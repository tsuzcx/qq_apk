package com.tencent.mobileqq.guild.message.registerproxy;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.registerproxy.observer.GuildRegisterProxyObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelMsg;
import tencent.im.group_pro_proto.synclogic.synclogic.ChannelParam;
import tencent.im.group_pro_proto.synclogic.synclogic.MultiChannelMsg;
import tencent.im.group_pro_proto.synclogic.synclogic.MultiChannelMsgReq;
import tencent.im.group_pro_proto.synclogic.synclogic.MultiChannelMsgRsp;

public class GuildRegisterProxyPullMsgProcesser
  implements IGuildProcesserCallBack, IGuildRegisterProxyProcesser
{
  private static String c = "GuildRegisterProxyPullMsgProcesser";
  GuildRegisterProxyMsgHandler a;
  boolean b = false;
  private AppInterface d;
  private ArrayList<synclogic.ChannelParam> e = new ArrayList();
  private int f = 0;
  private boolean g = false;
  private long h = 0L;
  private Set<Long> i = new HashSet();
  private Comparator j = new GuildRegisterProxyPullMsgProcesser.1(this);
  
  public GuildRegisterProxyPullMsgProcesser(AppInterface paramAppInterface, GuildRegisterProxyMsgHandler paramGuildRegisterProxyMsgHandler)
  {
    this.a = paramGuildRegisterProxyMsgHandler;
    this.d = paramAppInterface;
    this.a.a().a(this);
  }
  
  private String a(synclogic.ChannelParam paramChannelParam)
  {
    if (paramChannelParam == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelParam{ ");
    localStringBuilder.append("guild_id:");
    localStringBuilder.append(paramChannelParam.guild_id.get());
    localStringBuilder.append(" channel_id:");
    localStringBuilder.append(paramChannelParam.channel_id.get());
    localStringBuilder.append(" begin_seq:");
    localStringBuilder.append(paramChannelParam.begin_seq.get());
    localStringBuilder.append(" end_seq:");
    localStringBuilder.append(paramChannelParam.end_seq.get());
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean) {
      this.b = false;
    }
    this.a.notifyUI(paramInt, paramBoolean, paramObject);
  }
  
  private void a(ArrayList<synclogic.ChannelParam> paramArrayList)
  {
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      synclogic.ChannelParam localChannelParam = (synclogic.ChannelParam)((Iterator)localObject).next();
      String str = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendReqInner:");
      localStringBuilder.append(a(localChannelParam));
      QLog.i(str, 1, localStringBuilder.toString());
    }
    localObject = new synclogic.MultiChannelMsgReq();
    ((synclogic.MultiChannelMsgReq)localObject).seq.set(this.f);
    ((synclogic.MultiChannelMsgReq)localObject).rpt_channel_params.set(paramArrayList);
    paramArrayList = this.a.createToServiceMsg("trpc.group_pro.synclogic.SyncLogic.GetMultiChannelMsg", null);
    paramArrayList.putWupBuffer(((synclogic.MultiChannelMsgReq)localObject).toByteArray());
    paramArrayList.extraData.putInt("registerProxyEndSeq", this.f);
    this.a.sendPbReq(paramArrayList);
    paramArrayList = c;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSend registerProxyEndSeq:");
    ((StringBuilder)localObject).append(this.f);
    QLog.i(paramArrayList, 1, ((StringBuilder)localObject).toString());
  }
  
  private void a(synclogic.MultiChannelMsg paramMultiChannelMsg)
  {
    if ((paramMultiChannelMsg.push_flag.has()) && (paramMultiChannelMsg.push_flag.get() == 1))
    {
      this.g = true;
      QLog.i(c, 1, "handlePushFlag end");
      d();
    }
  }
  
  private void a(synclogic.MultiChannelMsg paramMultiChannelMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramMultiChannelMsg = paramMultiChannelMsg.rpt_channel_msgs.get().iterator();
    while (paramMultiChannelMsg.hasNext())
    {
      Object localObject1 = (synclogic.ChannelMsg)paramMultiChannelMsg.next();
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putString("selfuin", paramFromServiceMsg.getUin());
      long l = this.a.a().a((synclogic.ChannelMsg)localObject1, (Bundle)localObject2);
      this.i.add(Long.valueOf(l));
      if (QLog.isColorLevel())
      {
        localObject1 = c;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleChannelMsg seq:");
        ((StringBuilder)localObject2).append(l);
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.b = true;
    if (paramBoolean) {
      this.f = Math.abs(new Random(System.currentTimeMillis()).nextInt());
    }
    this.h = System.currentTimeMillis();
    this.g = false;
    this.i.clear();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e(c, 1, "handleGetMultiChannelMsg data == null");
      a(GuildRegisterProxyObserver.d, false, new Object[] { Integer.valueOf(this.f), null });
      return;
    }
    paramToServiceMsg = new synclogic.MultiChannelMsgRsp();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      if (paramToServiceMsg.result.get() != 0)
      {
        paramFromServiceMsg = c;
        paramObject = new StringBuilder();
        paramObject.append("handleGetMultiChannelMsg errorCode:");
        paramObject.append(paramToServiceMsg.result.get());
        paramObject.append(" errormsg:");
        paramObject.append(paramToServiceMsg.err_msg.get());
        QLog.e(paramFromServiceMsg, 1, paramObject.toString());
        a(GuildRegisterProxyObserver.d, false, new Object[] { Integer.valueOf(this.f), null });
        return;
      }
      a(GuildRegisterProxyObserver.d, true, new Object[] { Integer.valueOf(this.f), paramToServiceMsg });
      QLog.i(c, 1, "handleGetMultiChannelMsg success");
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramFromServiceMsg = c;
      paramObject = new StringBuilder();
      paramObject.append("handleGetMultiChannelMsg mergeFrom error:");
      paramObject.append(paramToServiceMsg.getMessage());
      QLog.e(paramFromServiceMsg, 1, paramObject.toString());
      paramToServiceMsg.printStackTrace();
      a(GuildRegisterProxyObserver.d, false, new Object[] { Integer.valueOf(this.f), null });
    }
  }
  
  private boolean b(ArrayList<GuildPullMsgParam> paramArrayList)
  {
    Object localObject2 = (IGuildMsgSeqTimeService)this.d.getRuntimeService(IGuildMsgSeqTimeService.class, "");
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new HashMap();
    Object localObject3 = paramArrayList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      GuildPullMsgParam localGuildPullMsgParam = (GuildPullMsgParam)((Iterator)localObject3).next();
      paramArrayList = localGuildPullMsgParam.b.iterator();
      while (paramArrayList.hasNext())
      {
        GuildPullMsgParam.PullMsgChannelInfo localPullMsgChannelInfo = (GuildPullMsgParam.PullMsgChannelInfo)paramArrayList.next();
        IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = ((IGuildMsgSeqTimeService)localObject2).getLastLocallMsgSeq(String.valueOf(localPullMsgChannelInfo.a));
        if ((localPullMsgChannelInfo.b > 0L) && ((localPullMsgChannelInfo.b > localMsgSeqTimeItem.a) || (!localMsgSeqTimeItem.a())))
        {
          GuildRegisterProxyPullMsgProcesser.ChannelParamEx localChannelParamEx = new GuildRegisterProxyPullMsgProcesser.ChannelParamEx(this);
          localChannelParamEx.a = localPullMsgChannelInfo.c;
          localChannelParamEx.b.guild_id.set(localGuildPullMsgParam.a);
          localChannelParamEx.b.channel_id.set(localPullMsgChannelInfo.a);
          boolean bool = localMsgSeqTimeItem.a();
          long l = 1L;
          if (!bool)
          {
            if (localPullMsgChannelInfo.b >= 10L) {
              l = 1L + (localPullMsgChannelInfo.b - 10L);
            }
          }
          else
          {
            if (localPullMsgChannelInfo.b - localMsgSeqTimeItem.a >= 10L) {
              l = localPullMsgChannelInfo.b - 10L;
            } else {
              l = localMsgSeqTimeItem.a;
            }
            l += 1L;
          }
          localChannelParamEx.b.begin_seq.set(l);
          localChannelParamEx.b.end_seq.set(localPullMsgChannelInfo.b);
          if (!((HashMap)localObject1).containsKey(Long.valueOf(localGuildPullMsgParam.a))) {
            ((HashMap)localObject1).put(Long.valueOf(localGuildPullMsgParam.a), new ArrayList(Arrays.asList(new GuildRegisterProxyPullMsgProcesser.ChannelParamEx[] { localChannelParamEx })));
          } else {
            ((ArrayList)((HashMap)localObject1).get(Long.valueOf(localGuildPullMsgParam.a))).add(localChannelParamEx);
          }
        }
      }
    }
    paramArrayList = ((HashMap)localObject1).values().iterator();
    while (paramArrayList.hasNext()) {
      Collections.sort((ArrayList)paramArrayList.next(), this.j);
    }
    paramArrayList = new ArrayList();
    localObject2 = ((HashMap)localObject1).values().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (ArrayList)((Iterator)localObject2).next();
      if (((ArrayList)localObject3).size() > 0)
      {
        paramArrayList.add(((ArrayList)localObject3).get(0));
        ((ArrayList)localObject3).remove(0);
      }
    }
    Collections.sort(paramArrayList, this.j);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((GuildRegisterProxyPullMsgProcesser.ChannelParamEx)paramArrayList.next()).b);
    }
    paramArrayList = new ArrayList();
    localObject1 = ((HashMap)localObject1).values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ArrayList)((Iterator)localObject1).next();
      if (((ArrayList)localObject2).size() > 0) {
        paramArrayList.addAll((Collection)localObject2);
      }
    }
    Collections.sort(paramArrayList, this.j);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((GuildRegisterProxyPullMsgProcesser.ChannelParamEx)paramArrayList.next()).b);
    }
    if (localArrayList.size() > 0)
    {
      this.e = localArrayList;
      return true;
    }
    return false;
  }
  
  private ArrayList<synclogic.ChannelParam> c()
  {
    ArrayList localArrayList = new ArrayList();
    int k = 0;
    while ((k < this.e.size()) && (k < 100))
    {
      localArrayList.add(this.e.get(k));
      k += 1;
    }
    int m = 0;
    while (m < k)
    {
      this.e.remove(0);
      m += 1;
    }
    return localArrayList;
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e(c, 1, "handlePushChannelMsg data == null");
      a(GuildRegisterProxyObserver.e, false, new Object[] { Integer.valueOf(this.f), null });
      return;
    }
    paramToServiceMsg = new synclogic.MultiChannelMsg();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      this.h = System.currentTimeMillis();
      a(paramToServiceMsg, paramFromServiceMsg);
      a(paramToServiceMsg);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      paramFromServiceMsg = c;
      paramObject = new StringBuilder();
      paramObject.append("handlePushChannelMsg mergeFrom error:");
      paramObject.append(paramToServiceMsg.getMessage());
      QLog.e(paramFromServiceMsg, 1, paramObject.toString());
      paramToServiceMsg.printStackTrace();
      a(GuildRegisterProxyObserver.e, false, new Object[] { Integer.valueOf(this.f), null });
    }
  }
  
  private void d()
  {
    if ((this.g) && (this.i.size() == 0))
    {
      this.a.notifyUI(GuildRegisterProxyObserver.e, true, new Object[] { Integer.valueOf(this.f), null });
      QLog.i(c, 1, "handlePushChannelMsg once success");
      ArrayList localArrayList = c();
      if (localArrayList.size() > 0)
      {
        a(false);
        a(localArrayList);
        return;
      }
      this.b = false;
      QLog.i(c, 1, "handlePushChannelMsg all success");
    }
  }
  
  public void a()
  {
    if (this.a.a() != null) {
      this.a.a().b(this);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    try
    {
      boolean bool = paramObject instanceof Long;
      if (!bool) {
        return;
      }
      long l = ((Long)paramObject).longValue();
      if (this.i.contains(Long.valueOf(l)))
      {
        this.i.remove(Long.valueOf(l));
        if (QLog.isColorLevel())
        {
          paramObject = c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onNotifyg seq:");
          localStringBuilder.append(l);
          QLog.i(paramObject, 2, localStringBuilder.toString());
        }
        d();
      }
      return;
    }
    finally {}
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      if ("trpc.group_pro.synclogic.SyncLogic.GetMultiChannelMsg".equals(paramFromServiceMsg.getServiceCmd())) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      } else if ("trpc.group_pro.synclogic.SyncLogic.PushChannelMsg".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    finally {}
  }
  
  public boolean a(Object paramObject)
  {
    try
    {
      if ((this.b) && (System.currentTimeMillis() - this.h < 30000L))
      {
        paramObject = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSend processerIng:true sengBeginTime:");
        localStringBuilder.append(this.h);
        QLog.i(paramObject, 1, localStringBuilder.toString());
        return false;
      }
      if (((paramObject instanceof ArrayList)) && (((ArrayList)paramObject).size() != 0))
      {
        boolean bool = b((ArrayList)paramObject);
        if (!bool) {
          return false;
        }
        paramObject = c();
        a(true);
        a(paramObject);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public int b()
  {
    try
    {
      int k = this.f;
      return k;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyPullMsgProcesser
 * JD-Core Version:    0.7.0.1
 */