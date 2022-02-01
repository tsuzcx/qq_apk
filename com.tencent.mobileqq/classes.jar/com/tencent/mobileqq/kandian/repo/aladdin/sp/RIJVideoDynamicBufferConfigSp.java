package com.tencent.mobileqq.kandian.repo.aladdin.sp;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.QLog;

public class RIJVideoDynamicBufferConfigSp
{
  public static int a()
  {
    int i = ((Integer)RIJSPUtils.a("readinjoy_dynamic_buffer_switch", Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDynamicBufferSwitch result=");
      localStringBuilder.append(i);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    return i;
  }
  
  public static String a()
  {
    String str = (String)RIJSPUtils.a("readinjoy_dynamic_buffer_config", "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDynamicBufferConfig result=");
      localStringBuilder.append(str);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    return str;
  }
  
  public static void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateDynamicBufferSwitch value=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_dynamic_buffer_switch", Integer.valueOf(paramInt));
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateDynamicBufferConfig value=");
      localStringBuilder.append(paramString);
      QLog.d("Q.readinjoy.tt_report", 1, localStringBuilder.toString());
    }
    RIJSPUtils.a("readinjoy_dynamic_buffer_config", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoDynamicBufferConfigSp
 * JD-Core Version:    0.7.0.1
 */