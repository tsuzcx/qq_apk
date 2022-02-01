package shark;

import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Buffer;
import okio.BufferedSink;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofWriter;", "Ljava/io/Closeable;", "sink", "Lokio/BufferedSink;", "hprofHeader", "Lshark/HprofHeader;", "(Lokio/BufferedSink;Lshark/HprofHeader;)V", "getHprofHeader", "()Lshark/HprofHeader;", "hprofVersion", "Lshark/Hprof$HprofVersion;", "getHprofVersion$annotations", "()V", "getHprofVersion", "()Lshark/Hprof$HprofVersion;", "identifierByteSize", "", "getIdentifierByteSize$annotations", "getIdentifierByteSize", "()I", "workBuffer", "Lokio/Buffer;", "close", "", "valuesToBytes", "", "values", "", "Lshark/ValueHolder;", "write", "record", "Lshark/HprofRecord;", "flushHeapBuffer", "array", "", "", "", "", "", "", "", "writeBoolean", "value", "", "writeDouble", "", "writeFloat", "", "writeId", "id", "", "writeIdArray", "writeNonHeapRecord", "tag", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "writeTagHeader", "length", "writeValue", "wrapper", "Companion", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofWriter
  implements Closeable
{
  @NotNull
  public static final HprofWriter.Companion a = new HprofWriter.Companion(null);
  private final Buffer b;
  private final BufferedSink c;
  @NotNull
  private final HprofHeader d;
  
  private final void a(BufferedSink paramBufferedSink)
  {
    if (this.b.size() > 0L)
    {
      a(paramBufferedSink, HprofRecordTag.HEAP_DUMP.getTag(), this.b.size());
      paramBufferedSink.writeAll((Source)this.b);
      a(paramBufferedSink, HprofRecordTag.HEAP_DUMP_END.getTag(), 0L);
    }
  }
  
  private final void a(BufferedSink paramBufferedSink, double paramDouble)
  {
    paramBufferedSink.writeLong(Double.doubleToLongBits(paramDouble));
  }
  
  private final void a(BufferedSink paramBufferedSink, float paramFloat)
  {
    paramBufferedSink.writeInt(Float.floatToIntBits(paramFloat));
  }
  
  private final void a(BufferedSink paramBufferedSink, int paramInt, long paramLong)
  {
    paramBufferedSink.writeByte(paramInt);
    paramBufferedSink.writeInt(0);
    paramBufferedSink.writeInt((int)paramLong);
  }
  
  private final void a(BufferedSink paramBufferedSink, int paramInt, Function1<? super BufferedSink, Unit> paramFunction1)
  {
    a(paramBufferedSink);
    paramFunction1.invoke(this.b);
    a(paramBufferedSink, paramInt, this.b.size());
    paramBufferedSink.writeAll((Source)this.b);
  }
  
  private final void a(BufferedSink paramBufferedSink, long paramLong)
  {
    int i = this.d.c();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i == 8)
          {
            paramBufferedSink.writeLong(paramLong);
            return;
          }
          throw ((Throwable)new IllegalArgumentException("ID Length must be 1, 2, 4, or 8"));
        }
        paramBufferedSink.writeInt((int)paramLong);
        return;
      }
      paramBufferedSink.writeShort((int)paramLong);
      return;
    }
    paramBufferedSink.writeByte((int)paramLong);
  }
  
  private final void a(BufferedSink paramBufferedSink, HprofRecord paramHprofRecord)
  {
    if ((paramHprofRecord instanceof HprofRecord.StringRecord))
    {
      a(paramBufferedSink, HprofRecordTag.STRING_IN_UTF8.getTag(), (Function1)new HprofWriter.write.1(this, paramHprofRecord));
      return;
    }
    if ((paramHprofRecord instanceof HprofRecord.LoadClassRecord))
    {
      a(paramBufferedSink, HprofRecordTag.LOAD_CLASS.getTag(), (Function1)new HprofWriter.write.2(this, paramHprofRecord));
      return;
    }
    if ((paramHprofRecord instanceof HprofRecord.StackTraceRecord))
    {
      a(paramBufferedSink, HprofRecordTag.STACK_TRACE.getTag(), (Function1)new HprofWriter.write.3(this, paramHprofRecord));
      return;
    }
    if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.GcRootRecord))
    {
      paramBufferedSink = this.b;
      paramHprofRecord = ((HprofRecord.HeapDumpRecord.GcRootRecord)paramHprofRecord).a();
      if ((paramHprofRecord instanceof GcRoot.Unknown))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_UNKNOWN.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.JniGlobal))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_JNI_GLOBAL.getTag());
        paramBufferedSink = (BufferedSink)paramBufferedSink;
        a(paramBufferedSink, paramHprofRecord.a());
        a(paramBufferedSink, ((GcRoot.JniGlobal)paramHprofRecord).b());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.JniLocal))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_JNI_LOCAL.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        paramHprofRecord = (GcRoot.JniLocal)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.b());
        paramBufferedSink.writeInt(paramHprofRecord.c());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.JavaFrame))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_JAVA_FRAME.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        paramHprofRecord = (GcRoot.JavaFrame)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.b());
        paramBufferedSink.writeInt(paramHprofRecord.c());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.NativeStack))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_NATIVE_STACK.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        paramBufferedSink.writeInt(((GcRoot.NativeStack)paramHprofRecord).b());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.StickyClass))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_STICKY_CLASS.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.ThreadBlock))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_THREAD_BLOCK.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        paramBufferedSink.writeInt(((GcRoot.ThreadBlock)paramHprofRecord).b());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.MonitorUsed))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_MONITOR_USED.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.ThreadObject))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_THREAD_OBJECT.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        paramHprofRecord = (GcRoot.ThreadObject)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.b());
        paramBufferedSink.writeInt(paramHprofRecord.c());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.ReferenceCleanup))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_REFERENCE_CLEANUP.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.VmInternal))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_VM_INTERNAL.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.JniMonitor))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_JNI_MONITOR.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        paramHprofRecord = (GcRoot.JniMonitor)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.b());
        paramBufferedSink.writeInt(paramHprofRecord.c());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.InternedString))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_INTERNED_STRING.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.Finalizing))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_FINALIZING.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.Debugger))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_DEBUGGER.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        return;
      }
      if ((paramHprofRecord instanceof GcRoot.Unreachable))
      {
        paramBufferedSink.writeByte(HprofRecordTag.ROOT_UNREACHABLE.getTag());
        a((BufferedSink)paramBufferedSink, paramHprofRecord.a());
        return;
      }
      throw new NoWhenBranchMatchedException();
    }
    BufferedSink localBufferedSink;
    Object localObject;
    if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord))
    {
      paramBufferedSink = this.b;
      paramBufferedSink.writeByte(HprofRecordTag.CLASS_DUMP.getTag());
      localBufferedSink = (BufferedSink)paramBufferedSink;
      paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord)paramHprofRecord;
      a(localBufferedSink, paramHprofRecord.a());
      paramBufferedSink.writeInt(paramHprofRecord.b());
      a(localBufferedSink, paramHprofRecord.c());
      a(localBufferedSink, paramHprofRecord.d());
      a(localBufferedSink, paramHprofRecord.e());
      a(localBufferedSink, paramHprofRecord.f());
      a(localBufferedSink, 0L);
      a(localBufferedSink, 0L);
      paramBufferedSink.writeInt(paramHprofRecord.g());
      paramBufferedSink.writeShort(0);
      paramBufferedSink.writeShort(paramHprofRecord.h().size());
      localObject = ((Iterable)paramHprofRecord.h()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord localStaticFieldRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord)((Iterator)localObject).next();
        a(localBufferedSink, localStaticFieldRecord.a());
        paramBufferedSink.writeByte(localStaticFieldRecord.b());
        a(localBufferedSink, localStaticFieldRecord.c());
      }
      paramBufferedSink.writeShort(paramHprofRecord.i().size());
      paramHprofRecord = ((Iterable)paramHprofRecord.i()).iterator();
      while (paramHprofRecord.hasNext())
      {
        localObject = (HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord)paramHprofRecord.next();
        a(localBufferedSink, ((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord)localObject).a());
        paramBufferedSink.writeByte(((HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord)localObject).b());
      }
    }
    if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord))
    {
      paramBufferedSink = this.b;
      paramBufferedSink.writeByte(HprofRecordTag.INSTANCE_DUMP.getTag());
      localBufferedSink = (BufferedSink)paramBufferedSink;
      paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord)paramHprofRecord;
      a(localBufferedSink, paramHprofRecord.a());
      paramBufferedSink.writeInt(paramHprofRecord.b());
      a(localBufferedSink, paramHprofRecord.c());
      paramBufferedSink.writeInt(paramHprofRecord.d().length);
      paramBufferedSink.write(paramHprofRecord.d());
      return;
    }
    if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord))
    {
      paramBufferedSink = this.b;
      paramBufferedSink.writeByte(HprofRecordTag.OBJECT_ARRAY_DUMP.getTag());
      localBufferedSink = (BufferedSink)paramBufferedSink;
      paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord)paramHprofRecord;
      a(localBufferedSink, paramHprofRecord.a());
      paramBufferedSink.writeInt(paramHprofRecord.b());
      paramBufferedSink.writeInt(paramHprofRecord.d().length);
      a(localBufferedSink, paramHprofRecord.c());
      a(localBufferedSink, paramHprofRecord.d());
      return;
    }
    if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord))
    {
      paramBufferedSink = this.b;
      paramBufferedSink.writeByte(HprofRecordTag.PRIMITIVE_ARRAY_DUMP.getTag());
      localBufferedSink = (BufferedSink)paramBufferedSink;
      localObject = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)paramHprofRecord;
      a(localBufferedSink, ((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)localObject).a());
      paramBufferedSink.writeInt(((HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)localObject).b());
      if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump))
      {
        paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.c().length);
        paramBufferedSink.writeByte(PrimitiveType.BOOLEAN.getHprofType());
        a(localBufferedSink, paramHprofRecord.c());
        return;
      }
      if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump))
      {
        paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.c().length);
        paramBufferedSink.writeByte(PrimitiveType.CHAR.getHprofType());
        a(localBufferedSink, paramHprofRecord.c());
        return;
      }
      if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump))
      {
        paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.c().length);
        paramBufferedSink.writeByte(PrimitiveType.FLOAT.getHprofType());
        a(localBufferedSink, paramHprofRecord.c());
        return;
      }
      if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump))
      {
        paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.c().length);
        paramBufferedSink.writeByte(PrimitiveType.DOUBLE.getHprofType());
        a(localBufferedSink, paramHprofRecord.c());
        return;
      }
      if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump))
      {
        paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.c().length);
        paramBufferedSink.writeByte(PrimitiveType.BYTE.getHprofType());
        paramBufferedSink.write(paramHprofRecord.c());
        return;
      }
      if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump))
      {
        paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.c().length);
        paramBufferedSink.writeByte(PrimitiveType.SHORT.getHprofType());
        a(localBufferedSink, paramHprofRecord.c());
        return;
      }
      if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump))
      {
        paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.c().length);
        paramBufferedSink.writeByte(PrimitiveType.INT.getHprofType());
        a(localBufferedSink, paramHprofRecord.c());
        return;
      }
      if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump))
      {
        paramHprofRecord = (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump)paramHprofRecord;
        paramBufferedSink.writeInt(paramHprofRecord.c().length);
        paramBufferedSink.writeByte(PrimitiveType.LONG.getHprofType());
        b(localBufferedSink, paramHprofRecord.c());
        return;
      }
      throw new NoWhenBranchMatchedException();
    }
    if ((paramHprofRecord instanceof HprofRecord.HeapDumpRecord.HeapDumpInfoRecord))
    {
      paramBufferedSink = this.b;
      paramBufferedSink.writeByte(HprofRecordTag.HEAP_DUMP_INFO.getTag());
      paramHprofRecord = (HprofRecord.HeapDumpRecord.HeapDumpInfoRecord)paramHprofRecord;
      paramBufferedSink.writeInt(paramHprofRecord.a());
      a((BufferedSink)paramBufferedSink, paramHprofRecord.b());
      return;
    }
    if (!(paramHprofRecord instanceof HprofRecord.HeapDumpEndRecord)) {
      return;
    }
    paramBufferedSink = (Throwable)new IllegalArgumentException("HprofWriter automatically emits HeapDumpEndRecord");
    for (;;)
    {
      throw paramBufferedSink;
    }
  }
  
  private final void a(BufferedSink paramBufferedSink, ValueHolder paramValueHolder)
  {
    if ((paramValueHolder instanceof ValueHolder.ReferenceHolder))
    {
      a(paramBufferedSink, ((ValueHolder.ReferenceHolder)paramValueHolder).b());
      return;
    }
    if ((paramValueHolder instanceof ValueHolder.BooleanHolder))
    {
      a(paramBufferedSink, ((ValueHolder.BooleanHolder)paramValueHolder).a());
      return;
    }
    if ((paramValueHolder instanceof ValueHolder.CharHolder))
    {
      a(paramBufferedSink, new char[] { ((ValueHolder.CharHolder)paramValueHolder).a() });
      return;
    }
    if ((paramValueHolder instanceof ValueHolder.FloatHolder))
    {
      a(paramBufferedSink, ((ValueHolder.FloatHolder)paramValueHolder).a());
      return;
    }
    if ((paramValueHolder instanceof ValueHolder.DoubleHolder))
    {
      a(paramBufferedSink, ((ValueHolder.DoubleHolder)paramValueHolder).a());
      return;
    }
    if ((paramValueHolder instanceof ValueHolder.ByteHolder))
    {
      paramBufferedSink.writeByte(((ValueHolder.ByteHolder)paramValueHolder).a());
      return;
    }
    if ((paramValueHolder instanceof ValueHolder.ShortHolder))
    {
      paramBufferedSink.writeShort(((ValueHolder.ShortHolder)paramValueHolder).a());
      return;
    }
    if ((paramValueHolder instanceof ValueHolder.IntHolder))
    {
      paramBufferedSink.writeInt(((ValueHolder.IntHolder)paramValueHolder).a());
      return;
    }
    if ((paramValueHolder instanceof ValueHolder.LongHolder)) {
      paramBufferedSink.writeLong(((ValueHolder.LongHolder)paramValueHolder).a());
    }
  }
  
  private final void a(BufferedSink paramBufferedSink, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private final void a(BufferedSink paramBufferedSink, char[] paramArrayOfChar)
  {
    paramBufferedSink.writeString(new String(paramArrayOfChar), Charsets.UTF_16BE);
  }
  
  private final void a(BufferedSink paramBufferedSink, double[] paramArrayOfDouble)
  {
    int j = paramArrayOfDouble.length;
    int i = 0;
    while (i < j)
    {
      a(paramBufferedSink, paramArrayOfDouble[i]);
      i += 1;
    }
  }
  
  private final void a(BufferedSink paramBufferedSink, float[] paramArrayOfFloat)
  {
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      a(paramBufferedSink, paramArrayOfFloat[i]);
      i += 1;
    }
  }
  
  private final void a(BufferedSink paramBufferedSink, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      paramBufferedSink.writeInt(paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  private final void a(BufferedSink paramBufferedSink, long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      a(paramBufferedSink, paramArrayOfLong[i]);
      i += 1;
    }
  }
  
  private final void a(BufferedSink paramBufferedSink, short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    int i = 0;
    while (i < j)
    {
      paramBufferedSink.writeShort(paramArrayOfShort[i]);
      i += 1;
    }
  }
  
  private final void a(BufferedSink paramBufferedSink, boolean[] paramArrayOfBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:553)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private final void b(BufferedSink paramBufferedSink, long[] paramArrayOfLong)
  {
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      paramBufferedSink.writeLong(paramArrayOfLong[i]);
      i += 1;
    }
  }
  
  public final void a(@NotNull HprofRecord paramHprofRecord)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofRecord, "record");
    a(this.c, paramHprofRecord);
  }
  
  public void close()
  {
    a(this.c);
    this.c.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofWriter
 * JD-Core Version:    0.7.0.1
 */