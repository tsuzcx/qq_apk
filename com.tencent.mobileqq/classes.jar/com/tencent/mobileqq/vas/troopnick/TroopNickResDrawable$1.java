package com.tencent.mobileqq.vas.troopnick;

import android.graphics.Bitmap;
import com.tencent.mobileqq.vas.ui.VasNinePathBitmap;
import com.tencent.mobileqq.vas.utils.CacheHelper;

class TroopNickResDrawable$1
  implements Runnable
{
  TroopNickResDrawable$1(TroopNickResDrawable paramTroopNickResDrawable, String paramString) {}
  
  public void run()
  {
    if (TroopNickResDrawable.a(this.this$0).c())
    {
      Bitmap localBitmap = (Bitmap)CacheHelper.a(new TroopNickResDrawable.MyBitmapOptions(this.a));
      TroopNickResDrawable.a(this.this$0).a(localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickResDrawable.1
 * JD-Core Version:    0.7.0.1
 */