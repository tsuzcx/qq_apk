package com.tencent.mobileqq.kandian.base.video.compress;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/video/compress/VideoCompressConfig;", "", "()V", "DEFAULT_COMPRESS_BITRATE_1080P", "", "DEFAULT_COMPRESS_BITRATE_480P", "DEFAULT_COMPRESS_BITRATE_640P", "DEFAULT_COMPRESS_BITRATE_720P", "DEFAULT_COMPRESS_FILE_SIZE_LOWER_BOUND", "", "DEFAULT_COMPRESS_FILE_SIZE_UPPER_BOUND", "RESOLUTION_1080P", "RESOLUTION_480P", "RESOLUTION_640P", "RESOLUTION_720P", "UNKNOWN_VALUE", "compressFileSizeLowerBound", "compressFileSizeLowerBound$annotations", "getCompressFileSizeLowerBound", "()J", "setCompressFileSizeLowerBound", "(J)V", "compressFileSizeUpperBound", "compressFileSizeUpperBound$annotations", "getCompressFileSizeUpperBound", "setCompressFileSizeUpperBound", "res2bitRateMap", "Landroid/util/SparseIntArray;", "res2bitRateMap$annotations", "getRes2bitRateMap", "()Landroid/util/SparseIntArray;", "getTargetResolutionBitRate", "resolution", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoCompressConfig
{
  private static long jdField_a_of_type_Long;
  @NotNull
  private static final SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  public static final VideoCompressConfig a;
  private static long b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressConfig = new VideoCompressConfig();
    jdField_a_of_type_Long = 62914560L;
    b = 1073741824L;
  }
  
  @JvmStatic
  public static final int a(int paramInt)
  {
    if (jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt) == -2147483648) {
      return 2048;
    }
    return jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt);
  }
  
  public static final long a()
  {
    return jdField_a_of_type_Long;
  }
  
  @NotNull
  public static final SparseIntArray a()
  {
    return jdField_a_of_type_AndroidUtilSparseIntArray;
  }
  
  public static final void a(long paramLong)
  {
    jdField_a_of_type_Long = paramLong;
  }
  
  public static final long b()
  {
    return b;
  }
  
  public static final void b(long paramLong)
  {
    b = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.compress.VideoCompressConfig
 * JD-Core Version:    0.7.0.1
 */