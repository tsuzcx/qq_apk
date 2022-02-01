package com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.video.playfeedback.MsgLayoutHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelper;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IMsgLayoutHelperFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/impl/MsgLayoutHelperFactoryImpl;", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IMsgLayoutHelperFactory;", "()V", "create", "Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/api/IMsgLayoutHelper;", "root", "Landroid/view/View;", "listener", "Landroid/view/View$OnClickListener;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class MsgLayoutHelperFactoryImpl
  implements IMsgLayoutHelperFactory
{
  @NotNull
  public IMsgLayoutHelper create(@NotNull View paramView, @Nullable View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "root");
    return (IMsgLayoutHelper)new MsgLayoutHelper(paramView, paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.api.impl.MsgLayoutHelperFactoryImpl
 * JD-Core Version:    0.7.0.1
 */