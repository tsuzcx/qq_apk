package com.tencent.tkd.weibo.utils;

import android.annotation.SuppressLint;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/utils/DrawableClickHelper;", "", "textView", "Landroid/widget/TextView;", "listener", "Lcom/tencent/tkd/weibo/utils/DrawableClickHelper$OnDrawableListener;", "(Landroid/widget/TextView;Lcom/tencent/tkd/weibo/utils/DrawableClickHelper$OnDrawableListener;)V", "onTouchListener", "Landroid/view/View$OnTouchListener;", "getTextView$tkd_weibo_component_release", "()Landroid/widget/TextView;", "Companion", "OnDrawableListener", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ClickableViewAccessibility"})
public final class DrawableClickHelper
{
  public static final DrawableClickHelper.Companion a = new DrawableClickHelper.Companion(null);
  private final View.OnTouchListener b;
  @NotNull
  private final TextView c;
  private final DrawableClickHelper.OnDrawableListener d;
  
  public DrawableClickHelper(@NotNull TextView paramTextView, @Nullable DrawableClickHelper.OnDrawableListener paramOnDrawableListener)
  {
    this.c = paramTextView;
    this.d = paramOnDrawableListener;
    this.b = ((View.OnTouchListener)new DrawableClickHelper.onTouchListener.1(this));
    this.c.setOnTouchListener(this.b);
  }
  
  @NotNull
  public final TextView a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.DrawableClickHelper
 * JD-Core Version:    0.7.0.1
 */