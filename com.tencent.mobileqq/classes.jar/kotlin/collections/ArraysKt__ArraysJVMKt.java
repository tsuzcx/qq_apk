package kotlin.collections;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"arrayOfNulls", "", "T", "reference", "size", "", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "copyOfRangeToIndexCheck", "", "toIndex", "contentDeepHashCodeImpl", "contentDeepHashCode", "([Ljava/lang/Object;)I", "orEmpty", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "", "charset", "Ljava/nio/charset/Charset;", "toTypedArray", "", "(Ljava/util/Collection;)[Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/ArraysKt")
class ArraysKt__ArraysJVMKt
{
  @NotNull
  public static final <T> T[] arrayOfNulls(@NotNull T[] paramArrayOfT, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "reference");
    paramArrayOfT = Array.newInstance(paramArrayOfT.getClass().getComponentType(), paramInt);
    if (paramArrayOfT != null) {
      return (Object[])paramArrayOfT;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @JvmName(name="contentDeepHashCode")
  public static final <T> int contentDeepHashCode(@NotNull T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$contentDeepHashCodeImpl");
    return Arrays.deepHashCode(paramArrayOfT);
  }
  
  @SinceKotlin(version="1.3")
  public static final void copyOfRangeToIndexCheck(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("toIndex (");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(") is greater than size (");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(").");
    throw ((Throwable)new IndexOutOfBoundsException(localStringBuilder.toString()));
  }
  
  @InlineOnly
  private static final String toString(@NotNull byte[] paramArrayOfByte, Charset paramCharset)
  {
    return new String(paramArrayOfByte, paramCharset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.ArraysKt__ArraysJVMKt
 * JD-Core Version:    0.7.0.1
 */