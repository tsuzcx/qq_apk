package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public final class FunctionInvokeDescriptor$Factory
{
  private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor paramFunctionInvokeDescriptor, int paramInt, TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    Object localObject = paramTypeParameterDescriptor.getName().asString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "typeParameter.name.asString()");
    int i = ((String)localObject).hashCode();
    if (i != 69)
    {
      if ((i == 84) && (((String)localObject).equals("T")))
      {
        localObject = "instance";
        break label95;
      }
    }
    else if (((String)localObject).equals("E"))
    {
      localObject = "receiver";
      break label95;
    }
    if (localObject != null)
    {
      localObject = ((String)localObject).toLowerCase();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "(this as java.lang.String).toLowerCase()");
      label95:
      paramFunctionInvokeDescriptor = (CallableDescriptor)paramFunctionInvokeDescriptor;
      Annotations localAnnotations = Annotations.Companion.getEMPTY();
      localObject = Name.identifier((String)localObject);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Name.identifier(name)");
      paramTypeParameterDescriptor = paramTypeParameterDescriptor.getDefaultType();
      Intrinsics.checkExpressionValueIsNotNull(paramTypeParameterDescriptor, "typeParameter.defaultType");
      paramTypeParameterDescriptor = (KotlinType)paramTypeParameterDescriptor;
      SourceElement localSourceElement = SourceElement.NO_SOURCE;
      Intrinsics.checkExpressionValueIsNotNull(localSourceElement, "SourceElement.NO_SOURCE");
      return (ValueParameterDescriptor)new ValueParameterDescriptorImpl(paramFunctionInvokeDescriptor, null, paramInt, localAnnotations, (Name)localObject, paramTypeParameterDescriptor, false, false, false, null, localSourceElement);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  @NotNull
  public final FunctionInvokeDescriptor create(@NotNull FunctionClassDescriptor paramFunctionClassDescriptor, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionClassDescriptor, "functionClass");
    List localList1 = paramFunctionClassDescriptor.getDeclaredTypeParameters();
    FunctionInvokeDescriptor localFunctionInvokeDescriptor = new FunctionInvokeDescriptor((DeclarationDescriptor)paramFunctionClassDescriptor, null, CallableMemberDescriptor.Kind.DECLARATION, paramBoolean, null);
    paramFunctionClassDescriptor = paramFunctionClassDescriptor.getThisAsReceiverParameter();
    List localList2 = CollectionsKt.emptyList();
    Object localObject2 = (Iterable)localList1;
    Object localObject1 = new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      int i;
      if (((TypeParameterDescriptor)localObject3).getVariance() == Variance.IN_VARIANCE) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        break;
      }
      ((ArrayList)localObject1).add(localObject3);
    }
    localObject2 = CollectionsKt.withIndex((Iterable)localObject1);
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (IndexedValue)((Iterator)localObject2).next();
      ((Collection)localObject1).add(FunctionInvokeDescriptor.Factory.createValueParameter(localFunctionInvokeDescriptor, ((IndexedValue)localObject3).getIndex(), (TypeParameterDescriptor)((IndexedValue)localObject3).getValue()));
    }
    localFunctionInvokeDescriptor.initialize(null, paramFunctionClassDescriptor, localList2, (List)localObject1, (KotlinType)((TypeParameterDescriptor)CollectionsKt.last(localList1)).getDefaultType(), Modality.ABSTRACT, Visibilities.PUBLIC);
    localFunctionInvokeDescriptor.setHasSynthesizedParameterNames(true);
    return localFunctionInvokeDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor.Factory
 * JD-Core Version:    0.7.0.1
 */