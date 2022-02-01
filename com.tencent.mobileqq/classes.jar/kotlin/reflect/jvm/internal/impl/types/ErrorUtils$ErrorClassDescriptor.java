package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collections;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassConstructorDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

class ErrorUtils$ErrorClassDescriptor
  extends ClassDescriptorImpl
{
  public ErrorUtils$ErrorClassDescriptor(@NotNull Name paramName)
  {
    super(ErrorUtils.getErrorModule(), paramName, Modality.OPEN, ClassKind.CLASS, Collections.emptyList(), SourceElement.NO_SOURCE, false, LockBasedStorageManager.NO_LOCKS);
    paramName = ClassConstructorDescriptorImpl.create(this, Annotations.Companion.getEMPTY(), true, SourceElement.NO_SOURCE);
    paramName.initialize(Collections.emptyList(), Visibilities.INTERNAL);
    MemberScope localMemberScope = ErrorUtils.createErrorScope(getName().asString());
    paramName.setReturnType(new ErrorType(ErrorUtils.access$200("<ERROR>", this), localMemberScope));
    initialize(localMemberScope, Collections.singleton(paramName), paramName);
  }
  
  @NotNull
  public MemberScope getMemberScope(@NotNull TypeSubstitution paramTypeSubstitution, @NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(6);
    }
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(7);
    }
    paramKotlinTypeRefiner = new StringBuilder();
    paramKotlinTypeRefiner.append("Error scope for class ");
    paramKotlinTypeRefiner.append(getName());
    paramKotlinTypeRefiner.append(" with arguments: ");
    paramKotlinTypeRefiner.append(paramTypeSubstitution);
    paramTypeSubstitution = ErrorUtils.createErrorScope(paramKotlinTypeRefiner.toString());
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(8);
    }
    return paramTypeSubstitution;
  }
  
  @NotNull
  public ClassDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(1);
    }
    return this;
  }
  
  public String toString()
  {
    return getName().asString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.ErrorUtils.ErrorClassDescriptor
 * JD-Core Version:    0.7.0.1
 */