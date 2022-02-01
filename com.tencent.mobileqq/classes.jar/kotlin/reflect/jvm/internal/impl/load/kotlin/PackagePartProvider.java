package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import org.jetbrains.annotations.NotNull;

public abstract interface PackagePartProvider
{
  @NotNull
  public abstract List<String> findPackageParts(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider
 * JD-Core Version:    0.7.0.1
 */