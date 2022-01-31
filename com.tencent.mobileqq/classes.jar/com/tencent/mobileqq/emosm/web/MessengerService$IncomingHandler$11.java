package com.tencent.mobileqq.emosm.web;

import alto;
import android.os.Bundle;
import android.text.TextUtils;
import apqh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MessengerService$IncomingHandler$11
  implements Runnable
{
  public MessengerService$IncomingHandler$11(apqh paramapqh, QQAppInterface paramQQAppInterface, ArrayList paramArrayList, Bundle paramBundle, MessengerService paramMessengerService) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    HashMap localHashMap = new HashMap();
    alto localalto = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localalto != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Friends localFriends = localalto.e(str);
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
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler.11
 * JD-Core Version:    0.7.0.1
 */