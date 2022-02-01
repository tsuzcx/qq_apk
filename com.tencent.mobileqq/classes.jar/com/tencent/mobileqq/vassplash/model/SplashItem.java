package com.tencent.mobileqq.vassplash.model;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class SplashItem
{
  public String a;
  public String b = "";
  public String c = "";
  public String d = "";
  public int e = -1;
  public String f = "";
  public int g = -1;
  public String h = "";
  public int i = 0;
  public String j = "";
  public String k;
  public String l;
  public int m;
  public String n;
  public String o;
  public int p;
  public boolean q = false;
  public boolean r = false;
  public String s = "-1";
  public String t;
  public String u;
  public String v;
  public int w;
  public String x;
  public String y;
  
  public SplashItem(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, int paramInt2, String paramString6, int paramInt3, String paramString7, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString8, int paramInt4, String paramString9, String paramString10, int paramInt5, String paramString11)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramInt1;
    this.f = paramString5;
    this.g = paramInt2;
    this.h = paramString6;
    this.i = paramInt3;
    this.j = paramString7;
    this.q = paramBoolean1;
    this.r = paramBoolean3;
    this.k = paramString8;
    this.m = paramInt4;
    this.n = paramString9;
    this.o = paramString10;
    this.p = paramInt5;
    this.s = paramString11;
  }
  
  private boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = VasSplashUtil.a(BaseApplicationImpl.getContext(), this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("splash_union_banner_res_path_");
    localStringBuilder.append(paramString);
    paramString = localSharedPreferences.getString(localStringBuilder.toString(), "");
    if (!TextUtils.isEmpty(paramString)) {
      return a(paramString, true);
    }
    return false;
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    try
    {
      paramString = new File(paramString);
      if (paramString.exists())
      {
        if (paramBoolean)
        {
          paramBoolean = paramString.getAbsolutePath().endsWith(".splashtemp");
          return paramBoolean ^ true;
        }
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public boolean a()
  {
    boolean bool1;
    if ((this.r) && (a(this.k, true)) && (d())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (bool1)
    {
      bool2 = bool1;
      if (c())
      {
        bool2 = bool1;
        if (!a(this.b))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("adid [");
          localStringBuilder.append(this.b);
          localStringBuilder.append("] union banner res not ready.");
          QLog.i("QSplash@SplashItem", 1, localStringBuilder.toString());
          bool2 = false;
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adid [");
    localStringBuilder.append(this.b);
    localStringBuilder.append("] shouldSplash ");
    localStringBuilder.append(bool2);
    QLog.i("QSplash@SplashItem", 1, localStringBuilder.toString());
    return bool2;
  }
  
  public boolean b()
  {
    boolean bool;
    if ((!a(this.k, true)) && (!a(this.y, true)) && (!this.q) && (!VasSplashUtil.c(this.d))) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("adid [");
    localStringBuilder.append(this.b);
    localStringBuilder.append("] shouldRequestRes result = ");
    localStringBuilder.append(bool);
    QLog.i("QSplash@VasSplashUtil", 1, localStringBuilder.toString());
    return bool;
  }
  
  public boolean c()
  {
    return ("1".equals(this.s)) || ("2".equals(this.s));
  }
  
  public boolean d()
  {
    int i1 = this.w;
    if (i1 == 0) {
      return true;
    }
    if ((i1 != 1) && (i1 != 2)) {
      return true;
    }
    return a(this.y, true);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SplashADEntry{, mAdID='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mBeginTime='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mEndTime='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContentType=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mDownloadUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mJumpType=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mJumpH5Url='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mExposureUrl='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mResPath='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoPath='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShowpriority:");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isLowerDeviceLimit=");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCanShow=");
    localStringBuilder.append(this.r);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mResTraceinfo=");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mResMD5=");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mShowAdMark=");
    localStringBuilder.append(this.p);
    localStringBuilder.append(", mBannerType=");
    localStringBuilder.append(this.s);
    localStringBuilder.append(", mEntryText=");
    localStringBuilder.append(this.t);
    localStringBuilder.append(", mEntryTextColor=");
    localStringBuilder.append(this.u);
    localStringBuilder.append(", mEntryBgColor=");
    localStringBuilder.append(this.v);
    localStringBuilder.append(", mEntryBtnType=");
    localStringBuilder.append(this.w);
    localStringBuilder.append(", mEntryBtnUrl=");
    localStringBuilder.append(this.x);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vassplash.model.SplashItem
 * JD-Core Version:    0.7.0.1
 */