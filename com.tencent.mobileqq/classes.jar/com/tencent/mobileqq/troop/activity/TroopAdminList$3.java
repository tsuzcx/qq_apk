package com.tencent.mobileqq.troop.activity;

import bhlg;
import java.util.List;
import java.util.Map;

class TroopAdminList$3
  implements Runnable
{
  TroopAdminList$3(TroopAdminList paramTroopAdminList) {}
  
  public void run()
  {
    int j = this.this$0.a.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)((Map)this.this$0.a.get(i)).get("uin");
      ((Map)this.this$0.a.get(i)).put("nick", bhlg.j(this.this$0.app, str));
      i += 1;
    }
    this.this$0.runOnUiThread(new TroopAdminList.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList.3
 * JD-Core Version:    0.7.0.1
 */