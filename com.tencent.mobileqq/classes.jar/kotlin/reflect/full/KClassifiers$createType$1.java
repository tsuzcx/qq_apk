package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClassifier;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class KClassifiers$createType$1
  extends Lambda
  implements Function0
{
  KClassifiers$createType$1(KClassifier paramKClassifier)
  {
    super(0);
  }
  
  @NotNull
  public final Void invoke()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Java type is not yet supported for types created with createType (classifier = ");
    ((StringBuilder)localObject).append(this.$this_createType);
    ((StringBuilder)localObject).append(')');
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("An operation is not implemented: ");
    localStringBuilder.append((String)localObject);
    throw ((Throwable)new NotImplementedError(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KClassifiers.createType.1
 * JD-Core Version:    0.7.0.1
 */