package com.tencent.mobileqq.kandian.biz.push.api.impl;

import com.tencent.mobileqq.kandian.repo.push.api.RIJTabObserverCallBack;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class KanDianMergeManagerImpl$readInJoyTabObserver$1$onMainVideoRedTabChange$1
  implements Runnable
{
  KanDianMergeManagerImpl$readInJoyTabObserver$1$onMainVideoRedTabChange$1(KanDianMergeManagerImpl.readInJoyTabObserver.1 param1) {}
  
  public final void run()
  {
    RIJTabObserverCallBack localRIJTabObserverCallBack = this.this$0.a.getRijTabObserverCallBack();
    if (localRIJTabObserverCallBack != null) {
      localRIJTabObserverCallBack.a(39, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.api.impl.KanDianMergeManagerImpl.readInJoyTabObserver.1.onMainVideoRedTabChange.1
 * JD-Core Version:    0.7.0.1
 */