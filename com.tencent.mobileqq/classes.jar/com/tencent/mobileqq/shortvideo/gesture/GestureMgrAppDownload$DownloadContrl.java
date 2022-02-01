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
  boolean a = false;
  DownloadInfo b = null;
  int c = 0;
  int d = 0;
  int e = 0;
  HttpNetReq f;
  
  boolean a(DownloadInfo paramDownloadInfo)
  {
    boolean bool;
    if ((this.a) && ((this.b == paramDownloadInfo) || (((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_model)) || (paramDownloadInfo.MD5_zip_model.equals(this.b.MD5_zip_model))) && ((TextUtils.isEmpty(paramDownloadInfo.MD5_zip_so)) || (paramDownloadInfo.MD5_zip_so.equals(this.b.MD5_zip_so)))))) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QavGesture", 2, String.format("DownloadContrl, mDownloading[%s], reDownload[%s]", new Object[] { Boolean.valueOf(this.a), Boolean.valueOf(bool) }));
    }
    if (!bool) {
      return this.a;
    }
    if (this.f != null)
    {
      Object localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof AppInterface))
      {
        localObject = (IHttpEngineService)((AppInterface)localObject).getRuntimeService(IHttpEngineService.class, "all");
        if (localObject != null)
        {
          QLog.d("QavGesture", 2, String.format("DownloadContrl, cancelReq[%s]", new Object[] { (String)this.f.getUserData() }));
          ((IHttpEngineService)localObject).cancelReq(this.f);
        }
      }
    }
    this.b = paramDownloadInfo;
    this.e = 0;
    this.f = null;
    this.c = 0;
    this.d = 0;
    if (!GestureUtil.e(this.b))
    {
      this.e |= 0x1;
      this.c += 1;
    }
    if (!GestureUtil.d(this.b))
    {
      this.e |= 0x2;
      this.c += 1;
    }
    if ((GestureUtil.b(this.b)) && (!GestureUtil.c(this.b)))
    {
      this.e |= 0x3;
      this.c += 1;
    }
    QLog.d("QavGesture", 1, String.format("DownloadContrl, mResFlag[%s], mInfo[%s]", new Object[] { Integer.valueOf(this.e), this.b }));
    if (this.c == 0) {
      return this.a;
    }
    this.a = a(this.b, 3);
    return this.a;
  }
  
  boolean a(DownloadInfo paramDownloadInfo, int paramInt)
  {
    String str2;
    String str1;
    int i;
    if (!GestureUtil.e(paramDownloadInfo))
    {
      str2 = paramDownloadInfo.url_zip_so;
      str1 = paramDownloadInfo.MD5_zip_so;
      i = 1;
    }
    else if ((paramDownloadInfo.enable) && (!GestureUtil.d(paramDownloadInfo)))
    {
      str2 = paramDownloadInfo.url_zip_model;
      str1 = paramDownloadInfo.MD5_zip_model;
      i = 2;
    }
    else
    {
      if ((!GestureUtil.b(paramDownloadInfo)) || (GestureUtil.c(paramDownloadInfo))) {
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
        this.f = ((HttpNetReq)localObject);
        paramDownloadInfo.sendReq(this.f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.gesture.GestureMgrAppDownload.DownloadContrl
 * JD-Core Version:    0.7.0.1
 */