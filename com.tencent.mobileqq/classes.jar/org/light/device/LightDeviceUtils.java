package org.light.device;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.StatFs;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.light.thread.HandlerThreadManager;
import org.light.thread.HandlerThreadTag;
import org.light.utils.LightLogUtil;

public class LightDeviceUtils
{
  private static final int MIN_OPENGL_ES_VERSION = 131072;
  public static final int MIN_STORAGE_SIZE = 52428800;
  public static final int MOBILE_NETWORK_2G = 1;
  public static final int MOBILE_NETWORK_3G = 2;
  public static final int MOBILE_NETWORK_4G = 3;
  public static final int MOBILE_NETWORK_DISCONNECT = 5;
  public static final int MOBILE_NETWORK_UNKNOWN = 4;
  public static final int NET_2G = 2;
  public static final int NET_3G = 3;
  public static final int NET_4G = 4;
  public static final int NET_NONE = 0;
  public static final int NET_OTHER = 5;
  public static final int NET_WIFI = 1;
  public static final int RECORD_CPU_INTERVAL = 100;
  private static final String TAG = "LightDeviceUtils";
  private static float cpuRate = 0.0F;
  public static Handler handler;
  public static HandlerThread handlerThread;
  private static long lastCpuIdleTime = 0L;
  private static long lastCpuTotalTime = 0L;
  private static boolean mIsAllUnusable = false;
  private static boolean mIsOpenGlEsValid = true;
  public static int openGLESVersion = 65536;
  private static int recordCpuCount;
  private static int sCpuCount;
  private static String sCpuName;
  private static long sMaxCpuFreq;
  private static int sTotalMemory;
  
