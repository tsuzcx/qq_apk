package cooperation.qwallet.plugin.impl;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class QWalletHelperDelegate
{
  private static final String TAG = "QWalletHelperDelegate";
  public static boolean graphbSpeedEnable = false;
  static String mDeviceId;
  public static boolean mIsEnterPayBridge = false;
  public static int sEnterQWalletPluginCount;
  public static int sFullWindowActivitySource;
  public static int sFullWndCurID;
  public static int sFullWndCurType;
  public static long sReporteSeq;
  
  public static String desDecrypt(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (16 == paramString2.length()) && (16 == paramString3.length())) {
      try
      {
        paramString1 = Base64.decode(paramString1, 2);
        paramString3 = new IvParameterSpec(paramString3.getBytes());
        paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localCipher.init(2, paramString2, paramString3);
        paramString1 = new String(localCipher.doFinal(paramString1));
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return "";
      }
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("AES decrypt key error = ");
      paramString1.append(paramString2);
      paramString1.append(" : ");
      paramString1.append(paramString3);
      QLog.d("Q.qwallet.redpack", 2, paramString1.toString());
    }
    return null;
  }
  
  public static String desEncrypt(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (16 == paramString2.length()) && (16 == paramString3.length())) {
      try
      {
        paramString3 = new IvParameterSpec(paramString3.getBytes());
        paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localCipher.init(1, paramString2, paramString3);
        paramString1 = Base64.encodeToString(localCipher.doFinal(paramString1.getBytes()), 2);
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return "";
      }
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("AES encrypt key error = ");
      paramString1.append(paramString2);
      paramString1.append(" : ");
      paramString1.append(paramString3);
      QLog.d("Q.qwallet.redpack", 2, paramString1.toString());
    }
    return null;
  }
  
  public static String getQWDevId()
  {
    if (mDeviceId == null) {
      try
      {
        mDeviceId = QQDeviceInfo.getIMEI("5076bf");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deviceId is:");
      localStringBuilder.append(mDeviceId);
      QLog.i("QWalletHelperDelegate", 1, localStringBuilder.toString());
    }
    return mDeviceId;
  }
  
  public static String hexdigest(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    char[] arrayOfChar = new char[16];
    char[] tmp15_13 = arrayOfChar;
    tmp15_13[0] = 48;
    char[] tmp20_15 = tmp15_13;
    tmp20_15[1] = 49;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[2] = 50;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[3] = 51;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[4] = 52;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[5] = 53;
    char[] tmp45_40 = tmp40_35;
    tmp45_40[6] = 54;
    char[] tmp51_45 = tmp45_40;
    tmp51_45[7] = 55;
    char[] tmp57_51 = tmp51_45;
    tmp57_51[8] = 56;
    char[] tmp63_57 = tmp57_51;
    tmp63_57[9] = 57;
    char[] tmp69_63 = tmp63_57;
    tmp69_63[10] = 65;
    char[] tmp75_69 = tmp69_63;
    tmp75_69[11] = 66;
    char[] tmp81_75 = tmp75_69;
    tmp81_75[12] = 67;
    char[] tmp87_81 = tmp81_75;
    tmp87_81[13] = 68;
    char[] tmp93_87 = tmp87_81;
    tmp93_87[14] = 69;
    char[] tmp99_93 = tmp93_87;
    tmp99_93[15] = 70;
    tmp99_93;
    for (;;)
    {
      Object localObject;
      int i;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        paramString = ((MessageDigest)localObject).digest();
        localObject = new char[32];
        i = 0;
        j = 0;
      }
      catch (Exception paramString)
      {
        continue;
      }
      paramString = new String((char[])localObject);
      return paramString;
      return null;
      while (i < 16)
      {
        int k = paramString[i];
        int m = j + 1;
        localObject[j] = arrayOfChar[(k >>> 4 & 0xF)];
        j = m + 1;
        localObject[m] = arrayOfChar[(k & 0xF)];
        i += 1;
      }
    }
  }
  
  public static boolean isQWalletProcessExist(Context paramContext)
  {
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        int i = "com.tencent.mobileqq:tool".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName);
        if (i == 0) {
          return true;
        }
      }
    }
    catch (Throwable paramContext)
    {
      if (QLog.isDevelopLevel()) {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.impl.QWalletHelperDelegate
 * JD-Core Version:    0.7.0.1
 */