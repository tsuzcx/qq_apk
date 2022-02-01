package kotlin.properties;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/properties/Delegates;", "", "()V", "notNull", "Lkotlin/properties/ReadWriteProperty;", "T", "observable", "initialValue", "onChange", "Lkotlin/Function3;", "Lkotlin/reflect/KProperty;", "Lkotlin/ParameterName;", "name", "property", "oldValue", "newValue", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlin/properties/ReadWriteProperty;", "vetoable", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class Delegates
{
  public static final Delegates INSTANCE = new Delegates();
  
  @NotNull
  public final <T> ReadWriteProperty<Object, T> notNull()
  {
    return (ReadWriteProperty)new NotNullVar();
  }
  
  @NotNull
  public final <T> ReadWriteProperty<Object, T> observable(T paramT, @NotNull Function3<? super KProperty<?>, ? super T, ? super T, Unit> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "onChange");
    return (ReadWriteProperty)new Delegates.observable.1(paramFunction3, paramT, paramT);
  }
  
  @NotNull
  public final <T> ReadWriteProperty<Object, T> vetoable(T paramT, @NotNull Function3<? super KProperty<?>, ? super T, ? super T, Boolean> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction3, "onChange");
    return (ReadWriteProperty)new Delegates.vetoable.1(paramFunction3, paramT, paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.properties.Delegates
 * JD-Core Version:    0.7.0.1
 */