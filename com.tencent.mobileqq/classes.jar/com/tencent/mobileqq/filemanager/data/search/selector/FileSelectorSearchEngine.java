package com.tencent.mobileqq.filemanager.data.search.selector;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import asgz;
import asmv;
import asna;
import asnc;
import asyy;
import aszl;
import basn;
import baso;
import bata;
import bbfe;
import bbff;
import bbfs;
import bbgk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileSelectorSearchEngine
  implements bata, bbfe<asmv>
{
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileSelectorSearchEngine.SearchRunnable jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable = new FileSelectorSearchEngine.SearchRunnable(this, null);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public FileSelectorSearchEngine(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private List<asmv> b(bbfs parambbfs)
  {
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(parambbfs.a);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      asnc localasnc = new asnc(parambbfs.a, this.jdField_a_of_type_Int);
      localObject = (List)localMap.get(localObject);
      localasnc.a(this.jdField_a_of_type_AndroidOsBundle);
      localasnc.a((List)localObject);
      if (localasnc.d() > 0) {
        localArrayList.add(localasnc);
      }
    }
    return localArrayList;
  }
  
  private List<asmv> c(bbfs parambbfs)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject3 = new HashMap();
    Object localObject2 = ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.jpg|.bmp|.jpeg|.gif|.png|.ico|";
    Object localObject1 = "";
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("file_choose_extension_handle_type", -1);
    if (i == 1)
    {
      localObject1 = this.jdField_a_of_type_AndroidOsBundle.getString("file_choose_extension_in_filter");
      localObject2 = this.jdField_a_of_type_AndroidOsBundle.getString("file_choose_extension_out_filter");
      if ((((String)localObject1).equals("")) || (((String)localObject1).contains(".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|")))
      {
        localObject4 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() + "/" + "QQ" + "/";
        if (localObject4 != null) {
          aszl.a(true, (String)localObject4, ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", (HashMap)localObject3, null);
        }
      }
    }
    Object localObject4 = asyy.a().b();
    if (!TextUtils.isEmpty((CharSequence)localObject4)) {
      aszl.a(true, (String)localObject4, (String)localObject1, (String)localObject2, (HashMap)localObject3, null);
    }
    if ((i == -1) && (a()))
    {
      localObject4 = aszl.a(this.jdField_a_of_type_AndroidContentContext, null);
      if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
        ((HashMap)localObject3).put("installedApk", localObject4);
      }
    }
    localObject4 = asyy.a().a();
    if (localObject4 != null) {
      aszl.a(true, (String)localObject4, (String)localObject1, (String)localObject2, (HashMap)localObject3, null);
    }
    localObject1 = new HashMap();
    if ((localObject3 != null) && (!((HashMap)localObject3).isEmpty()))
    {
      localObject2 = new ArrayList();
      localObject3 = ((HashMap)localObject3).values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (List)((Iterator)localObject3).next();
        if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
          ((List)localObject2).addAll((Collection)localObject4);
        }
      }
      if (!((List)localObject2).isEmpty())
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileInfo)((Iterator)localObject2).next();
          localObject4 = ((FileInfo)localObject3).d();
          if (((String)localObject4).indexOf(parambbfs.a) >= 0)
          {
            if (!((Map)localObject1).containsKey(localObject4)) {
              ((Map)localObject1).put(localObject4, new ArrayList());
            }
            ((List)((Map)localObject1).get(localObject4)).add(localObject3);
          }
          else if (bbgk.b(parambbfs.a, (String)localObject4, basn.g) > -9223372036854775808L)
          {
            if (!((Map)localObject1).containsKey(localObject4)) {
              ((Map)localObject1).put(localObject4, new ArrayList());
            }
            ((List)((Map)localObject1).get(localObject4)).add(localObject3);
          }
        }
      }
      if (!((Map)localObject1).isEmpty())
      {
        localObject2 = ((Map)localObject1).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = new asna(parambbfs.a, this.jdField_a_of_type_Int);
          ((asna)localObject4).a((List)((Map)localObject1).get(localObject3));
          ((asna)localObject4).a(this.jdField_a_of_type_AndroidOsBundle);
          localArrayList.add(localObject4);
        }
      }
    }
    return localArrayList;
  }
  
  private List<asmv> d(bbfs parambbfs)
  {
    return new ArrayList();
  }
  
  public List<asmv> a(bbfs parambbfs)
  {
    List localList = null;
    if (this.jdField_a_of_type_Int == 16) {
      localList = b(parambbfs);
    }
    for (;;)
    {
      parambbfs = localList;
      if (localList == null) {
        parambbfs = new ArrayList();
      }
      return parambbfs;
      if (this.jdField_a_of_type_Int == 17) {
        localList = c(parambbfs);
      } else if (this.jdField_a_of_type_Int == 18) {
        localList = d(parambbfs);
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt, List<? extends baso> paramList) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(bbfs parambbfs, bbff<asmv> parambbff)
  {
    if ((parambbfs == null) || (parambbfs.a == null) || (TextUtils.isEmpty(parambbfs.a.trim()))) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Bbfs = parambbfs;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Bbff = parambbff;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable, 64);
      ThreadManager.executeOnFileThread(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable);
      return;
    }
  }
  
  protected boolean a()
  {
    if (this.b) {
      return this.jdField_a_of_type_Boolean;
    }
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("qfile_permission", 0).getBoolean("qfile_permission_access_apps", false);
    this.b = true;
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Bbfs = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Bbff = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable, 64);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchEngine
 * JD-Core Version:    0.7.0.1
 */