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
import android.net.Uri;
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
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import oicq.wlogin_sdk.listener.QimeiListener;
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
  public static final int ASYN_QUICKLOG_BY_GATEWAY = 19;
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
  public static final long BUILD_TIME = 1619061003L;
  public static final int BUSINESS_TYPE_LOGIN_GATEWAY = 2;
  public static final int BUSINESS_TYPE_LOGIN_SMS = 3;
  public static final int BUSINESS_TYPE_NULL = 0;
  public static final int D = 2;
  private static SimpleDateFormat DAYFORMAT;
  public static final int E_A1_DECRYPT = -1014;
  public static final int E_A1_FORMAT = -1016;
  public static final int E_A1_SEQ_ERROR = 20;
  public static final int E_ADVANCE_NOTICE = 257;
  public static final int E_APK_CHK_ERR = -1021;
  public static final int E_BUFFER_OVERFLOW = -1023;
  public static final int E_DECRYPT = -1002;
  public static final int E_ENCODING = -1013;
  public static final int E_ENCRYPTION_METHOD = -1024;
  public static final int E_GATEWAY_LOGIN_FAILED = -2005;
  public static final int E_GATEWAY_LOGIN_NUM_FAILED = -2004;
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
  public static final int E_OTHER_EXCEPTION = -2006;
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
  public static int GUID_DELAY_HOUR = 360;
  private static int HONEYCOMB = 11;
  public static final int I = 1;
  public static final int KEY_TLV543_IN_TLV199 = 1676611;
  public static LogCallBack LCB;
  public static boolean LOGCAT_OUT = false;
  public static final String LOG_DIR = "tencent/wtlogin";
  public static int LOG_LEVEL = 1;
  public static String LOG_TAG_EVENT_REPORT = "event_report";
  public static String LOG_TAG_GATEWAY_LOGIN_NEW_DOV = "gateway_login_new_dov";
  public static String LOG_TAG_POW = "pow";
  public static String LOG_TAG_QIMEI = "qimei";
  public static int MAX_APPID = 65535;
  public static final int MAX_CONTENT_SIZE = 40960;
  public static final int MAX_FILE_SIZE = 524288;
  public static final int MAX_INIT_KEY_TIME = 3;
  public static int MAX_NAME_LEN = 128;
  @SuppressLint({"NewApi"})
  private static int MODE_MULTI_PROCESS = 0;
  public static final int REG_CHECK_ERROR_FACE = 59;
  public static final String SDK_VERSION = "6.0.0.2473";
  public static final int SSO_VERSION = 17;
  public static final long SVN_VER = 2473L;
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
  public static final int TLV542 = 1346;
  public static final int W = 0;
  public static final String WT_LOGIN_URL_HOST = "txz.qq.com";
  static final char[] base64_encode_chars = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  static final char base64_pad_url = '_';
  static final short[] base64_reverse_table_url = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 63, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  private static boolean libwtecdh_loaded = false;
  public static boolean loadEncryptSo = true;
  public static String logContent = "";
  public static QimeiListener qimeiListener;
  
  static
  {
    int i;
    if (Build.VERSION.SDK_INT > 9) {
      i = 4;
    } else {
      i = 0;
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wlogin_sdk");
          localStringBuilder.append(getLineInfo(2));
          Log.d(localStringBuilder.toString(), paramString);
        }
      }
      return;
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
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("wlogin_sdk");
          ((StringBuilder)localObject).append(getLineInfo(2));
          localObject = ((StringBuilder)localObject).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append(":");
          localStringBuilder.append(paramString2);
          Log.d((String)localObject, localStringBuilder.toString());
        }
      }
      return;
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wlogin_sdk");
          localStringBuilder.append(getLineInfo(2));
          Log.i(localStringBuilder.toString(), paramString);
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void LOGI(String paramString1, String paramString2)
  {
    try
    {
      if (LOG_LEVEL >= 1)
      {
        if (LCB != null)
        {
          LCB.OnLog(paramString1);
        }
        else if (LOGCAT_OUT)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("wlogin_sdk");
          localStringBuilder.append(getLineInfo(2));
          Log.i(localStringBuilder.toString(), paramString1);
        }
        b.a(t.u, paramString2, paramString1);
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
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("wlogin_sdk");
          ((StringBuilder)localObject).append(getLineInfo(2));
          localObject = ((StringBuilder)localObject).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append(":");
          localStringBuilder.append(paramString2);
          Log.w((String)localObject, localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static void LOGW(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (LOG_LEVEL >= 0)
      {
        Object localObject = LCB;
        if (localObject != null)
        {
          LCB.OnLog(paramString1, paramString2);
        }
        else if (LOGCAT_OUT)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("wlogin_sdk");
          ((StringBuilder)localObject).append(getLineInfo(2));
          localObject = ((StringBuilder)localObject).toString();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append(":");
          localStringBuilder.append(paramString2);
          Log.w((String)localObject, localStringBuilder.toString());
        }
        localObject = t.u;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(":");
        localStringBuilder.append(paramString2);
        b.a((Context)localObject, paramString3, localStringBuilder.toString());
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public static byte[] RSADecrypt(byte[] paramArrayOfByte, Key paramKey)
  {
    if ((paramArrayOfByte != null) && (paramKey != null)) {}
    for (;;)
    {
      int i;
      int j;
      try
      {
        localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(2, paramKey);
        k = paramArrayOfByte.length;
        paramKey = new byte[k];
        if (k % 128 == 0) {
          break label180;
        }
        LOGI("len not match block size", "");
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        Cipher localCipher;
        int k;
        byte[] arrayOfByte;
        paramKey = new StringBuilder();
        paramKey.append("descypt exception:");
        paramKey.append(paramArrayOfByte.toString());
        LOGI(paramKey.toString(), "");
        return null;
      }
      if (i < k / 128)
      {
        arrayOfByte = new byte[''];
        System.arraycopy(paramArrayOfByte, i * 128, arrayOfByte, 0, 128);
        arrayOfByte = localCipher.doFinal(arrayOfByte);
        System.arraycopy(arrayOfByte, 0, paramKey, j, arrayOfByte.length);
        j += arrayOfByte.length;
        i += 1;
      }
      else
      {
        paramArrayOfByte = new byte[j];
        System.arraycopy(paramKey, 0, paramArrayOfByte, 0, j);
        return paramArrayOfByte;
        LOGI("data or key is null", "");
        return null;
        label180:
        i = 0;
        j = 0;
      }
    }
  }
  
  public static byte[] RSAEncrypt(byte[] paramArrayOfByte, Key paramKey)
  {
    if (paramArrayOfByte != null) {
      if (paramKey == null) {
        return null;
      }
    }
    for (;;)
    {
      int i;
      int j;
      int m;
      int k;
      try
      {
        localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        localCipher.init(1, paramKey);
        i = paramArrayOfByte.length;
        j = i / 117;
        double d = j;
        Double.isNaN(d);
        m = (int)Math.round(d + 0.5D);
        paramKey = new byte[m * 128];
        j = 0;
        k = 117;
      }
      catch (Exception paramArrayOfByte)
      {
        Cipher localCipher;
        byte[] arrayOfByte;
        return null;
      }
      arrayOfByte = new byte[k];
      System.arraycopy(paramArrayOfByte, j * 117, arrayOfByte, 0, k);
      System.arraycopy(localCipher.doFinal(arrayOfByte), 0, paramKey, 128 * j, 128);
      i -= k;
      j += 1;
      break label139;
      return paramKey;
      return null;
      label139:
      if (j < m) {
        if (i < 117) {
          k = i;
        }
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
    arrayOfByte1[25] = ((byte)(arrayOfByte1[25] + i));
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
    int k = 0;
    int i = 0;
    int m = 0;
    int n = 0;
    int j = paramInt;
    paramInt = n;
    n = i;
    if (j > 0)
    {
      i = paramArrayOfByte[k];
      n = i;
      if (i != 0) {
        if (i == 95)
        {
          n = i;
        }
        else
        {
          n = i;
          if (i == 32) {
            n = 42;
          }
          i = base64_reverse_table_url[n];
          if (i < 0) {}
          for (;;)
          {
            k += 1;
            j -= 1;
            break;
            n = m % 4;
            if (n != 0)
            {
              if (n != 1)
              {
                if (n != 2)
                {
                  if (n != 3) {
                    break label224;
                  }
                  n = paramInt + 1;
                  arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i));
                  paramInt = n;
                }
                else
                {
                  n = paramInt + 1;
                  arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i >> 2));
                  arrayOfByte[n] = ((byte)((i & 0x3) << 6));
                  paramInt = n;
                }
              }
              else
              {
                n = paramInt + 1;
                arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | i >> 4));
                arrayOfByte[n] = ((byte)((i & 0xF) << 4));
                paramInt = n;
              }
            }
            else {
              arrayOfByte[paramInt] = ((byte)(i << 2));
            }
            label224:
            m += 1;
          }
        }
      }
    }
    if (n == 95)
    {
      i = m % 4;
      if ((i != 0) && (i != 1))
      {
        if (i != 2)
        {
          if (i != 3) {
            return arrayOfByte;
          }
        }
        else {
          paramInt += 1;
        }
        arrayOfByte[paramInt] = 0;
        return arrayOfByte;
      }
      return null;
    }
    return arrayOfByte;
  }
  
  public static String base64_encode(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int k;
    for (int i = 0; i < j; i = k + 1)
    {
      int m = i + 1;
      i = paramArrayOfByte[i] & 0xFF;
      if (m == j)
      {
        localStringBuffer.append(base64_encode_chars[(i >>> 2)]);
        localStringBuffer.append(base64_encode_chars[((i & 0x3) << 4)]);
        break;
      }
      k = m + 1;
      m = paramArrayOfByte[m] & 0xFF;
      if (k == j)
      {
        localStringBuffer.append(base64_encode_chars[(i >>> 2)]);
        localStringBuffer.append(base64_encode_chars[((i & 0x3) << 4 | (m & 0xF0) >>> 4)]);
        localStringBuffer.append(base64_encode_chars[((m & 0xF) << 2)]);
        break;
      }
      int n = paramArrayOfByte[k] & 0xFF;
      localStringBuffer.append(base64_encode_chars[(i >>> 2)]);
      localStringBuffer.append(base64_encode_chars[((i & 0x3) << 4 | (m & 0xF0) >>> 4)]);
      localStringBuffer.append(base64_encode_chars[((m & 0xF) << 2 | (n & 0xC0) >>> 6)]);
      localStringBuffer.append(base64_encode_chars[(n & 0x3F)]);
    }
    return localStringBuffer.toString();
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
    return (paramArrayOfByte[paramInt] << 56 & 0x0) + 0L + (paramArrayOfByte[(paramInt + 1)] << 48 & 0x0) + (paramArrayOfByte[(paramInt + 2)] << 40 & 0x0) + (paramArrayOfByte[(paramInt + 3)] << 32 & 0x0) + (paramArrayOfByte[(paramInt + 4)] << 24 & 0xFF000000) + (paramArrayOfByte[(paramInt + 5)] << 16 & 0xFF0000) + (paramArrayOfByte[(paramInt + 6)] << 8 & 0xFF00) + (paramArrayOfByte[(paramInt + 7)] << 0 & 0xFF);
  }
  
  public static int buf_to_int8(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF;
  }
  
  public static String buf_to_string(byte[] paramArrayOfByte)
  {
    String str = "";
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[i] & 0xF));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
  }
  
  public static String buf_to_string(byte[] paramArrayOfByte, int paramInt)
  {
    String str = "";
    if (paramArrayOfByte == null) {
      return "";
    }
    int i = paramInt;
    if (paramInt > paramArrayOfByte.length) {
      i = paramArrayOfByte.length;
    }
    paramInt = 0;
    while (paramInt < i)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[paramInt] >> 4 & 0xF));
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[paramInt] & 0xF));
      str = localStringBuilder.toString();
      paramInt += 1;
    }
    return str;
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
    catch (NumberFormatException paramString)
    {
      label31:
      break label31;
    }
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
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramArrayOfByte;
      }
      localObject = new ByteArrayOutputStream();
    }
    try
    {
      DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream((OutputStream)localObject);
      localDeflaterOutputStream.write(paramArrayOfByte);
      localDeflaterOutputStream.close();
      paramArrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      label46:
      break label46;
    }
    localObject = new byte[0];
    return localObject;
  }
  
  public static long constructSalt()
  {
    return (get_rand_32() << 32) + get_rand_32();
  }
  
  public static void decompress(byte[] paramArrayOfByte)
  {
    Object localObject1;
    int j;
    int i;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("data len:");
      ((StringBuilder)localObject1).append(paramArrayOfByte.length);
      LOGI(((StringBuilder)localObject1).toString());
      j = 0;
      i = 0;
    }
    for (;;)
    {
      int k;
      Object localObject2;
      if (paramArrayOfByte.length > j + 3)
      {
        k = buf_to_int32(paramArrayOfByte, j);
        if (paramArrayOfByte.length > j + k + 3)
        {
          localObject2 = new byte[k];
          j += 4;
          System.arraycopy(paramArrayOfByte, j, localObject2, 0, k);
          j += k;
          i += 1;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("len:");
          ((StringBuilder)localObject1).append(k);
          LOGI(((StringBuilder)localObject1).toString());
          localObject1 = new ByteArrayOutputStream();
          localObject2 = new ByteArrayInputStream((byte[])localObject2);
        }
      }
      try
      {
        localObject2 = new InflaterInputStream((InputStream)localObject2);
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          k = ((InflaterInputStream)localObject2).read(arrayOfByte);
          if (k == -1) {
            break;
          }
          ((ByteArrayOutputStream)localObject1).write(arrayOfByte, 0, k);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(((ByteArrayOutputStream)localObject1).toString());
        LOGI(((StringBuilder)localObject2).toString());
      }
      catch (IOException localIOException) {}
      return;
    }
  }
  
  public static void deleteExpireFile(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file path:");
      localStringBuilder.append(paramString);
      LOGI(localStringBuilder.toString());
    }
    try
    {
      paramString = new File(paramString);
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles(new g());
        if (paramString != null)
        {
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            if ((!paramString[i].isDirectory()) && ((System.currentTimeMillis() - paramString[i].lastModified()) / 1000L > paramInt)) {
              paramString[i].delete();
            }
            i += 1;
          }
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void deleteExpireLog(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      if ((t.az != null) && (t.az.length() != 0))
      {
        deleteExpireFile(t.az, 691200);
        return;
      }
      boolean bool = ExistSDCard();
      if (bool)
      {
        localObject = paramContext.getExternalCacheDir();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append("tencent/wtlogin");
        localStringBuilder.append("/");
        localStringBuilder.append(paramContext.getPackageName());
        deleteExpireFile(localStringBuilder.toString(), 691200);
        return;
      }
      paramContext = paramContext.getFilesDir().getPath();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramContext);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append("tencent/wtlogin");
      deleteExpireFile(((StringBuilder)localObject).toString(), 259200);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static int format_ret_code(int paramInt)
  {
    int i = 2;
    if ((paramInt != -1015) && (paramInt != -1014) && (paramInt != -1006) && (paramInt != -1002))
    {
      if (paramInt != -1000)
      {
        if (paramInt != 0)
        {
          if (paramInt != 2) {
            return 17;
          }
        }
        else {
          return 0;
        }
      }
      else {
        return 1;
      }
    }
    else {
      i = 5;
    }
    return i;
  }
  
  public static byte[] generateGuid(Context paramContext)
  {
    if ((t.al != null) && (t.al.length != 0))
    {
      LOGI("generate guid from customer guid");
      return t.al;
    }
    LOGI("generate guid temporarily");
    String str = getAndroidId(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("android_id ");
    localStringBuilder.append(str);
    LOGI(localStringBuilder.toString(), "");
    paramContext = getMacAddr(paramContext);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("mac ");
    localStringBuilder.append(paramContext);
    LOGI(localStringBuilder.toString(), "");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramContext);
    return MD5.toMD5Byte(localStringBuilder.toString().getBytes());
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
    catch (Exception localException)
    {
      label21:
      break label21;
    }
    return null;
  }
  
  public static String getAndroidId(Context paramContext)
  {
    CharSequence localCharSequence;
    try
    {
      String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    }
    catch (Throwable localThrowable)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("throw ");
      ((StringBuilder)localObject).append(Log.getStackTraceString(localThrowable));
      LOGI(((StringBuilder)localObject).toString(), "");
      localCharSequence = null;
    }
    Object localObject = localCharSequence;
    if (TextUtils.isEmpty(localCharSequence))
    {
      localObject = getRandomAndroidId(paramContext);
      paramContext = new StringBuilder();
      paramContext.append("getRandomAndroidId ");
      paramContext.append((String)localObject);
      LOGI(paramContext.toString(), "");
    }
    return localObject;
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
    catch (Throwable paramContext)
    {
      label42:
      break label42;
    }
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
    catch (Exception localException)
    {
      label61:
      break label61;
    }
    return "";
  }
  
  /* Error */
  public static String getBootId()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_0
    //   6: new 821	java/io/FileReader
    //   9: dup
    //   10: ldc_w 823
    //   13: invokespecial 824	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   16: astore_1
    //   17: new 826	java/io/BufferedReader
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 829	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: invokevirtual 832	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_0
    //   29: aload_0
    //   30: ifnull +16 -> 46
    //   33: aload_1
    //   34: invokevirtual 833	java/io/FileReader:close	()V
    //   37: aload_0
    //   38: areturn
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 836	java/io/IOException:printStackTrace	()V
    //   44: aload_0
    //   45: areturn
    //   46: aload_1
    //   47: invokevirtual 833	java/io/FileReader:close	()V
    //   50: ldc 216
    //   52: areturn
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 836	java/io/IOException:printStackTrace	()V
    //   58: ldc 216
    //   60: areturn
    //   61: astore_2
    //   62: aload_1
    //   63: astore_0
    //   64: aload_2
    //   65: astore_1
    //   66: goto +55 -> 121
    //   69: goto +10 -> 79
    //   72: goto +28 -> 100
    //   75: astore_1
    //   76: goto +45 -> 121
    //   79: aload_1
    //   80: astore_0
    //   81: ldc_w 838
    //   84: ldc 216
    //   86: invokestatic 840	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_1
    //   90: ifnull +28 -> 118
    //   93: aload_1
    //   94: invokevirtual 833	java/io/FileReader:close	()V
    //   97: ldc 216
    //   99: areturn
    //   100: aload_1
    //   101: astore_0
    //   102: ldc_w 842
    //   105: ldc 216
    //   107: invokestatic 840	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 833	java/io/FileReader:close	()V
    //   118: ldc 216
    //   120: areturn
    //   121: aload_0
    //   122: ifnull +15 -> 137
    //   125: aload_0
    //   126: invokevirtual 833	java/io/FileReader:close	()V
    //   129: goto +8 -> 137
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 836	java/io/IOException:printStackTrace	()V
    //   137: aload_1
    //   138: athrow
    //   139: astore_0
    //   140: aload_3
    //   141: astore_1
    //   142: goto -42 -> 100
    //   145: astore_0
    //   146: aload_2
    //   147: astore_1
    //   148: goto -69 -> 79
    //   151: astore_0
    //   152: goto -80 -> 72
    //   155: astore_0
    //   156: goto -87 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	40	0	str	String
    //   53	2	0	localIOException1	IOException
    //   63	63	0	localObject1	Object
    //   132	2	0	localIOException2	IOException
    //   139	1	0	localFileNotFoundException1	java.io.FileNotFoundException
    //   145	1	0	localIOException3	IOException
    //   151	1	0	localFileNotFoundException2	java.io.FileNotFoundException
    //   155	1	0	localIOException4	IOException
    //   16	18	1	localFileReader	java.io.FileReader
    //   39	24	1	localIOException5	IOException
    //   65	1	1	localObject2	Object
    //   75	63	1	localObject3	Object
    //   141	7	1	localObject4	Object
    //   1	1	2	localObject5	Object
    //   61	86	2	localObject6	Object
    //   3	138	3	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   33	37	39	java/io/IOException
    //   46	50	53	java/io/IOException
    //   93	97	53	java/io/IOException
    //   114	118	53	java/io/IOException
    //   17	29	61	finally
    //   6	17	75	finally
    //   81	89	75	finally
    //   102	110	75	finally
    //   125	129	132	java/io/IOException
    //   6	17	139	java/io/FileNotFoundException
    //   6	17	145	java/io/IOException
    //   17	29	151	java/io/FileNotFoundException
    //   17	29	155	java/io/IOException
  }
  
  public static int getByteLength(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    return paramArrayOfByte.length;
  }
  
  public static String getChannelId(Context paramContext, String paramString)
  {
    Object localObject;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      localObject = paramContext.getPackageName();
    }
    paramContext = paramContext.getPackageManager();
    int i;
    label383:
    do
    {
      for (;;)
      {
        try
        {
          paramString = paramContext.getPackageInfo((String)localObject, 0).applicationInfo.sourceDir;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("pkg ");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(" path ");
          if (paramString == null)
          {
            paramContext = "null";
            localStringBuilder.append(paramContext);
            LOGI(localStringBuilder.toString(), "");
            if (paramString != null)
            {
              if (paramString.length() == 0) {
                return "";
              }
              paramContext = new byte[4];
              paramContext[0] = 80;
              paramContext[1] = 75;
              paramContext[2] = 5;
              paramContext[3] = 6;
              paramString = new FileInputStream(paramString);
              l = paramString.available();
              localObject = new byte[(int)(l - paramString.skip(l - 256L))];
              paramString.read((byte[])localObject);
              paramString.close();
              i = 0;
              if (i >= localObject.length - 4) {
                break;
              }
              if ((localObject[i] != paramContext[0]) || (localObject[(i + 1)] != paramContext[1]) || (localObject[(i + 2)] != paramContext[2]) || (localObject[(i + 3)] != paramContext[3])) {
                break label383;
              }
              l = i;
              break label394;
              paramString = new byte[i];
              System.arraycopy(localObject, (int)(l + 20L), paramString, 0, i);
              paramContext = Pattern.compile("channelId=(\\S+)").matcher(new String(paramString));
              if (paramContext.find()) {
                paramContext = paramContext.group(1);
              } else {
                paramContext = "";
              }
              try
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("found comment ");
                ((StringBuilder)localObject).append(new String(paramString));
                ((StringBuilder)localObject).append(" channelId:");
                ((StringBuilder)localObject).append(paramContext);
                LOGI(((StringBuilder)localObject).toString(), "");
                return paramContext;
              }
              catch (Exception paramString) {}
            }
            else
            {
              return "";
            }
          }
        }
        catch (Exception paramString)
        {
          paramContext = "";
          printException(paramString, "");
          return paramContext;
        }
        paramContext = paramString;
        continue;
        i += 1;
      }
      long l = -1L;
      if (l == -1L) {
        return "";
      }
      i = (int)l + 20;
      i = localObject[i] + (localObject[(i + 1)] << 8);
    } while (i != 0);
    label394:
    return "";
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
    catch (Exception localException)
    {
      label35:
      break label35;
    }
    return null;
  }
  
  public static String getCurrentPid()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(Process.myPid());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static String getDate()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      label39:
      break label39;
    }
    return "";
  }
  
  public static long getFileModifyTime(String paramString)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramString != null) {
      if (paramString.length() == 0) {
        return 0L;
      }
    }
    try
    {
      paramString = new File(paramString);
      l1 = l2;
      if (paramString.exists())
      {
        if (!paramString.isFile()) {
          return 0L;
        }
        l1 = paramString.lastModified();
      }
      return l1;
    }
    catch (Exception paramString) {}
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
    //   0: getstatic 701	oicq/wlogin_sdk/request/t:al	[B
    //   3: ifnull +22 -> 25
    //   6: getstatic 701	oicq/wlogin_sdk/request/t:al	[B
    //   9: arraylength
    //   10: ifeq +15 -> 25
    //   13: ldc_w 952
    //   16: ldc 216
    //   18: invokestatic 425	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: getstatic 701	oicq/wlogin_sdk/request/t:al	[B
    //   24: areturn
    //   25: ldc_w 954
    //   28: ldc 216
    //   30: invokestatic 425	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aconst_null
    //   34: astore 7
    //   36: aconst_null
    //   37: astore_2
    //   38: aload_0
    //   39: ifnonnull +5 -> 44
    //   42: aconst_null
    //   43: areturn
    //   44: iconst_0
    //   45: newarray byte
    //   47: astore_3
    //   48: aload_2
    //   49: astore 5
    //   51: new 363	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   58: astore 4
    //   60: aload_2
    //   61: astore 5
    //   63: aload 4
    //   65: aload_0
    //   66: invokevirtual 689	android/content/Context:getFilesDir	()Ljava/io/File;
    //   69: invokevirtual 681	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   72: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_2
    //   77: astore 5
    //   79: aload 4
    //   81: ldc_w 956
    //   84: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_2
    //   89: astore 5
    //   91: new 640	java/io/File
    //   94: dup
    //   95: aload 4
    //   97: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 642	java/io/File:<init>	(Ljava/lang/String;)V
    //   103: astore 4
    //   105: aload_2
    //   106: astore 5
    //   108: aload 4
    //   110: invokevirtual 942	java/io/File:exists	()Z
    //   113: ifeq +77 -> 190
    //   116: aload_2
    //   117: astore 5
    //   119: new 868	java/io/FileInputStream
    //   122: dup
    //   123: aload 4
    //   125: invokespecial 959	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: astore 4
    //   130: aload_3
    //   131: astore_2
    //   132: aload 4
    //   134: invokevirtual 872	java/io/FileInputStream:available	()I
    //   137: istore_1
    //   138: aload_3
    //   139: astore_2
    //   140: aload 4
    //   142: astore 5
    //   144: iload_1
    //   145: sipush 1024
    //   148: if_icmpge +47 -> 195
    //   151: aload_3
    //   152: astore_2
    //   153: iload_1
    //   154: newarray byte
    //   156: astore_3
    //   157: aload_3
    //   158: astore_2
    //   159: aload 4
    //   161: aload_3
    //   162: invokevirtual 879	java/io/FileInputStream:read	([B)I
    //   165: pop
    //   166: aload_3
    //   167: astore_2
    //   168: aload 4
    //   170: astore 5
    //   172: goto +23 -> 195
    //   175: astore_0
    //   176: aload 4
    //   178: astore 5
    //   180: goto +131 -> 311
    //   183: astore_3
    //   184: aload_3
    //   185: astore 6
    //   187: goto +49 -> 236
    //   190: aconst_null
    //   191: astore 5
    //   193: aload_3
    //   194: astore_2
    //   195: aload_2
    //   196: astore_3
    //   197: aload 5
    //   199: ifnull +78 -> 277
    //   202: aload_2
    //   203: astore_3
    //   204: aload 5
    //   206: invokevirtual 880	java/io/FileInputStream:close	()V
    //   209: aload_2
    //   210: astore_3
    //   211: goto +66 -> 277
    //   214: astore_2
    //   215: aload_2
    //   216: ldc 216
    //   218: invokestatic 480	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   221: goto +56 -> 277
    //   224: astore_0
    //   225: goto +86 -> 311
    //   228: astore 6
    //   230: aload_3
    //   231: astore_2
    //   232: aload 7
    //   234: astore 4
    //   236: aload 4
    //   238: astore 5
    //   240: getstatic 962	oicq/wlogin_sdk/request/t:aa	I
    //   243: ldc_w 963
    //   246: ior
    //   247: putstatic 962	oicq/wlogin_sdk/request/t:aa	I
    //   250: aload 4
    //   252: astore 5
    //   254: aload 6
    //   256: ldc 216
    //   258: invokestatic 480	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   261: aload_2
    //   262: astore_3
    //   263: aload 4
    //   265: ifnull +12 -> 277
    //   268: aload_2
    //   269: astore_3
    //   270: aload 4
    //   272: invokevirtual 880	java/io/FileInputStream:close	()V
    //   275: aload_2
    //   276: astore_3
    //   277: aload_3
    //   278: astore_2
    //   279: aload_3
    //   280: arraylength
    //   281: ifgt +28 -> 309
    //   284: aload_0
    //   285: invokestatic 966	oicq/wlogin_sdk/tools/util:get_saved_android_id	(Landroid/content/Context;)[B
    //   288: astore_3
    //   289: aload_3
    //   290: astore_2
    //   291: aload_3
    //   292: ifnull +17 -> 309
    //   295: aload_3
    //   296: astore_2
    //   297: aload_3
    //   298: arraylength
    //   299: ifle +10 -> 309
    //   302: aload_0
    //   303: aload_3
    //   304: invokestatic 970	oicq/wlogin_sdk/tools/util:saveGuidToFile	(Landroid/content/Context;[B)V
    //   307: aload_3
    //   308: astore_2
    //   309: aload_2
    //   310: areturn
    //   311: aload 5
    //   313: ifnull +18 -> 331
    //   316: aload 5
    //   318: invokevirtual 880	java/io/FileInputStream:close	()V
    //   321: goto +10 -> 331
    //   324: astore_2
    //   325: aload_2
    //   326: ldc 216
    //   328: invokestatic 480	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   331: aload_0
    //   332: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	paramContext	Context
    //   137	17	1	i	int
    //   37	173	2	localObject1	Object
    //   214	2	2	localIOException1	IOException
    //   231	79	2	localObject2	Object
    //   324	2	2	localIOException2	IOException
    //   47	120	3	arrayOfByte	byte[]
    //   183	11	3	localException1	Exception
    //   196	112	3	localObject3	Object
    //   58	213	4	localObject4	Object
    //   49	268	5	localObject5	Object
    //   185	1	6	localException2	Exception
    //   228	27	6	localException3	Exception
    //   34	199	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   132	138	175	finally
    //   153	157	175	finally
    //   159	166	175	finally
    //   132	138	183	java/lang/Exception
    //   153	157	183	java/lang/Exception
    //   159	166	183	java/lang/Exception
    //   204	209	214	java/io/IOException
    //   270	275	214	java/io/IOException
    //   51	60	224	finally
    //   63	76	224	finally
    //   79	88	224	finally
    //   91	105	224	finally
    //   108	116	224	finally
    //   119	130	224	finally
    //   240	250	224	finally
    //   254	261	224	finally
    //   51	60	228	java/lang/Exception
    //   63	76	228	java/lang/Exception
    //   79	88	228	java/lang/Exception
    //   91	105	228	java/lang/Exception
    //   108	116	228	java/lang/Exception
    //   119	130	228	java/lang/Exception
    //   316	321	324	java/io/IOException
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
    catch (Throwable paramContext)
    {
      label31:
      break label31;
    }
    return new byte[0];
  }
  
  public static int getInitKeyTime(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        i = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).getInt("InitKeyTime", 0);
        paramContext = new StringBuilder();
        paramContext.append("getInitKeyTime ");
        paramContext.append(i);
        LOGI(paramContext.toString(), "");
        return i;
      }
      catch (Throwable paramContext)
      {
        printThrowable(paramContext, "getReqTimeFromSp");
        return 0;
      }
      int i = 0;
    }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(((StackTraceElement)localObject).getFileName());
      localStringBuilder.append(":");
      localStringBuilder.append(((StackTraceElement)localObject).getLineNumber());
      localStringBuilder.append("]");
      localObject = localStringBuilder.toString();
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
  
  public static String getLogDir(Context paramContext)
  {
    if ((t.az != null) && (t.az.length() != 0)) {
      return t.az;
    }
    try
    {
      boolean bool = ExistSDCard();
      if (bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getExternalCacheDir().getAbsolutePath());
        localStringBuilder.append("/");
        localStringBuilder.append("tencent/wtlogin");
        localStringBuilder.append("/");
        localStringBuilder.append(paramContext.getPackageName());
        return localStringBuilder.toString();
      }
      paramContext = paramContext.getFilesDir().getPath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append("/");
      localStringBuilder.append("tencent/wtlogin");
      paramContext = localStringBuilder.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label128:
      break label128;
    }
    return "";
  }
  
  public static String getLogFileName(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() != 0))
    {
      paramContext = getLogDir(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append("/wtlogin_");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".log");
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static long getLogModifyTime(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() != 0)) {
      return getFileModifyTime(getLogFileName(paramContext, paramString));
    }
    return 0L;
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
    catch (Throwable paramContext)
    {
      printThrowable(paramContext, "");
    }
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramArrayOfByte.substring(0, paramInt1));
    localStringBuilder.append("***");
    localStringBuilder.append(paramArrayOfByte.substring(paramArrayOfByte.length() - paramInt2));
    return localStringBuilder.toString();
  }
  
  public static String getMaskString(String paramString, int paramInt1, int paramInt2)
  {
    if (paramInt1 + paramInt2 > paramString.length()) {
      return "***";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, paramInt1));
    localStringBuilder.append("***");
    localStringBuilder.append(paramString.substring(paramString.length() - paramInt2));
    return localStringBuilder.toString();
  }
  
  public static byte[] getPkgSigFromApkName(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if ((paramContext.signatures != null) && (paramContext.signatures.length > 0) && (paramContext.signatures[0] != null)) {
        return MD5.toMD5Byte(paramContext.signatures[0].toByteArray());
      }
      return new byte[0];
    }
    catch (Throwable paramContext)
    {
      label55:
      break label55;
    }
    return new byte[0];
  }
  
  /* Error */
  public static String getProcVersion()
  {
    // Byte code:
    //   0: new 821	java/io/FileReader
    //   3: dup
    //   4: ldc_w 1111
    //   7: invokespecial 824	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   10: astore_1
    //   11: aload_1
    //   12: astore_0
    //   13: new 826	java/io/BufferedReader
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 829	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: invokevirtual 832	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +16 -> 42
    //   29: aload_1
    //   30: invokevirtual 833	java/io/FileReader:close	()V
    //   33: aload_2
    //   34: areturn
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 836	java/io/IOException:printStackTrace	()V
    //   40: aload_2
    //   41: areturn
    //   42: aload_1
    //   43: invokevirtual 833	java/io/FileReader:close	()V
    //   46: ldc 216
    //   48: areturn
    //   49: astore_0
    //   50: aload_0
    //   51: invokevirtual 836	java/io/IOException:printStackTrace	()V
    //   54: ldc 216
    //   56: areturn
    //   57: astore_2
    //   58: goto +12 -> 70
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: goto +64 -> 128
    //   67: astore_2
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: astore_0
    //   72: new 363	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   79: astore_3
    //   80: aload_1
    //   81: astore_0
    //   82: aload_3
    //   83: ldc_w 1113
    //   86: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: astore_0
    //   92: aload_3
    //   93: aload_2
    //   94: invokevirtual 438	java/lang/Exception:toString	()Ljava/lang/String;
    //   97: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_1
    //   102: astore_0
    //   103: aload_3
    //   104: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: ldc 216
    //   109: invokestatic 840	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 833	java/io/FileReader:close	()V
    //   120: ldc 216
    //   122: areturn
    //   123: astore_2
    //   124: aload_0
    //   125: astore_1
    //   126: aload_2
    //   127: astore_0
    //   128: aload_1
    //   129: ifnull +15 -> 144
    //   132: aload_1
    //   133: invokevirtual 833	java/io/FileReader:close	()V
    //   136: goto +8 -> 144
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 836	java/io/IOException:printStackTrace	()V
    //   144: aload_0
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	1	0	localObject1	Object
    //   35	2	0	localIOException1	IOException
    //   49	2	0	localIOException2	IOException
    //   61	1	0	localObject2	Object
    //   71	74	0	localObject3	Object
    //   10	123	1	localObject4	Object
    //   139	2	1	localIOException3	IOException
    //   24	17	2	str	String
    //   57	1	2	localException1	Exception
    //   67	27	2	localException2	Exception
    //   123	4	2	localObject5	Object
    //   79	25	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	33	35	java/io/IOException
    //   42	46	49	java/io/IOException
    //   116	120	49	java/io/IOException
    //   13	25	57	java/lang/Exception
    //   0	11	61	finally
    //   0	11	67	java/lang/Exception
    //   13	25	123	finally
    //   72	80	123	finally
    //   82	90	123	finally
    //   92	101	123	finally
    //   103	112	123	finally
    //   132	136	139	java/io/IOException
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
    int64_to_buf32(arrayOfByte, 0, System.currentTimeMillis() / 1000L + t.af);
    return arrayOfByte;
  }
  
  public static String getSvnVersion()
  {
    return "[2473]";
  }
  
  public static String getThreadId()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(Thread.currentThread().getId());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static String getThrowableInfo(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    localStringWriter.flush();
    return localStringWriter.toString();
  }
  
  public static String getUser(String paramString)
  {
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
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
    catch (Throwable paramContext)
    {
      label31:
      break label31;
    }
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
      ((StringBuilder)localObject2).append(str2);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str3);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str4);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str5);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str6);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str7);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str1);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str8);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append(str9);
      localObject1 = paramContext;
      ((StringBuilder)localObject2).append("\n");
      localObject1 = paramContext;
      LOGI(((StringBuilder)localObject2).toString(), "");
      localObject1 = paramContext;
    }
    catch (Throwable paramContext)
    {
      label411:
      break label411;
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
    catch (Throwable paramContext)
    {
      label10:
      break label10;
    }
    return new byte[0];
  }
  
  public static byte[] get_apk_v(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionName.getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label18:
      break label18;
    }
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
      return "wifi";
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
    catch (Throwable paramContext)
    {
      label43:
      break label43;
    }
    return new byte[0];
  }
  
  public static byte get_char(byte paramByte)
  {
    if ((paramByte >= 48) && (paramByte <= 57))
    {
      paramByte -= 48;
      return (byte)paramByte;
    }
    byte b = 97;
    if ((paramByte >= 97) && (paramByte <= 102)) {}
    do
    {
      paramByte = paramByte - b + 10;
      break;
      b = 65;
    } while ((paramByte >= 65) && (paramByte <= 70));
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
    //   0: aload_0
    //   1: ifnonnull +7 -> 8
    //   4: iconst_0
    //   5: newarray byte
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual 744	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   12: astore 8
    //   14: new 363	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   21: astore_0
    //   22: aload_0
    //   23: ldc_w 1296
    //   26: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_0
    //   31: ldc_w 1298
    //   34: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_0
    //   39: ldc_w 1300
    //   42: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_0
    //   47: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 1306	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   53: astore 9
    //   55: aconst_null
    //   56: astore 7
    //   58: aconst_null
    //   59: astore 6
    //   61: aload 6
    //   63: astore 5
    //   65: aload 7
    //   67: astore_0
    //   68: new 363	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   75: astore 10
    //   77: aload 6
    //   79: astore 5
    //   81: aload 7
    //   83: astore_0
    //   84: aload 10
    //   86: ldc 216
    //   88: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 6
    //   94: astore 5
    //   96: aload 7
    //   98: astore_0
    //   99: aload 10
    //   101: lload_1
    //   102: invokevirtual 938	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 6
    //   108: astore 5
    //   110: aload 7
    //   112: astore_0
    //   113: aload 10
    //   115: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore 10
    //   120: aload 6
    //   122: astore 5
    //   124: aload 7
    //   126: astore_0
    //   127: new 363	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   134: astore 11
    //   136: aload 6
    //   138: astore 5
    //   140: aload 7
    //   142: astore_0
    //   143: aload 11
    //   145: ldc 216
    //   147: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 6
    //   153: astore 5
    //   155: aload 7
    //   157: astore_0
    //   158: aload 11
    //   160: lload_3
    //   161: invokevirtual 938	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: astore 5
    //   169: aload 7
    //   171: astore_0
    //   172: aload 11
    //   174: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore 11
    //   179: aload 6
    //   181: astore 5
    //   183: aload 7
    //   185: astore_0
    //   186: aload 8
    //   188: aload 9
    //   190: iconst_5
    //   191: anewarray 342	java/lang/String
    //   194: dup
    //   195: iconst_0
    //   196: ldc_w 1308
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: ldc_w 1310
    //   205: aastore
    //   206: dup
    //   207: iconst_2
    //   208: ldc_w 1312
    //   211: aastore
    //   212: dup
    //   213: iconst_3
    //   214: ldc_w 1314
    //   217: aastore
    //   218: dup
    //   219: iconst_4
    //   220: ldc_w 1316
    //   223: aastore
    //   224: ldc_w 1318
    //   227: iconst_2
    //   228: anewarray 342	java/lang/String
    //   231: dup
    //   232: iconst_0
    //   233: aload 10
    //   235: aastore
    //   236: dup
    //   237: iconst_1
    //   238: aload 11
    //   240: aastore
    //   241: aconst_null
    //   242: invokevirtual 1324	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   245: astore 6
    //   247: aload 6
    //   249: ifnull +121 -> 370
    //   252: aload 6
    //   254: astore 5
    //   256: aload 6
    //   258: astore_0
    //   259: aload 6
    //   261: invokeinterface 1329 1 0
    //   266: ifeq +104 -> 370
    //   269: aload 6
    //   271: astore 5
    //   273: aload 6
    //   275: astore_0
    //   276: aload 6
    //   278: aload 6
    //   280: ldc_w 1314
    //   283: invokeinterface 1332 2 0
    //   288: invokeinterface 1334 2 0
    //   293: astore 7
    //   295: aload 6
    //   297: astore 5
    //   299: aload 6
    //   301: astore_0
    //   302: aload 6
    //   304: aload 6
    //   306: ldc_w 1316
    //   309: invokeinterface 1332 2 0
    //   314: invokeinterface 1334 2 0
    //   319: astore 8
    //   321: aload 6
    //   323: astore 5
    //   325: aload 6
    //   327: astore_0
    //   328: aload 7
    //   330: invokestatic 1337	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   333: aload 8
    //   335: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   338: ifeq +32 -> 370
    //   341: aload 6
    //   343: astore 5
    //   345: aload 6
    //   347: astore_0
    //   348: aload 7
    //   350: invokestatic 1341	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   353: astore 7
    //   355: aload 6
    //   357: ifnull +10 -> 367
    //   360: aload 6
    //   362: invokeinterface 1342 1 0
    //   367: aload 7
    //   369: areturn
    //   370: aload 6
    //   372: ifnull +35 -> 407
    //   375: aload 6
    //   377: astore_0
    //   378: goto +23 -> 401
    //   381: astore_0
    //   382: goto +32 -> 414
    //   385: astore 6
    //   387: aload_0
    //   388: astore 5
    //   390: aload 6
    //   392: ldc 216
    //   394: invokestatic 480	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   397: aload_0
    //   398: ifnull +9 -> 407
    //   401: aload_0
    //   402: invokeinterface 1342 1 0
    //   407: ldc_w 1344
    //   410: invokestatic 1341	oicq/wlogin_sdk/tools/util:string_to_buf	(Ljava/lang/String;)[B
    //   413: areturn
    //   414: aload 5
    //   416: ifnull +10 -> 426
    //   419: aload 5
    //   421: invokeinterface 1342 1 0
    //   426: aload_0
    //   427: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	paramContext	Context
    //   0	428	1	paramLong1	long
    //   0	428	3	paramLong2	long
    //   63	357	5	localObject1	Object
    //   59	317	6	localCursor	android.database.Cursor
    //   385	6	6	localException	Exception
    //   56	312	7	localObject2	Object
    //   12	322	8	localObject3	Object
    //   53	136	9	localUri	Uri
    //   75	159	10	localObject4	Object
    //   134	105	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   68	77	381	finally
    //   84	92	381	finally
    //   99	106	381	finally
    //   113	120	381	finally
    //   127	136	381	finally
    //   143	151	381	finally
    //   158	165	381	finally
    //   172	179	381	finally
    //   186	247	381	finally
    //   259	269	381	finally
    //   276	295	381	finally
    //   302	321	381	finally
    //   328	341	381	finally
    //   348	355	381	finally
    //   390	397	381	finally
    //   68	77	385	java/lang/Exception
    //   84	92	385	java/lang/Exception
    //   99	106	385	java/lang/Exception
    //   113	120	385	java/lang/Exception
    //   127	136	385	java/lang/Exception
    //   143	151	385	java/lang/Exception
    //   158	165	385	java/lang/Exception
    //   172	179	385	java/lang/Exception
    //   186	247	385	java/lang/Exception
    //   259	269	385	java/lang/Exception
    //   276	295	385	java/lang/Exception
    //   302	321	385	java/lang/Exception
    //   328	341	385	java/lang/Exception
    //   348	355	385	java/lang/Exception
  }
  
  public static String get_error_msg(int paramInt)
  {
    if (paramInt != -1000) {
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
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = SecureRandom.getSeed(16);
        str = "";
        i = 0;
        if (i >= arrayOfByte.length) {
          continue;
        }
        boolean bool = new Random().nextBoolean();
        k = Math.abs(arrayOfByte[i] % 26);
        if (!bool) {
          continue;
        }
        j = 97;
      }
      catch (Throwable localThrowable)
      {
        String str;
        int i;
        int k;
        StringBuilder localStringBuilder;
        continue;
        int j = 65;
        continue;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.valueOf((char)(k + j)));
      str = localStringBuilder.toString();
      i += 1;
    }
    return str;
    return "1234567890123456";
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
    }
    catch (Throwable paramContext)
    {
      int i;
      label20:
      break label20;
    }
    i = 0;
    if (i == 0) {
      return 1;
    }
    if (i == 1) {
      return 2;
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
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramContext != null) {
      try
      {
        bool1 = paramContext.getSharedPreferences("WLOGIN_COST", 4).getBoolean("powTestNew", true);
      }
      catch (Throwable paramContext)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(LOG_TAG_POW);
        localStringBuilder.append("get_pow_test ");
        localStringBuilder.append(Log.getStackTraceString(paramContext));
        LOGI(localStringBuilder.toString(), "");
        bool1 = bool2;
      }
    }
    paramContext = new StringBuilder();
    paramContext.append(LOG_TAG_POW);
    paramContext.append("get_pow_test ");
    paramContext.append(bool1);
    LOGI(paramContext.toString(), "");
    return bool1;
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
    catch (Throwable localThrowable)
    {
      label66:
      break label66;
    }
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
    Object localObject = qimeiListener;
    if (localObject == null)
    {
      paramContext = new StringBuilder();
      paramContext.append(LOG_TAG_QIMEI);
      paramContext.append("get listener = null");
      LOGI(paramContext.toString(), "");
      return new byte[0];
    }
    paramContext = ((QimeiListener)localObject).getQimei(paramContext);
    if (TextUtils.isEmpty(paramContext))
    {
      paramContext = new StringBuilder();
      paramContext.append(LOG_TAG_QIMEI);
      paramContext.append("get isEmpty");
      LOGI(paramContext.toString(), "");
      return new byte[0];
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(LOG_TAG_QIMEI);
    ((StringBuilder)localObject).append("get length = ");
    ((StringBuilder)localObject).append(paramContext.length());
    LOGI(((StringBuilder)localObject).toString(), "");
    return paramContext.getBytes();
  }
  
  public static byte[] get_rand_16byte(SecureRandom paramSecureRandom)
  {
    try
    {
      byte[] arrayOfByte = new byte[16];
      paramSecureRandom.nextBytes(arrayOfByte);
      return arrayOfByte;
    }
    catch (Throwable paramSecureRandom)
    {
      label12:
      break label12;
    }
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
    catch (Throwable paramArrayOfByte)
    {
      label40:
      break label40;
    }
    return get_prand_16byte();
  }
  
  public static int get_rand_32()
  {
    return (int)(Math.random() * 2147483647.0D);
  }
  
  public static String get_release_time()
  {
    return "2021/04/22 11:10:03";
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
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
    return new byte[0];
  }
  
  public static byte[] get_server_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
    return new byte[0];
  }
  
  public static byte[] get_server_ipv6_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ipv6_host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
    return new byte[0];
  }
  
  public static byte[] get_server_ipv6_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ipv6_host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
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
    catch (Throwable paramContext)
    {
      label29:
      break label29;
    }
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
    catch (Throwable paramContext)
    {
      label40:
      break label40;
    }
    return new byte[0];
  }
  
  public static byte[] get_wap_server_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
    return new byte[0];
  }
  
  public static byte[] get_wap_server_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
    return new byte[0];
  }
  
  public static byte[] get_wap_server_ipv6_host1(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-ipv6_host1", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
    return new byte[0];
  }
  
  public static byte[] get_wap_server_ipv6_host2(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("wap-ipv6_host2", "").getBytes();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      label24:
      break label24;
    }
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
    catch (Exception paramString)
    {
      label14:
      break label14;
    }
    return false;
  }
  
  public static boolean isMQQExist(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo("com.tencent.mobileqq", 0);
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.versionName;
      if (paramContext.compareTo("4.6.0") >= 0) {
        return true;
      }
      try
      {
        int i = Integer.parseInt(paramContext.substring(0, paramContext.indexOf(".")));
        return i >= 10;
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
  
  @Deprecated
  public static boolean isWtLoginUrlV1(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    int i = paramString.indexOf("?k=");
    if (i != -1)
    {
      i += 3;
      int j = i + 32;
      if (j > paramString.length()) {
        return false;
      }
      paramString = paramString.substring(i, j);
      return base64_decode_url(paramString.getBytes(), paramString.length()) != null;
    }
    return false;
  }
  
  public static boolean isWtLoginUrlV2(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject = null;
    try
    {
      String str = Uri.parse(paramString).getHost();
      localObject = str;
    }
    catch (Exception localException)
    {
      printException(localException);
    }
    if (!"txz.qq.com".equals(localObject)) {
      return false;
    }
    return isWtLoginUrlV1(paramString);
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
        if (paramContext.equalsIgnoreCase("uniwap")) {
          return true;
        }
        if (paramContext.equalsIgnoreCase("ctwap")) {
          return true;
        }
        boolean bool = paramContext.equalsIgnoreCase("3gwap");
        if (bool) {
          return true;
        }
      }
    }
    catch (Throwable paramContext)
    {
      label59:
      break label59;
    }
    return false;
  }
  
  public static boolean is_wap_retry(Context paramContext)
  {
    return get_net_retry_type(paramContext) != 0;
  }
  
  public static boolean loadLibrary(String paramString, Context paramContext)
  {
    boolean bool1 = loadEncryptSo;
    boolean bool3 = false;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 23) {
      return false;
    }
    if (libwtecdh_loaded) {
      return true;
    }
    bool1 = bool3;
    if (paramContext != null)
    {
      bool1 = bool3;
      if (paramString != null)
      {
        if (paramString.length() == 0) {
          return false;
        }
        Object localObject2 = null;
        Object localObject1;
        Object localObject3;
        try
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramContext.getFilesDir().getParent());
          ((StringBuilder)localObject1).append("/txlib/lib");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(".so");
          localObject1 = new File(((StringBuilder)localObject1).toString());
          try
          {
            if (!((File)localObject1).exists())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramContext.getFilesDir().getParent());
              ((StringBuilder)localObject2).append("/lib/lib");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(".so");
              localObject2 = new File(((StringBuilder)localObject2).toString());
              localObject1 = localObject2;
              break label219;
            }
          }
          catch (Exception localException1) {}
          printException((Exception)localObject3);
        }
        catch (Exception localException2)
        {
          localObject1 = localException1;
          localObject3 = localException2;
        }
        label219:
        bool1 = bool2;
        if (localObject1 != null)
        {
          bool1 = bool2;
          if (((File)localObject1).exists()) {
            try
            {
              System.load(((File)localObject1).getAbsolutePath());
              bool1 = true;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("loadLibrary failed ");
              ((StringBuilder)localObject3).append(localUnsatisfiedLinkError1.getMessage());
              LOGI(((StringBuilder)localObject3).toString(), "");
              bool1 = bool2;
            }
          }
        }
        bool2 = bool1;
        if (!bool1) {
          try
          {
            System.loadLibrary(paramString);
            bool2 = true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("loadLibrary failed ");
            ((StringBuilder)localObject3).append(localUnsatisfiedLinkError2.getMessage());
            LOGI(((StringBuilder)localObject3).toString(), "");
            bool2 = bool1;
          }
        }
        bool1 = bool2;
        if (!bool2)
        {
          bool1 = SoLoadUtilNew.loadSoByName(paramContext, paramString);
          if (bool1) {
            LOGI("SoLoadCore loadLibrary succ ", "");
          } else {
            LOGI("SoLoadCore loadLibrary failed: ", "");
          }
        }
        libwtecdh_loaded = bool1;
        paramString = new StringBuilder();
        paramString.append("libwtecdh loaded ");
        paramString.append(libwtecdh_loaded);
        LOGI(paramString.toString(), "");
      }
    }
    return bool1;
  }
  
  public static boolean needChangeGuid(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", 0);
    long l2 = paramContext.getLong("change_guid_time", 0L);
    long l1 = t.f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("needChangeGuid delay:");
    localStringBuilder.append(l2);
    localStringBuilder.append(" now:");
    localStringBuilder.append(l1);
    LOGI(localStringBuilder.toString(), "");
    if (l2 == 0L)
    {
      l2 = new Random().nextInt(GUID_DELAY_HOUR) * 60 * 60 * 1000;
      paramContext.edit().putLong("change_guid_time", l1 + l2).commit();
      return false;
    }
    if (l2 >= l1)
    {
      paramContext.edit().putLong("change_guid_time", 0L).commit();
      return true;
    }
    return false;
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
      return get_pow_test(t.u);
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
  
  public static String printByte(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "null";
    }
    return String.valueOf(paramArrayOfByte.length);
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
    if (paramString != null) {
      if (paramString.length() == 0) {
        return null;
      }
    }
    try
    {
      Object localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        if (!((File)localObject).isFile()) {
          return null;
        }
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
      return null;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static byte[] readLog(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() != 0)) {
      return readFile(getLogFileName(paramContext, paramString));
    }
    return null;
  }
  
  /* Error */
  public static void saveGuidToFile(Context paramContext, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +299 -> 300
    //   4: aload_1
    //   5: ifnull +295 -> 300
    //   8: aload_1
    //   9: arraylength
    //   10: ifle +290 -> 300
    //   13: new 363	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc_w 1688
    //   25: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: aload_1
    //   31: invokestatic 1690	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   34: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: ldc 216
    //   44: invokestatic 425	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aconst_null
    //   48: astore 6
    //   50: aconst_null
    //   51: astore 7
    //   53: aconst_null
    //   54: astore 5
    //   56: aload 6
    //   58: astore_2
    //   59: aload 7
    //   61: astore 4
    //   63: new 363	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   70: astore_3
    //   71: aload 6
    //   73: astore_2
    //   74: aload 7
    //   76: astore 4
    //   78: aload_3
    //   79: aload_0
    //   80: invokevirtual 689	android/content/Context:getFilesDir	()Ljava/io/File;
    //   83: invokevirtual 681	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   86: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 6
    //   92: astore_2
    //   93: aload 7
    //   95: astore 4
    //   97: aload_3
    //   98: ldc_w 956
    //   101: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 6
    //   107: astore_2
    //   108: aload 7
    //   110: astore 4
    //   112: new 640	java/io/File
    //   115: dup
    //   116: aload_3
    //   117: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 642	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: astore 8
    //   125: aload 6
    //   127: astore_2
    //   128: aload 7
    //   130: astore 4
    //   132: aload 8
    //   134: invokevirtual 942	java/io/File:exists	()Z
    //   137: ifne +16 -> 153
    //   140: aload 6
    //   142: astore_2
    //   143: aload 7
    //   145: astore 4
    //   147: aload 8
    //   149: invokevirtual 1693	java/io/File:createNewFile	()Z
    //   152: pop
    //   153: aload 5
    //   155: astore_3
    //   156: aload 6
    //   158: astore_2
    //   159: aload 7
    //   161: astore 4
    //   163: aload 8
    //   165: invokevirtual 942	java/io/File:exists	()Z
    //   168: ifeq +60 -> 228
    //   171: aload 5
    //   173: astore_3
    //   174: aload 6
    //   176: astore_2
    //   177: aload 7
    //   179: astore 4
    //   181: aload 8
    //   183: invokevirtual 1696	java/io/File:canWrite	()Z
    //   186: ifeq +42 -> 228
    //   189: aload 6
    //   191: astore_2
    //   192: aload 7
    //   194: astore 4
    //   196: new 1698	java/io/FileOutputStream
    //   199: dup
    //   200: aload 8
    //   202: iconst_0
    //   203: invokespecial 1701	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   206: astore_3
    //   207: aload_3
    //   208: aload_1
    //   209: invokevirtual 1702	java/io/FileOutputStream:write	([B)V
    //   212: goto +16 -> 228
    //   215: astore_0
    //   216: aload_3
    //   217: astore_2
    //   218: goto +62 -> 280
    //   221: astore_0
    //   222: aload_3
    //   223: astore 4
    //   225: goto +27 -> 252
    //   228: aload_3
    //   229: astore_2
    //   230: aload_3
    //   231: astore 4
    //   233: aload_0
    //   234: aload_1
    //   235: invokestatic 1705	oicq/wlogin_sdk/tools/util:save_android_id	(Landroid/content/Context;[B)V
    //   238: aload_3
    //   239: ifnull +61 -> 300
    //   242: aload_3
    //   243: invokevirtual 1706	java/io/FileOutputStream:close	()V
    //   246: return
    //   247: astore_0
    //   248: goto +32 -> 280
    //   251: astore_0
    //   252: aload 4
    //   254: astore_2
    //   255: aload_0
    //   256: ldc 216
    //   258: invokestatic 480	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   261: aload 4
    //   263: ifnull +37 -> 300
    //   266: aload 4
    //   268: invokevirtual 1706	java/io/FileOutputStream:close	()V
    //   271: return
    //   272: astore_0
    //   273: aload_0
    //   274: ldc 216
    //   276: invokestatic 480	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   279: return
    //   280: aload_2
    //   281: ifnull +17 -> 298
    //   284: aload_2
    //   285: invokevirtual 1706	java/io/FileOutputStream:close	()V
    //   288: goto +10 -> 298
    //   291: astore_1
    //   292: aload_1
    //   293: ldc 216
    //   295: invokestatic 480	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   298: aload_0
    //   299: athrow
    //   300: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	paramContext	Context
    //   0	301	1	paramArrayOfByte	byte[]
    //   20	265	2	localObject1	Object
    //   70	173	3	localObject2	Object
    //   61	206	4	localObject3	Object
    //   54	118	5	localObject4	Object
    //   48	142	6	localObject5	Object
    //   51	142	7	localObject6	Object
    //   123	78	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   207	212	215	finally
    //   207	212	221	java/lang/Exception
    //   63	71	247	finally
    //   78	90	247	finally
    //   97	105	247	finally
    //   112	125	247	finally
    //   132	140	247	finally
    //   147	153	247	finally
    //   163	171	247	finally
    //   181	189	247	finally
    //   196	207	247	finally
    //   233	238	247	finally
    //   255	261	247	finally
    //   63	71	251	java/lang/Exception
    //   78	90	251	java/lang/Exception
    //   97	105	251	java/lang/Exception
    //   112	125	251	java/lang/Exception
    //   132	140	251	java/lang/Exception
    //   147	153	251	java/lang/Exception
    //   163	171	251	java/lang/Exception
    //   181	189	251	java/lang/Exception
    //   196	207	251	java/lang/Exception
    //   233	238	251	java/lang/Exception
    //   242	246	272	java/io/IOException
    //   266	271	272	java/io/IOException
    //   284	288	291	java/io/IOException
  }
  
  public static void saveInitKeyTime(Context paramContext, int paramInt)
  {
    if (paramContext != null) {
      try
      {
        paramContext = paramContext.getSharedPreferences("WLOGIN_DEVICE_INFO", MODE_MULTI_PROCESS).edit();
        paramContext.putInt("InitKeyTime", paramInt);
        paramContext.commit();
        paramContext = new StringBuilder();
        paramContext.append("saveInitKeyTime time:");
        paramContext.append(paramInt);
        LOGI(paramContext.toString(), "");
        return;
      }
      catch (Throwable paramContext)
      {
        printThrowable(paramContext, "saveReqTimeToSp");
      }
    }
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
      paramContext.putBoolean("powTestNew", paramBoolean);
      paramContext.commit();
      paramContext = new StringBuilder();
      paramContext.append("save_pow_test ");
      paramContext.append(paramBoolean);
      LOGI(paramContext.toString(), "");
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
    //   7: invokevirtual 744	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   10: astore 10
    //   12: new 363	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   19: astore 6
    //   21: aload 6
    //   23: ldc_w 1296
    //   26: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 6
    //   32: ldc_w 1298
    //   35: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 6
    //   41: ldc_w 1300
    //   44: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 6
    //   50: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 1306	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   56: astore 11
    //   58: aload 11
    //   60: invokevirtual 1735	android/net/Uri:toString	()Ljava/lang/String;
    //   63: invokestatic 611	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   66: aconst_null
    //   67: astore 9
    //   69: aconst_null
    //   70: astore 8
    //   72: aload 8
    //   74: astore 6
    //   76: aload 9
    //   78: astore 7
    //   80: new 363	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   87: astore 12
    //   89: aload 8
    //   91: astore 6
    //   93: aload 9
    //   95: astore 7
    //   97: aload 12
    //   99: ldc 216
    //   101: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload 8
    //   107: astore 6
    //   109: aload 9
    //   111: astore 7
    //   113: aload 12
    //   115: lload_1
    //   116: invokevirtual 938	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 8
    //   122: astore 6
    //   124: aload 9
    //   126: astore 7
    //   128: aload 12
    //   130: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: astore 12
    //   135: aload 8
    //   137: astore 6
    //   139: aload 9
    //   141: astore 7
    //   143: new 363	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   150: astore 13
    //   152: aload 8
    //   154: astore 6
    //   156: aload 9
    //   158: astore 7
    //   160: aload 13
    //   162: ldc 216
    //   164: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 8
    //   170: astore 6
    //   172: aload 9
    //   174: astore 7
    //   176: aload 13
    //   178: lload_3
    //   179: invokevirtual 938	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 8
    //   185: astore 6
    //   187: aload 9
    //   189: astore 7
    //   191: aload 13
    //   193: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: astore 13
    //   198: aload 8
    //   200: astore 6
    //   202: aload 9
    //   204: astore 7
    //   206: aload 10
    //   208: aload 11
    //   210: iconst_5
    //   211: anewarray 342	java/lang/String
    //   214: dup
    //   215: iconst_0
    //   216: ldc_w 1308
    //   219: aastore
    //   220: dup
    //   221: iconst_1
    //   222: ldc_w 1310
    //   225: aastore
    //   226: dup
    //   227: iconst_2
    //   228: ldc_w 1312
    //   231: aastore
    //   232: dup
    //   233: iconst_3
    //   234: ldc_w 1314
    //   237: aastore
    //   238: dup
    //   239: iconst_4
    //   240: ldc_w 1316
    //   243: aastore
    //   244: ldc_w 1318
    //   247: iconst_2
    //   248: anewarray 342	java/lang/String
    //   251: dup
    //   252: iconst_0
    //   253: aload 12
    //   255: aastore
    //   256: dup
    //   257: iconst_1
    //   258: aload 13
    //   260: aastore
    //   261: aconst_null
    //   262: invokevirtual 1324	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   265: astore 8
    //   267: aload 8
    //   269: ifnonnull +17 -> 286
    //   272: aload 8
    //   274: ifnull +10 -> 284
    //   277: aload 8
    //   279: invokeinterface 1342 1 0
    //   284: iconst_0
    //   285: ireturn
    //   286: aload 8
    //   288: astore 6
    //   290: aload 8
    //   292: astore 7
    //   294: aload_0
    //   295: invokestatic 1737	oicq/wlogin_sdk/tools/util:get_rsa_pubkey	(Landroid/content/Context;)[B
    //   298: invokestatic 1690	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   301: astore_0
    //   302: aload 8
    //   304: astore 6
    //   306: aload 8
    //   308: astore 7
    //   310: aload_0
    //   311: invokevirtual 636	java/lang/String:length	()I
    //   314: istore 5
    //   316: iload 5
    //   318: ifne +17 -> 335
    //   321: aload 8
    //   323: ifnull +10 -> 333
    //   326: aload 8
    //   328: invokeinterface 1342 1 0
    //   333: iconst_0
    //   334: ireturn
    //   335: aload 8
    //   337: astore 6
    //   339: aload 8
    //   341: astore 7
    //   343: aload_0
    //   344: invokestatic 1337	oicq/wlogin_sdk/tools/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   347: astore 9
    //   349: aload 8
    //   351: astore 6
    //   353: aload 8
    //   355: astore 7
    //   357: aload 8
    //   359: invokeinterface 1740 1 0
    //   364: ifle +74 -> 438
    //   367: aload 8
    //   369: astore 6
    //   371: aload 8
    //   373: astore 7
    //   375: new 1742	android/content/ContentValues
    //   378: dup
    //   379: invokespecial 1743	android/content/ContentValues:<init>	()V
    //   382: astore 10
    //   384: aload 8
    //   386: astore 6
    //   388: aload 8
    //   390: astore 7
    //   392: aload 10
    //   394: ldc_w 1314
    //   397: aload_0
    //   398: invokevirtual 1746	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: aload 8
    //   403: astore 6
    //   405: aload 8
    //   407: astore 7
    //   409: aload 10
    //   411: ldc_w 1316
    //   414: aload 9
    //   416: invokevirtual 1746	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload 8
    //   421: astore 6
    //   423: aload 8
    //   425: astore 7
    //   427: aload 8
    //   429: invokeinterface 1329 1 0
    //   434: pop
    //   435: goto +242 -> 677
    //   438: aload 8
    //   440: astore 6
    //   442: aload 8
    //   444: astore 7
    //   446: new 1742	android/content/ContentValues
    //   449: dup
    //   450: invokespecial 1743	android/content/ContentValues:<init>	()V
    //   453: astore 12
    //   455: aload 8
    //   457: astore 6
    //   459: aload 8
    //   461: astore 7
    //   463: aload 12
    //   465: ldc_w 1310
    //   468: lload_1
    //   469: invokestatic 1749	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   472: invokevirtual 1752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   475: aload 8
    //   477: astore 6
    //   479: aload 8
    //   481: astore 7
    //   483: aload 12
    //   485: ldc_w 1312
    //   488: lload_3
    //   489: invokestatic 1749	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   492: invokevirtual 1752	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   495: aload 8
    //   497: astore 6
    //   499: aload 8
    //   501: astore 7
    //   503: aload 12
    //   505: ldc_w 1314
    //   508: aload_0
    //   509: invokevirtual 1746	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   512: aload 8
    //   514: astore 6
    //   516: aload 8
    //   518: astore 7
    //   520: aload 12
    //   522: ldc_w 1316
    //   525: aload 9
    //   527: invokevirtual 1746	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload 8
    //   532: astore 6
    //   534: aload 8
    //   536: astore 7
    //   538: aload 10
    //   540: aload 11
    //   542: aload 12
    //   544: invokevirtual 1756	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   547: astore_0
    //   548: aload 8
    //   550: astore 6
    //   552: aload 8
    //   554: astore 7
    //   556: new 363	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 364	java/lang/StringBuilder:<init>	()V
    //   563: astore 9
    //   565: aload 8
    //   567: astore 6
    //   569: aload 8
    //   571: astore 7
    //   573: aload 9
    //   575: ldc_w 1758
    //   578: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 8
    //   584: astore 6
    //   586: aload 8
    //   588: astore 7
    //   590: aload 9
    //   592: aload_0
    //   593: invokevirtual 1761	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: aload 8
    //   599: astore 6
    //   601: aload 8
    //   603: astore 7
    //   605: aload 9
    //   607: ldc_w 1763
    //   610: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload 8
    //   616: astore 6
    //   618: aload 8
    //   620: astore 7
    //   622: aload 9
    //   624: lload_1
    //   625: invokevirtual 938	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload 8
    //   631: astore 6
    //   633: aload 8
    //   635: astore 7
    //   637: aload 9
    //   639: ldc_w 1765
    //   642: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: aload 8
    //   648: astore 6
    //   650: aload 8
    //   652: astore 7
    //   654: aload 9
    //   656: lload_3
    //   657: invokevirtual 938	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload 8
    //   663: astore 6
    //   665: aload 8
    //   667: astore 7
    //   669: aload 9
    //   671: invokevirtual 375	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 1767	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;)V
    //   677: aload 8
    //   679: ifnull +10 -> 689
    //   682: aload 8
    //   684: invokeinterface 1342 1 0
    //   689: iconst_1
    //   690: ireturn
    //   691: astore_0
    //   692: goto +28 -> 720
    //   695: astore_0
    //   696: aload 7
    //   698: astore 6
    //   700: aload_0
    //   701: ldc 216
    //   703: invokestatic 480	oicq/wlogin_sdk/tools/util:printException	(Ljava/lang/Exception;Ljava/lang/String;)V
    //   706: aload 7
    //   708: ifnull +10 -> 718
    //   711: aload 7
    //   713: invokeinterface 1342 1 0
    //   718: iconst_0
    //   719: ireturn
    //   720: aload 6
    //   722: ifnull +10 -> 732
    //   725: aload 6
    //   727: invokeinterface 1342 1 0
    //   732: aload_0
    //   733: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	734	0	paramContext	Context
    //   0	734	1	paramLong1	long
    //   0	734	3	paramLong2	long
    //   314	3	5	i	int
    //   19	707	6	localObject1	Object
    //   78	634	7	localObject2	Object
    //   70	613	8	localCursor	android.database.Cursor
    //   67	603	9	localObject3	Object
    //   10	529	10	localObject4	Object
    //   56	485	11	localUri	Uri
    //   87	456	12	localObject5	Object
    //   150	109	13	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   80	89	691	finally
    //   97	105	691	finally
    //   113	120	691	finally
    //   128	135	691	finally
    //   143	152	691	finally
    //   160	168	691	finally
    //   176	183	691	finally
    //   191	198	691	finally
    //   206	267	691	finally
    //   294	302	691	finally
    //   310	316	691	finally
    //   343	349	691	finally
    //   357	367	691	finally
    //   375	384	691	finally
    //   392	401	691	finally
    //   409	419	691	finally
    //   427	435	691	finally
    //   446	455	691	finally
    //   463	475	691	finally
    //   483	495	691	finally
    //   503	512	691	finally
    //   520	530	691	finally
    //   538	548	691	finally
    //   556	565	691	finally
    //   573	582	691	finally
    //   590	597	691	finally
    //   605	614	691	finally
    //   622	629	691	finally
    //   637	646	691	finally
    //   654	661	691	finally
    //   669	677	691	finally
    //   700	706	691	finally
    //   80	89	695	java/lang/Exception
    //   97	105	695	java/lang/Exception
    //   113	120	695	java/lang/Exception
    //   128	135	695	java/lang/Exception
    //   143	152	695	java/lang/Exception
    //   160	168	695	java/lang/Exception
    //   176	183	695	java/lang/Exception
    //   191	198	695	java/lang/Exception
    //   206	267	695	java/lang/Exception
    //   294	302	695	java/lang/Exception
    //   310	316	695	java/lang/Exception
    //   343	349	695	java/lang/Exception
    //   357	367	695	java/lang/Exception
    //   375	384	695	java/lang/Exception
    //   392	401	695	java/lang/Exception
    //   409	419	695	java/lang/Exception
    //   427	435	695	java/lang/Exception
    //   446	455	695	java/lang/Exception
    //   463	475	695	java/lang/Exception
    //   483	495	695	java/lang/Exception
    //   503	512	695	java/lang/Exception
    //   520	530	695	java/lang/Exception
    //   538	548	695	java/lang/Exception
    //   556	565	695	java/lang/Exception
    //   573	582	695	java/lang/Exception
    //   590	597	695	java/lang/Exception
    //   605	614	695	java/lang/Exception
    //   622	629	695	java/lang/Exception
    //   637	646	695	java/lang/Exception
    //   654	661	695	java/lang/Exception
    //   669	677	695	java/lang/Exception
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
      int j = i * 2;
      arrayOfByte[i] = ((byte)((get_char((byte)paramString.charAt(j)) << 4) + get_char((byte)paramString.charAt(j + 1))));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[][] unpackBundle(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int j = paramBundle.getInt("len");
      int i = 0;
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
  
  public static void writeFile(String paramString, byte[] paramArrayOfByte)
  {
    if (paramString != null) {
      label87:
      try
      {
        int i = paramString.length();
        if (i != 0) {}
      }
      finally {}
    }
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists())
      {
        File localFile = paramString.getParentFile();
        if (localFile != null)
        {
          if (!localFile.mkdirs())
          {
            boolean bool = localFile.isDirectory();
            if (bool) {}
          }
        }
        else {
          return;
        }
      }
      paramString = new FileOutputStream(paramString, true);
      paramString.write(paramArrayOfByte);
      paramString.close();
    }
    catch (Exception paramString)
    {
      break label87;
    }
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     oicq.wlogin_sdk.tools.util
 * JD-Core Version:    0.7.0.1
 */