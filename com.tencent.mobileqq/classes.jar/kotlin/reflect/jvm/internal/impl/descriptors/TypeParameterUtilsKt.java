package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeParameterUtilsKt
{
  @Nullable
  public static final PossiblyInnerType buildPossiblyInnerType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$buildPossiblyInnerType");
    ClassifierDescriptor localClassifierDescriptor2 = paramKotlinType.getConstructor().getDeclarationDescriptor();
    ClassifierDescriptor localClassifierDescriptor1 = localClassifierDescriptor2;
    if (!(localClassifierDescriptor2 instanceof ClassifierDescriptorWithTypeParameters)) {
      localClassifierDescriptor1 = null;
    }
    return buildPossiblyInnerType(paramKotlinType, (ClassifierDescriptorWithTypeParameters)localClassifierDescriptor1, 0);
  }
  
  private static final PossiblyInnerType buildPossiblyInnerType(@NotNull KotlinType paramKotlinType, ClassifierDescriptorWithTypeParameters paramClassifierDescriptorWithTypeParameters, int paramInt)
  {
    Object localObject = null;
    if (paramClassifierDescriptorWithTypeParameters != null)
    {
      DeclarationDescriptor localDeclarationDescriptor = (DeclarationDescriptor)paramClassifierDescriptorWithTypeParameters;
      if (ErrorUtils.isError(localDeclarationDescriptor)) {
        return null;
      }
      int j = paramClassifierDescriptorWithTypeParameters.getDeclaredTypeParameters().size() + paramInt;
      if (!paramClassifierDescriptorWithTypeParameters.isInner())
      {
        int i;
        if ((j != paramKotlinType.getArguments().size()) && (!DescriptorUtils.isLocal(localDeclarationDescriptor))) {
          i = 0;
        } else {
          i = 1;
        }
        if ((_Assertions.ENABLED) && (i == 0))
        {
          paramClassifierDescriptorWithTypeParameters = new StringBuilder();
          paramClassifierDescriptorWithTypeParameters.append(paramKotlinType.getArguments().size() - j);
          paramClassifierDescriptorWithTypeParameters.append(" trailing arguments were found in ");
          paramClassifierDescriptorWithTypeParameters.append(paramKotlinType);
          paramClassifierDescriptorWithTypeParameters.append(" type");
          throw ((Throwable)new AssertionError(paramClassifierDescriptorWithTypeParameters.toString()));
        }
        return new PossiblyInnerType(paramClassifierDescriptorWithTypeParameters, paramKotlinType.getArguments().subList(paramInt, paramKotlinType.getArguments().size()), null);
      }
      List localList = paramKotlinType.getArguments().subList(paramInt, j);
      localDeclarationDescriptor = paramClassifierDescriptorWithTypeParameters.getContainingDeclaration();
      if ((localDeclarationDescriptor instanceof ClassifierDescriptorWithTypeParameters)) {
        localObject = localDeclarationDescriptor;
      }
      return new PossiblyInnerType(paramClassifierDescriptorWithTypeParameters, localList, buildPossiblyInnerType(paramKotlinType, (ClassifierDescriptorWithTypeParameters)localObject, j));
    }
    return null;
  }
  
  private static final CapturedTypeParameterDescriptor capturedCopyForInnerDeclaration(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor, DeclarationDescriptor paramDeclarationDescriptor, int paramInt)
  {
    return new CapturedTypeParameterDescriptor(paramTypeParameterDescriptor, paramDeclarationDescriptor, paramInt);
  }
  
  @NotNull
  public static final List<TypeParameterDescriptor> computeConstructorTypeParameters(@NotNull ClassifierDescriptorWithTypeParameters paramClassifierDescriptorWithTypeParameters)
  {
    Intrinsics.checkParameterIsNotNull(paramClassifierDescriptorWithTypeParameters, "$this$computeConstructorTypeParameters");
    List localList1 = paramClassifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(localList1, "declaredTypeParameters");
    if ((!paramClassifierDescriptorWithTypeParameters.isInner()) && (!(paramClassifierDescriptorWithTypeParameters.getContainingDeclaration() instanceof CallableDescriptor))) {
      return localList1;
    }
    DeclarationDescriptor localDeclarationDescriptor = (DeclarationDescriptor)paramClassifierDescriptorWithTypeParameters;
    List localList2 = SequencesKt.toList(SequencesKt.flatMap(SequencesKt.filter(SequencesKt.takeWhile(DescriptorUtilsKt.getParents(localDeclarationDescriptor), (Function1)TypeParameterUtilsKt.computeConstructorTypeParameters.parametersFromContainingFunctions.1.INSTANCE), (Function1)TypeParameterUtilsKt.computeConstructorTypeParameters.parametersFromContainingFunctions.2.INSTANCE), (Function1)TypeParameterUtilsKt.computeConstructorTypeParameters.parametersFromContainingFunctions.3.INSTANCE));
    Object localObject2 = DescriptorUtilsKt.getParents(localDeclarationDescriptor).iterator();
    TypeParameterDescriptor localTypeParameterDescriptor;
    do
    {
      boolean bool = ((Iterator)localObject2).hasNext();
      localTypeParameterDescriptor = null;
      if (!bool) {
        break;
      }
      localObject1 = ((Iterator)localObject2).next();
    } while (!(localObject1 instanceof ClassDescriptor));
    break label134;
    Object localObject1 = null;
    label134:
    localObject2 = (ClassDescriptor)localObject1;
    localObject1 = localTypeParameterDescriptor;
    if (localObject2 != null)
    {
      localObject2 = ((ClassDescriptor)localObject2).getTypeConstructor();
      localObject1 = localTypeParameterDescriptor;
      if (localObject2 != null) {
        localObject1 = ((TypeConstructor)localObject2).getParameters();
      }
    }
    if (localObject1 == null) {
      localObject1 = CollectionsKt.emptyList();
    }
    if ((localList2.isEmpty()) && (((List)localObject1).isEmpty()))
    {
      paramClassifierDescriptorWithTypeParameters = paramClassifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
      Intrinsics.checkExpressionValueIsNotNull(paramClassifierDescriptorWithTypeParameters, "declaredTypeParameters");
      return paramClassifierDescriptorWithTypeParameters;
    }
    localObject1 = (Iterable)CollectionsKt.plus((Collection)localList2, (Iterable)localObject1);
    paramClassifierDescriptorWithTypeParameters = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localTypeParameterDescriptor = (TypeParameterDescriptor)((Iterator)localObject1).next();
      Intrinsics.checkExpressionValueIsNotNull(localTypeParameterDescriptor, "it");
      paramClassifierDescriptorWithTypeParameters.add(capturedCopyForInnerDeclaration(localTypeParameterDescriptor, localDeclarationDescriptor, localList1.size()));
    }
    paramClassifierDescriptorWithTypeParameters = (List)paramClassifierDescriptorWithTypeParameters;
    return CollectionsKt.plus((Collection)localList1, (Iterable)paramClassifierDescriptorWithTypeParameters);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt
 * JD-Core Version:    0.7.0.1
 */