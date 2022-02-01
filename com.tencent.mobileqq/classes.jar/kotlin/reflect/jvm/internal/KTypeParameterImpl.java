package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KTypeParameterImpl
  implements KTypeParameter, KClassifierImpl
{
  @NotNull
  private final TypeParameterDescriptor descriptor;
  @NotNull
  private final ReflectProperties.LazySoftVal upperBounds$delegate;
  
  public KTypeParameterImpl(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    this.descriptor = paramTypeParameterDescriptor;
    this.upperBounds$delegate = ReflectProperties.lazySoft((Function0)new KTypeParameterImpl.upperBounds.2(this));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof KTypeParameterImpl)) && (Intrinsics.areEqual(getDescriptor(), ((KTypeParameterImpl)paramObject).getDescriptor()));
  }
  
  @NotNull
  public TypeParameterDescriptor getDescriptor()
  {
    return this.descriptor;
  }
  
  @NotNull
  public String getName()
  {
    String str = getDescriptor().getName().asString();
    Intrinsics.checkExpressionValueIsNotNull(str, "descriptor.name.asString()");
    return str;
  }
  
  @NotNull
  public List<KType> getUpperBounds()
  {
    return (List)this.upperBounds$delegate.getValue(this, $$delegatedProperties[0]);
  }
  
  @NotNull
  public KVariance getVariance()
  {
    Variance localVariance = getDescriptor().getVariance();
    int i = KTypeParameterImpl.WhenMappings.$EnumSwitchMapping$0[localVariance.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return KVariance.OUT;
        }
        throw new NoWhenBranchMatchedException();
      }
      return KVariance.IN;
    }
    return KVariance.INVARIANT;
  }
  
  public int hashCode()
  {
    return getDescriptor().hashCode();
  }
  
  public boolean isReified()
  {
    return getDescriptor().isReified();
  }
  
  @NotNull
  public String toString()
  {
    return ReflectionObjectRenderer.INSTANCE.renderTypeParameter(getDescriptor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KTypeParameterImpl
 * JD-Core Version:    0.7.0.1
 */