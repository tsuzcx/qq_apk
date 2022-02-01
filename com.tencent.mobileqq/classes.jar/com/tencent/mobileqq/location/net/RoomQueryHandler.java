package com.tencent.mobileqq.location.net;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.util.LocationProtoUtil;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import tencent.im.oidb.location.RoomOperate.ReqRoomQuery;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class RoomQueryHandler
  extends BaseProto<LocationHandler>
{
  private static int jdField_a_of_type_Int = 5000;
  private long jdField_a_of_type_Long;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public RoomQueryHandler(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void a(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] requestQueryRoom: invoked. ", " uinType: ", Integer.valueOf(paramInt), " sessionUin: ", Long.valueOf(paramLong), " noLimitReq: ", Boolean.valueOf(paramBoolean) });
    }
    long l = System.currentTimeMillis();
    if ((l - this.jdField_a_of_type_Long < this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() * 1000L) && (!paramBoolean))
    {
      QLog.d("RoomQueryHandler", 1, new Object[] { "[queryLocationRoom] requestQueryRoomNoLimit: invoked. frequency limited", " requestIntervalSecond: ", this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger });
      return;
    }
    this.jdField_a_of_type_Long = l;
    RoomOperate.ReqRoomQuery localReqRoomQuery = new RoomOperate.ReqRoomQuery();
    localReqRoomQuery.no_limit.set(paramBoolean);
    Object localObject = LocationProtoUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, paramInt, paramLong);
    localReqRoomQuery.room_key.set((MessageMicro)localObject);
    localReqRoomQuery.room_key.setHasFlag(true);
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_MqqAppAppRuntime.getAccount(), "QQLBSShareSvc.room_query");
    ((ToServiceMsg)localObject).extraData.putInt("uintype", paramInt);
    ((ToServiceMsg)localObject).extraData.putString("uin", String.valueOf(paramLong));
    ((ToServiceMsg)localObject).putWupBuffer(localReqRoomQuery.toByteArray());
    a().sendPbReq((ToServiceMsg)localObject);
  }
  
  private void c()
  {
    a().notifyUI(2, false, null);
  }
  
  private void c(int paramInt, String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoom: failed. ", paramString);
      }
    }
    a(paramInt, l1, false);
  }
  
  protected LocationHandler a()
  {
    return LocationHandler.a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] stopRequestQueryRoomInLoop: invoked. ", " loopQueryStopped: ", this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean });
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(int paramInt, String paramString)
  {
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("RoomQueryHandler", 1, "[queryLocationRoom] requestQueryRoom: failed. ", localNumberFormatException);
      }
    }
    LocationHandler.a().c(paramInt, paramString);
    a(paramInt, l1, true);
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: invokevirtual 237	com/tencent/mobileqq/location/net/RoomQueryHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Z
    //   7: ifeq +283 -> 290
    //   10: new 239	tencent/im/oidb/location/RoomOperate$RspRoomQuery
    //   13: dup
    //   14: invokespecial 240	tencent/im/oidb/location/RoomOperate$RspRoomQuery:<init>	()V
    //   17: aload_3
    //   18: checkcast 242	[B
    //   21: checkcast 242	[B
    //   24: invokevirtual 246	tencent/im/oidb/location/RoomOperate$RspRoomQuery:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 239	tencent/im/oidb/location/RoomOperate$RspRoomQuery
    //   30: astore_2
    //   31: aload_2
    //   32: getfield 250	tencent/im/oidb/location/RoomOperate$RspRoomQuery:room_state	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   35: invokevirtual 253	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   38: istore 4
    //   40: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +118 -> 161
    //   46: aload_2
    //   47: getfield 257	tencent/im/oidb/location/RoomOperate$RspRoomQuery:user_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   50: invokevirtual 262	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   53: astore 6
    //   55: new 264	java/util/ArrayList
    //   58: dup
    //   59: invokespecial 265	java/util/ArrayList:<init>	()V
    //   62: astore_3
    //   63: aload 6
    //   65: invokeinterface 271 1 0
    //   70: astore 6
    //   72: aload 6
    //   74: invokeinterface 276 1 0
    //   79: ifeq +42 -> 121
    //   82: aload_3
    //   83: aload 6
    //   85: invokeinterface 280 1 0
    //   90: checkcast 282	tencent/im/oidb/location/RoomOperate$UserData
    //   93: getfield 285	tencent/im/oidb/location/RoomOperate$UserData:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   96: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   99: invokestatic 79	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: invokevirtual 293	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   105: pop
    //   106: goto -34 -> 72
    //   109: astore_1
    //   110: ldc 60
    //   112: iconst_1
    //   113: ldc_w 295
    //   116: aload_1
    //   117: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   120: return
    //   121: ldc 60
    //   123: iconst_2
    //   124: iconst_5
    //   125: anewarray 62	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: ldc_w 297
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: ldc_w 299
    //   139: aastore
    //   140: dup
    //   141: iconst_2
    //   142: iload 4
    //   144: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: aastore
    //   148: dup
    //   149: iconst_3
    //   150: ldc_w 301
    //   153: aastore
    //   154: dup
    //   155: iconst_4
    //   156: aload_3
    //   157: aastore
    //   158: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   161: aload_2
    //   162: getfield 305	tencent/im/oidb/location/RoomOperate$RspRoomQuery:msg_result	Ltencent/im/oidb/location/qq_lbs_share$ResultInfo;
    //   165: invokevirtual 310	tencent/im/oidb/location/qq_lbs_share$ResultInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   168: checkcast 307	tencent/im/oidb/location/qq_lbs_share$ResultInfo
    //   171: invokestatic 313	com/tencent/mobileqq/location/util/LocationProtoUtil:a	(Ltencent/im/oidb/location/qq_lbs_share$ResultInfo;)Z
    //   174: ifeq +111 -> 285
    //   177: aload_2
    //   178: getfield 317	tencent/im/oidb/location/RoomOperate$RspRoomQuery:req_interval	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   181: invokevirtual 320	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   184: istore 5
    //   186: aload_0
    //   187: getfield 35	com/tencent/mobileqq/location/net/RoomQueryHandler:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   190: iload 5
    //   192: invokevirtual 322	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   195: aload_1
    //   196: getfield 159	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   199: ldc 161
    //   201: iconst_m1
    //   202: invokevirtual 326	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   205: istore 5
    //   207: aload_1
    //   208: getfield 159	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   211: ldc 169
    //   213: invokevirtual 330	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore_1
    //   217: iload 4
    //   219: iconst_2
    //   220: if_icmpne +35 -> 255
    //   223: aload_0
    //   224: invokevirtual 332	com/tencent/mobileqq/location/net/RoomQueryHandler:a	()V
    //   227: invokestatic 219	com/tencent/mobileqq/location/net/LocationHandler:a	()Lcom/tencent/mobileqq/location/net/LocationHandler;
    //   230: new 334	com/tencent/mobileqq/location/data/LocationRoom$RoomKey
    //   233: dup
    //   234: iload 5
    //   236: aload_1
    //   237: invokespecial 336	com/tencent/mobileqq/location/data/LocationRoom$RoomKey:<init>	(ILjava/lang/String;)V
    //   240: iconst_m1
    //   241: invokevirtual 340	com/tencent/mobileqq/location/net/LocationHandler:b	(Lcom/tencent/mobileqq/location/data/LocationRoom$RoomKey;I)V
    //   244: aload_0
    //   245: getfield 123	com/tencent/mobileqq/location/net/RoomQueryHandler:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   248: iload 5
    //   250: aload_1
    //   251: iconst_0
    //   252: invokestatic 343	com/tencent/mobileqq/location/util/LocationProtoUtil:a	(Lmqq/app/AppRuntime;ILjava/lang/String;Z)V
    //   255: aload_0
    //   256: invokevirtual 189	com/tencent/mobileqq/location/net/RoomQueryHandler:a	()Lcom/tencent/mobileqq/location/net/LocationHandler;
    //   259: iconst_2
    //   260: iconst_1
    //   261: iconst_3
    //   262: anewarray 62	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload_2
    //   268: aastore
    //   269: dup
    //   270: iconst_1
    //   271: iload 5
    //   273: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: dup
    //   278: iconst_2
    //   279: aload_1
    //   280: aastore
    //   281: invokevirtual 204	com/tencent/mobileqq/location/net/LocationHandler:notifyUI	(IZLjava/lang/Object;)V
    //   284: return
    //   285: aload_0
    //   286: invokespecial 345	com/tencent/mobileqq/location/net/RoomQueryHandler:c	()V
    //   289: return
    //   290: aload_2
    //   291: ifnull +45 -> 336
    //   294: aload_2
    //   295: invokevirtual 350	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   298: istore 4
    //   300: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq +33 -> 336
    //   306: ldc 60
    //   308: iconst_2
    //   309: iconst_3
    //   310: anewarray 62	java/lang/Object
    //   313: dup
    //   314: iconst_0
    //   315: ldc_w 297
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: ldc_w 352
    //   324: aastore
    //   325: dup
    //   326: iconst_2
    //   327: iload 4
    //   329: invokestatic 72	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   332: aastore
    //   333: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   336: aload_0
    //   337: invokespecial 345	com/tencent/mobileqq/location/net/RoomQueryHandler:c	()V
    //   340: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	this	RoomQueryHandler
    //   0	341	1	paramToServiceMsg	ToServiceMsg
    //   0	341	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   0	341	3	paramObject	Object
    //   38	290	4	i	int
    //   184	88	5	j	int
    //   53	31	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	72	109	java/lang/Exception
    //   72	106	109	java/lang/Exception
    //   121	161	109	java/lang/Exception
    //   161	217	109	java/lang/Exception
    //   223	255	109	java/lang/Exception
    //   255	284	109	java/lang/Exception
    //   285	289	109	java/lang/Exception
  }
  
  public void b()
  {
    a();
  }
  
  public void b(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("RoomQueryHandler", 2, new Object[] { "[queryLocationRoom] requestQueryRoomInLoop: invoked. still in loop, no need re-request ", " sessionUin: ", paramString });
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_JavaLangRunnable = new RoomQueryHandler.1(this, paramInt, paramString);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.RoomQueryHandler
 * JD-Core Version:    0.7.0.1
 */