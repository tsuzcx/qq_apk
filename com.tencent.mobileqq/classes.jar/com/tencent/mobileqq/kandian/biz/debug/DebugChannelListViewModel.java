package com.tencent.mobileqq.kandian.biz.debug;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/debug/DebugChannelListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_channelInfoList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/ChannelInfo;", "_list", "channelInfoList", "Landroidx/lifecycle/LiveData;", "getChannelInfoList", "()Landroidx/lifecycle/LiveData;", "channelListObserver", "com/tencent/mobileqq/kandian/biz/debug/DebugChannelListViewModel$channelListObserver$1", "Lcom/tencent/mobileqq/kandian/biz/debug/DebugChannelListViewModel$channelListObserver$1;", "getList", "onCleared", "", "requestAllChannel", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DebugChannelListViewModel
  extends ViewModel
{
  private final MutableLiveData<List<ChannelInfo>> a = new MutableLiveData();
  private final DebugChannelListViewModel.channelListObserver.1 b = new DebugChannelListViewModel.channelListObserver.1(this);
  private final MutableLiveData<List<ChannelInfo>> c = new MutableLiveData();
  
  public DebugChannelListViewModel()
  {
    ReadInJoyLogicEngineEventDispatcher.a().a((ReadInJoyObserver)this.b);
    a();
  }
  
  public final void a()
  {
    ReadInJoyLogicEngine.a().a(-1, 1);
  }
  
  protected void onCleared()
  {
    super.onCleared();
    ReadInJoyLogicEngineEventDispatcher.a().b((ReadInJoyObserver)this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.debug.DebugChannelListViewModel
 * JD-Core Version:    0.7.0.1
 */