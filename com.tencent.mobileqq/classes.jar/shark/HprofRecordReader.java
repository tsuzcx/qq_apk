package shark;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofRecordReader;", "", "header", "Lshark/HprofHeader;", "source", "Lokio/BufferedSource;", "(Lshark/HprofHeader;Lokio/BufferedSource;)V", "<set-?>", "", "bytesRead", "getBytesRead", "()J", "identifierByteSize", "", "typeSizes", "", "readBoolean", "", "readBooleanArray", "", "arrayLength", "readByte", "", "readByteArray", "", "byteCount", "readChar", "", "readCharArray", "", "readClassDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ClassDumpRecord;", "readDebuggerGcRootRecord", "Lshark/GcRoot$Debugger;", "readDouble", "", "readDoubleArray", "", "readFinalizingGcRootRecord", "Lshark/GcRoot$Finalizing;", "readFloat", "", "readFloatArray", "", "readHeapDumpInfoRecord", "Lshark/HprofRecord$HeapDumpRecord$HeapDumpInfoRecord;", "readId", "readIdArray", "", "readInstanceDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$InstanceDumpRecord;", "readInt", "readIntArray", "readInternedStringGcRootRecord", "Lshark/GcRoot$InternedString;", "readJavaFrameGcRootRecord", "Lshark/GcRoot$JavaFrame;", "readJniGlobalGcRootRecord", "Lshark/GcRoot$JniGlobal;", "readJniLocalGcRootRecord", "Lshark/GcRoot$JniLocal;", "readJniMonitorGcRootRecord", "Lshark/GcRoot$JniMonitor;", "readLoadClassRecord", "Lshark/HprofRecord$LoadClassRecord;", "readLong", "readLongArray", "readMonitorUsedGcRootRecord", "Lshark/GcRoot$MonitorUsed;", "readNativeStackGcRootRecord", "Lshark/GcRoot$NativeStack;", "readObjectArrayDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$ObjectArrayDumpRecord;", "readPrimitiveArrayDumpRecord", "Lshark/HprofRecord$HeapDumpRecord$ObjectRecord$PrimitiveArrayDumpRecord;", "readReferenceCleanupGcRootRecord", "Lshark/GcRoot$ReferenceCleanup;", "readShort", "", "readShortArray", "", "readStackFrameRecord", "Lshark/HprofRecord$StackFrameRecord;", "readStackTraceRecord", "Lshark/HprofRecord$StackTraceRecord;", "readStickyClassGcRootRecord", "Lshark/GcRoot$StickyClass;", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readStringRecord", "Lshark/HprofRecord$StringRecord;", "length", "readThreadBlockGcRootRecord", "Lshark/GcRoot$ThreadBlock;", "readThreadObjectGcRootRecord", "Lshark/GcRoot$ThreadObject;", "readUnknownGcRootRecord", "Lshark/GcRoot$Unknown;", "readUnreachableGcRootRecord", "Lshark/GcRoot$Unreachable;", "readUnsignedByte", "readUnsignedInt", "readUnsignedShort", "readUtf8", "readValue", "Lshark/ValueHolder;", "type", "readVmInternalGcRootRecord", "Lshark/GcRoot$VmInternal;", "sizeOf", "skip", "", "skipClassDumpConstantPool", "skipClassDumpFields", "skipClassDumpHeader", "skipClassDumpRecord", "skipClassDumpStaticFields", "skipHeapDumpInfoRecord", "skipInstanceDumpRecord", "skipObjectArrayDumpRecord", "skipPrimitiveArrayDumpRecord", "Companion", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofRecordReader
{
  @NotNull
  public static final HprofRecordReader.Companion a = new HprofRecordReader.Companion(null);
  private static final int f = PrimitiveType.BOOLEAN.getByteSize();
  private static final int g = PrimitiveType.CHAR.getByteSize();
  private static final int h = PrimitiveType.BYTE.getByteSize();
  private static final int i = PrimitiveType.SHORT.getByteSize();
  private static final int j = PrimitiveType.INT.getByteSize();
  private static final int k = PrimitiveType.LONG.getByteSize();
  private static final int l = PrimitiveType.BOOLEAN.getHprofType();
  private static final int m = PrimitiveType.CHAR.getHprofType();
  private static final int n = PrimitiveType.FLOAT.getHprofType();
  private static final int o = PrimitiveType.DOUBLE.getHprofType();
  private static final int p = PrimitiveType.BYTE.getHprofType();
  private static final int q = PrimitiveType.SHORT.getHprofType();
  private static final int r = PrimitiveType.INT.getHprofType();
  private static final int s = PrimitiveType.LONG.getHprofType();
  private long b;
  private final int c;
  private final int[] d;
  private final BufferedSource e;
  
  public HprofRecordReader(@NotNull HprofHeader paramHprofHeader, @NotNull BufferedSource paramBufferedSource)
  {
    this.e = paramBufferedSource;
    this.c = paramHprofHeader.c();
    paramHprofHeader = MapsKt.plus(PrimitiveType.Companion.a(), TuplesKt.to(Integer.valueOf(2), Integer.valueOf(this.c)));
    paramBufferedSource = CollectionsKt.max((Iterable)paramHprofHeader.keySet());
    if (paramBufferedSource == null) {
      Intrinsics.throwNpe();
    }
    int i3 = ((Number)paramBufferedSource).intValue() + 1;
    paramBufferedSource = new int[i3];
    int i1 = 0;
    while (i1 < i3)
    {
      Integer localInteger = (Integer)paramHprofHeader.get(Integer.valueOf(i1));
      int i2;
      if (localInteger != null) {
        i2 = localInteger.intValue();
      } else {
        i2 = 0;
      }
      paramBufferedSource[i1] = i2;
      i1 += 1;
    }
    this.d = paramBufferedSource;
  }
  
  public final void A()
  {
    int i2 = T();
    int i1 = 0;
    while (i1 < i2)
    {
      b(PrimitiveType.SHORT.getByteSize());
      b(a(J()));
      i1 += 1;
    }
  }
  
  public final void B()
  {
    int i3 = T();
    int i1 = 0;
    while (i1 < i3)
    {
      b(this.c);
      int i2 = J();
      if (i2 == 2) {
        i2 = this.c;
      } else {
        i2 = ((Number)MapsKt.getValue(PrimitiveType.Companion.a(), Integer.valueOf(i2))).intValue();
      }
      b(i2);
      i1 += 1;
    }
  }
  
  public final void C()
  {
    int i1 = T();
    b((this.c + 1) * i1);
  }
  
  public final void D()
  {
    int i1 = this.c;
    b(j + i1 + i1);
    b(L());
  }
  
  public final void E()
  {
    int i1 = this.c;
    int i2 = j;
    b(i1 + i2 + i1 + i1 + i1 + i1 + i1 + i1 + i2);
    int i3 = T();
    i2 = 0;
    i1 = 0;
    while (i1 < i3)
    {
      b(i);
      b(this.d[J()]);
      i1 += 1;
    }
    i3 = T();
    i1 = i2;
    while (i1 < i3)
    {
      b(this.c);
      i2 = J();
      b(this.d[i2]);
      i1 += 1;
    }
    b(T() * (this.c + h));
  }
  
  public final void F()
  {
    b(this.c + j);
    int i1 = L();
    int i2 = this.c;
    b(i2 + i1 * i2);
  }
  
  public final void G()
  {
    b(this.c + j);
    int i1 = L();
    int i2 = J();
    b(i1 * this.d[i2]);
  }
  
  public final void H()
  {
    int i1 = this.c;
    b(i1 + i1);
  }
  
  public final long I()
  {
    return L() & 0xFFFFFFFF;
  }
  
  public final int J()
  {
    return N() & 0xFF;
  }
  
  public final short K()
  {
    this.b += i;
    return this.e.readShort();
  }
  
  public final int L()
  {
    this.b += j;
    return this.e.readInt();
  }
  
  public final long M()
  {
    this.b += k;
    return this.e.readLong();
  }
  
  public final byte N()
  {
    this.b += h;
    return this.e.readByte();
  }
  
  public final boolean O()
  {
    this.b += f;
    return this.e.readByte() != 0;
  }
  
  public final char P()
  {
    return a(g, Charsets.UTF_16BE).charAt(0);
  }
  
  public final float Q()
  {
    FloatCompanionObject localFloatCompanionObject = FloatCompanionObject.INSTANCE;
    return Float.intBitsToFloat(L());
  }
  
  public final double R()
  {
    DoubleCompanionObject localDoubleCompanionObject = DoubleCompanionObject.INSTANCE;
    return Double.longBitsToDouble(M());
  }
  
  public final long S()
  {
    int i1 = this.c;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 4)
        {
          if (i1 == 8) {
            return M();
          }
          throw ((Throwable)new IllegalArgumentException("ID Length must be 1, 2, 4, or 8"));
        }
        i1 = L();
      }
      else
      {
        i1 = K();
      }
    }
    else {
      i1 = N();
    }
    return i1;
  }
  
  public final int T()
  {
    return K() & 0xFFFF;
  }
  
  public final int a(int paramInt)
  {
    return this.d[paramInt];
  }
  
  public final long a()
  {
    return this.b;
  }
  
  @NotNull
  public final String a(int paramInt, @NotNull Charset paramCharset)
  {
    Intrinsics.checkParameterIsNotNull(paramCharset, "charset");
    long l1 = this.b;
    long l2 = paramInt;
    this.b = (l1 + l2);
    paramCharset = this.e.readString(l2, paramCharset);
    Intrinsics.checkExpressionValueIsNotNull(paramCharset, "source.readString(byteCount.toLong(), charset)");
    return paramCharset;
  }
  
  @NotNull
  public final HprofRecord.StringRecord a(long paramLong)
  {
    return new HprofRecord.StringRecord(S(), c(paramLong - this.c));
  }
  
  @NotNull
  public final HprofRecord.LoadClassRecord b()
  {
    return new HprofRecord.LoadClassRecord(L(), S(), L(), S());
  }
  
  public final void b(int paramInt)
  {
    long l1 = this.b;
    long l2 = paramInt;
    this.b = (l1 + l2);
    this.e.skip(l2);
  }
  
  public final void b(long paramLong)
  {
    this.b += paramLong;
    this.e.skip(paramLong);
  }
  
  @NotNull
  public final String c(long paramLong)
  {
    this.b += paramLong;
    String str = this.e.readUtf8(paramLong);
    Intrinsics.checkExpressionValueIsNotNull(str, "source.readUtf8(byteCount)");
    return str;
  }
  
  @NotNull
  public final HprofRecord.StackFrameRecord c()
  {
    return new HprofRecord.StackFrameRecord(S(), S(), S(), S(), L(), L());
  }
  
  @NotNull
  public final ValueHolder c(int paramInt)
  {
    if (paramInt == 2) {
      return (ValueHolder)new ValueHolder.ReferenceHolder(S());
    }
    if (paramInt == l) {
      return (ValueHolder)new ValueHolder.BooleanHolder(O());
    }
    if (paramInt == m) {
      return (ValueHolder)new ValueHolder.CharHolder(P());
    }
    if (paramInt == n) {
      return (ValueHolder)new ValueHolder.FloatHolder(Q());
    }
    if (paramInt == o) {
      return (ValueHolder)new ValueHolder.DoubleHolder(R());
    }
    if (paramInt == p) {
      return (ValueHolder)new ValueHolder.ByteHolder(N());
    }
    if (paramInt == q) {
      return (ValueHolder)new ValueHolder.ShortHolder(K());
    }
    if (paramInt == r) {
      return (ValueHolder)new ValueHolder.IntHolder(L());
    }
    if (paramInt == s) {
      return (ValueHolder)new ValueHolder.LongHolder(M());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown type ");
    localStringBuilder.append(paramInt);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
  
  @NotNull
  public final HprofRecord.StackTraceRecord d()
  {
    return new HprofRecord.StackTraceRecord(L(), L(), d(L()));
  }
  
  @NotNull
  public final long[] d(int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    int i1 = 0;
    while (i1 < paramInt)
    {
      arrayOfLong[i1] = S();
      i1 += 1;
    }
    return arrayOfLong;
  }
  
  @NotNull
  public final GcRoot.Unknown e()
  {
    return new GcRoot.Unknown(S());
  }
  
  @NotNull
  public final boolean[] e(int paramInt)
  {
    boolean[] arrayOfBoolean = new boolean[paramInt];
    int i1 = 0;
    while (i1 < paramInt)
    {
      int i2;
      if (N() != 0) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      arrayOfBoolean[i1] = i2;
      i1 += 1;
    }
    return arrayOfBoolean;
  }
  
  @NotNull
  public final GcRoot.JniGlobal f()
  {
    return new GcRoot.JniGlobal(S(), S());
  }
  
  @NotNull
  public final char[] f(int paramInt)
  {
    char[] arrayOfChar = new char[paramInt];
    int i1 = 0;
    while (i1 < paramInt)
    {
      arrayOfChar[i1] = P();
      i1 += 1;
    }
    return arrayOfChar;
  }
  
  @NotNull
  public final GcRoot.JniLocal g()
  {
    return new GcRoot.JniLocal(S(), L(), L());
  }
  
  @NotNull
  public final float[] g(int paramInt)
  {
    float[] arrayOfFloat = new float[paramInt];
    int i1 = 0;
    while (i1 < paramInt)
    {
      arrayOfFloat[i1] = Q();
      i1 += 1;
    }
    return arrayOfFloat;
  }
  
  @NotNull
  public final GcRoot.JavaFrame h()
  {
    return new GcRoot.JavaFrame(S(), L(), L());
  }
  
  @NotNull
  public final double[] h(int paramInt)
  {
    double[] arrayOfDouble = new double[paramInt];
    int i1 = 0;
    while (i1 < paramInt)
    {
      arrayOfDouble[i1] = R();
      i1 += 1;
    }
    return arrayOfDouble;
  }
  
  @NotNull
  public final GcRoot.NativeStack i()
  {
    return new GcRoot.NativeStack(S(), L());
  }
  
  @NotNull
  public final short[] i(int paramInt)
  {
    short[] arrayOfShort = new short[paramInt];
    int i1 = 0;
    while (i1 < paramInt)
    {
      arrayOfShort[i1] = K();
      i1 += 1;
    }
    return arrayOfShort;
  }
  
  @NotNull
  public final GcRoot.StickyClass j()
  {
    return new GcRoot.StickyClass(S());
  }
  
  @NotNull
  public final int[] j(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    int i1 = 0;
    while (i1 < paramInt)
    {
      arrayOfInt[i1] = L();
      i1 += 1;
    }
    return arrayOfInt;
  }
  
  @NotNull
  public final GcRoot.ThreadBlock k()
  {
    return new GcRoot.ThreadBlock(S(), L());
  }
  
  @NotNull
  public final long[] k(int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    int i1 = 0;
    while (i1 < paramInt)
    {
      arrayOfLong[i1] = M();
      i1 += 1;
    }
    return arrayOfLong;
  }
  
  @NotNull
  public final GcRoot.MonitorUsed l()
  {
    return new GcRoot.MonitorUsed(S());
  }
  
  @NotNull
  public final byte[] l(int paramInt)
  {
    long l1 = this.b;
    long l2 = paramInt;
    this.b = (l1 + l2);
    byte[] arrayOfByte = this.e.readByteArray(l2);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "source.readByteArray(byteCount.toLong())");
    return arrayOfByte;
  }
  
  @NotNull
  public final GcRoot.ThreadObject m()
  {
    return new GcRoot.ThreadObject(S(), L(), L());
  }
  
  @NotNull
  public final GcRoot.InternedString n()
  {
    return new GcRoot.InternedString(S());
  }
  
  @NotNull
  public final GcRoot.Finalizing o()
  {
    return new GcRoot.Finalizing(S());
  }
  
  @NotNull
  public final GcRoot.Debugger p()
  {
    return new GcRoot.Debugger(S());
  }
  
  @NotNull
  public final GcRoot.ReferenceCleanup q()
  {
    return new GcRoot.ReferenceCleanup(S());
  }
  
  @NotNull
  public final GcRoot.VmInternal r()
  {
    return new GcRoot.VmInternal(S());
  }
  
  @NotNull
  public final GcRoot.JniMonitor s()
  {
    return new GcRoot.JniMonitor(S(), L(), L());
  }
  
  @NotNull
  public final GcRoot.Unreachable t()
  {
    return new GcRoot.Unreachable(S());
  }
  
  @NotNull
  public final HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord u()
  {
    return new HprofRecord.HeapDumpRecord.ObjectRecord.InstanceDumpRecord(S(), L(), S(), l(L()));
  }
  
  @NotNull
  public final HprofRecord.HeapDumpRecord.HeapDumpInfoRecord v()
  {
    return new HprofRecord.HeapDumpRecord.HeapDumpInfoRecord(L(), S());
  }
  
  @NotNull
  public final HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord w()
  {
    Object localObject = this;
    long l3 = S();
    int i5 = L();
    long l4 = S();
    long l5 = S();
    long l2 = S();
    long l1 = S();
    S();
    S();
    int i2 = L();
    int i3 = T();
    int i1 = 0;
    while (i1 < i3)
    {
      ((HprofRecordReader)localObject).b(i);
      ((HprofRecordReader)localObject).b(localObject.d[J()]);
      i1 += 1;
    }
    int i4 = T();
    localObject = new ArrayList(i4);
    i3 = 0;
    i1 = i2;
    i2 = i4;
    while (i3 < i2)
    {
      long l6 = S();
      i4 = J();
      ((ArrayList)localObject).add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.StaticFieldRecord(l6, i4, c(i4)));
      i3 += 1;
    }
    i3 = T();
    ArrayList localArrayList = new ArrayList(i3);
    i2 = 0;
    while (i2 < i3)
    {
      localArrayList.add(new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord.FieldRecord(S(), J()));
      i2 += 1;
    }
    return new HprofRecord.HeapDumpRecord.ObjectRecord.ClassDumpRecord(l3, i5, l4, l5, l2, l1, i1, (List)localObject, (List)localArrayList);
  }
  
  @NotNull
  public final HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord x()
  {
    long l1 = S();
    int i1 = L();
    int i2 = L();
    int i3 = J();
    if (i3 == l) {
      return (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.BooleanArrayDump(l1, i1, e(i2));
    }
    if (i3 == m) {
      return (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.CharArrayDump(l1, i1, f(i2));
    }
    if (i3 == n) {
      return (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.FloatArrayDump(l1, i1, g(i2));
    }
    if (i3 == o) {
      return (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.DoubleArrayDump(l1, i1, h(i2));
    }
    if (i3 == p) {
      return (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ByteArrayDump(l1, i1, l(i2));
    }
    if (i3 == q) {
      return (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.ShortArrayDump(l1, i1, i(i2));
    }
    if (i3 == r) {
      return (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.IntArrayDump(l1, i1, j(i2));
    }
    if (i3 == s) {
      return (HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord)new HprofRecord.HeapDumpRecord.ObjectRecord.PrimitiveArrayDumpRecord.LongArrayDump(l1, i1, k(i2));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected type ");
    localStringBuilder.append(i3);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
  }
  
  @NotNull
  public final HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord y()
  {
    long l1 = S();
    int i1 = L();
    int i2 = L();
    return new HprofRecord.HeapDumpRecord.ObjectRecord.ObjectArrayDumpRecord(l1, i1, S(), d(i2));
  }
  
  public final void z()
  {
    b(j * 2 + this.c * 7);
    A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofRecordReader
 * JD-Core Version:    0.7.0.1
 */