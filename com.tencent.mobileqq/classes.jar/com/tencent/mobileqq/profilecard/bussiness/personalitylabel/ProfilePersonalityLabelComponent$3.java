package com.tencent.mobileqq.profilecard.bussiness.personalitylabel;

import android.view.View;
import com.tencent.mobileqq.profilecard.base.component.IProfileActivityDelegate;

class ProfilePersonalityLabelComponent$3
  implements Runnable
{
  ProfilePersonalityLabelComponent$3(ProfilePersonalityLabelComponent paramProfilePersonalityLabelComponent) {}
  
  public void run()
  {
    if (ProfilePersonalityLabelComponent.access$700(this.this$0) != null)
    {
      int i = ((View)ProfilePersonalityLabelComponent.access$800(this.this$0)).getTop();
      if ((i >= 0) && (ProfilePersonalityLabelComponent.access$900(this.this$0) != null)) {
        ProfilePersonalityLabelComponent.access$1000(this.this$0).scrollToMoreInfoView(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.personalitylabel.ProfilePersonalityLabelComponent.3
 * JD-Core Version:    0.7.0.1
 */