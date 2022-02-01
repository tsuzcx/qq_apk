package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class MessengerService$IncomingHandler$7
  implements Runnable
{
  MessengerService$IncomingHandler$7(MessengerService.IncomingHandler paramIncomingHandler, QQAppInterface paramQQAppInterface, ArrayList paramArrayList, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    HashMap localHashMap = new HashMap();
    FriendsManager localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Friends localFriends = localFriendsManager.m(str);
        if (localFriends != null)
        {
          if (!TextUtils.isEmpty(localFriends.remark)) {
            localHashMap.put(str, localFriends.remark);
          } else if (!TextUtils.isEmpty(localFriends.name)) {
            localHashMap.put(str, localFriends.name);
          } else {
            localHashMap.put(str, "");
          }
        }
        else {
          localHashMap.put(str, "");
        }
      }
    }
    localBundle.putSerializable("friendsMap", localHashMap);
    this.c.putBundle("response", localBundle);
    this.d.a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.7
 * JD-Core Version:    0.7.0.1
 */