package com.tencent.tkd.topicsdk.framework;

import android.content.Context;
import com.tencent.tkd.topicsdk.interfaces.IImageLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/ImageLoader$Companion;", "", "()V", "with", "Lcom/tencent/tkd/topicsdk/framework/ImageLoader;", "context", "Landroid/content/Context;", "imageLoaderImpl", "Lcom/tencent/tkd/topicsdk/interfaces/IImageLoader;", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class ImageLoader$Companion
{
  @NotNull
  public final ImageLoader a(@NotNull Context paramContext, @NotNull IImageLoader paramIImageLoader)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramIImageLoader, "imageLoaderImpl");
    return new ImageLoader(paramContext, paramIImageLoader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.ImageLoader.Companion
 * JD-Core Version:    0.7.0.1
 */