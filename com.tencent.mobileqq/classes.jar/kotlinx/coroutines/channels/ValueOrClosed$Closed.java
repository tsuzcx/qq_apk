package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ValueOrClosed$Closed;", "", "cause", "", "(Ljava/lang/Throwable;)V", "equals", "", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ValueOrClosed$Closed
{
  @JvmField
  @Nullable
  public final Throwable cause;
  
  public ValueOrClosed$Closed(@Nullable Throwable paramThrowable)
  {
    this.cause = paramThrowable;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof Closed)) && (Intrinsics.areEqual(this.cause, ((Closed)paramObject).cause));
  }
  
  public int hashCode()
  {
    Throwable localThrowable = this.cause;
    if (localThrowable != null) {
      return localThrowable.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Closed(");
    localStringBuilder.append(this.cause);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ValueOrClosed.Closed
 * JD-Core Version:    0.7.0.1
 */