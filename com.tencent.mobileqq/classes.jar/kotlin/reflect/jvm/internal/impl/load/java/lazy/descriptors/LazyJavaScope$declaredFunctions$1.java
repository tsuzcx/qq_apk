package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;

final class LazyJavaScope$declaredFunctions$1
  extends Lambda
  implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>>
{
  LazyJavaScope$declaredFunctions$1(LazyJavaScope paramLazyJavaScope)
  {
    super(1);
  }
  
  @NotNull
  public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    if (this.this$0.getMainScope() != null) {
      return (Collection)LazyJavaScope.access$getDeclaredFunctions$p(this.this$0.getMainScope()).invoke(paramName);
    }
    List localList = (List)new ArrayList();
    paramName = ((DeclaredMemberIndex)this.this$0.getDeclaredMemberIndex().invoke()).findMethodsByName(paramName).iterator();
    while (paramName.hasNext())
    {
      JavaMethod localJavaMethod = (JavaMethod)paramName.next();
      JavaMethodDescriptor localJavaMethodDescriptor = this.this$0.resolveMethodToFunctionDescriptor(localJavaMethod);
      if (this.this$0.isVisibleAsFunction(localJavaMethodDescriptor))
      {
        this.this$0.getC().getComponents().getJavaResolverCache().recordMethod(localJavaMethod, (SimpleFunctionDescriptor)localJavaMethodDescriptor);
        localList.add(localJavaMethodDescriptor);
      }
    }
    return (Collection)localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.declaredFunctions.1
 * JD-Core Version:    0.7.0.1
 */