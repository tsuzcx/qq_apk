package com.tencent.mobileqq.kandian.biz.xtab;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/xtab/IKDXTabHomepageModeGuide;", "", "dismiss", "", "parent", "Landroid/widget/FrameLayout;", "hide", "resume", "setOnClickListener", "onClickListener", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/kandian/biz/xtab/OnGuideClickListener;", "show", "duration", "", "guideText", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IKDXTabHomepageModeGuide
{
  public abstract void a();
  
  public abstract void a(@NotNull FrameLayout paramFrameLayout);
  
  public abstract void a(@NotNull FrameLayout paramFrameLayout, int paramInt, @NotNull String paramString);
  
  public abstract void a(@NotNull Function1<? super IKDXTabHomepageModeGuide, Unit> paramFunction1);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.IKDXTabHomepageModeGuide
 * JD-Core Version:    0.7.0.1
 */