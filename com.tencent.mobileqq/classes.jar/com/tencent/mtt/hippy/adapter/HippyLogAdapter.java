package com.tencent.mtt.hippy.adapter;

public abstract interface HippyLogAdapter
{
  public abstract void init(int paramInt, String paramString);
  
  public abstract void log(String paramString1, String paramString2);
  
  public abstract void upload(HippyLogAdapter.callBack paramcallBack);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.HippyLogAdapter
 * JD-Core Version:    0.7.0.1
 */