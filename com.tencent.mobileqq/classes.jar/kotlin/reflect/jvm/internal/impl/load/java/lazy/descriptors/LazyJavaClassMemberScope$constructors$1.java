package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import org.jetbrains.annotations.NotNull;

final class LazyJavaClassMemberScope$constructors$1
  extends Lambda
  implements Function0<List<? extends ClassConstructorDescriptor>>
{
  LazyJavaClassMemberScope$constructors$1(LazyJavaClassMemberScope paramLazyJavaClassMemberScope, LazyJavaResolverContext paramLazyJavaResolverContext)
  {
    super(0);
  }
  
  @NotNull
  public final List<ClassConstructorDescriptor> invoke()
  {
    Object localObject2 = LazyJavaClassMemberScope.access$getJClass$p(this.this$0).getConstructors();
    Object localObject1 = new ArrayList(((Collection)localObject2).size());
    localObject2 = ((Collection)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (JavaConstructor)((Iterator)localObject2).next();
      ((ArrayList)localObject1).add(LazyJavaClassMemberScope.access$resolveConstructor(this.this$0, (JavaConstructor)localObject3));
    }
    Object localObject3 = this.$c.getComponents().getSignatureEnhancement();
    LazyJavaResolverContext localLazyJavaResolverContext = this.$c;
    localObject2 = (Collection)localObject1;
    localObject1 = localObject2;
    if (((Collection)localObject2).isEmpty()) {
      localObject1 = (Collection)CollectionsKt.listOfNotNull(LazyJavaClassMemberScope.access$createDefaultConstructor(this.this$0));
    }
    return CollectionsKt.toList((Iterable)((SignatureEnhancement)localObject3).enhanceSignatures(localLazyJavaResolverContext, (Collection)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.constructors.1
 * JD-Core Version:    0.7.0.1
 */