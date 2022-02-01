package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class DescriptorUtilsKt$parentsWithSelf$1
  extends Lambda
  implements Function1<DeclarationDescriptor, DeclarationDescriptor>
{
  public static final 1 INSTANCE = new 1();
  
  DescriptorUtilsKt$parentsWithSelf$1()
  {
    super(1);
  }
  
  @Nullable
  public final DeclarationDescriptor invoke(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "it");
    return paramDeclarationDescriptor.getContainingDeclaration();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.parentsWithSelf.1
 * JD-Core Version:    0.7.0.1
 */