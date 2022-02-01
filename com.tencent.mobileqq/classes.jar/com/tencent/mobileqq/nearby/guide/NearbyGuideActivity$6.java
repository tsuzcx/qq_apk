package com.tencent.mobileqq.nearby.guide;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class NearbyGuideActivity$6
  implements ActionSheet.OnButtonClickListener
{
  NearbyGuideActivity$6(NearbyGuideActivity paramNearbyGuideActivity, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.cancel();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.b.gotoQZoneAlbumActivity();
      return;
    }
    this.b.gotoPhotoListActivity();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.guide.NearbyGuideActivity.6
 * JD-Core Version:    0.7.0.1
 */