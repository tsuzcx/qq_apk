package com.tencent.tkd.weibo.utils;

import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/weibo/utils/FormatUtils;", "", "()V", "getFormatNum", "", "num", "", "tkd-weibo-component_release"}, k=1, mv={1, 1, 16})
public final class FormatUtils
{
  public static final FormatUtils a = new FormatUtils();
  
  @NotNull
  public final String a(long paramLong)
  {
    if (paramLong != 0L)
    {
      Object localObject = new StringBuilder();
      if (paramLong > 99990000) {
        ((StringBuilder)localObject).append("9999万+");
      }
      for (;;)
      {
        localObject = ((StringBuilder)localObject).toString();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "sb.toString()");
        return localObject;
        if (paramLong > 10000)
        {
          double d = paramLong / 10000.0D;
          ((StringBuilder)localObject).append(new DecimalFormat("0.0").format(d));
          ((StringBuilder)localObject).append("万");
        }
        else
        {
          ((StringBuilder)localObject).append(paramLong);
        }
      }
    }
    return "0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.weibo.utils.FormatUtils
 * JD-Core Version:    0.7.0.1
 */