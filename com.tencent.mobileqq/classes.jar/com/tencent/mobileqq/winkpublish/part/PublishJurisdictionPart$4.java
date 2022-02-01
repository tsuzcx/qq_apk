package com.tencent.mobileqq.winkpublish.part;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.winkpublish.util.FSToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishJurisdictionPart$4
  implements View.OnClickListener
{
  PublishJurisdictionPart$4(PublishJurisdictionPart paramPublishJurisdictionPart) {}
  
  public void onClick(View paramView)
  {
    if (PublishJurisdictionPart.b(this.a) != 0L)
    {
      PublishJurisdictionPart localPublishJurisdictionPart = this.a;
      if (localPublishJurisdictionPart.a(PublishJurisdictionPart.b(localPublishJurisdictionPart)) < 3000L) {}
    }
    else
    {
      FSToastUtil.a("当前权限设置状态下无法推荐给同城的人", 1);
      PublishJurisdictionPart.a(this.a, System.currentTimeMillis());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishJurisdictionPart.4
 * JD-Core Version:    0.7.0.1
 */