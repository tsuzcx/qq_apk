package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FunctionInvokeDescriptor
  extends SimpleFunctionDescriptorImpl
{
  public static final FunctionInvokeDescriptor.Factory Factory = new FunctionInvokeDescriptor.Factory(null);
  
  private FunctionInvokeDescriptor(DeclarationDescriptor paramDeclarationDescriptor, FunctionInvokeDescriptor paramFunctionInvokeDescriptor, CallableMemberDescriptor.Kind paramKind, boolean paramBoolean)
  {
    super(paramDeclarationDescriptor, (SimpleFunctionDescriptor)paramFunctionInvokeDescriptor, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, paramKind, SourceElement.NO_SOURCE);
    setOperator(true);
    setSuspend(paramBoolean);
    setHasStableParameterNames(false);
  }
  
  private final FunctionDescriptor replaceParameterNames(List<Name> paramList)
  {
    int j = getValueParameters().size() - paramList.size();
    boolean bool2 = false;
    int i;
    if ((j != 0) && (j != 1)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((_Assertions.ENABLED) && (i == 0)) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    Object localObject1 = getValueParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "valueParameters");
    localObject1 = (Iterable)localObject1;
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      ValueParameterDescriptor localValueParameterDescriptor = (ValueParameterDescriptor)localIterator.next();
      Intrinsics.checkExpressionValueIsNotNull(localValueParameterDescriptor, "it");
      localObject2 = localValueParameterDescriptor.getName();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.name");
      i = localValueParameterDescriptor.getIndex();
      int k = i - j;
      localObject1 = localObject2;
      if (k >= 0)
      {
        Name localName = (Name)paramList.get(k);
        localObject1 = localObject2;
        if (localName != null) {
          localObject1 = localName;
        }
      }
      localCollection.add(localValueParameterDescriptor.copy((CallableDescriptor)this, (Name)localObject1, i));
    }
    localObject1 = (List)localCollection;
    Object localObject2 = newCopyBuilder(TypeSubstitutor.EMPTY);
    paramList = (Iterable)paramList;
    boolean bool1;
    if (((paramList instanceof Collection)) && (((Collection)paramList).isEmpty()))
    {
      bool1 = bool2;
    }
    else
    {
      paramList = paramList.iterator();
      do
      {
        bool1 = bool2;
        if (!paramList.hasNext()) {
          break;
        }
        if ((Name)paramList.next() == null) {
          i = 1;
        } else {
          i = 0;
        }
      } while (i == 0);
      bool1 = true;
    }
    paramList = ((FunctionDescriptorImpl.CopyConfiguration)localObject2).setHasSynthesizedParameterNames(bool1).setValueParameters((List)localObject1).setOriginal((CallableMemberDescriptor)getOriginal());
    Intrinsics.checkExpressionValueIsNotNull(paramList, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
    paramList = super.doSubstitute(paramList);
    if (paramList == null) {
      Intrinsics.throwNpe();
    }
    return paramList;
  }
  
  @NotNull
  protected FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable FunctionDescriptor paramFunctionDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable Name paramName, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "newOwner");
    Intrinsics.checkParameterIsNotNull(paramKind, "kind");
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    Intrinsics.checkParameterIsNotNull(paramSourceElement, "source");
    return (FunctionDescriptorImpl)new FunctionInvokeDescriptor(paramDeclarationDescriptor, (FunctionInvokeDescriptor)paramFunctionDescriptor, paramKind, isSuspend());
  }
  
  @Nullable
  protected FunctionDescriptor doSubstitute(@NotNull FunctionDescriptorImpl.CopyConfiguration paramCopyConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramCopyConfiguration, "configuration");
    paramCopyConfiguration = (FunctionInvokeDescriptor)super.doSubstitute(paramCopyConfiguration);
    if (paramCopyConfiguration != null)
    {
      Object localObject1 = paramCopyConfiguration.getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "substituted.valueParameters");
      localObject1 = (Iterable)localObject1;
      boolean bool = localObject1 instanceof Collection;
      int j = 1;
      int i;
      if ((bool) && (((Collection)localObject1).isEmpty()))
      {
        i = j;
      }
      else
      {
        localObject1 = ((Iterable)localObject1).iterator();
        do
        {
          i = j;
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (ValueParameterDescriptor)((Iterator)localObject1).next();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
          localObject2 = ((ValueParameterDescriptor)localObject2).getType();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.type");
          if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument((KotlinType)localObject2) != null) {
            i = 1;
          } else {
            i = 0;
          }
        } while (i == 0);
        i = 0;
      }
      if (i != 0) {
        return (FunctionDescriptor)paramCopyConfiguration;
      }
      localObject1 = paramCopyConfiguration.getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "substituted.valueParameters");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ValueParameterDescriptor)((Iterator)localObject2).next();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "it");
        localObject3 = ((ValueParameterDescriptor)localObject3).getType();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.type");
        ((Collection)localObject1).add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument((KotlinType)localObject3));
      }
      return paramCopyConfiguration.replaceParameterNames((List)localObject1);
    }
    return null;
  }
  
  public boolean isExternal()
  {
    return false;
  }
  
  public boolean isInline()
  {
    return false;
  }
  
  public boolean isTailrec()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor
 * JD-Core Version:    0.7.0.1
 */