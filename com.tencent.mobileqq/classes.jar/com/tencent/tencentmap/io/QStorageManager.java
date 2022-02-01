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
  private static QStorageManager a;
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
    if (paramContext != null)
    {
      this.b = paramContext.getApplicationContext();
      Object localObject1 = getStorageRootPath(paramContext);
      Object localObject2 = om.a(this.b);
      if (nl.a((String)localObject2))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("/tencentmapsdk/");
        this.c = ((StringBuilder)localObject2).toString();
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("/tencentmapsdk/");
        localStringBuilder.append((String)localObject2);
        this.c = localStringBuilder.toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append("/data/v3/render/");
      this.d = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append("/sat/");
      this.e = ((StringBuilder)localObject1).toString();
      this.j = paramContext.getFilesDir().getAbsolutePath();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.j);
      ((StringBuilder)localObject1).append("/tencentMapSdk/config/");
      this.g = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.g);
      ((StringBuilder)localObject1).append("temp/");
      this.k = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.j);
      ((StringBuilder)localObject1).append("/tencentMapSdk/assets/");
      this.h = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.j);
      ((StringBuilder)localObject1).append("/tencentMapSdk/dynamicAssets/");
      this.i = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append("closeRoadDatas/");
      this.f = ((StringBuilder)localObject1).toString();
      clearOldConfig(paramContext, gf.a(paramContext).a("sdkVersion"));
      return;
    }
    throw new Error("context can not be null");
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
      if (Build.VERSION.SDK_INT < 18)
      {
        l1 = paramString.getBlockSize();
        l2 = paramString.getAvailableBlocks();
      }
      else
      {
        l1 = paramString.getBlockSizeLong();
        l2 = paramString.getAvailableBlocksLong();
      }
      long l1 = l1 * l2 / 1024L / 1024L;
      return l1;
    }
    catch (Exception paramString)
    {
      label56:
      break label56;
    }
    return 0L;
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
    boolean bool = Environment.getExternalStorageState().equals("mounted");
    int m = Build.VERSION.SDK_INT;
    int i2 = 0;
    int n;
    if (m >= 23)
    {
      m = paramContext.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
      n = paramContext.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid());
    }
    else
    {
      m = 0;
      n = 0;
    }
    int i1 = i2;
    if (m == 0)
    {
      i1 = i2;
      if (n == 0) {
        i1 = 1;
      }
    }
    String str1;
    if ((bool) && (i1 != 0))
    {
      String str2 = a(paramContext);
      str1 = str2;
      if (getAvailableStorageSize(str2) < 5L)
      {
        str2 = paramContext.getFilesDir().getPath();
        str1 = str2;
        if (getAvailableStorageSize(str2) < 5L) {
          return a(paramContext);
        }
      }
    }
    else
    {
      str1 = paramContext.getFilesDir().getPath();
    }
    return str1;
  }
  
  public void clearOldConfig(Context paramContext, String paramString)
  {
    if (nl.a(gf.a(paramContext).a("sdkVersion"))) {
      return;
    }
    if (fz.a("4.1.0", paramString) > 0)
    {
      ge.a(paramContext);
      om.e(new File(this.g));
      om.e(new File(this.h));
      paramContext = new StringBuilder();
      paramContext.append(this.j);
      paramContext.append("/tencentMapSdk/subKey/");
      om.e(new File(paramContext.toString()));
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j);
    localStringBuilder.append("/tencentMapSdk/subKey/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/assets/");
    return localStringBuilder.toString();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.j);
    localStringBuilder.append("/tencentMapSdk/subKey/");
    localStringBuilder.append(paramString);
    localStringBuilder.append("/config/");
    return localStringBuilder.toString();
  }
  
  public String getConfigTempPath(String paramString)
  {
    if (nl.a(paramString)) {
      return this.k;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getConfigPath(paramString));
    localStringBuilder.append("temp/");
    return localStringBuilder.toString();
  }
  
  public File getDataDir()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localStringBuilder.append("/data/");
    return new File(localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.io.QStorageManager
 * JD-Core Version:    0.7.0.1
 */