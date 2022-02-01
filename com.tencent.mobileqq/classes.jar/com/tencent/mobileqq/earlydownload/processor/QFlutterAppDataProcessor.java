package com.tencent.mobileqq.earlydownload.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.inject.BaseEarlyHandlerProcessor;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterAppData;
import mqq.app.AppRuntime;

public class QFlutterAppDataProcessor
  extends BaseEarlyHandlerProcessor
{
  public EarlyHandler a(AppRuntime paramAppRuntime)
  {
    return QFlutterAppData.createDownloader((QQAppInterface)paramAppRuntime);
  }
  
  public String a()
  {
    return "qq.android.flutter.app.v8.7.0_release";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.processor.QFlutterAppDataProcessor
 * JD-Core Version:    0.7.0.1
 */