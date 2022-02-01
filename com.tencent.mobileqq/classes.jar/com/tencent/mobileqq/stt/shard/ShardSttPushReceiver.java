package com.tencent.mobileqq.stt.shard;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ShardSttPushReceiver
  extends BaseSttPushReceiver
{
  private volatile int b = 0;
  private volatile int c = -1;
  private volatile boolean d = false;
  private ConcurrentHashMap<Integer, BaseSttPushReceiver.SttPushPacket> e = new ConcurrentHashMap();
  private volatile long f = 0L;
  
  public ShardSttPushReceiver(AIOSttResult paramAIOSttResult)
  {
    super(paramAIOSttResult);
  }
  
  private void a(int paramInt)
  {
    if (this.f != 0L)
    {
      if (paramInt == 0) {
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.f;
      this.f = 0L;
      l1 = (l1 - l2) / paramInt;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PttSttReport reportPackageTimeInterval timeInterval = ");
        ((StringBuilder)localObject).append(l1);
        QLog.d("Q.stt_ShardSttRcv", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1);
      localStringBuilder.append("");
      ((HashMap)localObject).put("timeInterval", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(l1);
      localStringBuilder.append("");
      ((HashMap)localObject).put("ntimeInterval", localStringBuilder.toString());
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttShardSttReveivePartTimeInterval", true, 0L, 0L, (HashMap)localObject, null);
    }
  }
  
  private BaseSttPushReceiver.SttPushPacket b(int paramInt)
  {
    if (this.e.containsKey(Integer.valueOf(paramInt))) {
      return (BaseSttPushReceiver.SttPushPacket)this.e.get(Integer.valueOf(paramInt));
    }
    BaseSttPushReceiver.SttPushPacket localSttPushPacket = new BaseSttPushReceiver.SttPushPacket();
    this.e.put(Integer.valueOf(paramInt), localSttPushPacket);
    return localSttPushPacket;
  }
  
  private void b()
  {
    try
    {
      this.b = 0;
      this.c = -1;
      this.d = false;
      this.e.clear();
      this.f = 0L;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void c()
  {
    b();
  }
  
  private String d()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tryGetContinuouslyString start Start = ");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(" | Current = ");
      ((StringBuilder)localObject1).append(this.c);
      QLog.d("Q.stt_ShardSttRcv", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.c < this.b) {
      return null;
    }
    int i = this.b;
    Object localObject1 = "";
    while (i <= this.c)
    {
      Object localObject2;
      if (this.e.containsKey(Integer.valueOf(i))) {
        localObject2 = (BaseSttPushReceiver.SttPushPacket)this.e.get(Integer.valueOf(i));
      } else {
        localObject2 = null;
      }
      StringBuilder localStringBuilder;
      if ((localObject2 != null) && (((BaseSttPushReceiver.SttPushPacket)localObject2).d))
      {
        localObject2 = new String(((BaseSttPushReceiver.SttPushPacket)localObject2).c.array());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append((String)localObject2);
        localObject1 = localStringBuilder.toString();
        i += 1;
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("tryGetContinuouslyString return null index = ");
          localStringBuilder.append(i);
          localStringBuilder.append(" | tempPacket is ");
          if (localObject2 == null) {
            localObject1 = "null";
          } else {
            localObject1 = "not end";
          }
          localStringBuilder.append((String)localObject1);
          QLog.d("Q.stt_ShardSttRcv", 2, localStringBuilder.toString());
        }
        return null;
      }
    }
    return localObject1;
  }
  
  /* Error */
  public int a(tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody paramMsgBody)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: astore 7
    //   6: aload 7
    //   8: monitorenter
    //   9: aload_1
    //   10: ifnonnull +10 -> 20
    //   13: aload 7
    //   15: monitorexit
    //   16: sipush 4001
    //   19: ireturn
    //   20: aload_1
    //   21: getfield 161	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$MsgBody:msg_ptt_shard_resp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp;
    //   24: astore 8
    //   26: aload 8
    //   28: invokevirtual 166	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:has	()Z
    //   31: ifne +25 -> 56
    //   34: aload_0
    //   35: invokespecial 168	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:c	()V
    //   38: aload_0
    //   39: getfield 171	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:a	Lcom/tencent/mobileqq/stt/shard/AIOSttResult;
    //   42: iconst_4
    //   43: sipush 2007
    //   46: invokevirtual 176	com/tencent/mobileqq/stt/shard/AIOSttResult:a	(II)V
    //   49: aload 7
    //   51: monitorexit
    //   52: sipush 4001
    //   55: ireturn
    //   56: aload 8
    //   58: getfield 180	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:uint64_sessionid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   61: invokevirtual 184	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   64: invokestatic 189	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   67: astore 9
    //   69: aload 8
    //   71: getfield 193	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:uint32_error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   74: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   77: istore_2
    //   78: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +48 -> 129
    //   84: new 50	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   91: astore_1
    //   92: aload_1
    //   93: ldc 200
    //   95: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_1
    //   100: iload_2
    //   101: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_1
    //   106: ldc 202
    //   108: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_1
    //   113: aload 9
    //   115: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: ldc 62
    //   121: iconst_2
    //   122: aload_1
    //   123: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload_2
    //   130: ifeq +23 -> 153
    //   133: aload_0
    //   134: invokespecial 168	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:c	()V
    //   137: aload_0
    //   138: getfield 171	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:a	Lcom/tencent/mobileqq/stt/shard/AIOSttResult;
    //   141: iconst_4
    //   142: iload_2
    //   143: invokevirtual 176	com/tencent/mobileqq/stt/shard/AIOSttResult:a	(II)V
    //   146: aload 7
    //   148: monitorexit
    //   149: sipush 4002
    //   152: ireturn
    //   153: aload_0
    //   154: getfield 33	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   157: invokevirtual 208	java/util/concurrent/ConcurrentHashMap:size	()I
    //   160: ifne +19 -> 179
    //   163: aload_0
    //   164: getfield 26	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:f	J
    //   167: lconst_0
    //   168: lcmp
    //   169: ifne +10 -> 179
    //   172: aload_0
    //   173: invokestatic 42	java/lang/System:currentTimeMillis	()J
    //   176: putfield 26	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:f	J
    //   179: aload 8
    //   181: getfield 211	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:uint32_total_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   184: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   187: istore_3
    //   188: iload_3
    //   189: aload_0
    //   190: getfield 20	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:b	I
    //   193: if_icmpge +8 -> 201
    //   196: aload 7
    //   198: monitorexit
    //   199: iconst_0
    //   200: ireturn
    //   201: aload_0
    //   202: getfield 22	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:c	I
    //   205: iload_3
    //   206: if_icmpge +8 -> 214
    //   209: aload_0
    //   210: iload_3
    //   211: putfield 22	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:c	I
    //   214: aload_0
    //   215: iload_3
    //   216: invokespecial 213	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:b	(I)Lcom/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket;
    //   219: astore 10
    //   221: aload 8
    //   223: getfield 217	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:all_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   226: invokevirtual 220	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:has	()Z
    //   229: ifeq +15 -> 244
    //   232: aload 8
    //   234: getfield 217	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:all_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   237: astore_1
    //   238: iconst_1
    //   239: istore 6
    //   241: goto +83 -> 324
    //   244: aload 8
    //   246: getfield 223	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:cur_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   249: invokevirtual 220	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:has	()Z
    //   252: ifne +63 -> 315
    //   255: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +35 -> 293
    //   261: new 50	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   268: astore_1
    //   269: aload_1
    //   270: ldc 225
    //   272: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_1
    //   277: aload 9
    //   279: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: ldc 62
    //   285: iconst_2
    //   286: aload_1
    //   287: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload_0
    //   294: invokespecial 168	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:c	()V
    //   297: aload_0
    //   298: getfield 171	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:a	Lcom/tencent/mobileqq/stt/shard/AIOSttResult;
    //   301: iconst_4
    //   302: sipush 2007
    //   305: invokevirtual 176	com/tencent/mobileqq/stt/shard/AIOSttResult:a	(II)V
    //   308: aload 7
    //   310: monitorexit
    //   311: sipush 4001
    //   314: ireturn
    //   315: aload 8
    //   317: getfield 223	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:cur_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   320: astore_1
    //   321: iconst_0
    //   322: istore 6
    //   324: aload_1
    //   325: getfield 228	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_pos	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   328: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   331: istore_2
    //   332: aload_1
    //   333: getfield 231	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: istore 4
    //   341: aload_1
    //   342: getfield 234	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_total_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   345: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   348: istore 5
    //   350: aload_0
    //   351: aload 10
    //   353: iload_2
    //   354: iload 4
    //   356: iload 5
    //   358: iconst_1
    //   359: aload_1
    //   360: getfield 237	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   363: invokevirtual 198	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   366: ishl
    //   367: aload_1
    //   368: getfield 241	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:bytes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   371: invokevirtual 246	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   374: invokevirtual 251	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   377: invokevirtual 254	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:a	(Lcom/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket;IIII[B)Lcom/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket;
    //   380: pop
    //   381: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq +404 -> 788
    //   387: new 50	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   394: astore_1
    //   395: aload_1
    //   396: ldc_w 256
    //   399: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_1
    //   404: aload 9
    //   406: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_1
    //   411: ldc 202
    //   413: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_1
    //   418: iload_2
    //   419: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload_1
    //   424: ldc 202
    //   426: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload_1
    //   431: iload 4
    //   433: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload_1
    //   438: ldc 202
    //   440: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_1
    //   445: iload 5
    //   447: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: ldc 62
    //   453: iconst_2
    //   454: aload_1
    //   455: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: new 50	java/lang/StringBuilder
    //   464: dup
    //   465: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   468: astore_1
    //   469: aload_1
    //   470: ldc_w 258
    //   473: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload_1
    //   478: iload_3
    //   479: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload_1
    //   484: ldc_w 260
    //   487: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: pop
    //   491: aload_1
    //   492: iload 6
    //   494: invokevirtual 263	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: aload_1
    //   499: ldc_w 265
    //   502: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_1
    //   507: aload 10
    //   509: getfield 132	com/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket:d	Z
    //   512: invokevirtual 263	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: ldc 62
    //   518: iconst_2
    //   519: aload_1
    //   520: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   526: goto +3 -> 529
    //   529: aload 10
    //   531: getfield 132	com/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket:d	Z
    //   534: ifeq +268 -> 802
    //   537: iload 6
    //   539: ifeq +37 -> 576
    //   542: aload_0
    //   543: getfield 20	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:b	I
    //   546: istore_2
    //   547: aload_0
    //   548: iload_3
    //   549: putfield 20	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:b	I
    //   552: iload_2
    //   553: iload_3
    //   554: if_icmpge +22 -> 576
    //   557: aload_0
    //   558: getfield 33	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:e	Ljava/util/concurrent/ConcurrentHashMap;
    //   561: iload_2
    //   562: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: invokevirtual 268	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   568: pop
    //   569: iload_2
    //   570: iconst_1
    //   571: iadd
    //   572: istore_2
    //   573: goto -21 -> 552
    //   576: aload_0
    //   577: invokespecial 270	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:d	()Ljava/lang/String;
    //   580: astore_1
    //   581: aload_1
    //   582: ifnull +163 -> 745
    //   585: aload 8
    //   587: getfield 274	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:bool_is_total_end	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   590: invokevirtual 278	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   593: istore 6
    //   595: aload_0
    //   596: getfield 171	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:a	Lcom/tencent/mobileqq/stt/shard/AIOSttResult;
    //   599: aload_1
    //   600: iload 6
    //   602: invokevirtual 281	com/tencent/mobileqq/stt/shard/AIOSttResult:a	(Ljava/lang/String;Z)V
    //   605: iload 6
    //   607: ifne +184 -> 791
    //   610: sipush -10001
    //   613: istore_2
    //   614: goto +3 -> 617
    //   617: aload_0
    //   618: getfield 24	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:d	Z
    //   621: ifne +175 -> 796
    //   624: aload_0
    //   625: iconst_1
    //   626: putfield 24	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:d	Z
    //   629: sipush -10002
    //   632: istore_2
    //   633: goto +3 -> 636
    //   636: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   639: ifeq +90 -> 729
    //   642: new 134	java/lang/String
    //   645: dup
    //   646: aload 10
    //   648: getfield 137	com/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket:c	Ljava/nio/ByteBuffer;
    //   651: invokevirtual 143	java/nio/ByteBuffer:array	()[B
    //   654: invokespecial 146	java/lang/String:<init>	([B)V
    //   657: astore 8
    //   659: new 50	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   666: astore 9
    //   668: aload 9
    //   670: ldc_w 283
    //   673: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 9
    //   679: aload 8
    //   681: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 9
    //   687: ldc_w 285
    //   690: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload 9
    //   696: iload 6
    //   698: invokevirtual 263	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload 9
    //   704: ldc_w 287
    //   707: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload 9
    //   713: aload_1
    //   714: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: ldc 62
    //   720: iconst_2
    //   721: aload 9
    //   723: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   729: iload 6
    //   731: ifeq +68 -> 799
    //   734: aload_0
    //   735: aload_0
    //   736: getfield 22	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:c	I
    //   739: invokespecial 289	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:a	(I)V
    //   742: goto +57 -> 799
    //   745: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq +54 -> 802
    //   751: ldc 62
    //   753: iconst_2
    //   754: ldc_w 291
    //   757: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: goto +42 -> 802
    //   763: aload_0
    //   764: getfield 171	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:a	Lcom/tencent/mobileqq/stt/shard/AIOSttResult;
    //   767: iconst_1
    //   768: invokevirtual 294	com/tencent/mobileqq/stt/shard/AIOSttResult:a	(Z)V
    //   771: aload 7
    //   773: monitorexit
    //   774: iload_2
    //   775: ireturn
    //   776: astore_1
    //   777: aload 7
    //   779: monitorexit
    //   780: goto +5 -> 785
    //   783: aload_1
    //   784: athrow
    //   785: goto -2 -> 783
    //   788: goto -259 -> 529
    //   791: iconst_0
    //   792: istore_2
    //   793: goto -176 -> 617
    //   796: goto -160 -> 636
    //   799: goto -36 -> 763
    //   802: iconst_0
    //   803: istore_2
    //   804: goto -41 -> 763
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	807	0	this	ShardSttPushReceiver
    //   0	807	1	paramMsgBody	tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody
    //   77	727	2	i	int
    //   187	368	3	j	int
    //   339	93	4	k	int
    //   348	98	5	m	int
    //   239	491	6	bool	boolean
    //   4	774	7	localConcurrentHashMap	ConcurrentHashMap
    //   67	655	9	localObject2	Object
    //   219	428	10	localSttPushPacket	BaseSttPushReceiver.SttPushPacket
    // Exception table:
    //   from	to	target	type
    //   13	16	776	finally
    //   20	52	776	finally
    //   56	129	776	finally
    //   133	149	776	finally
    //   153	179	776	finally
    //   179	199	776	finally
    //   201	214	776	finally
    //   214	238	776	finally
    //   244	293	776	finally
    //   293	311	776	finally
    //   315	321	776	finally
    //   324	526	776	finally
    //   529	537	776	finally
    //   542	552	776	finally
    //   557	569	776	finally
    //   576	581	776	finally
    //   585	605	776	finally
    //   617	629	776	finally
    //   636	729	776	finally
    //   734	742	776	finally
    //   745	760	776	finally
    //   763	774	776	finally
    //   777	780	776	finally
  }
  
  public void a()
  {
    synchronized (this.e)
    {
      b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.stt.shard.ShardSttPushReceiver
 * JD-Core Version:    0.7.0.1
 */