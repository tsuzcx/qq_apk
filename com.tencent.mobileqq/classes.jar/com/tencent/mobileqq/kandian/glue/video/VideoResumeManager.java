package com.tencent.mobileqq.kandian.glue.video;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/video/VideoResumeManager;", "", "()V", "TAG", "", "config", "Lcom/tencent/aladdin/config/AladdinConfig;", "kotlin.jvm.PlatformType", "enable", "", "getEnable", "()Z", "map", "", "", "cacheVideoStatus", "", "key", "position", "rowKey", "vid", "duration", "getPlayPosition", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoResumeManager
{
  private static final AladdinConfig jdField_a_of_type_ComTencentAladdinConfigAladdinConfig = Aladdin.getConfig(391);
  public static final VideoResumeManager a;
  private static final Map<String, Long> jdField_a_of_type_JavaUtilMap;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoResumeManager = new VideoResumeManager();
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
  }
  
  public final long a(@Nullable String paramString1, @Nullable String paramString2)
  {
    boolean bool = a();
    long l2 = 0L;
    long l3 = l2;
    if (bool)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
      localObject = (Long)jdField_a_of_type_JavaUtilMap.get(localObject);
      long l1;
      if (localObject != null) {
        l1 = ((Long)localObject).longValue();
      } else {
        l1 = 0L;
      }
      if (l1 < 1500) {
        l1 = l2;
      }
      l3 = l1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getPlayPosition: rowKey=");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", vid=");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(", result=");
        ((StringBuilder)localObject).append(l1);
        QLog.d("VideoResumeManager", 2, ((StringBuilder)localObject).toString());
        l3 = l1;
      }
    }
    return l3;
  }
  
  public final void a(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (a())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cacheVideoStatus: key=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", position=");
        localStringBuilder.append(paramLong);
        QLog.d("VideoResumeManager", 2, localStringBuilder.toString());
      }
      jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public final void a(@Nullable String paramString1, @Nullable String paramString2, long paramLong1, long paramLong2)
  {
    if (a())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("cacheVideoStatus: rowKey=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", vid=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", position=");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(", duration=");
        localStringBuilder.append(paramLong2);
        QLog.d("VideoResumeManager", 2, localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
      paramString2 = jdField_a_of_type_JavaUtilMap;
      if (paramLong2 - paramLong1 <= 1500) {
        paramLong1 = 0L;
      }
      paramString2.put(paramString1, Long.valueOf(paramLong1));
    }
  }
  
  public final boolean a()
  {
    AladdinConfig localAladdinConfig = jdField_a_of_type_ComTencentAladdinConfigAladdinConfig;
    boolean bool = false;
    if (localAladdinConfig.getIntegerFromString("resume_enable", 0) == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoResumeManager
 * JD-Core Version:    0.7.0.1
 */