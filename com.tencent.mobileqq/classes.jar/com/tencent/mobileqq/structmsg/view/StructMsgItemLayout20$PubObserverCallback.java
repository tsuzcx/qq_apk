package com.tencent.mobileqq.structmsg.view;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.app.HardCodeUtil;

class StructMsgItemLayout20$PubObserverCallback
  extends IPublicAccountObserver.OnCallback
{
  StructMsgItemLayout20.Holder jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder = null;
  
  public StructMsgItemLayout20$PubObserverCallback(StructMsgItemLayout20 paramStructMsgItemLayout20, StructMsgItemLayout20.Holder paramHolder)
  {
    this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder = paramHolder;
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder;
    if (paramString != null)
    {
      paramString.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714402));
        this.jdField_a_of_type_ComTencentMobileqqStructmsgViewStructMsgItemLayout20$Holder.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout20.PubObserverCallback
 * JD-Core Version:    0.7.0.1
 */