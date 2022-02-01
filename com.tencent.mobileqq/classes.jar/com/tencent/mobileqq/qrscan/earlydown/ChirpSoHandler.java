package com.tencent.mobileqq.qrscan.earlydown;

import android.os.Looper;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IQRScanAbilityApi;
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
  private AppRuntime h;
  private boolean i = false;
  private LinkedList<IChirpSoDownload.Callback> j = new LinkedList();
  
  public ChirpSoHandler(AppRuntime paramAppRuntime)
  {
    super("qq.android.system.chirp", paramAppRuntime);
    this.h = paramAppRuntime;
  }
  
  public Class<? extends XmlData> a()
  {
    return ChirpSoData.class;
  }
  
  public void a(IChirpSoDownload.Callback paramCallback)
  {
    synchronized (this.j)
    {
      if (!this.j.contains(paramCallback)) {
        this.j.add(paramCallback);
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
    if (!this.i) {
      this.i = paramBoolean;
    }
    if ((h() != null) && (h().loadState == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChirpSoHandler", 2, "is in downloading");
      }
    }
    else {
      super.a(paramBoolean);
    }
  }
  
  public String b()
  {
    return "actEarlyChirpSo";
  }
  
  public void b(IChirpSoDownload.Callback paramCallback)
  {
    synchronized (this.j)
    {
      this.j.remove(paramCallback);
      return;
    }
  }
  
  public int c()
  {
    return ((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).getEarlyDownBusId(101);
  }
  
  public String d()
  {
    return "prd";
  }
  
  public boolean e()
  {
    return true;
  }
  
  public boolean m()
  {
    StringBuilder localStringBuilder;
    if (this.i)
    {
      ((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).setTalkbackSwitch();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNetValid2Download by user ");
        localStringBuilder.append(AppSetting.e);
        QLog.d("ChirpSoHandler", 2, localStringBuilder.toString());
      }
      return AppSetting.e;
    }
    ((IQRScanAbilityApi)QRoute.api(IQRScanAbilityApi.class)).setTalkbackSwitch();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isNetValid2Download by startup ");
      localStringBuilder.append(AppSetting.e);
      QLog.d("ChirpSoHandler", 2, localStringBuilder.toString());
    }
    return (AppSetting.e) && (super.m());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.earlydown.ChirpSoHandler
 * JD-Core Version:    0.7.0.1
 */