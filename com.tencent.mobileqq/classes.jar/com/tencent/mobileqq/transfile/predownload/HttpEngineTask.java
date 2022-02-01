package com.tencent.mobileqq.transfile.predownload;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.qphone.base.util.QLog;

public class HttpEngineTask
  extends AbsPreDownloadTask
  implements INetEngineListener
{
  public HttpNetReq httpReq;
  private HttpEngineTask.IHttpEngineTask mCallback;
  
  public HttpEngineTask(QQAppInterface paramQQAppInterface, String paramString, HttpEngineTask.IHttpEngineTask paramIHttpEngineTask, HttpNetReq paramHttpNetReq)
  {
    super(paramQQAppInterface, paramString);
    this.httpReq = paramHttpNetReq;
    this.mCallback = paramIHttpEngineTask;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    this.mCallback.onResp(paramNetResp);
    this.ctrl.onTaskEnd(this);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.mCallback.onUpdateProgeress(paramNetReq, paramLong1, paramLong2);
  }
  
  protected void realCancel()
  {
    ((IHttpEngineService)this.app.getRuntimeService(IHttpEngineService.class, "all")).cancelReq(this.httpReq);
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Task", 2, "start: " + this);
    }
    ((IHttpEngineService)this.app.getRuntimeService(IHttpEngineService.class, "all")).sendReq(this.httpReq);
    this.httpReq.mCallback = this;
    this.mCallback.onPreDownloadStart(this);
  }
  
  public String toString()
  {
    return super.toString() + "[" + this.httpReq.mReqUrl + ", " + this.mCallback + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.HttpEngineTask
 * JD-Core Version:    0.7.0.1
 */