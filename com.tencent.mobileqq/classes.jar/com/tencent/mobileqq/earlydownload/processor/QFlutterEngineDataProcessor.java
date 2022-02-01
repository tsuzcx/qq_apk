package com.tencent.mobileqq.earlydownload.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.inject.BaseEarlyHandlerProcessor;
import com.tencent.mobileqq.earlydownload.xmldata.QFlutterEngineData;
import mqq.app.AppRuntime;

public class QFlutterEngineDataProcessor
  extends BaseEarlyHandlerProcessor
{
  public EarlyHandler a(AppRuntime paramAppRuntime)
  {
    return QFlutterEngineData.createDownloader((QQAppInterface)paramAppRuntime);
  }
  
  public String a()
  {
    return QFlutterEngineData.STR_RES_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.processor.QFlutterEngineDataProcessor
 * JD-Core Version:    0.7.0.1
 */