package com.tencent.mobileqq.qrscan.inject;

import com.tencent.biz.qrcode.processor.ArkQRProcessor;
import com.tencent.biz.qrcode.processor.CardQRProcessor;
import com.tencent.biz.qrcode.processor.DeviceQRProcessor;
import com.tencent.biz.qrcode.processor.HippyQRProcessor;
import com.tencent.biz.qrcode.processor.LoginQRProcessor;
import com.tencent.biz.qrcode.processor.MicroAppQRProcessor;
import com.tencent.biz.qrcode.processor.MiniAppQRProcessor;
import com.tencent.biz.qrcode.processor.MiniCodeQRProcessor;
import com.tencent.biz.qrcode.processor.MsgBackupQRProcessor;
import com.tencent.biz.qrcode.processor.PublicAccountQRProcessor;
import com.tencent.biz.qrcode.processor.QLinkQRProcessor;
import com.tencent.biz.qrcode.processor.QWalletQRProcessor;
import com.tencent.biz.qrcode.processor.QimQRProcessor;
import com.tencent.biz.qrcode.processor.UrlQRProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.qrscan.IQRScanResultProcessor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class QRScanProcessorFactory
{
  @ConfigInject(configPath="Business/qqqrscan-impl/src/main/resources/Inject_QRScanProcessor.yml", version=1)
  private static ArrayList<Class<? extends IQRScanResultProcessor>> a = new ArrayList();
  
  static
  {
    a.add(MiniCodeQRProcessor.class);
    a.add(ArkQRProcessor.class);
    a.add(CardQRProcessor.class);
    a.add(DeviceQRProcessor.class);
    a.add(LoginQRProcessor.class);
    a.add(MicroAppQRProcessor.class);
    a.add(MiniAppQRProcessor.class);
    a.add(MsgBackupQRProcessor.class);
    a.add(PublicAccountQRProcessor.class);
    a.add(QimQRProcessor.class);
    a.add(QLinkQRProcessor.class);
    a.add(QWalletQRProcessor.class);
    a.add(HippyQRProcessor.class);
    a.add(UrlQRProcessor.class);
  }
  
  public List<IQRScanResultProcessor> a(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Class)localIterator.next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initBusinessProcessors| ");
        localStringBuilder.append(((Class)localObject1).getName());
        QLog.d("IQRScanConst_QRScanProcessorFactory", 2, localStringBuilder.toString());
      }
      Object localObject2;
      try
      {
        localObject1 = (IQRScanResultProcessor)((Class)localObject1).getConstructor(new Class[] { AppRuntime.class, OnQRHandleResultCallback.class }).newInstance(new Object[] { paramAppRuntime, paramOnQRHandleResultCallback });
      }
      catch (Exception localException)
      {
        QLog.d("IQRScanConst_QRScanProcessorFactory", 1, "initBusinessProcessors fail.", localException);
        localObject2 = null;
      }
      if (localObject2 != null) {
        localArrayList.add(localObject2);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.inject.QRScanProcessorFactory
 * JD-Core Version:    0.7.0.1
 */