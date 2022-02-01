package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractLazyTypeParameterDescriptor
  extends AbstractTypeParameterDescriptor
{
  public AbstractLazyTypeParameterDescriptor(@NotNull StorageManager paramStorageManager, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Name paramName, @NotNull Variance paramVariance, boolean paramBoolean, int paramInt, @NotNull SourceElement paramSourceElement, @NotNull SupertypeLoopChecker paramSupertypeLoopChecker)
  {
    super(paramStorageManager, paramDeclarationDescriptor, Annotations.Companion.getEMPTY(), paramName, paramVariance, paramBoolean, paramInt, paramSourceElement, paramSupertypeLoopChecker);
  }
  
  public String toString()
  {
    boolean bool = isReified();
    Object localObject = "";
    String str;
    if (bool) {
      str = "reified ";
    } else {
      str = "";
    }
    if (getVariance() != Variance.INVARIANT)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getVariance());
      ((StringBuilder)localObject).append(" ");
      localObject = ((StringBuilder)localObject).toString();
    }
    return String.format("%s%s%s", new Object[] { str, localObject, getName() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor
 * JD-Core Version:    0.7.0.1
 */