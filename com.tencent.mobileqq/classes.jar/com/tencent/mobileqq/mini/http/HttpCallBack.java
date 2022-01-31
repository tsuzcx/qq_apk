package com.tencent.mobileqq.mini.http;

import java.util.List;
import java.util.Map;

public abstract class HttpCallBack
{
  public abstract void headersReceived(int paramInt, Map<String, List<String>> paramMap);
  
  public abstract void httpCallBack(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap);
  
  public abstract void onProgressUpdate(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.http.HttpCallBack
 * JD-Core Version:    0.7.0.1
 */