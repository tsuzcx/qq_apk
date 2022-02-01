package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.Nullable;

final class ReflectJavaClass$innerClassNames$2
  extends Lambda
  implements Function1<Class<?>, Name>
{
  public static final 2 INSTANCE = new 2();
  
  ReflectJavaClass$innerClassNames$2()
  {
    super(1);
  }
  
  @Nullable
  public final Name invoke(Class<?> paramClass)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramClass, "it");
    paramClass = paramClass.getSimpleName();
    boolean bool = Name.isValidIdentifier(paramClass);
    Name localName = null;
    if (!bool) {
      paramClass = null;
    }
    if (paramClass != null) {
      localName = Name.identifier(paramClass);
    }
    return localName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass.innerClassNames.2
 * JD-Core Version:    0.7.0.1
 */