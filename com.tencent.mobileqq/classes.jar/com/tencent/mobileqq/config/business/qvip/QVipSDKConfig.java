package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import org.json.JSONObject;

public class QVipSDKConfig
{
  public int a;
  private boolean a;
  public int b = 1;
  public int c = 1;
  public int d = 1;
  public int e = 15;
  private int f = 1;
  private int g = 1;
  private int h = 1;
  private int i = 0;
  private int j = 16;
  private int k = 1;
  private int l = 1;
  
  public QVipSDKConfig()
  {
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = false;
  }
  
  @NonNull
  public static QVipSDKConfig a()
  {
    return new QVipSDKConfig();
  }
  
  @NonNull
  public static QVipSDKConfig a(@Nullable String paramString)
  {
    QVipSDKConfig localQVipSDKConfig = new QVipSDKConfig();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localQVipSDKConfig.jdField_a_of_type_Int = paramString.optInt("kingcard", localQVipSDKConfig.jdField_a_of_type_Int);
        localQVipSDKConfig.f = paramString.optInt("gldrawable", localQVipSDKConfig.f);
        localQVipSDKConfig.b = paramString.optInt("webso_preload", localQVipSDKConfig.b);
        localQVipSDKConfig.c = paramString.optInt("webso_screenshot", localQVipSDKConfig.c);
        localQVipSDKConfig.g = paramString.optInt("etcdrawable", localQVipSDKConfig.g);
        localQVipSDKConfig.h = paramString.optInt("gldrawableEtcApng", localQVipSDKConfig.h);
        localQVipSDKConfig.d = paramString.optInt("livePreload", localQVipSDKConfig.d);
        localQVipSDKConfig.e = paramString.optInt("liveAllowSdk", localQVipSDKConfig.e);
        localQVipSDKConfig.i = paramString.optInt("limitTime", localQVipSDKConfig.i);
        localQVipSDKConfig.j = paramString.optInt("gldrawableMinSdk", localQVipSDKConfig.j);
        localQVipSDKConfig.k = paramString.optInt("supportVideoTheme", localQVipSDKConfig.k);
        localQVipSDKConfig.l = paramString.optInt("optimizeTheme", localQVipSDKConfig.l);
        localQVipSDKConfig.jdField_a_of_type_Boolean = paramString.optBoolean("redpoint_new_code", localQVipSDKConfig.jdField_a_of_type_Boolean);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localQVipSDKConfig.toString());
      }
      return localQVipSDKConfig;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, "json parse error:" + paramString);
      }
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public boolean a()
  {
    return this.f > 0;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt >= this.j;
  }
  
  public boolean b()
  {
    return this.g > 0;
  }
  
  public boolean c()
  {
    return this.h > 0;
  }
  
  public boolean d()
  {
    return this.d > 0;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean f()
  {
    int m;
    if (this.k > 0) {
      m = 1;
    }
    while ((GLDrawableWraper.a()) && (m != 0))
    {
      return true;
      if ((GLDrawableWraper.b()) && (!DeviceInfoUtils.b())) {
        m = 1;
      } else {
        m = 0;
      }
    }
    return false;
  }
  
  public boolean g()
  {
    return (GLDrawableWraper.a()) && (this.l > 0);
  }
  
  public String toString()
  {
    return "QVipSDKConfig{gldrawable=" + this.f + ", etcdrawable=" + this.g + ", gldrawableEtcApng=" + this.h + ", kingCard=" + this.jdField_a_of_type_Int + ", websoPreload=" + this.b + ", websoScreenshot=" + this.c + ", livePreload=" + this.d + ", liveAllowSdk=" + this.e + ", limitTime=" + this.i + ", gldrawableMinSdk=" + this.j + ", supportVideoTheme=" + this.k + ", optimizeTheme=" + this.l + ", redPointNewCode=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipSDKConfig
 * JD-Core Version:    0.7.0.1
 */