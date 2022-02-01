package com.tencent.mobileqq.microapp.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static final List a;
  public static final HashMap b;
  public static final HashMap c;
  public static final HashMap d;
  private static final HashMap g = new HashMap();
  private SharedPreferences e;
  private int f = 60;
  
  static
  {
    a = new ArrayList();
    b = new HashMap();
    c = new HashMap();
    d = new HashMap();
    c.put("chooseLocation", "android.permission.ACCESS_FINE_LOCATION");
    c.put("openLocation", "android.permission.ACCESS_FINE_LOCATION");
    c.put("getLocation", "android.permission.ACCESS_FINE_LOCATION");
    if (Build.VERSION.SDK_INT >= 16)
    {
      c.put("chooseVideo", "android.permission.READ_EXTERNAL_STORAGE");
      c.put("chooseImage", "android.permission.READ_EXTERNAL_STORAGE");
      c.put("saveImageToPhotosAlbum", "android.permission.WRITE_EXTERNAL_STORAGE");
      c.put("saveVideoToPhotosAlbum", "android.permission.WRITE_EXTERNAL_STORAGE");
      d.put("android.permission.READ_EXTERNAL_STORAGE", "需要存储权限，请到设置中设置");
      d.put("android.permission.WRITE_EXTERNAL_STORAGE", "需要存储权限，请到设置中设置");
    }
    d.put("android.permission.ACCESS_FINE_LOCATION", "需要位置权限，请到设置中设置");
    d.put("android.permission.CALL_PHONE", "需要电话权限，请到设置中设置");
    d.put("android.permission.RECORD_AUDIO", "需要麦克风权限，请到设置中设置");
    d.put("android.permission.CAMERA", "需要相机权限，请到设置中设置");
    g.put("chooseLocation", "scope.userLocation");
    g.put("getLocation", "scope.userLocation");
    g.put("saveImageToPhotosAlbum", "scope.writePhotosAlbum");
    g.put("saveVideoToPhotosAlbum", "scope.writePhotosAlbum");
    g.put("chooseInvoiceTitle", "scope.invoiceTitle");
    g.put("openAddress", "scope.address");
    g.put("openWeRunSetting", "scope.werun");
    a.add("scope.userLocation");
    a.add("scope.userInfo");
    a.add("scope.address");
    a.add("scope.invoiceTitle");
    a.add("scope.werun");
    a.add("scope.record");
    a.add("scope.writePhotosAlbum");
    a.add("scope.camera");
    b.put("scope.userLocation", "获取你的地理位置");
    b.put("scope.userInfo", "获取你的公开信息（昵称、头像等）");
    b.put("scope.address", "获取你的通讯地址");
    b.put("scope.invoiceTitle", "获取你的发票抬头");
    b.put("scope.werun", "获取你的运动步数");
    b.put("scope.record", "使用录音功能");
    b.put("scope.writePhotosAlbum", "保存视频或图片到你的相册");
    b.put("scope.camera", "使用相机功能");
  }
  
  public a(Context paramContext, String paramString)
  {
    this.e = paramContext.getSharedPreferences(paramString, 0);
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return !TextUtils.isEmpty(c(paramString1, paramString2));
  }
  
  public static String c(String paramString1, String paramString2)
  {
    return (String)g.get(paramString1);
  }
  
  public static String d(String paramString1, String paramString2)
  {
    return (String)c.get(paramString1);
  }
  
  public int a(String paramString1, String paramString2)
  {
    paramString1 = c(paramString1, paramString2);
    if (TextUtils.isEmpty(paramString1)) {
      return 2;
    }
    return this.e.getInt(paramString1, 1);
  }
  
  public List a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      int i = this.e.getInt(str, 1);
      if (i == 2)
      {
        if ((paramInt & 0x2) == 2) {
          localArrayList.add(new a.a(str, 2));
        }
      }
      else if (i == 1)
      {
        if ((paramInt & 0x1) == 1) {
          localArrayList.add(new a.a(str, 1));
        }
      }
      else if ((paramInt & 0x4) == 4) {
        localArrayList.add(new a.a(str, 4));
      }
    }
    return localArrayList;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramBoolean) {
        break label36;
      }
    }
    label36:
    for (int i = 2;; i = (int)(System.currentTimeMillis() / 1000L) + this.f)
    {
      this.e.edit().putInt(paramString, i).commit();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.app.a
 * JD-Core Version:    0.7.0.1
 */