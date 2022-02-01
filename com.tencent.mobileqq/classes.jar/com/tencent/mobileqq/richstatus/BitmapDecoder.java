package com.tencent.mobileqq.richstatus;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

public class BitmapDecoder
{
  private HashSet<String> a;
  private BitmapDecoder.IBitmapListener b;
  private volatile long c;
  private String d;
  
  public BitmapDecoder(String paramString, BitmapDecoder.IBitmapListener paramIBitmapListener)
  {
    paramString = this.d;
    this.b = paramIBitmapListener;
  }
  
  public static File a()
  {
    if (SystemUtil.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_PATH);
      localStringBuilder.append("status_ic");
      return new File(localStringBuilder.toString());
    }
    return null;
  }
  
  private boolean a(String paramString, File paramFile)
  {
    int i = HttpDownloadUtil.downloadData(null, paramString, paramFile);
    if (QLog.isColorLevel())
    {
      paramFile = new StringBuilder();
      paramFile.append("download ");
      paramFile.append(paramString);
      paramFile.append("result ");
      paramFile.append(i);
      QLog.d("Q.richstatus.img", 2, paramFile.toString());
    }
    paramFile = StatisticCollector.getInstance(BaseApplication.getContext());
    HashMap localHashMap = new HashMap();
    localHashMap.put("result", String.valueOf(i));
    localHashMap.put("url", paramString);
    boolean bool;
    if (i == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramFile.collectPerformance("", "RichStatusIcon", bool, 0L, 0L, localHashMap, "");
    return i == 0;
  }
  
  public Bitmap a(String paramString)
  {
    MQLruCache localMQLruCache = GlobalImageCache.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(paramString);
    return (Bitmap)localMQLruCache.get(localStringBuilder.toString());
  }
  
  public Bitmap a(String paramString1, String paramString2, String paramString3)
  {
    Bitmap localBitmap = a(paramString1);
    if (localBitmap == null)
    {
      if (this.a == null) {
        this.a = new HashSet();
      }
      if (!this.a.contains(paramString1))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeBitmap ");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramString3);
          QLog.d("Q.richstatus.img", 2, localStringBuilder.toString());
        }
        this.a.add(paramString1);
        new BitmapDecoder.Decoder(this, paramString1, paramString2, paramString3).execute((Void[])null);
      }
    }
    return localBitmap;
  }
  
  public void b()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.BitmapDecoder
 * JD-Core Version:    0.7.0.1
 */