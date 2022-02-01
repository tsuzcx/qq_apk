package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import org.jetbrains.annotations.NotNull;

final class JvmPackageScope$kotlinScopes$2
  extends Lambda
  implements Function0<List<? extends MemberScope>>
{
  JvmPackageScope$kotlinScopes$2(JvmPackageScope paramJvmPackageScope)
  {
    super(0);
  }
  
  @NotNull
  public final List<MemberScope> invoke()
  {
    Object localObject1 = (Iterable)JvmPackageScope.access$getPackageFragment$p(this.this$0).getBinaryClasses$descriptors_jvm().values();
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (KotlinJvmBinaryClass)((Iterator)localObject1).next();
      localObject2 = JvmPackageScope.access$getC$p(this.this$0).getComponents().getDeserializedDescriptorResolver().createKotlinPackagePartScope((PackageFragmentDescriptor)JvmPackageScope.access$getPackageFragment$p(this.this$0), (KotlinJvmBinaryClass)localObject2);
      if (localObject2 != null) {
        localCollection.add(localObject2);
      }
    }
    return CollectionsKt.toList((Iterable)localCollection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.JvmPackageScope.kotlinScopes.2
 * JD-Core Version:    0.7.0.1
 */