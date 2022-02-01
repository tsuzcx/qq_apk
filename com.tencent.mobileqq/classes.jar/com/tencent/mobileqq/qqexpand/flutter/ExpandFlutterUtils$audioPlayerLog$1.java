package com.tencent.mobileqq.qqexpand.flutter;

import com.qflutter.audio.log.ILog;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/qqexpand/flutter/ExpandFlutterUtils$audioPlayerLog$1", "Lcom/qflutter/audio/log/ILog;", "d", "", "tag", "", "s", "e", "i", "v", "w", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterUtils$audioPlayerLog$1
  implements ILog
{
  public void d(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "s");
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioPlayer.");
      localStringBuilder.append(paramString1);
      QLog.d(localStringBuilder.toString(), 4, paramString2);
    }
  }
  
  public void e(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "s");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioPlayer.");
    localStringBuilder.append(paramString1);
    QLog.e(localStringBuilder.toString(), 1, paramString2);
  }
  
  public void i(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "s");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioPlayer.");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 1, paramString2);
  }
  
  public void v(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "s");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioPlayer.");
      localStringBuilder.append(paramString1);
      QLog.d(localStringBuilder.toString(), 2, paramString2);
    }
  }
  
  public void w(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "s");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AudioPlayer.");
    localStringBuilder.append(paramString1);
    QLog.w(localStringBuilder.toString(), 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterUtils.audioPlayerLog.1
 * JD-Core Version:    0.7.0.1
 */