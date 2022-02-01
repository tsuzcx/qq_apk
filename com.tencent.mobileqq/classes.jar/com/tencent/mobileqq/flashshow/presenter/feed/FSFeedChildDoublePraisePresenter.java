package com.tencent.mobileqq.flashshow.presenter.feed;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.bean.FSFeedSelectInfo;
import com.tencent.mobileqq.flashshow.bean.FSShareInfo;
import com.tencent.mobileqq.flashshow.ioc.IFSFeedIoc;
import com.tencent.mobileqq.flashshow.widgets.FSDoubleClickLayout;
import com.tencent.mobileqq.flashshow.widgets.FSDoublePraiseView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;

public class FSFeedChildDoublePraisePresenter
  extends FSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
{
  private FSDoublePraiseView f;
  private FSDoubleClickLayout g;
  
  private void f()
  {
    if (this.a == null)
    {
      QLog.d("FSFeedChildDoublePraisePresenter", 1, "[openSharePanel] feed ioc should not be null.");
      return;
    }
    FSShareInfo localFSShareInfo = new FSShareInfo();
    localFSShareInfo.a = ((FeedCloudMeta.StFeed)this.b);
    localFSShareInfo.c = e();
    if ((e() != null) && ("pg_ks_explore_page".equals(e().getPageId()))) {
      localFSShareInfo.i = true;
    }
    this.a.a("event_open_share", new Object[] { localFSShareInfo });
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.f = ((FSDoublePraiseView)paramView.findViewById(2131433351));
    this.g = ((FSDoubleClickLayout)paramView.findViewById(2131433364));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    this.f.setData(paramStFeed, paramInt);
    this.g.setOnDoubleClickListener(new FSFeedChildDoublePraisePresenter.1(this, paramInt));
    this.g.setOnTapClickListener(new FSFeedChildDoublePraisePresenter.2(this));
    this.g.setOnLongClickListener(new FSFeedChildDoublePraisePresenter.3(this));
  }
  
  public void d(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    super.d(paramFSFeedSelectInfo);
    paramFSFeedSelectInfo = this.f;
    if (paramFSFeedSelectInfo == null) {
      return;
    }
    paramFSFeedSelectInfo.b();
  }
  
  public void e(FSFeedSelectInfo paramFSFeedSelectInfo)
  {
    super.e(paramFSFeedSelectInfo);
    paramFSFeedSelectInfo = this.f;
    if (paramFSFeedSelectInfo == null) {
      return;
    }
    paramFSFeedSelectInfo.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildDoublePraisePresenter
 * JD-Core Version:    0.7.0.1
 */