package com.tencent.mobileqq.kandian.base.image.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.kandian.base.image.RIJImageOptConfig;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/api/impl/RIJImageOptConfigImpl;", "Lcom/tencent/mobileqq/kandian/base/image/api/IRIJImageOptConfig;", "()V", "isBitmapOpt", "", "()Z", "isDecodeHttpStream", "isLifoOn", "isRenderFirst", "isReportOn", "decodeSharpP", "Landroid/graphics/Bitmap;", "path", "", "dstWidth", "", "dstHeight", "config", "reuseBitmap", "decodeSharpPInBounds", "Landroid/graphics/BitmapFactory$Options;", "filePath", "getMonitorTime", "", "isSharpPAvailable", "useInnerDns", "useIpConnect", "useSharpP", "useWebp", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJImageOptConfigImpl
  implements IRIJImageOptConfig
{
  @Nullable
  public Bitmap decodeSharpP(@Nullable String paramString, int paramInt1, int paramInt2, @Nullable Bitmap paramBitmap1, @Nullable Bitmap paramBitmap2)
  {
    return this.$$delegate_0.decodeSharpP(paramString, paramInt1, paramInt2, paramBitmap1, paramBitmap2);
  }
  
  @NotNull
  public BitmapFactory.Options decodeSharpPInBounds(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    return this.$$delegate_0.decodeSharpPInBounds(paramString);
  }
  
  public long getMonitorTime()
  {
    return this.$$delegate_0.getMonitorTime();
  }
  
  public boolean isBitmapOpt()
  {
    return this.$$delegate_0.isBitmapOpt();
  }
  
  public boolean isDecodeHttpStream()
  {
    return this.$$delegate_0.isDecodeHttpStream();
  }
  
  public boolean isLifoOn()
  {
    return this.$$delegate_0.isLifoOn();
  }
  
  public boolean isRenderFirst()
  {
    return this.$$delegate_0.isRenderFirst();
  }
  
  public boolean isReportOn()
  {
    return this.$$delegate_0.isReportOn();
  }
  
  public boolean isSharpPAvailable()
  {
    return this.$$delegate_0.isSharpPAvailable();
  }
  
  public boolean useInnerDns()
  {
    return this.$$delegate_0.useInnerDns();
  }
  
  public boolean useIpConnect()
  {
    return this.$$delegate_0.useIpConnect();
  }
  
  public boolean useSharpP()
  {
    return this.$$delegate_0.useSharpP();
  }
  
  public boolean useWebp()
  {
    return this.$$delegate_0.useWebp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.impl.RIJImageOptConfigImpl
 * JD-Core Version:    0.7.0.1
 */