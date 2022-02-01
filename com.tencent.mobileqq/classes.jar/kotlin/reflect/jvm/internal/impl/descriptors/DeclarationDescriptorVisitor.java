package kotlin.reflect.jvm.internal.impl.descriptors;

public abstract interface DeclarationDescriptorVisitor<R, D>
{
  public abstract R visitClassDescriptor(ClassDescriptor paramClassDescriptor, D paramD);
  
  public abstract R visitConstructorDescriptor(ConstructorDescriptor paramConstructorDescriptor, D paramD);
  
  public abstract R visitFunctionDescriptor(FunctionDescriptor paramFunctionDescriptor, D paramD);
  
  public abstract R visitModuleDeclaration(ModuleDescriptor paramModuleDescriptor, D paramD);
  
  public abstract R visitPackageFragmentDescriptor(PackageFragmentDescriptor paramPackageFragmentDescriptor, D paramD);
  
  public abstract R visitPackageViewDescriptor(PackageViewDescriptor paramPackageViewDescriptor, D paramD);
  
  public abstract R visitPropertyDescriptor(PropertyDescriptor paramPropertyDescriptor, D paramD);
  
  public abstract R visitPropertyGetterDescriptor(PropertyGetterDescriptor paramPropertyGetterDescriptor, D paramD);
  
  public abstract R visitPropertySetterDescriptor(PropertySetterDescriptor paramPropertySetterDescriptor, D paramD);
  
  public abstract R visitReceiverParameterDescriptor(ReceiverParameterDescriptor paramReceiverParameterDescriptor, D paramD);
  
  public abstract R visitTypeAliasDescriptor(TypeAliasDescriptor paramTypeAliasDescriptor, D paramD);
  
  public abstract R visitTypeParameterDescriptor(TypeParameterDescriptor paramTypeParameterDescriptor, D paramD);
  
  public abstract R visitValueParameterDescriptor(ValueParameterDescriptor paramValueParameterDescriptor, D paramD);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor
 * JD-Core Version:    0.7.0.1
 */