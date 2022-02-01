package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public final class CombinedContext
  implements Serializable, CoroutineContext
{
  private final CoroutineContext.Element element;
  private final CoroutineContext left;
  
  public CombinedContext(@NotNull CoroutineContext paramCoroutineContext, @NotNull CoroutineContext.Element paramElement)
  {
    this.left = paramCoroutineContext;
    this.element = paramElement;
  }
  
  private final boolean contains(CoroutineContext.Element paramElement)
  {
    return Intrinsics.areEqual(get(paramElement.getKey()), paramElement);
  }
  
  private final boolean containsAll(CombinedContext paramCombinedContext)
  {
    for (;;)
    {
      if (!contains(paramCombinedContext.element)) {
        return false;
      }
      paramCombinedContext = paramCombinedContext.left;
      if (!(paramCombinedContext instanceof CombinedContext)) {
        break;
      }
      paramCombinedContext = (CombinedContext)paramCombinedContext;
    }
    if (paramCombinedContext != null) {
      return contains((CoroutineContext.Element)paramCombinedContext);
    }
    paramCombinedContext = new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
    for (;;)
    {
      throw paramCombinedContext;
    }
  }
  
  private final int size()
  {
    Object localObject = (CombinedContext)this;
    int i = 2;
    for (;;)
    {
      CoroutineContext localCoroutineContext = ((CombinedContext)localObject).left;
      localObject = localCoroutineContext;
      if (!(localCoroutineContext instanceof CombinedContext)) {
        localObject = null;
      }
      localObject = (CombinedContext)localObject;
      if (localObject == null) {
        break;
      }
      i += 1;
    }
    return i;
  }
  
  private final Object writeReplace()
  {
    int j = size();
    CoroutineContext[] arrayOfCoroutineContext = new CoroutineContext[j];
    Ref.IntRef localIntRef = new Ref.IntRef();
    int i = 0;
    localIntRef.element = 0;
    fold(Unit.INSTANCE, (Function2)new CombinedContext.writeReplace.1(arrayOfCoroutineContext, localIntRef));
    if (localIntRef.element == j) {
      i = 1;
    }
    if (i != 0) {
      return new CombinedContext.Serialized(arrayOfCoroutineContext);
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((CombinedContext)this != paramObject) {
      if ((paramObject instanceof CombinedContext))
      {
        paramObject = (CombinedContext)paramObject;
        if ((paramObject.size() == size()) && (paramObject.containsAll(this))) {}
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
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    return paramFunction2.invoke(this.left.fold(paramR, paramFunction2), this.element);
  }
  
  @Nullable
  public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    for (Object localObject = (CombinedContext)this;; localObject = (CombinedContext)localObject)
    {
      CoroutineContext.Element localElement = ((CombinedContext)localObject).element.get(paramKey);
      if (localElement != null) {
        return localElement;
      }
      localObject = ((CombinedContext)localObject).left;
      if (!(localObject instanceof CombinedContext)) {
        break;
      }
    }
    return ((CoroutineContext)localObject).get(paramKey);
  }
  
  public int hashCode()
  {
    return this.left.hashCode() + this.element.hashCode();
  }
  
  @NotNull
  public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey)
  {
    Intrinsics.checkParameterIsNotNull(paramKey, "key");
    if (this.element.get(paramKey) != null) {
      return this.left;
    }
    paramKey = this.left.minusKey(paramKey);
    if (paramKey == this.left) {
      return (CoroutineContext)this;
    }
    if (paramKey == EmptyCoroutineContext.INSTANCE) {
      return (CoroutineContext)this.element;
    }
    return (CoroutineContext)new CombinedContext(paramKey, this.element);
  }
  
  @NotNull
  public CoroutineContext plus(@NotNull CoroutineContext paramCoroutineContext)
  {
    Intrinsics.checkParameterIsNotNull(paramCoroutineContext, "context");
    return CoroutineContext.DefaultImpls.plus(this, paramCoroutineContext);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append((String)fold("", (Function2)CombinedContext.toString.1.INSTANCE));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.coroutines.CombinedContext
 * JD-Core Version:    0.7.0.1
 */