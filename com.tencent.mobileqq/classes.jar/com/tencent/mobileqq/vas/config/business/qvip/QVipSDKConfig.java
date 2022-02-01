package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableDownloadHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import org.json.JSONObject;

public class QVipSDKConfig
{
  public static String a = "envSwitch";
  public static String b = "vas_gldrawable";
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
  private int m = 1;
  private int n = 1;
  private int o = 1;
  
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
        localQVipSDKConfig.m = paramString.optInt("xaDynamic", localQVipSDKConfig.m);
        localQVipSDKConfig.n = paramString.optInt("isCommonGiftUsingXA", localQVipSDKConfig.n);
        localQVipSDKConfig.o = paramString.optInt("isStaffGiftAnimOpen", localQVipSDKConfig.o);
      }
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("json parse error:");
      localStringBuilder.append(paramString);
      QLog.e("QVIP.SDK.ConfigProcessor", 1, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(" : ");
      paramString.append(localQVipSDKConfig.toString());
      QLog.e("QVIP.SDK.ConfigProcessor", 1, paramString.toString());
    }
    return localQVipSDKConfig;
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
    return this.n > 0;
  }
  
  public boolean g()
  {
    return this.o > 0;
  }
  
  public boolean h()
  {
    int i1 = this.k;
    boolean bool2 = false;
    if (i1 > 0) {}
    while ((GLDrawableDownloadHelper.a()) && (!DeviceInfoUtils.b()))
    {
      i1 = 1;
      break;
    }
    i1 = 0;
    boolean bool1 = bool2;
    if (GLDrawableDownloadHelper.b())
    {
      bool1 = bool2;
      if (i1 != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean i()
  {
    return (GLDrawableDownloadHelper.b()) && (this.l > 0);
  }
  
  public boolean j()
  {
    return this.m > 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QVipSDKConfig{gldrawable=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", etcdrawable=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", gldrawableEtcApng=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", kingCard=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", websoPreload=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", websoScreenshot=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", livePreload=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", liveAllowSdk=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", limitTime=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", gldrawableMinSdk=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", supportVideoTheme=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", optimizeTheme=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", xaDynamic=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", isCommonGiftUsingXA=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", isStaffGiftAnimOpen=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", redPointNewCode=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig
 * JD-Core Version:    0.7.0.1
 */