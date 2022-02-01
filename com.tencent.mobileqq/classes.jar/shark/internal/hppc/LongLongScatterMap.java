package shark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/hppc/LongLongScatterMap;", "", "expectedElements", "", "(I)V", "assigned", "hasEmptyKey", "", "isEmpty", "()Z", "keys", "", "loadFactor", "", "mask", "resizeAt", "size", "getSize", "()I", "values", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "", "pendingValue", "containsKey", "key", "ensureCapacity", "entrySequence", "Lkotlin/sequences/Sequence;", "Lshark/internal/hppc/LongLongPair;", "forEach", "forEachCallback", "Lshark/internal/hppc/LongLongScatterMap$ForEachCallback;", "get", "getSlot", "getSlotValue", "hashKey", "rehash", "fromKeys", "fromValues", "release", "remove", "set", "value", "shiftConflictingKeys", "gapSlotArg", "ForEachCallback", "shark-graph"}, k=1, mv={1, 4, 1})
public final class LongLongScatterMap
{
  private long[] a = new long[0];
  private long[] b = new long[0];
  private int c;
  private int d;
  private int e;
  private boolean f;
  private double g = 0.75D;
  
  public LongLongScatterMap()
  {
    this(0, 1, null);
  }
  
  public LongLongScatterMap(int paramInt)
  {
    b(paramInt);
  }
  
  private final void a(int paramInt, long paramLong1, long paramLong2)
  {
    long[] arrayOfLong1 = this.a;
    long[] arrayOfLong2 = this.b;
    c(HPPC.a.a(this.d + 1, d(), this.g));
    arrayOfLong1[paramInt] = paramLong1;
    arrayOfLong2[paramInt] = paramLong2;
    a(arrayOfLong1, arrayOfLong2);
  }
  
  private final void a(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong1 = this.a;
    long[] arrayOfLong2 = this.b;
    int k = this.d;
    int i = paramArrayOfLong1.length - 1;
    arrayOfLong1[(arrayOfLong1.length - 1)] = paramArrayOfLong1[i];
    arrayOfLong2[(arrayOfLong2.length - 1)] = paramArrayOfLong2[i];
    for (;;)
    {
      int j = i - 1;
      if (j < 0) {
        break;
      }
      long l = paramArrayOfLong1[j];
      i = j;
      if (l != 0L)
      {
        i = c(l);
        for (;;)
        {
          i &= k;
          if (arrayOfLong1[i] == 0L) {
            break;
          }
          i += 1;
        }
        arrayOfLong1[i] = l;
        arrayOfLong2[i] = paramArrayOfLong2[j];
        i = j;
      }
    }
  }
  
  private final int c(long paramLong)
  {
    return HPPC.a.a(paramLong);
  }
  
  private final void c(int paramInt)
  {
    Object localObject1 = this.a;
    Object localObject2 = this.b;
    int i = paramInt + 1;
    try
    {
      this.a = new long[i];
      this.b = new long[i];
      this.e = HPPC.a.b(paramInt, this.g);
      this.d = (paramInt - 1);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.a = ((long[])localObject1);
      this.b = ((long[])localObject2);
      localObject1 = StringCompanionObject.INSTANCE;
      localObject1 = Locale.ROOT;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "Locale.ROOT");
      localObject2 = new Object[2];
      localObject2[0] = Integer.valueOf(this.d + 1);
      localObject2[1] = Integer.valueOf(paramInt);
      localObject1 = String.format((Locale)localObject1, "Not enough memory to allocate buffers for rehashing: %,d -> %,d", Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(locale, format, *args)");
      throw ((Throwable)new RuntimeException((String)localObject1, (Throwable)localOutOfMemoryError));
    }
  }
  
  public final int a(long paramLong)
  {
    int i = -1;
    if (paramLong == 0L)
    {
      if (this.f) {
        i = this.d + 1;
      }
      return i;
    }
    long[] arrayOfLong = this.a;
    int j = this.d;
    i = c(paramLong) & j;
    for (long l = arrayOfLong[i]; l != 0L; l = arrayOfLong[i])
    {
      if (l == paramLong) {
        return i;
      }
      i = i + 1 & j;
    }
    return -1;
  }
  
  public final long a(int paramInt)
  {
    return this.b[paramInt];
  }
  
  public final long a(long paramLong1, long paramLong2)
  {
    int j = this.d;
    if (paramLong1 == 0L)
    {
      this.f = true;
      arrayOfLong = this.b;
      i = j + 1;
      paramLong1 = arrayOfLong[i];
      arrayOfLong[i] = paramLong2;
      return paramLong1;
    }
    long[] arrayOfLong = this.a;
    int i = c(paramLong1) & j;
    for (long l = arrayOfLong[i]; l != 0L; l = arrayOfLong[i])
    {
      if (l == paramLong1)
      {
        arrayOfLong = this.b;
        paramLong1 = arrayOfLong[i];
        arrayOfLong[i] = paramLong2;
        return paramLong1;
      }
      i = i + 1 & j;
    }
    if (this.c == this.e)
    {
      a(i, paramLong1, paramLong2);
    }
    else
    {
      arrayOfLong[i] = paramLong1;
      this.b[i] = paramLong2;
    }
    this.c += 1;
    return 0L;
  }
  
  public final void a(@NotNull LongLongScatterMap.ForEachCallback paramForEachCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramForEachCallback, "forEachCallback");
    int k = this.d + 1;
    int i = -1;
    for (;;)
    {
      int j = i;
      if (i < k)
      {
        j = i;
        long l;
        do
        {
          i = j + 1;
          j = i;
          if (i >= k) {
            break;
          }
          l = this.a[i];
          j = i;
        } while (l == 0L);
        paramForEachCallback.a(l, this.b[i]);
      }
      else
      {
        if ((j != k) || (!this.f)) {
          break;
        }
        i = j + 1;
        paramForEachCallback.a(0L, this.b[k]);
      }
    }
  }
  
  public final boolean a()
  {
    return d() == 0;
  }
  
  public final long b(long paramLong)
  {
    int j = a(paramLong);
    int i;
    if (j != -1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return a(j);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unknown key ");
    localStringBuilder.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString().toString()));
  }
  
  @NotNull
  public final Sequence<LongLongPair> b()
  {
    int i = this.d;
    Ref.IntRef localIntRef = new Ref.IntRef();
    localIntRef.element = -1;
    return SequencesKt.generateSequence((Function0)new LongLongScatterMap.entrySequence.1(this, localIntRef, i + 1));
  }
  
  public final void b(int paramInt)
  {
    if (paramInt > this.e)
    {
      long[] arrayOfLong1 = this.a;
      long[] arrayOfLong2 = this.b;
      c(HPPC.a.a(paramInt, this.g));
      if (!a()) {
        a(arrayOfLong1, arrayOfLong2);
      }
    }
  }
  
  public final void c()
  {
    this.c = 0;
    this.f = false;
    c(HPPC.a.a(4, this.g));
  }
  
  public final int d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.hppc.LongLongScatterMap
 * JD-Core Version:    0.7.0.1
 */