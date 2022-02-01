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
    AvatarLayout localAvatarLayout = (AvatarLayout)this.this$0.mHeaderChildMap.get("map_key_face");
    if (localAvatarLayout == null) {
      localObject = null;
    } else {
      localObject = localAvatarLayout.b(0);
    }
    Object localObject = (ImageView)localObject;
    if (localObject != null)
    {
      if (this.val$faceBitMap != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ProfileHeaderView updateAvatar, bitmap: ");
        localStringBuilder.append(this.val$faceBitMap);
        QLog.d("Q.qqhead.freq", 1, localStringBuilder.toString());
        localAvatarLayout.setStaticAvatar(this.val$faceBitMap);
      }
      AbsProfileHeaderView.access$200(this.this$0, (ImageView)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView.4
 * JD-Core Version:    0.7.0.1
 */