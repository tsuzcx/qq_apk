package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomCloseBtnModule$1
  implements View.OnClickListener
{
  CustomCloseBtnModule$1(CustomCloseBtnModule paramCustomCloseBtnModule) {}
  
  public void onClick(View paramView)
  {
    this.a.getEvent().post(new RoomCloseEvent());
    LogFactory.a().c(CustomCloseBtnModule.a(), "mCloseImageView");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.closebtn.CustomCloseBtnModule.1
 * JD-Core Version:    0.7.0.1
 */