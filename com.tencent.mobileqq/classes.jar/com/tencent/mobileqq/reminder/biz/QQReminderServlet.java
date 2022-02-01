package com.tencent.mobileqq.reminder.biz;

import Wallet.AcsAckMsgReq;
import Wallet.AcsAckMsgRsp;
import Wallet.AcsBatchSubNoticeReq;
import Wallet.AcsBatchSubNoticeRsp;
import Wallet.AcsDelMsgReq;
import Wallet.AcsDelMsgRsp;
import Wallet.AcsGetMsgListReq;
import Wallet.AcsGetMsgListRsp;
import Wallet.AcsGetMsgReq;
import Wallet.AcsGetMsgRsp;
import Wallet.AcsHead;
import Wallet.AcsPullMsgReq;
import Wallet.AcsPullMsgRsp;
import Wallet.AcsQueryReq;
import Wallet.AcsQueryRsp;
import Wallet.AcsSubNoticeReq;
import Wallet.AcsSubNoticeRsp;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.reminder.util.QQReminderUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

public class QQReminderServlet
  extends MSFServlet
{
  private static final String a = QQReminderServlet.class.getSimpleName();
  
  public static AcsHead a(AppRuntime paramAppRuntime)
  {
    AcsHead localAcsHead = new AcsHead();
    localAcsHead.model = Build.MODEL;
    localAcsHead.platform = "Android";
    localAcsHead.version = QQReminderUtil.a(paramAppRuntime);
    return localAcsHead;
  }
  
  private void a(Bundle paramBundle, Packet paramPacket)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramBundle.getString("account"), "NoticeSvr.DelMsg");
    paramBundle = (AcsDelMsgReq)paramBundle.getSerializable("req");
    paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
    paramPacket.setFuncName("DelMsg");
    paramPacket.addRequestPacket("req", paramBundle);
    paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
    paramPacket.setTimeout(15000L);
    if (!localToServiceMsg.isNeedCallback()) {
      paramPacket.setNoResponse();
    }
  }
  
  private void b(Bundle paramBundle, Packet paramPacket)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramBundle.getString("account"), "NoticeSvr.BatchSubNotice");
    paramBundle = (AcsBatchSubNoticeReq)paramBundle.getSerializable("req");
    paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
    paramPacket.setFuncName("BatchSubNotice");
    paramPacket.addRequestPacket("req", paramBundle);
    paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
    paramPacket.setTimeout(15000L);
    if (!localToServiceMsg.isNeedCallback()) {
      paramPacket.setNoResponse();
    }
  }
  
  private void c(Bundle paramBundle, Packet paramPacket)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramBundle.getString("account"), "NoticeSvr.GetMsgList");
    paramBundle = (AcsGetMsgListReq)paramBundle.getSerializable("req");
    paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
    paramPacket.setFuncName("GetMsgList");
    paramPacket.addRequestPacket("req", paramBundle);
    paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
    paramPacket.setTimeout(15000L);
    if (!localToServiceMsg.isNeedCallback()) {
      paramPacket.setNoResponse();
    }
  }
  
  private void d(Bundle paramBundle, Packet paramPacket)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramBundle.getString("account"), "NoticeSvr.SubNotice");
    paramBundle = (AcsSubNoticeReq)paramBundle.getSerializable("req");
    paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
    paramPacket.setFuncName("SubNotice");
    paramPacket.addRequestPacket("req", paramBundle);
    paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
    paramPacket.setTimeout(15000L);
    if (!localToServiceMsg.isNeedCallback()) {
      paramPacket.setNoResponse();
    }
  }
  
  private void e(Bundle paramBundle, Packet paramPacket)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramBundle.getString("account"), "NoticeSvr.PullMsg");
    paramBundle = (AcsPullMsgReq)paramBundle.getSerializable("req");
    paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
    paramPacket.setFuncName("PullMsg");
    paramPacket.addRequestPacket("req", paramBundle);
    paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
    paramPacket.setTimeout(15000L);
    if (!localToServiceMsg.isNeedCallback()) {
      paramPacket.setNoResponse();
    }
  }
  
  private void f(Bundle paramBundle, Packet paramPacket)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramBundle.getString("account"), "NoticeSvr.AckMsg");
    paramBundle = (AcsAckMsgReq)paramBundle.getSerializable("req");
    paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
    paramPacket.setFuncName("AckMsg");
    paramPacket.addRequestPacket("req", paramBundle);
    paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
    paramPacket.setTimeout(15000L);
    if (!localToServiceMsg.isNeedCallback()) {
      paramPacket.setNoResponse();
    }
  }
  
  private void g(Bundle paramBundle, Packet paramPacket)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramBundle.getString("account"), "NoticeSvr.GetMsg");
    paramBundle = (AcsGetMsgReq)paramBundle.getSerializable("req");
    paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
    paramPacket.setFuncName("GetMsg");
    paramPacket.addRequestPacket("req", paramBundle);
    paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
    paramPacket.setTimeout(15000L);
    if (!localToServiceMsg.isNeedCallback()) {
      paramPacket.setNoResponse();
    }
  }
  
  private void h(Bundle paramBundle, Packet paramPacket)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramBundle.getString("account"), "NoticeSvr.Query");
    paramBundle = (AcsQueryReq)paramBundle.getSerializable("req");
    paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
    paramPacket.setFuncName("Query");
    paramPacket.addRequestPacket("req", paramBundle);
    paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
    paramPacket.setTimeout(15000L);
    if (!localToServiceMsg.isNeedCallback()) {
      paramPacket.setNoResponse();
    }
  }
  
  public void notifyObserver(Intent paramIntent, int paramInt, boolean paramBoolean, Bundle paramBundle, Class<? extends BusinessObserver> paramClass)
  {
    if (paramIntent.getIntExtra("param_req_type", 0) == 0) {
      super.notifyObserver(paramIntent, paramInt, paramBoolean, paramBundle, paramClass);
    }
    do
    {
      do
      {
        return;
      } while (!(paramIntent instanceof NewIntent));
      paramIntent = ((NewIntent)paramIntent).getObserver();
    } while (paramIntent == null);
    ThreadManagerV2.executeOnSubThread(new QQReminderServlet.1(this, paramIntent, paramInt, paramBoolean, paramBundle));
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "cmd: " + (String)localObject1 + " ");
    }
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      return;
      if (((String)localObject1).equals("NoticeSvr.GetMsgList"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsGetMsgListRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsGetMsgListRsp());
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          if (localObject2 != null)
          {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
            notifyObserver(paramIntent, 2000, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
            return;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2000, false, (Bundle)localObject1, null);
          return;
        }
        notifyObserver(paramIntent, 2000, false, (Bundle)localObject1, null);
        return;
      }
      if (((String)localObject1).equals("NoticeSvr.DelMsg"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsDelMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsDelMsgRsp());
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          if (localObject2 != null)
          {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
            notifyObserver(paramIntent, 2001, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
            return;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2001, false, (Bundle)localObject1, null);
          return;
        }
        notifyObserver(paramIntent, 2001, false, (Bundle)localObject1, null);
        return;
      }
      if (((String)localObject1).equals("NoticeSvr.SubNotice"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsSubNoticeRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsSubNoticeRsp());
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          if (localObject2 != null)
          {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
            notifyObserver(paramIntent, 2002, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
            return;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2002, false, (Bundle)localObject1, null);
          return;
        }
        notifyObserver(paramIntent, 2002, false, (Bundle)localObject1, null);
        return;
      }
      if (((String)localObject1).equals("NoticeSvr.PullMsg"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsPullMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsPullMsgRsp());
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          if (localObject2 != null)
          {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
            notifyObserver(paramIntent, 2003, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
            return;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2003, false, (Bundle)localObject1, null);
          return;
        }
        notifyObserver(paramIntent, 2003, false, (Bundle)localObject1, null);
        return;
      }
      if (((String)localObject1).equals("NoticeSvr.AckMsg"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsAckMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsAckMsgRsp());
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          if (localObject2 != null)
          {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
            notifyObserver(paramIntent, 2004, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
            return;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2004, false, (Bundle)localObject1, null);
          return;
        }
        notifyObserver(paramIntent, 2004, false, (Bundle)localObject1, null);
        return;
      }
      if (((String)localObject1).equals("NoticeSvr.GetMsg"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsGetMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsGetMsgRsp());
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          if (localObject2 != null)
          {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
            notifyObserver(paramIntent, 2005, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
            return;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2005, false, (Bundle)localObject1, null);
          return;
        }
        notifyObserver(paramIntent, 2005, false, (Bundle)localObject1, null);
        return;
      }
      if (((String)localObject1).equals("NoticeSvr.Query"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsQueryRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsQueryRsp());
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          if (localObject2 != null)
          {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
            notifyObserver(paramIntent, 2006, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
            return;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2006, false, (Bundle)localObject1, null);
          return;
        }
        notifyObserver(paramIntent, 2006, false, (Bundle)localObject1, null);
        return;
      }
    } while (!((String)localObject1).equals("NoticeSvr.BatchSubNotice"));
    localObject1 = new Bundle();
    try
    {
      localObject2 = (AcsBatchSubNoticeRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsBatchSubNoticeRsp());
      ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
      if (localObject2 != null)
      {
        ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
        notifyObserver(paramIntent, 2007, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
        return;
      }
    }
    catch (Exception paramFromServiceMsg)
    {
      notifyObserver(paramIntent, 2007, false, (Bundle)localObject1, null);
      return;
    }
    notifyObserver(paramIntent, 2007, false, (Bundle)localObject1, null);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null) {
      return;
    }
    switch (paramIntent.getInt("param_req_type", 0))
    {
    default: 
      return;
    case 2000: 
      c(paramIntent, paramPacket);
      return;
    case 2001: 
      a(paramIntent, paramPacket);
      return;
    case 2002: 
      d(paramIntent, paramPacket);
      return;
    case 2003: 
      e(paramIntent, paramPacket);
      return;
    case 2004: 
      f(paramIntent, paramPacket);
      return;
    case 2005: 
      g(paramIntent, paramPacket);
      return;
    case 2006: 
      h(paramIntent, paramPacket);
      return;
    }
    b(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.biz.QQReminderServlet
 * JD-Core Version:    0.7.0.1
 */