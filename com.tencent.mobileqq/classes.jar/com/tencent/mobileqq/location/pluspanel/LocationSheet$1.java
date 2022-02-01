package com.tencent.mobileqq.location.pluspanel;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class LocationSheet$1
  implements ActionSheet.OnButtonClickListener
{
  LocationSheet$1(LocationSheet paramLocationSheet, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        LocationSheet.b(this.b);
      }
    }
    else {
      LocationSheet.a(this.b);
    }
    this.a.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.pluspanel.LocationSheet.1
 * JD-Core Version:    0.7.0.1
 */