package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class NearbyPeopleProfileActivity$22
  implements ActionSheet.OnButtonClickListener
{
  NearbyPeopleProfileActivity$22(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        this.b.selectPhotoFromQZone();
        NearbyPeopleProfileActivity.access$1000(this.b);
      }
    }
    else
    {
      if (NearbyPeopleProfileActivity.access$300(this.b) != null) {
        NearbyPeopleProfileActivity.access$300(this.b).a(this.b.mPicInfo.size());
      }
      NearbyPeopleProfileActivity.access$1000(this.b);
    }
    this.a.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.22
 * JD-Core Version:    0.7.0.1
 */