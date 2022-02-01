package com.tencent.mobileqq.earlydownload.inject;

import com.tencent.mobileqq.earlydownload.processor.AppleEmojiProcessor;
import com.tencent.mobileqq.earlydownload.processor.ArNativeSoDownloadProcessor;
import com.tencent.mobileqq.earlydownload.processor.ChirpSoProcessor;
import com.tencent.mobileqq.earlydownload.processor.FaceModelsDownloadProcessor;
import com.tencent.mobileqq.earlydownload.processor.FaceScanNativeSoDownloadProcessor;
import com.tencent.mobileqq.earlydownload.processor.HotFriendResProcessor;
import com.tencent.mobileqq.earlydownload.processor.JpegSoDownloadProcessor;
import com.tencent.mobileqq.earlydownload.processor.MiniScanDecodeSoDownloadProcessor;
import com.tencent.mobileqq.earlydownload.processor.MiniScanDetectModelsDownloadProcessor;
import com.tencent.mobileqq.earlydownload.processor.MiniScanDetectSoDownloadProcessor;
import com.tencent.mobileqq.earlydownload.processor.PokeResProcessor;
import com.tencent.mobileqq.earlydownload.processor.PrecoverProcessor;
import com.tencent.mobileqq.earlydownload.processor.PttSilkAndChangeVoiceSoProcessor;
import com.tencent.mobileqq.earlydownload.processor.PttTransitionAnimProcessor;
import com.tencent.mobileqq.earlydownload.processor.QBarModelDownloadProcessor;
import com.tencent.mobileqq.earlydownload.processor.QFlutterAppDataProcessor;
import com.tencent.mobileqq.earlydownload.processor.QFlutterEngineDataProcessor;
import com.tencent.mobileqq.earlydownload.processor.QQDingdongSoundProcessor;
import com.tencent.mobileqq.earlydownload.processor.QavGAudioSoundProcessor;
import com.tencent.mobileqq.earlydownload.processor.QavImageProcessor;
import com.tencent.mobileqq.earlydownload.processor.QavSoDownloadProcessor;
import com.tencent.mobileqq.earlydownload.processor.QavVideoDownloadProcessor;
import com.tencent.mobileqq.earlydownload.processor.SystemFaceProcessor;
import com.tencent.mobileqq.earlydownload.processor.ViolaBizLibProcessor;
import com.tencent.mobileqq.earlydownload.processor.ViolaLibProcessor;
import com.tencent.mobileqq.earlydownload.processor.WebSoDownloadProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class EarlyHandlerProcessorFactory
{
  @ConfigInject(configPath="Business/qq-earlydownload-impl/src/main/resources/Inject_QQEarlyDownloadProcessor.yml", version=1)
  private static ArrayList<Class<? extends BaseEarlyHandlerProcessor>> a = new ArrayList();
  @ConfigInject(configPath="Business/qq-earlydownload-impl/src/main/resources/Inject_QQEarlyDownloadProcessor.yml", version=1)
  private static ArrayList<Class<? extends BaseEarlyHandlerProcessor>> b;
  private static ArrayList<BaseEarlyHandlerProcessor> d = new ArrayList();
  private volatile boolean c = false;
  
  static
  {
    a.add(AppleEmojiProcessor.class);
    a.add(ArNativeSoDownloadProcessor.class);
    a.add(ChirpSoProcessor.class);
    a.add(FaceModelsDownloadProcessor.class);
    a.add(FaceScanNativeSoDownloadProcessor.class);
    a.add(HotFriendResProcessor.class);
    a.add(JpegSoDownloadProcessor.class);
    a.add(MiniScanDecodeSoDownloadProcessor.class);
    a.add(MiniScanDetectModelsDownloadProcessor.class);
    a.add(MiniScanDetectSoDownloadProcessor.class);
    a.add(QBarModelDownloadProcessor.class);
    a.add(PokeResProcessor.class);
    a.add(PrecoverProcessor.class);
    a.add(PttSilkAndChangeVoiceSoProcessor.class);
    a.add(PttTransitionAnimProcessor.class);
    a.add(QavGAudioSoundProcessor.class);
    a.add(QavImageProcessor.class);
    a.add(QavSoDownloadProcessor.class);
    a.add(QavVideoDownloadProcessor.class);
    a.add(QFlutterAppDataProcessor.class);
    a.add(QFlutterEngineDataProcessor.class);
    a.add(QQDingdongSoundProcessor.class);
    a.add(SystemFaceProcessor.class);
    a.add(ViolaBizLibProcessor.class);
    a.add(ViolaLibProcessor.class);
    a.add(WebSoDownloadProcessor.class);
    b = new ArrayList();
    b.add(ArNativeSoDownloadProcessor.class);
  }
  
  private void b(AppRuntime paramAppRuntime)
  {
    d.clear();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      paramAppRuntime = (Class)localIterator.next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initBusinessProcessors| ");
        localStringBuilder.append(paramAppRuntime.getName());
        QLog.d("EarlyHandlerProcessorFactory", 2, localStringBuilder.toString());
      }
      try
      {
        paramAppRuntime = (BaseEarlyHandlerProcessor)paramAppRuntime.getConstructor(new Class[0]).newInstance(new Object[0]);
      }
      catch (Exception paramAppRuntime)
      {
        QLog.d("EarlyHandlerProcessorFactory", 1, "initBusinessProcessors fail.", paramAppRuntime);
        paramAppRuntime = null;
      }
      if (paramAppRuntime != null) {
        d.add(paramAppRuntime);
      }
    }
  }
  
  public String a()
  {
    try
    {
      String str = ((BaseEarlyHandlerProcessor)((Class)b.get(0)).getConstructor(new Class[0]).newInstance(new Object[0])).a();
      return str;
    }
    catch (Exception localException)
    {
      QLog.d("EarlyHandlerProcessorFactory", 1, "getArNativeSoDownloadResName fail.", localException);
    }
    return "";
  }
  
  public ArrayList<BaseEarlyHandlerProcessor> a(AppRuntime paramAppRuntime)
  {
    if (!this.c)
    {
      b(paramAppRuntime);
      this.c = true;
    }
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.inject.EarlyHandlerProcessorFactory
 * JD-Core Version:    0.7.0.1
 */