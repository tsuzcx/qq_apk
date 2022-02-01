package com.tencent.mobileqq.vas.apng.api;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.image.URLDrawable.URLDrawableListener;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;", "", "()V", "autoScale", "", "getAutoScale", "()Z", "setAutoScale", "(Z)V", "extraInfo", "Landroid/os/Bundle;", "getExtraInfo", "()Landroid/os/Bundle;", "setExtraInfo", "(Landroid/os/Bundle;)V", "loadListener", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "getLoadListener", "()Lcom/tencent/image/URLDrawable$URLDrawableListener;", "setLoadListener", "(Lcom/tencent/image/URLDrawable$URLDrawableListener;)V", "loadingDrawable", "Landroid/graphics/drawable/Drawable;", "getLoadingDrawable", "()Landroid/graphics/drawable/Drawable;", "setLoadingDrawable", "(Landroid/graphics/drawable/Drawable;)V", "loop", "", "getLoop", "()I", "setLoop", "(I)V", "requestHeight", "getRequestHeight", "setRequestHeight", "requestWidth", "getRequestWidth", "setRequestWidth", "tagId", "", "getTagId", "()[I", "setTagId", "([I)V", "useCache", "getUseCache", "setUseCache", "useUnFinishedCache", "getUseUnFinishedCache", "setUseUnFinishedCache", "Companion", "URLDrawableListenerAdapter", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class ApngOptions
{
  @JvmField
  @NotNull
  public static final ColorDrawable a = new ColorDrawable(0);
  public static final ApngOptions.Companion b = new ApngOptions.Companion(null);
  private int c;
  @NotNull
  private int[] d = new int[0];
  @NotNull
  private Bundle e = new Bundle();
  private int f;
  private int g;
  private boolean h = true;
  @Nullable
  private Drawable i = (Drawable)a;
  private boolean j = true;
  private boolean k = true;
  @NotNull
  private URLDrawable.URLDrawableListener l = (URLDrawable.URLDrawableListener)new ApngOptions.URLDrawableListenerAdapter();
  
  public final int a()
  {
    return this.c;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(@Nullable Drawable paramDrawable)
  {
    this.i = paramDrawable;
  }
  
  public final void a(@NotNull URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawableListener, "<set-?>");
    this.l = paramURLDrawableListener;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public final void a(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "<set-?>");
    this.d = paramArrayOfInt;
  }
  
  public final void b(int paramInt)
  {
    this.f = paramInt;
  }
  
  @NotNull
  public final int[] b()
  {
    return this.d;
  }
  
  @NotNull
  public final Bundle c()
  {
    return this.e;
  }
  
  public final void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final int d()
  {
    return this.f;
  }
  
  public final int e()
  {
    return this.g;
  }
  
  public final boolean f()
  {
    return this.h;
  }
  
  @Nullable
  public final Drawable g()
  {
    return this.i;
  }
  
  public final boolean h()
  {
    return this.j;
  }
  
  public final boolean i()
  {
    return this.k;
  }
  
  @NotNull
  public final URLDrawable.URLDrawableListener j()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.apng.api.ApngOptions
 * JD-Core Version:    0.7.0.1
 */