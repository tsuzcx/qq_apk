package kotlin.reflect.jvm.internal.impl.name;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpecialNames
{
  public static final Name ANONYMOUS_FUNCTION = Name.special("<anonymous>");
  public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT;
  public static final Name NO_NAME_PROVIDED = Name.special("<no name provided>");
  public static final Name ROOT_PACKAGE = Name.special("<root package>");
  public static final Name SAFE_IDENTIFIER_FOR_NO_NAME;
  
  static
  {
    DEFAULT_NAME_FOR_COMPANION_OBJECT = Name.identifier("Companion");
    SAFE_IDENTIFIER_FOR_NO_NAME = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
  }
  
  public static boolean isSafeIdentifier(@NotNull Name paramName)
  {
    if (paramName == null) {
      $$$reportNull$$$0(1);
    }
    return (!paramName.asString().isEmpty()) && (!paramName.isSpecial());
  }
  
  @NotNull
  public static Name safeIdentifier(@Nullable Name paramName)
  {
    if ((paramName == null) || (paramName.isSpecial())) {
      paramName = SAFE_IDENTIFIER_FOR_NO_NAME;
    }
    if (paramName == null) {
      $$$reportNull$$$0(0);
    }
    return paramName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.name.SpecialNames
 * JD-Core Version:    0.7.0.1
 */