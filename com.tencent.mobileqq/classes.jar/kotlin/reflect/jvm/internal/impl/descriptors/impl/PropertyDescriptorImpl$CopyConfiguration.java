package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PropertyDescriptorImpl$CopyConfiguration
{
  private boolean copyOverrides = true;
  private ReceiverParameterDescriptor dispatchReceiverParameter = PropertyDescriptorImpl.access$000(this.this$0);
  private CallableMemberDescriptor.Kind kind = this.this$0.getKind();
  private Modality modality = this.this$0.getModality();
  private Name name = this.this$0.getName();
  private List<TypeParameterDescriptor> newTypeParameters = null;
  private PropertyDescriptor original = null;
  private DeclarationDescriptor owner = this.this$0.getContainingDeclaration();
  private boolean preserveSourceElement = false;
  private TypeSubstitution substitution = TypeSubstitution.EMPTY;
  private Visibility visibility = this.this$0.getVisibility();
  
  public PropertyDescriptorImpl$CopyConfiguration(PropertyDescriptorImpl paramPropertyDescriptorImpl) {}
  
  @Nullable
  public PropertyDescriptor build()
  {
    return this.this$0.doSubstitute(this);
  }
  
  PropertyGetterDescriptor getOriginalGetter()
  {
    PropertyDescriptor localPropertyDescriptor = this.original;
    if (localPropertyDescriptor == null) {
      return null;
    }
    return localPropertyDescriptor.getGetter();
  }
  
  PropertySetterDescriptor getOriginalSetter()
  {
    PropertyDescriptor localPropertyDescriptor = this.original;
    if (localPropertyDescriptor == null) {
      return null;
    }
    return localPropertyDescriptor.getSetter();
  }
  
  @NotNull
  public CopyConfiguration setCopyOverrides(boolean paramBoolean)
  {
    this.copyOverrides = paramBoolean;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setKind(@NotNull CallableMemberDescriptor.Kind paramKind)
  {
    if (paramKind == null) {
      $$$reportNull$$$0(8);
    }
    this.kind = paramKind;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setModality(@NotNull Modality paramModality)
  {
    if (paramModality == null) {
      $$$reportNull$$$0(4);
    }
    this.modality = paramModality;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setOriginal(@Nullable CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    this.original = ((PropertyDescriptor)paramCallableMemberDescriptor);
    return this;
  }
  
  @NotNull
  public CopyConfiguration setOwner(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(0);
    }
    this.owner = paramDeclarationDescriptor;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setSubstitution(@NotNull TypeSubstitution paramTypeSubstitution)
  {
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(13);
    }
    this.substitution = paramTypeSubstitution;
    return this;
  }
  
  @NotNull
  public CopyConfiguration setVisibility(@NotNull Visibility paramVisibility)
  {
    if (paramVisibility == null) {
      $$$reportNull$$$0(6);
    }
    this.visibility = paramVisibility;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl.CopyConfiguration
 * JD-Core Version:    0.7.0.1
 */