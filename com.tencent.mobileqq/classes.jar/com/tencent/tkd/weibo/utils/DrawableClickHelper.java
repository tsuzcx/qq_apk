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
  public static final DrawableClickHelper.Companion a;
  private final View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  @NotNull
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private final DrawableClickHelper.OnDrawableListener jdField_a_of_type_ComTencentTkdWeiboUtilsDrawableClickHelper$OnDrawableListener;
  
  static
  {
    jdField_a_of_type_ComTencentTkdWeiboUtilsDrawableClickHelper$Companion = new DrawableClickHelper.Companion(null);
  }
  
  public DrawableClickHelper(@NotNull TextView paramTextView, @Nullable DrawableClickHelper.OnDrawableListener paramOnDrawableListener)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
    this.jdField_a_of_type_ComTencentTkdWeiboUtilsDrawableClickHelper$OnDrawableListener = paramOnDrawableListener;
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = ((View.OnTouchListener)new DrawableClickHelper.onTouchListener.1(this));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
  }
  
  @NotNull
  public final TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.DrawableClickHelper
 * JD-Core Version:    0.7.0.1
 */