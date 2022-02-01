package com.tencent.tkd.topicsdk.mediaselector;

import android.content.Context;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "path", "", "imageView", "Landroid/widget/ImageView;", "invoke"}, k=3, mv={1, 1, 16})
final class PreviewPhotoPage$onCreateView$4
  extends Lambda
  implements Function2<String, ImageView, Unit>
{
  PreviewPhotoPage$onCreateView$4(GalleryView paramGalleryView)
  {
    super(2);
  }
  
  public final void invoke(@NotNull String paramString, @NotNull ImageView paramImageView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Intrinsics.checkParameterIsNotNull(paramImageView, "imageView");
    com.tencent.tkd.topicsdk.framework.bridge.ImageLoader localImageLoader = com.tencent.tkd.topicsdk.framework.bridge.ImageLoader.a;
    Object localObject = this.$galleryView;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "galleryView");
    localObject = ((GalleryView)localObject).getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "galleryView.context");
    localImageLoader.a((Context)localObject).a(paramImageView).a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.PreviewPhotoPage.onCreateView.4
 * JD-Core Version:    0.7.0.1
 */