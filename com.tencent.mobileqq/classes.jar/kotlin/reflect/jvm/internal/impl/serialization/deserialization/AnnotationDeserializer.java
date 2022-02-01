package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags.BooleanFlagField;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.BooleanValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.CharValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.DoubleValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.constants.FloatValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ShortValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.StringValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UByteValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UIntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ULongValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.UShortValue;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;

public final class AnnotationDeserializer
{
  private final ModuleDescriptor module;
  private final NotFoundClasses notFoundClasses;
  
  public AnnotationDeserializer(@NotNull ModuleDescriptor paramModuleDescriptor, @NotNull NotFoundClasses paramNotFoundClasses)
  {
    this.module = paramModuleDescriptor;
    this.notFoundClasses = paramNotFoundClasses;
  }
  
  private final boolean doesValueConformToExpectedType(ConstantValue<?> paramConstantValue, KotlinType paramKotlinType, ProtoBuf.Annotation.Argument.Value paramValue)
  {
    Object localObject = paramValue.getType();
    boolean bool = false;
    int i;
    if (localObject != null)
    {
      i = AnnotationDeserializer.WhenMappings.$EnumSwitchMapping$1[localObject.ordinal()];
      if (i == 1) {
        break label276;
      }
      if (i == 2) {}
    }
    else
    {
      return Intrinsics.areEqual(paramConstantValue.getType(this.module), paramKotlinType);
    }
    if (((paramConstantValue instanceof ArrayValue)) && (((List)((ArrayValue)paramConstantValue).getValue()).size() == paramValue.getArrayElementList().size())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramKotlinType = getBuiltIns().getArrayElementType(paramKotlinType);
      Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "builtIns.getArrayElementType(expectedType)");
      paramConstantValue = (ArrayValue)paramConstantValue;
      localObject = (Iterable)CollectionsKt.getIndices((Collection)paramConstantValue.getValue());
      if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
      {
        localObject = ((Iterable)localObject).iterator();
        ConstantValue localConstantValue;
        ProtoBuf.Annotation.Argument.Value localValue;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          i = ((IntIterator)localObject).nextInt();
          localConstantValue = (ConstantValue)((List)paramConstantValue.getValue()).get(i);
          localValue = paramValue.getArrayElement(i);
          Intrinsics.checkExpressionValueIsNotNull(localValue, "value.getArrayElement(i)");
        } while (doesValueConformToExpectedType(localConstantValue, paramKotlinType, localValue));
        return false;
      }
    }
    else
    {
      paramKotlinType = new StringBuilder();
      paramKotlinType.append("Deserialized ArrayValue should have the same number of elements as the original array value: ");
      paramKotlinType.append(paramConstantValue);
      throw ((Throwable)new IllegalStateException(paramKotlinType.toString().toString()));
      label276:
      paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
      paramConstantValue = paramKotlinType;
      if (!(paramKotlinType instanceof ClassDescriptor)) {
        paramConstantValue = null;
      }
      paramConstantValue = (ClassDescriptor)paramConstantValue;
      if ((paramConstantValue != null) && (!KotlinBuiltIns.isKClass(paramConstantValue))) {
        break label316;
      }
    }
    bool = true;
    label316:
    return bool;
  }
  
  private final KotlinBuiltIns getBuiltIns()
  {
    return this.module.getBuiltIns();
  }
  
  private final Pair<Name, ConstantValue<?>> resolveArgument(ProtoBuf.Annotation.Argument paramArgument, Map<Name, ? extends ValueParameterDescriptor> paramMap, NameResolver paramNameResolver)
  {
    Object localObject = (ValueParameterDescriptor)paramMap.get(NameResolverUtilKt.getName(paramNameResolver, paramArgument.getNameId()));
    if (localObject != null)
    {
      paramMap = NameResolverUtilKt.getName(paramNameResolver, paramArgument.getNameId());
      localObject = ((ValueParameterDescriptor)localObject).getType();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "parameter.type");
      paramArgument = paramArgument.getValue();
      Intrinsics.checkExpressionValueIsNotNull(paramArgument, "proto.value");
      return new Pair(paramMap, resolveValueAndCheckExpectedType((KotlinType)localObject, paramArgument, paramNameResolver));
    }
    return null;
  }
  
  private final ClassDescriptor resolveClass(ClassId paramClassId)
  {
    return FindClassInModuleKt.findNonGenericClassAcrossDependencies(this.module, paramClassId, this.notFoundClasses);
  }
  
  private final ConstantValue<?> resolveValueAndCheckExpectedType(KotlinType paramKotlinType, ProtoBuf.Annotation.Argument.Value paramValue, NameResolver paramNameResolver)
  {
    paramNameResolver = resolveValue(paramKotlinType, paramValue, paramNameResolver);
    if (!doesValueConformToExpectedType(paramNameResolver, paramKotlinType, paramValue)) {
      paramNameResolver = null;
    }
    if (paramNameResolver != null) {
      return paramNameResolver;
    }
    paramNameResolver = ErrorValue.Companion;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected argument value: actual type ");
    localStringBuilder.append(paramValue.getType());
    localStringBuilder.append(" != expected type ");
    localStringBuilder.append(paramKotlinType);
    return (ConstantValue)paramNameResolver.create(localStringBuilder.toString());
  }
  
  @NotNull
  public final AnnotationDescriptor deserializeAnnotation(@NotNull ProtoBuf.Annotation paramAnnotation, @NotNull NameResolver paramNameResolver)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotation, "proto");
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "nameResolver");
    ClassDescriptor localClassDescriptor = resolveClass(NameResolverUtilKt.getClassId(paramNameResolver, paramAnnotation.getId()));
    Object localObject2 = MapsKt.emptyMap();
    Object localObject1 = localObject2;
    if (paramAnnotation.getArgumentCount() != 0)
    {
      Object localObject3 = (DeclarationDescriptor)localClassDescriptor;
      localObject1 = localObject2;
      if (!ErrorUtils.isError((DeclarationDescriptor)localObject3))
      {
        localObject1 = localObject2;
        if (DescriptorUtils.isAnnotationClass((DeclarationDescriptor)localObject3))
        {
          localObject1 = localClassDescriptor.getConstructors();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "annotationClass.constructors");
          localObject3 = (ClassConstructorDescriptor)CollectionsKt.singleOrNull((Iterable)localObject1);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = ((ClassConstructorDescriptor)localObject3).getValueParameters();
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "constructor.valueParameters");
            localObject2 = (Iterable)localObject1;
            localObject1 = (Map)new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10)), 16));
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = ((Iterator)localObject2).next();
              ValueParameterDescriptor localValueParameterDescriptor = (ValueParameterDescriptor)localObject3;
              Intrinsics.checkExpressionValueIsNotNull(localValueParameterDescriptor, "it");
              ((Map)localObject1).put(localValueParameterDescriptor.getName(), localObject3);
            }
            paramAnnotation = paramAnnotation.getArgumentList();
            Intrinsics.checkExpressionValueIsNotNull(paramAnnotation, "proto.argumentList");
            localObject2 = (Iterable)paramAnnotation;
            paramAnnotation = (Collection)new ArrayList();
            localObject2 = ((Iterable)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (ProtoBuf.Annotation.Argument)((Iterator)localObject2).next();
              Intrinsics.checkExpressionValueIsNotNull(localObject3, "it");
              localObject3 = resolveArgument((ProtoBuf.Annotation.Argument)localObject3, (Map)localObject1, paramNameResolver);
              if (localObject3 != null) {
                paramAnnotation.add(localObject3);
              }
            }
            localObject1 = MapsKt.toMap((Iterable)paramAnnotation);
          }
        }
      }
    }
    return (AnnotationDescriptor)new AnnotationDescriptorImpl((KotlinType)localClassDescriptor.getDefaultType(), (Map)localObject1, SourceElement.NO_SOURCE);
  }
  
  @NotNull
  public final ConstantValue<?> resolveValue(@NotNull KotlinType paramKotlinType, @NotNull ProtoBuf.Annotation.Argument.Value paramValue, @NotNull NameResolver paramNameResolver)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "expectedType");
    Intrinsics.checkParameterIsNotNull(paramValue, "value");
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "nameResolver");
    Object localObject1 = Flags.IS_UNSIGNED.get(paramValue.getFlags());
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "Flags.IS_UNSIGNED.get(value.flags)");
    boolean bool = ((Boolean)localObject1).booleanValue();
    localObject1 = paramValue.getType();
    if (localObject1 != null) {
      switch (AnnotationDeserializer.WhenMappings.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        break;
      case 13: 
        localObject1 = ConstantValueFactory.INSTANCE;
        paramValue = paramValue.getArrayElementList();
        Intrinsics.checkExpressionValueIsNotNull(paramValue, "value.arrayElementList");
        Object localObject2 = (Iterable)paramValue;
        paramValue = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ProtoBuf.Annotation.Argument.Value localValue = (ProtoBuf.Annotation.Argument.Value)((Iterator)localObject2).next();
          Object localObject3 = getBuiltIns().getAnyType();
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "builtIns.anyType");
          localObject3 = (KotlinType)localObject3;
          Intrinsics.checkExpressionValueIsNotNull(localValue, "it");
          paramValue.add(resolveValue((KotlinType)localObject3, localValue, paramNameResolver));
        }
        return (ConstantValue)((ConstantValueFactory)localObject1).createArrayValue((List)paramValue, paramKotlinType);
      case 12: 
        paramKotlinType = paramValue.getAnnotation();
        Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "value.annotation");
        return (ConstantValue)new AnnotationValue(deserializeAnnotation(paramKotlinType, paramNameResolver));
      case 11: 
        return (ConstantValue)new EnumValue(NameResolverUtilKt.getClassId(paramNameResolver, paramValue.getClassId()), NameResolverUtilKt.getName(paramNameResolver, paramValue.getEnumValueId()));
      case 10: 
        return (ConstantValue)new KClassValue(NameResolverUtilKt.getClassId(paramNameResolver, paramValue.getClassId()), paramValue.getArrayDimensionCount());
      case 9: 
        return (ConstantValue)new StringValue(paramNameResolver.getString(paramValue.getStringValue()));
      case 8: 
        if (paramValue.getIntValue() != 0L) {
          bool = true;
        } else {
          bool = false;
        }
        return (ConstantValue)new BooleanValue(bool);
      case 7: 
        return (ConstantValue)new DoubleValue(paramValue.getDoubleValue());
      case 6: 
        return (ConstantValue)new FloatValue(paramValue.getFloatValue());
      case 5: 
        long l = paramValue.getIntValue();
        if (bool) {
          paramKotlinType = new ULongValue(l);
        } else {
          paramKotlinType = new LongValue(l);
        }
        return (ConstantValue)paramKotlinType;
      case 4: 
        int i = (int)paramValue.getIntValue();
        if (bool) {
          paramKotlinType = new UIntValue(i);
        } else {
          paramKotlinType = new IntValue(i);
        }
        return (ConstantValue)paramKotlinType;
      case 3: 
        short s = (short)(int)paramValue.getIntValue();
        if (bool) {
          paramKotlinType = new UShortValue(s);
        } else {
          paramKotlinType = new ShortValue(s);
        }
        return (ConstantValue)paramKotlinType;
      case 2: 
        return (ConstantValue)new CharValue((char)(int)paramValue.getIntValue());
      case 1: 
        byte b = (byte)(int)paramValue.getIntValue();
        if (bool) {
          paramKotlinType = new UByteValue(b);
        } else {
          paramKotlinType = new ByteValue(b);
        }
        return (ConstantValue)paramKotlinType;
      }
    }
    paramNameResolver = new StringBuilder();
    paramNameResolver.append("Unsupported annotation argument type: ");
    paramNameResolver.append(paramValue.getType());
    paramNameResolver.append(" (expected ");
    paramNameResolver.append(paramKotlinType);
    paramNameResolver.append(')');
    paramKotlinType = (Throwable)new IllegalStateException(paramNameResolver.toString().toString());
    for (;;)
    {
      throw paramKotlinType;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationDeserializer
 * JD-Core Version:    0.7.0.1
 */