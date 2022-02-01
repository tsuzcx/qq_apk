package shark.internal.hppc;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/internal/hppc/HPPC;", "", "()V", "MAX_HASH_ARRAY_LENGTH", "", "MIN_HASH_ARRAY_LENGTH", "PHI_C64", "", "expandAtCount", "arraySize", "loadFactor", "", "minBufferSize", "elements", "mixPhi", "k", "nextBufferSize", "nextHighestPowerOfTwo", "input", "shark-graph"}, k=1, mv={1, 4, 1})
public final class HPPC
{
  @NotNull
  public static final HPPC a = new HPPC();
  
  public final int a(int paramInt, double paramDouble)
  {
    double d = paramInt;
    Double.isNaN(d);
    long l2 = Math.ceil(d / paramDouble);
    long l1 = l2;
    if (l2 == paramInt) {
      l1 = l2 + 1L;
    }
    l1 = Math.max(4, b(l1));
    if (l1 <= 1073741824) {
      return (int)l1;
    }
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = Locale.ROOT;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.ROOT");
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    arrayOfObject[1] = Double.valueOf(paramDouble);
    localObject = String.format((Locale)localObject, "Maximum array size exceeded for this load factor (elements: %d, load factor: %f)", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(locale, format, *args)");
    throw ((Throwable)new RuntimeException((String)localObject));
  }
  
  public final int a(int paramInt1, int paramInt2, double paramDouble)
  {
    if (paramInt1 != 1073741824) {
      return paramInt1 << 1;
    }
    Object localObject = StringCompanionObject.INSTANCE;
    localObject = Locale.ROOT;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.ROOT");
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt2);
    arrayOfObject[1] = Double.valueOf(paramDouble);
    localObject = String.format((Locale)localObject, "Maximum array size exceeded for this load factor (elements: %d, load factor: %f)", Arrays.copyOf(arrayOfObject, arrayOfObject.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(locale, format, *args)");
    throw ((Throwable)new RuntimeException((String)localObject));
  }
  
  public final int a(long paramLong)
  {
    paramLong *= -7046029254386353131L;
    return (int)(paramLong ^ paramLong >>> 32);
  }
  
  public final int b(int paramInt, double paramDouble)
  {
    double d = paramInt;
    Double.isNaN(d);
    return Math.min(paramInt - 1, (int)Math.ceil(d * paramDouble));
  }
  
  public final long b(long paramLong)
  {
    paramLong -= 1L;
    paramLong |= paramLong >> 1;
    paramLong |= paramLong >> 2;
    paramLong |= paramLong >> 4;
    paramLong |= paramLong >> 8;
    paramLong |= paramLong >> 16;
    return (paramLong | paramLong >> 32) + 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.hppc.HPPC
 * JD-Core Version:    0.7.0.1
 */