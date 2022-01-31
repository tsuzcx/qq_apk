package dov.com.qq.im.capture.view;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import bjju;

class QIMProviderContainerView$7$1
  implements Runnable
{
  QIMProviderContainerView$7$1(QIMProviderContainerView.7 param7, int paramInt, Drawable[] paramArrayOfDrawable) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      if (QIMProviderContainerView.a(this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView$7.this$0).a(i))
      {
        Object localObject = (ImageView)this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView$7.this$0.a.getChildAt(i);
        if (this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i] != null)
        {
          ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable[i]);
          if ((((ImageView)localObject).getDrawable() instanceof AnimationDrawable))
          {
            localObject = (AnimationDrawable)((ImageView)localObject).getDrawable();
            ((AnimationDrawable)localObject).stop();
            ((AnimationDrawable)localObject).setOneShot(true);
            ((AnimationDrawable)localObject).start();
          }
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMProviderContainerView.7.1
 * JD-Core Version:    0.7.0.1
 */