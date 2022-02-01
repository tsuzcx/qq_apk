package com.tencent.mobileqq.guild.mainframe.container.discover.handler;

import android.util.SparseArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.group_pro_proto.oidb0xf9c.common.Category;
import tencent.im.group_pro_proto.oidb0xf9c.common.Guild;
import tencent.im.group_pro_proto.oidb0xf9c.common.Guilds;
import tencent.im.group_pro_proto.oidb0xf9c.discovery.Reply;
import tencent.im.group_pro_proto.oidb0xf9c.discovery.Request;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QQGuildDiscoverHandler
  extends BusinessHandler
{
  protected QQGuildDiscoverHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a()
  {
    QQGuildDiscoverDataCenter.a.clear();
    QQGuildDiscoverDataCenter.b.clear();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildDiscover.QQGuildDiscoverHandler", 2, String.format("getDiscoverListData categoryId=%s ", new Object[] { Integer.valueOf(paramInt) }));
    }
    discovery.Request localRequest = new discovery.Request();
    localRequest.category_id.set(paramInt);
    sendPbReq(makeOIDBPkg("OidbSvcTrpcTcp.0xf9c", 3996, 1, localRequest.toByteArray()));
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label394;
        }
        i = 1;
        if (i != 0)
        {
          paramToServiceMsg = new discovery.Reply();
          paramToServiceMsg.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          try
          {
            if (paramToServiceMsg.categories.has())
            {
              paramFromServiceMsg = new ArrayList();
              paramObject = paramToServiceMsg.categories.get().iterator();
              if (paramObject.hasNext())
              {
                paramFromServiceMsg.add(DiscoverCategoryBean.a((common.Category)paramObject.next()));
                continue;
              }
              QQGuildDiscoverDataCenter.a.clear();
              QQGuildDiscoverDataCenter.a.addAll(paramFromServiceMsg);
            }
            if ((paramToServiceMsg.guilds.has()) && (paramToServiceMsg.guilds.guilds.has()))
            {
              i = paramToServiceMsg.guilds.category_id.get();
              paramFromServiceMsg = new ArrayList();
              paramToServiceMsg = paramToServiceMsg.guilds.guilds.get().iterator();
              if (paramToServiceMsg.hasNext())
              {
                paramFromServiceMsg.add(DiscoverGuildBean.a((common.Guild)paramToServiceMsg.next()));
                continue;
              }
              QQGuildDiscoverDataCenter.b.put(i, paramFromServiceMsg);
            }
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("handleReplyDiscoverListData result data:");
              paramToServiceMsg.append(QQGuildDiscoverDataCenter.c());
              QLog.d("GuildDiscover.QQGuildDiscoverHandler", 2, paramToServiceMsg.toString());
            }
            notifyUI(1, true, null);
            bool = true;
          }
          catch (Exception paramToServiceMsg)
          {
            bool = true;
            continue;
          }
        }
        else
        {
          a();
          notifyUI(1, false, null);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool = false;
        a();
        QLog.e("GuildDiscover.QQGuildDiscoverHandler", 1, "handleReplyDiscoverListData fail.", paramToServiceMsg);
        notifyUI(1, false, null);
        break label364;
      }
      a();
      notifyUI(1, false, null);
      boolean bool = false;
      label364:
      if (QLog.isColorLevel()) {
        QLog.d("GuildDiscover.QQGuildDiscoverHandler", 2, String.format("handleReplyDiscoverListData success=%s", new Object[] { Boolean.valueOf(bool) }));
      }
      return;
      label394:
      int i = 0;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvcTrpcTcp.0xf9c");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QQGuildDiscoverObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("OidbSvcTrpcTcp.0xf9c".equals(paramToServiceMsg.getServiceCmd())) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverHandler
 * JD-Core Version:    0.7.0.1
 */