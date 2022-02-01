package com.tencent.mobileqq.kandian.biz.fastweb.api.impl;

import android.graphics.Bitmap;
import android.view.Window;
import com.tencent.mobileqq.kandian.biz.fastweb.api.IScreenShotImageUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ScreenShotImageUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/api/impl/ScreenShotImageUtilImpl;", "Lcom/tencent/mobileqq/kandian/biz/fastweb/api/IScreenShotImageUtil;", "()V", "getScreenShotBitmap", "Landroid/graphics/Bitmap;", "window", "Landroid/view/Window;", "bitmap", "saveBitmapToPublicAccountFileFolder", "", "filePrefix", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ScreenShotImageUtilImpl
  implements IScreenShotImageUtil
{
  @Nullable
  public Bitmap getScreenShotBitmap(@Nullable Window paramWindow, @Nullable Bitmap paramBitmap)
  {
    return ScreenShotImageUtil.a(paramWindow, paramBitmap);
  }
  
  @Nullable
  public String saveBitmapToPublicAccountFileFolder(@Nullable Bitmap paramBitmap, @Nullable String paramString)
  {
    return ScreenShotImageUtil.a(paramBitmap, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.api.impl.ScreenShotImageUtilImpl
 * JD-Core Version:    0.7.0.1
 */