package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import org.jetbrains.annotations.NotNull;

final class LazyPackageViewDescriptorImpl$fragments$2
  extends Lambda
  implements Function0<List<? extends PackageFragmentDescriptor>>
{
  LazyPackageViewDescriptorImpl$fragments$2(LazyPackageViewDescriptorImpl paramLazyPackageViewDescriptorImpl)
  {
    super(0);
  }
  
  @NotNull
  public final List<PackageFragmentDescriptor> invoke()
  {
    return this.this$0.getModule().getPackageFragmentProvider().getPackageFragments(this.this$0.getFqName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl.fragments.2
 * JD-Core Version:    0.7.0.1
 */