package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;

public class RIJVideoSdkConfigSp
{
  public static int a()
  {
    int i = ((Integer)RIJSPUtils.b("readinjoy_preplay_time_limit", Integer.valueOf(6))).intValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPreplayTimeLimit result=");
      localStringBuilder.append(i);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    return i;
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updatePreplayTimeLimit value=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_preplay_time_limit", Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoSdkConfigSp
 * JD-Core Version:    0.7.0.1
 */