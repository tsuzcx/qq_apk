package kotlin.reflect.jvm.internal.impl.platform;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class PlatformUtilKt
{
  @NotNull
  public static final String getPresentableDescription(@NotNull TargetPlatform paramTargetPlatform)
  {
    Intrinsics.checkParameterIsNotNull(paramTargetPlatform, "$this$presentableDescription");
    return CollectionsKt.joinToString$default((Iterable)paramTargetPlatform.getComponentPlatforms(), (CharSequence)"/", null, null, 0, null, null, 62, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.platform.PlatformUtilKt
 * JD-Core Version:    0.7.0.1
 */