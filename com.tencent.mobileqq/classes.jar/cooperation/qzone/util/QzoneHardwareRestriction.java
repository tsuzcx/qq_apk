package cooperation.qzone.util;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import aniy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;

public class QzoneHardwareRestriction
{
  public static final String APP_ROOT = "/data/data/com.tencent.mobileqq/files/";
  public static final int BUFFER_SIZE = 1024;
  public static final int HARDWARE_HIGHLEVEL = 2;
  public static final int HARDWARE_LOWLEVEL = 0;
  public static final int HARDWARE_MIDDLELEVEL = 1;
  public static final int HARDWARE_SUPERLEVEL = 3;
  public static final String TAG = "QzoneHardwareRestriction";
  public static int curCpuLevel = -1;
  public static int curMemLevel = -1;
  public static int sCpuCoreNum = -1;
  private static long sCpuMaxFreq;
  
  public static long getAvailableMem()
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHardwareRestriction", 2, "getAvailableMem " + localMemoryInfo.availMem / 1024L);
    }
    return localMemoryInfo.availMem / 1024L;
  }
  
  public static long getCpuMaxFreq()
  {
    if (sCpuMaxFreq == 0L) {
      initCpuFreq();
    }
    return sCpuMaxFreq;
  }
  
  public static int getCurrentCpuLevel()
  {
    if (curCpuLevel != -1) {
      return curCpuLevel;
    }
    curCpuLevel = 1;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "hardwarerestriction_cpu_size", "1000,1500,2000");
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHardwareRestriction", 2, "cpuLevelList " + (String)localObject);
    }
    localObject = ((String)localObject).split(",");
    long l = getCpuMaxFreq() / 1024L;
    if ((localObject.length == 3) && (l != 0L))
    {
      if ((float)l >= Float.valueOf(localObject[0]).floatValue()) {
        break label109;
      }
      curCpuLevel = 0;
    }
    for (;;)
    {
      return curCpuLevel;
      label109:
      if (((float)l >= Float.valueOf(localObject[0]).floatValue()) && ((float)l < Float.valueOf(localObject[1]).floatValue())) {
        curCpuLevel = 1;
      } else if (((float)l >= Float.valueOf(localObject[1]).floatValue()) && ((float)l < Float.valueOf(localObject[2]).floatValue())) {
        curCpuLevel = 2;
      } else if ((float)l >= Float.valueOf(localObject[2]).floatValue()) {
        curCpuLevel = 3;
      }
    }
  }
  
  public static int getCurrentMemLevel()
  {
    if (curMemLevel != -1) {
      return curMemLevel;
    }
    curMemLevel = 1;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "hardwarerestriction_ram_size", "750,1000,2000");
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHardwareRestriction", 2, "memLevelList " + (String)localObject);
    }
    localObject = ((String)localObject).split(",");
    long l = getTotalMem() / 1024L;
    if ((localObject.length == 3) && (l != 0L))
    {
      if ((float)l >= Float.valueOf(localObject[0]).floatValue()) {
        break label109;
      }
      curMemLevel = 0;
    }
    for (;;)
    {
      return curMemLevel;
      label109:
      if (((float)l >= Float.valueOf(localObject[0]).floatValue()) && ((float)l < Float.valueOf(localObject[1]).floatValue())) {
        curMemLevel = 1;
      } else if (((float)l >= Float.valueOf(localObject[1]).floatValue()) && ((float)l < Float.valueOf(localObject[2]).floatValue())) {
        curMemLevel = 2;
      } else if ((float)l >= Float.valueOf(localObject[2]).floatValue()) {
        curMemLevel = 3;
      }
    }
  }
  
  private static final int getNumCoresOldPhones()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new aniy()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  @SuppressLint({"NewApi"})
  public static final int getNumberOfCores()
  {
    if (sCpuCoreNum == -1) {
      if (Build.VERSION.SDK_INT < 17) {
        break label28;
      }
    }
    label28:
    for (sCpuCoreNum = Runtime.getRuntime().availableProcessors();; sCpuCoreNum = getNumCoresOldPhones()) {
      return sCpuCoreNum;
    }
  }
  
  public static long getSDCardAllSize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      l = localStatFs.getBlockCount() * l / 1024L;
      return l;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public static long getSDCardAvailableSize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = localStatFs.getBlockSize();
      long l2 = localStatFs.getAvailableBlocks();
      if (QLog.isColorLevel()) {
        QLog.d("QzoneHardwareRestriction", 2, "getSDCardAvailableSize " + l2 * l1 / 1024L);
      }
      l1 = l2 * l1 / 1024L;
      return l1;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  public static long getSystemAvailableSize()
  {
    try
    {
      StatFs localStatFs = new StatFs("/data/data/com.tencent.mobileqq/files/");
      long l1 = localStatFs.getBlockSize();
      long l2 = localStatFs.getAvailableBlocks();
      if (QLog.isColorLevel()) {
        QLog.d("QzoneHardwareRestriction", 2, "getSystemAvailableSize " + l2 * l1 / 1024L);
      }
      l1 = l2 * l1 / 1024L;
      return l1;
    }
    catch (Exception localException) {}
    return 0L;
  }
  
  /* Error */
  public static long getTotalMem()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore 4
    //   8: lconst_0
    //   9: lstore_0
    //   10: new 223	java/io/BufferedReader
    //   13: dup
    //   14: new 225	java/io/FileReader
    //   17: dup
    //   18: ldc 227
    //   20: invokespecial 228	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   23: bipush 8
    //   25: invokespecial 231	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   28: astore_3
    //   29: aload_3
    //   30: astore_2
    //   31: aload_3
    //   32: invokevirtual 234	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   35: astore 6
    //   37: aload 4
    //   39: astore_2
    //   40: aload 6
    //   42: ifnull +6 -> 48
    //   45: aload 6
    //   47: astore_2
    //   48: aload_2
    //   49: astore 4
    //   51: aload_3
    //   52: ifnull +10 -> 62
    //   55: aload_3
    //   56: invokevirtual 237	java/io/BufferedReader:close	()V
    //   59: aload_2
    //   60: astore 4
    //   62: aload 4
    //   64: ifnull +32 -> 96
    //   67: aload 4
    //   69: aload 4
    //   71: bipush 58
    //   73: invokevirtual 241	java/lang/String:indexOf	(I)I
    //   76: iconst_1
    //   77: iadd
    //   78: aload 4
    //   80: bipush 107
    //   82: invokevirtual 241	java/lang/String:indexOf	(I)I
    //   85: invokevirtual 245	java/lang/String:substring	(II)Ljava/lang/String;
    //   88: invokevirtual 248	java/lang/String:trim	()Ljava/lang/String;
    //   91: invokestatic 254	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   94: i2l
    //   95: lstore_0
    //   96: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +29 -> 128
    //   102: ldc 22
    //   104: iconst_2
    //   105: new 72	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   112: ldc_w 256
    //   115: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: lload_0
    //   119: invokevirtual 87	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   122: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: lload_0
    //   129: lreturn
    //   130: astore_3
    //   131: aload_3
    //   132: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   135: aload_2
    //   136: astore 4
    //   138: goto -76 -> 62
    //   141: astore 4
    //   143: aconst_null
    //   144: astore_3
    //   145: aload_3
    //   146: astore_2
    //   147: aload 4
    //   149: invokevirtual 260	java/io/FileNotFoundException:printStackTrace	()V
    //   152: aload 5
    //   154: astore 4
    //   156: aload_3
    //   157: ifnull -95 -> 62
    //   160: aload_3
    //   161: invokevirtual 237	java/io/BufferedReader:close	()V
    //   164: aload 5
    //   166: astore 4
    //   168: goto -106 -> 62
    //   171: astore_2
    //   172: aload_2
    //   173: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   176: aload 5
    //   178: astore 4
    //   180: goto -118 -> 62
    //   183: astore 4
    //   185: aconst_null
    //   186: astore_3
    //   187: aload_3
    //   188: astore_2
    //   189: aload 4
    //   191: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   194: aload 5
    //   196: astore 4
    //   198: aload_3
    //   199: ifnull -137 -> 62
    //   202: aload_3
    //   203: invokevirtual 237	java/io/BufferedReader:close	()V
    //   206: aload 5
    //   208: astore 4
    //   210: goto -148 -> 62
    //   213: astore_2
    //   214: aload_2
    //   215: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   218: aload 5
    //   220: astore 4
    //   222: goto -160 -> 62
    //   225: astore 4
    //   227: aload_2
    //   228: astore_3
    //   229: aload 4
    //   231: astore_2
    //   232: aload_3
    //   233: ifnull +7 -> 240
    //   236: aload_3
    //   237: invokevirtual 237	java/io/BufferedReader:close	()V
    //   240: aload_2
    //   241: athrow
    //   242: astore_3
    //   243: aload_3
    //   244: invokevirtual 259	java/io/IOException:printStackTrace	()V
    //   247: goto -7 -> 240
    //   250: astore 4
    //   252: aload_2
    //   253: astore_3
    //   254: aload 4
    //   256: astore_2
    //   257: goto -25 -> 232
    //   260: astore 4
    //   262: goto -75 -> 187
    //   265: astore 4
    //   267: goto -122 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   9	120	0	l	long
    //   4	143	2	localObject1	Object
    //   171	2	2	localIOException1	java.io.IOException
    //   188	1	2	localObject2	Object
    //   213	15	2	localIOException2	java.io.IOException
    //   231	26	2	localObject3	Object
    //   28	28	3	localBufferedReader	java.io.BufferedReader
    //   130	2	3	localIOException3	java.io.IOException
    //   144	93	3	localIOException4	java.io.IOException
    //   242	2	3	localIOException5	java.io.IOException
    //   253	1	3	localObject4	Object
    //   6	131	4	localObject5	Object
    //   141	7	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   154	25	4	localObject6	Object
    //   183	7	4	localIOException6	java.io.IOException
    //   196	25	4	localObject7	Object
    //   225	5	4	localObject8	Object
    //   250	5	4	localObject9	Object
    //   260	1	4	localIOException7	java.io.IOException
    //   265	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	218	5	localObject10	Object
    //   35	11	6	str	String
    // Exception table:
    //   from	to	target	type
    //   55	59	130	java/io/IOException
    //   10	29	141	java/io/FileNotFoundException
    //   160	164	171	java/io/IOException
    //   10	29	183	java/io/IOException
    //   202	206	213	java/io/IOException
    //   10	29	225	finally
    //   236	240	242	java/io/IOException
    //   31	37	250	finally
    //   147	152	250	finally
    //   189	194	250	finally
    //   31	37	260	java/io/IOException
    //   31	37	265	java/io/FileNotFoundException
  }
  
  /* Error */
  private static void initCpuFreq()
  {
    // Byte code:
    //   0: invokestatic 262	cooperation/qzone/util/QzoneHardwareRestriction:getNumberOfCores	()I
    //   3: istore_1
    //   4: iconst_0
    //   5: istore_0
    //   6: iload_0
    //   7: iload_1
    //   8: if_icmpge +336 -> 344
    //   11: new 225	java/io/FileReader
    //   14: dup
    //   15: new 72	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 264
    //   25: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_0
    //   29: invokevirtual 267	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 269
    //   35: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 228	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: astore 5
    //   46: new 223	java/io/BufferedReader
    //   49: dup
    //   50: aload 5
    //   52: sipush 1024
    //   55: invokespecial 231	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   58: astore 4
    //   60: aload 4
    //   62: astore 7
    //   64: aload 5
    //   66: astore 6
    //   68: aload 4
    //   70: invokevirtual 234	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore 8
    //   75: aload 8
    //   77: ifnull +127 -> 204
    //   80: aload 4
    //   82: astore 7
    //   84: aload 5
    //   86: astore 6
    //   88: aload 8
    //   90: invokestatic 275	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   93: lstore_2
    //   94: aload 4
    //   96: astore 7
    //   98: aload 5
    //   100: astore 6
    //   102: getstatic 98	cooperation/qzone/util/QzoneHardwareRestriction:sCpuMaxFreq	J
    //   105: lload_2
    //   106: lcmp
    //   107: ifge +15 -> 122
    //   110: aload 4
    //   112: astore 7
    //   114: aload 5
    //   116: astore 6
    //   118: lload_2
    //   119: putstatic 98	cooperation/qzone/util/QzoneHardwareRestriction:sCpuMaxFreq	J
    //   122: aload 4
    //   124: astore 7
    //   126: aload 5
    //   128: astore 6
    //   130: invokestatic 70	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +44 -> 177
    //   136: aload 4
    //   138: astore 7
    //   140: aload 5
    //   142: astore 6
    //   144: ldc 22
    //   146: iconst_2
    //   147: invokestatic 281	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   150: ldc_w 283
    //   153: iconst_2
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: iload_0
    //   160: invokestatic 286	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: lload_2
    //   167: invokestatic 289	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   170: aastore
    //   171: invokestatic 293	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   174: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: aload 4
    //   179: ifnull +8 -> 187
    //   182: aload 4
    //   184: invokevirtual 237	java/io/BufferedReader:close	()V
    //   187: aload 5
    //   189: ifnull +8 -> 197
    //   192: aload 5
    //   194: invokevirtual 294	java/io/FileReader:close	()V
    //   197: iload_0
    //   198: iconst_1
    //   199: iadd
    //   200: istore_0
    //   201: goto -195 -> 6
    //   204: lconst_0
    //   205: lstore_2
    //   206: goto -112 -> 94
    //   209: astore 4
    //   211: aload 4
    //   213: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   216: goto -29 -> 187
    //   219: astore 4
    //   221: aload 4
    //   223: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   226: goto -29 -> 197
    //   229: astore 8
    //   231: aconst_null
    //   232: astore 4
    //   234: aconst_null
    //   235: astore 5
    //   237: aload 4
    //   239: astore 7
    //   241: aload 5
    //   243: astore 6
    //   245: aload 8
    //   247: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   250: aload 4
    //   252: ifnull +8 -> 260
    //   255: aload 4
    //   257: invokevirtual 237	java/io/BufferedReader:close	()V
    //   260: aload 5
    //   262: ifnull -65 -> 197
    //   265: aload 5
    //   267: invokevirtual 294	java/io/FileReader:close	()V
    //   270: goto -73 -> 197
    //   273: astore 4
    //   275: aload 4
    //   277: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   280: goto -83 -> 197
    //   283: astore 4
    //   285: aload 4
    //   287: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   290: goto -30 -> 260
    //   293: astore 4
    //   295: aconst_null
    //   296: astore 7
    //   298: aconst_null
    //   299: astore 5
    //   301: aload 7
    //   303: ifnull +8 -> 311
    //   306: aload 7
    //   308: invokevirtual 237	java/io/BufferedReader:close	()V
    //   311: aload 5
    //   313: ifnull +8 -> 321
    //   316: aload 5
    //   318: invokevirtual 294	java/io/FileReader:close	()V
    //   321: aload 4
    //   323: athrow
    //   324: astore 6
    //   326: aload 6
    //   328: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   331: goto -20 -> 311
    //   334: astore 5
    //   336: aload 5
    //   338: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   341: goto -20 -> 321
    //   344: getstatic 300	android/os/Build:MODEL	Ljava/lang/String;
    //   347: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   350: ifne +67 -> 417
    //   353: getstatic 300	android/os/Build:MODEL	Ljava/lang/String;
    //   356: ldc_w 308
    //   359: invokevirtual 312	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   362: ifne +15 -> 377
    //   365: getstatic 300	android/os/Build:MODEL	Ljava/lang/String;
    //   368: ldc_w 314
    //   371: invokevirtual 312	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   374: ifeq +43 -> 417
    //   377: getstatic 98	cooperation/qzone/util/QzoneHardwareRestriction:sCpuMaxFreq	J
    //   380: l2d
    //   381: ldc2_w 315
    //   384: dmul
    //   385: d2l
    //   386: putstatic 98	cooperation/qzone/util/QzoneHardwareRestriction:sCpuMaxFreq	J
    //   389: ldc 22
    //   391: iconst_2
    //   392: new 72	java/lang/StringBuilder
    //   395: dup
    //   396: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   399: ldc_w 318
    //   402: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: getstatic 300	android/os/Build:MODEL	Ljava/lang/String;
    //   408: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 321	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: return
    //   418: astore 4
    //   420: aconst_null
    //   421: astore 7
    //   423: goto -122 -> 301
    //   426: astore 4
    //   428: aload 6
    //   430: astore 5
    //   432: goto -131 -> 301
    //   435: astore 8
    //   437: aconst_null
    //   438: astore 4
    //   440: goto -203 -> 237
    //   443: astore 8
    //   445: goto -208 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	196	0	i	int
    //   3	6	1	j	int
    //   93	113	2	l	long
    //   58	125	4	localBufferedReader	java.io.BufferedReader
    //   209	3	4	localException1	Exception
    //   219	3	4	localException2	Exception
    //   232	24	4	localObject1	Object
    //   273	3	4	localException3	Exception
    //   283	3	4	localException4	Exception
    //   293	29	4	localObject2	Object
    //   418	1	4	localObject3	Object
    //   426	1	4	localObject4	Object
    //   438	1	4	localObject5	Object
    //   44	273	5	localFileReader1	java.io.FileReader
    //   334	3	5	localException5	Exception
    //   430	1	5	localObject6	Object
    //   66	178	6	localFileReader2	java.io.FileReader
    //   324	105	6	localException6	Exception
    //   62	360	7	localObject7	Object
    //   73	16	8	str	String
    //   229	17	8	localException7	Exception
    //   435	1	8	localException8	Exception
    //   443	1	8	localException9	Exception
    // Exception table:
    //   from	to	target	type
    //   182	187	209	java/lang/Exception
    //   192	197	219	java/lang/Exception
    //   11	46	229	java/lang/Exception
    //   265	270	273	java/lang/Exception
    //   255	260	283	java/lang/Exception
    //   11	46	293	finally
    //   306	311	324	java/lang/Exception
    //   316	321	334	java/lang/Exception
    //   46	60	418	finally
    //   68	75	426	finally
    //   88	94	426	finally
    //   102	110	426	finally
    //   118	122	426	finally
    //   130	136	426	finally
    //   144	177	426	finally
    //   245	250	426	finally
    //   46	60	435	java/lang/Exception
    //   68	75	443	java/lang/Exception
    //   88	94	443	java/lang/Exception
    //   102	110	443	java/lang/Exception
    //   118	122	443	java/lang/Exception
    //   130	136	443	java/lang/Exception
    //   144	177	443	java/lang/Exception
  }
  
  public static boolean meetHardwareRestriction(int paramInt1, int paramInt2)
  {
    return (paramInt1 <= getCurrentMemLevel()) && (paramInt2 <= getCurrentCpuLevel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.util.QzoneHardwareRestriction
 * JD-Core Version:    0.7.0.1
 */