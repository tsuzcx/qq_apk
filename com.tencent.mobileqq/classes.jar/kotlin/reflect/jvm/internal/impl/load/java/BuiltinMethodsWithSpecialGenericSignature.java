package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BuiltinMethodsWithSpecialGenericSignature
{
  @NotNull
  private static final List<String> ERASED_COLLECTION_PARAMETER_NAMES;
  private static final List<NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
  private static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES;
  private static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES;
  @NotNull
  private static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES;
  private static final Map<NameAndSignature, BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
  public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE = new BuiltinMethodsWithSpecialGenericSignature();
  private static final Map<String, BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP;
  
  static
  {
    Object localObject2 = (Iterable)SetsKt.setOf(new String[] { "containsAll", "removeAll", "retainAll" });
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = JvmPrimitiveType.BOOLEAN.getDesc();
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
      ((Collection)localObject1).add(SpecialBuiltinMembers.access$method("java/util/Collection", (String)localObject3, "Ljava/util/Collection;", (String)localObject4));
    }
    ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = (List)localObject1;
    localObject2 = (Iterable)ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((NameAndSignature)((Iterator)localObject2).next()).getSignature());
    }
    ERASED_COLLECTION_PARAMETER_SIGNATURES = (List)localObject1;
    localObject2 = (Iterable)ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((NameAndSignature)((Iterator)localObject2).next()).getName().asString());
    }
    ERASED_COLLECTION_PARAMETER_NAMES = (List)localObject1;
    localObject1 = SignatureBuildingComponents.INSTANCE;
    localObject2 = ((SignatureBuildingComponents)localObject1).javaUtil("Collection");
    Object localObject3 = JvmPrimitiveType.BOOLEAN.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "JvmPrimitiveType.BOOLEAN.desc");
    localObject2 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject2, "contains", "Ljava/lang/Object;", (String)localObject3), BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.FALSE);
    localObject3 = ((SignatureBuildingComponents)localObject1).javaUtil("Collection");
    Object localObject4 = JvmPrimitiveType.BOOLEAN.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "JvmPrimitiveType.BOOLEAN.desc");
    localObject3 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject3, "remove", "Ljava/lang/Object;", (String)localObject4), BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.FALSE);
    localObject4 = ((SignatureBuildingComponents)localObject1).javaUtil("Map");
    Object localObject5 = JvmPrimitiveType.BOOLEAN.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "JvmPrimitiveType.BOOLEAN.desc");
    localObject4 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject4, "containsKey", "Ljava/lang/Object;", (String)localObject5), BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.FALSE);
    localObject5 = ((SignatureBuildingComponents)localObject1).javaUtil("Map");
    Object localObject6 = JvmPrimitiveType.BOOLEAN.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "JvmPrimitiveType.BOOLEAN.desc");
    localObject5 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject5, "containsValue", "Ljava/lang/Object;", (String)localObject6), BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.FALSE);
    localObject6 = ((SignatureBuildingComponents)localObject1).javaUtil("Map");
    Object localObject7 = JvmPrimitiveType.BOOLEAN.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject7, "JvmPrimitiveType.BOOLEAN.desc");
    localObject6 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject6, "remove", "Ljava/lang/Object;Ljava/lang/Object;", (String)localObject7), BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.FALSE);
    localObject7 = TuplesKt.to(SpecialBuiltinMembers.access$method(((SignatureBuildingComponents)localObject1).javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT);
    Pair localPair1 = TuplesKt.to(SpecialBuiltinMembers.access$method(((SignatureBuildingComponents)localObject1).javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.NULL);
    Pair localPair2 = TuplesKt.to(SpecialBuiltinMembers.access$method(((SignatureBuildingComponents)localObject1).javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.NULL);
    Object localObject8 = ((SignatureBuildingComponents)localObject1).javaUtil("List");
    String str = JvmPrimitiveType.INT.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(str, "JvmPrimitiveType.INT.desc");
    localObject8 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject8, "indexOf", "Ljava/lang/Object;", str), BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.INDEX);
    localObject1 = ((SignatureBuildingComponents)localObject1).javaUtil("List");
    str = JvmPrimitiveType.INT.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(str, "JvmPrimitiveType.INT.desc");
    GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = MapsKt.mapOf(new Pair[] { localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localPair1, localPair2, localObject8, TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject1, "lastIndexOf", "Ljava/lang/Object;", str), BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.INDEX) });
    localObject2 = GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
    localObject1 = (Map)new LinkedHashMap(MapsKt.mapCapacity(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Map)localObject1).put(((NameAndSignature)((Map.Entry)localObject3).getKey()).getSignature(), ((Map.Entry)localObject3).getValue());
    }
    SIGNATURE_TO_DEFAULT_VALUES_MAP = (Map)localObject1;
    localObject1 = (Iterable)SetsKt.plus(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), (Iterable)ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
    localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject3 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(((NameAndSignature)((Iterator)localObject3).next()).getName());
    }
    ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt.toSet((Iterable)localObject2);
    localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Collection)localObject2).add(((NameAndSignature)((Iterator)localObject1).next()).getSignature());
    }
    ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt.toSet((Iterable)localObject2);
  }
  
  private final boolean getHasErasedValueParametersInJava(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    return CollectionsKt.contains((Iterable)ERASED_VALUE_PARAMETERS_SIGNATURES, MethodSignatureMappingKt.computeJvmSignature((CallableDescriptor)paramCallableMemberDescriptor));
  }
  
  @JvmStatic
  @Nullable
  public static final FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    BuiltinMethodsWithSpecialGenericSignature localBuiltinMethodsWithSpecialGenericSignature = INSTANCE;
    Name localName = paramFunctionDescriptor.getName();
    Intrinsics.checkExpressionValueIsNotNull(localName, "functionDescriptor.name");
    if (!localBuiltinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(localName)) {
      return null;
    }
    return (FunctionDescriptor)DescriptorUtilsKt.firstOverridden$default((CallableMemberDescriptor)paramFunctionDescriptor, false, (Function1)BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava.1.INSTANCE, 1, null);
  }
  
  @JvmStatic
  @Nullable
  public static final BuiltinMethodsWithSpecialGenericSignature.SpecialSignatureInfo getSpecialSignatureInfo(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableMemberDescriptor, "$this$getSpecialSignatureInfo");
    if (!ERASED_VALUE_PARAMETERS_SHORT_NAMES.contains(paramCallableMemberDescriptor.getName())) {
      return null;
    }
    paramCallableMemberDescriptor = DescriptorUtilsKt.firstOverridden$default(paramCallableMemberDescriptor, false, (Function1)BuiltinMethodsWithSpecialGenericSignature.getSpecialSignatureInfo.builtinSignature.1.INSTANCE, 1, null);
    if (paramCallableMemberDescriptor != null)
    {
      paramCallableMemberDescriptor = MethodSignatureMappingKt.computeJvmSignature((CallableDescriptor)paramCallableMemberDescriptor);
      if (paramCallableMemberDescriptor != null)
      {
        if (ERASED_COLLECTION_PARAMETER_SIGNATURES.contains(paramCallableMemberDescriptor)) {
          return BuiltinMethodsWithSpecialGenericSignature.SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
        }
        if ((BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription)MapsKt.getValue(SIGNATURE_TO_DEFAULT_VALUES_MAP, paramCallableMemberDescriptor) == BuiltinMethodsWithSpecialGenericSignature.TypeSafeBarrierDescription.NULL) {
          return BuiltinMethodsWithSpecialGenericSignature.SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
        }
        return BuiltinMethodsWithSpecialGenericSignature.SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
      }
    }
    return null;
  }
  
  public final boolean getSameAsBuiltinMethodWithErasedValueParameters(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "$this$sameAsBuiltinMethodWithErasedValueParameters");
    return ERASED_VALUE_PARAMETERS_SHORT_NAMES.contains(paramName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature
 * JD-Core Version:    0.7.0.1
 */