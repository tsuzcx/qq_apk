package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import bglf;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TroopAdminList$2
  implements Runnable
{
  TroopAdminList$2(TroopAdminList paramTroopAdminList) {}
  
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
        localHashMap.put("nick", bglf.j(this.this$0.app, str));
        this.this$0.jdField_a_of_type_JavaUtilList.add(localHashMap);
      }
      i += 1;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.this$0.app.a(1));
    this.this$0.addObserver(this.this$0.jdField_a_of_type_Anmu);
    this.this$0.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.c(this.this$0.jdField_a_of_type_ArrayOfJavaLangString);
    this.this$0.runOnUiThread(new TroopAdminList.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.2
 * JD-Core Version:    0.7.0.1
 */