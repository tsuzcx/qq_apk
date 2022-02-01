package com.tencent.mobileqq.newnearby.util;

import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.newnearby.hippy.NearbyHippyCallback;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

final class PickBirthdayHelper$1
  implements IphonePickerView.IphonePickListener
{
  PickBirthdayHelper$1(ActionSheet paramActionSheet, Promise paramPromise) {}
  
  public void onConfirmBtClicked()
  {
    this.a.dismiss();
    NearbyHippyCallback.a(this.b, PickBirthdayHelper.a(), PickBirthdayHelper.b(), PickBirthdayHelper.c());
    QLog.d("PickBirthdayHelper", 2, "showPickerView onConfirmBtClicked");
  }
  
  public void onItemSelected(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      PickBirthdayHelper.a(paramInt2 + 1896);
      return;
    }
    if (paramInt1 == 1)
    {
      PickBirthdayHelper.b(paramInt2 + 1);
      return;
    }
    if (paramInt1 == 2) {
      PickBirthdayHelper.c(paramInt2 + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.PickBirthdayHelper.1
 * JD-Core Version:    0.7.0.1
 */