package com.tencent.mobileqq.flashshow.presenter.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.flashshow.api.bean.FSPersonalDetailBean;
import com.tencent.mobileqq.flashshow.launcher.FSNativeLauncher;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002;
import com.tencent.mobileqq.flashshow.report.dc.FSLpReportDc11002.DataBuilder;
import com.tencent.mobileqq.flashshow.widgets.common.FSExpandableTextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomInfo;
import feedcloud.FeedCloudMeta.StUser;

public class FSFeedChildBottomInfoPresenter
  extends FSBaseFeedChildPresenter<FeedCloudMeta.StFeed>
  implements View.OnClickListener
{
  private LinearLayout f;
  private TextView g;
  private FSExpandableTextView h;
  private TextView i;
  private View j;
  private TextView k;
  
  private void a(FeedCloudMeta.StFeed paramStFeed)
  {
    this.k.setVisibility(8);
    if (TextUtils.isEmpty(paramStFeed.recomInfo.recomReason.get())) {
      return;
    }
    this.k.setVisibility(0);
    this.k.setText(paramStFeed.recomInfo.recomReason.get());
  }
  
  private void b(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    if (this.j == null)
    {
      QLog.d("FSFeedChildBottomInfoPresenter", 1, "[updateFeedMusicNameView] music view not is null.");
      return;
    }
    paramStFeed = this.i;
    if (paramStFeed == null)
    {
      QLog.d("FSFeedChildBottomInfoPresenter", 1, "[updateFeedMusicNameView] music name view should not be null.");
      return;
    }
    paramStFeed.setVisibility(8);
    this.j.setVisibility(8);
  }
  
  private void c(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    TextView localTextView = this.g;
    if (localTextView == null)
    {
      QLog.d("FSFeedChildBottomInfoPresenter", 1, "[updateAuthorNameView] author name view should not be null.");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("@");
    localStringBuilder.append(paramStFeed.poster.nick.get());
    localTextView.setText(localStringBuilder.toString());
  }
  
  private void d(@NonNull FeedCloudMeta.StFeed paramStFeed)
  {
    FSExpandableTextView localFSExpandableTextView = this.h;
    if (localFSExpandableTextView == null)
    {
      QLog.d("FSFeedChildBottomInfoPresenter", 1, "[updateFeedPostContentRichText] current feed post content view should be not null.");
      return;
    }
    localFSExpandableTextView.getSourceTextView().setOnClickListener(new FSFeedChildBottomInfoPresenter.RichTextSourceClickListener(null));
    this.h.setOnClickHashTagListener(new FSFeedChildBottomInfoPresenter.RichTextClickHashTagListener(null));
    this.h.setText(paramStFeed.content.get(), true, new FSFeedChildBottomInfoPresenter.RichTextAtClickListener(null));
    this.h.setVisibility(0);
    this.h.setOnClickListener(new FSFeedChildBottomInfoPresenter.RichTextViewClickListener(null));
  }
  
  public void a(@NonNull View paramView)
  {
    super.a(paramView);
    this.f = ((LinearLayout)paramView.findViewById(2131433365));
    this.g = ((TextView)paramView.findViewById(2131433358));
    this.g.setOnClickListener(this);
    this.h = ((FSExpandableTextView)paramView.findViewById(2131433368));
    this.j = paramView.findViewById(2131433320);
    this.i = ((TextView)paramView.findViewById(2131433321));
    this.k = ((TextView)paramView.findViewById(2131433373));
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    super.a(paramStFeed, paramInt);
    if (paramStFeed == null)
    {
      QLog.d("FSFeedChildBottomInfoPresenter", 1, "[onBindData] data should not be null.");
      return;
    }
    a(false);
    c(paramStFeed);
    d(paramStFeed);
    b(paramStFeed);
    a(paramStFeed);
  }
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    LinearLayout localLinearLayout = this.f;
    if (localLinearLayout == null) {
      return;
    }
    int m;
    if (paramBoolean) {
      m = 4;
    } else {
      m = 0;
    }
    localLinearLayout.setVisibility(m);
  }
  
  void b(View paramView)
  {
    FSPersonalDetailBean localFSPersonalDetailBean = new FSPersonalDetailBean(e());
    localFSPersonalDetailBean.setUser((FeedCloudMeta.StUser)((FeedCloudMeta.StFeed)this.b).poster.get());
    FSNativeLauncher.a(paramView.getContext(), localFSPersonalDetailBean);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131433358)
    {
      FSLpReportDc11002.a(new FSLpReportDc11002.DataBuilder((FeedCloudMeta.StFeed)this.b, e()).a(5).b(2).a(((FeedCloudMeta.StFeed)this.b).poster.id.get()).g(this.c));
      b(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildBottomInfoPresenter
 * JD-Core Version:    0.7.0.1
 */