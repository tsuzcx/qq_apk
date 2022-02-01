package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS.AbstractNodeHandler;
import org.jetbrains.annotations.NotNull;

public final class LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2
  extends DFS.AbstractNodeHandler<ClassDescriptor, Unit>
{
  LazyJavaStaticClassScope$flatMapJavaStaticSupertypesScopes$2(ClassDescriptor paramClassDescriptor, Set paramSet, Function1 paramFunction1) {}
  
  public boolean beforeChildren(@NotNull ClassDescriptor paramClassDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "current");
    if (paramClassDescriptor == this.$root) {
      return true;
    }
    paramClassDescriptor = paramClassDescriptor.getStaticScope();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "current.staticScope");
    if ((paramClassDescriptor instanceof LazyJavaStaticScope))
    {
      this.$result.addAll((Collection)this.$onJavaStaticScope.invoke(paramClassDescriptor));
      return false;
    }
    return true;
  }
  
  public void result() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.flatMapJavaStaticSupertypesScopes.2
 * JD-Core Version:    0.7.0.1
 */