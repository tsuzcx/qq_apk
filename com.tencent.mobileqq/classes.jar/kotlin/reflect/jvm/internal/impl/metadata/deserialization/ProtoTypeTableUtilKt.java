package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ProtoTypeTableUtilKt
{
  @Nullable
  public static final ProtoBuf.Type abbreviatedType(@NotNull ProtoBuf.Type paramType, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "$this$abbreviatedType");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramType.hasAbbreviatedType()) {
      return paramType.getAbbreviatedType();
    }
    if (paramType.hasAbbreviatedTypeId()) {
      return paramTypeTable.get(paramType.getAbbreviatedTypeId());
    }
    return null;
  }
  
  @NotNull
  public static final ProtoBuf.Type expandedType(@NotNull ProtoBuf.TypeAlias paramTypeAlias, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeAlias, "$this$expandedType");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramTypeAlias.hasExpandedType())
    {
      paramTypeAlias = paramTypeAlias.getExpandedType();
      Intrinsics.checkExpressionValueIsNotNull(paramTypeAlias, "expandedType");
      return paramTypeAlias;
    }
    if (paramTypeAlias.hasExpandedTypeId()) {
      return paramTypeTable.get(paramTypeAlias.getExpandedTypeId());
    }
    throw ((Throwable)new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString()));
  }
  
  @Nullable
  public static final ProtoBuf.Type flexibleUpperBound(@NotNull ProtoBuf.Type paramType, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "$this$flexibleUpperBound");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramType.hasFlexibleUpperBound()) {
      return paramType.getFlexibleUpperBound();
    }
    if (paramType.hasFlexibleUpperBoundId()) {
      return paramTypeTable.get(paramType.getFlexibleUpperBoundId());
    }
    return null;
  }
  
  public static final boolean hasReceiver(@NotNull ProtoBuf.Function paramFunction)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction, "$this$hasReceiver");
    return (paramFunction.hasReceiverType()) || (paramFunction.hasReceiverTypeId());
  }
  
  public static final boolean hasReceiver(@NotNull ProtoBuf.Property paramProperty)
  {
    Intrinsics.checkParameterIsNotNull(paramProperty, "$this$hasReceiver");
    return (paramProperty.hasReceiverType()) || (paramProperty.hasReceiverTypeId());
  }
  
  @Nullable
  public static final ProtoBuf.Type outerType(@NotNull ProtoBuf.Type paramType, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "$this$outerType");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramType.hasOuterType()) {
      return paramType.getOuterType();
    }
    if (paramType.hasOuterTypeId()) {
      return paramTypeTable.get(paramType.getOuterTypeId());
    }
    return null;
  }
  
  @Nullable
  public static final ProtoBuf.Type receiverType(@NotNull ProtoBuf.Function paramFunction, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction, "$this$receiverType");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramFunction.hasReceiverType()) {
      return paramFunction.getReceiverType();
    }
    if (paramFunction.hasReceiverTypeId()) {
      return paramTypeTable.get(paramFunction.getReceiverTypeId());
    }
    return null;
  }
  
  @Nullable
  public static final ProtoBuf.Type receiverType(@NotNull ProtoBuf.Property paramProperty, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramProperty, "$this$receiverType");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramProperty.hasReceiverType()) {
      return paramProperty.getReceiverType();
    }
    if (paramProperty.hasReceiverTypeId()) {
      return paramTypeTable.get(paramProperty.getReceiverTypeId());
    }
    return null;
  }
  
  @NotNull
  public static final ProtoBuf.Type returnType(@NotNull ProtoBuf.Function paramFunction, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction, "$this$returnType");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramFunction.hasReturnType())
    {
      paramFunction = paramFunction.getReturnType();
      Intrinsics.checkExpressionValueIsNotNull(paramFunction, "returnType");
      return paramFunction;
    }
    if (paramFunction.hasReturnTypeId()) {
      return paramTypeTable.get(paramFunction.getReturnTypeId());
    }
    throw ((Throwable)new IllegalStateException("No returnType in ProtoBuf.Function".toString()));
  }
  
  @NotNull
  public static final ProtoBuf.Type returnType(@NotNull ProtoBuf.Property paramProperty, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramProperty, "$this$returnType");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramProperty.hasReturnType())
    {
      paramProperty = paramProperty.getReturnType();
      Intrinsics.checkExpressionValueIsNotNull(paramProperty, "returnType");
      return paramProperty;
    }
    if (paramProperty.hasReturnTypeId()) {
      return paramTypeTable.get(paramProperty.getReturnTypeId());
    }
    throw ((Throwable)new IllegalStateException("No returnType in ProtoBuf.Property".toString()));
  }
  
  @NotNull
  public static final List<ProtoBuf.Type> supertypes(@NotNull ProtoBuf.Class paramClass, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "$this$supertypes");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    Object localObject = paramClass.getSupertypeList();
    if (!(((Collection)localObject).isEmpty() ^ true)) {
      localObject = null;
    }
    if (localObject != null) {
      return localObject;
    }
    paramClass = paramClass.getSupertypeIdList();
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "supertypeIdList");
    localObject = (Iterable)paramClass;
    paramClass = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      Intrinsics.checkExpressionValueIsNotNull(localInteger, "it");
      paramClass.add(paramTypeTable.get(localInteger.intValue()));
    }
    return (List)paramClass;
  }
  
  @Nullable
  public static final ProtoBuf.Type type(@NotNull ProtoBuf.Type.Argument paramArgument, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramArgument, "$this$type");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramArgument.hasType()) {
      return paramArgument.getType();
    }
    if (paramArgument.hasTypeId()) {
      return paramTypeTable.get(paramArgument.getTypeId());
    }
    return null;
  }
  
  @NotNull
  public static final ProtoBuf.Type type(@NotNull ProtoBuf.ValueParameter paramValueParameter, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramValueParameter, "$this$type");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramValueParameter.hasType())
    {
      paramValueParameter = paramValueParameter.getType();
      Intrinsics.checkExpressionValueIsNotNull(paramValueParameter, "type");
      return paramValueParameter;
    }
    if (paramValueParameter.hasTypeId()) {
      return paramTypeTable.get(paramValueParameter.getTypeId());
    }
    throw ((Throwable)new IllegalStateException("No type in ProtoBuf.ValueParameter".toString()));
  }
  
  @NotNull
  public static final ProtoBuf.Type underlyingType(@NotNull ProtoBuf.TypeAlias paramTypeAlias, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeAlias, "$this$underlyingType");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramTypeAlias.hasUnderlyingType())
    {
      paramTypeAlias = paramTypeAlias.getUnderlyingType();
      Intrinsics.checkExpressionValueIsNotNull(paramTypeAlias, "underlyingType");
      return paramTypeAlias;
    }
    if (paramTypeAlias.hasUnderlyingTypeId()) {
      return paramTypeTable.get(paramTypeAlias.getUnderlyingTypeId());
    }
    throw ((Throwable)new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString()));
  }
  
  @NotNull
  public static final List<ProtoBuf.Type> upperBounds(@NotNull ProtoBuf.TypeParameter paramTypeParameter, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeParameter, "$this$upperBounds");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    Object localObject = paramTypeParameter.getUpperBoundList();
    if (!(((Collection)localObject).isEmpty() ^ true)) {
      localObject = null;
    }
    if (localObject != null) {
      return localObject;
    }
    paramTypeParameter = paramTypeParameter.getUpperBoundIdList();
    Intrinsics.checkExpressionValueIsNotNull(paramTypeParameter, "upperBoundIdList");
    localObject = (Iterable)paramTypeParameter;
    paramTypeParameter = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      Intrinsics.checkExpressionValueIsNotNull(localInteger, "it");
      paramTypeParameter.add(paramTypeTable.get(localInteger.intValue()));
    }
    return (List)paramTypeParameter;
  }
  
  @Nullable
  public static final ProtoBuf.Type varargElementType(@NotNull ProtoBuf.ValueParameter paramValueParameter, @NotNull TypeTable paramTypeTable)
  {
    Intrinsics.checkParameterIsNotNull(paramValueParameter, "$this$varargElementType");
    Intrinsics.checkParameterIsNotNull(paramTypeTable, "typeTable");
    if (paramValueParameter.hasVarargElementType()) {
      return paramValueParameter.getVarargElementType();
    }
    if (paramValueParameter.hasVarargElementTypeId()) {
      return paramTypeTable.get(paramValueParameter.getVarargElementTypeId());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt
 * JD-Core Version:    0.7.0.1
 */