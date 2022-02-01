package com.tencent.viola.ui.dom.style;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.utils.ViolaLogUtils;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class FlexConvertUtils
{
  public static String TAG = "FlexConvertUtils";
  private static String deviceid = "";
  private static int mScreenContentHeight = 0;
  private static int mScreenHeight = 0;
  private static int mScreenWidth = 0;
  private static final boolean mUseWebPx = false;
  
  public static int converColor(String paramString)
  {
    return converColor(paramString, -2147483648);
  }
  
  public static int converColor(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramInt;
    }
    paramString.trim();
    return paramInt;
  }
  
  public static FlexPositionType converPosition(String paramString)
  {
    FlexPositionType localFlexPositionType = FlexPositionType.RELATIVE;
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("relative")) && (!paramString.equals("sticky")))
    {
      if ((paramString.equals("absolute")) || (paramString.equals("fixed"))) {
        return FlexPositionType.ABSOLUTE;
      }
    }
    else {
      localFlexPositionType = FlexPositionType.RELATIVE;
    }
    return localFlexPositionType;
  }
  
  public static float converPxByViewportToRealPx(Object paramObject, int paramInt)
  {
    return getFloatByViewport(paramObject, paramInt);
  }
  
  public static int[] converStringArrayToIntArray(String paramString)
  {
    int[] arrayOfInt = new int[4];
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length == 4))
      {
        int i = 0;
        while (i < paramString.length)
        {
          arrayOfInt[i] = ((int)converPxByViewportToRealPx(paramString[i], 750));
          i += 1;
        }
      }
    }
    return arrayOfInt;
  }
  
  public static String[] converTransFormScaleToStringArray(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramString1 = paramString1.replace(paramString2, "").replace(paramString3, "");
    if (TextUtils.isEmpty(paramString4)) {
      return new String[] { paramString1 };
    }
    return paramString1.split(paramString4);
  }
  
  public static String[] converTransformOriginStringToStringArray(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString.trim();
    return paramString.split("\\s+");
  }
  
  public static FlexAlign convertAlignItem(String paramString)
  {
    FlexAlign localFlexAlign = FlexAlign.STRETCH;
    if (TextUtils.isEmpty(paramString)) {
      return FlexAlign.STRETCH;
    }
    if (paramString.equals("stretch")) {
      return FlexAlign.STRETCH;
    }
    if (paramString.equals("flex-start")) {
      return FlexAlign.FLEX_START;
    }
    if (paramString.equals("flex-end")) {
      return FlexAlign.FLEX_END;
    }
    if (paramString.equals("center")) {
      localFlexAlign = FlexAlign.CENTER;
    }
    return localFlexAlign;
  }
  
  public static FlexAlign convertAlignSelf(String paramString)
  {
    FlexAlign localFlexAlign = FlexAlign.AUTO;
    if (TextUtils.isEmpty(paramString)) {
      return FlexAlign.AUTO;
    }
    if (paramString.equals("flex-start")) {
      return FlexAlign.FLEX_START;
    }
    if (paramString.equals("flex-end")) {
      return FlexAlign.FLEX_END;
    }
    if (paramString.equals("stretch")) {
      return FlexAlign.STRETCH;
    }
    if (paramString.equals("center")) {
      localFlexAlign = FlexAlign.CENTER;
    }
    return localFlexAlign;
  }
  
  public static FlexDirection convertDirection(String paramString)
  {
    FlexDirection localFlexDirection = FlexDirection.COLUMN;
    if (TextUtils.isEmpty(paramString)) {
      return FlexDirection.COLUMN;
    }
    if (paramString.equals("column")) {
      return FlexDirection.COLUMN;
    }
    if (paramString.equals("column-reverse")) {
      return FlexDirection.COLUMN_REVERSE;
    }
    if (paramString.equals("row")) {
      return FlexDirection.ROW;
    }
    if (paramString.equals("row-reverse")) {
      localFlexDirection = FlexDirection.ROW_REVERSE;
    }
    return localFlexDirection;
  }
  
  public static ImageSpanAlign convertImageSpanAlign(String paramString)
  {
    ImageSpanAlign localImageSpanAlign = ImageSpanAlign.BASELINE;
    if (TextUtils.isEmpty(paramString)) {
      return ImageSpanAlign.BASELINE;
    }
    if (paramString.equals("top")) {
      return ImageSpanAlign.TOP;
    }
    if (paramString.equals("bottom")) {
      return ImageSpanAlign.BOTTOM;
    }
    if (paramString.equals("center")) {
      localImageSpanAlign = ImageSpanAlign.CENTER;
    }
    return localImageSpanAlign;
  }
  
  public static FlexJustifyContent convertJustifyContent(String paramString)
  {
    FlexJustifyContent localFlexJustifyContent = FlexJustifyContent.FLEX_START;
    if (TextUtils.isEmpty(paramString)) {
      return FlexJustifyContent.FLEX_START;
    }
    if (paramString.equals("flex-start")) {
      return FlexJustifyContent.FLEX_START;
    }
    if (paramString.equals("flex-end")) {
      return FlexJustifyContent.FLEX_END;
    }
    if (paramString.equals("center")) {
      return FlexJustifyContent.CENTER;
    }
    if (paramString.equals("space-between")) {
      return FlexJustifyContent.SPACE_BETWEEN;
    }
    if (paramString.equals("space-around")) {
      localFlexJustifyContent = FlexJustifyContent.SPACE_AROUND;
    }
    return localFlexJustifyContent;
  }
  
  public static FlexWrap convertWrap(String paramString)
  {
    FlexWrap localFlexWrap = FlexWrap.NOWRAP;
    if (TextUtils.isEmpty(paramString)) {
      return FlexWrap.NOWRAP;
    }
    if (paramString.equals("nowrap")) {
      return FlexWrap.NOWRAP;
    }
    if (paramString.equals("wrap")) {
      localFlexWrap = FlexWrap.WRAP;
    }
    return localFlexWrap;
  }
  
  public static int dip2px(float paramFloat)
  {
    try
    {
      f = ViolaEnvironment.getApplication().getResources().getDisplayMetrics().density;
    }
    catch (Exception localException)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception e:");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e(str, localStringBuilder.toString());
      f = 2.0F;
    }
    float f = f * paramFloat + 0.5F;
    if (paramFloat == 0.0F) {
      f = 0.0F;
    }
    if ((f > 0.0F) && (f < 1.0F)) {
      return 1;
    }
    return (int)f;
  }
  
  public static int dip2px(int paramInt)
  {
    try
    {
      f = ViolaEnvironment.getApplication().getResources().getDisplayMetrics().density;
    }
    catch (Exception localException)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception e:");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e(str, localStringBuilder.toString());
      f = 2.0F;
    }
    float f = paramInt * f;
    if ((f > 0.0F) && (f < 1.0F)) {
      return 1;
    }
    return (int)f;
  }
  
  public static float getFloatByViewport(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      return (0.0F / 0.0F);
    }
    paramObject = paramObject.toString().trim();
    if ((!"auto".equals(paramObject)) && (!"undefined".equals(paramObject)))
    {
      if (TextUtils.isEmpty(paramObject)) {
        return (0.0F / 0.0F);
      }
      float f;
      String str;
      StringBuilder localStringBuilder;
      if (paramObject.endsWith("vx")) {
        try
        {
          f = transferVxToViewPortPx(paramObject, paramInt);
          return f;
        }
        catch (Exception paramObject)
        {
          str = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFloatByViewport Exception e:");
          localStringBuilder.append(paramObject.getMessage());
          ViolaLogUtils.e(str, localStringBuilder.toString());
          return (0.0F / 0.0F);
        }
        catch (NumberFormatException paramObject)
        {
          str = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFloatByViewport NumberFormatException e:");
          localStringBuilder.append(paramObject.getMessage());
          ViolaLogUtils.e(str, localStringBuilder.toString());
          return (0.0F / 0.0F);
        }
      }
      if (paramObject.endsWith("px"))
      {
        try
        {
          f = Float.parseFloat(paramObject.substring(0, paramObject.indexOf("px")));
          return f;
        }
        catch (Exception paramObject) {}catch (NumberFormatException paramObject)
        {
          break label233;
        }
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFloatByViewport Exception e:");
        localStringBuilder.append(paramObject.getMessage());
        ViolaLogUtils.e(str, localStringBuilder.toString());
        return (0.0F / 0.0F);
        label233:
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFloatByViewport NumberFormatException e:");
        localStringBuilder.append(paramObject.getMessage());
        ViolaLogUtils.e(str, localStringBuilder.toString());
        return (0.0F / 0.0F);
      }
      if (paramObject.endsWith("dp"))
      {
        try
        {
          paramInt = dip2px(Float.parseFloat(paramObject.substring(0, paramObject.indexOf("dp"))));
          return paramInt;
        }
        catch (Exception paramObject) {}catch (NumberFormatException paramObject)
        {
          break label361;
        }
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFloatByViewport Exception e:");
        localStringBuilder.append(paramObject.getMessage());
        ViolaLogUtils.e(str, localStringBuilder.toString());
        return (0.0F / 0.0F);
        label361:
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFloatByViewport NumberFormatException e:");
        localStringBuilder.append(paramObject.getMessage());
        ViolaLogUtils.e(str, localStringBuilder.toString());
        return (0.0F / 0.0F);
      }
      if (paramObject.endsWith("vw")) {
        try
        {
          paramObject = paramObject.substring(0, paramObject.indexOf("vw"));
          f = getRealPxByWidth(paramInt * Float.parseFloat(paramObject) / 100.0F, paramInt);
          return f;
        }
        catch (Exception paramObject)
        {
          str = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFloatByViewport Exception e:");
          localStringBuilder.append(paramObject.getMessage());
          ViolaLogUtils.e(str, localStringBuilder.toString());
          return (0.0F / 0.0F);
        }
      }
      if (paramObject.endsWith("rt")) {
        try
        {
          f = getRealPxByWidth(Float.parseFloat(paramObject.substring(0, paramObject.indexOf("rt"))), paramInt);
          return f;
        }
        catch (Exception paramObject)
        {
          str = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFloatByViewport Exception e:");
          localStringBuilder.append(paramObject.getMessage());
          ViolaLogUtils.e(str, localStringBuilder.toString());
          return (0.0F / 0.0F);
        }
      }
      try
      {
        f = getRealPxByWidth(Float.parseFloat(paramObject), paramInt);
        return f;
      }
      catch (Exception paramObject)
      {
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFloatByViewport Exception e:");
        localStringBuilder.append(paramObject.getMessage());
        ViolaLogUtils.e(str, localStringBuilder.toString());
        return (0.0F / 0.0F);
      }
      catch (NumberFormatException paramObject)
      {
        str = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFloatByViewport NumberFormatException e:");
        localStringBuilder.append(paramObject.getMessage());
        ViolaLogUtils.e(str, localStringBuilder.toString());
      }
    }
    return (0.0F / 0.0F);
  }
  
  @SuppressLint({"MissingPermission"})
  public static String getIMEI()
  {
    Object localObject = deviceid;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      return deviceid;
    }
    try
    {
      localObject = (TelephonyManager)ViolaEnvironment.sApplication.getSystemService("phone");
      if (Build.VERSION.SDK_INT >= 26) {
        break label63;
      }
      deviceid = ((TelephonyManager)localObject).getDeviceId();
    }
    catch (SecurityException localSecurityException)
    {
      break label58;
    }
    catch (Throwable localThrowable)
    {
      label50:
      break label50;
    }
    deviceid = "";
    break label63;
    label58:
    deviceid = "";
    label63:
    return deviceid;
  }
  
  public static float getRealPxByWidth(float paramFloat, int paramInt)
  {
    if (Float.isNaN(paramFloat)) {
      return paramFloat;
    }
    paramFloat = paramFloat * getScreenWidth() / paramInt;
    double d = paramFloat;
    if ((d > 0.005D) && (paramFloat < 1.0F)) {
      return 1.0F;
    }
    return (float)Math.rint(d);
  }
  
  public static int getScreenContentHeight()
  {
    return getScreenContentHeight(ViolaEnvironment.sApplication);
  }
  
  public static int getScreenContentHeight(Context paramContext)
  {
    if ((paramContext != null) && (mScreenContentHeight == 0))
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      mScreenContentHeight = localDisplayMetrics.heightPixels;
    }
    return mScreenContentHeight;
  }
  
  public static int getScreenHeight()
  {
    return Math.max(getScreenWidth(ViolaEnvironment.sApplication), getScreenHeight(ViolaEnvironment.sApplication));
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    if ((paramContext != null) && (mScreenHeight == 0))
    {
      mScreenHeight = paramContext.getResources().getDisplayMetrics().heightPixels;
      if (Build.VERSION.SDK_INT > 16)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
        mScreenHeight = localDisplayMetrics.heightPixels;
      }
    }
    return mScreenHeight;
  }
  
  public static int getScreenWidth()
  {
    return Math.min(getScreenWidth(ViolaEnvironment.sApplication), getScreenHeight(ViolaEnvironment.sApplication));
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if ((paramContext != null) && (mScreenWidth == 0))
    {
      mScreenWidth = paramContext.getResources().getDisplayMetrics().widthPixels;
      if (Build.VERSION.SDK_INT > 16)
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
        mScreenWidth = localDisplayMetrics.widthPixels;
      }
    }
    return mScreenWidth;
  }
  
  public static float px2dip(float paramFloat)
  {
    float f2 = 2.0F;
    float f1;
    Object localObject;
    StringBuilder localStringBuilder;
    try
    {
      f1 = ViolaEnvironment.getApplication().getResources().getDisplayMetrics().density;
    }
    catch (Exception localException1)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception e:");
      localStringBuilder.append(localException1.getMessage());
      ViolaLogUtils.e((String)localObject, localStringBuilder.toString());
      f1 = 2.0F;
    }
    if (f1 == 0.0F) {
      f1 = f2;
    }
    try
    {
      DecimalFormat localDecimalFormat = new DecimalFormat("0.00");
      localObject = new DecimalFormatSymbols();
      ((DecimalFormatSymbols)localObject).setDecimalSeparator('.');
      localDecimalFormat.setDecimalFormatSymbols((DecimalFormatSymbols)localObject);
      f1 = Float.valueOf(localDecimalFormat.format(paramFloat / f1)).floatValue();
      return f1;
    }
    catch (Exception localException2)
    {
      localObject = TAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[px2dip]: ");
      localStringBuilder.append(localException2.getMessage());
      ViolaLogUtils.e((String)localObject, localStringBuilder.toString());
    }
    return paramFloat;
  }
  
  public static int sp2px(float paramFloat)
  {
    float f;
    try
    {
      f = ViolaEnvironment.getApplication().getResources().getDisplayMetrics().scaledDensity;
    }
    catch (Exception localException)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Exception e:");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e(str, localStringBuilder.toString());
      f = 2.0F;
    }
    paramFloat = paramFloat * f + 0.5F;
    if ((paramFloat > 0.0F) && (paramFloat < 1.0F)) {
      return 1;
    }
    return (int)paramFloat;
  }
  
  public static int transRealPxToWebDp(int paramInt1, int paramInt2)
  {
    return paramInt1 * paramInt2 / getScreenWidth();
  }
  
  public static float transferVxToViewPortPx(String paramString, int paramInt)
  {
    if (paramString.isEmpty()) {
      return 0.0F;
    }
    String str = paramString;
    if (paramString.endsWith("vx")) {
      str = paramString.substring(0, paramString.indexOf("vx"));
    }
    return Float.valueOf(Float.parseFloat(str)).floatValue() * paramInt / getScreenWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.style.FlexConvertUtils
 * JD-Core Version:    0.7.0.1
 */