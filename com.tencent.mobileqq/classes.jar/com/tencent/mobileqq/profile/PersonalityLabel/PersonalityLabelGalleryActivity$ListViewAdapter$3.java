package com.tencent.mobileqq.profile.PersonalityLabel;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PersonalityLabelGalleryActivity$ListViewAdapter$3
  implements ActionSheet.OnButtonClickListener
{
  PersonalityLabelGalleryActivity$ListViewAdapter$3(PersonalityLabelGalleryActivity.ListViewAdapter paramListViewAdapter, PersonalityLabelInfo paramPersonalityLabelInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        PersonalityLabelGalleryActivity.b(this.c.a, this.a.id);
        this.c.a(this.a);
      }
    }
    else {
      PersonalityLabelGalleryActivity.ListViewAdapter.a(this.c, this.a);
    }
    this.b.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.ListViewAdapter.3
 * JD-Core Version:    0.7.0.1
 */