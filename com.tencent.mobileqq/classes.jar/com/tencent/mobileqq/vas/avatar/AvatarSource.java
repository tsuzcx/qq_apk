package com.tencent.mobileqq.vas.avatar;

import com.tencent.qphone.base.util.QLog;

public class AvatarSource
{
  public static int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DynamicFaceDrawable don't have ");
      localStringBuilder.append(paramInt);
      QLog.e("Q.qqhead.VasFaceManager", 1, "unknown DynamicSource", new RuntimeException(localStringBuilder.toString()));
      i = 7;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.avatar.AvatarSource
 * JD-Core Version:    0.7.0.1
 */