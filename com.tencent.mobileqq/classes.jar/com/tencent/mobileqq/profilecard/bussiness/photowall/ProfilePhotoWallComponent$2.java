package com.tencent.mobileqq.profilecard.bussiness.photowall;

import android.view.View;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;

class ProfilePhotoWallComponent$2
  implements Runnable
{
  ProfilePhotoWallComponent$2(ProfilePhotoWallComponent paramProfilePhotoWallComponent) {}
  
  public void run()
  {
    if (ProfilePhotoWallComponent.access$500(this.this$0) != null)
    {
      int i = ((View)ProfilePhotoWallComponent.access$600(this.this$0)).getTop();
      if ((i >= 0) && (ProfilePhotoWallComponent.access$700(this.this$0) != null)) {
        ProfilePhotoWallComponent.access$800(this.this$0).scrollToMoreInfoView(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.photowall.ProfilePhotoWallComponent.2
 * JD-Core Version:    0.7.0.1
 */