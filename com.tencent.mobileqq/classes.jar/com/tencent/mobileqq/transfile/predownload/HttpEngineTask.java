package com.tencent.mobileqq.transfile.predownload;

import com.tencent.common.app.business.BaseQQAppInterface;
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
  
  public HttpEngineTask(BaseQQAppInterface paramBaseQQAppInterface, String paramString, HttpEngineTask.IHttpEngineTask paramIHttpEngineTask, HttpNetReq paramHttpNetReq)
  {
    super(paramBaseQQAppInterface, paramString);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start: ");
      localStringBuilder.append(this);
      QLog.d("PreDownload.Task", 2, localStringBuilder.toString());
    }
    ((IHttpEngineService)this.app.getRuntimeService(IHttpEngineService.class, "all")).sendReq(this.httpReq);
    this.httpReq.mCallback = this;
    this.mCallback.onPreDownloadStart(this);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("[");
    localStringBuilder.append(this.httpReq.mReqUrl);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mCallback);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.predownload.HttpEngineTask
 * JD-Core Version:    0.7.0.1
 */