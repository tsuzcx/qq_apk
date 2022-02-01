package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;

public class RIJViolaSusAutoPlayConfigSp
{
  public static int a()
  {
    int i = ((Integer)RIJSPUtils.a("viola_sus_video_auto_play", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getViolaSusAutoPlayConfig result=");
      localStringBuilder.append(i);
      QLog.d("ReadInJoyLog", 1, localStringBuilder.toString());
    }
    return i;
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateViolaSusAutoPlayConfig value=");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyLog", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("viola_sus_video_auto_play", Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJViolaSusAutoPlayConfigSp
 * JD-Core Version:    0.7.0.1
 */