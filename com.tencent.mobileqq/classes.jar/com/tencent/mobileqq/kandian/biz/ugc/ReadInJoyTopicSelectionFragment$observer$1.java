package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.databinding.ReadInJoyTopicListAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfoExFunctionKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.topicsdk.widget.RecentTopicLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/ugc/ReadInJoyTopicSelectionFragment$observer$1", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "onRecentTopicInfoListFetched", "", "recentTopicInfoList", "", "Lcom/tencent/mobileqq/kandian/repo/handler/TopicInfo;", "onTopicInfoListFetched", "keywordList", "", "", "remoteTopicList", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyTopicSelectionFragment$observer$1
  extends ReadInJoyObserver
{
  public void b(@Nullable List<TopicInfo> paramList)
  {
    if (paramList == null)
    {
      QLog.e("IphoneTitleBarFragment", 1, "recent topic returns null");
      return;
    }
    if (paramList.isEmpty())
    {
      ReadInJoyTopicSelectionFragment.c(this.a).setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.i("IphoneTitleBarFragment", 2, "recent topic do not has content");
      }
      return;
    }
    ReadInJoyTopicSelectionFragment.c(this.a).setVisibility(0);
    RecentTopicLayout localRecentTopicLayout = ReadInJoyTopicSelectionFragment.c(this.a);
    QBaseActivity localQBaseActivity = this.a.getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
    localRecentTopicLayout.a(TopicInfoExFunctionKt.a(paramList, (Context)localQBaseActivity), false);
    if (QLog.isColorLevel()) {
      QLog.i("IphoneTitleBarFragment", 2, "recent topic has content and show");
    }
  }
  
  public void b(@NotNull List<String> paramList, @NotNull List<TopicInfo> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "keywordList");
    Intrinsics.checkParameterIsNotNull(paramList1, "remoteTopicList");
    if (paramList.isEmpty())
    {
      paramList = this.a.getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(paramList, "qBaseActivity");
      paramList = TopicInfoExFunctionKt.a(paramList1, (Context)paramList);
      TweetTopicItem localTweetTopicItem = new TweetTopicItem(null, null, null, 0L, null, 0L, null, 127, null);
      localTweetTopicItem.a("title");
      String str = this.a.getString(2131915544);
      Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.readinjoy_topic_recommended)");
      localTweetTopicItem.c(str);
      paramList.add(0, localTweetTopicItem);
      ReadInJoyTopicSelectionFragment.a(this.a).a(paramList, "");
      ReadInJoyUtils.a(ReadInJoyTopicSelectionFragment.b(this.a), paramList1, "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyTopicSelectionFragment.observer.1
 * JD-Core Version:    0.7.0.1
 */