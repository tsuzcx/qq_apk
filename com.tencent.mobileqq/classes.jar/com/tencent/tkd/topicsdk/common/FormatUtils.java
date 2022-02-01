package com.tencent.tkd.topicsdk.common;

import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/FormatUtils;", "", "()V", "getFormatFileSize", "", "sizeInByte", "", "getFormatNum", "num", "getFormatNumToBillion", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class FormatUtils
{
  public static final FormatUtils a = new FormatUtils();
  
  @NotNull
  public final String a(long paramLong)
  {
    if (paramLong != 0L)
    {
      Object localObject = new StringBuilder();
      long l = 100000000;
      if (paramLong > l)
      {
        paramLong /= l;
        ((StringBuilder)localObject).append(new DecimalFormat("0.0").format(paramLong));
        ((StringBuilder)localObject).append("亿");
      }
      else if (paramLong > 10000)
      {
        double d = paramLong;
        Double.isNaN(d);
        d /= 10000.0D;
        ((StringBuilder)localObject).append(new DecimalFormat("0.0").format(d));
        ((StringBuilder)localObject).append("万");
      }
      else
      {
        ((StringBuilder)localObject).append(paramLong);
      }
      localObject = ((StringBuilder)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "sb.toString()");
      return localObject;
    }
    return "0";
  }
  
  @NotNull
  public final String b(long paramLong)
  {
    if (paramLong <= 0L) {
      return "0B";
    }
    DecimalFormat localDecimalFormat;
    double d2;
    double d1;
    if (paramLong >= 1073741824)
    {
      localStringBuilder = new StringBuilder();
      localDecimalFormat = new DecimalFormat("0.0");
      d2 = paramLong;
      d1 = 1024;
      Double.isNaN(d2);
      Double.isNaN(d1);
      d2 /= d1;
      Double.isNaN(d1);
      d2 /= d1;
      Double.isNaN(d1);
      localStringBuilder.append(localDecimalFormat.format(d2 / d1));
      localStringBuilder.append("GB");
      return localStringBuilder.toString();
    }
    if (paramLong >= 1048576)
    {
      localStringBuilder = new StringBuilder();
      localDecimalFormat = new DecimalFormat("0.0");
      d2 = paramLong;
      d1 = 1024;
      Double.isNaN(d2);
      Double.isNaN(d1);
      d2 /= d1;
      Double.isNaN(d1);
      localStringBuilder.append(localDecimalFormat.format(d2 / d1));
      localStringBuilder.append("MB");
      return localStringBuilder.toString();
    }
    if (paramLong >= 1024)
    {
      localStringBuilder = new StringBuilder();
      localDecimalFormat = new DecimalFormat("0.0");
      d1 = paramLong;
      d2 = 1024;
      Double.isNaN(d1);
      Double.isNaN(d2);
      localStringBuilder.append(localDecimalFormat.format(d1 / d2));
      localStringBuilder.append("KB");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append('B');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.FormatUtils
 * JD-Core Version:    0.7.0.1
 */