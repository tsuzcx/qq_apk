package com.tencent.viola.adapter;

import java.util.List;
import java.util.Map;

public abstract interface IHttpAdapter$OnHttpListener
{
  public abstract void onHeadersReceived(int paramInt, Map<String, List<String>> paramMap);
  
  public abstract void onHttpFinish(HttpResponse paramHttpResponse);
  
  public abstract void onHttpStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.adapter.IHttpAdapter.OnHttpListener
 * JD-Core Version:    0.7.0.1
 */