package com.tencent.qqlive.tvkplayer.tools.utils;

import java.util.List;
import java.util.Map;

public abstract interface ITVKHttpProcessor$IWriteCallback
{
  public abstract void onWriteBodyEnd();
  
  public abstract void writeBody(byte[] paramArrayOfByte, int paramInt);
  
  public abstract void writeHeaders(Map<String, List<String>> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.tools.utils.ITVKHttpProcessor.IWriteCallback
 * JD-Core Version:    0.7.0.1
 */