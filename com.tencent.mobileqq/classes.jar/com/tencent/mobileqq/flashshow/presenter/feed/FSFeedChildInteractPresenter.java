package com.tencent.mobileqq.flashshow.presenter.feed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.flashshow.api.bean.FSInitBean;
import com.tencent.mobileqq.flashshow.api.bean.FSPersonalDetailBean;
import com.tencent.mobileqq.flashshow.api.bean.FSReportBean;
import com.tencent.mobileqq.flashshow.bean.FSCommentInfo;
import com.tencent.mobileqq.flashshow.bean.FSShareInfo;
import com.tencent.mobileqq.flashshow.data.FSDataCenter;
import com.tencent.mobileqq.flashshow.ioc.IFSFeedIoc;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.request.like.FSLikeManager;
import com.tencent.mobileqq.flashshow.thread.FSThreadUtils;
import com.tencent.mobileqq.flashshow.utils.FSCommonUtil;
import com.tencent.mobileqq.flashshow.widgets.common.FSAvatarView;
import com.tencent.mobileqq.flashshow.widgets.common.FSFollowView;
import com.tencent.mobileqq.flashshow.widgets.common.FSPlusFollowView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StBusiInfoCommentListData;

public class FSFeedChildInteractPresenter
  extends FSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
  implements View.OnClickListener, Observer<FeedCloudMeta.StFeed>
{
  private LinearLayout f;
  private TextView g;
  private TextView h;
  private TextView i;
  private View j;
  private View k;
  private View l;
  private ImageView m;
  private FSAvatarView n;
  private FSPlusFollowView o;
  
  private void a(FSFollowView paramFSFollowView)
  {
    paramFSFollowView.setReportListener(new FSFeedChildInteractPresenter.1(this));
  }
  
  private void b(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    FSPlusFollowView localFSPlusFollowView = this.o;
    if (localFSPlusFollowView == null)
    {
      QLog.d("FSFeedChildInteractPresenter", 1, "[updateAuthorFollowView] author attention view not be null.");
      return;
    }
    localFSPlusFollowView.setUserData((FeedCloudMeta.StUser)paramStFeed.poster.get(), paramStFeed);
  }
  
  private void c(View paramView)
  {
    FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder((FeedCloudMeta.StFeed)this.b, e()).a(4).b(2).a(((FeedCloudMeta.StFeed)this.b).poster.id.get()).g(this.c));
    b(paramView);
  }
  
  private void c(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    TextView localTextView = this.g;
    int i1 = 1;
    if (localTextView == null)
    {
      QLog.d("FSFeedChildInteractPresenter", 1, "[updateFeedShareText] video like text should not be null.");
      return;
    }
    if (paramStFeed.likeInfo.count.get() == 0)
    {
      this.g.setText(2131889720);
      this.g.setTextSize(12.0F);
    }
    else
    {
      this.g.setText(FSCommonUtil.a(paramStFeed.likeInfo.count.get()));
      this.g.setTextSize(13.0F);
    }
    if (paramStFeed.likeInfo.status.get() != 1) {
      i1 = 0;
    }
    if (i1 != 0) {
      paramStFeed = this.j.getContext().getResources().getDrawable(2130840432);
    } else {
      paramStFeed = this.j.getContext().getResources().getDrawable(2130840431);
    }
    this.m.setImageDrawable(paramStFeed);
  }
  
  private void d(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.h == null)
    {
      QLog.d("FSFeedChildInteractPresenter", 1, "[updateFeedCommentText] video comment text should not be null.");
      return;
    }
    QLog.d("FSFeedChildInteractPresenter", 1, new Object[] { "[updateFeedCommentText] data: ", Integer.valueOf(paramStFeed.commentCount.get()), " | feed id: ", g(paramStFeed), " | hash code: ", Integer.valueOf(hashCode()) });
    if (paramStFeed.commentCount.get() == 0)
    {
      this.h.setText(2131889705);
      this.h.setTextSize(12.0F);
      return;
    }
    this.h.setText(FSCommonUtil.a(paramStFeed.commentCount.get()));
    this.h.setTextSize(13.0F);
  }
  
  private void e(@NonNull FeedCloudMeta.StFeed paramStFeed) {}
  
  private void f()
  {
    FSLikeManager.b((FeedCloudMeta.StFeed)this.b);
    if (this.b == null) {
      return;
    }
    FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)this.b;
    FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder(localStFeed, e()).a(36).b(3).a(localStFeed.poster.id.get()).g(this.c));
  }
  
  private void f(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.n == null)
    {
      QLog.d("FSFeedChildInteractPresenter", 1, "[updateAuthorAvatarView] author avatar view not be null.");
      return;
    }
    if (paramStFeed == null) {
      paramStFeed = null;
    } else {
      paramStFeed = paramStFeed.poster;
    }
    if (paramStFeed == null)
    {
      QLog.d("FSFeedChildInteractPresenter", 1, "[updateAuthorAvatarView] user info should not be null.");
      return;
    }
    this.n.setAvatarUser(paramStFeed);
  }
  
  private String g(FeedCloudMeta.StFeed paramStFeed)
  {
    if (paramStFeed == null) {
      return "";
    }
    return paramStFeed.id.get();
  }
  
  private void g()
  {
    if (this.a == null)
    {
      QLog.d("FSFeedChildInteractPresenter", 1, "[openSharePanel] feed ioc should not be null.");
      return;
    }
    FSShareInfo localFSShareInfo = new FSShareInfo();
    localFSShareInfo.a = ((FeedCloudMeta.StFeed)this.b);
    localFSShareInfo.c = e();
    if ((e() != null) && ("pg_ks_explore_page".equals(e().getPageId()))) {
      localFSShareInfo.i = true;
    }
    localFSShareInfo.h = i();
    this.a.a("event_open_share", new Object[] { localFSShareInfo });
  }
  
  private void h()
  {
    if (this.a == null)
    {
      QLog.d("FSFeedChildInteractPresenter", 1, "[openCommentPanel] feed ioc should not be null.");
      return;
    }
    FSCommentInfo localFSCommentInfo = new FSCommentInfo();
    localFSCommentInfo.a = ((FeedCloudMeta.StFeed)this.b);
    localFSCommentInfo.d = e();
    localFSCommentInfo.e = 100;
    this.a.a("event_open_comment", new Object[] { localFSCommentInfo });
  }
  
  private boolean i()
  {
    String str = HostDataTransUtils.getAccount();
    if ((this.b != null) && (((FeedCloudMeta.StFeed)this.b).poster != null) && (((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)this.b).poster.get()).id != null) && (str != null)) {
      return ((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)this.b).poster.get()).id.get().equals(str);
    }
    return false;
  }
  
  private void j()
  {
    FSInitBean localFSInitBean = k();
    if (localFSInitBean != null)
    {
      if (localFSInitBean.getBusiInfoData() == null) {
        return;
      }
      QQCircleFeedBase.StBusiInfoCommentListData localStBusiInfoCommentListData = new QQCircleFeedBase.StBusiInfoCommentListData();
      try
      {
        localStBusiInfoCommentListData.mergeFrom(localFSInitBean.getBusiInfoData());
        localStBusiInfoCommentListData.setHasFlag(true);
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      if (!localStBusiInfoCommentListData.has()) {
        return;
      }
      h();
      localFSInitBean.setBusiInfoData(null);
    }
  }
  
  private FSInitBean k()
  {
    View localView = this.k;
    if ((localView != null) && ((localView.getContext() instanceof Activity)) && (((Activity)this.k.getContext()).getIntent() != null) && (((Activity)this.k.getContext()).getIntent().hasExtra("fs_key_bundle_common_init_bean"))) {
      return (FSInitBean)((Activity)this.k.getContext()).getIntent().getSerializableExtra("fs_key_bundle_common_init_bean");
    }
    return null;
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.n = ((FSAvatarView)paramView.findViewById(2131433354));
    this.o = ((FSPlusFollowView)paramView.findViewById(2131433356));
    this.f = ((LinearLayout)paramView.findViewById(2131433390));
    this.g = ((TextView)paramView.findViewById(2131433366));
    this.h = ((TextView)paramView.findViewById(2131433363));
    this.i = ((TextView)paramView.findViewById(2131433370));
    this.j = paramView.findViewById(2131433401);
    this.k = paramView.findViewById(2131433400);
    this.l = paramView.findViewById(2131433404);
    this.m = ((ImageView)paramView.findViewById(2131433402));
    this.o.setFollowedDismiss(true);
    this.n.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.l.setOnClickListener(this);
    a(this.o);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.b == null) {
      return;
    }
    if (!paramStFeed.id.get().equals(((FeedCloudMeta.StFeed)this.b).id.get())) {
      return;
    }
    c(paramStFeed);
    d(paramStFeed);
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    if (paramStFeed == null)
    {
      QLog.d("FSFeedChildInteractPresenter", 1, "[onBindData] data should not be null.");
      return;
    }
    a(false);
    c(paramStFeed);
    d(paramStFeed);
    e(paramStFeed);
    b(paramStFeed);
    f(paramStFeed);
    FSDataCenter.a().a(paramStFeed, this);
    FSThreadUtils.b(new FSFeedChildInteractPresenter.2(this));
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    LinearLayout localLinearLayout = this.f;
    if (localLinearLayout == null) {
      return;
    }
    int i1;
    if (paramBoolean) {
      i1 = 4;
    } else {
      i1 = 0;
    }
    localLinearLayout.setVisibility(i1);
  }
  
  void b(View paramView)
  {
    FSPersonalDetailBean localFSPersonalDetailBean = new FSPersonalDetailBean(e());
    localFSPersonalDetailBean.setUser((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)this.b).poster.get());
    FSNativeLauncher.a(paramView.getContext(), localFSPersonalDetailBean);
  }
  
  public void onClick(View paramView)
  {
    int i1;
    if (paramView == null) {
      i1 = -1;
    } else {
      i1 = paramView.getId();
    }
    if (i1 == 2131433401) {
      f();
    } else if (i1 == 2131433400) {
      h();
    } else if (i1 == 2131433404) {
      g();
    } else if (i1 == 2131433354) {
      c(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    super.onReceiveEvent(paramSimpleBaseEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildInteractPresenter
 * JD-Core Version:    0.7.0.1
 */