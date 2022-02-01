package com.tencent.mobileqq.winkpublish.queue;

public abstract interface IUploadQueueListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(Object paramObject);
  
  public abstract void a(Object paramObject, int paramInt, String paramString);
  
  public abstract void a(String paramString, long paramLong1, long paramLong2);
  
  public abstract void dC_();
  
  public abstract int getState();
  
  public abstract void setTime(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.queue.IUploadQueueListener
 * JD-Core Version:    0.7.0.1
 */