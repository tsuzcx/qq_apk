package com.tencent.mobileqq.kandian.repo.video;

import com.tencent.mobileqq.app.HardCodeUtil;
import java.text.DecimalFormat;

public class VideoFeedsUtil
{
  private static DecimalFormat a;
  
  public static String a(int paramInt)
  {
    return b(paramInt);
  }
  
  public static String b(int paramInt)
  {
    if (a == null) {
      a = new DecimalFormat("###.#");
    }
    Object localObject = "";
    DecimalFormat localDecimalFormat;
    double d;
    if (paramInt >= 100000000)
    {
      localObject = new StringBuilder();
      localDecimalFormat = a;
      d = paramInt;
      Double.isNaN(d);
      ((StringBuilder)localObject).append(localDecimalFormat.format(d / 100000000.0D));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913403));
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt >= 10000)
    {
      localObject = new StringBuilder();
      localDecimalFormat = a;
      d = paramInt;
      Double.isNaN(d);
      ((StringBuilder)localObject).append(localDecimalFormat.format(d / 10000.0D));
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913401));
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt >= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.VideoFeedsUtil
 * JD-Core Version:    0.7.0.1
 */