package com.tencent.videocut.utils.thread;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/thread/PriorityExecutorService$Priority;", "", "priority", "", "fifo", "", "(IZ)V", "getFifo", "()Z", "getPriority", "()I", "Companion", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class PriorityExecutorService$Priority
{
  @JvmField
  @NotNull
  public static final Priority a = new Priority(-16, true);
  @JvmField
  @NotNull
  public static final Priority b = new Priority(0, true);
  @JvmField
  @NotNull
  public static final Priority c = new Priority(16, false);
  @NotNull
  public static final PriorityExecutorService.Priority.Companion d = new PriorityExecutorService.Priority.Companion(null);
  private final int e;
  private final boolean f;
  
  public PriorityExecutorService$Priority(int paramInt, boolean paramBoolean)
  {
    this.e = paramInt;
    this.f = paramBoolean;
  }
  
  public final int a()
  {
    return this.e;
  }
  
  public final boolean b()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.thread.PriorityExecutorService.Priority
 * JD-Core Version:    0.7.0.1
 */