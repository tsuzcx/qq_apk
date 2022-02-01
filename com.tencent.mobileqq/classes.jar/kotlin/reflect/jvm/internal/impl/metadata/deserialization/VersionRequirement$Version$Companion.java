package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class VersionRequirement$Version$Companion
{
  @NotNull
  public final VersionRequirement.Version decode(@Nullable Integer paramInteger1, @Nullable Integer paramInteger2)
  {
    if (paramInteger2 != null) {
      return new VersionRequirement.Version(paramInteger2.intValue() & 0xFF, paramInteger2.intValue() >> 8 & 0xFF, paramInteger2.intValue() >> 16 & 0xFF);
    }
    if (paramInteger1 != null) {
      return new VersionRequirement.Version(paramInteger1.intValue() & 0x7, paramInteger1.intValue() >> 3 & 0xF, paramInteger1.intValue() >> 7 & 0x7F);
    }
    return VersionRequirement.Version.INFINITY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirement.Version.Companion
 * JD-Core Version:    0.7.0.1
 */