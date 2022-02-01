package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import org.jetbrains.annotations.Nullable;

final class JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1
  extends Lambda
  implements Function1<JavaType, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  JavaTypeResolver$argumentsMakeSenseOnlyForMutableContainer$1()
  {
    super(1);
  }
  
  public final boolean invoke(@Nullable JavaType paramJavaType)
  {
    JavaType localJavaType = paramJavaType;
    if (!(paramJavaType instanceof JavaWildcardType)) {
      localJavaType = null;
    }
    paramJavaType = (JavaWildcardType)localJavaType;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJavaType != null)
    {
      bool1 = bool2;
      if (paramJavaType.getBound() != null)
      {
        bool1 = bool2;
        if (!paramJavaType.isExtends()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.argumentsMakeSenseOnlyForMutableContainer.1
 * JD-Core Version:    0.7.0.1
 */