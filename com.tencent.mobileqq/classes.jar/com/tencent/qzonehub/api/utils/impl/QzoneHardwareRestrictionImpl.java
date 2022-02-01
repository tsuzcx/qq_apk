package com.tencent.qzonehub.api.utils.impl;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import common.config.service.QzoneConfig;
import java.io.File;

public class QzoneHardwareRestrictionImpl
  implements IQzoneHardwareRestriction
{
  private static long sCpuMaxFreq = 0L;
  int curCpuLevel = -1;
  int curMemLevel = -1;
  int sCpuCoreNum = -1;
  
  private final int getNumCoresOldPhones()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new QzoneHardwareRestrictionImpl.1CpuFilter(this)).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  /* Error */
  private void initCpuFreq()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 50	com/tencent/qzonehub/api/utils/impl/QzoneHardwareRestrictionImpl:getNumberOfCores	()I
    //   4: istore_2
    //   5: iconst_0
    //   6: istore_1
    //   7: iload_1
    //   8: iload_2
    //   9: if_icmpge +333 -> 342
    //   12: new 52	java/io/FileReader
    //   15: dup
    //   16: new 54	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   23: ldc 57
    //   25: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_1
    //   29: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc 66
    //   34: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 71	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   43: astore 6
    //   45: new 73	java/io/BufferedReader
    //   48: dup
    //   49: aload 6
    //   51: sipush 1024
    //   54: invokespecial 76	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   57: astore 5
    //   59: aload 5
    //   61: astore 8
    //   63: aload 6
    //   65: astore 7
    //   67: aload 5
    //   69: invokevirtual 79	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   72: astore 9
    //   74: aload 9
    //   76: ifnull +126 -> 202
    //   79: aload 5
    //   81: astore 8
    //   83: aload 6
    //   85: astore 7
    //   87: aload 9
    //   89: invokestatic 85	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   92: lstore_3
    //   93: aload 5
    //   95: astore 8
    //   97: aload 6
    //   99: astore 7
    //   101: getstatic 16	com/tencent/qzonehub/api/utils/impl/QzoneHardwareRestrictionImpl:sCpuMaxFreq	J
    //   104: lload_3
    //   105: lcmp
    //   106: ifge +15 -> 121
    //   109: aload 5
    //   111: astore 8
    //   113: aload 6
    //   115: astore 7
    //   117: lload_3
    //   118: putstatic 16	com/tencent/qzonehub/api/utils/impl/QzoneHardwareRestrictionImpl:sCpuMaxFreq	J
    //   121: aload 5
    //   123: astore 8
    //   125: aload 6
    //   127: astore 7
    //   129: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +43 -> 175
    //   135: aload 5
    //   137: astore 8
    //   139: aload 6
    //   141: astore 7
    //   143: ldc 93
    //   145: iconst_2
    //   146: invokestatic 99	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   149: ldc 101
    //   151: iconst_2
    //   152: anewarray 4	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: iload_1
    //   158: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: aastore
    //   162: dup
    //   163: iconst_1
    //   164: lload_3
    //   165: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   168: aastore
    //   169: invokestatic 116	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   172: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload 5
    //   177: ifnull +8 -> 185
    //   180: aload 5
    //   182: invokevirtual 123	java/io/BufferedReader:close	()V
    //   185: aload 6
    //   187: ifnull +8 -> 195
    //   190: aload 6
    //   192: invokevirtual 124	java/io/FileReader:close	()V
    //   195: iload_1
    //   196: iconst_1
    //   197: iadd
    //   198: istore_1
    //   199: goto -192 -> 7
    //   202: lconst_0
    //   203: lstore_3
    //   204: goto -111 -> 93
    //   207: astore 5
    //   209: aload 5
    //   211: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   214: goto -29 -> 185
    //   217: astore 5
    //   219: aload 5
    //   221: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   224: goto -29 -> 195
    //   227: astore 9
    //   229: aconst_null
    //   230: astore 5
    //   232: aconst_null
    //   233: astore 6
    //   235: aload 5
    //   237: astore 8
    //   239: aload 6
    //   241: astore 7
    //   243: aload 9
    //   245: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   248: aload 5
    //   250: ifnull +8 -> 258
    //   253: aload 5
    //   255: invokevirtual 123	java/io/BufferedReader:close	()V
    //   258: aload 6
    //   260: ifnull -65 -> 195
    //   263: aload 6
    //   265: invokevirtual 124	java/io/FileReader:close	()V
    //   268: goto -73 -> 195
    //   271: astore 5
    //   273: aload 5
    //   275: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   278: goto -83 -> 195
    //   281: astore 5
    //   283: aload 5
    //   285: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   288: goto -30 -> 258
    //   291: astore 5
    //   293: aconst_null
    //   294: astore 8
    //   296: aconst_null
    //   297: astore 6
    //   299: aload 8
    //   301: ifnull +8 -> 309
    //   304: aload 8
    //   306: invokevirtual 123	java/io/BufferedReader:close	()V
    //   309: aload 6
    //   311: ifnull +8 -> 319
    //   314: aload 6
    //   316: invokevirtual 124	java/io/FileReader:close	()V
    //   319: aload 5
    //   321: athrow
    //   322: astore 7
    //   324: aload 7
    //   326: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   329: goto -20 -> 309
    //   332: astore 6
    //   334: aload 6
    //   336: invokevirtual 127	java/lang/Exception:printStackTrace	()V
    //   339: goto -20 -> 319
    //   342: getstatic 133	android/os/Build:MODEL	Ljava/lang/String;
    //   345: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   348: ifne +64 -> 412
    //   351: getstatic 133	android/os/Build:MODEL	Ljava/lang/String;
    //   354: ldc 141
    //   356: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   359: ifne +14 -> 373
    //   362: getstatic 133	android/os/Build:MODEL	Ljava/lang/String;
    //   365: ldc 147
    //   367: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   370: ifeq +42 -> 412
    //   373: getstatic 16	com/tencent/qzonehub/api/utils/impl/QzoneHardwareRestrictionImpl:sCpuMaxFreq	J
    //   376: l2d
    //   377: ldc2_w 148
    //   380: dmul
    //   381: d2l
    //   382: putstatic 16	com/tencent/qzonehub/api/utils/impl/QzoneHardwareRestrictionImpl:sCpuMaxFreq	J
    //   385: ldc 93
    //   387: iconst_2
    //   388: new 54	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   395: ldc 151
    //   397: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: getstatic 133	android/os/Build:MODEL	Ljava/lang/String;
    //   403: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 154	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: return
    //   413: astore 5
    //   415: aconst_null
    //   416: astore 8
    //   418: goto -119 -> 299
    //   421: astore 5
    //   423: aload 7
    //   425: astore 6
    //   427: goto -128 -> 299
    //   430: astore 9
    //   432: aconst_null
    //   433: astore 5
    //   435: goto -200 -> 235
    //   438: astore 9
    //   440: goto -205 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	this	QzoneHardwareRestrictionImpl
    //   6	193	1	i	int
    //   4	6	2	j	int
    //   92	112	3	l	long
    //   57	124	5	localBufferedReader	java.io.BufferedReader
    //   207	3	5	localException1	Exception
    //   217	3	5	localException2	Exception
    //   230	24	5	localObject1	Object
    //   271	3	5	localException3	Exception
    //   281	3	5	localException4	Exception
    //   291	29	5	localObject2	Object
    //   413	1	5	localObject3	Object
    //   421	1	5	localObject4	Object
    //   433	1	5	localObject5	Object
    //   43	272	6	localFileReader1	java.io.FileReader
    //   332	3	6	localException5	Exception
    //   425	1	6	localObject6	Object
    //   65	177	7	localFileReader2	java.io.FileReader
    //   322	102	7	localException6	Exception
    //   61	356	8	localObject7	Object
    //   72	16	9	str	String
    //   227	17	9	localException7	Exception
    //   430	1	9	localException8	Exception
    //   438	1	9	localException9	Exception
    // Exception table:
    //   from	to	target	type
    //   180	185	207	java/lang/Exception
    //   190	195	217	java/lang/Exception
    //   12	45	227	java/lang/Exception
    //   263	268	271	java/lang/Exception
    //   253	258	281	java/lang/Exception
    //   12	45	291	finally
    //   304	309	322	java/lang/Exception
    //   314	319	332	java/lang/Exception
    //   45	59	413	finally
    //   67	74	421	finally
    //   87	93	421	finally
    //   101	109	421	finally
    //   117	121	421	finally
    //   129	135	421	finally
    //   143	175	421	finally
    //   243	248	421	finally
    //   45	59	430	java/lang/Exception
    //   67	74	438	java/lang/Exception
    //   87	93	438	java/lang/Exception
    //   101	109	438	java/lang/Exception
    //   117	121	438	java/lang/Exception
    //   129	135	438	java/lang/Exception
    //   143	175	438	java/lang/Exception
  }
  
  public boolean equalHardwareRestriction(int paramInt1, int paramInt2)
  {
    return (paramInt1 <= getCurrentMemLevelNew()) && (paramInt2 <= getCurrentCpuFreSumLevel());
  }
  
  public long getAvailableMem()
  {
    ActivityManager localActivityManager = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHardwareRestriction", 2, "getAvailableMem " + localMemoryInfo.availMem / 1024L);
    }
    return localMemoryInfo.availMem / 1024L;
  }
  
  public long getCpuMaxFreq()
  {
    if (sCpuMaxFreq == 0L) {
      initCpuFreq();
    }
    return sCpuMaxFreq;
  }
  
  public int getCurrentCpuFreSumLevel()
  {
    if (this.curCpuLevel != -1) {
      return this.curCpuLevel;
    }
    this.curCpuLevel = 1;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "hardwarerestriction_cpu_fre_sum", "4000,8000,14000");
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHardwareRestriction", 2, "cpuLevelList " + (String)localObject);
    }
    localObject = ((String)localObject).split(",");
    long l = getCpuMaxFreq() / 1024L * getNumberOfCores();
    if ((localObject.length == 3) && (l != 0L))
    {
      if ((float)l >= Float.valueOf(localObject[0]).floatValue()) {
        break label121;
      }
      this.curCpuLevel = 0;
    }
    for (;;)
    {
      return this.curCpuLevel;
      label121:
      if (((float)l >= Float.valueOf(localObject[0]).floatValue()) && ((float)l < Float.valueOf(localObject[1]).floatValue())) {
        this.curCpuLevel = 1;
      } else if (((float)l >= Float.valueOf(localObject[1]).floatValue()) && ((float)l < Float.valueOf(localObject[2]).floatValue())) {
        this.curCpuLevel = 2;
      } else if ((float)l >= Float.valueOf(localObject[2]).floatValue()) {
        this.curCpuLevel = 3;
      }
    }
  }
  
  public int getCurrentCpuLevel()
  {
    if (this.curCpuLevel != -1) {
      return this.curCpuLevel;
    }
    this.curCpuLevel = 1;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "hardwarerestriction_cpu_size", "1000,1500,2000");
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHardwareRestriction", 2, "cpuLevelList " + (String)localObject);
    }
    localObject = ((String)localObject).split(",");
    long l = getCpuMaxFreq() / 1024L;
    if ((localObject.length == 3) && (l != 0L))
    {
      if ((float)l >= Float.valueOf(localObject[0]).floatValue()) {
        break label115;
      }
      this.curCpuLevel = 0;
    }
    for (;;)
    {
      return this.curCpuLevel;
      label115:
      if (((float)l >= Float.valueOf(localObject[0]).floatValue()) && ((float)l < Float.valueOf(localObject[1]).floatValue())) {
        this.curCpuLevel = 1;
      } else if (((float)l >= Float.valueOf(localObject[1]).floatValue()) && ((float)l < Float.valueOf(localObject[2]).floatValue())) {
        this.curCpuLevel = 2;
      } else if ((float)l >= Float.valueOf(localObject[2]).floatValue()) {
        this.curCpuLevel = 3;
      }
    }
  }
  
  public int getCurrentMemLevel()
  {
    if (this.curMemLevel != -1) {
      return this.curMemLevel;
    }
    this.curMemLevel = 1;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "hardwarerestriction_ram_size", "750,1000,2000");
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHardwareRestriction", 2, "memLevelList " + (String)localObject);
    }
    localObject = ((String)localObject).split(",");
    long l = getTotalMem() / 1024L;
    if ((localObject.length == 3) && (l != 0L))
    {
      if ((float)l >= Float.valueOf(localObject[0]).floatValue()) {
        break label115;
      }
      this.curMemLevel = 0;
    }
    for (;;)
    {
      return this.curMemLevel;
      label115:
      if (((float)l >= Float.valueOf(localObject[0]).floatValue()) && ((float)l < Float.valueOf(localObject[1]).floatValue())) {
        this.curMemLevel = 1;
      } else if (((float)l >= Float.valueOf(localObject[1]).floatValue()) && ((float)l < Float.valueOf(localObject[2]).floatValue())) {
        this.curMemLevel = 2;
      } else if ((float)l >= Float.valueOf(localObject[2]).floatValue()) {
        this.curMemLevel = 3;
      }
    }
  }
  
  public int getCurrentMemLevelNew()
  {
    if (this.curMemLevel != -1) {
      return this.curMemLevel;
    }
    this.curMemLevel = 1;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "hardwarerestriction_ram_size_new", "1000,2000,6000");
    if (QLog.isColorLevel()) {
      QLog.d("QzoneHardwareRestriction", 2, "memLevelList " + (String)localObject);
    }
    localObject = ((String)localObject).split(",");
    long l = getTotalMem() / 1024L;
    if ((localObject.length == 3) && (l != 0L))
    {
      if ((float)l >= Float.valueOf(localObject[0]).floatValue()) {
        break label115;
      }
      this.curMemLevel = 0;
    }
    for (;;)
    {
      return this.curMemLevel;
      label115:
      if (((float)l >= Float.valueOf(localObject[0]).floatValue()) && ((float)l < Float.valueOf(localObject[1]).floatValue())) {
        this.curMemLevel = 1;
      } else if (((float)l >= Float.valueOf(localObject[1]).floatValue()) && ((float)l < Float.valueOf(localObject[2]).floatValue())) {
        this.curMemLevel = 2;
      } else if ((float)l >= Float.valueOf(localObject[2]).floatValue()) {
        this.curMemLevel = 3;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public final int getNumberOfCores()
  {
    if (this.sCpuCoreNum == -1) {
      if (Build.VERSION.SDK_INT < 17) {
        break label31;
      }
    }
    label31:
    for (this.sCpuCoreNum = Runtime.getRuntime().availableProcessors();; this.sCpuCoreNum = getNumCoresOldPhones()) {
      return this.sCpuCoreNum;
    }
  }
  
  public long getSDCardAllSize()
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
  
  public long getSDCardAvailableSize()
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
  
  public long getSystemAvailableSize()
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
  public long getTotalMem()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: lconst_0
    //   9: lstore_1
    //   10: new 73	java/io/BufferedReader
    //   13: dup
    //   14: new 52	java/io/FileReader
    //   17: dup
    //   18: ldc_w 310
    //   21: invokespecial 71	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   24: bipush 8
    //   26: invokespecial 76	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   29: astore 4
    //   31: aload 4
    //   33: astore_3
    //   34: aload 4
    //   36: invokevirtual 79	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   39: astore 7
    //   41: aload 5
    //   43: astore_3
    //   44: aload 7
    //   46: ifnull +6 -> 52
    //   49: aload 7
    //   51: astore_3
    //   52: aload_3
    //   53: astore 5
    //   55: aload 4
    //   57: ifnull +11 -> 68
    //   60: aload 4
    //   62: invokevirtual 123	java/io/BufferedReader:close	()V
    //   65: aload_3
    //   66: astore 5
    //   68: aload 5
    //   70: ifnull +32 -> 102
    //   73: aload 5
    //   75: aload 5
    //   77: bipush 58
    //   79: invokevirtual 314	java/lang/String:indexOf	(I)I
    //   82: iconst_1
    //   83: iadd
    //   84: aload 5
    //   86: bipush 107
    //   88: invokevirtual 314	java/lang/String:indexOf	(I)I
    //   91: invokevirtual 318	java/lang/String:substring	(II)Ljava/lang/String;
    //   94: invokevirtual 321	java/lang/String:trim	()Ljava/lang/String;
    //   97: invokestatic 325	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   100: i2l
    //   101: lstore_1
    //   102: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   105: ifeq +29 -> 134
    //   108: ldc 93
    //   110: iconst_2
    //   111: new 54	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 327
    //   121: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: lload_1
    //   125: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   128: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: lload_1
    //   135: lreturn
    //   136: astore 4
    //   138: aload 4
    //   140: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   143: aload_3
    //   144: astore 5
    //   146: goto -78 -> 68
    //   149: astore 5
    //   151: aconst_null
    //   152: astore 4
    //   154: aload 4
    //   156: astore_3
    //   157: aload 5
    //   159: invokevirtual 329	java/io/FileNotFoundException:printStackTrace	()V
    //   162: aload 6
    //   164: astore 5
    //   166: aload 4
    //   168: ifnull -100 -> 68
    //   171: aload 4
    //   173: invokevirtual 123	java/io/BufferedReader:close	()V
    //   176: aload 6
    //   178: astore 5
    //   180: goto -112 -> 68
    //   183: astore_3
    //   184: aload_3
    //   185: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   188: aload 6
    //   190: astore 5
    //   192: goto -124 -> 68
    //   195: astore 5
    //   197: aconst_null
    //   198: astore 4
    //   200: aload 4
    //   202: astore_3
    //   203: aload 5
    //   205: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   208: aload 6
    //   210: astore 5
    //   212: aload 4
    //   214: ifnull -146 -> 68
    //   217: aload 4
    //   219: invokevirtual 123	java/io/BufferedReader:close	()V
    //   222: aload 6
    //   224: astore 5
    //   226: goto -158 -> 68
    //   229: astore_3
    //   230: aload_3
    //   231: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   234: aload 6
    //   236: astore 5
    //   238: goto -170 -> 68
    //   241: astore 5
    //   243: aload_3
    //   244: astore 4
    //   246: aload 5
    //   248: astore_3
    //   249: aload 4
    //   251: ifnull +8 -> 259
    //   254: aload 4
    //   256: invokevirtual 123	java/io/BufferedReader:close	()V
    //   259: aload_3
    //   260: athrow
    //   261: astore 4
    //   263: aload 4
    //   265: invokevirtual 328	java/io/IOException:printStackTrace	()V
    //   268: goto -9 -> 259
    //   271: astore 5
    //   273: aload_3
    //   274: astore 4
    //   276: aload 5
    //   278: astore_3
    //   279: goto -30 -> 249
    //   282: astore 5
    //   284: goto -84 -> 200
    //   287: astore 5
    //   289: goto -135 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	QzoneHardwareRestrictionImpl
    //   9	126	1	l	long
    //   4	153	3	localObject1	Object
    //   183	2	3	localIOException1	java.io.IOException
    //   202	1	3	localObject2	Object
    //   229	15	3	localIOException2	java.io.IOException
    //   248	31	3	localObject3	Object
    //   29	32	4	localBufferedReader	java.io.BufferedReader
    //   136	3	4	localIOException3	java.io.IOException
    //   152	103	4	localIOException4	java.io.IOException
    //   261	3	4	localIOException5	java.io.IOException
    //   274	1	4	localObject4	Object
    //   6	139	5	localObject5	Object
    //   149	9	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   164	27	5	localObject6	Object
    //   195	9	5	localIOException6	java.io.IOException
    //   210	27	5	localObject7	Object
    //   241	6	5	localObject8	Object
    //   271	6	5	localObject9	Object
    //   282	1	5	localIOException7	java.io.IOException
    //   287	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	234	6	localObject10	Object
    //   39	11	7	str	String
    // Exception table:
    //   from	to	target	type
    //   60	65	136	java/io/IOException
    //   10	31	149	java/io/FileNotFoundException
    //   171	176	183	java/io/IOException
    //   10	31	195	java/io/IOException
    //   217	222	229	java/io/IOException
    //   10	31	241	finally
    //   254	259	261	java/io/IOException
    //   34	41	271	finally
    //   157	162	271	finally
    //   203	208	271	finally
    //   34	41	282	java/io/IOException
    //   34	41	287	java/io/FileNotFoundException
  }
  
  public boolean meetHardwareRestriction(int paramInt1, int paramInt2)
  {
    return (paramInt1 <= getCurrentMemLevel()) && (paramInt2 <= getCurrentCpuLevel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.impl.QzoneHardwareRestrictionImpl
 * JD-Core Version:    0.7.0.1
 */