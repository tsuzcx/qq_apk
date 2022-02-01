package com.tencent.mobileqq.troop.troopcreate.ui;

import android.graphics.Bitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.utils.BaseImageUtil;

class TroopCreateLogicActivity$6
  implements URLDrawable.DownloadListener
{
  TroopCreateLogicActivity$6(TroopCreateLogicActivity paramTroopCreateLogicActivity, URLDrawable paramURLDrawable, TroopCreateLogicActivity.OnGetBitmapCallback paramOnGetBitmapCallback) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    this.b.a(null);
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    Bitmap localBitmap = BaseImageUtil.a(this.a, 100, 100);
    this.b.a(localBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity.6
 * JD-Core Version:    0.7.0.1
 */