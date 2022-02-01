package com.tencent.mobileqq.hotpic;

import android.os.Handler;
import android.os.Message;

class HotPicPageView$3
  extends Handler
{
  HotPicPageView$3(HotPicPageView paramHotPicPageView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if (HotPicPageView.b) {
        return;
      }
      this.a.i();
      return;
    }
    if (HotPicPageView.b) {
      return;
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.getVisibility() == 0) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter != null))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$HotPicAdapter.getItemCount() == 0) {
        return;
      }
      i = this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a();
      if (i < 0) {
        return;
      }
      paramMessage = this.a.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.findViewHolderForPosition(i);
      if ((paramMessage != null) && ((paramMessage instanceof HotPicPageView.MyVideoViewHolder)))
      {
        paramMessage = (HotPicPageView.MyVideoViewHolder)paramMessage;
        if (paramMessage.jdField_a_of_type_Int == 0)
        {
          this.a.b(paramMessage, i);
          return;
        }
        paramMessage.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.3
 * JD-Core Version:    0.7.0.1
 */