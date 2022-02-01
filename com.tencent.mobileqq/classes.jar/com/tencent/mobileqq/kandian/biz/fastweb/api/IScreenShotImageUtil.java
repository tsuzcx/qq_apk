package com.tencent.mobileqq.kandian.biz.fastweb.api;

import android.graphics.Bitmap;
import android.view.Window;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/fastweb/api/IScreenShotImageUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getScreenShotBitmap", "Landroid/graphics/Bitmap;", "window", "Landroid/view/Window;", "bitmap", "saveBitmapToPublicAccountFileFolder", "", "filePrefix", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IScreenShotImageUtil
  extends QRouteApi
{
  @Nullable
  public abstract Bitmap getScreenShotBitmap(@Nullable Window paramWindow, @Nullable Bitmap paramBitmap);
  
  @Nullable
  public abstract String saveBitmapToPublicAccountFileFolder(@Nullable Bitmap paramBitmap, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.api.IScreenShotImageUtil
 * JD-Core Version:    0.7.0.1
 */