package com.tencent.mobileqq.winkpublish.part;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.winkpublish.viewmodel.PublishJurisdictionViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishJurisdictionPart$3
  implements View.OnClickListener
{
  PublishJurisdictionPart$3(PublishJurisdictionPart paramPublishJurisdictionPart) {}
  
  public void onClick(View paramView)
  {
    PublishJurisdictionPart.a(this.a).d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishJurisdictionPart.3
 * JD-Core Version:    0.7.0.1
 */