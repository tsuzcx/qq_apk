package com.tencent.mobileqq.earlydownload.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.handler.PttSilkAndChangeVoiceSoHandler;
import com.tencent.mobileqq.earlydownload.inject.BaseEarlyHandlerProcessor;
import mqq.app.AppRuntime;

public class PttSilkAndChangeVoiceSoProcessor
  extends BaseEarlyHandlerProcessor
{
  public EarlyHandler a(AppRuntime paramAppRuntime)
  {
    return new PttSilkAndChangeVoiceSoHandler((QQAppInterface)paramAppRuntime);
  }
  
  public String a()
  {
    return "qq.android.ptt.so.658";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.processor.PttSilkAndChangeVoiceSoProcessor
 * JD-Core Version:    0.7.0.1
 */