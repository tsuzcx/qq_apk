package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DeserializedClassDataFinder
  implements ClassDataFinder
{
  private final PackageFragmentProvider packageFragmentProvider;
  
  public DeserializedClassDataFinder(@NotNull PackageFragmentProvider paramPackageFragmentProvider)
  {
    this.packageFragmentProvider = paramPackageFragmentProvider;
  }
  
  @Nullable
  public ClassData findClassData(@NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    Object localObject1 = this.packageFragmentProvider;
    Object localObject2 = paramClassId.getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "classId.packageFqName");
    localObject1 = ((PackageFragmentProvider)localObject1).getPackageFragments((FqName)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (PackageFragmentDescriptor)((Iterator)localObject1).next();
      if ((localObject2 instanceof DeserializedPackageFragment))
      {
        localObject2 = ((DeserializedPackageFragment)localObject2).getClassDataFinder().findClassData(paramClassId);
        if (localObject2 != null) {
          return localObject2;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder
 * JD-Core Version:    0.7.0.1
 */