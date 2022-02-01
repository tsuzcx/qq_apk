package com.tencent.mobileqq.kandian.biz.publisher.impls.component;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfoExFunctionKt;
import com.tencent.qphone.base.util.BaseApplication;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/component/UIDataTransferImpl;", "Lcom/tencent/tkd/weibo/data/IDataTransfer;", "()V", "hotTopicCallback", "Lcom/tencent/tkd/weibo/data/IDataTransfer$TopicCallback;", "observer", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "recentTopicCallback", "searchTopicCallback", "getMyFansList", "", "p0", "", "p1", "Lcom/tencent/tkd/weibo/data/IDataTransfer$ContactCallback;", "getMyFollowList", "getTweetHotList", "pageId", "", "callback", "getTweetRecentTopicList", "getTweetSearchTopicList", "wording", "", "onRelease", "onTopicListRetrieved", "topicInfoList", "", "Lcom/tencent/mobileqq/kandian/repo/handler/TopicInfo;", "requestTopicInfoList", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UIDataTransferImpl
  implements IDataTransfer
{
  private final ReadInJoyObserver a = (ReadInJoyObserver)new UIDataTransferImpl.observer.1(this);
  private IDataTransfer.TopicCallback b;
  private IDataTransfer.TopicCallback c;
  private IDataTransfer.TopicCallback d;
  
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
      while (paramList.hasNext())
      {
        TopicInfo localTopicInfo = (TopicInfo)paramList.next();
        BaseApplication localBaseApplication = BaseApplicationImpl.context;
        Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplicationImpl.context");
        ((ArrayList)localObject).add(TopicInfoExFunctionKt.a(localTopicInfo, (Context)localBaseApplication));
      }
      if (paramTopicCallback != null) {
        paramTopicCallback.a(0, "", null, true, (List)localObject);
      }
    }
  }
  
  private final void a(String paramString)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a);
    ReadInJoyLogicEngine.a().g(paramString);
  }
  
  public void a()
  {
    IDataTransfer.TopicCallback localTopicCallback = (IDataTransfer.TopicCallback)null;
    this.b = localTopicCallback;
    this.c = localTopicCallback;
    this.d = localTopicCallback;
    ReadInJoyLogicEngineEventDispatcher.a().b(this.a);
  }
  
  public void a(int paramInt, @NotNull IDataTransfer.TopicCallback paramTopicCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicCallback, "callback");
    a(null);
    this.b = paramTopicCallback;
  }
  
  public void a(@NotNull IDataTransfer.TopicCallback paramTopicCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramTopicCallback, "callback");
    a(null);
    this.d = paramTopicCallback;
  }
  
  public void a(@NotNull String paramString, int paramInt, @NotNull IDataTransfer.TopicCallback paramTopicCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "wording");
    Intrinsics.checkParameterIsNotNull(paramTopicCallback, "callback");
    a(paramString);
    this.c = paramTopicCallback;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.component.UIDataTransferImpl
 * JD-Core Version:    0.7.0.1
 */