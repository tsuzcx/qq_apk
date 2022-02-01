package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/sync/Empty;", "", "locked", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class Empty
{
  @JvmField
  @NotNull
  public final Object locked;
  
  public Empty(@NotNull Object paramObject)
  {
    this.locked = paramObject;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Empty[");
    localStringBuilder.append(this.locked);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.sync.Empty
 * JD-Core Version:    0.7.0.1
 */