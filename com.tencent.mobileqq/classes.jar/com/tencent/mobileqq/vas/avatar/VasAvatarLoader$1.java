package com.tencent.mobileqq.vas.avatar;

import android.graphics.drawable.Drawable;
import bdwc;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;

public class VasAvatarLoader$1
  implements Runnable
{
  public VasAvatarLoader$1(bdwc parambdwc, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    VasAvatar localVasAvatar = (VasAvatar)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localVasAvatar != null) && (localVasAvatar.a == this.this$0))
    {
      localVasAvatar.setImageDrawable(this.a);
      if (!this.this$0.jdField_a_of_type_Boolean)
      {
        Drawable localDrawable = this.a.getCurrDrawable();
        if ((localDrawable instanceof ApngDrawable))
        {
          if (this.this$0.b != -1) {
            VasFaceManager.a((ApngDrawable)localDrawable);
          }
          VasFaceManager.a(this.this$0.jdField_a_of_type_JavaLangString, (ApngDrawable)localDrawable);
          localVasAvatar.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasAvatarLoader.1
 * JD-Core Version:    0.7.0.1
 */