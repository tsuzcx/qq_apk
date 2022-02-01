package com.tencent.mobileqq.flashshow.list.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.flashshow.api.bean.FSLayerPageInitBean;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StUser;

class FSDefaultMessagePresenter$3
  implements View.OnClickListener
{
  FSDefaultMessagePresenter$3(FSDefaultMessagePresenter paramFSDefaultMessagePresenter) {}
  
  public void onClick(View paramView)
  {
    if (this.a.d.feed.get() != null)
    {
      FSLayerPageInitBean localFSLayerPageInitBean = new FSLayerPageInitBean(this.a.e());
      localFSLayerPageInitBean.setSourceType(1002);
      localFSLayerPageInitBean.setFeedId(this.a.d.feed.id.get());
      localFSLayerPageInitBean.setUserId(this.a.d.feed.poster.id.get());
      localFSLayerPageInitBean.setCreateTime(this.a.d.feed.createTime.get());
      FSNativeLauncher.a(paramView.getContext(), localFSLayerPageInitBean);
    }
    FSDefaultMessagePresenter.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSDefaultMessagePresenter.3
 * JD-Core Version:    0.7.0.1
 */