package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class PackagePartProvider$Empty
  implements PackagePartProvider
{
  public static final Empty INSTANCE = new Empty();
  
  @NotNull
  public List<String> findPackageParts(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "packageFqName");
    return CollectionsKt.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider.Empty
 * JD-Core Version:    0.7.0.1
 */