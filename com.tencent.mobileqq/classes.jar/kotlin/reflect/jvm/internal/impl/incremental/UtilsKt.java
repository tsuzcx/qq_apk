package kotlin.reflect.jvm.internal.impl.incremental;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position;
import kotlin.reflect.jvm.internal.impl.incremental.components.Position.Companion;
import kotlin.reflect.jvm.internal.impl.incremental.components.ScopeKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import org.jetbrains.annotations.NotNull;

public final class UtilsKt
{
  public static final void record(@NotNull LookupTracker paramLookupTracker, @NotNull LookupLocation paramLookupLocation, @NotNull ClassDescriptor paramClassDescriptor, @NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramLookupTracker, "$this$record");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "from");
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "scopeOwner");
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    if (paramLookupTracker == LookupTracker.DO_NOTHING.INSTANCE) {
      return;
    }
    Object localObject = paramLookupLocation.getLocation();
    if (localObject != null)
    {
      if (paramLookupTracker.getRequiresPosition()) {
        paramLookupLocation = ((LocationInfo)localObject).getPosition();
      } else {
        paramLookupLocation = Position.Companion.getNO_POSITION();
      }
      localObject = ((LocationInfo)localObject).getFilePath();
      paramClassDescriptor = DescriptorUtils.getFqName((DeclarationDescriptor)paramClassDescriptor).asString();
      Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "DescriptorUtils.getFqName(scopeOwner).asString()");
      ScopeKind localScopeKind = ScopeKind.CLASSIFIER;
      paramName = paramName.asString();
      Intrinsics.checkExpressionValueIsNotNull(paramName, "name.asString()");
      paramLookupTracker.record((String)localObject, paramLookupLocation, paramClassDescriptor, localScopeKind, paramName);
    }
  }
  
  public static final void record(@NotNull LookupTracker paramLookupTracker, @NotNull LookupLocation paramLookupLocation, @NotNull PackageFragmentDescriptor paramPackageFragmentDescriptor, @NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramLookupTracker, "$this$record");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "from");
    Intrinsics.checkParameterIsNotNull(paramPackageFragmentDescriptor, "scopeOwner");
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    paramPackageFragmentDescriptor = paramPackageFragmentDescriptor.getFqName().asString();
    Intrinsics.checkExpressionValueIsNotNull(paramPackageFragmentDescriptor, "scopeOwner.fqName.asString()");
    paramName = paramName.asString();
    Intrinsics.checkExpressionValueIsNotNull(paramName, "name.asString()");
    recordPackageLookup(paramLookupTracker, paramLookupLocation, paramPackageFragmentDescriptor, paramName);
  }
  
  public static final void recordPackageLookup(@NotNull LookupTracker paramLookupTracker, @NotNull LookupLocation paramLookupLocation, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramLookupTracker, "$this$recordPackageLookup");
    Intrinsics.checkParameterIsNotNull(paramLookupLocation, "from");
    Intrinsics.checkParameterIsNotNull(paramString1, "packageFqName");
    Intrinsics.checkParameterIsNotNull(paramString2, "name");
    if (paramLookupTracker == LookupTracker.DO_NOTHING.INSTANCE) {
      return;
    }
    LocationInfo localLocationInfo = paramLookupLocation.getLocation();
    if (localLocationInfo != null)
    {
      if (paramLookupTracker.getRequiresPosition()) {
        paramLookupLocation = localLocationInfo.getPosition();
      } else {
        paramLookupLocation = Position.Companion.getNO_POSITION();
      }
      paramLookupTracker.record(localLocationInfo.getFilePath(), paramLookupLocation, paramString1, ScopeKind.PACKAGE, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.incremental.UtilsKt
 * JD-Core Version:    0.7.0.1
 */