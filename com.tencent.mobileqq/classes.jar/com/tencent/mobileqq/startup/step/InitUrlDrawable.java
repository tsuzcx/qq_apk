package com.tencent.mobileqq.startup.step;

import ahqz;
import ahra;
import ahrb;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class InitUrlDrawable
  extends Step
{
  public static DiskCache a;
  
  private static String b(Exception paramException)
  {
    int j = 0;
    if (paramException == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramException = paramException.getStackTrace();
    ArrayList localArrayList = new ArrayList(8);
    int m = paramException.length;
    int i = 0;
    Object localObject;
    int k;
    if (i < m)
    {
      localObject = paramException[i];
      String str = localObject.getClassName();
      k = j;
      if (!str.contains("URLDrawable"))
      {
        k = j;
        if (!str.startsWith("android."))
        {
          k = j;
          if (!str.startsWith("java."))
          {
            k = j;
            if (!str.startsWith("com.android."))
            {
              if (!str.startsWith("dalvik.")) {
                break label127;
              }
              k = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      j = k;
      break;
      label127:
      k = j + 1;
      if (k >= 8)
      {
        i = localArrayList.size() - 1;
        while (i >= 0)
        {
          localStringBuffer.append((String)localArrayList.get(i)).append(",");
          i -= 1;
        }
      }
      localArrayList.add(localObject.toString());
    }
    return localStringBuffer.toString();
  }
  
  protected boolean a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    URLDrawable.DEBUG = false;
    File localFile;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      localFile = new File(AppConstants.aJ);
    }
    try
    {
      for (;;)
      {
        URLDrawable.init(localBaseApplicationImpl, new ahrb(localBaseApplicationImpl));
        if (Build.VERSION.SDK_INT >= 11) {
          URLDrawable.setDebuggableCallback(new ahqz());
        }
        localFile = new File(localFile, "diskcache");
        if (localFile != null) {
          break;
        }
        localFile = Utils.getExternalCacheDir(localBaseApplicationImpl);
        a = new DiskCache(localFile);
        com.tencent.mobileqq.transfile.URLDrawableHelper.a = localFile;
        JpegExifReader.initJpegExifReader(new ahra());
        return true;
        localFile = localBaseApplicationImpl.getCacheDir();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AutoMonitor", 1, "", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable
 * JD-Core Version:    0.7.0.1
 */