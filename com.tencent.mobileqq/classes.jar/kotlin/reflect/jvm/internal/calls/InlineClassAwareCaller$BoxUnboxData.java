package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k=1, mv={1, 1, 16})
final class InlineClassAwareCaller$BoxUnboxData
{
  @NotNull
  private final IntRange argumentRange;
  @Nullable
  private final Method box;
  @NotNull
  private final Method[] unbox;
  
  public InlineClassAwareCaller$BoxUnboxData(@NotNull IntRange paramIntRange, @NotNull Method[] paramArrayOfMethod, @Nullable Method paramMethod)
  {
    this.argumentRange = paramIntRange;
    this.unbox = paramArrayOfMethod;
    this.box = paramMethod;
  }
  
  @NotNull
  public final IntRange component1()
  {
    return this.argumentRange;
  }
  
  @NotNull
  public final Method[] component2()
  {
    return this.unbox;
  }
  
  @Nullable
  public final Method component3()
  {
    return this.box;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.BoxUnboxData
 * JD-Core Version:    0.7.0.1
 */