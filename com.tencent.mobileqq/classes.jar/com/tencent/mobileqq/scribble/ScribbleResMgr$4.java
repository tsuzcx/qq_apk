package com.tencent.mobileqq.scribble;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class ScribbleResMgr$4
  implements Runnable
{
  ScribbleResMgr$4(ScribbleResMgr paramScribbleResMgr, ResInfo paramResInfo) {}
  
  public void run()
  {
    Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject2 = ScribbleResMgr.b(this.a.jdField_a_of_type_Int, this.a.b);
    if (FileUtils.fileExists((String)localObject2))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("res exist, return:");
        localStringBuilder.append(this.a.b);
        localStringBuilder.append(" ");
        localStringBuilder.append(this.a.jdField_a_of_type_Int);
        localStringBuilder.append(" file:");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(" url:");
        localStringBuilder.append(this.a.jdField_a_of_type_JavaLangString);
        QLog.d("ScribbleResMgr", 2, localStringBuilder.toString());
      }
      localObject1 = (IPreDownloadController)((QQAppInterface)localObject1).getRuntimeService(IPreDownloadController.class);
      if (((IPreDownloadController)localObject1).isEnable()) {
        ((IPreDownloadController)localObject1).preDownloadSuccess(this.a.jdField_a_of_type_JavaLangString, FileUtils.getFileOrFolderSize((String)localObject2));
      }
      ScribbleResMgr.a(this.this$0, this.a, 1);
      return;
    }
    ScribbleResMgr.b(this.this$0, this.a.jdField_a_of_type_Int, this.a.b, true);
    localObject2 = new HttpNetReq();
    ((HttpNetReq)localObject2).mCallback = new ScribbleResMgr.4.1(this);
    ((HttpNetReq)localObject2).mReqUrl = this.a.jdField_a_of_type_JavaLangString;
    ((HttpNetReq)localObject2).mHttpMethod = 0;
    if (this.a.jdField_a_of_type_Int == 1) {
      ((HttpNetReq)localObject2).mOutPath = ScribbleResMgr.b(this.a.jdField_a_of_type_Int, this.a.b);
    }
    if (this.a.jdField_a_of_type_Int == 2) {
      ((HttpNetReq)localObject2).mOutPath = ScribbleResMgr.a(this.a.b);
    }
    ScribbleResMgr.a(this.this$0, ((HttpNetReq)localObject2).mOutPath);
    ((HttpNetReq)localObject2).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((IHttpEngineService)((QQAppInterface)localObject1).getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject2);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("starthttpDownloadscribbleRes, url: ");
      ((StringBuilder)localObject1).append(this.a.jdField_a_of_type_JavaLangString);
      QLog.i("ScribbleResMgrdownloading", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.ScribbleResMgr.4
 * JD-Core Version:    0.7.0.1
 */