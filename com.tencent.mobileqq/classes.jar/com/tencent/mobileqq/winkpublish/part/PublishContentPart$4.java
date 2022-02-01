package com.tencent.mobileqq.winkpublish.part;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkpublish.api.IPublishLauncher;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishContentPart$4
  implements View.OnClickListener
{
  PublishContentPart$4(PublishContentPart paramPublishContentPart) {}
  
  public void onClick(View paramView)
  {
    ((IPublishLauncher)QRoute.api(IPublishLauncher.class)).onPublishClick(this.a.c(), true, 1, QCircleConfigHelper.ak(), 1001);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishContentPart.4
 * JD-Core Version:    0.7.0.1
 */