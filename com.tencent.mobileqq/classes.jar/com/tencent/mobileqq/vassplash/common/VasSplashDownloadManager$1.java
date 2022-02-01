package com.tencent.mobileqq.vassplash.common;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;

final class VasSplashDownloadManager$1
  extends AbsPreDownloadTask
{
  VasSplashDownloadManager$1(BaseQQAppInterface paramBaseQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    super(paramBaseQQAppInterface, paramString1);
  }
  
  protected void realCancel()
  {
    QLog.i("QSplash@VasSplashUtil", 1, "ctrl realCancel");
  }
  
  protected void realStart()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("downloadPicAGifAVideoRes adid");
    ((StringBuilder)localObject1).append(this.a);
    QLog.i("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(".splashtemp");
    VasSplashUtil.f(((StringBuilder)localObject1).toString());
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("vas_ad_res_png realStart, key  ");
      ((StringBuilder)localObject1).append(this.a);
      ((StringBuilder)localObject1).append("_");
      ((StringBuilder)localObject1).append(this.b);
      QLog.i("splash.tag.QSplash@VasSplashDownloadManager", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new HttpNetReq();
    Object localObject2 = (QQAppInterface)this.app;
    String str = this.a;
    int i = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(".splashtemp");
    ((HttpNetReq)localObject1).mCallback = new VasSplashDownloadManager.DownLoadNetEngine((QQAppInterface)localObject2, str, i, localStringBuilder.toString(), this.d, this.e);
    ((HttpNetReq)localObject1).mReqUrl = this.e;
    ((HttpNetReq)localObject1).mHttpMethod = 0;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append(".splashtemp");
    ((HttpNetReq)localObject1).mOutPath = ((StringBuilder)localObject2).toString();
    ((HttpEngineServiceImpl)this.app.getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.common.VasSplashDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */