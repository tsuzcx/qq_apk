package com.tencent.mobileqq.kandian.biz.dislike;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyFeedbackPopupWindow$4
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyFeedbackPopupWindow$4(ReadInJoyFeedbackPopupWindow paramReadInJoyFeedbackPopupWindow, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    this.a.dismiss();
    if (paramInt != 0) {
      return;
    }
    if (!ReadInJoyFeedbackPopupWindow.o(this.b)) {
      return;
    }
    if (ReadInJoyFeedbackPopupWindow.a(this.b, "deleteFeeds")) {
      FastWebRequestUtil.a(ReadInJoyFeedbackPopupWindow.c(this.b), ReadInJoyFeedbackPopupWindow.p(this.b));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyFeedbackPopupWindow.4
 * JD-Core Version:    0.7.0.1
 */