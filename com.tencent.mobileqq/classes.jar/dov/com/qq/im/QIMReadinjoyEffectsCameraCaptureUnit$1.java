package dov.com.qq.im;

import actj;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import bihu;
import oed;

public class QIMReadinjoyEffectsCameraCaptureUnit$1
  implements Runnable
{
  public QIMReadinjoyEffectsCameraCaptureUnit$1(bihu parambihu, Activity paramActivity) {}
  
  public void run()
  {
    if (this.a != null)
    {
      BitmapDrawable localBitmapDrawable = oed.a(this.a);
      if (localBitmapDrawable != null)
      {
        int i = actj.a(36.0F, this.this$0.a.getResources());
        localBitmapDrawable.setBounds(0, 0, i, i);
        this.a.runOnUiThread(new QIMReadinjoyEffectsCameraCaptureUnit.1.1(this, localBitmapDrawable));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMReadinjoyEffectsCameraCaptureUnit.1
 * JD-Core Version:    0.7.0.1
 */