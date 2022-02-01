package com.tencent.qqlive.tvkplayer.thirdparties.httpclient;

import java.util.List;
import java.util.Map;

public abstract interface IWriteFuncListener
{
  public abstract void onWriteBody(byte[] paramArrayOfByte, int paramInt);
  
  public abstract void onWriteBodyEnd();
  
  public abstract void onWriteHeaders(Map<String, List<String>> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.httpclient.IWriteFuncListener
 * JD-Core Version:    0.7.0.1
 */