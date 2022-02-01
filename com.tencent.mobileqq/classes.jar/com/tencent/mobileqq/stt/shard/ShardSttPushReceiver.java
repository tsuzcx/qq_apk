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
  private volatile int jdField_a_of_type_Int = 0;
  private volatile long jdField_a_of_type_Long = 0L;
  private ConcurrentHashMap<Integer, BaseSttPushReceiver.SttPushPacket> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile int b = -1;
  
  public ShardSttPushReceiver(AIOSttResult paramAIOSttResult)
  {
    super(paramAIOSttResult);
  }
  
  private BaseSttPushReceiver.SttPushPacket a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      return (BaseSttPushReceiver.SttPushPacket)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    }
    BaseSttPushReceiver.SttPushPacket localSttPushPacket = new BaseSttPushReceiver.SttPushPacket();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localSttPushPacket);
    return localSttPushPacket;
  }
  
  private String a()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("tryGetContinuouslyString start Start = ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(" | Current = ");
      ((StringBuilder)localObject1).append(this.b);
      QLog.d("Q.stt_ShardSttRcv", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.b < this.jdField_a_of_type_Int) {
      return null;
    }
    int i = this.jdField_a_of_type_Int;
    Object localObject1 = "";
    while (i <= this.b)
    {
      Object localObject2;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))) {
        localObject2 = (BaseSttPushReceiver.SttPushPacket)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
      } else {
        localObject2 = null;
      }
      StringBuilder localStringBuilder;
      if ((localObject2 != null) && (((BaseSttPushReceiver.SttPushPacket)localObject2).jdField_a_of_type_Boolean))
      {
        localObject2 = new String(((BaseSttPushReceiver.SttPushPacket)localObject2).jdField_a_of_type_JavaNioByteBuffer.array());
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
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      if (paramInt == 0) {
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = 0L;
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
  
  private void b()
  {
    try
    {
      this.jdField_a_of_type_Int = 0;
      this.b = -1;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_Long = 0L;
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
  
  /* Error */
  public int a(tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody paramMsgBody)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
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
    //   21: getfield 159	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$MsgBody:msg_ptt_shard_resp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp;
    //   24: astore 8
    //   26: aload 8
    //   28: invokevirtual 164	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:has	()Z
    //   31: ifne +25 -> 56
    //   34: aload_0
    //   35: invokespecial 166	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:c	()V
    //   38: aload_0
    //   39: getfield 169	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_ComTencentMobileqqSttShardAIOSttResult	Lcom/tencent/mobileqq/stt/shard/AIOSttResult;
    //   42: iconst_4
    //   43: sipush 2007
    //   46: invokevirtual 174	com/tencent/mobileqq/stt/shard/AIOSttResult:a	(II)V
    //   49: aload 7
    //   51: monitorexit
    //   52: sipush 4001
    //   55: ireturn
    //   56: aload 8
    //   58: getfield 178	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:uint64_sessionid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   61: invokevirtual 182	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   64: invokestatic 187	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   67: astore 9
    //   69: aload 8
    //   71: getfield 191	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:uint32_error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   74: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   77: istore_2
    //   78: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +48 -> 129
    //   84: new 62	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   91: astore_1
    //   92: aload_1
    //   93: ldc 198
    //   95: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_1
    //   100: iload_2
    //   101: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: aload_1
    //   106: ldc 200
    //   108: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_1
    //   113: aload 9
    //   115: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: ldc 76
    //   121: iconst_2
    //   122: aload_1
    //   123: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: iload_2
    //   130: ifeq +23 -> 153
    //   133: aload_0
    //   134: invokespecial 166	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:c	()V
    //   137: aload_0
    //   138: getfield 169	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_ComTencentMobileqqSttShardAIOSttResult	Lcom/tencent/mobileqq/stt/shard/AIOSttResult;
    //   141: iconst_4
    //   142: iload_2
    //   143: invokevirtual 174	com/tencent/mobileqq/stt/shard/AIOSttResult:a	(II)V
    //   146: aload 7
    //   148: monitorexit
    //   149: sipush 4002
    //   152: ireturn
    //   153: aload_0
    //   154: getfield 30	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   157: invokevirtual 206	java/util/concurrent/ConcurrentHashMap:size	()I
    //   160: ifne +19 -> 179
    //   163: aload_0
    //   164: getfield 23	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_Long	J
    //   167: lconst_0
    //   168: lcmp
    //   169: ifne +10 -> 179
    //   172: aload_0
    //   173: invokestatic 115	java/lang/System:currentTimeMillis	()J
    //   176: putfield 23	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_Long	J
    //   179: aload 8
    //   181: getfield 209	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:uint32_total_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   184: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   187: istore_3
    //   188: iload_3
    //   189: aload_0
    //   190: getfield 17	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_Int	I
    //   193: if_icmpge +8 -> 201
    //   196: aload 7
    //   198: monitorexit
    //   199: iconst_0
    //   200: ireturn
    //   201: aload_0
    //   202: getfield 19	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:b	I
    //   205: iload_3
    //   206: if_icmpge +8 -> 214
    //   209: aload_0
    //   210: iload_3
    //   211: putfield 19	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:b	I
    //   214: aload_0
    //   215: iload_3
    //   216: invokespecial 211	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:a	(I)Lcom/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket;
    //   219: astore 10
    //   221: aload 8
    //   223: getfield 215	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:all_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   226: invokevirtual 218	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:has	()Z
    //   229: ifeq +15 -> 244
    //   232: aload 8
    //   234: getfield 215	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:all_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   237: astore_1
    //   238: iconst_1
    //   239: istore 6
    //   241: goto +83 -> 324
    //   244: aload 8
    //   246: getfield 221	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:cur_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   249: invokevirtual 218	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:has	()Z
    //   252: ifne +63 -> 315
    //   255: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifeq +35 -> 293
    //   261: new 62	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   268: astore_1
    //   269: aload_1
    //   270: ldc 223
    //   272: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_1
    //   277: aload 9
    //   279: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: ldc 76
    //   285: iconst_2
    //   286: aload_1
    //   287: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   293: aload_0
    //   294: invokespecial 166	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:c	()V
    //   297: aload_0
    //   298: getfield 169	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_ComTencentMobileqqSttShardAIOSttResult	Lcom/tencent/mobileqq/stt/shard/AIOSttResult;
    //   301: iconst_4
    //   302: sipush 2007
    //   305: invokevirtual 174	com/tencent/mobileqq/stt/shard/AIOSttResult:a	(II)V
    //   308: aload 7
    //   310: monitorexit
    //   311: sipush 4001
    //   314: ireturn
    //   315: aload 8
    //   317: getfield 221	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:cur_text_rsp	Ltencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp;
    //   320: astore_1
    //   321: iconst_0
    //   322: istore 6
    //   324: aload_1
    //   325: getfield 226	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_pos	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   328: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   331: istore_2
    //   332: aload_1
    //   333: getfield 229	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   336: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   339: istore 4
    //   341: aload_1
    //   342: getfield 232	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_total_len	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   345: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   348: istore 5
    //   350: aload_0
    //   351: aload 10
    //   353: iload_2
    //   354: iload 4
    //   356: iload 5
    //   358: iconst_1
    //   359: aload_1
    //   360: getfield 235	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:uint32_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   363: invokevirtual 196	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   366: ishl
    //   367: aload_1
    //   368: getfield 239	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$textRsp:bytes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   371: invokevirtual 244	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   374: invokevirtual 249	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   377: invokevirtual 252	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:a	(Lcom/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket;IIII[B)Lcom/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket;
    //   380: pop
    //   381: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   384: ifeq +403 -> 787
    //   387: new 62	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   394: astore_1
    //   395: aload_1
    //   396: ldc 254
    //   398: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_1
    //   403: aload 9
    //   405: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_1
    //   410: ldc 200
    //   412: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload_1
    //   417: iload_2
    //   418: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload_1
    //   423: ldc 200
    //   425: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload_1
    //   430: iload 4
    //   432: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_1
    //   437: ldc 200
    //   439: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload_1
    //   444: iload 5
    //   446: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   449: pop
    //   450: ldc 76
    //   452: iconst_2
    //   453: aload_1
    //   454: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: new 62	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   467: astore_1
    //   468: aload_1
    //   469: ldc_w 256
    //   472: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: aload_1
    //   477: iload_3
    //   478: invokevirtual 72	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   481: pop
    //   482: aload_1
    //   483: ldc_w 258
    //   486: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload_1
    //   491: iload 6
    //   493: invokevirtual 261	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   496: pop
    //   497: aload_1
    //   498: ldc_w 263
    //   501: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload_1
    //   506: aload 10
    //   508: getfield 86	com/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket:jdField_a_of_type_Boolean	Z
    //   511: invokevirtual 261	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: ldc 76
    //   517: iconst_2
    //   518: aload_1
    //   519: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: goto +3 -> 528
    //   528: aload 10
    //   530: getfield 86	com/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket:jdField_a_of_type_Boolean	Z
    //   533: ifeq +268 -> 801
    //   536: iload 6
    //   538: ifeq +37 -> 575
    //   541: aload_0
    //   542: getfield 17	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_Int	I
    //   545: istore_2
    //   546: aload_0
    //   547: iload_3
    //   548: putfield 17	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_Int	I
    //   551: iload_2
    //   552: iload_3
    //   553: if_icmpge +22 -> 575
    //   556: aload_0
    //   557: getfield 30	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   560: iload_2
    //   561: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   564: invokevirtual 266	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   567: pop
    //   568: iload_2
    //   569: iconst_1
    //   570: iadd
    //   571: istore_2
    //   572: goto -21 -> 551
    //   575: aload_0
    //   576: invokespecial 268	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:a	()Ljava/lang/String;
    //   579: astore_1
    //   580: aload_1
    //   581: ifnull +163 -> 744
    //   584: aload 8
    //   586: getfield 272	tencent/im/s2c/msgtype0x210/submsgtype0x3d/SttResultPush$TransPttShardRsp:bool_is_total_end	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   589: invokevirtual 276	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   592: istore 6
    //   594: aload_0
    //   595: getfield 169	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_ComTencentMobileqqSttShardAIOSttResult	Lcom/tencent/mobileqq/stt/shard/AIOSttResult;
    //   598: aload_1
    //   599: iload 6
    //   601: invokevirtual 279	com/tencent/mobileqq/stt/shard/AIOSttResult:a	(Ljava/lang/String;Z)V
    //   604: iload 6
    //   606: ifne +184 -> 790
    //   609: sipush -10001
    //   612: istore_2
    //   613: goto +3 -> 616
    //   616: aload_0
    //   617: getfield 21	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_Boolean	Z
    //   620: ifne +175 -> 795
    //   623: aload_0
    //   624: iconst_1
    //   625: putfield 21	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_Boolean	Z
    //   628: sipush -10002
    //   631: istore_2
    //   632: goto +3 -> 635
    //   635: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   638: ifeq +90 -> 728
    //   641: new 88	java/lang/String
    //   644: dup
    //   645: aload 10
    //   647: getfield 91	com/tencent/mobileqq/stt/shard/BaseSttPushReceiver$SttPushPacket:jdField_a_of_type_JavaNioByteBuffer	Ljava/nio/ByteBuffer;
    //   650: invokevirtual 97	java/nio/ByteBuffer:array	()[B
    //   653: invokespecial 100	java/lang/String:<init>	([B)V
    //   656: astore 8
    //   658: new 62	java/lang/StringBuilder
    //   661: dup
    //   662: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   665: astore 9
    //   667: aload 9
    //   669: ldc_w 281
    //   672: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload 9
    //   678: aload 8
    //   680: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload 9
    //   686: ldc_w 283
    //   689: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload 9
    //   695: iload 6
    //   697: invokevirtual 261	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload 9
    //   703: ldc_w 285
    //   706: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: pop
    //   710: aload 9
    //   712: aload_1
    //   713: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: pop
    //   717: ldc 76
    //   719: iconst_2
    //   720: aload 9
    //   722: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   725: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   728: iload 6
    //   730: ifeq +68 -> 798
    //   733: aload_0
    //   734: aload_0
    //   735: getfield 19	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:b	I
    //   738: invokespecial 287	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:a	(I)V
    //   741: goto +57 -> 798
    //   744: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   747: ifeq +54 -> 801
    //   750: ldc 76
    //   752: iconst_2
    //   753: ldc_w 289
    //   756: invokestatic 83	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   759: goto +42 -> 801
    //   762: aload_0
    //   763: getfield 169	com/tencent/mobileqq/stt/shard/ShardSttPushReceiver:jdField_a_of_type_ComTencentMobileqqSttShardAIOSttResult	Lcom/tencent/mobileqq/stt/shard/AIOSttResult;
    //   766: iconst_1
    //   767: invokevirtual 292	com/tencent/mobileqq/stt/shard/AIOSttResult:a	(Z)V
    //   770: aload 7
    //   772: monitorexit
    //   773: iload_2
    //   774: ireturn
    //   775: astore_1
    //   776: aload 7
    //   778: monitorexit
    //   779: goto +5 -> 784
    //   782: aload_1
    //   783: athrow
    //   784: goto -2 -> 782
    //   787: goto -259 -> 528
    //   790: iconst_0
    //   791: istore_2
    //   792: goto -176 -> 616
    //   795: goto -160 -> 635
    //   798: goto -36 -> 762
    //   801: iconst_0
    //   802: istore_2
    //   803: goto -41 -> 762
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	806	0	this	ShardSttPushReceiver
    //   0	806	1	paramMsgBody	tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody
    //   77	726	2	i	int
    //   187	367	3	j	int
    //   339	92	4	k	int
    //   348	97	5	m	int
    //   239	490	6	bool	boolean
    //   4	773	7	localConcurrentHashMap	ConcurrentHashMap
    //   67	654	9	localObject2	Object
    //   219	427	10	localSttPushPacket	BaseSttPushReceiver.SttPushPacket
    // Exception table:
    //   from	to	target	type
    //   13	16	775	finally
    //   20	52	775	finally
    //   56	129	775	finally
    //   133	149	775	finally
    //   153	179	775	finally
    //   179	199	775	finally
    //   201	214	775	finally
    //   214	238	775	finally
    //   244	293	775	finally
    //   293	311	775	finally
    //   315	321	775	finally
    //   324	525	775	finally
    //   528	536	775	finally
    //   541	551	775	finally
    //   556	568	775	finally
    //   575	580	775	finally
    //   584	604	775	finally
    //   616	628	775	finally
    //   635	728	775	finally
    //   733	741	775	finally
    //   744	759	775	finally
    //   762	773	775	finally
    //   776	779	775	finally
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      b();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stt.shard.ShardSttPushReceiver
 * JD-Core Version:    0.7.0.1
 */