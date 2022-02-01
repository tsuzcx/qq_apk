package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import org.jetbrains.annotations.NotNull;

final class LazyJavaPackageFragment$binaryClasses$2
  extends Lambda
  implements Function0<Map<String, ? extends KotlinJvmBinaryClass>>
{
  LazyJavaPackageFragment$binaryClasses$2(LazyJavaPackageFragment paramLazyJavaPackageFragment)
  {
    super(0);
  }
  
  @NotNull
  public final Map<String, KotlinJvmBinaryClass> invoke()
  {
    Object localObject1 = LazyJavaPackageFragment.access$getC$p(this.this$0).getComponents().getPackagePartProvider();
    Object localObject2 = this.this$0.getFqName().asString();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "fqName.asString()");
    localObject1 = (Iterable)((PackagePartProvider)localObject1).findPackageParts((String)localObject2);
    localObject2 = (Collection)new ArrayList();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      Object localObject3 = JvmClassName.byInternalName((String)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "JvmClassName.byInternalName(partName)");
      localObject3 = ClassId.topLevel(((JvmClassName)localObject3).getFqNameForTopLevelClassMaybeWithDollars());
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "ClassId.topLevel(JvmClas…velClassMaybeWithDollars)");
      localObject3 = KotlinClassFinderKt.findKotlinClass(LazyJavaPackageFragment.access$getC$p(this.this$0).getComponents().getKotlinClassFinder(), (ClassId)localObject3);
      if (localObject3 != null) {
        localObject1 = TuplesKt.to(localObject1, localObject3);
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        ((Collection)localObject2).add(localObject1);
      }
    }
    return MapsKt.toMap((Iterable)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaPackageFragment.binaryClasses.2
 * JD-Core Version:    0.7.0.1
 */