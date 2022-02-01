package com.tencent.mobileqq.troop.troopnotification.activity;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.lang.ref.WeakReference;

class TroopRequestActivity$26
  implements URLDrawable.URLDrawableListener
{
  TroopRequestActivity$26(TroopRequestActivity paramTroopRequestActivity, WeakReference paramWeakReference) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (paramURLDrawable != null)
    {
      paramURLDrawable = (View)paramURLDrawable.get();
      if (paramURLDrawable != null) {
        paramURLDrawable.postInvalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity.26
 * JD-Core Version:    0.7.0.1
 */