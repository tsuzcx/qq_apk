package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import org.jetbrains.annotations.NotNull;

final class StaticScopeForKotlinEnum$functions$2
  extends Lambda
  implements Function0<List<? extends SimpleFunctionDescriptor>>
{
  StaticScopeForKotlinEnum$functions$2(StaticScopeForKotlinEnum paramStaticScopeForKotlinEnum)
  {
    super(0);
  }
  
  @NotNull
  public final List<SimpleFunctionDescriptor> invoke()
  {
    return CollectionsKt.listOf(new SimpleFunctionDescriptor[] { DescriptorFactory.createEnumValueOfMethod(StaticScopeForKotlinEnum.access$getContainingClass$p(this.this$0)), DescriptorFactory.createEnumValuesMethod(StaticScopeForKotlinEnum.access$getContainingClass$p(this.this$0)) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.StaticScopeForKotlinEnum.functions.2
 * JD-Core Version:    0.7.0.1
 */