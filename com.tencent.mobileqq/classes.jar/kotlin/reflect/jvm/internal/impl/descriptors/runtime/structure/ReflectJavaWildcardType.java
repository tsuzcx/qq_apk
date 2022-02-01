package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaWildcardType
  extends ReflectJavaType
  implements JavaWildcardType
{
  @NotNull
  private final WildcardType reflectType;
  
  public ReflectJavaWildcardType(@NotNull WildcardType paramWildcardType)
  {
    this.reflectType = paramWildcardType;
  }
  
  @Nullable
  public ReflectJavaType getBound()
  {
    Object localObject2 = getReflectType().getUpperBounds();
    Object localObject1 = getReflectType().getLowerBounds();
    if ((localObject2.length <= 1) && (localObject1.length <= 1))
    {
      int i = localObject1.length;
      ReflectJavaType.Factory localFactory = null;
      if (i == 1)
      {
        localFactory = ReflectJavaType.Factory;
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "lowerBounds");
        localObject1 = ArraysKt.single((Object[])localObject1);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "lowerBounds.single()");
        return localFactory.create((Type)localObject1);
      }
      localObject1 = localFactory;
      if (localObject2.length == 1)
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "upperBounds");
        localObject2 = (Type)ArraysKt.single((Object[])localObject2);
        localObject1 = localFactory;
        if ((Intrinsics.areEqual(localObject2, Object.class) ^ true))
        {
          localObject1 = ReflectJavaType.Factory;
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "ub");
          localObject1 = ((ReflectJavaType.Factory)localObject1).create((Type)localObject2);
        }
      }
      return localObject1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Wildcard types with many bounds are not yet supported: ");
    ((StringBuilder)localObject1).append(getReflectType());
    throw ((Throwable)new UnsupportedOperationException(((StringBuilder)localObject1).toString()));
  }
  
  @NotNull
  protected WildcardType getReflectType()
  {
    return this.reflectType;
  }
  
  public boolean isExtends()
  {
    Type[] arrayOfType = getReflectType().getUpperBounds();
    Intrinsics.checkExpressionValueIsNotNull(arrayOfType, "reflectType.upperBounds");
    return Intrinsics.areEqual((Type)ArraysKt.firstOrNull(arrayOfType), Object.class) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaWildcardType
 * JD-Core Version:    0.7.0.1
 */