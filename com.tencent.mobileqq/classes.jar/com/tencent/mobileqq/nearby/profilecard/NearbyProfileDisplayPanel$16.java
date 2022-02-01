package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;

class NearbyProfileDisplayPanel$16
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$16(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    paramView = ActionSheet.create(this.a.a);
    paramView.addButton(2131717470, 1);
    paramView.addCancelButton(2131690728);
    paramView.setOnButtonClickListener(new NearbyProfileDisplayPanel.16.1(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.16
 * JD-Core Version:    0.7.0.1
 */