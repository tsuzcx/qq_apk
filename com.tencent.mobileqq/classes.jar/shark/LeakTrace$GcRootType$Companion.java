package shark;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakTrace$GcRootType$Companion;", "", "()V", "fromGcRoot", "Lshark/LeakTrace$GcRootType;", "gcRoot", "Lshark/GcRoot;", "shark"}, k=1, mv={1, 4, 1})
public final class LeakTrace$GcRootType$Companion
{
  @NotNull
  public final LeakTrace.GcRootType a(@NotNull GcRoot paramGcRoot)
  {
    Intrinsics.checkParameterIsNotNull(paramGcRoot, "gcRoot");
    if ((paramGcRoot instanceof GcRoot.JniGlobal)) {
      return LeakTrace.GcRootType.JNI_GLOBAL;
    }
    if ((paramGcRoot instanceof GcRoot.JniLocal)) {
      return LeakTrace.GcRootType.JNI_LOCAL;
    }
    if ((paramGcRoot instanceof GcRoot.JavaFrame)) {
      return LeakTrace.GcRootType.JAVA_FRAME;
    }
    if ((paramGcRoot instanceof GcRoot.NativeStack)) {
      return LeakTrace.GcRootType.NATIVE_STACK;
    }
    if ((paramGcRoot instanceof GcRoot.StickyClass)) {
      return LeakTrace.GcRootType.STICKY_CLASS;
    }
    if ((paramGcRoot instanceof GcRoot.ThreadBlock)) {
      return LeakTrace.GcRootType.THREAD_BLOCK;
    }
    if ((paramGcRoot instanceof GcRoot.MonitorUsed)) {
      return LeakTrace.GcRootType.MONITOR_USED;
    }
    if ((paramGcRoot instanceof GcRoot.ThreadObject)) {
      return LeakTrace.GcRootType.THREAD_OBJECT;
    }
    if ((paramGcRoot instanceof GcRoot.JniMonitor)) {
      return LeakTrace.GcRootType.JNI_MONITOR;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected gc root ");
    localStringBuilder.append(paramGcRoot);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTrace.GcRootType.Companion
 * JD-Core Version:    0.7.0.1
 */