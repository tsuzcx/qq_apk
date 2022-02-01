package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "invoke"}, k=3, mv={1, 1, 16})
final class KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1
  extends Lambda
  implements Function1<FunctionDescriptor, String>
{
  public static final 1 INSTANCE = new 1();
  
  KDeclarationContainerImpl$findFunctionDescriptor$allMembers$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "descriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(DescriptorRenderer.DEBUG_TEXT.render((DeclarationDescriptor)paramFunctionDescriptor));
    localStringBuilder.append(" | ");
    localStringBuilder.append(RuntimeTypeMapper.INSTANCE.mapSignature(paramFunctionDescriptor).asString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KDeclarationContainerImpl.findFunctionDescriptor.allMembers.1
 * JD-Core Version:    0.7.0.1
 */