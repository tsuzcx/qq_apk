package com.tencent.mobileqq.kandian.base.video.compress;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/compress/VideoCompressConfig;", "", "()V", "DEFAULT_COMPRESS_BITRATE_1080P", "", "DEFAULT_COMPRESS_BITRATE_480P", "DEFAULT_COMPRESS_BITRATE_640P", "DEFAULT_COMPRESS_BITRATE_720P", "DEFAULT_COMPRESS_FILE_SIZE_LOWER_BOUND", "", "DEFAULT_COMPRESS_FILE_SIZE_UPPER_BOUND", "RESOLUTION_1080P", "RESOLUTION_480P", "RESOLUTION_640P", "RESOLUTION_720P", "UNKNOWN_VALUE", "compressFileSizeLowerBound", "compressFileSizeLowerBound$annotations", "getCompressFileSizeLowerBound", "()J", "setCompressFileSizeLowerBound", "(J)V", "compressFileSizeUpperBound", "compressFileSizeUpperBound$annotations", "getCompressFileSizeUpperBound", "setCompressFileSizeUpperBound", "res2bitRateMap", "Landroid/util/SparseIntArray;", "res2bitRateMap$annotations", "getRes2bitRateMap", "()Landroid/util/SparseIntArray;", "getTargetResolutionBitRate", "resolution", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoCompressConfig
{
  public static final VideoCompressConfig a = new VideoCompressConfig();
  private static long b = 62914560L;
  private static long c = 1073741824L;
  @NotNull
  private static final SparseIntArray d = new SparseIntArray();
  
  @JvmStatic
  public static final int a(int paramInt)
  {
    if (d.get(paramInt) == -2147483648) {
      return 2048;
    }
    return d.get(paramInt);
  }
  
  public static final long a()
  {
    return b;
  }
  
  public static final void a(long paramLong)
  {
    b = paramLong;
  }
  
  public static final long b()
  {
    return c;
  }
  
  public static final void b(long paramLong)
  {
    c = paramLong;
  }
  
  @NotNull
  public static final SparseIntArray c()
  {
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.compress.VideoCompressConfig
 * JD-Core Version:    0.7.0.1
 */