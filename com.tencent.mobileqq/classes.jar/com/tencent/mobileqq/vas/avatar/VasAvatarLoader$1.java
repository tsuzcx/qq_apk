package com.tencent.mobileqq.vas.avatar;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;

class VasAvatarLoader$1
  implements Runnable
{
  VasAvatarLoader$1(VasAvatarLoader paramVasAvatarLoader, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    VasAvatar localVasAvatar = (VasAvatar)this.this$0.h.get();
    if ((localVasAvatar != null) && (localVasAvatar.b == this.this$0))
    {
      localVasAvatar.setImageDrawable(this.a);
      if (!this.this$0.f)
      {
        Drawable localDrawable = this.a.getCurrDrawable();
        if ((localDrawable instanceof ApngDrawable))
        {
          if (this.this$0.e != -1) {
            VasFaceManager.a((ApngDrawable)localDrawable);
          }
          VasFaceManager.a(this.this$0.b, (ApngDrawable)localDrawable);
          localVasAvatar.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasAvatarLoader.1
 * JD-Core Version:    0.7.0.1
 */