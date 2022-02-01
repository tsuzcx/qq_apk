package com.tencent.mobileqq.kandian.glue.video.compress;

import android.util.SparseIntArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.base.video.compress.VideoCompressConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/video/compress/VideoCompressModule;", "", "()V", "KEY_COMPRESS_BITRATE_1080P", "", "KEY_COMPRESS_BITRATE_480P", "KEY_COMPRESS_BITRATE_640P", "KEY_COMPRESS_BITRATE_720P", "KEY_COMPRESS_FILE_SIZE_LOWER_BOUND", "KEY_COMPRESS_FILE_SIZE_UPPER_BOUND", "hasInit", "", "getConfigCompressFileSizeLowerBound", "", "getConfigCompressFileSizeUpperBound", "init", "", "initConfigTargetResolutionBitRate", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoCompressModule
{
  public static final VideoCompressModule.Companion a = new VideoCompressModule.Companion(null);
  @NotNull
  private static final Lazy i = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)VideoCompressModule.Companion.instance.2.INSTANCE);
  private final String b = "compress_size_lower_bound";
  private final String c = "compress_size_upper_bound";
  private final String d = "compress_bitrate_480p";
  private final String e = "compress_bitrate_640p";
  private final String f = "compress_bitrate_720p";
  private final String g = "compress_bitrate_1080p";
  private boolean h;
  
  private final long c()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    long l = 60L;
    if (localAladdinConfig != null)
    {
      l = localAladdinConfig.getLongFromString(this.b, 60L);
      QLog.d("VideoConvertUtils", 1, new Object[] { "getConfigCompressFileSizeLowerBound(), value = ", Long.valueOf(l) });
    }
    return l * 1048576;
  }
  
  private final long d()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    long l;
    if (localAladdinConfig != null)
    {
      l = localAladdinConfig.getLongFromString(this.c, 1024L);
      QLog.d("VideoConvertUtils", 1, new Object[] { "getConfigCompressFileSizeUpperBound(), value = ", Long.valueOf(l) });
    }
    else
    {
      l = 60L;
    }
    return l * 1048576;
  }
  
  private final void e()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    if (localAladdinConfig != null)
    {
      VideoCompressConfig.c().put(480, localAladdinConfig.getIntegerFromString(this.d, 1024));
      VideoCompressConfig.c().put(640, localAladdinConfig.getIntegerFromString(this.e, 1536));
      VideoCompressConfig.c().put(720, localAladdinConfig.getIntegerFromString(this.f, 2048));
      VideoCompressConfig.c().put(1080, localAladdinConfig.getIntegerFromString(this.g, 4096));
    }
  }
  
  public final void a()
  {
    if (!this.h)
    {
      this.h = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressModule", 2, "VideoCompressModule init...");
      }
      VideoCompressConfig.a(c());
      VideoCompressConfig.b(d());
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.compress.VideoCompressModule
 * JD-Core Version:    0.7.0.1
 */