package com.tencent.mobileqq.msf.sdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class MsfSdkUtils
{
  private static final String APP_FILE_PATH = "/data/data/com.tencent.mobileqq/files";
  public static final String TAG_COREUTIL_TOMSGE_UID = "__CoreUtil_toMsg_Uid";
  public static final boolean isPublicVersion = false;
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
    //   3: invokestatic 75	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getNewAppUinStoreFile	()Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: invokevirtual 81	java/io/File:exists	()Z
    //   11: ifne +8 -> 19
    //   14: aload_2
    //   15: invokevirtual 84	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: aload_2
    //   20: invokevirtual 81	java/io/File:exists	()Z
    //   23: ifeq +13 -> 36
    //   26: aload_2
    //   27: aload_0
    //   28: invokestatic 88	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:isAccountFileExist	(Ljava/io/File;Ljava/lang/String;)Z
    //   31: istore_1
    //   32: iload_1
    //   33: ifeq +7 -> 40
    //   36: ldc 2
    //   38: monitorexit
    //   39: return
    //   40: new 77	java/io/File
    //   43: dup
    //   44: new 93	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   51: aload_2
    //   52: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   55: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: ldc 104
    //   60: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_0
    //   64: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 131
    //   69: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   78: astore_2
    //   79: aload_2
    //   80: invokevirtual 113	java/io/File:createNewFile	()Z
    //   83: pop
    //   84: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq -51 -> 36
    //   90: ldc 19
    //   92: iconst_2
    //   93: new 93	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   100: ldc 134
    //   102: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: goto -79 -> 36
    //   118: astore_2
    //   119: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq -86 -> 36
    //   125: ldc 19
    //   127: iconst_2
    //   128: new 93	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   135: ldc 120
    //   137: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: aload_0
    //   141: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: ldc 122
    //   146: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_2
    //   150: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    return BaseApplication.channelId;
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
    return String.valueOf(BaseApplication.APP_ID);
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
    //   3: new 276	java/util/ArrayList
    //   6: dup
    //   7: invokespecial 277	java/util/ArrayList:<init>	()V
    //   10: astore 4
    //   12: aload_0
    //   13: ifnull +12 -> 25
    //   16: aload_0
    //   17: invokevirtual 81	java/io/File:exists	()Z
    //   20: istore_1
    //   21: iload_1
    //   22: ifne +9 -> 31
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload 4
    //   30: areturn
    //   31: new 336	java/util/Properties
    //   34: dup
    //   35: invokespecial 337	java/util/Properties:<init>	()V
    //   38: astore_3
    //   39: new 339	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 342	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_2
    //   48: aload_2
    //   49: astore_0
    //   50: aload_3
    //   51: aload_2
    //   52: invokevirtual 346	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   55: aload_2
    //   56: astore_0
    //   57: aload_3
    //   58: invokevirtual 350	java/util/Properties:keySet	()Ljava/util/Set;
    //   61: invokeinterface 356 1 0
    //   66: astore 5
    //   68: aload_2
    //   69: astore_0
    //   70: aload 5
    //   72: invokeinterface 361 1 0
    //   77: ifeq +159 -> 236
    //   80: aload_2
    //   81: astore_0
    //   82: aload 5
    //   84: invokeinterface 365 1 0
    //   89: checkcast 201	java/lang/String
    //   92: astore 6
    //   94: aload_2
    //   95: astore_0
    //   96: aload_3
    //   97: aload 6
    //   99: invokevirtual 369	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 7
    //   104: aload 7
    //   106: ifnull -38 -> 68
    //   109: aload_2
    //   110: astore_0
    //   111: aload 7
    //   113: invokestatic 373	com/tencent/qphone/base/remote/SimpleAccount:parseSimpleAccount	(Ljava/lang/String;)Lcom/tencent/qphone/base/remote/SimpleAccount;
    //   116: astore 7
    //   118: aload 7
    //   120: ifnull -52 -> 68
    //   123: aload_2
    //   124: astore_0
    //   125: aload 7
    //   127: invokevirtual 374	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   130: invokestatic 308	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:isUinLong	(Ljava/lang/String;)Z
    //   133: ifeq +34 -> 167
    //   136: aload_2
    //   137: astore_0
    //   138: aload 4
    //   140: aload 7
    //   142: invokevirtual 311	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   145: pop
    //   146: goto -78 -> 68
    //   149: astore_3
    //   150: aload_2
    //   151: astore_0
    //   152: aload_3
    //   153: invokevirtual 237	java/lang/Exception:printStackTrace	()V
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 377	java/io/FileInputStream:close	()V
    //   164: goto -139 -> 25
    //   167: aload_2
    //   168: astore_0
    //   169: ldc 19
    //   171: iconst_1
    //   172: new 93	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 313
    //   182: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 6
    //   187: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: goto -128 -> 68
    //   199: astore_3
    //   200: aload_0
    //   201: astore_2
    //   202: aload_3
    //   203: astore_0
    //   204: aload_2
    //   205: ifnull +7 -> 212
    //   208: aload_2
    //   209: invokevirtual 377	java/io/FileInputStream:close	()V
    //   212: aload_0
    //   213: athrow
    //   214: astore_0
    //   215: ldc 2
    //   217: monitorexit
    //   218: aload_0
    //   219: athrow
    //   220: astore_2
    //   221: aload_2
    //   222: invokevirtual 378	java/io/IOException:printStackTrace	()V
    //   225: goto -13 -> 212
    //   228: astore_0
    //   229: aload_0
    //   230: invokevirtual 378	java/io/IOException:printStackTrace	()V
    //   233: goto -69 -> 164
    //   236: aload_2
    //   237: ifnull -73 -> 164
    //   240: aload_2
    //   241: invokevirtual 377	java/io/FileInputStream:close	()V
    //   244: goto -80 -> 164
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 378	java/io/IOException:printStackTrace	()V
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
    //   38	59	3	localProperties	java.util.Properties
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
    catch (Exception paramContext)
    {
      QLog.d("MsfSdkUtils", 1, "getProcessName error " + localContext, paramContext);
    }
    return "unknown";
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
  public static String getServerConfig(String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: aload_2
    //   3: invokestatic 469	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;ILjava/lang/String;)Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +10 -> 18
    //   11: aload_2
    //   12: invokevirtual 81	java/io/File:exists	()Z
    //   15: ifne +7 -> 22
    //   18: ldc_w 272
    //   21: areturn
    //   22: new 93	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   29: astore 4
    //   31: aconst_null
    //   32: astore_0
    //   33: new 471	java/io/InputStreamReader
    //   36: dup
    //   37: new 339	java/io/FileInputStream
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 342	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: ldc_w 473
    //   48: invokespecial 476	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: astore_0
    //   54: sipush 4096
    //   57: newarray char
    //   59: astore_3
    //   60: aload_2
    //   61: astore_0
    //   62: aload_2
    //   63: aload_3
    //   64: invokevirtual 480	java/io/InputStreamReader:read	([C)I
    //   67: istore_1
    //   68: iconst_m1
    //   69: iload_1
    //   70: if_icmpeq +61 -> 131
    //   73: aload_2
    //   74: astore_0
    //   75: aload 4
    //   77: aload_3
    //   78: iconst_0
    //   79: iload_1
    //   80: invokevirtual 483	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: goto -24 -> 60
    //   87: astore_3
    //   88: aload_2
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 237	java/lang/Exception:printStackTrace	()V
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 484	java/io/InputStreamReader:close	()V
    //   102: aload 4
    //   104: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: areturn
    //   108: astore_3
    //   109: aload_0
    //   110: astore_2
    //   111: aload_3
    //   112: astore_0
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 484	java/io/InputStreamReader:close	()V
    //   121: aload_0
    //   122: athrow
    //   123: astore_2
    //   124: goto -3 -> 121
    //   127: astore_0
    //   128: goto -26 -> 102
    //   131: aload_2
    //   132: ifnull -30 -> 102
    //   135: aload_2
    //   136: invokevirtual 484	java/io/InputStreamReader:close	()V
    //   139: goto -37 -> 102
    //   142: astore_3
    //   143: aload_0
    //   144: astore_2
    //   145: aload_3
    //   146: astore_0
    //   147: goto -34 -> 113
    //   150: astore_3
    //   151: aconst_null
    //   152: astore_2
    //   153: goto -65 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramString1	String
    //   0	156	1	paramInt	int
    //   0	156	2	paramString2	String
    //   59	19	3	arrayOfChar	char[]
    //   87	4	3	localException1	Exception
    //   108	4	3	localObject1	Object
    //   142	4	3	localObject2	Object
    //   150	1	3	localException2	Exception
    //   29	74	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   54	60	87	java/lang/Exception
    //   62	68	87	java/lang/Exception
    //   75	84	87	java/lang/Exception
    //   33	52	108	finally
    //   117	121	123	java/io/IOException
    //   98	102	127	java/io/IOException
    //   135	139	127	java/io/IOException
    //   54	60	142	finally
    //   62	68	142	finally
    //   75	84	142	finally
    //   90	94	142	finally
    //   33	52	150	java/lang/Exception
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
    //   2: invokestatic 563	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   5: astore 4
    //   7: aload 4
    //   9: invokeinterface 566 1 0
    //   14: invokeinterface 356 1 0
    //   19: astore 6
    //   21: aload 6
    //   23: invokeinterface 361 1 0
    //   28: ifeq +115 -> 143
    //   31: aload 6
    //   33: invokeinterface 365 1 0
    //   38: checkcast 256	java/lang/Thread
    //   41: astore 5
    //   43: aload_0
    //   44: aload 5
    //   46: invokevirtual 569	java/lang/Thread:getName	()Ljava/lang/String;
    //   49: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq -31 -> 21
    //   55: new 93	java/lang/StringBuilder
    //   58: dup
    //   59: sipush 1024
    //   62: invokespecial 265	java/lang/StringBuilder:<init>	(I)V
    //   65: astore_0
    //   66: aload 4
    //   68: aload 5
    //   70: invokeinterface 574 2 0
    //   75: checkcast 576	[Ljava/lang/StackTraceElement;
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
    //   93: invokevirtual 268	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   96: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 122
    //   101: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: iload_1
    //   106: iconst_1
    //   107: iadd
    //   108: istore_1
    //   109: goto -25 -> 84
    //   112: aload_0
    //   113: ifnonnull +21 -> 134
    //   116: ldc_w 272
    //   119: areturn
    //   120: astore 4
    //   122: aload_3
    //   123: astore_0
    //   124: aload 4
    //   126: astore_3
    //   127: aload_3
    //   128: invokevirtual 237	java/lang/Exception:printStackTrace	()V
    //   131: goto -19 -> 112
    //   134: aload_0
    //   135: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
  public static java.util.Properties loadConfig(String paramString)
    throws Exception
  {
    // Byte code:
    //   0: new 336	java/util/Properties
    //   3: dup
    //   4: invokespecial 337	java/util/Properties:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aload_2
    //   13: areturn
    //   14: new 339	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 684	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 346	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   28: aload_1
    //   29: ifnull -17 -> 12
    //   32: aload_1
    //   33: invokevirtual 377	java/io/FileInputStream:close	()V
    //   36: aload_2
    //   37: areturn
    //   38: astore_0
    //   39: aconst_null
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 377	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: athrow
    //   51: astore_0
    //   52: goto -11 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString	String
    //   22	24	1	localFileInputStream	java.io.FileInputStream
    //   7	30	2	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   14	23	38	finally
    //   23	28	51	finally
  }
  
  /* Error */
  public static void saveConfig(String paramString, java.util.Properties paramProperties)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 689	java/io/FileOutputStream
    //   12: dup
    //   13: aload_0
    //   14: iconst_0
    //   15: invokespecial 691	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   18: astore_2
    //   19: aload_1
    //   20: aload_2
    //   21: ldc_w 272
    //   24: invokevirtual 695	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   27: aload_2
    //   28: ifnull -20 -> 8
    //   31: aload_2
    //   32: invokevirtual 696	java/io/FileOutputStream:close	()V
    //   35: return
    //   36: astore_0
    //   37: aconst_null
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +7 -> 47
    //   43: aload_1
    //   44: invokevirtual 696	java/io/FileOutputStream:close	()V
    //   47: aload_0
    //   48: athrow
    //   49: astore_0
    //   50: aload_2
    //   51: astore_1
    //   52: goto -13 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString	String
    //   0	55	1	paramProperties	java.util.Properties
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
    //   3: invokestatic 75	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getNewAppUinStoreFile	()Ljava/io/File;
    //   6: astore 5
    //   8: aload 5
    //   10: invokevirtual 81	java/io/File:exists	()Z
    //   13: ifeq +173 -> 186
    //   16: new 93	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   23: aload 5
    //   25: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 104
    //   33: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: astore 6
    //   42: iload_1
    //   43: ifeq +147 -> 190
    //   46: ldc 106
    //   48: astore 4
    //   50: aload 6
    //   52: aload 4
    //   54: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: astore 4
    //   62: new 77	java/io/File
    //   65: dup
    //   66: aload 4
    //   68: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: pop
    //   72: aload 5
    //   74: invokevirtual 706	java/io/File:listFiles	()[Ljava/io/File;
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
    //   103: invokevirtual 707	java/io/File:getName	()Ljava/lang/String;
    //   106: new 93	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   113: ldc 199
    //   115: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 106
    //   124: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   133: ifne +38 -> 171
    //   136: aload 6
    //   138: invokevirtual 707	java/io/File:getName	()Ljava/lang/String;
    //   141: new 93	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   148: ldc 199
    //   150: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 131
    //   159: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +29 -> 197
    //   171: aload 6
    //   173: new 77	java/io/File
    //   176: dup
    //   177: aload 4
    //   179: invokespecial 110	java/io/File:<init>	(Ljava/lang/String;)V
    //   182: invokevirtual 711	java/io/File:renameTo	(Ljava/io/File;)Z
    //   185: pop
    //   186: ldc 2
    //   188: monitorexit
    //   189: return
    //   190: ldc 131
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
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: aload_3
    //   3: invokestatic 469	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getServerConfigFile	(Ljava/lang/String;ILjava/lang/String;)Ljava/io/File;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnonnull +14 -> 22
    //   11: new 334	java/io/IOException
    //   14: dup
    //   15: ldc_w 721
    //   18: invokespecial 722	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   21: athrow
    //   22: aload_3
    //   23: invokevirtual 81	java/io/File:exists	()Z
    //   26: ifne +8 -> 34
    //   29: aload_3
    //   30: invokevirtual 113	java/io/File:createNewFile	()Z
    //   33: pop
    //   34: aload_3
    //   35: invokevirtual 81	java/io/File:exists	()Z
    //   38: ifeq +10 -> 48
    //   41: aload_3
    //   42: invokevirtual 725	java/io/File:canWrite	()Z
    //   45: ifne +34 -> 79
    //   48: new 334	java/io/IOException
    //   51: dup
    //   52: new 93	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 94	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 727
    //   62: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_3
    //   66: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 722	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   78: athrow
    //   79: aconst_null
    //   80: astore_0
    //   81: new 729	java/io/OutputStreamWriter
    //   84: dup
    //   85: new 689	java/io/FileOutputStream
    //   88: dup
    //   89: aload_3
    //   90: invokespecial 730	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   93: ldc_w 473
    //   96: invokespecial 732	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   99: astore_3
    //   100: aload_3
    //   101: astore_0
    //   102: aload_3
    //   103: aload_2
    //   104: invokevirtual 735	java/io/OutputStreamWriter:write	(Ljava/lang/String;)V
    //   107: aload_3
    //   108: astore_0
    //   109: aload_3
    //   110: invokevirtual 736	java/io/OutputStreamWriter:flush	()V
    //   113: aload_3
    //   114: ifnull +7 -> 121
    //   117: aload_3
    //   118: invokevirtual 737	java/io/OutputStreamWriter:close	()V
    //   121: return
    //   122: astore 4
    //   124: aconst_null
    //   125: astore_2
    //   126: aload_2
    //   127: astore_0
    //   128: aload 4
    //   130: invokevirtual 237	java/lang/Exception:printStackTrace	()V
    //   133: aload_2
    //   134: ifnull -13 -> 121
    //   137: aload_2
    //   138: invokevirtual 737	java/io/OutputStreamWriter:close	()V
    //   141: return
    //   142: astore_0
    //   143: return
    //   144: astore_3
    //   145: aload_0
    //   146: astore_2
    //   147: aload_3
    //   148: astore_0
    //   149: aload_2
    //   150: ifnull +7 -> 157
    //   153: aload_2
    //   154: invokevirtual 737	java/io/OutputStreamWriter:close	()V
    //   157: aload_0
    //   158: athrow
    //   159: astore_2
    //   160: goto -3 -> 157
    //   163: astore_3
    //   164: aload_0
    //   165: astore_2
    //   166: aload_3
    //   167: astore_0
    //   168: goto -19 -> 149
    //   171: astore 4
    //   173: aload_3
    //   174: astore_2
    //   175: goto -49 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramString1	String
    //   0	178	1	paramInt	int
    //   0	178	2	paramString2	String
    //   0	178	3	paramString3	String
    //   122	7	4	localException1	Exception
    //   171	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   81	100	122	java/lang/Exception
    //   117	121	142	java/io/IOException
    //   137	141	142	java/io/IOException
    //   81	100	144	finally
    //   153	157	159	java/io/IOException
    //   102	107	163	finally
    //   109	113	163	finally
    //   128	133	163	finally
    //   102	107	171	java/lang/Exception
    //   109	113	171	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.MsfSdkUtils
 * JD-Core Version:    0.7.0.1
 */