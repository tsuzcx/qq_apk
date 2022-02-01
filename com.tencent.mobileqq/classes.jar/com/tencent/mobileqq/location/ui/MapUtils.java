package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class MapUtils
{
  private static Boolean a;
  private static long b;
  
  private static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = b(paramDouble1);
    paramDouble3 = b(paramDouble3);
    paramDouble2 = b(paramDouble2);
    paramDouble4 = b(paramDouble4);
    return Math.asin(Math.sqrt(Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D) + Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D))) * 2.0D * 6378137.0D;
  }
  
  public static double a(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return a(paramLatLng1.latitude, paramLatLng1.longitude, paramLatLng2.latitude, paramLatLng2.longitude);
  }
  
  static int a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      try
      {
        i = Settings.Secure.getInt(paramContext.getContentResolver(), "location_mode");
      }
      catch (Settings.SettingNotFoundException paramContext)
      {
        paramContext.printStackTrace();
        break label46;
      }
    }
    else
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "location_providers_allowed");
      if (!TextUtils.isEmpty(paramContext)) {
        break label51;
      }
    }
    label46:
    label51:
    do
    {
      i = 0;
      break;
      if ((paramContext.contains("gps")) && (paramContext.contains("network")))
      {
        i = 3;
        break;
      }
      if (paramContext.contains("gps"))
      {
        i = 1;
        break;
      }
    } while (!paramContext.contains("network"));
    int i = 2;
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getLocationMode: invoked. locationMode: ");
      paramContext.append(i);
      QLog.d("MapUtils", 2, paramContext.toString());
    }
    return i;
  }
  
  public static LatLng a(Collection<LocationItem> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(((LocationItem)paramCollection.next()).a());
    }
    return a(localArrayList);
  }
  
  private static LatLng a(List<LatLng> paramList)
  {
    int i = paramList.size();
    paramList = paramList.iterator();
    double d3 = 0.0D;
    double d2 = 0.0D;
    double d8;
    for (double d1 = d2; paramList.hasNext(); d1 += d8)
    {
      LatLng localLatLng = (LatLng)paramList.next();
      d8 = localLatLng.getLatitude() * 3.141592653589793D / 180.0D;
      double d7 = localLatLng.getLongitude() * 3.141592653589793D / 180.0D;
      double d5 = Math.cos(d8);
      double d6 = Math.cos(d7);
      d4 = Math.cos(d8);
      d7 = Math.sin(d7);
      d8 = Math.sin(d8);
      d3 += d5 * d6;
      d2 += d4 * d7;
    }
    double d4 = i;
    Double.isNaN(d4);
    d3 /= d4;
    Double.isNaN(d4);
    d2 /= d4;
    Double.isNaN(d4);
    d1 /= d4;
    d4 = Math.atan2(d2, d3);
    return new LatLng(Math.atan2(d1, Math.sqrt(d3 * d3 + d2 * d2)) * 180.0D / 3.141592653589793D, d4 * 180.0D / 3.141592653589793D);
  }
  
  private static Object a(Object paramObject, String paramString)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      paramString = paramObject.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      return paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject.printStackTrace();
      return null;
    }
    catch (NoSuchFieldException paramObject)
    {
      paramObject.printStackTrace();
    }
    return null;
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble < 60.0D)
    {
      if (Math.round(paramDouble) <= 0L) {
        i = 1;
      } else {
        i = (int)Math.round(paramDouble);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("分钟");
      return localStringBuilder.toString();
    }
    if (paramDouble < 1440.0D)
    {
      i = (int)(paramDouble / 60.0D);
      d1 = i * 60;
      Double.isNaN(d1);
      j = (int)Math.round(paramDouble - d1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("小时");
      localStringBuilder.append(j);
      localStringBuilder.append("分钟");
      return localStringBuilder.toString();
    }
    int i = (int)(paramDouble / 1440.0D);
    double d1 = paramDouble / 60.0D;
    int k = i * 24;
    double d2 = k;
    Double.isNaN(d2);
    int j = (int)(d1 - d2);
    d1 = j * 60;
    Double.isNaN(d1);
    d2 = k * 60;
    Double.isNaN(d2);
    k = (int)Math.round(paramDouble - d1 - d2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("天");
    localStringBuilder.append(j);
    localStringBuilder.append("小时");
    localStringBuilder.append(k);
    localStringBuilder.append("分钟");
    return localStringBuilder.toString();
  }
  
  public static void a()
  {
    a = null;
  }
  
  static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if (b())
    {
      String str = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&policy=1&referer=qq", new Object[] { paramString1, paramString2, Double.valueOf(paramLatLng1.latitude), Double.valueOf(paramLatLng1.longitude), paramString3, Double.valueOf(paramLatLng2.latitude), Double.valueOf(paramLatLng2.longitude) });
      try
      {
        Object localObject = Intent.parseUri(str, 0);
        ((Intent)localObject).addCategory("android.intent.category.BROWSABLE");
        ((Intent)localObject).setComponent(null);
        ((Intent)localObject).setSelector(null);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_location_share");
        paramActivity.startActivity((Intent)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("launchQQMap: ");
          ((StringBuilder)localObject).append(str);
          QLog.d("Q.qqmap", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("launchQQMap: ");
          localStringBuilder.append(str);
          QLog.w("Q.qqmap", 2, localStringBuilder.toString(), localException);
        }
        ReportController.b(null, "CliOper", "", "", "0X800A972", "0X800A972", 1, 0, "0", "0", "0", "");
      }
    }
    else
    {
      ReportController.b(null, "CliOper", "", "", "0X800A972", "0X800A972", 2, 0, "0", "0", "0", "");
    }
    try
    {
      paramString1 = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&referer=qq", new Object[] { paramString1, paramString2, Double.valueOf(paramLatLng1.latitude), Double.valueOf(paramLatLng1.longitude), paramString3, Double.valueOf(paramLatLng2.latitude), Double.valueOf(paramLatLng2.longitude) });
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("launchQQMap, mapparam = ");
        paramString2.append(paramString1);
        QLog.d("Q.qqmap", 2, paramString2.toString());
      }
      paramString1 = URLEncoder.encode(paramString1, "UTF-8");
      paramString2 = new StringBuilder();
      paramString2.append("https://mapdownload.map.qq.com/outindex?key=qq&referer=qq2&channel=10041881%2C10041882&intention=");
      paramString2.append(paramString1);
      paramString1 = paramString2.toString();
      a(paramActivity, paramString1);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("launchQQMap, download = ");
        paramString2.append(paramString1);
        QLog.d("Q.qqmap", 2, paramString2.toString());
      }
      return;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
      a(paramActivity, "https://mapdownload.map.qq.com/outindex?key=qq&referer=qq2&channel=10041881%2C10041882");
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqmap", 2, "launchQQMap, download = https://mapdownload.map.qq.com/outindex?key=qq&referer=qq2&channel=10041881%2C10041882");
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext = new ActivityURIRequest(paramContext, "/base/browser");
    paramContext.extra().putString("url", paramString);
    paramContext.extra().putString("big_brother_source_key", "biz_src_location_share");
    QRoute.startUri(paramContext, null);
  }
  
  public static void a(View paramView, String paramString)
  {
    if (AppSetting.e) {
      paramView.setContentDescription(paramString);
    }
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
    localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString, localURLDrawableOptions));
  }
  
  static void a(TencentMap paramTencentMap)
  {
    if (paramTencentMap != null)
    {
      paramTencentMap = a(a(a(paramTencentMap, "m"), "a"), "b");
      a(a(paramTencentMap, "b"), "b", null);
      paramTencentMap = a(paramTencentMap, "u");
      if ((paramTencentMap instanceof List)) {
        ((List)paramTencentMap).clear();
      }
    }
  }
  
  static void a(TencentMap paramTencentMap, int paramInt)
  {
    if (paramTencentMap != null)
    {
      paramTencentMap = a(a(a(a(paramTencentMap.getUiSettings(), "a"), "a"), "d"), "W");
      if ((paramTencentMap instanceof ViewGroup)) {
        ((ViewGroup)paramTencentMap).setVisibility(paramInt);
      }
    }
  }
  
  private static void a(Object paramObject1, String paramString, Object paramObject2)
  {
    if (paramObject1 == null) {
      return;
    }
    try
    {
      paramString = paramObject1.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString.set(paramObject1, paramObject2);
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      paramObject1.printStackTrace();
      return;
    }
    catch (NoSuchFieldException paramObject1)
    {
      paramObject1.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2, TextView paramTextView)
  {
    if (paramTextView.getWidth() == 0)
    {
      paramTextView.post(new MapUtils.1(paramString1, paramString2, paramTextView));
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(paramString2);
    localObject = ((StringBuilder)localObject).toString();
    float f2 = paramTextView.getWidth();
    float f1 = paramTextView.getPaint().measureText(paramString1);
    float f3 = paramTextView.getPaint().measureText(paramString2);
    if (f1 + f3 <= f2)
    {
      paramTextView.setText((CharSequence)localObject);
      return;
    }
    float f4 = paramTextView.getPaint().measureText("...");
    while ((f1 + f4 + f3 > f2) && (paramString1.length() > 0))
    {
      paramString1 = paramString1.substring(0, paramString1.length() - 1);
      f1 = paramTextView.getPaint().measureText(paramString1);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("...");
    ((StringBuilder)localObject).append(paramString2);
    paramTextView.setText(((StringBuilder)localObject).toString());
  }
  
  static boolean a(Context paramContext, TencentMap paramTencentMap, LatLng paramLatLng)
  {
    int i = paramContext.getResources().getDisplayMetrics().heightPixels;
    paramContext = new Rect(0, 0, paramContext.getResources().getDisplayMetrics().widthPixels, i);
    paramTencentMap = paramTencentMap.getProjection();
    if (paramTencentMap == null) {
      return false;
    }
    paramTencentMap = paramTencentMap.toScreenLocation(paramLatLng);
    boolean bool = paramContext.contains(paramTencentMap.x, paramTencentMap.y);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("[map][init]isLocationInScreen: invoked. location: ");
      paramContext.append(paramLatLng);
      paramContext.append(" screen: ");
      paramContext.append(paramTencentMap);
      paramContext.append(" inScreen: ");
      paramContext.append(bool);
      QLog.d("MapUtils", 2, paramContext.toString());
    }
    return bool;
  }
  
  private static double b(double paramDouble)
  {
    return paramDouble * 3.141592653589793D / 180.0D;
  }
  
  static boolean b()
  {
    if (a == null) {
      a = Boolean.valueOf(PackageUtil.a(MobileQQ.sMobileQQ, "com.tencent.map"));
    }
    return a.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapUtils
 * JD-Core Version:    0.7.0.1
 */