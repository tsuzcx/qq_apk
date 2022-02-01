package com.tencent.mobileqq.qrscan.earlydown;

import android.os.Looper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanTempApi;
import com.tencent.mobileqq.qrscan.chirp.IChirpSoDownload;
import com.tencent.mobileqq.qrscan.chirp.IChirpSoDownload.Callback;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ChirpSoHandler
  extends EarlyHandler
  implements IChirpSoDownload
{
  private LinkedList<IChirpSoDownload.Callback> a = new LinkedList();
  private AppRuntime b;
  private boolean d = false;
  
  public ChirpSoHandler(AppRuntime paramAppRuntime)
  {
    super("qq.android.system.chirp", paramAppRuntime);
    this.b = paramAppRuntime;
  }
  
  public int a()
  {
    return ((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).getEarlyDownBusId(101);
  }
  
  public Class<? extends XmlData> a()
  {
    return ChirpSoData.class;
  }
  
  public String a()
  {
    return "actEarlyChirpSo";
  }
  
  public void a(IChirpSoDownload.Callback paramCallback)
  {
    synchronized (this.a)
    {
      if (!this.a.contains(paramCallback)) {
        this.a.add(paramCallback);
      }
      return;
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownload success ");
      localStringBuilder.append(paramString);
      QLog.d("ChirpSoHandler", 2, localStringBuilder.toString());
    }
    paramString = new ChirpSoHandler.1(this, paramString);
    if (Looper.getMainLooper() == Looper.myLooper()) {
      ThreadManager.getSubThreadHandler().post(paramString);
    } else {
      paramString.run();
    }
    ThreadManager.getUIHandler().post(new ChirpSoHandler.2(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("restartDownload ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ChirpSoHandler", 2, localStringBuilder.toString());
    }
    if (!this.d) {
      this.d = paramBoolean;
    }
    if ((a() != null) && (a().loadState == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChirpSoHandler", 2, "is in downloading");
      }
    }
    else {
      super.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public String b()
  {
    return "prd";
  }
  
  public void b(IChirpSoDownload.Callback paramCallback)
  {
    synchronized (this.a)
    {
      this.a.remove(paramCallback);
      return;
    }
  }
  
  public boolean c()
  {
    StringBuilder localStringBuilder;
    if (this.d)
    {
      ((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).setTalkbackSwitch();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNetValid2Download by user ");
        localStringBuilder.append(AppSetting.d);
        QLog.d("ChirpSoHandler", 2, localStringBuilder.toString());
      }
      return AppSetting.d;
    }
    ((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).setTalkbackSwitch();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNetValid2Download by startup ");
      localStringBuilder.append(AppSetting.d);
      QLog.d("ChirpSoHandler", 2, localStringBuilder.toString());
    }
    return (AppSetting.d) && (super.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.ChirpSoHandler
 * JD-Core Version:    0.7.0.1
 */