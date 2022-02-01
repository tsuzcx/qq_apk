package com.tencent.youtu.sdkkitframework.framework;

import java.util.HashMap;

public abstract interface YtSDKKitFramework$IYTBaseFunctionListener
{
  public abstract String base64Encode(byte[] paramArrayOfByte, int paramInt);
  
  public abstract void detectActionDone(int paramInt);
  
  public abstract HashMap<String, Integer> getFrameResult(Object paramObject);
  
  public abstract byte[] getVoiceData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.IYTBaseFunctionListener
 * JD-Core Version:    0.7.0.1
 */