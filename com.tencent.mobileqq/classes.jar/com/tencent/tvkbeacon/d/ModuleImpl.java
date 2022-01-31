package com.tencent.tvkbeacon.d;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.tvkbeacon.core.c.a;
import com.tencent.tvkbeacon.core.info.d;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ModuleImpl
  extends com.tencent.tvkbeacon.core.b
{
  private static ModuleImpl mInstance;
  private static final String modelEvent = "rqd_model";
  private boolean modelEventUsable = true;
  
  public ModuleImpl(Context paramContext)
  {
    super(paramContext);
  }
  
  /* Error */
  private int getCPUMhz()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aconst_null
    //   5: astore_3
    //   6: new 106	java/io/BufferedReader
    //   9: dup
    //   10: new 108	java/io/InputStreamReader
    //   13: dup
    //   14: invokestatic 114	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   17: iconst_2
    //   18: anewarray 116	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: ldc 118
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: ldc 120
    //   30: aastore
    //   31: invokevirtual 124	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   34: invokevirtual 130	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   37: invokespecial 133	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore 4
    //   45: aload 4
    //   47: astore_3
    //   48: aload 4
    //   50: invokevirtual 139	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   53: astore 5
    //   55: aload 5
    //   57: ifnull +19 -> 76
    //   60: aload 4
    //   62: astore_3
    //   63: aload 5
    //   65: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   68: invokestatic 148	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   71: sipush 1000
    //   74: idiv
    //   75: istore_1
    //   76: aload 4
    //   78: invokevirtual 152	java/io/BufferedReader:close	()V
    //   81: iload_1
    //   82: ireturn
    //   83: astore_3
    //   84: aload_3
    //   85: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   88: iload_1
    //   89: ireturn
    //   90: astore 5
    //   92: aconst_null
    //   93: astore 4
    //   95: aload 4
    //   97: astore_3
    //   98: aload 5
    //   100: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   103: iload_2
    //   104: istore_1
    //   105: aload 4
    //   107: ifnull -26 -> 81
    //   110: aload 4
    //   112: invokevirtual 152	java/io/BufferedReader:close	()V
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_3
    //   118: aload_3
    //   119: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   122: iconst_0
    //   123: ireturn
    //   124: astore 5
    //   126: aload_3
    //   127: astore 4
    //   129: aload 5
    //   131: astore_3
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 152	java/io/BufferedReader:close	()V
    //   142: aload_3
    //   143: athrow
    //   144: astore 4
    //   146: aload 4
    //   148: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   151: goto -9 -> 142
    //   154: astore 5
    //   156: aload_3
    //   157: astore 4
    //   159: aload 5
    //   161: astore_3
    //   162: goto -30 -> 132
    //   165: astore 5
    //   167: goto -72 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	ModuleImpl
    //   3	102	1	i	int
    //   1	103	2	j	int
    //   5	58	3	localObject1	Object
    //   83	2	3	localIOException1	java.io.IOException
    //   97	1	3	localObject2	Object
    //   117	10	3	localIOException2	java.io.IOException
    //   131	31	3	localObject3	Object
    //   43	95	4	localObject4	Object
    //   144	3	4	localIOException3	java.io.IOException
    //   157	1	4	localObject5	Object
    //   53	11	5	str	String
    //   90	9	5	localThrowable1	Throwable
    //   124	6	5	localObject6	Object
    //   154	6	5	localObject7	Object
    //   165	1	5	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   76	81	83	java/io/IOException
    //   6	45	90	java/lang/Throwable
    //   110	115	117	java/io/IOException
    //   6	45	124	finally
    //   137	142	144	java/io/IOException
    //   48	55	154	finally
    //   63	76	154	finally
    //   98	103	154	finally
    //   48	55	165	java/lang/Throwable
    //   63	76	165	java/lang/Throwable
  }
  
  /* Error */
  private String getCPUProcessor()
  {
    // Byte code:
    //   0: ldc 160
    //   2: astore_3
    //   3: new 106	java/io/BufferedReader
    //   6: dup
    //   7: new 108	java/io/InputStreamReader
    //   10: dup
    //   11: invokestatic 114	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   14: iconst_2
    //   15: anewarray 116	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: ldc 118
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: ldc 162
    //   27: aastore
    //   28: invokevirtual 124	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   31: invokevirtual 130	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   34: invokespecial 133	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   37: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 139	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore 4
    //   49: aload_3
    //   50: astore_1
    //   51: aload 4
    //   53: ifnull +39 -> 92
    //   56: aload_2
    //   57: astore_1
    //   58: aload 4
    //   60: ldc 164
    //   62: invokevirtual 168	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   65: ifeq -24 -> 41
    //   68: aload_2
    //   69: astore_1
    //   70: aload 4
    //   72: aload 4
    //   74: ldc 170
    //   76: invokevirtual 173	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   79: iconst_1
    //   80: iadd
    //   81: invokevirtual 177	java/lang/String:substring	(I)Ljava/lang/String;
    //   84: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   87: astore 4
    //   89: aload 4
    //   91: astore_1
    //   92: aload_2
    //   93: invokevirtual 152	java/io/BufferedReader:close	()V
    //   96: aload_1
    //   97: areturn
    //   98: astore_2
    //   99: aload_2
    //   100: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   103: aload_1
    //   104: areturn
    //   105: astore 4
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: aload 4
    //   113: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   116: aload_3
    //   117: astore_1
    //   118: aload_2
    //   119: ifnull -23 -> 96
    //   122: aload_2
    //   123: invokevirtual 152	java/io/BufferedReader:close	()V
    //   126: ldc 160
    //   128: areturn
    //   129: astore_1
    //   130: aload_1
    //   131: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   134: ldc 160
    //   136: areturn
    //   137: astore_2
    //   138: aconst_null
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 152	java/io/BufferedReader:close	()V
    //   148: aload_2
    //   149: athrow
    //   150: astore_1
    //   151: aload_1
    //   152: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   155: goto -7 -> 148
    //   158: astore_2
    //   159: goto -19 -> 140
    //   162: astore 4
    //   164: goto -55 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	ModuleImpl
    //   42	76	1	localObject1	Object
    //   129	2	1	localIOException1	java.io.IOException
    //   139	6	1	localObject2	Object
    //   150	2	1	localIOException2	java.io.IOException
    //   40	53	2	localBufferedReader	java.io.BufferedReader
    //   98	2	2	localIOException3	java.io.IOException
    //   108	15	2	localObject3	Object
    //   137	12	2	localObject4	Object
    //   158	1	2	localObject5	Object
    //   2	115	3	str1	String
    //   47	43	4	str2	String
    //   105	7	4	localThrowable1	Throwable
    //   162	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   92	96	98	java/io/IOException
    //   3	41	105	java/lang/Throwable
    //   122	126	129	java/io/IOException
    //   3	41	137	finally
    //   144	148	150	java/io/IOException
    //   43	49	158	finally
    //   58	68	158	finally
    //   70	89	158	finally
    //   111	116	158	finally
    //   43	49	162	java/lang/Throwable
    //   58	68	162	java/lang/Throwable
    //   70	89	162	java/lang/Throwable
  }
  
  private String getCountry()
  {
    try
    {
      String str = Locale.getDefault().getCountry();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tvkbeacon.core.c.c.d("[model] getCountry error!", new Object[0]);
      com.tencent.tvkbeacon.core.c.c.a(localThrowable);
    }
    return null;
  }
  
  private String getCpuProductorName()
  {
    String str = null;
    try
    {
      Object localObject = Build.class.getField("HARDWARE").get(null);
      if (localObject != null) {
        str = localObject.toString();
      }
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tvkbeacon.core.c.c.d("[model] get cpu product error!", new Object[0]);
    }
    return null;
  }
  
  private DisplayMetrics getDisplayMetrics()
  {
    try
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tvkbeacon.core.c.c.d("[model] getDisplayMetrics error!", new Object[0]);
      com.tencent.tvkbeacon.core.c.c.a(localThrowable);
    }
    return null;
  }
  
  private long getFreeMem()
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)this.mContext.getSystemService("activity");
      ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
      localActivityManager.getMemoryInfo(localMemoryInfo);
      long l = localMemoryInfo.availMem;
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tvkbeacon.core.c.c.d("[model] getFreeMem error!", new Object[0]);
      com.tencent.tvkbeacon.core.c.c.a(localThrowable);
    }
    return -1L;
  }
  
  private String getFreeMem2()
  {
    String str = "0";
    long l = getFreeMem();
    if (l > 0L) {
      str = l / 1024L / 1024L;
    }
    return str;
  }
  
  public static ModuleImpl getInstance(Context paramContext)
  {
    try
    {
      if (mInstance == null) {
        mInstance = new ModuleImpl(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  private int getNumCores()
  {
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new ModuleImpl.a(this));
      if (arrayOfFile == null) {
        return 1;
      }
      int i = arrayOfFile.length;
      return i;
    }
    catch (Exception localException)
    {
      com.tencent.tvkbeacon.core.c.c.d("[model] CPU Count: Failed.", new Object[0]);
      com.tencent.tvkbeacon.core.c.c.a(localException);
    }
    return 1;
  }
  
  /* Error */
  private String getRamSize()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 302	java/io/FileReader
    //   6: dup
    //   7: ldc_w 304
    //   10: invokespecial 305	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: astore 4
    //   15: new 106	java/io/BufferedReader
    //   18: dup
    //   19: aload 4
    //   21: sipush 8192
    //   24: invokespecial 308	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore_3
    //   28: aload_3
    //   29: astore 6
    //   31: aload 4
    //   33: astore 5
    //   35: aload_3
    //   36: invokevirtual 139	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: ldc_w 310
    //   42: iconst_2
    //   43: invokevirtual 314	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   46: iconst_1
    //   47: aaload
    //   48: invokevirtual 317	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   51: ldc_w 319
    //   54: ldc 160
    //   56: invokevirtual 323	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   59: invokevirtual 142	java/lang/String:trim	()Ljava/lang/String;
    //   62: invokestatic 329	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   65: ldc2_w 269
    //   68: ldiv
    //   69: lstore_1
    //   70: lload_1
    //   71: invokestatic 333	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   74: astore 5
    //   76: aload_3
    //   77: invokevirtual 152	java/io/BufferedReader:close	()V
    //   80: aload 4
    //   82: invokevirtual 334	java/io/FileReader:close	()V
    //   85: aload 5
    //   87: astore_3
    //   88: aload_3
    //   89: areturn
    //   90: astore_3
    //   91: ldc_w 336
    //   94: iconst_0
    //   95: anewarray 188	java/lang/Object
    //   98: invokestatic 192	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_3
    //   102: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   105: aload 5
    //   107: areturn
    //   108: astore 7
    //   110: aconst_null
    //   111: astore_3
    //   112: aconst_null
    //   113: astore 4
    //   115: aload_3
    //   116: astore 6
    //   118: aload 4
    //   120: astore 5
    //   122: ldc_w 338
    //   125: iconst_0
    //   126: anewarray 188	java/lang/Object
    //   129: invokestatic 192	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: aload_3
    //   133: astore 6
    //   135: aload 4
    //   137: astore 5
    //   139: aload 7
    //   141: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   144: aload_3
    //   145: ifnull +7 -> 152
    //   148: aload_3
    //   149: invokevirtual 152	java/io/BufferedReader:close	()V
    //   152: aload 8
    //   154: astore_3
    //   155: aload 4
    //   157: ifnull -69 -> 88
    //   160: aload 4
    //   162: invokevirtual 334	java/io/FileReader:close	()V
    //   165: aconst_null
    //   166: areturn
    //   167: astore_3
    //   168: ldc_w 336
    //   171: iconst_0
    //   172: anewarray 188	java/lang/Object
    //   175: invokestatic 192	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: aload_3
    //   179: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_3
    //   185: aconst_null
    //   186: astore 6
    //   188: aconst_null
    //   189: astore 4
    //   191: aload 6
    //   193: ifnull +8 -> 201
    //   196: aload 6
    //   198: invokevirtual 152	java/io/BufferedReader:close	()V
    //   201: aload 4
    //   203: ifnull +8 -> 211
    //   206: aload 4
    //   208: invokevirtual 334	java/io/FileReader:close	()V
    //   211: aload_3
    //   212: athrow
    //   213: astore 4
    //   215: ldc_w 336
    //   218: iconst_0
    //   219: anewarray 188	java/lang/Object
    //   222: invokestatic 192	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: aload 4
    //   227: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   230: goto -19 -> 211
    //   233: astore_3
    //   234: aconst_null
    //   235: astore 6
    //   237: goto -46 -> 191
    //   240: astore_3
    //   241: aload 5
    //   243: astore 4
    //   245: goto -54 -> 191
    //   248: astore 7
    //   250: aconst_null
    //   251: astore_3
    //   252: goto -137 -> 115
    //   255: astore 7
    //   257: goto -142 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	this	ModuleImpl
    //   69	2	1	l	long
    //   27	62	3	localObject1	Object
    //   90	12	3	localThrowable1	Throwable
    //   111	44	3	localObject2	Object
    //   167	12	3	localThrowable2	Throwable
    //   184	28	3	localObject3	Object
    //   233	1	3	localObject4	Object
    //   240	1	3	localObject5	Object
    //   251	1	3	localObject6	Object
    //   13	194	4	localFileReader	java.io.FileReader
    //   213	13	4	localThrowable3	Throwable
    //   243	1	4	localObject7	Object
    //   33	209	5	localObject8	Object
    //   29	207	6	localObject9	Object
    //   108	32	7	localThrowable4	Throwable
    //   248	1	7	localThrowable5	Throwable
    //   255	1	7	localThrowable6	Throwable
    //   1	152	8	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   76	85	90	java/lang/Throwable
    //   3	15	108	java/lang/Throwable
    //   148	152	167	java/lang/Throwable
    //   160	165	167	java/lang/Throwable
    //   3	15	184	finally
    //   196	201	213	java/lang/Throwable
    //   206	211	213	java/lang/Throwable
    //   15	28	233	finally
    //   35	70	240	finally
    //   122	132	240	finally
    //   139	144	240	finally
    //   15	28	248	java/lang/Throwable
    //   35	70	255	java/lang/Throwable
  }
  
  private String getResolution()
  {
    DisplayMetrics localDisplayMetrics = getDisplayMetrics();
    if (localDisplayMetrics == null) {
      return "";
    }
    return localDisplayMetrics.widthPixels + "*" + localDisplayMetrics.heightPixels;
  }
  
  private String getRomFingerPrint()
  {
    ArrayList localArrayList = a.a(new String[] { "/system/bin/sh", "-c", "getprop ro.build.fingerprint" });
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (String)localArrayList.get(0);
    }
    return "";
  }
  
  private long getSDCardSize()
  {
    d.a(this.mContext);
    if (!d.g()) {
      return 0L;
    }
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      long l = localStatFs.getBlockCount();
      l = i * l / 1024L / 1024L;
      return l;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tvkbeacon.core.c.c.a(localThrowable);
    }
    return 0L;
  }
  
  private int getScreenDpi()
  {
    for (;;)
    {
      try
      {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
        if (localDisplayMetrics.density == 1.0F) {
          return 160;
        }
        if (localDisplayMetrics.density <= 0.75D) {
          return 120;
        }
        if (localDisplayMetrics.density == 1.5D) {
          return 240;
        }
        if (localDisplayMetrics.density == 2.0D) {
          return 320;
        }
        float f = localDisplayMetrics.density;
        if (f == 3.0D)
        {
          i = 480;
          return i;
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.tvkbeacon.core.c.c.a(localThrowable);
        return 160;
      }
      int i = 160;
    }
  }
  
  private String getSensor()
  {
    com.tencent.tvkbeacon.core.c.c.b("[model] getSensor start", new Object[0]);
    Object localObject3 = "X";
    StringBuffer localStringBuffer = new StringBuffer();
    if (Integer.parseInt(Build.VERSION.SDK) >= 10) {}
    for (;;)
    {
      int i;
      try
      {
        localClass = Class.forName("android.hardware.Camera");
        j = ((Integer)localClass.getMethod("getNumberOfCameras", new Class[0]).invoke(localClass, new Object[0])).intValue();
        if (j == 0)
        {
          localObject1 = "N";
          localObject2 = "N";
        }
      }
      catch (Throwable localThrowable1)
      {
        Class localClass;
        int j;
        Object localObject4;
        Object localObject6;
        Object localObject7;
        int k;
        Field localField1;
        Field localField2;
        Field localField3;
        int m;
        int n;
        localObject2 = "X";
        localObject1 = "X";
        com.tencent.tvkbeacon.core.c.c.d("[model] getSensor error!", new Object[0]);
        com.tencent.tvkbeacon.core.c.c.a(localThrowable1);
        Object localObject5 = localObject3;
        localObject3 = localObject2;
        localObject2 = "X";
        continue;
        continue;
        localObject1 = "X";
        localObject2 = "X";
        continue;
      }
      try
      {
        localObject4 = (SensorManager)this.mContext.getSystemService("sensor");
        if (((SensorManager)localObject4).getDefaultSensor(9) != null) {
          localObject3 = "Y";
        }
      }
      catch (Throwable localThrowable3)
      {
        localObject3 = localObject2;
        localObject2 = "X";
        continue;
      }
      try
      {
        if (((SensorManager)localObject4).getDefaultSensor(4) != null)
        {
          localObject6 = "Y";
          localObject4 = localObject2;
          localObject2 = localObject6;
          localStringBuffer.append((String)localObject1).append((String)localObject4).append((String)localObject3).append((String)localObject2);
          return localStringBuffer.toString();
          localObject2 = Class.forName("android.hardware.Camera$CameraInfo");
          localObject7 = ((Class)localObject2).newInstance();
          localObject6 = localClass.getMethods();
          localObject1 = null;
          k = localObject6.length;
          i = 0;
          localObject4 = localObject1;
          if (i < k)
          {
            localObject4 = localObject6[i];
            if (!((Method)localObject4).getName().equals("getCameraInfo")) {
              break label562;
            }
          }
          localField1 = ((Class)localObject2).getField("facing");
          localField2 = ((Class)localObject2).getField("CAMERA_FACING_BACK");
          localField3 = ((Class)localObject2).getField("CAMERA_FACING_FRONT");
          if (localObject4 == null) {
            continue;
          }
          localObject2 = "X";
          localObject1 = "X";
          i = 0;
          if (i >= j) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable4)
      {
        localObject6 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject6;
        continue;
      }
      try
      {
        ((Method)localObject4).invoke(localClass, new Object[] { Integer.valueOf(i), localObject7 });
        k = localField1.getInt(localObject7);
        m = localField2.getInt(localObject7);
        n = localField3.getInt(localObject7);
        if (k == m)
        {
          localObject1 = "Y";
          localObject3 = localObject1;
          if (j == 1)
          {
            localObject2 = "N";
            localObject3 = localObject1;
          }
        }
        else
        {
          localObject3 = localObject1;
          if (k == n)
          {
            localObject6 = "Y";
            localObject2 = localObject6;
            localObject3 = localObject1;
            if (j == 1)
            {
              localObject3 = "N";
              localObject2 = localObject6;
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        localObject3 = localObject2;
        localObject2 = "X";
        continue;
      }
      localObject3 = "N";
      continue;
      localObject6 = "N";
      localObject4 = localObject2;
      Object localObject2 = localObject6;
      continue;
      localObject2 = "X";
      String str = "X";
      localObject3 = "X";
      Object localObject1 = "X";
      continue;
      i += 1;
      localObject1 = localObject3;
      continue;
      label562:
      i += 1;
    }
  }
  
  private String getSensor2()
  {
    com.tencent.tvkbeacon.core.c.c.b("[model] getSensor2 start", new Object[0]);
    Object localObject1 = "X";
    Object localObject2 = "X";
    Object localObject3 = "X";
    String str2;
    Object localObject4;
    Object localObject6;
    Object localObject5;
    if (hasWIFIDevice())
    {
      str2 = "Y";
      if (Integer.parseInt(Build.VERSION.SDK) < 10) {
        break label278;
      }
      localObject4 = localObject3;
      localObject6 = localObject2;
      localObject5 = localObject1;
    }
    for (;;)
    {
      try
      {
        SensorManager localSensorManager = (SensorManager)this.mContext.getSystemService("sensor");
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (localSensorManager.getDefaultSensor(1) == null) {
          continue;
        }
        localObject1 = "Y";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (localSensorManager.getDefaultSensor(5) == null) {
          break label298;
        }
        localObject2 = "Y";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (BluetoothAdapter.getDefaultAdapter() != null) {
          break label305;
        }
        localObject3 = "N";
        localObject4 = localObject3;
        localObject6 = localObject2;
        localObject5 = localObject1;
        if (!this.mContext.getPackageManager().hasSystemFeature("android.hardware.nfc")) {
          continue;
        }
        localObject6 = "Y";
        localObject5 = localObject3;
        localObject4 = localObject1;
        localObject3 = localObject2;
        localObject2 = localObject5;
        localObject1 = localObject6;
      }
      catch (Throwable localThrowable)
      {
        localObject3 = localObject6;
        com.tencent.tvkbeacon.core.c.c.d("[model] getSensor2 error!", new Object[0]);
        localObject2 = localObject4;
        str1 = "X";
        localObject4 = localObject5;
        continue;
      }
      return str2 + (String)localObject4 + (String)localObject3 + (String)localObject2 + (String)localObject1;
      str2 = "N";
      break;
      localObject1 = "N";
      continue;
      localObject6 = "N";
      localObject4 = localObject2;
      localObject5 = localObject1;
      localObject1 = localObject6;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject5;
      continue;
      label278:
      String str1 = "X";
      localObject2 = "X";
      localObject3 = "X";
      localObject4 = "X";
      continue;
      label298:
      localObject2 = "N";
      continue;
      label305:
      localObject3 = "Y";
    }
  }
  
  private String getWifiSSID()
  {
    try
    {
      Object localObject = ((WifiManager)this.mContext.getSystemService("wifi")).getConnectionInfo();
      if (((WifiInfo)localObject).getBSSID() != null)
      {
        localObject = ((WifiInfo)localObject).getSSID();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tvkbeacon.core.c.c.a(localThrowable);
      com.tencent.tvkbeacon.core.c.c.d("[model] getWifiSSID error!", new Object[0]);
    }
    return "";
  }
  
  private String hasGPSDevice()
  {
    Object localObject = (LocationManager)this.mContext.getSystemService("location");
    if (localObject == null) {
      return "N";
    }
    localObject = ((LocationManager)localObject).getAllProviders();
    if (localObject == null) {
      return "N";
    }
    if (((List)localObject).contains("gps")) {
      return "Y";
    }
    return "N";
  }
  
  private boolean hasWIFIDevice()
  {
    return (WifiManager)this.mContext.getSystemService("wifi") != null;
  }
  
  /* Error */
  private boolean isArmV7()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: new 106	java/io/BufferedReader
    //   11: dup
    //   12: new 108	java/io/InputStreamReader
    //   15: dup
    //   16: invokestatic 114	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   19: iconst_2
    //   20: anewarray 116	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc 118
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: ldc 162
    //   32: aastore
    //   33: invokevirtual 124	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   36: invokevirtual 130	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   39: invokespecial 133	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   42: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore 6
    //   47: aload 6
    //   49: astore 5
    //   51: aload 6
    //   53: invokevirtual 139	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   56: astore 7
    //   58: iload_3
    //   59: istore_2
    //   60: aload 7
    //   62: ifnull +26 -> 88
    //   65: aload 6
    //   67: astore 5
    //   69: aload 7
    //   71: invokevirtual 317	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   74: ldc_w 555
    //   77: invokevirtual 173	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   80: istore_1
    //   81: iconst_m1
    //   82: iload_1
    //   83: if_icmpeq -36 -> 47
    //   86: iconst_1
    //   87: istore_2
    //   88: aload 6
    //   90: invokevirtual 152	java/io/BufferedReader:close	()V
    //   93: iload_2
    //   94: ireturn
    //   95: astore 5
    //   97: aload 5
    //   99: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   102: iload_2
    //   103: ireturn
    //   104: astore 7
    //   106: aconst_null
    //   107: astore 6
    //   109: aload 6
    //   111: astore 5
    //   113: aload 7
    //   115: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   118: iload 4
    //   120: istore_2
    //   121: aload 6
    //   123: ifnull -30 -> 93
    //   126: aload 6
    //   128: invokevirtual 152	java/io/BufferedReader:close	()V
    //   131: iconst_0
    //   132: ireturn
    //   133: astore 5
    //   135: aload 5
    //   137: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   140: iconst_0
    //   141: ireturn
    //   142: astore 7
    //   144: aload 5
    //   146: astore 6
    //   148: aload 7
    //   150: astore 5
    //   152: aload 6
    //   154: ifnull +8 -> 162
    //   157: aload 6
    //   159: invokevirtual 152	java/io/BufferedReader:close	()V
    //   162: aload 5
    //   164: athrow
    //   165: astore 6
    //   167: aload 6
    //   169: invokestatic 158	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   172: goto -10 -> 162
    //   175: astore 7
    //   177: aload 5
    //   179: astore 6
    //   181: aload 7
    //   183: astore 5
    //   185: goto -33 -> 152
    //   188: astore 7
    //   190: goto -81 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	ModuleImpl
    //   80	4	1	i	int
    //   59	62	2	bool1	boolean
    //   4	55	3	bool2	boolean
    //   1	118	4	bool3	boolean
    //   6	62	5	localObject1	Object
    //   95	3	5	localIOException1	java.io.IOException
    //   111	1	5	localObject2	Object
    //   133	12	5	localIOException2	java.io.IOException
    //   150	34	5	localObject3	Object
    //   45	113	6	localObject4	Object
    //   165	3	6	localIOException3	java.io.IOException
    //   179	1	6	localObject5	Object
    //   56	14	7	str	String
    //   104	10	7	localThrowable1	Throwable
    //   142	7	7	localObject6	Object
    //   175	7	7	localObject7	Object
    //   188	1	7	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   88	93	95	java/io/IOException
    //   8	47	104	java/lang/Throwable
    //   126	131	133	java/io/IOException
    //   8	47	142	finally
    //   157	162	165	java/io/IOException
    //   51	58	175	finally
    //   69	81	175	finally
    //   113	118	175	finally
    //   51	58	188	java/lang/Throwable
    //   69	81	188	java/lang/Throwable
  }
  
  private void modelEvent()
  {
    com.tencent.tvkbeacon.core.a.c localc = com.tencent.tvkbeacon.core.a.c.a(this.mContext);
    try
    {
      localObject = localc.a("rqd_model", "");
      boolean bool = a.a().equals(localObject);
      if (bool) {
        return;
      }
    }
    catch (Exception localException1)
    {
      com.tencent.tvkbeacon.core.c.c.d("[model] get upload flag failed! ", new Object[0]);
      return;
    }
    Object localObject = new ModuleImpl.1(this);
    com.tencent.tvkbeacon.core.a.b.d().a((Runnable)localObject, 50000L);
    try
    {
      localException1.a().a("rqd_model", a.a()).b();
      return;
    }
    catch (Exception localException2)
    {
      com.tencent.tvkbeacon.core.c.c.d("[model] save upload flag failed!", new Object[0]);
      com.tencent.tvkbeacon.core.c.c.a(localException2);
    }
  }
  
  public String getLanguage()
  {
    try
    {
      String str = Locale.getDefault().getLanguage();
      return str;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.tvkbeacon.core.c.c.d("[model] getLanguage error!", new Object[0]);
      com.tencent.tvkbeacon.core.c.c.a(localThrowable);
    }
    return null;
  }
  
  public void onModuleStarted()
  {
    super.onModuleStarted();
    com.tencent.tvkbeacon.core.c.c.a("[module] model module > %S", new Object[] { this.modelEventUsable });
    if (this.modelEventUsable) {
      modelEvent();
    }
  }
  
  public void onModuleStrategyUpdated(int paramInt, Map<String, String> paramMap)
  {
    super.onModuleStrategyUpdated(paramInt, paramMap);
    if (paramInt == 1) {
      this.modelEventUsable = a.a((String)paramMap.get("modelEventUsable"), this.modelEventUsable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.d.ModuleImpl
 * JD-Core Version:    0.7.0.1
 */