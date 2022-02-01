package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FieldDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize.CapitalizeDecapitalizeKt;
import org.jetbrains.annotations.NotNull;

public final class JvmAbi
{
  public static final FqName JVM_FIELD_ANNOTATION_FQ_NAME = new FqName("kotlin.jvm.JvmField");
  public static final ClassId REFLECTION_FACTORY_IMPL = ClassId.topLevel(new FqName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl"));
  
  @NotNull
  public static String getterName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(6);
    }
    if (!startsWithIsPrefix(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get");
      localStringBuilder.append(CapitalizeDecapitalizeKt.capitalizeAsciiOnly(paramString));
      paramString = localStringBuilder.toString();
    }
    if (paramString == null) {
      $$$reportNull$$$0(7);
    }
    return paramString;
  }
  
  public static boolean hasJvmFieldAnnotation(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor)
  {
    if (paramCallableMemberDescriptor == null) {
      $$$reportNull$$$0(13);
    }
    if ((paramCallableMemberDescriptor instanceof PropertyDescriptor))
    {
      FieldDescriptor localFieldDescriptor = ((PropertyDescriptor)paramCallableMemberDescriptor).getBackingField();
      if ((localFieldDescriptor != null) && (localFieldDescriptor.getAnnotations().hasAnnotation(JVM_FIELD_ANNOTATION_FQ_NAME))) {
        return true;
      }
    }
    return paramCallableMemberDescriptor.getAnnotations().hasAnnotation(JVM_FIELD_ANNOTATION_FQ_NAME);
  }
  
  public static boolean isClassCompanionObjectWithBackingFieldsInOuter(@NotNull DeclarationDescriptor paramDeclarationDescriptor)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(11);
    }
    return (DescriptorUtils.isCompanionObject(paramDeclarationDescriptor)) && (DescriptorUtils.isClassOrEnumClass(paramDeclarationDescriptor.getContainingDeclaration())) && (!isMappedIntrinsicCompanionObject((ClassDescriptor)paramDeclarationDescriptor));
  }
  
  public static boolean isGetterName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(4);
    }
    return (paramString.startsWith("get")) || (paramString.startsWith("is"));
  }
  
  public static boolean isMappedIntrinsicCompanionObject(@NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(12);
    }
    return CompanionObjectMapping.INSTANCE.isMappedIntrinsicCompanionObject(paramClassDescriptor);
  }
  
  public static boolean isPropertyWithBackingFieldInOuterClass(@NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    if (paramPropertyDescriptor == null) {
      $$$reportNull$$$0(10);
    }
    if (paramPropertyDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
      return false;
    }
    if (isClassCompanionObjectWithBackingFieldsInOuter(paramPropertyDescriptor.getContainingDeclaration())) {
      return true;
    }
    return (DescriptorUtils.isCompanionObject(paramPropertyDescriptor.getContainingDeclaration())) && (hasJvmFieldAnnotation(paramPropertyDescriptor));
  }
  
  public static boolean isSetterName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(5);
    }
    return paramString.startsWith("set");
  }
  
  @NotNull
  public static String setterName(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(8);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set");
    if (startsWithIsPrefix(paramString)) {
      paramString = paramString.substring(2);
    } else {
      paramString = CapitalizeDecapitalizeKt.capitalizeAsciiOnly(paramString);
    }
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (paramString == null) {
      $$$reportNull$$$0(9);
    }
    return paramString;
  }
  
  public static boolean startsWithIsPrefix(String paramString)
  {
    boolean bool2 = paramString.startsWith("is");
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (paramString.length() == 2) {
      return false;
    }
    int i = paramString.charAt(2);
    if ((97 > i) || (i > 122)) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.JvmAbi
 * JD-Core Version:    0.7.0.1
 */