package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Element.DefaultImpls;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/flow/internal/DownstreamExceptionElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "e", "", "(Ljava/lang/Throwable;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "Key", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class DownstreamExceptionElement
  implements CoroutineContext.Element
{
  public static final DownstreamExceptionElement.Key Key = new DownstreamExceptionElement.Key(null);
  @JvmField
  @NotNull
  public final Throwable e;
  @NotNull
  private final CoroutineContext.Key<?> key;
  
  public DownstreamExceptionElement(@NotNull Throwable paramThrowable)
  {
    this.e = paramThrowable;
    this.key = ((CoroutineContext.Key)Key);
  }
  
  public <R> R fold(R paramR, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> paramFunction2)
  {
    return CoroutineContext.Element.DefaultImpls.fold(this, paramR, paramFunction2);
  }
  
  @Nullable
  public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> paramKey)
  {
    return CoroutineContext.Element.DefaultImpls.get(this, paramKey);
  }
  
  @NotNull
  public CoroutineContext.Key<?> getKey()
  {
    return this.key;
  }
  
  @NotNull
  public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> paramKey)
  {
    return CoroutineContext.Element.DefaultImpls.minusKey(this, paramKey);
  }
  
  @NotNull
  public CoroutineContext plus(@NotNull CoroutineContext paramCoroutineContext)
  {
    return CoroutineContext.Element.DefaultImpls.plus(this, paramCoroutineContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.flow.internal.DownstreamExceptionElement
 * JD-Core Version:    0.7.0.1
 */