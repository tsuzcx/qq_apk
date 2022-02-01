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
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo == paramDownloadInfo) || (((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_model)) || (paramDownloadInfo.MD5_zip_model.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo.MD5_zip_model))) && ((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_so)) || (paramDownloadInfo.MD5_zip_so.equals(this.jdField_a_of_type_ComTencentMobileqqShortvideoGestureDownloadInfo.MD5_zip_so)))))) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavGesture", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(bool) }));
    }
    if (!bool) {
      return this.jdField_a_of_type_Boolean;
    }
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
    else if ((paramDownloadInfo.enable) && (!GestureUtil.c(paramDownloadInfo)))
    {
      str2 = paramDownloadInfo.url_zip_model;
      str1 = paramDownloadInfo.MD5_zip_model;
      i = 2;
    }
    else
    {
      if ((!GestureUtil.a(paramDownloadInfo)) || (GestureUtil.b(paramDownloadInfo))) {
        break label373;
      }
      str2 = paramDownloadInfo.url_zip_gamemodel;
      str1 = paramDownloadInfo.MD5_zip_gamemodel;
      i = 3;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(GestureUtil.b());
    ((StringBuilder)localObject).append(str1);
    String str3 = ((StringBuilder)localObject).toString();
    if (paramInt < 0)
    {
      QLog.d("QavGesture", 1, String.format("downloadRes, 下载死循环了. res_flag[%s], info[%s]", new Object[] { Integer.valueOf(i), paramDownloadInfo }));
      GestureMgrAppDownload.a(-3);
      return false;
    }
    localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new GestureMgrAppDownload.DownloadContrl.1(this, str1, paramDownloadInfo, i, paramInt);
    paramDownloadInfo = new StringBuilder();
    paramDownloadInfo.append(i);
    paramDownloadInfo.append("_");
    paramDownloadInfo.append(str1);
    ((HttpNetReq)localObject).setUserData(paramDownloadInfo.toString());
    ((HttpNetReq)localObject).mReqUrl = str2;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = new File(str3).getPath();
    ((HttpNetReq)localObject).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    paramDownloadInfo = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramDownloadInfo instanceof QQAppInterface))
    {
      paramDownloadInfo = (IHttpEngineService)((QQAppInterface)paramDownloadInfo).getRuntimeService(IHttpEngineService.class, "all");
      if (paramDownloadInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = ((HttpNetReq)localObject);
        paramDownloadInfo.sendReq(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
        bool = true;
        break label319;
      }
    }
    boolean bool = false;
    label319:
    if (!bool) {
      GestureMgrAppDownload.a(-2);
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("downloadRes, res_flag[%s], md5[%s], etr[%s]", new Object[] { Integer.valueOf(i), str1, Boolean.valueOf(bool) }));
    }
    return bool;
    label373:
    GestureMgrAppDownload.a(100);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload.DownloadContrl
 * JD-Core Version:    0.7.0.1
 */