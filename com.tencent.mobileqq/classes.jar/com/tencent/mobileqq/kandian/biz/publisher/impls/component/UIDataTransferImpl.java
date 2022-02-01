package com.tencent.mobileqq.kandian.biz.publisher.impls.component;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.tkd.topicsdk.bean.TweetTopicItem;
import com.tencent.tkd.weibo.data.IDataTransfer;
import com.tencent.tkd.weibo.data.IDataTransfer.ContactCallback;
import com.tencent.tkd.weibo.data.IDataTransfer.TopicCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/component/UIDataTransferImpl;", "Lcom/tencent/tkd/weibo/data/IDataTransfer;", "()V", "hotTopicCallback", "Lcom/tencent/tkd/weibo/data/IDataTransfer$TopicCallback;", "observer", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "searchTopicCallback", "getMyFansList", "", "p0", "", "p1", "Lcom/tencent/tkd/weibo/data/IDataTransfer$ContactCallback;", "getMyFollowList", "getTweetHotList", "pageId", "", "callback", "getTweetRecentTopicList", "getTweetSearchTopicList", "wording", "", "onRelease", "onTopicListRetrieved", "topicInfoList", "", "Lcom/tencent/mobileqq/kandian/repo/handler/TopicInfo;", "toTweetTopicItem", "Lcom/tencent/tkd/topicsdk/bean/TweetTopicItem;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UIDataTransferImpl
  implements IDataTransfer
{
  private final ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = (ReadInJoyObserver)new UIDataTransferImpl.observer.1(this);
  private IDataTransfer.TopicCallback jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer$TopicCallback;
  private IDataTransfer.TopicCallback b;
  
  private final TweetTopicItem a(@NotNull TopicInfo paramTopicInfo)
  {
    TweetTopicItem localTweetTopicItem = new TweetTopicItem(null, null, null, 0L, null, 31, null);
    localTweetTopicItem.a(String.valueOf(paramTopicInfo.a()));
    String str = paramTopicInfo.a();
    Intrinsics.checkExpressionValueIsNotNull(str, "topicTitle");
    localTweetTopicItem.c(str);
    paramTopicInfo = paramTopicInfo.c();
    Intrinsics.checkExpressionValueIsNotNull(paramTopicInfo, "topicCoverUrl");
    localTweetTopicItem.b(paramTopicInfo);
    return localTweetTopicItem;
  }
  
  private final void a(IDataTransfer.TopicCallback paramTopicCallback, List<TopicInfo> paramList)
  {
    Object localObject = (Collection)paramList;
    int i;
    if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      if (paramTopicCallback != null) {
        paramTopicCallback.a(0, "", null, true, null);
      }
    }
    else
    {
      localObject = new ArrayList();
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        ((ArrayList)localObject).add(a((TopicInfo)paramList.next()));
      }
      if (paramTopicCallback != null) {
        paramTopicCallback.a(0, "", null, true, (List)localObject);
      }
    }
  }
  
  public void a()
  {
    IDataTransfer.TopicCallback localTopicCallback = (IDataTransfer.TopicCallback)null;
    this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer$TopicCallback = localTopicCallback;
    this.b = localTopicCallback;
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void a(int paramInt, @NotNull IDataTransfer.TopicCallback paramTopicCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicCallback, "callback");
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyLogicEngine.a().g(null);
    this.jdField_a_of_type_ComTencentTkdWeiboDataIDataTransfer$TopicCallback = paramTopicCallback;
  }
  
  public void a(@NotNull IDataTransfer.TopicCallback paramTopicCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicCallback, "p0");
  }
  
  public void a(@NotNull String paramString, int paramInt, @NotNull IDataTransfer.TopicCallback paramTopicCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wording");
    Intrinsics.checkParameterIsNotNull(paramTopicCallback, "callback");
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ReadInJoyLogicEngine.a().g(paramString);
    this.b = paramTopicCallback;
  }
  
  public void a(@Nullable byte[] paramArrayOfByte, @NotNull IDataTransfer.ContactCallback paramContactCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramContactCallback, "p1");
  }
  
  public void b(@Nullable byte[] paramArrayOfByte, @NotNull IDataTransfer.ContactCallback paramContactCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramContactCallback, "p1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.component.UIDataTransferImpl
 * JD-Core Version:    0.7.0.1
 */