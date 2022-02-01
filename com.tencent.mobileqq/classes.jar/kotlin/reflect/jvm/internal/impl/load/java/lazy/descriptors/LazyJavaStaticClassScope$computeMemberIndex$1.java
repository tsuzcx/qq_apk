package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import org.jetbrains.annotations.NotNull;

final class LazyJavaStaticClassScope$computeMemberIndex$1
  extends Lambda
  implements Function1<JavaMember, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  LazyJavaStaticClassScope$computeMemberIndex$1()
  {
    super(1);
  }
  
  public final boolean invoke(@NotNull JavaMember paramJavaMember)
  {
    Intrinsics.checkParameterIsNotNull(paramJavaMember, "it");
    return paramJavaMember.isStatic();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope.computeMemberIndex.1
 * JD-Core Version:    0.7.0.1
 */