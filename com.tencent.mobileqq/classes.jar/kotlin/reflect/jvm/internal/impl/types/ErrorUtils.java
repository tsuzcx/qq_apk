package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PropertyDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorSimpleFunctionDescriptorImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ErrorUtils
{
  private static final ErrorUtils.ErrorClassDescriptor ERROR_CLASS;
  private static final ModuleDescriptor ERROR_MODULE = new ErrorUtils.1();
  private static final PropertyDescriptor ERROR_PROPERTY = createErrorProperty();
  private static final Set<PropertyDescriptor> ERROR_PROPERTY_GROUP = Collections.singleton(ERROR_PROPERTY);
  private static final KotlinType ERROR_PROPERTY_TYPE;
  public static final SimpleType ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES;
  
  static
  {
    ERROR_CLASS = new ErrorUtils.ErrorClassDescriptor(Name.special("<ERROR CLASS>"));
    ERROR_TYPE_FOR_LOOP_IN_SUPERTYPES = createErrorType("<LOOP IN SUPERTYPES>");
    ERROR_PROPERTY_TYPE = createErrorType("<ERROR PROPERTY TYPE>");
  }
  
  @NotNull
  public static ClassDescriptor createErrorClass(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<ERROR CLASS: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(">");
    return new ErrorUtils.ErrorClassDescriptor(Name.special(localStringBuilder.toString()));
  }
  
  @NotNull
  private static SimpleFunctionDescriptor createErrorFunction(@NotNull ErrorUtils.ErrorScope paramErrorScope)
  {
    if (paramErrorScope == null) {
      $$$reportNull$$$0(5);
    }
    paramErrorScope = new ErrorSimpleFunctionDescriptorImpl(ERROR_CLASS, paramErrorScope);
    paramErrorScope.initialize(null, null, Collections.emptyList(), Collections.emptyList(), createErrorType("<ERROR FUNCTION RETURN TYPE>"), Modality.OPEN, Visibilities.PUBLIC);
    return paramErrorScope;
  }
  
  @NotNull
  private static PropertyDescriptorImpl createErrorProperty()
  {
    PropertyDescriptorImpl localPropertyDescriptorImpl = PropertyDescriptorImpl.create(ERROR_CLASS, Annotations.Companion.getEMPTY(), Modality.OPEN, Visibilities.PUBLIC, true, Name.special("<ERROR PROPERTY>"), CallableMemberDescriptor.Kind.DECLARATION, SourceElement.NO_SOURCE, false, false, false, false, false, false);
    localPropertyDescriptorImpl.setType(ERROR_PROPERTY_TYPE, Collections.emptyList(), null, null);
    if (localPropertyDescriptorImpl == null) {
      $$$reportNull$$$0(4);
    }
    return localPropertyDescriptorImpl;
  }
  
  @NotNull
  public static MemberScope createErrorScope(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(2);
    }
    return createErrorScope(paramString, false);
  }
  
  @NotNull
  public static MemberScope createErrorScope(@NotNull String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      $$$reportNull$$$0(3);
    }
    if (paramBoolean) {
      return new ErrorUtils.ThrowingScope(paramString, null);
    }
    return new ErrorUtils.ErrorScope(paramString, null);
  }
  
  @NotNull
  public static SimpleType createErrorType(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(7);
    }
    return createErrorTypeWithArguments(paramString, Collections.emptyList());
  }
  
  @NotNull
  public static TypeConstructor createErrorTypeConstructor(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(15);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[ERROR : ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    return createErrorTypeConstructorWithCustomDebugName(localStringBuilder.toString(), ERROR_CLASS);
  }
  
  @NotNull
  public static TypeConstructor createErrorTypeConstructorWithCustomDebugName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(16);
    }
    return createErrorTypeConstructorWithCustomDebugName(paramString, ERROR_CLASS);
  }
  
  @NotNull
  private static TypeConstructor createErrorTypeConstructorWithCustomDebugName(@NotNull String paramString, @NotNull ErrorUtils.ErrorClassDescriptor paramErrorClassDescriptor)
  {
    if (paramString == null) {
      $$$reportNull$$$0(17);
    }
    if (paramErrorClassDescriptor == null) {
      $$$reportNull$$$0(18);
    }
    return new ErrorUtils.2(paramErrorClassDescriptor, paramString);
  }
  
  @NotNull
  public static SimpleType createErrorTypeWithArguments(@NotNull String paramString, @NotNull List<TypeProjection> paramList)
  {
    if (paramString == null) {
      $$$reportNull$$$0(11);
    }
    if (paramList == null) {
      $$$reportNull$$$0(12);
    }
    return new ErrorType(createErrorTypeConstructor(paramString), createErrorScope(paramString), paramList, false);
  }
  
  @NotNull
  public static SimpleType createErrorTypeWithCustomConstructor(@NotNull String paramString, @NotNull TypeConstructor paramTypeConstructor)
  {
    if (paramString == null) {
      $$$reportNull$$$0(9);
    }
    if (paramTypeConstructor == null) {
      $$$reportNull$$$0(10);
    }
    return new ErrorType(paramTypeConstructor, createErrorScope(paramString));
  }
  
  @NotNull
  public static SimpleType createErrorTypeWithCustomDebugName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(8);
    }
    return createErrorTypeWithCustomConstructor(paramString, createErrorTypeConstructorWithCustomDebugName(paramString));
  }
  
  @NotNull
  public static ModuleDescriptor getErrorModule()
  {
    ModuleDescriptor localModuleDescriptor = ERROR_MODULE;
    if (localModuleDescriptor == null) {
      $$$reportNull$$$0(19);
    }
    return localModuleDescriptor;
  }
  
  public static boolean isError(@Nullable DeclarationDescriptor paramDeclarationDescriptor)
  {
    boolean bool = false;
    if (paramDeclarationDescriptor == null) {
      return false;
    }
    if ((isErrorClass(paramDeclarationDescriptor)) || (isErrorClass(paramDeclarationDescriptor.getContainingDeclaration())) || (paramDeclarationDescriptor == ERROR_MODULE)) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isErrorClass(@Nullable DeclarationDescriptor paramDeclarationDescriptor)
  {
    return paramDeclarationDescriptor instanceof ErrorUtils.ErrorClassDescriptor;
  }
  
  public static boolean isUninferredParameter(@Nullable KotlinType paramKotlinType)
  {
    return (paramKotlinType != null) && ((paramKotlinType.getConstructor() instanceof ErrorUtils.UninferredParameterTypeConstructor));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.ErrorUtils
 * JD-Core Version:    0.7.0.1
 */