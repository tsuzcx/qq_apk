package com.tencent.mtt.hippy.adapter.http;

public abstract interface HippyHttpAdapter
{
  public abstract void destroyIfNeed();
  
  public abstract void sendRequest(HippyHttpRequest paramHippyHttpRequest, HippyHttpAdapter.HttpTaskCallback paramHttpTaskCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter
 * JD-Core Version:    0.7.0.1
 */