package kotlin.text.jdk8;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchNamedGroupCollection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"get", "Lkotlin/text/MatchGroup;", "Lkotlin/text/MatchGroupCollection;", "name", "", "kotlin-stdlib-jdk8"}, k=2, mv={1, 1, 16}, pn="kotlin.text")
@JvmName(name="RegexExtensionsJDK8Kt")
public final class RegexExtensionsJDK8Kt
{
  @SinceKotlin(version="1.2")
  @Nullable
  public static final MatchGroup get(@NotNull MatchGroupCollection paramMatchGroupCollection, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMatchGroupCollection, "$this$get");
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    MatchGroupCollection localMatchGroupCollection = paramMatchGroupCollection;
    if (!(paramMatchGroupCollection instanceof MatchNamedGroupCollection)) {
      localMatchGroupCollection = null;
    }
    paramMatchGroupCollection = (MatchNamedGroupCollection)localMatchGroupCollection;
    if (paramMatchGroupCollection != null) {
      return paramMatchGroupCollection.get(paramString);
    }
    throw ((Throwable)new UnsupportedOperationException("Retrieving groups by name is not supported on this platform."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     kotlin.text.jdk8.RegexExtensionsJDK8Kt
 * JD-Core Version:    0.7.0.1
 */