package com.tencent.mobileqq.musicgene;

import android.graphics.Bitmap;
import android.os.Message;
import axku;
import axla;
import axlb;
import axlj;

public class MusicPlayerActivity$1$1$1
  implements Runnable
{
  public MusicPlayerActivity$1$1$1(axlb paramaxlb, int paramInt) {}
  
  public void run()
  {
    Object localObject = axku.a(this.jdField_a_of_type_Axlb.jdField_a_of_type_Axlj.c);
    if (localObject != null)
    {
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
        ((Bitmap)localObject).recycle();
        localObject = Message.obtain(MusicPlayerActivity.a(this.jdField_a_of_type_Axlb.jdField_a_of_type_Axla.a), 55);
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