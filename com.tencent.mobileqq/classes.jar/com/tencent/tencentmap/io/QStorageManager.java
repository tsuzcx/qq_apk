package com.tencent.tencentmap.io;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.tencent.map.sdk.a.fz;
import com.tencent.map.sdk.a.ge;
import com.tencent.map.sdk.a.gf;
import com.tencent.map.sdk.a.nl;
import com.tencent.map.sdk.a.om;
import java.io.File;

public class QStorageManager
{
  public static final String DATA = "data/";
  private static QStorageManager a = null;
  private Context b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  private QStorageManager(Context paramContext)
  {
    if (paramContext == null) {
      throw new Error("context can not be null");
    }
    this.b = paramContext.getApplicationContext();
    String str1 = getStorageRootPath(paramContext);
    String str2 = om.a(this.b);
    if (nl.a(str2)) {}
    for (this.c = (str1 + "/tencentmapsdk/");; this.c = (str1 + "/tencentmapsdk/" + str2))
    {
      this.d = (this.c + "/data/v3/render/");
      this.e = (this.c + "/sat/");
      this.j = paramContext.getFilesDir().getAbsolutePath();
      this.g = (this.j + "/tencentMapSdk/config/");
      this.k = (this.g + "temp/");
      this.h = (this.j + "/tencentMapSdk/assets/");
      this.i = (this.j + "/tencentMapSdk/dynamicAssets/");
      this.f = (this.d + "closeRoadDatas/");
      clearOldConfig(paramContext, gf.a(paramContext).a("sdkVersion"));
      return;
    }
  }
  
  private static String a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT > 28) {
      return paramContext.getExternalFilesDir(null).getAbsolutePath();
    }
    return Environment.getExternalStorageDirectory().getPath();
  }
  
  @SuppressLint({"NewApi"})
  public static long getAvailableStorageSize(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l2;
      if (Build.VERSION.SDK_INT < 18) {
        l2 = paramString.getBlockSize();
      }
      for (long l1 = paramString.getAvailableBlocks();; l1 = paramString.getAvailableBlocksLong())
      {
        return l1 * l2 / 1024L / 1024L;
        l2 = paramString.getBlockSizeLong();
      }
      return 0L;
    }
    catch (Exception paramString) {}
  }
  
  public static QStorageManager getInstance(Context paramContext)
  {
    if (a == null) {
      a = new QStorageManager(paramContext);
    }
    return a;
  }
  
  public static String getStorageRootPath(Context paramContext)
  {
    int i2 = 0;
    boolean bool = Environment.getExternalStorageState().equals("mounted");
    int n;
    int m;
    if (Build.VERSION.SDK_INT >= 23)
    {
      n = paramContext.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
      m = paramContext.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
    }
    for (;;)
    {
      int i1 = i2;
      if (n == 0)
      {
        i1 = i2;
        if (m == 0) {
          i1 = 1;
        }
      }
      Object localObject;
      if ((!bool) || (i1 == 0)) {
        localObject = paramContext.getFilesDir().getPath();
      }
      String str;
      do
      {
        do
        {
          return localObject;
          str = a(paramContext);
          localObject = str;
        } while (getAvailableStorageSize(str) >= 5L);
        str = paramContext.getFilesDir().getPath();
        localObject = str;
      } while (getAvailableStorageSize(str) >= 5L);
      return a(paramContext);
      m = 0;
      n = 0;
    }
  }
  
  public void clearOldConfig(Context paramContext, String paramString)
  {
    if (nl.a(gf.a(paramContext).a("sdkVersion"))) {}
    while (fz.a("4.1.0", paramString) <= 0) {
      return;
    }
    ge.a(paramContext);
    om.e(new File(this.g));
    om.e(new File(this.h));
    om.e(new File(this.j + "/tencentMapSdk/subKey/"));
  }
  
  public String getAssetsDynamicPath()
  {
    return this.i;
  }
  
  public String getAssetsLoadPath(String paramString)
  {
    if (nl.a(paramString)) {
      return this.h;
    }
    return this.j + "/tencentMapSdk/subKey/" + paramString + "/assets/";
  }
  
  public File getCacheDir()
  {
    return new File(this.c);
  }
  
  public String getConfigPath(String paramString)
  {
    if (nl.a(paramString)) {
      return this.g;
    }
    return this.j + "/tencentMapSdk/subKey/" + paramString + "/config/";
  }
  
  public String getConfigTempPath(String paramString)
  {
    if (nl.a(paramString)) {
      return this.k;
    }
    return getConfigPath(paramString) + "temp/";
  }
  
  public File getDataDir()
  {
    return new File(this.c + "/data/");
  }
  
  public String getMapPath()
  {
    return this.d;
  }
  
  public String getRouteBlockPath()
  {
    return this.f;
  }
  
  public String getSatPath()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.io.QStorageManager
 * JD-Core Version:    0.7.0.1
 */