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
  private static ArrayList<Class<? extends BaseEarlyHandlerProcessor>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  @ConfigInject(configPath="Business/qq-earlydownload-impl/src/main/resources/Inject_QQEarlyDownloadProcessor.yml", version=1)
  private static ArrayList<Class<? extends BaseEarlyHandlerProcessor>> b;
  private static ArrayList<BaseEarlyHandlerProcessor> c = new ArrayList();
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList.add(AppleEmojiProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(ArNativeSoDownloadProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(ChirpSoProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(FaceModelsDownloadProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(FaceScanNativeSoDownloadProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(HotFriendResProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(JpegSoDownloadProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(MiniScanDecodeSoDownloadProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(MiniScanDetectModelsDownloadProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(MiniScanDetectSoDownloadProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QBarModelDownloadProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(PokeResProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(PrecoverProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(PttSilkAndChangeVoiceSoProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(PttTransitionAnimProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QavGAudioSoundProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QavImageProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QavSoDownloadProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QavVideoDownloadProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QFlutterAppDataProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QFlutterEngineDataProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(QQDingdongSoundProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(SystemFaceProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(ViolaBizLibProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(ViolaLibProcessor.class);
    jdField_a_of_type_JavaUtilArrayList.add(WebSoDownloadProcessor.class);
    b = new ArrayList();
    b.add(ArNativeSoDownloadProcessor.class);
  }
  
  private void a(AppRuntime paramAppRuntime)
  {
    c.clear();
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
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
        c.add(paramAppRuntime);
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
    if (!this.jdField_a_of_type_Boolean)
    {
      a(paramAppRuntime);
      this.jdField_a_of_type_Boolean = true;
    }
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.inject.EarlyHandlerProcessorFactory
 * JD-Core Version:    0.7.0.1
 */