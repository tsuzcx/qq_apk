package com.tribe.async.reactive;

import com.tribe.async.utils.AssertUtils;
import java.util.NoSuchElementException;

public final class Optional<T>
{
  private static final Optional<?> EMPTY = new Optional();
  private final T value;
  
  private Optional()
  {
    this.value = null;
  }
  
  private Optional(T paramT)
  {
    if (paramT != null)
    {
      this.value = paramT;
      return;
    }
    throw new NullPointerException();
  }
  
  public static <T> Optional<T> empty()
  {
    return EMPTY;
  }
  
  public static <T> Optional<T> of(T paramT)
  {
    return new Optional(paramT);
  }
  
  public static <T> Optional<T> ofNullable(T paramT)
  {
    if (paramT == null) {
      return empty();
    }
    return of(paramT);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Optional)) {
      return false;
    }
    paramObject = (Optional)paramObject;
    Object localObject = this.value;
    if (localObject == null) {
      return paramObject.value == null;
    }
    return localObject.equals(paramObject.value);
  }
  
  public Optional<T> filter(Predicate<? super T> paramPredicate)
  {
    AssertUtils.checkNotNull(paramPredicate);
    if (!isPresent()) {
      return this;
    }
    if (paramPredicate.test(this.value)) {
      return this;
    }
    return empty();
  }
  
  public <U> Optional<U> flatMap(Function<? super T, Optional<U>> paramFunction)
  {
    AssertUtils.checkNotNull(paramFunction);
    if (!isPresent()) {
      return empty();
    }
    paramFunction = (Optional)paramFunction.apply(this.value);
    AssertUtils.checkNotNull(paramFunction);
    return paramFunction;
  }
  
  public T get()
  {
    Object localObject = this.value;
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException("No value present");
  }
  
  public int hashCode()
  {
    Object localObject = this.value;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public void ifPresent(Consumer<? super T> paramConsumer)
  {
    Object localObject = this.value;
    if (localObject != null) {
      paramConsumer.accept(localObject);
    }
  }
  
  public boolean isPresent()
  {
    return this.value != null;
  }
  
  public <U> Optional<U> map(Function<T, U> paramFunction)
  {
    AssertUtils.checkNotNull(paramFunction);
    if (!isPresent()) {
      return empty();
    }
    return ofNullable(paramFunction.apply(this.value));
  }
  
  public T orElse(T paramT)
  {
    Object localObject = this.value;
    if (localObject != null) {
      paramT = localObject;
    }
    return paramT;
  }
  
  public T orElseGet(Supplier<? extends T> paramSupplier)
  {
    Object localObject = this.value;
    if (localObject != null) {
      return localObject;
    }
    return paramSupplier.get();
  }
  
  public <X extends Throwable> T orElseThrow(Supplier<? extends X> paramSupplier)
  {
    Object localObject = this.value;
    if (localObject != null) {
      return localObject;
    }
    throw ((Throwable)paramSupplier.get());
  }
  
  public String toString()
  {
    Object localObject = this.value;
    if (localObject != null) {
      return String.format("Optional[%s]", new Object[] { localObject });
    }
    return "Optional.empty";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.reactive.Optional
 * JD-Core Version:    0.7.0.1
 */