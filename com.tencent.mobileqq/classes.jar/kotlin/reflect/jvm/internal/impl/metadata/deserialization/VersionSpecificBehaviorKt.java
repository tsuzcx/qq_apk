package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class VersionSpecificBehaviorKt
{
  public static final boolean isKotlin1Dot4OrLater(@NotNull BinaryVersion paramBinaryVersion)
  {
    Intrinsics.checkParameterIsNotNull(paramBinaryVersion, "version");
    return (paramBinaryVersion.getMajor() == 1) && (paramBinaryVersion.getMinor() >= 4);
  }
  
  public static final boolean isVersionRequirementTableWrittenCorrectly(@NotNull BinaryVersion paramBinaryVersion)
  {
    Intrinsics.checkParameterIsNotNull(paramBinaryVersion, "version");
    return isKotlin1Dot4OrLater(paramBinaryVersion);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionSpecificBehaviorKt
 * JD-Core Version:    0.7.0.1
 */