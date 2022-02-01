package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.FqNames;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModalityKt;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedType;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.DynamicType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StubType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.FlexibleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemInferenceExtensionContext.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ClassicTypeSystemContext$DefaultImpls
{
  public static int argumentsCount(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$argumentsCount");
    if ((paramKotlinTypeMarker instanceof KotlinType)) {
      return ((KotlinType)paramKotlinTypeMarker).getArguments().size();
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramKotlinTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramKotlinTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static TypeArgumentListMarker asArgumentList(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$asArgumentList");
    if ((paramSimpleTypeMarker instanceof SimpleType)) {
      return (TypeArgumentListMarker)paramSimpleTypeMarker;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static CapturedTypeMarker asCapturedType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$asCapturedType");
    if ((paramSimpleTypeMarker instanceof SimpleType))
    {
      paramClassicTypeSystemContext = paramSimpleTypeMarker;
      if (!(paramSimpleTypeMarker instanceof NewCapturedType)) {
        paramClassicTypeSystemContext = null;
      }
      return (CapturedTypeMarker)paramClassicTypeSystemContext;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static DefinitelyNotNullTypeMarker asDefinitelyNotNullType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$asDefinitelyNotNullType");
    if ((paramSimpleTypeMarker instanceof SimpleType))
    {
      paramClassicTypeSystemContext = paramSimpleTypeMarker;
      if (!(paramSimpleTypeMarker instanceof DefinitelyNotNullType)) {
        paramClassicTypeSystemContext = null;
      }
      return (DefinitelyNotNullTypeMarker)paramClassicTypeSystemContext;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static DynamicTypeMarker asDynamicType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull FlexibleTypeMarker paramFlexibleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramFlexibleTypeMarker, "$this$asDynamicType");
    if ((paramFlexibleTypeMarker instanceof FlexibleType))
    {
      paramClassicTypeSystemContext = paramFlexibleTypeMarker;
      if (!(paramFlexibleTypeMarker instanceof DynamicType)) {
        paramClassicTypeSystemContext = null;
      }
      return (DynamicTypeMarker)paramClassicTypeSystemContext;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramFlexibleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramFlexibleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static FlexibleTypeMarker asFlexibleType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$asFlexibleType");
    if ((paramKotlinTypeMarker instanceof KotlinType))
    {
      paramKotlinTypeMarker = ((KotlinType)paramKotlinTypeMarker).unwrap();
      paramClassicTypeSystemContext = paramKotlinTypeMarker;
      if (!(paramKotlinTypeMarker instanceof FlexibleType)) {
        paramClassicTypeSystemContext = null;
      }
      return (FlexibleTypeMarker)paramClassicTypeSystemContext;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramKotlinTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramKotlinTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static SimpleTypeMarker asSimpleType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$asSimpleType");
    if ((paramKotlinTypeMarker instanceof KotlinType))
    {
      paramKotlinTypeMarker = ((KotlinType)paramKotlinTypeMarker).unwrap();
      paramClassicTypeSystemContext = paramKotlinTypeMarker;
      if (!(paramKotlinTypeMarker instanceof SimpleType)) {
        paramClassicTypeSystemContext = null;
      }
      return (SimpleTypeMarker)paramClassicTypeSystemContext;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramKotlinTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramKotlinTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static TypeArgumentMarker asTypeArgument(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$asTypeArgument");
    if ((paramKotlinTypeMarker instanceof KotlinType)) {
      return (TypeArgumentMarker)TypeUtilsKt.asTypeProjection((KotlinType)paramKotlinTypeMarker);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramKotlinTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramKotlinTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static SimpleTypeMarker captureFromArguments(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker, @NotNull CaptureStatus paramCaptureStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "type");
    Intrinsics.checkParameterIsNotNull(paramCaptureStatus, "status");
    if ((paramSimpleTypeMarker instanceof SimpleType)) {
      return (SimpleTypeMarker)NewCapturedTypeKt.captureFromArguments((SimpleType)paramSimpleTypeMarker, paramCaptureStatus);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static List<SimpleTypeMarker> fastCorrespondingSupertypes(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$fastCorrespondingSupertypes");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "constructor");
    return TypeSystemInferenceExtensionContext.DefaultImpls.fastCorrespondingSupertypes((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramSimpleTypeMarker, paramTypeConstructorMarker);
  }
  
  @NotNull
  public static TypeArgumentMarker get(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeArgumentListMarker paramTypeArgumentListMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentListMarker, "$this$get");
    return TypeSystemInferenceExtensionContext.DefaultImpls.get((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramTypeArgumentListMarker, paramInt);
  }
  
  @NotNull
  public static TypeArgumentMarker getArgument(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$getArgument");
    if ((paramKotlinTypeMarker instanceof KotlinType)) {
      return (TypeArgumentMarker)((KotlinType)paramKotlinTypeMarker).getArguments().get(paramInt);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramKotlinTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramKotlinTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static TypeArgumentMarker getArgumentOrNull(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$getArgumentOrNull");
    return TypeSystemInferenceExtensionContext.DefaultImpls.getArgumentOrNull((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramSimpleTypeMarker, paramInt);
  }
  
  @NotNull
  public static FqNameUnsafe getClassFqNameUnsafe(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$getClassFqNameUnsafe");
    if ((paramTypeConstructorMarker instanceof TypeConstructor))
    {
      paramClassicTypeSystemContext = ((TypeConstructor)paramTypeConstructorMarker).getDeclarationDescriptor();
      if (paramClassicTypeSystemContext != null) {
        return DescriptorUtilsKt.getFqNameUnsafe((DeclarationDescriptor)paramClassicTypeSystemContext);
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static TypeParameterMarker getParameter(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$getParameter");
    if ((paramTypeConstructorMarker instanceof TypeConstructor))
    {
      paramClassicTypeSystemContext = ((TypeConstructor)paramTypeConstructorMarker).getParameters().get(paramInt);
      Intrinsics.checkExpressionValueIsNotNull(paramClassicTypeSystemContext, "this.parameters[index]");
      return (TypeParameterMarker)paramClassicTypeSystemContext;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static PrimitiveType getPrimitiveArrayType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$getPrimitiveArrayType");
    if ((paramTypeConstructorMarker instanceof TypeConstructor))
    {
      paramClassicTypeSystemContext = ((TypeConstructor)paramTypeConstructorMarker).getDeclarationDescriptor();
      if (paramClassicTypeSystemContext != null) {
        return KotlinBuiltIns.getPrimitiveArrayType((DeclarationDescriptor)paramClassicTypeSystemContext);
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static PrimitiveType getPrimitiveType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$getPrimitiveType");
    if ((paramTypeConstructorMarker instanceof TypeConstructor))
    {
      paramClassicTypeSystemContext = ((TypeConstructor)paramTypeConstructorMarker).getDeclarationDescriptor();
      if (paramClassicTypeSystemContext != null) {
        return KotlinBuiltIns.getPrimitiveType((DeclarationDescriptor)paramClassicTypeSystemContext);
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static KotlinTypeMarker getRepresentativeUpperBound(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeParameterMarker paramTypeParameterMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeParameterMarker, "$this$getRepresentativeUpperBound");
    if ((paramTypeParameterMarker instanceof TypeParameterDescriptor)) {
      return (KotlinTypeMarker)TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor)paramTypeParameterMarker);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeParameterMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeParameterMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static KotlinTypeMarker getSubstitutedUnderlyingType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$getSubstitutedUnderlyingType");
    if ((paramKotlinTypeMarker instanceof KotlinType)) {
      return (KotlinTypeMarker)InlineClassesUtilsKt.substitutedUnderlyingType((KotlinType)paramKotlinTypeMarker);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramKotlinTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramKotlinTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static KotlinTypeMarker getType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeArgumentMarker paramTypeArgumentMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentMarker, "$this$getType");
    if ((paramTypeArgumentMarker instanceof TypeProjection)) {
      return (KotlinTypeMarker)((TypeProjection)paramTypeArgumentMarker).getType().unwrap();
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeArgumentMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeArgumentMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @Nullable
  public static TypeParameterMarker getTypeParameterClassifier(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$getTypeParameterClassifier");
    if ((paramTypeConstructorMarker instanceof TypeConstructor))
    {
      paramTypeConstructorMarker = ((TypeConstructor)paramTypeConstructorMarker).getDeclarationDescriptor();
      paramClassicTypeSystemContext = paramTypeConstructorMarker;
      if (!(paramTypeConstructorMarker instanceof TypeParameterDescriptor)) {
        paramClassicTypeSystemContext = null;
      }
      return (TypeParameterMarker)paramClassicTypeSystemContext;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static TypeVariance getVariance(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeArgumentMarker paramTypeArgumentMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentMarker, "$this$getVariance");
    if ((paramTypeArgumentMarker instanceof TypeProjection))
    {
      paramClassicTypeSystemContext = ((TypeProjection)paramTypeArgumentMarker).getProjectionKind();
      Intrinsics.checkExpressionValueIsNotNull(paramClassicTypeSystemContext, "this.projectionKind");
      return ClassicTypeSystemContextKt.convertVariance(paramClassicTypeSystemContext);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeArgumentMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeArgumentMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static TypeVariance getVariance(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeParameterMarker paramTypeParameterMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeParameterMarker, "$this$getVariance");
    if ((paramTypeParameterMarker instanceof TypeParameterDescriptor))
    {
      paramClassicTypeSystemContext = ((TypeParameterDescriptor)paramTypeParameterMarker).getVariance();
      Intrinsics.checkExpressionValueIsNotNull(paramClassicTypeSystemContext, "this.variance");
      return ClassicTypeSystemContextKt.convertVariance(paramClassicTypeSystemContext);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeParameterMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeParameterMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean hasAnnotation(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker, @NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$hasAnnotation");
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    if ((paramKotlinTypeMarker instanceof KotlinType)) {
      return ((KotlinType)paramKotlinTypeMarker).getAnnotations().hasAnnotation(paramFqName);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramKotlinTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramKotlinTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean hasFlexibleNullability(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$hasFlexibleNullability");
    return TypeSystemInferenceExtensionContext.DefaultImpls.hasFlexibleNullability((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramKotlinTypeMarker);
  }
  
  public static boolean identicalArguments(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker1, @NotNull SimpleTypeMarker paramSimpleTypeMarker2)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker1, "a");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker2, "b");
    if ((paramSimpleTypeMarker1 instanceof SimpleType))
    {
      if ((paramSimpleTypeMarker2 instanceof SimpleType)) {
        return ((SimpleType)paramSimpleTypeMarker1).getArguments() == ((SimpleType)paramSimpleTypeMarker2).getArguments();
      }
      paramClassicTypeSystemContext = new StringBuilder();
      paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
      paramClassicTypeSystemContext.append(paramSimpleTypeMarker2);
      paramClassicTypeSystemContext.append(", ");
      paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker2.getClass()));
      throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker1);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker1.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static KotlinTypeMarker intersectTypes(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull List<? extends KotlinTypeMarker> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "types");
    return (KotlinTypeMarker)IntersectionTypeKt.intersectTypes(paramList);
  }
  
  public static boolean isAnyConstructor(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isAnyConstructor");
    if ((paramTypeConstructorMarker instanceof TypeConstructor)) {
      return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor)paramTypeConstructorMarker, KotlinBuiltIns.FQ_NAMES.any);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isClassType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isClassType");
    return TypeSystemInferenceExtensionContext.DefaultImpls.isClassType((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramSimpleTypeMarker);
  }
  
  public static boolean isClassTypeConstructor(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isClassTypeConstructor");
    if ((paramTypeConstructorMarker instanceof TypeConstructor)) {
      return ((TypeConstructor)paramTypeConstructorMarker).getDeclarationDescriptor() instanceof ClassDescriptor;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isCommonFinalClassConstructor(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isCommonFinalClassConstructor");
    if ((paramTypeConstructorMarker instanceof TypeConstructor))
    {
      paramTypeConstructorMarker = ((TypeConstructor)paramTypeConstructorMarker).getDeclarationDescriptor();
      paramClassicTypeSystemContext = paramTypeConstructorMarker;
      if (!(paramTypeConstructorMarker instanceof ClassDescriptor)) {
        paramClassicTypeSystemContext = null;
      }
      paramClassicTypeSystemContext = (ClassDescriptor)paramClassicTypeSystemContext;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramClassicTypeSystemContext != null)
      {
        bool1 = bool2;
        if (ModalityKt.isFinalClass(paramClassicTypeSystemContext))
        {
          bool1 = bool2;
          if (paramClassicTypeSystemContext.getKind() != ClassKind.ENUM_ENTRY)
          {
            bool1 = bool2;
            if (paramClassicTypeSystemContext.getKind() != ClassKind.ANNOTATION_CLASS) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isDefinitelyNotNullType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isDefinitelyNotNullType");
    return TypeSystemInferenceExtensionContext.DefaultImpls.isDefinitelyNotNullType((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramKotlinTypeMarker);
  }
  
  public static boolean isDenotable(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isDenotable");
    if ((paramTypeConstructorMarker instanceof TypeConstructor)) {
      return ((TypeConstructor)paramTypeConstructorMarker).isDenotable();
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isDynamic(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isDynamic");
    return TypeSystemInferenceExtensionContext.DefaultImpls.isDynamic((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramKotlinTypeMarker);
  }
  
  public static boolean isEqualTypeConstructors(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker1, @NotNull TypeConstructorMarker paramTypeConstructorMarker2)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker1, "c1");
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker2, "c2");
    if ((paramTypeConstructorMarker1 instanceof TypeConstructor))
    {
      if ((paramTypeConstructorMarker2 instanceof TypeConstructor)) {
        return Intrinsics.areEqual(paramTypeConstructorMarker1, paramTypeConstructorMarker2);
      }
      paramClassicTypeSystemContext = new StringBuilder();
      paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
      paramClassicTypeSystemContext.append(paramTypeConstructorMarker2);
      paramClassicTypeSystemContext.append(", ");
      paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker2.getClass()));
      throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker1);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker1.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isError(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isError");
    if ((paramKotlinTypeMarker instanceof KotlinType)) {
      return KotlinTypeKt.isError((KotlinType)paramKotlinTypeMarker);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramKotlinTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramKotlinTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isInlineClass(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isInlineClass");
    if ((paramTypeConstructorMarker instanceof TypeConstructor))
    {
      paramTypeConstructorMarker = ((TypeConstructor)paramTypeConstructorMarker).getDeclarationDescriptor();
      paramClassicTypeSystemContext = paramTypeConstructorMarker;
      if (!(paramTypeConstructorMarker instanceof ClassDescriptor)) {
        paramClassicTypeSystemContext = null;
      }
      paramClassicTypeSystemContext = (ClassDescriptor)paramClassicTypeSystemContext;
      return (paramClassicTypeSystemContext != null) && (paramClassicTypeSystemContext.isInline() == true);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isIntegerLiteralType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isIntegerLiteralType");
    return TypeSystemInferenceExtensionContext.DefaultImpls.isIntegerLiteralType((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramSimpleTypeMarker);
  }
  
  public static boolean isIntegerLiteralTypeConstructor(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isIntegerLiteralTypeConstructor");
    if ((paramTypeConstructorMarker instanceof TypeConstructor)) {
      return paramTypeConstructorMarker instanceof IntegerLiteralTypeConstructor;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isIntersection(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isIntersection");
    if ((paramTypeConstructorMarker instanceof TypeConstructor)) {
      return paramTypeConstructorMarker instanceof IntersectionTypeConstructor;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isMarkedNullable(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isMarkedNullable");
    return TypeSystemCommonBackendContext.DefaultImpls.isMarkedNullable((TypeSystemCommonBackendContext)paramClassicTypeSystemContext, paramKotlinTypeMarker);
  }
  
  public static boolean isMarkedNullable(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isMarkedNullable");
    if ((paramSimpleTypeMarker instanceof SimpleType)) {
      return ((SimpleType)paramSimpleTypeMarker).isMarkedNullable();
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isNothing(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isNothing");
    return TypeSystemInferenceExtensionContext.DefaultImpls.isNothing((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramKotlinTypeMarker);
  }
  
  public static boolean isNothingConstructor(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isNothingConstructor");
    if ((paramTypeConstructorMarker instanceof TypeConstructor)) {
      return KotlinBuiltIns.isTypeConstructorForGivenClass((TypeConstructor)paramTypeConstructorMarker, KotlinBuiltIns.FQ_NAMES.nothing);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isNullableType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$isNullableType");
    if ((paramKotlinTypeMarker instanceof KotlinType)) {
      return TypeUtils.isNullableType((KotlinType)paramKotlinTypeMarker);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramKotlinTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramKotlinTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isPrimitiveType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isPrimitiveType");
    if ((paramSimpleTypeMarker instanceof KotlinType)) {
      return KotlinBuiltIns.isPrimitiveType((KotlinType)paramSimpleTypeMarker);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isSingleClassifierType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isSingleClassifierType");
    if ((paramSimpleTypeMarker instanceof SimpleType))
    {
      if (!KotlinTypeKt.isError((KotlinType)paramSimpleTypeMarker))
      {
        paramClassicTypeSystemContext = (SimpleType)paramSimpleTypeMarker;
        if ((!(paramClassicTypeSystemContext.getConstructor().getDeclarationDescriptor() instanceof TypeAliasDescriptor)) && ((paramClassicTypeSystemContext.getConstructor().getDeclarationDescriptor() != null) || ((paramSimpleTypeMarker instanceof CapturedType)) || ((paramSimpleTypeMarker instanceof NewCapturedType)) || ((paramSimpleTypeMarker instanceof DefinitelyNotNullType)) || ((paramClassicTypeSystemContext.getConstructor() instanceof IntegerLiteralTypeConstructor)))) {
          return true;
        }
      }
      return false;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isStarProjection(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeArgumentMarker paramTypeArgumentMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentMarker, "$this$isStarProjection");
    if ((paramTypeArgumentMarker instanceof TypeProjection)) {
      return ((TypeProjection)paramTypeArgumentMarker).isStarProjection();
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeArgumentMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeArgumentMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isStubType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$isStubType");
    if ((paramSimpleTypeMarker instanceof SimpleType)) {
      return paramSimpleTypeMarker instanceof StubType;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static boolean isUnderKotlinPackage(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$isUnderKotlinPackage");
    if ((paramTypeConstructorMarker instanceof TypeConstructor))
    {
      paramClassicTypeSystemContext = ((TypeConstructor)paramTypeConstructorMarker).getDeclarationDescriptor();
      return (paramClassicTypeSystemContext != null) && (KotlinBuiltIns.isUnderKotlinPackage((DeclarationDescriptor)paramClassicTypeSystemContext) == true);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static SimpleTypeMarker lowerBound(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull FlexibleTypeMarker paramFlexibleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramFlexibleTypeMarker, "$this$lowerBound");
    if ((paramFlexibleTypeMarker instanceof FlexibleType)) {
      return (SimpleTypeMarker)((FlexibleType)paramFlexibleTypeMarker).getLowerBound();
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramFlexibleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramFlexibleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static SimpleTypeMarker lowerBoundIfFlexible(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$lowerBoundIfFlexible");
    return TypeSystemInferenceExtensionContext.DefaultImpls.lowerBoundIfFlexible((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramKotlinTypeMarker);
  }
  
  @Nullable
  public static KotlinTypeMarker lowerType(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull CapturedTypeMarker paramCapturedTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramCapturedTypeMarker, "$this$lowerType");
    if ((paramCapturedTypeMarker instanceof NewCapturedType)) {
      return (KotlinTypeMarker)((NewCapturedType)paramCapturedTypeMarker).getLowerType();
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramCapturedTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramCapturedTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static KotlinTypeMarker makeNullable(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$makeNullable");
    return TypeSystemCommonBackendContext.DefaultImpls.makeNullable((TypeSystemCommonBackendContext)paramClassicTypeSystemContext, paramKotlinTypeMarker);
  }
  
  @NotNull
  public static AbstractTypeCheckerContext newBaseTypeCheckerContext(ClassicTypeSystemContext paramClassicTypeSystemContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    return (AbstractTypeCheckerContext)new ClassicTypeCheckerContext(paramBoolean1, paramBoolean2, false, null, 12, null);
  }
  
  public static int parametersCount(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$parametersCount");
    if ((paramTypeConstructorMarker instanceof TypeConstructor)) {
      return ((TypeConstructor)paramTypeConstructorMarker).getParameters().size();
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static Collection<KotlinTypeMarker> possibleIntegerTypes(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$possibleIntegerTypes");
    paramClassicTypeSystemContext = paramClassicTypeSystemContext.typeConstructor(paramSimpleTypeMarker);
    if ((paramClassicTypeSystemContext instanceof IntegerLiteralTypeConstructor)) {
      return (Collection)((IntegerLiteralTypeConstructor)paramClassicTypeSystemContext).getPossibleTypes();
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  public static int size(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeArgumentListMarker paramTypeArgumentListMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeArgumentListMarker, "$this$size");
    return TypeSystemInferenceExtensionContext.DefaultImpls.size((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramTypeArgumentListMarker);
  }
  
  @NotNull
  public static Collection<KotlinTypeMarker> supertypes(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull TypeConstructorMarker paramTypeConstructorMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructorMarker, "$this$supertypes");
    if ((paramTypeConstructorMarker instanceof TypeConstructor))
    {
      paramClassicTypeSystemContext = ((TypeConstructor)paramTypeConstructorMarker).getSupertypes();
      Intrinsics.checkExpressionValueIsNotNull(paramClassicTypeSystemContext, "this.supertypes");
      return paramClassicTypeSystemContext;
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramTypeConstructorMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramTypeConstructorMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$typeConstructor");
    return TypeSystemInferenceExtensionContext.DefaultImpls.typeConstructor((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramKotlinTypeMarker);
  }
  
  @NotNull
  public static TypeConstructorMarker typeConstructor(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$typeConstructor");
    if ((paramSimpleTypeMarker instanceof SimpleType)) {
      return (TypeConstructorMarker)((SimpleType)paramSimpleTypeMarker).getConstructor();
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static SimpleTypeMarker upperBound(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull FlexibleTypeMarker paramFlexibleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramFlexibleTypeMarker, "$this$upperBound");
    if ((paramFlexibleTypeMarker instanceof FlexibleType)) {
      return (SimpleTypeMarker)((FlexibleType)paramFlexibleTypeMarker).getUpperBound();
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramFlexibleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramFlexibleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
  
  @NotNull
  public static SimpleTypeMarker upperBoundIfFlexible(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "$this$upperBoundIfFlexible");
    return TypeSystemInferenceExtensionContext.DefaultImpls.upperBoundIfFlexible((TypeSystemInferenceExtensionContext)paramClassicTypeSystemContext, paramKotlinTypeMarker);
  }
  
  @NotNull
  public static SimpleTypeMarker withNullability(ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "$this$withNullability");
    if ((paramSimpleTypeMarker instanceof SimpleType)) {
      return (SimpleTypeMarker)((SimpleType)paramSimpleTypeMarker).makeNullableAsSpecified(paramBoolean);
    }
    paramClassicTypeSystemContext = new StringBuilder();
    paramClassicTypeSystemContext.append("ClassicTypeSystemContext couldn't handle: ");
    paramClassicTypeSystemContext.append(paramSimpleTypeMarker);
    paramClassicTypeSystemContext.append(", ");
    paramClassicTypeSystemContext.append(Reflection.getOrCreateKotlinClass(paramSimpleTypeMarker.getClass()));
    throw ((Throwable)new IllegalArgumentException(paramClassicTypeSystemContext.toString().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeSystemContext.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */