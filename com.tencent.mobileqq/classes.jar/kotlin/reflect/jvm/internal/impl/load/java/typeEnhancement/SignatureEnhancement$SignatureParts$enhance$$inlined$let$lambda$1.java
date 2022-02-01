package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class SignatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1
  extends Lambda
  implements Function1<Integer, JavaTypeQualifiers>
{
  SignatureEnhancement$SignatureParts$enhance$$inlined$let$lambda$1(TypeEnhancementInfo paramTypeEnhancementInfo, Function1 paramFunction1)
  {
    super(1);
  }
  
  @NotNull
  public final JavaTypeQualifiers invoke(int paramInt)
  {
    JavaTypeQualifiers localJavaTypeQualifiers = (JavaTypeQualifiers)this.$predefined$inlined.getMap().get(Integer.valueOf(paramInt));
    if (localJavaTypeQualifiers != null) {
      return localJavaTypeQualifiers;
    }
    return (JavaTypeQualifiers)this.$qualifiers$inlined.invoke(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts.enhance..inlined.let.lambda.1
 * JD-Core Version:    0.7.0.1
 */