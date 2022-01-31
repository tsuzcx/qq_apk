package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.CRC32;

public class t
{
  public static final String a = "MSF.C.Util";
  public static final String b = "sp_imei";
  public static final int c = 0;
  public static final int d = 1;
  public static final int e = 2;
  public static final int f = 3;
  public static final int g = 4;
  public static long h = 0L;
  public static String i = "";
  public static String j = "";
  public static int k = 0;
  private static final int l = 60000;
  private static final int m = 1000000;
  private static final AtomicInteger n = new AtomicInteger(60000 + new Random().nextInt(100000));
  private static String o = "";
  private static String p = "";
  private static int q;
  private static int r = 0;
  private static String s = "";
  private static String t = "";
  private static String u = "";
  private static String v = "";
  private static String w = "";
  
  public static int a()
  {
    try
    {
      int i1 = n.incrementAndGet();
      if (i1 > 1000000) {
        n.set(60000 + new Random().nextInt(100000));
      }
      return i1;
    }
    finally {}
  }
  
  public static long a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext);
    paramContext = new File(paramContext + paramString);
    if (paramContext.exists()) {
      return a(paramContext);
    }
    return 0L;
  }
  
  /* Error */
  public static long a(File paramFile)
  {
    // Byte code:
    //   0: ldc2_w 130
    //   3: lstore_1
    //   4: lload_1
    //   5: lstore_3
    //   6: aload_0
    //   7: ifnull +12 -> 19
    //   10: aload_0
    //   11: invokevirtual 122	java/io/File:exists	()Z
    //   14: ifne +7 -> 21
    //   17: lload_1
    //   18: lstore_3
    //   19: lload_3
    //   20: lreturn
    //   21: new 133	java/io/FileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: astore 5
    //   31: aload 5
    //   33: astore_0
    //   34: aload 5
    //   36: invokestatic 139	com/tencent/mobileqq/msf/core/t:a	(Ljava/io/InputStream;)J
    //   39: lstore_3
    //   40: lload_3
    //   41: lstore_1
    //   42: lload_1
    //   43: lstore_3
    //   44: aload 5
    //   46: ifnull -27 -> 19
    //   49: aload 5
    //   51: invokevirtual 142	java/io/FileInputStream:close	()V
    //   54: lload_1
    //   55: lreturn
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   61: lload_1
    //   62: lreturn
    //   63: astore 6
    //   65: aconst_null
    //   66: astore 5
    //   68: aload 5
    //   70: astore_0
    //   71: aload 6
    //   73: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   76: lload_1
    //   77: lstore_3
    //   78: aload 5
    //   80: ifnull -61 -> 19
    //   83: aload 5
    //   85: invokevirtual 142	java/io/FileInputStream:close	()V
    //   88: ldc2_w 130
    //   91: lreturn
    //   92: astore_0
    //   93: goto -36 -> 57
    //   96: astore 5
    //   98: aconst_null
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 142	java/io/FileInputStream:close	()V
    //   108: aload 5
    //   110: athrow
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   116: goto -8 -> 108
    //   119: astore 5
    //   121: goto -21 -> 100
    //   124: astore 6
    //   126: goto -58 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	paramFile	File
    //   3	74	1	l1	long
    //   5	73	3	l2	long
    //   29	55	5	localFileInputStream	java.io.FileInputStream
    //   96	13	5	localObject1	Object
    //   119	1	5	localObject2	Object
    //   63	9	6	localException1	Exception
    //   124	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   49	54	56	java/io/IOException
    //   21	31	63	java/lang/Exception
    //   83	88	92	java/io/IOException
    //   21	31	96	finally
    //   104	108	111	java/io/IOException
    //   34	40	119	finally
    //   71	76	119	finally
    //   34	40	124	java/lang/Exception
  }
  
  public static long a(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[8192];
    CRC32 localCRC32 = new CRC32();
    for (;;)
    {
      int i1 = paramInputStream.read(arrayOfByte);
      if (i1 == -1) {
        break;
      }
      localCRC32.update(arrayOfByte, 0, i1);
    }
    return localCRC32.getValue();
  }
  
  public static FromServiceMsg a(ToServiceMsg paramToServiceMsg)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.setAppId(paramToServiceMsg.getAppId());
    localFromServiceMsg.setAppSeq(paramToServiceMsg.getAppSeq());
    localFromServiceMsg.setRequestSsoSeq(paramToServiceMsg.getRequestSsoSeq());
    localFromServiceMsg.setMsfCommand(paramToServiceMsg.getMsfCommand());
    localFromServiceMsg.addAttribute("to_SenderProcessName", paramToServiceMsg.getAttribute("to_SenderProcessName"));
    localFromServiceMsg.addAttribute("__timestamp_net2msf", Long.valueOf(System.currentTimeMillis()));
    return localFromServiceMsg;
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      String str = paramContext.getFilesDir().getParent();
      return str;
    }
    catch (Exception localException)
    {
      try
      {
        if ((paramContext instanceof ContextWrapper)) {}
        Object localObject;
        for (paramContext = ((ContextWrapper)paramContext).getBaseContext();; paramContext = ((Field)localObject).get(paramContext))
        {
          localObject = paramContext.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
          ((Method)localObject).setAccessible(true);
          return ((File)((Method)localObject).invoke(paramContext, new Object[0])).getAbsolutePath();
          localObject = ContextWrapper.class.getDeclaredField("mBase");
          ((Field)localObject).setAccessible(true);
        }
        return null;
      }
      catch (Throwable paramContext) {}
    }
  }
  
  /* Error */
  private static void a(File paramFile, List paramList)
  {
    // Byte code:
    //   0: new 284	java/util/Properties
    //   3: dup
    //   4: invokespecial 285	java/util/Properties:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: invokevirtual 122	java/io/File:exists	()Z
    //   12: ifne +8 -> 20
    //   15: aload_0
    //   16: invokevirtual 288	java/io/File:createNewFile	()Z
    //   19: pop
    //   20: aload_1
    //   21: invokeinterface 294 1 0
    //   26: astore_2
    //   27: aload_2
    //   28: invokeinterface 299 1 0
    //   33: ifeq +103 -> 136
    //   36: aload_2
    //   37: invokeinterface 303 1 0
    //   42: checkcast 305	com/tencent/qphone/base/remote/SimpleAccount
    //   45: astore_1
    //   46: aload_3
    //   47: aload_1
    //   48: invokevirtual 306	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   51: aload_1
    //   52: invokevirtual 309	com/tencent/qphone/base/remote/SimpleAccount:toStoreString	()Ljava/lang/String;
    //   55: invokevirtual 313	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   58: pop
    //   59: goto -32 -> 27
    //   62: astore_3
    //   63: aconst_null
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: invokestatic 318	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   70: ifeq +45 -> 115
    //   73: aload_2
    //   74: astore_1
    //   75: ldc 8
    //   77: iconst_2
    //   78: new 106	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 320
    //   88: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: invokevirtual 323	java/io/File:getName	()Ljava/lang/String;
    //   95: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: ldc_w 325
    //   101: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_3
    //   105: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aload_3
    //   112: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   115: iconst_0
    //   116: ifeq +11 -> 127
    //   119: new 333	java/lang/NullPointerException
    //   122: dup
    //   123: invokespecial 334	java/lang/NullPointerException:<init>	()V
    //   126: athrow
    //   127: aload_2
    //   128: ifnull +7 -> 135
    //   131: aload_2
    //   132: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   135: return
    //   136: new 336	java/io/FileOutputStream
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 338	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   144: astore_2
    //   145: aload_2
    //   146: astore_1
    //   147: aload_3
    //   148: aload_2
    //   149: ldc 67
    //   151: invokevirtual 342	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   154: aload_2
    //   155: astore_1
    //   156: aload_2
    //   157: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   160: aload_2
    //   161: astore_1
    //   162: ldc 8
    //   164: iconst_1
    //   165: new 106	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   172: ldc_w 344
    //   175: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_0
    //   179: invokevirtual 323	java/io/File:getName	()Ljava/lang/String;
    //   182: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 347	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: iconst_0
    //   192: ifeq +11 -> 203
    //   195: new 333	java/lang/NullPointerException
    //   198: dup
    //   199: invokespecial 334	java/lang/NullPointerException:<init>	()V
    //   202: athrow
    //   203: aload_2
    //   204: ifnull -69 -> 135
    //   207: aload_2
    //   208: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   211: return
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   217: return
    //   218: astore_0
    //   219: aconst_null
    //   220: astore_1
    //   221: iconst_0
    //   222: ifeq +11 -> 233
    //   225: new 333	java/lang/NullPointerException
    //   228: dup
    //   229: invokespecial 334	java/lang/NullPointerException:<init>	()V
    //   232: athrow
    //   233: aload_1
    //   234: ifnull +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 337	java/io/FileOutputStream:close	()V
    //   241: aload_0
    //   242: athrow
    //   243: astore_2
    //   244: aload_2
    //   245: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   248: goto -15 -> 233
    //   251: astore_1
    //   252: aload_1
    //   253: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   256: goto -15 -> 241
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   264: goto -137 -> 127
    //   267: astore_0
    //   268: goto -55 -> 213
    //   271: astore_0
    //   272: aload_0
    //   273: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   276: goto -73 -> 203
    //   279: astore_0
    //   280: goto -59 -> 221
    //   283: astore_3
    //   284: goto -219 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramFile	File
    //   0	287	1	paramList	List
    //   26	182	2	localObject	Object
    //   243	2	2	localIOException	IOException
    //   7	40	3	localProperties	Properties
    //   62	86	3	localException1	Exception
    //   283	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	20	62	java/lang/Exception
    //   20	27	62	java/lang/Exception
    //   27	59	62	java/lang/Exception
    //   136	145	62	java/lang/Exception
    //   207	211	212	java/io/IOException
    //   8	20	218	finally
    //   20	27	218	finally
    //   27	59	218	finally
    //   136	145	218	finally
    //   225	233	243	java/io/IOException
    //   237	241	251	java/io/IOException
    //   119	127	259	java/io/IOException
    //   131	135	267	java/io/IOException
    //   195	203	271	java/io/IOException
    //   67	73	279	finally
    //   75	115	279	finally
    //   147	154	279	finally
    //   156	160	279	finally
    //   162	191	279	finally
    //   147	154	283	java/lang/Exception
    //   156	160	283	java/lang/Exception
    //   162	191	283	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    Object localObject = new File(MsfCore.getIMEIPath());
    try
    {
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      if (((File)localObject).exists())
      {
        localObject = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath());
        ((Properties)localObject).put("imei", paramString);
        MsfSdkUtils.saveConfig(MsfCore.getIMEIPath(), (Properties)localObject);
        return;
      }
      QLog.d("MSF.C.Util", 1, "can not create imei file");
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("MSF.C.Util", 1, "save sys imei error", paramString);
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    h = paramLong;
    i = paramString1;
    j = paramString2;
  }
  
  private static void a(String paramString, List paramList)
  {
    int i1 = 1;
    for (;;)
    {
      if (i1 != 0)
      {
        Iterator localIterator = paramList.iterator();
        i1 = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label64;
          }
          if (((SimpleAccount)localIterator.next()).getUin().equals(paramString))
          {
            paramList.remove(i1);
            i1 = 1;
            break;
          }
          i1 += 1;
        }
      }
      return;
      label64:
      i1 = 0;
    }
  }
  
  public static String b()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i1 = 0;
    while (i1 < 12)
    {
      str = str + String.valueOf(localRandom.nextInt(10));
      i1 += 1;
    }
    return str;
  }
  
  public static String b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg.getAttributes().get("to_SenderProcessName") != null) {
      return (String)paramToServiceMsg.getAttributes().get("to_SenderProcessName");
    }
    return "";
  }
  
  public static void c()
  {
    for (;;)
    {
      try
      {
        localObject1 = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
      }
      catch (Exception localException4)
      {
        Object localObject1;
        Object localObject3;
        Object localObject5;
        Object localObject2 = null;
        continue;
        Object localObject4 = null;
        continue;
        localObject2 = null;
        continue;
      }
      try
      {
        localObject3 = ((TelephonyManager)localObject1).getSubscriberId();
        if (localObject3 != null)
        {
          t = (String)localObject3;
          u = (String)localObject3;
        }
        localObject3 = ((TelephonyManager)localObject1).getNetworkOperatorName();
        if (localObject3 != null) {
          w = (String)localObject3;
        }
        o = ((TelephonyManager)localObject1).getNetworkCountryIso();
        p = ((TelephonyManager)localObject1).getSimCountryIso();
        localObject3 = ((TelephonyManager)localObject1).getCellLocation();
        if (!(localObject3 instanceof CdmaCellLocation)) {
          continue;
        }
        localObject3 = (CdmaCellLocation)((TelephonyManager)localObject1).getCellLocation();
        localObject5 = localObject1;
        if (localObject3 != null)
        {
          q = ((CdmaCellLocation)localObject3).getBaseStationId();
          localObject5 = localObject1;
        }
      }
      catch (Exception localException3)
      {
        try
        {
          k = 0;
          if (!new File(MsfCore.getIMEIPath()).exists()) {
            continue;
          }
          localObject3 = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath()).getProperty("imei");
          if (localObject3 != null)
          {
            localObject1 = localObject3;
            if (((String)localObject3).length() != 0) {}
          }
          else
          {
            Thread.sleep(200L);
            localObject1 = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath()).getProperty("imei", null);
          }
          k = 1;
          localObject3 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.Util", 2, "read imei from file " + MsfCore.getIMEIPath() + ", imei:" + (String)localObject1);
            localObject3 = localObject1;
          }
          localSharedPreferences = BaseApplication.getContext().getSharedPreferences("MSF.C.Util", 0);
          if ((localObject3 != null) && (((String)localObject3).length() != 0)) {
            continue;
          }
          localObject3 = localSharedPreferences.getString("sp_imei", null);
          if (QLog.isColorLevel()) {
            QLog.d("MSF.C.Util", 2, "read imei from sharepreference:" + (String)localObject3);
          }
          if (localObject3 != null)
          {
            i1 = ((String)localObject3).length();
            if (i1 != 0) {
              continue;
            }
          }
          if (localObject5 == null) {
            continue;
          }
        }
        catch (Exception localException1)
        {
          QLog.d("MSF.C.Util", 1, "read sys imei error " + localException1, localException1);
          continue;
          k = 2;
          continue;
          k = 1;
          continue;
        }
        try
        {
          if (Build.VERSION.SDK_INT > 28)
          {
            localObject1 = Settings.System.getString(BaseApplication.getContext().getContentResolver(), "android_id");
            if ((localObject1 == null) || (((String)localObject1).length() <= 0)) {
              continue;
            }
            k = 3;
            localObject3 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.d("MSF.C.Util", 2, "read sys imei:" + (String)localObject1);
              localObject3 = localObject1;
            }
            a((String)localObject3);
            localObject1 = localSharedPreferences.edit();
            ((SharedPreferences.Editor)localObject1).putString("sp_imei", (String)localObject3);
            ((SharedPreferences.Editor)localObject1).commit();
            s = (String)localObject3;
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.Util", 1, "save imei:" + s + ",with order:" + k);
            }
            v = "testrevision";
          }
        }
        catch (SecurityException localSecurityException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
        }
        try
        {
          localObject1 = BaseApplication.getContext().getAssets().open("revision.txt");
          try
          {
            localObject3 = new byte[64];
            i1 = ((InputStream)localObject1).read((byte[])localObject3, 0, 64);
            if (i1 != -1)
            {
              v = new String((byte[])localObject3, 0, i1);
              if (QLog.isColorLevel()) {
                QLog.d("MSF.C.Util", 2, "revision:" + v);
              }
            }
            return;
          }
          catch (IOException localIOException)
          {
            QLog.d("MSF.C.Util", 1, "get revision IOException " + localIOException.getMessage());
            return;
          }
          localObject5 = localObject1;
          if (!(localObject3 instanceof GsmCellLocation)) {
            continue;
          }
          localObject3 = (GsmCellLocation)((TelephonyManager)localObject1).getCellLocation();
          localObject5 = localObject1;
          if (localObject3 == null) {
            continue;
          }
          q = ((GsmCellLocation)localObject3).getCid();
          localObject5 = localObject1;
        }
        catch (Exception localException2)
        {
          QLog.d("MSF.C.Util", 1, "get revision error " + localException2.getMessage());
          return;
        }
        localException3 = localException3;
        QLog.d("MSF.C.Util", 1, "get imsi error " + localException3, localException3);
        localObject5 = localObject1;
        continue;
        if (t.length() <= 5) {
          continue;
        }
        t = t.substring(0, 5);
        continue;
        if (Build.VERSION.SDK_INT >= 26) {
          continue;
        }
        localObject1 = localObject5.getDeviceId();
        continue;
        localObject1 = localObject5.getImei();
      }
    }
    if (t == null)
    {
      t = "";
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.Util", 2, "imsi:" + t + " networkOperatorName:" + w);
      }
    }
    for (;;)
    {
      SharedPreferences localSharedPreferences;
      int i1;
      QLog.d("MSF.C.Util", 2, "read sys imei SecurityException=", localSecurityException);
      break;
      String str1 = m();
      k = 4;
      String str2 = str1;
      if (QLog.isColorLevel())
      {
        QLog.d("MSF.C.Util", 2, "load imei:" + str1);
        str2 = str1;
      }
    }
  }
  
  public static String d()
  {
    return s;
  }
  
  public static String e()
  {
    return t;
  }
  
  public static String f()
  {
    return u;
  }
  
  public static String g()
  {
    return v;
  }
  
  public static int h()
  {
    return r;
  }
  
  public static String i()
  {
    return o;
  }
  
  public static String j()
  {
    return p;
  }
  
  public static int k()
  {
    return q;
  }
  
  public static String l()
  {
    return w;
  }
  
  public static String m()
  {
    String str1 = null;
    Object localObject = new File(MsfCore.getIMEIPath());
    StringBuffer localStringBuffer;
    String str2;
    try
    {
      if (((File)localObject).exists()) {
        str1 = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath()).getProperty("imei");
      }
      if (str1 != null)
      {
        i1 = str1.length();
        if (i1 > 0) {
          return str1;
        }
      }
    }
    catch (Exception localException1)
    {
      QLog.d("MSF.C.Util", 1, "load sys imei error", localException1);
      localStringBuffer = new StringBuffer();
      int i1 = 0;
      while (i1 < 15)
      {
        localStringBuffer.append(new Random().nextInt(10));
        i1 += 1;
      }
      str2 = localStringBuffer.toString();
    }
    for (;;)
    {
      try
      {
        if (!((File)localObject).exists()) {
          ((File)localObject).createNewFile();
        }
        if (!((File)localObject).exists()) {
          continue;
        }
        localObject = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath());
        ((Properties)localObject).put("imei", str2);
        MsfSdkUtils.saveConfig(MsfCore.getIMEIPath(), (Properties)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("MSF.C.Util", 2, "write imei " + str2);
        }
      }
      catch (Exception localException2)
      {
        QLog.d("MSF.C.Util", 1, "load imei error", localException2);
        continue;
      }
      return localStringBuffer.toString();
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.Util", 2, "can not create imei file");
      }
    }
  }
  
  public static String n()
  {
    try
    {
      NetworkInterface localNetworkInterface;
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          do
          {
            if ((localObject == null) || (!((Enumeration)localObject).hasMoreElements())) {
              break;
            }
            localNetworkInterface = (NetworkInterface)((Enumeration)localObject).nextElement();
          } while (localNetworkInterface == null);
          localEnumeration = localNetworkInterface.getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while ((localInetAddress == null) || (localInetAddress.isLoopbackAddress()) || (localInetAddress.isAnyLocalAddress()) || (localInetAddress.isLinkLocalAddress()));
      Object localObject = localNetworkInterface.getName() + ":" + localInetAddress.getHostAddress();
      return localObject;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("MSF.C.Util", 2, "getDeviceIp error " + localException.toString(), localException);
      }
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.t
 * JD-Core Version:    0.7.0.1
 */