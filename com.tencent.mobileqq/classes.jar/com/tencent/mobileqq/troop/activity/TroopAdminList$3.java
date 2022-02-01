package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TroopAdminList$3
  implements Runnable
{
  TroopAdminList$3(TroopAdminList paramTroopAdminList) {}
  
  public void run()
  {
    int i = 0;
    int j = this.this$0.jdField_a_of_type_ArrayOfJavaLangString.length;
    while (i < j)
    {
      String str = this.this$0.jdField_a_of_type_ArrayOfJavaLangString[i];
      if (!TextUtils.isEmpty(str))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("uin", str);
        localHashMap.put("nick", ContactUtils.j(this.this$0.app, str));
        this.this$0.jdField_a_of_type_JavaUtilList.add(localHashMap);
      }
      i += 1;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.this$0.addObserver(this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.this$0.addObserver(this.this$0.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendsInfo(this.this$0.jdField_a_of_type_ArrayOfJavaLangString);
    this.this$0.runOnUiThread(new TroopAdminList.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.3
 * JD-Core Version:    0.7.0.1
 */