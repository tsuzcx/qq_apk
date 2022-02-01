package com.tencent.mobileqq.musicgene;

import android.graphics.Bitmap;
import android.os.Message;

class MusicPlayerActivity$1$1$1
  implements Runnable
{
  MusicPlayerActivity$1$1$1(MusicPlayerActivity.1.1 param1, int paramInt) {}
  
  public void run()
  {
    Object localObject = MusicGeneWebViewPlugin.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$1$1.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$ShareInfo.c);
    if (localObject != null)
    {
      int j = ((Bitmap)localObject).getWidth();
      int i = ((Bitmap)localObject).getHeight();
      int k = j * i;
      if (k > 8000)
      {
        double d1 = k;
        Double.isNaN(d1);
        d1 = Math.sqrt(8000.0D / d1);
        double d2 = j;
        Double.isNaN(d2);
        j = (int)(d2 * d1);
        d2 = i;
        Double.isNaN(d2);
        Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, j, (int)(d2 * d1), true);
        ((Bitmap)localObject).recycle();
        localObject = Message.obtain(MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$1$1.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$1.a), 55);
        ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
        ((Message)localObject).obj = localBitmap;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.1.1.1
 * JD-Core Version:    0.7.0.1
 */