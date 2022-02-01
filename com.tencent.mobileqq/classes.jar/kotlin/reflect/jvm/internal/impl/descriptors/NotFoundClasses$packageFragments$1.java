package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

final class NotFoundClasses$packageFragments$1
  extends Lambda
  implements Function1<FqName, EmptyPackageFragmentDescriptor>
{
  NotFoundClasses$packageFragments$1(NotFoundClasses paramNotFoundClasses)
  {
    super(1);
  }
  
  @NotNull
  public final EmptyPackageFragmentDescriptor invoke(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    return new EmptyPackageFragmentDescriptor(NotFoundClasses.access$getModule$p(this.this$0), paramFqName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.packageFragments.1
 * JD-Core Version:    0.7.0.1
 */