package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;

public class DeclarationDescriptorVisitorEmptyBodies<R, D>
  implements DeclarationDescriptorVisitor<R, D>
{
  public R visitClassDescriptor(ClassDescriptor paramClassDescriptor, D paramD)
  {
    return visitDeclarationDescriptor(paramClassDescriptor, paramD);
  }
  
  public R visitConstructorDescriptor(ConstructorDescriptor paramConstructorDescriptor, D paramD)
  {
    return visitFunctionDescriptor(paramConstructorDescriptor, paramD);
  }
  
  public R visitDeclarationDescriptor(DeclarationDescriptor paramDeclarationDescriptor, D paramD)
  {
    return null;
  }
  
  public R visitFunctionDescriptor(FunctionDescriptor paramFunctionDescriptor, D paramD)
  {
    return visitDeclarationDescriptor(paramFunctionDescriptor, paramD);
  }
  
  public R visitModuleDeclaration(ModuleDescriptor paramModuleDescriptor, D paramD)
  {
    return visitDeclarationDescriptor(paramModuleDescriptor, paramD);
  }
  
  public R visitPackageFragmentDescriptor(PackageFragmentDescriptor paramPackageFragmentDescriptor, D paramD)
  {
    return visitDeclarationDescriptor(paramPackageFragmentDescriptor, paramD);
  }
  
  public R visitPackageViewDescriptor(PackageViewDescriptor paramPackageViewDescriptor, D paramD)
  {
    return visitDeclarationDescriptor(paramPackageViewDescriptor, paramD);
  }
  
  public R visitPropertyDescriptor(PropertyDescriptor paramPropertyDescriptor, D paramD)
  {
    return visitVariableDescriptor(paramPropertyDescriptor, paramD);
  }
  
  public R visitPropertyGetterDescriptor(PropertyGetterDescriptor paramPropertyGetterDescriptor, D paramD)
  {
    return visitFunctionDescriptor(paramPropertyGetterDescriptor, paramD);
  }
  
  public R visitPropertySetterDescriptor(PropertySetterDescriptor paramPropertySetterDescriptor, D paramD)
  {
    return visitFunctionDescriptor(paramPropertySetterDescriptor, paramD);
  }
  
  public R visitReceiverParameterDescriptor(ReceiverParameterDescriptor paramReceiverParameterDescriptor, D paramD)
  {
    return visitDeclarationDescriptor(paramReceiverParameterDescriptor, paramD);
  }
  
  public R visitTypeAliasDescriptor(TypeAliasDescriptor paramTypeAliasDescriptor, D paramD)
  {
    return visitDeclarationDescriptor(paramTypeAliasDescriptor, paramD);
  }
  
  public R visitTypeParameterDescriptor(TypeParameterDescriptor paramTypeParameterDescriptor, D paramD)
  {
    return visitDeclarationDescriptor(paramTypeParameterDescriptor, paramD);
  }
  
  public R visitValueParameterDescriptor(ValueParameterDescriptor paramValueParameterDescriptor, D paramD)
  {
    return visitVariableDescriptor(paramValueParameterDescriptor, paramD);
  }
  
  public R visitVariableDescriptor(VariableDescriptor paramVariableDescriptor, D paramD)
  {
    return visitDeclarationDescriptor(paramVariableDescriptor, paramD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorVisitorEmptyBodies
 * JD-Core Version:    0.7.0.1
 */