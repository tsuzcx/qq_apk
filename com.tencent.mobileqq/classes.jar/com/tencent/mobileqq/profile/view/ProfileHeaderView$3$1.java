package com.tencent.mobileqq.profile.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ProfileHeaderView$3$1
  implements Runnable
{
  ProfileHeaderView$3$1(ProfileHeaderView.3 param3, Bitmap paramBitmap) {}
  
  public void run()
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView$3.this$0.a.get("map_key_face");
    if (localAvatarLayout == null) {}
    for (Object localObject = null;; localObject = localAvatarLayout.a(0))
    {
      localObject = (ImageView)localObject;
      if (localObject != null)
      {
        if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
        {
          QLog.d("Q.qqhead.freq", 1, "ProfileHeaderView updateAvatar, bitmap: " + this.jdField_a_of_type_AndroidGraphicsBitmap);
          localAvatarLayout.setStaticAvatar(this.jdField_a_of_type_AndroidGraphicsBitmap);
        }
        ProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView$3.this$0, (ImageView)localObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.ProfileHeaderView.3.1
 * JD-Core Version:    0.7.0.1
 */