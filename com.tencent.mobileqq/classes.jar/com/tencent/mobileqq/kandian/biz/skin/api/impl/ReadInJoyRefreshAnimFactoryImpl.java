package com.tencent.mobileqq.kandian.biz.skin.api.impl;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.skin.ReadInJoyRefreshAnimFactory;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoyRefreshAnimFactory;
import com.tencent.widget.pull2refresh.anim.IAnimManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/skin/api/impl/ReadInJoyRefreshAnimFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/skin/api/IReadInJoyRefreshAnimFactory;", "()V", "getAnimManger", "Lcom/tencent/widget/pull2refresh/anim/IAnimManager;", "context", "Landroid/content/Context;", "animType", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyRefreshAnimFactoryImpl
  implements IReadInJoyRefreshAnimFactory
{
  @Nullable
  public IAnimManager getAnimManger(@Nullable Context paramContext, int paramInt)
  {
    return (IAnimManager)this.$$delegate_0.getAnimManger(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.api.impl.ReadInJoyRefreshAnimFactoryImpl
 * JD-Core Version:    0.7.0.1
 */