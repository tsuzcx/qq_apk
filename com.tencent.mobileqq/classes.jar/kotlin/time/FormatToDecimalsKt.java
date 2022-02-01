package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"precisionFormats", "", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormat;", "[Ljava/lang/ThreadLocal;", "rootNegativeExpFormatSymbols", "Ljava/text/DecimalFormatSymbols;", "rootPositiveExpFormatSymbols", "scientificFormat", "createFormatForDecimals", "decimals", "", "formatScientific", "", "value", "", "formatToExactDecimals", "formatUpToDecimals", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class FormatToDecimalsKt
{
  private static final ThreadLocal<DecimalFormat>[] precisionFormats;
  private static final DecimalFormatSymbols rootNegativeExpFormatSymbols;
  private static final DecimalFormatSymbols rootPositiveExpFormatSymbols;
  private static final ThreadLocal<DecimalFormat> scientificFormat = new ThreadLocal();
  
  static
  {
    Object localObject = new DecimalFormatSymbols(Locale.ROOT);
    ((DecimalFormatSymbols)localObject).setExponentSeparator("e");
    rootNegativeExpFormatSymbols = (DecimalFormatSymbols)localObject;
    localObject = new DecimalFormatSymbols(Locale.ROOT);
    ((DecimalFormatSymbols)localObject).setExponentSeparator("e+");
    rootPositiveExpFormatSymbols = (DecimalFormatSymbols)localObject;
    localObject = new ThreadLocal[4];
    int i = 0;
    while (i < 4)
    {
      localObject[i] = new ThreadLocal();
      i += 1;
    }
    precisionFormats = (ThreadLocal[])localObject;
  }
  
  private static final DecimalFormat createFormatForDecimals(int paramInt)
  {
    DecimalFormat localDecimalFormat = new DecimalFormat("0", rootNegativeExpFormatSymbols);
    if (paramInt > 0) {
      localDecimalFormat.setMinimumFractionDigits(paramInt);
    }
    localDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    return localDecimalFormat;
  }
  
  @NotNull
  public static final String formatScientific(double paramDouble)
  {
    Object localObject2 = scientificFormat;
    Object localObject1 = ((ThreadLocal)localObject2).get();
    DecimalFormat localDecimalFormat;
    if (localObject1 != null)
    {
      localDecimalFormat = (DecimalFormat)localObject1;
      if ((paramDouble < 1) && (paramDouble > -1)) {
        break label86;
      }
    }
    label86:
    for (localObject2 = rootPositiveExpFormatSymbols;; localObject2 = rootNegativeExpFormatSymbols)
    {
      localDecimalFormat.setDecimalFormatSymbols((DecimalFormatSymbols)localObject2);
      localObject1 = ((DecimalFormat)localObject1).format(paramDouble);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "scientificFormat.getOrSe… }\n        .format(value)");
      return localObject1;
      localObject1 = new DecimalFormat("0E0", rootNegativeExpFormatSymbols);
      ((DecimalFormat)localObject1).setMinimumFractionDigits(2);
      ((ThreadLocal)localObject2).set(localObject1);
      break;
    }
  }
  
  @NotNull
  public static final String formatToExactDecimals(double paramDouble, int paramInt)
  {
    ThreadLocal localThreadLocal;
    if (paramInt < precisionFormats.length)
    {
      localThreadLocal = precisionFormats[paramInt];
      localObject = localThreadLocal.get();
      if (localObject == null) {}
    }
    for (Object localObject = (DecimalFormat)localObject;; localObject = createFormatForDecimals(paramInt))
    {
      localObject = ((DecimalFormat)localObject).format(paramDouble);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "format.format(value)");
      return localObject;
      localObject = createFormatForDecimals(paramInt);
      localThreadLocal.set(localObject);
      break;
    }
  }
  
  @NotNull
  public static final String formatUpToDecimals(double paramDouble, int paramInt)
  {
    Object localObject = createFormatForDecimals(0);
    ((DecimalFormat)localObject).setMaximumFractionDigits(paramInt);
    localObject = ((DecimalFormat)localObject).format(paramDouble);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "createFormatForDecimals(… }\n        .format(value)");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.time.FormatToDecimalsKt
 * JD-Core Version:    0.7.0.1
 */