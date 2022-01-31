package com.tencent.mobileqq.troopshare;

import android.content.Intent;
import android.graphics.Bitmap;
import bctc;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troopinfo.TroopInfoData;

public class TroopShareUtility$9
  implements Runnable
{
  public TroopShareUtility$9(bctc parambctc, QQAppInterface paramQQAppInterface, TroopInfoData paramTroopInfoData, Intent paramIntent) {}
  
  public void run()
  {
    try
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.troopUin, (byte)3, false, false);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("face", localBitmap);
      this.this$0.a.startActivity(this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.9
 * JD-Core Version:    0.7.0.1
 */