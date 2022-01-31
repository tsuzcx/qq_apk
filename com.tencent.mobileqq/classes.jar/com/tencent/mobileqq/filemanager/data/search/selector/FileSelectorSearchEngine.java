package com.tencent.mobileqq.filemanager.data.search.selector;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import aqwl;
import ardh;
import ardm;
import ardo;
import arqx;
import arrj;
import ayhr;
import ayhs;
import ayie;
import ayug;
import ayuh;
import ayuu;
import ayvm;
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
  implements ayie, ayug<ardh>
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
  
  private List<ardh> b(ayuu paramayuu)
  {
    Map localMap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramayuu.a);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      ardo localardo = new ardo(paramayuu.a, this.jdField_a_of_type_Int);
      localObject = (List)localMap.get(localObject);
      localardo.a(this.jdField_a_of_type_AndroidOsBundle);
      localardo.a((List)localObject);
      if (localardo.d() > 0) {
        localArrayList.add(localardo);
      }
    }
    return localArrayList;
  }
  
  private List<ardh> c(ayuu paramayuu)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new HashMap();
    Object localObject1 = arqx.a().b();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      arrj.a(true, (String)localObject1, "", ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject2, null);
    }
    if (a())
    {
      localObject1 = arrj.a(this.jdField_a_of_type_AndroidContentContext, null);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        ((HashMap)localObject2).put("installedApk", localObject1);
      }
    }
    localObject1 = arqx.a().a();
    if (localObject1 != null) {
      arrj.a(true, (String)localObject1, "", ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject2, null);
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
          if (((String)localObject4).indexOf(paramayuu.a) >= 0)
          {
            if (!((Map)localObject1).containsKey(localObject4)) {
              ((Map)localObject1).put(localObject4, new ArrayList());
            }
            ((List)((Map)localObject1).get(localObject4)).add(localObject3);
          }
          else if (ayvm.b(paramayuu.a, (String)localObject4, ayhr.g) > -9223372036854775808L)
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
          localObject4 = new ardm(paramayuu.a, this.jdField_a_of_type_Int);
          ((ardm)localObject4).a((List)((Map)localObject1).get(localObject3));
          ((ardm)localObject4).a(this.jdField_a_of_type_AndroidOsBundle);
          localArrayList.add(localObject4);
        }
      }
    }
    return localArrayList;
  }
  
  private List<ardh> d(ayuu paramayuu)
  {
    return new ArrayList();
  }
  
  public List<ardh> a(ayuu paramayuu)
  {
    List localList = null;
    if (this.jdField_a_of_type_Int == 16) {
      localList = b(paramayuu);
    }
    for (;;)
    {
      paramayuu = localList;
      if (localList == null) {
        paramayuu = new ArrayList();
      }
      return paramayuu;
      if (this.jdField_a_of_type_Int == 17) {
        localList = c(paramayuu);
      } else if (this.jdField_a_of_type_Int == 18) {
        localList = d(paramayuu);
      }
    }
  }
  
  public void a() {}
  
  public void a(int paramInt, List<? extends ayhs> paramList) {}
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public void a(ayuu paramayuu, ayuh<ardh> paramayuh)
  {
    if ((paramayuu == null) || (paramayuu.a == null) || (TextUtils.isEmpty(paramayuu.a.trim()))) {
      return;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Ayuu = paramayuu;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Ayuh = paramayuh;
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
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Ayuu = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataSearchSelectorFileSelectorSearchEngine$SearchRunnable.jdField_a_of_type_Ayuh = null;
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