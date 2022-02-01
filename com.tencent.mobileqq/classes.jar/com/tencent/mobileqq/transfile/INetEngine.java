package com.tencent.mobileqq.transfile;

public abstract interface INetEngine
{
  public abstract void cancelReq(NetReq paramNetReq);
  
  public abstract void sendReq(NetReq paramNetReq);
  
  public abstract NetResp sendReqSync(NetReq paramNetReq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.INetEngine
 * JD-Core Version:    0.7.0.1
 */