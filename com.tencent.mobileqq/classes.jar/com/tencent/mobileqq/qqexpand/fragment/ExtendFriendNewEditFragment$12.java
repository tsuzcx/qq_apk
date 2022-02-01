package com.tencent.mobileqq.qqexpand.fragment;

import android.view.View;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.qqexpand.widget.ActionSheetCustom;

class ExtendFriendNewEditFragment$12
  implements IphonePickerView.IphonePickListener
{
  ExtendFriendNewEditFragment$12(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment, IphonePickerView paramIphonePickerView, ActionSheetCustom paramActionSheetCustom) {}
  
  public void onConfirmBtClicked()
  {
    ActionSheetCustom localActionSheetCustom = this.b;
    if ((localActionSheetCustom != null) && (localActionSheetCustom.isShowing()))
    {
      ExtendFriendNewEditFragment.a(this.c, this.a.b(0), this.a.b(1), this.a.b(2));
      ExtendFriendNewEditFragment.s(this.c).setClickable(true);
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
          ExtendFriendNewEditFragment.c(this.c, paramInt2);
        }
      }
      else {
        ExtendFriendNewEditFragment.b(this.c, paramInt2);
      }
    }
    else {
      ExtendFriendNewEditFragment.a(this.c, paramInt2);
    }
    if (this.a != null)
    {
      if ((paramInt1 == 0) || (paramInt1 == 1))
      {
        this.a.a(1);
        this.a.a(2);
      }
      ExtendFriendNewEditFragment.a(this.c, this.a.b(0), this.a.b(1), this.a.b(2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.12
 * JD-Core Version:    0.7.0.1
 */