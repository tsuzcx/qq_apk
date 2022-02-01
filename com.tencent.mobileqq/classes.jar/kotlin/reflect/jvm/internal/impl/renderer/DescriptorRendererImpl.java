package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PossiblyInnerType;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotated;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbbreviatedType;
import kotlin.reflect.jvm.internal.impl.types.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils.UninferredParameterTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.UnresolvedType;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.WrappedType;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorRendererImpl
  extends DescriptorRenderer
  implements DescriptorRendererOptions
{
  private final Lazy functionTypeAnnotationsRenderer$delegate;
  private final Lazy functionTypeParameterTypesRenderer$delegate;
  @NotNull
  private final DescriptorRendererOptionsImpl options;
  
  public DescriptorRendererImpl(@NotNull DescriptorRendererOptionsImpl paramDescriptorRendererOptionsImpl)
  {
    this.options = paramDescriptorRendererOptionsImpl;
    boolean bool = this.options.isLocked();
    if ((_Assertions.ENABLED) && (!bool)) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    this.functionTypeAnnotationsRenderer$delegate = LazyKt.lazy((Function0)new DescriptorRendererImpl.functionTypeAnnotationsRenderer.2(this));
    this.functionTypeParameterTypesRenderer$delegate = LazyKt.lazy((Function0)new DescriptorRendererImpl.functionTypeParameterTypesRenderer.2(this));
  }
  
  private final void appendDefinedIn(@NotNull StringBuilder paramStringBuilder, DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (!(paramDeclarationDescriptor instanceof PackageFragmentDescriptor))
    {
      if ((paramDeclarationDescriptor instanceof PackageViewDescriptor)) {
        return;
      }
      if ((paramDeclarationDescriptor instanceof ModuleDescriptor))
      {
        paramStringBuilder.append(" is a module");
        return;
      }
      DeclarationDescriptor localDeclarationDescriptor = paramDeclarationDescriptor.getContainingDeclaration();
      if ((localDeclarationDescriptor != null) && (!(localDeclarationDescriptor instanceof ModuleDescriptor)))
      {
        paramStringBuilder.append(" ");
        paramStringBuilder.append(renderMessage("defined in"));
        paramStringBuilder.append(" ");
        Object localObject = DescriptorUtils.getFqName(localDeclarationDescriptor);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "DescriptorUtils.getFqName(containingDeclaration)");
        if (((FqNameUnsafe)localObject).isRoot()) {
          localObject = "root package";
        } else {
          localObject = renderFqName((FqNameUnsafe)localObject);
        }
        paramStringBuilder.append((String)localObject);
        if ((getWithSourceFileForTopLevel()) && ((localDeclarationDescriptor instanceof PackageFragmentDescriptor)) && ((paramDeclarationDescriptor instanceof DeclarationDescriptorWithSource)))
        {
          paramDeclarationDescriptor = ((DeclarationDescriptorWithSource)paramDeclarationDescriptor).getSource();
          Intrinsics.checkExpressionValueIsNotNull(paramDeclarationDescriptor, "descriptor.source");
          paramDeclarationDescriptor = paramDeclarationDescriptor.getContainingFile();
          Intrinsics.checkExpressionValueIsNotNull(paramDeclarationDescriptor, "descriptor.source.containingFile");
          paramDeclarationDescriptor = paramDeclarationDescriptor.getName();
          if (paramDeclarationDescriptor != null)
          {
            paramStringBuilder.append(" ");
            paramStringBuilder.append(renderMessage("in file"));
            paramStringBuilder.append(" ");
            paramStringBuilder.append(paramDeclarationDescriptor);
          }
        }
      }
    }
  }
  
  private final void appendTypeProjections(@NotNull StringBuilder paramStringBuilder, List<? extends TypeProjection> paramList)
  {
    CollectionsKt.joinTo$default((Iterable)paramList, (Appendable)paramStringBuilder, (CharSequence)", ", null, null, 0, null, (Function1)new DescriptorRendererImpl.appendTypeProjections.1(this), 60, null);
  }
  
  private final String arrow()
  {
    RenderingFormat localRenderingFormat = getTextFormat();
    int i = DescriptorRendererImpl.WhenMappings.$EnumSwitchMapping$2[localRenderingFormat.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return "&rarr;";
      }
      throw new NoWhenBranchMatchedException();
    }
    return escape("->");
  }
  
  private final boolean differsOnlyInNullability(String paramString1, String paramString2)
  {
    boolean bool2 = Intrinsics.areEqual(paramString1, StringsKt.replace$default(paramString2, "?", "", false, 4, null));
    boolean bool1 = false;
    if (!bool2)
    {
      StringBuilder localStringBuilder;
      if (StringsKt.endsWith$default(paramString2, "?", false, 2, null))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append('?');
        if (Intrinsics.areEqual(localStringBuilder.toString(), paramString2)) {}
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append('(');
        localStringBuilder.append(paramString1);
        localStringBuilder.append(")?");
        if (!Intrinsics.areEqual(localStringBuilder.toString(), paramString2)) {
          return bool1;
        }
      }
    }
    bool1 = true;
    return bool1;
  }
  
  private final String escape(String paramString)
  {
    return getTextFormat().escape(paramString);
  }
  
  private final DescriptorRendererImpl getFunctionTypeAnnotationsRenderer()
  {
    return (DescriptorRendererImpl)this.functionTypeAnnotationsRenderer$delegate.getValue();
  }
  
  private final DescriptorRenderer getFunctionTypeParameterTypesRenderer()
  {
    return (DescriptorRenderer)this.functionTypeParameterTypesRenderer$delegate.getValue();
  }
  
  private final String gt()
  {
    return escape(">");
  }
  
  private final boolean hasModifiersOrAnnotations(@NotNull KotlinType paramKotlinType)
  {
    return (FunctionTypesKt.isSuspendFunctionType(paramKotlinType)) || (!paramKotlinType.getAnnotations().isEmpty());
  }
  
  private final Modality implicitModalityWithoutExtensions(@NotNull MemberDescriptor paramMemberDescriptor)
  {
    if ((paramMemberDescriptor instanceof ClassDescriptor))
    {
      if (((ClassDescriptor)paramMemberDescriptor).getKind() == ClassKind.INTERFACE) {
        return Modality.ABSTRACT;
      }
      return Modality.FINAL;
    }
    Object localObject2 = paramMemberDescriptor.getContainingDeclaration();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof ClassDescriptor)) {
      localObject1 = null;
    }
    localObject1 = (ClassDescriptor)localObject1;
    if (localObject1 != null)
    {
      if (!(paramMemberDescriptor instanceof CallableMemberDescriptor)) {
        return Modality.FINAL;
      }
      paramMemberDescriptor = (CallableMemberDescriptor)paramMemberDescriptor;
      localObject2 = paramMemberDescriptor.getOverriddenDescriptors();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "this.overriddenDescriptors");
      if (((((Collection)localObject2).isEmpty() ^ true)) && (((ClassDescriptor)localObject1).getModality() != Modality.FINAL)) {
        return Modality.OPEN;
      }
      if ((((ClassDescriptor)localObject1).getKind() == ClassKind.INTERFACE) && ((Intrinsics.areEqual(paramMemberDescriptor.getVisibility(), Visibilities.PRIVATE) ^ true)))
      {
        if (paramMemberDescriptor.getModality() == Modality.ABSTRACT) {
          return Modality.ABSTRACT;
        }
        return Modality.OPEN;
      }
      return Modality.FINAL;
    }
    return Modality.FINAL;
  }
  
  private final String lt()
  {
    return escape("<");
  }
  
  private final boolean overridesSomething(CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    return paramCallableMemberDescriptor.getOverriddenDescriptors().isEmpty() ^ true;
  }
  
  private final void renderAbbreviatedTypeExpansion(@NotNull StringBuilder paramStringBuilder, AbbreviatedType paramAbbreviatedType)
  {
    if (getTextFormat() == RenderingFormat.HTML) {
      paramStringBuilder.append("<font color=\"808080\"><i>");
    }
    paramStringBuilder.append(" /* = ");
    renderNormalizedTypeAsIs(paramStringBuilder, (KotlinType)paramAbbreviatedType.getExpandedType());
    paramStringBuilder.append(" */");
    if (getTextFormat() == RenderingFormat.HTML) {
      paramStringBuilder.append("</i></font>");
    }
  }
  
  private final void renderAccessorModifiers(PropertyAccessorDescriptor paramPropertyAccessorDescriptor, StringBuilder paramStringBuilder)
  {
    renderMemberModifiers((MemberDescriptor)paramPropertyAccessorDescriptor, paramStringBuilder);
  }
  
  private final void renderAdditionalModifiers(FunctionDescriptor paramFunctionDescriptor, StringBuilder paramStringBuilder)
  {
    boolean bool1 = paramFunctionDescriptor.isOperator();
    boolean bool3 = false;
    Object localObject;
    int i;
    FunctionDescriptor localFunctionDescriptor;
    if (bool1)
    {
      localObject = paramFunctionDescriptor.getOverriddenDescriptors();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "functionDescriptor.overriddenDescriptors");
      localObject = (Iterable)localObject;
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject).hasNext())
        {
          i = 1;
          break;
          localObject = ((Iterable)localObject).iterator();
        }
        localFunctionDescriptor = (FunctionDescriptor)((Iterator)localObject).next();
        Intrinsics.checkExpressionValueIsNotNull(localFunctionDescriptor, "it");
      } while (!localFunctionDescriptor.isOperator());
      i = 0;
      if ((i != 0) || (getAlwaysRenderModifiers()))
      {
        bool1 = true;
        break label136;
      }
    }
    bool1 = false;
    label136:
    boolean bool2 = bool3;
    if (paramFunctionDescriptor.isInfix())
    {
      localObject = paramFunctionDescriptor.getOverriddenDescriptors();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "functionDescriptor.overriddenDescriptors");
      localObject = (Iterable)localObject;
      if (((localObject instanceof Collection)) && (((Collection)localObject).isEmpty())) {}
      do
      {
        while (!((Iterator)localObject).hasNext())
        {
          i = 1;
          break;
          localObject = ((Iterable)localObject).iterator();
        }
        localFunctionDescriptor = (FunctionDescriptor)((Iterator)localObject).next();
        Intrinsics.checkExpressionValueIsNotNull(localFunctionDescriptor, "it");
      } while (!localFunctionDescriptor.isInfix());
      i = 0;
      if (i == 0)
      {
        bool2 = bool3;
        if (!getAlwaysRenderModifiers()) {}
      }
      else
      {
        bool2 = true;
      }
    }
    renderModifier(paramStringBuilder, paramFunctionDescriptor.isTailrec(), "tailrec");
    renderSuspendModifier(paramFunctionDescriptor, paramStringBuilder);
    renderModifier(paramStringBuilder, paramFunctionDescriptor.isInline(), "inline");
    renderModifier(paramStringBuilder, bool2, "infix");
    renderModifier(paramStringBuilder, bool1, "operator");
  }
  
  private final List<String> renderAndSortAnnotationArguments(AnnotationDescriptor paramAnnotationDescriptor)
  {
    Object localObject3 = paramAnnotationDescriptor.getAllValueArguments();
    boolean bool = getRenderDefaultAnnotationArguments();
    Object localObject2 = null;
    if (bool) {
      localObject1 = DescriptorUtilsKt.getAnnotationClass(paramAnnotationDescriptor);
    } else {
      localObject1 = null;
    }
    paramAnnotationDescriptor = (AnnotationDescriptor)localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((ClassDescriptor)localObject1).getUnsubstitutedPrimaryConstructor();
      paramAnnotationDescriptor = (AnnotationDescriptor)localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((ClassConstructorDescriptor)localObject1).getValueParameters();
        paramAnnotationDescriptor = (AnnotationDescriptor)localObject2;
        if (localObject1 != null)
        {
          localObject1 = (Iterable)localObject1;
          paramAnnotationDescriptor = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = ((Iterator)localObject1).next();
            if (((ValueParameterDescriptor)localObject2).declaresDefaultValue()) {
              paramAnnotationDescriptor.add(localObject2);
            }
          }
          localObject1 = (Iterable)paramAnnotationDescriptor;
          paramAnnotationDescriptor = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ValueParameterDescriptor)((Iterator)localObject1).next();
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "it");
            paramAnnotationDescriptor.add(((ValueParameterDescriptor)localObject2).getName());
          }
          paramAnnotationDescriptor = (List)paramAnnotationDescriptor;
        }
      }
    }
    if (paramAnnotationDescriptor == null) {
      paramAnnotationDescriptor = CollectionsKt.emptyList();
    }
    localObject2 = (Iterable)paramAnnotationDescriptor;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      if ((((Map)localObject3).containsKey((Name)localObject4) ^ true)) {
        ((Collection)localObject1).add(localObject4);
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject5;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (Name)((Iterator)localObject2).next();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(((Name)localObject4).asString());
      ((StringBuilder)localObject5).append(" = ...");
      ((Collection)localObject1).add(((StringBuilder)localObject5).toString());
    }
    localObject2 = (List)localObject1;
    localObject1 = (Iterable)((Map)localObject3).entrySet();
    localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
    Object localObject4 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = (Map.Entry)((Iterator)localObject4).next();
      localObject1 = (Name)((Map.Entry)localObject5).getKey();
      ConstantValue localConstantValue = (ConstantValue)((Map.Entry)localObject5).getValue();
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(((Name)localObject1).asString());
      ((StringBuilder)localObject5).append(" = ");
      if (!paramAnnotationDescriptor.contains(localObject1)) {
        localObject1 = renderConstant(localConstantValue);
      } else {
        localObject1 = "...";
      }
      ((StringBuilder)localObject5).append((String)localObject1);
      ((Collection)localObject3).add(((StringBuilder)localObject5).toString());
    }
    paramAnnotationDescriptor = (List)localObject3;
    return CollectionsKt.sorted((Iterable)CollectionsKt.plus((Collection)localObject2, (Iterable)paramAnnotationDescriptor));
  }
  
  private final void renderAnnotations(@NotNull StringBuilder paramStringBuilder, Annotated paramAnnotated, AnnotationUseSiteTarget paramAnnotationUseSiteTarget)
  {
    if (!getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
      return;
    }
    Set localSet;
    if ((paramAnnotated instanceof KotlinType)) {
      localSet = getExcludedTypeAnnotationClasses();
    } else {
      localSet = getExcludedAnnotationClasses();
    }
    Function1 localFunction1 = getAnnotationFilter();
    paramAnnotated = paramAnnotated.getAnnotations().iterator();
    while (paramAnnotated.hasNext())
    {
      AnnotationDescriptor localAnnotationDescriptor = (AnnotationDescriptor)paramAnnotated.next();
      if ((!CollectionsKt.contains((Iterable)localSet, localAnnotationDescriptor.getFqName())) && ((localFunction1 == null) || (((Boolean)localFunction1.invoke(localAnnotationDescriptor)).booleanValue())))
      {
        paramStringBuilder.append(renderAnnotation(localAnnotationDescriptor, paramAnnotationUseSiteTarget));
        if (getEachAnnotationOnNewLine()) {
          StringsKt.appendln(paramStringBuilder);
        } else {
          paramStringBuilder.append(" ");
        }
      }
    }
  }
  
  private final void renderCapturedTypeParametersIfRequired(ClassifierDescriptorWithTypeParameters paramClassifierDescriptorWithTypeParameters, StringBuilder paramStringBuilder)
  {
    List localList = paramClassifierDescriptorWithTypeParameters.getDeclaredTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(localList, "classifier.declaredTypeParameters");
    Object localObject = paramClassifierDescriptorWithTypeParameters.getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "classifier.typeConstructor");
    localObject = ((TypeConstructor)localObject).getParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "classifier.typeConstructor.parameters");
    if ((getVerbose()) && (paramClassifierDescriptorWithTypeParameters.isInner()) && (((List)localObject).size() > localList.size()))
    {
      paramStringBuilder.append(" /*captured type parameters: ");
      renderTypeParameterList(paramStringBuilder, ((List)localObject).subList(localList.size(), ((List)localObject).size()));
      paramStringBuilder.append("*/");
    }
  }
  
  private final void renderClass(ClassDescriptor paramClassDescriptor, StringBuilder paramStringBuilder)
  {
    int i;
    if (paramClassDescriptor.getKind() == ClassKind.ENUM_ENTRY) {
      i = 1;
    } else {
      i = 0;
    }
    if (!getStartFromName())
    {
      renderAnnotations$default(this, paramStringBuilder, (Annotated)paramClassDescriptor, null, 2, null);
      if (i == 0)
      {
        localObject1 = paramClassDescriptor.getVisibility();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "klass.visibility");
        renderVisibility((Visibility)localObject1, paramStringBuilder);
      }
      if ((paramClassDescriptor.getKind() != ClassKind.INTERFACE) || (paramClassDescriptor.getModality() != Modality.ABSTRACT))
      {
        localObject1 = paramClassDescriptor.getKind();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "klass.kind");
        if ((!((ClassKind)localObject1).isSingleton()) || (paramClassDescriptor.getModality() != Modality.FINAL))
        {
          localObject1 = paramClassDescriptor.getModality();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "klass.modality");
          renderModality((Modality)localObject1, paramStringBuilder, implicitModalityWithoutExtensions((MemberDescriptor)paramClassDescriptor));
        }
      }
      renderMemberModifiers((MemberDescriptor)paramClassDescriptor, paramStringBuilder);
      boolean bool;
      if ((getModifiers().contains(DescriptorRendererModifier.INNER)) && (paramClassDescriptor.isInner())) {
        bool = true;
      } else {
        bool = false;
      }
      renderModifier(paramStringBuilder, bool, "inner");
      if ((getModifiers().contains(DescriptorRendererModifier.DATA)) && (paramClassDescriptor.isData())) {
        bool = true;
      } else {
        bool = false;
      }
      renderModifier(paramStringBuilder, bool, "data");
      if ((getModifiers().contains(DescriptorRendererModifier.INLINE)) && (paramClassDescriptor.isInline())) {
        bool = true;
      } else {
        bool = false;
      }
      renderModifier(paramStringBuilder, bool, "inline");
      renderClassKindPrefix(paramClassDescriptor, paramStringBuilder);
    }
    Object localObject1 = (DeclarationDescriptor)paramClassDescriptor;
    if (!DescriptorUtils.isCompanionObject((DeclarationDescriptor)localObject1))
    {
      if (!getStartFromName()) {
        renderSpaceIfNeeded(paramStringBuilder);
      }
      renderName((DeclarationDescriptor)localObject1, paramStringBuilder, true);
    }
    else
    {
      renderCompanionObjectName((DeclarationDescriptor)localObject1, paramStringBuilder);
    }
    if (i != 0) {
      return;
    }
    localObject1 = paramClassDescriptor.getDeclaredTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "klass.declaredTypeParameters");
    renderTypeParameters((List)localObject1, paramStringBuilder, false);
    renderCapturedTypeParametersIfRequired((ClassifierDescriptorWithTypeParameters)paramClassDescriptor, paramStringBuilder);
    Object localObject2 = paramClassDescriptor.getKind();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "klass.kind");
    if ((!((ClassKind)localObject2).isSingleton()) && (getClassWithPrimaryConstructor()))
    {
      localObject2 = paramClassDescriptor.getUnsubstitutedPrimaryConstructor();
      if (localObject2 != null)
      {
        paramStringBuilder.append(" ");
        renderAnnotations$default(this, paramStringBuilder, (Annotated)localObject2, null, 2, null);
        Object localObject3 = ((ClassConstructorDescriptor)localObject2).getVisibility();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "primaryConstructor.visibility");
        renderVisibility((Visibility)localObject3, paramStringBuilder);
        paramStringBuilder.append(renderKeyword("constructor"));
        localObject3 = ((ClassConstructorDescriptor)localObject2).getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "primaryConstructor.valueParameters");
        renderValueParameters((Collection)localObject3, ((ClassConstructorDescriptor)localObject2).hasSynthesizedParameterNames(), paramStringBuilder);
      }
    }
    renderSuperTypes(paramClassDescriptor, paramStringBuilder);
    renderWhereSuffix((List)localObject1, paramStringBuilder);
  }
  
  private final void renderClassKindPrefix(ClassDescriptor paramClassDescriptor, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(renderKeyword(DescriptorRenderer.Companion.getClassifierKindPrefix((ClassifierDescriptorWithTypeParameters)paramClassDescriptor)));
  }
  
  private final void renderCompanionObjectName(DeclarationDescriptor paramDeclarationDescriptor, StringBuilder paramStringBuilder)
  {
    if (getRenderCompanionObjectName())
    {
      if (getStartFromName()) {
        paramStringBuilder.append("companion object");
      }
      renderSpaceIfNeeded(paramStringBuilder);
      Object localObject = paramDeclarationDescriptor.getContainingDeclaration();
      if (localObject != null)
      {
        paramStringBuilder.append("of ");
        localObject = ((DeclarationDescriptor)localObject).getName();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "containingDeclaration.name");
        paramStringBuilder.append(renderName((Name)localObject, false));
      }
    }
    if ((getVerbose()) || ((Intrinsics.areEqual(paramDeclarationDescriptor.getName(), SpecialNames.DEFAULT_NAME_FOR_COMPANION_OBJECT) ^ true)))
    {
      if (!getStartFromName()) {
        renderSpaceIfNeeded(paramStringBuilder);
      }
      paramDeclarationDescriptor = paramDeclarationDescriptor.getName();
      Intrinsics.checkExpressionValueIsNotNull(paramDeclarationDescriptor, "descriptor.name");
      paramStringBuilder.append(renderName(paramDeclarationDescriptor, true));
    }
  }
  
  private final String renderConstant(ConstantValue<?> paramConstantValue)
  {
    if ((paramConstantValue instanceof ArrayValue)) {
      return CollectionsKt.joinToString$default((Iterable)((ArrayValue)paramConstantValue).getValue(), (CharSequence)", ", (CharSequence)"{", (CharSequence)"}", 0, null, (Function1)new DescriptorRendererImpl.renderConstant.1(this), 24, null);
    }
    if ((paramConstantValue instanceof AnnotationValue)) {
      return StringsKt.removePrefix(DescriptorRenderer.renderAnnotation$default(this, (AnnotationDescriptor)((AnnotationValue)paramConstantValue).getValue(), null, 2, null), (CharSequence)"@");
    }
    if ((paramConstantValue instanceof KClassValue))
    {
      paramConstantValue = (KClassValue.Value)((KClassValue)paramConstantValue).getValue();
      Object localObject;
      if ((paramConstantValue instanceof KClassValue.Value.LocalClass))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(((KClassValue.Value.LocalClass)paramConstantValue).getType());
        ((StringBuilder)localObject).append("::class");
        return ((StringBuilder)localObject).toString();
      }
      if ((paramConstantValue instanceof KClassValue.Value.NormalClass))
      {
        localObject = (KClassValue.Value.NormalClass)paramConstantValue;
        paramConstantValue = ((KClassValue.Value.NormalClass)localObject).getClassId().asSingleFqName().asString();
        Intrinsics.checkExpressionValueIsNotNull(paramConstantValue, "classValue.classId.asSingleFqName().asString()");
        int j = ((KClassValue.Value.NormalClass)localObject).getArrayDimensions();
        int i = 0;
        while (i < j)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("kotlin.Array<");
          ((StringBuilder)localObject).append(paramConstantValue);
          ((StringBuilder)localObject).append('>');
          paramConstantValue = ((StringBuilder)localObject).toString();
          i += 1;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramConstantValue);
        ((StringBuilder)localObject).append("::class");
        return ((StringBuilder)localObject).toString();
      }
      throw new NoWhenBranchMatchedException();
    }
    return paramConstantValue.toString();
  }
  
  private final void renderConstructor(ConstructorDescriptor paramConstructorDescriptor, StringBuilder paramStringBuilder)
  {
    renderAnnotations$default(this, paramStringBuilder, (Annotated)paramConstructorDescriptor, null, 2, null);
    if (!this.options.getRenderDefaultVisibility())
    {
      localObject1 = paramConstructorDescriptor.getConstructedClass();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "constructor.constructedClass");
      if (((ClassDescriptor)localObject1).getModality() == Modality.SEALED) {}
    }
    else
    {
      localObject1 = paramConstructorDescriptor.getVisibility();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "constructor.visibility");
      if (renderVisibility((Visibility)localObject1, paramStringBuilder))
      {
        i = 1;
        break label84;
      }
    }
    int i = 0;
    label84:
    renderMemberKind((CallableMemberDescriptor)paramConstructorDescriptor, paramStringBuilder);
    if ((!getRenderConstructorKeyword()) && (paramConstructorDescriptor.isPrimary()) && (i == 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      paramStringBuilder.append(renderKeyword("constructor"));
    }
    Object localObject1 = paramConstructorDescriptor.getContainingDeclaration();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "constructor.containingDeclaration");
    if (getSecondaryConstructorsAsPrimary())
    {
      if (i != 0) {
        paramStringBuilder.append(" ");
      }
      renderName((DeclarationDescriptor)localObject1, paramStringBuilder, true);
      localObject2 = paramConstructorDescriptor.getTypeParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "constructor.typeParameters");
      renderTypeParameters((List)localObject2, paramStringBuilder, false);
    }
    Object localObject2 = paramConstructorDescriptor.getValueParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "constructor.valueParameters");
    renderValueParameters((Collection)localObject2, paramConstructorDescriptor.hasSynthesizedParameterNames(), paramStringBuilder);
    if ((getRenderConstructorDelegation()) && (!paramConstructorDescriptor.isPrimary()) && ((localObject1 instanceof ClassDescriptor)))
    {
      localObject1 = ((ClassDescriptor)localObject1).getUnsubstitutedPrimaryConstructor();
      if (localObject1 != null)
      {
        localObject1 = ((ClassConstructorDescriptor)localObject1).getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "primaryConstructor.valueParameters");
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = ((Iterator)localObject2).next();
          ValueParameterDescriptor localValueParameterDescriptor = (ValueParameterDescriptor)localObject3;
          if ((!localValueParameterDescriptor.declaresDefaultValue()) && (localValueParameterDescriptor.getVarargElementType() == null)) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            ((Collection)localObject1).add(localObject3);
          }
        }
        localObject1 = (List)localObject1;
        if ((((Collection)localObject1).isEmpty() ^ true))
        {
          paramStringBuilder.append(" : ");
          paramStringBuilder.append(renderKeyword("this"));
          localObject1 = (Iterable)localObject1;
          localObject2 = (CharSequence)"(";
          localObject3 = (CharSequence)")";
          paramStringBuilder.append(CollectionsKt.joinToString$default((Iterable)localObject1, (CharSequence)", ", (CharSequence)localObject2, (CharSequence)localObject3, 0, null, (Function1)DescriptorRendererImpl.renderConstructor.1.INSTANCE, 24, null));
        }
      }
    }
    if (getSecondaryConstructorsAsPrimary())
    {
      paramConstructorDescriptor = paramConstructorDescriptor.getTypeParameters();
      Intrinsics.checkExpressionValueIsNotNull(paramConstructorDescriptor, "constructor.typeParameters");
      renderWhereSuffix(paramConstructorDescriptor, paramStringBuilder);
    }
  }
  
  private final void renderDefaultType(@NotNull StringBuilder paramStringBuilder, KotlinType paramKotlinType)
  {
    renderAnnotations$default(this, paramStringBuilder, (Annotated)paramKotlinType, null, 2, null);
    if (KotlinTypeKt.isError(paramKotlinType))
    {
      if (((paramKotlinType instanceof UnresolvedType)) && (getPresentableUnresolvedTypes())) {
        paramStringBuilder.append(((UnresolvedType)paramKotlinType).getPresentableName());
      } else if (((paramKotlinType instanceof ErrorType)) && (!getInformativeErrorType())) {
        paramStringBuilder.append(((ErrorType)paramKotlinType).getPresentableName());
      } else {
        paramStringBuilder.append(paramKotlinType.getConstructor().toString());
      }
      paramStringBuilder.append(renderTypeArguments(paramKotlinType.getArguments()));
    }
    else
    {
      renderTypeConstructorAndArguments$default(this, paramStringBuilder, paramKotlinType, null, 2, null);
    }
    if (paramKotlinType.isMarkedNullable()) {
      paramStringBuilder.append("?");
    }
    if (SpecialTypesKt.isDefinitelyNotNullType(paramKotlinType)) {
      paramStringBuilder.append("!!");
    }
  }
  
  private final String renderError(String paramString)
  {
    Object localObject = getTextFormat();
    int i = DescriptorRendererImpl.WhenMappings.$EnumSwitchMapping$1[localObject.ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<font color=red><b>");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("</b></font>");
        return ((StringBuilder)localObject).toString();
      }
      throw new NoWhenBranchMatchedException();
    }
    return paramString;
  }
  
  private final String renderFqName(List<Name> paramList)
  {
    return escape(RenderingUtilsKt.renderFqName(paramList));
  }
  
  private final void renderFunction(FunctionDescriptor paramFunctionDescriptor, StringBuilder paramStringBuilder)
  {
    if (!getStartFromName())
    {
      if (!getStartFromDeclarationKeyword())
      {
        renderAnnotations$default(this, paramStringBuilder, (Annotated)paramFunctionDescriptor, null, 2, null);
        localObject = paramFunctionDescriptor.getVisibility();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "function.visibility");
        renderVisibility((Visibility)localObject, paramStringBuilder);
        localObject = (CallableMemberDescriptor)paramFunctionDescriptor;
        renderModalityForCallable((CallableMemberDescriptor)localObject, paramStringBuilder);
        if (getIncludeAdditionalModifiers()) {
          renderMemberModifiers((MemberDescriptor)paramFunctionDescriptor, paramStringBuilder);
        }
        renderOverride((CallableMemberDescriptor)localObject, paramStringBuilder);
        if (getIncludeAdditionalModifiers()) {
          renderAdditionalModifiers(paramFunctionDescriptor, paramStringBuilder);
        } else {
          renderSuspendModifier(paramFunctionDescriptor, paramStringBuilder);
        }
        renderMemberKind((CallableMemberDescriptor)localObject, paramStringBuilder);
        if (getVerbose())
        {
          if (paramFunctionDescriptor.isHiddenToOvercomeSignatureClash()) {
            paramStringBuilder.append("/*isHiddenToOvercomeSignatureClash*/ ");
          }
          if (paramFunctionDescriptor.isHiddenForResolutionEverywhereBesideSupercalls()) {
            paramStringBuilder.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
          }
        }
      }
      paramStringBuilder.append(renderKeyword("fun"));
      paramStringBuilder.append(" ");
      localObject = paramFunctionDescriptor.getTypeParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "function.typeParameters");
      renderTypeParameters((List)localObject, paramStringBuilder, true);
      renderReceiver((CallableDescriptor)paramFunctionDescriptor, paramStringBuilder);
    }
    renderName((DeclarationDescriptor)paramFunctionDescriptor, paramStringBuilder, true);
    Object localObject = paramFunctionDescriptor.getValueParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "function.valueParameters");
    renderValueParameters((Collection)localObject, paramFunctionDescriptor.hasSynthesizedParameterNames(), paramStringBuilder);
    renderReceiverAfterName((CallableDescriptor)paramFunctionDescriptor, paramStringBuilder);
    localObject = paramFunctionDescriptor.getReturnType();
    if ((!getWithoutReturnType()) && ((getUnitReturnType()) || (localObject == null) || (!KotlinBuiltIns.isUnit((KotlinType)localObject))))
    {
      paramStringBuilder.append(": ");
      if (localObject == null) {
        localObject = "[NULL]";
      } else {
        localObject = renderType((KotlinType)localObject);
      }
      paramStringBuilder.append((String)localObject);
    }
    paramFunctionDescriptor = paramFunctionDescriptor.getTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(paramFunctionDescriptor, "function.typeParameters");
    renderWhereSuffix(paramFunctionDescriptor, paramStringBuilder);
  }
  
  private final void renderFunctionType(@NotNull StringBuilder paramStringBuilder, KotlinType paramKotlinType)
  {
    int m = paramStringBuilder.length();
    renderAnnotations$default(getFunctionTypeAnnotationsRenderer(), paramStringBuilder, (Annotated)paramKotlinType, null, 2, null);
    int i = paramStringBuilder.length();
    int k = 1;
    if (i != m) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool1 = FunctionTypesKt.isSuspendFunctionType(paramKotlinType);
    boolean bool2 = paramKotlinType.isMarkedNullable();
    Object localObject1 = FunctionTypesKt.getReceiverTypeFromFunctionType(paramKotlinType);
    if ((!bool2) && ((j == 0) || (localObject1 == null))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      if (bool1)
      {
        paramStringBuilder.insert(m, '(');
      }
      else
      {
        if (j != 0)
        {
          localObject2 = (CharSequence)paramStringBuilder;
          if (StringsKt.last((CharSequence)localObject2) == ' ') {
            j = 1;
          } else {
            j = 0;
          }
          if ((_Assertions.ENABLED) && (j == 0)) {
            throw ((Throwable)new AssertionError("Assertion failed"));
          }
          if (paramStringBuilder.charAt(StringsKt.getLastIndex((CharSequence)localObject2) - 1) != ')') {
            paramStringBuilder.insert(StringsKt.getLastIndex((CharSequence)localObject2), "()");
          }
        }
        paramStringBuilder.append("(");
      }
    }
    renderModifier(paramStringBuilder, bool1, "suspend");
    if (localObject1 != null)
    {
      if (shouldRenderAsPrettyFunctionType((KotlinType)localObject1))
      {
        j = k;
        if (!((KotlinType)localObject1).isMarkedNullable()) {}
      }
      else if (hasModifiersOrAnnotations((KotlinType)localObject1))
      {
        j = k;
      }
      else
      {
        j = 0;
      }
      if (j != 0) {
        paramStringBuilder.append("(");
      }
      renderNormalizedType(paramStringBuilder, (KotlinType)localObject1);
      if (j != 0) {
        paramStringBuilder.append(")");
      }
      paramStringBuilder.append(".");
    }
    paramStringBuilder.append("(");
    Object localObject2 = ((Iterable)FunctionTypesKt.getValueParameterTypesFromFunctionType(paramKotlinType)).iterator();
    int j = 0;
    while (((Iterator)localObject2).hasNext())
    {
      TypeProjection localTypeProjection = (TypeProjection)((Iterator)localObject2).next();
      if (j > 0) {
        paramStringBuilder.append(", ");
      }
      if (getParameterNamesInFunctionalTypes())
      {
        localObject1 = localTypeProjection.getType();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "typeProjection.type");
        localObject1 = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument((KotlinType)localObject1);
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        paramStringBuilder.append(renderName((Name)localObject1, false));
        paramStringBuilder.append(": ");
      }
      paramStringBuilder.append(getFunctionTypeParameterTypesRenderer().renderTypeProjection(localTypeProjection));
      j += 1;
    }
    paramStringBuilder.append(") ");
    paramStringBuilder.append(arrow());
    paramStringBuilder.append(" ");
    renderNormalizedType(paramStringBuilder, FunctionTypesKt.getReturnTypeFromFunctionType(paramKotlinType));
    if (i != 0) {
      paramStringBuilder.append(")");
    }
    if (bool2) {
      paramStringBuilder.append("?");
    }
  }
  
  private final void renderInitializer(VariableDescriptor paramVariableDescriptor, StringBuilder paramStringBuilder)
  {
    if (getIncludePropertyConstant())
    {
      paramVariableDescriptor = paramVariableDescriptor.getCompileTimeInitializer();
      if (paramVariableDescriptor != null)
      {
        paramStringBuilder.append(" = ");
        Intrinsics.checkExpressionValueIsNotNull(paramVariableDescriptor, "constant");
        paramStringBuilder.append(escape(renderConstant(paramVariableDescriptor)));
      }
    }
  }
  
  private final String renderKeyword(String paramString)
  {
    Object localObject = getTextFormat();
    int i = DescriptorRendererImpl.WhenMappings.$EnumSwitchMapping$0[localObject.ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        if (getBoldOnlyForNamesInHtml()) {
          return paramString;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<b>");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("</b>");
        return ((StringBuilder)localObject).toString();
      }
      throw new NoWhenBranchMatchedException();
    }
    return paramString;
  }
  
  private final void renderMemberKind(CallableMemberDescriptor paramCallableMemberDescriptor, StringBuilder paramStringBuilder)
  {
    if (!getModifiers().contains(DescriptorRendererModifier.MEMBER_KIND)) {
      return;
    }
    if ((getVerbose()) && (paramCallableMemberDescriptor.getKind() != CallableMemberDescriptor.Kind.DECLARATION))
    {
      paramStringBuilder.append("/*");
      paramCallableMemberDescriptor = paramCallableMemberDescriptor.getKind().name();
      if (paramCallableMemberDescriptor != null)
      {
        paramCallableMemberDescriptor = paramCallableMemberDescriptor.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(paramCallableMemberDescriptor, "(this as java.lang.String).toLowerCase()");
        paramStringBuilder.append(paramCallableMemberDescriptor);
        paramStringBuilder.append("*/ ");
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
  }
  
  private final void renderMemberModifiers(MemberDescriptor paramMemberDescriptor, StringBuilder paramStringBuilder)
  {
    renderModifier(paramStringBuilder, paramMemberDescriptor.isExternal(), "external");
    boolean bool1 = getModifiers().contains(DescriptorRendererModifier.EXPECT);
    boolean bool2 = true;
    if ((bool1) && (paramMemberDescriptor.isExpect())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    renderModifier(paramStringBuilder, bool1, "expect");
    if ((getModifiers().contains(DescriptorRendererModifier.ACTUAL)) && (paramMemberDescriptor.isActual())) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    renderModifier(paramStringBuilder, bool1, "actual");
  }
  
  private final void renderModality(Modality paramModality1, StringBuilder paramStringBuilder, Modality paramModality2)
  {
    if ((!getRenderDefaultModality()) && (paramModality1 == paramModality2)) {
      return;
    }
    boolean bool = getModifiers().contains(DescriptorRendererModifier.MODALITY);
    paramModality1 = paramModality1.name();
    if (paramModality1 != null)
    {
      paramModality1 = paramModality1.toLowerCase();
      Intrinsics.checkExpressionValueIsNotNull(paramModality1, "(this as java.lang.String).toLowerCase()");
      renderModifier(paramStringBuilder, bool, paramModality1);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final void renderModalityForCallable(CallableMemberDescriptor paramCallableMemberDescriptor, StringBuilder paramStringBuilder)
  {
    if ((!DescriptorUtils.isTopLevelDeclaration((DeclarationDescriptor)paramCallableMemberDescriptor)) || (paramCallableMemberDescriptor.getModality() != Modality.FINAL))
    {
      if ((getOverrideRenderingPolicy() == OverrideRenderingPolicy.RENDER_OVERRIDE) && (paramCallableMemberDescriptor.getModality() == Modality.OPEN) && (overridesSomething(paramCallableMemberDescriptor))) {
        return;
      }
      Modality localModality = paramCallableMemberDescriptor.getModality();
      Intrinsics.checkExpressionValueIsNotNull(localModality, "callable.modality");
      renderModality(localModality, paramStringBuilder, implicitModalityWithoutExtensions((MemberDescriptor)paramCallableMemberDescriptor));
    }
  }
  
  private final void renderModifier(StringBuilder paramStringBuilder, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramStringBuilder.append(renderKeyword(paramString));
      paramStringBuilder.append(" ");
    }
  }
  
  private final void renderName(DeclarationDescriptor paramDeclarationDescriptor, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    paramDeclarationDescriptor = paramDeclarationDescriptor.getName();
    Intrinsics.checkExpressionValueIsNotNull(paramDeclarationDescriptor, "descriptor.name");
    paramStringBuilder.append(renderName(paramDeclarationDescriptor, paramBoolean));
  }
  
  private final void renderNormalizedType(@NotNull StringBuilder paramStringBuilder, KotlinType paramKotlinType)
  {
    UnwrappedType localUnwrappedType = paramKotlinType.unwrap();
    Object localObject = localUnwrappedType;
    if (!(localUnwrappedType instanceof AbbreviatedType)) {
      localObject = null;
    }
    localObject = (AbbreviatedType)localObject;
    if (localObject != null)
    {
      if (getRenderTypeExpansions())
      {
        renderNormalizedTypeAsIs(paramStringBuilder, (KotlinType)((AbbreviatedType)localObject).getExpandedType());
        return;
      }
      renderNormalizedTypeAsIs(paramStringBuilder, (KotlinType)((AbbreviatedType)localObject).getAbbreviation());
      if (getRenderUnabbreviatedType()) {
        renderAbbreviatedTypeExpansion(paramStringBuilder, (AbbreviatedType)localObject);
      }
      return;
    }
    renderNormalizedTypeAsIs(paramStringBuilder, paramKotlinType);
  }
  
  private final void renderNormalizedTypeAsIs(@NotNull StringBuilder paramStringBuilder, KotlinType paramKotlinType)
  {
    if (((paramKotlinType instanceof WrappedType)) && (getDebugMode()) && (!((WrappedType)paramKotlinType).isComputed()))
    {
      paramStringBuilder.append("<Not computed yet>");
      return;
    }
    paramKotlinType = paramKotlinType.unwrap();
    if ((paramKotlinType instanceof FlexibleType))
    {
      paramStringBuilder.append(((FlexibleType)paramKotlinType).render((DescriptorRenderer)this, (DescriptorRendererOptions)this));
      return;
    }
    if ((paramKotlinType instanceof SimpleType)) {
      renderSimpleType(paramStringBuilder, (SimpleType)paramKotlinType);
    }
  }
  
  private final void renderOverride(CallableMemberDescriptor paramCallableMemberDescriptor, StringBuilder paramStringBuilder)
  {
    if (!getModifiers().contains(DescriptorRendererModifier.OVERRIDE)) {
      return;
    }
    if ((overridesSomething(paramCallableMemberDescriptor)) && (getOverrideRenderingPolicy() != OverrideRenderingPolicy.RENDER_OPEN))
    {
      renderModifier(paramStringBuilder, true, "override");
      if (getVerbose())
      {
        paramStringBuilder.append("/*");
        paramStringBuilder.append(paramCallableMemberDescriptor.getOverriddenDescriptors().size());
        paramStringBuilder.append("*/ ");
      }
    }
  }
  
  private final void renderPackageFragment(PackageFragmentDescriptor paramPackageFragmentDescriptor, StringBuilder paramStringBuilder)
  {
    renderPackageHeader(paramPackageFragmentDescriptor.getFqName(), "package-fragment", paramStringBuilder);
    if (getDebugMode())
    {
      paramStringBuilder.append(" in ");
      renderName((DeclarationDescriptor)paramPackageFragmentDescriptor.getContainingDeclaration(), paramStringBuilder, false);
    }
  }
  
  private final void renderPackageHeader(FqName paramFqName, String paramString, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(renderKeyword(paramString));
    paramFqName = paramFqName.toUnsafe();
    Intrinsics.checkExpressionValueIsNotNull(paramFqName, "fqName.toUnsafe()");
    paramFqName = renderFqName(paramFqName);
    int i;
    if (((CharSequence)paramFqName).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramStringBuilder.append(" ");
      paramStringBuilder.append(paramFqName);
    }
  }
  
  private final void renderPackageView(PackageViewDescriptor paramPackageViewDescriptor, StringBuilder paramStringBuilder)
  {
    renderPackageHeader(paramPackageViewDescriptor.getFqName(), "package", paramStringBuilder);
    if (getDebugMode())
    {
      paramStringBuilder.append(" in context of ");
      renderName((DeclarationDescriptor)paramPackageViewDescriptor.getModule(), paramStringBuilder, false);
    }
  }
  
  private final void renderPossiblyInnerType(@NotNull StringBuilder paramStringBuilder, PossiblyInnerType paramPossiblyInnerType)
  {
    Object localObject = paramPossiblyInnerType.getOuterType();
    if (localObject != null)
    {
      renderPossiblyInnerType(paramStringBuilder, (PossiblyInnerType)localObject);
      paramStringBuilder.append('.');
      localObject = paramPossiblyInnerType.getClassifierDescriptor().getName();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "possiblyInnerType.classifierDescriptor.name");
      paramStringBuilder.append(renderName((Name)localObject, false));
      if (paramStringBuilder != null) {}
    }
    else
    {
      localObject = paramPossiblyInnerType.getClassifierDescriptor().getTypeConstructor();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "possiblyInnerType.classi…escriptor.typeConstructor");
      paramStringBuilder.append(renderTypeConstructor((TypeConstructor)localObject));
    }
    paramStringBuilder.append(renderTypeArguments(paramPossiblyInnerType.getArguments()));
  }
  
  private final void renderProperty(PropertyDescriptor paramPropertyDescriptor, StringBuilder paramStringBuilder)
  {
    if (!getStartFromName())
    {
      if (!getStartFromDeclarationKeyword())
      {
        renderPropertyAnnotations(paramPropertyDescriptor, paramStringBuilder);
        localObject = paramPropertyDescriptor.getVisibility();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "property.visibility");
        renderVisibility((Visibility)localObject, paramStringBuilder);
        boolean bool1 = getModifiers().contains(DescriptorRendererModifier.CONST);
        boolean bool2 = false;
        if ((bool1) && (paramPropertyDescriptor.isConst())) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        renderModifier(paramStringBuilder, bool1, "const");
        renderMemberModifiers((MemberDescriptor)paramPropertyDescriptor, paramStringBuilder);
        localObject = (CallableMemberDescriptor)paramPropertyDescriptor;
        renderModalityForCallable((CallableMemberDescriptor)localObject, paramStringBuilder);
        renderOverride((CallableMemberDescriptor)localObject, paramStringBuilder);
        bool1 = bool2;
        if (getModifiers().contains(DescriptorRendererModifier.LATEINIT))
        {
          bool1 = bool2;
          if (paramPropertyDescriptor.isLateInit()) {
            bool1 = true;
          }
        }
        renderModifier(paramStringBuilder, bool1, "lateinit");
        renderMemberKind((CallableMemberDescriptor)localObject, paramStringBuilder);
      }
      renderValVarPrefix$default(this, (VariableDescriptor)paramPropertyDescriptor, paramStringBuilder, false, 4, null);
      localObject = paramPropertyDescriptor.getTypeParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "property.typeParameters");
      renderTypeParameters((List)localObject, paramStringBuilder, true);
      renderReceiver((CallableDescriptor)paramPropertyDescriptor, paramStringBuilder);
    }
    renderName((DeclarationDescriptor)paramPropertyDescriptor, paramStringBuilder, true);
    paramStringBuilder.append(": ");
    Object localObject = paramPropertyDescriptor.getType();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "property.type");
    paramStringBuilder.append(renderType((KotlinType)localObject));
    renderReceiverAfterName((CallableDescriptor)paramPropertyDescriptor, paramStringBuilder);
    renderInitializer((VariableDescriptor)paramPropertyDescriptor, paramStringBuilder);
    paramPropertyDescriptor = paramPropertyDescriptor.getTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(paramPropertyDescriptor, "property.typeParameters");
    renderWhereSuffix(paramPropertyDescriptor, paramStringBuilder);
  }
  
  private final void renderPropertyAnnotations(PropertyDescriptor paramPropertyDescriptor, StringBuilder paramStringBuilder)
  {
    if (!getModifiers().contains(DescriptorRendererModifier.ANNOTATIONS)) {
      return;
    }
    renderAnnotations$default(this, paramStringBuilder, (Annotated)paramPropertyDescriptor, null, 2, null);
    Object localObject = paramPropertyDescriptor.getBackingField();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      renderAnnotations(paramStringBuilder, (Annotated)localObject, AnnotationUseSiteTarget.FIELD);
    }
    localObject = paramPropertyDescriptor.getDelegateField();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
      renderAnnotations(paramStringBuilder, (Annotated)localObject, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
    }
    if (getPropertyAccessorRenderingPolicy() == PropertyAccessorRenderingPolicy.NONE)
    {
      localObject = paramPropertyDescriptor.getGetter();
      if (localObject != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
        renderAnnotations(paramStringBuilder, (Annotated)localObject, AnnotationUseSiteTarget.PROPERTY_GETTER);
      }
      paramPropertyDescriptor = paramPropertyDescriptor.getSetter();
      if (paramPropertyDescriptor != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramPropertyDescriptor, "it");
        renderAnnotations(paramStringBuilder, (Annotated)paramPropertyDescriptor, AnnotationUseSiteTarget.PROPERTY_SETTER);
        Intrinsics.checkExpressionValueIsNotNull(paramPropertyDescriptor, "setter");
        paramPropertyDescriptor = paramPropertyDescriptor.getValueParameters();
        Intrinsics.checkExpressionValueIsNotNull(paramPropertyDescriptor, "setter.valueParameters");
        paramPropertyDescriptor = (ValueParameterDescriptor)CollectionsKt.single(paramPropertyDescriptor);
        Intrinsics.checkExpressionValueIsNotNull(paramPropertyDescriptor, "it");
        renderAnnotations(paramStringBuilder, (Annotated)paramPropertyDescriptor, AnnotationUseSiteTarget.SETTER_PARAMETER);
      }
    }
  }
  
  private final void renderReceiver(CallableDescriptor paramCallableDescriptor, StringBuilder paramStringBuilder)
  {
    paramCallableDescriptor = paramCallableDescriptor.getExtensionReceiverParameter();
    if (paramCallableDescriptor != null)
    {
      renderAnnotations(paramStringBuilder, (Annotated)paramCallableDescriptor, AnnotationUseSiteTarget.RECEIVER);
      KotlinType localKotlinType = paramCallableDescriptor.getType();
      Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "receiver.type");
      String str = renderType(localKotlinType);
      paramCallableDescriptor = str;
      if (shouldRenderAsPrettyFunctionType(localKotlinType))
      {
        paramCallableDescriptor = str;
        if (!TypeUtils.isNullableType(localKotlinType))
        {
          paramCallableDescriptor = new StringBuilder();
          paramCallableDescriptor.append('(');
          paramCallableDescriptor.append(str);
          paramCallableDescriptor.append(')');
          paramCallableDescriptor = paramCallableDescriptor.toString();
        }
      }
      paramStringBuilder.append(paramCallableDescriptor);
      paramStringBuilder.append(".");
    }
  }
  
  private final void renderReceiverAfterName(CallableDescriptor paramCallableDescriptor, StringBuilder paramStringBuilder)
  {
    if (!getReceiverAfterName()) {
      return;
    }
    paramCallableDescriptor = paramCallableDescriptor.getExtensionReceiverParameter();
    if (paramCallableDescriptor != null)
    {
      paramStringBuilder.append(" on ");
      paramCallableDescriptor = paramCallableDescriptor.getType();
      Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor, "receiver.type");
      paramStringBuilder.append(renderType(paramCallableDescriptor));
    }
  }
  
  private final void renderSimpleType(@NotNull StringBuilder paramStringBuilder, SimpleType paramSimpleType)
  {
    if (!Intrinsics.areEqual(paramSimpleType, TypeUtils.CANT_INFER_FUNCTION_PARAM_TYPE))
    {
      KotlinType localKotlinType = (KotlinType)paramSimpleType;
      if (!TypeUtils.isDontCarePlaceholder(localKotlinType))
      {
        if (ErrorUtils.isUninferredParameter(localKotlinType))
        {
          if (getUninferredTypeParameterAsName())
          {
            paramSimpleType = paramSimpleType.getConstructor();
            if (paramSimpleType != null)
            {
              paramSimpleType = ((ErrorUtils.UninferredParameterTypeConstructor)paramSimpleType).getTypeParameterDescriptor();
              Intrinsics.checkExpressionValueIsNotNull(paramSimpleType, "(type.constructor as Uni…).typeParameterDescriptor");
              paramSimpleType = paramSimpleType.getName().toString();
              Intrinsics.checkExpressionValueIsNotNull(paramSimpleType, "(type.constructor as Uni…escriptor.name.toString()");
              paramStringBuilder.append(renderError(paramSimpleType));
              return;
            }
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.ErrorUtils.UninferredParameterTypeConstructor");
          }
          paramStringBuilder.append("???");
          return;
        }
        if (KotlinTypeKt.isError(localKotlinType))
        {
          renderDefaultType(paramStringBuilder, localKotlinType);
          return;
        }
        if (shouldRenderAsPrettyFunctionType(localKotlinType))
        {
          renderFunctionType(paramStringBuilder, localKotlinType);
          return;
        }
        renderDefaultType(paramStringBuilder, localKotlinType);
        return;
      }
    }
    paramStringBuilder.append("???");
  }
  
  private final void renderSpaceIfNeeded(StringBuilder paramStringBuilder)
  {
    int i = paramStringBuilder.length();
    if ((i == 0) || (paramStringBuilder.charAt(i - 1) != ' ')) {
      paramStringBuilder.append(' ');
    }
  }
  
  private final void renderSuperTypes(ClassDescriptor paramClassDescriptor, StringBuilder paramStringBuilder)
  {
    if (getWithoutSuperTypes()) {
      return;
    }
    if (KotlinBuiltIns.isNothing((KotlinType)paramClassDescriptor.getDefaultType())) {
      return;
    }
    paramClassDescriptor = paramClassDescriptor.getTypeConstructor();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "klass.typeConstructor");
    paramClassDescriptor = paramClassDescriptor.getSupertypes();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "klass.typeConstructor.supertypes");
    if (!paramClassDescriptor.isEmpty())
    {
      if ((paramClassDescriptor.size() == 1) && (KotlinBuiltIns.isAnyOrNullableAny((KotlinType)paramClassDescriptor.iterator().next()))) {
        return;
      }
      renderSpaceIfNeeded(paramStringBuilder);
      paramStringBuilder.append(": ");
      CollectionsKt.joinTo$default((Iterable)paramClassDescriptor, (Appendable)paramStringBuilder, (CharSequence)", ", null, null, 0, null, (Function1)new DescriptorRendererImpl.renderSuperTypes.1(this), 60, null);
    }
  }
  
  private final void renderSuspendModifier(FunctionDescriptor paramFunctionDescriptor, StringBuilder paramStringBuilder)
  {
    renderModifier(paramStringBuilder, paramFunctionDescriptor.isSuspend(), "suspend");
  }
  
  private final void renderTypeAlias(TypeAliasDescriptor paramTypeAliasDescriptor, StringBuilder paramStringBuilder)
  {
    renderAnnotations$default(this, paramStringBuilder, (Annotated)paramTypeAliasDescriptor, null, 2, null);
    Object localObject = paramTypeAliasDescriptor.getVisibility();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "typeAlias.visibility");
    renderVisibility((Visibility)localObject, paramStringBuilder);
    renderMemberModifiers((MemberDescriptor)paramTypeAliasDescriptor, paramStringBuilder);
    paramStringBuilder.append(renderKeyword("typealias"));
    paramStringBuilder.append(" ");
    renderName((DeclarationDescriptor)paramTypeAliasDescriptor, paramStringBuilder, true);
    localObject = paramTypeAliasDescriptor.getDeclaredTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "typeAlias.declaredTypeParameters");
    renderTypeParameters((List)localObject, paramStringBuilder, false);
    renderCapturedTypeParametersIfRequired((ClassifierDescriptorWithTypeParameters)paramTypeAliasDescriptor, paramStringBuilder);
    paramStringBuilder.append(" = ");
    paramStringBuilder.append(renderType((KotlinType)paramTypeAliasDescriptor.getUnderlyingType()));
  }
  
  private final void renderTypeConstructorAndArguments(@NotNull StringBuilder paramStringBuilder, KotlinType paramKotlinType, TypeConstructor paramTypeConstructor)
  {
    PossiblyInnerType localPossiblyInnerType = TypeParameterUtilsKt.buildPossiblyInnerType(paramKotlinType);
    if (localPossiblyInnerType == null)
    {
      paramStringBuilder.append(renderTypeConstructor(paramTypeConstructor));
      paramStringBuilder.append(renderTypeArguments(paramKotlinType.getArguments()));
      return;
    }
    renderPossiblyInnerType(paramStringBuilder, localPossiblyInnerType);
  }
  
  private final void renderTypeParameter(TypeParameterDescriptor paramTypeParameterDescriptor, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if (paramBoolean) {
      paramStringBuilder.append(lt());
    }
    if (getVerbose())
    {
      paramStringBuilder.append("/*");
      paramStringBuilder.append(paramTypeParameterDescriptor.getIndex());
      paramStringBuilder.append("*/ ");
    }
    renderModifier(paramStringBuilder, paramTypeParameterDescriptor.isReified(), "reified");
    Object localObject = paramTypeParameterDescriptor.getVariance().getLabel();
    int j = ((CharSequence)localObject).length();
    int i = 1;
    boolean bool;
    if (j > 0) {
      bool = true;
    } else {
      bool = false;
    }
    renderModifier(paramStringBuilder, bool, (String)localObject);
    renderAnnotations$default(this, paramStringBuilder, (Annotated)paramTypeParameterDescriptor, null, 2, null);
    renderName((DeclarationDescriptor)paramTypeParameterDescriptor, paramStringBuilder, paramBoolean);
    j = paramTypeParameterDescriptor.getUpperBounds().size();
    if (((j > 1) && (!paramBoolean)) || (j == 1))
    {
      paramTypeParameterDescriptor = (KotlinType)paramTypeParameterDescriptor.getUpperBounds().iterator().next();
      if (!KotlinBuiltIns.isDefaultBound(paramTypeParameterDescriptor))
      {
        paramStringBuilder.append(" : ");
        Intrinsics.checkExpressionValueIsNotNull(paramTypeParameterDescriptor, "upperBound");
        paramStringBuilder.append(renderType(paramTypeParameterDescriptor));
      }
    }
    else if (paramBoolean)
    {
      paramTypeParameterDescriptor = paramTypeParameterDescriptor.getUpperBounds().iterator();
      while (paramTypeParameterDescriptor.hasNext())
      {
        localObject = (KotlinType)paramTypeParameterDescriptor.next();
        if (!KotlinBuiltIns.isDefaultBound((KotlinType)localObject))
        {
          if (i != 0) {
            paramStringBuilder.append(" : ");
          } else {
            paramStringBuilder.append(" & ");
          }
          Intrinsics.checkExpressionValueIsNotNull(localObject, "upperBound");
          paramStringBuilder.append(renderType((KotlinType)localObject));
          i = 0;
        }
      }
    }
    if (paramBoolean) {
      paramStringBuilder.append(gt());
    }
  }
  
  private final void renderTypeParameterList(StringBuilder paramStringBuilder, List<? extends TypeParameterDescriptor> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      renderTypeParameter((TypeParameterDescriptor)paramList.next(), paramStringBuilder, false);
      if (paramList.hasNext()) {
        paramStringBuilder.append(", ");
      }
    }
  }
  
  private final void renderTypeParameters(List<? extends TypeParameterDescriptor> paramList, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if (getWithoutTypeParameters()) {
      return;
    }
    if ((((Collection)paramList).isEmpty() ^ true))
    {
      paramStringBuilder.append(lt());
      renderTypeParameterList(paramStringBuilder, paramList);
      paramStringBuilder.append(gt());
      if (paramBoolean) {
        paramStringBuilder.append(" ");
      }
    }
  }
  
  private final void renderValVarPrefix(VariableDescriptor paramVariableDescriptor, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if ((paramBoolean) || (!(paramVariableDescriptor instanceof ValueParameterDescriptor)))
    {
      if (paramVariableDescriptor.isVar()) {
        paramVariableDescriptor = "var";
      } else {
        paramVariableDescriptor = "val";
      }
      paramStringBuilder.append(renderKeyword(paramVariableDescriptor));
      paramStringBuilder.append(" ");
    }
  }
  
  private final void renderValueParameter(ValueParameterDescriptor paramValueParameterDescriptor, boolean paramBoolean1, StringBuilder paramStringBuilder, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      paramStringBuilder.append(renderKeyword("value-parameter"));
      paramStringBuilder.append(" ");
    }
    if (getVerbose())
    {
      paramStringBuilder.append("/*");
      paramStringBuilder.append(paramValueParameterDescriptor.getIndex());
      paramStringBuilder.append("*/ ");
    }
    renderAnnotations$default(this, paramStringBuilder, (Annotated)paramValueParameterDescriptor, null, 2, null);
    renderModifier(paramStringBuilder, paramValueParameterDescriptor.isCrossinline(), "crossinline");
    renderModifier(paramStringBuilder, paramValueParameterDescriptor.isNoinline(), "noinline");
    boolean bool = getRenderPrimaryConstructorParametersAsProperties();
    int j = 0;
    Object localObject2;
    Object localObject1;
    if (bool)
    {
      localObject2 = paramValueParameterDescriptor.getContainingDeclaration();
      localObject1 = localObject2;
      if (!(localObject2 instanceof ClassConstructorDescriptor)) {
        localObject1 = null;
      }
      localObject1 = (ClassConstructorDescriptor)localObject1;
      if ((localObject1 != null) && (((ClassConstructorDescriptor)localObject1).isPrimary() == true))
      {
        bool = true;
        break label167;
      }
    }
    bool = false;
    label167:
    if (bool) {
      renderModifier(paramStringBuilder, getActualPropertiesInPrimaryConstructor(), "actual");
    }
    renderVariable((VariableDescriptor)paramValueParameterDescriptor, paramBoolean1, paramStringBuilder, paramBoolean2, bool);
    int i = j;
    if (getDefaultParameterValueRenderer() != null)
    {
      if (getDebugMode()) {
        paramBoolean1 = paramValueParameterDescriptor.declaresDefaultValue();
      } else {
        paramBoolean1 = DescriptorUtilsKt.declaresOrInheritsDefaultValue(paramValueParameterDescriptor);
      }
      i = j;
      if (paramBoolean1) {
        i = 1;
      }
    }
    if (i != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" = ");
      localObject2 = getDefaultParameterValueRenderer();
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((StringBuilder)localObject1).append((String)((Function1)localObject2).invoke(paramValueParameterDescriptor));
      paramStringBuilder.append(((StringBuilder)localObject1).toString());
    }
  }
  
  private final void renderValueParameters(Collection<? extends ValueParameterDescriptor> paramCollection, boolean paramBoolean, StringBuilder paramStringBuilder)
  {
    paramBoolean = shouldRenderParameterNames(paramBoolean);
    int j = paramCollection.size();
    getValueParametersHandler().appendBeforeValueParameters(j, paramStringBuilder);
    paramCollection = ((Iterable)paramCollection).iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      ValueParameterDescriptor localValueParameterDescriptor = (ValueParameterDescriptor)paramCollection.next();
      getValueParametersHandler().appendBeforeValueParameter(localValueParameterDescriptor, i, j, paramStringBuilder);
      renderValueParameter(localValueParameterDescriptor, paramBoolean, paramStringBuilder, false);
      getValueParametersHandler().appendAfterValueParameter(localValueParameterDescriptor, i, j, paramStringBuilder);
      i += 1;
    }
    getValueParametersHandler().appendAfterValueParameters(j, paramStringBuilder);
  }
  
  private final void renderVariable(VariableDescriptor paramVariableDescriptor, boolean paramBoolean1, StringBuilder paramStringBuilder, boolean paramBoolean2, boolean paramBoolean3)
  {
    KotlinType localKotlinType = paramVariableDescriptor.getType();
    Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "variable.type");
    if (!(paramVariableDescriptor instanceof ValueParameterDescriptor)) {
      localObject1 = null;
    } else {
      localObject1 = paramVariableDescriptor;
    }
    Object localObject1 = (ValueParameterDescriptor)localObject1;
    if (localObject1 != null) {
      localObject1 = ((ValueParameterDescriptor)localObject1).getVarargElementType();
    } else {
      localObject1 = null;
    }
    Object localObject2;
    if (localObject1 != null) {
      localObject2 = localObject1;
    } else {
      localObject2 = localKotlinType;
    }
    boolean bool;
    if (localObject1 != null) {
      bool = true;
    } else {
      bool = false;
    }
    renderModifier(paramStringBuilder, bool, "vararg");
    if ((paramBoolean3) || ((paramBoolean2) && (!getStartFromName()))) {
      renderValVarPrefix(paramVariableDescriptor, paramStringBuilder, paramBoolean3);
    }
    if (paramBoolean1)
    {
      renderName((DeclarationDescriptor)paramVariableDescriptor, paramStringBuilder, paramBoolean2);
      paramStringBuilder.append(": ");
    }
    paramStringBuilder.append(renderType((KotlinType)localObject2));
    renderInitializer(paramVariableDescriptor, paramStringBuilder);
    if ((getVerbose()) && (localObject1 != null))
    {
      paramStringBuilder.append(" /*");
      paramStringBuilder.append(renderType(localKotlinType));
      paramStringBuilder.append("*/");
    }
  }
  
  private final boolean renderVisibility(Visibility paramVisibility, StringBuilder paramStringBuilder)
  {
    if (!getModifiers().contains(DescriptorRendererModifier.VISIBILITY)) {
      return false;
    }
    Visibility localVisibility = paramVisibility;
    if (getNormalizedVisibilities()) {
      localVisibility = paramVisibility.normalize();
    }
    if ((!getRenderDefaultVisibility()) && (Intrinsics.areEqual(localVisibility, Visibilities.DEFAULT_VISIBILITY))) {
      return false;
    }
    paramStringBuilder.append(renderKeyword(localVisibility.getInternalDisplayName()));
    paramStringBuilder.append(" ");
    return true;
  }
  
  private final void renderWhereSuffix(List<? extends TypeParameterDescriptor> paramList, StringBuilder paramStringBuilder)
  {
    if (getWithoutTypeParameters()) {
      return;
    }
    ArrayList localArrayList = new ArrayList(0);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (TypeParameterDescriptor)paramList.next();
      Object localObject2 = ((TypeParameterDescriptor)localObject1).getUpperBounds();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "typeParameter.upperBounds");
      localObject2 = ((Iterable)CollectionsKt.drop((Iterable)localObject2, 1)).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        Collection localCollection = (Collection)localArrayList;
        localObject3 = (KotlinType)localObject3;
        StringBuilder localStringBuilder = new StringBuilder();
        Name localName = ((TypeParameterDescriptor)localObject1).getName();
        Intrinsics.checkExpressionValueIsNotNull(localName, "typeParameter.name");
        localStringBuilder.append(renderName(localName, false));
        localStringBuilder.append(" : ");
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "it");
        localStringBuilder.append(renderType((KotlinType)localObject3));
        localCollection.add(localStringBuilder.toString());
      }
      localObject1 = (Collection)localArrayList;
    }
    if ((((Collection)localArrayList).isEmpty() ^ true))
    {
      paramStringBuilder.append(" ");
      paramStringBuilder.append(renderKeyword("where"));
      paramStringBuilder.append(" ");
      CollectionsKt.joinTo$default((Iterable)localArrayList, (Appendable)paramStringBuilder, (CharSequence)", ", null, null, 0, null, null, 124, null);
    }
  }
  
  private final String replacePrefixes(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((StringsKt.startsWith$default(paramString1, paramString2, false, 2, null)) && (StringsKt.startsWith$default(paramString3, paramString4, false, 2, null)))
    {
      int i = paramString2.length();
      if (paramString1 != null)
      {
        paramString1 = paramString1.substring(i);
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "(this as java.lang.String).substring(startIndex)");
        i = paramString4.length();
        if (paramString3 != null)
        {
          paramString2 = paramString3.substring(i);
          Intrinsics.checkExpressionValueIsNotNull(paramString2, "(this as java.lang.String).substring(startIndex)");
          paramString3 = new StringBuilder();
          paramString3.append(paramString5);
          paramString3.append(paramString1);
          paramString3 = paramString3.toString();
          if (Intrinsics.areEqual(paramString1, paramString2)) {
            return paramString3;
          }
          if (differsOnlyInNullability(paramString1, paramString2))
          {
            paramString1 = new StringBuilder();
            paramString1.append(paramString3);
            paramString1.append('!');
            return paramString1.toString();
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    return null;
  }
  
  private final boolean shouldRenderAsPrettyFunctionType(KotlinType paramKotlinType)
  {
    boolean bool3 = FunctionTypesKt.isBuiltinFunctionalType(paramKotlinType);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramKotlinType = (Iterable)paramKotlinType.getArguments();
      if (((paramKotlinType instanceof Collection)) && (((Collection)paramKotlinType).isEmpty())) {}
      do
      {
        while (!paramKotlinType.hasNext())
        {
          i = 1;
          break;
          paramKotlinType = paramKotlinType.iterator();
        }
      } while (!((TypeProjection)paramKotlinType.next()).isStarProjection());
      int i = 0;
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private final boolean shouldRenderParameterNames(boolean paramBoolean)
  {
    ParameterNameRenderingPolicy localParameterNameRenderingPolicy = getParameterNameRenderingPolicy();
    int i = DescriptorRendererImpl.WhenMappings.$EnumSwitchMapping$4[localParameterNameRenderingPolicy.ordinal()];
    boolean bool = false;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          return false;
        }
        throw new NoWhenBranchMatchedException();
      }
      if (paramBoolean) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  public boolean getActualPropertiesInPrimaryConstructor()
  {
    return this.options.getActualPropertiesInPrimaryConstructor();
  }
  
  public boolean getAlwaysRenderModifiers()
  {
    return this.options.getAlwaysRenderModifiers();
  }
  
  @NotNull
  public AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy()
  {
    return this.options.getAnnotationArgumentsRenderingPolicy();
  }
  
  @Nullable
  public Function1<AnnotationDescriptor, Boolean> getAnnotationFilter()
  {
    return this.options.getAnnotationFilter();
  }
  
  public boolean getBoldOnlyForNamesInHtml()
  {
    return this.options.getBoldOnlyForNamesInHtml();
  }
  
  public boolean getClassWithPrimaryConstructor()
  {
    return this.options.getClassWithPrimaryConstructor();
  }
  
  @NotNull
  public ClassifierNamePolicy getClassifierNamePolicy()
  {
    return this.options.getClassifierNamePolicy();
  }
  
  public boolean getDebugMode()
  {
    return this.options.getDebugMode();
  }
  
  @Nullable
  public Function1<ValueParameterDescriptor, String> getDefaultParameterValueRenderer()
  {
    return this.options.getDefaultParameterValueRenderer();
  }
  
  public boolean getEachAnnotationOnNewLine()
  {
    return this.options.getEachAnnotationOnNewLine();
  }
  
  public boolean getEnhancedTypes()
  {
    return this.options.getEnhancedTypes();
  }
  
  @NotNull
  public Set<FqName> getExcludedAnnotationClasses()
  {
    return this.options.getExcludedAnnotationClasses();
  }
  
  @NotNull
  public Set<FqName> getExcludedTypeAnnotationClasses()
  {
    return this.options.getExcludedTypeAnnotationClasses();
  }
  
  public boolean getIncludeAdditionalModifiers()
  {
    return this.options.getIncludeAdditionalModifiers();
  }
  
  public boolean getIncludeAnnotationArguments()
  {
    return this.options.getIncludeAnnotationArguments();
  }
  
  public boolean getIncludeEmptyAnnotationArguments()
  {
    return this.options.getIncludeEmptyAnnotationArguments();
  }
  
  public boolean getIncludePropertyConstant()
  {
    return this.options.getIncludePropertyConstant();
  }
  
  public boolean getInformativeErrorType()
  {
    return this.options.getInformativeErrorType();
  }
  
  @NotNull
  public Set<DescriptorRendererModifier> getModifiers()
  {
    return this.options.getModifiers();
  }
  
  public boolean getNormalizedVisibilities()
  {
    return this.options.getNormalizedVisibilities();
  }
  
  @NotNull
  public final DescriptorRendererOptionsImpl getOptions()
  {
    return this.options;
  }
  
  @NotNull
  public OverrideRenderingPolicy getOverrideRenderingPolicy()
  {
    return this.options.getOverrideRenderingPolicy();
  }
  
  @NotNull
  public ParameterNameRenderingPolicy getParameterNameRenderingPolicy()
  {
    return this.options.getParameterNameRenderingPolicy();
  }
  
  public boolean getParameterNamesInFunctionalTypes()
  {
    return this.options.getParameterNamesInFunctionalTypes();
  }
  
  public boolean getPresentableUnresolvedTypes()
  {
    return this.options.getPresentableUnresolvedTypes();
  }
  
  @NotNull
  public PropertyAccessorRenderingPolicy getPropertyAccessorRenderingPolicy()
  {
    return this.options.getPropertyAccessorRenderingPolicy();
  }
  
  public boolean getReceiverAfterName()
  {
    return this.options.getReceiverAfterName();
  }
  
  public boolean getRenderCompanionObjectName()
  {
    return this.options.getRenderCompanionObjectName();
  }
  
  public boolean getRenderConstructorDelegation()
  {
    return this.options.getRenderConstructorDelegation();
  }
  
  public boolean getRenderConstructorKeyword()
  {
    return this.options.getRenderConstructorKeyword();
  }
  
  public boolean getRenderDefaultAnnotationArguments()
  {
    return this.options.getRenderDefaultAnnotationArguments();
  }
  
  public boolean getRenderDefaultModality()
  {
    return this.options.getRenderDefaultModality();
  }
  
  public boolean getRenderDefaultVisibility()
  {
    return this.options.getRenderDefaultVisibility();
  }
  
  public boolean getRenderPrimaryConstructorParametersAsProperties()
  {
    return this.options.getRenderPrimaryConstructorParametersAsProperties();
  }
  
  public boolean getRenderTypeExpansions()
  {
    return this.options.getRenderTypeExpansions();
  }
  
  public boolean getRenderUnabbreviatedType()
  {
    return this.options.getRenderUnabbreviatedType();
  }
  
  public boolean getSecondaryConstructorsAsPrimary()
  {
    return this.options.getSecondaryConstructorsAsPrimary();
  }
  
  public boolean getStartFromDeclarationKeyword()
  {
    return this.options.getStartFromDeclarationKeyword();
  }
  
  public boolean getStartFromName()
  {
    return this.options.getStartFromName();
  }
  
  @NotNull
  public RenderingFormat getTextFormat()
  {
    return this.options.getTextFormat();
  }
  
  @NotNull
  public Function1<KotlinType, KotlinType> getTypeNormalizer()
  {
    return this.options.getTypeNormalizer();
  }
  
  public boolean getUninferredTypeParameterAsName()
  {
    return this.options.getUninferredTypeParameterAsName();
  }
  
  public boolean getUnitReturnType()
  {
    return this.options.getUnitReturnType();
  }
  
  @NotNull
  public DescriptorRenderer.ValueParametersHandler getValueParametersHandler()
  {
    return this.options.getValueParametersHandler();
  }
  
  public boolean getVerbose()
  {
    return this.options.getVerbose();
  }
  
  public boolean getWithDefinedIn()
  {
    return this.options.getWithDefinedIn();
  }
  
  public boolean getWithSourceFileForTopLevel()
  {
    return this.options.getWithSourceFileForTopLevel();
  }
  
  public boolean getWithoutReturnType()
  {
    return this.options.getWithoutReturnType();
  }
  
  public boolean getWithoutSuperTypes()
  {
    return this.options.getWithoutSuperTypes();
  }
  
  public boolean getWithoutTypeParameters()
  {
    return this.options.getWithoutTypeParameters();
  }
  
  @NotNull
  public String render(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "declarationDescriptor");
    StringBuilder localStringBuilder = new StringBuilder();
    paramDeclarationDescriptor.accept((DeclarationDescriptorVisitor)new DescriptorRendererImpl.RenderDeclarationDescriptorVisitor(this), localStringBuilder);
    if (getWithDefinedIn()) {
      appendDefinedIn(localStringBuilder, paramDeclarationDescriptor);
    }
    paramDeclarationDescriptor = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramDeclarationDescriptor, "StringBuilder().apply(builderAction).toString()");
    return paramDeclarationDescriptor;
  }
  
  @NotNull
  public String renderAnnotation(@NotNull AnnotationDescriptor paramAnnotationDescriptor, @Nullable AnnotationUseSiteTarget paramAnnotationUseSiteTarget)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationDescriptor, "annotation");
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append('@');
    if (paramAnnotationUseSiteTarget != null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramAnnotationUseSiteTarget.getRenderName());
      localStringBuilder2.append(":");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    paramAnnotationUseSiteTarget = paramAnnotationDescriptor.getType();
    localStringBuilder1.append(renderType(paramAnnotationUseSiteTarget));
    if (getIncludeAnnotationArguments())
    {
      paramAnnotationDescriptor = renderAndSortAnnotationArguments(paramAnnotationDescriptor);
      if ((getIncludeEmptyAnnotationArguments()) || ((((Collection)paramAnnotationDescriptor).isEmpty() ^ true))) {
        CollectionsKt.joinTo$default((Iterable)paramAnnotationDescriptor, (Appendable)localStringBuilder1, (CharSequence)", ", (CharSequence)"(", (CharSequence)")", 0, null, null, 112, null);
      }
    }
    if ((getVerbose()) && ((KotlinTypeKt.isError(paramAnnotationUseSiteTarget)) || ((paramAnnotationUseSiteTarget.getConstructor().getDeclarationDescriptor() instanceof NotFoundClasses.MockClassDescriptor)))) {
      localStringBuilder1.append(" /* annotation class not found */");
    }
    paramAnnotationDescriptor = localStringBuilder1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramAnnotationDescriptor, "StringBuilder().apply(builderAction).toString()");
    return paramAnnotationDescriptor;
  }
  
  @NotNull
  public String renderClassifierName(@NotNull ClassifierDescriptor paramClassifierDescriptor)
  {
    Intrinsics.checkParameterIsNotNull(paramClassifierDescriptor, "klass");
    if (ErrorUtils.isError((DeclarationDescriptor)paramClassifierDescriptor)) {
      return paramClassifierDescriptor.getTypeConstructor().toString();
    }
    return getClassifierNamePolicy().renderClassifier(paramClassifierDescriptor, (DescriptorRenderer)this);
  }
  
  @NotNull
  public String renderFlexibleType(@NotNull String paramString1, @NotNull String paramString2, @NotNull KotlinBuiltIns paramKotlinBuiltIns)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "lowerRendered");
    Intrinsics.checkParameterIsNotNull(paramString2, "upperRendered");
    Intrinsics.checkParameterIsNotNull(paramKotlinBuiltIns, "builtIns");
    if (differsOnlyInNullability(paramString1, paramString2))
    {
      if (StringsKt.startsWith$default(paramString2, "(", false, 2, null))
      {
        paramString2 = new StringBuilder();
        paramString2.append('(');
        paramString2.append(paramString1);
        paramString2.append(")!");
        return paramString2.toString();
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append('!');
      return paramString2.toString();
    }
    Object localObject2 = getClassifierNamePolicy();
    Object localObject1 = paramKotlinBuiltIns.getCollection();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "builtIns.collection");
    Object localObject3 = (ClassifierDescriptor)localObject1;
    localObject1 = (DescriptorRenderer)this;
    localObject2 = StringsKt.substringBefore$default(((ClassifierNamePolicy)localObject2).renderClassifier((ClassifierDescriptor)localObject3, (DescriptorRenderer)localObject1), "Collection", null, 2, null);
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("Mutable");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append('(');
    ((StringBuilder)localObject4).append("Mutable");
    ((StringBuilder)localObject4).append(')');
    localObject3 = replacePrefixes(paramString1, (String)localObject3, paramString2, (String)localObject2, ((StringBuilder)localObject4).toString());
    if (localObject3 != null) {
      return localObject3;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append("MutableMap.MutableEntry");
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append((String)localObject2);
    ((StringBuilder)localObject4).append("Map.Entry");
    localObject4 = ((StringBuilder)localObject4).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("(Mutable)Map.(Mutable)Entry");
    localObject2 = replacePrefixes(paramString1, (String)localObject3, paramString2, (String)localObject4, localStringBuilder.toString());
    if (localObject2 != null) {
      return localObject2;
    }
    localObject2 = getClassifierNamePolicy();
    paramKotlinBuiltIns = paramKotlinBuiltIns.getArray();
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinBuiltIns, "builtIns.array");
    paramKotlinBuiltIns = StringsKt.substringBefore$default(((ClassifierNamePolicy)localObject2).renderClassifier((ClassifierDescriptor)paramKotlinBuiltIns, (DescriptorRenderer)localObject1), "Array", null, 2, null);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramKotlinBuiltIns);
    ((StringBuilder)localObject1).append(escape("Array<"));
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramKotlinBuiltIns);
    ((StringBuilder)localObject2).append(escape("Array<out "));
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(paramKotlinBuiltIns);
    ((StringBuilder)localObject3).append(escape("Array<(out) "));
    paramKotlinBuiltIns = replacePrefixes(paramString1, (String)localObject1, paramString2, (String)localObject2, ((StringBuilder)localObject3).toString());
    if (paramKotlinBuiltIns != null) {
      return paramKotlinBuiltIns;
    }
    paramKotlinBuiltIns = new StringBuilder();
    paramKotlinBuiltIns.append('(');
    paramKotlinBuiltIns.append(paramString1);
    paramKotlinBuiltIns.append("..");
    paramKotlinBuiltIns.append(paramString2);
    paramKotlinBuiltIns.append(')');
    return paramKotlinBuiltIns.toString();
  }
  
  @NotNull
  public String renderFqName(@NotNull FqNameUnsafe paramFqNameUnsafe)
  {
    Intrinsics.checkParameterIsNotNull(paramFqNameUnsafe, "fqName");
    paramFqNameUnsafe = paramFqNameUnsafe.pathSegments();
    Intrinsics.checkExpressionValueIsNotNull(paramFqNameUnsafe, "fqName.pathSegments()");
    return renderFqName(paramFqNameUnsafe);
  }
  
  @NotNull
  public String renderMessage(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    Object localObject = getTextFormat();
    int i = DescriptorRendererImpl.WhenMappings.$EnumSwitchMapping$3[localObject.ordinal()];
    if (i != 1)
    {
      if (i == 2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<i>");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("</i>");
        return ((StringBuilder)localObject).toString();
      }
      throw new NoWhenBranchMatchedException();
    }
    return paramString;
  }
  
  @NotNull
  public String renderName(@NotNull Name paramName, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    String str = escape(RenderingUtilsKt.render(paramName));
    paramName = str;
    if (getBoldOnlyForNamesInHtml())
    {
      paramName = str;
      if (getTextFormat() == RenderingFormat.HTML)
      {
        paramName = str;
        if (paramBoolean)
        {
          paramName = new StringBuilder();
          paramName.append("<b>");
          paramName.append(str);
          paramName.append("</b>");
          paramName = paramName.toString();
        }
      }
    }
    return paramName;
  }
  
  @NotNull
  public String renderType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "type");
    StringBuilder localStringBuilder = new StringBuilder();
    renderNormalizedType(localStringBuilder, (KotlinType)getTypeNormalizer().invoke(paramKotlinType));
    paramKotlinType = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "StringBuilder().apply(builderAction).toString()");
    return paramKotlinType;
  }
  
  @NotNull
  public String renderTypeArguments(@NotNull List<? extends TypeProjection> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "typeArguments");
    if (paramList.isEmpty()) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(lt());
    appendTypeProjections(localStringBuilder, paramList);
    localStringBuilder.append(gt());
    paramList = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "StringBuilder().apply(builderAction).toString()");
    return paramList;
  }
  
  @NotNull
  public String renderTypeConstructor(@NotNull TypeConstructor paramTypeConstructor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "typeConstructor");
    ClassifierDescriptor localClassifierDescriptor = paramTypeConstructor.getDeclarationDescriptor();
    if (((localClassifierDescriptor instanceof TypeParameterDescriptor)) || ((localClassifierDescriptor instanceof ClassDescriptor)) || ((localClassifierDescriptor instanceof TypeAliasDescriptor))) {
      return renderClassifierName(localClassifierDescriptor);
    }
    if (localClassifierDescriptor == null) {
      return paramTypeConstructor.toString();
    }
    paramTypeConstructor = new StringBuilder();
    paramTypeConstructor.append("Unexpected classifier: ");
    paramTypeConstructor.append(localClassifierDescriptor.getClass());
    throw ((Throwable)new IllegalStateException(paramTypeConstructor.toString().toString()));
  }
  
  @NotNull
  public String renderTypeProjection(@NotNull TypeProjection paramTypeProjection)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeProjection, "typeProjection");
    StringBuilder localStringBuilder = new StringBuilder();
    appendTypeProjections(localStringBuilder, CollectionsKt.listOf(paramTypeProjection));
    paramTypeProjection = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramTypeProjection, "StringBuilder().apply(builderAction).toString()");
    return paramTypeProjection;
  }
  
  public void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy paramAnnotationArgumentsRenderingPolicy)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotationArgumentsRenderingPolicy, "<set-?>");
    this.options.setAnnotationArgumentsRenderingPolicy(paramAnnotationArgumentsRenderingPolicy);
  }
  
  public void setClassifierNamePolicy(@NotNull ClassifierNamePolicy paramClassifierNamePolicy)
  {
    Intrinsics.checkParameterIsNotNull(paramClassifierNamePolicy, "<set-?>");
    this.options.setClassifierNamePolicy(paramClassifierNamePolicy);
  }
  
  public void setDebugMode(boolean paramBoolean)
  {
    this.options.setDebugMode(paramBoolean);
  }
  
  public void setExcludedTypeAnnotationClasses(@NotNull Set<FqName> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "<set-?>");
    this.options.setExcludedTypeAnnotationClasses(paramSet);
  }
  
  public void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> paramSet)
  {
    Intrinsics.checkParameterIsNotNull(paramSet, "<set-?>");
    this.options.setModifiers(paramSet);
  }
  
  public void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy paramParameterNameRenderingPolicy)
  {
    Intrinsics.checkParameterIsNotNull(paramParameterNameRenderingPolicy, "<set-?>");
    this.options.setParameterNameRenderingPolicy(paramParameterNameRenderingPolicy);
  }
  
  public void setReceiverAfterName(boolean paramBoolean)
  {
    this.options.setReceiverAfterName(paramBoolean);
  }
  
  public void setRenderCompanionObjectName(boolean paramBoolean)
  {
    this.options.setRenderCompanionObjectName(paramBoolean);
  }
  
  public void setStartFromName(boolean paramBoolean)
  {
    this.options.setStartFromName(paramBoolean);
  }
  
  public void setTextFormat(@NotNull RenderingFormat paramRenderingFormat)
  {
    Intrinsics.checkParameterIsNotNull(paramRenderingFormat, "<set-?>");
    this.options.setTextFormat(paramRenderingFormat);
  }
  
  public void setVerbose(boolean paramBoolean)
  {
    this.options.setVerbose(paramBoolean);
  }
  
  public void setWithDefinedIn(boolean paramBoolean)
  {
    this.options.setWithDefinedIn(paramBoolean);
  }
  
  public void setWithoutSuperTypes(boolean paramBoolean)
  {
    this.options.setWithoutSuperTypes(paramBoolean);
  }
  
  public void setWithoutTypeParameters(boolean paramBoolean)
  {
    this.options.setWithoutTypeParameters(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl
 * JD-Core Version:    0.7.0.1
 */