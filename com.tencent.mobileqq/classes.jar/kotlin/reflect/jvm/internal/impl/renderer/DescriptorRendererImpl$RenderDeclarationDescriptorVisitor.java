package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;

final class DescriptorRendererImpl$RenderDeclarationDescriptorVisitor
  implements DeclarationDescriptorVisitor<Unit, StringBuilder>
{
  private final void visitPropertyAccessorDescriptor(PropertyAccessorDescriptor paramPropertyAccessorDescriptor, StringBuilder paramStringBuilder, String paramString)
  {
    Object localObject = this.this$0.getPropertyAccessorRenderingPolicy();
    int i = DescriptorRendererImpl.RenderDeclarationDescriptorVisitor.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      visitFunctionDescriptor((FunctionDescriptor)paramPropertyAccessorDescriptor, paramStringBuilder);
      return;
    }
    DescriptorRendererImpl.access$renderAccessorModifiers(this.this$0, paramPropertyAccessorDescriptor, paramStringBuilder);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" for ");
    paramStringBuilder.append(((StringBuilder)localObject).toString());
    paramString = this.this$0;
    paramPropertyAccessorDescriptor = paramPropertyAccessorDescriptor.getCorrespondingProperty();
    Intrinsics.checkExpressionValueIsNotNull(paramPropertyAccessorDescriptor, "descriptor.correspondingProperty");
    DescriptorRendererImpl.access$renderProperty(paramString, paramPropertyAccessorDescriptor, paramStringBuilder);
  }
  
  public void visitClassDescriptor(@NotNull ClassDescriptor paramClassDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    DescriptorRendererImpl.access$renderClass(this.this$0, paramClassDescriptor, paramStringBuilder);
  }
  
  public void visitConstructorDescriptor(@NotNull ConstructorDescriptor paramConstructorDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramConstructorDescriptor, "constructorDescriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    DescriptorRendererImpl.access$renderConstructor(this.this$0, paramConstructorDescriptor, paramStringBuilder);
  }
  
  public void visitFunctionDescriptor(@NotNull FunctionDescriptor paramFunctionDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramFunctionDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    DescriptorRendererImpl.access$renderFunction(this.this$0, paramFunctionDescriptor, paramStringBuilder);
  }
  
  public void visitModuleDeclaration(@NotNull ModuleDescriptor paramModuleDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramModuleDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    DescriptorRendererImpl.access$renderName(this.this$0, (DeclarationDescriptor)paramModuleDescriptor, paramStringBuilder, true);
  }
  
  public void visitPackageFragmentDescriptor(@NotNull PackageFragmentDescriptor paramPackageFragmentDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramPackageFragmentDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    DescriptorRendererImpl.access$renderPackageFragment(this.this$0, paramPackageFragmentDescriptor, paramStringBuilder);
  }
  
  public void visitPackageViewDescriptor(@NotNull PackageViewDescriptor paramPackageViewDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramPackageViewDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    DescriptorRendererImpl.access$renderPackageView(this.this$0, paramPackageViewDescriptor, paramStringBuilder);
  }
  
  public void visitPropertyDescriptor(@NotNull PropertyDescriptor paramPropertyDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramPropertyDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    DescriptorRendererImpl.access$renderProperty(this.this$0, paramPropertyDescriptor, paramStringBuilder);
  }
  
  public void visitPropertyGetterDescriptor(@NotNull PropertyGetterDescriptor paramPropertyGetterDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramPropertyGetterDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    visitPropertyAccessorDescriptor((PropertyAccessorDescriptor)paramPropertyGetterDescriptor, paramStringBuilder, "getter");
  }
  
  public void visitPropertySetterDescriptor(@NotNull PropertySetterDescriptor paramPropertySetterDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramPropertySetterDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    visitPropertyAccessorDescriptor((PropertyAccessorDescriptor)paramPropertySetterDescriptor, paramStringBuilder, "setter");
  }
  
  public void visitReceiverParameterDescriptor(@NotNull ReceiverParameterDescriptor paramReceiverParameterDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramReceiverParameterDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    paramStringBuilder.append(paramReceiverParameterDescriptor.getName());
  }
  
  public void visitTypeAliasDescriptor(@NotNull TypeAliasDescriptor paramTypeAliasDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeAliasDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    DescriptorRendererImpl.access$renderTypeAlias(this.this$0, paramTypeAliasDescriptor, paramStringBuilder);
  }
  
  public void visitTypeParameterDescriptor(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeParameterDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    DescriptorRendererImpl.access$renderTypeParameter(this.this$0, paramTypeParameterDescriptor, paramStringBuilder, true);
  }
  
  public void visitValueParameterDescriptor(@NotNull ValueParameterDescriptor paramValueParameterDescriptor, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramValueParameterDescriptor, "descriptor");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    DescriptorRendererImpl.access$renderValueParameter(this.this$0, paramValueParameterDescriptor, true, paramStringBuilder, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.RenderDeclarationDescriptorVisitor
 * JD-Core Version:    0.7.0.1
 */