package com.tencent.mobileqq.kandian.biz.push.mvp;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/push/mvp/RIJPushNotifyDialog$initCallback$1", "Landroid/view/View$OnAttachStateChangeListener;", "onViewAttachedToWindow", "", "v", "Landroid/view/View;", "onViewDetachedFromWindow", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPushNotifyDialog$initCallback$1
  implements View.OnAttachStateChangeListener
{
  public void onViewAttachedToWindow(@Nullable View paramView)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(RIJPushNotifyDialog.a(this.a));
  }
  
  public void onViewDetachedFromWindow(@Nullable View paramView)
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(RIJPushNotifyDialog.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.push.mvp.RIJPushNotifyDialog.initCallback.1
 * JD-Core Version:    0.7.0.1
 */