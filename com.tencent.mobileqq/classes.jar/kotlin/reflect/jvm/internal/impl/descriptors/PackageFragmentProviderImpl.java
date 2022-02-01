package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

public final class PackageFragmentProviderImpl
  implements PackageFragmentProvider
{
  private final Collection<PackageFragmentDescriptor> packageFragments;
  
  public PackageFragmentProviderImpl(@NotNull Collection<? extends PackageFragmentDescriptor> paramCollection)
  {
    this.packageFragments = paramCollection;
  }
  
  @NotNull
  public List<PackageFragmentDescriptor> getPackageFragments(@NotNull FqName paramFqName)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Object localObject1 = (Iterable)this.packageFragments;
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (Intrinsics.areEqual(((PackageFragmentDescriptor)localObject2).getFqName(), paramFqName)) {
        localCollection.add(localObject2);
      }
    }
    return (List)localCollection;
  }
  
  @NotNull
  public Collection<FqName> getSubPackagesOf(@NotNull FqName paramFqName, @NotNull Function1<? super Name, Boolean> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "fqName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "nameFilter");
    return (Collection)SequencesKt.toList(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable)this.packageFragments), (Function1)PackageFragmentProviderImpl.getSubPackagesOf.1.INSTANCE), (Function1)new PackageFragmentProviderImpl.getSubPackagesOf.2(paramFqName)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderImpl
 * JD-Core Version:    0.7.0.1
 */