package com.tencent.viola.module;

import com.tencent.viola.adapter.HttpResponse;
import java.util.Map;

abstract interface HttpModule$ResponseCallback
{
  public abstract void onResponse(HttpResponse paramHttpResponse, Map<String, String> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.module.HttpModule.ResponseCallback
 * JD-Core Version:    0.7.0.1
 */