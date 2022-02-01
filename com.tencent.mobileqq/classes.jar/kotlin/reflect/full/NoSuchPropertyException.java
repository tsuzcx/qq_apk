package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/full/NoSuchPropertyException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "(Ljava/lang/Exception;)V", "kotlin-reflection"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public final class NoSuchPropertyException
  extends Exception
{
  public NoSuchPropertyException()
  {
    this(null, 1, null);
  }
  
  public NoSuchPropertyException(@Nullable Exception paramException)
  {
    super((Throwable)paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.NoSuchPropertyException
 * JD-Core Version:    0.7.0.1
 */