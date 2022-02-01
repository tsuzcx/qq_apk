package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"}, k=3, mv={1, 1, 16})
final class KFunctionImpl$descriptor$2
  extends Lambda
  implements Function0<FunctionDescriptor>
{
  KFunctionImpl$descriptor$2(KFunctionImpl paramKFunctionImpl, String paramString)
  {
    super(0);
  }
  
  @NotNull
  public final FunctionDescriptor invoke()
  {
    return this.this$0.getContainer().findFunctionDescriptor(this.$name, KFunctionImpl.access$getSignature$p(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KFunctionImpl.descriptor.2
 * JD-Core Version:    0.7.0.1
 */