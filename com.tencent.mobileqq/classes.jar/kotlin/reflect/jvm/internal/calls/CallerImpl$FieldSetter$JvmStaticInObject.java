package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "(Ljava/lang/reflect/Field;Z)V", "checkArguments", "", "args", "", "([Ljava/lang/Object;)V", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class CallerImpl$FieldSetter$JvmStaticInObject
  extends CallerImpl.FieldSetter
{
  public CallerImpl$FieldSetter$JvmStaticInObject(@NotNull Field paramField, boolean paramBoolean)
  {
    super(paramField, paramBoolean, true, null);
  }
  
  public void checkArguments(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    super.checkArguments(paramArrayOfObject);
    checkObjectInstance(ArraysKt.firstOrNull(paramArrayOfObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter.JvmStaticInObject
 * JD-Core Version:    0.7.0.1
 */