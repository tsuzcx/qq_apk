package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class LazyJavaScope$declaredField$1
  extends Lambda
  implements Function1<Name, PropertyDescriptor>
{
  LazyJavaScope$declaredField$1(LazyJavaScope paramLazyJavaScope)
  {
    super(1);
  }
  
  @Nullable
  public final PropertyDescriptor invoke(@NotNull Name paramName)
  {
    Intrinsics.checkParameterIsNotNull(paramName, "name");
    if (this.this$0.getMainScope() != null) {
      return (PropertyDescriptor)LazyJavaScope.access$getDeclaredField$p(this.this$0.getMainScope()).invoke(paramName);
    }
    paramName = ((DeclaredMemberIndex)this.this$0.getDeclaredMemberIndex().invoke()).findFieldByName(paramName);
    if ((paramName != null) && (!paramName.isEnumEntry())) {
      return LazyJavaScope.access$resolveProperty(this.this$0, paramName);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaScope.declaredField.1
 * JD-Core Version:    0.7.0.1
 */