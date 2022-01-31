package oicq.wlogin_sdk.tools;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import javax.crypto.Cipher;
import oicq.wlogin_sdk.pb.device_report.DeviceReport;
import oicq.wlogin_sdk.request.t;

public class util
{
  public static final int ASYN_CHECK_IMAGE = 2;
  public static final int ASYN_CHECK_SMS = 4;
  public static final int ASYN_EXCEPTION = 11;
  public static final int ASYN_GET_A1_WITH_A1 = 6;
  public static final int ASYN_GET_ST_WITHOUT_PWD = 5;
  public static final int ASYN_GET_ST_WITH_PWD = 0;
  public static final int ASYN_QUICKLOG_BY_WECHAT = 18;
  public static final int ASYN_QUICKLOG_WITH_PTSIG = 16;
  public static final int ASYN_QUICKLOG_WITH_QQSIG = 15;
  public static final int ASYN_QUICKLOG_WITH_QRSIG = 17;
  public static final int ASYN_REFLUSH_IMAGE = 1;
  public static final int ASYN_REFLUSH_SMS = 3;
  public static final int ASYN_REPORT = 7;
  public static final int ASYN_REPORT_ERROR = 8;
  public static final int ASYN_SMSLOGIN_CHECK = 12;
  public static final int ASYN_SMSLOGIN_REFRESH = 14;
  public static final int ASYN_SMSLOGIN_VERIFY = 13;
  public static final int ASYN_TRANSPORT = 9;
  public static final int ASYN_TRANSPORT_MSF = 10;
  public static final long BUILD_TIME = 1585297161L;
  public static final int D = 2;
  private static SimpleDateFormat DAYFORMAT;
  public static final int E_A1_DECRYPT = -1014;
  public static final int E_A1_FORMAT = -1016;
  public static final int E_ADVANCE_NOTICE = 257;
  public static final int E_APK_CHK_ERR = -1021;
  public static final int E_BUFFER_OVERFLOW = -1023;
  public static final int E_DECRYPT = -1002;
  public static final int E_ENCODING = -1013;
  public static final int E_ENCRYPTION_METHOD = -1024;
  public static final int E_INPUT = -1017;
  public static final int E_LOGIN_THROUGH_QQ = -2001;
  public static final int E_LOGIN_THROUGH_WEB = -2000;
  public static final int E_NAME_INVALID = -1008;
  public static final int E_NEWST_DECRYPT = -1025;
  public static final int E_NO_KEY = -1004;
  public static final int E_NO_NETWORK = -1026;
  public static final int E_NO_REG_CMD = -1010;
  public static final int E_NO_RET = -1000;
  public static final int E_NO_TGTKEY = -1006;
  public static final int E_NO_UIN = -1003;
  public static final int E_PENDING = -1001;
  public static final int E_PK_LEN = -1009;
  public static final int E_PUSH_REG = -1011;
  public static final int E_RESOLVE_ADDR = -1007;
  public static final int E_SAVE_TICKET_ERROR = -1022;
  public static final int E_SHARE_SERVICE_EXCEPTION = -1020;
  public static final int E_SHARE_SERVICE_PARAM = -1019;
  public static final int E_SHARE_SERVICE_UNCHECK = -1018;
  public static final int E_SYSTEM = -1012;
  public static final int E_TLV_DECRYPT = -1015;
  public static final int E_TLV_VERIFY = -1005;
  public static final int E_WXLOGIN_NO_REGISTER = 230;
  public static final int E_WXLOGIN_NUM_FAILED = -2003;
  public static final int E_WXLOGIN_TOKEN_FAILED = -2002;
  public static final String FILE_DIR = "wtlogin";
  public static int GUID_DELAY_HOUR = 0;
  private static int HONEYCOMB = 11;
  public static final int I = 1;
  public static LogCallBack LCB;
  public static boolean LOGCAT_OUT = false;
  public static final String LOG_DIR = "tencent/wtlogin";
  public static int LOG_LEVEL = 0;
  public static int MAX_APPID = 0;
  public static final int MAX_CONTENT_SIZE = 40960;
  public static final int MAX_FILE_SIZE = 524288;
  public static int MAX_NAME_LEN = 0;
  @SuppressLint({"NewApi"})
  private static int MODE_MULTI_PROCESS = 0;
  public static final String SDK_VERSION = "6.0.0.2424";
  public static final int SSO_VERSION = 8;
  public static final long SVN_VER = 2424L;
  public static final int S_BABYLH_EXPIRED = 116;
  public static final int S_GET_IMAGE = 2;
  public static final int S_GET_SMS = 160;
  public static final int S_GET_SMS_TOKEN = 239;
  public static final int S_LH_EXPIRED = 41;
  public static final int S_PWD_WRONG = 1;
  public static final int S_ROLL_BACK = 180;
  public static final int S_SEC_GUID = 204;
  public static final int S_SUCCESS = 0;
  public static final String TAG = "wlogin_sdk";
  public static final int W = 0;
  static final char[] base64_encode_chars = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  static final char base64_pad_url = '_';
  static final short[] base64_reverse_table_url = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static boolean libwtecdh_loaded;
  public static boolean loadEncryptSo;
  public static String logContent;
  
  static
  {
    int i = 0;
    MAX_APPID = 65535;
    MAX_NAME_LEN = 128;
    LOG_LEVEL = 1;
    LCB = null;
    LOGCAT_OUT = false;
    GUID_DELAY_HOUR = 360;
    logContent = "";
    DAYFORMAT = null;
    libwtecdh_loaded = false;
    loadEncryptSo = true;
    if (Build.VERSION.SDK_INT > 9) {
      i = 4;
    }
    MODE_MULTI_PROCESS = i;
  }
  
