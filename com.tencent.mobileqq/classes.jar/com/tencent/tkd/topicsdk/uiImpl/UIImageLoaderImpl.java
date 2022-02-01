package com.tencent.tkd.topicsdk.uiImpl;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/uiImpl/UIImageLoaderImpl;", "Lcom/tencent/tkd/weibo/framework/IImageLoader;", "()V", "load", "", "context", "Landroid/content/Context;", "path", "", "imageView", "Landroid/widget/ImageView;", "option", "Lcom/tencent/tkd/weibo/framework/IImageLoader$ImageLoaderOption;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class UIImageLoaderImpl
  implements com.tencent.tkd.weibo.framework.IImageLoader
{
  public void a(@NotNull Context paramContext, @NotNull String paramString, @Nullable ImageView paramImageView, @NotNull com.tencent.tkd.weibo.framework.IImageLoader.ImageLoaderOption paramImageLoaderOption)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramImageLoaderOption, "option");
    com.tencent.tkd.topicsdk.interfaces.IImageLoader.ImageLoaderOption localImageLoaderOption = new com.tencent.tkd.topicsdk.interfaces.IImageLoader.ImageLoaderOption();
    localImageLoaderOption.jdField_a_of_type_Int = paramImageLoaderOption.jdField_a_of_type_Int;
    localImageLoaderOption.jdField_b_of_type_Int = paramImageLoaderOption.jdField_b_of_type_Int;
    localImageLoaderOption.c = paramImageLoaderOption.c;
    localImageLoaderOption.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramImageLoaderOption.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    localImageLoaderOption.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramImageLoaderOption.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    TopicSDK.a.a().a().a().a(paramContext, paramString, paramImageView, localImageLoaderOption);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.uiImpl.UIImageLoaderImpl
 * JD-Core Version:    0.7.0.1
 */