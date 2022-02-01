package kotlin.random;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Deprecated(level=DeprecationLevel.HIDDEN, message="Use Default companion object instead")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/random/Random$Companion;", "Lkotlin/random/Random;", "()V", "nextBits", "", "bitCount", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Random$Companion
  extends Random
{
  public static final Companion INSTANCE = new Companion();
  
  public int nextBits(int paramInt)
  {
    return Random.Default.nextBits(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.random.Random.Companion
 * JD-Core Version:    0.7.0.1
 */