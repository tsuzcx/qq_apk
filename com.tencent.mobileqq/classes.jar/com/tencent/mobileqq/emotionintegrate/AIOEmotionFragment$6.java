package com.tencent.mobileqq.emotionintegrate;

import android.app.Activity;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;

class AIOEmotionFragment$6
  implements View.OnTouchListener
{
  AIOEmotionFragment$6(AIOEmotionFragment paramAIOEmotionFragment, MsgEmoticonPreviewData paramMsgEmoticonPreviewData) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.b.setBackgroundColor(Color.parseColor("#F7F7F7"));
      paramView = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateMsgEmoticonPreviewData.a();
      if (QLog.isColorLevel()) {
        QLog.i("AIOEmotionFragment", 2, "updateSelfEmotionDetail id:" + paramView);
      }
      JumpUtil.b((Activity)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a, paramView);
      paramView = (Activity)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a;
      if ((paramView != null) && (!paramView.isFinishing())) {
        paramView.finish();
      }
    }
    for (;;)
    {
      return false;
      if (paramMotionEvent.getAction() == 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.b.setBackgroundColor(Color.parseColor("#DEDEDE"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.6
 * JD-Core Version:    0.7.0.1
 */