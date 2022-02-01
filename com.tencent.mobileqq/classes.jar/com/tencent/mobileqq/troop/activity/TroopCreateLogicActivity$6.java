package com.tencent.mobileqq.troop.activity;

import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.open.base.ImageUtil;

class TroopCreateLogicActivity$6
  implements URLDrawable.DownloadListener
{
  TroopCreateLogicActivity$6(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, TroopCreateLogicActivity.OnGetBitmapCallback paramOnGetBitmapCallback) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateLogicActivity$OnGetBitmapCallback.a(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = ImageUtil.a(this.jdField_a_of_type_ComTencentImageURLDrawable, 100, 100);
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateLogicActivity$OnGetBitmapCallback.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateLogicActivity.6
 * JD-Core Version:    0.7.0.1
 */