package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.3")
public abstract interface CoroutineStackFrame
{
  @Nullable
  public abstract CoroutineStackFrame getCallerFrame();
  
  @Nullable
  public abstract StackTraceElement getStackTraceElement();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.CoroutineStackFrame
 * JD-Core Version:    0.7.0.1
 */