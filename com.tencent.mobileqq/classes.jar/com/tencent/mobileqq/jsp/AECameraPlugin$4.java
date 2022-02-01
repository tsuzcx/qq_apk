package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

final class AECameraPlugin$4
  implements INetEngineListener
{
  AECameraPlugin$4(INetEngineListener paramINetEngineListener) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (this.a != null) {
      this.a.onResp(paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.a != null) {
      this.a.onUpdateProgeress(paramNetReq, paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.AECameraPlugin.4
 * JD-Core Version:    0.7.0.1
 */