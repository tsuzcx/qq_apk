package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class SignatureBuildingComponents$jvmDescriptor$1
  extends Lambda
  implements Function1<String, String>
{
  public static final 1 INSTANCE = new 1();
  
  SignatureBuildingComponents$jvmDescriptor$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "it");
    return SignatureBuildingComponents.access$escapeClassName(SignatureBuildingComponents.INSTANCE, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents.jvmDescriptor.1
 * JD-Core Version:    0.7.0.1
 */