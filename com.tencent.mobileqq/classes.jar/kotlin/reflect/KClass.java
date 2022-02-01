package kotlin.reflect;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KClass;", "T", "", "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "", "sealedSubclasses$annotations", "getSealedSubclasses", "()Ljava/util/List;", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "hashCode", "", "isInstance", "value", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KClass<T>
  extends KAnnotatedElement, KClassifier, KDeclarationContainer
{
  public abstract boolean equals(@Nullable Object paramObject);
  
  @NotNull
  public abstract Collection<KFunction<T>> getConstructors();
  
  @NotNull
  public abstract Collection<KCallable<?>> getMembers();
  
  @NotNull
  public abstract Collection<KClass<?>> getNestedClasses();
  
  @Nullable
  public abstract T getObjectInstance();
  
  @Nullable
  public abstract String getQualifiedName();
  
  @NotNull
  public abstract List<KClass<? extends T>> getSealedSubclasses();
  
  @Nullable
  public abstract String getSimpleName();
  
  @NotNull
  public abstract List<KType> getSupertypes();
  
  @NotNull
  public abstract List<KTypeParameter> getTypeParameters();
  
  @Nullable
  public abstract KVisibility getVisibility();
  
  public abstract int hashCode();
  
  public abstract boolean isAbstract();
  
  public abstract boolean isCompanion();
  
  public abstract boolean isData();
  
  public abstract boolean isFinal();
  
  public abstract boolean isInner();
  
  @SinceKotlin(version="1.1")
  public abstract boolean isInstance(@Nullable Object paramObject);
  
  public abstract boolean isOpen();
  
  public abstract boolean isSealed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.reflect.KClass
 * JD-Core Version:    0.7.0.1
 */