package com.tencent.mobileqq.vas;

import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

final class VasApngUtil$2
  implements URLDrawable.URLDrawableListener
{
  VasApngUtil$2(int[] paramArrayOfInt) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasApngUtil", 2, "applyNormalPaster onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ThreadManagerV2.getUIHandlerV2().post(new VasApngUtil.2.1(this, paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasApngUtil.2
 * JD-Core Version:    0.7.0.1
 */