package com.tencent.mobileqq.troop.activity;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.troop.widget.TroopAvatarWallGalleryAdapter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopAvatarWallEditActivity$7
  implements ActionSheet.OnButtonClickListener
{
  String a = this.d.d.c(this.d.j);
  
  TroopAvatarWallEditActivity$7(TroopAvatarWallEditActivity paramTroopAvatarWallEditActivity, ActionSheet paramActionSheet, URLDrawable paramURLDrawable) {}
  
  public void onClick(View paramView, int paramInt)
  {
    paramView = this.b.getContent(paramInt);
    if (this.d.getString(2131890804).equals(paramView))
    {
      this.d.a(this.c, this.a);
    }
    else if (this.d.getString(2131890810).equals(paramView))
    {
      TroopAvatarWallEditActivity.a(this.d, this.c);
    }
    else if (this.d.getString(2131890808).equals(paramView))
    {
      paramView = this.d;
      paramView.a(paramView.x, this.a);
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAvatarWallEditActivity.7
 * JD-Core Version:    0.7.0.1
 */