package com.tencent.mobileqq.reminder.api.impl;

import Wallet.AcsAckMsgReq;
import Wallet.AcsBatchSubNoticeReq;
import Wallet.AcsDelMsgReq;
import Wallet.AcsGetMsgListReq;
import Wallet.AcsGetMsgReq;
import Wallet.AcsPullMsgReq;
import Wallet.AcsQueryReq;
import Wallet.AcsSubNoticeReq;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.QQReminderServlet;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class QQReminderServiceImpl
  implements IQQReminderService
{
  private AppRuntime mAppRuntime;
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mAppRuntime = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void queryNotifyIsSubscribed(String paramString, BusinessObserver paramBusinessObserver)
  {
    if (this.mAppRuntime == null) {
      return;
    }
    AcsQueryReq localAcsQueryReq = new AcsQueryReq();
    localAcsQueryReq.head = QQReminderServlet.a(this.mAppRuntime);
    localAcsQueryReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
    localAcsQueryReq.msg_id = paramString;
    paramString = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
    paramString.putExtra("account", this.mAppRuntime.getAccount());
    paramString.putExtra("req", localAcsQueryReq);
    paramString.putExtra("param_req_type", 2006);
    paramString.setObserver(paramBusinessObserver);
    this.mAppRuntime.startServlet(paramString);
  }
  
  public void sendAckMsgs(ArrayList<String> paramArrayList, BusinessObserver paramBusinessObserver)
  {
    if (this.mAppRuntime == null) {
      return;
    }
    AcsAckMsgReq localAcsAckMsgReq = new AcsAckMsgReq();
    localAcsAckMsgReq.head = QQReminderServlet.a(this.mAppRuntime);
    localAcsAckMsgReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
    localAcsAckMsgReq.msg_id_list = paramArrayList;
    paramArrayList = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
    paramArrayList.putExtra("account", this.mAppRuntime.getAccount());
    paramArrayList.putExtra("req", localAcsAckMsgReq);
    paramArrayList.putExtra("param_req_type", 2004);
    paramArrayList.setObserver(paramBusinessObserver);
    this.mAppRuntime.startServlet(paramArrayList);
  }
  
  public void sendBatchSubscribeReminder(ArrayList<String> paramArrayList, String paramString, BusinessObserver paramBusinessObserver)
  {
    if (this.mAppRuntime == null) {
      return;
    }
    AcsBatchSubNoticeReq localAcsBatchSubNoticeReq = new AcsBatchSubNoticeReq();
    localAcsBatchSubNoticeReq.domain = paramString;
    localAcsBatchSubNoticeReq.msg_id_list = new ArrayList();
    localAcsBatchSubNoticeReq.msg_id_list.addAll(paramArrayList);
    localAcsBatchSubNoticeReq.head = QQReminderServlet.a(this.mAppRuntime);
    paramArrayList = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
    paramArrayList.putExtra("account", this.mAppRuntime.getAccount());
    paramArrayList.putExtra("req", localAcsBatchSubNoticeReq);
    paramArrayList.putExtra("param_req_type", 2007);
    paramArrayList.setObserver(paramBusinessObserver);
    this.mAppRuntime.startServlet(paramArrayList);
  }
  
  public void sendDelReminderListById(String paramString, long paramLong, int paramInt, BusinessObserver paramBusinessObserver)
  {
    if (this.mAppRuntime == null) {
      return;
    }
    AcsDelMsgReq localAcsDelMsgReq = new AcsDelMsgReq();
    localAcsDelMsgReq.head = QQReminderServlet.a(this.mAppRuntime);
    localAcsDelMsgReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
    localAcsDelMsgReq.msg_id = paramString;
    localAcsDelMsgReq.mn_appid = paramLong;
    localAcsDelMsgReq.source = paramInt;
    paramString = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
    paramString.putExtra("account", this.mAppRuntime.getAccount());
    paramString.putExtra("req", localAcsDelMsgReq);
    paramString.putExtra("param_req_type", 2001);
    paramString.setObserver(paramBusinessObserver);
    this.mAppRuntime.startServlet(paramString);
  }
  
  public void sendGetMsgs(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    if (this.mAppRuntime == null) {
      return;
    }
    AcsGetMsgReq localAcsGetMsgReq = new AcsGetMsgReq();
    localAcsGetMsgReq.head = QQReminderServlet.a(this.mAppRuntime);
    localAcsGetMsgReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
    localAcsGetMsgReq.msg_id = paramString1;
    localAcsGetMsgReq.domain = paramString2;
    paramString1 = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
    paramString1.putExtra("account", this.mAppRuntime.getAccount());
    paramString1.putExtra("req", localAcsGetMsgReq);
    paramString1.putExtra("param_req_type", 2005);
    paramString1.setObserver(paramBusinessObserver);
    this.mAppRuntime.startServlet(paramString1);
  }
  
  public void sendReminderList(int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if (this.mAppRuntime == null) {
      return;
    }
    AcsGetMsgListReq localAcsGetMsgListReq = new AcsGetMsgListReq();
    localAcsGetMsgListReq.head = QQReminderServlet.a(this.mAppRuntime);
    localAcsGetMsgListReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
    localAcsGetMsgListReq.record_start = paramInt1;
    localAcsGetMsgListReq.record_size = paramInt2;
    NewIntent localNewIntent = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
    localNewIntent.putExtra("account", this.mAppRuntime.getAccount());
    localNewIntent.putExtra("req", localAcsGetMsgListReq);
    localNewIntent.putExtra("param_req_type", 2000);
    localNewIntent.setObserver(paramBusinessObserver);
    this.mAppRuntime.startServlet(localNewIntent);
  }
  
  public void sendReminderListByDay(String paramString, BusinessObserver paramBusinessObserver)
  {
    if (this.mAppRuntime == null) {
      return;
    }
    AcsPullMsgReq localAcsPullMsgReq = new AcsPullMsgReq();
    localAcsPullMsgReq.head = QQReminderServlet.a(this.mAppRuntime);
    localAcsPullMsgReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
    localAcsPullMsgReq.day = paramString;
    paramString = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
    paramString.putExtra("account", this.mAppRuntime.getAccount());
    paramString.putExtra("req", localAcsPullMsgReq);
    paramString.putExtra("param_req_type", 2003);
    paramString.setObserver(paramBusinessObserver);
    this.mAppRuntime.startServlet(paramString);
  }
  
  public void sendSubscribeReminder(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    if (this.mAppRuntime == null) {
      return;
    }
    AcsSubNoticeReq localAcsSubNoticeReq = new AcsSubNoticeReq();
    localAcsSubNoticeReq.head = QQReminderServlet.a(this.mAppRuntime);
    localAcsSubNoticeReq.uin = Long.parseLong(this.mAppRuntime.getAccount());
    localAcsSubNoticeReq.msg_id = paramString1;
    localAcsSubNoticeReq.domain = paramString2;
    paramString1 = new NewIntent(this.mAppRuntime.getApplicationContext(), QQReminderServlet.class);
    paramString1.putExtra("account", this.mAppRuntime.getAccount());
    paramString1.putExtra("req", localAcsSubNoticeReq);
    paramString1.putExtra("param_req_type", 2002);
    paramString1.setObserver(paramBusinessObserver);
    this.mAppRuntime.startServlet(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.impl.QQReminderServiceImpl
 * JD-Core Version:    0.7.0.1
 */