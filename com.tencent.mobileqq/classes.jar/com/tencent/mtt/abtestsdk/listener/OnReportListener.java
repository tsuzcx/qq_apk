package com.tencent.mtt.abtestsdk.listener;

import okhttp3.ResponseBody;

public abstract interface OnReportListener
{
  public abstract void onFailed(int paramInt, String paramString);
  
  public abstract void onSucceed(ResponseBody paramResponseBody);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.listener.OnReportListener
 * JD-Core Version:    0.7.0.1
 */