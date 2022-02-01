package com.tencent.mobileqq.vas.avatar;

import com.tencent.image.URLDrawable;
import java.lang.ref.WeakReference;

class VasAvatarLoader$2
  implements Runnable
{
  VasAvatarLoader$2(VasAvatarLoader paramVasAvatarLoader, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    VasAvatar localVasAvatar = (VasAvatar)this.this$0.a.get();
    if ((localVasAvatar != null) && (localVasAvatar.a == this.this$0))
    {
      localVasAvatar.setImageDrawable(this.a);
      localVasAvatar.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.VasAvatarLoader.2
 * JD-Core Version:    0.7.0.1
 */