package com.tencent.mobileqq.structmsg.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ecshop.temp.api.impl.EcshopMessageApiImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StructMsgItemLayout6$1
  implements View.OnClickListener
{
  StructMsgItemLayout6$1(StructMsgItemLayout6 paramStructMsgItemLayout6) {}
  
  public void onClick(View paramView)
  {
    EcshopMessageApiImpl.enterGdtCanvasActivity((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.a, (Activity)paramView.getContext());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6.1
 * JD-Core Version:    0.7.0.1
 */