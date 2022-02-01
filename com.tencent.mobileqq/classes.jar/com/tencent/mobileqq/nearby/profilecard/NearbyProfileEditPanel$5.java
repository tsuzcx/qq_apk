package com.tencent.mobileqq.nearby.profilecard;

import android.widget.EditText;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.widget.ActionSheet;

class NearbyProfileEditPanel$5
  implements IphonePickerView.IphonePickListener
{
  int a = -1;
  
  NearbyProfileEditPanel$5(NearbyProfileEditPanel paramNearbyProfileEditPanel, int paramInt, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    if (this.a == -1)
    {
      this.d.z.setTag(Byte.valueOf((byte)(this.b + 1)));
      this.d.z.setText(NearbyProfileEditPanel.b(this.d).getText(0, this.b));
    }
    else
    {
      this.d.z.setTag(Byte.valueOf((byte)(this.a + 1)));
      this.d.z.setText(NearbyProfileEditPanel.b(this.d).getText(0, this.a));
    }
    if (this.c.isShowing())
    {
      NearbyProfileEditPanel localNearbyProfileEditPanel = this.d;
      localNearbyProfileEditPanel.a(localNearbyProfileEditPanel.z, false);
      this.c.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    this.a = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.5
 * JD-Core Version:    0.7.0.1
 */