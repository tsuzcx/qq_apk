package kotlin.reflect.jvm.internal.impl.load.java.components;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorResolverUtils
{
  @Nullable
  public static ValueParameterDescriptor getAnnotationParameterByName(@NotNull Name paramName, @NotNull ClassDescriptor paramClassDescriptor)
  {
    if (paramName == null) {
      $$$reportNull$$$0(19);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(20);
    }
    paramClassDescriptor = paramClassDescriptor.getConstructors();
    if (paramClassDescriptor.size() != 1) {
      return null;
    }
    paramClassDescriptor = ((ClassConstructorDescriptor)paramClassDescriptor.iterator().next()).getValueParameters().iterator();
    while (paramClassDescriptor.hasNext())
    {
      ValueParameterDescriptor localValueParameterDescriptor = (ValueParameterDescriptor)paramClassDescriptor.next();
      if (localValueParameterDescriptor.getName().equals(paramName)) {
        return localValueParameterDescriptor;
      }
    }
    return null;
  }
  
  private static boolean isMethodWithOneObjectParameter(@NotNull JavaMethod paramJavaMethod)
  {
    if (paramJavaMethod == null) {
      $$$reportNull$$$0(23);
    }
    paramJavaMethod = paramJavaMethod.getValueParameters();
    if (paramJavaMethod.size() == 1)
    {
      paramJavaMethod = ((JavaValueParameter)paramJavaMethod.get(0)).getType();
      if ((paramJavaMethod instanceof JavaClassifierType))
      {
        paramJavaMethod = ((JavaClassifierType)paramJavaMethod).getClassifier();
        if ((paramJavaMethod instanceof JavaClass))
        {
          paramJavaMethod = ((JavaClass)paramJavaMethod).getFqName();
          return (paramJavaMethod != null) && (paramJavaMethod.asString().equals("java.lang.Object"));
        }
      }
    }
    return false;
  }
  
  private static boolean isObjectMethod(@NotNull JavaMethod paramJavaMethod)
  {
    if (paramJavaMethod == null) {
      $$$reportNull$$$0(22);
    }
    String str = paramJavaMethod.getName().asString();
    if ((!str.equals("toString")) && (!str.equals("hashCode")))
    {
      if (str.equals("equals")) {
        return isMethodWithOneObjectParameter(paramJavaMethod);
      }
      return false;
    }
    return paramJavaMethod.getValueParameters().isEmpty();
  }
  
  public static boolean isObjectMethodInInterface(@NotNull JavaMember paramJavaMember)
  {
    if (paramJavaMember == null) {
      $$$reportNull$$$0(21);
    }
    return (paramJavaMember.getContainingClass().isInterface()) && ((paramJavaMember instanceof JavaMethod)) && (isObjectMethod((JavaMethod)paramJavaMember));
  }
  
  @NotNull
  private static <D extends CallableMemberDescriptor> Collection<D> resolveOverrides(@NotNull Name paramName, @NotNull Collection<D> paramCollection1, @NotNull Collection<D> paramCollection2, @NotNull ClassDescriptor paramClassDescriptor, @NotNull ErrorReporter paramErrorReporter, @NotNull OverridingUtil paramOverridingUtil, boolean paramBoolean)
  {
    if (paramName == null) {
      $$$reportNull$$$0(12);
    }
    if (paramCollection1 == null) {
      $$$reportNull$$$0(13);
    }
    if (paramCollection2 == null) {
      $$$reportNull$$$0(14);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(15);
    }
    if (paramErrorReporter == null) {
      $$$reportNull$$$0(16);
    }
    if (paramOverridingUtil == null) {
      $$$reportNull$$$0(17);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramOverridingUtil.generateOverridesInFunctionGroup(paramName, paramCollection1, paramCollection2, paramClassDescriptor, new DescriptorResolverUtils.1(paramErrorReporter, localLinkedHashSet, paramBoolean));
    return localLinkedHashSet;
  }
  
  @NotNull
  public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForNonStaticMembers(@NotNull Name paramName, @NotNull Collection<D> paramCollection1, @NotNull Collection<D> paramCollection2, @NotNull ClassDescriptor paramClassDescriptor, @NotNull ErrorReporter paramErrorReporter, @NotNull OverridingUtil paramOverridingUtil)
  {
    if (paramName == null) {
      $$$reportNull$$$0(0);
    }
    if (paramCollection1 == null) {
      $$$reportNull$$$0(1);
    }
    if (paramCollection2 == null) {
      $$$reportNull$$$0(2);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(3);
    }
    if (paramErrorReporter == null) {
      $$$reportNull$$$0(4);
    }
    if (paramOverridingUtil == null) {
      $$$reportNull$$$0(5);
    }
    return resolveOverrides(paramName, paramCollection1, paramCollection2, paramClassDescriptor, paramErrorReporter, paramOverridingUtil, false);
  }
  
  @NotNull
  public static <D extends CallableMemberDescriptor> Collection<D> resolveOverridesForStaticMembers(@NotNull Name paramName, @NotNull Collection<D> paramCollection1, @NotNull Collection<D> paramCollection2, @NotNull ClassDescriptor paramClassDescriptor, @NotNull ErrorReporter paramErrorReporter, @NotNull OverridingUtil paramOverridingUtil)
  {
    if (paramName == null) {
      $$$reportNull$$$0(6);
    }
    if (paramCollection1 == null) {
      $$$reportNull$$$0(7);
    }
    if (paramCollection2 == null) {
      $$$reportNull$$$0(8);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(9);
    }
    if (paramErrorReporter == null) {
      $$$reportNull$$$0(10);
    }
    if (paramOverridingUtil == null) {
      $$$reportNull$$$0(11);
    }
    return resolveOverrides(paramName, paramCollection1, paramCollection2, paramClassDescriptor, paramErrorReporter, paramOverridingUtil, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils
 * JD-Core Version:    0.7.0.1
 */