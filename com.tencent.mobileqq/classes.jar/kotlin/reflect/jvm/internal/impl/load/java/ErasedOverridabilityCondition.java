package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawSubstitution;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Contract;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ErasedOverridabilityCondition
  implements ExternalOverridabilityCondition
{
  @NotNull
  public ExternalOverridabilityCondition.Contract getContract()
  {
    return ExternalOverridabilityCondition.Contract.SUCCESS_ONLY;
  }
  
  @NotNull
  public ExternalOverridabilityCondition.Result isOverridable(@NotNull CallableDescriptor paramCallableDescriptor1, @NotNull CallableDescriptor paramCallableDescriptor2, @Nullable ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor1, "superDescriptor");
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor2, "subDescriptor");
    if ((paramCallableDescriptor2 instanceof JavaMethodDescriptor))
    {
      Object localObject2 = (JavaMethodDescriptor)paramCallableDescriptor2;
      paramClassDescriptor = ((JavaMethodDescriptor)localObject2).getTypeParameters();
      Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "subDescriptor.typeParameters");
      if (!(((Collection)paramClassDescriptor).isEmpty() ^ true))
      {
        paramClassDescriptor = OverridingUtil.getBasicOverridabilityProblem(paramCallableDescriptor1, paramCallableDescriptor2);
        Object localObject1 = null;
        if (paramClassDescriptor != null) {
          paramClassDescriptor = paramClassDescriptor.getResult();
        } else {
          paramClassDescriptor = null;
        }
        if (paramClassDescriptor != null) {
          return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        paramClassDescriptor = ((JavaMethodDescriptor)localObject2).getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "subDescriptor.valueParameters");
        paramClassDescriptor = SequencesKt.map(CollectionsKt.asSequence((Iterable)paramClassDescriptor), (Function1)ErasedOverridabilityCondition.isOverridable.signatureTypes.1.INSTANCE);
        Object localObject3 = ((JavaMethodDescriptor)localObject2).getReturnType();
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        localObject3 = SequencesKt.plus(paramClassDescriptor, localObject3);
        localObject2 = ((JavaMethodDescriptor)localObject2).getExtensionReceiverParameter();
        paramClassDescriptor = (ClassDescriptor)localObject1;
        if (localObject2 != null) {
          paramClassDescriptor = ((ReceiverParameterDescriptor)localObject2).getType();
        }
        paramClassDescriptor = SequencesKt.plus((Sequence)localObject3, (Iterable)CollectionsKt.listOfNotNull(paramClassDescriptor)).iterator();
        while (paramClassDescriptor.hasNext())
        {
          localObject1 = (KotlinType)paramClassDescriptor.next();
          if (((((Collection)((KotlinType)localObject1).getArguments()).isEmpty() ^ true)) && (!(((KotlinType)localObject1).unwrap() instanceof RawTypeImpl))) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            i = 1;
            break label250;
          }
        }
        int i = 0;
        label250:
        if (i != 0) {
          return ExternalOverridabilityCondition.Result.UNKNOWN;
        }
        paramClassDescriptor = (CallableDescriptor)paramCallableDescriptor1.substitute(RawSubstitution.INSTANCE.buildSubstitutor());
        if (paramClassDescriptor != null)
        {
          paramCallableDescriptor1 = paramClassDescriptor;
          if ((paramClassDescriptor instanceof SimpleFunctionDescriptor))
          {
            localObject1 = (SimpleFunctionDescriptor)paramClassDescriptor;
            localObject2 = ((SimpleFunctionDescriptor)localObject1).getTypeParameters();
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "erasedSuper.typeParameters");
            paramCallableDescriptor1 = paramClassDescriptor;
            if ((((Collection)localObject2).isEmpty() ^ true))
            {
              paramCallableDescriptor1 = ((SimpleFunctionDescriptor)localObject1).newCopyBuilder().setTypeParameters(CollectionsKt.emptyList()).build();
              if (paramCallableDescriptor1 == null) {
                Intrinsics.throwNpe();
              }
              paramCallableDescriptor1 = (CallableDescriptor)paramCallableDescriptor1;
            }
          }
          paramCallableDescriptor1 = OverridingUtil.DEFAULT.isOverridableByWithoutExternalConditions(paramCallableDescriptor1, paramCallableDescriptor2, false);
          Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor1, "OverridingUtil.DEFAULT.i…er, subDescriptor, false)");
          paramCallableDescriptor1 = paramCallableDescriptor1.getResult();
          Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor1, "OverridingUtil.DEFAULT.i…Descriptor, false).result");
          if (ErasedOverridabilityCondition.WhenMappings.$EnumSwitchMapping$0[paramCallableDescriptor1.ordinal()] != 1) {
            return ExternalOverridabilityCondition.Result.UNKNOWN;
          }
          return ExternalOverridabilityCondition.Result.OVERRIDABLE;
        }
        return ExternalOverridabilityCondition.Result.UNKNOWN;
      }
    }
    return ExternalOverridabilityCondition.Result.UNKNOWN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.ErasedOverridabilityCondition
 * JD-Core Version:    0.7.0.1
 */