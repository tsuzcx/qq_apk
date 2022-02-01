package com.tencent.mobileqq.kandian.repo.common;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

public class ReadInJoyRefreshOptimizeUtil
{
  /* Error */
  public static int a(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject, com.tencent.mobileqq.pb.MessageMicro paramMessageMicro, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 19	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: istore 6
    //   6: iload 6
    //   8: sipush 1000
    //   11: if_icmpne +315 -> 326
    //   14: aconst_null
    //   15: astore 8
    //   17: aconst_null
    //   18: astore_1
    //   19: aload_2
    //   20: ifnull +68 -> 88
    //   23: new 21	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   26: dup
    //   27: invokespecial 22	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   30: astore 8
    //   32: aload 8
    //   34: aload_2
    //   35: checkcast 24	[B
    //   38: checkcast 24	[B
    //   41: invokevirtual 28	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   44: checkcast 21	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   47: astore_1
    //   48: goto +51 -> 99
    //   51: astore_2
    //   52: aload 8
    //   54: astore_1
    //   55: goto +4 -> 59
    //   58: astore_2
    //   59: ldc 30
    //   61: iconst_1
    //   62: iconst_2
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: ldc 32
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload_2
    //   74: invokevirtual 36	java/lang/Exception:toString	()Ljava/lang/String;
    //   77: aastore
    //   78: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   81: aload_2
    //   82: invokevirtual 45	java/lang/Exception:printStackTrace	()V
    //   85: goto +14 -> 99
    //   88: ldc 30
    //   90: iconst_1
    //   91: ldc 47
    //   93: invokestatic 50	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   96: aload 8
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull +12 -> 112
    //   103: aload_1
    //   104: getfield 54	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: invokevirtual 59	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   110: istore 6
    //   112: iload 6
    //   114: istore 7
    //   116: aload_1
    //   117: ifnull +236 -> 353
    //   120: iload 6
    //   122: istore 7
    //   124: aload_1
    //   125: getfield 63	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   128: invokevirtual 69	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   131: ifeq +222 -> 353
    //   134: iload 6
    //   136: istore 7
    //   138: aload_1
    //   139: getfield 63	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   142: invokevirtual 72	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   145: ifnull +208 -> 353
    //   148: iload 6
    //   150: istore 7
    //   152: aload_3
    //   153: ifnull +200 -> 353
    //   156: aload_1
    //   157: getfield 63	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   160: invokevirtual 72	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   163: invokevirtual 78	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   166: astore 8
    //   168: aload 8
    //   170: astore_1
    //   171: iload 6
    //   173: ifne +78 -> 251
    //   176: aload 8
    //   178: astore_1
    //   179: iload 4
    //   181: ifeq +70 -> 251
    //   184: aload 8
    //   186: aload_0
    //   187: invokestatic 81	com/tencent/mobileqq/kandian/repo/common/ReadInJoyRefreshOptimizeUtil:a	([BLcom/tencent/qphone/base/remote/ToServiceMsg;)[B
    //   190: astore_2
    //   191: aload 8
    //   193: astore_1
    //   194: aload_2
    //   195: arraylength
    //   196: ifle +55 -> 251
    //   199: aload 8
    //   201: arraylength
    //   202: sipush 10000
    //   205: imul
    //   206: aload_2
    //   207: arraylength
    //   208: idiv
    //   209: i2f
    //   210: fconst_1
    //   211: fmul
    //   212: ldc 82
    //   214: fdiv
    //   215: fstore 5
    //   217: new 84	java/text/DecimalFormat
    //   220: dup
    //   221: ldc 86
    //   223: invokespecial 89	java/text/DecimalFormat:<init>	(Ljava/lang/String;)V
    //   226: astore_1
    //   227: aload_0
    //   228: ifnull +128 -> 356
    //   231: aload_0
    //   232: invokevirtual 95	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   235: ldc 97
    //   237: aload_1
    //   238: fload 5
    //   240: f2d
    //   241: invokevirtual 101	java/text/DecimalFormat:format	(D)Ljava/lang/String;
    //   244: invokevirtual 107	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   247: pop
    //   248: goto +108 -> 356
    //   251: aload_3
    //   252: aload_1
    //   253: invokevirtual 110	com/tencent/mobileqq/pb/MessageMicro:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   256: pop
    //   257: iload 6
    //   259: istore 7
    //   261: aload_0
    //   262: ifnull +91 -> 353
    //   265: aload_0
    //   266: invokevirtual 95	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   269: ldc 112
    //   271: ldc 114
    //   273: invokevirtual 107	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   276: pop
    //   277: iload 6
    //   279: ireturn
    //   280: astore_1
    //   281: ldc 30
    //   283: iconst_1
    //   284: iconst_2
    //   285: anewarray 4	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: ldc 116
    //   292: aastore
    //   293: dup
    //   294: iconst_1
    //   295: aload_1
    //   296: invokevirtual 36	java/lang/Exception:toString	()Ljava/lang/String;
    //   299: aastore
    //   300: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   303: iload 6
    //   305: istore 7
    //   307: aload_0
    //   308: ifnull +45 -> 353
    //   311: aload_0
    //   312: invokevirtual 95	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   315: ldc 112
    //   317: ldc 118
    //   319: invokevirtual 107	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   322: pop
    //   323: iload 6
    //   325: ireturn
    //   326: ldc 30
    //   328: iconst_1
    //   329: iconst_2
    //   330: anewarray 4	java/lang/Object
    //   333: dup
    //   334: iconst_0
    //   335: ldc 120
    //   337: aastore
    //   338: dup
    //   339: iconst_1
    //   340: iload 6
    //   342: invokestatic 126	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   345: aastore
    //   346: invokestatic 42	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   349: iload 6
    //   351: istore 7
    //   353: iload 7
    //   355: ireturn
    //   356: aload_2
    //   357: astore_1
    //   358: goto -107 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	paramToServiceMsg	ToServiceMsg
    //   0	361	1	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	361	2	paramObject	Object
    //   0	361	3	paramMessageMicro	com.tencent.mobileqq.pb.MessageMicro
    //   0	361	4	paramBoolean	boolean
    //   215	24	5	f	float
    //   4	346	6	i	int
    //   114	240	7	j	int
    //   15	185	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   32	48	51	java/lang/Exception
    //   23	32	58	java/lang/Exception
    //   156	168	280	java/lang/Exception
    //   184	191	280	java/lang/Exception
    //   194	227	280	java/lang/Exception
    //   231	248	280	java/lang/Exception
    //   251	257	280	java/lang/Exception
    //   265	277	280	java/lang/Exception
  }
  
