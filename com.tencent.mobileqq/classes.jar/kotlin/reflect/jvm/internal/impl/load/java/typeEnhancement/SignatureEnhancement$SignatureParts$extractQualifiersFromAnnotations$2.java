package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2
  extends Lambda
  implements Function2<T, T, T>
{
  public static final 2 INSTANCE = new 2();
  
  SignatureEnhancement$SignatureParts$extractQualifiersFromAnnotations$2()
  {
    super(2);
  }
  
  @Nullable
  public final <T> T invoke(@Nullable T paramT1, @Nullable T paramT2)
  {
    if ((paramT1 != null) && (paramT2 != null) && (!Intrinsics.areEqual(paramT1, paramT2))) {
      return null;
    }
    if (paramT1 != null) {
      return paramT1;
    }
    return paramT2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.extractQualifiersFromAnnotations.2
 * JD-Core Version:    0.7.0.1
 */