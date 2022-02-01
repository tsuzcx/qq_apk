package com.tencent.mobileqq.guild.message.api.impl.pullroammsg;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.GuildRoamMessageProcessor;
import com.tencent.mobileqq.guild.message.api.IGuildMsgFactory;
import com.tencent.mobileqq.guild.message.api.impl.GuildRoamMessageHandler;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgReq;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelParam;

public class PullRoamMsgLogicCommon
  extends BasePullRoamMsgLogic
{
  public PullRoamMsgLogicCommon(AppInterface paramAppInterface, GuildRoamMessageHandler paramGuildRoamMessageHandler)
  {
    super(paramAppInterface, paramGuildRoamMessageHandler);
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    paramToServiceMsg.setNeedRemindSlowNetwork(true);
    this.c.sendPbReq(paramToServiceMsg);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    super.a(paramToServiceMsg, paramFromServiceMsg);
  }
  
  /* Error */
  public void a(String paramString, ToServiceMsg paramToServiceMsg, tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgRsp paramChannelMsgRsp, java.util.ArrayList<tencent.im.group_pro_proto.common.common.Msg> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 36	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   4: ifnonnull +15 -> 19
    //   7: aload_0
    //   8: getfield 39	com/tencent/mobileqq/guild/message/api/impl/pullroammsg/PullRoamMsgLogicCommon:a	Lcom/tencent/common/app/AppInterface;
    //   11: invokevirtual 44	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   14: astore 5
    //   16: goto +9 -> 25
    //   19: aload_2
    //   20: invokevirtual 36	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   23: astore 5
    //   25: aload_0
    //   26: getfield 39	com/tencent/mobileqq/guild/message/api/impl/pullroammsg/PullRoamMsgLogicCommon:a	Lcom/tencent/common/app/AppInterface;
    //   29: ldc 46
    //   31: ldc 48
    //   33: invokevirtual 52	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   36: checkcast 46	com/tencent/mobileqq/guild/message/api/IGuildMsgFactory
    //   39: invokeinterface 56 1 0
    //   44: aload_1
    //   45: invokevirtual 61	com/tencent/mobileqq/guild/message/GuildMessageCache:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   48: astore 6
    //   50: aload 6
    //   52: monitorenter
    //   53: aload_0
    //   54: getfield 39	com/tencent/mobileqq/guild/message/api/impl/pullroammsg/PullRoamMsgLogicCommon:a	Lcom/tencent/common/app/AppInterface;
    //   57: ldc 46
    //   59: ldc 48
    //   61: invokevirtual 52	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   64: checkcast 46	com/tencent/mobileqq/guild/message/api/IGuildMsgFactory
    //   67: iconst_0
    //   68: invokeinterface 65 2 0
    //   73: iconst_4
    //   74: anewarray 67	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_2
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload_3
    //   84: aastore
    //   85: dup
    //   86: iconst_2
    //   87: aload 4
    //   89: aastore
    //   90: dup
    //   91: iconst_3
    //   92: aload 5
    //   94: aastore
    //   95: invokeinterface 72 2 0
    //   100: aload 6
    //   102: monitorexit
    //   103: aload_0
    //   104: aload_1
    //   105: aload_2
    //   106: aload_3
    //   107: aload 4
    //   109: invokespecial 74	com/tencent/mobileqq/guild/message/api/impl/pullroammsg/BasePullRoamMsgLogic:a	(Ljava/lang/String;Lcom/tencent/qphone/base/remote/ToServiceMsg;Ltencent/im/group_pro_proto/synclogic/synclogic$ChannelMsgRsp;Ljava/util/ArrayList;)V
    //   112: return
    //   113: astore_1
    //   114: aload 6
    //   116: monitorexit
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: invokestatic 80	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   123: ifeq +12 -> 135
    //   126: ldc 82
    //   128: iconst_2
    //   129: ldc 84
    //   131: aload_1
    //   132: invokestatic 88	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	PullRoamMsgLogicCommon
    //   0	137	1	paramString	String
    //   0	137	2	paramToServiceMsg	ToServiceMsg
    //   0	137	3	paramChannelMsgRsp	tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgRsp
    //   0	137	4	paramArrayList	java.util.ArrayList<tencent.im.group_pro_proto.common.common.Msg>
    //   14	79	5	str	String
    // Exception table:
    //   from	to	target	type
    //   53	103	113	finally
    //   114	117	113	finally
    //   25	53	119	java/lang/Exception
    //   117	119	119	java/lang/Exception
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    ToServiceMsg localToServiceMsg = this.c.createToServiceMsg("trpc.group_pro.synclogic.SyncLogic.GetChannelMsg");
    localToServiceMsg.extraData.putString("guildId", paramString1);
    localToServiceMsg.extraData.putString("channelId", paramString2);
    localToServiceMsg.extraData.putLong("lBeginSeq", paramLong1);
    localToServiceMsg.extraData.putLong("lEndSeq", paramLong2);
    localToServiceMsg.extraData.putBundle("context", paramBundle);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    paramBundle = new synclogic.ChannelMsgReq();
    synclogic.ChannelParam localChannelParam = new synclogic.ChannelParam();
    localChannelParam.begin_seq.set(paramLong1);
    localChannelParam.end_seq.set(paramLong2);
    localChannelParam.guild_id.set(Long.valueOf(paramString1).longValue());
    localChannelParam.channel_id.set(Long.valueOf(paramString2).longValue());
    paramBundle.channel_param.set(localChannelParam);
    localToServiceMsg.putWupBuffer(paramBundle.toByteArray());
    a(localToServiceMsg);
    return true;
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = paramToServiceMsg.extraData.getBundle("context");
    String str = paramToServiceMsg.extraData.getString("channelId");
    if (localBundle != null)
    {
      localBundle.putBoolean("success", false);
      ((GuildRoamMessageProcessor)((IGuildMsgFactory)this.a.getRuntimeService(IGuildMsgFactory.class, "")).getMessageProcessor(0)).a(str, 10014, null, null, localBundle);
    }
    super.b(paramToServiceMsg, paramFromServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.pullroammsg.PullRoamMsgLogicCommon
 * JD-Core Version:    0.7.0.1
 */