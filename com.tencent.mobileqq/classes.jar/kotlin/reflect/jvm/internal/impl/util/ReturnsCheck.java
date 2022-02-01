package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class ReturnsCheck
  implements Check
{
  @NotNull
  private final String description;
  @NotNull
  private final String name;
  @NotNull
  private final Function1<KotlinBuiltIns, KotlinType> type;
  
  private ReturnsCheck(String paramString, Function1<? super KotlinBuiltIns, ? extends KotlinType> paramFunction1)
  {
    this.name = paramString;
    this.type = paramFunction1;
    paramString = new StringBuilder();
    paramString.append("must return ");
    paramString.append(this.name);
    this.description = paramString.toString();
  }
  
  public boolean check(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    return Intrinsics.areEqual(paramFunctionDescriptor.getReturnType(), (KotlinType)this.type.invoke(DescriptorUtilsKt.getBuiltIns((DeclarationDescriptor)paramFunctionDescriptor)));
  }
  
  @NotNull
  public String getDescription()
  {
    return this.description;
  }
  
  @Nullable
  public String invoke(@NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "functionDescriptor");
    return Check.DefaultImpls.invoke(this, paramFunctionDescriptor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.ReturnsCheck
 * JD-Core Version:    0.7.0.1
 */