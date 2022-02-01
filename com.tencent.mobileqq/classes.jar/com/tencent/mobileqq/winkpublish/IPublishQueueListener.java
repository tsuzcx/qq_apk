package com.tencent.mobileqq.winkpublish;

public abstract interface IPublishQueueListener
{
  public abstract void onProgressChanged(IQueueTask paramIQueueTask);
  
  public abstract void onQueueChanged();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.IPublishQueueListener
 * JD-Core Version:    0.7.0.1
 */