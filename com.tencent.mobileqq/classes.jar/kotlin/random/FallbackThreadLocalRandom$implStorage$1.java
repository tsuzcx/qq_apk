package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Ljava/lang/ThreadLocal;", "Ljava/util/Random;", "initialValue", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class FallbackThreadLocalRandom$implStorage$1
  extends ThreadLocal<Random>
{
  @NotNull
  protected Random initialValue()
  {
    return new Random();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.random.FallbackThreadLocalRandom.implStorage.1
 * JD-Core Version:    0.7.0.1
 */