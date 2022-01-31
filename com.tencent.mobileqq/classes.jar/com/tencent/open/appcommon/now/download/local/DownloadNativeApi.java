package com.tencent.open.appcommon.now.download.local;

import alfa;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.open.appcommon.Common;
import com.tencent.open.appcommon.now.download.DownloadCenterImpl;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DownloadNativeApi
{
  private static DownloadNativeApi jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadNativeApi;
  private DownloadCallbackNativeImpl jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadCallbackNativeImpl = new DownloadCallbackNativeImpl();
  
  public static DownloadNativeApi a()
  {
    if (jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadNativeApi == null) {
      jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadNativeApi = new DownloadNativeApi();
    }
    return jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadNativeApi;
  }
  
  private DownloadInfo a(DownloadTaskInfo paramDownloadTaskInfo)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo(paramDownloadTaskInfo.jdField_a_of_type_JavaLangString, paramDownloadTaskInfo.jdField_b_of_type_JavaLangString);
    localDownloadInfo.jdField_c_of_type_JavaLangString = paramDownloadTaskInfo.jdField_d_of_type_JavaLangString;
    localDownloadInfo.jdField_b_of_type_Int = paramDownloadTaskInfo.jdField_a_of_type_Int;
    localDownloadInfo.jdField_b_of_type_Boolean = paramDownloadTaskInfo.jdField_d_of_type_Boolean;
    localDownloadInfo.jdField_a_of_type_Boolean = paramDownloadTaskInfo.e;
    localDownloadInfo.e = paramDownloadTaskInfo.jdField_c_of_type_JavaLangString;
    localDownloadInfo.jdField_a_of_type_Int = paramDownloadTaskInfo.jdField_c_of_type_Int;
    localDownloadInfo.jdField_c_of_type_Int = paramDownloadTaskInfo.jdField_b_of_type_Int;
    localDownloadInfo.d = 0;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    return localDownloadInfo;
  }
  
  private boolean a()
  {
    return "com.tencent.mobileqq:tool".equals(Common.r());
  }
  
  public int a(Activity paramActivity, DownloadTaskInfo paramDownloadTaskInfo)
  {
    if (!a()) {
      return 401;
    }
    if (paramDownloadTaskInfo == null) {
      return 400;
    }
    if ((paramDownloadTaskInfo.jdField_a_of_type_Boolean) && (!"com.tencent.now".equals(paramDownloadTaskInfo.jdField_c_of_type_JavaLangString))) {
      return 402;
    }
    DownloadInfo localDownloadInfo = a(paramDownloadTaskInfo);
    localDownloadInfo.h = 2;
    localDownloadInfo.jdField_c_of_type_Boolean = true;
    if ((HttpUtil.a() != 1) && (paramActivity != null) && (paramDownloadTaskInfo.f)) {
      a(paramActivity, localDownloadInfo, paramDownloadTaskInfo);
    }
    for (;;)
    {
      return 200;
      DownloadCenterImpl.a().a(localDownloadInfo);
      this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadCallbackNativeImpl.a(paramDownloadTaskInfo);
    }
  }
  
  public int a(DownloadTaskInfo paramDownloadTaskInfo)
  {
    int j = -1;
    int i;
    if (!a()) {
      i = 401;
    }
    int k;
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramDownloadTaskInfo == null);
      paramDownloadTaskInfo = a(paramDownloadTaskInfo);
      paramDownloadTaskInfo.h = 13;
      paramDownloadTaskInfo.jdField_c_of_type_Int = 0;
      k = DownloadCenterImpl.a().a(paramDownloadTaskInfo);
      if (k == 1) {
        return 1;
      }
      i = j;
    } while (k != 0);
    return 0;
  }
  
  public int a(String paramString)
  {
    if (!a()) {
      return 401;
    }
    this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadCallbackNativeImpl.a(paramString);
    DownloadCenterImpl.a().a(paramString);
    return 200;
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a()) {
      return 401;
    }
    DownloadCenterImpl.a().a(paramString1, paramString2);
    return 200;
  }
  
  public int a(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return 400;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = a((DownloadTaskInfo)paramList.next());
      localDownloadInfo.jdField_c_of_type_Int = 0;
      localArrayList.add(localDownloadInfo);
    }
    if (DownloadCenterImpl.a().a(localArrayList) != 0) {
      return 400;
    }
    return 200;
  }
  
  public void a(Activity paramActivity, DownloadInfo paramDownloadInfo, DownloadTaskInfo paramDownloadTaskInfo)
  {
    new Handler(Looper.getMainLooper()).post(new alfa(this, paramDownloadInfo, paramDownloadTaskInfo, paramActivity));
  }
  
  public void a(DownloadNativeApi.IDownloadObserver paramIDownloadObserver)
  {
    this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadCallbackNativeImpl.a(paramIDownloadObserver);
    DownloadCenterImpl.a().a(this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadCallbackNativeImpl);
  }
  
  public boolean a(String paramString)
  {
    return AppUtil.a(paramString);
  }
  
  public void b(DownloadNativeApi.IDownloadObserver paramIDownloadObserver)
  {
    this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadCallbackNativeImpl.a();
    this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadCallbackNativeImpl.b(paramIDownloadObserver);
    DownloadCenterImpl.a().b(this.jdField_a_of_type_ComTencentOpenAppcommonNowDownloadLocalDownloadCallbackNativeImpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.local.DownloadNativeApi
 * JD-Core Version:    0.7.0.1
 */