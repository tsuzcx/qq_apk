package kotlin;

import java.io.Serializable;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/Result$Failure;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "exception", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Result$Failure
  implements Serializable
{
  @JvmField
  @NotNull
  public final Throwable exception;
  
  public Result$Failure(@NotNull Throwable paramThrowable)
  {
    this.exception = paramThrowable;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Failure)) && (Intrinsics.areEqual(this.exception, ((Failure)paramObject).exception));
  }
  
  public int hashCode()
  {
    return this.exception.hashCode();
  }
  
  @NotNull
  public String toString()
  {
    return "Failure(" + this.exception + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.Result.Failure
 * JD-Core Version:    0.7.0.1
 */