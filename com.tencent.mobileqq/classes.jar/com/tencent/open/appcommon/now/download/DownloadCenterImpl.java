package com.tencent.open.appcommon.now.download;

import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.NowUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
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
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    int i = 1;
    int j = 0;
    Object localObject1;
    if (AppUtil.a(paramDownloadInfo.e))
    {
      if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > AppUtil.a("com.tencent.now"))) {}
      for (i = 0;; i = 1)
      {
        paramDownloadInfo.a(13);
        localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        for (;;)
        {
          j = i;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          ((IDownloadCallback)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
        }
      }
    }
    DownloadInfo localDownloadInfo = DownloadManager.a().a(paramDownloadInfo.jdField_c_of_type_JavaLangString);
    boolean bool;
    if ("com.tencent.now".equals(paramDownloadInfo.e))
    {
      bool = NowUtil.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e);
      if (localDownloadInfo == null)
      {
        i = j;
        if (bool)
        {
          i = AppUtil.b(NowUtil.b());
          if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i)) {
            break label277;
          }
          localObject1 = new DownloadInfo(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.jdField_d_of_type_JavaLangString, paramDownloadInfo.e, paramDownloadInfo.f, paramDownloadInfo.h, null, paramDownloadInfo.m, paramDownloadInfo.jdField_c_of_type_Boolean);
          ((DownloadInfo)localObject1).a(4);
          ((DownloadInfo)localObject1).l = NowUtil.b();
          ((DownloadInfo)localObject1).jdField_b_of_type_Boolean = paramDownloadInfo.jdField_b_of_type_Boolean;
          DownloadManager.a().e((DownloadInfo)localObject1);
          i = 1;
        }
      }
    }
    for (;;)
    {
      paramDownloadInfo.a(13);
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((IDownloadCallback)((Iterator)localObject1).next()).a(paramDownloadInfo, i);
      }
      label277:
      NowUtil.a(NowUtil.b());
      i = j;
      continue;
      localObject1 = localDownloadInfo.l;
      if ((NowUtil.b((String)localObject1)) || (bool))
      {
        if (bool)
        {
          i = AppUtil.b(NowUtil.b());
          label321:
          if ((paramDownloadInfo.jdField_b_of_type_Int != 0) && (paramDownloadInfo.jdField_b_of_type_Int > i)) {
            break label427;
          }
          if (bool) {
            break label399;
          }
          if (NowUtil.a((String)localObject1, paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
          {
            NowUtil.a((String)localObject1);
            localDownloadInfo.l = NowUtil.b();
          }
        }
        for (;;)
        {
          localDownloadInfo.a(4);
          DownloadManager.a().e(localDownloadInfo);
          i = 1;
          break;
          i = AppUtil.b((String)localObject1);
          break label321;
          label399:
          if (!NowUtil.b().equals(localObject1))
          {
            NowUtil.a((String)localObject1);
            localDownloadInfo.l = NowUtil.b();
          }
        }
        label427:
        DownloadManager.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
        NowUtil.a(NowUtil.b());
        NowUtil.a((String)localObject1);
        i = j;
      }
      else
      {
        i = j;
        if (localDownloadInfo.a() == 4)
        {
          DownloadManager.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString, true);
          i = j;
          continue;
          if (localDownloadInfo != null)
          {
            Object localObject2 = "";
            TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
            if (TextUtils.isEmpty(localDownloadInfo.l)) {
              if (localDownloadInfo.jdField_c_of_type_Int == 0)
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
                label581:
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
                }
              }
            }
            for (localObject2 = localObject1;; localObject2 = localDownloadInfo.l)
            {
              if ((!StringUtil.a((String)localObject2)) && (NowUtil.b((String)localObject2))) {
                break label747;
              }
              i = 0;
              break;
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
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                break label581;
              }
              localTMAssistantDownloadTaskInfo1 = DownloadManager.a().a(localDownloadInfo.jdField_d_of_type_JavaLangString);
              localObject2 = localObject1;
              break label581;
            }
          }
          else
          {
            label747:
            i = 0;
          }
        }
      }
    }
    j = i;
    return j;
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
    if ((paramIDownloadCallback != null) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramIDownloadCallback))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramIDownloadCallback);
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo)
  {
    if (NowUtil.a(paramDownloadInfo.jdField_c_of_type_JavaLangString, paramDownloadInfo.e))
    {
      paramDownloadInfo.a(4);
      paramDownloadInfo.l = NowUtil.b();
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
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramIDownloadCallback);
    }
  }
  
  public void b(String paramString)
  {
    DownloadInfo localDownloadInfo = DownloadManager.a().a(paramString);
    DownloadManager.a().a(paramString, true);
    DownloadManager.a().a(10, localDownloadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.DownloadCenterImpl
 * JD-Core Version:    0.7.0.1
 */