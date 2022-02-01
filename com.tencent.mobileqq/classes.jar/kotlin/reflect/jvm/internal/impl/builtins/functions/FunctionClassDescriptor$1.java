package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

final class FunctionClassDescriptor$1
  extends Lambda
  implements Function2<Variance, String, Unit>
{
  FunctionClassDescriptor$1(FunctionClassDescriptor paramFunctionClassDescriptor, ArrayList paramArrayList)
  {
    super(2);
  }
  
  public final void invoke(@NotNull Variance paramVariance, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVariance, "variance");
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    this.$result.add(TypeParameterDescriptorImpl.createWithDefaultBound((DeclarationDescriptor)this.this$0, Annotations.Companion.getEMPTY(), false, paramVariance, Name.identifier(paramString), this.$result.size(), FunctionClassDescriptor.access$getStorageManager$p(this.this$0)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.1
 * JD-Core Version:    0.7.0.1
 */