package com.tencent.mobileqq.nearby.profilecard;

import android.widget.EditText;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.widget.ActionSheet;

class NearbyProfileEditPanel$1
  implements IphonePickerView.IphonePickListener
{
  NearbyProfileEditPanel$1(NearbyProfileEditPanel paramNearbyProfileEditPanel, IphonePickerView paramIphonePickerView, ActionSheet paramActionSheet) {}
  
  public void onConfirmBtClicked()
  {
    if (this.b.isShowing())
    {
      NearbyProfileEditPanel localNearbyProfileEditPanel = this.c;
      localNearbyProfileEditPanel.a(localNearbyProfileEditPanel.o, false);
      this.b.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    paramInt1 = this.a.b(0);
    this.c.o.setTag(Byte.valueOf((byte)paramInt1));
    this.c.o.setText(NearbyProfileEditPanel.a(this.c).getText(0, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileEditPanel.1
 * JD-Core Version:    0.7.0.1
 */