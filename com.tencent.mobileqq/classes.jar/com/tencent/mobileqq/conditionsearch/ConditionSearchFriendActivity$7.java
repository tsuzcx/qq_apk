package com.tencent.mobileqq.conditionsearch;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.widget.QQToast;

class ConditionSearchFriendActivity$7
  extends Handler
{
  ConditionSearchFriendActivity$7(ConditionSearchFriendActivity paramConditionSearchFriendActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1000) && ((this.a.S == 1) || (this.a.S == 2)))
    {
      this.a.a();
      QQToast.makeText(this.a, 2131888003, 0).show(this.a.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.ConditionSearchFriendActivity.7
 * JD-Core Version:    0.7.0.1
 */