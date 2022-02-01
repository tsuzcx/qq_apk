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

public class o
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
  private static final AtomicInteger n = new AtomicInteger(new Random().nextInt(100000) + 60000);
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
        n.set(new Random().nextInt(100000) + 60000);
      }
      return i1;
    }
    finally {}
  }
  
  public static long a(Context paramContext, String paramString)
  {
    paramContext = a(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(paramString);
    paramContext = new File(localStringBuilder.toString());
    if (paramContext.exists()) {
      return a(paramContext);
    }
    return 0L;
  }
  
  /* Error */
  public static long a(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +116 -> 117
    //   4: aload_0
    //   5: invokevirtual 122	java/io/File:exists	()Z
    //   8: ifne +7 -> 15
    //   11: ldc2_w 130
    //   14: lreturn
    //   15: aconst_null
    //   16: astore 5
    //   18: aconst_null
    //   19: astore_3
    //   20: new 133	java/io/FileInputStream
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   28: astore_0
    //   29: aload_0
    //   30: invokestatic 139	com/tencent/mobileqq/msf/core/o:a	(Ljava/io/InputStream;)J
    //   33: lstore_1
    //   34: aload_0
    //   35: invokevirtual 142	java/io/FileInputStream:close	()V
    //   38: lload_1
    //   39: lreturn
    //   40: astore_0
    //   41: aload_0
    //   42: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   45: lload_1
    //   46: lreturn
    //   47: astore 4
    //   49: aload_0
    //   50: astore_3
    //   51: aload 4
    //   53: astore_0
    //   54: goto +45 -> 99
    //   57: astore 4
    //   59: goto +12 -> 71
    //   62: astore_0
    //   63: goto +36 -> 99
    //   66: astore 4
    //   68: aload 5
    //   70: astore_0
    //   71: aload_0
    //   72: astore_3
    //   73: aload 4
    //   75: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   78: aload_0
    //   79: ifnull +16 -> 95
    //   82: aload_0
    //   83: invokevirtual 142	java/io/FileInputStream:close	()V
    //   86: ldc2_w 130
    //   89: lreturn
    //   90: astore_0
    //   91: aload_0
    //   92: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   95: ldc2_w 130
    //   98: lreturn
    //   99: aload_3
    //   100: ifnull +15 -> 115
    //   103: aload_3
    //   104: invokevirtual 142	java/io/FileInputStream:close	()V
    //   107: goto +8 -> 115
    //   110: astore_3
    //   111: aload_3
    //   112: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   115: aload_0
    //   116: athrow
    //   117: ldc2_w 130
    //   120: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramFile	File
    //   33	13	1	l1	long
    //   19	85	3	localFile	File
    //   110	2	3	localIOException	IOException
    //   47	5	4	localObject1	Object
    //   57	1	4	localException1	Exception
    //   66	8	4	localException2	Exception
    //   16	53	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	38	40	java/io/IOException
    //   29	34	47	finally
    //   29	34	57	java/lang/Exception
    //   20	29	62	finally
    //   73	78	62	finally
    //   20	29	66	java/lang/Exception
    //   82	86	90	java/io/IOException
    //   103	107	110	java/io/IOException
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
      localObject = paramContext.getFilesDir().getParent();
      return localObject;
    }
    catch (Exception localException)
    {
      Object localObject;
      label10:
      label85:
      break label10;
    }
    try
    {
      if ((paramContext instanceof ContextWrapper))
      {
        paramContext = ((ContextWrapper)paramContext).getBaseContext();
      }
      else
      {
        localObject = ContextWrapper.class.getDeclaredField("mBase");
        ((Field)localObject).setAccessible(true);
        paramContext = ((Field)localObject).get(paramContext);
      }
      localObject = paramContext.getClass().getDeclaredMethod("getDataDirFile", new Class[0]);
      ((Method)localObject).setAccessible(true);
      paramContext = ((File)((Method)localObject).invoke(paramContext, new Object[0])).getAbsolutePath();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      break label85;
    }
    return null;
  }
  
  /* Error */
  private static void a(File paramFile, List paramList)
  {
    // Byte code:
    //   0: new 284	java/util/Properties
    //   3: dup
    //   4: invokespecial 285	java/util/Properties:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: aload_0
    //   17: invokevirtual 122	java/io/File:exists	()Z
    //   20: ifne +10 -> 30
    //   23: aload_3
    //   24: astore_2
    //   25: aload_0
    //   26: invokevirtual 288	java/io/File:createNewFile	()Z
    //   29: pop
    //   30: aload_3
    //   31: astore_2
    //   32: aload_1
    //   33: invokeinterface 294 1 0
    //   38: astore_1
    //   39: aload_3
    //   40: astore_2
    //   41: aload_1
    //   42: invokeinterface 299 1 0
    //   47: ifeq +37 -> 84
    //   50: aload_3
    //   51: astore_2
    //   52: aload_1
    //   53: invokeinterface 303 1 0
    //   58: checkcast 305	com/tencent/qphone/base/remote/SimpleAccount
    //   61: astore 6
    //   63: aload_3
    //   64: astore_2
    //   65: aload 5
    //   67: aload 6
    //   69: invokevirtual 306	com/tencent/qphone/base/remote/SimpleAccount:getUin	()Ljava/lang/String;
    //   72: aload 6
    //   74: invokevirtual 309	com/tencent/qphone/base/remote/SimpleAccount:toStoreString	()Ljava/lang/String;
    //   77: invokevirtual 313	java/util/Properties:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   80: pop
    //   81: goto -42 -> 39
    //   84: aload_3
    //   85: astore_2
    //   86: new 315	java/io/FileOutputStream
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 316	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   94: astore_1
    //   95: aload 5
    //   97: aload_1
    //   98: ldc 67
    //   100: invokevirtual 320	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   103: aload_1
    //   104: invokevirtual 321	java/io/FileOutputStream:close	()V
    //   107: new 104	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   114: astore_2
    //   115: aload_2
    //   116: ldc_w 323
    //   119: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_2
    //   124: aload_0
    //   125: invokevirtual 326	java/io/File:getName	()Ljava/lang/String;
    //   128: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: ldc 8
    //   134: iconst_1
    //   135: aload_2
    //   136: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 331	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_1
    //   143: invokevirtual 321	java/io/FileOutputStream:close	()V
    //   146: return
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   152: return
    //   153: astore_0
    //   154: aload_1
    //   155: astore_2
    //   156: goto +100 -> 256
    //   159: astore_3
    //   160: goto +11 -> 171
    //   163: astore_0
    //   164: goto +92 -> 256
    //   167: astore_3
    //   168: aload 4
    //   170: astore_1
    //   171: aload_1
    //   172: astore_2
    //   173: invokestatic 334	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +71 -> 247
    //   179: aload_1
    //   180: astore_2
    //   181: new 104	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   188: astore 4
    //   190: aload_1
    //   191: astore_2
    //   192: aload 4
    //   194: ldc_w 336
    //   197: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_1
    //   202: astore_2
    //   203: aload 4
    //   205: aload_0
    //   206: invokevirtual 326	java/io/File:getName	()Ljava/lang/String;
    //   209: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_1
    //   214: astore_2
    //   215: aload 4
    //   217: ldc_w 338
    //   220: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: astore_2
    //   226: aload 4
    //   228: aload_3
    //   229: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_1
    //   234: astore_2
    //   235: ldc 8
    //   237: iconst_2
    //   238: aload 4
    //   240: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: aload_3
    //   244: invokestatic 344	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   247: aload_1
    //   248: ifnull +7 -> 255
    //   251: aload_1
    //   252: invokevirtual 321	java/io/FileOutputStream:close	()V
    //   255: return
    //   256: aload_2
    //   257: ifnull +15 -> 272
    //   260: aload_2
    //   261: invokevirtual 321	java/io/FileOutputStream:close	()V
    //   264: goto +8 -> 272
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 145	java/io/IOException:printStackTrace	()V
    //   272: goto +5 -> 277
    //   275: aload_0
    //   276: athrow
    //   277: goto -2 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramFile	File
    //   0	280	1	paramList	List
    //   15	246	2	localObject1	Object
    //   13	72	3	localObject2	Object
    //   159	1	3	localException1	Exception
    //   167	77	3	localException2	Exception
    //   10	229	4	localStringBuilder	StringBuilder
    //   7	89	5	localProperties	Properties
    //   61	12	6	localSimpleAccount	SimpleAccount
    // Exception table:
    //   from	to	target	type
    //   142	146	147	java/io/IOException
    //   251	255	147	java/io/IOException
    //   95	142	153	finally
    //   95	142	159	java/lang/Exception
    //   16	23	163	finally
    //   25	30	163	finally
    //   32	39	163	finally
    //   41	50	163	finally
    //   52	63	163	finally
    //   65	81	163	finally
    //   86	95	163	finally
    //   173	179	163	finally
    //   181	190	163	finally
    //   192	201	163	finally
    //   203	213	163	finally
    //   215	224	163	finally
    //   226	233	163	finally
    //   235	247	163	finally
    //   16	23	167	java/lang/Exception
    //   25	30	167	java/lang/Exception
    //   32	39	167	java/lang/Exception
    //   41	50	167	java/lang/Exception
    //   52	63	167	java/lang/Exception
    //   65	81	167	java/lang/Exception
    //   86	95	167	java/lang/Exception
    //   260	264	267	java/io/IOException
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
    label61:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        return;
      }
      Iterator localIterator = paramList.iterator();
      i1 = 0;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label61;
        }
        if (((SimpleAccount)localIterator.next()).getUin().equals(paramString))
        {
          paramList.remove(i1);
          break;
        }
        i1 += 1;
      }
    }
  }
  
  public static String b()
  {
    Random localRandom = new Random(System.currentTimeMillis());
    String str = "---------";
    int i1 = 0;
    while (i1 < 12)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.valueOf(localRandom.nextInt(10)));
      str = localStringBuilder.toString();
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
    Object localObject8 = null;
    try
    {
      localObject1 = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
      try
      {
        Object localObject4 = ((TelephonyManager)localObject1).getSubscriberId();
        if (localObject4 != null)
        {
          t = (String)localObject4;
          u = (String)localObject4;
        }
        localObject4 = ((TelephonyManager)localObject1).getNetworkOperatorName();
        if (localObject4 != null) {
          w = (String)localObject4;
        }
        o = ((TelephonyManager)localObject1).getNetworkCountryIso();
        p = ((TelephonyManager)localObject1).getSimCountryIso();
        localObject4 = ((TelephonyManager)localObject1).getCellLocation();
        if ((localObject4 instanceof CdmaCellLocation))
        {
          localObject4 = (CdmaCellLocation)((TelephonyManager)localObject1).getCellLocation();
          localObject7 = localObject1;
          if (localObject4 != null)
          {
            q = ((CdmaCellLocation)localObject4).getBaseStationId();
            localObject7 = localObject1;
          }
        }
        else
        {
          localObject7 = localObject1;
          if ((localObject4 instanceof GsmCellLocation))
          {
            localObject4 = (GsmCellLocation)((TelephonyManager)localObject1).getCellLocation();
            localObject7 = localObject1;
            if (localObject4 != null)
            {
              q = ((GsmCellLocation)localObject4).getCid();
              localObject7 = localObject1;
            }
          }
        }
      }
      catch (Exception localException3) {}
      localObject7 = new StringBuilder();
    }
    catch (Exception localException4)
    {
      localObject1 = null;
    }
    ((StringBuilder)localObject7).append("get imsi error ");
    ((StringBuilder)localObject7).append(localException4);
    QLog.d("MSF.C.Util", 1, ((StringBuilder)localObject7).toString(), localException4);
    Object localObject7 = localObject1;
    Object localObject1 = t;
    if (localObject1 == null) {
      t = "";
    } else if (((String)localObject1).length() > 5) {
      t = t.substring(0, 5);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("imsi:");
      ((StringBuilder)localObject1).append(t);
      ((StringBuilder)localObject1).append(" networkOperatorName:");
      ((StringBuilder)localObject1).append(w);
      QLog.d("MSF.C.Util", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      int i1;
      try
      {
        k = 0;
        if (!new File(MsfCore.getIMEIPath()).exists()) {
          break label981;
        }
        localObject1 = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath()).getProperty("imei");
        if (localObject1 != null) {
          if (((String)localObject1).length() != 0) {
            break label978;
          }
        }
        Thread.sleep(200L);
        localObject1 = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath()).getProperty("imei", null);
        k = 1;
        Object localObject5 = localObject1;
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("read imei from file ");
          ((StringBuilder)localObject5).append(MsfCore.getIMEIPath());
          ((StringBuilder)localObject5).append(", imei:");
          ((StringBuilder)localObject5).append((String)localObject1);
          QLog.d("MSF.C.Util", 2, ((StringBuilder)localObject5).toString());
          localObject5 = localObject1;
        }
        SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("MSF.C.Util", 0);
        if ((localObject5 != null) && (((String)localObject5).length() != 0))
        {
          k = 1;
          localObject1 = localObject5;
        }
        else
        {
          localObject1 = localSharedPreferences.getString("sp_imei", null);
          if (QLog.isColorLevel())
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("read imei from sharepreference:");
            ((StringBuilder)localObject5).append((String)localObject1);
            QLog.d("MSF.C.Util", 2, ((StringBuilder)localObject5).toString());
          }
          if (localObject1 != null)
          {
            i1 = ((String)localObject1).length();
            if (i1 != 0) {}
          }
          else if (localObject7 != null)
          {
            try
            {
              if (Build.VERSION.SDK_INT > 28) {
                localObject1 = Settings.System.getString(BaseApplication.getContext().getContentResolver(), "android_id");
              } else if (Build.VERSION.SDK_INT < 26) {
                localObject1 = ((TelephonyManager)localObject7).getDeviceId();
              } else {
                localObject1 = ((TelephonyManager)localObject7).getImei();
              }
            }
            catch (SecurityException localSecurityException)
            {
              localObject1 = localObject8;
              if (QLog.isColorLevel())
              {
                QLog.d("MSF.C.Util", 2, "read sys imei SecurityException=", localSecurityException);
                localObject1 = localObject8;
              }
            }
            if ((localObject1 != null) && (((String)localObject1).length() > 0))
            {
              k = 3;
              localObject6 = localObject1;
              if (!QLog.isColorLevel()) {
                break label986;
              }
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("read sys imei:");
              ((StringBuilder)localObject6).append((String)localObject1);
              QLog.d("MSF.C.Util", 2, ((StringBuilder)localObject6).toString());
              localObject6 = localObject1;
              break label986;
            }
            localObject1 = m();
            k = 4;
            localObject6 = localObject1;
            if (!QLog.isColorLevel()) {
              break label986;
            }
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("load imei:");
            ((StringBuilder)localObject6).append((String)localObject1);
            QLog.d("MSF.C.Util", 2, ((StringBuilder)localObject6).toString());
            localObject6 = localObject1;
            break label986;
          }
          k = 2;
          a((String)localObject1);
        }
        localObject6 = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject6).putString("sp_imei", (String)localObject1);
        ((SharedPreferences.Editor)localObject6).commit();
        s = (String)localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("save imei:");
          ((StringBuilder)localObject1).append(s);
          ((StringBuilder)localObject1).append(",with order:");
          ((StringBuilder)localObject1).append(k);
          QLog.d("MSF.C.Util", 1, ((StringBuilder)localObject1).toString());
        }
      }
      catch (Exception localException1)
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("read sys imei error ");
        ((StringBuilder)localObject6).append(localException1);
        QLog.d("MSF.C.Util", 1, ((StringBuilder)localObject6).toString(), localException1);
      }
      v = "testrevision";
      try
      {
        Object localObject2 = BaseApplication.getContext().getAssets().open("revision.txt");
        try
        {
          localObject6 = new byte[64];
          i1 = ((InputStream)localObject2).read((byte[])localObject6, 0, 64);
          if (i1 != -1)
          {
            v = new String((byte[])localObject6, 0, i1);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("revision:");
              ((StringBuilder)localObject2).append(v);
              QLog.d("MSF.C.Util", 2, ((StringBuilder)localObject2).toString());
              return;
            }
          }
        }
        catch (IOException localIOException)
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("get revision IOException ");
          ((StringBuilder)localObject6).append(localIOException.getMessage());
          QLog.d("MSF.C.Util", 1, ((StringBuilder)localObject6).toString());
          return;
        }
        return;
      }
      catch (Exception localException2)
      {
        localObject6 = new StringBuilder();
        ((StringBuilder)localObject6).append("get revision error ");
        ((StringBuilder)localObject6).append(localException2.getMessage());
        QLog.d("MSF.C.Util", 1, ((StringBuilder)localObject6).toString());
      }
      label978:
      continue;
      label981:
      Object localObject6 = null;
      continue;
      label986:
      Object localObject3 = localObject6;
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
    Object localObject = new File(MsfCore.getIMEIPath());
    for (;;)
    {
      try
      {
        if (((File)localObject).exists())
        {
          String str1 = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath()).getProperty("imei");
          if (str1 != null)
          {
            i1 = str1.length();
            if (i1 > 0) {
              return str1;
            }
          }
        }
      }
      catch (Exception localException1)
      {
        QLog.d("MSF.C.Util", 1, "load sys imei error", localException1);
        localStringBuffer = new StringBuffer();
        int i1 = 0;
        if (i1 < 15)
        {
          localStringBuffer.append(new Random().nextInt(10));
          i1 += 1;
          continue;
        }
        String str2 = localStringBuffer.toString();
        try
        {
          if (!((File)localObject).exists()) {
            ((File)localObject).createNewFile();
          }
          if (((File)localObject).exists())
          {
            localObject = MsfSdkUtils.loadConfig(MsfCore.getIMEIPath());
            ((Properties)localObject).put("imei", str2);
            MsfSdkUtils.saveConfig(MsfCore.getIMEIPath(), (Properties)localObject);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("write imei ");
              ((StringBuilder)localObject).append(str2);
              QLog.d("MSF.C.Util", 2, ((StringBuilder)localObject).toString());
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("MSF.C.Util", 2, "can not create imei file");
          }
        }
        catch (Exception localException2)
        {
          QLog.d("MSF.C.Util", 1, "load imei error", localException2);
        }
        return localStringBuffer.toString();
      }
      StringBuffer localStringBuffer = null;
    }
  }
  
  public static String n()
  {
    try
    {
      do
      {
        localObject3 = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          do
          {
            if ((localObject3 == null) || (!((Enumeration)localObject3).hasMoreElements())) {
              break;
            }
            localObject1 = (NetworkInterface)((Enumeration)localObject3).nextElement();
          } while (localObject1 == null);
          localEnumeration = ((NetworkInterface)localObject1).getInetAddresses();
        }
        localObject2 = (InetAddress)localEnumeration.nextElement();
      } while ((localObject2 == null) || (((InetAddress)localObject2).isLoopbackAddress()) || (((InetAddress)localObject2).isAnyLocalAddress()) || (((InetAddress)localObject2).isLinkLocalAddress()));
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((NetworkInterface)localObject1).getName());
      ((StringBuilder)localObject3).append(":");
      ((StringBuilder)localObject3).append(((InetAddress)localObject2).getHostAddress());
      Object localObject1 = ((StringBuilder)localObject3).toString();
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getDeviceIp error ");
        ((StringBuilder)localObject2).append(localException.toString());
        QLog.w("MSF.C.Util", 2, ((StringBuilder)localObject2).toString(), localException);
      }
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.o
 * JD-Core Version:    0.7.0.1
 */