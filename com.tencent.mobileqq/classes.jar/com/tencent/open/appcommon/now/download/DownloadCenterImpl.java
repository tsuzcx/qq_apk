package com.tencent.open.appcommon.now.download;

import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.api.INowUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class DownloadCenterImpl
{
  private static DownloadCenterImpl jdField_a_of_type_ComTencentOpenAppcommonNowDownloadDownloadCenterImpl;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new DownloadCenterImpl.1(this);
  private DownloadListener jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener = new DownloadCenterImpl.2(this);
  private ArrayList<IDownloadCallback> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public DownloadCenterImpl()
  {
    DownloadManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener);
    AppNetConnInfo.registerNetChangeReceiver(CommonDataAdapter.a().a(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public static DownloadCenterImpl a()
  {
    if (jdField_a_of_type_ComTencentOpenAppcommonNowDownloadDownloadCenterImpl == null) {
      jdField_a_of_type_ComTencentOpenAppcommonNowDownloadDownloadCenterImpl = new DownloadCenterImpl();
    }
    return jdField_a_of_type_ComTencentOpenAppcommonNowDownloadDownloadCenterImpl;
  }
  
  public int a(DownloadInfo paramDownloadInfo)
  {
    boolean bool = AppUtil.a(paramDownloadInfo.e);
    int j = 1;
    int m = 1;
    int k = 0;
    int i;
    if (bool)
    {
      i = m;
      if (paramDownloadInfo.jdField_b_of_type_Int != 0)
      {
        i = m;
        if (paramDownloadInfo.jdField_b_of_type_Int > AppUtil.a("com.tencent.now")) {
          i = 0;
        }
      }
      paramDownloadInfo.a(13);
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((IDownloadCallback)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
      }
      return i;
    }
    DownloadInfo localDownloadInfo = DownloadManager.a().a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    if ("com.tencent.now".equals(paramDownloadInfo.e))
    {
      bool = ((INowUtil)QRoute.api(INowUtil.class)).checkNowApkExist(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
      if (localDownloadInfo == null)
      {
        i = k;
        if (!bool) {
          break label904;
        }
        i = AppUtil.b(((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath());
        if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i))
        {
          ((INowUtil)QRoute.api(INowUtil.class)).delete(((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath());
          i = 0;
        }
        else
        {
          localObject1 = new DownloadInfo(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_d_of_type_JavaLangString, paramDownloadInfo.e, paramDownloadInfo.f, paramDownloadInfo.h, null, paramDownloadInfo.m, paramDownloadInfo.jdField_c_of_type_Boolean);
          ((DownloadInfo)localObject1).a(4);
          ((DownloadInfo)localObject1).l = ((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath();
          ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = paramDownloadInfo.jdField_b_of_type_Boolean;
          DownloadManager.a().e((DownloadInfo)localObject1);
        }
      }
      for (i = j;; i = j)
      {
        break label904;
        localObject1 = localDownloadInfo.l;
        if ((!((INowUtil)QRoute.api(INowUtil.class)).isExists((String)localObject1)) && (!bool))
        {
          i = k;
          if (localDownloadInfo.a() != 4) {
            break label904;
          }
          DownloadManager.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
          i = k;
          break label904;
        }
        if (bool) {
          i = AppUtil.b(((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath());
        } else {
          i = AppUtil.b((String)localObject1);
        }
        if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i))
        {
          DownloadManager.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
          ((INowUtil)QRoute.api(INowUtil.class)).delete(((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath());
          ((INowUtil)QRoute.api(INowUtil.class)).delete((String)localObject1);
          break;
        }
        if (!bool)
        {
          if (((INowUtil)QRoute.api(INowUtil.class)).copyNowApkToCommonDir((String)localObject1, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
          {
            ((INowUtil)QRoute.api(INowUtil.class)).delete((String)localObject1);
            localDownloadInfo.l = ((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath();
          }
        }
        else if (!((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath().equals(localObject1))
        {
          ((INowUtil)QRoute.api(INowUtil.class)).delete((String)localObject1);
          localDownloadInfo.l = ((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath();
        }
        localDownloadInfo.a(4);
        DownloadManager.a().e(localDownloadInfo);
      }
    }
    else
    {
      i = k;
      if (localDownloadInfo != null)
      {
        Object localObject2 = "";
        if (TextUtils.isEmpty(localDownloadInfo.l))
        {
          i = localDownloadInfo.jdField_c_of_type_Int;
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
          if (i == 0)
          {
            localTMAssistantDownloadTaskInfo2 = DownloadManager.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
            localObject1 = localObject2;
            if (localTMAssistantDownloadTaskInfo2 != null)
            {
              localObject1 = localObject2;
              if (localTMAssistantDownloadTaskInfo2.mState == 4) {
                localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
              }
            }
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localTMAssistantDownloadTaskInfo1 = DownloadManager.a().a(localDownloadInfo);
              localObject2 = localObject1;
            }
          }
          else
          {
            localTMAssistantDownloadTaskInfo2 = DownloadManager.a().a(localDownloadInfo);
            localObject1 = localObject2;
            if (localTMAssistantDownloadTaskInfo2 != null)
            {
              localObject1 = localObject2;
              if (localTMAssistantDownloadTaskInfo2.mState == 4) {
                localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
              }
            }
            localObject2 = localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              localTMAssistantDownloadTaskInfo1 = DownloadManager.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
              localObject2 = localObject1;
            }
          }
          localObject1 = localObject2;
          if (localTMAssistantDownloadTaskInfo1 != null)
          {
            localObject1 = localObject2;
            if (localTMAssistantDownloadTaskInfo1.mState == 4) {
              localObject1 = localTMAssistantDownloadTaskInfo1.mSavePath;
            }
          }
          localObject2 = localObject1;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localDownloadInfo.l = ((String)localObject1);
            localDownloadInfo.a(4);
            DownloadManager.a().e(localDownloadInfo);
            localObject2 = localObject1;
          }
        }
        else
        {
          localObject2 = localDownloadInfo.l;
        }
        i = k;
        if (!StringUtil.a((String)localObject2))
        {
          i = k;
          if (((INowUtil)QRoute.api(INowUtil.class)).isExists((String)localObject2)) {
            i = 1;
          }
        }
      }
    }
    label904:
    paramDownloadInfo.a(13);
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((IDownloadCallback)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
    }
    return i;
  }
  
  public int a(ArrayList<DownloadInfo> paramArrayList)
  {
    if (paramArrayList == null)
    {
      LogUtility.a("DownloadCenterImpl", "getDownloadProgressById infos == null");
      return -1;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadCenterImpl.3(this, paramArrayList));
    return 0;
  }
  
  public DownloadInfo a(String paramString)
  {
    return DownloadManager.a().a(paramString);
  }
  
  public void a(IDownloadCallback paramIDownloadCallback)
  {
    if (paramIDownloadCallback != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localArrayList != null) && (!localArrayList.contains(paramIDownloadCallback))) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramIDownloadCallback);
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (((INowUtil)QRoute.api(INowUtil.class)).checkNowApkExist(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
    {
      paramDownloadInfo.a(4);
      paramDownloadInfo.l = ((INowUtil)QRoute.api(INowUtil.class)).getCommonNowPath();
      DownloadManager.a().e(paramDownloadInfo);
      this.jdField_a_of_type_ComTencentOpenDownloadnewDownloadListener.onDownloadFinish(paramDownloadInfo);
      return;
    }
    DownloadManager.a().a(paramDownloadInfo);
  }
  
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    DownloadManager.a().a(paramDownloadInfo, paramApkUpdateDetail);
  }
  
  public void a(String paramString)
  {
    DownloadManager.a().a(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    DownloadInfo localDownloadInfo = DownloadManager.a().a(paramString1);
    paramString1 = localDownloadInfo;
    if (localDownloadInfo == null) {
      paramString1 = DownloadManager.a().b(paramString2);
    }
    if (paramString1 != null)
    {
      paramString1.g = 5;
      paramString1.jdField_c_of_type_Int = 0;
      paramString1.jdField_d_of_type_Int = 0;
      DownloadManager.a().c(paramString1);
    }
  }
  
  public void b(IDownloadCallback paramIDownloadCallback)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList != null) {
      localArrayList.remove(paramIDownloadCallback);
    }
  }
  
  public void b(String paramString)
  {
    DownloadInfo localDownloadInfo = DownloadManager.a().a(paramString);
    DownloadManager.a().a(paramString, true);
    DownloadManager.a().a(10, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.DownloadCenterImpl
 * JD-Core Version:    0.7.0.1
 */