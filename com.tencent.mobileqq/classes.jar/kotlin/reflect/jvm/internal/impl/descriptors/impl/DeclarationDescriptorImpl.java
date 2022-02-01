package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotatedImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import org.jetbrains.annotations.NotNull;

public abstract class DeclarationDescriptorImpl
  extends AnnotatedImpl
  implements DeclarationDescriptor
{
  @NotNull
  private final Name name;
  
  public DeclarationDescriptorImpl(@NotNull Annotations paramAnnotations, @NotNull Name paramName)
  {
    super(paramAnnotations);
    this.name = paramName;
  }
  
  @NotNull
  public static String toString(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(4);
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(DescriptorRenderer.DEBUG_TEXT.render(paramDeclarationDescriptor));
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(paramDeclarationDescriptor.getClass().getSimpleName());
      ((StringBuilder)localObject).append("@");
      ((StringBuilder)localObject).append(Integer.toHexString(System.identityHashCode(paramDeclarationDescriptor)));
      ((StringBuilder)localObject).append("]");
      localObject = ((StringBuilder)localObject).toString();
      if (localObject == null) {
        $$$reportNull$$$0(5);
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      label88:
      break label88;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramDeclarationDescriptor.getClass().getSimpleName());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(paramDeclarationDescriptor.getName());
    paramDeclarationDescriptor = ((StringBuilder)localObject).toString();
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(6);
    }
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  public Name getName()
  {
    Name localName = this.name;
    if (localName == null) {
      $$$reportNull$$$0(2);
    }
    return localName;
  }
  
  @NotNull
  public DeclarationDescriptor getOriginal()
  {
    return this;
  }
  
  public String toString()
  {
    return toString(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */