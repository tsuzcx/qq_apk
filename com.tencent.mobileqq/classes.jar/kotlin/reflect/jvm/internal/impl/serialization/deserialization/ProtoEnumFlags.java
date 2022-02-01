package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.MemberKind;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.Variance;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Visibility;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProtoEnumFlags
{
  public static final ProtoEnumFlags INSTANCE = new ProtoEnumFlags();
  
  @NotNull
  public final ClassKind classKind(@Nullable ProtoBuf.Class.Kind paramKind)
  {
    if (paramKind != null) {
      switch (ProtoEnumFlags.WhenMappings.$EnumSwitchMapping$5[paramKind.ordinal()])
      {
      default: 
        break;
      case 6: 
      case 7: 
        return ClassKind.OBJECT;
      case 5: 
        return ClassKind.ANNOTATION_CLASS;
      case 4: 
        return ClassKind.ENUM_ENTRY;
      case 3: 
        return ClassKind.ENUM_CLASS;
      case 2: 
        return ClassKind.INTERFACE;
      case 1: 
        return ClassKind.CLASS;
      }
    }
    return ClassKind.CLASS;
  }
  
  @NotNull
  public final CallableMemberDescriptor.Kind memberKind(@Nullable ProtoBuf.MemberKind paramMemberKind)
  {
    if (paramMemberKind != null)
    {
      int i = ProtoEnumFlags.WhenMappings.$EnumSwitchMapping$0[paramMemberKind.ordinal()];
      if (i == 1) {
        break label52;
      }
      if (i == 2) {
        break label48;
      }
      if (i == 3) {
        break label44;
      }
      if (i == 4) {}
    }
    else
    {
      return CallableMemberDescriptor.Kind.DECLARATION;
    }
    return CallableMemberDescriptor.Kind.SYNTHESIZED;
    label44:
    return CallableMemberDescriptor.Kind.DELEGATION;
    label48:
    return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
    label52:
    return CallableMemberDescriptor.Kind.DECLARATION;
  }
  
  @NotNull
  public final Modality modality(@Nullable ProtoBuf.Modality paramModality)
  {
    if (paramModality != null)
    {
      int i = ProtoEnumFlags.WhenMappings.$EnumSwitchMapping$2[paramModality.ordinal()];
      if (i == 1) {
        break label52;
      }
      if (i == 2) {
        break label48;
      }
      if (i == 3) {
        break label44;
      }
      if (i == 4) {}
    }
    else
    {
      return Modality.FINAL;
    }
    return Modality.SEALED;
    label44:
    return Modality.ABSTRACT;
    label48:
    return Modality.OPEN;
    label52:
    return Modality.FINAL;
  }
  
  @NotNull
  public final Variance variance(@NotNull ProtoBuf.Type.Argument.Projection paramProjection)
  {
    Intrinsics.checkParameterIsNotNull(paramProjection, "projection");
    int i = ProtoEnumFlags.WhenMappings.$EnumSwitchMapping$8[paramProjection.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            throw new NoWhenBranchMatchedException();
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Only IN, OUT and INV are supported. Actual argument: ");
          localStringBuilder.append(paramProjection);
          throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
        }
        return Variance.INVARIANT;
      }
      return Variance.OUT_VARIANCE;
    }
    return Variance.IN_VARIANCE;
  }
  
  @NotNull
  public final Variance variance(@NotNull ProtoBuf.TypeParameter.Variance paramVariance)
  {
    Intrinsics.checkParameterIsNotNull(paramVariance, "variance");
    int i = ProtoEnumFlags.WhenMappings.$EnumSwitchMapping$7[paramVariance.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return Variance.INVARIANT;
        }
        throw new NoWhenBranchMatchedException();
      }
      return Variance.OUT_VARIANCE;
    }
    return Variance.IN_VARIANCE;
  }
  
  @NotNull
  public final Visibility visibility(@Nullable ProtoBuf.Visibility paramVisibility)
  {
    if (paramVisibility != null) {
      switch (ProtoEnumFlags.WhenMappings.$EnumSwitchMapping$4[paramVisibility.ordinal()])
      {
      default: 
        break;
      case 6: 
        paramVisibility = Visibilities.LOCAL;
        break;
      case 5: 
        paramVisibility = Visibilities.PUBLIC;
        break;
      case 4: 
        paramVisibility = Visibilities.PROTECTED;
        break;
      case 3: 
        paramVisibility = Visibilities.PRIVATE_TO_THIS;
        break;
      case 2: 
        paramVisibility = Visibilities.PRIVATE;
        break;
      case 1: 
        paramVisibility = Visibilities.INTERNAL;
        break;
      }
    }
    paramVisibility = Visibilities.PRIVATE;
    Intrinsics.checkExpressionValueIsNotNull(paramVisibility, "when (visibility) {\n    …isibilities.PRIVATE\n    }");
    return paramVisibility;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoEnumFlags
 * JD-Core Version:    0.7.0.1
 */