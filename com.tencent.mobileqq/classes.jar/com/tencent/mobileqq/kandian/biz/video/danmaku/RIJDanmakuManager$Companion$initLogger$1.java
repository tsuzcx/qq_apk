package com.tencent.mobileqq.kandian.biz.video.danmaku;

import com.tencent.common.danmaku.inject.VideoDanmakuConfig.ILogger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/video/danmaku/RIJDanmakuManager$Companion$initLogger$1", "Lcom/tencent/common/danmaku/inject/VideoDanmakuConfig$ILogger;", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "w", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDanmakuManager$Companion$initLogger$1
  implements VideoDanmakuConfig.ILogger
{
  public void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable Throwable paramThrowable)
  {
    QLog.e(paramString1, 2, paramString2, paramThrowable);
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  public void c(@Nullable String paramString1, @Nullable String paramString2)
  {
    QLog.i(paramString1, 2, paramString2);
  }
  
  public void d(@Nullable String paramString1, @Nullable String paramString2)
  {
    QLog.w(paramString1, 2, paramString2);
  }
  
  public void e(@Nullable String paramString1, @Nullable String paramString2)
  {
    QLog.e(paramString1, 2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.danmaku.RIJDanmakuManager.Companion.initLogger.1
 * JD-Core Version:    0.7.0.1
 */