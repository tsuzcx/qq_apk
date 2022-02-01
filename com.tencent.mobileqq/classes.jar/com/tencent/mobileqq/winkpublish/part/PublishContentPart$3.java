package com.tencent.mobileqq.winkpublish.part;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishContentPart$3
  implements View.OnClickListener
{
  PublishContentPart$3(PublishContentPart paramPublishContentPart) {}
  
  public void onClick(View paramView)
  {
    if (PublishContentPart.c(this.a) != null) {
      if (!this.a.l)
      {
        this.a.l();
      }
      else
      {
        this.a.p();
        this.a.n();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishContentPart.3
 * JD-Core Version:    0.7.0.1
 */