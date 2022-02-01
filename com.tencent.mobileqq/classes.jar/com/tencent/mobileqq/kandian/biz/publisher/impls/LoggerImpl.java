package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.TMG.utils.QLog;
import com.tencent.tkd.topicsdk.interfaces.ILogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/LoggerImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/ILogger;", "()V", "RIJUGC", "", "d", "", "tag", "msg", "throwable", "", "e", "i", "w", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class LoggerImpl
  implements ILogger
{
  private final String a = "RIJ_UGC.";
  
  public void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(paramString1);
      QLog.d(localStringBuilder.toString(), 0, paramString2, (Exception)paramThrowable);
    }
  }
  
  public void b(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2, (Exception)paramThrowable);
  }
  
  public void c(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(paramString1);
      QLog.i(localStringBuilder.toString(), 0, paramString2, (Exception)paramThrowable);
    }
  }
  
  public void d(@NotNull String paramString1, @NotNull String paramString2, @Nullable Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(paramString1);
      QLog.w(localStringBuilder.toString(), 0, paramString2, (Exception)paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.LoggerImpl
 * JD-Core Version:    0.7.0.1
 */