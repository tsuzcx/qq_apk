package com.tencent.mobileqq.profilecard.base.component;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;

class ProfileHeaderBaseComponent$5
  implements ActionSheet.OnButtonClickListener
{
  ProfileHeaderBaseComponent$5(ProfileHeaderBaseComponent paramProfileHeaderBaseComponent, ArrayList paramArrayList, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    ((ProfileHeaderBaseComponent.ActionSheetItem)this.val$actionSheetItems.get(paramInt)).onClick();
    this.val$actionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.component.ProfileHeaderBaseComponent.5
 * JD-Core Version:    0.7.0.1
 */