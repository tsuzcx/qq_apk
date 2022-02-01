package com.tencent.richframework.sender.interceptor;

import com.tencent.richframework.sender.chain.SenderChain;

public abstract interface ReqInterceptor<T, E extends SenderChain>
{
  public abstract void a(T paramT, E paramE);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.interceptor.ReqInterceptor
 * JD-Core Version:    0.7.0.1
 */