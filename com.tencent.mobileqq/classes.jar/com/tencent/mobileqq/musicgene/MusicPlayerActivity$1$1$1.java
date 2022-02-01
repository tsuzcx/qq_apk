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
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
        ((Bitmap)localObject).recycle();
        localObject = Message.obtain(MusicPlayerActivity.a(this.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$1$1.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$1.a), 55);
        ((Message)localObject).arg1 = this.jdField_a_of_type_Int;
        ((Message)localObject).obj = localBitmap;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.1.1.1
 * JD-Core Version:    0.7.0.1
 */