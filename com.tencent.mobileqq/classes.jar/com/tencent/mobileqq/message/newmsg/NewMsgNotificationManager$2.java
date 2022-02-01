package com.tencent.mobileqq.message.newmsg;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class NewMsgNotificationManager$2
  extends ClickableSpan
{
  NewMsgNotificationManager$2(NewMsgNotificationManager paramNewMsgNotificationManager, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    NewMsgNotificationManager.a(this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.jdField_a_of_type_ComTencentMobileqqMessageNewmsgNewMsgNotificationManager.a.getApp().getResources().getColor(2131167041));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.message.newmsg.NewMsgNotificationManager.2
 * JD-Core Version:    0.7.0.1
 */