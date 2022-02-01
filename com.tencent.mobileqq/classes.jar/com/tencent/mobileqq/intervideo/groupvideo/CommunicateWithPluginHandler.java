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
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new CommunicateWithPluginHandler.2(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PushMessageDelegate jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanPushMessageDelegate = new CommunicateWithPluginHandler.1(this);
  private List<OnOpenCloseRoomCallback> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<OnOpenCloseRoomCallback> b = new ArrayList();
  
  private Intent a()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.gvideo.message.communicate.qq2gvideo");
    return localIntent;
  }
  
  private void a(Intent paramIntent)
  {
    WatchTogetherManager localWatchTogetherManager = (WatchTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WATCH_LIVE_TOGETHER);
    NewTogetherRoomMessageData localNewTogetherRoomMessageData = new NewTogetherRoomMessageData();
    localNewTogetherRoomMessageData.b = paramIntent.getStringExtra("closeRoomGroupOwnerUin");
    localNewTogetherRoomMessageData.a = paramIntent.getStringExtra("closeRoomGroupUin");
    localWatchTogetherManager.a(paramIntent.getStringExtra("closeRoomFrom"), localNewTogetherRoomMessageData);
  }
  
  private void a(Intent paramIntent, List<OnOpenCloseRoomCallback> paramList)
  {
    int i;
    String str;
    StringBuilder localStringBuilder;
    if (!paramList.isEmpty())
    {
      i = paramIntent.getIntExtra("callback_return_code", 0);
      str = paramIntent.getStringExtra("callback_return_message");
      paramIntent = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramIntent.hasNext()) {
        ((OnOpenCloseRoomCallback)paramIntent.next()).a(i, str);
      }
      localStringBuilder = new StringBuilder().append("receive ");
      if (paramList != this.jdField_a_of_type_JavaUtilList) {
        break label130;
      }
    }
    label130:
    for (paramIntent = "close";; paramIntent = "open")
    {
      QLog.i("GroupVideoManager|Communicate", 2, paramIntent + " room message " + i + " " + str);
      paramList.clear();
      return;
    }
  }
  
  private void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, int paramInt)
  {
    Intent localIntent = a();
    localIntent.putExtra("command_type", paramInt);
    localIntent.putExtra("togetherRoomMessageData", paramNewTogetherRoomMessageData);
    b(localIntent);
  }
  
  private void b()
  {
    Object localObject = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    if ((localObject != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
    {
      localObject = ((TicketManager)localObject).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      Intent localIntent = a();
      localIntent.putExtra("command_type", 6);
      localIntent.putExtra("sKeyKey", (String)localObject);
      b(localIntent);
      return;
    }
    QLog.e("GroupVideoManager|Communicate", 1, "get skey error");
  }
  
  private void b(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramIntent);
  }
  
  public PushMessageDelegate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanPushMessageDelegate;
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.b.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  void a(Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    Intent localIntent = a();
    localIntent.putExtra("command_type", 4);
    localIntent.putExtra("closeRoomBundle", paramBundle);
    b(localIntent);
    this.jdField_a_of_type_JavaUtilList.add(paramOnOpenCloseRoomCallback);
  }
  
  void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("com.tencent.gvideo.message.communicate.gvideo2qq");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramQQAppInterface);
  }
  
  void a(OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    this.b.add(paramOnOpenCloseRoomCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.CommunicateWithPluginHandler
 * JD-Core Version:    0.7.0.1
 */