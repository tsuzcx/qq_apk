package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.Projection;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedAnnotations;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionForAbsentTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeDeserializer
{
  private final DeserializationContext c;
  private final Function1<Integer, ClassDescriptor> classDescriptors;
  private final String containerPresentableName;
  private final String debugName;
  private boolean experimentalSuspendFunctionTypeEncountered;
  private final TypeDeserializer parent;
  private final Function1<Integer, ClassifierDescriptor> typeAliasDescriptors;
  private final Map<Integer, TypeParameterDescriptor> typeParameterDescriptors;
  
  public TypeDeserializer(@NotNull DeserializationContext paramDeserializationContext, @Nullable TypeDeserializer paramTypeDeserializer, @NotNull List<ProtoBuf.TypeParameter> paramList, @NotNull String paramString1, @NotNull String paramString2, boolean paramBoolean)
  {
    this.c = paramDeserializationContext;
    this.parent = paramTypeDeserializer;
    this.debugName = paramString1;
    this.containerPresentableName = paramString2;
    this.experimentalSuspendFunctionTypeEncountered = paramBoolean;
    this.classDescriptors = ((Function1)this.c.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new TypeDeserializer.classDescriptors.1(this)));
    this.typeAliasDescriptors = ((Function1)this.c.getStorageManager().createMemoizedFunctionWithNullableValues((Function1)new TypeDeserializer.typeAliasDescriptors.1(this)));
    if (paramList.isEmpty())
    {
      paramDeserializationContext = MapsKt.emptyMap();
    }
    else
    {
      paramDeserializationContext = new LinkedHashMap();
      int i = 0;
      paramTypeDeserializer = ((Iterable)paramList).iterator();
      while (paramTypeDeserializer.hasNext())
      {
        paramList = (ProtoBuf.TypeParameter)paramTypeDeserializer.next();
        ((Map)paramDeserializationContext).put(Integer.valueOf(paramList.getId()), new DeserializedTypeParameterDescriptor(this.c, paramList, i));
        i += 1;
      }
      paramDeserializationContext = (Map)paramDeserializationContext;
    }
    this.typeParameterDescriptors = paramDeserializationContext;
  }
  
  private final ClassDescriptor computeClassDescriptor(int paramInt)
  {
    ClassId localClassId = NameResolverUtilKt.getClassId(this.c.getNameResolver(), paramInt);
    if (localClassId.isLocal()) {
      return this.c.getComponents().deserializeClass(localClassId);
    }
    return FindClassInModuleKt.findClassAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), localClassId);
  }
  
  private final SimpleType computeLocalClassifierReplacementType(int paramInt)
  {
    if (NameResolverUtilKt.getClassId(this.c.getNameResolver(), paramInt).isLocal()) {
      return this.c.getComponents().getLocalClassifierTypeSettings().getReplacementTypeForLocalClassifiers();
    }
    return null;
  }
  
  private final ClassifierDescriptor computeTypeAliasDescriptor(int paramInt)
  {
    ClassId localClassId = NameResolverUtilKt.getClassId(this.c.getNameResolver(), paramInt);
    if (localClassId.isLocal()) {
      return null;
    }
    return (ClassifierDescriptor)FindClassInModuleKt.findTypeAliasAcrossModuleDependencies(this.c.getComponents().getModuleDescriptor(), localClassId);
  }
  
  private final SimpleType createSimpleSuspendFunctionType(KotlinType paramKotlinType1, KotlinType paramKotlinType2)
  {
    KotlinBuiltIns localKotlinBuiltIns = TypeUtilsKt.getBuiltIns(paramKotlinType1);
    Annotations localAnnotations = paramKotlinType1.getAnnotations();
    KotlinType localKotlinType = FunctionTypesKt.getReceiverTypeFromFunctionType(paramKotlinType1);
    Object localObject = (Iterable)CollectionsKt.dropLast(FunctionTypesKt.getValueParameterTypesFromFunctionType(paramKotlinType1), 1);
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((TypeProjection)((Iterator)localObject).next()).getType());
    }
    return FunctionTypesKt.createFunctionType(localKotlinBuiltIns, localAnnotations, localKotlinType, (List)localCollection, null, paramKotlinType2, true).makeNullableAsSpecified(paramKotlinType1.isMarkedNullable());
  }
  
  private final SimpleType createSuspendFunctionType(Annotations paramAnnotations, TypeConstructor paramTypeConstructor, List<? extends TypeProjection> paramList, boolean paramBoolean)
  {
    int i = paramTypeConstructor.getParameters().size() - paramList.size();
    Object localObject = null;
    if (i != 0)
    {
      if (i == 1)
      {
        i = paramList.size() - 1;
        if (i >= 0)
        {
          localObject = paramTypeConstructor.getBuiltIns().getSuspendFunction(i);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "functionTypeConstructor.…getSuspendFunction(arity)");
          localObject = ((ClassDescriptor)localObject).getTypeConstructor();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "functionTypeConstructor.…on(arity).typeConstructor");
          localObject = KotlinTypeFactory.simpleType$default(paramAnnotations, (TypeConstructor)localObject, paramList, paramBoolean, null, 16, null);
        }
      }
    }
    else {
      localObject = createSuspendFunctionTypeForBasicCase(paramAnnotations, paramTypeConstructor, paramList, paramBoolean);
    }
    if (localObject != null) {
      return localObject;
    }
    paramAnnotations = new StringBuilder();
    paramAnnotations.append("Bad suspend function in metadata with constructor: ");
    paramAnnotations.append(paramTypeConstructor);
    paramAnnotations = ErrorUtils.createErrorTypeWithArguments(paramAnnotations.toString(), paramList);
    Intrinsics.checkExpressionValueIsNotNull(paramAnnotations, "ErrorUtils.createErrorTy…      arguments\n        )");
    return paramAnnotations;
  }
  
  private final SimpleType createSuspendFunctionTypeForBasicCase(Annotations paramAnnotations, TypeConstructor paramTypeConstructor, List<? extends TypeProjection> paramList, boolean paramBoolean)
  {
    paramAnnotations = (KotlinType)KotlinTypeFactory.simpleType$default(paramAnnotations, paramTypeConstructor, paramList, paramBoolean, null, 16, null);
    if (!FunctionTypesKt.isFunctionType(paramAnnotations)) {
      return null;
    }
    return transformRuntimeFunctionTypeToSuspendFunction(paramAnnotations);
  }
  
  private final SimpleType transformRuntimeFunctionTypeToSuspendFunction(KotlinType paramKotlinType)
  {
    boolean bool3 = this.c.getComponents().getConfiguration().getReleaseCoroutines();
    Object localObject1 = (TypeProjection)CollectionsKt.lastOrNull(FunctionTypesKt.getValueParameterTypesFromFunctionType(paramKotlinType));
    Object localObject3 = null;
    if (localObject1 != null)
    {
      Object localObject2 = ((TypeProjection)localObject1).getType();
      if (localObject2 != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "funType.getValueParamete…ll()?.type ?: return null");
        localObject1 = ((KotlinType)localObject2).getConstructor().getDeclarationDescriptor();
        if (localObject1 != null) {
          localObject1 = DescriptorUtilsKt.getFqNameSafe((DeclarationDescriptor)localObject1);
        } else {
          localObject1 = null;
        }
        int i = ((KotlinType)localObject2).getArguments().size();
        boolean bool2 = true;
        if ((i == 1) && ((SuspendFunctionTypesKt.isContinuation((FqName)localObject1, true)) || (SuspendFunctionTypesKt.isContinuation((FqName)localObject1, false))))
        {
          KotlinType localKotlinType = ((TypeProjection)CollectionsKt.single(((KotlinType)localObject2).getArguments())).getType();
          Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "continuationArgumentType.arguments.single().type");
          Object localObject4 = this.c.getContainingDeclaration();
          localObject2 = localObject4;
          if (!(localObject4 instanceof CallableDescriptor)) {
            localObject2 = null;
          }
          localObject4 = (CallableDescriptor)localObject2;
          localObject2 = localObject3;
          if (localObject4 != null) {
            localObject2 = DescriptorUtilsKt.fqNameOrNull((DeclarationDescriptor)localObject4);
          }
          if (Intrinsics.areEqual(localObject2, SuspendFunctionTypeUtilKt.KOTLIN_SUSPEND_BUILT_IN_FUNCTION_FQ_NAME)) {
            return createSimpleSuspendFunctionType(paramKotlinType, localKotlinType);
          }
          boolean bool1 = bool2;
          if (!this.experimentalSuspendFunctionTypeEncountered) {
            if ((bool3) && (SuspendFunctionTypesKt.isContinuation((FqName)localObject1, bool3 ^ true))) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
          }
          this.experimentalSuspendFunctionTypeEncountered = bool1;
          return createSimpleSuspendFunctionType(paramKotlinType, localKotlinType);
        }
        return (SimpleType)paramKotlinType;
      }
    }
    return null;
  }
  
  private final TypeProjection typeArgument(TypeParameterDescriptor paramTypeParameterDescriptor, ProtoBuf.Type.Argument paramArgument)
  {
    if (paramArgument.getProjection() == ProtoBuf.Type.Argument.Projection.STAR)
    {
      if (paramTypeParameterDescriptor == null) {
        return (TypeProjection)new StarProjectionForAbsentTypeParameter(this.c.getComponents().getModuleDescriptor().getBuiltIns());
      }
      return (TypeProjection)new StarProjectionImpl(paramTypeParameterDescriptor);
    }
    paramTypeParameterDescriptor = ProtoEnumFlags.INSTANCE;
    ProtoBuf.Type.Argument.Projection localProjection = paramArgument.getProjection();
    Intrinsics.checkExpressionValueIsNotNull(localProjection, "typeArgumentProto.projection");
    paramTypeParameterDescriptor = paramTypeParameterDescriptor.variance(localProjection);
    paramArgument = ProtoTypeTableUtilKt.type(paramArgument, this.c.getTypeTable());
    if (paramArgument != null) {
      return (TypeProjection)new TypeProjectionImpl(paramTypeParameterDescriptor, type(paramArgument));
    }
    return (TypeProjection)new TypeProjectionImpl((KotlinType)ErrorUtils.createErrorType("No type recorded"));
  }
  
  private final TypeConstructor typeConstructor(ProtoBuf.Type paramType)
  {
    Object localObject2 = new TypeDeserializer.typeConstructor.1(this, paramType);
    Object localObject1;
    if (paramType.hasClassName())
    {
      localObject1 = (ClassDescriptor)this.classDescriptors.invoke(Integer.valueOf(paramType.getClassName()));
      if (localObject1 != null) {
        paramType = (ProtoBuf.Type)localObject1;
      } else {
        paramType = ((TypeDeserializer.typeConstructor.1)localObject2).invoke(paramType.getClassName());
      }
      paramType = paramType.getTypeConstructor();
      Intrinsics.checkExpressionValueIsNotNull(paramType, "(classDescriptors(proto.…assName)).typeConstructor");
      return paramType;
    }
    if (paramType.hasTypeParameter())
    {
      localObject1 = typeParameterTypeConstructor(paramType.getTypeParameter());
      if (localObject1 != null) {
        return localObject1;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Unknown type parameter ");
      ((StringBuilder)localObject1).append(paramType.getTypeParameter());
      ((StringBuilder)localObject1).append(". Please try recompiling module containing \"");
      ((StringBuilder)localObject1).append(this.containerPresentableName);
      ((StringBuilder)localObject1).append('"');
      paramType = ErrorUtils.createErrorTypeConstructor(((StringBuilder)localObject1).toString());
      Intrinsics.checkExpressionValueIsNotNull(paramType, "ErrorUtils.createErrorTy…\\\"\"\n                    )");
      return paramType;
    }
    if (paramType.hasTypeParameterName())
    {
      localObject1 = this.c.getContainingDeclaration();
      localObject2 = this.c.getNameResolver().getString(paramType.getTypeParameterName());
      Iterator localIterator = ((Iterable)getOwnTypeParameters()).iterator();
      while (localIterator.hasNext())
      {
        paramType = localIterator.next();
        if (Intrinsics.areEqual(((TypeParameterDescriptor)paramType).getName().asString(), localObject2)) {
          break label247;
        }
      }
      paramType = null;
      label247:
      paramType = (TypeParameterDescriptor)paramType;
      if (paramType != null)
      {
        paramType = paramType.getTypeConstructor();
        if (paramType != null) {
          return paramType;
        }
      }
      paramType = new StringBuilder();
      paramType.append("Deserialized type parameter ");
      paramType.append((String)localObject2);
      paramType.append(" in ");
      paramType.append(localObject1);
      paramType = ErrorUtils.createErrorTypeConstructor(paramType.toString());
      Intrinsics.checkExpressionValueIsNotNull(paramType, "ErrorUtils.createErrorTy…ter $name in $container\")");
      return paramType;
    }
    if (paramType.hasTypeAliasName())
    {
      localObject1 = (ClassifierDescriptor)this.typeAliasDescriptors.invoke(Integer.valueOf(paramType.getTypeAliasName()));
      if (localObject1 != null) {
        paramType = (ProtoBuf.Type)localObject1;
      } else {
        paramType = (ClassifierDescriptor)((TypeDeserializer.typeConstructor.1)localObject2).invoke(paramType.getTypeAliasName());
      }
      paramType = paramType.getTypeConstructor();
      Intrinsics.checkExpressionValueIsNotNull(paramType, "(typeAliasDescriptors(pr…iasName)).typeConstructor");
      return paramType;
    }
    paramType = ErrorUtils.createErrorTypeConstructor("Unknown type");
    Intrinsics.checkExpressionValueIsNotNull(paramType, "ErrorUtils.createErrorTy…nstructor(\"Unknown type\")");
    return paramType;
  }
  
  private final TypeConstructor typeParameterTypeConstructor(int paramInt)
  {
    Object localObject = (TypeParameterDescriptor)this.typeParameterDescriptors.get(Integer.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = ((TypeParameterDescriptor)localObject).getTypeConstructor();
      if (localObject != null) {
        return localObject;
      }
    }
    localObject = this.parent;
    if (localObject != null) {
      return ((TypeDeserializer)localObject).typeParameterTypeConstructor(paramInt);
    }
    return null;
  }
  
  public final boolean getExperimentalSuspendFunctionTypeEncountered()
  {
    return this.experimentalSuspendFunctionTypeEncountered;
  }
  
  @NotNull
  public final List<TypeParameterDescriptor> getOwnTypeParameters()
  {
    return CollectionsKt.toList((Iterable)this.typeParameterDescriptors.values());
  }
  
  @NotNull
  public final SimpleType simpleType(@NotNull ProtoBuf.Type paramType)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "proto");
    if (paramType.hasClassName()) {
      localObject1 = computeLocalClassifierReplacementType(paramType.getClassName());
    } else if (paramType.hasTypeAliasName()) {
      localObject1 = computeLocalClassifierReplacementType(paramType.getTypeAliasName());
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject1 = typeConstructor(paramType);
    if (ErrorUtils.isError((DeclarationDescriptor)((TypeConstructor)localObject1).getDeclarationDescriptor()))
    {
      paramType = ErrorUtils.createErrorTypeWithCustomConstructor(localObject1.toString(), (TypeConstructor)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(paramType, "ErrorUtils.createErrorTy….toString(), constructor)");
      return paramType;
    }
    DeserializedAnnotations localDeserializedAnnotations = new DeserializedAnnotations(this.c.getStorageManager(), (Function0)new TypeDeserializer.simpleType.annotations.1(this, paramType));
    Object localObject3 = (Iterable)new TypeDeserializer.simpleType.1(this).invoke(paramType);
    Object localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
    int i = 0;
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject4 = (ProtoBuf.Type.Argument)localObject4;
      List localList = ((TypeConstructor)localObject1).getParameters();
      Intrinsics.checkExpressionValueIsNotNull(localList, "constructor.parameters");
      ((Collection)localObject2).add(typeArgument((TypeParameterDescriptor)CollectionsKt.getOrNull(localList, i), (ProtoBuf.Type.Argument)localObject4));
      i += 1;
    }
    localObject2 = CollectionsKt.toList((Iterable)localObject2);
    localObject3 = Flags.SUSPEND_TYPE.get(paramType.getFlags());
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "Flags.SUSPEND_TYPE.get(proto.flags)");
    if (((Boolean)localObject3).booleanValue()) {
      localObject1 = createSuspendFunctionType((Annotations)localDeserializedAnnotations, (TypeConstructor)localObject1, (List)localObject2, paramType.getNullable());
    } else {
      localObject1 = KotlinTypeFactory.simpleType$default((Annotations)localDeserializedAnnotations, (TypeConstructor)localObject1, (List)localObject2, paramType.getNullable(), null, 16, null);
    }
    paramType = ProtoTypeTableUtilKt.abbreviatedType(paramType, this.c.getTypeTable());
    if (paramType != null) {
      return SpecialTypesKt.withAbbreviation((SimpleType)localObject1, simpleType(paramType));
    }
    return localObject1;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.debugName);
    Object localObject;
    if (this.parent == null)
    {
      localObject = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(". Child of ");
      ((StringBuilder)localObject).append(this.parent.debugName);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  @NotNull
  public final KotlinType type(@NotNull ProtoBuf.Type paramType)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "proto");
    if (paramType.hasFlexibleTypeCapabilitiesId())
    {
      String str = this.c.getNameResolver().getString(paramType.getFlexibleTypeCapabilitiesId());
      SimpleType localSimpleType = simpleType(paramType);
      Object localObject = ProtoTypeTableUtilKt.flexibleUpperBound(paramType, this.c.getTypeTable());
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = simpleType((ProtoBuf.Type)localObject);
      return this.c.getComponents().getFlexibleTypeDeserializer().create(paramType, str, localSimpleType, (SimpleType)localObject);
    }
    return (KotlinType)simpleType(paramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer
 * JD-Core Version:    0.7.0.1
 */