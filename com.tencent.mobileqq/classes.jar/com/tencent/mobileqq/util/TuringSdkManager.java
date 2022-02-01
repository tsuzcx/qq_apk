package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.beacon.event.UserAction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tinyid.impl.TinyIDHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.turingfd.sdk.xq.RiskDetectResp;
import com.tencent.turingfd.sdk.xq.TuringRiskService;
import com.tencent.turingfd.sdk.xq.TuringSDK;
import com.tencent.turingfd.sdk.xq.TuringSDK.Builder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mqq.manager.Manager;

public class TuringSdkManager
  implements Manager
{
  private String a = "TinyId";
  private String b = "Qimei36";
  private boolean c = false;
  private Context d;
  private AppInterface e;
  private String f;
  private TinyIDHandler g;
  
  @Deprecated
  public TuringSdkManager() {}
  
  public TuringSdkManager(AppInterface paramAppInterface)
  {
    this.e = paramAppInterface;
    this.d = BaseApplication.getContext();
    this.f = this.e.getCurrentAccountUin();
    this.g = ((TinyIDHandler)this.e.getBusinessHandler(TinyIDHandler.a));
  }
  
  public void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.d.getSharedPreferences("TinyID_Cache", 0).edit();
    localEditor.putString(this.f, paramString);
    localEditor.apply();
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put(Integer.valueOf(11), this.a);
    ((Map)localObject).put(Integer.valueOf(12), this.b);
    if (!this.c)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init TuringSDK isUserAllow = ");
      localStringBuilder.append(paramBoolean);
      QLog.i("TuringSdkInitHelper", 1, localStringBuilder.toString());
      try
      {
        TuringSDK.a(this.d).a("1109803375").a(new TuringSdkManager.2(this, paramBoolean)).a((Map)localObject).a().d();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("TuringSDK Version : ");
        ((StringBuilder)localObject).append(TuringSDK.c());
        QLog.i("TuringSdkInitHelper", 1, ((StringBuilder)localObject).toString());
        this.c = true;
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("TuringSdkInitHelper", 1, localThrowable, new Object[] { "Turing init crash fail" });
        throw localThrowable;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!TextUtils.isEmpty(UserAction.getQimeiNew())) {
      this.b = UserAction.getQimeiNew();
    }
    Object localObject = this.d.getSharedPreferences("TinyID_Cache", 0);
    if (((SharedPreferences)localObject).contains(this.f))
    {
      this.a = ((SharedPreferences)localObject).getString(this.f, "TinyId");
      if (!b(this.a))
      {
        QLog.d("TuringSdkInitHelper", 1, "[initTuringSDKAndRiskDetect], tinyID from sp is invalid");
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[initTuringSDKAndRiskDetect], get tinyID with sp, tinyID = [");
      ((StringBuilder)localObject).append(this.a.substring(0, 3));
      ((StringBuilder)localObject).append("****]");
      QLog.d("TuringSdkInitHelper", 1, ((StringBuilder)localObject).toString());
      b(paramBoolean1, paramBoolean2);
      return;
    }
    if (this.g == null) {
      this.g = ((TinyIDHandler)this.e.getBusinessHandler(TinyIDHandler.a));
    }
    QLog.d("TuringSdkInitHelper", 1, "[initTuringSDKAndRiskDetect], get tinyID with OIDB");
    this.g.a(new TuringSdkManager.1(this, paramBoolean1, paramBoolean2));
  }
  
  public boolean a(long paramLong)
  {
    Object localObject1 = this.d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("turing_risk_detect");
    ((StringBuilder)localObject2).append(this.f);
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool = false;
    long l = ((Context)localObject1).getSharedPreferences((String)localObject2, 0).getLong("last_risk_detect_time", 0L);
    localObject1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("lastTime: ");
    ((StringBuilder)localObject2).append(((SimpleDateFormat)localObject1).format(new Date(l)));
    ((StringBuilder)localObject2).append(" currTime: ");
    ((StringBuilder)localObject2).append(((SimpleDateFormat)localObject1).format(new Date(paramLong)));
    QLog.d("TuringSdkInitHelper", 1, ((StringBuilder)localObject2).toString());
    if ((l == 0L) || (!a(l, paramLong))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(2) == localCalendar2.get(2)) && (localCalendar1.get(5) == localCalendar2.get(5));
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      a(paramBoolean1);
    }
    catch (Throwable localThrowable)
    {
      QLog.e("TuringSdkInitHelper", 1, localThrowable, new Object[0]);
    }
    if ((this.c) && (paramBoolean2))
    {
      paramBoolean1 = ((ICommonFunctionPublishConfigService)QRoute.api(ICommonFunctionPublishConfigService.class)).isTuringRiskDetectEnable();
      long l = System.currentTimeMillis();
      if ((paramBoolean1) && (a(l)))
      {
        RiskDetectResp localRiskDetectResp = TuringRiskService.a(BaseApplication.getContext());
        StringBuilder localStringBuilder;
        if (localRiskDetectResp.a() == 0L)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("msgBlock : ");
          localStringBuilder.append(localRiskDetectResp.b());
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("errorCode : ");
          localStringBuilder.append(localRiskDetectResp.a());
        }
        QLog.d("TuringSdkInitHelper", 1, localStringBuilder.toString());
      }
    }
  }
  
  boolean b(@Nullable String paramString)
  {
    return (paramString != null) && (paramString.length() >= 3);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.TuringSdkManager
 * JD-Core Version:    0.7.0.1
 */