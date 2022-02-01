package com.tencent.mobileqq.now.message;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.now.roport.NowQQLiveDataReport;
import com.tencent.mobileqq.now.utils.NowRoomUtil;
import com.tencent.mobileqq.now.utils.UrlUtil;
import com.tencent.qphone.base.util.QLog;

class MessageReceivingAdapter$2
  extends OnArkViewTouchListener
{
  MessageReceivingAdapter$2(MessageReceivingAdapter paramMessageReceivingAdapter, int paramInt, MessageForArkApp paramMessageForArkApp) {}
  
  public boolean onClick(View paramView)
  {
    j = 0;
    NowQQLiveDataReport.b(this.jdField_a_of_type_Int + 1, ChatMessageHelper.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp), "1");
    paramView = ChatMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkApp);
    if (TextUtils.isEmpty(paramView)) {
      return false;
    }
    paramView = UrlUtil.a(UrlUtil.a(paramView, "fromid", String.valueOf(60013)), "startsrc", String.valueOf(60013));
    try
    {
      String str = UrlUtil.a(paramView, "roomid");
      i = j;
      if (!TextUtils.isEmpty(str)) {
        i = Integer.parseInt(str);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("MessageReceivingAdapter", 4, localException, new Object[0]);
        int i = j;
      }
    }
    Log.i("MessageReceivingAdapter", "jumpUrl = " + paramView);
    return NowRoomUtil.a(MessageReceivingAdapter.a(this.jdField_a_of_type_ComTencentMobileqqNowMessageMessageReceivingAdapter), paramView, i, 60012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.MessageReceivingAdapter.2
 * JD-Core Version:    0.7.0.1
 */