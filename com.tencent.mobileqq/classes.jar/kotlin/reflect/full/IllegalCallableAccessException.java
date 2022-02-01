package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/full/IllegalCallableAccessException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "Ljava/lang/IllegalAccessException;", "(Ljava/lang/IllegalAccessException;)V", "kotlin-reflection"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public final class IllegalCallableAccessException
  extends Exception
{
  public IllegalCallableAccessException(@NotNull IllegalAccessException paramIllegalAccessException)
  {
    super((Throwable)paramIllegalAccessException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.IllegalCallableAccessException
 * JD-Core Version:    0.7.0.1
 */