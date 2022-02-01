package com.tencent.mobileqq.msf.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AppOpsManager;
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
        Object localObject = getNewAppUinStoreFile();
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        if (((File)localObject).exists())
        {
          if (isAccountFileExist((File)localObject, paramString)) {
            updateSimpleAccountNotCreate(paramString, true);
          }
        }
        else {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder().append(((File)localObject).getAbsolutePath()).append("/u_").append(paramString);
        if (paramBoolean)
        {
          localObject = "_t";
          localObject = new File((String)localObject);
          try
          {
            ((File)localObject).createNewFile();
          }
          catch (Exception localException) {}
          if (QLog.isColorLevel()) {
            QLog.d("MsfSdkUtils", 2, "add user failed " + paramString + " " + localException);
          }
        }
        else
        {
          String str = "_f";
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public static void addSimpleAccount(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 99	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getNewAppUinStoreFile	()Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 105	java/io/File:exists	()Z
    //   11: ifne +8 -> 19
    //   14: aload_2
    //   15: invokevirtual 108	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: aload_2
    //   20: invokevirtual 105	java/io/File:exists	()Z
    //   23: ifeq +13 -> 36
    //   26: aload_2
    //   27: aload_0
    //   28: invokestatic 112	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:isAccountFileExist	(Ljava/io/File;Ljava/lang/String;)Z
    //   31: istore_1
    //   32: iload_1
    //   33: ifeq +7 -> 40
    //   36: ldc 2
    //   38: monitorexit
    //   39: return
    //   40: new 101	java/io/File
    //   43: dup
    //   44: new 117	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 122	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   55: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 128
    //   60: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 155
    //   69: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 137	java/io/File:createNewFile	()Z
    //   83: pop
    //   84: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq -51 -> 36
    //   90: ldc 39
    //   92: iconst_2
    //   93: new 117	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   100: ldc 158
    //   102: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: goto -79 -> 36
    //   118: astore_2
    //   119: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq -86 -> 36
    //   125: ldc 39
    //   127: iconst_2
    //   128: new 117	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   135: ldc 144
    //   137: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 146
    //   146: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_2
    //   150: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: goto -123 -> 36
    //   162: astore_0
    //   163: ldc 2
    //   165: monitorexit
    //   166: aload_0
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString	String
    //   31	2	1	bool	boolean
    //   6	74	2	localFile	File
    //   118	32	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   79	115	118	java/lang/Exception
    //   3	19	162	finally
    //   19	32	162	finally
    //   40	79	162	finally
    //   79	115	162	finally
    //   119	159	162	finally
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
    }
    for (;;)
    {
      if (paramObject != null) {
        paramString1.addAttribute(paramString2, paramObject);
      }
      paramString1.setRequestSsoSeq(paramInt3);
      return paramString1;
      paramString1.setMsgSuccess();
    }
  }
  
  public static int convertBytes2Int(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] << 24 & 0xFF000000 | paramArrayOfByte[1] << 16 & 0xFF0000 | paramArrayOfByte[2] << 8 & 0xFF00 | paramArrayOfByte[3] << 0 & 0xFF;
  }
  
  public static int convertBytes2Int(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 0)] << 24 & 0xFF000000 | paramArrayOfByte[(paramInt + 1)] << 16 & 0xFF0000 | paramArrayOfByte[(paramInt + 2)] << 8 & 0xFF00 | paramArrayOfByte[(paramInt + 3)] << 0 & 0xFF;
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
          String str = arrayOfString[i];
          if ((str.equals("u_" + paramString + "_f")) || (str.equals("u_" + paramString + "_t")))
          {
            new File(localFile.getPath(), str).delete();
            if (QLog.isColorLevel()) {
              QLog.d("MsfSdkUtils", 2, "del user succ " + paramString);
            }
          }
          i += 1;
        }
      }
      return;
    }
    finally {}
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
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject = new File((String)localObject + "/simpleback.user");
          return localObject;
        }
        catch (Exception localException2)
        {
          String str;
          localException2.printStackTrace();
        }
        localException1 = localException1;
        str = "/data/data/com.tencent.mobileqq/files";
      }
    }
    return null;
  }
  
  public static File getAppUinStoreFile()
  {
    try
    {
      localObject = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject = new File((String)localObject + "/simple.user");
          return localObject;
        }
        catch (Exception localException2)
        {
          String str;
          localException2.printStackTrace();
        }
        localException1 = localException1;
        str = "/data/data/com.tencent.mobileqq/files";
      }
    }
    return null;
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
        localStringBuilder.append(arrayOfStackTraceElement[i].toString()).append("#");
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
    Object localObject2 = "";
    Object localObject1;
    if (!isValidBusId(paramString))
    {
      localObject1 = "";
      return localObject1;
    }
    paramString = (String)localObject2;
    for (;;)
    {
      for (;;)
      {
        try
        {
          localTelephonyManager = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
          localObject1 = localObject2;
          paramString = (String)localObject2;
          if (new File(MsfCore.getIMEIPath()).exists())
          {
            paramString = (String)localObject2;
            localObject1 = loadConfig(MsfCore.getIMEIPath()).getProperty("imei");
            if (localObject1 != null)
            {
              localObject2 = localObject1;
              paramString = (String)localObject1;
              if (((String)localObject1).length() != 0) {}
            }
            else
            {
              paramString = (String)localObject1;
              Thread.sleep(200L);
              paramString = (String)localObject1;
              localObject2 = loadConfig(MsfCore.getIMEIPath()).getProperty("imei", null);
            }
            localObject1 = localObject2;
            paramString = (String)localObject2;
            if (QLog.isColorLevel())
            {
              paramString = (String)localObject2;
              QLog.d("MsfSdkUtils", 2, "read imei from file " + MsfCore.getIMEIPath() + ", imei:" + (String)localObject2 + ",with order:" + 1);
              localObject1 = localObject2;
            }
          }
          if (localObject1 == null) {}
        }
        catch (Exception localException1)
        {
          TelephonyManager localTelephonyManager;
          int i;
          int j;
          QLog.d("MsfSdkUtils", 1, "read sys imei error " + localException1, localException1);
          continue;
        }
        try
        {
          i = ((String)localObject1).length();
          if ((i != 0) || (localTelephonyManager == null)) {
            continue;
          }
        }
        catch (Exception localException3)
        {
          paramString = localException1;
          Exception localException2 = localException3;
          continue;
          Object localObject3 = null;
          continue;
        }
        try
        {
          localObject2 = localTelephonyManager.getDeviceId();
          if (localObject2 == null) {
            continue;
          }
          i = ((String)localObject2).length();
          if (i <= 0) {
            continue;
          }
          j = 3;
          i = j;
          localObject1 = localObject2;
          paramString = (String)localObject2;
          if (QLog.isColorLevel())
          {
            paramString = (String)localObject2;
            QLog.d("MsfSdkUtils", 2, "read sys imei:" + (String)localObject2);
            localObject1 = localObject2;
            i = j;
          }
          paramString = (String)localObject1;
          if (QLog.isColorLevel())
          {
            paramString = (String)localObject1;
            QLog.d("MsfSdkUtils", 1, "save imei:" + (String)localObject1 + ",with order:" + i);
          }
          paramString = (String)localObject1;
          localObject1 = paramString;
          if (paramString != null) {
            break;
          }
          return "";
        }
        catch (SecurityException paramString)
        {
          if (!QLog.isColorLevel()) {
            break label433;
          }
        }
      }
      QLog.d("MsfSdkUtils", 2, "read sys imei SecurityException=", paramString);
      break label433;
      i = 4;
      if (QLog.isColorLevel()) {
        QLog.d("MsfSdkUtils", 2, "load imei:" + (String)localObject1);
      }
      continue;
      i = 1;
    }
  }
  
  public static ArrayList getLoginedAccountList()
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        Object localObject1 = getNewAppUinStoreFile();
        if ((localObject1 != null) && (((File)localObject1).exists()))
        {
          String[] arrayOfString = ((File)localObject1).list();
          localArrayList = new ArrayList();
          if (arrayOfString == null)
          {
            localObject1 = localArrayList;
            return localObject1;
          }
          int j = arrayOfString.length;
          i = 0;
          localObject1 = localArrayList;
          if (i >= j) {
            continue;
          }
          localObject1 = arrayOfString[i];
          try
          {
            if (!((String)localObject1).startsWith("u_")) {
              break label341;
            }
            String str = ((String)localObject1).substring(2, ((String)localObject1).length() - 2);
            boolean bool = ((String)localObject1).endsWith("_t");
            SimpleAccount localSimpleAccount = new SimpleAccount();
            localSimpleAccount.setUin(str);
            localSimpleAccount.setAttribute("_isLogined", String.valueOf(bool));
            if (isUinLong(str)) {
              localArrayList.add(localSimpleAccount);
            } else {
              QLog.d("MsfSdkUtils", 1, "found invalid uin: " + str);
            }
          }
          catch (Exception localException)
          {
            if (!QLog.isColorLevel()) {
              break label341;
            }
          }
          QLog.d("MsfSdkUtils", 2, "parse user failed " + localException + " " + (String)localObject1);
        }
      }
      finally {}
      Object localObject3 = getLoginedAccountList(getAppUinStoreFile());
      if ((localObject3 == null) || (((ArrayList)localObject3).size() == 0))
      {
        localArrayList = getLoginedAccountList(getAppUinBackStoreFile());
        localObject3 = localArrayList;
        if (localArrayList != null)
        {
          localObject3 = localArrayList;
          if (QLog.isColorLevel())
          {
            QLog.d("MsfSdkUtils", 2, "load accountList " + localArrayList.size() + " from backFile");
            localObject3 = localArrayList;
          }
        }
      }
      else
      {
        QLog.d("MsfSdkUtils", 1, "load accountList " + ((ArrayList)localObject3).size());
        continue;
        label341:
        i += 1;
      }
    }
  }
  
  /* Error */
  public static ArrayList getLoginedAccountList(File paramFile)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 432	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 433	java/util/ArrayList:<init>	()V
    //   10: astore 4
    //   12: aload_0
    //   13: ifnull +12 -> 25
    //   16: aload_0
    //   17: invokevirtual 105	java/io/File:exists	()Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifne +9 -> 31
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload 4
    //   30: areturn
    //   31: new 391	java/util/Properties
    //   34: dup
    //   35: invokespecial 484	java/util/Properties:<init>	()V
    //   38: astore_3
    //   39: new 486	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 489	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_2
    //   48: aload_2
    //   49: astore_0
    //   50: aload_3
    //   51: aload_2
    //   52: invokevirtual 493	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   55: aload_2
    //   56: astore_0
    //   57: aload_3
    //   58: invokevirtual 497	java/util/Properties:keySet	()Ljava/util/Set;
    //   61: invokeinterface 503 1 0
    //   66: astore 5
    //   68: aload_2
    //   69: astore_0
    //   70: aload 5
    //   72: invokeinterface 508 1 0
    //   77: ifeq +159 -> 236
    //   80: aload_2
    //   81: astore_0
    //   82: aload 5
    //   84: invokeinterface 512 1 0
    //   89: checkcast 71	java/lang/String
    //   92: astore 6
    //   94: aload_2
    //   95: astore_0
    //   96: aload_3
    //   97: aload 6
    //   99: invokevirtual 394	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 7
    //   104: aload 7
    //   106: ifnull -38 -> 68
    //   109: aload_2
    //   110: astore_0
    //   111: aload 7
    //   113: invokestatic 516	com/tencent/qphone/base/remote/SimpleAccount:parseSimpleAccount	(Ljava/lang/String;)Lcom/tencent/qphone/base/remote/SimpleAccount;
    //   116: astore 7
    //   118: aload 7
    //   120: ifnull -52 -> 68
    //   123: aload_2
    //   124: astore_0
    //   125: aload 7
    //   127: invokevirtual 517	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   130: invokestatic 460	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:isUinLong	(Ljava/lang/String;)Z
    //   133: ifeq +34 -> 167
    //   136: aload_2
    //   137: astore_0
    //   138: aload 4
    //   140: aload 7
    //   142: invokevirtual 463	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   145: pop
    //   146: goto -78 -> 68
    //   149: astore_3
    //   150: aload_2
    //   151: astore_0
    //   152: aload_3
    //   153: invokevirtual 259	java/lang/Exception:printStackTrace	()V
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 520	java/io/FileInputStream:close	()V
    //   164: goto -139 -> 25
    //   167: aload_2
    //   168: astore_0
    //   169: ldc 39
    //   171: iconst_1
    //   172: new 117	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 465
    //   182: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 6
    //   187: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: goto -128 -> 68
    //   199: astore_3
    //   200: aload_0
    //   201: astore_2
    //   202: aload_3
    //   203: astore_0
    //   204: aload_2
    //   205: ifnull +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 520	java/io/FileInputStream:close	()V
    //   212: aload_0
    //   213: athrow
    //   214: astore_0
    //   215: ldc 2
    //   217: monitorexit
    //   218: aload_0
    //   219: athrow
    //   220: astore_2
    //   221: aload_2
    //   222: invokevirtual 521	java/io/IOException:printStackTrace	()V
    //   225: goto -13 -> 212
    //   228: astore_0
    //   229: aload_0
    //   230: invokevirtual 521	java/io/IOException:printStackTrace	()V
    //   233: goto -69 -> 164
    //   236: aload_2
    //   237: ifnull -73 -> 164
    //   240: aload_2
    //   241: invokevirtual 520	java/io/FileInputStream:close	()V
    //   244: goto -80 -> 164
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 521	java/io/IOException:printStackTrace	()V
    //   252: goto -88 -> 164
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_2
    //   258: goto -54 -> 204
    //   261: astore_3
    //   262: aconst_null
    //   263: astore_2
    //   264: goto -114 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	paramFile	File
    //   20	2	1	bool	boolean
    //   47	162	2	localObject1	Object
    //   220	21	2	localIOException	IOException
    //   257	7	2	localObject2	Object
    //   38	59	3	localProperties	Properties
    //   149	4	3	localException1	Exception
    //   199	4	3	localObject3	Object
    //   261	1	3	localException2	Exception
    //   10	129	4	localArrayList	ArrayList
    //   66	17	5	localIterator	Iterator
    //   92	94	6	str	String
    //   102	39	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   50	55	149	java/lang/Exception
    //   57	68	149	java/lang/Exception
    //   70	80	149	java/lang/Exception
    //   82	94	149	java/lang/Exception
    //   96	104	149	java/lang/Exception
    //   111	118	149	java/lang/Exception
    //   125	136	149	java/lang/Exception
    //   138	146	149	java/lang/Exception
    //   169	196	149	java/lang/Exception
    //   50	55	199	finally
    //   57	68	199	finally
    //   70	80	199	finally
    //   82	94	199	finally
    //   96	104	199	finally
    //   111	118	199	finally
    //   125	136	199	finally
    //   138	146	199	finally
    //   152	156	199	finally
    //   169	196	199	finally
    //   3	12	214	finally
    //   16	21	214	finally
    //   31	39	214	finally
    //   160	164	214	finally
    //   208	212	214	finally
    //   212	214	214	finally
    //   221	225	214	finally
    //   229	233	214	finally
    //   240	244	214	finally
    //   248	252	214	finally
    //   208	212	220	java/io/IOException
    //   160	164	228	java/io/IOException
    //   240	244	247	java/io/IOException
    //   39	48	255	finally
    //   39	48	261	java/lang/Exception
  }
  
  public static File getNewAppUinStoreFile()
  {
    try
    {
      str1 = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          String str1;
          File localFile = new File(str1 + "/user/");
          return localFile;
        }
        catch (Exception localException2)
        {
          String str2;
          if (!QLog.isColorLevel()) {
            break label89;
          }
          QLog.e("MsfSdkUtils", 2, "get user file error " + str2 + " " + localException2);
        }
        localException1 = localException1;
        str2 = "/data/data/com.tencent.mobileqq/files";
      }
    }
    label89:
    return null;
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
    //   0: iconst_0
    //   1: istore_1
    //   2: new 540	java/io/FileReader
    //   5: dup
    //   6: new 117	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   13: ldc_w 542
    //   16: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: iload_0
    //   20: invokevirtual 415	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   23: ldc_w 544
    //   26: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 545	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   35: astore 4
    //   37: aload 4
    //   39: astore_3
    //   40: sipush 512
    //   43: newarray char
    //   45: astore_2
    //   46: aload 4
    //   48: astore_3
    //   49: aload 4
    //   51: aload_2
    //   52: invokevirtual 549	java/io/FileReader:read	([C)I
    //   55: pop
    //   56: iload_1
    //   57: istore_0
    //   58: aload 4
    //   60: astore_3
    //   61: iload_0
    //   62: aload_2
    //   63: arraylength
    //   64: if_icmpge +9 -> 73
    //   67: aload_2
    //   68: iload_0
    //   69: caload
    //   70: ifne +38 -> 108
    //   73: aload 4
    //   75: astore_3
    //   76: new 71	java/lang/String
    //   79: dup
    //   80: aload_2
    //   81: invokespecial 552	java/lang/String:<init>	([C)V
    //   84: iconst_0
    //   85: iload_0
    //   86: invokevirtual 440	java/lang/String:substring	(II)Ljava/lang/String;
    //   89: astore_2
    //   90: aload_2
    //   91: astore_3
    //   92: aload 4
    //   94: ifnull +12 -> 106
    //   97: aload_2
    //   98: astore_3
    //   99: aload 4
    //   101: invokevirtual 553	java/io/FileReader:close	()V
    //   104: aload_2
    //   105: astore_3
    //   106: aload_3
    //   107: areturn
    //   108: iload_0
    //   109: iconst_1
    //   110: iadd
    //   111: istore_0
    //   112: goto -54 -> 58
    //   115: astore 5
    //   117: aconst_null
    //   118: astore_2
    //   119: aload_2
    //   120: astore_3
    //   121: ldc 39
    //   123: iconst_1
    //   124: ldc_w 555
    //   127: aload 5
    //   129: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   132: ldc_w 559
    //   135: astore 4
    //   137: aload 4
    //   139: astore_3
    //   140: aload_2
    //   141: ifnull -35 -> 106
    //   144: aload 4
    //   146: astore_3
    //   147: aload_2
    //   148: invokevirtual 553	java/io/FileReader:close	()V
    //   151: ldc_w 559
    //   154: areturn
    //   155: astore_2
    //   156: aload_3
    //   157: areturn
    //   158: astore_2
    //   159: aconst_null
    //   160: astore_3
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 553	java/io/FileReader:close	()V
    //   169: aload_2
    //   170: athrow
    //   171: astore_3
    //   172: goto -3 -> 169
    //   175: astore_2
    //   176: goto -15 -> 161
    //   179: astore_3
    //   180: goto -48 -> 132
    //   183: astore 5
    //   185: aload 4
    //   187: astore_2
    //   188: goto -69 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramInt	int
    //   1	56	1	i	int
    //   45	103	2	localObject1	Object
    //   155	1	2	localThrowable1	Throwable
    //   158	12	2	localObject2	Object
    //   175	1	2	localObject3	Object
    //   187	1	2	localObject4	Object
    //   39	127	3	localObject5	Object
    //   171	1	3	localThrowable2	Throwable
    //   179	1	3	localThrowable3	Throwable
    //   35	151	4	localObject6	Object
    //   115	13	5	localThrowable4	Throwable
    //   183	1	5	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	37	115	java/lang/Throwable
    //   99	104	155	java/lang/Throwable
    //   147	151	155	java/lang/Throwable
    //   2	37	158	finally
    //   165	169	171	java/lang/Throwable
    //   40	46	175	finally
    //   49	56	175	finally
    //   61	67	175	finally
    //   76	90	175	finally
    //   121	132	175	finally
    //   121	132	179	java/lang/Throwable
    //   40	46	183	java/lang/Throwable
    //   49	56	183	java/lang/Throwable
    //   61	67	183	java/lang/Throwable
    //   76	90	183	java/lang/Throwable
  }
  
  public static String getProcessName(Context paramContext)
  {
    if (paramContext == null) {
      return "unknown";
    }
    Context localContext = null;
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        localContext = paramContext;
        Iterator localIterator = paramContext.iterator();
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
        do
        {
          do
          {
            localContext = paramContext;
            if (!localIterator.hasNext()) {
              break;
            }
            localContext = paramContext;
            localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
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
      QLog.d("MsfSdkUtils", 1, "getProcessName error " + localContext, paramContext);
      label113:
      return getProcessName(Process.myPid());
    }
    catch (Throwable paramContext)
    {
      break label113;
    }
  }
  
  public static String getResolutionString(Context paramContext)
  {
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    int j = paramContext.getResources().getDisplayMetrics().heightPixels;
    int k;
    if (paramContext.getResources().getConfiguration().orientation == 2)
    {
      k = j;
      j = i;
    }
    for (;;)
    {
      return k + "X" + j;
      k = i;
    }
  }
  
  /* Error */
  public static int getRoutingID(Context paramContext)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: new 117	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   9: invokestatic 247	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: invokevirtual 254	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   15: invokevirtual 122	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 621
    //   24: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore_0
    //   31: new 117	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   38: aload_0
    //   39: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 623
    //   45: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: astore 4
    //   53: new 101	java/io/File
    //   56: dup
    //   57: aload 4
    //   59: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore_3
    //   63: aload_3
    //   64: astore_0
    //   65: aload_3
    //   66: invokevirtual 626	java/io/File:canRead	()Z
    //   69: ifne +13 -> 82
    //   72: new 101	java/io/File
    //   75: dup
    //   76: aload 4
    //   78: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: astore_0
    //   82: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   85: ifeq +71 -> 156
    //   88: ldc 39
    //   90: iconst_2
    //   91: new 117	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 628
    //   101: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: invokevirtual 122	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   108: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc_w 630
    //   114: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: aload_0
    //   118: invokevirtual 633	java/io/File:isFile	()Z
    //   121: invokevirtual 636	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   124: ldc_w 638
    //   127: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_0
    //   131: invokevirtual 626	java/io/File:canRead	()Z
    //   134: invokevirtual 636	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   137: ldc_w 640
    //   140: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: invokevirtual 643	java/io/File:length	()J
    //   147: invokevirtual 646	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   150: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 649	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: new 391	java/util/Properties
    //   159: dup
    //   160: invokespecial 484	java/util/Properties:<init>	()V
    //   163: astore 5
    //   165: aload_0
    //   166: invokevirtual 105	java/io/File:exists	()Z
    //   169: ifeq +174 -> 343
    //   172: new 486	java/io/FileInputStream
    //   175: dup
    //   176: aload_0
    //   177: invokespecial 489	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   180: astore_3
    //   181: aload_3
    //   182: astore_0
    //   183: aload 5
    //   185: aload_3
    //   186: invokevirtual 493	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   189: aload_3
    //   190: astore_0
    //   191: aload_3
    //   192: invokevirtual 520	java/io/FileInputStream:close	()V
    //   195: aload_3
    //   196: ifnull +7 -> 203
    //   199: aload_3
    //   200: invokevirtual 520	java/io/FileInputStream:close	()V
    //   203: aload 5
    //   205: ldc_w 651
    //   208: invokevirtual 394	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   211: astore_0
    //   212: aload_0
    //   213: ifnull +125 -> 338
    //   216: aload_0
    //   217: invokevirtual 654	java/lang/String:trim	()Ljava/lang/String;
    //   220: invokevirtual 397	java/lang/String:length	()I
    //   223: ifle +115 -> 338
    //   226: aload_0
    //   227: invokestatic 657	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   230: invokevirtual 340	java/lang/Integer:intValue	()I
    //   233: istore_2
    //   234: iload_2
    //   235: istore_1
    //   236: iload_1
    //   237: ireturn
    //   238: astore 4
    //   240: aconst_null
    //   241: astore_3
    //   242: aload_3
    //   243: astore_0
    //   244: aload 4
    //   246: invokevirtual 259	java/lang/Exception:printStackTrace	()V
    //   249: aload_3
    //   250: ifnull -47 -> 203
    //   253: aload_3
    //   254: invokevirtual 520	java/io/FileInputStream:close	()V
    //   257: goto -54 -> 203
    //   260: astore_0
    //   261: aload_0
    //   262: invokevirtual 521	java/io/IOException:printStackTrace	()V
    //   265: goto -62 -> 203
    //   268: astore_3
    //   269: aconst_null
    //   270: astore_0
    //   271: aload_0
    //   272: ifnull +7 -> 279
    //   275: aload_0
    //   276: invokevirtual 520	java/io/FileInputStream:close	()V
    //   279: aload_3
    //   280: athrow
    //   281: astore_3
    //   282: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq -49 -> 236
    //   288: ldc 39
    //   290: iconst_2
    //   291: new 117	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 659
    //   301: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_0
    //   305: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: aload_3
    //   312: invokestatic 661	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   315: iconst_m1
    //   316: ireturn
    //   317: astore_0
    //   318: aload_0
    //   319: invokevirtual 521	java/io/IOException:printStackTrace	()V
    //   322: goto -43 -> 279
    //   325: astore_0
    //   326: goto -65 -> 261
    //   329: astore_3
    //   330: goto -59 -> 271
    //   333: astore 4
    //   335: goto -93 -> 242
    //   338: iconst_m1
    //   339: istore_1
    //   340: goto -104 -> 236
    //   343: aconst_null
    //   344: astore_3
    //   345: goto -150 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramContext	Context
    //   1	339	1	i	int
    //   233	2	2	j	int
    //   62	192	3	localObject1	Object
    //   268	12	3	localObject2	Object
    //   281	31	3	localThrowable	Throwable
    //   329	1	3	localObject3	Object
    //   344	1	3	localObject4	Object
    //   51	26	4	str	String
    //   238	7	4	localException1	Exception
    //   333	1	4	localException2	Exception
    //   163	41	5	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   165	181	238	java/lang/Exception
    //   253	257	260	java/io/IOException
    //   165	181	268	finally
    //   216	234	281	java/lang/Throwable
    //   275	279	317	java/io/IOException
    //   199	203	325	java/io/IOException
    //   183	189	329	finally
    //   191	195	329	finally
    //   244	249	329	finally
    //   183	189	333	java/lang/Exception
    //   191	195	333	java/lang/Exception
  }
  
  public static int getSendBatteryStatus(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1) {}
    for (int i = paramInt1 | 0x80;; i = paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.PushManager:PushCoder", 2, new Object[] { "ret:", Integer.valueOf(i), " batteryCapacity:", Integer.valueOf(paramInt1), " powerConectStatus:", Integer.valueOf(paramInt2) });
      }
      return i;
    }
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
    //   10: ldc_w 678
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_0
    //   17: aastore
    //   18: dup
    //   19: iconst_2
    //   20: ldc_w 680
    //   23: aastore
    //   24: dup
    //   25: iconst_3
    //   26: iload_1
    //   27: invokestatic 323	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_4
    //   33: ldc_w 682
    //   36: aastore
    //   37: dup
    //   38: iconst_5
    //   39: aload_2
    //   40: aastore
    //   41: invokestatic 674	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   44: aload_0
    //   45: iload_1
    //   46: aload_2
    //   47: invokestatic 686	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;ILjava/lang/String;)Ljava/io/File;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +10 -> 62
    //   55: aload_2
    //   56: invokevirtual 105	java/io/File:exists	()Z
    //   59: ifne +7 -> 66
    //   62: ldc_w 365
    //   65: areturn
    //   66: new 117	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   73: astore 4
    //   75: aconst_null
    //   76: astore_0
    //   77: new 688	java/io/InputStreamReader
    //   80: dup
    //   81: new 486	java/io/FileInputStream
    //   84: dup
    //   85: aload_2
    //   86: invokespecial 489	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: ldc_w 690
    //   92: invokespecial 693	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   95: astore_2
    //   96: aload_2
    //   97: astore_0
    //   98: sipush 4096
    //   101: newarray char
    //   103: astore_3
    //   104: aload_2
    //   105: astore_0
    //   106: aload_2
    //   107: aload_3
    //   108: invokevirtual 694	java/io/InputStreamReader:read	([C)I
    //   111: istore_1
    //   112: iconst_m1
    //   113: iload_1
    //   114: if_icmpeq +61 -> 175
    //   117: aload_2
    //   118: astore_0
    //   119: aload 4
    //   121: aload_3
    //   122: iconst_0
    //   123: iload_1
    //   124: invokevirtual 697	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: goto -24 -> 104
    //   131: astore_3
    //   132: aload_2
    //   133: astore_0
    //   134: aload_3
    //   135: invokevirtual 259	java/lang/Exception:printStackTrace	()V
    //   138: aload_2
    //   139: ifnull +7 -> 146
    //   142: aload_2
    //   143: invokevirtual 698	java/io/InputStreamReader:close	()V
    //   146: aload 4
    //   148: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: areturn
    //   152: astore_3
    //   153: aload_0
    //   154: astore_2
    //   155: aload_3
    //   156: astore_0
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 698	java/io/InputStreamReader:close	()V
    //   165: aload_0
    //   166: athrow
    //   167: astore_2
    //   168: goto -3 -> 165
    //   171: astore_0
    //   172: goto -26 -> 146
    //   175: aload_2
    //   176: ifnull -30 -> 146
    //   179: aload_2
    //   180: invokevirtual 698	java/io/InputStreamReader:close	()V
    //   183: goto -37 -> 146
    //   186: astore_3
    //   187: aload_0
    //   188: astore_2
    //   189: aload_3
    //   190: astore_0
    //   191: goto -34 -> 157
    //   194: astore_3
    //   195: aconst_null
    //   196: astore_2
    //   197: goto -65 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramString1	String
    //   0	200	1	paramInt	int
    //   0	200	2	paramString2	String
    //   103	19	3	arrayOfChar	char[]
    //   131	4	3	localException1	Exception
    //   152	4	3	localObject1	Object
    //   186	4	3	localObject2	Object
    //   194	1	3	localException2	Exception
    //   73	74	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   98	104	131	java/lang/Exception
    //   106	112	131	java/lang/Exception
    //   119	128	131	java/lang/Exception
    //   77	96	152	finally
    //   161	165	167	java/io/IOException
    //   142	146	171	java/io/IOException
    //   179	183	171	java/io/IOException
    //   98	104	186	finally
    //   106	112	186	finally
    //   119	128	186	finally
    //   134	138	186	finally
    //   77	96	194	java/lang/Exception
  }
  
  public static File getServerConfigFile(String paramString1, int paramInt, String paramString2)
  {
    if (paramString1 == null) {}
    String str;
    do
    {
      return null;
      str = paramString1.replaceAll(":", "_");
      try
      {
        paramString1 = BaseApplication.getContext().getFilesDir().getAbsolutePath();
        if (paramInt == 0) {
          return new File(paramString1 + "/" + str + "_common");
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          paramString1 = "/data/data/com.tencent.mobileqq/files";
        }
        if (paramInt == 1) {
          return new File(paramString1 + "/" + str + "_" + paramString2.hashCode() + "_user");
        }
      }
    } while (paramInt != 2);
    return new File(paramString1 + "/" + str + "_app");
  }
  
  public static String getShortHexKey(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      return "*";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toHexString(paramArrayOfByte[0]));
    localStringBuilder.append(Integer.toHexString(paramArrayOfByte[1]));
    localStringBuilder.append(Integer.toHexString(paramArrayOfByte[2]));
    localStringBuilder.append(Integer.toHexString(paramArrayOfByte[3]));
    return localStringBuilder.toString();
  }
  
  public static String getShortKey(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      return "*";
    }
    return MD5.toMD5(new String(paramArrayOfByte)).substring(0, 4) + "*";
  }
  
  public static String getShortStringKey(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      return "*";
    }
    return new String(paramArrayOfByte, 0, 4);
  }
  
  public static String getShortUin(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 4)) {
      return paramString;
    }
    return "*" + paramString.substring(paramString.length() - 4, paramString.length());
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
    for (;;)
    {
      try
      {
        Iterator localIterator = Thread.getAllStackTraces().keySet().iterator();
        j = i;
        int k = i;
        if (localIterator.hasNext())
        {
          j = i;
          boolean bool = paramString.equals(((Thread)localIterator.next()).getName());
          if (bool) {
            i += 1;
          }
        }
        else
        {
          return k;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        k = j;
      }
    }
  }
  
  /* Error */
  public static String getThreadStackString(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 772	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   5: astore 4
    //   7: aload 4
    //   9: invokeinterface 775 1 0
    //   14: invokeinterface 503 1 0
    //   19: astore 6
    //   21: aload 6
    //   23: invokeinterface 508 1 0
    //   28: ifeq +115 -> 143
    //   31: aload 6
    //   33: invokeinterface 512 1 0
    //   38: checkcast 349	java/lang/Thread
    //   41: astore 5
    //   43: aload_0
    //   44: aload 5
    //   46: invokevirtual 778	java/lang/Thread:getName	()Ljava/lang/String;
    //   49: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq -31 -> 21
    //   55: new 117	java/lang/StringBuilder
    //   58: dup
    //   59: sipush 1024
    //   62: invokespecial 358	java/lang/StringBuilder:<init>	(I)V
    //   65: astore_0
    //   66: aload 4
    //   68: aload 5
    //   70: invokeinterface 783 2 0
    //   75: checkcast 785	[Ljava/lang/StackTraceElement;
    //   78: astore_3
    //   79: aload_3
    //   80: arraylength
    //   81: istore_2
    //   82: iconst_0
    //   83: istore_1
    //   84: iload_1
    //   85: iload_2
    //   86: if_icmpge +26 -> 112
    //   89: aload_0
    //   90: aload_3
    //   91: iload_1
    //   92: aaload
    //   93: invokevirtual 361	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   96: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 146
    //   101: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: iload_1
    //   106: iconst_1
    //   107: iadd
    //   108: istore_1
    //   109: goto -25 -> 84
    //   112: aload_0
    //   113: ifnonnull +21 -> 134
    //   116: ldc_w 365
    //   119: areturn
    //   120: astore 4
    //   122: aload_3
    //   123: astore_0
    //   124: aload 4
    //   126: astore_3
    //   127: aload_3
    //   128: invokevirtual 259	java/lang/Exception:printStackTrace	()V
    //   131: goto -19 -> 112
    //   134: aload_0
    //   135: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: areturn
    //   139: astore_3
    //   140: goto -13 -> 127
    //   143: aconst_null
    //   144: astore_0
    //   145: goto -33 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramString	String
    //   83	26	1	i	int
    //   81	6	2	j	int
    //   1	127	3	localObject	Object
    //   139	1	3	localException1	Exception
    //   5	62	4	localMap	Map
    //   120	5	4	localException2	Exception
    //   41	28	5	localThread	Thread
    //   19	13	6	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	21	120	java/lang/Exception
    //   21	66	120	java/lang/Exception
    //   66	82	139	java/lang/Exception
    //   89	105	139	java/lang/Exception
  }
  
  public static String getTotalMemory()
  {
    for (;;)
    {
      try
      {
        BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        String str = localBufferedReader.readLine();
        if (str != null) {
          str = str.trim();
        }
        str = "";
      }
      catch (IOException localIOException1)
      {
        try
        {
          localBufferedReader.close();
          return str;
        }
        catch (IOException localIOException2)
        {
          continue;
        }
        localIOException1 = localIOException1;
        str = "";
        localIOException1.printStackTrace();
        return str;
      }
    }
  }
  
  public static String insertMtype(String paramString1, String paramString2)
  {
    if (paramString2.contains("mType=")) {}
    do
    {
      do
      {
        return paramString2;
      } while (paramString1 == null);
      int i = paramString2.indexOf("?");
      if (i > 0)
      {
        if (paramString2.length() == i + 1) {
          return paramString2.substring(0, i + 1) + "mType=" + paramString1;
        }
        i = paramString2.indexOf("#", i);
        if (i > -1) {}
        for (paramString1 = paramString2.substring(0, i) + "&mType=" + paramString1 + paramString2.substring(i);; paramString1 = paramString2 + "&mType=" + paramString1) {
          return paramString1;
        }
      }
    } while (paramString2.length() <= 0);
    return paramString2 + "?mType=" + paramString1;
  }
  
  private static boolean isAccountFileExist(File paramFile, String paramString)
  {
    boolean bool2 = false;
    paramFile = paramFile.list();
    boolean bool1 = bool2;
    int i;
    if (paramFile != null)
    {
      bool1 = bool2;
      if (paramFile.length > 0) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramFile.length)
      {
        if ((paramFile[i] != null) && ((paramFile[i].equals("u_" + paramString + "_f")) || (paramFile[i].equals("u_" + paramString + "_t")))) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isBatteryOnlineStatus(PushRegisterInfo paramPushRegisterInfo)
  {
    if ((paramPushRegisterInfo != null) && (paramPushRegisterInfo.extStatus == 1000L)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        if (paramPushRegisterInfo != null) {
          break label54;
        }
      }
      label54:
      for (paramPushRegisterInfo = "null";; paramPushRegisterInfo = Long.valueOf(paramPushRegisterInfo.extStatus))
      {
        QLog.d("MSF.C.PushManager:PushCoder", 1, new Object[] { "isBatteryOnlineStatus extStatus:", paramPushRegisterInfo });
        return bool;
      }
    }
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
      QLog.d("MsfSdkUtils", 1, "e = " + paramContext.toString());
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
    boolean bool = false;
    String[] arrayOfString = s_validBusId;
    int j = arrayOfString.length;
    int i = 0;
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
    if ((paramContext == null) || (paramString == null)) {
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
    return false;
  }
  
  /* Error */
  public static Properties loadConfig(String paramString)
  {
    // Byte code:
    //   0: new 391	java/util/Properties
    //   3: dup
    //   4: invokespecial 484	java/util/Properties:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aload_2
    //   13: areturn
    //   14: new 486	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 887	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 493	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   28: aload_1
    //   29: ifnull -17 -> 12
    //   32: aload_1
    //   33: invokevirtual 520	java/io/FileInputStream:close	()V
    //   36: aload_2
    //   37: areturn
    //   38: astore_0
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 520	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: athrow
    //   51: astore_0
    //   52: goto -11 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString	String
    //   22	24	1	localFileInputStream	java.io.FileInputStream
    //   7	30	2	localProperties	Properties
    // Exception table:
    //   from	to	target	type
    //   14	23	38	finally
    //   23	28	51	finally
  }
  
  /* Error */
  public static void saveConfig(String paramString, Properties paramProperties)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 891	java/io/FileOutputStream
    //   12: dup
    //   13: aload_0
    //   14: iconst_0
    //   15: invokespecial 893	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   18: astore_2
    //   19: aload_1
    //   20: aload_2
    //   21: ldc_w 365
    //   24: invokevirtual 897	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   27: aload_2
    //   28: ifnull -20 -> 8
    //   31: aload_2
    //   32: invokevirtual 898	java/io/FileOutputStream:close	()V
    //   35: return
    //   36: astore_0
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 898	java/io/FileOutputStream:close	()V
    //   47: aload_0
    //   48: athrow
    //   49: astore_0
    //   50: aload_2
    //   51: astore_1
    //   52: goto -13 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString	String
    //   0	55	1	paramProperties	Properties
    //   18	33	2	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   9	19	36	finally
    //   19	27	49	finally
  }
  
  public static void updateSimpleAccount(String paramString, boolean paramBoolean)
  {
    label399:
    for (;;)
    {
      try
      {
        Object localObject2 = getNewAppUinStoreFile();
        int i;
        if (((File)localObject2).exists())
        {
          Object localObject3 = new StringBuilder().append(((File)localObject2).getAbsolutePath()).append("/u_").append(paramString);
          if (!paramBoolean) {
            continue;
          }
          localObject1 = "_t";
          localObject1 = (String)localObject1;
          localObject3 = new File((String)localObject1);
          if (((File)localObject3).exists())
          {
            ((File)localObject3).delete();
            if (QLog.isColorLevel()) {
              QLog.d("MsfSdkUtils", 2, "found want update user exists,del " + paramString + " " + paramBoolean);
            }
          }
          localObject2 = ((File)localObject2).listFiles();
          if (localObject2 == null) {
            continue;
          }
          int j = localObject2.length;
          i = 0;
          if (i >= j) {
            continue;
          }
          localObject3 = localObject2[i];
          if ((!((File)localObject3).getName().equals("u_" + paramString + "_t")) && (!((File)localObject3).getName().equals("u_" + paramString + "_f"))) {
            break label399;
          }
          ((File)localObject3).renameTo(new File((String)localObject1));
          if (QLog.isColorLevel()) {
            QLog.d("MsfSdkUtils", 2, "update user succ " + paramString + " " + paramBoolean);
          }
        }
        return;
        Object localObject1 = "_f";
        continue;
        localObject1 = new File((String)localObject1);
        try
        {
          ((File)localObject1).createNewFile();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("MsfSdkUtils", 2, "update add user succ " + MD5.toMD5(paramString));
        }
        catch (Exception localException)
        {
          QLog.d("MsfSdkUtils", 1, "update add user failed " + MD5.toMD5(paramString) + " " + localException);
        }
        continue;
        i += 1;
      }
      finally {}
    }
  }
  
  /* Error */
  public static void updateSimpleAccountNotCreate(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 99	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getNewAppUinStoreFile	()Ljava/io/File;
    //   6: astore 5
    //   8: aload 5
    //   10: invokevirtual 105	java/io/File:exists	()Z
    //   13: ifeq +173 -> 186
    //   16: new 117	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   23: aload 5
    //   25: invokevirtual 122	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 128
    //   33: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: astore 6
    //   42: iload_1
    //   43: ifeq +147 -> 190
    //   46: ldc 130
    //   48: astore 4
    //   50: aload 6
    //   52: aload 4
    //   54: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 4
    //   62: new 101	java/io/File
    //   65: dup
    //   66: aload 4
    //   68: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: pop
    //   72: aload 5
    //   74: invokevirtual 905	java/io/File:listFiles	()[Ljava/io/File;
    //   77: astore 5
    //   79: aload 5
    //   81: ifnull +105 -> 186
    //   84: aload 5
    //   86: arraylength
    //   87: istore_3
    //   88: iconst_0
    //   89: istore_2
    //   90: iload_2
    //   91: iload_3
    //   92: if_icmpge +94 -> 186
    //   95: aload 5
    //   97: iload_2
    //   98: aaload
    //   99: astore 6
    //   101: aload 6
    //   103: invokevirtual 906	java/io/File:getName	()Ljava/lang/String;
    //   106: new 117	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   113: ldc 223
    //   115: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 130
    //   124: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifne +38 -> 171
    //   136: aload 6
    //   138: invokevirtual 906	java/io/File:getName	()Ljava/lang/String;
    //   141: new 117	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   148: ldc 223
    //   150: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 155
    //   159: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokevirtual 227	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +29 -> 197
    //   171: aload 6
    //   173: new 101	java/io/File
    //   176: dup
    //   177: aload 4
    //   179: invokespecial 134	java/io/File:<init>	(Ljava/lang/String;)V
    //   182: invokevirtual 910	java/io/File:renameTo	(Ljava/io/File;)Z
    //   185: pop
    //   186: ldc 2
    //   188: monitorexit
    //   189: return
    //   190: ldc 155
    //   192: astore 4
    //   194: goto -144 -> 50
    //   197: iload_2
    //   198: iconst_1
    //   199: iadd
    //   200: istore_2
    //   201: goto -111 -> 90
    //   204: astore_0
    //   205: ldc 2
    //   207: monitorexit
    //   208: aload_0
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramString	String
    //   0	210	1	paramBoolean	boolean
    //   89	112	2	i	int
    //   87	6	3	j	int
    //   48	145	4	str	String
    //   6	90	5	localObject	Object
    //   40	132	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	42	204	finally
    //   50	79	204	finally
    //   84	88	204	finally
    //   101	171	204	finally
    //   171	186	204	finally
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
    //   10: ldc_w 920
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_0
    //   17: aastore
    //   18: dup
    //   19: iconst_2
    //   20: ldc_w 680
    //   23: aastore
    //   24: dup
    //   25: iconst_3
    //   26: iload_1
    //   27: invokestatic 323	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: aastore
    //   31: dup
    //   32: iconst_4
    //   33: ldc_w 682
    //   36: aastore
    //   37: dup
    //   38: iconst_5
    //   39: aload_3
    //   40: aastore
    //   41: invokestatic 674	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   44: aload_0
    //   45: iload_1
    //   46: aload_3
    //   47: invokestatic 686	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;ILjava/lang/String;)Ljava/io/File;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull +14 -> 66
    //   55: new 483	java/io/IOException
    //   58: dup
    //   59: ldc_w 922
    //   62: invokespecial 923	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   65: athrow
    //   66: aload_3
    //   67: invokevirtual 105	java/io/File:exists	()Z
    //   70: ifne +8 -> 78
    //   73: aload_3
    //   74: invokevirtual 137	java/io/File:createNewFile	()Z
    //   77: pop
    //   78: aload_3
    //   79: invokevirtual 105	java/io/File:exists	()Z
    //   82: ifeq +10 -> 92
    //   85: aload_3
    //   86: invokevirtual 926	java/io/File:canWrite	()Z
    //   89: ifne +34 -> 123
    //   92: new 483	java/io/IOException
    //   95: dup
    //   96: new 117	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 928
    //   106: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokevirtual 122	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   113: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokespecial 923	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //   123: aconst_null
    //   124: astore_0
    //   125: new 930	java/io/OutputStreamWriter
    //   128: dup
    //   129: new 891	java/io/FileOutputStream
    //   132: dup
    //   133: aload_3
    //   134: invokespecial 931	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   137: ldc_w 690
    //   140: invokespecial 933	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   143: astore_3
    //   144: aload_3
    //   145: astore_0
    //   146: aload_3
    //   147: aload_2
    //   148: invokevirtual 936	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   151: aload_3
    //   152: astore_0
    //   153: aload_3
    //   154: invokevirtual 937	java/io/OutputStreamWriter:flush	()V
    //   157: aload_3
    //   158: ifnull +7 -> 165
    //   161: aload_3
    //   162: invokevirtual 938	java/io/OutputStreamWriter:close	()V
    //   165: return
    //   166: astore 4
    //   168: aconst_null
    //   169: astore_2
    //   170: aload_2
    //   171: astore_0
    //   172: aload 4
    //   174: invokevirtual 259	java/lang/Exception:printStackTrace	()V
    //   177: aload_2
    //   178: ifnull -13 -> 165
    //   181: aload_2
    //   182: invokevirtual 938	java/io/OutputStreamWriter:close	()V
    //   185: return
    //   186: astore_0
    //   187: return
    //   188: astore_3
    //   189: aload_0
    //   190: astore_2
    //   191: aload_3
    //   192: astore_0
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 938	java/io/OutputStreamWriter:close	()V
    //   201: aload_0
    //   202: athrow
    //   203: astore_2
    //   204: goto -3 -> 201
    //   207: astore_3
    //   208: aload_0
    //   209: astore_2
    //   210: aload_3
    //   211: astore_0
    //   212: goto -19 -> 193
    //   215: astore 4
    //   217: aload_3
    //   218: astore_2
    //   219: goto -49 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	paramString1	String
    //   0	222	1	paramInt	int
    //   0	222	2	paramString2	String
    //   0	222	3	paramString3	String
    //   166	7	4	localException1	Exception
    //   215	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   125	144	166	java/lang/Exception
    //   161	165	186	java/io/IOException
    //   181	185	186	java/io/IOException
    //   125	144	188	finally
    //   197	201	203	java/io/IOException
    //   146	151	207	finally
    //   153	157	207	finally
    //   172	177	207	finally
    //   146	151	215	java/lang/Exception
    //   153	157	215	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfSdkUtils
 * JD-Core Version:    0.7.0.1
 */