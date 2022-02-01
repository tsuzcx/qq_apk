package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class NearbyProfileEditTribePanel$5$1
  implements ActionSheet.OnButtonClickListener
{
  NearbyProfileEditTribePanel$5$1(NearbyProfileEditTribePanel.5 param5, View paramView, PicInfo paramPicInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (this.d.a == 0) {
      i = paramInt + 1;
    }
    if (i != 0) {
      if (i != 1)
      {
        if (i == 2) {
          NearbyProfileEditTribePanel.a(this.d.b, this.b, this.a);
        }
      }
      else
      {
        paramView = AnimationUtils.a(this.a);
        this.d.b.A.showBigPhotoWithDelAndSetHeadView(this.d.a, paramView, this.d.b.E);
      }
    }
    this.c.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.5.1
 * JD-Core Version:    0.7.0.1
 */