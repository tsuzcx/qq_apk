package com.tencent.mobileqq.kandian.base.utils.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.kandian.base.image.api.impl.PublicAccountHttpDownloaderImpl;
import com.tencent.mobileqq.kandian.base.utils.api.IImageUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/ImageUtilImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IImageUtil;", "()V", "getDefaultFaceDrawable140_140", "Landroid/graphics/drawable/Drawable;", "getDrawableUrl", "Ljava/net/URL;", "path", "", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ImageUtilImpl
  implements IImageUtil
{
  @Nullable
  public Drawable getDefaultFaceDrawable140_140()
  {
    return ImageUtil.m();
  }
  
  @Nullable
  public URL getDrawableUrl(@Nullable String paramString)
  {
    return new PublicAccountHttpDownloaderImpl().makeURL(paramString, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.ImageUtilImpl
 * JD-Core Version:    0.7.0.1
 */