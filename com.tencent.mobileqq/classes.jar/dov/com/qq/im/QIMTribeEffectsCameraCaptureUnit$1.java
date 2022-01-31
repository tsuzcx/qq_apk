package dov.com.qq.im;

import aepi;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import bkod;
import oip;

public class QIMTribeEffectsCameraCaptureUnit$1
  implements Runnable
{
  public QIMTribeEffectsCameraCaptureUnit$1(bkod parambkod, Activity paramActivity) {}
  
  public void run()
  {
    if (this.a != null)
    {
      BitmapDrawable localBitmapDrawable = oip.a(this.a);
      if (localBitmapDrawable != null)
      {
        int i = aepi.a(36.0F, this.this$0.a.getResources());
        localBitmapDrawable.setBounds(0, 0, i, i);
        this.a.runOnUiThread(new QIMTribeEffectsCameraCaptureUnit.1.1(this, localBitmapDrawable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMTribeEffectsCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */