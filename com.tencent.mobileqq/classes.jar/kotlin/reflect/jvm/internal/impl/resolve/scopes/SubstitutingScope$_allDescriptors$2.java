package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;

final class SubstitutingScope$_allDescriptors$2
  extends Lambda
  implements Function0<Collection<? extends DeclarationDescriptor>>
{
  SubstitutingScope$_allDescriptors$2(SubstitutingScope paramSubstitutingScope)
  {
    super(0);
  }
  
  @NotNull
  public final Collection<DeclarationDescriptor> invoke()
  {
    SubstitutingScope localSubstitutingScope = this.this$0;
    return SubstitutingScope.access$substitute(localSubstitutingScope, ResolutionScope.DefaultImpls.getContributedDescriptors$default(SubstitutingScope.access$getWorkerScope$p(localSubstitutingScope), null, null, 3, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope._allDescriptors.2
 * JD-Core Version:    0.7.0.1
 */