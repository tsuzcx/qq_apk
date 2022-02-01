package com.tencent.tkd.topicsdk.framework;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.tkd.topicsdk.interfaces.IImageLoader;
import com.tencent.tkd.topicsdk.interfaces.IImageLoader.ImageLoaderOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/ImageLoader;", "", "context", "Landroid/content/Context;", "imageLoaderImpl", "Lcom/tencent/tkd/topicsdk/interfaces/IImageLoader;", "(Landroid/content/Context;Lcom/tencent/tkd/topicsdk/interfaces/IImageLoader;)V", "getContext", "()Landroid/content/Context;", "errorDrawable", "Landroid/graphics/drawable/Drawable;", "height", "", "loadingDrawable", "radius", "view", "Landroid/widget/ImageView;", "width", "circle", "error", "drawable", "load", "", "path", "", "loading", "size", "imageView", "Companion", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class ImageLoader
{
  public static final ImageLoader.Companion a = new ImageLoader.Companion(null);
  private int b;
  private int c;
  private Drawable d;
  private Drawable e;
  private int f;
  private ImageView g;
  @NotNull
  private final Context h;
  private final IImageLoader i;
  
  public ImageLoader(@NotNull Context paramContext, @NotNull IImageLoader paramIImageLoader)
  {
    this.h = paramContext;
    this.i = paramIImageLoader;
  }
  
  @NotNull
  public final ImageLoader a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    return this;
  }
  
  @NotNull
  public final ImageLoader a(@NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "drawable");
    this.e = paramDrawable;
    return this;
  }
  
  @NotNull
  public final ImageLoader a(@NotNull ImageView paramImageView)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "imageView");
    this.g = paramImageView;
    return this;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    IImageLoader.ImageLoaderOption localImageLoaderOption = new IImageLoader.ImageLoaderOption();
    localImageLoaderOption.a = this.b;
    localImageLoaderOption.b = this.c;
    localImageLoaderOption.c = this.f;
    localImageLoaderOption.d = this.d;
    localImageLoaderOption.e = this.e;
    this.i.a(this.h, paramString, this.g, localImageLoaderOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.ImageLoader
 * JD-Core Version:    0.7.0.1
 */