package com.tencent.mobileqq.msf.core.auth;

import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.af;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.VerifyCodeInfo;
import com.tencent.mobileqq.msf.service.u;
import com.tencent.msf.service.protocol.security.CustomSigContent;
import com.tencent.msf.service.protocol.security.RespondCustomSig;
import com.tencent.msf.service.protocol.security.c;
import com.tencent.msf.service.protocol.security.d;
import com.tencent.msf.service.protocol.security.g;
import com.tencent.msf.service.protocol.security.h;
import com.tencent.msf.service.protocol.security.i;
import com.tencent.msf.service.protocol.security.k;
import com.tencent.msf.service.protocol.security.m;
import com.tencent.msf.service.protocol.security.n;
import com.tencent.msf.service.protocol.security.o;
import com.tencent.msf.service.protocol.security.p;
import com.tencent.msf.service.protocol.security.q;
import com.tencent.msf.service.protocol.security.r;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class j
{
  public static final String a = "test";
  public static final String b = "cmdstr";
  public static final String c = "123";
  public static final String d = "RequestHeader";
  public static final String e = "RequestVerifyPic";
  public static final String f = "RespondVerifyPic";
  public static final String g = "RequestRefreshVPic";
  public static final String h = "RespondRefreshVPic";
  public static final String i = "RespondAuth";
  public static final String j = "RespondHeader";
  public static final String k = "RequestCustomSig";
  public static final String l = "RespondCustomSig";
  public static final int m = 0;
  private static final String o = "MSF.C.AuthCoder";
  b n;
  
  public j(b paramb)
  {
    this.n = paramb;
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    paramArrayOfByte[paramInt] = ((byte)(int)(paramLong >> 24));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)(paramLong >> 16));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)(paramLong >> 8));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)paramLong);
  }
  
  public static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt1, paramInt2);
  }
  
  public static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, paramInt3);
  }
  
  /* Error */
  private static boolean a(ToServiceMsg paramToServiceMsg, k paramk, a parama)
  {
    // Byte code:
    //   0: new 73	com/tencent/qphone/base/util/Cryptor
    //   3: dup
    //   4: invokespecial 74	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   7: astore 5
    //   9: iconst_0
    //   10: istore 4
    //   12: aload_2
    //   13: ifnull +253 -> 266
    //   16: aload_2
    //   17: aload_1
    //   18: getfield 79	com/tencent/msf/service/protocol/security/k:h	[B
    //   21: invokevirtual 84	com/tencent/mobileqq/msf/core/auth/a:g	([B)V
    //   24: aload_2
    //   25: aload_1
    //   26: getfield 86	com/tencent/msf/service/protocol/security/k:g	[B
    //   29: invokevirtual 88	com/tencent/mobileqq/msf/core/auth/a:f	([B)V
    //   32: aload_2
    //   33: invokevirtual 91	com/tencent/mobileqq/msf/core/auth/a:j	()[B
    //   36: astore 6
    //   38: aload 5
    //   40: aload_1
    //   41: getfield 79	com/tencent/msf/service/protocol/security/k:h	[B
    //   44: aload 6
    //   46: invokevirtual 95	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   49: astore 6
    //   51: bipush 16
    //   53: newarray byte
    //   55: astore 7
    //   57: aload 6
    //   59: arraylength
    //   60: bipush 16
    //   62: isub
    //   63: newarray byte
    //   65: astore 8
    //   67: aload 7
    //   69: iconst_0
    //   70: aload 6
    //   72: bipush 16
    //   74: invokestatic 97	com/tencent/mobileqq/msf/core/auth/j:a	([BI[BI)V
    //   77: aload 8
    //   79: iconst_0
    //   80: aload 6
    //   82: bipush 16
    //   84: aload 6
    //   86: arraylength
    //   87: bipush 16
    //   89: isub
    //   90: invokestatic 99	com/tencent/mobileqq/msf/core/auth/j:a	([BI[BII)V
    //   93: aload_2
    //   94: aload 8
    //   96: invokevirtual 101	com/tencent/mobileqq/msf/core/auth/a:e	([B)V
    //   99: aload 5
    //   101: aload_1
    //   102: getfield 86	com/tencent/msf/service/protocol/security/k:g	[B
    //   105: aload 7
    //   107: invokevirtual 95	com/tencent/qphone/base/util/Cryptor:decrypt	([B[B)[B
    //   110: astore 7
    //   112: new 103	java/io/ByteArrayInputStream
    //   115: dup
    //   116: aload 7
    //   118: invokespecial 105	java/io/ByteArrayInputStream:<init>	([B)V
    //   121: astore 5
    //   123: new 107	java/io/DataInputStream
    //   126: dup
    //   127: aload 5
    //   129: invokespecial 110	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   132: astore 6
    //   134: aload 6
    //   136: invokevirtual 114	java/io/DataInputStream:readInt	()I
    //   139: iconst_4
    //   140: isub
    //   141: newarray byte
    //   143: astore 8
    //   145: aload 6
    //   147: aload 8
    //   149: invokevirtual 118	java/io/DataInputStream:read	([B)I
    //   152: pop
    //   153: aload_2
    //   154: aload 8
    //   156: invokevirtual 120	com/tencent/mobileqq/msf/core/auth/a:h	([B)V
    //   159: iconst_4
    //   160: newarray byte
    //   162: astore 8
    //   164: aload 6
    //   166: aload 8
    //   168: invokevirtual 118	java/io/DataInputStream:read	([B)I
    //   171: pop
    //   172: aload_1
    //   173: getfield 122	com/tencent/msf/service/protocol/security/k:f	I
    //   176: bipush 10
    //   178: if_icmpeq +31 -> 209
    //   181: aload 7
    //   183: arraylength
    //   184: istore_3
    //   185: aload_1
    //   186: getfield 124	com/tencent/msf/service/protocol/security/k:j	I
    //   189: ifeq +92 -> 281
    //   192: aload_1
    //   193: getfield 124	com/tencent/msf/service/protocol/security/k:j	I
    //   196: istore_3
    //   197: goto +3 -> 200
    //   200: aload 6
    //   202: iload_3
    //   203: newarray byte
    //   205: invokevirtual 118	java/io/DataInputStream:read	([B)I
    //   208: pop
    //   209: bipush 16
    //   211: newarray byte
    //   213: astore_1
    //   214: aload_1
    //   215: iconst_0
    //   216: aload 8
    //   218: aload 8
    //   220: arraylength
    //   221: invokestatic 97	com/tencent/mobileqq/msf/core/auth/j:a	([BI[BI)V
    //   224: aload_2
    //   225: aload_1
    //   226: invokevirtual 126	com/tencent/mobileqq/msf/core/auth/a:j	([B)V
    //   229: aload_2
    //   230: aload_0
    //   231: invokestatic 131	com/tencent/mobileqq/msf/service/u:b	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)Ljava/lang/String;
    //   234: invokevirtual 134	com/tencent/mobileqq/msf/core/auth/a:c	(Ljava/lang/String;)V
    //   237: aload 5
    //   239: invokevirtual 137	java/io/ByteArrayInputStream:close	()V
    //   242: aload 6
    //   244: invokevirtual 138	java/io/DataInputStream:close	()V
    //   247: goto +16 -> 263
    //   250: astore_0
    //   251: aload 5
    //   253: invokevirtual 137	java/io/ByteArrayInputStream:close	()V
    //   256: aload 6
    //   258: invokevirtual 138	java/io/DataInputStream:close	()V
    //   261: aload_0
    //   262: athrow
    //   263: iconst_1
    //   264: istore 4
    //   266: iload 4
    //   268: ireturn
    //   269: astore_0
    //   270: goto -33 -> 237
    //   273: astore_0
    //   274: goto -11 -> 263
    //   277: astore_1
    //   278: goto -17 -> 261
    //   281: bipush 24
    //   283: istore_3
    //   284: goto -84 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	287	0	paramToServiceMsg	ToServiceMsg
    //   0	287	1	paramk	k
    //   0	287	2	parama	a
    //   184	100	3	i1	int
    //   10	257	4	bool	boolean
    //   7	245	5	localObject1	Object
    //   36	221	6	localObject2	Object
    //   55	127	7	arrayOfByte1	byte[]
    //   65	154	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   134	197	250	finally
    //   200	209	250	finally
    //   209	237	250	finally
    //   134	197	269	java/io/IOException
    //   200	209	269	java/io/IOException
    //   209	237	269	java/io/IOException
    //   237	247	273	java/lang/Exception
    //   251	261	277	java/lang/Exception
  }
  
  private byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[24];
    int i2 = (short)paramArrayOfByte.length;
    int i1 = i2;
    if (i2 > 16) {
      i1 = 16;
    }
    long l1 = Long.valueOf(paramString).longValue();
    paramString = new byte[8];
    a(paramString, 4, l1);
    a(arrayOfByte, 0, paramArrayOfByte, i1);
    a(arrayOfByte, 16, paramString, paramString.length);
    return MD5.toMD5Byte(arrayOfByte);
  }
  
  /* Error */
  private byte[] a(byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, int paramInt)
  {
    // Byte code:
    //   0: new 160	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 161	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 7
    //   9: new 163	java/io/DataOutputStream
    //   12: dup
    //   13: aload 7
    //   15: invokespecial 166	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore 8
    //   20: aconst_null
    //   21: astore 6
    //   23: aload 6
    //   25: astore 5
    //   27: aload 8
    //   29: iconst_1
    //   30: invokevirtual 170	java/io/DataOutputStream:writeShort	(I)V
    //   33: aload 6
    //   35: astore 5
    //   37: aload 8
    //   39: new 172	java/util/Random
    //   42: dup
    //   43: invokespecial 173	java/util/Random:<init>	()V
    //   46: invokevirtual 176	java/util/Random:nextInt	()I
    //   49: iconst_1
    //   50: iushr
    //   51: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   54: aload 6
    //   56: astore 5
    //   58: aload 8
    //   60: iconst_1
    //   61: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   64: aload 6
    //   66: astore 5
    //   68: aload 8
    //   70: iload 4
    //   72: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   75: aload 6
    //   77: astore 5
    //   79: aload 8
    //   81: iconst_1
    //   82: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   85: aload 6
    //   87: astore 5
    //   89: aload 8
    //   91: aload_2
    //   92: invokestatic 183	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   95: invokevirtual 187	java/io/DataOutputStream:writeLong	(J)V
    //   98: aload 6
    //   100: astore 5
    //   102: aload 8
    //   104: invokestatic 190	java/lang/System:currentTimeMillis	()J
    //   107: ldc2_w 191
    //   110: ldiv
    //   111: l2i
    //   112: aload_0
    //   113: getfield 56	com/tencent/mobileqq/msf/core/auth/j:n	Lcom/tencent/mobileqq/msf/core/auth/b;
    //   116: invokevirtual 196	com/tencent/mobileqq/msf/core/auth/b:e	()I
    //   119: iadd
    //   120: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   123: aload 6
    //   125: astore 5
    //   127: aload 8
    //   129: iconst_0
    //   130: invokevirtual 179	java/io/DataOutputStream:writeInt	(I)V
    //   133: aload 6
    //   135: astore 5
    //   137: aload 8
    //   139: iconst_0
    //   140: invokevirtual 199	java/io/DataOutputStream:writeByte	(I)V
    //   143: aload 6
    //   145: astore 5
    //   147: aload 8
    //   149: aload_3
    //   150: invokevirtual 202	java/io/DataOutputStream:write	([B)V
    //   153: aload 6
    //   155: astore 5
    //   157: aload 8
    //   159: bipush 16
    //   161: newarray byte
    //   163: invokevirtual 202	java/io/DataOutputStream:write	([B)V
    //   166: aload 6
    //   168: astore 5
    //   170: aload 8
    //   172: iconst_0
    //   173: invokevirtual 170	java/io/DataOutputStream:writeShort	(I)V
    //   176: aload 6
    //   178: astore 5
    //   180: aload 8
    //   182: invokevirtual 205	java/io/DataOutputStream:flush	()V
    //   185: aload 6
    //   187: astore 5
    //   189: aload 7
    //   191: invokevirtual 208	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   194: astore_2
    //   195: aload_2
    //   196: astore 5
    //   198: new 73	com/tencent/qphone/base/util/Cryptor
    //   201: dup
    //   202: invokespecial 74	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   205: aload_2
    //   206: aload_1
    //   207: invokevirtual 211	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   210: astore_1
    //   211: aload 7
    //   213: invokevirtual 212	java/io/ByteArrayOutputStream:close	()V
    //   216: aload 8
    //   218: invokevirtual 213	java/io/DataOutputStream:close	()V
    //   221: aload_1
    //   222: areturn
    //   223: astore_1
    //   224: goto +55 -> 279
    //   227: astore_1
    //   228: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   231: ifeq +35 -> 266
    //   234: new 221	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 222	java/lang/StringBuilder:<init>	()V
    //   241: astore_2
    //   242: aload_2
    //   243: ldc 224
    //   245: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_2
    //   250: aload_1
    //   251: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: ldc 47
    //   257: iconst_2
    //   258: aload_2
    //   259: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: aload_1
    //   263: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   266: aload 7
    //   268: invokevirtual 212	java/io/ByteArrayOutputStream:close	()V
    //   271: aload 8
    //   273: invokevirtual 213	java/io/DataOutputStream:close	()V
    //   276: aload 5
    //   278: areturn
    //   279: aload 7
    //   281: invokevirtual 212	java/io/ByteArrayOutputStream:close	()V
    //   284: aload 8
    //   286: invokevirtual 213	java/io/DataOutputStream:close	()V
    //   289: aload_1
    //   290: athrow
    //   291: astore_2
    //   292: aload_1
    //   293: areturn
    //   294: astore_1
    //   295: goto -19 -> 276
    //   298: astore_2
    //   299: goto -10 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	302	0	this	j
    //   0	302	1	paramArrayOfByte1	byte[]
    //   0	302	2	paramString	String
    //   0	302	3	paramArrayOfByte2	byte[]
    //   0	302	4	paramInt	int
    //   25	252	5	localObject1	Object
    //   21	165	6	localObject2	Object
    //   7	273	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   18	267	8	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   27	33	223	finally
    //   37	54	223	finally
    //   58	64	223	finally
    //   68	75	223	finally
    //   79	85	223	finally
    //   89	98	223	finally
    //   102	123	223	finally
    //   127	133	223	finally
    //   137	143	223	finally
    //   147	153	223	finally
    //   157	166	223	finally
    //   170	176	223	finally
    //   180	185	223	finally
    //   189	195	223	finally
    //   198	211	223	finally
    //   228	266	223	finally
    //   27	33	227	java/lang/Exception
    //   37	54	227	java/lang/Exception
    //   58	64	227	java/lang/Exception
    //   68	75	227	java/lang/Exception
    //   79	85	227	java/lang/Exception
    //   89	98	227	java/lang/Exception
    //   102	123	227	java/lang/Exception
    //   127	133	227	java/lang/Exception
    //   137	143	227	java/lang/Exception
    //   147	153	227	java/lang/Exception
    //   157	166	227	java/lang/Exception
    //   170	176	227	java/lang/Exception
    //   180	185	227	java/lang/Exception
    //   189	195	227	java/lang/Exception
    //   198	211	227	java/lang/Exception
    //   211	221	291	java/lang/Exception
    //   266	276	294	java/lang/Exception
    //   279	289	298	java/lang/Exception
  }
  
  public void a(UniPacket paramUniPacket, a parama)
  {
    if (paramUniPacket != null)
    {
      if (parama == null) {
        return;
      }
      Object localObject = (RespondCustomSig)paramUniPacket.getByClass("RespondCustomSig", new RespondCustomSig());
      if (localObject != null)
      {
        int i1 = 0;
        while (i1 < ((RespondCustomSig)localObject).SigList.size())
        {
          CustomSigContent localCustomSigContent = (CustomSigContent)((RespondCustomSig)localObject).SigList.get(i1);
          if (localCustomSigContent.ulSigType == 1L) {
            parama.l(localCustomSigContent.SigContent);
          } else if (localCustomSigContent.ulSigType != 3L) {
            long l1 = localCustomSigContent.ulSigType;
          }
          i1 += 1;
        }
      }
      localObject = (q)paramUniPacket.getByClass("UserMainAccount", new q());
      if (localObject != null) {
        if (((q)localObject).a == 2L) {
          parama.m(((q)localObject).c);
        } else {
          parama.m(parama.d().getBytes());
        }
      }
      paramUniPacket = (r)paramUniPacket.getByClass("UserSimpleInfo", new r());
      if (paramUniPacket != null)
      {
        parama.a(paramUniPacket.a);
        parama.b(paramUniPacket.b);
        parama.c(paramUniPacket.c);
        parama.n(paramUniPacket.d);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, UniPacket paramUniPacket, k paramk)
  {
    af.a(paramFromServiceMsg);
    VerifyCodeInfo localVerifyCodeInfo = new VerifyCodeInfo();
    localVerifyCodeInfo.ssoSeq = paramFromServiceMsg.getRequestSsoSeq();
    localVerifyCodeInfo.wupSeq = paramUniPacket.getRequestId();
    if (paramk.b == 0)
    {
      paramUniPacket = (i)paramUniPacket.getByClass("RespondAuth", new i());
      localVerifyCodeInfo.vpicSid = paramUniPacket.c;
      localVerifyCodeInfo.svrSeqNo = paramk.e;
      localVerifyCodeInfo.verifyimage = paramUniPacket.a;
      localVerifyCodeInfo.verifyNote = paramUniPacket.b;
    }
    else if (paramk.b == 12)
    {
      paramUniPacket = (i)paramUniPacket.getByClass("RespondAuth", new i());
      localVerifyCodeInfo.vpicSid = paramUniPacket.c;
      localVerifyCodeInfo.svrSeqNo = paramk.e;
      localVerifyCodeInfo.verifyimage = paramUniPacket.a;
      localVerifyCodeInfo.verifyNote = paramUniPacket.b;
    }
    else if (paramk.b == 1)
    {
      paramUniPacket = (n)paramUniPacket.getByClass("RespondVerifyPic", new n());
      localVerifyCodeInfo.vpicSid = paramUniPacket.b;
      localVerifyCodeInfo.svrSeqNo = paramk.e;
      localVerifyCodeInfo.verifyimage = paramUniPacket.a;
      localVerifyCodeInfo.verifyNote = "";
    }
    else if (paramk.b == 2)
    {
      paramUniPacket = (m)paramUniPacket.getByClass("RespondRefreshVPic", new m());
      localVerifyCodeInfo.vpicSid = paramUniPacket.c;
      localVerifyCodeInfo.svrSeqNo = paramk.e;
      localVerifyCodeInfo.verifyimage = paramUniPacket.a;
      localVerifyCodeInfo.verifyNote = paramUniPacket.b;
    }
    else if (paramk.b == 13)
    {
      paramUniPacket = (p)paramUniPacket.getByClass("ResponseNameExchangeUin", new p());
      localVerifyCodeInfo.vpicSid = paramUniPacket.c;
      localVerifyCodeInfo.svrSeqNo = paramk.e;
      localVerifyCodeInfo.verifyimage = paramUniPacket.a;
      localVerifyCodeInfo.verifyNote = paramUniPacket.b;
    }
    else if (paramk.b == 14)
    {
      paramUniPacket = (o)paramUniPacket.getByClass("ResponseAuthWlogin", new o());
      byte[] arrayOfByte = paramUniPacket.d;
      if (arrayOfByte != null) {
        int i1 = arrayOfByte.length;
      }
      localVerifyCodeInfo.vpicSid = paramUniPacket.c;
      localVerifyCodeInfo.svrSeqNo = paramk.e;
      localVerifyCodeInfo.verifyimage = paramUniPacket.a;
      localVerifyCodeInfo.verifyNote = paramUniPacket.b;
    }
    VerifyCodeInfo.putVerifyCodeInfo(paramFromServiceMsg, localVerifyCodeInfo);
    if (QLog.isColorLevel())
    {
      paramUniPacket = new StringBuilder();
      paramUniPacket.append("rece loginVerifyCode seq:");
      paramUniPacket.append(paramFromServiceMsg.getRequestSsoSeq());
      paramUniPacket.append(" uin:");
      paramUniPacket.append(paramFromServiceMsg.getUin());
      paramUniPacket.append(" cmd:");
      paramUniPacket.append(paramFromServiceMsg.getServiceCmd());
      paramUniPacket.append(" svrseqNo:");
      paramUniPacket.append(localVerifyCodeInfo.svrSeqNo);
      paramUniPacket.append(" vipsid:");
      paramUniPacket.append(localVerifyCodeInfo.vpicSid);
      paramUniPacket.append(" wupSeq:");
      paramUniPacket.append(localVerifyCodeInfo.wupSeq);
      QLog.d("MSF.C.AuthCoder", 2, paramUniPacket.toString());
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("add ");
      paramFromServiceMsg.append(paramToServiceMsg);
      paramFromServiceMsg.append(" to mutilActionQueue.");
      QLog.d("MSF.C.AuthCoder", 2, paramFromServiceMsg.toString());
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, k paramk)
  {
    if (paramk == null) {
      return;
    }
    a locala = (a)this.n.b.remove(paramk.d);
    if (locala == null)
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("can not find account ");
        paramToServiceMsg.append(paramFromServiceMsg.getUin());
        paramToServiceMsg.append(" info.");
        QLog.d("MSF.C.AuthCoder", 2, paramToServiceMsg.toString());
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(MD5.toMD5(paramFromServiceMsg.getUin()));
    ((StringBuilder)localObject).append(" login succ.");
    QLog.d("MSF.C.AuthCoder", 1, ((StringBuilder)localObject).toString());
    locala.c(u.b(paramToServiceMsg));
    this.n.a(locala);
    if (a(paramToServiceMsg, paramk, locala))
    {
      long l1 = System.currentTimeMillis();
      locala.a(true);
      locala.a(l1);
      paramk = new StringBuilder();
      paramk.append(Thread.currentThread().getName());
      paramk.append(" decodeLoginSuccResp setKey ");
      paramk.append(MsfSdkUtils.getShortUin(locala.d()));
      QLog.d("MSF.C.AuthCoder", 1, paramk.toString());
      paramk = locala.d();
      localObject = locala.f();
      byte[] arrayOfByte1 = locala.g();
      byte[] arrayOfByte2 = locala.h();
      byte[] arrayOfByte3 = locala.i();
      byte[] arrayOfByte4 = locala.j();
      byte[] arrayOfByte5 = locala.k();
      CodecWarpper.nativeSetAccountKey(paramk, new byte[0], (byte[])localObject, arrayOfByte1, arrayOfByte2, arrayOfByte3, arrayOfByte4, arrayOfByte5, new byte[0], null);
      this.n.m(locala.d());
      ac.a(locala.d(), false);
      try
      {
        this.n.a.getWtLoginCenter().a(locala, true);
      }
      catch (Throwable paramk)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(MD5.toMD5(paramFromServiceMsg.getUin()));
        ((StringBuilder)localObject).append(" set key to wt error ");
        ((StringBuilder)localObject).append(paramk);
        QLog.d("MSF.C.AuthCoder", 1, ((StringBuilder)localObject).toString(), paramk);
      }
    }
    else
    {
      paramk = new StringBuilder();
      paramk.append(MD5.toMD5(paramFromServiceMsg.getUin()));
      paramk.append("decode login failed.");
      QLog.d("MSF.C.AuthCoder", 1, paramk.toString());
    }
    this.n.a.sender.a(paramFromServiceMsg.getAppId(), paramFromServiceMsg.getUin());
    paramFromServiceMsg.addAttribute("resp_simpleAccount", locala.o().toStoreString());
    this.n.a.addRespToQuque(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public byte[] a(int paramInt1, String paramString, int paramInt2, HashMap paramHashMap)
  {
    this.n.b(paramString);
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    localUniPacket.put("RequestHeader", new d(1, paramInt2, MsfCore.getNextSeq(), 1, paramString, paramInt1, String.valueOf(paramInt1), "123", 0));
    if (paramHashMap != null)
    {
      paramString = paramHashMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramHashMap = (Map.Entry)paramString.next();
        localUniPacket.put((String)paramHashMap.getKey(), paramHashMap.getValue());
      }
    }
    return localUniPacket.encode();
  }
  
  public byte[] a(int paramInt, String paramString, VerifyCodeInfo paramVerifyCodeInfo)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    String str = this.n.i(paramString);
    int i1 = paramVerifyCodeInfo.wupSeq;
    int i2 = paramVerifyCodeInfo.svrSeqNo;
    if (str != null) {
      paramString = str;
    }
    localUniPacket.put("RequestHeader", new d(1, 2, i1, i2, paramString, paramInt, String.valueOf(paramInt), "123", 0));
    localUniPacket.put("RequestRefreshVPic", new g(1, 1));
    localUniPacket.setRequestId(paramVerifyCodeInfo.wupSeq);
    return localUniPacket.encode();
  }
  
  public byte[] a(int paramInt, String paramString1, String paramString2, VerifyCodeInfo paramVerifyCodeInfo)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    String str = this.n.i(paramString1);
    int i1 = paramVerifyCodeInfo.wupSeq;
    int i2 = paramVerifyCodeInfo.svrSeqNo;
    if (str != null) {
      paramString1 = str;
    }
    localUniPacket.put("RequestHeader", new d(1, 1, i1, i2, paramString1, paramInt, String.valueOf(paramInt), "123", 0));
    localUniPacket.put("RequestVerifyPic", new h(paramVerifyCodeInfo.vpicSid, paramString2));
    localUniPacket.setRequestId(paramVerifyCodeInfo.wupSeq);
    return localUniPacket.encode();
  }
  
  public byte[] a(int paramInt1, String paramString, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    UniPacket localUniPacket = new UniPacket(true);
    localUniPacket.setServantName("test");
    localUniPacket.setFuncName("cmdstr");
    this.n.b(paramString);
    a locala = (a)this.n.b.get(paramString);
    localUniPacket.put("RequestHeader", new d(1, 14, MsfCore.getNextSeq(), locala.w(), paramString, paramInt1, String.valueOf(paramInt1), "123", 0));
    byte[] arrayOfByte2 = a(paramString, paramArrayOfByte1);
    byte[] arrayOfByte1 = a(arrayOfByte2, paramString, paramArrayOfByte1, paramInt2);
    locala.i(arrayOfByte2);
    paramArrayOfByte1 = this.n.f();
    paramString = paramArrayOfByte1;
    if (paramArrayOfByte1 == null) {
      paramString = new byte[0];
    }
    localUniPacket.put("RequestAuthWlogin", new com.tencent.msf.service.protocol.security.b(arrayOfByte1, 1, 0, paramString, paramInt3, paramArrayOfByte2));
    paramString = new c();
    paramString.a = ((int)(System.currentTimeMillis() / 1000L) + this.n.e());
    localUniPacket.put("RequestGetServerTime", paramString);
    return localUniPacket.encode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.auth.j
 * JD-Core Version:    0.7.0.1
 */