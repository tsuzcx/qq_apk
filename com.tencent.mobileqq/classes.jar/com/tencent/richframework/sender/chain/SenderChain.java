package com.tencent.richframework.sender.chain;

public abstract interface SenderChain<Q>
{
  public abstract void a(Q paramQ);
  
  public abstract void a(boolean paramBoolean, long paramLong, String paramString, Q paramQ, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.sender.chain.SenderChain
 * JD-Core Version:    0.7.0.1
 */