package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class CompanionObjectMapping
{
  public static final CompanionObjectMapping INSTANCE = new CompanionObjectMapping();
  private static final LinkedHashSet<ClassId> classIds;
  
  static
  {
    Object localObject1 = PrimitiveType.NUMBER_TYPES;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "PrimitiveType.NUMBER_TYPES");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(KotlinBuiltIns.getPrimitiveFqName((PrimitiveType)((Iterator)localObject2).next()));
    }
    localObject2 = (Iterable)CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)CollectionsKt.plus((Collection)localObject1, KotlinBuiltIns.FQ_NAMES.string.toSafe()), KotlinBuiltIns.FQ_NAMES._boolean.toSafe()), KotlinBuiltIns.FQ_NAMES._enum.toSafe());
    localObject1 = (Collection)new LinkedHashSet();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(ClassId.topLevel((FqName)((Iterator)localObject2).next()));
    }
    classIds = (LinkedHashSet)localObject1;
  }
  
  @NotNull
  public final Set<ClassId> allClassesWithIntrinsicCompanions()
  {
    Set localSet = Collections.unmodifiableSet((Set)classIds);
    Intrinsics.checkExpressionValueIsNotNull(localSet, "Collections.unmodifiableSet(classIds)");
    return localSet;
  }
  
  public final boolean isMappedIntrinsicCompanionObject(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "classDescriptor");
    if (DescriptorUtils.isCompanionObject((DeclarationDescriptor)paramClassDescriptor))
    {
      Iterable localIterable = (Iterable)classIds;
      paramClassDescriptor = DescriptorUtilsKt.getClassId((ClassifierDescriptor)paramClassDescriptor);
      if (paramClassDescriptor != null) {
        paramClassDescriptor = paramClassDescriptor.getOuterClassId();
      } else {
        paramClassDescriptor = null;
      }
      if (CollectionsKt.contains(localIterable, paramClassDescriptor)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping
 * JD-Core Version:    0.7.0.1
 */