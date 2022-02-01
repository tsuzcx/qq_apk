package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

final class LazyJavaPackageFragment$subPackages$1
  extends Lambda
  implements Function0<List<? extends FqName>>
{
  LazyJavaPackageFragment$subPackages$1(LazyJavaPackageFragment paramLazyJavaPackageFragment)
  {
    super(0);
  }
  
  @NotNull
  public final List<FqName> invoke()
  {
    Object localObject = (Iterable)LazyJavaPackageFragment.access$getJPackage$p(this.this$0).getSubPackages();
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((JavaPackage)((Iterator)localObject).next()).getFqName());
    }
    return (List)localCollection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment.subPackages.1
 * JD-Core Version:    0.7.0.1
 */