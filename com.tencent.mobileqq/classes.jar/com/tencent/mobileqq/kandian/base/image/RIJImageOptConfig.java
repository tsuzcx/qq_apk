package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import com.tencent.qqsharpP.QQSharpPUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/RIJImageOptConfig;", "Lcom/tencent/mobileqq/kandian/base/image/api/IRIJImageOptConfig;", "()V", "FILE_TYPE_SHARPP", "", "FILE_TYPE_WEBP", "bitmapOpt", "decodeHttpStream", "fileTypeOpt", "isBitmapOpt", "", "()Z", "isDecodeHttpStream", "isLifoOn", "isRenderFirst", "isReportOn", "isRollbackToDomainConnect", "lifoOn", "monitorTime", "", "renderFirst", "reportOn", "rollbackDomainConnect", "useInnerDns", "useKandianIpConnect", "decodeSharpP", "Landroid/graphics/Bitmap;", "path", "", "dstWidth", "dstHeight", "config", "reuseBitmap", "decodeSharpPInBounds", "Landroid/graphics/BitmapFactory$Options;", "filePath", "getMonitorTime", "isSharpPAvailable", "setBitmapOpt", "", "setDecodeHttpStream", "setFileTypeOpt", "setLifoOn", "setMonitorTime", "setRenderFirst", "setReportOn", "setRollbackToDomainConnect", "setUseInnerDns", "setUseKanDianIpConnect", "useKanDianIpConnect", "useIpConnect", "useSharpP", "useWebp", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJImageOptConfig
  implements IRIJImageOptConfig
{
  private static final int FILE_TYPE_SHARPP = 2;
  private static final int FILE_TYPE_WEBP = 1;
  public static final RIJImageOptConfig INSTANCE = new RIJImageOptConfig();
  private static int bitmapOpt;
  private static int decodeHttpStream;
  private static int fileTypeOpt;
  private static int lifoOn;
  private static long monitorTime;
  private static int renderFirst;
  private static int reportOn;
  private static int rollbackDomainConnect;
  private static int useInnerDns;
  private static int useKandianIpConnect;
  
  static
  {
    FILE_TYPE_WEBP = 1;
  }
  
  @Nullable
  public Bitmap decodeSharpP(@Nullable String paramString, int paramInt1, int paramInt2, @Nullable Bitmap paramBitmap1, @Nullable Bitmap paramBitmap2)
  {
    return new RIJSharpPDecoder().a(paramString, paramInt1, paramInt2, Bitmap.Config.ARGB_8888, paramBitmap2);
  }
  
  @NotNull
  public BitmapFactory.Options decodeSharpPInBounds(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "filePath");
    return new RIJSharpPDecoder().a(paramString);
  }
  
  public long getMonitorTime()
  {
    long l = monitorTime;
    if (l > 0L) {
      return l;
    }
    return 10000L;
  }
  
  public boolean isBitmapOpt()
  {
    return bitmapOpt == 1;
  }
  
  public boolean isDecodeHttpStream()
  {
    return decodeHttpStream == 1;
  }
  
  public boolean isLifoOn()
  {
    return lifoOn == 1;
  }
  
  public boolean isRenderFirst()
  {
    return renderFirst == 1;
  }
  
  public boolean isReportOn()
  {
    return reportOn == 1;
  }
  
  public boolean isRollbackToDomainConnect()
  {
    return rollbackDomainConnect == 1;
  }
  
  public boolean isSharpPAvailable()
  {
    return QQSharpPUtil.a(null);
  }
  
  public final void setBitmapOpt(int paramInt)
  {
    bitmapOpt = paramInt;
  }
  
  public final void setDecodeHttpStream(int paramInt)
  {
    decodeHttpStream = paramInt;
  }
  
  public final void setFileTypeOpt(int paramInt)
  {
    fileTypeOpt = paramInt;
  }
  
  public final void setLifoOn(int paramInt)
  {
    lifoOn = paramInt;
  }
  
  public final void setMonitorTime(long paramLong)
  {
    monitorTime = paramLong;
  }
  
  public final void setRenderFirst(int paramInt)
  {
    renderFirst = paramInt;
  }
  
  public final void setReportOn(int paramInt)
  {
    reportOn = paramInt;
  }
  
  public final void setRollbackToDomainConnect(int paramInt)
  {
    rollbackDomainConnect = paramInt;
  }
  
  public final void setUseInnerDns(int paramInt)
  {
    useInnerDns = paramInt;
  }
  
  public final void setUseKanDianIpConnect(int paramInt)
  {
    useKandianIpConnect = paramInt;
  }
  
  public boolean useInnerDns()
  {
    return useInnerDns == 1;
  }
  
  public boolean useIpConnect()
  {
    return useKandianIpConnect == 1;
  }
  
  public boolean useSharpP()
  {
    return fileTypeOpt == FILE_TYPE_SHARPP;
  }
  
  public boolean useWebp()
  {
    return fileTypeOpt == FILE_TYPE_WEBP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RIJImageOptConfig
 * JD-Core Version:    0.7.0.1
 */