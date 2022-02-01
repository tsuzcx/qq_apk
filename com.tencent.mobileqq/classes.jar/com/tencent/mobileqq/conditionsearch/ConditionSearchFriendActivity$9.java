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
      ((StringBuilder)localObject).append(this.a.S);
      ((StringBuilder)localObject).append(", isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", resultCode = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ConditionSearchFriendActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.a.S == 1) || (this.a.S == 2))
    {
      if (!paramBoolean)
      {
        this.a.a();
        QQToast.makeText(this.a, 2131888003, 0).show(this.a.getTitleBarHeight());
        return;
      }
      if (paramInt == 2)
      {
        this.a.a();
        localObject = this.a;
        ((ConditionSearchFriendActivity)localObject).a(((ConditionSearchFriendActivity)localObject).S);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.9
 * JD-Core Version:    0.7.0.1
 */