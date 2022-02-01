package com.tencent.mobileqq.conditionsearch;

import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ConditionSearchFriendActivity$9
  implements ConditionSearchManager.IConfigListener
{
  ConditionSearchFriendActivity$9(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearchFriendActivity", 2, "onGetConfig | mDialogType = " + this.a.j + ", isSuccess = " + paramBoolean + ", resultCode = " + paramInt);
    }
    if ((this.a.j == 1) || (this.a.j == 2))
    {
      if (paramBoolean) {
        break label110;
      }
      this.a.a();
      QQToast.a(this.a, 2131691137, 0).b(this.a.getTitleBarHeight());
    }
    label110:
    while (paramInt != 2) {
      return;
    }
    this.a.a();
    this.a.a(this.a.j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.9
 * JD-Core Version:    0.7.0.1
 */