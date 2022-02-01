package com.tencent.richframework.sender.interceptor;

import com.tencent.richframework.sender.chain.SenderChain;

public abstract interface RspInterceptor<Q, E extends SenderChain>
{
  public abstract void interceptReturnRsp(boolean paramBoolean, long paramLong, String paramString, Q paramQ, Object paramObject, E paramE);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.interceptor.RspInterceptor
 * JD-Core Version:    0.7.0.1
 */