  public static boolean canWriteFile(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str;
    if (!paramBoolean)
    {
      str = paramString;
      if (!paramString.endsWith(File.separator)) {}
    }
    else
    {
      int i = paramString.lastIndexOf(File.separator);
      str = paramString;
      if (i > -1) {
        str = paramString.substring(0, i);
      }
    }
    paramString = new StringBuilder();
    paramString.append(str);
    paramString.append(File.separator);
    paramString.append("test_temp.txt");
    paramString = new File(paramString.toString());
    try
    {
      if (!paramString.getParentFile().exists()) {
        paramString.getParentFile().mkdirs();
      }
      if (paramString.exists()) {
        paramString.delete();
      }
      paramString.createNewFile();
      paramString.delete();
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  private static int extractValue(byte[] paramArrayOfByte, int paramInt)
  {
    while ((paramInt < paramArrayOfByte.length) && (paramArrayOfByte[paramInt] != 10))
    {
      if ((paramArrayOfByte[paramInt] >= 48) && (paramArrayOfByte[paramInt] <= 57))
      {
        int i = paramInt + 1;
        while ((i < paramArrayOfByte.length) && (paramArrayOfByte[i] >= 48) && (paramArrayOfByte[i] <= 57)) {
          i += 1;
        }
        return Integer.parseInt(new String(paramArrayOfByte, 0, paramInt, i - paramInt));
      }
      paramInt += 1;
    }
    return -1;
  }
  
  /* Error */
  private static String fetchExternalIpProviderHTML(String paramString)
  {
    // Byte code:
    //   0: new 164	java/net/URL
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 165	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 169	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   11: checkcast 171	java/net/HttpURLConnection
    //   14: astore_0
    //   15: iconst_1
    //   16: invokestatic 175	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   19: aload_0
    //   20: ldc 177
    //   22: invokevirtual 180	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: ldc 182
    //   28: ldc 184
    //   30: invokevirtual 188	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: invokevirtual 192	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   37: astore 5
    //   39: aload 5
    //   41: astore_3
    //   42: aload_0
    //   43: astore 4
    //   45: sipush 1024
    //   48: newarray byte
    //   50: astore 6
    //   52: iconst_0
    //   53: istore_1
    //   54: aload 5
    //   56: astore_3
    //   57: aload_0
    //   58: astore 4
    //   60: iload_1
    //   61: aload 6
    //   63: arraylength
    //   64: if_icmpge +34 -> 98
    //   67: aload 5
    //   69: astore_3
    //   70: aload_0
    //   71: astore 4
    //   73: aload 5
    //   75: aload 6
    //   77: iload_1
    //   78: aload 6
    //   80: arraylength
    //   81: iload_1
    //   82: isub
    //   83: invokevirtual 198	java/io/InputStream:read	([BII)I
    //   86: istore_2
    //   87: iload_2
    //   88: iflt +10 -> 98
    //   91: iload_1
    //   92: iload_2
    //   93: iadd
    //   94: istore_1
    //   95: goto -41 -> 54
    //   98: aload 5
    //   100: astore_3
    //   101: aload_0
    //   102: astore 4
    //   104: new 99	java/lang/String
    //   107: dup
    //   108: aload 6
    //   110: ldc 200
    //   112: invokespecial 203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   115: astore 6
    //   117: aload 5
    //   119: ifnull +11 -> 130
    //   122: aload 5
    //   124: invokevirtual 206	java/io/InputStream:close	()V
    //   127: goto +3 -> 130
    //   130: aload_0
    //   131: ifnull +14 -> 145
    //   134: aload_0
    //   135: invokevirtual 209	java/net/HttpURLConnection:disconnect	()V
    //   138: aload 6
    //   140: areturn
    //   141: aload_0
    //   142: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   145: aload 6
    //   147: areturn
    //   148: astore 6
    //   150: goto +48 -> 198
    //   153: astore 6
    //   155: goto +81 -> 236
    //   158: astore_3
    //   159: aconst_null
    //   160: astore 4
    //   162: goto +125 -> 287
    //   165: astore 6
    //   167: aconst_null
    //   168: astore 5
    //   170: goto +28 -> 198
    //   173: astore 6
    //   175: aconst_null
    //   176: astore 5
    //   178: goto +58 -> 236
    //   181: astore_3
    //   182: aconst_null
    //   183: astore 4
    //   185: aload 4
    //   187: astore_0
    //   188: goto +99 -> 287
    //   191: astore 6
    //   193: aconst_null
    //   194: astore_0
    //   195: aload_0
    //   196: astore 5
    //   198: aload 5
    //   200: astore_3
    //   201: aload_0
    //   202: astore 4
    //   204: aload 6
    //   206: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   209: aload 5
    //   211: ifnull +8 -> 219
    //   214: aload 5
    //   216: invokevirtual 206	java/io/InputStream:close	()V
    //   219: aload_0
    //   220: ifnull +54 -> 274
    //   223: aload_0
    //   224: invokevirtual 209	java/net/HttpURLConnection:disconnect	()V
    //   227: aconst_null
    //   228: areturn
    //   229: astore 6
    //   231: aconst_null
    //   232: astore_0
    //   233: aload_0
    //   234: astore 5
    //   236: aload 5
    //   238: astore_3
    //   239: aload_0
    //   240: astore 4
    //   242: aload 6
    //   244: invokevirtual 211	java/net/MalformedURLException:printStackTrace	()V
    //   247: aload 5
    //   249: ifnull +11 -> 260
    //   252: aload 5
    //   254: invokevirtual 206	java/io/InputStream:close	()V
    //   257: goto +3 -> 260
    //   260: aload_0
    //   261: ifnull +13 -> 274
    //   264: aload_0
    //   265: invokevirtual 209	java/net/HttpURLConnection:disconnect	()V
    //   268: aconst_null
    //   269: areturn
    //   270: aload_0
    //   271: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   274: aconst_null
    //   275: areturn
    //   276: astore 5
    //   278: aload 4
    //   280: astore_0
    //   281: aload_3
    //   282: astore 4
    //   284: aload 5
    //   286: astore_3
    //   287: aload 4
    //   289: ifnull +11 -> 300
    //   292: aload 4
    //   294: invokevirtual 206	java/io/InputStream:close	()V
    //   297: goto +3 -> 300
    //   300: aload_0
    //   301: ifnull +14 -> 315
    //   304: aload_0
    //   305: invokevirtual 209	java/net/HttpURLConnection:disconnect	()V
    //   308: goto +7 -> 315
    //   311: aload_0
    //   312: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   315: goto +5 -> 320
    //   318: aload_3
    //   319: athrow
    //   320: goto -2 -> 318
    //   323: astore_0
    //   324: goto -183 -> 141
    //   327: astore_0
    //   328: goto -58 -> 270
    //   331: astore_0
    //   332: goto -21 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	paramString	String
    //   53	42	1	i	int
    //   86	8	2	j	int
    //   41	60	3	localObject1	Object
    //   158	1	3	localObject2	Object
    //   181	1	3	localObject3	Object
    //   200	119	3	localObject4	Object
    //   43	250	4	localObject5	Object
    //   37	216	5	localObject6	Object
    //   276	9	5	localObject7	Object
    //   50	96	6	localObject8	Object
    //   148	1	6	localIOException1	IOException
    //   153	1	6	localMalformedURLException1	java.net.MalformedURLException
    //   165	1	6	localIOException2	IOException
    //   173	1	6	localMalformedURLException2	java.net.MalformedURLException
    //   191	14	6	localIOException3	IOException
    //   229	14	6	localMalformedURLException3	java.net.MalformedURLException
    // Exception table:
    //   from	to	target	type
    //   45	52	148	java/io/IOException
    //   60	67	148	java/io/IOException
    //   73	87	148	java/io/IOException
    //   104	117	148	java/io/IOException
    //   45	52	153	java/net/MalformedURLException
    //   60	67	153	java/net/MalformedURLException
    //   73	87	153	java/net/MalformedURLException
    //   104	117	153	java/net/MalformedURLException
    //   15	39	158	finally
    //   15	39	165	java/io/IOException
    //   15	39	173	java/net/MalformedURLException
    //   0	15	181	finally
    //   0	15	191	java/io/IOException
    //   0	15	229	java/net/MalformedURLException
    //   45	52	276	finally
    //   60	67	276	finally
    //   73	87	276	finally
    //   104	117	276	finally
    //   204	209	276	finally
    //   242	247	276	finally
    //   122	127	323	java/lang/Exception
    //   134	138	323	java/lang/Exception
    //   214	219	327	java/lang/Exception
    //   223	227	327	java/lang/Exception
    //   252	257	327	java/lang/Exception
    //   264	268	327	java/lang/Exception
    //   292	297	331	java/lang/Exception
    //   304	308	331	java/lang/Exception
  }
  
  @RequiresApi(api=19)
  public static int getApplicationMemory()
  {
    Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
    Debug.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.getTotalPrivateClean() + localMemoryInfo.getTotalPrivateDirty() + localMemoryInfo.getTotalPss() + localMemoryInfo.getTotalSharedClean() + localMemoryInfo.getTotalSharedDirty() + localMemoryInfo.getTotalSwappablePss();
  }
  
  @TargetApi(18)
  public static long getAvailableSize(StatFs paramStatFs)
  {
    if (ApiHelper.hasJellyBeanMR2()) {
      return paramStatFs.getAvailableBytes();
    }
    return paramStatFs.getAvailableBlocks() * paramStatFs.getBlockSize();
  }
  
  public static String getBuildVersionName(Context paramContext)
  {
    paramContext = getVersionName(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      return "";
    }
    return paramContext.substring(paramContext.lastIndexOf(".") + 1);
  }
  
  /* Error */
  public static String getCpuName()
  {
    // Byte code:
    //   0: new 282	java/io/BufferedReader
    //   3: dup
    //   4: new 284	java/io/FileReader
    //   7: dup
    //   8: ldc_w 286
    //   11: invokespecial 287	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 290	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   17: astore_1
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: invokevirtual 293	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +124 -> 150
    //   29: aload_1
    //   30: astore_0
    //   31: aload_2
    //   32: ldc_w 295
    //   35: iconst_2
    //   36: invokevirtual 299	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   39: astore_3
    //   40: aload_1
    //   41: astore_0
    //   42: aload_3
    //   43: arraylength
    //   44: iconst_1
    //   45: if_icmple +95 -> 140
    //   48: aload_1
    //   49: astore_0
    //   50: aload_3
    //   51: iconst_0
    //   52: aaload
    //   53: invokevirtual 302	java/lang/String:trim	()Ljava/lang/String;
    //   56: invokevirtual 305	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   59: ldc_w 307
    //   62: invokevirtual 310	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   65: ifeq +75 -> 140
    //   68: aload_1
    //   69: astore_0
    //   70: getstatic 64	org/light/device/LightDeviceUtils:TAG	Ljava/lang/String;
    //   73: astore 4
    //   75: aload_1
    //   76: astore_0
    //   77: new 113	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   84: astore 5
    //   86: aload_1
    //   87: astore_0
    //   88: aload 5
    //   90: ldc_w 312
    //   93: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_1
    //   98: astore_0
    //   99: aload 5
    //   101: aload_2
    //   102: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_1
    //   107: astore_0
    //   108: aload 4
    //   110: aload 5
    //   112: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 317	org/light/utils/LightLogUtil:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_1
    //   119: astore_0
    //   120: aload_3
    //   121: iconst_1
    //   122: aaload
    //   123: invokevirtual 302	java/lang/String:trim	()Ljava/lang/String;
    //   126: astore_2
    //   127: aload_1
    //   128: invokevirtual 318	java/io/BufferedReader:close	()V
    //   131: aload_2
    //   132: areturn
    //   133: astore_0
    //   134: aload_0
    //   135: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   138: aload_2
    //   139: areturn
    //   140: aload_1
    //   141: astore_0
    //   142: aload_1
    //   143: invokevirtual 293	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   146: astore_2
    //   147: goto -122 -> 25
    //   150: aload_1
    //   151: invokevirtual 318	java/io/BufferedReader:close	()V
    //   154: goto +62 -> 216
    //   157: astore_2
    //   158: goto +16 -> 174
    //   161: astore_2
    //   162: goto +32 -> 194
    //   165: astore_0
    //   166: aconst_null
    //   167: astore_1
    //   168: goto +57 -> 225
    //   171: astore_2
    //   172: aconst_null
    //   173: astore_1
    //   174: aload_1
    //   175: astore_0
    //   176: aload_2
    //   177: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   180: aload_1
    //   181: ifnull +35 -> 216
    //   184: aload_1
    //   185: invokevirtual 318	java/io/BufferedReader:close	()V
    //   188: goto +28 -> 216
    //   191: astore_2
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_1
    //   195: astore_0
    //   196: aload_2
    //   197: invokevirtual 319	java/io/FileNotFoundException:printStackTrace	()V
    //   200: aload_1
    //   201: ifnull +15 -> 216
    //   204: aload_1
    //   205: invokevirtual 318	java/io/BufferedReader:close	()V
    //   208: goto +8 -> 216
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   216: ldc_w 272
    //   219: areturn
    //   220: astore_2
    //   221: aload_0
    //   222: astore_1
    //   223: aload_2
    //   224: astore_0
    //   225: aload_1
    //   226: ifnull +15 -> 241
    //   229: aload_1
    //   230: invokevirtual 318	java/io/BufferedReader:close	()V
    //   233: goto +8 -> 241
    //   236: astore_1
    //   237: aload_1
    //   238: invokevirtual 210	java/io/IOException:printStackTrace	()V
    //   241: goto +5 -> 246
    //   244: aload_0
    //   245: athrow
    //   246: goto -2 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	101	0	localObject1	Object
    //   133	2	0	localIOException1	IOException
    //   141	1	0	localObject2	Object
    //   165	1	0	localObject3	Object
    //   175	21	0	localObject4	Object
    //   211	11	0	localIOException2	IOException
    //   224	21	0	localObject5	Object
    //   17	213	1	localObject6	Object
    //   236	2	1	localIOException3	IOException
    //   24	123	2	str1	String
    //   157	1	2	localIOException4	IOException
    //   161	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   171	6	2	localIOException5	IOException
    //   191	6	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   220	4	2	localObject7	Object
    //   39	82	3	arrayOfString	String[]
    //   73	36	4	str2	String
    //   84	27	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   127	131	133	java/io/IOException
    //   20	25	157	java/io/IOException
    //   31	40	157	java/io/IOException
    //   42	48	157	java/io/IOException
    //   50	68	157	java/io/IOException
    //   70	75	157	java/io/IOException
    //   77	86	157	java/io/IOException
    //   88	97	157	java/io/IOException
    //   99	106	157	java/io/IOException
    //   108	118	157	java/io/IOException
    //   120	127	157	java/io/IOException
    //   142	147	157	java/io/IOException
    //   20	25	161	java/io/FileNotFoundException
    //   31	40	161	java/io/FileNotFoundException
    //   42	48	161	java/io/FileNotFoundException
    //   50	68	161	java/io/FileNotFoundException
    //   70	75	161	java/io/FileNotFoundException
    //   77	86	161	java/io/FileNotFoundException
    //   88	97	161	java/io/FileNotFoundException
    //   99	106	161	java/io/FileNotFoundException
    //   108	118	161	java/io/FileNotFoundException
    //   120	127	161	java/io/FileNotFoundException
    //   142	147	161	java/io/FileNotFoundException
    //   0	18	165	finally
    //   0	18	171	java/io/IOException
    //   0	18	191	java/io/FileNotFoundException
    //   150	154	211	java/io/IOException
    //   184	188	211	java/io/IOException
    //   204	208	211	java/io/IOException
    //   20	25	220	finally
    //   31	40	220	finally
    //   42	48	220	finally
    //   50	68	220	finally
    //   70	75	220	finally
    //   77	86	220	finally
    //   88	97	220	finally
    //   99	106	220	finally
    //   108	118	220	finally
    //   120	127	220	finally
    //   142	147	220	finally
    //   176	180	220	finally
    //   196	200	220	finally
    //   229	233	236	java/io/IOException
  }
  
  public static String getCpuNameOnce()
  {
    if (sCpuName == null) {
      sCpuName = getCpuName();
    }
    return sCpuName;
  }
  
  public static float getCpuRate()
  {
    return cpuRate;
  }
  
  public static String getCurrentProcessName(Context paramContext)
  {
    int i = Process.myPid();
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
      if (localRunningAppProcessInfo.pid == i) {
        return localRunningAppProcessInfo.processName;
      }
    }
    return null;
  }
  
  public static File getExternalFilesDir(Context paramContext)
  {
    Object localObject2 = paramContext.getExternalFilesDir(null);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("/Android/data/");
      ((StringBuilder)localObject1).append(paramContext.getPackageName());
      ((StringBuilder)localObject1).append("/files/");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramContext.getExternalFilesDir(null));
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = new File(((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public static File getExternalFilesDir(Context paramContext, String paramString)
  {
    if ((isExternalStorageAvailable(paramContext)) && (isExternalStorageSpaceEnough(paramContext, 52428800L))) {
      paramContext = getExternalFilesDir(paramContext).getPath();
    } else {
      paramContext = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    paramContext = new File(localStringBuilder.toString());
    try
    {
      if ((paramContext.exists()) && (paramContext.isFile())) {
        paramContext.delete();
      }
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext;
    }
    catch (Exception paramString) {}
    return paramContext;
  }
  
  public static String getExternalLocalIpAddress()
  {
    String str = fetchExternalIpProviderHTML("https://checkip.dyndns.org/");
    if (str == null) {
      return null;
    }
    return parse(str);
  }
  
  public static float getHeapAllocatedPercent(Context paramContext)
  {
    long l1 = getHeapAllocatedSizeInKb();
    long l2 = getHeapMaxSizeInKb(paramContext);
    return (float)l1 * 1.0F / (float)l2;
  }
  
  public static long getHeapAllocatedSizeInKb()
  {
    long l = getRuntimeTotalMemory(1) - getRuntimeFreeMemory(1);
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getHeapAllocatedSizeInKb(), heapAllocated = ");
    localStringBuilder.append((float)l / 1024.0F);
    localStringBuilder.append("(Mb), ");
    localStringBuilder.append(l);
    localStringBuilder.append("(Kb)");
    LightLogUtil.v(str, localStringBuilder.toString());
    return l;
  }
  
  public static long getHeapMaxSizeInKb(Context paramContext)
  {
    long l = getRuntimeMaxMemory(1);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHeapMaxSizeInKb(), heap size(Mb) = ");
      localStringBuilder.append(paramContext.getMemoryClass());
      LightLogUtil.v(str, localStringBuilder.toString());
      int i = paramContext.getMemoryClass();
      return i * 1024;
    }
    catch (Exception paramContext)
    {
      LightLogUtil.e(paramContext);
    }
    return l;
  }
  
  public static long getHeapMaxSizeInMb(Context paramContext)
  {
    long l = getRuntimeMaxMemory(2);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHeapMaxSizeInMb(), heap size(Mb) = ");
      localStringBuilder.append(paramContext.getMemoryClass());
      LightLogUtil.v(str, localStringBuilder.toString());
      int i = paramContext.getMemoryClass();
      return i;
    }
    catch (Exception paramContext)
    {
      LightLogUtil.e(paramContext);
    }
    return l;
  }
  
  public static long getHeapRemainSizeInKb(Context paramContext)
  {
    long l = getHeapMaxSizeInKb(paramContext) - getHeapAllocatedSizeInKb();
    paramContext = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getHeapRemainSizeInKb(), remainSize = ");
    localStringBuilder.append((float)l / 1024.0F);
    localStringBuilder.append("(Mb), ");
    localStringBuilder.append(l);
    localStringBuilder.append("(Kb)");
    LightLogUtil.v(paramContext, localStringBuilder.toString());
    return l;
  }
  
  public static long getLargeHeapMaxSizeInKb(Context paramContext)
  {
    long l = getRuntimeMaxMemory(1);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLargeHeapMaxSizeInKb(), heap size(Mb) = ");
      localStringBuilder.append(paramContext.getLargeMemoryClass());
      LightLogUtil.v(str, localStringBuilder.toString());
      int i = paramContext.getLargeMemoryClass();
      return i * 1024;
    }
    catch (Exception paramContext)
    {
      LightLogUtil.e(paramContext);
    }
    return l;
  }
  
  public static long getLargeHeapRemainSizeInKb(Context paramContext)
  {
    long l = getLargeHeapMaxSizeInKb(paramContext) - getHeapAllocatedSizeInKb();
    paramContext = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLargeHeapRemainSizeInKb(), remainSize = ");
    localStringBuilder.append((float)l / 1024.0F);
    localStringBuilder.append("(Mb), ");
    localStringBuilder.append(l);
    localStringBuilder.append("(Kb)");
    LightLogUtil.v(paramContext, localStringBuilder.toString());
    return l;
  }
  
  public static String getLocalIpAddress()
  {
    try
    {
      if (NetworkMonitor.getNetworkInterfaces() != null)
      {
        Enumeration localEnumeration = NetworkMonitor.getNetworkInterfaces();
        while (localEnumeration.hasMoreElements())
        {
          Object localObject1 = (NetworkInterface)localEnumeration.nextElement();
          if (localObject1 != null)
          {
            localObject1 = ((NetworkInterface)localObject1).getInetAddresses();
            while (((Enumeration)localObject1).hasMoreElements())
            {
              Object localObject2 = (InetAddress)((Enumeration)localObject1).nextElement();
              try
              {
                if ((!((InetAddress)localObject2).isLoopbackAddress()) && ((localObject2 instanceof Inet4Address)) && (Inet4Address.getByName(((InetAddress)localObject2).getHostAddress()) != null) && (!((InetAddress)localObject2).getHostAddress().equals("null")) && (((InetAddress)localObject2).getHostAddress() != null))
                {
                  localObject2 = ((InetAddress)localObject2).getHostAddress().trim();
                  return localObject2;
                }
              }
              catch (UnknownHostException localUnknownHostException)
              {
                localUnknownHostException.printStackTrace();
              }
            }
          }
        }
      }
      return "";
    }
    catch (SocketException localSocketException)
    {
      LightLogUtil.e(localSocketException);
    }
  }
  
  /* Error */
  public static String getLocalRealIpAddress()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore_2
    //   7: invokestatic 486	com/tencent/mobileqq/qmethodmonitor/monitor/NetworkMonitor:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   10: astore 8
    //   12: iconst_0
    //   13: istore_0
    //   14: aconst_null
    //   15: astore 7
    //   17: aload 7
    //   19: astore 4
    //   21: aload 8
    //   23: ifnull +230 -> 253
    //   26: aload_2
    //   27: astore 5
    //   29: aload_2
    //   30: astore 6
    //   32: aload 8
    //   34: invokeinterface 491 1 0
    //   39: ifeq +214 -> 253
    //   42: iload_0
    //   43: ifne +210 -> 253
    //   46: aload_2
    //   47: astore 5
    //   49: aload_2
    //   50: astore 6
    //   52: aload 8
    //   54: invokeinterface 494 1 0
    //   59: checkcast 496	java/net/NetworkInterface
    //   62: invokevirtual 499	java/net/NetworkInterface:getInetAddresses	()Ljava/util/Enumeration;
    //   65: astore 9
    //   67: aload_2
    //   68: astore_3
    //   69: aload_3
    //   70: astore_2
    //   71: aload 4
    //   73: astore 7
    //   75: aload_3
    //   76: astore 5
    //   78: aload_3
    //   79: astore 6
    //   81: aload 9
    //   83: invokeinterface 491 1 0
    //   88: ifeq -71 -> 17
    //   91: aload_3
    //   92: astore 5
    //   94: aload_3
    //   95: astore 6
    //   97: aload 9
    //   99: invokeinterface 494 1 0
    //   104: checkcast 501	java/net/InetAddress
    //   107: astore_2
    //   108: aload_3
    //   109: astore 5
    //   111: aload_3
    //   112: astore 6
    //   114: aload_2
    //   115: invokevirtual 524	java/net/InetAddress:isSiteLocalAddress	()Z
    //   118: istore_1
    //   119: iload_1
    //   120: ifne +55 -> 175
    //   123: aload_3
    //   124: astore 5
    //   126: aload_3
    //   127: astore 6
    //   129: aload_2
    //   130: invokevirtual 504	java/net/InetAddress:isLoopbackAddress	()Z
    //   133: ifne +42 -> 175
    //   136: aload_3
    //   137: astore 5
    //   139: aload_3
    //   140: astore 6
    //   142: aload_2
    //   143: invokevirtual 509	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   146: ldc_w 526
    //   149: invokevirtual 529	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   152: iconst_m1
    //   153: if_icmpne +22 -> 175
    //   156: aload_3
    //   157: astore 5
    //   159: aload_3
    //   160: astore 6
    //   162: aload_2
    //   163: invokevirtual 509	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   166: astore 7
    //   168: iconst_1
    //   169: istore_0
    //   170: aload_3
    //   171: astore_2
    //   172: goto -155 -> 17
    //   175: aload_3
    //   176: astore 5
    //   178: aload_3
    //   179: astore 6
    //   181: aload_2
    //   182: invokevirtual 524	java/net/InetAddress:isSiteLocalAddress	()Z
    //   185: ifeq -116 -> 69
    //   188: aload_3
    //   189: astore 5
    //   191: aload_3
    //   192: astore 6
    //   194: aload_2
    //   195: invokevirtual 504	java/net/InetAddress:isLoopbackAddress	()Z
    //   198: ifne -129 -> 69
    //   201: aload_3
    //   202: astore 5
    //   204: aload_3
    //   205: astore 6
    //   207: aload_2
    //   208: invokevirtual 509	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   211: ldc_w 526
    //   214: invokevirtual 529	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   217: iconst_m1
    //   218: if_icmpne -149 -> 69
    //   221: aload_3
    //   222: astore 5
    //   224: aload_3
    //   225: astore 6
    //   227: aload_2
    //   228: invokevirtual 509	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   231: astore_3
    //   232: goto -163 -> 69
    //   235: goto +89 -> 324
    //   238: astore 6
    //   240: aload 5
    //   242: astore_2
    //   243: aload 4
    //   245: astore_3
    //   246: aload 6
    //   248: astore 4
    //   250: goto +39 -> 289
    //   253: aload 4
    //   255: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifne +6 -> 264
    //   261: aload 4
    //   263: areturn
    //   264: invokestatic 531	org/light/device/LightDeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   267: astore_3
    //   268: aload_3
    //   269: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   272: ifne +5 -> 277
    //   275: aload_3
    //   276: areturn
    //   277: aload_2
    //   278: areturn
    //   279: aconst_null
    //   280: astore 4
    //   282: goto +42 -> 324
    //   285: astore 4
    //   287: aconst_null
    //   288: astore_2
    //   289: aload 4
    //   291: invokevirtual 532	java/net/SocketException:printStackTrace	()V
    //   294: aload_3
    //   295: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   298: ifne +5 -> 303
    //   301: aload_3
    //   302: areturn
    //   303: invokestatic 531	org/light/device/LightDeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   306: astore_3
    //   307: aload_3
    //   308: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   311: ifne +5 -> 316
    //   314: aload_3
    //   315: areturn
    //   316: aload_2
    //   317: areturn
    //   318: aload_3
    //   319: astore 4
    //   321: aload_2
    //   322: astore 6
    //   324: aload 4
    //   326: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   329: ifne +6 -> 335
    //   332: aload 4
    //   334: areturn
    //   335: invokestatic 531	org/light/device/LightDeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   338: astore_2
    //   339: aload_2
    //   340: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   343: ifne +5 -> 348
    //   346: aload_2
    //   347: areturn
    //   348: aload 6
    //   350: areturn
    //   351: astore_2
    //   352: goto -73 -> 279
    //   355: astore_2
    //   356: goto -121 -> 235
    //   359: astore 4
    //   361: goto -43 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	157	0	i	int
    //   118	2	1	bool	boolean
    //   6	341	2	localObject1	Object
    //   351	1	2	localObject2	Object
    //   355	1	2	localObject3	Object
    //   1	318	3	localObject4	Object
    //   19	262	4	localObject5	Object
    //   285	5	4	localSocketException1	SocketException
    //   319	14	4	localObject6	Object
    //   359	1	4	localObject7	Object
    //   27	214	5	localObject8	Object
    //   3	223	6	localObject9	Object
    //   238	9	6	localSocketException2	SocketException
    //   322	27	6	localObject10	Object
    //   15	152	7	localObject11	Object
    //   10	43	8	localEnumeration1	Enumeration
    //   65	33	9	localEnumeration2	Enumeration
    // Exception table:
    //   from	to	target	type
    //   32	42	238	java/net/SocketException
    //   52	67	238	java/net/SocketException
    //   81	91	238	java/net/SocketException
    //   97	108	238	java/net/SocketException
    //   114	119	238	java/net/SocketException
    //   129	136	238	java/net/SocketException
    //   142	156	238	java/net/SocketException
    //   162	168	238	java/net/SocketException
    //   181	188	238	java/net/SocketException
    //   194	201	238	java/net/SocketException
    //   207	221	238	java/net/SocketException
    //   227	232	238	java/net/SocketException
    //   7	12	285	java/net/SocketException
    //   7	12	351	finally
    //   32	42	355	finally
    //   52	67	355	finally
    //   81	91	355	finally
    //   97	108	355	finally
    //   114	119	355	finally
    //   129	136	355	finally
    //   142	156	355	finally
    //   162	168	355	finally
    //   181	188	355	finally
    //   194	201	355	finally
    //   207	221	355	finally
    //   227	232	355	finally
    //   289	294	359	finally
  }
  
  public static String getMachineInfo()
  {
    return DeviceInstance.getInstance().getDeviceName();
  }
  
  /* Error */
  public static long getMaxCpuFreq()
  {
    // Byte code:
    //   0: getstatic 547	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   3: lstore_2
    //   4: lload_2
    //   5: lconst_0
    //   6: lcmp
    //   7: ifle +5 -> 12
    //   10: lload_2
    //   11: lreturn
    //   12: iconst_0
    //   13: istore_0
    //   14: iload_0
    //   15: invokestatic 550	org/light/device/LightDeviceUtils:getNumCores	()I
    //   18: if_icmpge +178 -> 196
    //   21: new 113	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   28: astore 4
    //   30: aload 4
    //   32: ldc_w 552
    //   35: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 4
    //   41: iload_0
    //   42: invokevirtual 454	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 4
    //   48: ldc_w 554
    //   51: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: new 94	java/io/File
    //   58: dup
    //   59: aload 4
    //   61: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 126	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 4
    //   69: aload 4
    //   71: invokevirtual 134	java/io/File:exists	()Z
    //   74: ifeq +246 -> 320
    //   77: sipush 128
    //   80: newarray byte
    //   82: astore 5
    //   84: new 556	java/io/FileInputStream
    //   87: dup
    //   88: aload 4
    //   90: invokespecial 559	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   93: astore 4
    //   95: aload 4
    //   97: aload 5
    //   99: invokevirtual 562	java/io/FileInputStream:read	([B)I
    //   102: pop
    //   103: iconst_0
    //   104: istore_1
    //   105: aload 5
    //   107: iload_1
    //   108: baload
    //   109: bipush 48
    //   111: if_icmplt +26 -> 137
    //   114: aload 5
    //   116: iload_1
    //   117: baload
    //   118: bipush 57
    //   120: if_icmpgt +17 -> 137
    //   123: iload_1
    //   124: aload 5
    //   126: arraylength
    //   127: if_icmpge +10 -> 137
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: istore_1
    //   134: goto -29 -> 105
    //   137: new 99	java/lang/String
    //   140: dup
    //   141: aload 5
    //   143: iconst_0
    //   144: iload_1
    //   145: invokespecial 565	java/lang/String:<init>	([BII)V
    //   148: invokestatic 156	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   151: invokestatic 569	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: astore 5
    //   156: aload 5
    //   158: invokevirtual 572	java/lang/Integer:intValue	()I
    //   161: i2l
    //   162: getstatic 547	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   165: lcmp
    //   166: ifle +12 -> 178
    //   169: aload 5
    //   171: invokevirtual 572	java/lang/Integer:intValue	()I
    //   174: i2l
    //   175: putstatic 547	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   178: aload 4
    //   180: invokevirtual 573	java/io/FileInputStream:close	()V
    //   183: goto +137 -> 320
    //   186: astore 5
    //   188: aload 4
    //   190: invokevirtual 573	java/io/FileInputStream:close	()V
    //   193: aload 5
    //   195: athrow
    //   196: getstatic 547	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   199: ldc2_w 574
    //   202: lcmp
    //   203: ifne +65 -> 268
    //   206: new 556	java/io/FileInputStream
    //   209: dup
    //   210: ldc_w 286
    //   213: invokespecial 576	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   216: astore 4
    //   218: ldc_w 578
    //   221: aload 4
    //   223: invokestatic 582	org/light/device/LightDeviceUtils:parseFileForValue	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   226: sipush 1000
    //   229: imul
    //   230: i2l
    //   231: lstore_2
    //   232: lload_2
    //   233: getstatic 547	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   236: lcmp
    //   237: ifle +7 -> 244
    //   240: lload_2
    //   241: putstatic 547	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   244: aload 4
    //   246: invokevirtual 573	java/io/FileInputStream:close	()V
    //   249: goto +19 -> 268
    //   252: astore 5
    //   254: aload 4
    //   256: invokevirtual 573	java/io/FileInputStream:close	()V
    //   259: aload 5
    //   261: athrow
    //   262: ldc2_w 574
    //   265: putstatic 547	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   268: new 113	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   275: astore 4
    //   277: aload 4
    //   279: ldc_w 584
    //   282: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 4
    //   288: getstatic 547	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   291: invokevirtual 438	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: ldc_w 586
    //   298: aload 4
    //   300: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 443	org/light/utils/LightLogUtil:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: getstatic 547	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   309: lreturn
    //   310: astore 4
    //   312: goto -50 -> 262
    //   315: astore 5
    //   317: goto -139 -> 178
    //   320: iload_0
    //   321: iconst_1
    //   322: iadd
    //   323: istore_0
    //   324: goto -310 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	311	0	i	int
    //   104	41	1	j	int
    //   3	238	2	l	long
    //   28	271	4	localObject1	Object
    //   310	1	4	localIOException	IOException
    //   82	88	5	localObject2	Object
    //   186	8	5	localObject3	Object
    //   252	8	5	localObject4	Object
    //   315	1	5	localNumberFormatException	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   95	103	186	finally
    //   123	130	186	finally
    //   137	178	186	finally
    //   218	244	252	finally
    //   14	95	310	java/io/IOException
    //   178	183	310	java/io/IOException
    //   188	196	310	java/io/IOException
    //   196	218	310	java/io/IOException
    //   244	249	310	java/io/IOException
    //   254	262	310	java/io/IOException
    //   95	103	315	java/lang/NumberFormatException
    //   123	130	315	java/lang/NumberFormatException
    //   137	178	315	java/lang/NumberFormatException
  }
  
  public static int getMobileNetworkType(Context paramContext)
  {
    if (paramContext == null) {
      return 4;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return 4;
    }
    paramContext = paramContext.getNetworkInfo(0);
    if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected()))
    {
      switch (paramContext.getSubtype())
      {
      case 3: 
      case 7: 
      case 11: 
      case 14: 
      default: 
        return 4;
      case 13: 
        return 3;
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 15: 
        return 2;
      }
      return 1;
    }
    return 5;
  }
  
  public static int getNavigationBarHeight(Activity paramActivity)
  {
    if (!isNavigationBarShow(paramActivity)) {
      return 0;
    }
    paramActivity = paramActivity.getResources();
    return paramActivity.getDimensionPixelSize(paramActivity.getIdentifier("navigation_bar_height", "dimen", "android"));
  }
  
  public static int getNetworkType(Context paramContext)
  {
    try
    {
      if (!isNetworkAvailable(paramContext)) {
        return 0;
      }
      if (isWifiNetwork(paramContext)) {
        return 1;
      }
      int i = getMobileNetworkType(paramContext);
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return 5;
          }
          return 4;
        }
        return 3;
      }
      return 2;
    }
    catch (Exception paramContext)
    {
      LightLogUtil.e(paramContext);
    }
    return 5;
  }
  
  public static String getNetworkTypeName(Context paramContext)
  {
    int i = getNetworkType(paramContext);
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return "unknow";
            }
            return "4G";
          }
          return "3G";
        }
        return "2G";
      }
      return "wifi";
    }
    return "none";
  }
  
  public static int getNumCores()
  {
    int i = sCpuCount;
    if (i > 0) {
      return i;
    }
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new LightDeviceUtils.1CpuFilter());
      if (arrayOfFile != null) {
        sCpuCount = arrayOfFile.length;
      } else {
        sCpuCount = 1;
      }
    }
    catch (Throwable localThrowable)
    {
      LightLogUtil.e(localThrowable);
      sCpuCount = 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sCpuCount:");
    localStringBuilder.append(sCpuCount);
    LightLogUtil.v("DeviceUtils", localStringBuilder.toString());
    return sCpuCount;
  }
  
  public static String getOSVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static int getOpenGlEsVersion(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getDeviceConfigurationInfo();
    if (paramContext != null) {
      openGLESVersion = paramContext.reqGlEsVersion;
    }
    return openGLESVersion;
  }
  
  public static int getPhonePerfLevel(Context paramContext)
  {
    return OfflineConfig.getPhonePerfLevel(paramContext);
  }
  
  private static long getRuntimeFreeMemory(int paramInt)
  {
    long l;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          l = Runtime.getRuntime().freeMemory();
        } else {
          l = Runtime.getRuntime().freeMemory() / 1024L / 1024L;
        }
      }
      else {
        l = Runtime.getRuntime().freeMemory() / 1024L;
      }
    }
    else {
      l = Runtime.getRuntime().freeMemory();
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getRuntimeFreeMemory] freeMemory = ");
    localStringBuilder.append(Runtime.getRuntime().freeMemory() / 1024L / 1024L);
    localStringBuilder.append("(Mb), ");
    localStringBuilder.append(Runtime.getRuntime().freeMemory() / 1024L);
    localStringBuilder.append("(Kb)");
    LightLogUtil.v(str, localStringBuilder.toString());
    return l;
  }
  
  private static long getRuntimeMaxMemory(int paramInt)
  {
    long l = Runtime.getRuntime().maxMemory();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {
          l = Runtime.getRuntime().maxMemory() / 1024L / 1024L;
        }
      }
      else {
        l = Runtime.getRuntime().maxMemory() / 1024L;
      }
    }
    else {
      l = Runtime.getRuntime().maxMemory();
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getRuntimeMaxMemory] maxMemory = ");
    localStringBuilder.append(Runtime.getRuntime().maxMemory() / 1024L / 1024L);
    localStringBuilder.append("(Mb), ");
    localStringBuilder.append(Runtime.getRuntime().maxMemory() / 1024L);
    localStringBuilder.append("(Kb)");
    LightLogUtil.v(str, localStringBuilder.toString());
    return l;
  }
  
  public static long getRuntimeRemainSize(int paramInt)
  {
    long l2 = Runtime.getRuntime().maxMemory() - getHeapAllocatedSizeInKb() * 1024L;
    long l1 = l2;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          l1 = l2;
        } else {
          l1 = l2 / 1048576L;
        }
      }
      else {
        l1 = l2 / 1024L;
      }
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getRuntimeRemainSize] remainMemory = ");
    localStringBuilder.append(l1);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramInt);
    LightLogUtil.v(str, localStringBuilder.toString());
    return l1;
  }
  
  private static long getRuntimeTotalMemory(int paramInt)
  {
    long l;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          l = Runtime.getRuntime().totalMemory();
        } else {
          l = Runtime.getRuntime().totalMemory() / 1024L / 1024L;
        }
      }
      else {
        l = Runtime.getRuntime().totalMemory() / 1024L;
      }
    }
    else {
      l = Runtime.getRuntime().totalMemory();
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getRuntimeTotalMemory] totalMemory = ");
    localStringBuilder.append(Runtime.getRuntime().totalMemory() / 1024L / 1024L);
    localStringBuilder.append("(Mb), ");
    localStringBuilder.append(Runtime.getRuntime().totalMemory() / 1024L);
    localStringBuilder.append("(Kb)");
    LightLogUtil.v(str, localStringBuilder.toString());
    return l;
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    if (paramContext == null) {
      return 1;
    }
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenHeightWithNavigationBar(Activity paramActivity)
  {
    return getScreenHeight(paramActivity) + getNavigationBarHeight(paramActivity);
  }
  
  public static float getScreenRatio(Context paramContext)
  {
    int i = getScreenWidth(paramContext);
    int k = getScreenHeight(paramContext);
    int j = Math.max(i, k);
    k = Math.min(i, k);
    i = j;
    if (NotchInScreenUtils.hasNotchInScreenHw(paramContext)) {
      i = j - NotchInScreenUtils.getNotchHeightHw(paramContext);
    }
    return k * 1.0F / i;
  }
  
  public static String getScreenSize(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramContext.widthPixels);
    localStringBuilder.append("*");
    localStringBuilder.append(paramContext.heightPixels);
    return localStringBuilder.toString();
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (paramContext == null) {
      return 1;
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getSystemScreenBrightness(ContentResolver paramContentResolver)
  {
    try
    {
      int i = Settings.System.getInt(paramContentResolver, "screen_brightness");
      return i;
    }
    catch (Exception paramContentResolver)
    {
      LightLogUtil.e(paramContentResolver);
    }
    return 0;
  }
  
  public static int getSystemScreenMode(ContentResolver paramContentResolver)
  {
    try
    {
      int i = Settings.System.getInt(paramContentResolver, "screen_brightness_mode");
      return i;
    }
    catch (Exception paramContentResolver)
    {
      LightLogUtil.e(paramContentResolver);
    }
    return -1;
  }
  
  public static long getTotalRamMemory(Context paramContext)
  {
    if ((Build.VERSION.SDK_INT >= 16) && (paramContext != null))
    {
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      ((ActivityManager)paramContext.getSystemService("activity")).getMemoryInfo(localMemoryInfo);
      return localMemoryInfo.totalMem;
    }
    long l2 = -1L;
    l1 = l2;
    try
    {
      paramContext = new FileInputStream("/proc/meminfo");
      try
      {
        int i = parseFileForValue("MemTotal", paramContext);
        l2 = i * 1024L;
        l1 = l2;
        paramContext.close();
        return l2;
      }
      finally
      {
        l1 = l2;
        paramContext.close();
        l1 = l2;
      }
      return l1;
    }
    catch (IOException paramContext) {}
  }
  
  @TargetApi(18)
  public static long getTotalSize(StatFs paramStatFs)
  {
    if (ApiHelper.hasJellyBeanMR2()) {
      return paramStatFs.getTotalBytes();
    }
    return paramStatFs.getBlockCount() * paramStatFs.getBlockSize();
  }
  
  public static int getVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 16384).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  public static String getVersionName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static float getWindowScreenBrightness(Window paramWindow)
  {
    return paramWindow.getAttributes().screenBrightness;
  }
  
  public static void hideNavigationBar(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindow().getDecorView();
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramActivity.setSystemUiVisibility(5894);
      paramActivity.setOnSystemUiVisibilityChangeListener(new LightDeviceUtils.2(paramActivity));
    }
  }
  
  public static boolean isExternalStorageAvailable(Context paramContext)
  {
    try
    {
      if (!"mounted".equals(Environment.getExternalStorageState())) {
        if (Environment.isExternalStorageRemovable()) {
          break label42;
        }
      }
      new StatFs(paramContext.getExternalFilesDir(null).getAbsolutePath());
      return true;
    }
    catch (Exception paramContext)
    {
      return false;
    }
    label42:
    return false;
  }
  
  public static boolean isExternalStorageSpaceEnough(Context paramContext, long paramLong)
  {
    paramContext = paramContext.getExternalFilesDir(null);
    boolean bool = false;
    try
    {
      long l = getAvailableSize(new StatFs(paramContext.getAbsolutePath()));
      if (l > paramLong) {
        bool = true;
      }
      return bool;
    }
    catch (IllegalArgumentException paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean isMainProcess(Context paramContext)
  {
    return (paramContext != null) && (paramContext.getPackageName().equals(getCurrentProcessName(paramContext)));
  }
  
  public static boolean isMobileNetwork(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getNetworkInfo(0);
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.isAvailable())
      {
        bool1 = bool2;
        if (paramContext.isConnected()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isNavigationBarShow(Activity paramActivity)
  {
    if (Build.MODEL.equals("Redmi 6"))
    {
      int i;
      if (Build.VERSION.SDK_INT < 21) {
        i = Settings.System.getInt(paramActivity.getContentResolver(), "force_fsg_nav_bar", 0);
      } else {
        i = Settings.Global.getInt(paramActivity.getContentResolver(), "force_fsg_nav_bar", 0);
      }
      return i != 1;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
      Point localPoint1 = new Point();
      Point localPoint2 = new Point();
      paramActivity.getSize(localPoint1);
      paramActivity.getRealSize(localPoint2);
      return localPoint2.y != localPoint1.y;
    }
    boolean bool1 = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
    boolean bool2 = KeyCharacterMap.deviceHasKey(4);
    return (!bool1) && (!bool2);
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.isConnectedOrConnecting()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isValid(Context paramContext)
  {
    boolean bool;
    if (getOpenGlEsVersion(paramContext) >= 131072) {
      bool = true;
    } else {
      bool = false;
    }
    mIsOpenGlEsValid = bool;
    mIsAllUnusable = false;
    return (!mIsAllUnusable) && (mIsOpenGlEsValid);
  }
  
  public static boolean isWifiNetwork(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getNetworkInfo(1);
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.isAvailable())
      {
        bool1 = bool2;
        if (paramContext.isConnected()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private static String parse(String paramString)
  {
    paramString = Pattern.compile("(\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})[.](\\d{1,3})", 2).matcher(paramString);
    if (paramString.find()) {
      return paramString.group(0);
    }
    return null;
  }
  
  private static int parseFileForValue(String paramString, FileInputStream paramFileInputStream)
  {
    arrayOfByte = new byte[1024];
    for (;;)
    {
      try
      {
        m = paramFileInputStream.read(arrayOfByte);
        j = 0;
      }
      catch (IOException|NumberFormatException paramString)
      {
        int m;
        continue;
        if (j >= m) {
          continue;
        }
        if (arrayOfByte[j] == 10) {
          continue;
        }
        int k = j;
        if (j != 0) {
          continue;
        }
        int i = j;
        if (arrayOfByte[j] != 10) {
          continue;
        }
        i = j + 1;
        int j = i;
        continue;
      }
      k = i;
      if (j >= m) {
        continue;
      }
      k = j - i;
      if (arrayOfByte[j] != paramString.charAt(k))
      {
        k = i;
        continue;
      }
      if (k == paramString.length() - 1)
      {
        i = extractValue(arrayOfByte, j);
        return i;
      }
      j += 1;
    }
    j = k + 1;
    break label94;
    return -1;
  }
  
  public static void recordCpuInfo()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return;
    }
    if (handlerThread == null)
    {
      handlerThread = HandlerThreadManager.getInstance().getHandlerThread(HandlerThreadTag.CAL_CPU_RATE);
      handler = new Handler(handlerThread.getLooper());
    }
    int i = recordCpuCount;
    if (i % 100 == 0)
    {
      handler.post(new LightDeviceUtils.1());
      return;
    }
    recordCpuCount = i + 1;
  }
  
  public static void resetWindowScreenBrightness(Window paramWindow)
  {
    if (paramWindow == null) {
      return;
    }
    setWindowScreenBrightness(paramWindow, -1.0F);
  }
  
  public static void setNavigationBarColor(Activity paramActivity, int paramInt)
  {
    Object localObject = paramActivity.getWindow();
    if (Build.VERSION.SDK_INT >= 21)
    {
      ((Window)localObject).clearFlags(201326592);
      i = 1792;
      if (Build.MODEL.equals("Pixel")) {
        i = 1808;
      }
      ((Window)localObject).getDecorView().setSystemUiVisibility(i);
      ((Window)localObject).addFlags(-2147483648);
      ((Window)localObject).setNavigationBarColor(paramInt);
      return;
    }
    localObject = (ViewGroup)paramActivity.getWindow().getDecorView();
    View localView = new View(paramActivity);
    int i = paramActivity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
    paramInt = 0;
    if (i > 0) {
      paramInt = paramActivity.getResources().getDimensionPixelSize(i);
    }
    paramActivity = new FrameLayout.LayoutParams(-1, paramInt);
    paramActivity.gravity = 80;
    localView.setLayoutParams(paramActivity);
    localView.setBackgroundColor(Color.parseColor("#000000"));
    ((ViewGroup)localObject).addView(localView);
  }
  
  public static void setSystemScreenBrightness(ContentResolver paramContentResolver, int paramInt)
  {
    try
    {
      Settings.System.putInt(paramContentResolver, "screen_brightness", paramInt);
      return;
    }
    catch (Exception paramContentResolver)
    {
      LightLogUtil.e(paramContentResolver);
    }
  }
  
  public static void setSystemScreenMode(ContentResolver paramContentResolver, int paramInt)
  {
    try
    {
      Settings.System.putInt(paramContentResolver, "screen_brightness_mode", paramInt);
      paramContentResolver.notifyChange(Settings.System.getUriFor("screen_brightness_mode"), null);
      return;
    }
    catch (Exception paramContentResolver)
    {
      LightLogUtil.e(paramContentResolver);
    }
  }
  
  public static void setWindowScreenBrightness(Window paramWindow, float paramFloat)
  {
    if (paramWindow == null) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = paramWindow.getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    paramWindow.setAttributes(localLayoutParams);
  }
  
  public static void setWindowScreenBrightnessMax(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    if (veryLargeScreen(paramActivity))
    {
      setWindowScreenBrightness(paramActivity.getWindow(), 0.8F);
      return;
    }
    setWindowScreenBrightness(paramActivity.getWindow(), 1.0F);
  }
  
  public static boolean veryLargeScreen(Context paramContext)
  {
    return getScreenHeight(paramContext) * getScreenWidth(paramContext) >= 2073600;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.device.LightDeviceUtils
 * JD-Core Version:    0.7.0.1
 */