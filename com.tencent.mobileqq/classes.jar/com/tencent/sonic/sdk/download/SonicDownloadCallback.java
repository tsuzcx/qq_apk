package com.tencent.sonic.sdk.download;

import java.util.List;
import java.util.Map;

public abstract interface SonicDownloadCallback
{
  public abstract void onError(int paramInt);
  
  public abstract void onFinish();
  
  public abstract void onProgress(int paramInt1, int paramInt2);
  
  public abstract void onStart();
  
  public abstract void onSuccess(byte[] paramArrayOfByte, Map<String, List<String>> paramMap);
  
  public static class SimpleDownloadCallback
    implements SonicDownloadCallback
  {
    public void onError(int paramInt) {}
    
    public void onFinish() {}
    
    public void onProgress(int paramInt1, int paramInt2) {}
    
    public void onStart() {}
    
    public void onSuccess(byte[] paramArrayOfByte, Map<String, List<String>> paramMap) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.download.SonicDownloadCallback
 * JD-Core Version:    0.7.0.1
 */