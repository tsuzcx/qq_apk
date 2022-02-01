package com.tencent.mobileqq.troop.utils;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;

class TroopGagMgr$1
  implements Runnable
{
  TroopGagMgr$1(TroopGagMgr paramTroopGagMgr, boolean paramBoolean, Context paramContext, String paramString, int paramInt) {}
  
  public void run()
  {
    if (this.a)
    {
      QQToast.makeText(this.b, 2, this.c, 0).show(this.d);
      return;
    }
    QQToast.makeText(this.b, 2130840055, this.c, 0).show(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopGagMgr.1
 * JD-Core Version:    0.7.0.1
 */