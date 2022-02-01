package com.tencent.mobileqq.qqexpand.flutter.apng;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import androidx.annotation.NonNull;
import com.peterlmeng.animate_image.support.common.IInvalidateCallback;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class ApngDrawableWrapper$2
  implements Drawable.Callback
{
  ApngDrawableWrapper$2(ApngDrawableWrapper paramApngDrawableWrapper) {}
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    paramDrawable.draw(ApngDrawableWrapper.a(this.a));
    if ((ApngDrawableWrapper.a(this.a) != null) && ((paramDrawable instanceof URLDrawable)))
    {
      Object localObject = ((URLDrawable)paramDrawable).getCurrDrawable();
      if ((localObject instanceof ApngDrawable))
      {
        localObject = ((ApngDrawable)localObject).getImage();
        Bitmap localBitmap = ((ApngImage)localObject).getCurrentFrame();
        if (ApngDrawableWrapper.a(this.a) != null)
        {
          ApngDrawableWrapper.a(this.a).onInvalidate(localBitmap, ((ApngImage)localObject).currentApngLoop);
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[");
          ((StringBuilder)localObject).append(ApngDrawableWrapper.a(this.a));
          ((StringBuilder)localObject).append("] ");
          QLog.d("ApngDrawableWrapper", 2, new Object[] { ((StringBuilder)localObject).toString(), "invalidateDrawable() callback is null", paramDrawable });
        }
      }
      else
      {
        paramDrawable = new StringBuilder();
        paramDrawable.append("[");
        paramDrawable.append(ApngDrawableWrapper.a(this.a));
        paramDrawable.append("] ");
        QLog.d("ApngDrawableWrapper", 2, new Object[] { paramDrawable.toString(), "invalidateDrawable() strange drawable is: ", localObject });
      }
    }
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.apng.ApngDrawableWrapper.2
 * JD-Core Version:    0.7.0.1
 */