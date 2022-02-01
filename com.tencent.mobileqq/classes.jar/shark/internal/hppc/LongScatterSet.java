package shark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/hppc/LongScatterSet;", "", "expectedElements", "", "(I)V", "assigned", "hasEmptyKey", "", "keys", "", "loadFactor", "", "mask", "resizeAt", "add", "key", "", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "contains", "ensureCapacity", "hashKey", "plusAssign", "rehash", "fromKeys", "release", "remove", "shiftConflictingKeys", "inputGapSlot", "size", "shark-graph"}, k=1, mv={1, 4, 1})
public final class LongScatterSet
{
  private long[] a = new long[0];
  private int b;
  private int c;
  private int d;
  private boolean e;
  private final double f = 0.75D;
  
  public LongScatterSet()
  {
    this(0, 1, null);
  }
  
  public LongScatterSet(int paramInt)
  {
    a(paramInt);
  }
  
  private final void a(int paramInt, long paramLong)
  {
    long[] arrayOfLong = this.a;
    c(HPPC.a.a(this.c + 1, a(), this.f));
    arrayOfLong[paramInt] = paramLong;
    a(arrayOfLong);
  }
  
  private final void a(long[] paramArrayOfLong)
  {
    long[] arrayOfLong = this.a;
    int k = this.c;
    int i = paramArrayOfLong.length - 1;
    for (;;)
    {
      int j = i - 1;
      if (j < 0) {
        break;
      }
      long l = paramArrayOfLong[j];
      i = j;
      if (l != 0L)
      {
        i = d(l);
        for (;;)
        {
          i &= k;
          if (arrayOfLong[i] == 0L) {
            break;
          }
          i += 1;
        }
        arrayOfLong[i] = l;
        i = j;
      }
    }
  }
  
  private final void b(int paramInt)
  {
    long[] arrayOfLong = this.a;
    int m = this.c;
    for (;;)
    {
      int i = 0;
      int j;
      int k;
      long l;
      do
      {
        j = i + 1;
        k = paramInt + j & m;
        l = arrayOfLong[k];
        if (l == 0L)
        {
          arrayOfLong[paramInt] = 0L;
          this.b -= 1;
          return;
        }
        i = j;
      } while ((k - d(l) & m) < j);
      arrayOfLong[paramInt] = l;
      paramInt = k;
    }
  }
  
  private final void c(int paramInt)
  {
    Object localObject = this.a;
    try
    {
      this.a = new long[paramInt + 1];
      this.d = HPPC.a.b(paramInt, this.f);
      this.c = (paramInt - 1);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.a = ((long[])localObject);
      localObject = StringCompanionObject.INSTANCE;
      localObject = Locale.ROOT;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.ROOT");
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(a());
      arrayOfObject[1] = Integer.valueOf(paramInt);
      localObject = String.format((Locale)localObject, "Not enough memory to allocate buffers for rehashing: %,d -> %,d", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(locale, format, *args)");
      throw ((Throwable)new RuntimeException((String)localObject, (Throwable)localOutOfMemoryError));
    }
  }
  
  private final int d(long paramLong)
  {
    return HPPC.a.a(paramLong);
  }
  
  public final int a()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > this.d)
    {
      long[] arrayOfLong = this.a;
      c(HPPC.a.a(paramInt, this.f));
      if (a() != 0) {
        a(arrayOfLong);
      }
    }
  }
  
  public final boolean a(long paramLong)
  {
    if (paramLong == 0L)
    {
      boolean bool = this.e;
      this.e = true;
      return bool ^ true;
    }
    long[] arrayOfLong = this.a;
    int j = this.c;
    int i = d(paramLong) & j;
    for (long l = arrayOfLong[i]; l != 0L; l = arrayOfLong[i])
    {
      if (l == paramLong) {
        return false;
      }
      i = i + 1 & j;
    }
    if (this.b == this.d) {
      a(i, paramLong);
    } else {
      arrayOfLong[i] = paramLong;
    }
    this.b += 1;
    return true;
  }
  
  public final boolean b(long paramLong)
  {
    if (paramLong == 0L) {
      return this.e;
    }
    long[] arrayOfLong = this.a;
    int j = this.c;
    int i = d(paramLong) & j;
    for (long l = arrayOfLong[i]; l != 0L; l = arrayOfLong[i])
    {
      if (l == paramLong) {
        return true;
      }
      i = i + 1 & j;
    }
    return false;
  }
  
  public final boolean c(long paramLong)
  {
    if (paramLong == 0L)
    {
      boolean bool = this.e;
      this.e = false;
      return bool;
    }
    long[] arrayOfLong = this.a;
    int j = this.c;
    int i = d(paramLong) & j;
    for (long l = arrayOfLong[i]; l != 0L; l = arrayOfLong[i])
    {
      if (l == paramLong)
      {
        b(i);
        return true;
      }
      i = i + 1 & j;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.hppc.LongScatterSet
 * JD-Core Version:    0.7.0.1
 */