package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class CoroutineId
  extends AbstractCoroutineContextElement
  implements ThreadContextElement<String>
{
  public static final CoroutineId.Key Key = new CoroutineId.Key(null);
  private final long id;
  
  public CoroutineId(long paramLong)
  {
    super((CoroutineContext.Key)Key);
    this.id = paramLong;
  }
  
  public final long component1()
  {
    return this.id;
  }
  
  @NotNull
  public final CoroutineId copy(long paramLong)
  {
    return new CoroutineId(paramLong);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CoroutineId))
      {
        paramObject = (CoroutineId)paramObject;
        if (this.id == paramObject.id) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public <R> R fold(R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    return ThreadContextElement.DefaultImpls.fold(this, paramR, paramFunction2);
  }
  
  @Nullable
  public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> paramKey)
  {
    return ThreadContextElement.DefaultImpls.get(this, paramKey);
  }
  
  public final long getId()
  {
    return this.id;
  }
  
  public int hashCode()
  {
    long l = this.id;
    return (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey)
  {
    return ThreadContextElement.DefaultImpls.minusKey(this, paramKey);
  }
  
  @NotNull
  public CoroutineContext plus(@NotNull CoroutineContext paramCoroutineContext)
  {
    return ThreadContextElement.DefaultImpls.plus(this, paramCoroutineContext);
  }
  
  public void restoreThreadContext(@NotNull CoroutineContext paramCoroutineContext, @NotNull String paramString)
  {
    Thread.currentThread().setName(paramString);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CoroutineId(");
    localStringBuilder.append(this.id);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  @NotNull
  public String updateThreadContext(@NotNull CoroutineContext paramCoroutineContext)
  {
    paramCoroutineContext = (CoroutineName)paramCoroutineContext.get((CoroutineContext.Key)CoroutineName.Key);
    if (paramCoroutineContext != null)
    {
      paramCoroutineContext = paramCoroutineContext.getName();
      if (paramCoroutineContext != null) {}
    }
    else
    {
      paramCoroutineContext = "coroutine";
    }
    Thread localThread = Thread.currentThread();
    String str1 = localThread.getName();
    int j = StringsKt.lastIndexOf$default((CharSequence)str1, " @", 0, false, 6, null);
    int i = j;
    if (j < 0) {
      i = str1.length();
    }
    StringBuilder localStringBuilder = new StringBuilder(paramCoroutineContext.length() + i + 10);
    if (str1 != null)
    {
      String str2 = str1.substring(0, i);
      Intrinsics.checkExpressionValueIsNotNull(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localStringBuilder.append(str2);
      localStringBuilder.append(" @");
      localStringBuilder.append(paramCoroutineContext);
      localStringBuilder.append('#');
      localStringBuilder.append(this.id);
      paramCoroutineContext = localStringBuilder.toString();
      Intrinsics.checkExpressionValueIsNotNull(paramCoroutineContext, "StringBuilder(capacity).…builderAction).toString()");
      localThread.setName(paramCoroutineContext);
      return str1;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CoroutineId
 * JD-Core Version:    0.7.0.1
 */