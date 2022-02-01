package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BuiltinMethodsWithDifferentJvmName
{
  public static final BuiltinMethodsWithDifferentJvmName INSTANCE = new BuiltinMethodsWithDifferentJvmName();
  private static final Map<Name, List<Name>> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
  private static final Map<NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
  @NotNull
  private static final List<Name> ORIGINAL_SHORT_NAMES;
  private static final NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;
  private static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME;
  
  static
  {
    Object localObject1 = JvmPrimitiveType.INT.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "JvmPrimitiveType.INT.desc");
    REMOVE_AT_NAME_AND_SIGNATURE = SpecialBuiltinMembers.access$method("java/util/List", "removeAt", (String)localObject1, "Ljava/lang/Object;");
    Object localObject2 = SignatureBuildingComponents.INSTANCE;
    localObject1 = ((SignatureBuildingComponents)localObject2).javaLang("Number");
    Object localObject3 = JvmPrimitiveType.BYTE.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "JvmPrimitiveType.BYTE.desc");
    localObject1 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject1, "toByte", "", (String)localObject3), Name.identifier("byteValue"));
    localObject3 = ((SignatureBuildingComponents)localObject2).javaLang("Number");
    Object localObject4 = JvmPrimitiveType.SHORT.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "JvmPrimitiveType.SHORT.desc");
    localObject3 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject3, "toShort", "", (String)localObject4), Name.identifier("shortValue"));
    localObject4 = ((SignatureBuildingComponents)localObject2).javaLang("Number");
    Object localObject5 = JvmPrimitiveType.INT.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject5, "JvmPrimitiveType.INT.desc");
    localObject4 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject4, "toInt", "", (String)localObject5), Name.identifier("intValue"));
    localObject5 = ((SignatureBuildingComponents)localObject2).javaLang("Number");
    Object localObject6 = JvmPrimitiveType.LONG.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject6, "JvmPrimitiveType.LONG.desc");
    localObject5 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject5, "toLong", "", (String)localObject6), Name.identifier("longValue"));
    localObject6 = ((SignatureBuildingComponents)localObject2).javaLang("Number");
    Object localObject7 = JvmPrimitiveType.FLOAT.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject7, "JvmPrimitiveType.FLOAT.desc");
    localObject6 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject6, "toFloat", "", (String)localObject7), Name.identifier("floatValue"));
    localObject7 = ((SignatureBuildingComponents)localObject2).javaLang("Number");
    Object localObject8 = JvmPrimitiveType.DOUBLE.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(localObject8, "JvmPrimitiveType.DOUBLE.desc");
    localObject7 = TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject7, "toDouble", "", (String)localObject8), Name.identifier("doubleValue"));
    localObject8 = TuplesKt.to(REMOVE_AT_NAME_AND_SIGNATURE, Name.identifier("remove"));
    localObject2 = ((SignatureBuildingComponents)localObject2).javaLang("CharSequence");
    String str1 = JvmPrimitiveType.INT.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(str1, "JvmPrimitiveType.INT.desc");
    String str2 = JvmPrimitiveType.CHAR.getDesc();
    Intrinsics.checkExpressionValueIsNotNull(str2, "JvmPrimitiveType.CHAR.desc");
    NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = MapsKt.mapOf(new Pair[] { localObject1, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, TuplesKt.to(SpecialBuiltinMembers.access$method((String)localObject2, "get", str1, str2), Name.identifier("charAt")) });
    localObject2 = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
    localObject1 = (Map)new LinkedHashMap(MapsKt.mapCapacity(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Map)localObject1).put(((NameAndSignature)((Map.Entry)localObject3).getKey()).getSignature(), ((Map.Entry)localObject3).getValue());
    }
    SIGNATURE_TO_JVM_REPRESENTATION_NAME = (Map)localObject1;
    localObject2 = (Iterable)NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((NameAndSignature)((Iterator)localObject2).next()).getName());
    }
    ORIGINAL_SHORT_NAMES = (List)localObject1;
    localObject2 = (Iterable)NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      ((Collection)localObject1).add(new Pair(((NameAndSignature)((Map.Entry)localObject3).getKey()).getName(), ((Map.Entry)localObject3).getValue()));
    }
    localObject1 = (Iterable)localObject1;
    localObject3 = (Map)new LinkedHashMap();
    localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (Pair)((Iterator)localObject4).next();
      localObject6 = (Name)((Pair)localObject5).getSecond();
      localObject2 = ((Map)localObject3).get(localObject6);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        ((Map)localObject3).put(localObject6, localObject1);
      }
      ((List)localObject1).add((Name)((Pair)localObject5).getFirst());
    }
    JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = (Map)localObject3;
  }
  
  @NotNull
  public final List<Name> getBuiltinFunctionNamesByJvmName(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    paramName = (List)JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP.get(paramName);
    if (paramName != null) {
      return paramName;
    }
    return CollectionsKt.emptyList();
  }
  
  @Nullable
  public final Name getJvmName(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleFunctionDescriptor, "functionDescriptor");
    Map localMap = SIGNATURE_TO_JVM_REPRESENTATION_NAME;
    paramSimpleFunctionDescriptor = MethodSignatureMappingKt.computeJvmSignature((CallableDescriptor)paramSimpleFunctionDescriptor);
    if (paramSimpleFunctionDescriptor != null) {
      return (Name)localMap.get(paramSimpleFunctionDescriptor);
    }
    return null;
  }
  
  @NotNull
  public final List<Name> getORIGINAL_SHORT_NAMES()
  {
    return ORIGINAL_SHORT_NAMES;
  }
  
  public final boolean getSameAsRenamedInJvmBuiltin(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "$this$sameAsRenamedInJvmBuiltin");
    return ORIGINAL_SHORT_NAMES.contains(paramName);
  }
  
  public final boolean isBuiltinFunctionWithDifferentNameInJvm(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleFunctionDescriptor, "functionDescriptor");
    return (KotlinBuiltIns.isBuiltIn((DeclarationDescriptor)paramSimpleFunctionDescriptor)) && (DescriptorUtilsKt.firstOverridden$default((CallableMemberDescriptor)paramSimpleFunctionDescriptor, false, (Function1)new BuiltinMethodsWithDifferentJvmName.isBuiltinFunctionWithDifferentNameInJvm.1(paramSimpleFunctionDescriptor), 1, null) != null);
  }
  
  public final boolean isRemoveAtByIndex(@NotNull SimpleFunctionDescriptor paramSimpleFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleFunctionDescriptor, "$this$isRemoveAtByIndex");
    return (Intrinsics.areEqual(paramSimpleFunctionDescriptor.getName().asString(), "removeAt")) && (Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmSignature((CallableDescriptor)paramSimpleFunctionDescriptor), REMOVE_AT_NAME_AND_SIGNATURE.getSignature()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName
 * JD-Core Version:    0.7.0.1
 */