package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorUtilKt
{
  @Nullable
  public static final ClassDescriptor resolveClassByFqName(@NotNull ModuleDescriptor paramModuleDescriptor, @NotNull FqName paramFqName, @NotNull LookupLocation paramLookupLocation)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "$this$resolveClassByFqName");
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "lookupLocation");
    if (paramFqName.isRoot()) {
      return null;
    }
    Object localObject1 = paramFqName.parent();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "fqName.parent()");
    localObject1 = paramModuleDescriptor.getPackage((FqName)localObject1).getMemberScope();
    Object localObject2 = paramFqName.shortName();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "fqName.shortName()");
    localObject2 = ((MemberScope)localObject1).getContributedClassifier((Name)localObject2, paramLookupLocation);
    localObject1 = localObject2;
    if (!(localObject2 instanceof ClassDescriptor)) {
      localObject1 = null;
    }
    localObject1 = (ClassDescriptor)localObject1;
    if (localObject1 != null) {
      return localObject1;
    }
    localObject1 = paramFqName.parent();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "fqName.parent()");
    paramModuleDescriptor = resolveClassByFqName(paramModuleDescriptor, (FqName)localObject1, paramLookupLocation);
    if (paramModuleDescriptor != null)
    {
      paramModuleDescriptor = paramModuleDescriptor.getUnsubstitutedInnerClassesScope();
      if (paramModuleDescriptor != null)
      {
        paramFqName = paramFqName.shortName();
        Intrinsics.checkExpressionValueIsNotNull(paramFqName, "fqName.shortName()");
        paramModuleDescriptor = paramModuleDescriptor.getContributedClassifier(paramFqName, paramLookupLocation);
        break label157;
      }
    }
    paramModuleDescriptor = null;
    label157:
    paramFqName = paramModuleDescriptor;
    if (!(paramModuleDescriptor instanceof ClassDescriptor)) {
      paramFqName = null;
    }
    return (ClassDescriptor)paramFqName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.DescriptorUtilKt
 * JD-Core Version:    0.7.0.1
 */