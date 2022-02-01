package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2
  extends Lambda
  implements Function0<CompositePackageFragmentProvider>
{
  ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(ModuleDescriptorImpl paramModuleDescriptorImpl)
  {
    super(0);
  }
  
  @NotNull
  public final CompositePackageFragmentProvider invoke()
  {
    Object localObject1 = ModuleDescriptorImpl.access$getDependencies$p(this.this$0);
    if (localObject1 != null)
    {
      localObject1 = ((ModuleDependencies)localObject1).getAllDependencies();
      boolean bool = ((List)localObject1).contains(this.this$0);
      if ((_Assertions.ENABLED) && (!bool))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Module ");
        ((StringBuilder)localObject1).append(ModuleDescriptorImpl.access$getId$p(this.this$0));
        ((StringBuilder)localObject1).append(" is not contained in his own dependencies, this is probably a misconfiguration");
        throw ((Throwable)new AssertionError(((StringBuilder)localObject1).toString()));
      }
      localObject1 = (Iterable)localObject1;
      Object localObject3 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (ModuleDescriptorImpl)((Iterator)localObject3).next();
        bool = ModuleDescriptorImpl.access$isInitialized$p((ModuleDescriptorImpl)localObject2);
        if ((_Assertions.ENABLED) && (!bool))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Dependency module ");
          ((StringBuilder)localObject1).append(ModuleDescriptorImpl.access$getId$p((ModuleDescriptorImpl)localObject2));
          ((StringBuilder)localObject1).append(" was not initialized by the time contents of dependent module ");
          ((StringBuilder)localObject1).append(ModuleDescriptorImpl.access$getId$p(this.this$0));
          ((StringBuilder)localObject1).append(" were queried");
          throw ((Throwable)new AssertionError(((StringBuilder)localObject1).toString()));
        }
      }
      Object localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = ModuleDescriptorImpl.access$getPackageFragmentProviderForModuleContent$p((ModuleDescriptorImpl)((Iterator)localObject1).next());
        if (localObject3 == null) {
          Intrinsics.throwNpe();
        }
        ((Collection)localObject2).add(localObject3);
      }
      return new CompositePackageFragmentProvider((List)localObject2);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Dependencies of module ");
    ((StringBuilder)localObject1).append(ModuleDescriptorImpl.access$getId$p(this.this$0));
    ((StringBuilder)localObject1).append(" were not set before querying module content");
    localObject1 = (Throwable)new AssertionError(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl.packageFragmentProviderForWholeModuleWithDependencies.2
 * JD-Core Version:    0.7.0.1
 */