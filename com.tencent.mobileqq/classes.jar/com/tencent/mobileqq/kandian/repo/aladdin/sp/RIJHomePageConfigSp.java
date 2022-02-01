package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;

public class RIJHomePageConfigSp
{
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateHomePageConfig value=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_homepage_open_viola", Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJHomePageConfigSp
 * JD-Core Version:    0.7.0.1
 */