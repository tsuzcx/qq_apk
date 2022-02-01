package shark.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import shark.GcRoot;
import shark.GcRoot.Debugger;
import shark.GcRoot.Finalizing;
import shark.GcRoot.InternedString;
import shark.GcRoot.JavaFrame;
import shark.GcRoot.JniGlobal;
import shark.GcRoot.JniLocal;
import shark.GcRoot.JniMonitor;
import shark.GcRoot.MonitorUsed;
import shark.GcRoot.NativeStack;
import shark.GcRoot.ReferenceCleanup;
import shark.GcRoot.StickyClass;
import shark.GcRoot.ThreadBlock;
import shark.GcRoot.ThreadObject;
import shark.GcRoot.Unknown;
import shark.GcRoot.Unreachable;
import shark.GcRoot.VmInternal;
import shark.HprofHeader;
import shark.HprofRecordReader;
import shark.HprofRecordTag;
import shark.HprofVersion;
import shark.OnHprofRecordTagListener;
import shark.PrimitiveType;
import shark.PrimitiveType.Companion;
import shark.ProguardMapping;
import shark.internal.hppc.LongLongScatterMap;
import shark.internal.hppc.LongObjectScatterMap;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/HprofInMemoryIndex$Builder;", "Lshark/OnHprofRecordTagListener;", "longIdentifiers", "", "maxPosition", "", "classCount", "", "instanceCount", "objectArrayCount", "primitiveArrayCount", "bytesForClassSize", "bytesForInstanceSize", "bytesForObjectArraySize", "bytesForPrimitiveArraySize", "classFieldsTotalBytes", "(ZJIIIIIIIII)V", "getBytesForClassSize", "()I", "getBytesForInstanceSize", "getBytesForObjectArraySize", "getBytesForPrimitiveArraySize", "classFieldBytes", "", "classFieldsIndex", "classFieldsIndexSize", "getClassFieldsTotalBytes", "classIndex", "Lshark/internal/UnsortedByteEntries;", "classNames", "Lshark/internal/hppc/LongLongScatterMap;", "gcRoots", "", "Lshark/GcRoot;", "hprofStringCache", "Lshark/internal/hppc/LongObjectScatterMap;", "", "identifierSize", "instanceIndex", "objectArrayIndex", "positionSize", "primitiveArrayIndex", "buildIndex", "Lshark/internal/HprofInMemoryIndex;", "proguardMapping", "Lshark/ProguardMapping;", "hprofHeader", "Lshark/HprofHeader;", "lastClassFieldsShort", "", "onHprofRecord", "", "tag", "Lshark/HprofRecordTag;", "length", "reader", "Lshark/HprofRecordReader;", "copyToClassFields", "byteCount", "shark-graph"}, k=1, mv={1, 4, 1})
final class HprofInMemoryIndex$Builder
  implements OnHprofRecordTagListener
{
  private final int b;
  private final int c;
  private final int d;
  private final LongObjectScatterMap<String> e;
  private final LongLongScatterMap f;
  private final byte[] g;
  private int h;
  private final UnsortedByteEntries i;
  private final UnsortedByteEntries j;
  private final UnsortedByteEntries k;
  private final UnsortedByteEntries l;
  private final List<GcRoot> m;
  private final int n;
  private final int o;
  private final int p;
  private final int q;
  private final int r;
  
  public HprofInMemoryIndex$Builder(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    this.n = paramInt5;
    this.o = paramInt6;
    this.p = paramInt7;
    this.q = paramInt8;
    this.r = paramInt9;
    if (paramBoolean) {
      paramInt5 = 8;
    } else {
      paramInt5 = 4;
    }
    this.b = paramInt5;
    this.c = HprofInMemoryIndex.Companion.a(HprofInMemoryIndex.a, paramLong);
    this.d = HprofInMemoryIndex.Companion.a(HprofInMemoryIndex.a, this.r);
    this.e = new LongObjectScatterMap();
    this.f = new LongLongScatterMap(paramInt1);
    this.g = new byte[this.r];
    this.i = new UnsortedByteEntries(this.c + this.b + 4 + this.n + this.d, paramBoolean, paramInt1, 0.0D, 8, null);
    paramInt1 = this.c;
    paramInt5 = this.b;
    this.j = new UnsortedByteEntries(this.o + (paramInt1 + paramInt5), paramBoolean, paramInt2, 0.0D, 8, null);
    paramInt1 = this.c;
    paramInt2 = this.b;
    this.k = new UnsortedByteEntries(this.p + (paramInt1 + paramInt2), paramBoolean, paramInt3, 0.0D, 8, null);
    paramInt1 = this.c;
    this.l = new UnsortedByteEntries(this.q + (paramInt1 + 1), paramBoolean, paramInt4, 0.0D, 8, null);
    this.m = ((List)new ArrayList());
  }
  
  private final short a()
  {
    byte[] arrayOfByte = this.g;
    int i1 = this.h;
    int i2 = arrayOfByte[(i1 - 2)];
    return (short)(arrayOfByte[(i1 - 1)] & 0xFF | (i2 & 0xFF) << 8);
  }
  
  private final void a(HprofRecordReader paramHprofRecordReader, int paramInt)
  {
    int i1 = 1;
    if (1 <= paramInt) {
      for (;;)
      {
        byte[] arrayOfByte = this.g;
        int i2 = this.h;
        this.h = (i2 + 1);
        arrayOfByte[i2] = paramHprofRecordReader.N();
        if (i1 == paramInt) {
          break;
        }
        i1 += 1;
      }
    }
  }
  
  @NotNull
  public final HprofInMemoryIndex a(@Nullable ProguardMapping paramProguardMapping, @NotNull HprofHeader paramHprofHeader)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofHeader, "hprofHeader");
    int i1;
    if (this.h == this.g.length) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      SortedBytesMap localSortedBytesMap1 = this.j.a();
      SortedBytesMap localSortedBytesMap2 = this.k.a();
      SortedBytesMap localSortedBytesMap3 = this.l.a();
      SortedBytesMap localSortedBytesMap4 = this.i.a();
      i1 = this.c;
      LongObjectScatterMap localLongObjectScatterMap = this.e;
      LongLongScatterMap localLongLongScatterMap = this.f;
      List localList = this.m;
      int i2 = this.n;
      int i3 = this.o;
      int i4 = this.p;
      int i5 = this.q;
      boolean bool;
      if (paramHprofHeader.b() != HprofVersion.ANDROID) {
        bool = true;
      } else {
        bool = false;
      }
      return new HprofInMemoryIndex(i1, localLongObjectScatterMap, localLongLongScatterMap, localSortedBytesMap4, localSortedBytesMap1, localSortedBytesMap2, localSortedBytesMap3, localList, paramProguardMapping, i2, i3, i4, i5, bool, new ClassFieldsReader(this.b, this.g), this.d, null);
    }
    paramProguardMapping = new StringBuilder();
    paramProguardMapping.append("Read ");
    paramProguardMapping.append(this.h);
    paramProguardMapping.append(" into fields bytes instead of expected ");
    paramProguardMapping.append(this.g.length);
    throw ((Throwable)new IllegalArgumentException(paramProguardMapping.toString().toString()));
  }
  
  public void a(@NotNull HprofRecordTag paramHprofRecordTag, long paramLong, @NotNull HprofRecordReader paramHprofRecordReader)
  {
    Intrinsics.checkParameterIsNotNull(paramHprofRecordTag, "tag");
    Intrinsics.checkParameterIsNotNull(paramHprofRecordReader, "reader");
    long l1;
    int i1;
    long l2;
    long l3;
    switch (HprofInMemoryIndex.Builder.WhenMappings.$EnumSwitchMapping$0[paramHprofRecordTag.ordinal()])
    {
    default: 
      return;
    case 22: 
      paramLong = paramHprofRecordReader.a();
      l1 = paramHprofRecordReader.S();
      paramHprofRecordReader.b(PrimitiveType.INT.getByteSize());
      i1 = paramHprofRecordReader.L();
      paramHprofRecordTag = (PrimitiveType)MapsKt.getValue(PrimitiveType.Companion.b(), Integer.valueOf(paramHprofRecordReader.J()));
      paramHprofRecordReader.b(i1 * paramHprofRecordTag.getByteSize());
      l2 = paramHprofRecordReader.a();
      paramHprofRecordReader = this.l.a(l1);
      paramHprofRecordReader.a(paramLong, this.c);
      paramHprofRecordReader.a((byte)paramHprofRecordTag.ordinal());
      paramHprofRecordReader.a(l2 - paramLong, this.q);
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 21: 
      paramLong = paramHprofRecordReader.a();
      l1 = paramHprofRecordReader.S();
      paramHprofRecordReader.b(PrimitiveType.INT.getByteSize());
      i1 = paramHprofRecordReader.L();
      l2 = paramHprofRecordReader.S();
      paramHprofRecordReader.b(this.b * i1);
      l3 = paramHprofRecordReader.a();
      paramHprofRecordTag = this.k.a(l1);
      paramHprofRecordTag.a(paramLong, this.c);
      paramHprofRecordTag.a(l2);
      paramHprofRecordTag.a(l3 - paramLong, this.p);
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 20: 
      paramLong = paramHprofRecordReader.a();
      l1 = paramHprofRecordReader.S();
      paramHprofRecordReader.b(PrimitiveType.INT.getByteSize());
      l2 = paramHprofRecordReader.S();
      paramHprofRecordReader.b(paramHprofRecordReader.L());
      l3 = paramHprofRecordReader.a();
      paramHprofRecordTag = this.j.a(l1);
      paramHprofRecordTag.a(paramLong, this.c);
      paramHprofRecordTag.a(l2);
      paramHprofRecordTag.a(l3 - paramLong, this.o);
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 19: 
      paramLong = paramHprofRecordReader.a();
      l1 = paramHprofRecordReader.S();
      paramHprofRecordReader.b(PrimitiveType.INT.getByteSize());
      l2 = paramHprofRecordReader.S();
      paramHprofRecordReader.b(this.b * 5);
      int i4 = paramHprofRecordReader.L();
      paramHprofRecordReader.A();
      int i5 = this.h;
      l3 = paramHprofRecordReader.a();
      a(paramHprofRecordReader, 2);
      i1 = a() & 0xFFFF;
      int i2 = 0;
      int i3;
      for (;;)
      {
        i3 = 1;
        if (i2 >= i1) {
          break;
        }
        a(paramHprofRecordReader, this.b);
        a(paramHprofRecordReader, 1);
        i3 = this.g[(this.h - 1)] & 0xFF;
        if (i3 == 2) {
          a(paramHprofRecordReader, this.b);
        } else {
          a(paramHprofRecordReader, ((Number)MapsKt.getValue(PrimitiveType.Companion.a(), Integer.valueOf(i3))).intValue());
        }
        i2 += 1;
      }
      a(paramHprofRecordReader, 2);
      i2 = a();
      i1 = 0;
      while (i1 < (i2 & 0xFFFF))
      {
        a(paramHprofRecordReader, this.b);
        a(paramHprofRecordReader, 1);
        i1 += 1;
      }
      i2 = (int)(paramHprofRecordReader.a() - l3);
      l3 = paramHprofRecordReader.a();
      paramHprofRecordTag = this.i.a(l1);
      paramHprofRecordTag.a(paramLong, this.c);
      paramHprofRecordTag.a(l2);
      paramHprofRecordTag.a(i4);
      paramHprofRecordTag.a(l3 - paramLong, this.n);
      paramHprofRecordTag.a(i5, this.d);
      paramHprofRecordTag = Unit.INSTANCE;
      i4 = i5 + i2;
      if (i4 == this.h) {
        i1 = i3;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        return;
      }
      paramHprofRecordTag = new StringBuilder();
      paramHprofRecordTag.append("Expected ");
      paramHprofRecordTag.append(this.h);
      paramHprofRecordTag.append(" to have moved by ");
      paramHprofRecordTag.append(i2);
      paramHprofRecordTag.append(" and be equal to ");
      paramHprofRecordTag.append(i4);
      throw ((Throwable)new IllegalArgumentException(paramHprofRecordTag.toString().toString()));
    case 18: 
      paramHprofRecordTag = paramHprofRecordReader.t();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 17: 
      paramHprofRecordTag = paramHprofRecordReader.s();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 16: 
      paramHprofRecordTag = paramHprofRecordReader.r();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 15: 
      paramHprofRecordTag = paramHprofRecordReader.q();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 14: 
      paramHprofRecordTag = paramHprofRecordReader.p();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 13: 
      paramHprofRecordTag = paramHprofRecordReader.o();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 12: 
      paramHprofRecordTag = paramHprofRecordReader.n();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 11: 
      paramHprofRecordTag = paramHprofRecordReader.m();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 10: 
      paramHprofRecordTag = paramHprofRecordReader.l();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 9: 
      paramHprofRecordTag = paramHprofRecordReader.k();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 8: 
      paramHprofRecordTag = paramHprofRecordReader.j();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 7: 
      paramHprofRecordTag = paramHprofRecordReader.i();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 6: 
      paramHprofRecordTag = paramHprofRecordReader.h();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 5: 
      paramHprofRecordTag = paramHprofRecordReader.g();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 4: 
      paramHprofRecordTag = paramHprofRecordReader.f();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 3: 
      paramHprofRecordTag = paramHprofRecordReader.e();
      if (paramHprofRecordTag.a() != 0L) {
        ((Collection)this.m).add(paramHprofRecordTag);
      }
      paramHprofRecordTag = Unit.INSTANCE;
      return;
    case 2: 
      paramHprofRecordReader.b(PrimitiveType.INT.getByteSize());
      paramLong = paramHprofRecordReader.S();
      paramHprofRecordReader.b(PrimitiveType.INT.getByteSize());
      l1 = paramHprofRecordReader.S();
      this.f.a(paramLong, l1);
      return;
    }
    this.e.a(paramHprofRecordReader.S(), paramHprofRecordReader.c(paramLong - this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.HprofInMemoryIndex.Builder
 * JD-Core Version:    0.7.0.1
 */