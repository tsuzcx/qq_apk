package com.tencent.mobileqq.kandian.biz.publisher.impls;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/ViewPagerImpl$SubViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isScrollEnabled", "", "()Z", "setScrollEnabled", "(Z)V", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
final class ViewPagerImpl$SubViewPager
  extends ViewPager
{
  private boolean a = true;
  
  public ViewPagerImpl$SubViewPager(@NotNull Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean onInterceptTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    return (this.a) && (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(@Nullable MotionEvent paramMotionEvent)
  {
    return (this.a) && (super.onTouchEvent(paramMotionEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.ViewPagerImpl.SubViewPager
 * JD-Core Version:    0.7.0.1
 */