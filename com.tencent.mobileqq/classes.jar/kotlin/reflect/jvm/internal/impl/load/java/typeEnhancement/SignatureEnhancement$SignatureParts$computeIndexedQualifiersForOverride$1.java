package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1
  extends Lambda
  implements Function1<Integer, JavaTypeQualifiers>
{
  SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1(JavaTypeQualifiers[] paramArrayOfJavaTypeQualifiers)
  {
    super(1);
  }
  
  @NotNull
  public final JavaTypeQualifiers invoke(int paramInt)
  {
    JavaTypeQualifiers[] arrayOfJavaTypeQualifiers = this.$computedResult;
    if ((paramInt >= 0) && (paramInt <= ArraysKt.getLastIndex(arrayOfJavaTypeQualifiers))) {
      return arrayOfJavaTypeQualifiers[paramInt];
    }
    return JavaTypeQualifiers.Companion.getNONE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.computeIndexedQualifiersForOverride.1
 * JD-Core Version:    0.7.0.1
 */