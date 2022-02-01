package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.common.galleryactivity.AnimationUtils;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class NearbyProfileEditPanel$7$1
  implements ActionSheet.OnButtonClickListener
{
  NearbyProfileEditPanel$7$1(NearbyProfileEditPanel.7 param7, View paramView, PicInfo paramPicInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (this.d.a == 0) {
      i = paramInt + 1;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          this.d.b.a(this.b, this.a);
        }
      }
      else
      {
        paramView = AnimationUtils.a(this.a);
        this.d.b.F.showBigPhotoWithDelAndSetHeadView(this.d.a, paramView, this.d.b.J);
      }
    }
    else
    {
      this.d.b.i.removeView(this.a);
      this.d.b.i.addView(this.a, 0);
      this.d.b.m();
      NearbyProfileEditPanel.c(this.d.b);
    }
    this.c.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.7.1
 * JD-Core Version:    0.7.0.1
 */