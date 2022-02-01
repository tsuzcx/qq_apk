package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CoroutineName;", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class CoroutineName
  extends AbstractCoroutineContextElement
{
  public static final CoroutineName.Key Key = new CoroutineName.Key(null);
  @NotNull
  private final String name;
  
  public CoroutineName(@NotNull String paramString)
  {
    super((CoroutineContext.Key)Key);
    this.name = paramString;
  }
  
  @NotNull
  public final String component1()
  {
    return this.name;
  }
  
  @NotNull
  public final CoroutineName copy(@NotNull String paramString)
  {
    return new CoroutineName(paramString);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CoroutineName))
      {
        paramObject = (CoroutineName)paramObject;
        if (Intrinsics.areEqual(this.name, paramObject.name)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    String str = this.name;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CoroutineName(");
    localStringBuilder.append(this.name);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineName
 * JD-Core Version:    0.7.0.1
 */