  public static long a()
  {
    long l = 0L;
    Long localLong = (Long)RIJSPUtils.a("sp_key_readinjoy_refresh_optimize_id", Long.valueOf(0L));
    if (localLong != null) {
      l = localLong.longValue();
    }
    QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "getOptimizeId = ", Long.valueOf(l) });
    return l;
  }
  
  public static void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    if (paramRequest0x68bParams != null)
    {
      QLog.d("ReadInJoyRefreshOptimizeUtil", 1, "addPackageCompressFlag.");
      paramRequest0x68bParams.f |= 0x4000;
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    if (paramToServiceMsg == null)
    {
      QLog.d("ReadInJoyRefreshOptimizeUtil", 1, "req is null.");
      return;
    }
    if (c(paramLong))
    {
      paramToServiceMsg.setEnableFastResend(true);
      QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "addFastResend true, optimizeID = ", Long.valueOf(paramLong) });
    }
  }
  
  public static void a(String paramString)
  {
    QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "receive 92 config, updateOptimizeId = ", paramString });
    long l;
    try
    {
      l = Long.valueOf(paramString).longValue();
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
      QLog.d("ReadInJoyRefreshOptimizeUtil", 1, "optimizeID is not a number");
      l = 0L;
    }
    RIJSPUtils.a("sp_key_readinjoy_refresh_optimize_id", Long.valueOf(l));
  }
  
  public static boolean a(long paramLong)
  {
    return (paramLong & 0x4) > 0L;
  }
  
  private static byte[] a(byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
  {
    long l = System.currentTimeMillis();
    try
    {
      localObject = new ByteArrayInputStream(paramArrayOfByte);
      paramArrayOfByte = new ByteArrayOutputStream();
      localObject = new GZIPInputStream((InputStream)localObject);
      byte[] arrayOfByte = new byte[1024];
      for (;;)
      {
        int i = ((GZIPInputStream)localObject).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramArrayOfByte.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = paramArrayOfByte.toByteArray();
      if (paramToServiceMsg != null) {
        paramToServiceMsg.getAttributes().put("unCompressSucceed", "0");
      }
      QLog.d("ReadInJoyRefreshOptimizeUtil", 1, "unCompressBody succeed, data report succeed.");
    }
    catch (Throwable paramArrayOfByte)
    {
      localObject = new byte[0];
      QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "unCompressBody finally failed: ", paramArrayOfByte.toString(), ", data report failed." });
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = (byte[])localObject;
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.getAttributes().put("unCompressSucceed", "2");
        paramArrayOfByte = (byte[])localObject;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      Object localObject = new byte[0];
      QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "unCompressBody IOException failed: ", paramArrayOfByte.toString(), ", data report failed." });
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = (byte[])localObject;
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.getAttributes().put("unCompressSucceed", "1");
        paramArrayOfByte = (byte[])localObject;
      }
    }
    l = System.currentTimeMillis() - l;
    if (paramToServiceMsg != null) {
      paramToServiceMsg.getAttributes().put("unCompressTimeCost", Long.valueOf(l));
    }
    QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "unCompressBody cost = ", Long.valueOf(l) });
    return paramArrayOfByte;
  }
  
  public static boolean b(long paramLong)
  {
    return (paramLong & 1L) > 0L;
  }
  
  private static boolean c(long paramLong)
  {
    return (paramLong & 0x2) > 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.common.ReadInJoyRefreshOptimizeUtil
 * JD-Core Version:    0.7.0.1
 */