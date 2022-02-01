package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/full/IllegalPropertyDelegateAccessException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "Ljava/lang/IllegalAccessException;", "(Ljava/lang/IllegalAccessException;)V", "kotlin-reflection"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public final class IllegalPropertyDelegateAccessException
  extends Exception
{
  public IllegalPropertyDelegateAccessException(@NotNull IllegalAccessException paramIllegalAccessException)
  {
    super("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", (Throwable)paramIllegalAccessException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.IllegalPropertyDelegateAccessException
 * JD-Core Version:    0.7.0.1
 */