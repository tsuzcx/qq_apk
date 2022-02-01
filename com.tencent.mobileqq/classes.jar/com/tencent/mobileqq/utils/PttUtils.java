package com.tencent.mobileqq.utils;

import android.util.SparseIntArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import tencent.im.cs.ptt_waveform.ptt_waveform.PttWaveform;

public class PttUtils
{
  private static final SparseIntArray a = new SparseIntArray(8);
  
  static
  {
    a.put(4, 13);
    a.put(12, 14);
    a.put(20, 16);
    a.put(28, 18);
    a.put(36, 20);
    a.put(44, 21);
    a.put(52, 27);
    a.put(60, 32);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = 1;
    if (paramInt == 8) {
      i = 8;
    } else if (paramInt != 1) {
      if (paramInt == 2) {
        i = 2;
      } else {
        i = 3;
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004603", "0X8004603", 0, 0, localStringBuilder.toString(), "", "", "");
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("report cancle send ptt, cancel source = ");
      paramQQAppInterface.append(paramInt);
      QLog.d("QQRecorder", 2, paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 1;
    if (paramInt1 == 0) {
      paramInt1 = 1;
    } else if (paramInt1 == 3000) {
      paramInt1 = 2;
    } else if (paramInt1 == 1) {
      paramInt1 = 3;
    } else {
      paramInt1 = 4;
    }
    Object localObject1;
    Object localObject2;
    if (paramInt2 == 8)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append("");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006189", "0X8006189", 0, 0, "", (String)localObject1, ((StringBuilder)localObject2).toString(), "");
    }
    else if ((paramInt2 != 1) && (paramInt2 != 2))
    {
      if (paramInt2 == 4)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt3);
        ((StringBuilder)localObject2).append("");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005C1E", "0X8005C1E", 0, 0, "", (String)localObject1, ((StringBuilder)localObject2).toString(), "");
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append("");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramInt3);
        ((StringBuilder)localObject2).append("");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004601", "0X8004601", 0, 0, "", (String)localObject1, ((StringBuilder)localObject2).toString(), "");
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      if (paramInt2 != 1) {
        i = 2;
      }
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004600", "0X8004600", 0, 0, (String)localObject1, (String)localObject2, localStringBuilder.toString(), "");
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("report send ptt, send source = ");
      paramQQAppInterface.append(paramInt2);
      paramQQAppInterface.append(", sessionType = ");
      paramQQAppInterface.append(paramInt1);
      paramQQAppInterface.append(", seconds = ");
      paramQQAppInterface.append(paramInt3);
      QLog.d("QQRecorder", 2, paramQQAppInterface.toString());
    }
  }
  
  private static final boolean a(ByteArrayInputStream paramByteArrayInputStream, int[] paramArrayOfInt)
  {
    paramByteArrayInputStream.read("#!AMR\n".getBytes());
    int j = paramByteArrayInputStream.read();
    int i = 0;
    while ((i < paramArrayOfInt.length) && (j != paramArrayOfInt[i])) {
      i += 1;
    }
    if (i == paramArrayOfInt.length) {
      return false;
    }
    i = a.get(j, -1);
    if (i == -1) {
      return false;
    }
    paramArrayOfInt = new byte[i - 1];
    paramByteArrayInputStream.read(paramArrayOfInt);
    for (;;)
    {
      i = paramByteArrayInputStream.read();
      if (i == -1) {
        break;
      }
      if (i != j) {
        return false;
      }
      paramByteArrayInputStream.read(paramArrayOfInt);
    }
    return true;
  }
  
  /* Error */
  public static final boolean a(String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: new 108	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 111	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 114	java/io/File:exists	()Z
    //   13: ifeq +108 -> 121
    //   16: aload_3
    //   17: invokevirtual 118	java/io/File:length	()J
    //   20: lconst_0
    //   21: lcmp
    //   22: ifne +5 -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: aconst_null
    //   28: astore 4
    //   30: aconst_null
    //   31: astore_0
    //   32: new 90	java/io/ByteArrayInputStream
    //   35: dup
    //   36: aload_3
    //   37: invokestatic 124	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
    //   40: invokespecial 127	java/io/ByteArrayInputStream:<init>	([B)V
    //   43: astore_3
    //   44: aload_3
    //   45: aload_1
    //   46: invokestatic 129	com/tencent/mobileqq/utils/PttUtils:a	(Ljava/io/ByteArrayInputStream;[I)Z
    //   49: istore_2
    //   50: aload_3
    //   51: invokevirtual 132	java/io/ByteArrayInputStream:close	()V
    //   54: iload_2
    //   55: ireturn
    //   56: astore_0
    //   57: aload_3
    //   58: astore_1
    //   59: goto +52 -> 111
    //   62: astore_0
    //   63: aload_3
    //   64: astore_1
    //   65: aload_0
    //   66: astore_3
    //   67: goto +15 -> 82
    //   70: astore_3
    //   71: aload_0
    //   72: astore_1
    //   73: aload_3
    //   74: astore_0
    //   75: goto +36 -> 111
    //   78: astore_3
    //   79: aload 4
    //   81: astore_1
    //   82: aload_1
    //   83: astore_0
    //   84: invokestatic 56	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +14 -> 101
    //   90: aload_1
    //   91: astore_0
    //   92: ldc 134
    //   94: iconst_2
    //   95: ldc 136
    //   97: aload_3
    //   98: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 132	java/io/ByteArrayInputStream:close	()V
    //   109: iconst_0
    //   110: ireturn
    //   111: aload_1
    //   112: ifnull +7 -> 119
    //   115: aload_1
    //   116: invokevirtual 132	java/io/ByteArrayInputStream:close	()V
    //   119: aload_0
    //   120: athrow
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_0
    //   124: iload_2
    //   125: ireturn
    //   126: astore_0
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_1
    //   130: goto -11 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramString	String
    //   0	133	1	paramArrayOfInt	int[]
    //   49	76	2	bool	boolean
    //   8	59	3	localObject1	Object
    //   70	4	3	localObject2	Object
    //   78	20	3	localThrowable	java.lang.Throwable
    //   28	52	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   44	50	56	finally
    //   44	50	62	java/lang/Throwable
    //   32	44	70	finally
    //   84	90	70	finally
    //   92	101	70	finally
    //   32	44	78	java/lang/Throwable
    //   50	54	123	java/lang/Exception
    //   105	109	126	java/lang/Exception
    //   115	119	129	java/lang/Exception
  }
  
  public static int[] a(ptt_waveform.PttWaveform paramPttWaveform)
  {
    if ((paramPttWaveform != null) && (paramPttWaveform.uin32_size.has()) && (paramPttWaveform.uin32_size.get() > 0) && (paramPttWaveform.bytes_amplitudes.has()))
    {
      int j = paramPttWaveform.uin32_size.get();
      int[] arrayOfInt = new int[j];
      paramPttWaveform = paramPttWaveform.bytes_amplitudes.get().toByteArray();
      if (paramPttWaveform.length != j)
      {
        QLog.e("PttUtils", 2, "changePtToWaveform, data error");
        return null;
      }
      int i = 0;
      while (i < j)
      {
        paramPttWaveform[i] &= 0xFF;
        i += 1;
      }
      return arrayOfInt;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PttUtils
 * JD-Core Version:    0.7.0.1
 */