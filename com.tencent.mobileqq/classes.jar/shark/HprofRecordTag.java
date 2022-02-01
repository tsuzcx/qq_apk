package shark;

import java.util.EnumSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecordTag;", "", "tag", "", "(Ljava/lang/String;II)V", "getTag", "()I", "STRING_IN_UTF8", "LOAD_CLASS", "UNLOAD_CLASS", "STACK_FRAME", "STACK_TRACE", "ALLOC_SITES", "HEAP_SUMMARY", "START_THREAD", "END_THREAD", "HEAP_DUMP", "HEAP_DUMP_SEGMENT", "HEAP_DUMP_END", "CPU_SAMPLES", "CONTROL_SETTINGS", "ROOT_UNKNOWN", "ROOT_JNI_GLOBAL", "ROOT_JNI_LOCAL", "ROOT_JAVA_FRAME", "ROOT_NATIVE_STACK", "ROOT_STICKY_CLASS", "ROOT_THREAD_BLOCK", "ROOT_MONITOR_USED", "ROOT_THREAD_OBJECT", "HEAP_DUMP_INFO", "ROOT_INTERNED_STRING", "ROOT_FINALIZING", "ROOT_DEBUGGER", "ROOT_REFERENCE_CLEANUP", "ROOT_VM_INTERNAL", "ROOT_JNI_MONITOR", "ROOT_UNREACHABLE", "PRIMITIVE_ARRAY_NODATA", "CLASS_DUMP", "INSTANCE_DUMP", "OBJECT_ARRAY_DUMP", "PRIMITIVE_ARRAY_DUMP", "Companion", "shark-hprof"}, k=1, mv={1, 4, 1})
public enum HprofRecordTag
{
  @NotNull
  public static final HprofRecordTag.Companion Companion;
  @NotNull
  private static final EnumSet<HprofRecordTag> rootTags;
  private final int tag;
  
