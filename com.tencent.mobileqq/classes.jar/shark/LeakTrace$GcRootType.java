package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/LeakTrace$GcRootType;", "", "description", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "JNI_GLOBAL", "JNI_LOCAL", "JAVA_FRAME", "NATIVE_STACK", "STICKY_CLASS", "THREAD_BLOCK", "MONITOR_USED", "THREAD_OBJECT", "JNI_MONITOR", "Companion", "shark"}, k=1, mv={1, 4, 1})
public enum LeakTrace$GcRootType
{
  @NotNull
  public static final LeakTrace.GcRootType.Companion Companion = new LeakTrace.GcRootType.Companion(null);
  @NotNull
  private final String description;
  
  static
  {
    GcRootType localGcRootType1 = new GcRootType("JNI_GLOBAL", 0, "Global variable in native code");
    JNI_GLOBAL = localGcRootType1;
    GcRootType localGcRootType2 = new GcRootType("JNI_LOCAL", 1, "Local variable in native code");
    JNI_LOCAL = localGcRootType2;
    GcRootType localGcRootType3 = new GcRootType("JAVA_FRAME", 2, "Java local variable");
    JAVA_FRAME = localGcRootType3;
    GcRootType localGcRootType4 = new GcRootType("NATIVE_STACK", 3, "Input or output parameters in native code");
    NATIVE_STACK = localGcRootType4;
    GcRootType localGcRootType5 = new GcRootType("STICKY_CLASS", 4, "System class");
    STICKY_CLASS = localGcRootType5;
    GcRootType localGcRootType6 = new GcRootType("THREAD_BLOCK", 5, "Thread block");
    THREAD_BLOCK = localGcRootType6;
    GcRootType localGcRootType7 = new GcRootType("MONITOR_USED", 6, "Monitor (anything that called the wait() or notify() methods, or that is synchronized.)");
    MONITOR_USED = localGcRootType7;
    GcRootType localGcRootType8 = new GcRootType("THREAD_OBJECT", 7, "Thread object");
    THREAD_OBJECT = localGcRootType8;
    GcRootType localGcRootType9 = new GcRootType("JNI_MONITOR", 8, "Root JNI monitor");
    JNI_MONITOR = localGcRootType9;
    $VALUES = new GcRootType[] { localGcRootType1, localGcRootType2, localGcRootType3, localGcRootType4, localGcRootType5, localGcRootType6, localGcRootType7, localGcRootType8, localGcRootType9 };
  }
  
  private LeakTrace$GcRootType(String paramString)
  {
    this.description = paramString;
  }
  
  @NotNull
  public final String getDescription()
  {
    return this.description;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.LeakTrace.GcRootType
 * JD-Core Version:    0.7.0.1
 */