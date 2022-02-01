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
  public static final VideoCompressModule.Companion a;
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)VideoCompressModule.Companion.instance.2.INSTANCE);
  private final String jdField_a_of_type_JavaLangString = "compress_size_lower_bound";
  private boolean jdField_a_of_type_Boolean;
  private final String b = "compress_size_upper_bound";
  private final String c = "compress_bitrate_480p";
  private final String d = "compress_bitrate_640p";
  private final String e = "compress_bitrate_720p";
  private final String f = "compress_bitrate_1080p";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianGlueVideoCompressVideoCompressModule$Companion = new VideoCompressModule.Companion(null);
  }
  
  private final long a()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    long l = 60L;
    if (localAladdinConfig != null)
    {
      l = localAladdinConfig.getLongFromString(this.jdField_a_of_type_JavaLangString, 60L);
      QLog.d("VideoConvertUtils", 1, new Object[] { "getConfigCompressFileSizeLowerBound(), value = ", Long.valueOf(l) });
    }
    return l * 1048576;
  }
  
  private final long b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    long l;
    if (localAladdinConfig != null)
    {
      l = localAladdinConfig.getLongFromString(this.b, 1024L);
      QLog.d("VideoConvertUtils", 1, new Object[] { "getConfigCompressFileSizeUpperBound(), value = ", Long.valueOf(l) });
    }
    else
    {
      l = 60L;
    }
    return l * 1048576;
  }
  
  private final void b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    if (localAladdinConfig != null)
    {
      VideoCompressConfig.a().put(480, localAladdinConfig.getIntegerFromString(this.c, 1024));
      VideoCompressConfig.a().put(640, localAladdinConfig.getIntegerFromString(this.d, 1536));
      VideoCompressConfig.a().put(720, localAladdinConfig.getIntegerFromString(this.e, 2048));
      VideoCompressConfig.a().put(1080, localAladdinConfig.getIntegerFromString(this.f, 4096));
    }
  }
  
  public final void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressModule", 2, "VideoCompressModule init...");
      }
      VideoCompressConfig.a(a());
      VideoCompressConfig.b(b());
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.compress.VideoCompressModule
 * JD-Core Version:    0.7.0.1
 */