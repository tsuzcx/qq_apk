package com.tencent.mobileqq.kandian.biz.dislike;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyFeedbackPopupWindow$4
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyFeedbackPopupWindow$4(ReadInJoyFeedbackPopupWindow paramReadInJoyFeedbackPopupWindow, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (paramInt != 0) {
      return;
    }
    if (!ReadInJoyFeedbackPopupWindow.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyFeedbackPopupWindow)) {
      return;
    }
    if (ReadInJoyFeedbackPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyFeedbackPopupWindow, "deleteFeeds")) {
      FastWebRequestUtil.a(ReadInJoyFeedbackPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyFeedbackPopupWindow), ReadInJoyFeedbackPopupWindow.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeReadInJoyFeedbackPopupWindow));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyFeedbackPopupWindow.4
 * JD-Core Version:    0.7.0.1
 */