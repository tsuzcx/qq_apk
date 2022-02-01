package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface ClassDescriptor
  extends ClassOrPackageFragmentDescriptor, ClassifierDescriptorWithTypeParameters
{
  @Nullable
  public abstract ClassDescriptor getCompanionObjectDescriptor();
  
  @NotNull
  public abstract Collection<ClassConstructorDescriptor> getConstructors();
  
  @NotNull
  public abstract DeclarationDescriptor getContainingDeclaration();
  
  @NotNull
  public abstract List<TypeParameterDescriptor> getDeclaredTypeParameters();
  
  @NotNull
  public abstract SimpleType getDefaultType();
  
  @NotNull
  public abstract ClassKind getKind();
  
  @NotNull
  public abstract MemberScope getMemberScope(@NotNull TypeSubstitution paramTypeSubstitution);
  
  @NotNull
  public abstract Modality getModality();
  
  @NotNull
  public abstract ClassDescriptor getOriginal();
  
  @NotNull
  public abstract Collection<ClassDescriptor> getSealedSubclasses();
  
  @NotNull
  public abstract MemberScope getStaticScope();
  
  @NotNull
  public abstract ReceiverParameterDescriptor getThisAsReceiverParameter();
  
  @NotNull
  public abstract MemberScope getUnsubstitutedInnerClassesScope();
  
  @NotNull
  public abstract MemberScope getUnsubstitutedMemberScope();
  
  @Nullable
  public abstract ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor();
  
  @NotNull
  public abstract Visibility getVisibility();
  
  public abstract boolean isCompanionObject();
  
  public abstract boolean isData();
  
  public abstract boolean isInline();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
 * JD-Core Version:    0.7.0.1
 */