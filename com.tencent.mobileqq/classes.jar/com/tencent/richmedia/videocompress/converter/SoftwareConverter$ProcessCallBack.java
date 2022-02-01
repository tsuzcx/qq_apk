package com.tencent.richmedia.videocompress.converter;

import com.tencent.richmedia.videocompress.VideoConverterConfig;

public abstract interface SoftwareConverter$ProcessCallBack
{
  public abstract VideoConverterConfig getEncodeConfig();
  
  public abstract void onDestroy();
  
  public abstract void onStart(Process paramProcess);
  
  public abstract void onStop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmedia.videocompress.converter.SoftwareConverter.ProcessCallBack
 * JD-Core Version:    0.7.0.1
 */