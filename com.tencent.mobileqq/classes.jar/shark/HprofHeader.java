package shark;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofHeader;", "", "heapDumpTimestamp", "", "version", "Lshark/HprofVersion;", "identifierByteSize", "", "(JLshark/HprofVersion;I)V", "getHeapDumpTimestamp", "()J", "getIdentifierByteSize", "()I", "recordsPosition", "getRecordsPosition", "getVersion", "()Lshark/HprofVersion;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class HprofHeader
{
  @NotNull
  public static final HprofHeader.Companion a = new HprofHeader.Companion(null);
  private static final Map<String, HprofVersion> f;
  private final int b;
  private final long c;
  @NotNull
  private final HprofVersion d;
  private final int e;
  
  static
  {
    HprofVersion[] arrayOfHprofVersion = HprofVersion.values();
    Collection localCollection = (Collection)new ArrayList(arrayOfHprofVersion.length);
    int j = arrayOfHprofVersion.length;
    int i = 0;
    while (i < j)
    {
      HprofVersion localHprofVersion = arrayOfHprofVersion[i];
      localCollection.add(TuplesKt.to(localHprofVersion.getVersionString(), localHprofVersion));
      i += 1;
    }
    f = MapsKt.toMap((Iterable)localCollection);
  }
  
  public HprofHeader()
  {
    this(0L, null, 0, 7, null);
  }
  
  public HprofHeader(long paramLong, @NotNull HprofVersion paramHprofVersion, int paramInt)
  {
    this.c = paramLong;
    this.d = paramHprofVersion;
    this.e = paramInt;
    paramHprofVersion = this.d.getVersionString();
    Charset localCharset = Charsets.UTF_8;
    if (paramHprofVersion != null)
    {
      paramHprofVersion = paramHprofVersion.getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(paramHprofVersion, "(this as java.lang.String).getBytes(charset)");
      this.b = (paramHprofVersion.length + 1 + 4 + 8);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public final int a()
  {
    return this.b;
  }
  
  @NotNull
  public final HprofVersion b()
  {
    return this.d;
  }
  
  public final int c()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HprofHeader))
      {
        paramObject = (HprofHeader)paramObject;
        if ((this.c == paramObject.c) && (Intrinsics.areEqual(this.d, paramObject.d)) && (this.e == paramObject.e)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    long l = this.c;
    int j = (int)(l ^ l >>> 32);
    HprofVersion localHprofVersion = this.d;
    int i;
    if (localHprofVersion != null) {
      i = localHprofVersion.hashCode();
    } else {
      i = 0;
    }
    return (j * 31 + i) * 31 + this.e;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HprofHeader(heapDumpTimestamp=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", identifierByteSize=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofHeader
 * JD-Core Version:    0.7.0.1
 */