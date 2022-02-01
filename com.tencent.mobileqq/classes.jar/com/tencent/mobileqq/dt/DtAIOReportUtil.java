package com.tencent.mobileqq.dt;

import android.util.SparseArray;

public class DtAIOReportUtil
{
  private static final SparseArray<String> a = new SparseArray();
  
  static
  {
    a.put(5, "em_aio_shoot_button");
    a.put(6, "em_aio_shoot_button");
    a.put(16, "em_aio_files_button");
    a.put(17, "em_aio_computer_button");
  }
  
  public static int a(String paramString)
  {
    int i = 0;
    int k;
    for (int j = 0; i < paramString.length(); j = k)
    {
      k = j;
      if (20 == paramString.codePointAt(i)) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public static String a(int paramInt)
  {
    return (String)a.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dt.DtAIOReportUtil
 * JD-Core Version:    0.7.0.1
 */