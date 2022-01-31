package kotlin.random;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.internal.PlatformImplementations;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"defaultPlatformRandom", "Lkotlin/random/Random;", "doubleFromParts", "", "hi26", "", "low27", "asJavaRandom", "Ljava/util/Random;", "asKotlinRandom", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class PlatformRandomKt
{
  @SinceKotlin(version="1.3")
  @NotNull
  public static final java.util.Random asJavaRandom(@NotNull Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$asJavaRandom");
    if (!(paramRandom instanceof AbstractPlatformRandom)) {}
    for (Object localObject = null;; localObject = paramRandom)
    {
      localObject = (AbstractPlatformRandom)localObject;
      if (localObject != null)
      {
        localObject = ((AbstractPlatformRandom)localObject).getImpl();
        if (localObject != null) {
          return localObject;
        }
      }
      return (java.util.Random)new KotlinRandom(paramRandom);
    }
  }
  
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Random asKotlinRandom(@NotNull java.util.Random paramRandom)
  {
    Intrinsics.checkParameterIsNotNull(paramRandom, "$this$asKotlinRandom");
    if (!(paramRandom instanceof KotlinRandom)) {}
    for (Object localObject = null;; localObject = paramRandom)
    {
      localObject = (KotlinRandom)localObject;
      if (localObject != null)
      {
        localObject = ((KotlinRandom)localObject).getImpl();
        if (localObject != null) {
          return localObject;
        }
      }
      return (Random)new PlatformRandom(paramRandom);
    }
  }
  
  @InlineOnly
  private static final Random defaultPlatformRandom()
  {
    return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
  }
  
  public static final double doubleFromParts(int paramInt1, int paramInt2)
  {
    return ((paramInt1 << 27) + paramInt2) / 9007199254740992L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.random.PlatformRandomKt
 * JD-Core Version:    0.7.0.1
 */