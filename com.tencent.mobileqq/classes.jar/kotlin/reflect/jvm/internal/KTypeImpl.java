package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "isMarkedNullable", "", "()Z", "javaType", "getJavaType$kotlin_reflection", "()Ljava/lang/reflect/Type;", "javaType$delegate", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "toString", "", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KTypeImpl
  implements KType
{
  @NotNull
  private final ReflectProperties.LazySoftVal arguments$delegate;
  @Nullable
  private final ReflectProperties.LazySoftVal classifier$delegate;
  @NotNull
  private final ReflectProperties.LazySoftVal javaType$delegate;
  @NotNull
  private final KotlinType type;
  
  public KTypeImpl(@NotNull KotlinType paramKotlinType, @NotNull Function0<? extends Type> paramFunction0)
  {
    this.type = paramKotlinType;
    this.javaType$delegate = ReflectProperties.lazySoft(paramFunction0);
    this.classifier$delegate = ReflectProperties.lazySoft((Function0)new KTypeImpl.classifier.2(this));
    this.arguments$delegate = ReflectProperties.lazySoft((Function0)new KTypeImpl.arguments.2(this));
  }
  
  private final KClassifier convert(KotlinType paramKotlinType)
  {
    Object localObject = paramKotlinType.getConstructor().getDeclarationDescriptor();
    if ((localObject instanceof ClassDescriptor))
    {
      localObject = UtilKt.toJavaClass((ClassDescriptor)localObject);
      if (localObject != null)
      {
        if (((Class)localObject).isArray())
        {
          paramKotlinType = (TypeProjection)CollectionsKt.singleOrNull(paramKotlinType.getArguments());
          if (paramKotlinType != null)
          {
            paramKotlinType = paramKotlinType.getType();
            if (paramKotlinType != null)
            {
              Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "type.arguments.singleOrN…return KClassImpl(jClass)");
              paramKotlinType = convert(paramKotlinType);
              if (paramKotlinType != null) {
                return (KClassifier)new KClassImpl(ReflectClassUtilKt.createArrayType(JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(paramKotlinType))));
              }
              paramKotlinType = new StringBuilder();
              paramKotlinType.append("Cannot determine classifier for array element type: ");
              paramKotlinType.append(this);
              throw ((Throwable)new KotlinReflectionInternalError(paramKotlinType.toString()));
            }
          }
          return (KClassifier)new KClassImpl((Class)localObject);
        }
        if (!TypeUtils.isNullableType(paramKotlinType))
        {
          Class localClass = ReflectClassUtilKt.getPrimitiveByWrapper((Class)localObject);
          paramKotlinType = (KotlinType)localObject;
          if (localClass != null) {
            paramKotlinType = localClass;
          }
          return (KClassifier)new KClassImpl(paramKotlinType);
        }
        return (KClassifier)new KClassImpl((Class)localObject);
      }
      return null;
    }
    if ((localObject instanceof TypeParameterDescriptor)) {
      return (KClassifier)new KTypeParameterImpl((TypeParameterDescriptor)localObject);
    }
    if (!(localObject instanceof TypeAliasDescriptor)) {
      return null;
    }
    paramKotlinType = new StringBuilder();
    paramKotlinType.append("An operation is not implemented: ");
    paramKotlinType.append("Type alias classifiers are not yet supported");
    throw ((Throwable)new NotImplementedError(paramKotlinType.toString()));
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof KTypeImpl)) && (Intrinsics.areEqual(this.type, ((KTypeImpl)paramObject).type));
  }
  
  @NotNull
  public List<Annotation> getAnnotations()
  {
    return UtilKt.computeAnnotations((Annotated)this.type);
  }
  
  @NotNull
  public List<KTypeProjection> getArguments()
  {
    return (List)this.arguments$delegate.getValue(this, $$delegatedProperties[2]);
  }
  
  @Nullable
  public KClassifier getClassifier()
  {
    return (KClassifier)this.classifier$delegate.getValue(this, $$delegatedProperties[1]);
  }
  
  @NotNull
  public final Type getJavaType$kotlin_reflection()
  {
    return (Type)this.javaType$delegate.getValue(this, $$delegatedProperties[0]);
  }
  
  @NotNull
  public final KotlinType getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return this.type.hashCode();
  }
  
  public boolean isMarkedNullable()
  {
    return this.type.isMarkedNullable();
  }
  
  @NotNull
  public String toString()
  {
    return ReflectionObjectRenderer.INSTANCE.renderType(this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KTypeImpl
 * JD-Core Version:    0.7.0.1
 */