package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class AbstractTypeConstructor$ModuleViewTypeConstructor
  implements TypeConstructor
{
  private final KotlinTypeRefiner kotlinTypeRefiner;
  private final Lazy refinedSupertypes$delegate;
  
  public AbstractTypeConstructor$ModuleViewTypeConstructor(KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    this.kotlinTypeRefiner = localObject;
    this.refinedSupertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new AbstractTypeConstructor.ModuleViewTypeConstructor.refinedSupertypes.2(this));
  }
  
  private final List<KotlinType> getRefinedSupertypes()
  {
    return (List)this.refinedSupertypes$delegate.getValue();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return this.this$0.equals(paramObject);
  }
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    KotlinBuiltIns localKotlinBuiltIns = this.this$0.getBuiltIns();
    Intrinsics.checkExpressionValueIsNotNull(localKotlinBuiltIns, "this@AbstractTypeConstructor.builtIns");
    return localKotlinBuiltIns;
  }
  
  @NotNull
  public ClassifierDescriptor getDeclarationDescriptor()
  {
    return this.this$0.getDeclarationDescriptor();
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getParameters()
  {
    List localList = this.this$0.getParameters();
    Intrinsics.checkExpressionValueIsNotNull(localList, "this@AbstractTypeConstructor.parameters");
    return localList;
  }
  
  @NotNull
  public List<KotlinType> getSupertypes()
  {
    return getRefinedSupertypes();
  }
  
  public int hashCode()
  {
    return this.this$0.hashCode();
  }
  
  public boolean isDenotable()
  {
    return this.this$0.isDenotable();
  }
  
  @NotNull
  public TypeConstructor refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return this.this$0.refine(paramKotlinTypeRefiner);
  }
  
  @NotNull
  public String toString()
  {
    return this.this$0.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.ModuleViewTypeConstructor
 * JD-Core Version:    0.7.0.1
 */