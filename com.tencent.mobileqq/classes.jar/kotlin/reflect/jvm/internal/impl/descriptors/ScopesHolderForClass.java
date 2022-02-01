package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class ScopesHolderForClass<T extends MemberScope>
{
  public static final ScopesHolderForClass.Companion Companion = new ScopesHolderForClass.Companion(null);
  private final ClassDescriptor classDescriptor;
  private final KotlinTypeRefiner kotlinTypeRefinerForOwnerModule;
  private final Function1<KotlinTypeRefiner, T> scopeFactory;
  private final NotNullLazyValue scopeForOwnerModule$delegate;
  
  private ScopesHolderForClass(ClassDescriptor paramClassDescriptor, StorageManager paramStorageManager, Function1<? super KotlinTypeRefiner, ? extends T> paramFunction1, KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    this.classDescriptor = paramClassDescriptor;
    this.scopeFactory = paramFunction1;
    this.kotlinTypeRefinerForOwnerModule = paramKotlinTypeRefiner;
    this.scopeForOwnerModule$delegate = paramStorageManager.createLazyValue((Function0)new ScopesHolderForClass.scopeForOwnerModule.2(this));
  }
  
  private final T getScopeForOwnerModule()
  {
    return (MemberScope)StorageKt.getValue(this.scopeForOwnerModule$delegate, this, $$delegatedProperties[0]);
  }
  
  @NotNull
  public final T getScope(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    if (!paramKotlinTypeRefiner.isRefinementNeededForModule(DescriptorUtilsKt.getModule((DeclarationDescriptor)this.classDescriptor))) {
      return getScopeForOwnerModule();
    }
    TypeConstructor localTypeConstructor = this.classDescriptor.getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(localTypeConstructor, "classDescriptor.typeConstructor");
    if (!paramKotlinTypeRefiner.isRefinementNeededForTypeConstructor(localTypeConstructor)) {
      return getScopeForOwnerModule();
    }
    return paramKotlinTypeRefiner.getOrPutScopeForClass(this.classDescriptor, (Function0)new ScopesHolderForClass.getScope.1(this, paramKotlinTypeRefiner));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass
 * JD-Core Version:    0.7.0.1
 */