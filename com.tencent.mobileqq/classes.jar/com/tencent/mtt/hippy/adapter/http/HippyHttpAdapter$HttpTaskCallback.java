package com.tencent.mtt.hippy.adapter.http;

public abstract interface HippyHttpAdapter$HttpTaskCallback
{
  public abstract void onTaskFailed(HippyHttpRequest paramHippyHttpRequest, Throwable paramThrowable);
  
  public abstract void onTaskSuccess(HippyHttpRequest paramHippyHttpRequest, HippyHttpResponse paramHippyHttpResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter.HttpTaskCallback
 * JD-Core Version:    0.7.0.1
 */