package com.tencent.mobileqq.qbosssplash.common;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.impl.HttpEngineServiceImpl;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

final class QbossSplashDownloadManager$1
  extends AbsPreDownloadTask
{
  QbossSplashDownloadManager$1(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    super(paramQQAppInterface, paramString1);
  }
  
  public void realCancel()
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "ctrl realCancel");
  }
  
  public void realStart()
  {
    QLog.i("QSplash@QbossSplashUtil", 1, "downloadPicAGifAVideoRes adid" + this.jdField_a_of_type_JavaLangString);
    QbossSplashUtil.a(this.b + ".splashtemp");
    Object localObject = new HashMap();
    ((HashMap)localObject).put("qbossSplashresAppid", this.jdField_a_of_type_JavaLangString);
    QbossSplashDownloadManager.a("qbossSplashrequest", (HashMap)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("QSplash@QbossSplashDownloadManager", 2, "qboss_ad_res_png realStart, key  " + this.jdField_a_of_type_JavaLangString + "_" + this.b);
    }
    localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new QbossSplashDownloadManager.DownLoadNetEngine(this.app, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.b + ".splashtemp", this.c, this.d);
    ((HttpNetReq)localObject).mReqUrl = this.d;
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = (this.b + ".splashtemp");
    ((HttpEngineServiceImpl)this.app.getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qbosssplash.common.QbossSplashDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */