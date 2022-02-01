package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "field", "Ljava/lang/reflect/Field;", "notNull", "", "boundReceiver", "", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class CallerImpl$FieldSetter$BoundInstance
  extends CallerImpl.FieldSetter
  implements BoundCaller
{
  private final Object boundReceiver;
  
  public CallerImpl$FieldSetter$BoundInstance(@NotNull Field paramField, boolean paramBoolean, @Nullable Object paramObject)
  {
    super(paramField, paramBoolean, false, null);
    this.boundReceiver = paramObject;
  }
  
  @Nullable
  public Object call(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    checkArguments(paramArrayOfObject);
    ((Field)getMember()).set(this.boundReceiver, ArraysKt.first(paramArrayOfObject));
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter.BoundInstance
 * JD-Core Version:    0.7.0.1
 */