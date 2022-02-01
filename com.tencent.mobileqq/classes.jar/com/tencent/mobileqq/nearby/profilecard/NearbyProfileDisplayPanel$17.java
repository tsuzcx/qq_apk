package com.tencent.mobileqq.nearby.profilecard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.widget.ActionSheet;

class NearbyProfileDisplayPanel$17
  implements View.OnClickListener
{
  NearbyProfileDisplayPanel$17(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onClick(View paramView)
  {
    paramView = ActionSheet.create(this.a.e);
    paramView.addButton(2131914943, 1);
    paramView.addCancelButton(2131887648);
    paramView.setOnButtonClickListener(new NearbyProfileDisplayPanel.17.1(this, paramView));
    paramView.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.17
 * JD-Core Version:    0.7.0.1
 */