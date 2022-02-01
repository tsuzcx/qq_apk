package com.tencent.mobileqq.qqgamepub.adapter;

import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import java.util.HashSet;

public abstract class FlowControlListenerAdapter
  implements WadlTrpcListener
{
  public void a(long paramLong) {}
  
  public abstract void a(String paramString1, String paramString2, int paramInt, long paramLong);
  
  public HashSet<String> getFilterCmds()
  {
    return new FlowControlListenerAdapter.1(this);
  }
  
  /* Error */
  public void onTrpcRsp(android.content.Intent paramIntent, String paramString, long paramLong, com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 29
    //   3: invokevirtual 35	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 14
    //   8: aload_1
    //   9: ldc 37
    //   11: invokevirtual 35	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 15
    //   16: lconst_0
    //   17: lstore 10
    //   19: lload_3
    //   20: lconst_0
    //   21: lcmp
    //   22: ifne +185 -> 207
    //   25: aload 5
    //   27: ifnull +180 -> 207
    //   30: aload 5
    //   32: getfield 43	com/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp:data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   35: invokevirtual 49	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   38: ifnull +169 -> 207
    //   41: new 51	com/tencent/mobileqq/qqgamepub/data/QQGameResFlowControl$ResourcePermitRsp
    //   44: dup
    //   45: invokespecial 52	com/tencent/mobileqq/qqgamepub/data/QQGameResFlowControl$ResourcePermitRsp:<init>	()V
    //   48: astore 16
    //   50: aload 16
    //   52: aload 5
    //   54: getfield 43	com/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp:data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   57: invokevirtual 49	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   60: invokevirtual 58	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   63: invokevirtual 62	com/tencent/mobileqq/qqgamepub/data/QQGameResFlowControl$ResourcePermitRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   66: pop
    //   67: aload 16
    //   69: getfield 66	com/tencent/mobileqq/qqgamepub/data/QQGameResFlowControl$ResourcePermitRsp:resState	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   72: invokevirtual 71	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   75: istore 6
    //   77: aload 16
    //   79: getfield 75	com/tencent/mobileqq/qqgamepub/data/QQGameResFlowControl$ResourcePermitRsp:internalTime	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   82: invokevirtual 80	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   85: lstore 8
    //   87: ldc 82
    //   89: invokestatic 88	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   92: checkcast 82	com/tencent/mobileqq/qqgamepub/api/IQQGameFlowControlService
    //   95: astore 5
    //   97: iload 6
    //   99: i2l
    //   100: lstore 10
    //   102: invokestatic 93	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   105: lstore 12
    //   107: iload 6
    //   109: istore 7
    //   111: aload 5
    //   113: aload 14
    //   115: lload 10
    //   117: lload 8
    //   119: lload 12
    //   121: ladd
    //   122: invokeinterface 97 6 0
    //   127: aload_0
    //   128: aload 14
    //   130: aload 15
    //   132: iload 7
    //   134: lload 8
    //   136: invokevirtual 99	com/tencent/mobileqq/qqgamepub/adapter/FlowControlListenerAdapter:a	(Ljava/lang/String;Ljava/lang/String;IJ)V
    //   139: iload 7
    //   141: istore 6
    //   143: goto +76 -> 219
    //   146: astore 5
    //   148: goto +10 -> 158
    //   151: astore 5
    //   153: goto +5 -> 158
    //   156: astore 5
    //   158: goto +21 -> 179
    //   161: astore 5
    //   163: lload 10
    //   165: lstore 8
    //   167: goto +12 -> 179
    //   170: astore 5
    //   172: iconst_0
    //   173: istore 6
    //   175: lload 10
    //   177: lstore 8
    //   179: aload_0
    //   180: ldc2_w 100
    //   183: invokevirtual 103	com/tencent/mobileqq/qqgamepub/adapter/FlowControlListenerAdapter:a	(J)V
    //   186: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   189: ifeq +15 -> 204
    //   192: ldc 111
    //   194: iconst_2
    //   195: aload 5
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   204: goto +15 -> 219
    //   207: iconst_0
    //   208: istore 6
    //   210: aload_0
    //   211: lload_3
    //   212: invokevirtual 103	com/tencent/mobileqq/qqgamepub/adapter/FlowControlListenerAdapter:a	(J)V
    //   215: lload 10
    //   217: lstore 8
    //   219: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   222: ifeq +116 -> 338
    //   225: new 117	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   232: astore 5
    //   234: aload 5
    //   236: ldc 120
    //   238: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 5
    //   244: aload_1
    //   245: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload 5
    //   251: ldc 129
    //   253: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 5
    //   259: aload_2
    //   260: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload 5
    //   266: ldc 131
    //   268: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload 5
    //   274: lload_3
    //   275: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 5
    //   281: ldc 136
    //   283: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 5
    //   289: iload 6
    //   291: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 5
    //   297: ldc 141
    //   299: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: aload 5
    //   305: lload 8
    //   307: invokevirtual 134	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload 5
    //   313: ldc 143
    //   315: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 5
    //   321: aload 14
    //   323: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: ldc 111
    //   329: iconst_2
    //   330: aload 5
    //   332: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 151	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	FlowControlListenerAdapter
    //   0	339	1	paramIntent	android.content.Intent
    //   0	339	2	paramString	String
    //   0	339	3	paramLong	long
    //   0	339	5	paramTrpcInovkeRsp	com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp
    //   75	215	6	i	int
    //   109	31	7	j	int
    //   85	221	8	l1	long
    //   17	199	10	l2	long
    //   105	15	12	l3	long
    //   6	316	14	str1	String
    //   14	117	15	str2	String
    //   48	30	16	localResourcePermitRsp	com.tencent.mobileqq.qqgamepub.data.QQGameResFlowControl.ResourcePermitRsp
    // Exception table:
    //   from	to	target	type
    //   127	139	146	java/lang/Exception
    //   111	127	151	java/lang/Exception
    //   87	97	156	java/lang/Exception
    //   102	107	156	java/lang/Exception
    //   77	87	161	java/lang/Exception
    //   41	77	170	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.adapter.FlowControlListenerAdapter
 * JD-Core Version:    0.7.0.1
 */