package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;

class NearbyProfileDisplayTribePanel$16
  implements View.OnClickListener
{
  NearbyProfileDisplayTribePanel$16(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onClick(View paramView)
  {
    paramView = ActionSheet.create(this.a.a);
    paramView.addButton(2131717470, 1);
    paramView.addCancelButton(2131690728);
    paramView.setOnButtonClickListener(new NearbyProfileDisplayTribePanel.16.1(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.16
 * JD-Core Version:    0.7.0.1
 */