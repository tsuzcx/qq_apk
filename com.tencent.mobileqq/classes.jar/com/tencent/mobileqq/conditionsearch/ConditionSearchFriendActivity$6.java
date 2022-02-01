package com.tencent.mobileqq.conditionsearch;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.qphone.base.util.QLog;

class ConditionSearchFriendActivity$6
  implements Runnable
{
  ConditionSearchFriendActivity$6(ConditionSearchFriendActivity paramConditionSearchFriendActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = this.this$0.a.getHeight();
    Object localObject = this.this$0;
    ConditionSearchFriendActivity.c((ConditionSearchFriendActivity)localObject, this.a - (((ConditionSearchFriendActivity)localObject).d.getBottom() - i) + this.b);
    int j = this.this$0.getResources().getDisplayMetrics().heightPixels;
    int k = this.this$0.getResources().getDisplayMetrics().widthPixels;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(")value: ");
      ((StringBuilder)localObject).append(ConditionSearchFriendActivity.a(this.this$0));
      ((StringBuilder)localObject).append(" itemTop:");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("  pvTop:");
      ((StringBuilder)localObject).append(this.this$0.d.getBottom() - i);
      ((StringBuilder)localObject).append("  itemHeight:");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(" RootBottom:");
      ((StringBuilder)localObject).append(this.this$0.d.getBottom());
      ((StringBuilder)localObject).append(" pvHeight:");
      ((StringBuilder)localObject).append(i);
      QLog.d("meassure", 2, ((StringBuilder)localObject).toString());
    }
    if ((ConditionSearchFriendActivity.a(this.this$0) > 0) && (this.a != -1))
    {
      if (this.b == -1) {
        return;
      }
      this.this$0.e.scrollBy(0, ConditionSearchFriendActivity.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.6
 * JD-Core Version:    0.7.0.1
 */