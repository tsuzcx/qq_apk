package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class AbstractDeserializedPackageFragmentProvider$fragments$1
  extends Lambda
  implements Function1<FqName, DeserializedPackageFragment>
{
  AbstractDeserializedPackageFragmentProvider$fragments$1(AbstractDeserializedPackageFragmentProvider paramAbstractDeserializedPackageFragmentProvider)
  {
    super(1);
  }
  
  @Nullable
  public final DeserializedPackageFragment invoke(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    paramFqName = this.this$0.findPackage(paramFqName);
    if (paramFqName != null)
    {
      paramFqName.initialize(this.this$0.getComponents());
      return paramFqName;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider.fragments.1
 * JD-Core Version:    0.7.0.1
 */