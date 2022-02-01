package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Modifier;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.JavaVisibilities;
import org.jetbrains.annotations.NotNull;

public final class ReflectJavaModifierListOwner$DefaultImpls
{
  @NotNull
  public static Visibility getVisibility(ReflectJavaModifierListOwner paramReflectJavaModifierListOwner)
  {
    int i = paramReflectJavaModifierListOwner.getModifiers();
    if (Modifier.isPublic(i))
    {
      paramReflectJavaModifierListOwner = Visibilities.PUBLIC;
      Intrinsics.checkExpressionValueIsNotNull(paramReflectJavaModifierListOwner, "Visibilities.PUBLIC");
      return paramReflectJavaModifierListOwner;
    }
    if (Modifier.isPrivate(i))
    {
      paramReflectJavaModifierListOwner = Visibilities.PRIVATE;
      Intrinsics.checkExpressionValueIsNotNull(paramReflectJavaModifierListOwner, "Visibilities.PRIVATE");
      return paramReflectJavaModifierListOwner;
    }
    if (Modifier.isProtected(i))
    {
      if (Modifier.isStatic(i)) {
        paramReflectJavaModifierListOwner = JavaVisibilities.PROTECTED_STATIC_VISIBILITY;
      } else {
        paramReflectJavaModifierListOwner = JavaVisibilities.PROTECTED_AND_PACKAGE;
      }
      Intrinsics.checkExpressionValueIsNotNull(paramReflectJavaModifierListOwner, "if (Modifier.isStatic(mo…ies.PROTECTED_AND_PACKAGE");
      return paramReflectJavaModifierListOwner;
    }
    paramReflectJavaModifierListOwner = JavaVisibilities.PACKAGE_VISIBILITY;
    Intrinsics.checkExpressionValueIsNotNull(paramReflectJavaModifierListOwner, "JavaVisibilities.PACKAGE_VISIBILITY");
    return paramReflectJavaModifierListOwner;
  }
  
  public static boolean isAbstract(ReflectJavaModifierListOwner paramReflectJavaModifierListOwner)
  {
    return Modifier.isAbstract(paramReflectJavaModifierListOwner.getModifiers());
  }
  
  public static boolean isFinal(ReflectJavaModifierListOwner paramReflectJavaModifierListOwner)
  {
    return Modifier.isFinal(paramReflectJavaModifierListOwner.getModifiers());
  }
  
  public static boolean isStatic(ReflectJavaModifierListOwner paramReflectJavaModifierListOwner)
  {
    return Modifier.isStatic(paramReflectJavaModifierListOwner.getModifiers());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */