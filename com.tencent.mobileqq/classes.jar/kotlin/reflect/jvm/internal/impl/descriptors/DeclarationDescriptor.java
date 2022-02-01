package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface DeclarationDescriptor
  extends Named, Annotated
{
  public abstract <R, D> R accept(DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD);
  
  @Nullable
  public abstract DeclarationDescriptor getContainingDeclaration();
  
  @NotNull
  public abstract DeclarationDescriptor getOriginal();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
 * JD-Core Version:    0.7.0.1
 */