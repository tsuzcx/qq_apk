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

class MessengerService$IncomingHandler$8
  implements Runnable
{
  MessengerService$IncomingHandler$8(MessengerService.IncomingHandler paramIncomingHandler, QQAppInterface paramQQAppInterface, ArrayList paramArrayList, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    HashMap localHashMap = new HashMap();
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localFriendsManager != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Friends localFriends = localFriendsManager.e(str);
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
    this.jdField_a_of_type_AndroidOsBundle.putBundle("response", localBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService.a(this.jdField_a_of_type_AndroidOsBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.8
 * JD-Core Version:    0.7.0.1
 */