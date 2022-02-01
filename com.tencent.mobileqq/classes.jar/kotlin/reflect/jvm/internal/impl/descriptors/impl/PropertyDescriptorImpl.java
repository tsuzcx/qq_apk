package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PropertyDescriptorImpl
  extends VariableDescriptorWithInitializerImpl
  implements PropertyDescriptor
{
  private FieldDescriptor backingField;
  private FieldDescriptor delegateField;
  private ReceiverParameterDescriptor dispatchReceiverParameter;
  private ReceiverParameterDescriptor extensionReceiverParameter;
  private PropertyGetterDescriptorImpl getter;
  private final boolean isActual;
  private final boolean isConst;
  private final boolean isDelegated;
  private final boolean isExpect;
  private final boolean isExternal;
  private final CallableMemberDescriptor.Kind kind;
  private final boolean lateInit;
  private final Modality modality;
  private final PropertyDescriptor original;
  private Collection<? extends PropertyDescriptor> overriddenProperties = null;
  private PropertySetterDescriptor setter;
  private boolean setterProjectedOut;
  private List<TypeParameterDescriptor> typeParameters;
  private Visibility visibility;
  
  protected PropertyDescriptorImpl(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable PropertyDescriptor paramPropertyDescriptor, @NotNull Annotations paramAnnotations, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, boolean paramBoolean1, @NotNull Name paramName, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull SourceElement paramSourceElement, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    super(paramDeclarationDescriptor, paramAnnotations, paramName, null, paramBoolean1, paramSourceElement);
    this.modality = paramModality;
    this.visibility = paramVisibility;
    if (paramPropertyDescriptor == null) {
      paramDeclarationDescriptor = this;
    } else {
      paramDeclarationDescriptor = paramPropertyDescriptor;
    }
    this.original = paramDeclarationDescriptor;
    this.kind = paramKind;
    this.lateInit = paramBoolean2;
    this.isConst = paramBoolean3;
    this.isExpect = paramBoolean4;
    this.isActual = paramBoolean5;
    this.isExternal = paramBoolean6;
    this.isDelegated = paramBoolean7;
  }
  
  @NotNull
  public static PropertyDescriptorImpl create(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, boolean paramBoolean1, @NotNull Name paramName, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull SourceElement paramSourceElement, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(7);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(8);
    }
    if (paramModality == null) {
      $$$reportNull$$$0(9);
    }
    if (paramVisibility == null) {
      $$$reportNull$$$0(10);
    }
    if (paramName == null) {
      $$$reportNull$$$0(11);
    }
    if (paramKind == null) {
      $$$reportNull$$$0(12);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(13);
    }
    return new PropertyDescriptorImpl(paramDeclarationDescriptor, null, paramAnnotations, paramModality, paramVisibility, paramBoolean1, paramName, paramKind, paramSourceElement, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5, paramBoolean6, paramBoolean7);
  }
  
  @NotNull
  private SourceElement getSourceToUseForCopy(boolean paramBoolean, @Nullable PropertyDescriptor paramPropertyDescriptor)
  {
    if (paramBoolean)
    {
      if (paramPropertyDescriptor == null) {
        paramPropertyDescriptor = getOriginal();
      }
      paramPropertyDescriptor = paramPropertyDescriptor.getSource();
    }
    else
    {
      paramPropertyDescriptor = SourceElement.NO_SOURCE;
    }
    if (paramPropertyDescriptor == null) {
      $$$reportNull$$$0(23);
    }
    return paramPropertyDescriptor;
  }
  
  private static FunctionDescriptor getSubstitutedInitialSignatureDescriptor(@NotNull TypeSubstitutor paramTypeSubstitutor, @NotNull PropertyAccessorDescriptor paramPropertyAccessorDescriptor)
  {
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(25);
    }
    if (paramPropertyAccessorDescriptor == null) {
      $$$reportNull$$$0(26);
    }
    if (paramPropertyAccessorDescriptor.getInitialSignatureDescriptor() != null) {
      return paramPropertyAccessorDescriptor.getInitialSignatureDescriptor().substitute(paramTypeSubstitutor);
    }
    return null;
  }
  
  private static Visibility normalizeVisibility(Visibility paramVisibility, CallableMemberDescriptor.Kind paramKind)
  {
    Visibility localVisibility = paramVisibility;
    if (paramKind == CallableMemberDescriptor.Kind.FAKE_OVERRIDE)
    {
      localVisibility = paramVisibility;
      if (Visibilities.isPrivate(paramVisibility.normalize())) {
        localVisibility = Visibilities.INVISIBLE_FAKE;
      }
    }
    return localVisibility;
  }
  
  public <R, D> R accept(DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    return paramDeclarationDescriptorVisitor.visitPropertyDescriptor(this, paramD);
  }
  
  @NotNull
  public PropertyDescriptor copy(DeclarationDescriptor paramDeclarationDescriptor, Modality paramModality, Visibility paramVisibility, CallableMemberDescriptor.Kind paramKind, boolean paramBoolean)
  {
    paramDeclarationDescriptor = newCopyBuilder().setOwner(paramDeclarationDescriptor).setOriginal(null).setModality(paramModality).setVisibility(paramVisibility).setKind(paramKind).setCopyOverrides(paramBoolean).build();
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(37);
    }
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  protected PropertyDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, @Nullable PropertyDescriptor paramPropertyDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull Name paramName, @NotNull SourceElement paramSourceElement)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(27);
    }
    if (paramModality == null) {
      $$$reportNull$$$0(28);
    }
    if (paramVisibility == null) {
      $$$reportNull$$$0(29);
    }
    if (paramKind == null) {
      $$$reportNull$$$0(30);
    }
    if (paramName == null) {
      $$$reportNull$$$0(31);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(32);
    }
    return new PropertyDescriptorImpl(paramDeclarationDescriptor, paramPropertyDescriptor, getAnnotations(), paramModality, paramVisibility, isVar(), paramName, paramKind, paramSourceElement, isLateInit(), isConst(), isExpect(), isActual(), isExternal(), isDelegated());
  }
  
  @Nullable
  protected PropertyDescriptor doSubstitute(@NotNull PropertyDescriptorImpl.CopyConfiguration paramCopyConfiguration)
  {
    if (paramCopyConfiguration == null) {
      $$$reportNull$$$0(24);
    }
    PropertyDescriptorImpl localPropertyDescriptorImpl = createSubstitutedCopy(PropertyDescriptorImpl.CopyConfiguration.access$100(paramCopyConfiguration), PropertyDescriptorImpl.CopyConfiguration.access$200(paramCopyConfiguration), PropertyDescriptorImpl.CopyConfiguration.access$300(paramCopyConfiguration), PropertyDescriptorImpl.CopyConfiguration.access$400(paramCopyConfiguration), PropertyDescriptorImpl.CopyConfiguration.access$500(paramCopyConfiguration), PropertyDescriptorImpl.CopyConfiguration.access$600(paramCopyConfiguration), getSourceToUseForCopy(PropertyDescriptorImpl.CopyConfiguration.access$700(paramCopyConfiguration), PropertyDescriptorImpl.CopyConfiguration.access$400(paramCopyConfiguration)));
    if (PropertyDescriptorImpl.CopyConfiguration.access$800(paramCopyConfiguration) == null) {
      localObject1 = getTypeParameters();
    } else {
      localObject1 = PropertyDescriptorImpl.CopyConfiguration.access$800(paramCopyConfiguration);
    }
    Object localObject3 = new ArrayList(((List)localObject1).size());
    TypeSubstitutor localTypeSubstitutor = DescriptorSubstitutor.substituteTypeParameters((List)localObject1, PropertyDescriptorImpl.CopyConfiguration.access$900(paramCopyConfiguration), localPropertyDescriptorImpl, (List)localObject3);
    Object localObject4 = localTypeSubstitutor.substitute(getType(), Variance.OUT_VARIANCE);
    FieldDescriptorImpl localFieldDescriptorImpl = null;
    if (localObject4 == null) {
      return null;
    }
    Object localObject1 = PropertyDescriptorImpl.CopyConfiguration.access$1000(paramCopyConfiguration);
    if (localObject1 != null)
    {
      localObject2 = ((ReceiverParameterDescriptor)localObject1).substitute(localTypeSubstitutor);
      localObject1 = localObject2;
      if (localObject2 == null) {
        return null;
      }
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = this.extensionReceiverParameter;
    if (localObject2 != null)
    {
      localObject2 = localTypeSubstitutor.substitute(((ReceiverParameterDescriptor)localObject2).getType(), Variance.IN_VARIANCE);
      if (localObject2 == null) {
        return null;
      }
      localObject2 = new ReceiverParameterDescriptorImpl(localPropertyDescriptorImpl, new ExtensionReceiver(localPropertyDescriptorImpl, (KotlinType)localObject2, this.extensionReceiverParameter.getValue()), this.extensionReceiverParameter.getAnnotations());
    }
    else
    {
      localObject2 = null;
    }
    localPropertyDescriptorImpl.setType((KotlinType)localObject4, (List)localObject3, (ReceiverParameterDescriptor)localObject1, (ReceiverParameterDescriptor)localObject2);
    localObject1 = this.getter;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = new PropertyGetterDescriptorImpl(localPropertyDescriptorImpl, ((PropertyGetterDescriptorImpl)localObject1).getAnnotations(), PropertyDescriptorImpl.CopyConfiguration.access$200(paramCopyConfiguration), normalizeVisibility(this.getter.getVisibility(), PropertyDescriptorImpl.CopyConfiguration.access$500(paramCopyConfiguration)), this.getter.isDefault(), this.getter.isExternal(), this.getter.isInline(), PropertyDescriptorImpl.CopyConfiguration.access$500(paramCopyConfiguration), paramCopyConfiguration.getOriginalGetter(), SourceElement.NO_SOURCE);
    }
    if (localObject1 != null)
    {
      localObject2 = this.getter.getReturnType();
      ((PropertyGetterDescriptorImpl)localObject1).setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(localTypeSubstitutor, this.getter));
      if (localObject2 != null) {
        localObject2 = localTypeSubstitutor.substitute((KotlinType)localObject2, Variance.OUT_VARIANCE);
      } else {
        localObject2 = null;
      }
      ((PropertyGetterDescriptorImpl)localObject1).initialize((KotlinType)localObject2);
    }
    localObject2 = this.setter;
    if (localObject2 == null) {
      localObject2 = null;
    } else {
      localObject2 = new PropertySetterDescriptorImpl(localPropertyDescriptorImpl, ((PropertySetterDescriptor)localObject2).getAnnotations(), PropertyDescriptorImpl.CopyConfiguration.access$200(paramCopyConfiguration), normalizeVisibility(this.setter.getVisibility(), PropertyDescriptorImpl.CopyConfiguration.access$500(paramCopyConfiguration)), this.setter.isDefault(), this.setter.isExternal(), this.setter.isInline(), PropertyDescriptorImpl.CopyConfiguration.access$500(paramCopyConfiguration), paramCopyConfiguration.getOriginalSetter(), SourceElement.NO_SOURCE);
    }
    if (localObject2 != null)
    {
      localObject4 = FunctionDescriptorImpl.getSubstitutedValueParameters((FunctionDescriptor)localObject2, this.setter.getValueParameters(), localTypeSubstitutor, false, false, null);
      localObject3 = localObject4;
      if (localObject4 == null)
      {
        localPropertyDescriptorImpl.setSetterProjectedOut(true);
        localObject3 = Collections.singletonList(PropertySetterDescriptorImpl.createSetterParameter((PropertySetterDescriptor)localObject2, DescriptorUtilsKt.getBuiltIns(PropertyDescriptorImpl.CopyConfiguration.access$100(paramCopyConfiguration)).getNothingType(), ((ValueParameterDescriptor)this.setter.getValueParameters().get(0)).getAnnotations()));
      }
      if (((List)localObject3).size() == 1)
      {
        ((PropertySetterDescriptorImpl)localObject2).setInitialSignatureDescriptor(getSubstitutedInitialSignatureDescriptor(localTypeSubstitutor, this.setter));
        ((PropertySetterDescriptorImpl)localObject2).initialize((ValueParameterDescriptor)((List)localObject3).get(0));
      }
      else
      {
        throw new IllegalStateException();
      }
    }
    localObject3 = this.backingField;
    if (localObject3 == null) {
      localObject3 = null;
    } else {
      localObject3 = new FieldDescriptorImpl(((FieldDescriptor)localObject3).getAnnotations(), localPropertyDescriptorImpl);
    }
    localObject4 = this.delegateField;
    if (localObject4 != null) {
      localFieldDescriptorImpl = new FieldDescriptorImpl(((FieldDescriptor)localObject4).getAnnotations(), localPropertyDescriptorImpl);
    }
    localPropertyDescriptorImpl.initialize((PropertyGetterDescriptorImpl)localObject1, (PropertySetterDescriptor)localObject2, (FieldDescriptor)localObject3, localFieldDescriptorImpl);
    if (PropertyDescriptorImpl.CopyConfiguration.access$1100(paramCopyConfiguration))
    {
      paramCopyConfiguration = SmartSet.create();
      localObject1 = getOverriddenDescriptors().iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramCopyConfiguration.add(((PropertyDescriptor)((Iterator)localObject1).next()).substitute(localTypeSubstitutor));
      }
      localPropertyDescriptorImpl.setOverriddenDescriptors(paramCopyConfiguration);
    }
    if ((isConst()) && (this.compileTimeInitializer != null)) {
      localPropertyDescriptorImpl.setCompileTimeInitializer(this.compileTimeInitializer);
    }
    return localPropertyDescriptorImpl;
  }
  
  @NotNull
  public List<PropertyAccessorDescriptor> getAccessors()
  {
    ArrayList localArrayList = new ArrayList(2);
    Object localObject = this.getter;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = this.setter;
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    return localArrayList;
  }
  
  @Nullable
  public FieldDescriptor getBackingField()
  {
    return this.backingField;
  }
  
  @Nullable
  public FieldDescriptor getDelegateField()
  {
    return this.delegateField;
  }
  
  @Nullable
  public ReceiverParameterDescriptor getDispatchReceiverParameter()
  {
    return this.dispatchReceiverParameter;
  }
  
  @Nullable
  public ReceiverParameterDescriptor getExtensionReceiverParameter()
  {
    return this.extensionReceiverParameter;
  }
  
  @Nullable
  public PropertyGetterDescriptorImpl getGetter()
  {
    return this.getter;
  }
  
  @NotNull
  public CallableMemberDescriptor.Kind getKind()
  {
    CallableMemberDescriptor.Kind localKind = this.kind;
    if (localKind == null) {
      $$$reportNull$$$0(34);
    }
    return localKind;
  }
  
  @NotNull
  public Modality getModality()
  {
    Modality localModality = this.modality;
    if (localModality == null) {
      $$$reportNull$$$0(19);
    }
    return localModality;
  }
  
  @NotNull
  public PropertyDescriptor getOriginal()
  {
    Object localObject = this.original;
    if (localObject == this) {
      localObject = this;
    } else {
      localObject = ((PropertyDescriptor)localObject).getOriginal();
    }
    if (localObject == null) {
      $$$reportNull$$$0(33);
    }
    return localObject;
  }
  
  @NotNull
  public Collection<? extends PropertyDescriptor> getOverriddenDescriptors()
  {
    Object localObject = this.overriddenProperties;
    if (localObject == null) {
      localObject = Collections.emptyList();
    }
    if (localObject == null) {
      $$$reportNull$$$0(36);
    }
    return localObject;
  }
  
  @NotNull
  public KotlinType getReturnType()
  {
    KotlinType localKotlinType = getType();
    if (localKotlinType == null) {
      $$$reportNull$$$0(18);
    }
    return localKotlinType;
  }
  
  @Nullable
  public PropertySetterDescriptor getSetter()
  {
    return this.setter;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getTypeParameters()
  {
    List localList = this.typeParameters;
    if (localList == null) {
      $$$reportNull$$$0(17);
    }
    return localList;
  }
  
  @Nullable
  public <V> V getUserData(CallableDescriptor.UserDataKey<V> paramUserDataKey)
  {
    return null;
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    Visibility localVisibility = this.visibility;
    if (localVisibility == null) {
      $$$reportNull$$$0(20);
    }
    return localVisibility;
  }
  
  public void initialize(@Nullable PropertyGetterDescriptorImpl paramPropertyGetterDescriptorImpl, @Nullable PropertySetterDescriptor paramPropertySetterDescriptor)
  {
    initialize(paramPropertyGetterDescriptorImpl, paramPropertySetterDescriptor, null, null);
  }
  
  public void initialize(@Nullable PropertyGetterDescriptorImpl paramPropertyGetterDescriptorImpl, @Nullable PropertySetterDescriptor paramPropertySetterDescriptor, @Nullable FieldDescriptor paramFieldDescriptor1, @Nullable FieldDescriptor paramFieldDescriptor2)
  {
    this.getter = paramPropertyGetterDescriptorImpl;
    this.setter = paramPropertySetterDescriptor;
    this.backingField = paramFieldDescriptor1;
    this.delegateField = paramFieldDescriptor2;
  }
  
  public boolean isActual()
  {
    return this.isActual;
  }
  
  public boolean isConst()
  {
    return this.isConst;
  }
  
  public boolean isDelegated()
  {
    return this.isDelegated;
  }
  
  public boolean isExpect()
  {
    return this.isExpect;
  }
  
  public boolean isExternal()
  {
    return this.isExternal;
  }
  
  public boolean isLateInit()
  {
    return this.lateInit;
  }
  
  public boolean isSetterProjectedOut()
  {
    return this.setterProjectedOut;
  }
  
  @NotNull
  public PropertyDescriptorImpl.CopyConfiguration newCopyBuilder()
  {
    return new PropertyDescriptorImpl.CopyConfiguration(this);
  }
  
  public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> paramCollection)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(35);
    }
    this.overriddenProperties = paramCollection;
  }
  
  public void setSetterProjectedOut(boolean paramBoolean)
  {
    this.setterProjectedOut = paramBoolean;
  }
  
  public void setType(@NotNull KotlinType paramKotlinType, @NotNull List<? extends TypeParameterDescriptor> paramList, @Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor1, @Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor2)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(14);
    }
    if (paramList == null) {
      $$$reportNull$$$0(15);
    }
    setOutType(paramKotlinType);
    this.typeParameters = new ArrayList(paramList);
    this.extensionReceiverParameter = paramReceiverParameterDescriptor2;
    this.dispatchReceiverParameter = paramReceiverParameterDescriptor1;
  }
  
  public void setVisibility(@NotNull Visibility paramVisibility)
  {
    if (paramVisibility == null) {
      $$$reportNull$$$0(16);
    }
    this.visibility = paramVisibility;
  }
  
  public PropertyDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(22);
    }
    if (paramTypeSubstitutor.isEmpty()) {
      return this;
    }
    return newCopyBuilder().setSubstitution(paramTypeSubstitutor.getSubstitution()).setOriginal(getOriginal()).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */