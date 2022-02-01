package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NumberWithRadix
{
  @NotNull
  private final String number;
  private final int radix;
  
  public NumberWithRadix(@NotNull String paramString, int paramInt)
  {
    this.number = paramString;
    this.radix = paramInt;
  }
  
  @NotNull
  public final String component1()
  {
    return this.number;
  }
  
  public final int component2()
  {
    return this.radix;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof NumberWithRadix))
      {
        paramObject = (NumberWithRadix)paramObject;
        if ((Intrinsics.areEqual(this.number, paramObject.number)) && (this.radix == paramObject.radix)) {}
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
    String str = this.number;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i * 31 + this.radix;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NumberWithRadix(number=");
    localStringBuilder.append(this.number);
    localStringBuilder.append(", radix=");
    localStringBuilder.append(this.radix);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.NumberWithRadix
 * JD-Core Version:    0.7.0.1
 */