import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class pot
{
  /* Error */
  public static int a(com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject, com.tencent.mobileqq.pb.MessageMicro paramMessageMicro)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokevirtual 14	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   7: istore_3
    //   8: invokestatic 20	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   11: ifeq +222 -> 233
    //   14: new 22	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   21: astore 4
    //   23: iload_3
    //   24: sipush 1000
    //   27: if_icmpne +179 -> 206
    //   30: aload_1
    //   31: ifnull +134 -> 165
    //   34: new 28	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   37: dup
    //   38: invokespecial 29	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   41: astore_0
    //   42: aload_0
    //   43: aload_1
    //   44: checkcast 31	[B
    //   47: checkcast 31	[B
    //   50: invokevirtual 35	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   53: checkcast 28	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   56: astore_1
    //   57: aload_1
    //   58: astore_0
    //   59: aload_0
    //   60: ifnull +170 -> 230
    //   63: aload_0
    //   64: getfield 39	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   67: invokevirtual 44	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   70: istore_3
    //   71: aload_0
    //   72: ifnull +42 -> 114
    //   75: aload_0
    //   76: getfield 48	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   79: invokevirtual 53	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   82: ifeq +32 -> 114
    //   85: aload_0
    //   86: getfield 48	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   89: invokevirtual 56	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   92: ifnull +22 -> 114
    //   95: aload_2
    //   96: ifnull +18 -> 114
    //   99: aload_2
    //   100: aload_0
    //   101: getfield 48	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   104: invokevirtual 56	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   107: invokevirtual 62	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   110: invokevirtual 65	com/tencent/mobileqq/pb/MessageMicro:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   113: pop
    //   114: aload 4
    //   116: ifnull +17 -> 133
    //   119: aload 4
    //   121: invokevirtual 68	java/lang/StringBuilder:length	()I
    //   124: ifle +9 -> 133
    //   127: invokestatic 20	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   130: ifeq +3 -> 133
    //   133: iload_3
    //   134: ireturn
    //   135: astore_1
    //   136: aconst_null
    //   137: astore_0
    //   138: aload 4
    //   140: ifnull +18 -> 158
    //   143: aload 4
    //   145: ldc 70
    //   147: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_1
    //   151: invokevirtual 78	java/lang/Exception:toString	()Ljava/lang/String;
    //   154: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload_1
    //   159: invokevirtual 81	java/lang/Exception:printStackTrace	()V
    //   162: goto -103 -> 59
    //   165: aload 5
    //   167: astore_0
    //   168: aload 4
    //   170: ifnull -111 -> 59
    //   173: aload 4
    //   175: ldc 83
    //   177: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 5
    //   183: astore_0
    //   184: goto -125 -> 59
    //   187: astore_0
    //   188: aload 4
    //   190: ifnull -76 -> 114
    //   193: aload 4
    //   195: aload_0
    //   196: invokevirtual 78	java/lang/Exception:toString	()Ljava/lang/String;
    //   199: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: goto -89 -> 114
    //   206: aload 4
    //   208: ifnull +15 -> 223
    //   211: aload 4
    //   213: ldc 85
    //   215: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload_3
    //   219: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: goto -109 -> 114
    //   226: astore_1
    //   227: goto -89 -> 138
    //   230: goto -159 -> 71
    //   233: aconst_null
    //   234: astore 4
    //   236: goto -213 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	239	1	paramObject	Object
    //   0	239	2	paramMessageMicro	com.tencent.mobileqq.pb.MessageMicro
    //   7	212	3	i	int
    //   21	214	4	localStringBuilder	java.lang.StringBuilder
    //   1	181	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	42	135	java/lang/Exception
    //   99	114	187	java/lang/Exception
    //   42	57	226	java/lang/Exception
  }
  
  public static ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", onh.a(), paramString);
  }
  
  public static ToServiceMsg a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramString = a(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(30000L);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pot
 * JD-Core Version:    0.7.0.1
 */