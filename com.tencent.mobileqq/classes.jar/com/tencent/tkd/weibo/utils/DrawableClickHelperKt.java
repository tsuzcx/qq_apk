package com.tencent.tkd.weibo.utils;

import android.widget.EditText;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"setOnDrawableClickListener", "", "Landroid/widget/EditText;", "listener", "Lcom/tencent/tkd/weibo/utils/DrawableClickHelper$OnDrawableListener;", "tkd-weibo-component_release"}, k=2, mv={1, 1, 16})
public final class DrawableClickHelperKt
{
  public static final void a(@NotNull EditText paramEditText, @NotNull DrawableClickHelper.OnDrawableListener paramOnDrawableListener)
  {
    Intrinsics.checkParameterIsNotNull(paramEditText, "$this$setOnDrawableClickListener");
    Intrinsics.checkParameterIsNotNull(paramOnDrawableListener, "listener");
    new DrawableClickHelper((TextView)paramEditText, paramOnDrawableListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.DrawableClickHelperKt
 * JD-Core Version:    0.7.0.1
 */