package com.tencent.mobileqq.minigame.splash;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

final class SplashMiniGameDownloadManager$1
  extends AbsPreDownloadTask
{
  SplashMiniGameDownloadManager$1(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    super(paramBaseQQAppInterface, paramString1);
  }
  
  protected void realCancel()
  {
    QLog.i("SplashMiniGameDownloadMgr", 1, "ctrl realCancel");
  }
  
  protected void realStart()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("downloadPicAGifAVideoRes appid");
    ((StringBuilder)localObject).append(this.val$appid);
    QLog.i("SplashMiniGameDownloadMgr", 1, ((StringBuilder)localObject).toString());
    localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new SplashMiniGameDownloadManager.DownLoadNetEngine((QQAppInterface)this.app, this.val$appid, this.val$contentType, this.val$path, this.val$downloadUrl);
    ((HttpNetReq)localObject).mReqUrl = this.val$downloadUrl;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = this.val$path;
    ((HttpEngineServiceImpl)this.app.getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.splash.SplashMiniGameDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */