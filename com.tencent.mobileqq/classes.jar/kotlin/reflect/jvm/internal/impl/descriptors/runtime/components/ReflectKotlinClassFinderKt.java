package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

public final class ReflectKotlinClassFinderKt
{
  private static final String toRuntimeFqName(@NotNull ClassId paramClassId)
  {
    String str = paramClassId.getRelativeClassName().asString();
    Intrinsics.checkExpressionValueIsNotNull(str, "relativeClassName.asString()");
    str = StringsKt.replace$default(str, '.', '$', false, 4, null);
    Object localObject = paramClassId.getPackageFqName();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "packageFqName");
    if (((FqName)localObject).isRoot()) {
      return str;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramClassId.getPackageFqName());
    ((StringBuilder)localObject).append('.');
    ((StringBuilder)localObject).append(str);
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClassFinderKt
 * JD-Core Version:    0.7.0.1
 */