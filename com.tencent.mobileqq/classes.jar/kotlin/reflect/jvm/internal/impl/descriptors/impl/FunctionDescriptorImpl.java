package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor.UserDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationsKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ExtensionReceiver;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class FunctionDescriptorImpl
  extends DeclarationDescriptorNonRootImpl
  implements FunctionDescriptor
{
  private ReceiverParameterDescriptor dispatchReceiverParameter;
  private ReceiverParameterDescriptor extensionReceiverParameter;
  private boolean hasStableParameterNames = true;
  private boolean hasSynthesizedParameterNames = false;
  @Nullable
  private FunctionDescriptor initialSignatureDescriptor = null;
  private boolean isActual = false;
  private boolean isExpect = false;
  private boolean isExternal = false;
  private boolean isHiddenForResolutionEverywhereBesideSupercalls = false;
  private boolean isHiddenToOvercomeSignatureClash = false;
  private boolean isInfix = false;
  private boolean isInline = false;
  private boolean isOperator = false;
  private boolean isSuspend = false;
  private boolean isTailrec = false;
  private final CallableMemberDescriptor.Kind kind;
  private volatile Function0<Collection<FunctionDescriptor>> lazyOverriddenFunctionsTask = null;
  private Modality modality;
  private final FunctionDescriptor original;
  private Collection<? extends FunctionDescriptor> overriddenFunctions = null;
  private List<TypeParameterDescriptor> typeParameters;
  private KotlinType unsubstitutedReturnType;
  private List<ValueParameterDescriptor> unsubstitutedValueParameters;
  protected Map<CallableDescriptor.UserDataKey<?>, Object> userDataMap = null;
  private Visibility visibility = Visibilities.UNKNOWN;
  
  protected FunctionDescriptorImpl(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable FunctionDescriptor paramFunctionDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull CallableMemberDescriptor.Kind paramKind, @NotNull SourceElement paramSourceElement)
  {
    super(paramDeclarationDescriptor, paramAnnotations, paramName, paramSourceElement);
    paramDeclarationDescriptor = paramFunctionDescriptor;
    if (paramFunctionDescriptor == null) {
      paramDeclarationDescriptor = this;
    }
    this.original = paramDeclarationDescriptor;
    this.kind = paramKind;
  }
  
  @NotNull
  private SourceElement getSourceToUseForCopy(boolean paramBoolean, @Nullable FunctionDescriptor paramFunctionDescriptor)
  {
    if (paramBoolean)
    {
      if (paramFunctionDescriptor == null) {
        paramFunctionDescriptor = getOriginal();
      }
      paramFunctionDescriptor = paramFunctionDescriptor.getSource();
    }
    else
    {
      paramFunctionDescriptor = SourceElement.NO_SOURCE;
    }
    if (paramFunctionDescriptor == null) {
      $$$reportNull$$$0(25);
    }
    return paramFunctionDescriptor;
  }
  
  @Nullable
  public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor paramFunctionDescriptor, @NotNull List<ValueParameterDescriptor> paramList, @NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    if (paramList == null) {
      $$$reportNull$$$0(26);
    }
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(27);
    }
    return getSubstitutedValueParameters(paramFunctionDescriptor, paramList, paramTypeSubstitutor, false, false, null);
  }
  
  @Nullable
  public static List<ValueParameterDescriptor> getSubstitutedValueParameters(FunctionDescriptor paramFunctionDescriptor, @NotNull List<ValueParameterDescriptor> paramList, @NotNull TypeSubstitutor paramTypeSubstitutor, boolean paramBoolean1, boolean paramBoolean2, @Nullable boolean[] paramArrayOfBoolean)
  {
    if (paramList == null) {
      $$$reportNull$$$0(28);
    }
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(29);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (ValueParameterDescriptor)localIterator.next();
      KotlinType localKotlinType = paramTypeSubstitutor.substitute(((ValueParameterDescriptor)localObject3).getType(), Variance.IN_VARIANCE);
      Object localObject1 = ((ValueParameterDescriptor)localObject3).getVarargElementType();
      if (localObject1 == null) {
        paramList = null;
      } else {
        paramList = paramTypeSubstitutor.substitute((KotlinType)localObject1, Variance.IN_VARIANCE);
      }
      if (localKotlinType == null) {
        return null;
      }
      if (((localKotlinType != ((ValueParameterDescriptor)localObject3).getType()) || (localObject1 != paramList)) && (paramArrayOfBoolean != null)) {
        paramArrayOfBoolean[0] = true;
      }
      if ((localObject3 instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration)) {
        localObject1 = new FunctionDescriptorImpl.2(((ValueParameterDescriptorImpl.WithDestructuringDeclaration)localObject3).getDestructuringVariables());
      } else {
        localObject1 = null;
      }
      Object localObject2;
      if (paramBoolean1) {
        localObject2 = null;
      } else {
        localObject2 = localObject3;
      }
      int i = ((ValueParameterDescriptor)localObject3).getIndex();
      Annotations localAnnotations = ((ValueParameterDescriptor)localObject3).getAnnotations();
      Name localName = ((ValueParameterDescriptor)localObject3).getName();
      boolean bool1 = ((ValueParameterDescriptor)localObject3).declaresDefaultValue();
      boolean bool2 = ((ValueParameterDescriptor)localObject3).isCrossinline();
      boolean bool3 = ((ValueParameterDescriptor)localObject3).isNoinline();
      if (paramBoolean2) {
        localObject3 = ((ValueParameterDescriptor)localObject3).getSource();
      } else {
        localObject3 = SourceElement.NO_SOURCE;
      }
      localArrayList.add(ValueParameterDescriptorImpl.createWithDestructuringDeclarations(paramFunctionDescriptor, localObject2, i, localAnnotations, localName, localKotlinType, bool1, bool2, bool3, paramList, (SourceElement)localObject3, (Function0)localObject1));
    }
    return localArrayList;
  }
  
  private void performOverriddenLazyCalculationIfNeeded()
  {
    Function0 localFunction0 = this.lazyOverriddenFunctionsTask;
    if (localFunction0 != null)
    {
      this.overriddenFunctions = ((Collection)localFunction0.invoke());
      this.lazyOverriddenFunctionsTask = null;
    }
  }
  
  private void setHiddenForResolutionEverywhereBesideSupercalls(boolean paramBoolean)
  {
    this.isHiddenForResolutionEverywhereBesideSupercalls = paramBoolean;
  }
  
  private void setHiddenToOvercomeSignatureClash(boolean paramBoolean)
  {
    this.isHiddenToOvercomeSignatureClash = paramBoolean;
  }
  
  private void setInitialSignatureDescriptor(@Nullable FunctionDescriptor paramFunctionDescriptor)
  {
    this.initialSignatureDescriptor = paramFunctionDescriptor;
  }
  
  public <R, D> R accept(DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    return paramDeclarationDescriptorVisitor.visitFunctionDescriptor(this, paramD);
  }
  
  @NotNull
  public FunctionDescriptor copy(DeclarationDescriptor paramDeclarationDescriptor, Modality paramModality, Visibility paramVisibility, CallableMemberDescriptor.Kind paramKind, boolean paramBoolean)
  {
    paramDeclarationDescriptor = newCopyBuilder().setOwner(paramDeclarationDescriptor).setModality(paramModality).setVisibility(paramVisibility).setKind(paramKind).setCopyOverrides(paramBoolean).build();
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(24);
    }
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  protected abstract FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable FunctionDescriptor paramFunctionDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable Name paramName, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement);
  
  @Nullable
  protected FunctionDescriptor doSubstitute(@NotNull FunctionDescriptorImpl.CopyConfiguration paramCopyConfiguration)
  {
    if (paramCopyConfiguration == null) {
      $$$reportNull$$$0(23);
    }
    Object localObject3 = new boolean[1];
    Object localObject1;
    if (FunctionDescriptorImpl.CopyConfiguration.access$100(paramCopyConfiguration) != null) {
      localObject1 = AnnotationsKt.composeAnnotations(getAnnotations(), FunctionDescriptorImpl.CopyConfiguration.access$100(paramCopyConfiguration));
    } else {
      localObject1 = getAnnotations();
    }
    FunctionDescriptorImpl localFunctionDescriptorImpl = createSubstitutedCopy(paramCopyConfiguration.newOwner, paramCopyConfiguration.original, paramCopyConfiguration.kind, paramCopyConfiguration.name, (Annotations)localObject1, getSourceToUseForCopy(paramCopyConfiguration.preserveSourceElement, paramCopyConfiguration.original));
    if (FunctionDescriptorImpl.CopyConfiguration.access$200(paramCopyConfiguration) == null) {
      localObject1 = getTypeParameters();
    } else {
      localObject1 = FunctionDescriptorImpl.CopyConfiguration.access$200(paramCopyConfiguration);
    }
    localObject3[0] |= ((List)localObject1).isEmpty() ^ true;
    ArrayList localArrayList = new ArrayList(((List)localObject1).size());
    TypeSubstitutor localTypeSubstitutor = DescriptorSubstitutor.substituteTypeParameters((List)localObject1, paramCopyConfiguration.substitution, localFunctionDescriptorImpl, localArrayList, (boolean[])localObject3);
    if (localTypeSubstitutor == null) {
      return null;
    }
    Object localObject2;
    int i;
    if (paramCopyConfiguration.newExtensionReceiverParameter != null)
    {
      localObject2 = localTypeSubstitutor.substitute(paramCopyConfiguration.newExtensionReceiverParameter.getType(), Variance.IN_VARIANCE);
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new ReceiverParameterDescriptorImpl(localFunctionDescriptorImpl, new ExtensionReceiver(localFunctionDescriptorImpl, (KotlinType)localObject2, paramCopyConfiguration.newExtensionReceiverParameter.getValue()), paramCopyConfiguration.newExtensionReceiverParameter.getAnnotations());
      j = localObject3[0];
      if (localObject2 != paramCopyConfiguration.newExtensionReceiverParameter.getType()) {
        i = 1;
      } else {
        i = 0;
      }
      localObject3[0] = (i | j);
    }
    else
    {
      localObject1 = null;
    }
    if (paramCopyConfiguration.dispatchReceiverParameter != null)
    {
      localObject2 = paramCopyConfiguration.dispatchReceiverParameter.substitute(localTypeSubstitutor);
      if (localObject2 == null) {
        return null;
      }
      j = localObject3[0];
      if (localObject2 != paramCopyConfiguration.dispatchReceiverParameter) {
        i = 1;
      } else {
        i = 0;
      }
      localObject3[0] = (j | i);
    }
    else
    {
      localObject2 = null;
    }
    List localList = getSubstitutedValueParameters(localFunctionDescriptorImpl, paramCopyConfiguration.newValueParameterDescriptors, localTypeSubstitutor, paramCopyConfiguration.dropOriginalInContainingParts, paramCopyConfiguration.preserveSourceElement, (boolean[])localObject3);
    if (localList == null) {
      return null;
    }
    KotlinType localKotlinType = localTypeSubstitutor.substitute(paramCopyConfiguration.newReturnType, Variance.OUT_VARIANCE);
    if (localKotlinType == null) {
      return null;
    }
    int j = localObject3[0];
    if (localKotlinType != paramCopyConfiguration.newReturnType) {
      i = 1;
    } else {
      i = 0;
    }
    localObject3[0] = (j | i);
    if ((localObject3[0] == 0) && (paramCopyConfiguration.justForTypeSubstitution)) {
      return this;
    }
    localFunctionDescriptorImpl.initialize((ReceiverParameterDescriptor)localObject1, (ReceiverParameterDescriptor)localObject2, localArrayList, localList, localKotlinType, paramCopyConfiguration.newModality, paramCopyConfiguration.newVisibility);
    localFunctionDescriptorImpl.setOperator(this.isOperator);
    localFunctionDescriptorImpl.setInfix(this.isInfix);
    localFunctionDescriptorImpl.setExternal(this.isExternal);
    localFunctionDescriptorImpl.setInline(this.isInline);
    localFunctionDescriptorImpl.setTailrec(this.isTailrec);
    localFunctionDescriptorImpl.setSuspend(this.isSuspend);
    localFunctionDescriptorImpl.setExpect(this.isExpect);
    localFunctionDescriptorImpl.setActual(this.isActual);
    localFunctionDescriptorImpl.setHasStableParameterNames(this.hasStableParameterNames);
    localFunctionDescriptorImpl.setHiddenToOvercomeSignatureClash(FunctionDescriptorImpl.CopyConfiguration.access$300(paramCopyConfiguration));
    localFunctionDescriptorImpl.setHiddenForResolutionEverywhereBesideSupercalls(FunctionDescriptorImpl.CopyConfiguration.access$400(paramCopyConfiguration));
    boolean bool;
    if (FunctionDescriptorImpl.CopyConfiguration.access$500(paramCopyConfiguration) != null) {
      bool = FunctionDescriptorImpl.CopyConfiguration.access$500(paramCopyConfiguration).booleanValue();
    } else {
      bool = this.hasSynthesizedParameterNames;
    }
    localFunctionDescriptorImpl.setHasSynthesizedParameterNames(bool);
    if ((!FunctionDescriptorImpl.CopyConfiguration.access$600(paramCopyConfiguration).isEmpty()) || (this.userDataMap != null))
    {
      localObject1 = FunctionDescriptorImpl.CopyConfiguration.access$600(paramCopyConfiguration);
      localObject2 = this.userDataMap;
      if (localObject2 != null)
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject2).next();
          if (!((Map)localObject1).containsKey(((Map.Entry)localObject3).getKey())) {
            ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), ((Map.Entry)localObject3).getValue());
          }
        }
      }
      if (((Map)localObject1).size() == 1) {
        localFunctionDescriptorImpl.userDataMap = Collections.singletonMap(((Map)localObject1).keySet().iterator().next(), ((Map)localObject1).values().iterator().next());
      } else {
        localFunctionDescriptorImpl.userDataMap = ((Map)localObject1);
      }
    }
    if ((paramCopyConfiguration.signatureChange) || (getInitialSignatureDescriptor() != null))
    {
      if (getInitialSignatureDescriptor() != null) {
        localObject1 = getInitialSignatureDescriptor();
      } else {
        localObject1 = this;
      }
      localFunctionDescriptorImpl.setInitialSignatureDescriptor(((FunctionDescriptor)localObject1).substitute(localTypeSubstitutor));
    }
    if ((paramCopyConfiguration.copyOverrides) && (!getOriginal().getOverriddenDescriptors().isEmpty()))
    {
      if (paramCopyConfiguration.substitution.isEmpty())
      {
        paramCopyConfiguration = this.lazyOverriddenFunctionsTask;
        if (paramCopyConfiguration != null)
        {
          localFunctionDescriptorImpl.lazyOverriddenFunctionsTask = paramCopyConfiguration;
          return localFunctionDescriptorImpl;
        }
        localFunctionDescriptorImpl.setOverriddenDescriptors(getOverriddenDescriptors());
        return localFunctionDescriptorImpl;
      }
      localFunctionDescriptorImpl.lazyOverriddenFunctionsTask = new FunctionDescriptorImpl.1(this, localTypeSubstitutor);
    }
    return localFunctionDescriptorImpl;
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
  public FunctionDescriptor getInitialSignatureDescriptor()
  {
    return this.initialSignatureDescriptor;
  }
  
  @NotNull
  public CallableMemberDescriptor.Kind getKind()
  {
    CallableMemberDescriptor.Kind localKind = this.kind;
    if (localKind == null) {
      $$$reportNull$$$0(19);
    }
    return localKind;
  }
  
  @NotNull
  public Modality getModality()
  {
    Modality localModality = this.modality;
    if (localModality == null) {
      $$$reportNull$$$0(13);
    }
    return localModality;
  }
  
  @NotNull
  public FunctionDescriptor getOriginal()
  {
    Object localObject = this.original;
    if (localObject == this) {
      localObject = this;
    } else {
      localObject = ((FunctionDescriptor)localObject).getOriginal();
    }
    if (localObject == null) {
      $$$reportNull$$$0(18);
    }
    return localObject;
  }
  
  @NotNull
  public Collection<? extends FunctionDescriptor> getOverriddenDescriptors()
  {
    performOverriddenLazyCalculationIfNeeded();
    Object localObject = this.overriddenFunctions;
    if (localObject == null) {
      localObject = Collections.emptyList();
    }
    if (localObject == null) {
      $$$reportNull$$$0(12);
    }
    return localObject;
  }
  
  public KotlinType getReturnType()
  {
    return this.unsubstitutedReturnType;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getTypeParameters()
  {
    List localList = this.typeParameters;
    if (localList == null) {
      $$$reportNull$$$0(16);
    }
    return localList;
  }
  
  public <V> V getUserData(CallableDescriptor.UserDataKey<V> paramUserDataKey)
  {
    Map localMap = this.userDataMap;
    if (localMap == null) {
      return null;
    }
    return localMap.get(paramUserDataKey);
  }
  
  @NotNull
  public List<ValueParameterDescriptor> getValueParameters()
  {
    List localList = this.unsubstitutedValueParameters;
    if (localList == null) {
      $$$reportNull$$$0(17);
    }
    return localList;
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    Visibility localVisibility = this.visibility;
    if (localVisibility == null) {
      $$$reportNull$$$0(14);
    }
    return localVisibility;
  }
  
  public boolean hasStableParameterNames()
  {
    return this.hasStableParameterNames;
  }
  
  public boolean hasSynthesizedParameterNames()
  {
    return this.hasSynthesizedParameterNames;
  }
  
  @NotNull
  public FunctionDescriptorImpl initialize(@Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor1, @Nullable ReceiverParameterDescriptor paramReceiverParameterDescriptor2, @NotNull List<? extends TypeParameterDescriptor> paramList, @NotNull List<ValueParameterDescriptor> paramList1, @Nullable KotlinType paramKotlinType, @Nullable Modality paramModality, @NotNull Visibility paramVisibility)
  {
    if (paramList == null) {
      $$$reportNull$$$0(5);
    }
    if (paramList1 == null) {
      $$$reportNull$$$0(6);
    }
    if (paramVisibility == null) {
      $$$reportNull$$$0(7);
    }
    this.typeParameters = CollectionsKt.toList(paramList);
    this.unsubstitutedValueParameters = CollectionsKt.toList(paramList1);
    this.unsubstitutedReturnType = paramKotlinType;
    this.modality = paramModality;
    this.visibility = paramVisibility;
    this.extensionReceiverParameter = paramReceiverParameterDescriptor1;
    this.dispatchReceiverParameter = paramReceiverParameterDescriptor2;
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramList.size()) {
        break label186;
      }
      paramReceiverParameterDescriptor1 = (TypeParameterDescriptor)paramList.get(i);
      if (paramReceiverParameterDescriptor1.getIndex() != i) {
        break;
      }
      i += 1;
    }
    paramReceiverParameterDescriptor2 = new StringBuilder();
    paramReceiverParameterDescriptor2.append(paramReceiverParameterDescriptor1);
    paramReceiverParameterDescriptor2.append(" index is ");
    paramReceiverParameterDescriptor2.append(paramReceiverParameterDescriptor1.getIndex());
    paramReceiverParameterDescriptor2.append(" but position is ");
    paramReceiverParameterDescriptor2.append(i);
    throw new IllegalStateException(paramReceiverParameterDescriptor2.toString());
    label186:
    while (j < paramList1.size())
    {
      paramReceiverParameterDescriptor1 = (ValueParameterDescriptor)paramList1.get(j);
      if (paramReceiverParameterDescriptor1.getIndex() == j + 0)
      {
        j += 1;
      }
      else
      {
        paramReceiverParameterDescriptor2 = new StringBuilder();
        paramReceiverParameterDescriptor2.append(paramReceiverParameterDescriptor1);
        paramReceiverParameterDescriptor2.append("index is ");
        paramReceiverParameterDescriptor2.append(paramReceiverParameterDescriptor1.getIndex());
        paramReceiverParameterDescriptor2.append(" but position is ");
        paramReceiverParameterDescriptor2.append(j);
        throw new IllegalStateException(paramReceiverParameterDescriptor2.toString());
      }
    }
    return this;
  }
  
  public boolean isActual()
  {
    return this.isActual;
  }
  
  public boolean isExpect()
  {
    return this.isExpect;
  }
  
  public boolean isExternal()
  {
    return this.isExternal;
  }
  
  public boolean isHiddenForResolutionEverywhereBesideSupercalls()
  {
    return this.isHiddenForResolutionEverywhereBesideSupercalls;
  }
  
  public boolean isHiddenToOvercomeSignatureClash()
  {
    return this.isHiddenToOvercomeSignatureClash;
  }
  
  public boolean isInfix()
  {
    if (this.isInfix) {
      return true;
    }
    Iterator localIterator = getOriginal().getOverriddenDescriptors().iterator();
    while (localIterator.hasNext()) {
      if (((FunctionDescriptor)localIterator.next()).isInfix()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isInline()
  {
    return this.isInline;
  }
  
  public boolean isOperator()
  {
    if (this.isOperator) {
      return true;
    }
    Iterator localIterator = getOriginal().getOverriddenDescriptors().iterator();
    while (localIterator.hasNext()) {
      if (((FunctionDescriptor)localIterator.next()).isOperator()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isSuspend()
  {
    return this.isSuspend;
  }
  
  public boolean isTailrec()
  {
    return this.isTailrec;
  }
  
  @NotNull
  public FunctionDescriptor.CopyBuilder<? extends FunctionDescriptor> newCopyBuilder()
  {
    FunctionDescriptorImpl.CopyConfiguration localCopyConfiguration = newCopyBuilder(TypeSubstitutor.EMPTY);
    if (localCopyConfiguration == null) {
      $$$reportNull$$$0(21);
    }
    return localCopyConfiguration;
  }
  
  @NotNull
  protected FunctionDescriptorImpl.CopyConfiguration newCopyBuilder(@NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(22);
    }
    return new FunctionDescriptorImpl.CopyConfiguration(this, paramTypeSubstitutor.getSubstitution(), getContainingDeclaration(), getModality(), getVisibility(), getKind(), getValueParameters(), getExtensionReceiverParameter(), getReturnType(), null);
  }
  
  public <V> void putInUserDataMap(CallableDescriptor.UserDataKey<V> paramUserDataKey, Object paramObject)
  {
    if (this.userDataMap == null) {
      this.userDataMap = new LinkedHashMap();
    }
    this.userDataMap.put(paramUserDataKey, paramObject);
  }
  
  public void setActual(boolean paramBoolean)
  {
    this.isActual = paramBoolean;
  }
  
  public void setExpect(boolean paramBoolean)
  {
    this.isExpect = paramBoolean;
  }
  
  public void setExternal(boolean paramBoolean)
  {
    this.isExternal = paramBoolean;
  }
  
  public void setHasStableParameterNames(boolean paramBoolean)
  {
    this.hasStableParameterNames = paramBoolean;
  }
  
  public void setHasSynthesizedParameterNames(boolean paramBoolean)
  {
    this.hasSynthesizedParameterNames = paramBoolean;
  }
  
  public void setInfix(boolean paramBoolean)
  {
    this.isInfix = paramBoolean;
  }
  
  public void setInline(boolean paramBoolean)
  {
    this.isInline = paramBoolean;
  }
  
  public void setOperator(boolean paramBoolean)
  {
    this.isOperator = paramBoolean;
  }
  
  public void setOverriddenDescriptors(@NotNull Collection<? extends CallableMemberDescriptor> paramCollection)
  {
    if (paramCollection == null) {
      $$$reportNull$$$0(15);
    }
    this.overriddenFunctions = paramCollection;
    paramCollection = this.overriddenFunctions.iterator();
    while (paramCollection.hasNext()) {
      if (((FunctionDescriptor)paramCollection.next()).isHiddenForResolutionEverywhereBesideSupercalls()) {
        this.isHiddenForResolutionEverywhereBesideSupercalls = true;
      }
    }
  }
  
  public void setReturnType(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(10);
    }
    KotlinType localKotlinType = this.unsubstitutedReturnType;
    this.unsubstitutedReturnType = paramKotlinType;
  }
  
  public void setSuspend(boolean paramBoolean)
  {
    this.isSuspend = paramBoolean;
  }
  
  public void setTailrec(boolean paramBoolean)
  {
    this.isTailrec = paramBoolean;
  }
  
  public void setVisibility(@NotNull Visibility paramVisibility)
  {
    if (paramVisibility == null) {
      $$$reportNull$$$0(9);
    }
    this.visibility = paramVisibility;
  }
  
  public FunctionDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(20);
    }
    if (paramTypeSubstitutor.isEmpty()) {
      return this;
    }
    return newCopyBuilder(paramTypeSubstitutor).setOriginal(getOriginal()).setPreserveSourceElement().setJustForTypeSubstitution(true).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */