package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KParameter;
import kotlin.reflect.KParameter.Kind;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KParameterImpl;", "Lkotlin/reflect/KParameter;", "callable", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "index", "", "kind", "Lkotlin/reflect/KParameter$Kind;", "computeDescriptor", "Lkotlin/Function0;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;ILkotlin/reflect/KParameter$Kind;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getCallable", "()Lkotlin/reflect/jvm/internal/KCallableImpl;", "descriptor", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;", "descriptor$delegate", "getIndex", "()I", "isOptional", "", "()Z", "isVararg", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "name", "", "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "equals", "other", "", "hashCode", "toString", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KParameterImpl
  implements KParameter
{
  @NotNull
  private final ReflectProperties.LazySoftVal annotations$delegate;
  @NotNull
  private final KCallableImpl<?> callable;
  private final ReflectProperties.LazySoftVal descriptor$delegate;
  private final int index;
  @NotNull
  private final KParameter.Kind kind;
  
  public KParameterImpl(@NotNull KCallableImpl<?> paramKCallableImpl, int paramInt, @NotNull KParameter.Kind paramKind, @NotNull Function0<? extends ParameterDescriptor> paramFunction0)
  {
    this.callable = paramKCallableImpl;
    this.index = paramInt;
    this.kind = paramKind;
    this.descriptor$delegate = ReflectProperties.lazySoft(paramFunction0);
    this.annotations$delegate = ReflectProperties.lazySoft((Function0)new KParameterImpl.annotations.2(this));
  }
  
  private final ParameterDescriptor getDescriptor()
  {
    return (ParameterDescriptor)this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof KParameterImpl))
    {
      KCallableImpl localKCallableImpl = this.callable;
      paramObject = (KParameterImpl)paramObject;
      if ((Intrinsics.areEqual(localKCallableImpl, paramObject.callable)) && (Intrinsics.areEqual(getDescriptor(), paramObject.getDescriptor()))) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  public List<Annotation> getAnnotations()
  {
    return (List)this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
  }
  
  @NotNull
  public final KCallableImpl<?> getCallable()
  {
    return this.callable;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  @NotNull
  public KParameter.Kind getKind()
  {
    return this.kind;
  }
  
  @Nullable
  public String getName()
  {
    Object localObject1 = getDescriptor();
    boolean bool = localObject1 instanceof ValueParameterDescriptor;
    Object localObject2 = null;
    if (!bool) {
      localObject1 = null;
    }
    ValueParameterDescriptor localValueParameterDescriptor = (ValueParameterDescriptor)localObject1;
    localObject1 = localObject2;
    if (localValueParameterDescriptor != null)
    {
      if (localValueParameterDescriptor.getContainingDeclaration().hasSynthesizedParameterNames()) {
        return null;
      }
      localObject1 = localValueParameterDescriptor.getName();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "valueParameter.name");
      if (((Name)localObject1).isSpecial()) {
        return null;
      }
      localObject1 = ((Name)localObject1).asString();
    }
    return localObject1;
  }
  
  @NotNull
  public KType getType()
  {
    KotlinType localKotlinType = getDescriptor().getType();
    Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "descriptor.type");
    return (KType)new KTypeImpl(localKotlinType, (Function0)new KParameterImpl.type.1(this));
  }
  
  public int hashCode()
  {
    return this.callable.hashCode() * 31 + getDescriptor().hashCode();
  }
  
  public boolean isOptional()
  {
    ParameterDescriptor localParameterDescriptor = getDescriptor();
    Object localObject = localParameterDescriptor;
    if (!(localParameterDescriptor instanceof ValueParameterDescriptor)) {
      localObject = null;
    }
    localObject = (ValueParameterDescriptor)localObject;
    if (localObject != null) {
      return DescriptorUtilsKt.declaresOrInheritsDefaultValue((ValueParameterDescriptor)localObject);
    }
    return false;
  }
  
  public boolean isVararg()
  {
    ParameterDescriptor localParameterDescriptor = getDescriptor();
    return ((localParameterDescriptor instanceof ValueParameterDescriptor)) && (((ValueParameterDescriptor)localParameterDescriptor).getVarargElementType() != null);
  }
  
  @NotNull
  public String toString()
  {
    return ReflectionObjectRenderer.INSTANCE.renderParameter(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KParameterImpl
 * JD-Core Version:    0.7.0.1
 */