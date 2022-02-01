package com.tencent.mobileqq.scribble;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class ScribbleResMgr$4
  implements Runnable
{
  ScribbleResMgr$4(ScribbleResMgr paramScribbleResMgr, ScribbleResMgr.ResInfo paramResInfo) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ScribbleResMgr.b(this.a.resType, this.a.sourceId);
    if (FileUtils.a((String)localObject2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScribbleResMgr", 2, "res exist, return:" + this.a.sourceId + " " + this.a.resType + " file:" + (String)localObject2 + " url:" + this.a.sourceUrl);
      }
      localObject1 = (PreDownloadController)((QQAppInterface)localObject1).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
      if (((PreDownloadController)localObject1).isEnable()) {
        ((PreDownloadController)localObject1).preDownloadSuccess(this.a.sourceUrl, FileUtils.b((String)localObject2));
      }
      ScribbleResMgr.a(this.this$0, this.a, 1);
    }
    do
    {
      return;
      ScribbleResMgr.b(this.this$0, this.a.resType, this.a.sourceId, true);
      localObject2 = new HttpNetReq();
      ((HttpNetReq)localObject2).mCallback = new ScribbleResMgr.4.1(this);
      ((HttpNetReq)localObject2).mReqUrl = this.a.sourceUrl;
      ((HttpNetReq)localObject2).mHttpMethod = 0;
      if (this.a.resType == 1) {
        ((HttpNetReq)localObject2).mOutPath = ScribbleResMgr.b(this.a.resType, this.a.sourceId);
      }
      if (this.a.resType == 2) {
        ((HttpNetReq)localObject2).mOutPath = ScribbleResMgr.a(this.a.sourceId);
      }
      ScribbleResMgr.a(this.this$0, ((HttpNetReq)localObject2).mOutPath);
      ((HttpNetReq)localObject2).mContinuErrorLimit = NetworkUtil.a(NetworkCenter.getInstance().getNetType());
      ((IHttpEngineService)((QQAppInterface)localObject1).getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject2);
    } while (!QLog.isColorLevel());
    QLog.i("ScribbleResMgrdownloading", 2, "starthttpDownloadscribbleRes, url: " + this.a.sourceUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.4
 * JD-Core Version:    0.7.0.1
 */