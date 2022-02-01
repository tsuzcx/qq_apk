package kotlin.reflect.jvm;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "jvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k=2, mv={1, 1, 16})
@JvmName(name="KTypesJvm")
public final class KTypesJvm
{
  @NotNull
  public static final KClass<?> getJvmErasure(@NotNull KClassifier paramKClassifier)
  {
    Intrinsics.checkParameterIsNotNull(paramKClassifier, "$this$jvmErasure");
    if ((paramKClassifier instanceof KClass)) {
      return (KClass)paramKClassifier;
    }
    if ((paramKClassifier instanceof KTypeParameter))
    {
      List localList = ((KTypeParameter)paramKClassifier).getUpperBounds();
      Iterator localIterator = ((Iterable)localList).iterator();
      int i;
      do
      {
        boolean bool = localIterator.hasNext();
        paramKClassifier = null;
        if (!bool) {
          break label172;
        }
        localObject1 = localIterator.next();
        Object localObject2 = (KType)localObject1;
        if (localObject2 == null) {
          break;
        }
        localObject2 = ((KTypeImpl)localObject2).getType().getConstructor().getDeclarationDescriptor();
        if ((localObject2 instanceof ClassDescriptor)) {
          paramKClassifier = (KClassifier)localObject2;
        }
        paramKClassifier = (ClassDescriptor)paramKClassifier;
        if ((paramKClassifier != null) && (paramKClassifier.getKind() != ClassKind.INTERFACE) && (paramKClassifier.getKind() != ClassKind.ANNOTATION_CLASS)) {
          i = 1;
        } else {
          i = 0;
        }
      } while (i == 0);
      paramKClassifier = (KClassifier)localObject1;
      break label174;
      throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
      label172:
      paramKClassifier = null;
      label174:
      paramKClassifier = (KType)paramKClassifier;
      if (paramKClassifier == null) {
        paramKClassifier = (KType)CollectionsKt.firstOrNull(localList);
      }
      if (paramKClassifier != null)
      {
        paramKClassifier = getJvmErasure(paramKClassifier);
        if (paramKClassifier != null) {
          return paramKClassifier;
        }
      }
      return Reflection.getOrCreateKotlinClass(Object.class);
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Cannot calculate JVM erasure for type: ");
    ((StringBuilder)localObject1).append(paramKClassifier);
    paramKClassifier = (Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw paramKClassifier;
    }
  }
  
  @NotNull
  public static final KClass<?> getJvmErasure(@NotNull KType paramKType)
  {
    Intrinsics.checkParameterIsNotNull(paramKType, "$this$jvmErasure");
    Object localObject = paramKType.getClassifier();
    if (localObject != null)
    {
      localObject = getJvmErasure((KClassifier)localObject);
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Cannot calculate JVM erasure for type: ");
    ((StringBuilder)localObject).append(paramKType);
    throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject).toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.KTypesJvm
 * JD-Core Version:    0.7.0.1
 */