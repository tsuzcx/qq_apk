package com.tencent.mobileqq.kandian.base.video.player;

import com.tencent.mobileqq.app.HardCodeUtil;

public class ErrorCode
{
  public static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 1;
    if (paramInt2 == 1300080) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    int i;
    if (paramInt1 == 202)
    {
      i = j;
      if (paramInt2 == 108) {}
    }
    else if (paramInt2 == 1300062)
    {
      i = j;
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131718106));
      localStringBuilder.append(" (");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    if (paramInt1 == 4000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131715987));
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    if (paramInt3 != 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131715918));
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("-");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131715944));
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.ErrorCode
 * JD-Core Version:    0.7.0.1
 */