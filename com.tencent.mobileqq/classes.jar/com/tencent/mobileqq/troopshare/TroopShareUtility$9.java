package com.tencent.mobileqq.troopshare;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopInfoData;

class TroopShareUtility$9
  implements Runnable
{
  TroopShareUtility$9(TroopShareUtility paramTroopShareUtility, QQAppInterface paramQQAppInterface, TroopInfoData paramTroopInfoData, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = this.a.getTroopFaceBitmap(this.b.troopUin, (byte)3, false, false);
      this.c.putExtra("face", localBitmap);
      this.this$0.h.startActivity(this.c);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.9
 * JD-Core Version:    0.7.0.1
 */