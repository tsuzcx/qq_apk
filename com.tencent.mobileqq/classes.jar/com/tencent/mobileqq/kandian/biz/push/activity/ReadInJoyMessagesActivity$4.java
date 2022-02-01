package com.tencent.mobileqq.kandian.biz.push.activity;

import android.view.View;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyMessagesActivity$4
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyMessagesActivity$4(ReadInJoyMessagesActivity paramReadInJoyMessagesActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0) {
      ReadInJoyLogicEngine.a().a(this.a, this.c.getActivity());
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.activity.ReadInJoyMessagesActivity.4
 * JD-Core Version:    0.7.0.1
 */