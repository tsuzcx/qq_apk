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
  public static String f = "envSwitch";
  public static String g = "vas_gldrawable";
  public int a = 2;
  public int b = 1;
  public int c = 1;
  public int d = 1;
  public int e = 15;
  private int h = 1;
  private int i = 1;
  private int j = 1;
  private int k = 0;
  private int l = 16;
  private int m = 1;
  private int n = 1;
  private int o = 0;
  private int p = 1;
  private int q = 1;
  private int r = 1;
  private int s = 0;
  private boolean t = false;
  
  @NonNull
  public static QVipSDKConfig a(@Nullable String paramString)
  {
    QVipSDKConfig localQVipSDKConfig = new QVipSDKConfig();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localQVipSDKConfig.a = paramString.optInt("kingcard", localQVipSDKConfig.a);
        localQVipSDKConfig.h = paramString.optInt("gldrawable", localQVipSDKConfig.h);
        localQVipSDKConfig.b = paramString.optInt("webso_preload", localQVipSDKConfig.b);
        localQVipSDKConfig.c = paramString.optInt("webso_screenshot", localQVipSDKConfig.c);
        localQVipSDKConfig.i = paramString.optInt("etcdrawable", localQVipSDKConfig.i);
        localQVipSDKConfig.j = paramString.optInt("gldrawableEtcApng", localQVipSDKConfig.j);
        localQVipSDKConfig.d = paramString.optInt("livePreload", localQVipSDKConfig.d);
        localQVipSDKConfig.e = paramString.optInt("liveAllowSdk", localQVipSDKConfig.e);
        localQVipSDKConfig.k = paramString.optInt("limitTime", localQVipSDKConfig.k);
        localQVipSDKConfig.l = paramString.optInt("gldrawableMinSdk", localQVipSDKConfig.l);
        localQVipSDKConfig.m = paramString.optInt("supportVideoTheme", localQVipSDKConfig.m);
        localQVipSDKConfig.n = paramString.optInt("optimizeTheme", localQVipSDKConfig.n);
        localQVipSDKConfig.t = paramString.optBoolean("redpoint_new_code", localQVipSDKConfig.t);
        localQVipSDKConfig.o = paramString.optInt("xaDynamic", localQVipSDKConfig.o);
        localQVipSDKConfig.p = paramString.optInt("isCommonGiftUsingXA", localQVipSDKConfig.p);
        localQVipSDKConfig.q = paramString.optInt("isStaffGiftAnimOpen", localQVipSDKConfig.q);
        localQVipSDKConfig.r = paramString.optInt("isGestureGiftAnimOpen", localQVipSDKConfig.r);
        localQVipSDKConfig.s = paramString.optInt("isGetSummaryBatchUpdateEnabled", localQVipSDKConfig.s);
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
  
  @NonNull
  public static QVipSDKConfig n()
  {
    return new QVipSDKConfig();
  }
  
  public boolean a()
  {
    return this.h > 0;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt >= this.l;
  }
  
  public boolean b()
  {
    return this.i > 0;
  }
  
  public boolean c()
  {
    return this.j > 0;
  }
  
  public boolean d()
  {
    return this.d > 0;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return this.t;
  }
  
  public boolean g()
  {
    return this.p > 0;
  }
  
  public boolean h()
  {
    return this.q > 0;
  }
  
  public boolean i()
  {
    return this.r > 0;
  }
  
  public boolean j()
  {
    return this.s > 0;
  }
  
  public boolean k()
  {
    int i1 = this.m;
    boolean bool2 = false;
    if (i1 > 0) {}
    while ((GLDrawableDownloadHelper.a()) && (!DeviceInfoUtils.isLowPerfDevice()))
    {
      i1 = 1;
      break;
    }
    i1 = 0;
    boolean bool1 = bool2;
    if (GLDrawableDownloadHelper.c())
    {
      bool1 = bool2;
      if (i1 != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean l()
  {
    return (GLDrawableDownloadHelper.c()) && (this.n > 0);
  }
  
  public boolean m()
  {
    return this.o > 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QVipSDKConfig{gldrawable=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", etcdrawable=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", gldrawableEtcApng=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", kingCard=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", websoPreload=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", websoScreenshot=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", livePreload=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", liveAllowSdk=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", limitTime=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", gldrawableMinSdk=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", supportVideoTheme=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", optimizeTheme=");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", xaDynamic=");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", isCommonGiftUsingXA=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", isStaffGiftAnimOpen=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", isGestureGiftAnimOpen=");
    localStringBuilder.append(this.r);
    localStringBuilder.append(", isGetSummaryBatchUpdateEnabled=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", redPointNewCode=");
    localStringBuilder.append(this.t);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig
 * JD-Core Version:    0.7.0.1
 */