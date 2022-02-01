package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.widget.ActionSheet;

class NearbyProfileEditTribePanel$3
  implements IphonePickerView.IphonePickListener
{
  NearbyProfileEditTribePanel$3(NearbyProfileEditTribePanel paramNearbyProfileEditTribePanel, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((ActionSheet)localObject).isShowing()))
    {
      localObject = this.c;
      NearbyProfileEditTribePanel.a((NearbyProfileEditTribePanel)localObject, ((NearbyProfileEditTribePanel)localObject).p, false);
      this.b.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          this.c.M = paramInt2;
        }
      }
      else {
        this.c.L = paramInt2;
      }
    }
    else {
      this.c.K = paramInt2;
    }
    if (this.a != null)
    {
      if ((paramInt1 == 0) || (paramInt1 == 1)) {
        this.a.a(2);
      }
      this.c.a(this.a.b(0), this.a.b(1), this.a.b(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditTribePanel.3
 * JD-Core Version:    0.7.0.1
 */