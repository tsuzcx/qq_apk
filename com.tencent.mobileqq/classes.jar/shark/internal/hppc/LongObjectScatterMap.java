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
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/hppc/LongObjectScatterMap;", "T", "", "()V", "assigned", "", "hasEmptyKey", "", "isEmpty", "()Z", "keys", "", "loadFactor", "", "mask", "resizeAt", "size", "getSize", "()I", "values", "", "getValues$annotations", "[Ljava/lang/Object;", "allocateBuffers", "", "arraySize", "allocateThenInsertThenRehash", "slot", "pendingKey", "", "pendingValue", "(IJLjava/lang/Object;)V", "containsKey", "key", "ensureCapacity", "expectedElements", "entrySequence", "Lkotlin/sequences/Sequence;", "Lshark/internal/hppc/LongObjectPair;", "get", "(J)Ljava/lang/Object;", "hashKey", "rehash", "fromKeys", "fromValues", "([J[Ljava/lang/Object;)V", "release", "remove", "set", "value", "(JLjava/lang/Object;)Ljava/lang/Object;", "shiftConflictingKeys", "gapSlotArg", "shark-graph"}, k=1, mv={1, 4, 1})
public final class LongObjectScatterMap<T>
{
  private long[] a = new long[0];
  private T[] b = new Object[0];
  private int c;
  private int d;
  private int e;
  private boolean f;
  private double g = 0.75D;
  
  public LongObjectScatterMap()
  {
    a(4);
  }
  
  private final void a(int paramInt, long paramLong, T paramT)
  {
    long[] arrayOfLong = this.a;
    Object[] arrayOfObject = this.b;
    b(HPPC.a.a(this.d + 1, c(), this.g));
    arrayOfLong[paramInt] = paramLong;
    arrayOfObject[paramInt] = paramT;
    a(arrayOfLong, arrayOfObject);
  }
  
  private final void a(long[] paramArrayOfLong, T[] paramArrayOfT)
  {
    long[] arrayOfLong = this.a;
    Object[] arrayOfObject = this.b;
    int k = this.d;
    int i = paramArrayOfLong.length - 1;
    arrayOfLong[(arrayOfLong.length - 1)] = paramArrayOfLong[i];
    arrayOfObject[(arrayOfObject.length - 1)] = paramArrayOfT[i];
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
        i = b(l);
        for (;;)
        {
          i &= k;
          if (arrayOfLong[i] == 0L) {
            break;
          }
          i += 1;
        }
        arrayOfLong[i] = l;
        arrayOfObject[i] = paramArrayOfT[j];
        i = j;
      }
    }
  }
  
  private final int b(long paramLong)
  {
    return HPPC.a.a(paramLong);
  }
  
  private final void b(int paramInt)
  {
    Object localObject = this.a;
    Object[] arrayOfObject = this.b;
    int i = paramInt + 1;
    try
    {
      this.a = new long[i];
      this.b = new Object[i];
      this.e = HPPC.a.b(paramInt, this.g);
      this.d = (paramInt - 1);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      this.a = ((long[])localObject);
      this.b = arrayOfObject;
      localObject = StringCompanionObject.INSTANCE;
      localObject = Locale.ROOT;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.ROOT");
      arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.d + 1);
      arrayOfObject[1] = Integer.valueOf(paramInt);
      localObject = String.format((Locale)localObject, "Not enough memory to allocate buffers for rehashing: %,d -> %,d", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(locale, format, *args)");
      throw ((Throwable)new RuntimeException((String)localObject, (Throwable)localOutOfMemoryError));
    }
  }
  
  @Nullable
  public final T a(long paramLong)
  {
    Object localObject = null;
    if (paramLong == 0L)
    {
      if (this.f) {
        localObject = this.b[(this.d + 1)];
      }
      return localObject;
    }
    localObject = this.a;
    int j = this.d;
    int i = b(paramLong) & j;
    for (long l = localObject[i]; l != 0L; l = localObject[i])
    {
      if (l == paramLong) {
        return this.b[i];
      }
      i = i + 1 & j;
    }
    return null;
  }
  
  @Nullable
  public final T a(long paramLong, T paramT)
  {
    int j = this.d;
    T ?;
    if (paramLong == 0L)
    {
      this.f = true;
      localObject = this.b;
      i = j + 1;
      ? = localObject[i];
      localObject[i] = paramT;
      return ?;
    }
    Object localObject = this.a;
    int i = b(paramLong) & j;
    for (long l = localObject[i]; l != 0L; l = localObject[i])
    {
      if (l == paramLong)
      {
        localObject = this.b;
        ? = localObject[i];
        localObject[i] = paramT;
        return ?;
      }
      i = i + 1 & j;
    }
    if (this.c == this.e)
    {
      a(i, paramLong, paramT);
    }
    else
    {
      localObject[i] = paramLong;
      this.b[i] = paramT;
    }
    this.c += 1;
    return null;
  }
  
  public final void a(int paramInt)
  {
    if (paramInt > this.e)
    {
      long[] arrayOfLong = this.a;
      Object[] arrayOfObject = this.b;
      b(HPPC.a.a(paramInt, this.g));
      if (!a()) {
        a(arrayOfLong, arrayOfObject);
      }
    }
  }
  
  public final boolean a()
  {
    return c() == 0;
  }
  
  @NotNull
  public final Sequence<LongObjectPair<T>> b()
  {
    int i = this.d;
    Ref.IntRef localIntRef = new Ref.IntRef();
    localIntRef.element = -1;
    return SequencesKt.generateSequence((Function0)new LongObjectScatterMap.entrySequence.1(this, localIntRef, i + 1));
  }
  
  public final int c()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:632)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.hppc.LongObjectScatterMap
 * JD-Core Version:    0.7.0.1
 */