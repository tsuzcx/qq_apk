package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Companion;
import org.jetbrains.annotations.NotNull;

final class LazyJavaScope$allDescriptors$1
  extends Lambda
  implements Function0<List<? extends DeclarationDescriptor>>
{
  LazyJavaScope$allDescriptors$1(LazyJavaScope paramLazyJavaScope)
  {
    super(0);
  }
  
  @NotNull
  public final List<DeclarationDescriptor> invoke()
  {
    return this.this$0.computeDescriptors(DescriptorKindFilter.ALL, MemberScope.Companion.getALL_NAME_FILTER());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.allDescriptors.1
 * JD-Core Version:    0.7.0.1
 */