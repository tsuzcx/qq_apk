package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KClassImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$Data;", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KClassImpl;)V", "allMembers", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "getAllMembers", "()Ljava/util/Collection;", "allMembers$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "allNonStaticMembers", "getAllNonStaticMembers", "allNonStaticMembers$delegate", "allStaticMembers", "getAllStaticMembers", "allStaticMembers$delegate", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "annotations$delegate", "constructors", "Lkotlin/reflect/KFunction;", "constructors$annotations", "()V", "getConstructors", "constructors$delegate", "declaredMembers", "getDeclaredMembers", "declaredMembers$delegate", "declaredNonStaticMembers", "getDeclaredNonStaticMembers", "declaredNonStaticMembers$delegate", "declaredStaticMembers", "getDeclaredStaticMembers", "declaredStaticMembers$delegate", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;", "descriptor$delegate", "inheritedNonStaticMembers", "getInheritedNonStaticMembers", "inheritedNonStaticMembers$delegate", "inheritedStaticMembers", "getInheritedStaticMembers", "inheritedStaticMembers$delegate", "nestedClasses", "Lkotlin/reflect/KClass;", "getNestedClasses", "nestedClasses$delegate", "objectInstance", "objectInstance$annotations", "getObjectInstance", "()Ljava/lang/Object;", "objectInstance$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "qualifiedName$delegate", "sealedSubclasses", "getSealedSubclasses", "sealedSubclasses$delegate", "simpleName", "getSimpleName", "simpleName$delegate", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes", "supertypes$delegate", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters$delegate", "calculateLocalClassName", "jClass", "Ljava/lang/Class;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KClassImpl$Data
  extends KDeclarationContainerImpl.Data
{
  @NotNull
  private final ReflectProperties.LazySoftVal allMembers$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.allMembers.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal allNonStaticMembers$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.allNonStaticMembers.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal allStaticMembers$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.allStaticMembers.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal annotations$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.annotations.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal constructors$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.constructors.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal declaredMembers$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.declaredMembers.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal declaredNonStaticMembers$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.declaredNonStaticMembers.2(this));
  private final ReflectProperties.LazySoftVal declaredStaticMembers$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.declaredStaticMembers.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal descriptor$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.descriptor.2(this));
  private final ReflectProperties.LazySoftVal inheritedNonStaticMembers$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.inheritedNonStaticMembers.2(this));
  private final ReflectProperties.LazySoftVal inheritedStaticMembers$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.inheritedStaticMembers.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal nestedClasses$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.nestedClasses.2(this));
  @Nullable
  private final ReflectProperties.LazyVal objectInstance$delegate = ReflectProperties.lazy((Function0)new KClassImpl.Data.objectInstance.2(this));
  @Nullable
  private final ReflectProperties.LazySoftVal qualifiedName$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.qualifiedName.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal sealedSubclasses$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.sealedSubclasses.2(this));
  @Nullable
  private final ReflectProperties.LazySoftVal simpleName$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.simpleName.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal supertypes$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.supertypes.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal typeParameters$delegate = ReflectProperties.lazySoft((Function0)new KClassImpl.Data.typeParameters.2(this));
  
  public KClassImpl$Data()
  {
    super(localKDeclarationContainerImpl);
  }
  
  private final String calculateLocalClassName(Class<?> paramClass)
  {
    String str = paramClass.getSimpleName();
    Object localObject = paramClass.getEnclosingMethod();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(str, "name");
      paramClass = new StringBuilder();
      paramClass.append(((Method)localObject).getName());
      paramClass.append("$");
      return StringsKt.substringAfter$default(str, paramClass.toString(), null, 2, null);
    }
    paramClass = paramClass.getEnclosingConstructor();
    if (paramClass != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(str, "name");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append("$");
      return StringsKt.substringAfter$default(str, ((StringBuilder)localObject).toString(), null, 2, null);
    }
    Intrinsics.checkExpressionValueIsNotNull(str, "name");
    return StringsKt.substringAfter$default(str, '$', null, 2, null);
  }
  
  private final Collection<KCallableImpl<?>> getDeclaredStaticMembers()
  {
    return (Collection)this.declaredStaticMembers$delegate.getValue(this, $$delegatedProperties[11]);
  }
  
  private final Collection<KCallableImpl<?>> getInheritedNonStaticMembers()
  {
    return (Collection)this.inheritedNonStaticMembers$delegate.getValue(this, $$delegatedProperties[12]);
  }
  
  private final Collection<KCallableImpl<?>> getInheritedStaticMembers()
  {
    return (Collection)this.inheritedStaticMembers$delegate.getValue(this, $$delegatedProperties[13]);
  }
  
  @NotNull
  public final Collection<KCallableImpl<?>> getAllMembers()
  {
    return (Collection)this.allMembers$delegate.getValue(this, $$delegatedProperties[17]);
  }
  
  @NotNull
  public final Collection<KCallableImpl<?>> getAllNonStaticMembers()
  {
    return (Collection)this.allNonStaticMembers$delegate.getValue(this, $$delegatedProperties[14]);
  }
  
  @NotNull
  public final Collection<KCallableImpl<?>> getAllStaticMembers()
  {
    return (Collection)this.allStaticMembers$delegate.getValue(this, $$delegatedProperties[15]);
  }
  
  @NotNull
  public final List<Annotation> getAnnotations()
  {
    return (List)this.annotations$delegate.getValue(this, $$delegatedProperties[1]);
  }
  
  @NotNull
  public final Collection<KFunction<T>> getConstructors()
  {
    return (Collection)this.constructors$delegate.getValue(this, $$delegatedProperties[4]);
  }
  
  @NotNull
  public final Collection<KCallableImpl<?>> getDeclaredMembers()
  {
    return (Collection)this.declaredMembers$delegate.getValue(this, $$delegatedProperties[16]);
  }
  
  @NotNull
  public final Collection<KCallableImpl<?>> getDeclaredNonStaticMembers()
  {
    return (Collection)this.declaredNonStaticMembers$delegate.getValue(this, $$delegatedProperties[10]);
  }
  
  @NotNull
  public final ClassDescriptor getDescriptor()
  {
    return (ClassDescriptor)this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
  }
  
  @NotNull
  public final Collection<KClass<?>> getNestedClasses()
  {
    return (Collection)this.nestedClasses$delegate.getValue(this, $$delegatedProperties[5]);
  }
  
  @Nullable
  public final T getObjectInstance()
  {
    return this.objectInstance$delegate.getValue(this, $$delegatedProperties[6]);
  }
  
  @Nullable
  public final String getQualifiedName()
  {
    return (String)this.qualifiedName$delegate.getValue(this, $$delegatedProperties[3]);
  }
  
  @NotNull
  public final List<KClass<? extends T>> getSealedSubclasses()
  {
    return (List)this.sealedSubclasses$delegate.getValue(this, $$delegatedProperties[9]);
  }
  
  @Nullable
  public final String getSimpleName()
  {
    return (String)this.simpleName$delegate.getValue(this, $$delegatedProperties[2]);
  }
  
  @NotNull
  public final List<KType> getSupertypes()
  {
    return (List)this.supertypes$delegate.getValue(this, $$delegatedProperties[8]);
  }
  
  @NotNull
  public final List<KTypeParameter> getTypeParameters()
  {
    return (List)this.typeParameters$delegate.getValue(this, $$delegatedProperties[7]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KClassImpl.Data
 * JD-Core Version:    0.7.0.1
 */