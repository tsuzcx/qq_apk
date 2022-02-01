package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import org.jetbrains.annotations.NotNull;

final class LazyJavaScope$properties$1
  extends Lambda
  implements Function1<Name, List<? extends PropertyDescriptor>>
{
  LazyJavaScope$properties$1(LazyJavaScope paramLazyJavaScope)
  {
    super(1);
  }
  
  @NotNull
  public final List<PropertyDescriptor> invoke(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    ArrayList localArrayList = new ArrayList();
    Collection localCollection = (Collection)localArrayList;
    kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(localCollection, LazyJavaScope.access$getDeclaredField$p(this.this$0).invoke(paramName));
    this.this$0.computeNonDeclaredProperties(paramName, localCollection);
    if (DescriptorUtils.isAnnotationClass(this.this$0.getOwnerDescriptor())) {
      return kotlin.collections.CollectionsKt.toList((Iterable)localArrayList);
    }
    return kotlin.collections.CollectionsKt.toList((Iterable)this.this$0.getC().getComponents().getSignatureEnhancement().enhanceSignatures(this.this$0.getC(), localCollection));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.properties.1
 * JD-Core Version:    0.7.0.1
 */