package com.tencent.mobileqq.profile.PersonalityLabel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

class PersonalityLabelGalleryActivity$ListViewAdapter$4
  implements DialogInterface.OnClickListener
{
  PersonalityLabelGalleryActivity$ListViewAdapter$4(PersonalityLabelGalleryActivity.ListViewAdapter paramListViewAdapter, View paramView, PersonalityLabelInfo paramPersonalityLabelInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    paramDialogInterface = (PersonalityLabelGalleryActivity.LabelItemViewHolder)this.a.getTag(2131431689);
    if (paramDialogInterface != null) {
      this.c.a.a(paramDialogInterface.m, this.b.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity.ListViewAdapter.4
 * JD-Core Version:    0.7.0.1
 */