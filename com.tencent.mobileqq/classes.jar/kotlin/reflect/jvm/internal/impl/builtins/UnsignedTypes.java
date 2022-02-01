package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UnsignedTypes
{
  public static final UnsignedTypes INSTANCE = new UnsignedTypes();
  private static final HashMap<ClassId, ClassId> arrayClassIdToUnsignedClassId;
  private static final Set<Name> arrayClassesShortNames;
  private static final HashMap<ClassId, ClassId> unsignedClassIdToArrayClassId;
  private static final Set<Name> unsignedTypeNames;
  
  static
  {
    UnsignedType[] arrayOfUnsignedType = UnsignedType.values();
    Object localObject = (Collection)new ArrayList(arrayOfUnsignedType.length);
    int k = arrayOfUnsignedType.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfUnsignedType[i].getTypeName());
      i += 1;
    }
    unsignedTypeNames = CollectionsKt.toSet((Iterable)localObject);
    arrayClassIdToUnsignedClassId = new HashMap();
    unsignedClassIdToArrayClassId = new HashMap();
    arrayOfUnsignedType = UnsignedType.values();
    localObject = (Collection)new LinkedHashSet();
    k = arrayOfUnsignedType.length;
    i = 0;
    while (i < k)
    {
      ((Collection)localObject).add(arrayOfUnsignedType[i].getArrayClassId().getShortClassName());
      i += 1;
    }
    arrayClassesShortNames = (Set)localObject;
    arrayOfUnsignedType = UnsignedType.values();
    k = arrayOfUnsignedType.length;
    i = j;
    while (i < k)
    {
      localObject = arrayOfUnsignedType[i];
      ((Map)arrayClassIdToUnsignedClassId).put(((UnsignedType)localObject).getArrayClassId(), ((UnsignedType)localObject).getClassId());
      ((Map)unsignedClassIdToArrayClassId).put(((UnsignedType)localObject).getClassId(), ((UnsignedType)localObject).getArrayClassId());
      i += 1;
    }
  }
  
  @Nullable
  public final ClassId getUnsignedClassIdByArrayClassId(@NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "arrayClassId");
    return (ClassId)arrayClassIdToUnsignedClassId.get(paramClassId);
  }
  
  public final boolean isShortNameOfUnsignedArray(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    return arrayClassesShortNames.contains(paramName);
  }
  
  public final boolean isUnsignedClass(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "descriptor");
    DeclarationDescriptor localDeclarationDescriptor = paramDeclarationDescriptor.getContainingDeclaration();
    return ((localDeclarationDescriptor instanceof PackageFragmentDescriptor)) && (Intrinsics.areEqual(((PackageFragmentDescriptor)localDeclarationDescriptor).getFqName(), KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME)) && (unsignedTypeNames.contains(paramDeclarationDescriptor.getName()));
  }
  
  public final boolean isUnsignedType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    if (TypeUtils.noExpectedType(paramKotlinType)) {
      return false;
    }
    paramKotlinType = paramKotlinType.getConstructor().getDeclarationDescriptor();
    if (paramKotlinType != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "type.constructor.declara…escriptor ?: return false");
      return isUnsignedClass((DeclarationDescriptor)paramKotlinType);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes
 * JD-Core Version:    0.7.0.1
 */