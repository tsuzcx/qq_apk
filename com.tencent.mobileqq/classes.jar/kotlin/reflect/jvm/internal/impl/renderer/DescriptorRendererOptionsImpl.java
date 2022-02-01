package kotlin.reflect.jvm.internal.impl.renderer;

import java.lang.reflect.Field;
import java.util.Set;
import kotlin._Assertions;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorRendererOptionsImpl
  implements DescriptorRendererOptions
{
  @NotNull
  private final ReadWriteProperty actualPropertiesInPrimaryConstructor$delegate;
  @NotNull
  private final ReadWriteProperty alwaysRenderModifiers$delegate;
  @NotNull
  private final ReadWriteProperty annotationArgumentsRenderingPolicy$delegate;
  @Nullable
  private final ReadWriteProperty annotationFilter$delegate;
  @NotNull
  private final ReadWriteProperty boldOnlyForNamesInHtml$delegate;
  @NotNull
  private final ReadWriteProperty classWithPrimaryConstructor$delegate;
  @NotNull
  private final ReadWriteProperty classifierNamePolicy$delegate = property(ClassifierNamePolicy.SOURCE_CODE_QUALIFIED.INSTANCE);
  @NotNull
  private final ReadWriteProperty debugMode$delegate;
  @Nullable
  private final ReadWriteProperty defaultParameterValueRenderer$delegate;
  @NotNull
  private final ReadWriteProperty eachAnnotationOnNewLine$delegate;
  @NotNull
  private final ReadWriteProperty enhancedTypes$delegate;
  @NotNull
  private final ReadWriteProperty excludedAnnotationClasses$delegate;
  @NotNull
  private final ReadWriteProperty excludedTypeAnnotationClasses$delegate;
  @NotNull
  private final ReadWriteProperty includeAdditionalModifiers$delegate;
  @NotNull
  private final ReadWriteProperty includePropertyConstant$delegate;
  @NotNull
  private final ReadWriteProperty informativeErrorType$delegate;
  private boolean isLocked;
  @NotNull
  private final ReadWriteProperty modifiers$delegate;
  @NotNull
  private final ReadWriteProperty normalizedVisibilities$delegate;
  @NotNull
  private final ReadWriteProperty overrideRenderingPolicy$delegate;
  @NotNull
  private final ReadWriteProperty parameterNameRenderingPolicy$delegate;
  @NotNull
  private final ReadWriteProperty parameterNamesInFunctionalTypes$delegate;
  @NotNull
  private final ReadWriteProperty presentableUnresolvedTypes$delegate;
  @NotNull
  private final ReadWriteProperty propertyAccessorRenderingPolicy$delegate;
  @NotNull
  private final ReadWriteProperty receiverAfterName$delegate;
  @NotNull
  private final ReadWriteProperty renderCompanionObjectName$delegate;
  @NotNull
  private final ReadWriteProperty renderConstructorDelegation$delegate;
  @NotNull
  private final ReadWriteProperty renderConstructorKeyword$delegate;
  @NotNull
  private final ReadWriteProperty renderDefaultAnnotationArguments$delegate;
  @NotNull
  private final ReadWriteProperty renderDefaultModality$delegate;
  @NotNull
  private final ReadWriteProperty renderDefaultVisibility$delegate;
  @NotNull
  private final ReadWriteProperty renderFunctionContracts$delegate;
  @NotNull
  private final ReadWriteProperty renderPrimaryConstructorParametersAsProperties$delegate;
  @NotNull
  private final ReadWriteProperty renderTypeExpansions$delegate;
  @NotNull
  private final ReadWriteProperty renderUnabbreviatedType$delegate;
  @NotNull
  private final ReadWriteProperty secondaryConstructorsAsPrimary$delegate;
  @NotNull
  private final ReadWriteProperty startFromDeclarationKeyword$delegate;
  @NotNull
  private final ReadWriteProperty startFromName$delegate;
  @NotNull
  private final ReadWriteProperty textFormat$delegate;
  @NotNull
  private final ReadWriteProperty typeNormalizer$delegate;
  @NotNull
  private final ReadWriteProperty uninferredTypeParameterAsName$delegate;
  @NotNull
  private final ReadWriteProperty unitReturnType$delegate;
  @NotNull
  private final ReadWriteProperty valueParametersHandler$delegate;
  @NotNull
  private final ReadWriteProperty verbose$delegate;
  @NotNull
  private final ReadWriteProperty withDefinedIn$delegate;
  @NotNull
  private final ReadWriteProperty withSourceFileForTopLevel$delegate;
  @NotNull
  private final ReadWriteProperty withoutReturnType$delegate;
  @NotNull
  private final ReadWriteProperty withoutSuperTypes$delegate;
  @NotNull
  private final ReadWriteProperty withoutTypeParameters$delegate;
  
  public DescriptorRendererOptionsImpl()
  {
    Boolean localBoolean1 = Boolean.valueOf(true);
    this.withDefinedIn$delegate = property(localBoolean1);
    this.withSourceFileForTopLevel$delegate = property(localBoolean1);
    this.modifiers$delegate = property(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
    Boolean localBoolean2 = Boolean.valueOf(false);
    this.startFromName$delegate = property(localBoolean2);
    this.startFromDeclarationKeyword$delegate = property(localBoolean2);
    this.debugMode$delegate = property(localBoolean2);
    this.classWithPrimaryConstructor$delegate = property(localBoolean2);
    this.verbose$delegate = property(localBoolean2);
    this.unitReturnType$delegate = property(localBoolean1);
    this.withoutReturnType$delegate = property(localBoolean2);
    this.enhancedTypes$delegate = property(localBoolean2);
    this.normalizedVisibilities$delegate = property(localBoolean2);
    this.renderDefaultVisibility$delegate = property(localBoolean1);
    this.renderDefaultModality$delegate = property(localBoolean1);
    this.renderConstructorDelegation$delegate = property(localBoolean2);
    this.renderPrimaryConstructorParametersAsProperties$delegate = property(localBoolean2);
    this.actualPropertiesInPrimaryConstructor$delegate = property(localBoolean2);
    this.uninferredTypeParameterAsName$delegate = property(localBoolean2);
    this.includePropertyConstant$delegate = property(localBoolean2);
    this.withoutTypeParameters$delegate = property(localBoolean2);
    this.withoutSuperTypes$delegate = property(localBoolean2);
    this.typeNormalizer$delegate = property(DescriptorRendererOptionsImpl.typeNormalizer.2.INSTANCE);
    this.defaultParameterValueRenderer$delegate = property(DescriptorRendererOptionsImpl.defaultParameterValueRenderer.2.INSTANCE);
    this.secondaryConstructorsAsPrimary$delegate = property(localBoolean1);
    this.overrideRenderingPolicy$delegate = property(OverrideRenderingPolicy.RENDER_OPEN);
    this.valueParametersHandler$delegate = property(DescriptorRenderer.ValueParametersHandler.DEFAULT.INSTANCE);
    this.textFormat$delegate = property(RenderingFormat.PLAIN);
    this.parameterNameRenderingPolicy$delegate = property(ParameterNameRenderingPolicy.ALL);
    this.receiverAfterName$delegate = property(localBoolean2);
    this.renderCompanionObjectName$delegate = property(localBoolean2);
    this.propertyAccessorRenderingPolicy$delegate = property(PropertyAccessorRenderingPolicy.DEBUG);
    this.renderDefaultAnnotationArguments$delegate = property(localBoolean2);
    this.eachAnnotationOnNewLine$delegate = property(localBoolean2);
    this.excludedAnnotationClasses$delegate = property(SetsKt.emptySet());
    this.excludedTypeAnnotationClasses$delegate = property(ExcludedTypeAnnotations.INSTANCE.getInternalAnnotationsForResolve());
    this.annotationFilter$delegate = property(null);
    this.annotationArgumentsRenderingPolicy$delegate = property(AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);
    this.alwaysRenderModifiers$delegate = property(localBoolean2);
    this.renderConstructorKeyword$delegate = property(localBoolean1);
    this.renderUnabbreviatedType$delegate = property(localBoolean1);
    this.renderTypeExpansions$delegate = property(localBoolean2);
    this.includeAdditionalModifiers$delegate = property(localBoolean1);
    this.parameterNamesInFunctionalTypes$delegate = property(localBoolean1);
    this.renderFunctionContracts$delegate = property(localBoolean2);
    this.presentableUnresolvedTypes$delegate = property(localBoolean2);
    this.boldOnlyForNamesInHtml$delegate = property(localBoolean2);
    this.informativeErrorType$delegate = property(localBoolean1);
  }
  
  private final <T> ReadWriteProperty<DescriptorRendererOptionsImpl, T> property(T paramT)
  {
    Delegates localDelegates = Delegates.INSTANCE;
    return (ReadWriteProperty)new DescriptorRendererOptionsImpl.property..inlined.vetoable.1(paramT, paramT, this);
  }
  
  @NotNull
  public final DescriptorRendererOptionsImpl copy()
  {
    DescriptorRendererOptionsImpl localDescriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
    Field[] arrayOfField = getClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      Intrinsics.checkExpressionValueIsNotNull(localField, "field");
      if ((localField.getModifiers() & 0x8) == 0)
      {
        localField.setAccessible(true);
        Object localObject2 = localField.get(this);
        Object localObject1 = localObject2;
        if (!(localObject2 instanceof ObservableProperty)) {
          localObject1 = null;
        }
        localObject1 = (ObservableProperty)localObject1;
        if (localObject1 != null)
        {
          localObject2 = localField.getName();
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "field.name");
          boolean bool = StringsKt.startsWith$default((String)localObject2, "is", false, 2, null);
          if ((_Assertions.ENABLED) && (!(true ^ bool))) {
            throw ((Throwable)new AssertionError("Fields named is* are not supported here yet"));
          }
          localObject2 = (KDeclarationContainer)Reflection.getOrCreateKotlinClass(DescriptorRendererOptionsImpl.class);
          String str1 = localField.getName();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("get");
          String str2 = localField.getName();
          Intrinsics.checkExpressionValueIsNotNull(str2, "field.name");
          localStringBuilder.append(StringsKt.capitalize(str2));
          localField.set(localDescriptorRendererOptionsImpl, localDescriptorRendererOptionsImpl.property(((ObservableProperty)localObject1).getValue(this, (KProperty)new PropertyReference1Impl((KDeclarationContainer)localObject2, str1, localStringBuilder.toString()))));
        }
      }
      i += 1;
    }
    return localDescriptorRendererOptionsImpl;
  }
  
  public boolean getActualPropertiesInPrimaryConstructor()
  {
    return ((Boolean)this.actualPropertiesInPrimaryConstructor$delegate.getValue(this, $$delegatedProperties[17])).booleanValue();
  }
  
  public boolean getAlwaysRenderModifiers()
  {
    return ((Boolean)this.alwaysRenderModifiers$delegate.getValue(this, $$delegatedProperties[38])).booleanValue();
  }
  
  @NotNull
  public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy()
  {
    return (AnnotationArgumentsRenderingPolicy)this.annotationArgumentsRenderingPolicy$delegate.getValue(this, $$delegatedProperties[37]);
  }
  
  @Nullable
  public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter()
  {
    return (Function1)this.annotationFilter$delegate.getValue(this, $$delegatedProperties[36]);
  }
  
  public boolean getBoldOnlyForNamesInHtml()
  {
    return ((Boolean)this.boldOnlyForNamesInHtml$delegate.getValue(this, $$delegatedProperties[46])).booleanValue();
  }
  
  public boolean getClassWithPrimaryConstructor()
  {
    return ((Boolean)this.classWithPrimaryConstructor$delegate.getValue(this, $$delegatedProperties[7])).booleanValue();
  }
  
  @NotNull
  public ClassifierNamePolicy getClassifierNamePolicy()
  {
    return (ClassifierNamePolicy)this.classifierNamePolicy$delegate.getValue(this, $$delegatedProperties[0]);
  }
  
  public boolean getDebugMode()
  {
    return ((Boolean)this.debugMode$delegate.getValue(this, $$delegatedProperties[6])).booleanValue();
  }
  
  @Nullable
  public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer()
  {
    return (Function1)this.defaultParameterValueRenderer$delegate.getValue(this, $$delegatedProperties[23]);
  }
  
  public boolean getEachAnnotationOnNewLine()
  {
    return ((Boolean)this.eachAnnotationOnNewLine$delegate.getValue(this, $$delegatedProperties[33])).booleanValue();
  }
  
  public boolean getEnhancedTypes()
  {
    return ((Boolean)this.enhancedTypes$delegate.getValue(this, $$delegatedProperties[11])).booleanValue();
  }
  
  @NotNull
  public Set<FqName> getExcludedAnnotationClasses()
  {
    return (Set)this.excludedAnnotationClasses$delegate.getValue(this, $$delegatedProperties[34]);
  }
  
  @NotNull
  public Set<FqName> getExcludedTypeAnnotationClasses()
  {
    return (Set)this.excludedTypeAnnotationClasses$delegate.getValue(this, $$delegatedProperties[35]);
  }
  
  public boolean getIncludeAdditionalModifiers()
  {
    return ((Boolean)this.includeAdditionalModifiers$delegate.getValue(this, $$delegatedProperties[42])).booleanValue();
  }
  
  public boolean getIncludeAnnotationArguments()
  {
    return DescriptorRendererOptions.DefaultImpls.getIncludeAnnotationArguments(this);
  }
  
  public boolean getIncludeEmptyAnnotationArguments()
  {
    return DescriptorRendererOptions.DefaultImpls.getIncludeEmptyAnnotationArguments(this);
  }
  
  public boolean getIncludePropertyConstant()
  {
    return ((Boolean)this.includePropertyConstant$delegate.getValue(this, $$delegatedProperties[19])).booleanValue();
  }
  
  public boolean getInformativeErrorType()
  {
    return ((Boolean)this.informativeErrorType$delegate.getValue(this, $$delegatedProperties[47])).booleanValue();
  }
  
  @NotNull
  public Set<DescriptorRendererModifier> getModifiers()
  {
    return (Set)this.modifiers$delegate.getValue(this, $$delegatedProperties[3]);
  }
  
  public boolean getNormalizedVisibilities()
  {
    return ((Boolean)this.normalizedVisibilities$delegate.getValue(this, $$delegatedProperties[12])).booleanValue();
  }
  
  @NotNull
  public OverrideRenderingPolicy getOverrideRenderingPolicy()
  {
    return (OverrideRenderingPolicy)this.overrideRenderingPolicy$delegate.getValue(this, $$delegatedProperties[25]);
  }
  
  @NotNull
  public ParameterNameRenderingPolicy getParameterNameRenderingPolicy()
  {
    return (ParameterNameRenderingPolicy)this.parameterNameRenderingPolicy$delegate.getValue(this, $$delegatedProperties[28]);
  }
  
  public boolean getParameterNamesInFunctionalTypes()
  {
    return ((Boolean)this.parameterNamesInFunctionalTypes$delegate.getValue(this, $$delegatedProperties[43])).booleanValue();
  }
  
  public boolean getPresentableUnresolvedTypes()
  {
    return ((Boolean)this.presentableUnresolvedTypes$delegate.getValue(this, $$delegatedProperties[45])).booleanValue();
  }
  
  @NotNull
  public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy()
  {
    return (PropertyAccessorRenderingPolicy)this.propertyAccessorRenderingPolicy$delegate.getValue(this, $$delegatedProperties[31]);
  }
  
  public boolean getReceiverAfterName()
  {
    return ((Boolean)this.receiverAfterName$delegate.getValue(this, $$delegatedProperties[29])).booleanValue();
  }
  
  public boolean getRenderCompanionObjectName()
  {
    return ((Boolean)this.renderCompanionObjectName$delegate.getValue(this, $$delegatedProperties[30])).booleanValue();
  }
  
  public boolean getRenderConstructorDelegation()
  {
    return ((Boolean)this.renderConstructorDelegation$delegate.getValue(this, $$delegatedProperties[15])).booleanValue();
  }
  
  public boolean getRenderConstructorKeyword()
  {
    return ((Boolean)this.renderConstructorKeyword$delegate.getValue(this, $$delegatedProperties[39])).booleanValue();
  }
  
  public boolean getRenderDefaultAnnotationArguments()
  {
    return ((Boolean)this.renderDefaultAnnotationArguments$delegate.getValue(this, $$delegatedProperties[32])).booleanValue();
  }
  
  public boolean getRenderDefaultModality()
  {
    return ((Boolean)this.renderDefaultModality$delegate.getValue(this, $$delegatedProperties[14])).booleanValue();
  }
  
  public boolean getRenderDefaultVisibility()
  {
    return ((Boolean)this.renderDefaultVisibility$delegate.getValue(this, $$delegatedProperties[13])).booleanValue();
  }
  
  public boolean getRenderPrimaryConstructorParametersAsProperties()
  {
    return ((Boolean)this.renderPrimaryConstructorParametersAsProperties$delegate.getValue(this, $$delegatedProperties[16])).booleanValue();
  }
  
  public boolean getRenderTypeExpansions()
  {
    return ((Boolean)this.renderTypeExpansions$delegate.getValue(this, $$delegatedProperties[41])).booleanValue();
  }
  
  public boolean getRenderUnabbreviatedType()
  {
    return ((Boolean)this.renderUnabbreviatedType$delegate.getValue(this, $$delegatedProperties[40])).booleanValue();
  }
  
  public boolean getSecondaryConstructorsAsPrimary()
  {
    return ((Boolean)this.secondaryConstructorsAsPrimary$delegate.getValue(this, $$delegatedProperties[24])).booleanValue();
  }
  
  public boolean getStartFromDeclarationKeyword()
  {
    return ((Boolean)this.startFromDeclarationKeyword$delegate.getValue(this, $$delegatedProperties[5])).booleanValue();
  }
  
  public boolean getStartFromName()
  {
    return ((Boolean)this.startFromName$delegate.getValue(this, $$delegatedProperties[4])).booleanValue();
  }
  
  @NotNull
  public RenderingFormat getTextFormat()
  {
    return (RenderingFormat)this.textFormat$delegate.getValue(this, $$delegatedProperties[27]);
  }
  
  @NotNull
  public Function1<KotlinType, KotlinType> getTypeNormalizer()
  {
    return (Function1)this.typeNormalizer$delegate.getValue(this, $$delegatedProperties[22]);
  }
  
  public boolean getUninferredTypeParameterAsName()
  {
    return ((Boolean)this.uninferredTypeParameterAsName$delegate.getValue(this, $$delegatedProperties[18])).booleanValue();
  }
  
  public boolean getUnitReturnType()
  {
    return ((Boolean)this.unitReturnType$delegate.getValue(this, $$delegatedProperties[9])).booleanValue();
  }
  
  @NotNull
  public DescriptorRenderer.ValueParametersHandler getValueParametersHandler()
  {
    return (DescriptorRenderer.ValueParametersHandler)this.valueParametersHandler$delegate.getValue(this, $$delegatedProperties[26]);
  }
  
  public boolean getVerbose()
  {
    return ((Boolean)this.verbose$delegate.getValue(this, $$delegatedProperties[8])).booleanValue();
  }
  
  public boolean getWithDefinedIn()
  {
    return ((Boolean)this.withDefinedIn$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
  }
  
  public boolean getWithSourceFileForTopLevel()
  {
    return ((Boolean)this.withSourceFileForTopLevel$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
  }
  
  public boolean getWithoutReturnType()
  {
    return ((Boolean)this.withoutReturnType$delegate.getValue(this, $$delegatedProperties[10])).booleanValue();
  }
  
  public boolean getWithoutSuperTypes()
  {
    return ((Boolean)this.withoutSuperTypes$delegate.getValue(this, $$delegatedProperties[21])).booleanValue();
  }
  
  public boolean getWithoutTypeParameters()
  {
    return ((Boolean)this.withoutTypeParameters$delegate.getValue(this, $$delegatedProperties[20])).booleanValue();
  }
  
  public final boolean isLocked()
  {
    return this.isLocked;
  }
  
  public final void lock()
  {
    boolean bool = this.isLocked;
    if ((_Assertions.ENABLED) && (!(bool ^ true))) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    this.isLocked = true;
  }
  
  public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy paramAnnotationArgumentsRenderingPolicy)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationArgumentsRenderingPolicy, "<set-?>");
    this.annotationArgumentsRenderingPolicy$delegate.setValue(this, $$delegatedProperties[37], paramAnnotationArgumentsRenderingPolicy);
  }
  
  public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy paramClassifierNamePolicy)
  {
    Intrinsics.checkParameterIsNotNull(paramClassifierNamePolicy, "<set-?>");
    this.classifierNamePolicy$delegate.setValue(this, $$delegatedProperties[0], paramClassifierNamePolicy);
  }
  
  public void setDebugMode(boolean paramBoolean)
  {
    this.debugMode$delegate.setValue(this, $$delegatedProperties[6], Boolean.valueOf(paramBoolean));
  }
  
  public void setExcludedTypeAnnotationClasses(@NotNull Set<FqName> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "<set-?>");
    this.excludedTypeAnnotationClasses$delegate.setValue(this, $$delegatedProperties[35], paramSet);
  }
  
  public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "<set-?>");
    this.modifiers$delegate.setValue(this, $$delegatedProperties[3], paramSet);
  }
  
  public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy paramParameterNameRenderingPolicy)
  {
    Intrinsics.checkParameterIsNotNull(paramParameterNameRenderingPolicy, "<set-?>");
    this.parameterNameRenderingPolicy$delegate.setValue(this, $$delegatedProperties[28], paramParameterNameRenderingPolicy);
  }
  
  public void setReceiverAfterName(boolean paramBoolean)
  {
    this.receiverAfterName$delegate.setValue(this, $$delegatedProperties[29], Boolean.valueOf(paramBoolean));
  }
  
  public void setRenderCompanionObjectName(boolean paramBoolean)
  {
    this.renderCompanionObjectName$delegate.setValue(this, $$delegatedProperties[30], Boolean.valueOf(paramBoolean));
  }
  
  public void setStartFromName(boolean paramBoolean)
  {
    this.startFromName$delegate.setValue(this, $$delegatedProperties[4], Boolean.valueOf(paramBoolean));
  }
  
  public void setTextFormat(@NotNull RenderingFormat paramRenderingFormat)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderingFormat, "<set-?>");
    this.textFormat$delegate.setValue(this, $$delegatedProperties[27], paramRenderingFormat);
  }
  
  public void setVerbose(boolean paramBoolean)
  {
    this.verbose$delegate.setValue(this, $$delegatedProperties[8], Boolean.valueOf(paramBoolean));
  }
  
  public void setWithDefinedIn(boolean paramBoolean)
  {
    this.withDefinedIn$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(paramBoolean));
  }
  
  public void setWithoutSuperTypes(boolean paramBoolean)
  {
    this.withoutSuperTypes$delegate.setValue(this, $$delegatedProperties[21], Boolean.valueOf(paramBoolean));
  }
  
  public void setWithoutTypeParameters(boolean paramBoolean)
  {
    this.withoutTypeParameters$delegate.setValue(this, $$delegatedProperties[20], Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl
 * JD-Core Version:    0.7.0.1
 */