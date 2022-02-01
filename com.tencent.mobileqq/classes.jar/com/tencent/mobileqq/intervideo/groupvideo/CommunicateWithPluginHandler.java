package com.tencent.mobileqq.intervideo.groupvideo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.OnOpenCloseRoomCallback;
import com.tencent.mobileqq.intervideo.yiqikan.PushMessageDelegate;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.TicketManager;

class CommunicateWithPluginHandler
{
  private QQAppInterface a;
  private PushMessageDelegate b = new CommunicateWithPluginHandler.1(this);
  private BroadcastReceiver c = new CommunicateWithPluginHandler.2(this);
  private List<OnOpenCloseRoomCallback> d = new ArrayList();
  private List<OnOpenCloseRoomCallback> e = new ArrayList();
  
  private void a(Intent paramIntent)
  {
    WatchTogetherManager localWatchTogetherManager = (WatchTogetherManager)this.a.getManager(QQManagerFactory.WATCH_LIVE_TOGETHER);
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
    localNewTogetherRoomMessageData.b = paramIntent.getStringExtra("closeRoomGroupOwnerUin");
    localNewTogetherRoomMessageData.a = paramIntent.getStringExtra("closeRoomGroupUin");
    localWatchTogetherManager.a(paramIntent.getStringExtra("closeRoomFrom"), localNewTogetherRoomMessageData);
  }
  
  private void a(Intent paramIntent, List<OnOpenCloseRoomCallback> paramList)
  {
    if (!paramList.isEmpty())
    {
      int i = paramIntent.getIntExtra("callback_return_code", 0);
      String str = paramIntent.getStringExtra("callback_return_message");
      paramIntent = this.d.iterator();
      while (paramIntent.hasNext()) {
        ((OnOpenCloseRoomCallback)paramIntent.next()).a(i, str);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive ");
      if (paramList == this.d) {
        paramIntent = "close";
      } else {
        paramIntent = "open";
      }
      localStringBuilder.append(paramIntent);
      localStringBuilder.append(" room message ");
      localStringBuilder.append(i);
      localStringBuilder.append(" ");
      localStringBuilder.append(str);
      QLog.i("GroupVideoManager|Communicate", 2, localStringBuilder.toString());
      paramList.clear();
    }
  }
  
  private void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, int paramInt)
  {
    Intent localIntent = c();
    localIntent.putExtra("command_type", paramInt);
    localIntent.putExtra("togetherRoomMessageData", paramNewTogetherRoomMessageData);
    b(localIntent);
  }
  
  private void b(Intent paramIntent)
  {
    this.a.getApp().sendBroadcast(paramIntent);
  }
  
  private Intent c()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.gvideo.message.communicate.qq2gvideo");
    return localIntent;
  }
  
  private void d()
  {
    Object localObject = (TicketManager)this.a.getManager(2);
    if ((localObject != null) && (!TextUtils.isEmpty(this.a.getAccount())))
    {
      localObject = ((TicketManager)localObject).getSkey(this.a.getAccount());
      Intent localIntent = c();
      localIntent.putExtra("command_type", 6);
      localIntent.putExtra("sKeyKey", (String)localObject);
      b(localIntent);
      return;
    }
    QLog.e("GroupVideoManager|Communicate", 1, "get skey error");
  }
  
  void a()
  {
    this.a.getApp().unregisterReceiver(this.c);
    this.e.clear();
    this.d.clear();
    this.a = null;
  }
  
  void a(Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    Intent localIntent = c();
    localIntent.putExtra("command_type", 4);
    localIntent.putExtra("closeRoomBundle", paramBundle);
    b(localIntent);
    this.d.add(paramOnOpenCloseRoomCallback);
  }
  
  void a(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("com.tencent.gvideo.message.communicate.gvideo2qq");
    this.a.getApp().registerReceiver(this.c, paramQQAppInterface);
  }
  
  void a(OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    this.e.add(paramOnOpenCloseRoomCallback);
  }
  
  public PushMessageDelegate b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.CommunicateWithPluginHandler
 * JD-Core Version:    0.7.0.1
 */