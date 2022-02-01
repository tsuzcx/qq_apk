package com.tencent.mobileqq.monitor;

import com.tencent.qphone.base.util.QLog;

public class CaptureFreqMonitor
{
  public static CaptureFreqMonitorItem a;
  public static String a = "AutoMonitor_Camera";
  public static boolean a = false;
  public static CaptureFreqMonitorItem b;
  public static boolean b;
  public static CaptureFreqMonitorItem c = new CaptureFreqMonitorItem(5);
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem = new CaptureFreqMonitorItem();
    jdField_b_of_type_Boolean = true;
    jdField_b_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem = new CaptureFreqMonitorItem(3);
  }
  
  public static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    if ((paramInt2 != 0) && (paramArrayOfInt != null))
    {
      if (paramInt2 > paramArrayOfInt.length) {
        return 0;
      }
      long l = 0L;
      int i = paramInt1;
      while (i < paramInt2)
      {
        l += paramArrayOfInt[i];
        i += 1;
      }
      paramInt1 = paramInt2 - paramInt1;
      if (paramInt1 == 0) {
        return 0;
      }
      return (int)(l / paramInt1);
    }
    return 0;
  }
  
  public static String a(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramInt != 0) && (paramArrayOfInt != null) && (paramInt <= paramArrayOfInt.length))
    {
      int i = paramInt - 1;
      if (i == -1) {
        return "[]";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('[');
      paramInt = 0;
      for (;;)
      {
        localStringBuilder.append(paramArrayOfInt[paramInt]);
        if (paramInt == i)
        {
          localStringBuilder.append(']');
          return localStringBuilder.toString();
        }
        localStringBuilder.append(", ");
        paramInt += 1;
      }
    }
    return "";
  }
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.a())
    {
      jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_b_of_type_Long = System.currentTimeMillis();
      long l = jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_b_of_type_Long - jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_a_of_type_Long;
      QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("CameraEditStatistic, avgRenderCost=%d, cost=%d, frameCount=%d, frameFreq=%d", new Object[] { Integer.valueOf(a(jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_a_of_type_ArrayOfInt, 0, jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_b_of_type_Int)), Long.valueOf(l), Integer.valueOf(jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_b_of_type_Int), Long.valueOf(jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_b_of_type_Int * 1000 / l) }));
      QLog.d(jdField_a_of_type_JavaLangString, 1, String.format("CameraEditStatistic, render cost: %s", new Object[] { a(jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_a_of_type_ArrayOfInt, jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.jdField_b_of_type_Int) }));
      jdField_a_of_type_ComTencentMobileqqMonitorCaptureFreqMonitorItem.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.monitor.CaptureFreqMonitor
 * JD-Core Version:    0.7.0.1
 */