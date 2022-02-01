package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CompletedIdempotentResult;", "", "idempotentResume", "result", "(Ljava/lang/Object;Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class CompletedIdempotentResult
{
  @JvmField
  @Nullable
  public final Object idempotentResume;
  @JvmField
  @Nullable
  public final Object result;
  
  public CompletedIdempotentResult(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    this.idempotentResume = paramObject1;
    this.result = paramObject2;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompletedIdempotentResult[");
    localStringBuilder.append(this.result);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CompletedIdempotentResult
 * JD-Core Version:    0.7.0.1
 */