package com.tencent.rtmp;

import android.content.Context;
import android.util.Log;
import com.tencent.liteav.TXLiteAVExternalDecoderFactoryInterface;
import com.tencent.liteav.basic.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.license.LicenceCheck;
import com.tencent.liteav.basic.license.f;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TXLiveBase
{
  private static final String FILE_MD5_FFMPEG_ARM = "___md5_libtxffmpeg_arm_md5______";
  private static final String FILE_MD5_FFMPEG_V64 = "___md5_libtxffmpeg_v64_md5______";
  private static final String FILE_MD5_FFMPEG_V7A = "___md5_libtxffmpeg_v7a_md5______";
  private static final String FILE_MD5_LITEAV_ARM = "___md5_libliteavsdk_arm_md5_____";
  private static final String FILE_MD5_LITEAV_V64 = "___md5_libliteavsdk_v64_md5_____";
  private static final String FILE_MD5_LITEAV_V7A = "___md5_libliteavsdk_v7a_md5_____";
  private static final String FILE_MD5_SATURN_ARM = "___md5_libsaturn_arm_md5________";
  private static final String FILE_MD5_SATURN_V64 = "___md5_libsaturn_v64_md5________";
  private static final String FILE_MD5_SATURN_V7A = "___md5_libsaturn_v7a_md5________";
  private static final String FILE_MD5_TRAE_ARM = "___md5_libtraeimp_arm_md5_______";
  private static final String FILE_MD5_TRAE_V64 = "___md5_libtraeimp_v64_md5_______";
  private static final String FILE_MD5_TRAE_V7A = "___md5_libtraeimp_v7a_md5_______";
  private static final String TAG = "TXLiveBase";
  private static TXLiveBase instance = new TXLiveBase();
  private static ITXLiveBaseListener listener;
  
  private static String getFileMD5(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString1, paramString2);
    boolean bool = ((File)localObject).exists();
    String str1 = null;
    String str2 = null;
    paramString2 = null;
    if (bool)
    {
      if (!((File)localObject).isFile()) {
        return null;
      }
      byte[] arrayOfByte = new byte[1024];
      try
      {
        paramString1 = MessageDigest.getInstance("MD5");
        paramString2 = paramString1;
        str1 = paramString1;
        str2 = paramString1;
        localObject = new FileInputStream((File)localObject);
        for (;;)
        {
          paramString2 = paramString1;
          str1 = paramString1;
          str2 = paramString1;
          int i = ((FileInputStream)localObject).read(arrayOfByte, 0, 1024);
          if (i == -1) {
            break;
          }
          paramString2 = paramString1;
          str1 = paramString1;
          str2 = paramString1;
          paramString1.update(arrayOfByte, 0, i);
        }
        paramString2 = paramString1;
        str1 = paramString1;
        str2 = paramString1;
        ((FileInputStream)localObject).close();
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = paramString2;
      }
      catch (FileNotFoundException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = str1;
      }
      catch (NoSuchAlgorithmException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = str2;
      }
      return new BigInteger(1, paramString1.digest()).toString(16);
    }
    return null;
  }
  
  public static TXLiveBase getInstance()
  {
    return instance;
  }
  
  public static String getPituSDKVersion()
  {
    return p.a();
  }
  
  public static String getSDKVersionStr()
  {
    return TXCCommonUtil.getSDKVersionStr();
  }
  
  public static boolean isLibraryPathValid(String paramString)
  {
    String str1 = getFileMD5(paramString, "libliteavsdk.so");
    String str2 = getFileMD5(paramString, "libsaturn.so");
    String str3 = getFileMD5(paramString, "libtxffmpeg.so");
    paramString = getFileMD5(paramString, "libtraeimp-rtmp.so");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-V64 libliteavsdk = ");
    localStringBuilder.append(str1);
    localStringBuilder.append(" FILE_MD5_LITEAV_V64 = ");
    localStringBuilder.append("___md5_libliteavsdk_v64_md5_____");
    Log.e("TXLiveBase", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-V64 libsaturn    = ");
    localStringBuilder.append(str2);
    localStringBuilder.append(" FILE_MD5_SATURN_V64 = ");
    localStringBuilder.append("___md5_libsaturn_v64_md5________");
    Log.e("TXLiveBase", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-V64 libtxffmpeg  = ");
    localStringBuilder.append(str3);
    localStringBuilder.append(" FILE_MD5_FFMPEG_V64 = ");
    localStringBuilder.append("___md5_libtxffmpeg_v64_md5______");
    Log.e("TXLiveBase", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-V64 libtraeimpl  = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" FILE_MD5_TRAE_V64   = ");
    localStringBuilder.append("___md5_libtraeimp_v64_md5_______");
    Log.e("TXLiveBase", localStringBuilder.toString());
    if ((str1 != null) && (str1.equalsIgnoreCase("___md5_libliteavsdk_v64_md5_____")) && (str2 != null) && (str2.equalsIgnoreCase("___md5_libsaturn_v64_md5________")) && (str3 != null) && (str3.equalsIgnoreCase("___md5_libtxffmpeg_v64_md5______")) && (paramString != null) && (paramString.equalsIgnoreCase("___md5_libtraeimp_v64_md5_______"))) {
      return true;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-V7A libliteavsdk = ");
    localStringBuilder.append(str1);
    localStringBuilder.append(" FILE_MD5_LITEAV_V7A = ");
    localStringBuilder.append("___md5_libliteavsdk_v7a_md5_____");
    Log.e("TXLiveBase", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-V7A libsaturn    = ");
    localStringBuilder.append(str2);
    localStringBuilder.append(" FILE_MD5_SATURN_V7A = ");
    localStringBuilder.append("___md5_libsaturn_v7a_md5________");
    Log.e("TXLiveBase", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-V7A libtxffmpeg  = ");
    localStringBuilder.append(str3);
    localStringBuilder.append(" FILE_MD5_FFMPEG_V7A = ");
    localStringBuilder.append("___md5_libtxffmpeg_v7a_md5______");
    Log.e("TXLiveBase", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-V7A libtraeimpl  = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" FILE_MD5_TRAE_V7A   = ");
    localStringBuilder.append("___md5_libtraeimp_v7a_md5_______");
    Log.e("TXLiveBase", localStringBuilder.toString());
    if ((str1 != null) && (str1.equalsIgnoreCase("___md5_libliteavsdk_v7a_md5_____")) && (str2 != null) && (str2.equalsIgnoreCase("___md5_libsaturn_v7a_md5________")) && (str3 != null) && (str3.equalsIgnoreCase("___md5_libtxffmpeg_v7a_md5______")) && (paramString != null) && (paramString.equalsIgnoreCase("___md5_libtraeimp_v7a_md5_______"))) {
      return true;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-ARM libliteavsdk = ");
    localStringBuilder.append(str1);
    localStringBuilder.append(" FILE_MD5_LITEAV_ARM = ");
    localStringBuilder.append("___md5_libliteavsdk_arm_md5_____");
    Log.e("TXLiveBase", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-ARM libsaturn    = ");
    localStringBuilder.append(str2);
    localStringBuilder.append(" FILE_MD5_SATURN_ARM = ");
    localStringBuilder.append("___md5_libsaturn_arm_md5________");
    Log.e("TXLiveBase", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-ARM libtxffmpeg  = ");
    localStringBuilder.append(str3);
    localStringBuilder.append(" FILE_MD5_FFMPEG_ARM = ");
    localStringBuilder.append("___md5_libtxffmpeg_arm_md5______");
    Log.e("TXLiveBase", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("MD5-CHECK-ARM libtraeimpl  = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" FILE_MD5_TRAE_ARM   = ");
    localStringBuilder.append("___md5_libtraeimp_arm_md5_______");
    Log.e("TXLiveBase", localStringBuilder.toString());
    return (str1 != null) && (str1.equalsIgnoreCase("___md5_libliteavsdk_arm_md5_____")) && (str2 != null) && (str2.equalsIgnoreCase("___md5_libsaturn_arm_md5________")) && (str3 != null) && (str3.equalsIgnoreCase("___md5_libtxffmpeg_arm_md5______")) && (paramString != null) && (paramString.equalsIgnoreCase("___md5_libtraeimp_arm_md5_______"));
  }
  
  public static void setAppID(String paramString)
  {
    TXCCommonUtil.setAppID(paramString);
  }
  
  public static void setAppVersion(String paramString)
  {
    TXCDRApi.txSetAppVersion(paramString);
    TXCCommonUtil.setAppVersion(paramString);
  }
  
  public static void setConsoleEnabled(boolean paramBoolean)
  {
    TXCLog.setConsoleEnabled(paramBoolean);
  }
  
  public static void setExternalDecoderFactory(TXLiteAVExternalDecoderFactoryInterface paramTXLiteAVExternalDecoderFactoryInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setExternalDecoderFactory decoderFactory = ");
    localStringBuilder.append(paramTXLiteAVExternalDecoderFactoryInterface);
    TXCLog.i("TXLiveBase", localStringBuilder.toString());
    a.a(paramTXLiteAVExternalDecoderFactoryInterface);
  }
  
  public static void setLibraryPath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setLibraryPath ");
    localStringBuilder.append(paramString);
    Log.i("TXLiveBase", localStringBuilder.toString());
    h.b(paramString);
  }
  
  public static void setListener(ITXLiveBaseListener paramITXLiveBaseListener)
  {
    TXCLog.setListener(new TXLiveBase.a(null));
    listener = paramITXLiveBaseListener;
  }
  
  public static void setLogLevel(int paramInt)
  {
    TXCLog.setLevel(paramInt);
  }
  
  public static void setPituLicencePath(String paramString)
  {
    TXCCommonUtil.setPituLicencePath(paramString);
  }
  
  public static void setUserId(String paramString)
  {
    TXCCommonUtil.setUserId(paramString);
  }
  
  public String getLicenceInfo(Context paramContext)
  {
    f localf = new f();
    LicenceCheck.a().a(localf, paramContext);
    return localf.a;
  }
  
  public void setLicence(Context paramContext, String paramString1, String paramString2)
  {
    LicenceCheck.a().a(paramContext, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLiveBase
 * JD-Core Version:    0.7.0.1
 */