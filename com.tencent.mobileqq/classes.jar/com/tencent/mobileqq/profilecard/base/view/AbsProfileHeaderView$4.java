package com.tencent.mobileqq.profilecard.base.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AbsProfileHeaderView$4
  implements Runnable
{
  AbsProfileHeaderView$4(AbsProfileHeaderView paramAbsProfileHeaderView, Bitmap paramBitmap) {}
  
  public void run()
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)this.this$0.a.get("map_key_face");
    if (localAvatarLayout == null) {}
    for (Object localObject = null;; localObject = localAvatarLayout.a(0))
    {
      localObject = (ImageView)localObject;
      if (localObject != null)
      {
        if (this.a != null)
        {
          QLog.d("Q.qqhead.freq", 1, "ProfileHeaderView updateAvatar, bitmap: " + this.a);
          localAvatarLayout.setStaticAvatar(this.a);
        }
        AbsProfileHeaderView.a(this.this$0, (ImageView)localObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.4
 * JD-Core Version:    0.7.0.1
 */