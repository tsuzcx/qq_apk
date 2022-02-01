package com.tencent.mobileqq.mini.out;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.pm.PackageUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class MapHelper
  implements ActionSheet.OnButtonClickListener
{
  public static final int ACTION_BAIDU_MAP = 2;
  public static final int ACTION_STREET = 0;
  public static final int ACTION_TENCENT_MAP = 1;
  public static final String BAIDU_PKGNAME = "com.baidu.BaiduMap";
  protected static final int DRAVING = 1;
  public static final String QQMAP_DOWNLOAD_URL = "https://pr.map.qq.com/j/tmap/download";
  public static final String QQMAP_PKGNAME = "com.tencent.map";
  protected static final int WALKING = 0;
  protected int[] mActionArray = new int[6];
  protected HashMap<String, Integer> mActionMap = new HashMap();
  protected ActionSheet mActionSheet = null;
  protected LinkedHashMap<String, String> mAppNameMap = new LinkedHashMap();
  protected Context mContext;
  protected HashSet<String> mInstalledMapAppSet = new HashSet();
  protected int mRouteMode = 0;
  protected String mSelfPoiName;
  protected LatLng mSelfPoint;
  private String mStreetViewUrl;
  protected String mTargetPoiName;
  protected LatLng mTargetPoint;
  protected Handler mUIHandler;
  
  public MapHelper(Context paramContext)
  {
    this.mContext = paramContext;
    this.mAppNameMap.put("com.tencent.map", HardCodeUtil.a(2131904369));
    this.mAppNameMap.put("com.baidu.BaiduMap", HardCodeUtil.a(2131904375));
    this.mActionMap.put("com.tencent.map", Integer.valueOf(1));
    this.mActionMap.put("com.baidu.BaiduMap", Integer.valueOf(2));
    this.mUIHandler = new Handler(Looper.getMainLooper());
  }
  
  public static double getDistance(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble2 = paramDouble2 * 3.141592653589793D / 180.0D;
    paramDouble4 = paramDouble4 * 3.141592653589793D / 180.0D;
    paramDouble3 = (paramDouble1 - paramDouble3) * 3.141592653589793D / 180.0D;
    paramDouble1 = Math.sin((paramDouble2 - paramDouble4) / 2.0D);
    paramDouble3 = Math.sin(paramDouble3 / 2.0D);
    return 12756274.0D * Math.asin(Math.sqrt(paramDouble1 * paramDouble1 + Math.cos(paramDouble2) * Math.cos(paramDouble4) * paramDouble3 * paramDouble3));
  }
  
  public static double[] map_tx2bd(double paramDouble1, double paramDouble2)
  {
    double d = Math.sqrt(paramDouble2 * paramDouble2 + paramDouble1 * paramDouble1) + Math.sin(paramDouble1 * 3.141592653589793D) * 2.E-005D;
    paramDouble1 = Math.atan2(paramDouble1, paramDouble2) + Math.cos(paramDouble2 * 3.141592653589793D) * 3.E-006D;
    paramDouble2 = Math.cos(paramDouble1);
    return new double[] { d * Math.sin(paramDouble1) + 0.006D, paramDouble2 * d + 0.0065D };
  }
  
  protected void checkInstalledMapApp()
  {
    long l = System.currentTimeMillis();
    this.mInstalledMapAppSet.clear();
    this.mContext.getPackageManager();
    if (PackageUtil.d(this.mContext, "com.tencent.map")) {
      this.mInstalledMapAppSet.add("com.tencent.map");
    }
    if (PackageUtil.d(this.mContext, "com.baidu.BaiduMap")) {
      this.mInstalledMapAppSet.add("com.baidu.BaiduMap");
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkInstalledMapApp: time=");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d("Q.qqmap", 2, localStringBuilder.toString());
    }
  }
  
  public void onClick(View paramView, int paramInt)
  {
    paramInt = this.mActionArray[paramInt];
    if (paramInt != 1)
    {
      if (paramInt == 2) {
        openBaiduMapForRoute();
      }
    }
    else {
      openQQMapForRoute();
    }
    if (this.mActionSheet.isShowing()) {
      this.mActionSheet.dismiss();
    }
  }
  
  protected void openBaiduMapForRoute()
  {
    String str;
    if (this.mRouteMode == 0) {
      str = "walking";
    } else {
      str = "driving";
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    try
    {
      double[] arrayOfDouble1 = map_tx2bd(this.mSelfPoint.getLatitude(), this.mSelfPoint.getLongitude());
      localObject1 = localObject2;
      double[] arrayOfDouble2 = map_tx2bd(this.mTargetPoint.getLatitude(), this.mTargetPoint.getLongitude());
      localObject1 = localObject2;
      str = String.format("intent://map/direction?origin=latlng:%f,%f|name:%s&destination=latlng:%f,%f|name:%s&mode=%s&src=src=thirdapp.navi.yourCompanyName.yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end", new Object[] { Double.valueOf(arrayOfDouble1[0]), Double.valueOf(arrayOfDouble1[1]), this.mSelfPoiName, Double.valueOf(arrayOfDouble2[0]), Double.valueOf(arrayOfDouble2[1]), this.mTargetPoiName, str });
      localObject1 = str;
      localObject2 = Intent.getIntent(str);
      localObject1 = str;
      ((Intent)localObject2).addCategory("android.intent.category.BROWSABLE");
      localObject1 = str;
      ((Intent)localObject2).setComponent(null);
      localObject1 = str;
      ((Intent)localObject2).setSelector(null);
      localObject1 = str;
      this.mContext.startActivity((Intent)localObject2);
      localObject1 = str;
      if (QLog.isColorLevel())
      {
        localObject1 = str;
        localObject2 = new StringBuilder();
        localObject1 = str;
        ((StringBuilder)localObject2).append("openBaiduMapForRoute:");
        localObject1 = str;
        ((StringBuilder)localObject2).append(str);
        localObject1 = str;
        QLog.d("Q.qqmap", 2, ((StringBuilder)localObject2).toString());
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("openBaiduMapForRoute:");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.w("Q.qqmap", 2, ((StringBuilder)localObject2).toString(), localException);
      }
    }
  }
  
  protected void openQQMapForRoute()
  {
    if (this.mInstalledMapAppSet.contains("com.tencent.map"))
    {
      if (this.mRouteMode == 0) {
        localObject1 = "walk";
      } else {
        localObject1 = "drive";
      }
      localObject1 = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&policy=1&referer=qq", new Object[] { localObject1, this.mSelfPoiName, Double.valueOf(this.mSelfPoint.getLatitude()), Double.valueOf(this.mSelfPoint.getLongitude()), this.mTargetPoiName, Double.valueOf(this.mTargetPoint.getLatitude()), Double.valueOf(this.mTargetPoint.getLongitude()) });
      try
      {
        Object localObject2 = Intent.parseUri((String)localObject1, 0);
        ((Intent)localObject2).addCategory("android.intent.category.BROWSABLE");
        ((Intent)localObject2).setComponent(null);
        ((Intent)localObject2).setSelector(null);
        this.mContext.startActivity((Intent)localObject2);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("openQQMapForRoute:");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("Q.qqmap", 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("openQQMapForRoute:");
          localStringBuilder.append((String)localObject1);
          QLog.w("Q.qqmap", 2, localStringBuilder.toString(), localException);
        }
      }
    }
    Object localObject1 = new Intent(this.mContext, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", "https://pr.map.qq.com/j/tmap/download");
    this.mContext.startActivity((Intent)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "openQQMapForRoute, download=https://pr.map.qq.com/j/tmap/download");
    }
  }
  
  protected void openStreetViewMap()
  {
    if (TextUtils.isEmpty(this.mStreetViewUrl))
    {
      QQToast.makeText(this.mContext.getApplicationContext(), 0, HardCodeUtil.a(2131904371), 1).show(this.mContext.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    Intent localIntent = new Intent(this.mContext, QQBrowserActivity.class);
    localIntent.putExtra("url", this.mStreetViewUrl);
    localIntent.putExtra("reqType", 4);
    this.mContext.startActivity(localIntent);
  }
  
  public void setStreetViewUrl(String paramString)
  {
    this.mStreetViewUrl = paramString;
  }
  
  public void showActionSheet(LatLng paramLatLng1, LatLng paramLatLng2, String paramString1, String paramString2)
  {
    int i = 0;
    if ((paramLatLng1 != null) && (paramLatLng2 != null))
    {
      this.mSelfPoint = paramLatLng1;
      this.mTargetPoint = paramLatLng2;
      this.mSelfPoiName = paramString1;
      this.mTargetPoiName = paramString2;
      if (TextUtils.isEmpty(this.mSelfPoiName)) {
        this.mSelfPoiName = HardCodeUtil.a(2131904370);
      }
      if (TextUtils.isEmpty(this.mTargetPoiName)) {
        this.mTargetPoiName = HardCodeUtil.a(2131904368);
      }
      double d = getDistance(paramLatLng1.getLongitude(), paramLatLng1.getLatitude(), paramLatLng2.getLongitude(), paramLatLng2.getLatitude());
      if (d > 1000.0D) {
        this.mRouteMode = 1;
      } else {
        this.mRouteMode = 0;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showActionSheet: self=");
        localStringBuilder.append(paramLatLng1.toString());
        localStringBuilder.append(",to=");
        localStringBuilder.append(paramLatLng2.toString());
        localStringBuilder.append(",selfPoi=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(",toPoi=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(",distance=");
        localStringBuilder.append(d);
        QLog.d("Q.qqmap", 2, localStringBuilder.toString());
      }
      checkInstalledMapApp();
      this.mActionSheet = ((ActionSheet)ActionSheetHelper.b(this.mContext, null));
      this.mActionSheet.setOnButtonClickListener(this);
      if (!TextUtils.isEmpty(this.mStreetViewUrl))
      {
        this.mActionSheet.addButton(HardCodeUtil.a(2131904372));
        this.mActionArray[0] = 0;
        i = 1;
      }
      this.mActionSheet.addButton(HardCodeUtil.a(2131904373));
      paramLatLng1 = this.mActionArray;
      int j = i + 1;
      paramLatLng1[i] = 1;
      paramLatLng1 = this.mAppNameMap.entrySet().iterator();
      i = j;
      while (paramLatLng1.hasNext())
      {
        paramString1 = (Map.Entry)paramLatLng1.next();
        paramLatLng2 = (String)paramString1.getKey();
        paramString1 = (String)paramString1.getValue();
        if (this.mInstalledMapAppSet.contains(paramLatLng2))
        {
          this.mActionSheet.addButton(paramString1);
          this.mActionArray[i] = ((Integer)this.mActionMap.get(paramLatLng2)).intValue();
          i += 1;
        }
      }
      this.mActionSheet.show();
      return;
    }
    QQToast.makeText(this.mContext, 0, HardCodeUtil.a(2131904374), 1).show(this.mContext.getResources().getDimensionPixelSize(2131299920));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.MapHelper
 * JD-Core Version:    0.7.0.1
 */