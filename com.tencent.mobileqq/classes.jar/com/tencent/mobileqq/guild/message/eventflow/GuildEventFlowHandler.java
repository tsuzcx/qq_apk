package com.tencent.mobileqq.guild.message.eventflow;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.GuildEventFlowObserver;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.eventflow.api.IGuildEventFlowService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.group_pro_proto.common.common.Event;
import tencent.im.group_pro_proto.eventflow.msg_event.GetReq;
import tencent.im.group_pro_proto.eventflow.msg_event.GetRsp;
import tencent.im.group_pro_proto.eventflow.msg_event.MsgEvent;

public class GuildEventFlowHandler
  extends BusinessHandler
  implements IGuildEventFlowHandler
{
  private static String a = "GuildEventFlowHandler";
  private ArrayList<String> b = new ArrayList();
  
  public GuildEventFlowHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 35	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: astore 10
    //   6: ldc 37
    //   8: astore 9
    //   10: aload 10
    //   12: ldc 39
    //   14: ldc 37
    //   16: invokevirtual 45	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 10
    //   21: aload_1
    //   22: getfield 35	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   25: ldc 47
    //   27: ldc 37
    //   29: invokevirtual 45	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 11
    //   34: getstatic 49	com/tencent/mobileqq/guild/message/eventflow/GuildEventFlowHandler:a	Ljava/lang/String;
    //   37: astore_1
    //   38: new 51	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   45: astore 12
    //   47: aload 12
    //   49: ldc 54
    //   51: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 12
    //   57: aload_2
    //   58: invokevirtual 64	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   61: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_1
    //   66: iconst_2
    //   67: aload 12
    //   69: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: aload_2
    //   76: invokevirtual 64	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   79: sipush 1000
    //   82: if_icmpne +256 -> 338
    //   85: aload_3
    //   86: ifnull +252 -> 338
    //   89: new 79	tencent/im/group_pro_proto/eventflow/msg_event$GetRsp
    //   92: dup
    //   93: invokespecial 80	tencent/im/group_pro_proto/eventflow/msg_event$GetRsp:<init>	()V
    //   96: astore_2
    //   97: aload_2
    //   98: aload_3
    //   99: checkcast 82	[B
    //   102: checkcast 82	[B
    //   105: invokevirtual 86	tencent/im/group_pro_proto/eventflow/msg_event$GetRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   108: pop
    //   109: getstatic 49	com/tencent/mobileqq/guild/message/eventflow/GuildEventFlowHandler:a	Ljava/lang/String;
    //   112: astore_3
    //   113: new 51	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   120: astore 12
    //   122: aload 12
    //   124: ldc 88
    //   126: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 12
    //   132: aload_2
    //   133: getfield 92	tencent/im/group_pro_proto/eventflow/msg_event$GetRsp:err_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   136: invokevirtual 98	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   139: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload 12
    //   145: ldc 103
    //   147: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 9
    //   153: astore_1
    //   154: aload_2
    //   155: getfield 107	tencent/im/group_pro_proto/eventflow/msg_event$GetRsp:err_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   158: invokevirtual 113	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   161: ifeq +14 -> 175
    //   164: aload_2
    //   165: getfield 107	tencent/im/group_pro_proto/eventflow/msg_event$GetRsp:err_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   168: invokevirtual 116	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   171: invokevirtual 121	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   174: astore_1
    //   175: aload 12
    //   177: aload_1
    //   178: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 12
    //   184: ldc 123
    //   186: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 12
    //   192: aload_2
    //   193: getfield 92	tencent/im/group_pro_proto/eventflow/msg_event$GetRsp:err_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   196: invokevirtual 98	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   199: invokevirtual 101	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_3
    //   204: iconst_2
    //   205: aload 12
    //   207: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 77	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload_2
    //   214: getfield 92	tencent/im/group_pro_proto/eventflow/msg_event$GetRsp:err_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   217: invokevirtual 98	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   220: lstore 5
    //   222: lload 5
    //   224: lconst_0
    //   225: lcmp
    //   226: ifne +112 -> 338
    //   229: aload_2
    //   230: getfield 127	tencent/im/group_pro_proto/eventflow/msg_event$GetRsp:msg_events	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   233: invokevirtual 130	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   236: ifeq +23 -> 259
    //   239: aload_2
    //   240: getfield 127	tencent/im/group_pro_proto/eventflow/msg_event$GetRsp:msg_events	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   243: invokevirtual 133	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   246: istore 4
    //   248: iload 4
    //   250: ifle +9 -> 259
    //   253: iconst_1
    //   254: istore 7
    //   256: goto +6 -> 262
    //   259: iconst_0
    //   260: istore 7
    //   262: aload_0
    //   263: aload 10
    //   265: aload 11
    //   267: aload_2
    //   268: invokespecial 136	com/tencent/mobileqq/guild/message/eventflow/GuildEventFlowHandler:a	(Ljava/lang/String;Ljava/lang/String;Ltencent/im/group_pro_proto/eventflow/msg_event$GetRsp;)V
    //   271: iconst_1
    //   272: istore 8
    //   274: goto +70 -> 344
    //   277: astore_1
    //   278: iconst_1
    //   279: istore 8
    //   281: goto +17 -> 298
    //   284: astore_1
    //   285: iconst_1
    //   286: istore 8
    //   288: goto +7 -> 295
    //   291: astore_1
    //   292: iconst_0
    //   293: istore 8
    //   295: iconst_0
    //   296: istore 7
    //   298: getstatic 49	com/tencent/mobileqq/guild/message/eventflow/GuildEventFlowHandler:a	Ljava/lang/String;
    //   301: astore_2
    //   302: new 51	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   309: astore_3
    //   310: aload_3
    //   311: ldc 138
    //   313: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_3
    //   318: aload_1
    //   319: invokevirtual 139	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   322: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload_2
    //   327: iconst_2
    //   328: aload_3
    //   329: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 142	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: goto +9 -> 344
    //   338: iconst_0
    //   339: istore 8
    //   341: iconst_0
    //   342: istore 7
    //   344: aload_0
    //   345: getstatic 147	com/tencent/mobileqq/guild/message/GuildEventFlowObserver:b	I
    //   348: iload 8
    //   350: iconst_2
    //   351: anewarray 149	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: iload 7
    //   358: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   361: aastore
    //   362: dup
    //   363: iconst_1
    //   364: aload 10
    //   366: aastore
    //   367: invokevirtual 159	com/tencent/mobileqq/guild/message/eventflow/GuildEventFlowHandler:notifyUI	(IZLjava/lang/Object;)V
    //   370: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	GuildEventFlowHandler
    //   0	371	1	paramToServiceMsg	ToServiceMsg
    //   0	371	2	paramFromServiceMsg	FromServiceMsg
    //   0	371	3	paramObject	Object
    //   246	3	4	i	int
    //   220	3	5	l	long
    //   254	103	7	bool1	boolean
    //   272	77	8	bool2	boolean
    //   8	144	9	str1	String
    //   4	361	10	localObject	Object
    //   32	234	11	str2	String
    //   45	161	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   262	271	277	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   229	248	284	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   89	151	291	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   154	175	291	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   175	222	291	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void a(String paramString1, String paramString2, long paramLong, List<common.Event> paramList)
  {
    if ((this.appRuntime instanceof BaseQQAppInterface))
    {
      MessageRecord localMessageRecord = ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade((BaseQQAppInterface)this.appRuntime).a(10014).a(10014).d(String.valueOf(paramString2), 10014, paramLong);
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("applyEventsToMsg. channelId: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", shmsgseq: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", findMr = ");
      boolean bool;
      if (localMessageRecord != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.i(str, 2, localStringBuilder.toString());
      ((IGuildEventFlowService)this.appRuntime.getRuntimeService(IGuildEventFlowService.class, "")).processEvents(localMessageRecord, paramList, paramString1, paramString2, paramLong);
      if (localMessageRecord != null) {
        ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).saveEventFlowToMsg(localMessageRecord, new GuildMsgEventInfo(paramList));
      }
    }
  }
  
  private void a(String paramString1, String paramString2, msg_event.GetRsp paramGetRsp)
  {
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processEventFlow. channelId: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", beginTime: ");
    localStringBuilder.append(paramGetRsp.begin_time.get());
    localStringBuilder.append(", endTime: ");
    localStringBuilder.append(paramGetRsp.end_time.get());
    localStringBuilder.append(", msg_events size:");
    localStringBuilder.append(paramGetRsp.msg_events.size());
    QLog.i((String)localObject, 2, localStringBuilder.toString());
    this.b.add(paramString1);
    ((IGuildMsgSeqTimeService)this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "")).setEventFlowTimeItem(paramString2, paramString1, paramGetRsp.begin_time.get(), paramGetRsp.end_time.get(), paramGetRsp.cookie.get().toByteArray());
    paramGetRsp = paramGetRsp.msg_events.get().iterator();
    while (paramGetRsp.hasNext())
    {
      localObject = (msg_event.MsgEvent)paramGetRsp.next();
      a(paramString2, paramString1, ((msg_event.MsgEvent)localObject).msg_seq.get(), ((msg_event.MsgEvent)localObject).events.get());
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool3 = this.b.contains(paramString);
    paramString = ((IGuildMsgSeqTimeService)this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getEventFlowTimeItem(paramString);
    boolean bool2 = true;
    boolean bool1;
    if ((paramString != null) && (paramString.registProxyTime > paramString.eventEndTime)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if ((bool3) || (!bool1)) {
      bool2 = false;
    }
    if (QLog.isColorLevel())
    {
      paramString = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canPullMsgEvents. hasPulledBefore: ");
      localStringBuilder.append(bool3);
      localStringBuilder.append(", needsUpdate: ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(", canPull: ");
      localStringBuilder.append(bool2);
      QLog.d(paramString, 2, localStringBuilder.toString());
    }
    return bool2;
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!a(paramString2)) {
      return;
    }
    msg_event.GetReq localGetReq = new msg_event.GetReq();
    Object localObject = ((IGuildMsgSeqTimeService)this.appRuntime.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getEventFlowTimeItem(paramString2);
    if ((localObject != null) && (((GuildEventFlowTimeItem)localObject).cookie != null) && (((GuildEventFlowTimeItem)localObject).cookie.length > 0)) {
      localGetReq.cookie.set(ByteStringMicro.copyFrom(((GuildEventFlowTimeItem)localObject).cookie));
    }
    try
    {
      localGetReq.channel_id.set(Long.parseLong(paramString2));
      localGetReq.guild_id.set(Long.parseLong(paramString1));
      localObject = createToServiceMsg("trpc.group_pro.msg_event.MsgEventSvc.Get");
      ((ToServiceMsg)localObject).extraData.putString("channelId", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("guildId", paramString1);
      ((ToServiceMsg)localObject).putWupBuffer(localGetReq.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e(a, 2, paramString1.getMessage());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.b.clear();
    }
    ThreadManagerV2.getUIHandlerV2().post(new GuildEventFlowHandler.1(this));
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("trpc.group_pro.msg_event.MsgEventSvc.Get");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return GuildEventFlowObserver.class;
  }
  
  public void onDestroy()
  {
    this.b.clear();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = a;
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("cmdfilter error=");
          paramFromServiceMsg.append(str);
          QLog.d(paramToServiceMsg, 2, paramFromServiceMsg.toString());
        }
        return;
      }
      if ("trpc.group_pro.msg_event.MsgEventSvc.Get".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowHandler
 * JD-Core Version:    0.7.0.1
 */