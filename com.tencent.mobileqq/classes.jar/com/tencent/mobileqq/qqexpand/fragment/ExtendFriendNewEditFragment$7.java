package com.tencent.mobileqq.qqexpand.fragment;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.qqexpand.widget.ActionSheetCustom;

class ExtendFriendNewEditFragment$7
  implements IphonePickerView.IphonePickListener
{
  ExtendFriendNewEditFragment$7(ExtendFriendNewEditFragment paramExtendFriendNewEditFragment, IphonePickerView paramIphonePickerView, ActionSheetCustom paramActionSheetCustom) {}
  
  public void onConfirmBtClicked()
  {
    ActionSheetCustom localActionSheetCustom = this.b;
    if ((localActionSheetCustom != null) && (localActionSheetCustom.isShowing()))
    {
      ExtendFriendNewEditFragment.q(this.c).setClickable(true);
      this.b.dismiss();
    }
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    paramInt1 = this.a.b(0);
    ExtendFriendNewEditFragment localExtendFriendNewEditFragment = this.c;
    ExtendFriendNewEditFragment.a(localExtendFriendNewEditFragment, ExtendFriendNewEditFragment.o(localExtendFriendNewEditFragment), ExtendFriendNewEditFragment.p(this.c).getText(0, paramInt1));
    ExtendFriendNewEditFragment.o(this.c).setTag(Integer.valueOf(paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendNewEditFragment.7
 * JD-Core Version:    0.7.0.1
 */