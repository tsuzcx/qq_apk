package com.tencent.mobileqq.qwallet.preload;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.utils.QWalletValues;
import com.tencent.qphone.base.util.MD5;
import cooperation.qwallet.plugin.IQWalletHelper;
import mqq.app.AppRuntime;

public class PreloadStaticApi
{
  public static final Object a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = TextUtils.isEmpty(c());
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static ResultReceiver a(ResultReceiver paramResultReceiver)
  {
    if (paramResultReceiver == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    paramResultReceiver.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramResultReceiver = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel(localParcel);
    localParcel.recycle();
    return paramResultReceiver;
  }
  
  public static IPreloadService.PathResult a(DownloadParam paramDownloadParam)
  {
    return ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).getResPathSync(paramDownloadParam);
  }
  
  public static IPreloadServiceAbs a()
  {
    return ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).getInstance();
  }
  
  public static ResourceInfo a(String paramString, boolean paramBoolean, int paramInt)
  {
    return ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).getResInfoByUrl(paramString, paramBoolean, paramInt);
  }
  
  public static String a()
  {
    return a(0);
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 1) {
      return b();
    }
    String str = c();
    if (!TextUtils.isEmpty(str))
    {
      jdField_a_of_type_Boolean = false;
      return str;
    }
    jdField_a_of_type_Boolean = true;
    return b();
  }
  
  public static String a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static String a(String paramString, int paramInt)
  {
    return ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).getResourcePathByUrl(paramString, paramInt);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    return ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).getFolderPathByMD5AndUrl(paramString1, paramString2, paramInt);
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    return ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath() + paramAppRuntime.getAccount() + "/" + ".preloaduni" + "/";
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString)
  {
    return a(paramAppRuntime) + paramString;
  }
  
  public static void a(String paramString, boolean paramBoolean, int paramInt)
  {
    ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).deleteRes(paramString, paramBoolean, paramInt);
  }
  
  public static boolean a(ResourceInfo paramResourceInfo, DownloadParam paramDownloadParam)
  {
    return ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).isFileValid(paramResourceInfo, paramDownloadParam);
  }
  
  public static boolean a(String paramString)
  {
    return ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).isDiskEnoughToUnzip(paramString);
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    return (paramInt == 4) || ((paramString != null) && (paramString.length() > 5) && (paramString.substring(paramString.length() - 4).equals(".zip")));
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).unzipAtomically(paramString1, paramString2);
      return bool;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static String b()
  {
    return ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getQWalletInternalPath() + ".preloaduni" + "/";
  }
  
  public static String b(String paramString)
  {
    return b(paramString, 0);
  }
  
  public static String b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = MD5.toMD5(paramString);
    return a(paramInt) + paramString;
  }
  
  public static boolean b(String paramString)
  {
    return ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).isFolderPathValid(paramString);
  }
  
  public static String c()
  {
    String str1 = null;
    try
    {
      String str2 = QWalletValues.a;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2 + ".preloaduni" + "/";
      }
      return str1;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static String c(String paramString)
  {
    return ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).getUnzipFolderPath(paramString);
  }
  
  public static String d(String paramString)
  {
    return ((IPreloadStaticApi)QRoute.api(IPreloadStaticApi.class)).getConfigFromQQ(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.PreloadStaticApi
 * JD-Core Version:    0.7.0.1
 */