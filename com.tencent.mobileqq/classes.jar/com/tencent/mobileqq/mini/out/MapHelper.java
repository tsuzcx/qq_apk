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
    this.mAppNameMap.put("com.tencent.map", HardCodeUtil.a(2131706466));
    this.mAppNameMap.put("com.baidu.BaiduMap", HardCodeUtil.a(2131706472));
    this.mActionMap.put("com.tencent.map", Integer.valueOf(1));
    this.mActionMap.put("com.baidu.BaiduMap", Integer.valueOf(2));
    this.mUIHandler = new Handler(Looper.getMainLooper());
  }
  
  public static double getDistance(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble2 = 3.141592653589793D * paramDouble2 / 180.0D;
    paramDouble4 = 3.141592653589793D * paramDouble4 / 180.0D;
    paramDouble3 = (paramDouble1 - paramDouble3) * 3.141592653589793D / 180.0D;
    paramDouble1 = Math.sin((paramDouble2 - paramDouble4) / 2.0D);
    paramDouble3 = Math.sin(paramDouble3 / 2.0D);
    return 6378137.0D * 2.0D * Math.asin(Math.sqrt(Math.cos(paramDouble2) * Math.cos(paramDouble4) * paramDouble3 * paramDouble3 + paramDouble1 * paramDouble1));
  }
  
  public static double[] map_tx2bd(double paramDouble1, double paramDouble2)
  {
    double d = Math.sqrt(paramDouble2 * paramDouble2 + paramDouble1 * paramDouble1) + 2.E-005D * Math.sin(paramDouble1 * 3.141592653589793D);
    paramDouble1 = Math.atan2(paramDouble1, paramDouble2);
    paramDouble1 = Math.cos(3.141592653589793D * paramDouble2) * 3.E-006D + paramDouble1;
    paramDouble2 = Math.cos(paramDouble1);
    return new double[] { Math.sin(paramDouble1) * d + 0.006D, paramDouble2 * d + 0.0065D };
  }
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (this.mActionArray[paramInt])
    {
    }
    for (;;)
    {
      if (this.mActionSheet.isShowing()) {
        this.mActionSheet.dismiss();
      }
      return;
      openQQMapForRoute();
      continue;
      openBaiduMapForRoute();
    }
  }
  
  protected void checkInstalledMapApp()
  {
    long l = System.currentTimeMillis();
    this.mInstalledMapAppSet.clear();
    this.mContext.getPackageManager();
    if (PackageUtil.a(this.mContext, "com.tencent.map")) {
      this.mInstalledMapAppSet.add("com.tencent.map");
    }
    if (PackageUtil.a(this.mContext, "com.baidu.BaiduMap")) {
      this.mInstalledMapAppSet.add("com.baidu.BaiduMap");
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqmap", 2, "checkInstalledMapApp: time=" + (System.currentTimeMillis() - l));
    }
  }
  
  protected void openBaiduMapForRoute()
  {
    String str = "driving";
    if (this.mRouteMode == 0) {
      str = "walking";
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
        QLog.d("Q.qqmap", 2, "openBaiduMapForRoute:" + str);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqmap", 2, "openBaiduMapForRoute:" + (String)localObject1, localException);
    }
  }
  
  protected void openQQMapForRoute()
  {
    Object localObject;
    if (this.mInstalledMapAppSet.contains("com.tencent.map"))
    {
      localObject = "drive";
      if (this.mRouteMode == 0) {
        localObject = "walk";
      }
      localObject = String.format("qqmap://map/routeplan?type=%s&from=%s&fromcoord=%f,%f&to=%s&tocoord=%f,%f&policy=1&referer=qq", new Object[] { localObject, this.mSelfPoiName, Double.valueOf(this.mSelfPoint.getLatitude()), Double.valueOf(this.mSelfPoint.getLongitude()), this.mTargetPoiName, Double.valueOf(this.mTargetPoint.getLatitude()), Double.valueOf(this.mTargetPoint.getLongitude()) });
    }
    do
    {
      try
      {
        Intent localIntent = Intent.parseUri((String)localObject, 0);
        localIntent.addCategory("android.intent.category.BROWSABLE");
        localIntent.setComponent(null);
        localIntent.setSelector(null);
        this.mContext.startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqmap", 2, "openQQMapForRoute:" + (String)localObject);
        }
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqmap", 2, "openQQMapForRoute:" + (String)localObject, localException);
        }
      }
      localObject = new Intent(this.mContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", "https://pr.map.qq.com/j/tmap/download");
      this.mContext.startActivity((Intent)localObject);
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqmap", 2, "openQQMapForRoute, download=https://pr.map.qq.com/j/tmap/download");
  }
  
  protected void openStreetViewMap()
  {
    if (TextUtils.isEmpty(this.mStreetViewUrl))
    {
      QQToast.a(this.mContext.getApplicationContext(), 0, HardCodeUtil.a(2131706468), 1).b(this.mContext.getResources().getDimensionPixelSize(2131299166));
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
    if ((paramLatLng1 == null) || (paramLatLng2 == null))
    {
      QQToast.a(this.mContext, 0, HardCodeUtil.a(2131706471), 1).b(this.mContext.getResources().getDimensionPixelSize(2131299166));
      return;
    }
    this.mSelfPoint = paramLatLng1;
    this.mTargetPoint = paramLatLng2;
    this.mSelfPoiName = paramString1;
    this.mTargetPoiName = paramString2;
    if (TextUtils.isEmpty(this.mSelfPoiName)) {
      this.mSelfPoiName = HardCodeUtil.a(2131706467);
    }
    if (TextUtils.isEmpty(this.mTargetPoiName)) {
      this.mTargetPoiName = HardCodeUtil.a(2131706465);
    }
    double d = getDistance(paramLatLng1.getLongitude(), paramLatLng1.getLatitude(), paramLatLng2.getLongitude(), paramLatLng2.getLatitude());
    if (d > 1000.0D)
    {
      this.mRouteMode = 1;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqmap", 2, "showActionSheet: self=" + paramLatLng1.toString() + ",to=" + paramLatLng2.toString() + ",selfPoi=" + paramString1 + ",toPoi=" + paramString2 + ",distance=" + d);
      }
      checkInstalledMapApp();
      this.mActionSheet = ((ActionSheet)ActionSheetHelper.a(this.mContext, null));
      this.mActionSheet.setOnButtonClickListener(this);
      if (TextUtils.isEmpty(this.mStreetViewUrl)) {
        break label424;
      }
      this.mActionSheet.addButton(HardCodeUtil.a(2131706469));
      this.mActionArray[0] = 0;
    }
    label421:
    label424:
    for (int i = 1;; i = 0)
    {
      this.mActionSheet.addButton(HardCodeUtil.a(2131706470));
      this.mActionArray[i] = 1;
      paramLatLng1 = this.mAppNameMap.entrySet().iterator();
      i += 1;
      label317:
      if (paramLatLng1.hasNext())
      {
        paramString1 = (Map.Entry)paramLatLng1.next();
        paramLatLng2 = (String)paramString1.getKey();
        paramString1 = (String)paramString1.getValue();
        if (!this.mInstalledMapAppSet.contains(paramLatLng2)) {
          break label421;
        }
        this.mActionSheet.addButton(paramString1);
        this.mActionArray[i] = ((Integer)this.mActionMap.get(paramLatLng2)).intValue();
        i += 1;
      }
      for (;;)
      {
        break label317;
        this.mRouteMode = 0;
        break;
        this.mActionSheet.show();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.MapHelper
 * JD-Core Version:    0.7.0.1
 */