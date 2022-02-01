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
  private static long sCpuMaxFreq;
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
    catch (Exception localException)
    {
      label24:
      break label24;
    }
    return 1;
  }
  
  /* Error */
  private void initCpuFreq()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 48	com/tencent/qzonehub/api/utils/impl/QzoneHardwareRestrictionImpl:getNumberOfCores	()I
    //   4: istore 4
    //   6: iconst_0
    //   7: istore_3
    //   8: iload_3
    //   9: iload 4
    //   11: if_icmpge +328 -> 339
    //   14: aconst_null
    //   15: astore 9
    //   17: aconst_null
    //   18: astore 11
    //   20: new 50	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   27: astore 7
    //   29: aload 7
    //   31: ldc 53
    //   33: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 7
    //   39: iload_3
    //   40: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 7
    //   46: ldc 62
    //   48: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: new 64	java/io/FileReader
    //   55: dup
    //   56: aload 7
    //   58: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 69	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   64: astore 7
    //   66: aload 7
    //   68: astore 8
    //   70: new 71	java/io/BufferedReader
    //   73: dup
    //   74: aload 7
    //   76: sipush 1024
    //   79: invokespecial 74	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   82: astore 10
    //   84: aload 10
    //   86: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: astore 8
    //   91: aload 8
    //   93: ifnull +334 -> 427
    //   96: aload 8
    //   98: invokestatic 83	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   101: lstore 5
    //   103: goto +3 -> 106
    //   106: getstatic 85	com/tencent/qzonehub/api/utils/impl/QzoneHardwareRestrictionImpl:sCpuMaxFreq	J
    //   109: lload 5
    //   111: lcmp
    //   112: ifge +8 -> 120
    //   115: lload 5
    //   117: putstatic 85	com/tencent/qzonehub/api/utils/impl/QzoneHardwareRestrictionImpl:sCpuMaxFreq	J
    //   120: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +36 -> 159
    //   126: ldc 93
    //   128: iconst_2
    //   129: invokestatic 99	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   132: ldc 101
    //   134: iconst_2
    //   135: anewarray 4	java/lang/Object
    //   138: dup
    //   139: iconst_0
    //   140: iload_3
    //   141: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   144: aastore
    //   145: dup
    //   146: iconst_1
    //   147: lload 5
    //   149: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   152: aastore
    //   153: invokestatic 116	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 10
    //   161: invokevirtual 123	java/io/BufferedReader:close	()V
    //   164: goto +10 -> 174
    //   167: astore 8
    //   169: aload 8
    //   171: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   174: aload 7
    //   176: invokevirtual 127	java/io/FileReader:close	()V
    //   179: goto +100 -> 279
    //   182: astore 8
    //   184: aload 10
    //   186: astore 9
    //   188: goto +108 -> 296
    //   191: astore 8
    //   193: aload 10
    //   195: astore 11
    //   197: aload 8
    //   199: astore 10
    //   201: goto +25 -> 226
    //   204: astore 10
    //   206: goto +20 -> 226
    //   209: astore 8
    //   211: aconst_null
    //   212: astore 7
    //   214: aload 7
    //   216: astore 9
    //   218: goto +78 -> 296
    //   221: astore 10
    //   223: aconst_null
    //   224: astore 7
    //   226: aload 11
    //   228: astore 9
    //   230: aload 7
    //   232: astore 8
    //   234: aload 10
    //   236: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   239: aload 11
    //   241: ifnull +18 -> 259
    //   244: aload 11
    //   246: invokevirtual 123	java/io/BufferedReader:close	()V
    //   249: goto +10 -> 259
    //   252: astore 8
    //   254: aload 8
    //   256: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   259: aload 7
    //   261: ifnull +18 -> 279
    //   264: aload 7
    //   266: invokevirtual 127	java/io/FileReader:close	()V
    //   269: goto +10 -> 279
    //   272: astore 7
    //   274: aload 7
    //   276: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   279: iload_3
    //   280: iconst_1
    //   281: iadd
    //   282: istore_3
    //   283: goto -275 -> 8
    //   286: astore 10
    //   288: aload 8
    //   290: astore 7
    //   292: aload 10
    //   294: astore 8
    //   296: aload 9
    //   298: ifnull +18 -> 316
    //   301: aload 9
    //   303: invokevirtual 123	java/io/BufferedReader:close	()V
    //   306: goto +10 -> 316
    //   309: astore 9
    //   311: aload 9
    //   313: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   316: aload 7
    //   318: ifnull +18 -> 336
    //   321: aload 7
    //   323: invokevirtual 127	java/io/FileReader:close	()V
    //   326: goto +10 -> 336
    //   329: astore 7
    //   331: aload 7
    //   333: invokevirtual 126	java/lang/Exception:printStackTrace	()V
    //   336: aload 8
    //   338: athrow
    //   339: getstatic 133	android/os/Build:MODEL	Ljava/lang/String;
    //   342: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   345: ifne +81 -> 426
    //   348: getstatic 133	android/os/Build:MODEL	Ljava/lang/String;
    //   351: ldc 141
    //   353: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   356: ifne +14 -> 370
    //   359: getstatic 133	android/os/Build:MODEL	Ljava/lang/String;
    //   362: ldc 147
    //   364: invokevirtual 145	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   367: ifeq +59 -> 426
    //   370: getstatic 85	com/tencent/qzonehub/api/utils/impl/QzoneHardwareRestrictionImpl:sCpuMaxFreq	J
    //   373: l2d
    //   374: dstore_1
    //   375: dload_1
    //   376: invokestatic 153	java/lang/Double:isNaN	(D)Z
    //   379: pop
    //   380: dload_1
    //   381: ldc2_w 154
    //   384: dmul
    //   385: d2l
    //   386: putstatic 85	com/tencent/qzonehub/api/utils/impl/QzoneHardwareRestrictionImpl:sCpuMaxFreq	J
    //   389: new 50	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   396: astore 7
    //   398: aload 7
    //   400: ldc 157
    //   402: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 7
    //   408: getstatic 133	android/os/Build:MODEL	Ljava/lang/String;
    //   411: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: ldc 93
    //   417: iconst_2
    //   418: aload 7
    //   420: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 160	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: return
    //   427: lconst_0
    //   428: lstore 5
    //   430: goto -324 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	this	QzoneHardwareRestrictionImpl
    //   374	7	1	d	double
    //   7	276	3	i	int
    //   4	8	4	j	int
    //   101	328	5	l	long
    //   27	238	7	localObject1	Object
    //   272	3	7	localException1	Exception
    //   290	32	7	localObject2	Object
    //   329	3	7	localException2	Exception
    //   396	23	7	localStringBuilder	StringBuilder
    //   68	29	8	localObject3	Object
    //   167	3	8	localException3	Exception
    //   182	1	8	localObject4	Object
    //   191	7	8	localException4	Exception
    //   209	1	8	localObject5	Object
    //   232	1	8	localObject6	Object
    //   252	37	8	localException5	Exception
    //   294	43	8	localObject7	Object
    //   15	287	9	localObject8	Object
    //   309	3	9	localException6	Exception
    //   82	118	10	localObject9	Object
    //   204	1	10	localException7	Exception
    //   221	14	10	localException8	Exception
    //   286	7	10	localObject10	Object
    //   18	227	11	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   159	164	167	java/lang/Exception
    //   84	91	182	finally
    //   96	103	182	finally
    //   106	120	182	finally
    //   120	159	182	finally
    //   84	91	191	java/lang/Exception
    //   96	103	191	java/lang/Exception
    //   106	120	191	java/lang/Exception
    //   120	159	191	java/lang/Exception
    //   70	84	204	java/lang/Exception
    //   20	66	209	finally
    //   20	66	221	java/lang/Exception
    //   244	249	252	java/lang/Exception
    //   174	179	272	java/lang/Exception
    //   264	269	272	java/lang/Exception
    //   70	84	286	finally
    //   234	239	286	finally
    //   301	306	309	java/lang/Exception
    //   321	326	329	java/lang/Exception
  }
  
  public boolean equalHardwareRestriction(int paramInt1, int paramInt2)
  {
    return (paramInt1 <= getCurrentMemLevelNew()) && (paramInt2 <= getCurrentCpuFreSumLevel());
  }
  
  public long getAvailableMem()
  {
    Object localObject = (ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    ((ActivityManager)localObject).getMemoryInfo(localMemoryInfo);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAvailableMem ");
      ((StringBuilder)localObject).append(localMemoryInfo.availMem / 1024L);
      QLog.d("QzoneHardwareRestriction", 2, ((StringBuilder)localObject).toString());
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
    int i = this.curCpuLevel;
    if (i != -1) {
      return i;
    }
    this.curCpuLevel = 1;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "hardwarerestriction_cpu_fre_sum", "4000,8000,14000");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cpuLevelList ");
      localStringBuilder.append((String)localObject);
      QLog.d("QzoneHardwareRestriction", 2, localStringBuilder.toString());
    }
    localObject = ((String)localObject).split(",");
    long l = getCpuMaxFreq() / 1024L * getNumberOfCores();
    if ((localObject.length == 3) && (l != 0L))
    {
      float f = (float)l;
      if (f < Float.valueOf(localObject[0]).floatValue()) {
        this.curCpuLevel = 0;
      } else if ((f >= Float.valueOf(localObject[0]).floatValue()) && (f < Float.valueOf(localObject[1]).floatValue())) {
        this.curCpuLevel = 1;
      } else if ((f >= Float.valueOf(localObject[1]).floatValue()) && (f < Float.valueOf(localObject[2]).floatValue())) {
        this.curCpuLevel = 2;
      } else if (f >= Float.valueOf(localObject[2]).floatValue()) {
        this.curCpuLevel = 3;
      }
    }
    return this.curCpuLevel;
  }
  
  public int getCurrentCpuLevel()
  {
    int i = this.curCpuLevel;
    if (i != -1) {
      return i;
    }
    this.curCpuLevel = 1;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "hardwarerestriction_cpu_size", "1000,1500,2000");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cpuLevelList ");
      localStringBuilder.append((String)localObject);
      QLog.d("QzoneHardwareRestriction", 2, localStringBuilder.toString());
    }
    localObject = ((String)localObject).split(",");
    long l = getCpuMaxFreq() / 1024L;
    if ((localObject.length == 3) && (l != 0L))
    {
      float f = (float)l;
      if (f < Float.valueOf(localObject[0]).floatValue()) {
        this.curCpuLevel = 0;
      } else if ((f >= Float.valueOf(localObject[0]).floatValue()) && (f < Float.valueOf(localObject[1]).floatValue())) {
        this.curCpuLevel = 1;
      } else if ((f >= Float.valueOf(localObject[1]).floatValue()) && (f < Float.valueOf(localObject[2]).floatValue())) {
        this.curCpuLevel = 2;
      } else if (f >= Float.valueOf(localObject[2]).floatValue()) {
        this.curCpuLevel = 3;
      }
    }
    return this.curCpuLevel;
  }
  
  public int getCurrentMemLevel()
  {
    int i = this.curMemLevel;
    if (i != -1) {
      return i;
    }
    this.curMemLevel = 1;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "hardwarerestriction_ram_size", "750,1000,2000");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("memLevelList ");
      localStringBuilder.append((String)localObject);
      QLog.d("QzoneHardwareRestriction", 2, localStringBuilder.toString());
    }
    localObject = ((String)localObject).split(",");
    long l = getTotalMem() / 1024L;
    if ((localObject.length == 3) && (l != 0L))
    {
      float f = (float)l;
      if (f < Float.valueOf(localObject[0]).floatValue()) {
        this.curMemLevel = 0;
      } else if ((f >= Float.valueOf(localObject[0]).floatValue()) && (f < Float.valueOf(localObject[1]).floatValue())) {
        this.curMemLevel = 1;
      } else if ((f >= Float.valueOf(localObject[1]).floatValue()) && (f < Float.valueOf(localObject[2]).floatValue())) {
        this.curMemLevel = 2;
      } else if (f >= Float.valueOf(localObject[2]).floatValue()) {
        this.curMemLevel = 3;
      }
    }
    return this.curMemLevel;
  }
  
  public int getCurrentMemLevelNew()
  {
    int i = this.curMemLevel;
    if (i != -1) {
      return i;
    }
    this.curMemLevel = 1;
    Object localObject = QzoneConfig.getInstance().getConfig("QZoneSetting", "hardwarerestriction_ram_size_new", "1000,2000,6000");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("memLevelList ");
      localStringBuilder.append((String)localObject);
      QLog.d("QzoneHardwareRestriction", 2, localStringBuilder.toString());
    }
    localObject = ((String)localObject).split(",");
    long l = getTotalMem() / 1024L;
    if ((localObject.length == 3) && (l != 0L))
    {
      float f = (float)l;
      if (f < Float.valueOf(localObject[0]).floatValue()) {
        this.curMemLevel = 0;
      } else if ((f >= Float.valueOf(localObject[0]).floatValue()) && (f < Float.valueOf(localObject[1]).floatValue())) {
        this.curMemLevel = 1;
      } else if ((f >= Float.valueOf(localObject[1]).floatValue()) && (f < Float.valueOf(localObject[2]).floatValue())) {
        this.curMemLevel = 2;
      } else if (f >= Float.valueOf(localObject[2]).floatValue()) {
        this.curMemLevel = 3;
      }
    }
    return this.curMemLevel;
  }
  
  @SuppressLint({"NewApi"})
  public final int getNumberOfCores()
  {
    if (this.sCpuCoreNum == -1) {
      if (Build.VERSION.SDK_INT >= 17) {
        this.sCpuCoreNum = Runtime.getRuntime().availableProcessors();
      } else {
        this.sCpuCoreNum = getNumCoresOldPhones();
      }
    }
    return this.sCpuCoreNum;
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
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    return 0L;
  }
  
  public long getSDCardAvailableSize()
  {
    try
    {
      Object localObject = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getAvailableBlocks();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSDCardAvailableSize ");
        ((StringBuilder)localObject).append(l2 * l1 / 1024L);
        QLog.d("QzoneHardwareRestriction", 2, ((StringBuilder)localObject).toString());
      }
      l1 = l2 * l1 / 1024L;
      return l1;
    }
    catch (Exception localException)
    {
      label87:
      break label87;
    }
    return 0L;
  }
  
  public long getSystemAvailableSize()
  {
    try
    {
      Object localObject = new StatFs("/data/data/com.tencent.mobileqq/files/");
      long l1 = ((StatFs)localObject).getBlockSize();
      long l2 = ((StatFs)localObject).getAvailableBlocks();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSystemAvailableSize ");
        ((StringBuilder)localObject).append(l2 * l1 / 1024L);
        QLog.d("QzoneHardwareRestriction", 2, ((StringBuilder)localObject).toString());
      }
      l1 = l2 * l1 / 1024L;
      return l1;
    }
    catch (Exception localException)
    {
      label84:
      break label84;
    }
    return 0L;
  }
  
  /* Error */
  public long getTotalMem()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 5
    //   12: new 71	java/io/BufferedReader
    //   15: dup
    //   16: new 64	java/io/FileReader
    //   19: dup
    //   20: ldc_w 316
    //   23: invokespecial 69	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   26: bipush 8
    //   28: invokespecial 74	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore 4
    //   33: aload 4
    //   35: astore_3
    //   36: aload 4
    //   38: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   41: astore 8
    //   43: aload 5
    //   45: astore_3
    //   46: aload 8
    //   48: ifnull +6 -> 54
    //   51: aload 8
    //   53: astore_3
    //   54: aload_3
    //   55: astore 5
    //   57: aload 4
    //   59: invokevirtual 123	java/io/BufferedReader:close	()V
    //   62: goto +101 -> 163
    //   65: astore_3
    //   66: aload_3
    //   67: invokevirtual 317	java/io/IOException:printStackTrace	()V
    //   70: aload 5
    //   72: astore_3
    //   73: goto +90 -> 163
    //   76: astore 5
    //   78: goto +21 -> 99
    //   81: astore 5
    //   83: goto +52 -> 135
    //   86: astore_3
    //   87: aload 8
    //   89: astore 4
    //   91: goto +155 -> 246
    //   94: astore 5
    //   96: aconst_null
    //   97: astore 4
    //   99: aload 4
    //   101: astore_3
    //   102: aload 5
    //   104: invokevirtual 317	java/io/IOException:printStackTrace	()V
    //   107: aload 6
    //   109: astore_3
    //   110: aload 4
    //   112: ifnull +51 -> 163
    //   115: aload 7
    //   117: astore 5
    //   119: aload 4
    //   121: invokevirtual 123	java/io/BufferedReader:close	()V
    //   124: aload 6
    //   126: astore_3
    //   127: goto +36 -> 163
    //   130: astore 5
    //   132: aconst_null
    //   133: astore 4
    //   135: aload 4
    //   137: astore_3
    //   138: aload 5
    //   140: invokevirtual 318	java/io/FileNotFoundException:printStackTrace	()V
    //   143: aload 6
    //   145: astore_3
    //   146: aload 4
    //   148: ifnull +15 -> 163
    //   151: aload 7
    //   153: astore 5
    //   155: aload 4
    //   157: invokevirtual 123	java/io/BufferedReader:close	()V
    //   160: aload 6
    //   162: astore_3
    //   163: aload_3
    //   164: ifnull +32 -> 196
    //   167: aload_3
    //   168: aload_3
    //   169: bipush 58
    //   171: invokevirtual 322	java/lang/String:indexOf	(I)I
    //   174: iconst_1
    //   175: iadd
    //   176: aload_3
    //   177: bipush 107
    //   179: invokevirtual 322	java/lang/String:indexOf	(I)I
    //   182: invokevirtual 326	java/lang/String:substring	(II)Ljava/lang/String;
    //   185: invokevirtual 329	java/lang/String:trim	()Ljava/lang/String;
    //   188: invokestatic 333	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   191: i2l
    //   192: lstore_1
    //   193: goto +5 -> 198
    //   196: lconst_0
    //   197: lstore_1
    //   198: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +35 -> 236
    //   204: new 50	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   211: astore_3
    //   212: aload_3
    //   213: ldc_w 335
    //   216: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload_3
    //   221: lload_1
    //   222: invokevirtual 203	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: ldc 93
    //   228: iconst_2
    //   229: aload_3
    //   230: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: lload_1
    //   237: lreturn
    //   238: astore 5
    //   240: aload_3
    //   241: astore 4
    //   243: aload 5
    //   245: astore_3
    //   246: aload 4
    //   248: ifnull +18 -> 266
    //   251: aload 4
    //   253: invokevirtual 123	java/io/BufferedReader:close	()V
    //   256: goto +10 -> 266
    //   259: astore 4
    //   261: aload 4
    //   263: invokevirtual 317	java/io/IOException:printStackTrace	()V
    //   266: aload_3
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	QzoneHardwareRestrictionImpl
    //   192	45	1	l	long
    //   35	20	3	localObject1	Object
    //   65	2	3	localIOException1	java.io.IOException
    //   72	1	3	localObject2	Object
    //   86	1	3	localObject3	Object
    //   101	166	3	localObject4	Object
    //   31	221	4	localObject5	Object
    //   259	3	4	localIOException2	java.io.IOException
    //   10	61	5	localObject6	Object
    //   76	1	5	localIOException3	java.io.IOException
    //   81	1	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   94	9	5	localIOException4	java.io.IOException
    //   117	1	5	localObject7	Object
    //   130	9	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   153	1	5	localObject8	Object
    //   238	6	5	localObject9	Object
    //   4	157	6	localObject10	Object
    //   1	151	7	localObject11	Object
    //   7	81	8	str	String
    // Exception table:
    //   from	to	target	type
    //   57	62	65	java/io/IOException
    //   119	124	65	java/io/IOException
    //   155	160	65	java/io/IOException
    //   36	43	76	java/io/IOException
    //   36	43	81	java/io/FileNotFoundException
    //   12	33	86	finally
    //   12	33	94	java/io/IOException
    //   12	33	130	java/io/FileNotFoundException
    //   36	43	238	finally
    //   102	107	238	finally
    //   138	143	238	finally
    //   251	256	259	java/io/IOException
  }
  
  public boolean meetHardwareRestriction(int paramInt1, int paramInt2)
  {
    return (paramInt1 <= getCurrentMemLevel()) && (paramInt2 <= getCurrentCpuLevel());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.utils.impl.QzoneHardwareRestrictionImpl
 * JD-Core Version:    0.7.0.1
 */