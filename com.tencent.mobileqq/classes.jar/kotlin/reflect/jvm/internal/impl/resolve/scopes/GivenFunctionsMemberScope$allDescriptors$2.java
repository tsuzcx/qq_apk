package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;

final class GivenFunctionsMemberScope$allDescriptors$2
  extends Lambda
  implements Function0<List<? extends DeclarationDescriptor>>
{
  GivenFunctionsMemberScope$allDescriptors$2(GivenFunctionsMemberScope paramGivenFunctionsMemberScope)
  {
    super(0);
  }
  
  @NotNull
  public final List<DeclarationDescriptor> invoke()
  {
    List localList = this.this$0.computeDeclaredFunctions();
    return CollectionsKt.plus((Collection)localList, (Iterable)GivenFunctionsMemberScope.access$createFakeOverrides(this.this$0, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope.allDescriptors.2
 * JD-Core Version:    0.7.0.1
 */