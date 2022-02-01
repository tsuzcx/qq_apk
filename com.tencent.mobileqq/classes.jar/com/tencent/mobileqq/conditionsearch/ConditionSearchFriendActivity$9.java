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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetConfig | mDialogType = ");
      ((StringBuilder)localObject).append(this.a.j);
      ((StringBuilder)localObject).append(", isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", resultCode = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a.j == 1) || (this.a.j == 2))
    {
      if (!paramBoolean)
      {
        this.a.a();
        QQToast.a(this.a, 2131691057, 0).b(this.a.getTitleBarHeight());
        return;
      }
      if (paramInt == 2)
      {
        this.a.a();
        localObject = this.a;
        ((ConditionSearchFriendActivity)localObject).a(((ConditionSearchFriendActivity)localObject).j);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.9
 * JD-Core Version:    0.7.0.1
 */