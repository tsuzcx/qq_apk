package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.SuspendFunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap.PlatformMutabilityMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeEnhancementKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSystemCommonBackendContext;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeSignatureMappingKt
{
  private static final <T> T boxTypeIfNeeded(@NotNull JvmTypeFactory<T> paramJvmTypeFactory, T paramT, boolean paramBoolean)
  {
    Object localObject = paramT;
    if (paramBoolean) {
      localObject = paramJvmTypeFactory.boxType(paramT);
    }
    return localObject;
  }
  
  @NotNull
  public static final String computeInternalName(@NotNull ClassDescriptor paramClassDescriptor, @NotNull TypeMappingConfiguration<?> paramTypeMappingConfiguration)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "klass");
    Intrinsics.checkParameterIsNotNull(paramTypeMappingConfiguration, "typeMappingConfiguration");
    Object localObject = paramTypeMappingConfiguration.getPredefinedFullInternalNameForClass(paramClassDescriptor);
    if (localObject != null) {
      return localObject;
    }
    DeclarationDescriptor localDeclarationDescriptor = paramClassDescriptor.getContainingDeclaration();
    Intrinsics.checkExpressionValueIsNotNull(localDeclarationDescriptor, "klass.containingDeclaration");
    localObject = SpecialNames.safeIdentifier(paramClassDescriptor.getName());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "SpecialNames.safeIdentifier(klass.name)");
    String str = ((Name)localObject).getIdentifier();
    Intrinsics.checkExpressionValueIsNotNull(str, "SpecialNames.safeIdentifier(klass.name).identifier");
    if ((localDeclarationDescriptor instanceof PackageFragmentDescriptor))
    {
      paramTypeMappingConfiguration = ((PackageFragmentDescriptor)localDeclarationDescriptor).getFqName();
      if (paramTypeMappingConfiguration.isRoot()) {
        return str;
      }
      paramClassDescriptor = new StringBuilder();
      paramTypeMappingConfiguration = paramTypeMappingConfiguration.asString();
      Intrinsics.checkExpressionValueIsNotNull(paramTypeMappingConfiguration, "fqName.asString()");
      paramClassDescriptor.append(StringsKt.replace$default(paramTypeMappingConfiguration, '.', '/', false, 4, null));
      paramClassDescriptor.append('/');
      paramClassDescriptor.append(str);
      return paramClassDescriptor.toString();
    }
    if (!(localDeclarationDescriptor instanceof ClassDescriptor)) {
      localObject = null;
    } else {
      localObject = localDeclarationDescriptor;
    }
    localObject = (ClassDescriptor)localObject;
    if (localObject != null)
    {
      paramClassDescriptor = paramTypeMappingConfiguration.getPredefinedInternalNameForClass((ClassDescriptor)localObject);
      if (paramClassDescriptor == null) {
        paramClassDescriptor = computeInternalName((ClassDescriptor)localObject, paramTypeMappingConfiguration);
      }
      paramTypeMappingConfiguration = new StringBuilder();
      paramTypeMappingConfiguration.append(paramClassDescriptor);
      paramTypeMappingConfiguration.append('$');
      paramTypeMappingConfiguration.append(str);
      return paramTypeMappingConfiguration.toString();
    }
    paramTypeMappingConfiguration = new StringBuilder();
    paramTypeMappingConfiguration.append("Unexpected container: ");
    paramTypeMappingConfiguration.append(localDeclarationDescriptor);
    paramTypeMappingConfiguration.append(" for ");
    paramTypeMappingConfiguration.append(paramClassDescriptor);
    throw ((Throwable)new IllegalArgumentException(paramTypeMappingConfiguration.toString()));
  }
  
  public static final boolean hasVoidReturnType(@NotNull CallableDescriptor paramCallableDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor, "descriptor");
    if ((paramCallableDescriptor instanceof ConstructorDescriptor)) {
      return true;
    }
    KotlinType localKotlinType = paramCallableDescriptor.getReturnType();
    if (localKotlinType == null) {
      Intrinsics.throwNpe();
    }
    if (KotlinBuiltIns.isUnit(localKotlinType))
    {
      localKotlinType = paramCallableDescriptor.getReturnType();
      if (localKotlinType == null) {
        Intrinsics.throwNpe();
      }
      if ((!TypeUtils.isNullableType(localKotlinType)) && (!(paramCallableDescriptor instanceof PropertyGetterDescriptor))) {
        return true;
      }
    }
    return false;
  }
  
  @Nullable
  public static final <T> T mapBuiltInType(@NotNull TypeSystemCommonBackendContext paramTypeSystemCommonBackendContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker, @NotNull JvmTypeFactory<T> paramJvmTypeFactory, @NotNull TypeMappingMode paramTypeMappingMode)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeSystemCommonBackendContext, "$this$mapBuiltInType");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "type");
    Intrinsics.checkParameterIsNotNull(paramJvmTypeFactory, "typeFactory");
    Intrinsics.checkParameterIsNotNull(paramTypeMappingMode, "mode");
    TypeConstructorMarker localTypeConstructorMarker = paramTypeSystemCommonBackendContext.typeConstructor(paramKotlinTypeMarker);
    if (!paramTypeSystemCommonBackendContext.isClassTypeConstructor(localTypeConstructorMarker)) {
      return null;
    }
    PrimitiveType localPrimitiveType = paramTypeSystemCommonBackendContext.getPrimitiveType(localTypeConstructorMarker);
    boolean bool2 = true;
    int j = 0;
    if (localPrimitiveType != null)
    {
      paramTypeMappingMode = JvmPrimitiveType.get(localPrimitiveType);
      Intrinsics.checkExpressionValueIsNotNull(paramTypeMappingMode, "JvmPrimitiveType.get(primitiveType)");
      paramTypeMappingMode = paramTypeMappingMode.getDesc();
      Intrinsics.checkExpressionValueIsNotNull(paramTypeMappingMode, "JvmPrimitiveType.get(primitiveType).desc");
      paramTypeMappingMode = paramJvmTypeFactory.createFromString(paramTypeMappingMode);
      boolean bool1 = bool2;
      if (!paramTypeSystemCommonBackendContext.isNullableType(paramKotlinTypeMarker)) {
        if (TypeEnhancementKt.hasEnhancedNullability(paramTypeSystemCommonBackendContext, paramKotlinTypeMarker)) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      return boxTypeIfNeeded(paramJvmTypeFactory, paramTypeMappingMode, bool1);
    }
    paramKotlinTypeMarker = paramTypeSystemCommonBackendContext.getPrimitiveArrayType(localTypeConstructorMarker);
    if (paramKotlinTypeMarker != null)
    {
      paramTypeSystemCommonBackendContext = new StringBuilder();
      paramTypeSystemCommonBackendContext.append("[");
      paramKotlinTypeMarker = JvmPrimitiveType.get(paramKotlinTypeMarker);
      Intrinsics.checkExpressionValueIsNotNull(paramKotlinTypeMarker, "JvmPrimitiveType.get(arrayElementType)");
      paramTypeSystemCommonBackendContext.append(paramKotlinTypeMarker.getDesc());
      return paramJvmTypeFactory.createFromString(paramTypeSystemCommonBackendContext.toString());
    }
    if (paramTypeSystemCommonBackendContext.isUnderKotlinPackage(localTypeConstructorMarker))
    {
      paramTypeSystemCommonBackendContext = paramTypeSystemCommonBackendContext.getClassFqNameUnsafe(localTypeConstructorMarker);
      if (paramTypeSystemCommonBackendContext != null) {
        paramTypeSystemCommonBackendContext = JavaToKotlinClassMap.INSTANCE.mapKotlinToJava(paramTypeSystemCommonBackendContext);
      } else {
        paramTypeSystemCommonBackendContext = null;
      }
      if (paramTypeSystemCommonBackendContext != null)
      {
        if (!paramTypeMappingMode.getKotlinCollectionsToJavaCollections())
        {
          paramKotlinTypeMarker = (Iterable)JavaToKotlinClassMap.INSTANCE.getMutabilityMappings();
          int i;
          if (((paramKotlinTypeMarker instanceof Collection)) && (((Collection)paramKotlinTypeMarker).isEmpty()))
          {
            i = j;
          }
          else
          {
            paramKotlinTypeMarker = paramKotlinTypeMarker.iterator();
            do
            {
              i = j;
              if (!paramKotlinTypeMarker.hasNext()) {
                break;
              }
            } while (!Intrinsics.areEqual(((JavaToKotlinClassMap.PlatformMutabilityMapping)paramKotlinTypeMarker.next()).getJavaClass(), paramTypeSystemCommonBackendContext));
            i = 1;
          }
          if (i != 0) {
            return null;
          }
        }
        paramTypeSystemCommonBackendContext = JvmClassName.byClassId(paramTypeSystemCommonBackendContext);
        Intrinsics.checkExpressionValueIsNotNull(paramTypeSystemCommonBackendContext, "JvmClassName.byClassId(classId)");
        paramTypeSystemCommonBackendContext = paramTypeSystemCommonBackendContext.getInternalName();
        Intrinsics.checkExpressionValueIsNotNull(paramTypeSystemCommonBackendContext, "JvmClassName.byClassId(classId).internalName");
        return paramJvmTypeFactory.createObjectType(paramTypeSystemCommonBackendContext);
      }
    }
    return null;
  }
  
  @NotNull
  public static final <T> T mapType(@NotNull KotlinType paramKotlinType, @NotNull JvmTypeFactory<T> paramJvmTypeFactory, @NotNull TypeMappingMode paramTypeMappingMode, @NotNull TypeMappingConfiguration<? extends T> paramTypeMappingConfiguration, @Nullable JvmDescriptorTypeWriter<T> paramJvmDescriptorTypeWriter, @NotNull Function3<? super KotlinType, ? super T, ? super TypeMappingMode, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "kotlinType");
    Intrinsics.checkParameterIsNotNull(paramJvmTypeFactory, "factory");
    Intrinsics.checkParameterIsNotNull(paramTypeMappingMode, "mode");
    Intrinsics.checkParameterIsNotNull(paramTypeMappingConfiguration, "typeMappingConfiguration");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "writeGenericType");
    Object localObject1 = paramTypeMappingConfiguration.preprocessType(paramKotlinType);
    if (localObject1 != null) {
      return mapType((KotlinType)localObject1, paramJvmTypeFactory, paramTypeMappingMode, paramTypeMappingConfiguration, paramJvmDescriptorTypeWriter, paramFunction3);
    }
    if (FunctionTypesKt.isSuspendFunctionType(paramKotlinType)) {
      return mapType((KotlinType)SuspendFunctionTypesKt.transformSuspendFunctionToRuntimeFunctionType(paramKotlinType, paramTypeMappingConfiguration.releaseCoroutines()), paramJvmTypeFactory, paramTypeMappingMode, paramTypeMappingConfiguration, paramJvmDescriptorTypeWriter, paramFunction3);
    }
    localObject1 = (TypeSystemCommonBackendContext)SimpleClassicTypeSystemContext.INSTANCE;
    Object localObject2 = (KotlinTypeMarker)paramKotlinType;
    localObject1 = mapBuiltInType((TypeSystemCommonBackendContext)localObject1, (KotlinTypeMarker)localObject2, paramJvmTypeFactory, paramTypeMappingMode);
    if (localObject1 != null)
    {
      paramJvmTypeFactory = boxTypeIfNeeded(paramJvmTypeFactory, localObject1, paramTypeMappingMode.getNeedPrimitiveBoxing());
      paramFunction3.invoke(paramKotlinType, paramJvmTypeFactory, paramTypeMappingMode);
      return paramJvmTypeFactory;
    }
    localObject1 = paramKotlinType.getConstructor();
    if ((localObject1 instanceof IntersectionTypeConstructor)) {
      return mapType(TypeUtilsKt.replaceArgumentsWithStarProjections(paramTypeMappingConfiguration.commonSupertype(((IntersectionTypeConstructor)localObject1).getSupertypes())), paramJvmTypeFactory, paramTypeMappingMode, paramTypeMappingConfiguration, paramJvmDescriptorTypeWriter, paramFunction3);
    }
    localObject1 = ((TypeConstructor)localObject1).getDeclarationDescriptor();
    if (localObject1 != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "constructor.declarationD…structor of $kotlinType\")");
      if (ErrorUtils.isError((DeclarationDescriptor)localObject1))
      {
        paramJvmTypeFactory = paramJvmTypeFactory.createObjectType("error/NonExistentClass");
        if (localObject1 != null)
        {
          paramTypeMappingConfiguration.processErrorType(paramKotlinType, (ClassDescriptor)localObject1);
          if (paramJvmDescriptorTypeWriter != null) {
            paramJvmDescriptorTypeWriter.writeClass(paramJvmTypeFactory);
          }
          return paramJvmTypeFactory;
        }
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
      }
      boolean bool = localObject1 instanceof ClassDescriptor;
      if ((bool) && (KotlinBuiltIns.isArray(paramKotlinType)))
      {
        if (paramKotlinType.getArguments().size() == 1)
        {
          localObject1 = (TypeProjection)paramKotlinType.getArguments().get(0);
          paramKotlinType = ((TypeProjection)localObject1).getType();
          Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "memberProjection.type");
          if (((TypeProjection)localObject1).getProjectionKind() == Variance.IN_VARIANCE)
          {
            paramTypeMappingMode = paramJvmTypeFactory.createObjectType("java/lang/Object");
            paramKotlinType = paramTypeMappingMode;
            if (paramJvmDescriptorTypeWriter != null)
            {
              paramJvmDescriptorTypeWriter.writeArrayType();
              paramJvmDescriptorTypeWriter.writeClass(paramTypeMappingMode);
              paramJvmDescriptorTypeWriter.writeArrayEnd();
              paramKotlinType = paramTypeMappingMode;
            }
          }
          else
          {
            if (paramJvmDescriptorTypeWriter != null) {
              paramJvmDescriptorTypeWriter.writeArrayType();
            }
            localObject1 = ((TypeProjection)localObject1).getProjectionKind();
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "memberProjection.projectionKind");
            paramTypeMappingMode = mapType(paramKotlinType, paramJvmTypeFactory, paramTypeMappingMode.toGenericArgumentMode((Variance)localObject1), paramTypeMappingConfiguration, paramJvmDescriptorTypeWriter, paramFunction3);
            paramKotlinType = paramTypeMappingMode;
            if (paramJvmDescriptorTypeWriter != null)
            {
              paramJvmDescriptorTypeWriter.writeArrayEnd();
              paramKotlinType = paramTypeMappingMode;
            }
          }
          paramTypeMappingMode = new StringBuilder();
          paramTypeMappingMode.append("[");
          paramTypeMappingMode.append(paramJvmTypeFactory.toString(paramKotlinType));
          return paramJvmTypeFactory.createFromString(paramTypeMappingMode.toString());
        }
        throw ((Throwable)new UnsupportedOperationException("arrays must have one type argument"));
      }
      if (bool)
      {
        localObject1 = (ClassDescriptor)localObject1;
        if ((((ClassDescriptor)localObject1).isInline()) && (!paramTypeMappingMode.getNeedInlineClassWrapping()))
        {
          localObject2 = (KotlinType)InlineClassMappingKt.computeExpandedTypeForInlineClass((TypeSystemCommonBackendContext)SimpleClassicTypeSystemContext.INSTANCE, (KotlinTypeMarker)localObject2);
          if (localObject2 != null) {
            return mapType((KotlinType)localObject2, paramJvmTypeFactory, paramTypeMappingMode.wrapInlineClassesMode(), paramTypeMappingConfiguration, paramJvmDescriptorTypeWriter, paramFunction3);
          }
        }
        if ((paramTypeMappingMode.isForAnnotationParameter()) && (KotlinBuiltIns.isKClass((ClassDescriptor)localObject1)))
        {
          paramJvmTypeFactory = paramJvmTypeFactory.getJavaLangClassType();
        }
        else
        {
          paramJvmDescriptorTypeWriter = ((ClassDescriptor)localObject1).getOriginal();
          Intrinsics.checkExpressionValueIsNotNull(paramJvmDescriptorTypeWriter, "descriptor.original");
          paramJvmDescriptorTypeWriter = paramTypeMappingConfiguration.getPredefinedTypeForClass(paramJvmDescriptorTypeWriter);
          if (paramJvmDescriptorTypeWriter != null)
          {
            paramJvmTypeFactory = paramJvmDescriptorTypeWriter;
          }
          else
          {
            paramJvmDescriptorTypeWriter = (JvmDescriptorTypeWriter<T>)localObject1;
            if (((ClassDescriptor)localObject1).getKind() == ClassKind.ENUM_ENTRY)
            {
              paramJvmDescriptorTypeWriter = ((ClassDescriptor)localObject1).getContainingDeclaration();
              if (paramJvmDescriptorTypeWriter != null) {
                paramJvmDescriptorTypeWriter = (ClassDescriptor)paramJvmDescriptorTypeWriter;
              } else {
                throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
              }
            }
            paramJvmDescriptorTypeWriter = paramJvmDescriptorTypeWriter.getOriginal();
            Intrinsics.checkExpressionValueIsNotNull(paramJvmDescriptorTypeWriter, "enumClassIfEnumEntry.original");
            paramJvmTypeFactory = paramJvmTypeFactory.createObjectType(computeInternalName(paramJvmDescriptorTypeWriter, paramTypeMappingConfiguration));
          }
        }
        paramFunction3.invoke(paramKotlinType, paramJvmTypeFactory, paramTypeMappingMode);
        return paramJvmTypeFactory;
      }
      if ((localObject1 instanceof TypeParameterDescriptor))
      {
        paramKotlinType = TypeUtilsKt.getRepresentativeUpperBound((TypeParameterDescriptor)localObject1);
        paramFunction3 = FunctionsKt.getDO_NOTHING_3();
      }
    }
    try
    {
      paramKotlinType = mapType(paramKotlinType, paramJvmTypeFactory, paramTypeMappingMode, paramTypeMappingConfiguration, null, paramFunction3);
      if (paramJvmDescriptorTypeWriter != null)
      {
        paramJvmTypeFactory = ((ClassifierDescriptor)localObject1).getName();
        Intrinsics.checkExpressionValueIsNotNull(paramJvmTypeFactory, "descriptor.getName()");
        paramJvmDescriptorTypeWriter.writeTypeVariable(paramJvmTypeFactory, paramKotlinType);
      }
      return paramKotlinType;
    }
    catch (Throwable paramKotlinType)
    {
      throw paramKotlinType;
    }
    paramJvmTypeFactory = new StringBuilder();
    paramJvmTypeFactory.append("Unknown type ");
    paramJvmTypeFactory.append(paramKotlinType);
    throw ((Throwable)new UnsupportedOperationException(paramJvmTypeFactory.toString()));
    paramJvmTypeFactory = new StringBuilder();
    paramJvmTypeFactory.append("no descriptor for type constructor of ");
    paramJvmTypeFactory.append(paramKotlinType);
    throw ((Throwable)new UnsupportedOperationException(paramJvmTypeFactory.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.TypeSignatureMappingKt
 * JD-Core Version:    0.7.0.1
 */