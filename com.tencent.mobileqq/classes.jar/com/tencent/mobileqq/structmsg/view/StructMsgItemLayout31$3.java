package com.tencent.mobileqq.structmsg.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.qwallet.QWalletGdtAdManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;

class StructMsgItemLayout31$3
  implements View.OnClickListener
{
  StructMsgItemLayout31$3(StructMsgItemLayout31 paramStructMsgItemLayout31, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    QWalletHelperImpl.gotoQWalletHome((Activity)this.jdField_a_of_type_AndroidContentContext);
    QWalletGdtAdManager.a("public.tailplace.click", "", "", "2", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout31.3
 * JD-Core Version:    0.7.0.1
 */