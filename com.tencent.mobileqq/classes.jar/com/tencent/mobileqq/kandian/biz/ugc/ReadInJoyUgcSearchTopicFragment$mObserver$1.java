package com.tencent.mobileqq.kandian.biz.ugc;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/ugc/ReadInJoyUgcSearchTopicFragment$mObserver$1", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "onCreateTopic", "", "retCode", "", "topicID", "", "topicUrl", "", "onTopicInfoListFetched", "keywordList", "", "topicInfoList", "", "Lcom/tencent/mobileqq/kandian/repo/handler/TopicInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyUgcSearchTopicFragment$mObserver$1
  extends ReadInJoyObserver
{
  public void a(int paramInt, long paramLong, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "topicUrl");
    ThreadManager.getUIHandler().post((Runnable)new ReadInJoyUgcSearchTopicFragment.mObserver.1.onCreateTopic.1(this));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handle0xc16CreateTopic, topicID:");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("  topicUrl:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" result:");
    localStringBuilder.append(paramInt);
    QLog.d("ReadInJoyUgcSearchTopicFragment", 1, localStringBuilder.toString());
  }
  
  public void b(@NotNull List<String> paramList, @NotNull List<TopicInfo> paramList1)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "keywordList");
    Intrinsics.checkParameterIsNotNull(paramList1, "topicInfoList");
    ReadInJoyUgcSearchTopicFragment.a(this.a, paramList1);
    RIJDeliverUGCReportUtil.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyUgcSearchTopicFragment.mObserver.1
 * JD-Core Version:    0.7.0.1
 */