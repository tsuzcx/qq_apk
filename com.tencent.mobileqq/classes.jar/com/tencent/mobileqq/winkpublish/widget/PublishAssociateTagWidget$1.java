package com.tencent.mobileqq.winkpublish.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.winkpublish.event.PublishAssociateTagEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishAssociateTagWidget$1
  implements View.OnClickListener
{
  PublishAssociateTagWidget$1(PublishAssociateTagWidget paramPublishAssociateTagWidget) {}
  
  public void onClick(View paramView)
  {
    PublishAssociateTagEvent localPublishAssociateTagEvent = new PublishAssociateTagEvent(this.a.a.getText().toString());
    SimpleEventBus.getInstance().dispatchEvent(localPublishAssociateTagEvent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.PublishAssociateTagWidget.1
 * JD-Core Version:    0.7.0.1
 */