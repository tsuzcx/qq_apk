import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.HashMap;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class obr
{
  public static int a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, MessageMicro paramMessageMicro, boolean paramBoolean)
  {
    int i = paramFromServiceMsg.getResultCode();
    if (i == 1000)
    {
      if (paramObject != null) {}
      for (;;)
      {
        try
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        }
        catch (Exception paramObject)
        {
          paramFromServiceMsg = null;
        }
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
          paramFromServiceMsg = paramObject;
          if (paramFromServiceMsg == null) {
            break label315;
          }
          i = paramFromServiceMsg.uint32_result.get();
        }
        catch (Exception paramObject)
        {
          break label198;
          continue;
          continue;
        }
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null) && (paramMessageMicro != null)) {}
        try
        {
          paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
          if ((i != 0) || (!paramBoolean)) {
            break;
          }
          paramObject = a(paramFromServiceMsg, paramToServiceMsg);
          if (paramObject.length <= 0) {
            break;
          }
          float f = paramFromServiceMsg.length * 10000 / paramObject.length * 1.0F / 10000.0F;
          DecimalFormat localDecimalFormat = new DecimalFormat("0.0000");
          paramFromServiceMsg = paramObject;
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg.getAttributes().put("compressRatio", localDecimalFormat.format(f));
            paramFromServiceMsg = paramObject;
          }
          paramMessageMicro.mergeFrom(paramFromServiceMsg);
          if (paramToServiceMsg != null) {
            paramToServiceMsg.getAttributes().put("finalParseSucceed", "0");
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "parseOIDBPkg msg mergeFrom exception: ", paramFromServiceMsg.toString() });
          if (paramToServiceMsg == null) {
            continue;
          }
          paramToServiceMsg.getAttributes().put("finalParseSucceed", "1");
          return i;
        }
        return i;
        label198:
        QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "parseOIDBPkg, oidb_sso exception: ", paramObject.toString() });
        paramObject.printStackTrace();
        continue;
        QLog.d("ReadInJoyRefreshOptimizeUtil", 1, "parseOIDBPkg, data is null.");
        paramFromServiceMsg = null;
      }
    }
    QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "parseOIDBPkg, resultCode = ", Integer.valueOf(i) });
    return i;
  }
  
  public static long a()
  {
    Long localLong = (Long)bgmq.a("sp_key_readinjoy_refresh_optimize_id", Long.valueOf(0L));
    if (localLong != null) {}
    for (long l = localLong.longValue();; l = 0L)
    {
      QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "getOptimizeId = ", Long.valueOf(l) });
      return l;
    }
  }
  
  public static void a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    if (paramToServiceMsg == null) {
      QLog.d("ReadInJoyRefreshOptimizeUtil", 1, "req is null.");
    }
    while (!c(paramLong)) {
      return;
    }
    paramToServiceMsg.setEnableFastResend(true);
    QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "addFastResend true, optimizeID = ", Long.valueOf(paramLong) });
  }
  
  public static void a(String paramString)
  {
    QLog.d("ReadInJoyRefreshOptimizeUtil", 1, new Object[] { "receive 92 config, updateOptimizeId = ", paramString });
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(paramString).longValue();
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        QLog.d("ReadInJoyRefreshOptimizeUtil", 1, "optimizeID is not a number");
      }
    }
    bgmq.a("sp_key_readinjoy_refresh_optimize_id", Long.valueOf(l1));
  }
  
  public static void a(pdh parampdh)
  {
    if (parampdh != null)
    {
      QLog.d("ReadInJoyRefreshOptimizeUtil", 1, "addPackageCompressFlag.");
      parampdh.f |= 0x4000;
    }
  }
  
  public static boolean a(long paramLong)
  {
    return (1L & paramLong) > 0L;
  }
  
  /* Error */
  private static byte[] a(byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
  {
    // Byte code:
    //   0: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 189	java/io/ByteArrayInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 192	java/io/ByteArrayInputStream:<init>	([B)V
    //   12: astore 5
    //   14: new 194	java/io/ByteArrayOutputStream
    //   17: dup
    //   18: invokespecial 195	java/io/ByteArrayOutputStream:<init>	()V
    //   21: astore_0
    //   22: new 197	java/util/zip/GZIPInputStream
    //   25: dup
    //   26: aload 5
    //   28: invokespecial 200	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   31: astore 5
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore 6
    //   40: aload 5
    //   42: aload 6
    //   44: invokevirtual 204	java/util/zip/GZIPInputStream:read	([B)I
    //   47: istore_2
    //   48: iload_2
    //   49: iconst_m1
    //   50: if_icmpeq +121 -> 171
    //   53: aload_0
    //   54: aload 6
    //   56: iconst_0
    //   57: iload_2
    //   58: invokevirtual 208	java/io/ByteArrayOutputStream:write	([BII)V
    //   61: goto -21 -> 40
    //   64: astore_0
    //   65: iconst_0
    //   66: newarray byte
    //   68: astore 5
    //   70: ldc 92
    //   72: iconst_1
    //   73: iconst_3
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: ldc 210
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: aload_0
    //   85: invokevirtual 211	java/io/IOException:toString	()Ljava/lang/String;
    //   88: aastore
    //   89: dup
    //   90: iconst_2
    //   91: ldc 213
    //   93: aastore
    //   94: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   97: aload_0
    //   98: invokevirtual 214	java/io/IOException:printStackTrace	()V
    //   101: aload 5
    //   103: astore_0
    //   104: aload_1
    //   105: ifnull +18 -> 123
    //   108: aload_1
    //   109: invokevirtual 71	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   112: ldc 216
    //   114: ldc 116
    //   116: invokevirtual 83	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: aload 5
    //   122: astore_0
    //   123: invokestatic 187	java/lang/System:currentTimeMillis	()J
    //   126: lload_3
    //   127: lsub
    //   128: lstore_3
    //   129: aload_1
    //   130: ifnull +17 -> 147
    //   133: aload_1
    //   134: invokevirtual 71	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   137: ldc 218
    //   139: lload_3
    //   140: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   143: invokevirtual 83	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   146: pop
    //   147: ldc 92
    //   149: iconst_1
    //   150: iconst_2
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: ldc 220
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: lload_3
    //   162: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   165: aastore
    //   166: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   169: aload_0
    //   170: areturn
    //   171: aload_0
    //   172: invokevirtual 221	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   175: astore_0
    //   176: aload_1
    //   177: ifnull +15 -> 192
    //   180: aload_1
    //   181: invokevirtual 71	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   184: ldc 216
    //   186: ldc 90
    //   188: invokevirtual 83	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: pop
    //   192: ldc 92
    //   194: iconst_1
    //   195: ldc 223
    //   197: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   200: goto -77 -> 123
    //   203: astore_0
    //   204: iconst_0
    //   205: newarray byte
    //   207: astore 5
    //   209: ldc 92
    //   211: iconst_1
    //   212: iconst_3
    //   213: anewarray 4	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: ldc 225
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: aload_0
    //   224: invokevirtual 226	java/lang/Throwable:toString	()Ljava/lang/String;
    //   227: aastore
    //   228: dup
    //   229: iconst_2
    //   230: ldc 213
    //   232: aastore
    //   233: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   236: aload_0
    //   237: invokevirtual 227	java/lang/Throwable:printStackTrace	()V
    //   240: aload 5
    //   242: astore_0
    //   243: aload_1
    //   244: ifnull -121 -> 123
    //   247: aload_1
    //   248: invokevirtual 71	com/tencent/qphone/base/remote/ToServiceMsg:getAttributes	()Ljava/util/HashMap;
    //   251: ldc 216
    //   253: ldc 229
    //   255: invokevirtual 83	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   258: pop
    //   259: aload 5
    //   261: astore_0
    //   262: goto -139 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramArrayOfByte	byte[]
    //   0	265	1	paramToServiceMsg	ToServiceMsg
    //   47	11	2	i	int
    //   3	159	3	l	long
    //   12	248	5	localObject	Object
    //   38	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   4	40	64	java/io/IOException
    //   40	48	64	java/io/IOException
    //   53	61	64	java/io/IOException
    //   171	176	64	java/io/IOException
    //   180	192	64	java/io/IOException
    //   192	200	64	java/io/IOException
    //   4	40	203	java/lang/Throwable
    //   40	48	203	java/lang/Throwable
    //   53	61	203	java/lang/Throwable
    //   171	176	203	java/lang/Throwable
    //   180	192	203	java/lang/Throwable
    //   192	200	203	java/lang/Throwable
  }
  
  public static boolean b(long paramLong)
  {
    return (0x4 & paramLong) > 0L;
  }
  
  private static boolean c(long paramLong)
  {
    return (0x2 & paramLong) > 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     obr
 * JD-Core Version:    0.7.0.1
 */