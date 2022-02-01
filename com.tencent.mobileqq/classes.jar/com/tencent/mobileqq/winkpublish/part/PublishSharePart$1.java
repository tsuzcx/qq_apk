package com.tencent.mobileqq.winkpublish.part;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.winkpublish.util.FSToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishSharePart$1
  implements View.OnClickListener
{
  PublishSharePart$1(PublishSharePart paramPublishSharePart) {}
  
  public void onClick(View paramView)
  {
    if (PublishSharePart.a(this.a) != 0L)
    {
      PublishSharePart localPublishSharePart = this.a;
      if (localPublishSharePart.a(PublishSharePart.a(localPublishSharePart)) < 3000L) {}
    }
    else
    {
      FSToastUtil.a("当前权限状态下无法同步到qq空间", 1);
      PublishSharePart.a(this.a, System.currentTimeMillis());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishSharePart.1
 * JD-Core Version:    0.7.0.1
 */