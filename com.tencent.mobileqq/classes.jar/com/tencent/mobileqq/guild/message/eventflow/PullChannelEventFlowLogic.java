package com.tencent.mobileqq.guild.message.eventflow;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildRoamMessageHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import tencent.im.group_pro_proto.common.common.Msg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsgRsp;

public class PullChannelEventFlowLogic
{
  private AppInterface a;
  private String b;
  private String c;
  private HashSet<Long> d = new HashSet();
  
  public PullChannelEventFlowLogic(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    this.a = paramAppInterface;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    while (paramLong1 <= paramLong2)
    {
      this.d.add(Long.valueOf(paramLong1));
      paramLong1 += 1L;
    }
  }
  
  private boolean a(GuildMsgEventInfoForUpdate paramGuildMsgEventInfoForUpdate)
  {
    if (paramGuildMsgEventInfoForUpdate == null) {
      return false;
    }
    boolean bool = this.d.contains(Long.valueOf(paramGuildMsgEventInfoForUpdate.a));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("needVersionUpdate: guildId:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" channelId:");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" msgSeq:");
      ((StringBuilder)localObject).append(paramGuildMsgEventInfoForUpdate.a);
      ((StringBuilder)localObject).append(" isPullIng:");
      ((StringBuilder)localObject).append(bool);
      QLog.i("PullChannelEventFlowLogic", 2, ((StringBuilder)localObject).toString());
    }
    if (bool) {
      return false;
    }
    Object localObject = ((IGuildMsgSeqTimeService)this.a.getRuntimeService(IGuildMsgSeqTimeService.class, "")).getEventFlowTimeItem(this.c);
    if (localObject == null) {
      return false;
    }
    if (paramGuildMsgEventInfoForUpdate.b() < ((GuildEventFlowTimeItem)localObject).eventBeginTime) {
      return true;
    }
    return paramGuildMsgEventInfoForUpdate.a();
  }
  
  private void b(long paramLong1, long paramLong2)
  {
    while (paramLong1 <= paramLong2)
    {
      this.d.remove(Long.valueOf(paramLong1));
      paramLong1 += 1L;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removePullSeqs: guildId:");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" channelId:");
      localStringBuilder.append(this.c);
      localStringBuilder.append(" pullSeqsFromSvr size():");
      localStringBuilder.append(this.d.size());
      QLog.i("PullChannelEventFlowLogic", 2, localStringBuilder.toString());
    }
  }
  
  private boolean b(ArrayList<GuildMsgEventInfoForUpdate> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onChatMessageExposure: guildId:");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(" channelId:");
        ((StringBuilder)localObject).append(this.c);
        ((StringBuilder)localObject).append(" needUpdateInfos:");
        ((StringBuilder)localObject).append(paramArrayList.toString());
        QLog.i("PullChannelEventFlowLogic", 2, ((StringBuilder)localObject).toString());
      }
      long l1 = ((GuildMsgEventInfoForUpdate)paramArrayList.get(0)).a;
      long l2 = ((GuildMsgEventInfoForUpdate)paramArrayList.get(paramArrayList.size() - 1)).a;
      Object localObject = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GuildMsgEventInfoForUpdate localGuildMsgEventInfoForUpdate = (GuildMsgEventInfoForUpdate)paramArrayList.next();
        ((ArrayList)localObject).add(new Pair(Long.valueOf(localGuildMsgEventInfoForUpdate.a), Long.valueOf(localGuildMsgEventInfoForUpdate.b.b())));
      }
      paramArrayList = new Bundle();
      paramArrayList.putBoolean("pull_roammsg_from_eventflow", true);
      paramArrayList.putSerializable("msgevent_version_list", (Serializable)localObject);
      if (((IGuildRoamMessageHandler)this.a.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildRoamMsgHandlerName())).reqPullRoamMsg(this.c, l1, l2, paramArrayList))
      {
        a(l1, l2);
        return true;
      }
    }
    return false;
  }
  
  private ArrayList<ArrayList<GuildMsgEventInfoForUpdate>> c(ArrayList<GuildMsgEventInfoForUpdate> paramArrayList)
  {
    int j = paramArrayList.size();
    GuildMsgEventInfoForUpdate localGuildMsgEventInfoForUpdate = (GuildMsgEventInfoForUpdate)paramArrayList.get(0);
    long l = localGuildMsgEventInfoForUpdate.a;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (a(localGuildMsgEventInfoForUpdate)) {
      localArrayList2.add(localGuildMsgEventInfoForUpdate);
    }
    int i = 1;
    while (i < j)
    {
      localGuildMsgEventInfoForUpdate = (GuildMsgEventInfoForUpdate)paramArrayList.get(i);
      if ((localGuildMsgEventInfoForUpdate.a != l + 1L) && (!localArrayList2.isEmpty()))
      {
        localArrayList1.add(localArrayList2);
        localArrayList2.clear();
      }
      if (a(localGuildMsgEventInfoForUpdate)) {
        localArrayList2.add(localGuildMsgEventInfoForUpdate);
      }
      l = localGuildMsgEventInfoForUpdate.a;
      i += 1;
    }
    if (!localArrayList2.isEmpty()) {
      localArrayList1.add(localArrayList2);
    }
    return localArrayList1;
  }
  
  public void a(ArrayList<GuildMsgEventInfoForUpdate> paramArrayList)
  {
    paramArrayList = c(paramArrayList);
    if (paramArrayList.size() > 0)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        b((ArrayList)paramArrayList.next());
      }
    }
  }
  
  public void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, synclogic.ChannelMsgRsp paramChannelMsgRsp, ArrayList<common.Msg> paramArrayList)
  {
    long l1 = paramToServiceMsg.extraData.getLong("lBeginSeq");
    long l2 = paramToServiceMsg.extraData.getLong("lEndSeq");
    this.a.runOnUiThread(new PullChannelEventFlowLogic.1(this, l1, l2, paramToServiceMsg, paramChannelMsgRsp, paramArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.eventflow.PullChannelEventFlowLogic
 * JD-Core Version:    0.7.0.1
 */