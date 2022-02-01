package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class CompositePackageFragmentProvider
  implements PackageFragmentProvider
{
  private final List<PackageFragmentProvider> providers;
  
  public CompositePackageFragmentProvider(@NotNull List<? extends PackageFragmentProvider> paramList)
  {
    this.providers = paramList;
  }
  
  @NotNull
  public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.providers.iterator();
    while (localIterator.hasNext()) {
      localArrayList.addAll((Collection)((PackageFragmentProvider)localIterator.next()).getPackageFragments(paramFqName));
    }
    return CollectionsKt.toList((Iterable)localArrayList);
  }
  
  @NotNull
  public Collection<FqName> getSubPackagesOf(@NotNull FqName paramFqName, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.providers.iterator();
    while (localIterator.hasNext()) {
      localHashSet.addAll(((PackageFragmentProvider)localIterator.next()).getSubPackagesOf(paramFqName, paramFunction1));
    }
    return (Collection)localHashSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider
 * JD-Core Version:    0.7.0.1
 */