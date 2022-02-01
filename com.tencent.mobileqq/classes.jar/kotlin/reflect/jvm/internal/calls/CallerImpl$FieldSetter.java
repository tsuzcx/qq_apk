package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "notNull", "", "requiresInstance", "(Ljava/lang/reflect/Field;ZZ)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "checkArguments", "", "([Ljava/lang/Object;)V", "BoundInstance", "BoundJvmStaticInObject", "Instance", "JvmStaticInObject", "Static", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Static;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$Instance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundInstance;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$FieldSetter$BoundJvmStaticInObject;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public abstract class CallerImpl$FieldSetter
  extends CallerImpl<Field>
{
  private final boolean notNull;
  
  private CallerImpl$FieldSetter(Field paramField, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(localMember, localType, localClass, new Type[] { paramField }, null);
    this.notNull = paramBoolean1;
  }
  
  @Nullable
  public Object call(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    checkArguments(paramArrayOfObject);
    Field localField = (Field)getMember();
    Object localObject;
    if (getInstanceClass() != null) {
      localObject = ArraysKt.first(paramArrayOfObject);
    } else {
      localObject = null;
    }
    localField.set(localObject, ArraysKt.last(paramArrayOfObject));
    return Unit.INSTANCE;
  }
  
  public void checkArguments(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    super.checkArguments(paramArrayOfObject);
    if (this.notNull)
    {
      if (ArraysKt.last(paramArrayOfObject) != null) {
        return;
      }
      throw ((Throwable)new IllegalArgumentException("null is not allowed as a value for this property."));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter
 * JD-Core Version:    0.7.0.1
 */