package com.tencent.mtt.hippy.adapter;

public class DefaultLogAdapter
  implements HippyLogAdapter
{
  public void init(int paramInt, String paramString) {}
  
  public void log(String paramString1, String paramString2) {}
  
  public void upload(HippyLogAdapter.callBack paramcallBack)
  {
    paramcallBack.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.adapter.DefaultLogAdapter
 * JD-Core Version:    0.7.0.1
 */