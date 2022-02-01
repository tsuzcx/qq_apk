package com.tencent.mobileqq.kandian.base.image.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/api/IRIJImageOptConfig;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isBitmapOpt", "", "()Z", "isDecodeHttpStream", "isLifoOn", "isRenderFirst", "isReportOn", "isRollbackToDomainConnect", "decodeSharpP", "Landroid/graphics/Bitmap;", "path", "", "dstWidth", "", "dstHeight", "config", "reuseBitmap", "decodeSharpPInBounds", "Landroid/graphics/BitmapFactory$Options;", "filePath", "getMonitorTime", "", "isSharpPAvailable", "useInnerDns", "useIpConnect", "useSharpP", "useWebp", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJImageOptConfig
  extends QRouteApi
{
  @Nullable
  public abstract Bitmap decodeSharpP(@Nullable String paramString, int paramInt1, int paramInt2, @Nullable Bitmap paramBitmap1, @Nullable Bitmap paramBitmap2);
  
  @NotNull
  public abstract BitmapFactory.Options decodeSharpPInBounds(@NotNull String paramString);
  
  public abstract long getMonitorTime();
  
  public abstract boolean isBitmapOpt();
  
  public abstract boolean isDecodeHttpStream();
  
  public abstract boolean isLifoOn();
  
  public abstract boolean isRenderFirst();
  
  public abstract boolean isReportOn();
  
  public abstract boolean isRollbackToDomainConnect();
  
  public abstract boolean isSharpPAvailable();
  
  public abstract boolean useInnerDns();
  
  public abstract boolean useIpConnect();
  
  public abstract boolean useSharpP();
  
  public abstract boolean useWebp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig
 * JD-Core Version:    0.7.0.1
 */