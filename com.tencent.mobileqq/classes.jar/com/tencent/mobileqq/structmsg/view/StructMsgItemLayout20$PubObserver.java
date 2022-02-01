package com.tencent.mobileqq.structmsg.view;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountObserver;

class StructMsgItemLayout20$PubObserver
  extends PublicAccountObserver
{
  StructMsgItemLayout20.Holder jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder = null;
  
  public StructMsgItemLayout20$PubObserver(StructMsgItemLayout20 paramStructMsgItemLayout20, StructMsgItemLayout20.Holder paramHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder = paramHolder;
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714481));
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.PubObserver
 * JD-Core Version:    0.7.0.1
 */