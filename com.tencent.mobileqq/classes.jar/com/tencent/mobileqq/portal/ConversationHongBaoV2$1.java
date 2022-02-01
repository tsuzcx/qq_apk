package com.tencent.mobileqq.portal;

import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoListView;

class ConversationHongBaoV2$1
  implements Runnable
{
  ConversationHongBaoV2$1(ConversationHongBaoV2 paramConversationHongBaoV2) {}
  
  public void run()
  {
    FrameHelperActivity.b(true);
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_ConversationHongBaoV2", 2, "mTouchReleaseRunable  do Run");
    }
    if (this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.getScrollY() == 0) {
      return;
    }
    if (this.this$0.jdField_a_of_type_Int == 4)
    {
      this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(-this.this$0.d);
      if (Math.abs(this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.getScrollY() + this.this$0.d) > this.this$0.d * 1.0F / 13.0F) {
        this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(-this.this$0.d);
      }
    }
    for (;;)
    {
      if (!this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.n) {
        this.this$0.b(false);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      int i = ConversationHongBaoV2.a(this.this$0).a();
      int j = ConversationHongBaoV2.a(this.this$0).getVisibility();
      QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] mTouchReleaseRunable mProgressViewRed alpha = " + i + ",visibility = " + j);
      return;
      this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.setSpringbackOffset(0);
      if (this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.getScrollY() != 0) {
        this.this$0.jdField_a_of_type_ComTencentWidgetHongBaoListView.springBackTo(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.1
 * JD-Core Version:    0.7.0.1
 */