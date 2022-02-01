package com.tencent.mobileqq.vas.hippy;

import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.dom.node.TypeFaceUtil;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class VasHippyFontUtils
{
  public static DownloadTask a(String paramString1, String paramString2)
  {
    return new DownloadTask(paramString1, new File(paramString2));
  }
  
  public static DownloaderInterface a()
  {
    return ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(4);
  }
  
  public static String a(String paramString)
  {
    paramString = b(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HippyUtils.getHippyFontRootDir());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static ArrayList a(@NonNull HippyArray paramHippyArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramHippyArray.size())
    {
      String str = paramHippyArray.getString(i);
      if (!d(a(str))) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(HippyArray paramHippyArray, Promise paramPromise)
  {
    ThreadManager.excute(new VasHippyFontUtils.1(paramHippyArray, paramPromise), 128, null, false);
  }
  
  public static void a(Promise paramPromise, int paramInt, String paramString)
  {
    if (paramPromise == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyPromise returnCode = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" msg = ");
      localStringBuilder.append(paramString);
      QLog.i("VasHippyFontUtils", 2, localStringBuilder.toString());
    }
    paramPromise.resolve(VasHippyUtils.a(paramInt, paramString, null));
  }
  
  public static void a(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
      HashMap localHashMap = b();
      if (localHashMap == null) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(c(paramFile.getAbsolutePath()));
      ((StringBuilder)localObject).append(0);
      localObject = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("injectHippyTypeFace key = ");
        localStringBuilder.append((String)localObject);
        QLog.i("VasHippyFontUtils", 2, localStringBuilder.toString());
      }
      try
      {
        localHashMap.put(localObject, Typeface.createFromFile(paramFile));
        return;
      }
      catch (RuntimeException paramFile)
      {
        paramFile.printStackTrace();
        QLog.e("VasHippyFontUtils", 1, "createFromFile error ", paramFile);
      }
    }
  }
  
  public static String b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("/"))) {
      return paramString.substring(paramString.lastIndexOf("/") + 1);
    }
    return "";
  }
  
  public static HashMap<String, Typeface> b()
  {
    Object localObject2;
    try
    {
      Object localObject1 = TypeFaceUtil.class.getDeclaredField("mFontCache");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get("mFontCache");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.e("VasHippyFontUtils", 1, "getStaticFieldValue error ", localException);
      localObject2 = null;
    }
    if (localObject2 != null)
    {
      if (!(localObject2 instanceof HashMap)) {
        return null;
      }
      return (HashMap)localObject2;
    }
    return null;
  }
  
  public static void b(HippyArray paramHippyArray, Promise paramPromise)
  {
    if (paramHippyArray != null)
    {
      if (paramHippyArray.size() == 0) {
        return;
      }
      Object localObject = a(paramHippyArray);
      if (((ArrayList)localObject).size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VasHippyFontUtils", 2, "all file has downloaded");
        }
        a(paramPromise, 0, "success");
        return;
      }
      paramHippyArray = new VasHippyFontUtils.FontDownloadListener(paramPromise, ((ArrayList)localObject).size());
      paramPromise = a();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        paramPromise.startDownload(a(str, a(str)), paramHippyArray, null);
      }
    }
  }
  
  public static String c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.contains(File.separator)) {
        return "";
      }
      try
      {
        String str = paramString.substring(paramString.lastIndexOf(File.separator) + 1);
        str = str.substring(0, str.lastIndexOf("."));
        return str;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("parseFontFamily error , path = ");
        localStringBuilder.append(paramString);
        QLog.e("VasHippyFontUtils", 1, localStringBuilder.toString(), localException);
      }
    }
    return "";
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.VasHippyFontUtils
 * JD-Core Version:    0.7.0.1
 */