package com.tencent.mobileqq.troop.activity;

import com.tencent.mobileqq.utils.ContactUtils;
import java.util.List;
import java.util.Map;

class TroopAdminList$4
  implements Runnable
{
  TroopAdminList$4(TroopAdminList paramTroopAdminList) {}
  
  public void run()
  {
    int j = this.this$0.f.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)((Map)this.this$0.f.get(i)).get("uin");
      ((Map)this.this$0.f.get(i)).put("nick", ContactUtils.d(this.this$0.app, str));
      i += 1;
    }
    this.this$0.runOnUiThread(new TroopAdminList.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.4
 * JD-Core Version:    0.7.0.1
 */