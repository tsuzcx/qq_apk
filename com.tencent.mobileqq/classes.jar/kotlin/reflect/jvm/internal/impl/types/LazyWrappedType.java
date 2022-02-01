package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class LazyWrappedType
  extends WrappedType
{
  private final Function0<KotlinType> computation;
  private final NotNullLazyValue<KotlinType> lazyValue;
  private final StorageManager storageManager;
  
  public LazyWrappedType(@NotNull StorageManager paramStorageManager, @NotNull Function0<? extends KotlinType> paramFunction0)
  {
    this.storageManager = paramStorageManager;
    this.computation = paramFunction0;
    this.lazyValue = this.storageManager.createLazyValue(this.computation);
  }
  
  @NotNull
  protected KotlinType getDelegate()
  {
    return (KotlinType)this.lazyValue.invoke();
  }
  
  public boolean isComputed()
  {
    return this.lazyValue.isComputed();
  }
  
  @NotNull
  public LazyWrappedType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return new LazyWrappedType(this.storageManager, (Function0)new LazyWrappedType.refine.1(this, paramKotlinTypeRefiner));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.LazyWrappedType
 * JD-Core Version:    0.7.0.1
 */