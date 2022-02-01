package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import org.jetbrains.annotations.NotNull;

final class LazyJavaScope$functions$1
  extends Lambda
  implements Function1<Name, List<? extends SimpleFunctionDescriptor>>
{
  LazyJavaScope$functions$1(LazyJavaScope paramLazyJavaScope)
  {
    super(1);
  }
  
  @NotNull
  public final List<SimpleFunctionDescriptor> invoke(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    Collection localCollection = (Collection)new LinkedHashSet((Collection)LazyJavaScope.access$getDeclaredFunctions$p(this.this$0).invoke(paramName));
    OverridingUtilsKt.retainMostSpecificInEachOverridableGroup(localCollection);
    this.this$0.computeNonDeclaredFunctions(localCollection, paramName);
    return CollectionsKt.toList((Iterable)this.this$0.getC().getComponents().getSignatureEnhancement().enhanceSignatures(this.this$0.getC(), localCollection));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.functions.1
 * JD-Core Version:    0.7.0.1
 */