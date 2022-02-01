package com.tencent.mobileqq.shortvideo.gesture;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class GestureMgrAppDownload$DownloadContrl
{
  int jdField_a_of_type_Int = 0;
  DownloadInfo jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = null;
  HttpNetReq jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
  boolean jdField_a_of_type_Boolean = false;
  int b = 0;
  int c = 0;
  
  boolean a(DownloadInfo paramDownloadInfo)
  {
    boolean bool;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == paramDownloadInfo) || (((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_model)) || (paramDownloadInfo.MD5_zip_model.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo.MD5_zip_model))) && ((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_so)) || (paramDownloadInfo.MD5_zip_so.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo.MD5_zip_so))))) {
        break label388;
      }
      bool = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QavGesture", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
      }
      if (!bool)
      {
        return this.jdField_a_of_type_Boolean;
        bool = true;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null)
        {
          Object localObject = BaseApplicationImpl.sApplication.getRuntime();
          if ((localObject instanceof AppInterface))
          {
            localObject = (IHttpEngineService)((AppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all");
            if (localObject != null)
            {
              QLog.d("QavGesture", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.getUserData() }));
              ((IHttpEngineService)localObject).cancelReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo = paramDownloadInfo;
        this.c = 0;
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
        this.jdField_a_of_type_Int = 0;
        this.b = 0;
        if (!GestureUtil.d(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo))
        {
          this.c |= 0x1;
          this.jdField_a_of_type_Int += 1;
        }
        if (!GestureUtil.c(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo))
        {
          this.c |= 0x2;
          this.jdField_a_of_type_Int += 1;
        }
        if ((GestureUtil.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo)) && (!GestureUtil.b(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo)))
        {
          this.c |= 0x3;
          this.jdField_a_of_type_Int += 1;
        }
        QLog.d("QavGesture", 1, String.format("DownloadContrl, mResFlag[%s], mInfo[%s]", new Object[] { Integer.valueOf(this.c), this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo }));
        if (this.jdField_a_of_type_Int == 0) {
          return this.jdField_a_of_type_Boolean;
        }
        this.jdField_a_of_type_Boolean = a(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo, 3);
        return this.jdField_a_of_type_Boolean;
        label388:
        bool = false;
      }
    }
  }
  
  boolean a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    String str2;
    String str1;
    int i;
    if (!GestureUtil.d(paramDownloadInfo))
    {
      str2 = paramDownloadInfo.url_zip_so;
      str1 = paramDownloadInfo.MD5_zip_so;
      i = 1;
    }
    String str3;
    boolean bool2;
    for (;;)
    {
      str3 = GestureUtil.b() + str1;
      if (paramInt >= 0) {
        break label154;
      }
      QLog.d("QavGesture", 1, String.format("downloadRes, 下载死循环了. res_flag[%s], info[%s]", new Object[] { Integer.valueOf(i), paramDownloadInfo }));
      GestureMgrAppDownload.a(-3);
      bool2 = false;
      return bool2;
      if ((paramDownloadInfo.enable) && (!GestureUtil.c(paramDownloadInfo)))
      {
        str2 = paramDownloadInfo.url_zip_model;
        str1 = paramDownloadInfo.MD5_zip_model;
        i = 2;
      }
      else
      {
        if ((!GestureUtil.a(paramDownloadInfo)) || (GestureUtil.b(paramDownloadInfo))) {
          break;
        }
        str2 = paramDownloadInfo.url_zip_gamemodel;
        str1 = paramDownloadInfo.MD5_zip_gamemodel;
        i = 3;
      }
    }
    GestureMgrAppDownload.a(100);
    return false;
    label154:
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mCallback = new GestureMgrAppDownload.DownloadContrl.1(this, str1, paramDownloadInfo, i, paramInt);
    localHttpNetReq.setUserData(i + "_" + str1);
    localHttpNetReq.mReqUrl = str2;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = new File(str3).getPath();
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
    paramDownloadInfo = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramDownloadInfo instanceof QQAppInterface))
    {
      paramDownloadInfo = (IHttpEngineService)((QQAppInterface)paramDownloadInfo).getRuntimeService(IHttpEngineService.class, "all");
      if (paramDownloadInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = localHttpNetReq;
        paramDownloadInfo.sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
      }
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        GestureMgrAppDownload.a(-2);
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QavGesture", 2, String.format("downloadRes, res_flag[%s], md5[%s], etr[%s]", new Object[] { Integer.valueOf(i), str1, Boolean.valueOf(bool1) }));
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload.DownloadContrl
 * JD-Core Version:    0.7.0.1
 */