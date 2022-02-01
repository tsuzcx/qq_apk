package com.tencent.mobileqq.kandian.biz.push.api.impl;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.push.ReadInJoyTabObserver;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/push/api/impl/KanDianMergeManagerImpl$readInJoyTabObserver$1", "Lcom/tencent/mobileqq/kandian/biz/push/ReadInJoyTabObserver;", "notifyRedInfoChange", "", "onComponentLastReadShow", "v", "Landroid/view/View;", "onMainVideoRedTabChange", "updateIndepentTabState", "type", "", "data", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class KanDianMergeManagerImpl$readInJoyTabObserver$1
  extends ReadInJoyTabObserver
{
  public void a()
  {
    if (ReadInJoyHelper.l()) {
      UiThreadUtil.a((Runnable)new KanDianMergeManagerImpl.readInJoyTabObserver.1.onMainVideoRedTabChange.1(this));
    }
  }
  
  public void a(int paramInt, @Nullable Object paramObject)
  {
    super.a(paramInt, paramObject);
    if (!RIJShowKanDianTabSp.c()) {
      return;
    }
    UiThreadUtil.a((Runnable)new KanDianMergeManagerImpl.readInJoyTabObserver.1.updateIndepentTabState.1(this, paramInt, paramObject));
  }
  
  public void a(@Nullable View paramView)
  {
    super.a(paramView);
    a(1, paramView);
  }
  
  public void j()
  {
    if (!RIJShowKanDianTabSp.c()) {
      return;
    }
    UiThreadUtil.a((Runnable)new KanDianMergeManagerImpl.readInJoyTabObserver.1.notifyRedInfoChange.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.api.impl.KanDianMergeManagerImpl.readInJoyTabObserver.1
 * JD-Core Version:    0.7.0.1
 */