package com.tencent.mobileqq.vas;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;

final class VasApngUtil$3
  implements Runnable
{
  VasApngUtil$3(URLDrawable paramURLDrawable, int[] paramArrayOfInt) {}
  
  public void run()
  {
    Drawable localDrawable = this.val$urlDrawable.getCurrDrawable();
    if ((localDrawable != null) && ((localDrawable instanceof ApngDrawable)) && (((ApngDrawable)localDrawable).getImage() != null)) {
      ApngImage.playByTag(this.val$apngTag[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngUtil.3
 * JD-Core Version:    0.7.0.1
 */