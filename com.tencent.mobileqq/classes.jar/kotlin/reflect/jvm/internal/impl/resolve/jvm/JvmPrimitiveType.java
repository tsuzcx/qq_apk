package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public enum JvmPrimitiveType
{
  private static final Map<String, JvmPrimitiveType> TYPE_BY_DESC;
  private static final Map<String, JvmPrimitiveType> TYPE_BY_NAME;
  private static final Map<PrimitiveType, JvmPrimitiveType> TYPE_BY_PRIMITIVE_TYPE;
  private static final Set<FqName> WRAPPERS_CLASS_NAMES;
  private final String desc;
  private final String name;
  private final PrimitiveType primitiveType;
  private final FqName wrapperFqName;
  
  static
  {
    BYTE = new JvmPrimitiveType("BYTE", 2, PrimitiveType.BYTE, "byte", "B", "java.lang.Byte");
    SHORT = new JvmPrimitiveType("SHORT", 3, PrimitiveType.SHORT, "short", "S", "java.lang.Short");
    INT = new JvmPrimitiveType("INT", 4, PrimitiveType.INT, "int", "I", "java.lang.Integer");
    FLOAT = new JvmPrimitiveType("FLOAT", 5, PrimitiveType.FLOAT, "float", "F", "java.lang.Float");
    LONG = new JvmPrimitiveType("LONG", 6, PrimitiveType.LONG, "long", "J", "java.lang.Long");
    DOUBLE = new JvmPrimitiveType("DOUBLE", 7, PrimitiveType.DOUBLE, "double", "D", "java.lang.Double");
    Object localObject1 = BOOLEAN;
    int i = 0;
    $VALUES = new JvmPrimitiveType[] { localObject1, CHAR, BYTE, SHORT, INT, FLOAT, LONG, DOUBLE };
    WRAPPERS_CLASS_NAMES = new HashSet();
    TYPE_BY_NAME = new HashMap();
    TYPE_BY_PRIMITIVE_TYPE = new EnumMap(PrimitiveType.class);
    TYPE_BY_DESC = new HashMap();
    localObject1 = values();
    int j = localObject1.length;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      WRAPPERS_CLASS_NAMES.add(localObject2.getWrapperFqName());
      TYPE_BY_NAME.put(localObject2.getJavaKeywordName(), localObject2);
      TYPE_BY_PRIMITIVE_TYPE.put(localObject2.getPrimitiveType(), localObject2);
      TYPE_BY_DESC.put(localObject2.getDesc(), localObject2);
      i += 1;
    }
  }
  
  private JvmPrimitiveType(PrimitiveType paramPrimitiveType, String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    this.primitiveType = paramPrimitiveType;
    this.name = paramString1;
    this.desc = paramString2;
    this.wrapperFqName = new FqName(paramString3);
  }
  
  @NotNull
  public static JvmPrimitiveType get(@NotNull String paramString)
  {
    if (paramString == null) {
      $$$reportNull$$$0(1);
    }
    Object localObject = (JvmPrimitiveType)TYPE_BY_NAME.get(paramString);
    if (localObject != null)
    {
      if (localObject == null) {
        $$$reportNull$$$0(2);
      }
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Non-primitive type name passed: ");
    ((StringBuilder)localObject).append(paramString);
    throw new AssertionError(((StringBuilder)localObject).toString());
  }
  
  @NotNull
  public static JvmPrimitiveType get(@NotNull PrimitiveType paramPrimitiveType)
  {
    if (paramPrimitiveType == null) {
      $$$reportNull$$$0(3);
    }
    paramPrimitiveType = (JvmPrimitiveType)TYPE_BY_PRIMITIVE_TYPE.get(paramPrimitiveType);
    if (paramPrimitiveType == null) {
      $$$reportNull$$$0(4);
    }
    return paramPrimitiveType;
  }
  
  @NotNull
  public String getDesc()
  {
    String str = this.desc;
    if (str == null) {
      $$$reportNull$$$0(12);
    }
    return str;
  }
  
  @NotNull
  public String getJavaKeywordName()
  {
    String str = this.name;
    if (str == null) {
      $$$reportNull$$$0(11);
    }
    return str;
  }
  
  @NotNull
  public PrimitiveType getPrimitiveType()
  {
    PrimitiveType localPrimitiveType = this.primitiveType;
    if (localPrimitiveType == null) {
      $$$reportNull$$$0(10);
    }
    return localPrimitiveType;
  }
  
  @NotNull
  public FqName getWrapperFqName()
  {
    FqName localFqName = this.wrapperFqName;
    if (localFqName == null) {
      $$$reportNull$$$0(13);
    }
    return localFqName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType
 * JD-Core Version:    0.7.0.1
 */