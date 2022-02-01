package org.light.device;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
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
  private static final String TAG = LightDeviceUtils.class.getSimpleName();
  private static float cpuRate;
  public static Handler handler;
  public static HandlerThread handlerThread;
  private static long lastCpuIdleTime = 0L;
  private static long lastCpuTotalTime;
  private static boolean mIsAllUnusable = false;
  private static boolean mIsOpenGlEsValid = true;
  public static int openGLESVersion = 65536;
  private static int recordCpuCount;
  private static int sCpuCount;
  private static String sCpuName;
  private static long sMaxCpuFreq;
  private static int sTotalMemory = 0;
  
  static
  {
    sMaxCpuFreq = 0L;
    sCpuCount = 0;
    handlerThread = null;
    handler = null;
    recordCpuCount = 0;
    cpuRate = 0.0F;
    lastCpuTotalTime = 0L;
  }
  
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
    paramString = new File(str + File.separator + "test_temp.txt");
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
    //   0: aconst_null
    //   1: astore 4
    //   3: new 180	java/net/URL
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 181	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 185	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 187	java/net/HttpURLConnection
    //   17: astore_0
    //   18: iconst_1
    //   19: invokestatic 191	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   22: aload_0
    //   23: ldc 193
    //   25: invokevirtual 196	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: ldc 198
    //   31: ldc 200
    //   33: invokevirtual 204	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: invokevirtual 208	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   40: astore_3
    //   41: sipush 1024
    //   44: newarray byte
    //   46: astore 4
    //   48: iconst_0
    //   49: istore_1
    //   50: iload_1
    //   51: aload 4
    //   53: arraylength
    //   54: if_icmpge +27 -> 81
    //   57: aload_3
    //   58: aload 4
    //   60: iload_1
    //   61: aload 4
    //   63: arraylength
    //   64: iload_1
    //   65: isub
    //   66: invokevirtual 214	java/io/InputStream:read	([BII)I
    //   69: istore_2
    //   70: iload_2
    //   71: iflt +10 -> 81
    //   74: iload_1
    //   75: iload_2
    //   76: iadd
    //   77: istore_1
    //   78: goto -28 -> 50
    //   81: new 115	java/lang/String
    //   84: dup
    //   85: aload 4
    //   87: ldc 216
    //   89: invokespecial 219	java/lang/String:<init>	([BLjava/lang/String;)V
    //   92: astore 4
    //   94: aload_3
    //   95: ifnull +7 -> 102
    //   98: aload_3
    //   99: invokevirtual 222	java/io/InputStream:close	()V
    //   102: aload_0
    //   103: ifnull +7 -> 110
    //   106: aload_0
    //   107: invokevirtual 225	java/net/HttpURLConnection:disconnect	()V
    //   110: aload 4
    //   112: areturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual 162	java/lang/Exception:printStackTrace	()V
    //   118: goto -8 -> 110
    //   121: astore 4
    //   123: aconst_null
    //   124: astore_0
    //   125: aconst_null
    //   126: astore_3
    //   127: aload_0
    //   128: astore 6
    //   130: aload_3
    //   131: astore 5
    //   133: aload 4
    //   135: invokevirtual 226	java/net/MalformedURLException:printStackTrace	()V
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 222	java/io/InputStream:close	()V
    //   146: aload_0
    //   147: ifnull +7 -> 154
    //   150: aload_0
    //   151: invokevirtual 225	java/net/HttpURLConnection:disconnect	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_0
    //   157: aload_0
    //   158: invokevirtual 162	java/lang/Exception:printStackTrace	()V
    //   161: goto -7 -> 154
    //   164: astore 4
    //   166: aconst_null
    //   167: astore_0
    //   168: aconst_null
    //   169: astore_3
    //   170: aload_0
    //   171: astore 6
    //   173: aload_3
    //   174: astore 5
    //   176: aload 4
    //   178: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   181: aload_3
    //   182: ifnull +7 -> 189
    //   185: aload_3
    //   186: invokevirtual 222	java/io/InputStream:close	()V
    //   189: aload_0
    //   190: ifnull -36 -> 154
    //   193: aload_0
    //   194: invokevirtual 225	java/net/HttpURLConnection:disconnect	()V
    //   197: goto -43 -> 154
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 162	java/lang/Exception:printStackTrace	()V
    //   205: goto -51 -> 154
    //   208: astore_0
    //   209: aconst_null
    //   210: astore_3
    //   211: aload_3
    //   212: ifnull +7 -> 219
    //   215: aload_3
    //   216: invokevirtual 222	java/io/InputStream:close	()V
    //   219: aload 4
    //   221: ifnull +8 -> 229
    //   224: aload 4
    //   226: invokevirtual 225	java/net/HttpURLConnection:disconnect	()V
    //   229: aload_0
    //   230: athrow
    //   231: astore_3
    //   232: aload_3
    //   233: invokevirtual 162	java/lang/Exception:printStackTrace	()V
    //   236: goto -7 -> 229
    //   239: astore 5
    //   241: aconst_null
    //   242: astore_3
    //   243: aload_0
    //   244: astore 4
    //   246: aload 5
    //   248: astore_0
    //   249: goto -38 -> 211
    //   252: astore 5
    //   254: aload_0
    //   255: astore 4
    //   257: aload 5
    //   259: astore_0
    //   260: goto -49 -> 211
    //   263: astore_0
    //   264: aload 6
    //   266: astore 4
    //   268: aload 5
    //   270: astore_3
    //   271: goto -60 -> 211
    //   274: astore 4
    //   276: aconst_null
    //   277: astore_3
    //   278: goto -108 -> 170
    //   281: astore 4
    //   283: goto -113 -> 170
    //   286: astore 4
    //   288: aconst_null
    //   289: astore_3
    //   290: goto -163 -> 127
    //   293: astore 4
    //   295: goto -168 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramString	String
    //   49	29	1	i	int
    //   69	8	2	j	int
    //   40	176	3	localInputStream1	java.io.InputStream
    //   231	2	3	localException	Exception
    //   242	48	3	localObject1	Object
    //   1	110	4	localObject2	Object
    //   121	13	4	localMalformedURLException1	java.net.MalformedURLException
    //   164	61	4	localIOException1	IOException
    //   244	23	4	localObject3	Object
    //   274	1	4	localIOException2	IOException
    //   281	1	4	localIOException3	IOException
    //   286	1	4	localMalformedURLException2	java.net.MalformedURLException
    //   293	1	4	localMalformedURLException3	java.net.MalformedURLException
    //   131	44	5	localInputStream2	java.io.InputStream
    //   239	8	5	localObject4	Object
    //   252	17	5	localObject5	Object
    //   128	137	6	str	String
    // Exception table:
    //   from	to	target	type
    //   98	102	113	java/lang/Exception
    //   106	110	113	java/lang/Exception
    //   3	18	121	java/net/MalformedURLException
    //   142	146	156	java/lang/Exception
    //   150	154	156	java/lang/Exception
    //   3	18	164	java/io/IOException
    //   185	189	200	java/lang/Exception
    //   193	197	200	java/lang/Exception
    //   3	18	208	finally
    //   215	219	231	java/lang/Exception
    //   224	229	231	java/lang/Exception
    //   18	41	239	finally
    //   41	48	252	finally
    //   50	70	252	finally
    //   81	94	252	finally
    //   133	138	263	finally
    //   176	181	263	finally
    //   18	41	274	java/io/IOException
    //   41	48	281	java/io/IOException
    //   50	70	281	java/io/IOException
    //   81	94	281	java/io/IOException
    //   18	41	286	java/net/MalformedURLException
    //   41	48	293	java/net/MalformedURLException
    //   50	70	293	java/net/MalformedURLException
    //   81	94	293	java/net/MalformedURLException
  }
  
  @RequiresApi(api=19)
  public static int getApplicationMemory()
  {
    Debug.MemoryInfo localMemoryInfo = new Debug.MemoryInfo();
    Debug.getMemoryInfo(localMemoryInfo);
    int i = localMemoryInfo.getTotalPrivateClean();
    int j = localMemoryInfo.getTotalPrivateDirty();
    int k = localMemoryInfo.getTotalPss();
    int m = localMemoryInfo.getTotalSharedClean();
    int n = localMemoryInfo.getTotalSharedDirty();
    return localMemoryInfo.getTotalSwappablePss() + (i + j + k + m + n);
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
    //   0: new 298	java/io/BufferedReader
    //   3: dup
    //   4: new 300	java/io/FileReader
    //   7: dup
    //   8: ldc_w 302
    //   11: invokespecial 303	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 306	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   17: astore_1
    //   18: aload_1
    //   19: astore_0
    //   20: aload_1
    //   21: invokevirtual 309	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +106 -> 132
    //   29: aload_1
    //   30: astore_0
    //   31: aload_2
    //   32: ldc_w 311
    //   35: iconst_2
    //   36: invokevirtual 315	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   39: astore_3
    //   40: aload_1
    //   41: astore_0
    //   42: aload_3
    //   43: arraylength
    //   44: iconst_1
    //   45: if_icmple +77 -> 122
    //   48: aload_1
    //   49: astore_0
    //   50: aload_3
    //   51: iconst_0
    //   52: aaload
    //   53: invokevirtual 318	java/lang/String:trim	()Ljava/lang/String;
    //   56: invokevirtual 321	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   59: ldc_w 323
    //   62: invokevirtual 326	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   65: ifeq +57 -> 122
    //   68: aload_1
    //   69: astore_0
    //   70: getstatic 58	org/light/device/LightDeviceUtils:TAG	Ljava/lang/String;
    //   73: new 129	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 328
    //   83: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 333	org/light/utils/LightLogUtil:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_1
    //   97: astore_0
    //   98: aload_3
    //   99: iconst_1
    //   100: aaload
    //   101: invokevirtual 318	java/lang/String:trim	()Ljava/lang/String;
    //   104: astore_2
    //   105: aload_1
    //   106: ifnull +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 334	java/io/BufferedReader:close	()V
    //   113: aload_2
    //   114: areturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   120: aload_2
    //   121: areturn
    //   122: aload_1
    //   123: astore_0
    //   124: aload_1
    //   125: invokevirtual 309	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   128: astore_2
    //   129: goto -104 -> 25
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 334	java/io/BufferedReader:close	()V
    //   140: ldc_w 288
    //   143: areturn
    //   144: astore_0
    //   145: aload_0
    //   146: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   149: goto -9 -> 140
    //   152: astore_2
    //   153: aconst_null
    //   154: astore_1
    //   155: aload_1
    //   156: astore_0
    //   157: aload_2
    //   158: invokevirtual 335	java/io/FileNotFoundException:printStackTrace	()V
    //   161: aload_1
    //   162: ifnull -22 -> 140
    //   165: aload_1
    //   166: invokevirtual 334	java/io/BufferedReader:close	()V
    //   169: goto -29 -> 140
    //   172: astore_0
    //   173: aload_0
    //   174: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   177: goto -37 -> 140
    //   180: astore_2
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: astore_0
    //   185: aload_2
    //   186: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   189: aload_1
    //   190: ifnull -50 -> 140
    //   193: aload_1
    //   194: invokevirtual 334	java/io/BufferedReader:close	()V
    //   197: goto -57 -> 140
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   205: goto -65 -> 140
    //   208: astore_1
    //   209: aconst_null
    //   210: astore_0
    //   211: aload_0
    //   212: ifnull +7 -> 219
    //   215: aload_0
    //   216: invokevirtual 334	java/io/BufferedReader:close	()V
    //   219: aload_1
    //   220: athrow
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 227	java/io/IOException:printStackTrace	()V
    //   226: goto -7 -> 219
    //   229: astore_1
    //   230: goto -19 -> 211
    //   233: astore_2
    //   234: goto -51 -> 183
    //   237: astore_2
    //   238: goto -83 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   19	79	0	localBufferedReader1	java.io.BufferedReader
    //   115	2	0	localIOException1	IOException
    //   123	1	0	localBufferedReader2	java.io.BufferedReader
    //   144	2	0	localIOException2	IOException
    //   156	1	0	localBufferedReader3	java.io.BufferedReader
    //   172	2	0	localIOException3	IOException
    //   184	1	0	localBufferedReader4	java.io.BufferedReader
    //   200	2	0	localIOException4	IOException
    //   210	6	0	localObject1	Object
    //   221	2	0	localIOException5	IOException
    //   17	177	1	localBufferedReader5	java.io.BufferedReader
    //   208	12	1	localObject2	Object
    //   229	1	1	localObject3	Object
    //   24	105	2	str	String
    //   152	6	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   180	6	2	localIOException6	IOException
    //   233	1	2	localIOException7	IOException
    //   237	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   39	60	3	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   109	113	115	java/io/IOException
    //   136	140	144	java/io/IOException
    //   0	18	152	java/io/FileNotFoundException
    //   165	169	172	java/io/IOException
    //   0	18	180	java/io/IOException
    //   193	197	200	java/io/IOException
    //   0	18	208	finally
    //   215	219	221	java/io/IOException
    //   20	25	229	finally
    //   31	40	229	finally
    //   42	48	229	finally
    //   50	68	229	finally
    //   70	96	229	finally
    //   98	105	229	finally
    //   124	129	229	finally
    //   157	161	229	finally
    //   185	189	229	finally
    //   20	25	233	java/io/IOException
    //   31	40	233	java/io/IOException
    //   42	48	233	java/io/IOException
    //   50	68	233	java/io/IOException
    //   70	96	233	java/io/IOException
    //   98	105	233	java/io/IOException
    //   124	129	233	java/io/IOException
    //   20	25	237	java/io/FileNotFoundException
    //   31	40	237	java/io/FileNotFoundException
    //   42	48	237	java/io/FileNotFoundException
    //   50	68	237	java/io/FileNotFoundException
    //   70	96	237	java/io/FileNotFoundException
    //   98	105	237	java/io/FileNotFoundException
    //   124	129	237	java/io/FileNotFoundException
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
    File localFile = paramContext.getExternalFilesDir(null);
    Object localObject = localFile;
    if (localFile == null)
    {
      localObject = "/Android/data/" + paramContext.getPackageName() + "/files/";
      localObject = new File(paramContext.getExternalFilesDir(null) + (String)localObject);
    }
    return localObject;
  }
  
  public static File getExternalFilesDir(Context paramContext, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (isExternalStorageAvailable(paramContext))
    {
      localObject1 = localObject2;
      if (isExternalStorageSpaceEnough(paramContext, 52428800L)) {
        localObject1 = getExternalFilesDir(paramContext).getPath();
      }
    }
    paramContext = new File((String)localObject1 + File.separator + paramString);
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
    LightLogUtil.v(TAG, "getHeapAllocatedSizeInKb(), heapAllocated = " + (float)l / 1024.0F + "(Mb), " + l + "(Kb)");
    return l;
  }
  
  public static long getHeapMaxSizeInKb(Context paramContext)
  {
    long l = getRuntimeMaxMemory(1);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      LightLogUtil.v(TAG, "getHeapMaxSizeInKb(), heap size(Mb) = " + paramContext.getMemoryClass());
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
      LightLogUtil.v(TAG, "getHeapMaxSizeInMb(), heap size(Mb) = " + paramContext.getMemoryClass());
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
    LightLogUtil.v(TAG, "getHeapRemainSizeInKb(), remainSize = " + (float)l / 1024.0F + "(Mb), " + l + "(Kb)");
    return l;
  }
  
  public static long getLargeHeapMaxSizeInKb(Context paramContext)
  {
    long l = getRuntimeMaxMemory(1);
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      LightLogUtil.v(TAG, "getLargeHeapMaxSizeInKb(), heap size(Mb) = " + paramContext.getLargeMemoryClass());
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
    LightLogUtil.v(TAG, "getLargeHeapRemainSizeInKb(), remainSize = " + (float)l / 1024.0F + "(Mb), " + l + "(Kb)");
    return l;
  }
  
  public static String getLocalIpAddress()
  {
    try
    {
      if (NetworkInterface.getNetworkInterfaces() != null)
      {
        Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
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
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aconst_null
    //   5: astore_1
    //   6: invokestatic 502	java/net/NetworkInterface:getNetworkInterfaces	()Ljava/util/Enumeration;
    //   9: astore 6
    //   11: iconst_0
    //   12: istore_0
    //   13: aconst_null
    //   14: astore_2
    //   15: aload 6
    //   17: ifnull +200 -> 217
    //   20: aload_2
    //   21: astore 4
    //   23: aload_2
    //   24: astore_3
    //   25: aload 6
    //   27: invokeinterface 507 1 0
    //   32: ifeq +185 -> 217
    //   35: iload_0
    //   36: ifne +181 -> 217
    //   39: aload_2
    //   40: astore 4
    //   42: aload_2
    //   43: astore_3
    //   44: aload 6
    //   46: invokeinterface 510 1 0
    //   51: checkcast 498	java/net/NetworkInterface
    //   54: invokevirtual 513	java/net/NetworkInterface:getInetAddresses	()Ljava/util/Enumeration;
    //   57: astore 5
    //   59: aload_2
    //   60: astore 4
    //   62: aload_2
    //   63: astore_3
    //   64: aload 5
    //   66: invokeinterface 507 1 0
    //   71: ifeq +254 -> 325
    //   74: aload_2
    //   75: astore 4
    //   77: aload_2
    //   78: astore_3
    //   79: aload 5
    //   81: invokeinterface 510 1 0
    //   86: checkcast 515	java/net/InetAddress
    //   89: astore 7
    //   91: aload_2
    //   92: astore 4
    //   94: aload_2
    //   95: astore_3
    //   96: aload 7
    //   98: invokevirtual 538	java/net/InetAddress:isSiteLocalAddress	()Z
    //   101: ifne +56 -> 157
    //   104: aload_2
    //   105: astore 4
    //   107: aload_2
    //   108: astore_3
    //   109: aload 7
    //   111: invokevirtual 518	java/net/InetAddress:isLoopbackAddress	()Z
    //   114: ifne +43 -> 157
    //   117: aload_2
    //   118: astore 4
    //   120: aload_2
    //   121: astore_3
    //   122: aload 7
    //   124: invokevirtual 523	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   127: ldc_w 540
    //   130: invokevirtual 543	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   133: iconst_m1
    //   134: if_icmpne +23 -> 157
    //   137: aload_2
    //   138: astore 4
    //   140: aload_2
    //   141: astore_3
    //   142: aload 7
    //   144: invokevirtual 523	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   147: astore 5
    //   149: iconst_1
    //   150: istore_0
    //   151: aload 5
    //   153: astore_1
    //   154: goto +171 -> 325
    //   157: aload_2
    //   158: astore 4
    //   160: aload_2
    //   161: astore_3
    //   162: aload 7
    //   164: invokevirtual 538	java/net/InetAddress:isSiteLocalAddress	()Z
    //   167: ifeq -108 -> 59
    //   170: aload_2
    //   171: astore 4
    //   173: aload_2
    //   174: astore_3
    //   175: aload 7
    //   177: invokevirtual 518	java/net/InetAddress:isLoopbackAddress	()Z
    //   180: ifne -121 -> 59
    //   183: aload_2
    //   184: astore 4
    //   186: aload_2
    //   187: astore_3
    //   188: aload 7
    //   190: invokevirtual 523	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   193: ldc_w 540
    //   196: invokevirtual 543	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   199: iconst_m1
    //   200: if_icmpne -141 -> 59
    //   203: aload_2
    //   204: astore 4
    //   206: aload_2
    //   207: astore_3
    //   208: aload 7
    //   210: invokevirtual 523	java/net/InetAddress:getHostAddress	()Ljava/lang/String;
    //   213: astore_2
    //   214: goto -155 -> 59
    //   217: aload_1
    //   218: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   221: ifne +5 -> 226
    //   224: aload_1
    //   225: areturn
    //   226: invokestatic 545	org/light/device/LightDeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   229: astore_3
    //   230: aload_3
    //   231: astore_1
    //   232: aload_3
    //   233: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   236: ifeq -12 -> 224
    //   239: aload_2
    //   240: areturn
    //   241: astore 4
    //   243: aconst_null
    //   244: astore_3
    //   245: aload 4
    //   247: invokevirtual 546	java/net/SocketException:printStackTrace	()V
    //   250: aload_2
    //   251: astore_1
    //   252: aload_2
    //   253: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   256: ifeq -32 -> 224
    //   259: invokestatic 545	org/light/device/LightDeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   262: astore_2
    //   263: aload_2
    //   264: astore_1
    //   265: aload_2
    //   266: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   269: ifeq -45 -> 224
    //   272: aload_3
    //   273: areturn
    //   274: astore_1
    //   275: aconst_null
    //   276: astore_1
    //   277: aload_3
    //   278: astore_2
    //   279: aload_1
    //   280: astore_3
    //   281: aload_2
    //   282: astore_1
    //   283: aload_2
    //   284: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   287: ifeq -63 -> 224
    //   290: invokestatic 545	org/light/device/LightDeviceUtils:getExternalLocalIpAddress	()Ljava/lang/String;
    //   293: astore_2
    //   294: aload_2
    //   295: astore_1
    //   296: aload_2
    //   297: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   300: ifeq -76 -> 224
    //   303: aload_3
    //   304: areturn
    //   305: astore_2
    //   306: aload 4
    //   308: astore_3
    //   309: aload_1
    //   310: astore_2
    //   311: goto -30 -> 281
    //   314: astore_1
    //   315: goto -34 -> 281
    //   318: astore 4
    //   320: aload_1
    //   321: astore_2
    //   322: goto -77 -> 245
    //   325: goto -310 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	139	0	i	int
    //   5	260	1	localObject1	Object
    //   274	1	1	localObject2	Object
    //   276	34	1	localObject3	Object
    //   314	7	1	localObject4	Object
    //   1	296	2	localObject5	Object
    //   305	1	2	localObject6	Object
    //   310	12	2	localObject7	Object
    //   3	306	3	localObject8	Object
    //   21	184	4	localObject9	Object
    //   241	66	4	localSocketException1	SocketException
    //   318	1	4	localSocketException2	SocketException
    //   57	95	5	localObject10	Object
    //   9	36	6	localEnumeration	Enumeration
    //   89	120	7	localInetAddress	InetAddress
    // Exception table:
    //   from	to	target	type
    //   6	11	241	java/net/SocketException
    //   6	11	274	finally
    //   25	35	305	finally
    //   44	59	305	finally
    //   64	74	305	finally
    //   79	91	305	finally
    //   96	104	305	finally
    //   109	117	305	finally
    //   122	137	305	finally
    //   142	149	305	finally
    //   162	170	305	finally
    //   175	183	305	finally
    //   188	203	305	finally
    //   208	214	305	finally
    //   245	250	314	finally
    //   25	35	318	java/net/SocketException
    //   44	59	318	java/net/SocketException
    //   64	74	318	java/net/SocketException
    //   79	91	318	java/net/SocketException
    //   96	104	318	java/net/SocketException
    //   109	117	318	java/net/SocketException
    //   122	137	318	java/net/SocketException
    //   142	149	318	java/net/SocketException
    //   162	170	318	java/net/SocketException
    //   175	183	318	java/net/SocketException
    //   188	203	318	java/net/SocketException
    //   208	214	318	java/net/SocketException
  }
  
  public static String getMachineInfo()
  {
    return DeviceInstance.getInstance().getDeviceName();
  }
  
  /* Error */
  public static long getMaxCpuFreq()
  {
    // Byte code:
    //   0: getstatic 62	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   3: lconst_0
    //   4: lcmp
    //   5: ifle +7 -> 12
    //   8: getstatic 62	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   11: lreturn
    //   12: iconst_0
    //   13: istore_0
    //   14: iload_0
    //   15: invokestatic 562	org/light/device/LightDeviceUtils:getNumCores	()I
    //   18: if_icmpge +194 -> 212
    //   21: new 110	java/io/File
    //   24: dup
    //   25: new 129	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 564
    //   35: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_0
    //   39: invokevirtual 470	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: ldc_w 566
    //   45: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 142	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore_2
    //   55: aload_2
    //   56: invokevirtual 150	java/io/File:exists	()Z
    //   59: ifeq +214 -> 273
    //   62: sipush 128
    //   65: newarray byte
    //   67: astore_3
    //   68: new 568	java/io/FileInputStream
    //   71: dup
    //   72: aload_2
    //   73: invokespecial 571	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   76: astore_2
    //   77: aload_2
    //   78: aload_3
    //   79: invokevirtual 574	java/io/FileInputStream:read	([B)I
    //   82: pop
    //   83: iconst_0
    //   84: istore_1
    //   85: aload_3
    //   86: iload_1
    //   87: baload
    //   88: bipush 48
    //   90: if_icmplt +24 -> 114
    //   93: aload_3
    //   94: iload_1
    //   95: baload
    //   96: bipush 57
    //   98: if_icmpgt +16 -> 114
    //   101: iload_1
    //   102: aload_3
    //   103: arraylength
    //   104: if_icmpge +10 -> 114
    //   107: iload_1
    //   108: iconst_1
    //   109: iadd
    //   110: istore_1
    //   111: goto -26 -> 85
    //   114: new 115	java/lang/String
    //   117: dup
    //   118: aload_3
    //   119: iconst_0
    //   120: iload_1
    //   121: invokespecial 577	java/lang/String:<init>	([BII)V
    //   124: invokestatic 172	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   127: invokestatic 581	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: astore_3
    //   131: aload_3
    //   132: invokevirtual 584	java/lang/Integer:intValue	()I
    //   135: i2l
    //   136: getstatic 62	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   139: lcmp
    //   140: ifle +11 -> 151
    //   143: aload_3
    //   144: invokevirtual 584	java/lang/Integer:intValue	()I
    //   147: i2l
    //   148: putstatic 62	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   151: aload_2
    //   152: invokevirtual 585	java/io/FileInputStream:close	()V
    //   155: goto +118 -> 273
    //   158: astore_3
    //   159: aload_2
    //   160: invokevirtual 585	java/io/FileInputStream:close	()V
    //   163: goto +110 -> 273
    //   166: astore_2
    //   167: ldc2_w 586
    //   170: putstatic 62	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   173: ldc_w 589
    //   176: new 129	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 591
    //   186: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: getstatic 62	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   192: invokevirtual 454	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 459	org/light/utils/LightLogUtil:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: getstatic 62	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   204: lreturn
    //   205: astore_3
    //   206: aload_2
    //   207: invokevirtual 585	java/io/FileInputStream:close	()V
    //   210: aload_3
    //   211: athrow
    //   212: getstatic 62	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   215: ldc2_w 586
    //   218: lcmp
    //   219: ifne -46 -> 173
    //   222: new 568	java/io/FileInputStream
    //   225: dup
    //   226: ldc_w 302
    //   229: invokespecial 592	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   232: astore_2
    //   233: ldc_w 594
    //   236: aload_2
    //   237: invokestatic 598	org/light/device/LightDeviceUtils:parseFileForValue	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   240: sipush 1000
    //   243: imul
    //   244: istore_0
    //   245: iload_0
    //   246: i2l
    //   247: getstatic 62	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   250: lcmp
    //   251: ifle +8 -> 259
    //   254: iload_0
    //   255: i2l
    //   256: putstatic 62	org/light/device/LightDeviceUtils:sMaxCpuFreq	J
    //   259: aload_2
    //   260: invokevirtual 585	java/io/FileInputStream:close	()V
    //   263: goto -90 -> 173
    //   266: astore_3
    //   267: aload_2
    //   268: invokevirtual 585	java/io/FileInputStream:close	()V
    //   271: aload_3
    //   272: athrow
    //   273: iload_0
    //   274: iconst_1
    //   275: iadd
    //   276: istore_0
    //   277: goto -263 -> 14
    // Local variable table:
    //   start	length	slot	name	signature
    //   13	264	0	i	int
    //   84	37	1	j	int
    //   54	106	2	localObject1	Object
    //   166	41	2	localIOException	IOException
    //   232	36	2	localFileInputStream	FileInputStream
    //   67	77	3	localObject2	Object
    //   158	1	3	localNumberFormatException	NumberFormatException
    //   205	6	3	localObject3	Object
    //   266	6	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   77	83	158	java/lang/NumberFormatException
    //   101	107	158	java/lang/NumberFormatException
    //   114	151	158	java/lang/NumberFormatException
    //   14	77	166	java/io/IOException
    //   151	155	166	java/io/IOException
    //   159	163	166	java/io/IOException
    //   206	212	166	java/io/IOException
    //   212	233	166	java/io/IOException
    //   259	263	166	java/io/IOException
    //   267	273	166	java/io/IOException
    //   77	83	205	finally
    //   101	107	205	finally
    //   114	151	205	finally
    //   233	259	266	finally
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
      case 1: 
      case 2: 
      case 4: 
        return 1;
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 15: 
        return 2;
      }
      return 3;
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
      switch (i)
      {
      default: 
        return 5;
      case 1: 
        return 2;
      case 2: 
        return 3;
      }
      return 4;
    }
    catch (Exception paramContext)
    {
      LightLogUtil.e(paramContext);
    }
    return 5;
  }
  
  public static String getNetworkTypeName(Context paramContext)
  {
    switch (getNetworkType(paramContext))
    {
    default: 
      return "unknow";
    case 0: 
      return "none";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "wifi";
  }
  
  public static int getNumCores()
  {
    if (sCpuCount > 0) {
      return sCpuCount;
    }
    for (;;)
    {
      try
      {
        File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new LightDeviceUtils.1CpuFilter());
        if (arrayOfFile == null) {
          continue;
        }
        sCpuCount = arrayOfFile.length;
      }
      catch (Throwable localThrowable)
      {
        LightLogUtil.e(localThrowable);
        sCpuCount = 1;
        continue;
      }
      LightLogUtil.v("DeviceUtils", "sCpuCount:" + sCpuCount);
      return sCpuCount;
      sCpuCount = 1;
    }
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
    switch (paramInt)
    {
    default: 
      l = Runtime.getRuntime().freeMemory();
    }
    for (;;)
    {
      LightLogUtil.v(TAG, "[getRuntimeFreeMemory] freeMemory = " + Runtime.getRuntime().freeMemory() / 1024L / 1024L + "(Mb), " + Runtime.getRuntime().freeMemory() / 1024L + "(Kb)");
      return l;
      l = Runtime.getRuntime().freeMemory();
      continue;
      l = Runtime.getRuntime().freeMemory() / 1024L;
      continue;
      l = Runtime.getRuntime().freeMemory() / 1024L / 1024L;
    }
  }
  
  private static long getRuntimeMaxMemory(int paramInt)
  {
    long l = Runtime.getRuntime().maxMemory();
    switch (paramInt)
    {
    }
    for (;;)
    {
      LightLogUtil.v(TAG, "[getRuntimeMaxMemory] maxMemory = " + Runtime.getRuntime().maxMemory() / 1024L / 1024L + "(Mb), " + Runtime.getRuntime().maxMemory() / 1024L + "(Kb)");
      return l;
      l = Runtime.getRuntime().maxMemory();
      continue;
      l = Runtime.getRuntime().maxMemory() / 1024L;
      continue;
      l = Runtime.getRuntime().maxMemory() / 1024L / 1024L;
    }
  }
  
  public static long getRuntimeRemainSize(int paramInt)
  {
    long l2 = Runtime.getRuntime().maxMemory() - getHeapAllocatedSizeInKb() * 1024L;
    long l1 = l2;
    switch (paramInt)
    {
    default: 
      l1 = l2;
    }
    for (;;)
    {
      LightLogUtil.v(TAG, "[getRuntimeRemainSize] remainMemory = " + l1 + " " + paramInt);
      return l1;
      l1 = l2 / 1024L;
      continue;
      l1 = l2 / 1048576L;
    }
  }
  
  private static long getRuntimeTotalMemory(int paramInt)
  {
    long l;
    switch (paramInt)
    {
    default: 
      l = Runtime.getRuntime().totalMemory();
    }
    for (;;)
    {
      LightLogUtil.v(TAG, "[getRuntimeTotalMemory] totalMemory = " + Runtime.getRuntime().totalMemory() / 1024L / 1024L + "(Mb), " + Runtime.getRuntime().totalMemory() / 1024L + "(Kb)");
      return l;
      l = Runtime.getRuntime().totalMemory();
      continue;
      l = Runtime.getRuntime().totalMemory() / 1024L;
      continue;
      l = Runtime.getRuntime().totalMemory() / 1024L / 1024L;
    }
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
    return "" + paramContext.widthPixels + "*" + paramContext.heightPixels;
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
  
  /* Error */
  public static long getTotalRamMemory(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 794	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 16
    //   5: if_icmplt +46 -> 51
    //   8: aload_0
    //   9: ifnull +42 -> 51
    //   12: new 796	android/app/ActivityManager$MemoryInfo
    //   15: dup
    //   16: invokespecial 797	android/app/ActivityManager$MemoryInfo:<init>	()V
    //   19: astore 4
    //   21: aload_0
    //   22: ldc_w 350
    //   25: invokevirtual 356	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   28: checkcast 358	android/app/ActivityManager
    //   31: aload 4
    //   33: invokevirtual 800	android/app/ActivityManager:getMemoryInfo	(Landroid/app/ActivityManager$MemoryInfo;)V
    //   36: aload 4
    //   38: ifnull +9 -> 47
    //   41: aload 4
    //   43: getfield 803	android/app/ActivityManager$MemoryInfo:totalMem	J
    //   46: lreturn
    //   47: ldc2_w 586
    //   50: lreturn
    //   51: new 568	java/io/FileInputStream
    //   54: dup
    //   55: ldc_w 805
    //   58: invokespecial 592	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   61: astore_0
    //   62: ldc_w 807
    //   65: aload_0
    //   66: invokestatic 598	org/light/device/LightDeviceUtils:parseFileForValue	(Ljava/lang/String;Ljava/io/FileInputStream;)I
    //   69: istore_1
    //   70: iload_1
    //   71: i2l
    //   72: ldc2_w 716
    //   75: lmul
    //   76: lstore_2
    //   77: aload_0
    //   78: invokevirtual 585	java/io/FileInputStream:close	()V
    //   81: lload_2
    //   82: lreturn
    //   83: astore_0
    //   84: lload_2
    //   85: lreturn
    //   86: astore 4
    //   88: aload_0
    //   89: invokevirtual 585	java/io/FileInputStream:close	()V
    //   92: aload 4
    //   94: athrow
    //   95: astore_0
    //   96: ldc2_w 586
    //   99: lreturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramContext	Context
    //   69	2	1	i	int
    //   76	9	2	l	long
    //   19	23	4	localMemoryInfo	android.app.ActivityManager.MemoryInfo
    //   86	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   77	81	83	java/io/IOException
    //   62	70	86	finally
    //   51	62	95	java/io/IOException
    //   88	95	95	java/io/IOException
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
    boolean bool = false;
    try
    {
      if (("mounted".equals(Environment.getExternalStorageState())) || (!Environment.isExternalStorageRemovable()))
      {
        new StatFs(paramContext.getExternalFilesDir(null).getAbsolutePath());
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isExternalStorageSpaceEnough(Context paramContext, long paramLong)
  {
    boolean bool = false;
    paramContext = paramContext.getExternalFilesDir(null);
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
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    } while (paramContext == null);
    paramContext = paramContext.getNetworkInfo(0);
    if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isNavigationBarShow(Activity paramActivity)
  {
    int i;
    if (Build.MODEL.equals("Redmi 6")) {
      if (Build.VERSION.SDK_INT < 21)
      {
        i = Settings.System.getInt(paramActivity.getContentResolver(), "force_fsg_nav_bar", 0);
        if (i == 1) {
          break label54;
        }
      }
    }
    label54:
    label119:
    boolean bool1;
    boolean bool2;
    do
    {
      Point localPoint1;
      Point localPoint2;
      do
      {
        return true;
        i = Settings.Global.getInt(paramActivity.getContentResolver(), "force_fsg_nav_bar", 0);
        break;
        return false;
        if (Build.VERSION.SDK_INT < 17) {
          break label119;
        }
        paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
        localPoint1 = new Point();
        localPoint2 = new Point();
        paramActivity.getSize(localPoint1);
        paramActivity.getRealSize(localPoint2);
      } while (localPoint2.y != localPoint1.y);
      return false;
      bool1 = ViewConfiguration.get(paramActivity).hasPermanentMenuKey();
      bool2 = KeyCharacterMap.deviceHasKey(4);
    } while ((!bool1) && (!bool2));
    return false;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnectedOrConnecting())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isValid(Context paramContext)
  {
    if (getOpenGlEsVersion(paramContext) >= 131072) {}
    for (boolean bool = true;; bool = false)
    {
      mIsOpenGlEsValid = bool;
      mIsAllUnusable = false;
      if ((mIsAllUnusable) || (!mIsOpenGlEsValid)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean isWifiNetwork(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return false;
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    } while (paramContext == null);
    paramContext = paramContext.getNetworkInfo(1);
    if ((paramContext != null) && (paramContext.isAvailable()) && (paramContext.isConnected())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
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
    byte[] arrayOfByte = new byte[1024];
    int m;
    int j;
    int i;
    int k;
    for (;;)
    {
      try
      {
        m = paramFileInputStream.read(arrayOfByte);
        j = 0;
      }
      catch (NumberFormatException paramString)
      {
        return -1;
      }
      catch (IOException paramString)
      {
        continue;
      }
      k = i;
      if (j >= m) {
        break label129;
      }
      k = j - i;
      if (arrayOfByte[j] != paramString.charAt(k))
      {
        k = i;
        break label129;
      }
      if (k == paramString.length() - 1)
      {
        i = extractValue(arrayOfByte, j);
        return i;
      }
      j += 1;
    }
    for (;;)
    {
      if (j < m)
      {
        if (arrayOfByte[j] != 10)
        {
          k = j;
          if (j != 0) {}
        }
        else
        {
          i = j;
          if (arrayOfByte[j] == 10) {
            i = j + 1;
          }
          j = i;
          break;
        }
        label129:
        j = k + 1;
      }
    }
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
    if (recordCpuCount % 100 == 0)
    {
      handler.post(new LightDeviceUtils.1());
      return;
    }
    recordCpuCount += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.device.LightDeviceUtils
 * JD-Core Version:    0.7.0.1
 */