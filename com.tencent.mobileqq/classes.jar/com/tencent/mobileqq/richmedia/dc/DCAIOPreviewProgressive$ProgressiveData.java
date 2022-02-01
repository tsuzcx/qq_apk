package com.tencent.mobileqq.richmedia.dc;

import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DCAIOPreviewProgressive$ProgressiveData
  extends DataAdapter
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = false;
  private long c;
  
  public HashMap<String, String> a(String paramString)
  {
    long l1 = this.jdField_a_of_type_Long;
    paramString = null;
    if (l1 != 0L)
    {
      if (this.c == 0L) {
        return null;
      }
      if (QLog.isColorLevel()) {
        paramString = new StringBuilder();
      }
      HashMap localHashMap = new HashMap();
      long l2;
      StringBuilder localStringBuilder;
      if (this.jdField_a_of_type_Boolean)
      {
        localHashMap.put("is_progressive", "progressive");
        localHashMap.put("view_count", "1");
        if (this.jdField_b_of_type_Boolean)
        {
          localHashMap.put("failure", "1");
        }
        else
        {
          l1 = this.jdField_b_of_type_Long;
          l2 = this.jdField_a_of_type_Long;
          if (l1 > l2) {
            localHashMap.put("to_dp", String.valueOf(l1 - l2));
          }
          l1 = this.c;
          l2 = this.jdField_a_of_type_Long;
          if ((l1 > l2) && (l1 > this.jdField_b_of_type_Long)) {
            localHashMap.put("to_large", String.valueOf(l1 - l2));
          }
        }
        if (QLog.isColorLevel())
        {
          paramString.append("progressive:\n");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh_dp:");
          localStringBuilder.append(String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
          localStringBuilder.append("\n");
          paramString.append(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh_large:");
          localStringBuilder.append(String.valueOf(this.c - this.jdField_a_of_type_Long));
          paramString.append(localStringBuilder.toString());
          QLog.i(DataCollector.a, 2, paramString.toString());
          return localHashMap;
        }
      }
      else
      {
        localHashMap.put("is_progressive", "baseline");
        localHashMap.put("view_count", "1");
        if (this.jdField_b_of_type_Boolean)
        {
          localHashMap.put("failure", "1");
        }
        else
        {
          l1 = this.c;
          l2 = this.jdField_a_of_type_Long;
          if (l1 > l2) {
            localHashMap.put("to_large", String.valueOf(l1 - l2));
          }
        }
        if (QLog.isColorLevel())
        {
          paramString.append("baseline:\n");
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("refresh_large:");
          localStringBuilder.append(String.valueOf(this.c - this.jdField_a_of_type_Long));
          paramString.append(localStringBuilder.toString());
          QLog.i(DataCollector.a, 2, paramString.toString());
        }
      }
      return localHashMap;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive.ProgressiveData
 * JD-Core Version:    0.7.0.1
 */