package kotlin.reflect;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/KProperty;", "R", "Lkotlin/reflect/KCallable;", "getter", "Lkotlin/reflect/KProperty$Getter;", "getGetter", "()Lkotlin/reflect/KProperty$Getter;", "isConst", "", "isConst$annotations", "()V", "()Z", "isLateinit", "isLateinit$annotations", "Accessor", "Getter", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract interface KProperty<R>
  extends KCallable<R>
{
  @NotNull
  public abstract KProperty.Getter<R> getGetter();
  
  public abstract boolean isConst();
  
  public abstract boolean isLateinit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.reflect.KProperty
 * JD-Core Version:    0.7.0.1
 */