  public static boolean ExistSDCard()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static void LOGD(String paramString)
  {
    try
    {
      if (LOG_LEVEL >= 2)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString);
          return;
        }
        if (LOGCAT_OUT)
        {
          Log.d("wlogin_sdk" + getLineInfo(2), paramString);
          return;
        }
      }
    }
    catch (Exception paramString) {}
  }
  
  public static void LOGD(String paramString1, String paramString2)
  {
    try
    {
      if (LOG_LEVEL >= 2)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString1, paramString2);
          return;
        }
        if (LOGCAT_OUT)
        {
          Log.d("wlogin_sdk" + getLineInfo(2), paramString1 + ":" + paramString2);
          return;
        }
      }
    }
    catch (Exception paramString1) {}
  }
  
  public static void LOGI(String paramString)
  {
    try
    {
      if (LOG_LEVEL >= 1)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString);
          return;
        }
        if (LOGCAT_OUT)
        {
          Log.i("wlogin_sdk" + getLineInfo(2), paramString);
          return;
        }
      }
    }
    catch (Exception paramString) {}
  }
  
  public static void LOGI(String paramString1, String paramString2)
  {
    try
    {
      if (LOG_LEVEL >= 1)
      {
        if (LCB != null) {
          LCB.OnLog(paramString1);
        }
        for (;;)
        {
          b.a(t.t, paramString2, paramString1);
          return;
          if (LOGCAT_OUT) {
            Log.i("wlogin_sdk" + getLineInfo(2), paramString1);
          }
        }
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void LOGW(String paramString1, String paramString2)
  {
    try
    {
      if (LOG_LEVEL >= 0)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString1, paramString2);
          return;
        }
        if (LOGCAT_OUT)
        {
          Log.w("wlogin_sdk" + getLineInfo(2), paramString1 + ":" + paramString2);
          return;
        }
      }
    }
    catch (Exception paramString1) {}
  }
  
  public static void LOGW(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (LOG_LEVEL >= 0)
      {
        if (LCB != null) {
          LCB.OnLog(paramString1, paramString2);
        }
        for (;;)
        {
          b.a(t.t, paramString3, paramString1 + ":" + paramString2);
          return;
          if (LOGCAT_OUT) {
            Log.w("wlogin_sdk" + getLineInfo(2), paramString1 + ":" + paramString2);
          }
        }
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static byte[] RSADecrypt(byte[] paramArrayOfByte, Key paramKey)
  {
    int i = 0;
    if ((paramArrayOfByte == null) || (paramKey == null))
    {
      LOGI("data or key is null", "");
      return null;
    }
    Cipher localCipher;
    int k;
    try
    {
      localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
      localCipher.init(2, paramKey);
      k = paramArrayOfByte.length;
      paramKey = new byte[k];
      if (k % 128 != 0)
      {
        LOGI("len not match block size", "");
        return null;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      LOGI("descypt exception:" + paramArrayOfByte.toString(), "");
      return null;
    }
    int j = 0;
    while (i < k / 128)
    {
      byte[] arrayOfByte = new byte[''];
      System.arraycopy(paramArrayOfByte, i * 128, arrayOfByte, 0, 128);
      arrayOfByte = localCipher.doFinal(arrayOfByte);
      System.arraycopy(arrayOfByte, 0, paramKey, j, arrayOfByte.length);
      j += arrayOfByte.length;
      i += 1;
    }
    paramArrayOfByte = new byte[j];
    System.arraycopy(paramKey, 0, paramArrayOfByte, 0, j);
    return paramArrayOfByte;
  }
  
  public static byte[] RSAEncrypt(byte[] paramArrayOfByte, Key paramKey)
  {
    if ((paramArrayOfByte == null) || (paramKey == null))
    {
      paramKey = null;
      return paramKey;
    }
    for (;;)
    {
      int i;
      int m;
      byte[] arrayOfByte;
      int k;
      int j;
      try
      {
        localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(1, paramKey);
        i = paramArrayOfByte.length;
        m = (int)Math.round(i / 117 + 0.5D);
        arrayOfByte = new byte[128 * m];
        k = 0;
        j = 117;
      }
      catch (Exception paramArrayOfByte)
      {
        Cipher localCipher;
        return null;
      }
      paramKey = new byte[j];
      System.arraycopy(paramArrayOfByte, k * 117, paramKey, 0, j);
      System.arraycopy(localCipher.doFinal(paramKey), 0, arrayOfByte, 128 * k, 128);
      k += 1;
      i -= j;
      paramKey = arrayOfByte;
      if (k >= m) {
        break;
      }
      if (i < 117) {
        j = i;
      }
    }
  }
  
  public static Key RSAPrivKeyFromJNI(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte1 = new byte[26];
    byte[] tmp12_11 = arrayOfByte1;
    tmp12_11[0] = 48;
    byte[] tmp18_12 = tmp12_11;
    tmp18_12[1] = -126;
    byte[] tmp24_18 = tmp18_12;
    tmp24_18[2] = 2;
    byte[] tmp29_24 = tmp24_18;
    tmp29_24[3] = 117;
    byte[] tmp35_29 = tmp29_24;
    tmp35_29[4] = 2;
    byte[] tmp40_35 = tmp35_29;
    tmp40_35[5] = 1;
    byte[] tmp45_40 = tmp40_35;
    tmp45_40[6] = 0;
    byte[] tmp51_45 = tmp45_40;
    tmp51_45[7] = 48;
    byte[] tmp58_51 = tmp51_45;
    tmp58_51[8] = 13;
    byte[] tmp64_58 = tmp58_51;
    tmp64_58[9] = 6;
    byte[] tmp70_64 = tmp64_58;
    tmp70_64[10] = 9;
    byte[] tmp76_70 = tmp70_64;
    tmp76_70[11] = 42;
    byte[] tmp83_76 = tmp76_70;
    tmp83_76[12] = -122;
    byte[] tmp90_83 = tmp83_76;
    tmp90_83[13] = 72;
    byte[] tmp96_90 = tmp90_83;
    tmp96_90[14] = -122;
    byte[] tmp103_96 = tmp96_90;
    tmp103_96[15] = -9;
    byte[] tmp110_103 = tmp103_96;
    tmp110_103[16] = 13;
    byte[] tmp116_110 = tmp110_103;
    tmp116_110[17] = 1;
    byte[] tmp122_116 = tmp116_110;
    tmp122_116[18] = 1;
    byte[] tmp128_122 = tmp122_116;
    tmp128_122[19] = 1;
    byte[] tmp134_128 = tmp128_122;
    tmp134_128[20] = 5;
    byte[] tmp140_134 = tmp134_128;
    tmp140_134[21] = 0;
    byte[] tmp146_140 = tmp140_134;
    tmp146_140[22] = 4;
    byte[] tmp152_146 = tmp146_140;
    tmp152_146[23] = -126;
    byte[] tmp159_152 = tmp152_146;
    tmp159_152[24] = 2;
    byte[] tmp165_159 = tmp159_152;
    tmp165_159[25] = 95;
    tmp165_159;
    int i = paramArrayOfByte.length - 607;
    arrayOfByte1[3] = ((byte)(arrayOfByte1[3] + i));
    arrayOfByte1[25] = ((byte)(i + arrayOfByte1[25]));
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    try
    {
      paramArrayOfByte = new PKCS8EncodedKeySpec(arrayOfByte2);
      paramArrayOfByte = KeyFactory.getInstance("RSA").generatePrivate(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      printException(paramArrayOfByte, "");
    }
    return null;
  }
  
  public static byte[] RSAPrivKeyFromJava(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = new PKCS8EncodedKeySpec(paramArrayOfByte);
    try
    {
      Object localObject = KeyFactory.getInstance("RSA").generatePrivate(paramArrayOfByte);
      paramArrayOfByte = new byte[26];
      paramArrayOfByte[0] = 48;
      paramArrayOfByte[1] = -126;
      paramArrayOfByte[2] = 2;
      paramArrayOfByte[3] = 117;
      paramArrayOfByte[4] = 2;
      paramArrayOfByte[5] = 1;
      paramArrayOfByte[6] = 0;
      paramArrayOfByte[7] = 48;
      paramArrayOfByte[8] = 13;
      paramArrayOfByte[9] = 6;
      paramArrayOfByte[10] = 9;
      paramArrayOfByte[11] = 42;
      paramArrayOfByte[12] = -122;
      paramArrayOfByte[13] = 72;
      paramArrayOfByte[14] = -122;
      paramArrayOfByte[15] = -9;
      paramArrayOfByte[16] = 13;
      paramArrayOfByte[17] = 1;
      paramArrayOfByte[18] = 1;
      paramArrayOfByte[19] = 1;
      paramArrayOfByte[20] = 5;
      paramArrayOfByte[21] = 0;
      paramArrayOfByte[22] = 4;
      paramArrayOfByte[23] = -126;
      paramArrayOfByte[24] = 2;
      paramArrayOfByte[25] = 95;
      paramArrayOfByte;
      localObject = ((PrivateKey)localObject).getEncoded();
      byte[] arrayOfByte = new byte[localObject.length - paramArrayOfByte.length];
      System.arraycopy(localObject, paramArrayOfByte.length, arrayOfByte, 0, arrayOfByte.length);
      return arrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      printException(paramArrayOfByte, "");
    }
    return null;
  }
  
  public static Key RSAPubKeyFromJNI(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte1 = new byte[22];
    byte[] tmp12_11 = arrayOfByte1;
    tmp12_11[0] = 48;
    byte[] tmp18_12 = tmp12_11;
    tmp18_12[1] = -127;
    byte[] tmp24_18 = tmp18_12;
    tmp24_18[2] = -97;
    byte[] tmp30_24 = tmp24_18;
    tmp30_24[3] = 48;
    byte[] tmp36_30 = tmp30_24;
    tmp36_30[4] = 13;
    byte[] tmp41_36 = tmp36_30;
    tmp41_36[5] = 6;
    byte[] tmp46_41 = tmp41_36;
    tmp46_41[6] = 9;
    byte[] tmp52_46 = tmp46_41;
    tmp52_46[7] = 42;
    byte[] tmp59_52 = tmp52_46;
    tmp59_52[8] = -122;
    byte[] tmp66_59 = tmp59_52;
    tmp66_59[9] = 72;
    byte[] tmp72_66 = tmp66_59;
    tmp72_66[10] = -122;
    byte[] tmp79_72 = tmp72_66;
    tmp79_72[11] = -9;
    byte[] tmp86_79 = tmp79_72;
    tmp86_79[12] = 13;
    byte[] tmp92_86 = tmp86_79;
    tmp92_86[13] = 1;
    byte[] tmp98_92 = tmp92_86;
    tmp98_92[14] = 1;
    byte[] tmp104_98 = tmp98_92;
    tmp104_98[15] = 1;
    byte[] tmp110_104 = tmp104_98;
    tmp110_104[16] = 5;
    byte[] tmp116_110 = tmp110_104;
    tmp116_110[17] = 0;
    byte[] tmp122_116 = tmp116_110;
    tmp122_116[18] = 3;
    byte[] tmp128_122 = tmp122_116;
    tmp128_122[19] = -127;
    byte[] tmp135_128 = tmp128_122;
    tmp135_128[20] = -115;
    byte[] tmp142_135 = tmp135_128;
    tmp142_135[21] = 0;
    tmp142_135;
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    paramArrayOfByte = new X509EncodedKeySpec(arrayOfByte2);
    try
    {
      paramArrayOfByte = KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      printException(paramArrayOfByte, "");
    }
    return null;
  }
  
  public static byte[] RSAPubKeyFromJava(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramArrayOfByte = new X509EncodedKeySpec(paramArrayOfByte);
    try
    {
      Object localObject = KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte);
      paramArrayOfByte = new byte[22];
      paramArrayOfByte[0] = 48;
      paramArrayOfByte[1] = -127;
      paramArrayOfByte[2] = -97;
      paramArrayOfByte[3] = 48;
      paramArrayOfByte[4] = 13;
      paramArrayOfByte[5] = 6;
      paramArrayOfByte[6] = 9;
      paramArrayOfByte[7] = 42;
      paramArrayOfByte[8] = -122;
      paramArrayOfByte[9] = 72;
      paramArrayOfByte[10] = -122;
      paramArrayOfByte[11] = -9;
      paramArrayOfByte[12] = 13;
      paramArrayOfByte[13] = 1;
      paramArrayOfByte[14] = 1;
      paramArrayOfByte[15] = 1;
      paramArrayOfByte[16] = 5;
      paramArrayOfByte[17] = 0;
      paramArrayOfByte[18] = 3;
      paramArrayOfByte[19] = -127;
      paramArrayOfByte[20] = -115;
      paramArrayOfByte[21] = 0;
      paramArrayOfByte;
      localObject = ((PublicKey)localObject).getEncoded();
      byte[] arrayOfByte = new byte[localObject.length - paramArrayOfByte.length];
      System.arraycopy(localObject, paramArrayOfByte.length, arrayOfByte, 0, arrayOfByte.length);
      return arrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      printException(paramArrayOfByte, "");
    }
    return null;
  }
  
  public static byte[] base64_decode_url(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[24];
    int n = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    int k = paramInt;
    paramInt = n;
    n = k - 1;
    int i1 = i;
    if (k > 0)
    {
      i = j + 1;
      j = paramArrayOfByte[j];
      i1 = j;
      if (j != 0)
      {
        if (j != 95) {
          break label107;
        }
        i1 = j;
      }
    }
    if (i1 == 95)
    {
      i = paramInt;
      switch (m % 4)
      {
      }
    }
    for (;;)
    {
      return arrayOfByte;
      label107:
      k = j;
      if (j == 32) {
        k = 42;
      }
      j = base64_reverse_table_url[k];
      if (j < 0)
      {
        k = n;
        n = i;
        i = j;
        j = n;
        break;
      }
      switch (m % 4)
      {
      }
      for (;;)
      {
        i1 = m + 1;
        k = n;
        m = j;
        j = i;
        i = m;
        m = i1;
        break;
        arrayOfByte[paramInt] = ((byte)(j << 2));
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 4));
        arrayOfByte[k] = ((byte)((j & 0xF) << 4));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j >> 2));
        arrayOfByte[k] = ((byte)((j & 0x3) << 6));
        paramInt = k;
        continue;
        k = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | j));
        paramInt = k;
      }
      return null;
      i = paramInt + 1;
      arrayOfByte[i] = 0;
    }
  }
  
  public static String base64_encode(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    for (;;)
    {
      int n;
      int k;
      if (i < j)
      {
        n = i + 1;
        k = paramArrayOfByte[i] & 0xFF;
        if (n != j) {
          break label72;
        }
        localStringBuffer.append(base64_encode_chars[(k >>> 2)]);
        localStringBuffer.append(base64_encode_chars[((k & 0x3) << 4)]);
      }
      for (;;)
      {
        return localStringBuffer.toString();
        label72:
        m = n + 1;
        n = paramArrayOfByte[n] & 0xFF;
        if (m != j) {
          break;
        }
        localStringBuffer.append(base64_encode_chars[(k >>> 2)]);
        localStringBuffer.append(base64_encode_chars[((k & 0x3) << 4 | (n & 0xF0) >>> 4)]);
        localStringBuffer.append(base64_encode_chars[((n & 0xF) << 2)]);
      }
      i = m + 1;
      int m = paramArrayOfByte[m] & 0xFF;
      localStringBuffer.append(base64_encode_chars[(k >>> 2)]);
      localStringBuffer.append(base64_encode_chars[((k & 0x3) << 4 | (n & 0xF0) >>> 4)]);
      localStringBuffer.append(base64_encode_chars[((n & 0xF) << 2 | (m & 0xC0) >>> 6)]);
      localStringBuffer.append(base64_encode_chars[(m & 0x3F)]);
    }
  }
  
  public static long buf_len(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0L;
    }
    return paramArrayOfByte.length;
  }
  
  public static int buf_to_int16(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 1)] << 0 & 0xFF);
  }
  
  public static int buf_to_int32(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[paramInt] << 24 & 0xFF000000) + (paramArrayOfByte[(paramInt + 1)] << 16 & 0xFF0000) + (paramArrayOfByte[(paramInt + 2)] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 3)] << 0 & 0xFF);
  }
  
  public static long buf_to_int64(byte[] paramArrayOfByte, int paramInt)
  {
    return 0L + (paramArrayOfByte[paramInt] << 56 & 0x0) + (paramArrayOfByte[(paramInt + 1)] << 48 & 0x0) + (paramArrayOfByte[(paramInt + 2)] << 40 & 0x0) + (paramArrayOfByte[(paramInt + 3)] << 32 & 0x0) + (paramArrayOfByte[(paramInt + 4)] << 24 & 0xFF000000) + (paramArrayOfByte[(paramInt + 5)] << 16 & 0xFF0000) + (paramArrayOfByte[(paramInt + 6)] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 7)] << 0 & 0xFF);
  }
  
  public static int buf_to_int8(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public static String buf_to_string(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (paramArrayOfByte == null)
    {
      localObject = "";
      return localObject;
    }
    String str = "";
    int i = 0;
    for (;;)
    {
      localObject = str;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      str = str + Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF);
      str = str + Integer.toHexString(paramArrayOfByte[i] & 0xF);
      i += 1;
    }
  }
  
  public static String buf_to_string(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject;
    if (paramArrayOfByte == null)
    {
      localObject = "";
      return localObject;
    }
    int i = paramInt;
    if (paramInt > paramArrayOfByte.length) {
      i = paramArrayOfByte.length;
    }
    String str = "";
    paramInt = 0;
    for (;;)
    {
      localObject = str;
      if (paramInt >= i) {
        break;
      }
      str = str + Integer.toHexString(paramArrayOfByte[paramInt] >> 4 & 0xF);
      str = str + Integer.toHexString(paramArrayOfByte[paramInt] & 0xF);
      paramInt += 1;
    }
  }
  
  public static Boolean check_uin_account(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if ((l >= 10000L) && (l <= 4000000000L)) {
        return Boolean.valueOf(true);
      }
      return Boolean.valueOf(false);
    }
    catch (NumberFormatException paramString) {}
    return Boolean.valueOf(false);
  }
  
  public static void chg_retry_type(Context paramContext)
  {
    if (get_net_retry_type(paramContext) == 0)
    {
      set_net_retry_type(paramContext, 1);
      return;
    }
    set_net_retry_type(paramContext, 0);
  }
  
  public static byte[] compress(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
      localDeflaterOutputStream.write(paramArrayOfByte);
      localDeflaterOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte) {}
    return new byte[0];
  }
  
  public static long constructSalt()
  {
    return (get_rand_32() << 32) + get_rand_32();
  }
  
  public static void decompress(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    label205:
    for (;;)
    {
      return;
      LOGI("data len:" + paramArrayOfByte.length);
      int i = 0;
      int j = 0;
      for (;;)
      {
        if (paramArrayOfByte.length <= j + 3) {
          break label205;
        }
        int k = buf_to_int32(paramArrayOfByte, j);
        if (paramArrayOfByte.length <= j + k + 3) {
          break;
        }
        Object localObject = new byte[k];
        System.arraycopy(paramArrayOfByte, j + 4, localObject, 0, k);
        j = j + 4 + k;
        i += 1;
        LOGI("len:" + k);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localObject = new ByteArrayInputStream((byte[])localObject);
        try
        {
          localObject = new InflaterInputStream((InputStream)localObject);
          byte[] arrayOfByte = new byte[1024];
          for (;;)
          {
            k = ((InflaterInputStream)localObject).read(arrayOfByte);
            if (k == -1) {
              break;
            }
            localByteArrayOutputStream.write(arrayOfByte, 0, k);
          }
          LOGI(i + localByteArrayOutputStream.toString());
        }
        catch (IOException localIOException) {}
      }
    }
  }
  
  public static void deleteExpireFile(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return;
      LOGI("file path:" + paramString);
      try
      {
        paramString = new File(paramString);
        if (!paramString.isDirectory()) {
          continue;
        }
        paramString = paramString.listFiles(new e());
        if (paramString == null) {
          continue;
        }
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          if ((!paramString[i].isDirectory()) && ((System.currentTimeMillis() - paramString[i].lastModified()) / 1000L > paramInt)) {
            paramString[i].delete();
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramString) {}
    }
  }
  
  public static void deleteExpireLog(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      if ((t.ay != null) && (t.ay.length() != 0))
      {
        deleteExpireFile(t.ay, 691200);
        return;
      }
      if (ExistSDCard())
      {
        File localFile = paramContext.getExternalCacheDir();
        deleteExpireFile(localFile.getAbsolutePath() + "/" + "tencent/wtlogin" + "/" + paramContext.getPackageName(), 691200);
        return;
      }
      paramContext = paramContext.getFilesDir().getPath();
      deleteExpireFile(paramContext + "/" + "tencent/wtlogin", 259200);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static int format_ret_code(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 17;
    case 0: 
      return 0;
    case -1000: 
      return 1;
    case 2: 
      return 2;
    }
    return 5;
  }
  
  public static byte[] generateGuid(Context paramContext)
  {
    if ((t.ak != null) && (t.ak.length != 0))
    {
      LOGI("generate guid from customer guid");
      return t.ak;
    }
    LOGI("generate guid temporarily");
    String str = getAndroidId(paramContext);
    LOGI("android_id " + str, "");
    paramContext = getMacAddr(paramContext);
    LOGI("mac " + paramContext, "");
    return MD5.toMD5Byte((str + paramContext).getBytes());
  }
  
  public static KeyPair generateRSAKeyPair()
  {
    try
    {
      Object localObject = KeyPairGenerator.getInstance("RSA");
      ((KeyPairGenerator)localObject).initialize(1024);
      localObject = ((KeyPairGenerator)localObject).generateKeyPair();
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getAndroidId(Context paramContext)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2;
        LOGI("throw " + Log.getStackTraceString(localThrowable), "");
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty(localObject1))
    {
      localObject2 = getRandomAndroidId(paramContext);
      LOGI("getRandomAndroidId " + (String)localObject2, "");
    }
    return localObject2;
  }
  
  public static byte[] getAppName(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0);
      if (localApplicationInfo != null)
      {
        paramContext = paramContext.getPackageManager().getApplicationLabel(localApplicationInfo).toString();
        if (paramContext != null)
        {
          paramContext = paramContext.getBytes();
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static String getBaseband()
  {
    try
    {
      Object localObject1 = Class.forName("android.os.SystemProperties");
      Object localObject2 = ((Class)localObject1).newInstance();
      localObject1 = (String)((Class)localObject1).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject2, new Object[] { "gsm.version.baseband", "no message" });
      return localObject1;
    }
    catch (Exception localException) {}
    return "";
  }
  
  /* Error */
  public static String getBootId()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 793	java/io/FileReader
    //   5: dup
    //   6: ldc_w 795
    //   9: invokespecial 796	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: aload_0
    //   14: astore_1
    //   15: new 798	java/io/BufferedReader
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 801	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: invokevirtual 804	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +20 -> 48
    //   31: aload_0
    //   32: ifnull +7 -> 39
    //   35: aload_0
    //   36: invokevirtual 805	java/io/FileReader:close	()V
    //   39: aload_2
    //   40: areturn
    //   41: astore_0
    //   42: aload_0
    //   43: invokevirtual 808	java/io/IOException:printStackTrace	()V
    //   46: aload_2
    //   47: areturn
    //   48: aload_0
    //   49: ifnull +7 -> 56
    //   52: aload_0
    //   53: invokevirtual 805	java/io/FileReader:close	()V
    //   56: ldc 193
    //   58: areturn
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 808	java/io/IOException:printStackTrace	()V
    //   64: goto -8 -> 56
    //   67: astore_0
    //   68: aload_1
    //   69: astore_0
    //   70: ldc_w 810
    //   73: ldc 193
    //   75: invokestatic 812	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_0
    //   79: ifnull -23 -> 56
    //   82: aload_0
    //   83: invokevirtual 805	java/io/FileReader:close	()V
    //   86: goto -30 -> 56
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 808	java/io/IOException:printStackTrace	()V
    //   94: goto -38 -> 56
    //   97: astore_0
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: astore_1
    //   102: ldc_w 814
    //   105: ldc 193
    //   107: invokestatic 812	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_0
    //   111: ifnull -55 -> 56
    //   114: aload_0
    //   115: invokevirtual 805	java/io/FileReader:close	()V
    //   118: goto -62 -> 56
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 808	java/io/IOException:printStackTrace	()V
    //   126: goto -70 -> 56
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_1
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 805	java/io/FileReader:close	()V
    //   140: aload_0
    //   141: athrow
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 808	java/io/IOException:printStackTrace	()V
    //   147: goto -7 -> 140
    //   150: astore_0
    //   151: goto -19 -> 132
    //   154: astore_2
    //   155: aload_0
    //   156: astore_1
    //   157: aload_2
    //   158: astore_0
    //   159: goto -27 -> 132
    //   162: astore_1
    //   163: goto -63 -> 100
    //   166: astore_1
    //   167: goto -97 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	24	0	localFileReader	java.io.FileReader
    //   41	12	0	localIOException1	IOException
    //   59	2	0	localIOException2	IOException
    //   67	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   69	14	0	localObject1	Object
    //   89	2	0	localIOException3	IOException
    //   97	1	0	localIOException4	IOException
    //   99	16	0	localObject2	Object
    //   121	2	0	localIOException5	IOException
    //   129	12	0	localObject3	Object
    //   150	6	0	localObject4	Object
    //   158	1	0	localObject5	Object
    //   1	136	1	localObject6	Object
    //   142	2	1	localIOException6	IOException
    //   156	1	1	localObject7	Object
    //   162	1	1	localIOException7	IOException
    //   166	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   26	21	2	str	String
    //   154	4	2	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   35	39	41	java/io/IOException
    //   52	56	59	java/io/IOException
    //   2	13	67	java/io/FileNotFoundException
    //   82	86	89	java/io/IOException
    //   2	13	97	java/io/IOException
    //   114	118	121	java/io/IOException
    //   2	13	129	finally
    //   136	140	142	java/io/IOException
    //   15	27	150	finally
    //   102	110	150	finally
    //   70	78	154	finally
    //   15	27	162	java/io/IOException
    //   15	27	166	java/io/FileNotFoundException
  }
  
  public static String getChannelId(Context paramContext, String paramString)
  {
    int i = 0;
    Object localObject2;
    if (paramString != null)
    {
      localObject2 = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject2 = paramContext.getPackageName();
    }
    paramString = "";
    paramContext = paramContext.getPackageManager();
    Object localObject1 = paramString;
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject3 = paramContext.getPackageInfo((String)localObject2, 0).applicationInfo.sourceDir;
        localObject1 = paramString;
        localObject2 = new StringBuilder().append("pkg ").append((String)localObject2).append(" path ");
        if (localObject3 != null) {
          break label468;
        }
        paramContext = "null";
        localObject1 = paramString;
        LOGI(paramContext, "");
        if (localObject3 == null) {
          break label465;
        }
        localObject1 = paramString;
        if (((String)localObject3).length() == 0) {
          return "";
        }
        localObject1 = paramString;
        paramContext = new byte[4];
        localObject1 = paramString;
        paramContext[0] = 80;
        paramContext[1] = 75;
        paramContext[2] = 5;
        paramContext[3] = 6;
        paramContext;
        localObject1 = paramString;
        localObject2 = new FileInputStream((String)localObject3);
        localObject1 = paramString;
        l = ((FileInputStream)localObject2).available();
        localObject1 = paramString;
        localObject3 = new byte[(int)(l - ((FileInputStream)localObject2).skip(l - 256L))];
        localObject1 = paramString;
        ((FileInputStream)localObject2).read((byte[])localObject3);
        localObject1 = paramString;
        ((FileInputStream)localObject2).close();
        localObject1 = paramString;
        if (i >= localObject3.length - 4) {
          break label457;
        }
        if ((localObject3[i] == paramContext[0]) && (localObject3[(i + 1)] == paramContext[1]) && (localObject3[(i + 2)] == paramContext[2]) && (localObject3[(i + 3)] == paramContext[3]))
        {
          l = i;
          if (l == -1L) {
            break label465;
          }
          i = (int)l + 20;
          int j = localObject3[i];
          i = (localObject3[(i + 1)] << 8) + j;
          if (i == 0) {
            break label465;
          }
          localObject1 = paramString;
          localObject2 = new byte[i];
          localObject1 = paramString;
          System.arraycopy(localObject3, (int)(l + 20L), localObject2, 0, i);
          localObject1 = paramString;
          localObject3 = Pattern.compile("channelId=(\\S+)").matcher(new String((byte[])localObject2));
          paramContext = paramString;
          localObject1 = paramString;
          if (((Matcher)localObject3).find())
          {
            localObject1 = paramString;
            paramContext = ((Matcher)localObject3).group(1);
          }
          localObject1 = paramContext;
          LOGI("found comment " + new String((byte[])localObject2) + " channelId:" + paramContext, "");
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        printException(paramContext, "");
        return localObject1;
      }
      i += 1;
      continue;
      label457:
      long l = -1L;
      continue;
      label465:
      return "";
      label468:
      paramContext = (Context)localObject3;
    }
  }
  
  public static String getCurrentDay()
  {
    try
    {
      if (DAYFORMAT == null) {
        DAYFORMAT = new SimpleDateFormat("yyyyMMdd");
      }
      String str = DAYFORMAT.format(new Date());
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String getCurrentPid()
  {
    return "[" + Process.myPid() + "]";
  }
  
  public static String getDate()
  {
    try
    {
      String str = "[" + System.currentTimeMillis() + "]";
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static long getFileModifyTime(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        paramString = new File(paramString);
        if ((paramString.exists()) && (paramString.isFile()))
        {
          long l = paramString.lastModified();
          return l;
        }
      }
      catch (Exception paramString) {}
    }
    return 0L;
  }
  
  public static int getFileSize(String paramString)
  {
    int j = 0;
    try
    {
      paramString = new File(paramString);
      int i = j;
      if (paramString.exists())
      {
        i = j;
        if (paramString.isFile())
        {
          long l = paramString.length();
          i = (int)l;
        }
      }
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  /* Error */
  public static byte[] getGuidFromFile(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 673	oicq/wlogin_sdk/request/t:ak	[B
    //   5: ifnull +24 -> 29
    //   8: getstatic 673	oicq/wlogin_sdk/request/t:ak	[B
    //   11: arraylength
    //   12: ifeq +17 -> 29
    //   15: ldc_w 921
    //   18: ldc 193
    //   20: invokestatic 391	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: getstatic 673	oicq/wlogin_sdk/request/t:ak	[B
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: ldc_w 923
    //   32: ldc 193
    //   34: invokestatic 391	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_0
    //   38: ifnull -11 -> 27
    //   41: iconst_0
    //   42: newarray byte
    //   44: astore_3
    //   45: new 612	java/io/File
    //   48: dup
    //   49: new 341	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   56: aload_0
    //   57: invokevirtual 661	android/content/Context:getFilesDir	()Ljava/io/File;
    //   60: invokevirtual 653	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   63: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 925
    //   69: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 614	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore_2
    //   79: aload_2
    //   80: ifnull +230 -> 310
    //   83: aload_2
    //   84: invokevirtual 911	java/io/File:exists	()Z
    //   87: ifeq +223 -> 310
    //   90: new 839	java/io/FileInputStream
    //   93: dup
    //   94: aload_2
    //   95: invokespecial 928	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   98: astore 5
    //   100: aload 5
    //   102: astore 4
    //   104: aload_3
    //   105: astore_2
    //   106: aload 5
    //   108: invokevirtual 843	java/io/FileInputStream:available	()I
    //   111: istore_1
    //   112: aload 5
    //   114: astore 4
    //   116: aload_3
    //   117: astore_2
    //   118: iload_1
    //   119: sipush 1024
    //   122: if_icmpge +32 -> 154
    //   125: aload 5
    //   127: astore 4
    //   129: aload_3
    //   130: astore_2
    //   131: iload_1
    //   132: newarray byte
    //   134: astore_3
    //   135: aload 5
    //   137: astore 4
    //   139: aload_3
    //   140: astore_2
    //   141: aload 5
    //   143: aload_3
    //   144: invokevirtual 850	java/io/FileInputStream:read	([B)I
    //   147: pop
    //   148: aload_3
    //   149: astore_2
    //   150: aload 5
    //   152: astore 4
    //   154: aload_2
    //   155: astore_3
    //   156: aload 4
    //   158: ifnull +147 -> 305
    //   161: aload 4
    //   163: invokevirtual 851	java/io/FileInputStream:close	()V
    //   166: aload_2
    //   167: ifnull +10 -> 177
    //   170: aload_2
    //   171: astore_3
    //   172: aload_2
    //   173: arraylength
    //   174: ifgt -147 -> 27
    //   177: aload_0
    //   178: invokestatic 931	oicq/wlogin_sdk/tools/util:get_saved_android_id	(Landroid/content/Context;)[B
    //   181: astore_2
    //   182: aload_2
    //   183: astore_3
    //   184: aload_2
    //   185: ifnull -158 -> 27
    //   188: aload_2
    //   189: astore_3
    //   190: aload_2
    //   191: arraylength
    //   192: ifle -165 -> 27
    //   195: aload_0
    //   196: aload_2
    //   197: invokestatic 935	oicq/wlogin_sdk/tools/util:saveGuidToFile	(Landroid/content/Context;[B)V
    //   200: aload_2
    //   201: areturn
    //   202: astore_3
    //   203: aload_3
    //   204: ldc 193
    //   206: invokestatic 452	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   209: goto -43 -> 166
    //   212: astore 4
    //   214: aconst_null
    //   215: astore 5
    //   217: aload_3
    //   218: astore_2
    //   219: aload 4
    //   221: astore_3
    //   222: aload 5
    //   224: astore 4
    //   226: getstatic 937	oicq/wlogin_sdk/request/t:Z	I
    //   229: ldc_w 938
    //   232: ior
    //   233: putstatic 937	oicq/wlogin_sdk/request/t:Z	I
    //   236: aload 5
    //   238: astore 4
    //   240: aload_3
    //   241: ldc 193
    //   243: invokestatic 452	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   246: aload_2
    //   247: astore_3
    //   248: aload 5
    //   250: ifnull +55 -> 305
    //   253: aload 5
    //   255: invokevirtual 851	java/io/FileInputStream:close	()V
    //   258: goto -92 -> 166
    //   261: astore_3
    //   262: aload_3
    //   263: ldc 193
    //   265: invokestatic 452	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   268: goto -102 -> 166
    //   271: astore_0
    //   272: aconst_null
    //   273: astore 4
    //   275: aload 4
    //   277: ifnull +8 -> 285
    //   280: aload 4
    //   282: invokevirtual 851	java/io/FileInputStream:close	()V
    //   285: aload_0
    //   286: athrow
    //   287: astore_2
    //   288: aload_2
    //   289: ldc 193
    //   291: invokestatic 452	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   294: goto -9 -> 285
    //   297: astore_0
    //   298: goto -23 -> 275
    //   301: astore_3
    //   302: goto -80 -> 222
    //   305: aload_3
    //   306: astore_2
    //   307: goto -141 -> 166
    //   310: aconst_null
    //   311: astore 4
    //   313: aload_3
    //   314: astore_2
    //   315: goto -161 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	318	0	paramContext	Context
    //   111	21	1	i	int
    //   78	169	2	localObject1	Object
    //   287	2	2	localIOException1	IOException
    //   306	9	2	localException1	Exception
    //   1	189	3	localObject2	Object
    //   202	16	3	localIOException2	IOException
    //   221	27	3	localObject3	Object
    //   261	2	3	localIOException3	IOException
    //   301	13	3	localException2	Exception
    //   102	60	4	localFileInputStream1	FileInputStream
    //   212	8	4	localException3	Exception
    //   224	88	4	localFileInputStream2	FileInputStream
    //   98	156	5	localFileInputStream3	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   161	166	202	java/io/IOException
    //   45	79	212	java/lang/Exception
    //   83	100	212	java/lang/Exception
    //   253	258	261	java/io/IOException
    //   45	79	271	finally
    //   83	100	271	finally
    //   280	285	287	java/io/IOException
    //   106	112	297	finally
    //   131	135	297	finally
    //   141	148	297	finally
    //   226	236	297	finally
    //   240	246	297	finally
    //   106	112	301	java/lang/Exception
    //   131	135	301	java/lang/Exception
    //   141	148	301	java/lang/Exception
  }
  
  public static byte[] getIccid(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = paramContext.getSimSerialNumber();
        if (paramContext != null)
        {
          paramContext = paramContext.getBytes();
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static String getInnerVersion()
  {
    if (Build.DISPLAY.contains(Build.VERSION.INCREMENTAL)) {
      return Build.DISPLAY;
    }
    return Build.VERSION.INCREMENTAL;
  }
  
  public static String getLanguage(Context paramContext)
  {
    paramContext = paramContext.getResources().getConfiguration().locale.getCountry();
    if (paramContext.equals("CN")) {
      return "CN";
    }
    if (paramContext.equals("TW")) {
      return "TW";
    }
    return "EN";
  }
  
  public static String getLineInfo(int paramInt)
  {
    if (paramInt < 0) {
      return "";
    }
    try
    {
      Object localObject = new Throwable().getStackTrace()[paramInt];
      localObject = "[" + ((StackTraceElement)localObject).getFileName() + ":" + ((StackTraceElement)localObject).getLineNumber() + "]";
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static String getLogDir(Context paramContext)
  {
    if ((t.ay != null) && (t.ay.length() != 0)) {
      return t.ay;
    }
    try
    {
      if (ExistSDCard()) {
        return paramContext.getExternalCacheDir().getAbsolutePath() + "/" + "tencent/wtlogin" + "/" + paramContext.getPackageName();
      }
      paramContext = paramContext.getFilesDir().getPath();
      paramContext = paramContext + "/" + "tencent/wtlogin";
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  public static String getLogFileName(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    paramContext = getLogDir(paramContext);
    return paramContext + "/wtlogin_" + paramString + ".log";
  }
  
  public static long getLogModifyTime(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
      return 0L;
    }
    return getFileModifyTime(getLogFileName(paramContext, paramString));
  }
  
  public static String getMacAddr(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = paramContext.getConnectionInfo();
        if (paramContext != null)
        {
          paramContext = paramContext.getMacAddress();
          boolean bool = TextUtils.isEmpty(paramContext);
          if (!bool) {
            return paramContext;
          }
        }
      }
    }
    catch (Throwable paramContext) {}
    return "02:00:00:00:00:00";
  }
  
  public static String getMaskBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte == null) {
      return "null";
    }
    paramArrayOfByte = new String(paramArrayOfByte);
    if (paramInt1 + paramInt2 > paramArrayOfByte.length()) {
      return "***";
    }
    return paramArrayOfByte.substring(0, paramInt1) + "***" + paramArrayOfByte.substring(paramArrayOfByte.length() - paramInt2);
  }
  
  public static String getMaskString(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramString.length()) {
      return "***";
    }
    return paramString.substring(0, paramInt1) + "***" + paramString.substring(paramString.length() - paramInt2);
  }
  
  public static byte[] getPkgSigFromApkName(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if ((paramContext.signatures == null) || (paramContext.signatures.length <= 0) || (paramContext.signatures[0] == null)) {
        return new byte[0];
      }
      paramContext = MD5.toMD5Byte(paramContext.signatures[0].toByteArray());
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  /* Error */
  public static String getProcVersion()
  {
    // Byte code:
    //   0: new 793	java/io/FileReader
    //   3: dup
    //   4: ldc_w 1056
    //   7: invokespecial 796	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: new 798	java/io/BufferedReader
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 801	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: invokevirtual 804	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +20 -> 46
    //   29: aload_1
    //   30: ifnull +7 -> 37
    //   33: aload_1
    //   34: invokevirtual 805	java/io/FileReader:close	()V
    //   37: aload_2
    //   38: areturn
    //   39: astore_0
    //   40: aload_0
    //   41: invokevirtual 808	java/io/IOException:printStackTrace	()V
    //   44: aload_2
    //   45: areturn
    //   46: aload_1
    //   47: ifnull +7 -> 54
    //   50: aload_1
    //   51: invokevirtual 805	java/io/FileReader:close	()V
    //   54: ldc 193
    //   56: areturn
    //   57: astore_0
    //   58: aload_0
    //   59: invokevirtual 808	java/io/IOException:printStackTrace	()V
    //   62: goto -8 -> 54
    //   65: astore_2
    //   66: aconst_null
    //   67: astore_1
    //   68: aload_1
    //   69: astore_0
    //   70: new 341	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 1058
    //   80: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: aload_2
    //   84: invokevirtual 408	java/lang/Exception:toString	()Ljava/lang/String;
    //   87: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: ldc 193
    //   95: invokestatic 812	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload_1
    //   99: ifnull -45 -> 54
    //   102: aload_1
    //   103: invokevirtual 805	java/io/FileReader:close	()V
    //   106: goto -52 -> 54
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 808	java/io/IOException:printStackTrace	()V
    //   114: goto -60 -> 54
    //   117: astore_1
    //   118: aconst_null
    //   119: astore_0
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 805	java/io/FileReader:close	()V
    //   128: aload_1
    //   129: athrow
    //   130: astore_0
    //   131: aload_0
    //   132: invokevirtual 808	java/io/IOException:printStackTrace	()V
    //   135: goto -7 -> 128
    //   138: astore_1
    //   139: goto -19 -> 120
    //   142: astore_2
    //   143: goto -75 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	1	0	localFileReader1	java.io.FileReader
    //   39	2	0	localIOException1	IOException
    //   57	2	0	localIOException2	IOException
    //   69	1	0	localFileReader2	java.io.FileReader
    //   109	2	0	localIOException3	IOException
    //   119	6	0	localObject1	Object
    //   130	2	0	localIOException4	IOException
    //   10	93	1	localFileReader3	java.io.FileReader
    //   117	12	1	localObject2	Object
    //   138	1	1	localObject3	Object
    //   24	21	2	str	String
    //   65	19	2	localException1	Exception
    //   142	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   33	37	39	java/io/IOException
    //   50	54	57	java/io/IOException
    //   0	11	65	java/lang/Exception
    //   102	106	109	java/io/IOException
    //   0	11	117	finally
    //   124	128	130	java/io/IOException
    //   13	25	138	finally
    //   70	98	138	finally
    //   13	25	142	java/lang/Exception
  }
  
  public static String getRandomAndroidId(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 4);
    Object localObject = paramContext.getString("random_AndroidId", null);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      return localObject;
    }
    localObject = new StringBuffer();
    int i = 0;
    while (i < 15)
    {
      ((StringBuffer)localObject).append(new Random().nextInt(10));
      i += 1;
    }
    localObject = ((StringBuffer)localObject).toString();
    paramContext = paramContext.edit();
    paramContext.putString("random_AndroidId", (String)localObject);
    paramContext.commit();
    return localObject;
  }
  
  public static byte[] getRequestInitTime()
  {
    byte[] arrayOfByte = new byte[4];
    int64_to_buf32(arrayOfByte, 0, System.currentTimeMillis() / 1000L + t.ae);
    return arrayOfByte;
  }
  
  public static String getSvnVersion()
  {
    return "[2424]";
  }
  
  public static String getThreadId()
  {
    return "[" + Thread.currentThread().getId() + "]";
  }
  
  public static String getUser(String paramString)
  {
    if (paramString != null) {
      return "[" + paramString + "]";
    }
    return "[]";
  }
  
  public static byte[] get_IMSI(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        paramContext = paramContext.getSubscriberId();
        if (paramContext != null)
        {
          paramContext = paramContext.getBytes();
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_android_dev_info(Context paramContext)
  {
    Object localObject2 = new byte[0];
    Object localObject1 = localObject2;
    try
    {
      String str1 = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      localObject1 = localObject2;
      String str2 = Build.BOOTLOADER;
      localObject1 = localObject2;
      String str3 = getProcVersion();
      localObject1 = localObject2;
      String str4 = Build.VERSION.CODENAME;
      localObject1 = localObject2;
      String str5 = Build.VERSION.INCREMENTAL;
      localObject1 = localObject2;
      String str6 = Build.FINGERPRINT;
      localObject1 = localObject2;
      String str7 = getBootId();
      localObject1 = localObject2;
      String str8 = getBaseband();
      localObject1 = localObject2;
      String str9 = getInnerVersion();
      localObject1 = localObject2;
      paramContext = new device_report.DeviceReport();
      localObject1 = localObject2;
      paramContext.bytes_bootloader.set(ByteStringMicro.copyFromUtf8(str2));
      localObject1 = localObject2;
      paramContext.bytes_version.set(ByteStringMicro.copyFromUtf8(str3));
      localObject1 = localObject2;
      paramContext.bytes_codename.set(ByteStringMicro.copyFromUtf8(str4));
      localObject1 = localObject2;
      paramContext.bytes_incremental.set(ByteStringMicro.copyFromUtf8(str5));
      localObject1 = localObject2;
      paramContext.bytes_fingerprint.set(ByteStringMicro.copyFromUtf8(str6));
      localObject1 = localObject2;
      paramContext.bytes_boot_id.set(ByteStringMicro.copyFromUtf8(str7));
      localObject1 = localObject2;
      paramContext.bytes_android_id.set(ByteStringMicro.copyFromUtf8(str1));
      localObject1 = localObject2;
      paramContext.bytes_baseband.set(ByteStringMicro.copyFromUtf8(str8));
      localObject1 = localObject2;
      paramContext.bytes_inner_ver.set(ByteStringMicro.copyFromUtf8(str9));
      localObject1 = localObject2;
      paramContext = paramContext.toByteArray();
      localObject1 = paramContext;
      localObject2 = new StringBuilder(300);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str3).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str4).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str5).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str6).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str7).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str1).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str8).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str9).append("\n");
      localObject1 = paramContext;
      LOGI(((StringBuilder)localObject2).toString(), "");
      localObject1 = paramContext;
    }
    catch (Throwable paramContext)
    {
      label375:
      break label375;
    }
    if (localObject1 != null)
    {
      paramContext = (Context)localObject1;
      if (localObject1.length > 0) {}
    }
    else
    {
      paramContext = new byte[0];
    }
    return paramContext;
  }
  
  public static byte[] get_android_id(Context paramContext)
  {
    paramContext = getAndroidId(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      return paramContext.getBytes();
    }
    return new byte[0];
  }
  
  public static byte[] get_apk_id(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageName().getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_apk_v(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName.getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static String get_apn_string(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 0)
      {
        paramContext = paramContext.getExtraInfo();
        if (paramContext != null) {
          return paramContext;
        }
      }
      else
      {
        return "wifi";
      }
    }
    catch (Throwable paramContext) {}
    return "wifi";
  }
  
  public static byte[] get_bssid_addr(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = paramContext.getConnectionInfo();
        if (paramContext != null)
        {
          paramContext = paramContext.getBSSID();
          if (paramContext != null)
          {
            paramContext = paramContext.toLowerCase().getBytes();
            return paramContext;
          }
        }
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte get_char(byte paramByte)
  {
    if ((paramByte >= 48) && (paramByte <= 57)) {
      return (byte)(paramByte - 48);
    }
    if ((paramByte >= 97) && (paramByte <= 102)) {
      return (byte)(paramByte - 97 + 10);
    }
    if ((paramByte >= 65) && (paramByte <= 70)) {
      return (byte)(paramByte - 65 + 10);
    }
    return 0;
  }
  
  public static String get_cost_time(Context paramContext)
  {
    String str = "";
    if (paramContext != null) {}
    try
    {
      str = paramContext.getSharedPreferences("WLOGIN_COST", 4).getString("costTime", "");
      return str;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static String get_cost_trace(Context paramContext)
  {
    String str = "";
    if (paramContext != null) {}
    try
    {
      str = paramContext.getSharedPreferences("WLOGIN_COST", 4).getString("costTrace", "");
      return str;
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  /* Error */
  public static byte[] get_cp_pubkey(Context paramContext, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: ifnonnull +11 -> 15
    //   7: iconst_0
    //   8: newarray byte
    //   10: astore 5
    //   12: aload 5
    //   14: areturn
    //   15: aload_0
    //   16: invokevirtual 716	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   19: astore_0
    //   20: new 341	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 1232
    //   30: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 1234
    //   36: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 1236
    //   42: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 1242	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   51: astore 6
    //   53: new 341	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   60: ldc 193
    //   62: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload_1
    //   66: invokevirtual 907	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 7
    //   74: new 341	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   81: ldc 193
    //   83: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload_3
    //   87: invokevirtual 907	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore 8
    //   95: aload_0
    //   96: aload 6
    //   98: iconst_5
    //   99: anewarray 326	java/lang/String
    //   102: dup
    //   103: iconst_0
    //   104: ldc_w 1244
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: ldc_w 1246
    //   113: aastore
    //   114: dup
    //   115: iconst_2
    //   116: ldc_w 1248
    //   119: aastore
    //   120: dup
    //   121: iconst_3
    //   122: ldc_w 1250
    //   125: aastore
    //   126: dup
    //   127: iconst_4
    //   128: ldc_w 1252
    //   131: aastore
    //   132: ldc_w 1254
    //   135: iconst_2
    //   136: anewarray 326	java/lang/String
    //   139: dup
    //   140: iconst_0
    //   141: aload 7
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload 8
    //   148: aastore
    //   149: aconst_null
    //   150: invokevirtual 1260	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   153: astore_0
    //   154: aload_0
    //   155: ifnull +98 -> 253
    //   158: aload_0
    //   159: astore 5
    //   161: aload_0
    //   162: invokeinterface 1265 1 0
    //   167: ifeq +86 -> 253
    //   170: aload_0
    //   171: astore 5
    //   173: aload_0
    //   174: aload_0
    //   175: ldc_w 1250
    //   178: invokeinterface 1268 2 0
    //   183: invokeinterface 1270 2 0
    //   188: astore 6
    //   190: aload_0
    //   191: astore 5
    //   193: aload_0
    //   194: aload_0
    //   195: ldc_w 1252
    //   198: invokeinterface 1268 2 0
    //   203: invokeinterface 1270 2 0
    //   208: astore 7
    //   210: aload_0
    //   211: astore 5
    //   213: aload 6
    //   215: invokestatic 1273	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   218: aload 7
    //   220: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   223: ifeq +30 -> 253
    //   226: aload_0
    //   227: astore 5
    //   229: aload 6
    //   231: invokestatic 1277	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   234: astore 6
    //   236: aload 6
    //   238: astore 5
    //   240: aload_0
    //   241: ifnull -229 -> 12
    //   244: aload_0
    //   245: invokeinterface 1278 1 0
    //   250: aload 6
    //   252: areturn
    //   253: aload_0
    //   254: ifnull +9 -> 263
    //   257: aload_0
    //   258: invokeinterface 1278 1 0
    //   263: ldc_w 1280
    //   266: invokestatic 1277	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   269: areturn
    //   270: astore 6
    //   272: aconst_null
    //   273: astore_0
    //   274: aload_0
    //   275: astore 5
    //   277: aload 6
    //   279: ldc 193
    //   281: invokestatic 452	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   284: aload_0
    //   285: ifnull -22 -> 263
    //   288: aload_0
    //   289: invokeinterface 1278 1 0
    //   294: goto -31 -> 263
    //   297: astore_0
    //   298: aload 5
    //   300: ifnull +10 -> 310
    //   303: aload 5
    //   305: invokeinterface 1278 1 0
    //   310: aload_0
    //   311: athrow
    //   312: astore_0
    //   313: goto -15 -> 298
    //   316: astore 6
    //   318: goto -44 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	paramContext	Context
    //   0	321	1	paramLong1	long
    //   0	321	3	paramLong2	long
    //   1	303	5	localObject1	Object
    //   51	200	6	localObject2	Object
    //   270	8	6	localException1	Exception
    //   316	1	6	localException2	Exception
    //   72	147	7	str1	String
    //   93	54	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   53	154	270	java/lang/Exception
    //   53	154	297	finally
    //   161	170	312	finally
    //   173	190	312	finally
    //   193	210	312	finally
    //   213	226	312	finally
    //   229	236	312	finally
    //   277	284	312	finally
    //   161	170	316	java/lang/Exception
    //   173	190	316	java/lang/Exception
    //   193	210	316	java/lang/Exception
    //   213	226	316	java/lang/Exception
    //   229	236	316	java/lang/Exception
  }
  
  public static String get_error_msg(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return InternationMsg.a(InternationMsg.MSG_TYPE.MSG_3);
    }
    return InternationMsg.a(InternationMsg.MSG_TYPE.MSG_4);
  }
  
  public static byte[] get_ksid(Context paramContext)
  {
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ksid", new String("")));
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_last_android_id(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("last_android_id", new String("")));
      if (paramContext != null)
      {
        localObject = paramContext;
        if (paramContext.length > 0) {}
      }
      else
      {
        localObject = new byte[0];
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static int get_last_flag(Context paramContext)
  {
    try
    {
      int i = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getInt("last_flag", 0);
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static byte[] get_last_guid(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("last_guid", new String("")));
      if (paramContext != null)
      {
        localObject = paramContext;
        if (paramContext.length > 0) {}
      }
      else
      {
        localObject = new byte[0];
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static byte[] get_last_mac(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("last_mac", new String("")));
      if (paramContext != null)
      {
        localObject = paramContext;
        if (paramContext.length > 0) {}
      }
      else
      {
        localObject = new byte[0];
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static byte[] get_mac_addr(Context paramContext)
  {
    paramContext = getMacAddr(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      return paramContext.getBytes();
    }
    return new byte[0];
  }
  
  public static String get_mpasswd()
  {
    try
    {
      byte[] arrayOfByte = SecureRandom.getSeed(16);
      int i = 0;
      String str1 = "";
      String str2 = str1;
      if (i < arrayOfByte.length)
      {
        boolean bool = new Random().nextBoolean();
        int k = Math.abs(arrayOfByte[i] % 26);
        if (bool) {}
        for (int j = 97;; j = 65)
        {
          str1 = str1 + String.valueOf((char)(j + k));
          i += 1;
          break;
        }
      }
      return str2;
    }
    catch (Throwable localThrowable)
    {
      str2 = "1234567890123456";
    }
  }
  
  public static int get_net_retry_type(Context paramContext)
  {
    try
    {
      int i = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getInt("netretry_type", 0);
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static int get_network_type(Context paramContext)
  {
    try
    {
      i = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getType();
      if (i == 0) {
        return 1;
      }
    }
    catch (Throwable paramContext)
    {
      int i;
      for (;;)
      {
        i = 0;
      }
      if (i == 1) {
        return 2;
      }
    }
    return 0;
  }
  
  public static byte[] get_os_type()
  {
    return "android".getBytes();
  }
  
  public static byte[] get_os_version()
  {
    return Build.VERSION.RELEASE.getBytes();
  }
  
  public static boolean get_pow_test(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null) {}
    try
    {
      bool1 = paramContext.getSharedPreferences("WLOGIN_COST", 4).getBoolean("powTest", false);
      LOGI("get_pow_test " + bool1, "");
      return bool1;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
  }
  
  public static byte[] get_prand_16byte()
  {
    try
    {
      byte[] arrayOfByte = new byte[16];
      int32_to_buf(arrayOfByte, 0, (int)(Math.random() * 2147483647.0D));
      int32_to_buf(arrayOfByte, 4, (int)(Math.random() * 2147483647.0D));
      int32_to_buf(arrayOfByte, 8, (int)(Math.random() * 2147483647.0D));
      int32_to_buf(arrayOfByte, 12, (int)(Math.random() * 2147483647.0D));
      arrayOfByte = MD5.toMD5Byte(arrayOfByte);
      return arrayOfByte;
    }
    catch (Throwable localThrowable) {}
    return new byte[16];
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(4)
  public static String get_proxy_ip()
  {
    if (Build.VERSION.SDK_INT < HONEYCOMB) {
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  @SuppressLint({"NewApi", "NewApi"})
  @TargetApi(4)
  public static int get_proxy_port()
  {
    if (Build.VERSION.SDK_INT < HONEYCOMB) {
      return Proxy.getDefaultPort();
    }
    try
    {
      int i = Integer.parseInt(System.getProperty("http.proxyPort"));
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
    }
    return -1;
  }
  
  public static byte[] get_qimei(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("DENGTA_META", 0);
      if (paramContext != null)
      {
        paramContext = paramContext.getString("QIMEI_DENGTA", "");
        if (!TextUtils.isEmpty(paramContext))
        {
          paramContext = MD5.toMD5Byte(paramContext.getBytes());
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      LOGD("" + Log.getStackTraceString(paramContext), "");
    }
    return new byte[0];
  }
  
  public static byte[] get_rand_16byte(SecureRandom paramSecureRandom)
  {
    try
    {
      byte[] arrayOfByte = new byte[16];
      paramSecureRandom.nextBytes(arrayOfByte);
      return arrayOfByte;
    }
    catch (Throwable paramSecureRandom) {}
    return get_prand_16byte();
  }
  
  public static byte[] get_rand_16byte(byte[] paramArrayOfByte)
  {
    try
    {
      byte[] arrayOfByte1 = SecureRandom.getSeed(16);
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
      paramArrayOfByte = MD5.toMD5Byte(arrayOfByte2);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return get_prand_16byte();
  }
  
  public static int get_rand_32()
  {
    return (int)(Math.random() * 2147483647.0D);
  }
  
  public static String get_release_time()
  {
    return "2020/03/27 16:19:21";
  }
  
  public static byte[] get_rsa_privkey(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("rsa_privkey", ""));
      if (paramContext != null)
      {
        localObject = paramContext;
        if (paramContext.length > 0) {}
      }
      else
      {
        localObject = new byte[0];
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static byte[] get_rsa_pubkey(Context paramContext)
  {
    Object localObject = new byte[0];
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getString("rsa_pubkey", ""));
      if (paramContext != null)
      {
        localObject = paramContext;
        if (paramContext.length > 0) {}
      }
      else
      {
        localObject = new byte[0];
      }
      return localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static byte[] get_saved_android_id(Context paramContext)
  {
    try
    {
      paramContext = string_to_buf(paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("android_id", new String("")));
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      printThrowable(paramContext, "");
    }
    return new byte[0];
  }
  
  public static int get_saved_network_type(Context paramContext)
  {
    try
    {
      int i = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getInt("network_type", 0);
      return i;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static long get_server_cur_time()
  {
    return t.g();
  }
  
  public static byte[] get_server_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_server_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_server_ipv6_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ipv6_host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_server_ipv6_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ipv6_host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_sim_operator_name(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext.getSimState() == 5)
      {
        paramContext = paramContext.getSimOperatorName().getBytes();
        return paramContext;
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_ssid_addr(Context paramContext)
  {
    try
    {
      paramContext = (WifiManager)paramContext.getSystemService("wifi");
      if (paramContext != null)
      {
        paramContext = paramContext.getConnectionInfo();
        if (paramContext != null)
        {
          paramContext = paramContext.getSSID();
          if (paramContext != null)
          {
            paramContext = paramContext.getBytes();
            return paramContext;
          }
        }
      }
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_wap_server_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_wap_server_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_wap_server_ipv6_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-ipv6_host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static byte[] get_wap_server_ipv6_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-ipv6_host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return new byte[0];
  }
  
  public static void int16_to_buf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 0));
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 8));
  }
  
  public static void int32_to_buf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 >> 0));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 16));
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 24));
  }
  
  public static void int64_to_buf(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)(paramLong >> 0));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 32));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 40));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 48));
    paramArrayOfByte[(paramInt + 0)] = ((byte)(int)(paramLong >> 56));
  }
  
  public static void int64_to_buf32(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)(paramLong >> 0));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 0)] = ((byte)(int)(paramLong >> 24));
  }
  
  public static void int8_to_buf(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 0));
  }
  
  public static boolean isFileExist(String paramString)
  {
    try
    {
      boolean bool = new File(paramString).exists();
      return bool;
    }
    catch (Exception paramString) {}
    return false;
  }
  
  public static boolean isMQQExist(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext = paramContext.getPackageInfo("com.tencent.mobileqq", 0);
        if (paramContext == null) {
          continue;
        }
        paramContext = paramContext.versionName;
        if (paramContext.compareTo("4.6.0") >= 0) {
          return true;
        }
        try
        {
          int i = Integer.parseInt(paramContext.substring(0, paramContext.indexOf(".")));
          if (i < 10) {
            continue;
          }
          return true;
        }
        catch (Exception paramContext)
        {
          printException(paramContext, "");
          return false;
        }
        return false;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public static boolean isPackageExist(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      LOGI(paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName, "");
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean is_wap_proxy_retry(Context paramContext)
  {
    try
    {
      paramContext = get_apn_string(paramContext);
      if (paramContext != null)
      {
        if (paramContext.equalsIgnoreCase("cmwap")) {
          return true;
        }
        if ((paramContext.equalsIgnoreCase("uniwap")) || (paramContext.equalsIgnoreCase("ctwap"))) {
          break label59;
        }
        boolean bool = paramContext.equalsIgnoreCase("3gwap");
        if (bool) {
          break label59;
        }
      }
    }
    catch (Throwable paramContext)
    {
      label53:
      break label53;
    }
    return false;
    label59:
    return true;
  }
  
  public static boolean is_wap_retry(Context paramContext)
  {
    return get_net_retry_type(paramContext) != 0;
  }
  
  /* Error */
  public static boolean loadLibrary(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: getstatic 201	oicq/wlogin_sdk/tools/util:loadEncryptSo	Z
    //   3: ifne +5 -> 8
    //   6: iconst_0
    //   7: ireturn
    //   8: getstatic 206	android/os/Build$VERSION:SDK_INT	I
    //   11: bipush 23
    //   13: if_icmplt +5 -> 18
    //   16: iconst_0
    //   17: ireturn
    //   18: getstatic 199	oicq/wlogin_sdk/tools/util:libwtecdh_loaded	Z
    //   21: ifeq +5 -> 26
    //   24: iconst_1
    //   25: ireturn
    //   26: aload_1
    //   27: ifnull +14 -> 41
    //   30: aload_0
    //   31: ifnull +10 -> 41
    //   34: aload_0
    //   35: invokevirtual 608	java/lang/String:length	()I
    //   38: ifne +5 -> 43
    //   41: iconst_0
    //   42: ireturn
    //   43: new 612	java/io/File
    //   46: dup
    //   47: new 341	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   54: aload_1
    //   55: invokevirtual 661	android/content/Context:getFilesDir	()Ljava/io/File;
    //   58: invokevirtual 1499	java/io/File:getParent	()Ljava/lang/String;
    //   61: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: ldc_w 1501
    //   67: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_0
    //   71: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 1503
    //   77: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokespecial 614	java/io/File:<init>	(Ljava/lang/String;)V
    //   86: astore 5
    //   88: aload 5
    //   90: astore 4
    //   92: aload 5
    //   94: invokevirtual 911	java/io/File:exists	()Z
    //   97: ifne +150 -> 247
    //   100: new 612	java/io/File
    //   103: dup
    //   104: new 341	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   111: aload_1
    //   112: invokevirtual 661	android/content/Context:getFilesDir	()Ljava/io/File;
    //   115: invokevirtual 1499	java/io/File:getParent	()Ljava/lang/String;
    //   118: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc_w 1505
    //   124: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: aload_0
    //   128: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc_w 1503
    //   134: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 614	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore 4
    //   145: aload 4
    //   147: ifnull +134 -> 281
    //   150: aload 4
    //   152: invokevirtual 911	java/io/File:exists	()Z
    //   155: ifeq +126 -> 281
    //   158: aload 4
    //   160: invokevirtual 653	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   163: invokestatic 1508	java/lang/System:load	(Ljava/lang/String;)V
    //   166: iconst_1
    //   167: istore_3
    //   168: iload_3
    //   169: istore_2
    //   170: iload_3
    //   171: ifne +9 -> 180
    //   174: aload_0
    //   175: invokestatic 1510	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   178: iconst_1
    //   179: istore_2
    //   180: iload_2
    //   181: istore_3
    //   182: iload_2
    //   183: ifne +21 -> 204
    //   186: aload_1
    //   187: aload_0
    //   188: invokestatic 1515	com/tencent/commonsdk/soload/SoLoadUtilNew:loadSoByName	(Landroid/content/Context;Ljava/lang/String;)Z
    //   191: istore_3
    //   192: iload_3
    //   193: ifeq +129 -> 322
    //   196: ldc_w 1517
    //   199: ldc 193
    //   201: invokestatic 391	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: iload_3
    //   205: putstatic 199	oicq/wlogin_sdk/tools/util:libwtecdh_loaded	Z
    //   208: new 341	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   215: ldc_w 1519
    //   218: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: getstatic 199	oicq/wlogin_sdk/tools/util:libwtecdh_loaded	Z
    //   224: invokevirtual 1357	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   227: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: ldc 193
    //   232: invokestatic 391	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: iload_3
    //   236: ireturn
    //   237: astore 6
    //   239: aconst_null
    //   240: astore 4
    //   242: aload 6
    //   244: invokestatic 1522	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;)V
    //   247: goto -102 -> 145
    //   250: astore 4
    //   252: new 341	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   259: ldc_w 1524
    //   262: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 4
    //   267: invokevirtual 1527	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   270: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: ldc 193
    //   278: invokestatic 391	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: iconst_0
    //   282: istore_3
    //   283: goto -115 -> 168
    //   286: astore 4
    //   288: new 341	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   295: ldc_w 1524
    //   298: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload 4
    //   303: invokevirtual 1527	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   306: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: ldc 193
    //   314: invokestatic 391	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: iload_3
    //   318: istore_2
    //   319: goto -139 -> 180
    //   322: ldc_w 1529
    //   325: ldc 193
    //   327: invokestatic 391	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: goto -126 -> 204
    //   333: astore 6
    //   335: aload 5
    //   337: astore 4
    //   339: goto -97 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	paramString	String
    //   0	342	1	paramContext	Context
    //   169	150	2	bool1	boolean
    //   167	151	3	bool2	boolean
    //   90	151	4	localFile1	File
    //   250	16	4	localUnsatisfiedLinkError1	java.lang.UnsatisfiedLinkError
    //   286	16	4	localUnsatisfiedLinkError2	java.lang.UnsatisfiedLinkError
    //   337	1	4	localFile2	File
    //   86	250	5	localFile3	File
    //   237	6	6	localException1	Exception
    //   333	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   43	88	237	java/lang/Exception
    //   158	166	250	java/lang/UnsatisfiedLinkError
    //   174	178	286	java/lang/UnsatisfiedLinkError
    //   92	145	333	java/lang/Exception
  }
  
  public static boolean needChangeGuid(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0);
    long l2 = paramContext.getLong("change_guid_time", 0L);
    long l1 = t.f();
    if (l2 == 0L)
    {
      l2 = new Random().nextInt(GUID_DELAY_HOUR) * 60 * 60 * 1000;
      paramContext.edit().putLong("chang_guid_time", l2 + l1).commit();
    }
    while (l2 < l1) {
      return false;
    }
    paramContext.edit().putLong("chang_guid_time", 0L).commit();
    return true;
  }
  
  public static boolean need_pow_test(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      LOGI("need_pow_test false because not null");
      return false;
    }
    paramArrayOfByte = t.m();
    if ((!TextUtils.isEmpty(paramArrayOfByte)) && (paramArrayOfByte.endsWith(":MSF"))) {
      return get_pow_test(t.t);
    }
    LOGI("need_pow_test false because not msf");
    return false;
  }
  
  public static Bundle packBundle(byte[][] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      localBundle.putInt("len", paramArrayOfByte.length);
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localBundle.putByteArray(String.valueOf(i), paramArrayOfByte[i]);
        i += 1;
      }
    }
    if (localBundle.isEmpty()) {
      return null;
    }
    return localBundle;
  }
  
  public static void printException(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramException.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    LOGW("exception:", localStringWriter.toString());
  }
  
  public static void printException(Exception paramException, String paramString)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramException.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    LOGW("exception", localStringWriter.toString(), paramString);
  }
  
  public static void printThrowable(Throwable paramThrowable, String paramString)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    LOGW("throwable", localStringWriter.toString(), paramString);
  }
  
  public static byte[] readFile(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return null;
      try
      {
        Object localObject = new File(paramString);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          paramString = new FileInputStream(paramString);
          int i = paramString.available();
          if (i > 528384)
          {
            paramString.close();
            return null;
          }
          localObject = new byte[i];
          paramString.read((byte[])localObject);
          paramString.close();
          return localObject;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
  
  public static byte[] readLog(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    return readFile(getLogFileName(paramContext, paramString));
  }
  
  /* Error */
  public static void saveGuidToFile(Context paramContext, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +196 -> 197
    //   4: aload_1
    //   5: ifnull +192 -> 197
    //   8: aload_1
    //   9: arraylength
    //   10: ifle +187 -> 197
    //   13: new 341	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 1613
    //   23: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokestatic 1615	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   30: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: ldc 193
    //   38: invokestatic 391	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aconst_null
    //   42: astore 6
    //   44: aconst_null
    //   45: astore 7
    //   47: aconst_null
    //   48: astore 5
    //   50: aload 6
    //   52: astore 4
    //   54: aload 7
    //   56: astore_2
    //   57: new 612	java/io/File
    //   60: dup
    //   61: new 341	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   68: aload_0
    //   69: invokevirtual 661	android/content/Context:getFilesDir	()Ljava/io/File;
    //   72: invokevirtual 653	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   75: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 925
    //   81: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 614	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: astore 8
    //   92: aload 6
    //   94: astore 4
    //   96: aload 7
    //   98: astore_2
    //   99: aload 8
    //   101: invokevirtual 911	java/io/File:exists	()Z
    //   104: ifne +16 -> 120
    //   107: aload 6
    //   109: astore 4
    //   111: aload 7
    //   113: astore_2
    //   114: aload 8
    //   116: invokevirtual 1618	java/io/File:createNewFile	()Z
    //   119: pop
    //   120: aload 5
    //   122: astore_3
    //   123: aload 6
    //   125: astore 4
    //   127: aload 7
    //   129: astore_2
    //   130: aload 8
    //   132: invokevirtual 911	java/io/File:exists	()Z
    //   135: ifeq +44 -> 179
    //   138: aload 5
    //   140: astore_3
    //   141: aload 6
    //   143: astore 4
    //   145: aload 7
    //   147: astore_2
    //   148: aload 8
    //   150: invokevirtual 1621	java/io/File:canWrite	()Z
    //   153: ifeq +26 -> 179
    //   156: aload 6
    //   158: astore 4
    //   160: aload 7
    //   162: astore_2
    //   163: new 1623	java/io/FileOutputStream
    //   166: dup
    //   167: aload 8
    //   169: iconst_0
    //   170: invokespecial 1626	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   173: astore_3
    //   174: aload_3
    //   175: aload_1
    //   176: invokevirtual 1627	java/io/FileOutputStream:write	([B)V
    //   179: aload_3
    //   180: astore 4
    //   182: aload_3
    //   183: astore_2
    //   184: aload_0
    //   185: aload_1
    //   186: invokestatic 1630	oicq/wlogin_sdk/tools/util:save_android_id	(Landroid/content/Context;[B)V
    //   189: aload_3
    //   190: ifnull +7 -> 197
    //   193: aload_3
    //   194: invokevirtual 1631	java/io/FileOutputStream:close	()V
    //   197: return
    //   198: astore_0
    //   199: aload_0
    //   200: ldc 193
    //   202: invokestatic 452	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   205: return
    //   206: astore_0
    //   207: aload 4
    //   209: astore_2
    //   210: aload_0
    //   211: ldc 193
    //   213: invokestatic 452	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   216: aload 4
    //   218: ifnull -21 -> 197
    //   221: aload 4
    //   223: invokevirtual 1631	java/io/FileOutputStream:close	()V
    //   226: return
    //   227: astore_0
    //   228: aload_0
    //   229: ldc 193
    //   231: invokestatic 452	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   234: return
    //   235: astore_0
    //   236: aload_2
    //   237: ifnull +7 -> 244
    //   240: aload_2
    //   241: invokevirtual 1631	java/io/FileOutputStream:close	()V
    //   244: aload_0
    //   245: athrow
    //   246: astore_1
    //   247: aload_1
    //   248: ldc 193
    //   250: invokestatic 452	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   253: goto -9 -> 244
    //   256: astore_0
    //   257: aload_3
    //   258: astore_2
    //   259: goto -23 -> 236
    //   262: astore_0
    //   263: aload_3
    //   264: astore 4
    //   266: goto -59 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramContext	Context
    //   0	269	1	paramArrayOfByte	byte[]
    //   56	203	2	localObject1	Object
    //   122	142	3	localObject2	Object
    //   52	213	4	localObject3	Object
    //   48	91	5	localObject4	Object
    //   42	115	6	localObject5	Object
    //   45	116	7	localObject6	Object
    //   90	78	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   193	197	198	java/io/IOException
    //   57	92	206	java/lang/Exception
    //   99	107	206	java/lang/Exception
    //   114	120	206	java/lang/Exception
    //   130	138	206	java/lang/Exception
    //   148	156	206	java/lang/Exception
    //   163	174	206	java/lang/Exception
    //   184	189	206	java/lang/Exception
    //   221	226	227	java/io/IOException
    //   57	92	235	finally
    //   99	107	235	finally
    //   114	120	235	finally
    //   130	138	235	finally
    //   148	156	235	finally
    //   163	174	235	finally
    //   184	189	235	finally
    //   210	216	235	finally
    //   240	244	246	java/io/IOException
    //   174	179	256	finally
    //   174	179	262	java/lang/Exception
  }
  
  public static void save_android_id(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("android_id", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_cost_time(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_COST", 4).edit();
      paramContext.putString("costTime", paramString);
      paramContext.commit();
    }
  }
  
  public static void save_cost_trace(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_COST", 4).edit();
      paramContext.putString("costTrace", paramString);
      paramContext.commit();
    }
  }
  
  public static void save_cur_android_id(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("last_android_id", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_cur_flag(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putInt("last_flag", paramInt);
      paramContext.commit();
    }
  }
  
  public static void save_cur_guid(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("last_guid", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_cur_mac(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("last_mac", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_network_type(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putInt("network_type", paramInt);
      paramContext.commit();
    }
  }
  
  public static void save_pow_test(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_COST", 4).edit();
      paramContext.putBoolean("powTest", paramBoolean);
      paramContext.commit();
      LOGI("save_pow_test " + paramBoolean, "");
    }
  }
  
  public static void save_rsa_privkey(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("rsa_privkey", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void save_rsa_pubkey(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
      paramContext.putString("rsa_pubkey", buf_to_string(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  /* Error */
  public static boolean set_cp_pubkey(Context paramContext, long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aload_0
    //   7: invokevirtual 716	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 7
    //   12: new 341	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   19: ldc_w 1232
    //   22: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 1234
    //   28: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc_w 1236
    //   34: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 1242	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   43: astore 8
    //   45: aload 8
    //   47: invokevirtual 1655	android/net/Uri:toString	()Ljava/lang/String;
    //   50: invokestatic 583	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   53: new 341	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   60: ldc 193
    //   62: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload_1
    //   66: invokevirtual 907	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: astore 6
    //   74: new 341	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   81: ldc 193
    //   83: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: lload_3
    //   87: invokevirtual 907	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore 9
    //   95: aload 7
    //   97: aload 8
    //   99: iconst_5
    //   100: anewarray 326	java/lang/String
    //   103: dup
    //   104: iconst_0
    //   105: ldc_w 1244
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: ldc_w 1246
    //   114: aastore
    //   115: dup
    //   116: iconst_2
    //   117: ldc_w 1248
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: ldc_w 1250
    //   126: aastore
    //   127: dup
    //   128: iconst_4
    //   129: ldc_w 1252
    //   132: aastore
    //   133: ldc_w 1254
    //   136: iconst_2
    //   137: anewarray 326	java/lang/String
    //   140: dup
    //   141: iconst_0
    //   142: aload 6
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: aload 9
    //   149: aastore
    //   150: aconst_null
    //   151: invokevirtual 1260	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   154: astore 6
    //   156: aload 6
    //   158: ifnonnull +17 -> 175
    //   161: aload 6
    //   163: ifnull +10 -> 173
    //   166: aload 6
    //   168: invokeinterface 1278 1 0
    //   173: iconst_0
    //   174: ireturn
    //   175: aload_0
    //   176: invokestatic 1657	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   179: invokestatic 1615	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   182: astore_0
    //   183: aload_0
    //   184: invokevirtual 608	java/lang/String:length	()I
    //   187: istore 5
    //   189: iload 5
    //   191: ifne +17 -> 208
    //   194: aload 6
    //   196: ifnull +10 -> 206
    //   199: aload 6
    //   201: invokeinterface 1278 1 0
    //   206: iconst_0
    //   207: ireturn
    //   208: aload_0
    //   209: invokestatic 1273	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   212: astore 9
    //   214: aload 6
    //   216: invokeinterface 1660 1 0
    //   221: ifle +53 -> 274
    //   224: new 1662	android/content/ContentValues
    //   227: dup
    //   228: invokespecial 1663	android/content/ContentValues:<init>	()V
    //   231: astore 7
    //   233: aload 7
    //   235: ldc_w 1250
    //   238: aload_0
    //   239: invokevirtual 1666	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: aload 7
    //   244: ldc_w 1252
    //   247: aload 9
    //   249: invokevirtual 1666	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 6
    //   254: invokeinterface 1265 1 0
    //   259: pop
    //   260: aload 6
    //   262: ifnull +10 -> 272
    //   265: aload 6
    //   267: invokeinterface 1278 1 0
    //   272: iconst_1
    //   273: ireturn
    //   274: new 1662	android/content/ContentValues
    //   277: dup
    //   278: invokespecial 1663	android/content/ContentValues:<init>	()V
    //   281: astore 10
    //   283: aload 10
    //   285: ldc_w 1246
    //   288: lload_1
    //   289: invokestatic 1669	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   292: invokevirtual 1672	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   295: aload 10
    //   297: ldc_w 1248
    //   300: lload_3
    //   301: invokestatic 1669	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   304: invokevirtual 1672	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   307: aload 10
    //   309: ldc_w 1250
    //   312: aload_0
    //   313: invokevirtual 1666	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload 10
    //   318: ldc_w 1252
    //   321: aload 9
    //   323: invokevirtual 1666	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: aload 7
    //   328: aload 8
    //   330: aload 10
    //   332: invokevirtual 1676	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   335: astore_0
    //   336: new 341	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 342	java/lang/StringBuilder:<init>	()V
    //   343: ldc_w 1678
    //   346: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: aload_0
    //   350: invokevirtual 1681	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   353: ldc_w 1683
    //   356: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: lload_1
    //   360: invokevirtual 907	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   363: ldc_w 1685
    //   366: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: lload_3
    //   370: invokevirtual 907	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   373: invokevirtual 353	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 1687	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;)V
    //   379: goto -119 -> 260
    //   382: astore 7
    //   384: aload 6
    //   386: astore_0
    //   387: aload 7
    //   389: astore 6
    //   391: aload 6
    //   393: ldc 193
    //   395: invokestatic 452	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   398: aload_0
    //   399: ifnull +9 -> 408
    //   402: aload_0
    //   403: invokeinterface 1278 1 0
    //   408: iconst_0
    //   409: ireturn
    //   410: astore_0
    //   411: aconst_null
    //   412: astore 6
    //   414: aload 6
    //   416: ifnull +10 -> 426
    //   419: aload 6
    //   421: invokeinterface 1278 1 0
    //   426: aload_0
    //   427: athrow
    //   428: astore_0
    //   429: goto -15 -> 414
    //   432: astore 7
    //   434: aload_0
    //   435: astore 6
    //   437: aload 7
    //   439: astore_0
    //   440: goto -26 -> 414
    //   443: astore 6
    //   445: aconst_null
    //   446: astore_0
    //   447: goto -56 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	paramContext	Context
    //   0	450	1	paramLong1	long
    //   0	450	3	paramLong2	long
    //   187	3	5	i	int
    //   72	364	6	localObject1	Object
    //   443	1	6	localException1	Exception
    //   10	317	7	localObject2	Object
    //   382	6	7	localException2	Exception
    //   432	6	7	localObject3	Object
    //   43	286	8	localUri	android.net.Uri
    //   93	229	9	str	String
    //   281	50	10	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   175	189	382	java/lang/Exception
    //   208	260	382	java/lang/Exception
    //   274	379	382	java/lang/Exception
    //   53	156	410	finally
    //   175	189	428	finally
    //   208	260	428	finally
    //   274	379	428	finally
    //   391	398	432	finally
    //   53	156	443	java/lang/Exception
  }
  
  public static void set_ksid(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      byte[] arrayOfByte = get_ksid(paramContext);
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
      {
        paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
        paramContext.putString("ksid", buf_to_string(paramArrayOfByte));
        paramContext.commit();
      }
    }
  }
  
  public static void set_net_retry_type(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putInt("netretry_type", paramInt);
      paramContext.commit();
    }
  }
  
  public static void set_server_host1(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("host1", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_server_host2(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("host2", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_server_ipv6_host1(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("ipv6_host1", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_server_ipv6_host2(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("ipv6_host2", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_wap_server_host1(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("wap-host1", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_wap_server_host2(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("wap-host2", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_wap_server_ipv6_host1(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("wap-ipv6_host1", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static void set_wap_server_ipv6_host2(Context paramContext, byte[] paramArrayOfByte)
  {
    if ((paramContext != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
      paramContext.putString("wap-ipv6_host2", new String(paramArrayOfByte));
      paramContext.commit();
    }
  }
  
  public static boolean shouldKick(int paramInt)
  {
    return (paramInt != -1000) && (paramInt != 257) && (paramInt != -1026);
  }
  
  public static byte[] string_to_buf(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    while (i < paramString.length() / 2)
    {
      arrayOfByte[i] = ((byte)((get_char((byte)paramString.charAt(i * 2)) << 4) + get_char((byte)paramString.charAt(i * 2 + 1))));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[][] unpackBundle(Bundle paramBundle)
  {
    int i = 0;
    if (paramBundle != null)
    {
      int j = paramBundle.getInt("len");
      byte[][] arrayOfByte2 = (byte[][])Array.newInstance(Byte.TYPE, new int[] { j, 0 });
      for (;;)
      {
        arrayOfByte1 = arrayOfByte2;
        if (i >= j) {
          break;
        }
        arrayOfByte2[i] = paramBundle.getByteArray(String.valueOf(i));
        i += 1;
      }
    }
    byte[][] arrayOfByte1 = (byte[][])null;
    return arrayOfByte1;
  }
  
  /* Error */
  public static void writeFile(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +12 -> 16
    //   7: aload_0
    //   8: invokevirtual 608	java/lang/String:length	()I
    //   11: istore_2
    //   12: iload_2
    //   13: ifne +7 -> 20
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: new 612	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 614	java/io/File:<init>	(Ljava/lang/String;)V
    //   28: astore_3
    //   29: aload_3
    //   30: invokevirtual 911	java/io/File:exists	()Z
    //   33: ifne +30 -> 63
    //   36: aload_3
    //   37: invokevirtual 1730	java/io/File:getParentFile	()Ljava/io/File;
    //   40: astore 4
    //   42: aload 4
    //   44: ifnull -28 -> 16
    //   47: aload 4
    //   49: invokevirtual 1733	java/io/File:mkdirs	()Z
    //   52: ifne +11 -> 63
    //   55: aload 4
    //   57: invokevirtual 617	java/io/File:isDirectory	()Z
    //   60: ifeq -44 -> 16
    //   63: aload_0
    //   64: invokestatic 1735	oicq/wlogin_sdk/tools/util:getFileSize	(Ljava/lang/String;)I
    //   67: ldc 135
    //   69: if_icmpge -53 -> 16
    //   72: new 1623	java/io/FileOutputStream
    //   75: dup
    //   76: aload_3
    //   77: iconst_1
    //   78: invokespecial 1626	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   81: astore_0
    //   82: aload_0
    //   83: aload_1
    //   84: invokevirtual 1627	java/io/FileOutputStream:write	([B)V
    //   87: aload_0
    //   88: invokevirtual 1631	java/io/FileOutputStream:close	()V
    //   91: goto -75 -> 16
    //   94: astore_0
    //   95: goto -79 -> 16
    //   98: astore_0
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_0
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramString	String
    //   0	104	1	paramArrayOfByte	byte[]
    //   11	2	2	i	int
    //   28	49	3	localFile1	File
    //   40	16	4	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   20	42	94	java/lang/Exception
    //   47	63	94	java/lang/Exception
    //   63	91	94	java/lang/Exception
    //   7	12	98	finally
    //   20	42	98	finally
    //   47	63	98	finally
    //   63	91	98	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.util
 * JD-Core Version:    0.7.0.1
 */