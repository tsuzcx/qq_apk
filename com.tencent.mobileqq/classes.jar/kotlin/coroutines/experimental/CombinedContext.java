package kotlin.coroutines.experimental;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/experimental/CombinedContext;", "Lkotlin/coroutines/experimental/CoroutineContext;", "left", "element", "Lkotlin/coroutines/experimental/CoroutineContext$Element;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/coroutines/experimental/CoroutineContext$Element;)V", "getElement", "()Lkotlin/coroutines/experimental/CoroutineContext$Element;", "getLeft", "()Lkotlin/coroutines/experimental/CoroutineContext;", "contains", "", "containsAll", "context", "equals", "other", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/experimental/CoroutineContext$Key;", "(Lkotlin/coroutines/experimental/CoroutineContext$Key;)Lkotlin/coroutines/experimental/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "kotlin-stdlib-coroutines"}, k=1, mv={1, 1, 16})
public final class CombinedContext
  implements CoroutineContext
{
  @NotNull
  private final CoroutineContext.Element element;
  @NotNull
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
    if (paramCombinedContext == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.experimental.CoroutineContext.Element");
    }
    return contains((CoroutineContext.Element)paramCombinedContext);
  }
  
  private final int size()
  {
    if ((this.left instanceof CombinedContext)) {
      return ((CombinedContext)this.left).size() + 1;
    }
    return 2;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((CombinedContext)this == paramObject) || (((paramObject instanceof CombinedContext)) && (((CombinedContext)paramObject).size() == size()) && (((CombinedContext)paramObject).containsAll(this)));
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
  
  @NotNull
  public final CoroutineContext.Element getElement()
  {
    return this.element;
  }
  
  @NotNull
  public final CoroutineContext getLeft()
  {
    return this.left;
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
    return "[" + (String)fold("", (Function2)CombinedContext.toString.1.INSTANCE) + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.coroutines.experimental.CombinedContext
 * JD-Core Version:    0.7.0.1
 */