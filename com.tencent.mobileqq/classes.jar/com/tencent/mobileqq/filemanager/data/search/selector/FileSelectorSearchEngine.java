package com.tencent.mobileqq.filemanager.data.search.selector;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import aoze;
import apga;
import apgf;
import apgh;
import aptm;
import apty;
import awii;
import awij;
import awiv;
import awuu;
import awuv;
import awvi;
import awwa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileSelectorSearchEngine
  implements awiv, awuu<apga>
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
  
  private List<apga> b(awvi paramawvi)
  {
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramawvi.a);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      apgh localapgh = new apgh(paramawvi.a, this.jdField_a_of_type_Int);
      localObject = (List)localMap.get(localObject);
      localapgh.a(this.jdField_a_of_type_AndroidOsBundle);
      localapgh.a((List)localObject);
      if (localapgh.d() > 0) {
        localArrayList.add(localapgh);
      }
    }
    return localArrayList;
  }
  
  private List<apga> c(awvi paramawvi)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new HashMap();
    Object localObject1 = aptm.a().b();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      apty.a(true, (String)localObject1, "", ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject2, null);
    }
    if (a())
    {
      localObject1 = apty.a(this.jdField_a_of_type_AndroidContentContext, null);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        ((HashMap)localObject2).put("installedApk", localObject1);
      }
    }
    localObject1 = aptm.a().a();
    if (localObject1 != null) {
      apty.a(true, (String)localObject1, "", ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject2, null);
    }
    localObject1 = new HashMap();
    if ((localObject2 != null) && (!((HashMap)localObject2).isEmpty()))
    {
      Object localObject3 = new ArrayList();
      localObject2 = ((HashMap)localObject2).values().iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (List)((Iterator)localObject2).next();
        if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
          ((List)localObject3).addAll((Collection)localObject4);
        }
      }
      if (!((List)localObject3).isEmpty())
      {
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileInfo)((Iterator)localObject2).next();
          localObject4 = ((FileInfo)localObject3).d();
          if (((String)localObject4).indexOf(paramawvi.a) >= 0)
          {
            if (!((Map)localObject1).containsKey(localObject4)) {
              ((Map)localObject1).put(localObject4, new ArrayList());
            }
            ((List)((Map)localObject1).get(localObject4)).add(localObject3);
          }
          else if (awwa.b(paramawvi.a, (String)localObject4, awii.g) > -9223372036854775808L)
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
          localObject4 = new apgf(paramawvi.a, this.jdField_a_of_type_Int);
          ((apgf)localObject4).a((List)((Map)localObject1).get(localObject3));
          ((apgf)localObject4).a(this.jdField_a_of_type_AndroidOsBundle);
          localArrayList.add(localObject4);
        }
      }
    }
    return localArrayList;
  }
  
  private List<apga> d(awvi paramawvi)
  {
    return new ArrayList();
  }
  
  public List<apga> a(awvi paramawvi)
  {
    List localList = null;
    if (this.jdField_a_of_type_Int == 16) {
      localList = b(paramawvi);
    }
    for (;;)
    {
      paramawvi = localList;
      if (localList == null) {
        paramawvi = new ArrayList();
      }
      return paramawvi;
      if (this.jdField_a_of_type_Int == 17) {
        localList = c(paramawvi);
      } else if (this.jdField_a_of_type_Int == 18) {
        localList = d(paramawvi);
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt, List<? extends awij> paramList) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(awvi paramawvi, awuv<apga> paramawuv)
  {
    if ((paramawvi == null) || (paramawvi.a == null) || (TextUtils.isEmpty(paramawvi.a.trim()))) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Awvi = paramawvi;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Awuv = paramawuv;
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Awvi = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Awuv = null;
      ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable, 64);
      return;
    }
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchEngine
 * JD-Core Version:    0.7.0.1
 */