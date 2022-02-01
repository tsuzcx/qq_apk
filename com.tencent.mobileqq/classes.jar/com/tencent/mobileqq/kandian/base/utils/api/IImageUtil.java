package com.tencent.mobileqq.kandian.base.utils.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/IImageUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDefaultFaceDrawable140_140", "Landroid/graphics/drawable/Drawable;", "getDrawableUrl", "Ljava/net/URL;", "path", "", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IImageUtil
  extends QRouteApi
{
  @Nullable
  public abstract Drawable getDefaultFaceDrawable140_140();
  
  @Nullable
  public abstract URL getDrawableUrl(@Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.IImageUtil
 * JD-Core Version:    0.7.0.1
 */