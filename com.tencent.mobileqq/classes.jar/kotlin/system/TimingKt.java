package kotlin.system;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"measureNanoTime", "", "block", "Lkotlin/Function0;", "", "measureTimeMillis", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="TimingKt")
public final class TimingKt
{
  public static final long measureNanoTime(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    long l = System.nanoTime();
    paramFunction0.invoke();
    return System.nanoTime() - l;
  }
  
  public static final long measureTimeMillis(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    long l = System.currentTimeMillis();
    paramFunction0.invoke();
    return System.currentTimeMillis() - l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.system.TimingKt
 * JD-Core Version:    0.7.0.1
 */