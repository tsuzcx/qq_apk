package com.tencent.mobileqq.conditionsearch;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.qphone.base.util.QLog;

class ConditionSearchFriendActivity$5
  implements Runnable
{
  ConditionSearchFriendActivity$5(ConditionSearchFriendActivity paramConditionSearchFriendActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int i = this.this$0.a.getHeight();
    ConditionSearchFriendActivity.a(this.this$0, this.a - (this.this$0.d.getBottom() - i) + this.b);
    int j = this.this$0.getResources().getDisplayMetrics().heightPixels;
    int k = this.this$0.getResources().getDisplayMetrics().widthPixels;
    if (QLog.isColorLevel()) {
      QLog.d("meassure", 2, "(" + k + "," + j + ")value: " + ConditionSearchFriendActivity.a(this.this$0) + " itemTop:" + this.a + "  pvTop:" + (this.this$0.d.getBottom() - i) + "  itemHeight:" + this.b + " RootBottom:" + this.this$0.d.getBottom() + " pvHeight:" + i);
    }
    if ((ConditionSearchFriendActivity.a(this.this$0) <= 0) || (this.a == -1) || (this.b == -1)) {
      return;
    }
    this.this$0.e.scrollBy(0, ConditionSearchFriendActivity.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.5
 * JD-Core Version:    0.7.0.1
 */