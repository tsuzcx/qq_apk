package com.tencent.tbs.one.impl.net;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public abstract interface HttpRequestJob$Client
{
  public abstract void onResponseReceived(int paramInt, Map<String, List<String>> paramMap, InputStream paramInputStream);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.net.HttpRequestJob.Client
 * JD-Core Version:    0.7.0.1
 */