package com.tencent.mobileqq.statistics.natmem;

import android.text.format.DateFormat;
import android.util.SparseArray;

public class NativeMemoryInfo
{
  public int a;
  public final NativeMemoryInfo.BackTrace a;
  public String a;
  public String b;
  
  private String a()
  {
    try
    {
      String str = DateFormat.format("yyyy-MM-dd hh:mm:ss", Double.parseDouble(this.jdField_a_of_type_JavaLangString)).toString();
      return str;
    }
    catch (Exception localException)
    {
      NativeMemoryUtils.a("NatMem", localException.toString());
    }
    return "";
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNativeMemoryInfo$BackTrace.jdField_a_of_type_Boolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNativeMemoryInfo$BackTrace.jdField_a_of_type_Boolean) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof NativeMemoryInfo)) {
      return false;
    }
    paramObject = (NativeMemoryInfo)paramObject;
    if (this.jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNativeMemoryInfo$BackTrace.jdField_a_of_type_AndroidUtilSparseArray.size() == paramObject.jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNativeMemoryInfo$BackTrace.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNativeMemoryInfo$BackTrace.jdField_a_of_type_AndroidUtilSparseArray.size();
      int i = 0;
      while (i < j)
      {
        int k = this.jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNativeMemoryInfo$BackTrace.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        NativeMemoryInfo.BackTraceLine localBackTraceLine1 = (NativeMemoryInfo.BackTraceLine)this.jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNativeMemoryInfo$BackTrace.jdField_a_of_type_AndroidUtilSparseArray.get(k);
        NativeMemoryInfo.BackTraceLine localBackTraceLine2 = (NativeMemoryInfo.BackTraceLine)paramObject.jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNativeMemoryInfo$BackTrace.jdField_a_of_type_AndroidUtilSparseArray.get(k);
        if ((localBackTraceLine1 == null) || (!localBackTraceLine1.equals(localBackTraceLine2))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("create time:").append(a());
    localStringBuilder.append(" address:").append(this.b);
    localStringBuilder.append(" size:").append(this.jdField_a_of_type_Int).append("\n");
    localStringBuilder.append("trace:").append(this.jdField_a_of_type_ComTencentMobileqqStatisticsNatmemNativeMemoryInfo$BackTrace.jdField_a_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.natmem.NativeMemoryInfo
 * JD-Core Version:    0.7.0.1
 */