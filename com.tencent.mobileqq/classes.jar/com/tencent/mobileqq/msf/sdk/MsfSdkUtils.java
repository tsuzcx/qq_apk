package com.tencent.mobileqq.msf.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AppOpsManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class MsfSdkUtils
{
  private static final String APP_FILE_PATH = "/data/data/com.tencent.mobileqq/files";
  public static final String BUSINESS_ID_VIP_CUSTOMIZE_ONLINE_STATUS = "bussiness_id_customize_online_status";
  public static final int MODE_ERR_MANU = -10003;
  public static final int MODE_ERR_SERVICE = -10001;
  public static final int MODE_EXCEPTION = -10000;
  public static final int MODE_LOW_END = -10002;
  public static final int MODE_UNINIT = -9999;
  private static final int OP_AUTO_START_MI_ABOVE_23 = 10008;
  private static final int OP_AUTO_START_MI_BELOW_23 = 50;
  public static final String TAG_COREUTIL_TOMSGE_UID = "__CoreUtil_toMsg_Uid";
  public static final boolean isPublicVersion = false;
  private static final String[] s_validBusId = { "bussiness_id_customize_online_status" };
  private static final AtomicInteger seqFactory = new AtomicInteger(new Random().nextInt(100000));
  private static final String tag = "MsfSdkUtils";
  public static final SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
  
  public static void addFromMsgProcessName(String paramString, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return;
    }
    paramFromServiceMsg.getAttributes().put("to_SenderProcessName", paramString);
  }
  
  public static void addLoginSimpleAccount(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        QLog.d("MsfSdkUtils", 1, new Object[] { "add login user ", getShortUin(paramString), "_", Boolean.valueOf(paramBoolean) });
        Object localObject = getNewAppUinStoreFile();
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        if (((File)localObject).exists())
        {
          if (isAccountFileExist((File)localObject, paramString))
          {
            updateSimpleAccountNotCreate(paramString, true);
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((File)localObject).getAbsolutePath());
          localStringBuilder.append("/u_");
          localStringBuilder.append(paramString);
          if (!paramBoolean) {
            break label204;
          }
          localObject = "_t";
          localStringBuilder.append((String)localObject);
          localObject = new File(localStringBuilder.toString());
          try
          {
            ((File)localObject).createNewFile();
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("add user failed ");
              localStringBuilder.append(paramString);
              localStringBuilder.append(" ");
              localStringBuilder.append(localException);
              QLog.d("MsfSdkUtils", 2, localStringBuilder.toString());
            }
          }
        }
        return;
      }
      finally {}
      label204:
      String str = "_f";
    }
  }
  
  public static void addSimpleAccount(String paramString)
  {
    try
    {
      QLog.d("MsfSdkUtils", 1, new Object[] { "add user ", getShortUin(paramString) });
      Object localObject = getNewAppUinStoreFile();
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      if (((File)localObject).exists())
      {
        boolean bool = isAccountFileExist((File)localObject, paramString);
        if (bool) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append("/u_");
        localStringBuilder.append(paramString);
        localStringBuilder.append("_f");
        localObject = new File(localStringBuilder.toString());
        try
        {
          ((File)localObject).createNewFile();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("add user succ ");
            ((StringBuilder)localObject).append(paramString);
            QLog.d("MsfSdkUtils", 2, ((StringBuilder)localObject).toString());
          }
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("add user failed ");
            localStringBuilder.append(paramString);
            localStringBuilder.append(" ");
            localStringBuilder.append(localException);
            QLog.d("MsfSdkUtils", 2, localStringBuilder.toString());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public static void addToMsgProcessName(String paramString, ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return;
    }
    paramToServiceMsg.getAttributes().put("to_SenderProcessName", paramString);
  }
  
  public static FromServiceMsg constructResponse(ToServiceMsg paramToServiceMsg, int paramInt, String paramString, Object paramObject)
  {
    if (paramToServiceMsg == null) {
      return new FromServiceMsg();
    }
    paramString = constructResponse(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd(), paramToServiceMsg.getAppId(), paramInt, paramString, paramObject, paramToServiceMsg.getRequestSsoSeq());
    paramString.setAppSeq(paramToServiceMsg.getAppSeq());
    return paramString;
  }
  
  public static FromServiceMsg constructResponse(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, Object paramObject, int paramInt3)
  {
    paramString1 = new FromServiceMsg(paramString1, paramString2);
    paramString1.setAppId(paramInt1);
    if (paramInt2 != 1000) {
      paramString1.setBusinessFail(paramInt2, paramString3);
    } else {
      paramString1.setMsgSuccess();
    }
    if (paramObject != null) {
      paramString1.addAttribute(paramString2, paramObject);
    }
    paramString1.setRequestSsoSeq(paramInt3);
    return paramString1;
  }
  
  public static int convertBytes2Int(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    return paramArrayOfByte[3] << 0 & 0xFF | i << 24 & 0xFF000000 | j << 16 & 0xFF0000 | k << 8 & 0xFF00;
  }
  
  public static int convertBytes2Int(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 0)];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return paramArrayOfByte[(paramInt + 3)] << 0 & 0xFF | i << 24 & 0xFF000000 | j << 16 & 0xFF0000 | k << 8 & 0xFF00;
  }
  
  public static byte[] convertInt2Bytes(int paramInt)
  {
    return new byte[] { (byte)(paramInt >>> 24 & 0xFF), (byte)(paramInt >>> 16 & 0xFF), (byte)(paramInt >>> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static void delSimpleAccount(String paramString)
  {
    try
    {
      File localFile = getNewAppUinStoreFile();
      if (localFile.exists())
      {
        String[] arrayOfString = localFile.list();
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = arrayOfString[i];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("u_");
          localStringBuilder.append(paramString);
          localStringBuilder.append("_f");
          if (!((String)localObject).equals(localStringBuilder.toString()))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("u_");
            localStringBuilder.append(paramString);
            localStringBuilder.append("_t");
            if (!((String)localObject).equals(localStringBuilder.toString())) {}
          }
          else
          {
            new File(localFile.getPath(), (String)localObject).delete();
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("del user succ ");
              ((StringBuilder)localObject).append(paramString);
              QLog.d("MsfSdkUtils", 2, ((StringBuilder)localObject).toString());
            }
          }
          i += 1;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static String getAppBuildNum()
  {
    return BaseApplication.buildNum;
  }
  
  public static String getAppChannelId()
  {
    return BaseApplication.getContext().getChannelId();
  }
  
  public static File getAppUinBackStoreFile()
  {
    try
    {
      localObject = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    }
    catch (Exception localException2)
    {
      Object localObject;
      label13:
      break label13;
    }
    localObject = "/data/data/com.tencent.mobileqq/files";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/simpleback.user");
      localObject = new File(localStringBuilder.toString());
      return localObject;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      return null;
    }
  }
  
  public static File getAppUinStoreFile()
  {
    try
    {
      localObject = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    }
    catch (Exception localException2)
    {
      Object localObject;
      label13:
      break label13;
    }
    localObject = "/data/data/com.tencent.mobileqq/files";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/simple.user");
      localObject = new File(localStringBuilder.toString());
      return localObject;
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      return null;
    }
  }
  
  public static String getAppVersion()
  {
    return BaseApplication.reportVersionName;
  }
  
  public static String getAppid()
  {
    return String.valueOf(BaseApplication.getContext().getAppId());
  }
  
  public static int getAutoStartMode(Context paramContext)
  {
    if (!"Xiaomi".equals(Build.MANUFACTURER)) {
      return -10003;
    }
    if (Build.VERSION.SDK_INT < 19) {
      return -10002;
    }
    try
    {
      AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
      Method localMethod = localAppOpsManager.getClass().getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
      int i = 10008;
      if (Build.VERSION.SDK_INT < 23) {
        i = 50;
      }
      paramContext = paramContext.getApplicationInfo();
      i = ((Integer)localMethod.invoke(localAppOpsManager, new Object[] { Integer.valueOf(i), Integer.valueOf(paramContext.uid), paramContext.packageName })).intValue();
      return i;
    }
    catch (Throwable paramContext)
    {
      QLog.d("MsfSdk", 1, "getAutoStartMode", paramContext);
    }
    return -10000;
  }
  
  public static String getCurrentThreadStackString()
  {
    Object localObject2 = null;
    StringBuilder localStringBuilder = null;
    localObject1 = localObject2;
    try
    {
      StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
      if (arrayOfStackTraceElement != null)
      {
        localObject1 = localObject2;
        localStringBuilder = new StringBuilder(1024);
      }
      localObject1 = localStringBuilder;
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      for (;;)
      {
        localObject1 = localStringBuilder;
        if (i >= j) {
          break;
        }
        localObject1 = localStringBuilder;
        localStringBuilder.append(arrayOfStackTraceElement[i].toString());
        localObject1 = localStringBuilder;
        localStringBuilder.append("#");
        i += 1;
      }
      return ((StringBuilder)localObject1).toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (localObject1 == null) {
        return "";
      }
    }
  }
  
  public static String getIMEIForMain(String paramString)
  {
    if (!isValidBusId(paramString)) {
      return "";
    }
    try
    {
      localTelephonyManager = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
      boolean bool = new File(MsfCore.getIMEIPath()).exists();
      if (!bool) {
        break label587;
      }
      paramString = loadConfig(MsfCore.getIMEIPath()).getProperty("imei");
      if (paramString == null) {}
    }
    catch (Exception localException3)
    {
      TelephonyManager localTelephonyManager;
      String str3;
      Object localObject1;
      label206:
      int j;
      label278:
      paramString = "";
    }
    try
    {
      if (paramString.length() != 0) {
        break label576;
      }
      Thread.sleep(200L);
      str3 = loadConfig(MsfCore.getIMEIPath()).getProperty("imei", null);
      localObject1 = str3;
      paramString = str3;
      try
      {
        if (QLog.isColorLevel())
        {
          paramString = str3;
          localObject1 = new StringBuilder();
          paramString = str3;
          ((StringBuilder)localObject1).append("read imei from file ");
          paramString = str3;
          ((StringBuilder)localObject1).append(MsfCore.getIMEIPath());
          paramString = str3;
          ((StringBuilder)localObject1).append(", imei:");
          paramString = str3;
          ((StringBuilder)localObject1).append(str3);
          paramString = str3;
          ((StringBuilder)localObject1).append(",with order:");
          paramString = str3;
          ((StringBuilder)localObject1).append(1);
          paramString = str3;
          QLog.d("MsfSdkUtils", 2, ((StringBuilder)localObject1).toString());
          localObject1 = str3;
        }
        if (localObject1 != null)
        {
          paramString = (String)localObject1;
          i = ((String)localObject1).length();
          if (i != 0) {
            break label601;
          }
        }
      }
      catch (Exception localException1)
      {
        break label520;
      }
      if (localTelephonyManager == null) {
        break label601;
      }
      paramString = localException1;
      try
      {
        str3 = PhoneInfoMonitor.getDeviceId(localTelephonyManager);
      }
      catch (SecurityException localSecurityException)
      {
        paramString = localException1;
        if (!QLog.isColorLevel()) {
          break label595;
        }
      }
      paramString = localException1;
      QLog.d("MsfSdkUtils", 2, "read sys imei SecurityException=", localSecurityException);
    }
    catch (Exception localException4)
    {
      break label520;
    }
    if (localSecurityException != null)
    {
      paramString = localException1;
      i = localSecurityException.length();
      if (i > 0) {
        try
        {
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("read sys imei:");
            paramString.append(localSecurityException);
            QLog.d("MsfSdkUtils", 2, paramString.toString());
          }
          i = 3;
        }
        catch (Exception localException2)
        {
          paramString = localSecurityException;
          break label520;
        }
      }
    }
    j = 4;
    paramString = localException2;
    Object localObject3 = localException2;
    int i = j;
    if (QLog.isColorLevel())
    {
      paramString = localException2;
      localObject3 = new StringBuilder();
      paramString = localException2;
      ((StringBuilder)localObject3).append("load imei:");
      paramString = localException2;
      ((StringBuilder)localObject3).append(localException2);
      paramString = localException2;
      QLog.d("MsfSdkUtils", 2, ((StringBuilder)localObject3).toString());
      localObject3 = localException2;
      i = j;
    }
    for (;;)
    {
      paramString = (String)localObject3;
      Object localObject2 = localObject3;
      label520:
      String str1;
      if (QLog.isColorLevel())
      {
        paramString = (String)localObject3;
        localObject2 = new StringBuilder();
        paramString = (String)localObject3;
        ((StringBuilder)localObject2).append("save imei:");
        paramString = (String)localObject3;
        ((StringBuilder)localObject2).append((String)localObject3);
        paramString = (String)localObject3;
        ((StringBuilder)localObject2).append(",with order:");
        paramString = (String)localObject3;
        ((StringBuilder)localObject2).append(i);
        paramString = (String)localObject3;
        QLog.d("MsfSdkUtils", 1, ((StringBuilder)localObject2).toString());
        localObject2 = localObject3;
        break label562;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("read sys imei error ");
        ((StringBuilder)localObject3).append(localException3);
        QLog.d("MsfSdkUtils", 1, ((StringBuilder)localObject3).toString(), localException3);
        str1 = paramString;
      }
      label562:
      paramString = str1;
      if (str1 == null) {
        paramString = "";
      }
      return paramString;
      label576:
      localObject3 = paramString;
      break;
      label587:
      String str2 = "";
      break label206;
      label595:
      localObject3 = null;
      break label278;
      label601:
      i = 1;
      localObject3 = str2;
    }
  }
  
  public static ArrayList getLoginedAccountList()
  {
    try
    {
      Object localObject1 = getNewAppUinStoreFile();
      Object localObject3;
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        localObject1 = ((File)localObject1).list();
        localObject3 = new ArrayList();
        if (localObject1 == null) {
          return localObject3;
        }
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          String str1 = localObject1[i];
          try
          {
            if (str1.startsWith("u_"))
            {
              String str2 = str1.substring(2, str1.length() - 2);
              boolean bool = str1.endsWith("_t");
              localObject4 = new SimpleAccount();
              ((SimpleAccount)localObject4).setUin(str2);
              ((SimpleAccount)localObject4).setAttribute("_isLogined", String.valueOf(bool));
              if (isUinLong(str2))
              {
                ((ArrayList)localObject3).add(localObject4);
              }
              else
              {
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("found invalid uin: ");
                ((StringBuilder)localObject4).append(str2);
                QLog.d("MsfSdkUtils", 1, ((StringBuilder)localObject4).toString());
              }
            }
          }
          catch (Exception localException)
          {
            Object localObject4;
            if (QLog.isColorLevel())
            {
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("parse user failed ");
              ((StringBuilder)localObject4).append(localException);
              ((StringBuilder)localObject4).append(" ");
              ((StringBuilder)localObject4).append(str1);
              QLog.d("MsfSdkUtils", 2, ((StringBuilder)localObject4).toString());
            }
          }
          i += 1;
        }
        return localObject3;
      }
      localObject1 = getLoginedAccountList(getAppUinStoreFile());
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("load accountList ");
        ((StringBuilder)localObject3).append(((ArrayList)localObject1).size());
        QLog.d("MsfSdkUtils", 1, ((StringBuilder)localObject3).toString());
      }
      else
      {
        localObject3 = getLoginedAccountList(getAppUinBackStoreFile());
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("load accountList ");
            ((StringBuilder)localObject1).append(((ArrayList)localObject3).size());
            ((StringBuilder)localObject1).append(" from backFile");
            QLog.d("MsfSdkUtils", 2, ((StringBuilder)localObject1).toString());
            localObject1 = localObject3;
          }
        }
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  /* Error */
  public static ArrayList getLoginedAccountList(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 452	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 453	java/util/ArrayList:<init>	()V
    //   10: astore 4
    //   12: aload_0
    //   13: ifnull +232 -> 245
    //   16: aload_0
    //   17: invokevirtual 125	java/io/File:exists	()Z
    //   20: ifne +6 -> 26
    //   23: goto +222 -> 245
    //   26: new 408	java/util/Properties
    //   29: dup
    //   30: invokespecial 504	java/util/Properties:<init>	()V
    //   33: astore_2
    //   34: aconst_null
    //   35: astore_3
    //   36: aconst_null
    //   37: astore_1
    //   38: new 506	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 509	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: astore_0
    //   47: aload_2
    //   48: aload_0
    //   49: invokevirtual 513	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   52: aload_2
    //   53: invokevirtual 517	java/util/Properties:keySet	()Ljava/util/Set;
    //   56: invokeinterface 523 1 0
    //   61: astore_1
    //   62: aload_1
    //   63: invokeinterface 528 1 0
    //   68: ifeq +98 -> 166
    //   71: aload_1
    //   72: invokeinterface 532 1 0
    //   77: checkcast 71	java/lang/String
    //   80: astore_3
    //   81: aload_2
    //   82: aload_3
    //   83: invokevirtual 411	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 5
    //   88: aload 5
    //   90: ifnull -28 -> 62
    //   93: aload 5
    //   95: invokestatic 536	com/tencent/qphone/base/remote/SimpleAccount:parseSimpleAccount	(Ljava/lang/String;)Lcom/tencent/qphone/base/remote/SimpleAccount;
    //   98: astore 5
    //   100: aload 5
    //   102: ifnull -40 -> 62
    //   105: aload 5
    //   107: invokevirtual 537	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   110: invokestatic 480	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:isUinLong	(Ljava/lang/String;)Z
    //   113: ifeq +14 -> 127
    //   116: aload 4
    //   118: aload 5
    //   120: invokevirtual 483	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   123: pop
    //   124: goto -62 -> 62
    //   127: new 137	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   134: astore 5
    //   136: aload 5
    //   138: ldc_w 485
    //   141: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 5
    //   147: aload_3
    //   148: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc 39
    //   154: iconst_1
    //   155: aload 5
    //   157: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 170	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: goto -101 -> 62
    //   166: aload_0
    //   167: invokevirtual 540	java/io/FileInputStream:close	()V
    //   170: goto +51 -> 221
    //   173: astore_0
    //   174: aload_0
    //   175: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   178: goto +43 -> 221
    //   181: astore_1
    //   182: goto +45 -> 227
    //   185: astore_2
    //   186: goto +14 -> 200
    //   189: astore_2
    //   190: aload_1
    //   191: astore_0
    //   192: aload_2
    //   193: astore_1
    //   194: goto +33 -> 227
    //   197: astore_2
    //   198: aload_3
    //   199: astore_0
    //   200: aload_0
    //   201: astore_1
    //   202: aload_2
    //   203: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   206: aload_0
    //   207: ifnull +14 -> 221
    //   210: aload_0
    //   211: invokevirtual 540	java/io/FileInputStream:close	()V
    //   214: goto +7 -> 221
    //   217: astore_0
    //   218: goto -44 -> 174
    //   221: ldc 2
    //   223: monitorexit
    //   224: aload 4
    //   226: areturn
    //   227: aload_0
    //   228: ifnull +15 -> 243
    //   231: aload_0
    //   232: invokevirtual 540	java/io/FileInputStream:close	()V
    //   235: goto +8 -> 243
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   243: aload_1
    //   244: athrow
    //   245: ldc 2
    //   247: monitorexit
    //   248: aload 4
    //   250: areturn
    //   251: astore_0
    //   252: ldc 2
    //   254: monitorexit
    //   255: goto +5 -> 260
    //   258: aload_0
    //   259: athrow
    //   260: goto -2 -> 258
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramFile	File
    //   37	35	1	localIterator	Iterator
    //   181	10	1	localObject1	Object
    //   193	51	1	localObject2	Object
    //   33	49	2	localProperties	Properties
    //   185	1	2	localException1	Exception
    //   189	4	2	localObject3	Object
    //   197	6	2	localException2	Exception
    //   35	164	3	str	String
    //   10	239	4	localArrayList	ArrayList
    //   86	70	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   166	170	173	java/io/IOException
    //   47	62	181	finally
    //   62	88	181	finally
    //   93	100	181	finally
    //   105	124	181	finally
    //   127	163	181	finally
    //   47	62	185	java/lang/Exception
    //   62	88	185	java/lang/Exception
    //   93	100	185	java/lang/Exception
    //   105	124	185	java/lang/Exception
    //   127	163	185	java/lang/Exception
    //   38	47	189	finally
    //   202	206	189	finally
    //   38	47	197	java/lang/Exception
    //   210	214	217	java/io/IOException
    //   231	235	238	java/io/IOException
    //   3	12	251	finally
    //   16	23	251	finally
    //   26	34	251	finally
    //   166	170	251	finally
    //   174	178	251	finally
    //   210	214	251	finally
    //   231	235	251	finally
    //   239	243	251	finally
    //   243	245	251	finally
  }
  
  public static File getNewAppUinStoreFile()
  {
    try
    {
      str = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    }
    catch (Exception localException1)
    {
      String str;
      label13:
      break label13;
    }
    str = "/data/data/com.tencent.mobileqq/files";
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("/user/");
      localObject = new File(((StringBuilder)localObject).toString());
      return localObject;
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get user file error ");
        localStringBuilder.append(str);
        localStringBuilder.append(" ");
        localStringBuilder.append(localException2);
        QLog.e("MsfSdkUtils", 2, localStringBuilder.toString());
      }
      return null;
    }
  }
  
  public static int getNextAppSeq()
  {
    try
    {
      int j = seqFactory.incrementAndGet();
      if (j > 1000000) {
        seqFactory.set(new Random().nextInt(100000));
      }
      int i = j;
      if (j == 50000) {
        i = j + 10000;
      }
      return i;
    }
    finally {}
  }
  
  /* Error */
  private static String getProcessName(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_2
    //   6: astore_1
    //   7: new 137	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   14: astore_3
    //   15: aload_2
    //   16: astore_1
    //   17: aload_3
    //   18: ldc_w 560
    //   21: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_2
    //   26: astore_1
    //   27: aload_3
    //   28: iload_0
    //   29: invokevirtual 432	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: astore_1
    //   35: aload_3
    //   36: ldc_w 562
    //   39: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: astore_1
    //   45: new 564	java/io/FileReader
    //   48: dup
    //   49: aload_3
    //   50: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 565	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   56: astore_2
    //   57: sipush 512
    //   60: newarray char
    //   62: astore_1
    //   63: aload_2
    //   64: aload_1
    //   65: invokevirtual 569	java/io/FileReader:read	([C)I
    //   68: pop
    //   69: iconst_0
    //   70: istore_0
    //   71: iload_0
    //   72: aload_1
    //   73: arraylength
    //   74: if_icmpge +12 -> 86
    //   77: aload_1
    //   78: iload_0
    //   79: caload
    //   80: ifne +102 -> 182
    //   83: goto +3 -> 86
    //   86: new 71	java/lang/String
    //   89: dup
    //   90: aload_1
    //   91: invokespecial 572	java/lang/String:<init>	([C)V
    //   94: iconst_0
    //   95: iload_0
    //   96: invokevirtual 460	java/lang/String:substring	(II)Ljava/lang/String;
    //   99: astore_1
    //   100: aload_2
    //   101: invokevirtual 573	java/io/FileReader:close	()V
    //   104: aload_1
    //   105: areturn
    //   106: astore_3
    //   107: aload_2
    //   108: astore_1
    //   109: aload_3
    //   110: astore_2
    //   111: goto +39 -> 150
    //   114: astore_3
    //   115: goto +11 -> 126
    //   118: astore_2
    //   119: goto +31 -> 150
    //   122: astore_3
    //   123: aload 4
    //   125: astore_2
    //   126: aload_2
    //   127: astore_1
    //   128: ldc 39
    //   130: iconst_1
    //   131: ldc_w 575
    //   134: aload_3
    //   135: invokestatic 577	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   138: aload_2
    //   139: ifnull +7 -> 146
    //   142: aload_2
    //   143: invokevirtual 573	java/io/FileReader:close	()V
    //   146: ldc_w 579
    //   149: areturn
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 573	java/io/FileReader:close	()V
    //   158: goto +5 -> 163
    //   161: aload_2
    //   162: athrow
    //   163: goto -2 -> 161
    //   166: astore_2
    //   167: aload_1
    //   168: areturn
    //   169: astore_1
    //   170: goto -32 -> 138
    //   173: astore_1
    //   174: ldc_w 579
    //   177: areturn
    //   178: astore_1
    //   179: goto -21 -> 158
    //   182: iload_0
    //   183: iconst_1
    //   184: iadd
    //   185: istore_0
    //   186: goto -115 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramInt	int
    //   6	162	1	localObject1	Object
    //   169	1	1	localThrowable1	Throwable
    //   173	1	1	localThrowable2	Throwable
    //   178	1	1	localThrowable3	Throwable
    //   4	107	2	localObject2	Object
    //   118	1	2	localObject3	Object
    //   125	37	2	localObject4	Object
    //   166	1	2	localThrowable4	Throwable
    //   14	36	3	localStringBuilder	StringBuilder
    //   106	4	3	localObject5	Object
    //   114	1	3	localThrowable5	Throwable
    //   122	13	3	localThrowable6	Throwable
    //   1	123	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   57	69	106	finally
    //   71	77	106	finally
    //   86	100	106	finally
    //   57	69	114	java/lang/Throwable
    //   71	77	114	java/lang/Throwable
    //   86	100	114	java/lang/Throwable
    //   7	15	118	finally
    //   17	25	118	finally
    //   27	33	118	finally
    //   35	43	118	finally
    //   45	57	118	finally
    //   128	138	118	finally
    //   7	15	122	java/lang/Throwable
    //   17	25	122	java/lang/Throwable
    //   27	33	122	java/lang/Throwable
    //   35	43	122	java/lang/Throwable
    //   45	57	122	java/lang/Throwable
    //   100	104	166	java/lang/Throwable
    //   128	138	169	java/lang/Throwable
    //   142	146	173	java/lang/Throwable
    //   154	158	178	java/lang/Throwable
  }
  
  public static String getProcessName(Context paramContext)
  {
    if (paramContext == null) {
      return "unknown";
    }
    Context localContext = null;
    Object localObject;
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        localContext = paramContext;
        localObject = paramContext.iterator();
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        do
        {
          do
          {
            localContext = paramContext;
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localContext = paramContext;
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
          } while (localRunningAppProcessInfo == null);
          localContext = paramContext;
        } while (localRunningAppProcessInfo.pid != Process.myPid());
        localContext = paramContext;
        paramContext = localRunningAppProcessInfo.processName;
        return paramContext;
      }
    }
    catch (Exception paramContext) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getProcessName error ");
      ((StringBuilder)localObject).append(localContext);
      QLog.d("MsfSdkUtils", 1, ((StringBuilder)localObject).toString(), paramContext);
      label119:
      return getProcessName(Process.myPid());
    }
    catch (Throwable paramContext)
    {
      break label119;
    }
  }
  
  public static String getProcessNameIfNoPrivacyPolicy(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return Application.getProcessName();
    }
    if (Build.VERSION.SDK_INT < 23) {
      return getProcessName(paramContext);
    }
    try
    {
      localClass = Class.forName("android.app.ActivityThread");
      if (Build.VERSION.SDK_INT < 18) {
        break label78;
      }
      paramContext = "currentProcessName";
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        Class localClass;
        continue;
        paramContext = "currentPackageName";
      }
    }
    paramContext = (String)localClass.getDeclaredMethod(paramContext, new Class[0]).invoke(null, new Object[0]);
    return paramContext;
    return "unknown";
  }
  
  public static String getResolutionString(Context paramContext)
  {
    int k = paramContext.getResources().getDisplayMetrics().widthPixels;
    int i = paramContext.getResources().getDisplayMetrics().heightPixels;
    int m = k;
    int j = i;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      j = k;
      m = i;
    }
    paramContext = new StringBuilder();
    paramContext.append(m);
    paramContext.append("X");
    paramContext.append(j);
    return paramContext.toString();
  }
  
  /* Error */
  public static int getRoutingID(Context paramContext)
  {
    // Byte code:
    //   0: new 137	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   7: astore_0
    //   8: aload_0
    //   9: invokestatic 266	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: invokevirtual 273	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 142	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_0
    //   23: ldc_w 661
    //   26: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_0
    //   31: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore_0
    //   35: new 137	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   42: astore_2
    //   43: aload_2
    //   44: aload_0
    //   45: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: ldc_w 663
    //   53: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore_3
    //   62: new 121	java/io/File
    //   65: dup
    //   66: aload_3
    //   67: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   70: astore_0
    //   71: aload_0
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual 666	java/io/File:canRead	()Z
    //   77: ifne +12 -> 89
    //   80: new 121	java/io/File
    //   83: dup
    //   84: aload_3
    //   85: invokespecial 154	java/io/File:<init>	(Ljava/lang/String;)V
    //   88: astore_2
    //   89: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +89 -> 181
    //   95: new 137	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   102: astore_0
    //   103: aload_0
    //   104: ldc_w 668
    //   107: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_0
    //   112: aload_2
    //   113: invokevirtual 142	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_0
    //   121: ldc_w 670
    //   124: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_0
    //   129: aload_2
    //   130: invokevirtual 673	java/io/File:isFile	()Z
    //   133: invokevirtual 676	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_0
    //   138: ldc_w 678
    //   141: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_0
    //   146: aload_2
    //   147: invokevirtual 666	java/io/File:canRead	()Z
    //   150: invokevirtual 676	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_0
    //   155: ldc_w 680
    //   158: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_0
    //   163: aload_2
    //   164: invokevirtual 683	java/io/File:length	()J
    //   167: invokevirtual 686	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: ldc 39
    //   173: iconst_2
    //   174: aload_0
    //   175: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 689	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: new 408	java/util/Properties
    //   184: dup
    //   185: invokespecial 504	java/util/Properties:<init>	()V
    //   188: astore 6
    //   190: aconst_null
    //   191: astore 5
    //   193: aconst_null
    //   194: astore 4
    //   196: aconst_null
    //   197: astore_3
    //   198: aload 5
    //   200: astore_0
    //   201: aload_2
    //   202: invokevirtual 125	java/io/File:exists	()Z
    //   205: ifeq +42 -> 247
    //   208: aload 5
    //   210: astore_0
    //   211: new 506	java/io/FileInputStream
    //   214: dup
    //   215: aload_2
    //   216: invokespecial 509	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   219: astore_2
    //   220: aload 6
    //   222: aload_2
    //   223: invokevirtual 513	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   226: aload_2
    //   227: invokevirtual 540	java/io/FileInputStream:close	()V
    //   230: aload_2
    //   231: astore_3
    //   232: goto +15 -> 247
    //   235: astore_3
    //   236: aload_2
    //   237: astore_0
    //   238: aload_3
    //   239: astore_2
    //   240: goto +123 -> 363
    //   243: astore_3
    //   244: goto +30 -> 274
    //   247: aload_3
    //   248: ifnull +40 -> 288
    //   251: aload_3
    //   252: invokevirtual 540	java/io/FileInputStream:close	()V
    //   255: goto +33 -> 288
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   263: goto +25 -> 288
    //   266: astore_2
    //   267: goto +96 -> 363
    //   270: astore_3
    //   271: aload 4
    //   273: astore_2
    //   274: aload_2
    //   275: astore_0
    //   276: aload_3
    //   277: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   280: aload_2
    //   281: ifnull +7 -> 288
    //   284: aload_2
    //   285: invokevirtual 540	java/io/FileInputStream:close	()V
    //   288: aload 6
    //   290: ldc_w 691
    //   293: invokevirtual 411	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   296: astore_0
    //   297: aload_0
    //   298: ifnull +63 -> 361
    //   301: aload_0
    //   302: invokevirtual 694	java/lang/String:trim	()Ljava/lang/String;
    //   305: invokevirtual 414	java/lang/String:length	()I
    //   308: ifle +53 -> 361
    //   311: aload_0
    //   312: invokestatic 697	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   315: invokevirtual 358	java/lang/Integer:intValue	()I
    //   318: istore_1
    //   319: iload_1
    //   320: ireturn
    //   321: astore_2
    //   322: invokestatic 160	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +36 -> 361
    //   328: new 137	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   335: astore_3
    //   336: aload_3
    //   337: ldc_w 699
    //   340: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_3
    //   345: aload_0
    //   346: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: ldc 39
    //   352: iconst_2
    //   353: aload_3
    //   354: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: aload_2
    //   358: invokestatic 701	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   361: iconst_m1
    //   362: ireturn
    //   363: aload_0
    //   364: ifnull +15 -> 379
    //   367: aload_0
    //   368: invokevirtual 540	java/io/FileInputStream:close	()V
    //   371: goto +8 -> 379
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual 541	java/io/IOException:printStackTrace	()V
    //   379: aload_2
    //   380: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	381	0	paramContext	Context
    //   318	2	1	i	int
    //   42	198	2	localObject1	Object
    //   266	1	2	localObject2	Object
    //   273	12	2	localObject3	Object
    //   321	59	2	localThrowable	Throwable
    //   61	171	3	localObject4	Object
    //   235	4	3	localObject5	Object
    //   243	9	3	localException1	Exception
    //   270	7	3	localException2	Exception
    //   335	19	3	localStringBuilder	StringBuilder
    //   194	78	4	localObject6	Object
    //   191	18	5	localObject7	Object
    //   188	101	6	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   220	230	235	finally
    //   220	230	243	java/lang/Exception
    //   251	255	258	java/io/IOException
    //   284	288	258	java/io/IOException
    //   201	208	266	finally
    //   211	220	266	finally
    //   276	280	266	finally
    //   201	208	270	java/lang/Exception
    //   211	220	270	java/lang/Exception
    //   301	319	321	java/lang/Throwable
    //   367	371	374	java/io/IOException
  }
  
  public static int getSendBatteryStatus(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt2 == 1) {
      i = paramInt1 | 0x80;
    } else {
      i = paramInt1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MSF.C.PushManager:PushCoder", 2, new Object[] { "ret:", Integer.valueOf(i), " batteryCapacity:", Integer.valueOf(paramInt1), " powerConectStatus:", Integer.valueOf(paramInt2) });
    }
    return i;
  }
  
  /* Error */
  public static String getServerConfig(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: ldc 39
    //   2: iconst_1
    //   3: bipush 6
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 715
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_0
    //   17: aastore
    //   18: dup
    //   19: iconst_2
    //   20: ldc_w 717
    //   23: aastore
    //   24: dup
    //   25: iconst_3
    //   26: iload_1
    //   27: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_4
    //   33: ldc_w 719
    //   36: aastore
    //   37: dup
    //   38: iconst_5
    //   39: aload_2
    //   40: aastore
    //   41: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   44: aload_0
    //   45: iload_1
    //   46: aload_2
    //   47: invokestatic 723	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;ILjava/lang/String;)Ljava/io/File;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +132 -> 184
    //   55: aload_2
    //   56: invokevirtual 125	java/io/File:exists	()Z
    //   59: ifne +6 -> 65
    //   62: goto +122 -> 184
    //   65: new 137	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   72: astore 4
    //   74: aconst_null
    //   75: astore_3
    //   76: aconst_null
    //   77: astore_0
    //   78: new 725	java/io/InputStreamReader
    //   81: dup
    //   82: new 506	java/io/FileInputStream
    //   85: dup
    //   86: aload_2
    //   87: invokespecial 509	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   90: ldc_w 727
    //   93: invokespecial 730	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   96: astore_2
    //   97: sipush 4096
    //   100: newarray char
    //   102: astore_0
    //   103: aload_2
    //   104: aload_0
    //   105: invokevirtual 731	java/io/InputStreamReader:read	([C)I
    //   108: istore_1
    //   109: iconst_m1
    //   110: iload_1
    //   111: if_icmpeq +15 -> 126
    //   114: aload 4
    //   116: aload_0
    //   117: iconst_0
    //   118: iload_1
    //   119: invokevirtual 734	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: goto -20 -> 103
    //   126: aload_2
    //   127: invokevirtual 735	java/io/InputStreamReader:close	()V
    //   130: goto +38 -> 168
    //   133: astore_3
    //   134: aload_2
    //   135: astore_0
    //   136: aload_3
    //   137: astore_2
    //   138: goto +36 -> 174
    //   141: astore_3
    //   142: goto +12 -> 154
    //   145: astore_2
    //   146: goto +28 -> 174
    //   149: astore_0
    //   150: aload_3
    //   151: astore_2
    //   152: aload_0
    //   153: astore_3
    //   154: aload_2
    //   155: astore_0
    //   156: aload_3
    //   157: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 735	java/io/InputStreamReader:close	()V
    //   168: aload 4
    //   170: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: areturn
    //   174: aload_0
    //   175: ifnull +7 -> 182
    //   178: aload_0
    //   179: invokevirtual 735	java/io/InputStreamReader:close	()V
    //   182: aload_2
    //   183: athrow
    //   184: ldc_w 383
    //   187: areturn
    //   188: astore_0
    //   189: goto -21 -> 168
    //   192: astore_0
    //   193: goto -11 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramString1	String
    //   0	196	1	paramInt	int
    //   0	196	2	paramString2	String
    //   75	1	3	localObject1	Object
    //   133	4	3	localObject2	Object
    //   141	10	3	localException	Exception
    //   153	4	3	str	String
    //   72	97	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   97	103	133	finally
    //   103	109	133	finally
    //   114	123	133	finally
    //   97	103	141	java/lang/Exception
    //   103	109	141	java/lang/Exception
    //   114	123	141	java/lang/Exception
    //   78	97	145	finally
    //   156	160	145	finally
    //   78	97	149	java/lang/Exception
    //   126	130	188	java/io/IOException
    //   164	168	188	java/io/IOException
    //   178	182	192	java/io/IOException
  }
  
  public static File getServerConfigFile(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = null;
    if (paramString1 == null) {
      return null;
    }
    String str = paramString1.replaceAll(":", "_");
    try
    {
      paramString1 = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    }
    catch (Exception paramString1)
    {
      label32:
      break label32;
    }
    paramString1 = "/data/data/com.tencent.mobileqq/files";
    if (paramInt == 0)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("/");
      paramString2.append(str);
      paramString2.append("_common");
      return new File(paramString2.toString());
    }
    if (paramInt == 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/");
      localStringBuilder.append(str);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2.hashCode());
      localStringBuilder.append("_user");
      return new File(localStringBuilder.toString());
    }
    paramString2 = localStringBuilder;
    if (paramInt == 2)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("/");
      paramString2.append(str);
      paramString2.append("_app");
      paramString2 = new File(paramString2.toString());
    }
    return paramString2;
  }
  
  public static String getShortHexKey(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[0]));
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[1]));
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[2]));
      localStringBuilder.append(Integer.toHexString(paramArrayOfByte[3]));
      return localStringBuilder.toString();
    }
    return "*";
  }
  
  public static String getShortKey(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 4) {
        return "*";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MD5.toMD5(new String(paramArrayOfByte)).substring(0, 4));
      localStringBuilder.append("*");
      return localStringBuilder.toString();
    }
    return "*";
  }
  
  public static String getShortStringKey(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4)) {
      return new String(paramArrayOfByte, 0, 4);
    }
    return "*";
  }
  
  public static String getShortUin(String paramString)
  {
    Object localObject = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() < 4) {
        return paramString;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("*");
      ((StringBuilder)localObject).append(paramString.substring(paramString.length() - 4, paramString.length()));
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String getStackTraceString(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      if ((localObject instanceof UnknownHostException)) {
        return "";
      }
    }
    localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return ((StringWriter)localObject).toString();
  }
  
  public static int getThreadCounts(String paramString)
  {
    int j = 0;
    int i = 0;
    try
    {
      Iterator localIterator = Thread.getAllStackTraces().keySet().iterator();
      int k;
      for (;;)
      {
        j = i;
        k = i;
        if (!localIterator.hasNext()) {
          break;
        }
        j = i;
        boolean bool = paramString.equals(((Thread)localIterator.next()).getName());
        if (bool) {
          i += 1;
        }
      }
      return k;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      k = j;
    }
  }
  
  /* Error */
  public static String getThreadStackString(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: invokestatic 806	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   9: astore 6
    //   11: aload 6
    //   13: invokeinterface 809 1 0
    //   18: invokeinterface 523 1 0
    //   23: astore 7
    //   25: aload 4
    //   27: astore_3
    //   28: aload 7
    //   30: invokeinterface 528 1 0
    //   35: ifeq +105 -> 140
    //   38: aload 7
    //   40: invokeinterface 532 1 0
    //   45: checkcast 367	java/lang/Thread
    //   48: astore_3
    //   49: aload_0
    //   50: aload_3
    //   51: invokevirtual 812	java/lang/Thread:getName	()Ljava/lang/String;
    //   54: invokevirtual 246	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq -32 -> 25
    //   60: new 137	java/lang/StringBuilder
    //   63: dup
    //   64: sipush 1024
    //   67: invokespecial 376	java/lang/StringBuilder:<init>	(I)V
    //   70: astore_0
    //   71: aload 6
    //   73: aload_3
    //   74: invokeinterface 817 2 0
    //   79: checkcast 819	[Ljava/lang/StackTraceElement;
    //   82: astore 4
    //   84: aload 4
    //   86: arraylength
    //   87: istore_2
    //   88: iconst_0
    //   89: istore_1
    //   90: aload_0
    //   91: astore_3
    //   92: iload_1
    //   93: iload_2
    //   94: if_icmpge +46 -> 140
    //   97: aload_0
    //   98: aload 4
    //   100: iload_1
    //   101: aaload
    //   102: invokevirtual 379	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   105: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_0
    //   110: ldc 164
    //   112: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: iload_1
    //   117: iconst_1
    //   118: iadd
    //   119: istore_1
    //   120: goto -30 -> 90
    //   123: astore 4
    //   125: aload_0
    //   126: astore_3
    //   127: goto +8 -> 135
    //   130: astore 4
    //   132: aload 5
    //   134: astore_3
    //   135: aload 4
    //   137: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   140: aload_3
    //   141: ifnonnull +7 -> 148
    //   144: ldc_w 383
    //   147: areturn
    //   148: aload_3
    //   149: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramString	String
    //   89	31	1	i	int
    //   87	8	2	j	int
    //   27	122	3	localObject1	Object
    //   1	98	4	arrayOfStackTraceElement	StackTraceElement[]
    //   123	1	4	localException1	Exception
    //   130	6	4	localException2	Exception
    //   4	129	5	localObject2	Object
    //   9	63	6	localMap	Map
    //   23	16	7	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   71	88	123	java/lang/Exception
    //   97	116	123	java/lang/Exception
    //   6	25	130	java/lang/Exception
    //   28	71	130	java/lang/Exception
  }
  
  public static String getTotalMemory()
  {
    String str2 = "";
    Object localObject = str2;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
      localObject = str2;
      String str3 = localBufferedReader.readLine();
      String str1 = str2;
      if (str3 != null)
      {
        localObject = str2;
        str1 = str3.trim();
      }
      localObject = str1;
      localBufferedReader.close();
      return str1;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localObject;
  }
  
  public static String insertMtype(String paramString1, String paramString2)
  {
    if (paramString2.contains("mType=")) {
      return paramString2;
    }
    Object localObject = paramString2;
    if (paramString1 != null)
    {
      int i = paramString2.indexOf("?");
      if (i > 0)
      {
        int j = paramString2.length();
        int k = i + 1;
        if (j == k)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString2.substring(0, k));
          ((StringBuilder)localObject).append("mType=");
          ((StringBuilder)localObject).append(paramString1);
          return ((StringBuilder)localObject).toString();
        }
        i = paramString2.indexOf("#", i);
        if (i > -1)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString2.substring(0, i));
          ((StringBuilder)localObject).append("&mType=");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(paramString2.substring(i));
          paramString1 = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append("&mType=");
          ((StringBuilder)localObject).append(paramString1);
          paramString1 = ((StringBuilder)localObject).toString();
        }
        return paramString1;
      }
      localObject = paramString2;
      if (paramString2.length() > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append("?mType=");
        ((StringBuilder)localObject).append(paramString1);
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  private static boolean isAccountFileExist(File paramFile, String paramString)
  {
    paramFile = paramFile.list();
    if ((paramFile != null) && (paramFile.length > 0))
    {
      int i = 0;
      while (i < paramFile.length)
      {
        if (paramFile[i] != null)
        {
          Object localObject = paramFile[i];
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("u_");
          localStringBuilder.append(paramString);
          localStringBuilder.append("_f");
          if (!localObject.equals(localStringBuilder.toString()))
          {
            localObject = paramFile[i];
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("u_");
            localStringBuilder.append(paramString);
            localStringBuilder.append("_t");
            if (!localObject.equals(localStringBuilder.toString())) {}
          }
          else
          {
            return true;
          }
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static boolean isBatteryOnlineStatus(PushRegisterInfo paramPushRegisterInfo)
  {
    boolean bool;
    if ((paramPushRegisterInfo != null) && (paramPushRegisterInfo.extStatus == 1000L)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      if (paramPushRegisterInfo == null) {
        paramPushRegisterInfo = "null";
      } else {
        paramPushRegisterInfo = Long.valueOf(paramPushRegisterInfo.extStatus);
      }
      QLog.d("MSF.C.PushManager:PushCoder", 1, new Object[] { "isBatteryOnlineStatus extStatus:", paramPushRegisterInfo });
    }
    return bool;
  }
  
  public static boolean isBuildTestEnvValid()
  {
    return false;
  }
  
  public static boolean isExistMsfProcess(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext()) {
          if (((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName.equals("com.tencent.mobileqq:MSF")) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public static boolean isProcessExist(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        paramContext = paramContext.getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext()) {
            if (TextUtils.equals(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName, paramString)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  public static boolean isScreenOn(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = (PowerManager)paramContext.getSystemService("power");
      boolean bool = ((Boolean)paramContext.getClass().getMethod("isScreenOn", new Class[0]).invoke(paramContext, (Object[])null)).booleanValue();
      return bool;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("e = ");
      localStringBuilder.append(paramContext.toString());
      QLog.d("MsfSdkUtils", 1, localStringBuilder.toString());
    }
    return true;
  }
  
  public static boolean isTopActivity(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      String str = paramContext.getPackageName();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        boolean bool = ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getPackageName().equals(str);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private static boolean isUinLong(String paramString)
  {
    try
    {
      Long.parseLong(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private static boolean isValidBusId(String paramString)
  {
    String[] arrayOfString = s_validBusId;
    int j = arrayOfString.length;
    int i = 0;
    boolean bool = false;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramString)) {
        bool = true;
      }
      i += 1;
    }
    return bool;
  }
  
  public static boolean killProcess(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (paramString == null) {
        return false;
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.processName.equals(paramString))
        {
          Process.killProcess(localRunningAppProcessInfo.pid);
          return true;
        }
      }
    }
    return false;
  }
  
  /* Error */
  public static Properties loadConfig(String paramString)
  {
    // Byte code:
    //   0: new 408	java/util/Properties
    //   3: dup
    //   4: invokespecial 504	java/util/Properties:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aload_1
    //   13: areturn
    //   14: aconst_null
    //   15: astore_2
    //   16: new 506	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 923	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_1
    //   26: aload_0
    //   27: invokevirtual 513	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   30: aload_0
    //   31: invokevirtual 540	java/io/FileInputStream:close	()V
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: goto +6 -> 43
    //   40: astore_1
    //   41: aload_2
    //   42: astore_0
    //   43: aload_0
    //   44: ifnull +7 -> 51
    //   47: aload_0
    //   48: invokevirtual 540	java/io/FileInputStream:close	()V
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	paramString	String
    //   7	28	1	localProperties	Properties
    //   36	1	1	localObject1	Object
    //   40	12	1	localObject2	Object
    //   15	27	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   25	30	36	finally
    //   16	25	40	finally
  }
  
  /* Error */
  public static void saveConfig(String paramString, Properties paramProperties)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +50 -> 51
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aconst_null
    //   10: astore_2
    //   11: new 927	java/io/FileOutputStream
    //   14: dup
    //   15: aload_0
    //   16: iconst_0
    //   17: invokespecial 929	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   20: astore_0
    //   21: aload_1
    //   22: aload_0
    //   23: ldc_w 383
    //   26: invokevirtual 933	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   29: aload_0
    //   30: invokevirtual 934	java/io/FileOutputStream:close	()V
    //   33: return
    //   34: astore_1
    //   35: goto +6 -> 41
    //   38: astore_1
    //   39: aload_2
    //   40: astore_0
    //   41: aload_0
    //   42: ifnull +7 -> 49
    //   45: aload_0
    //   46: invokevirtual 934	java/io/FileOutputStream:close	()V
    //   49: aload_1
    //   50: athrow
    //   51: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramString	String
    //   0	52	1	paramProperties	Properties
    //   10	30	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	29	34	finally
    //   11	21	38	finally
  }
  
  public static void updateSimpleAccount(String paramString, boolean paramBoolean)
  {
    try
    {
      localObject2 = getNewAppUinStoreFile();
      if (!((File)localObject2).exists()) {
        break label493;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((File)localObject2).getAbsolutePath());
      ((StringBuilder)localObject3).append("/u_");
      ((StringBuilder)localObject3).append(paramString);
      if (!paramBoolean) {
        break label509;
      }
      localObject1 = "_t";
    }
    finally
    {
      for (;;)
      {
        Object localObject2;
        Object localObject3;
        Object localObject1;
        int j;
        int i;
        String str2;
        StringBuilder localStringBuilder;
        for (;;)
        {
          label493:
          throw paramString;
        }
        label509:
        String str1 = "_f";
        continue;
        label516:
        i += 1;
      }
    }
    ((StringBuilder)localObject3).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject3).toString();
    localObject3 = new File((String)localObject1);
    if (((File)localObject3).exists())
    {
      ((File)localObject3).delete();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("found want update user exists,del ");
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append(" ");
        ((StringBuilder)localObject3).append(paramBoolean);
        QLog.d("MsfSdkUtils", 2, ((StringBuilder)localObject3).toString());
      }
    }
    localObject2 = ((File)localObject2).listFiles();
    if (localObject2 != null)
    {
      j = localObject2.length;
      i = 0;
      if (i < j)
      {
        localObject3 = localObject2[i];
        str2 = ((File)localObject3).getName();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("u_");
        localStringBuilder.append(paramString);
        localStringBuilder.append("_t");
        if (!str2.equals(localStringBuilder.toString()))
        {
          str2 = ((File)localObject3).getName();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("u_");
          localStringBuilder.append(paramString);
          localStringBuilder.append("_f");
          if (!str2.equals(localStringBuilder.toString())) {
            break label516;
          }
        }
        ((File)localObject3).renameTo(new File((String)localObject1));
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("update user succ ");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(paramBoolean);
          QLog.d("MsfSdkUtils", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
    }
    localObject1 = new File((String)localObject1);
    try
    {
      ((File)localObject1).createNewFile();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("update add user succ ");
        ((StringBuilder)localObject1).append(MD5.toMD5(paramString));
        QLog.d("MsfSdkUtils", 2, ((StringBuilder)localObject1).toString());
      }
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("update add user failed ");
      ((StringBuilder)localObject2).append(MD5.toMD5(paramString));
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(localException);
      QLog.d("MsfSdkUtils", 1, ((StringBuilder)localObject2).toString());
    }
  }
  
  public static void updateSimpleAccountNotCreate(String paramString, boolean paramBoolean)
  {
    try
    {
      localObject = getNewAppUinStoreFile();
      if (!((File)localObject).exists()) {
        break label242;
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(((File)localObject).getAbsolutePath());
      localStringBuilder1.append("/u_");
      localStringBuilder1.append(paramString);
      if (!paramBoolean) {
        break label258;
      }
      str1 = "_t";
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        StringBuilder localStringBuilder1;
        int j;
        int i;
        String str2;
        StringBuilder localStringBuilder2;
        for (;;)
        {
          label242:
          throw paramString;
        }
        label258:
        String str1 = "_f";
        continue;
        label265:
        i += 1;
      }
    }
    localStringBuilder1.append(str1);
    str1 = localStringBuilder1.toString();
    new File(str1);
    localObject = ((File)localObject).listFiles();
    if (localObject != null)
    {
      j = localObject.length;
      i = 0;
      if (i < j)
      {
        localStringBuilder1 = localObject[i];
        str2 = localStringBuilder1.getName();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("u_");
        localStringBuilder2.append(paramString);
        localStringBuilder2.append("_t");
        if (!str2.equals(localStringBuilder2.toString()))
        {
          str2 = localStringBuilder1.getName();
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append("u_");
          localStringBuilder2.append(paramString);
          localStringBuilder2.append("_f");
          if (!str2.equals(localStringBuilder2.toString())) {
            break label265;
          }
        }
        localStringBuilder1.renameTo(new File(str1));
        return;
      }
    }
  }
  
  /* Error */
  public static void writeServerConfig(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 39
    //   2: iconst_1
    //   3: bipush 6
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 956
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_0
    //   17: aastore
    //   18: dup
    //   19: iconst_2
    //   20: ldc_w 717
    //   23: aastore
    //   24: dup
    //   25: iconst_3
    //   26: iload_1
    //   27: invokestatic 341	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_4
    //   33: ldc_w 719
    //   36: aastore
    //   37: dup
    //   38: iconst_5
    //   39: aload_3
    //   40: aastore
    //   41: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   44: aload_0
    //   45: iload_1
    //   46: aload_3
    //   47: invokestatic 723	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;ILjava/lang/String;)Ljava/io/File;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +151 -> 203
    //   55: aload_3
    //   56: invokevirtual 125	java/io/File:exists	()Z
    //   59: ifne +8 -> 67
    //   62: aload_3
    //   63: invokevirtual 157	java/io/File:createNewFile	()Z
    //   66: pop
    //   67: aload_3
    //   68: invokevirtual 125	java/io/File:exists	()Z
    //   71: ifeq +95 -> 166
    //   74: aload_3
    //   75: invokevirtual 959	java/io/File:canWrite	()Z
    //   78: ifeq +88 -> 166
    //   81: aconst_null
    //   82: astore 4
    //   84: aconst_null
    //   85: astore_0
    //   86: new 961	java/io/OutputStreamWriter
    //   89: dup
    //   90: new 927	java/io/FileOutputStream
    //   93: dup
    //   94: aload_3
    //   95: invokespecial 962	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   98: ldc_w 727
    //   101: invokespecial 964	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   104: astore_3
    //   105: aload_3
    //   106: aload_2
    //   107: invokevirtual 967	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   110: aload_3
    //   111: invokevirtual 968	java/io/OutputStreamWriter:flush	()V
    //   114: aload_3
    //   115: invokevirtual 969	java/io/OutputStreamWriter:close	()V
    //   118: return
    //   119: astore_2
    //   120: aload_3
    //   121: astore_0
    //   122: goto +34 -> 156
    //   125: astore_0
    //   126: aload_3
    //   127: astore_2
    //   128: aload_0
    //   129: astore_3
    //   130: goto +11 -> 141
    //   133: astore_2
    //   134: goto +22 -> 156
    //   137: astore_3
    //   138: aload 4
    //   140: astore_2
    //   141: aload_2
    //   142: astore_0
    //   143: aload_3
    //   144: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   147: aload_2
    //   148: ifnull +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 969	java/io/OutputStreamWriter:close	()V
    //   155: return
    //   156: aload_0
    //   157: ifnull +7 -> 164
    //   160: aload_0
    //   161: invokevirtual 969	java/io/OutputStreamWriter:close	()V
    //   164: aload_2
    //   165: athrow
    //   166: new 137	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   173: astore_0
    //   174: aload_0
    //   175: ldc_w 971
    //   178: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_0
    //   183: aload_3
    //   184: invokevirtual 142	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   187: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: new 503	java/io/IOException
    //   194: dup
    //   195: aload_0
    //   196: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokespecial 972	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   202: athrow
    //   203: new 503	java/io/IOException
    //   206: dup
    //   207: ldc_w 974
    //   210: invokespecial 972	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   213: athrow
    //   214: astore_0
    //   215: return
    //   216: astore_0
    //   217: goto -53 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramString1	String
    //   0	220	1	paramInt	int
    //   0	220	2	paramString2	String
    //   0	220	3	paramString3	String
    //   82	57	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   105	114	119	finally
    //   105	114	125	java/lang/Exception
    //   86	105	133	finally
    //   143	147	133	finally
    //   86	105	137	java/lang/Exception
    //   114	118	214	java/io/IOException
    //   151	155	214	java/io/IOException
    //   160	164	216	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfSdkUtils
 * JD-Core Version:    0.7.0.1
 */