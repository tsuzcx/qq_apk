package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"boxBoolean", "Ljava/lang/Boolean;", "primitive", "", "boxByte", "Ljava/lang/Byte;", "", "boxChar", "Ljava/lang/Character;", "", "boxDouble", "Ljava/lang/Double;", "", "boxFloat", "Ljava/lang/Float;", "", "boxInt", "Ljava/lang/Integer;", "", "boxLong", "Ljava/lang/Long;", "", "boxShort", "Ljava/lang/Short;", "", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="Boxing")
public final class Boxing
{
  @PublishedApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Boolean boxBoolean(boolean paramBoolean)
  {
    return Boolean.valueOf(paramBoolean);
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Byte boxByte(byte paramByte)
  {
    return Byte.valueOf(paramByte);
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Character boxChar(char paramChar)
  {
    return new Character(paramChar);
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Double boxDouble(double paramDouble)
  {
    return new Double(paramDouble);
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Float boxFloat(float paramFloat)
  {
    return new Float(paramFloat);
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Integer boxInt(int paramInt)
  {
    return new Integer(paramInt);
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Long boxLong(long paramLong)
  {
    return new Long(paramLong);
  }
  
  @PublishedApi
  @SinceKotlin(version="1.3")
  @NotNull
  public static final Short boxShort(short paramShort)
  {
    return new Short(paramShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.coroutines.jvm.internal.Boxing
 * JD-Core Version:    0.7.0.1
 */