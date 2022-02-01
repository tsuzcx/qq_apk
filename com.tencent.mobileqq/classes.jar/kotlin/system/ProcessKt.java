package kotlin.system;

import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"exitProcess", "", "status", "", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="ProcessKt")
public final class ProcessKt
{
  @InlineOnly
  private static final Void exitProcess(int paramInt)
  {
    System.exit(paramInt);
    throw ((Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM."));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.system.ProcessKt
 * JD-Core Version:    0.7.0.1
 */