package com.tencent.mobileqq.ptt.impl;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mobileqq.ptt.IQQRecorder;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.ptt.QQRecorder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.AmrInputStreamWrapper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.SilkCodecWrapper;
import java.io.File;

public class QQRecorderUtilsImpl
  implements IQQRecorderUtils
{
  static int[] frameSize = { 13, 14, 16, 18, 20, 21, 27, 32 };
  private String lastRecorderPath = null;
  private final boolean useSecond = true;
  
  public int bytesInMillisecond(int paramInt1, int paramInt2, int paramInt3)
  {
    return bytesInSecond(paramInt1, paramInt2, paramInt3) / 1000;
  }
  
  public int bytesInSecond(int paramInt)
  {
    return bytesInSecond(paramInt, 2, 2);
  }
  
  public int bytesInSecond(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    if (paramInt2 != 2)
    {
      if (paramInt2 != 3)
      {
        if (paramInt2 == 4) {
          break label48;
        }
        if (paramInt2 != 12)
        {
          if (paramInt2 == 16) {
            break label48;
          }
          throw new RuntimeException("channel Illegal");
        }
      }
      paramInt2 = 2;
      break label50;
    }
    label48:
    paramInt2 = 1;
    label50:
    if (paramInt3 != 2)
    {
      if (paramInt3 == 3) {
        paramInt3 = i;
      } else {
        throw new RuntimeException("format Illegal");
      }
    }
    else {
      paramInt3 = 2;
    }
    return paramInt1 * paramInt3 * paramInt2;
  }
  
  public boolean checkExternalStorageForRecord()
  {
    return new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1;
  }
  
  public boolean checkIntenalStorageForRecord(int paramInt)
  {
    if (paramInt == 0)
    {
      if (AmrInputStreamWrapper.a()) {
        return true;
      }
      return FileUtils.getAvailableInnernalMemorySize() > 327680.0F;
    }
    if (SilkCodecWrapper.a()) {
      return true;
    }
    return FileUtils.getAvailableInnernalMemorySize() > 1310720.0F;
  }
  
  public IQQRecorder createQQRecorder(Context paramContext)
  {
    return new QQRecorder(paramContext);
  }
  
  public int dsToIs(double paramDouble)
  {
    double d = paramDouble;
    if (paramDouble <= 0.5D)
    {
      d = paramDouble;
      if (paramDouble > 0.0D) {
        d = paramDouble + 0.5D;
      }
    }
    return (int)(d + 0.5D);
  }
  
  /* Error */
  public int getFilePlayTime(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: new 95	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: new 98	java/io/DataInputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 101	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore 9
    //   22: aload_1
    //   23: astore 8
    //   25: aload 9
    //   27: astore 10
    //   29: aload_1
    //   30: invokevirtual 104	java/io/FileInputStream:available	()I
    //   33: istore 6
    //   35: aload_1
    //   36: astore 8
    //   38: aload 9
    //   40: astore 10
    //   42: bipush 10
    //   44: newarray byte
    //   46: astore 12
    //   48: aload_1
    //   49: astore 8
    //   51: aload 9
    //   53: astore 10
    //   55: aload 9
    //   57: aload 12
    //   59: invokevirtual 108	java/io/DataInputStream:read	([B)I
    //   62: aload 12
    //   64: arraylength
    //   65: if_icmpne +141 -> 206
    //   68: aload_1
    //   69: astore 8
    //   71: aload 9
    //   73: astore 10
    //   75: aload 12
    //   77: invokestatic 113	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	([B)Z
    //   80: ifeq +39 -> 119
    //   83: aload_1
    //   84: astore 8
    //   86: aload 9
    //   88: astore 10
    //   90: aload 12
    //   92: iconst_0
    //   93: baload
    //   94: aload 9
    //   96: invokestatic 116	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(BLjava/io/InputStream;)I
    //   99: istore 6
    //   101: iload 6
    //   103: i2d
    //   104: dstore_2
    //   105: dload_2
    //   106: invokestatic 122	java/lang/Double:isNaN	(D)Z
    //   109: pop
    //   110: dload_2
    //   111: ldc2_w 123
    //   114: ddiv
    //   115: dstore_2
    //   116: goto +65 -> 181
    //   119: aload 12
    //   121: bipush 6
    //   123: baload
    //   124: iconst_3
    //   125: ishr
    //   126: i2b
    //   127: bipush 7
    //   129: iand
    //   130: i2b
    //   131: istore 7
    //   133: iload 6
    //   135: i2d
    //   136: dstore_2
    //   137: dload_2
    //   138: invokestatic 122	java/lang/Double:isNaN	(D)Z
    //   141: pop
    //   142: aload_1
    //   143: astore 8
    //   145: aload 9
    //   147: astore 10
    //   149: getstatic 16	com/tencent/mobileqq/ptt/impl/QQRecorderUtilsImpl:frameSize	[I
    //   152: iload 7
    //   154: iaload
    //   155: istore 6
    //   157: iload 6
    //   159: i2d
    //   160: dstore 4
    //   162: dload 4
    //   164: invokestatic 122	java/lang/Double:isNaN	(D)Z
    //   167: pop
    //   168: dload_2
    //   169: ldc2_w 125
    //   172: dsub
    //   173: dload 4
    //   175: ddiv
    //   176: ldc2_w 127
    //   179: ddiv
    //   180: dstore_2
    //   181: aload_1
    //   182: astore 8
    //   184: aload 9
    //   186: astore 10
    //   188: aload 9
    //   190: invokevirtual 131	java/io/DataInputStream:close	()V
    //   193: aload_1
    //   194: invokevirtual 132	java/io/FileInputStream:close	()V
    //   197: aconst_null
    //   198: astore 9
    //   200: aload 11
    //   202: astore_1
    //   203: goto +5 -> 208
    //   206: dconst_0
    //   207: dstore_2
    //   208: aload_1
    //   209: ifnull +7 -> 216
    //   212: aload_1
    //   213: invokevirtual 132	java/io/FileInputStream:close	()V
    //   216: aload 9
    //   218: ifnull +8 -> 226
    //   221: aload 9
    //   223: invokevirtual 131	java/io/DataInputStream:close	()V
    //   226: aload_0
    //   227: dload_2
    //   228: invokevirtual 134	com/tencent/mobileqq/ptt/impl/QQRecorderUtilsImpl:dsToIs	(D)I
    //   231: ireturn
    //   232: astore 11
    //   234: aload_1
    //   235: astore 12
    //   237: aload 9
    //   239: astore_1
    //   240: goto +44 -> 284
    //   243: astore 8
    //   245: aconst_null
    //   246: astore 10
    //   248: goto +77 -> 325
    //   251: astore 11
    //   253: aconst_null
    //   254: astore 8
    //   256: aload_1
    //   257: astore 12
    //   259: aload 8
    //   261: astore_1
    //   262: goto +22 -> 284
    //   265: astore 8
    //   267: aconst_null
    //   268: astore 10
    //   270: aload 10
    //   272: astore_1
    //   273: goto +52 -> 325
    //   276: astore 11
    //   278: aconst_null
    //   279: astore 12
    //   281: aload 12
    //   283: astore_1
    //   284: aload 12
    //   286: astore 8
    //   288: aload_1
    //   289: astore 10
    //   291: aload 11
    //   293: invokevirtual 137	java/lang/Exception:printStackTrace	()V
    //   296: aload 12
    //   298: ifnull +8 -> 306
    //   301: aload 12
    //   303: invokevirtual 132	java/io/FileInputStream:close	()V
    //   306: aload_1
    //   307: ifnull +7 -> 314
    //   310: aload_1
    //   311: invokevirtual 131	java/io/DataInputStream:close	()V
    //   314: iconst_0
    //   315: ireturn
    //   316: astore 9
    //   318: aload 8
    //   320: astore_1
    //   321: aload 9
    //   323: astore 8
    //   325: aload_1
    //   326: ifnull +7 -> 333
    //   329: aload_1
    //   330: invokevirtual 132	java/io/FileInputStream:close	()V
    //   333: aload 10
    //   335: ifnull +8 -> 343
    //   338: aload 10
    //   340: invokevirtual 131	java/io/DataInputStream:close	()V
    //   343: aload 8
    //   345: athrow
    //   346: astore_1
    //   347: goto -121 -> 226
    //   350: astore_1
    //   351: iconst_0
    //   352: ireturn
    //   353: astore_1
    //   354: goto -11 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	QQRecorderUtilsImpl
    //   0	357	1	paramString	String
    //   104	124	2	d1	double
    //   160	14	4	d2	double
    //   33	125	6	i	int
    //   131	22	7	j	int
    //   23	160	8	str	String
    //   243	1	8	localObject1	Object
    //   254	6	8	localObject2	Object
    //   265	1	8	localObject3	Object
    //   286	58	8	localObject4	Object
    //   20	218	9	localDataInputStream	java.io.DataInputStream
    //   316	6	9	localObject5	Object
    //   27	312	10	localObject6	Object
    //   1	200	11	localObject7	Object
    //   232	1	11	localException1	java.lang.Exception
    //   251	1	11	localException2	java.lang.Exception
    //   276	16	11	localException3	java.lang.Exception
    //   46	256	12	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   29	35	232	java/lang/Exception
    //   42	48	232	java/lang/Exception
    //   55	68	232	java/lang/Exception
    //   75	83	232	java/lang/Exception
    //   90	101	232	java/lang/Exception
    //   149	157	232	java/lang/Exception
    //   188	193	232	java/lang/Exception
    //   12	22	243	finally
    //   193	197	243	finally
    //   12	22	251	java/lang/Exception
    //   193	197	251	java/lang/Exception
    //   3	12	265	finally
    //   3	12	276	java/lang/Exception
    //   29	35	316	finally
    //   42	48	316	finally
    //   55	68	316	finally
    //   75	83	316	finally
    //   90	101	316	finally
    //   149	157	316	finally
    //   188	193	316	finally
    //   291	296	316	finally
    //   212	216	346	java/lang/Exception
    //   221	226	346	java/lang/Exception
    //   301	306	350	java/lang/Exception
    //   310	314	350	java/lang/Exception
    //   329	333	353	java/lang/Exception
    //   338	343	353	java/lang/Exception
  }
  
  public String getLastRecorderPath()
  {
    return this.lastRecorderPath;
  }
  
  public double getMillisecond(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (paramLong <= 0L) {
      return 0.0D;
    }
    double d1 = paramLong;
    double d2 = bytesInMillisecond(paramInt1, paramInt2, paramInt3);
    Double.isNaN(d1);
    Double.isNaN(d2);
    return d1 / d2;
  }
  
  public int getPttRecordTime(double paramDouble)
  {
    return ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).msToSec(paramDouble);
  }
  
  public int getPttShowTime(int paramInt)
  {
    return paramInt;
  }
  
  public RecordParams.RecorderParam getRecorderParam()
  {
    return new RecordParams.RecorderParam(RecordParams.a, 0, 0);
  }
  
  public int msToSec(double paramDouble)
  {
    return dsToIs(paramDouble / 1000.0D);
  }
  
  public void setLastRecorderPath(String paramString)
  {
    this.lastRecorderPath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.impl.QQRecorderUtilsImpl
 * JD-Core Version:    0.7.0.1
 */