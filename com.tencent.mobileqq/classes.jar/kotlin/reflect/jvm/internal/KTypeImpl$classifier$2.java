package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClassifier;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/KClassifier;", "invoke"}, k=3, mv={1, 1, 16})
final class KTypeImpl$classifier$2
  extends Lambda
  implements Function0<KClassifier>
{
  KTypeImpl$classifier$2(KTypeImpl paramKTypeImpl)
  {
    super(0);
  }
  
  @Nullable
  public final KClassifier invoke()
  {
    KTypeImpl localKTypeImpl = this.this$0;
    return KTypeImpl.access$convert(localKTypeImpl, localKTypeImpl.getType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KTypeImpl.classifier.2
 * JD-Core Version:    0.7.0.1
 */