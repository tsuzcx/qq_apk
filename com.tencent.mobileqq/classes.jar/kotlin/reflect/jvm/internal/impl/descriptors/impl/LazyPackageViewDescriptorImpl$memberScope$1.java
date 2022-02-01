package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import org.jetbrains.annotations.NotNull;

final class LazyPackageViewDescriptorImpl$memberScope$1
  extends Lambda
  implements Function0<MemberScope>
{
  LazyPackageViewDescriptorImpl$memberScope$1(LazyPackageViewDescriptorImpl paramLazyPackageViewDescriptorImpl)
  {
    super(0);
  }
  
  @NotNull
  public final MemberScope invoke()
  {
    if (this.this$0.getFragments().isEmpty()) {
      return (MemberScope)MemberScope.Empty.INSTANCE;
    }
    Object localObject2 = (Iterable)this.this$0.getFragments();
    Object localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((PackageFragmentDescriptor)((Iterator)localObject2).next()).getMemberScope());
    }
    localObject1 = CollectionsKt.plus((Collection)localObject1, new SubpackagesScope((ModuleDescriptor)this.this$0.getModule(), this.this$0.getFqName()));
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("package view scope for ");
    ((StringBuilder)localObject2).append(this.this$0.getFqName());
    ((StringBuilder)localObject2).append(" in ");
    ((StringBuilder)localObject2).append(this.this$0.getModule().getName());
    return (MemberScope)new ChainedMemberScope(((StringBuilder)localObject2).toString(), (List)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.LazyPackageViewDescriptorImpl.memberScope.1
 * JD-Core Version:    0.7.0.1
 */