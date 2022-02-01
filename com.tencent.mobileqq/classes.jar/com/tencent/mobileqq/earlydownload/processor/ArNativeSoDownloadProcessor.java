package com.tencent.mobileqq.earlydownload.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.handler.ArNativeSoDownloadHandler;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.inject.BaseEarlyHandlerProcessor;
import mqq.app.AppRuntime;

public class ArNativeSoDownloadProcessor
  extends BaseEarlyHandlerProcessor
{
  public EarlyHandler a(AppRuntime paramAppRuntime)
  {
    return new ArNativeSoDownloadHandler((QQAppInterface)paramAppRuntime);
  }
  
  public String a()
  {
    return "qq.android.ar.native.so_v8.3.6";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.processor.ArNativeSoDownloadProcessor
 * JD-Core Version:    0.7.0.1
 */