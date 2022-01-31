package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/FallbackThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "implStorage", "kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Lkotlin/random/FallbackThreadLocalRandom$implStorage$1;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class FallbackThreadLocalRandom
  extends AbstractPlatformRandom
{
  private final FallbackThreadLocalRandom.implStorage.1 implStorage = new FallbackThreadLocalRandom.implStorage.1();
  
  @NotNull
  public Random getImpl()
  {
    Object localObject = this.implStorage.get();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "implStorage.get()");
    return (Random)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.random.FallbackThreadLocalRandom
 * JD-Core Version:    0.7.0.1
 */