  static
  {
    Object localObject = new HprofRecordTag("STRING_IN_UTF8", 0, 1);
    STRING_IN_UTF8 = (HprofRecordTag)localObject;
    HprofRecordTag localHprofRecordTag1 = new HprofRecordTag("LOAD_CLASS", 1, 2);
    LOAD_CLASS = localHprofRecordTag1;
    HprofRecordTag localHprofRecordTag2 = new HprofRecordTag("UNLOAD_CLASS", 2, 3);
    UNLOAD_CLASS = localHprofRecordTag2;
    HprofRecordTag localHprofRecordTag3 = new HprofRecordTag("STACK_FRAME", 3, 4);
    STACK_FRAME = localHprofRecordTag3;
    HprofRecordTag localHprofRecordTag4 = new HprofRecordTag("STACK_TRACE", 4, 5);
    STACK_TRACE = localHprofRecordTag4;
    HprofRecordTag localHprofRecordTag5 = new HprofRecordTag("ALLOC_SITES", 5, 6);
    ALLOC_SITES = localHprofRecordTag5;
    HprofRecordTag localHprofRecordTag6 = new HprofRecordTag("HEAP_SUMMARY", 6, 7);
    HEAP_SUMMARY = localHprofRecordTag6;
    HprofRecordTag localHprofRecordTag7 = new HprofRecordTag("START_THREAD", 7, 10);
    START_THREAD = localHprofRecordTag7;
    HprofRecordTag localHprofRecordTag8 = new HprofRecordTag("END_THREAD", 8, 11);
    END_THREAD = localHprofRecordTag8;
    HprofRecordTag localHprofRecordTag9 = new HprofRecordTag("HEAP_DUMP", 9, 12);
    HEAP_DUMP = localHprofRecordTag9;
    HprofRecordTag localHprofRecordTag10 = new HprofRecordTag("HEAP_DUMP_SEGMENT", 10, 28);
    HEAP_DUMP_SEGMENT = localHprofRecordTag10;
    HprofRecordTag localHprofRecordTag11 = new HprofRecordTag("HEAP_DUMP_END", 11, 44);
    HEAP_DUMP_END = localHprofRecordTag11;
    HprofRecordTag localHprofRecordTag12 = new HprofRecordTag("CPU_SAMPLES", 12, 13);
    CPU_SAMPLES = localHprofRecordTag12;
    HprofRecordTag localHprofRecordTag13 = new HprofRecordTag("CONTROL_SETTINGS", 13, 14);
    CONTROL_SETTINGS = localHprofRecordTag13;
    HprofRecordTag localHprofRecordTag14 = new HprofRecordTag("ROOT_UNKNOWN", 14, 255);
    ROOT_UNKNOWN = localHprofRecordTag14;
    HprofRecordTag localHprofRecordTag15 = new HprofRecordTag("ROOT_JNI_GLOBAL", 15, 1);
    ROOT_JNI_GLOBAL = localHprofRecordTag15;
    HprofRecordTag localHprofRecordTag16 = new HprofRecordTag("ROOT_JNI_LOCAL", 16, 2);
    ROOT_JNI_LOCAL = localHprofRecordTag16;
    HprofRecordTag localHprofRecordTag17 = new HprofRecordTag("ROOT_JAVA_FRAME", 17, 3);
    ROOT_JAVA_FRAME = localHprofRecordTag17;
    HprofRecordTag localHprofRecordTag18 = new HprofRecordTag("ROOT_NATIVE_STACK", 18, 4);
    ROOT_NATIVE_STACK = localHprofRecordTag18;
    HprofRecordTag localHprofRecordTag19 = new HprofRecordTag("ROOT_STICKY_CLASS", 19, 5);
    ROOT_STICKY_CLASS = localHprofRecordTag19;
    HprofRecordTag localHprofRecordTag20 = new HprofRecordTag("ROOT_THREAD_BLOCK", 20, 6);
    ROOT_THREAD_BLOCK = localHprofRecordTag20;
    HprofRecordTag localHprofRecordTag21 = new HprofRecordTag("ROOT_MONITOR_USED", 21, 7);
    ROOT_MONITOR_USED = localHprofRecordTag21;
    HprofRecordTag localHprofRecordTag22 = new HprofRecordTag("ROOT_THREAD_OBJECT", 22, 8);
    ROOT_THREAD_OBJECT = localHprofRecordTag22;
    HprofRecordTag localHprofRecordTag23 = new HprofRecordTag("HEAP_DUMP_INFO", 23, 254);
    HEAP_DUMP_INFO = localHprofRecordTag23;
    HprofRecordTag localHprofRecordTag24 = new HprofRecordTag("ROOT_INTERNED_STRING", 24, 137);
    ROOT_INTERNED_STRING = localHprofRecordTag24;
    HprofRecordTag localHprofRecordTag25 = new HprofRecordTag("ROOT_FINALIZING", 25, 138);
    ROOT_FINALIZING = localHprofRecordTag25;
    HprofRecordTag localHprofRecordTag26 = new HprofRecordTag("ROOT_DEBUGGER", 26, 139);
    ROOT_DEBUGGER = localHprofRecordTag26;
    HprofRecordTag localHprofRecordTag27 = new HprofRecordTag("ROOT_REFERENCE_CLEANUP", 27, 140);
    ROOT_REFERENCE_CLEANUP = localHprofRecordTag27;
    HprofRecordTag localHprofRecordTag28 = new HprofRecordTag("ROOT_VM_INTERNAL", 28, 141);
    ROOT_VM_INTERNAL = localHprofRecordTag28;
    HprofRecordTag localHprofRecordTag29 = new HprofRecordTag("ROOT_JNI_MONITOR", 29, 142);
    ROOT_JNI_MONITOR = localHprofRecordTag29;
    HprofRecordTag localHprofRecordTag30 = new HprofRecordTag("ROOT_UNREACHABLE", 30, 144);
    ROOT_UNREACHABLE = localHprofRecordTag30;
    HprofRecordTag localHprofRecordTag31 = new HprofRecordTag("PRIMITIVE_ARRAY_NODATA", 31, 195);
    PRIMITIVE_ARRAY_NODATA = localHprofRecordTag31;
    HprofRecordTag localHprofRecordTag32 = new HprofRecordTag("CLASS_DUMP", 32, 32);
    CLASS_DUMP = localHprofRecordTag32;
    HprofRecordTag localHprofRecordTag33 = new HprofRecordTag("INSTANCE_DUMP", 33, 33);
    INSTANCE_DUMP = localHprofRecordTag33;
    HprofRecordTag localHprofRecordTag34 = new HprofRecordTag("OBJECT_ARRAY_DUMP", 34, 34);
    OBJECT_ARRAY_DUMP = localHprofRecordTag34;
    HprofRecordTag localHprofRecordTag35 = new HprofRecordTag("PRIMITIVE_ARRAY_DUMP", 35, 35);
    PRIMITIVE_ARRAY_DUMP = localHprofRecordTag35;
    $VALUES = new HprofRecordTag[] { localObject, localHprofRecordTag1, localHprofRecordTag2, localHprofRecordTag3, localHprofRecordTag4, localHprofRecordTag5, localHprofRecordTag6, localHprofRecordTag7, localHprofRecordTag8, localHprofRecordTag9, localHprofRecordTag10, localHprofRecordTag11, localHprofRecordTag12, localHprofRecordTag13, localHprofRecordTag14, localHprofRecordTag15, localHprofRecordTag16, localHprofRecordTag17, localHprofRecordTag18, localHprofRecordTag19, localHprofRecordTag20, localHprofRecordTag21, localHprofRecordTag22, localHprofRecordTag23, localHprofRecordTag24, localHprofRecordTag25, localHprofRecordTag26, localHprofRecordTag27, localHprofRecordTag28, localHprofRecordTag29, localHprofRecordTag30, localHprofRecordTag31, localHprofRecordTag32, localHprofRecordTag33, localHprofRecordTag34, localHprofRecordTag35 };
    Companion = new HprofRecordTag.Companion(null);
    localObject = EnumSet.of((Enum)ROOT_UNKNOWN, new HprofRecordTag[] { ROOT_JNI_GLOBAL, ROOT_JNI_LOCAL, ROOT_JAVA_FRAME, ROOT_NATIVE_STACK, ROOT_STICKY_CLASS, ROOT_THREAD_BLOCK, ROOT_MONITOR_USED, ROOT_THREAD_OBJECT, ROOT_INTERNED_STRING, ROOT_FINALIZING, ROOT_DEBUGGER, ROOT_REFERENCE_CLEANUP, ROOT_VM_INTERNAL, ROOT_JNI_MONITOR, ROOT_UNREACHABLE });
    Intrinsics.checkExpressionValueIsNotNull(localObject, "EnumSet.of(\n      ROOT_U…   ROOT_UNREACHABLE\n    )");
    rootTags = (EnumSet)localObject;
  }
  
  private HprofRecordTag(int paramInt)
  {
    this.tag = paramInt;
  }
  
  public final int getTag()
  {
    return this.tag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecordTag
 * JD-Core Version:    0.7.0.1
 */