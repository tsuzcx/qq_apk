package com.tencent.mobileqq.kandian.biz.debug;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/debug/DebugChannelListViewModel$channelListObserver$1", "Lcom/tencent/mobileqq/kandian/repo/feeds/ReadInJoyObserver;", "onAllChannelListUpdated", "", "success", "", "list", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ChannelInfo;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DebugChannelListViewModel$channelListObserver$1
  extends ReadInJoyObserver
{
  public void a(boolean paramBoolean, @Nullable List<? extends ChannelInfo> paramList)
  {
    if (paramList == null) {
      paramList = CollectionsKt.emptyList();
    }
    paramList = CollectionsKt.toMutableList((Collection)paramList);
    CollectionsKt.sortWith(paramList, (Comparator)DebugChannelListViewModel.channelListObserver.1.onAllChannelListUpdated.1.a);
    DebugChannelListViewModel.a(this.a).postValue(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.debug.DebugChannelListViewModel.channelListObserver.1
 * JD-Core Version:    0.7.0.1
 */