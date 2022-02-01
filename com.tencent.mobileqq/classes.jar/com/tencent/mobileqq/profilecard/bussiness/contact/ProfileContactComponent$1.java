package com.tencent.mobileqq.profilecard.bussiness.contact;

import android.view.View;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ProfileContactComponent$1
  implements ActionSheet.OnButtonClickListener
{
  ProfileContactComponent$1(ProfileContactComponent paramProfileContactComponent) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramInt = ProfileContactComponent.access$000(this.this$0)[paramInt];
    if (paramInt != 7)
    {
      if (paramInt != 8)
      {
        if (paramInt != 9) {
          return;
        }
        paramView = this.this$0;
        ProfileContactComponent.access$400(paramView, ProfileContactComponent.access$100(paramView));
        return;
      }
      paramView = this.this$0;
      ProfileContactComponent.access$300(paramView, ProfileContactComponent.access$100(paramView));
      return;
    }
    paramView = this.this$0;
    ProfileContactComponent.access$200(paramView, ProfileContactComponent.access$100(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.contact.ProfileContactComponent.1
 * JD-Core Version:    0.7.0.1
 */