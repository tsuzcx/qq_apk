package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldGetter;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldGetter.BoundInstance;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldGetter.BoundJvmStaticInObject;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldGetter.Instance;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldGetter.JvmStaticInObject;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldGetter.Static;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter.BoundInstance;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter.BoundJvmStaticInObject;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter.Instance;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter.JvmStaticInObject;
import kotlin.reflect.jvm.internal.calls.CallerImpl.FieldSetter.Static;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"}, k=3, mv={1, 1, 16})
final class KPropertyImplKt$computeCallerForAccessor$3
  extends Lambda
  implements Function1<Field, CallerImpl<? extends Field>>
{
  KPropertyImplKt$computeCallerForAccessor$3(KPropertyImpl.Accessor paramAccessor, boolean paramBoolean, KPropertyImplKt.computeCallerForAccessor.2 param2, KPropertyImplKt.computeCallerForAccessor.1 param1)
  {
    super(1);
  }
  
  @NotNull
  public final CallerImpl<Field> invoke(@NotNull Field paramField)
  {
    Intrinsics.checkParameterIsNotNull(paramField, "field");
    if ((!KPropertyImplKt.access$isJvmFieldPropertyInCompanionObject(this.$this_computeCallerForAccessor.getProperty().getDescriptor())) && (Modifier.isStatic(paramField.getModifiers())))
    {
      if (this.$isJvmStaticProperty$1.invoke())
      {
        if (this.$isGetter)
        {
          if (this.$this_computeCallerForAccessor.isBound()) {
            paramField = (CallerImpl.FieldGetter)new CallerImpl.FieldGetter.BoundJvmStaticInObject(paramField);
          } else {
            paramField = (CallerImpl.FieldGetter)new CallerImpl.FieldGetter.JvmStaticInObject(paramField);
          }
          return (CallerImpl)paramField;
        }
        if (this.$this_computeCallerForAccessor.isBound()) {
          paramField = (CallerImpl.FieldSetter)new CallerImpl.FieldSetter.BoundJvmStaticInObject(paramField, this.$isNotNullProperty$2.invoke());
        } else {
          paramField = (CallerImpl.FieldSetter)new CallerImpl.FieldSetter.JvmStaticInObject(paramField, this.$isNotNullProperty$2.invoke());
        }
        return (CallerImpl)paramField;
      }
      if (this.$isGetter) {
        return (CallerImpl)new CallerImpl.FieldGetter.Static(paramField);
      }
      return (CallerImpl)new CallerImpl.FieldSetter.Static(paramField, this.$isNotNullProperty$2.invoke());
    }
    if (this.$isGetter)
    {
      if (this.$this_computeCallerForAccessor.isBound()) {
        paramField = (CallerImpl.FieldGetter)new CallerImpl.FieldGetter.BoundInstance(paramField, KPropertyImplKt.getBoundReceiver(this.$this_computeCallerForAccessor));
      } else {
        paramField = (CallerImpl.FieldGetter)new CallerImpl.FieldGetter.Instance(paramField);
      }
      return (CallerImpl)paramField;
    }
    if (this.$this_computeCallerForAccessor.isBound()) {
      paramField = (CallerImpl.FieldSetter)new CallerImpl.FieldSetter.BoundInstance(paramField, this.$isNotNullProperty$2.invoke(), KPropertyImplKt.getBoundReceiver(this.$this_computeCallerForAccessor));
    } else {
      paramField = (CallerImpl.FieldSetter)new CallerImpl.FieldSetter.Instance(paramField, this.$isNotNullProperty$2.invoke());
    }
    return (CallerImpl)paramField;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPropertyImplKt.computeCallerForAccessor.3
 * JD-Core Version:    0.7.0.1
 */