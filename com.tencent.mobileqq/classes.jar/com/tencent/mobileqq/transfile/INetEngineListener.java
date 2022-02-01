package com.tencent.mobileqq.transfile;

public abstract interface INetEngineListener
{
  public abstract void onResp(NetResp paramNetResp);
  
  public abstract void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.INetEngineListener
 * JD-Core Version:    0.7.0.1
 */