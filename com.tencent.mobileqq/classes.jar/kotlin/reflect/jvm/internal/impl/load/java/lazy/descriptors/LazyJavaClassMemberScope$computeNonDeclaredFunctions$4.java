package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

final class LazyJavaClassMemberScope$computeNonDeclaredFunctions$4
  extends FunctionReference
  implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>>
{
  LazyJavaClassMemberScope$computeNonDeclaredFunctions$4(LazyJavaClassMemberScope arg1) {}
  
  public final String getName() {}
  
  public final KDeclarationContainer getOwner() {}
  
  public final String getSignature() {}
  
  @NotNull
  public final Collection<SimpleFunctionDescriptor> invoke(@NotNull Name arg1) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope.computeNonDeclaredFunctions.4
 * JD-Core Version:    0.7.0.1
 */