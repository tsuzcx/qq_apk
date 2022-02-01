package com.tencent.mobileqq.transfile;

import com.tencent.TMG.utils.QLog;

class HttpInterfaceForTVKImp$NetEngineResponseListener
  implements INetEngineListener
{
  private HttpInterfaceForTVKImp$NetEngineResponseListener(HttpInterfaceForTVKImp paramHttpInterfaceForTVKImp) {}
  
  public void onResp(NetResp paramNetResp)
  {
    synchronized (HttpInterfaceForTVKImp.access$000(this.this$0))
    {
      HttpInterfaceForTVKImp.access$102(this.this$0, paramNetResp.mResult);
      HttpInterfaceForTVKImp.access$202(this.this$0, paramNetResp.mErrCode);
      this.this$0.mErrDesc = paramNetResp.mErrDesc;
      this.this$0.mHttpCode = paramNetResp.mHttpCode;
      HttpInterfaceForTVKImp.access$302(this.this$0, true);
      if (QLog.isColorLevel()) {
        QLog.d("HttpInterfaceForTVKImp", 0, "onResp, result = " + HttpInterfaceForTVKImp.access$100(this.this$0) + " , errorCode = " + HttpInterfaceForTVKImp.access$200(this.this$0) + " , mErrDesc = " + this.this$0.mErrDesc + " , mHttpCode = " + this.this$0.mHttpCode);
      }
      HttpInterfaceForTVKImp.access$000(this.this$0).notify();
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpInterfaceForTVKImp.NetEngineResponseListener
 * JD-Core Version:    0.7.0.1
 */