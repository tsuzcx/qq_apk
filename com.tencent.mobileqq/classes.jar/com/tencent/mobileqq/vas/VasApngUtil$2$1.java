package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

class VasApngUtil$2$1
  implements Runnable
{
  VasApngUtil$2$1(VasApngUtil.2 param2, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasApngUtil", 2, "urlDrawableListener onLoadSuccessed");
    }
    Drawable localDrawable = this.val$drawable.getCurrDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof ApngDrawable)) && (((ApngDrawable)localDrawable).getImage() != null)) {
      ApngImage.playByTag(this.this$0.val$apngTag[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngUtil.2.1
 * JD-Core Version:    0.7.0.1
 */