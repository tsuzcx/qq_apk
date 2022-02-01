package com.tencent.mobileqq.nearby.profilecard;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class NearbyProfileEditPanel$16
  implements View.OnClickListener
{
  NearbyProfileEditPanel$16(NearbyProfileEditPanel paramNearbyProfileEditPanel) {}
  
  public void onClick(View paramView)
  {
    if (this.a.J.size() >= NearbyProfileCardConstants.a)
    {
      QQToast.makeText(this.a.F, 0, this.a.F.getResources().getString(2131892083), 0).show();
      return;
    }
    NearbyProfileEditPanel.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.16
 * JD-Core Version:    0.7.0.1
 */