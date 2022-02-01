package com.tencent.open.appcommon.now.download.local;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.appcommon.now.download.IDownloadCallback;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class DownloadCallbackNativeImpl
  implements IDownloadCallback
{
  private ArrayList<DownloadNativeApi.IDownloadObserver> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, DownloadTaskInfo> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public void a()
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if (localMap != null) {
      localMap.clear();
    }
  }
  
  public void a(int paramInt)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadCallbackNativeImpl.1(this, paramInt), 3000L);
  }
  
  public void a(DownloadNativeApi.IDownloadObserver paramIDownloadObserver)
  {
    if (paramIDownloadObserver != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (!localArrayList.contains(paramIDownloadObserver))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramIDownloadObserver);
      }
    }
  }
  
  public void a(DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
    }
    if (paramDownloadTaskInfo != null)
    {
      if (TextUtils.isEmpty(paramDownloadTaskInfo.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramDownloadTaskInfo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilMap.put(paramDownloadTaskInfo.jdField_a_of_type_JavaLangString, paramDownloadTaskInfo);
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt) {}
  
  public void a(String paramString)
  {
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    if ((localMap != null) && (localMap.containsKey(paramString))) {
      ((DownloadTaskInfo)this.jdField_a_of_type_JavaUtilMap.get(paramString)).c = true;
    }
  }
  
  public void a(List<DownloadInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DownloadInfo)paramList.next();
      if (localObject != null)
      {
        DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
        localDownloadStateInfo.a((DownloadInfo)localObject);
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((DownloadNativeApi.IDownloadObserver)((Iterator)localObject).next()).d(localDownloadStateInfo);
        }
      }
    }
  }
  
  public void b(DownloadNativeApi.IDownloadObserver paramIDownloadObserver)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.remove(paramIDownloadObserver);
    }
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.jdField_a_of_type_JavaLangString = paramString1;
      localDownloadStateInfo.b = paramString2;
      localDownloadStateInfo.jdField_a_of_type_Int = 7;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramString1.next()).a(localDownloadStateInfo);
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramDownloadInfo.next()).a(localDownloadStateInfo);
      }
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a(paramDownloadInfo);
      localDownloadStateInfo.jdField_a_of_type_Int = localDownloadStateInfo.a(paramDownloadInfo.a());
      localDownloadStateInfo.jdField_c_of_type_Int = localDownloadStateInfo.b(paramInt1);
      localDownloadStateInfo.jdField_c_of_type_JavaLangString = paramString;
      paramString = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramString.next()).b(localDownloadStateInfo);
      }
      if (localDownloadStateInfo.jdField_c_of_type_Int == 201)
      {
        paramString = (DownloadTaskInfo)this.jdField_a_of_type_JavaUtilMap.get(localDownloadStateInfo.jdField_a_of_type_JavaLangString);
        if ((paramString != null) && (!paramString.b)) {
          DownloadCenterImpl.a().a(paramDownloadInfo);
        }
      }
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a(paramDownloadInfo);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)localIterator.next()).a(localDownloadStateInfo);
      }
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramDownloadInfo.jdField_c_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilMap.remove(paramDownloadInfo.jdField_c_of_type_JavaLangString);
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramDownloadInfo.next()).a(localDownloadStateInfo);
      }
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (DownloadInfo)paramList.next();
      if (localObject != null)
      {
        DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
        localDownloadStateInfo.a((DownloadInfo)localObject);
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((DownloadNativeApi.IDownloadObserver)((Iterator)localObject).next()).c(localDownloadStateInfo);
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramDownloadInfo != null))
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.a(paramDownloadInfo);
      paramDownloadInfo = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramDownloadInfo.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramDownloadInfo.next()).a(localDownloadStateInfo);
      }
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.jdField_a_of_type_JavaLangString = paramString1;
      localDownloadStateInfo.b = paramString2;
      localDownloadStateInfo.jdField_a_of_type_Int = 9;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramString1.next()).a(localDownloadStateInfo);
      }
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      DownloadStateInfo localDownloadStateInfo = new DownloadStateInfo();
      localDownloadStateInfo.jdField_a_of_type_JavaLangString = paramString1;
      localDownloadStateInfo.b = paramString2;
      localDownloadStateInfo.jdField_a_of_type_Int = 8;
      paramString1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramString1.hasNext()) {
        ((DownloadNativeApi.IDownloadObserver)paramString1.next()).a(localDownloadStateInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadCallbackNativeImpl
 * JD-Core Version:    0.7.0.1
 */