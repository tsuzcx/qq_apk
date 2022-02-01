package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FunctionClassDescriptor$Kind$Companion
{
  @Nullable
  public final FunctionClassDescriptor.Kind byClassNamePrefix(@NotNull FqName paramFqName, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramFqName, "packageFqName");
    Intrinsics.checkParameterIsNotNull(paramString, "className");
    FunctionClassDescriptor.Kind[] arrayOfKind = FunctionClassDescriptor.Kind.values();
    int k = arrayOfKind.length;
    int i = 0;
    while (i < k)
    {
      FunctionClassDescriptor.Kind localKind = arrayOfKind[i];
      int j;
      if ((Intrinsics.areEqual(localKind.getPackageFqName(), paramFqName)) && (StringsKt.startsWith$default(paramString, localKind.getClassNamePrefix(), false, 2, null))) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        return localKind;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassDescriptor.Kind.Companion
 * JD-Core Version:    0.7.0.1
 */