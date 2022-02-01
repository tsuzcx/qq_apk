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
  public static final ImageLoader.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private final Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final IImageLoader jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader;
  private int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private int c;
  
  static
  {
    jdField_a_of_type_ComTencentTkdTopicsdkFrameworkImageLoader$Companion = new ImageLoader.Companion(null);
  }
  
  public ImageLoader(@NotNull Context paramContext, @NotNull IImageLoader paramIImageLoader)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader = paramIImageLoader;
  }
  
  @NotNull
  public final ImageLoader a()
  {
    this.c = -1;
    return this;
  }
  
  @NotNull
  public final ImageLoader a(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
  
  @NotNull
  public final ImageLoader a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    return this;
  }
  
  @NotNull
  public final ImageLoader a(@NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "drawable");
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    return this;
  }
  
  @NotNull
  public final ImageLoader a(@NotNull ImageView paramImageView)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "imageView");
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    return this;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    IImageLoader.ImageLoaderOption localImageLoaderOption = new IImageLoader.ImageLoaderOption();
    localImageLoaderOption.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localImageLoaderOption.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localImageLoaderOption.c = this.c;
    localImageLoaderOption.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localImageLoaderOption.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIImageLoader.a(this.jdField_a_of_type_AndroidContentContext, paramString, this.jdField_a_of_type_AndroidWidgetImageView, localImageLoaderOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.ImageLoader
 * JD-Core Version:    0.7.0.1
 */