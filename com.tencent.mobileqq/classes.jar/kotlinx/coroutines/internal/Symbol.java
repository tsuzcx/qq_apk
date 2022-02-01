package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/internal/Symbol;", "", "symbol", "", "(Ljava/lang/String;)V", "getSymbol", "()Ljava/lang/String;", "toString", "unbox", "T", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class Symbol
{
  @NotNull
  private final String symbol;
  
  public Symbol(@NotNull String paramString)
  {
    this.symbol = paramString;
  }
  
  @NotNull
  public final String getSymbol()
  {
    return this.symbol;
  }
  
  @NotNull
  public String toString()
  {
    return this.symbol;
  }
  
  public final <T> T unbox(@Nullable Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == (Symbol)this) {
      localObject = null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.internal.Symbol
 * JD-Core Version:    0.7.0.1
 */