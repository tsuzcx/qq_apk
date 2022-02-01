package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Ljava/lang/reflect/Field;", "T", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KProperty1Impl$delegateField$1
  extends Lambda
  implements Function0<Field>
{
  KProperty1Impl$delegateField$1(KProperty1Impl paramKProperty1Impl)
  {
    super(0);
  }
  
  @Nullable
  public final Field invoke()
  {
    return this.this$0.computeDelegateField();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KProperty1Impl.delegateField.1
 * JD-Core Version:    0.7.0.1
 */