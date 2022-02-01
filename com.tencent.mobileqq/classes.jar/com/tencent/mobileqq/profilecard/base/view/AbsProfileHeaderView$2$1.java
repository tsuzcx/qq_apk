package com.tencent.mobileqq.profilecard.base.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AbsProfileHeaderView$2$1
  implements Runnable
{
  AbsProfileHeaderView$2$1(AbsProfileHeaderView.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    AvatarLayout localAvatarLayout = (AvatarLayout)this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView$2.this$0.a.get("map_key_face");
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
        AbsProfileHeaderView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView$2.this$0, (ImageView)localObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.2.1
 * JD-Core Version:    0.7.0.1
 */