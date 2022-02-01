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
    int j = this.this$0.e.length;
    int i = 0;
    while (i < j)
    {
      localObject = this.this$0.e[i];
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("uin", localObject);
        localHashMap.put("nick", ContactUtils.d(this.this$0.app, (String)localObject));
        this.this$0.f.add(localHashMap);
      }
      i += 1;
    }
    Object localObject = this.this$0;
    ((TroopAdminList)localObject).h = ((FriendListHandler)((TroopAdminList)localObject).app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    localObject = this.this$0;
    ((TroopAdminList)localObject).addObserver(((TroopAdminList)localObject).l);
    localObject = this.this$0;
    ((TroopAdminList)localObject).addObserver(((TroopAdminList)localObject).k);
    this.this$0.h.getFriendsInfo(this.this$0.e);
    this.this$0.runOnUiThread(new TroopAdminList.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.3
 * JD-Core Version:    0.7.0.1
 */