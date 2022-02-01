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
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

public class QQReminderServlet
  extends MSFServlet
{
  private static final String a = "QQReminderServlet";
  
  public static AcsHead a(AppRuntime paramAppRuntime)
  {
    AcsHead localAcsHead = new AcsHead();
    localAcsHead.model = Build.MODEL;
    localAcsHead.platform = "Android";
    localAcsHead.version = QQReminderUtil.a(paramAppRuntime);
    return localAcsHead;
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      AcsBatchSubNoticeRsp localAcsBatchSubNoticeRsp = (AcsBatchSubNoticeRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsBatchSubNoticeRsp());
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      if (localAcsBatchSubNoticeRsp != null)
      {
        localBundle.putSerializable("rsp", localAcsBatchSubNoticeRsp);
        notifyObserver(paramIntent, 2007, paramFromServiceMsg.isSuccess(), localBundle, null);
        return;
      }
      notifyObserver(paramIntent, 2007, false, localBundle, null);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      label81:
      break label81;
    }
    notifyObserver(paramIntent, 2007, false, localBundle, null);
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
  
  private void b(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      AcsQueryRsp localAcsQueryRsp = (AcsQueryRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsQueryRsp());
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      if (localAcsQueryRsp != null)
      {
        localBundle.putSerializable("rsp", localAcsQueryRsp);
        notifyObserver(paramIntent, 2006, paramFromServiceMsg.isSuccess(), localBundle, null);
        return;
      }
      notifyObserver(paramIntent, 2006, false, localBundle, null);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      label81:
      break label81;
    }
    notifyObserver(paramIntent, 2006, false, localBundle, null);
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
  
  private void c(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      AcsGetMsgRsp localAcsGetMsgRsp = (AcsGetMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsGetMsgRsp());
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      if (localAcsGetMsgRsp != null)
      {
        localBundle.putSerializable("rsp", localAcsGetMsgRsp);
        notifyObserver(paramIntent, 2005, paramFromServiceMsg.isSuccess(), localBundle, null);
        return;
      }
      notifyObserver(paramIntent, 2005, false, localBundle, null);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      label81:
      break label81;
    }
    notifyObserver(paramIntent, 2005, false, localBundle, null);
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
  
  private void d(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      AcsAckMsgRsp localAcsAckMsgRsp = (AcsAckMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsAckMsgRsp());
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      if (localAcsAckMsgRsp != null)
      {
        localBundle.putSerializable("rsp", localAcsAckMsgRsp);
        notifyObserver(paramIntent, 2004, paramFromServiceMsg.isSuccess(), localBundle, null);
        return;
      }
      notifyObserver(paramIntent, 2004, false, localBundle, null);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      label81:
      break label81;
    }
    notifyObserver(paramIntent, 2004, false, localBundle, null);
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
  
  private void e(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      AcsPullMsgRsp localAcsPullMsgRsp = (AcsPullMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsPullMsgRsp());
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      if (localAcsPullMsgRsp != null)
      {
        localBundle.putSerializable("rsp", localAcsPullMsgRsp);
        notifyObserver(paramIntent, 2003, paramFromServiceMsg.isSuccess(), localBundle, null);
        return;
      }
      notifyObserver(paramIntent, 2003, false, localBundle, null);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      label81:
      break label81;
    }
    notifyObserver(paramIntent, 2003, false, localBundle, null);
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
  
  private void f(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      AcsSubNoticeRsp localAcsSubNoticeRsp = (AcsSubNoticeRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsSubNoticeRsp());
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      if (localAcsSubNoticeRsp != null)
      {
        localBundle.putSerializable("rsp", localAcsSubNoticeRsp);
        notifyObserver(paramIntent, 2002, paramFromServiceMsg.isSuccess(), localBundle, null);
        return;
      }
      notifyObserver(paramIntent, 2002, false, localBundle, null);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      label81:
      break label81;
    }
    notifyObserver(paramIntent, 2002, false, localBundle, null);
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
  
  private void g(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      AcsDelMsgRsp localAcsDelMsgRsp = (AcsDelMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsDelMsgRsp());
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      if (localAcsDelMsgRsp != null)
      {
        localBundle.putSerializable("rsp", localAcsDelMsgRsp);
        notifyObserver(paramIntent, 2001, paramFromServiceMsg.isSuccess(), localBundle, null);
        return;
      }
      notifyObserver(paramIntent, 2001, false, localBundle, null);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      label81:
      break label81;
    }
    notifyObserver(paramIntent, 2001, false, localBundle, null);
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
  
  private void h(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    try
    {
      AcsGetMsgListRsp localAcsGetMsgListRsp = (AcsGetMsgListRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsGetMsgListRsp());
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      if (localAcsGetMsgListRsp != null)
      {
        localBundle.putSerializable("rsp", localAcsGetMsgListRsp);
        notifyObserver(paramIntent, 2000, paramFromServiceMsg.isSuccess(), localBundle, null);
        return;
      }
      notifyObserver(paramIntent, 2000, false, localBundle, null);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
      localBundle.putSerializable("req", paramIntent.getSerializableExtra("req"));
      notifyObserver(paramIntent, 2000, false, localBundle, null);
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
    if (paramIntent.getIntExtra("param_req_type", 0) == 0)
    {
      super.notifyObserver(paramIntent, paramInt, paramBoolean, paramBundle, paramClass);
      return;
    }
    if ((paramIntent instanceof NewIntent))
    {
      paramIntent = ((NewIntent)paramIntent).getObserver();
      if (paramIntent != null) {
        ThreadManagerV2.executeOnSubThread(new QQReminderServlet.1(this, paramIntent, paramInt, paramBoolean, paramBundle));
      }
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    String str1 = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      String str2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cmd: ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" ");
      QLog.i(str2, 2, localStringBuilder.toString());
    }
    if (str1 == null) {
      return;
    }
    if (str1.equals("NoticeSvr.GetMsgList"))
    {
      h(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str1.equals("NoticeSvr.DelMsg"))
    {
      g(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str1.equals("NoticeSvr.SubNotice"))
    {
      f(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str1.equals("NoticeSvr.PullMsg"))
    {
      e(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str1.equals("NoticeSvr.AckMsg"))
    {
      d(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str1.equals("NoticeSvr.GetMsg"))
    {
      c(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str1.equals("NoticeSvr.Query"))
    {
      b(paramIntent, paramFromServiceMsg);
      return;
    }
    if (str1.equals("NoticeSvr.BatchSubNotice")) {
      a(paramIntent, paramFromServiceMsg);
    }
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
    case 2007: 
      b(paramIntent, paramPacket);
      return;
    case 2006: 
      h(paramIntent, paramPacket);
      return;
    case 2005: 
      g(paramIntent, paramPacket);
      return;
    case 2004: 
      f(paramIntent, paramPacket);
      return;
    case 2003: 
      e(paramIntent, paramPacket);
      return;
    case 2002: 
      d(paramIntent, paramPacket);
      return;
    case 2001: 
      a(paramIntent, paramPacket);
      return;
    }
    c(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.biz.QQReminderServlet
 * JD-Core Version:    0.7.0.1
 */