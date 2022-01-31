package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.smtt.sdk.WebView;

public class SysCoreQUA2Utils
{
  public static final String DE_DEFAULT = "PHONE";
  public static final String DE_PAD = "PAD";
  public static final String DE_TV = "TV";
  public static final String PB_DEFAULT = "GE";
  public static final String PB_INT = "INT";
  public static final String PB_PAD = "PAD";
  public static final String PB_TMS = "TMS";
  public static final String PB_TV = "TV";
  public static final String PR_DEFAULT = "TRD";
  public static final String PR_QB = "QB";
  public static final String PR_QQ = "QQ";
  public static final String PR_QZ = "QZ";
  public static final String PR_TOS = "TOS";
  public static final String PR_WX = "WX";
  private static final String QB_PACKAGE_NAME = "com.tencent.mtt";
  private static final String QQ_PACKAGE_NAME = "com.tencent.mobileqq";
  private static final String QZONE_PACKAGE_NAME = "com.qzone";
  private static final String WX_PACKAGE_NAME = "com.tencent.mm";
  private static String mCHID;
  private static boolean mIsPad;
  private static boolean mIsTablet = false;
  private static String mLCID;
  private static String mMttQua = null;
  private static String mPB;
  private static String mPPVN;
  private static boolean mPadCheckFinished;
  private static String mVE = "GA";
  
  static
  {
    mPB = "GE";
    mLCID = "9422";
    mCHID = "0";
    mPPVN = "";
    mIsPad = false;
    mPadCheckFinished = false;
  }
  
  private static void appendInfo(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    paramStringBuilder.append("&").append(paramString1).append("=").append(paramString2);
  }
  
  private static String generateQUA2_v3(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = getDeviceWidth(paramContext) + "*" + getDeviceHeight(paramContext);
    for (;;)
    {
      try
      {
        localObject1 = paramContext.getApplicationContext().getApplicationInfo();
        localObject3 = paramContext.getPackageManager().getPackageInfo(((ApplicationInfo)localObject1).packageName, 0);
        localObject1 = ((ApplicationInfo)localObject1).packageName;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException1)
      {
        Object localObject1;
        Object localObject3;
        boolean bool;
        paramString7 = "";
        localNameNotFoundException1.printStackTrace();
        localObject2 = "";
        continue;
        if (isRealPad(paramContext))
        {
          paramContext = "PAD";
          continue;
        }
      }
      try
      {
        bool = TextUtils.isEmpty(paramString7);
        if (bool) {
          continue;
        }
        localObject3 = localObject1;
        localObject1 = paramString7;
        paramString7 = (String)localObject3;
        localObject3 = getPrFromPP(paramString7);
        if (!"QB".equals(localObject3)) {
          continue;
        }
        if (!paramBoolean) {
          break label448;
        }
        paramContext = "PAD";
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException2)
      {
        paramString7 = (String)localObject2;
        localObject2 = localNameNotFoundException2;
        continue;
        paramContext = "PHONE";
        continue;
      }
      localStringBuilder.append("QV").append("=").append("3");
      appendInfo(localStringBuilder, "PL", "ADR");
      appendInfo(localStringBuilder, "PR", (String)localObject3);
      appendInfo(localStringBuilder, "PP", paramString7);
      appendInfo(localStringBuilder, "PPVN", (String)localObject1);
      if (!TextUtils.isEmpty(paramString1)) {
        appendInfo(localStringBuilder, "TBSVC", paramString1);
      }
      appendInfo(localStringBuilder, "CO", "SYS");
      if (!TextUtils.isEmpty(paramString2)) {
        appendInfo(localStringBuilder, "COVC", paramString2);
      }
      appendInfo(localStringBuilder, "PB", paramString4);
      appendInfo(localStringBuilder, "VE", paramString3);
      appendInfo(localStringBuilder, "DE", paramContext);
      paramContext = paramString6;
      if (TextUtils.isEmpty(paramString6)) {
        paramContext = "0";
      }
      appendInfo(localStringBuilder, "CHID", paramContext);
      appendInfo(localStringBuilder, "LCID", paramString5);
      paramContext = getDeviceName();
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        appendInfo(localStringBuilder, "MO", paramContext);
      }
      appendInfo(localStringBuilder, "RL", str);
      paramContext = Build.VERSION.RELEASE;
      try
      {
        paramString1 = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
        paramContext = paramString1;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      if (!TextUtils.isEmpty(paramContext)) {
        appendInfo(localStringBuilder, "OS", paramContext);
      }
      appendInfo(localStringBuilder, "API", Build.VERSION.SDK_INT + "");
      return localStringBuilder.toString();
      paramString7 = ((PackageInfo)localObject3).versionName;
    }
  }
  
  private static int getDensityDpi(Context paramContext)
  {
    Object localObject = (WindowManager)paramContext.getSystemService("window");
    paramContext = new DisplayMetrics();
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    if (localObject != null)
    {
      ((Display)localObject).getMetrics(paramContext);
      return paramContext.densityDpi;
    }
    return 160;
  }
  
  private static int getDeviceHeight(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      return paramContext.getHeight();
    }
    return -1;
  }
  
  private static String getDeviceName()
  {
    return " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", "") + " ";
  }
  
  private static int getDeviceWidth(Context paramContext)
  {
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (paramContext != null) {
      return paramContext.getWidth();
    }
    return -1;
  }
  
  private static String getPrFromPP(String paramString)
  {
    if ("com.tencent.mm".equals(paramString)) {
      return "WX";
    }
    if ("com.tencent.mobileqq".equals(paramString)) {
      return "QQ";
    }
    if ("com.qzone".equals(paramString)) {
      return "QZ";
    }
    if ("com.tencent.mtt".equals(paramString)) {
      return "QB";
    }
    return "TRD";
  }
  
  public static String getQUA2_V3(Context paramContext)
  {
    if (!TextUtils.isEmpty(mMttQua)) {
      return mMttQua;
    }
    mMttQua = generateQUA2_v3(paramContext, String.valueOf(WebView.getTbsSDKVersion(paramContext)), "0", mVE, mPB, mLCID, mCHID, mPPVN, mIsPad);
    return mMttQua;
  }
  
  private static boolean isRealPad(Context paramContext)
  {
    boolean bool = true;
    if (mPadCheckFinished) {
      return mIsTablet;
    }
    try
    {
      if (Math.min(getDeviceWidth(paramContext), getDeviceHeight(paramContext)) * 160 / getDensityDpi(paramContext) >= 700) {}
      for (;;)
      {
        mIsTablet = bool;
        mPadCheckFinished = true;
        return mIsTablet;
        bool = false;
      }
      return false;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.SysCoreQUA2Utils
 * JD-Core Version:    0.7.0.1
 */