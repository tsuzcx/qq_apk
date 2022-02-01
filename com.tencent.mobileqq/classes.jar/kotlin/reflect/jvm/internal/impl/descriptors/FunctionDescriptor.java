package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface FunctionDescriptor
  extends CallableMemberDescriptor
{
  @NotNull
  public abstract DeclarationDescriptor getContainingDeclaration();
  
  @Nullable
  public abstract FunctionDescriptor getInitialSignatureDescriptor();
  
  @NotNull
  public abstract FunctionDescriptor getOriginal();
  
  @NotNull
  public abstract Collection<? extends FunctionDescriptor> getOverriddenDescriptors();
  
  public abstract boolean isHiddenForResolutionEverywhereBesideSupercalls();
  
  public abstract boolean isHiddenToOvercomeSignatureClash();
  
  public abstract boolean isInfix();
  
  public abstract boolean isInline();
  
  public abstract boolean isOperator();
  
  public abstract boolean isSuspend();
  
  public abstract boolean isTailrec();
  
  @NotNull
  public abstract FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder();
  
  @Nullable
  public abstract FunctionDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
 * JD-Core Version:    0.7.0.1
 */