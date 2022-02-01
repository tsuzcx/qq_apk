package com.tencent.mobileqq.uniformdownload.util;

import android.util.SparseArray;
import com.tencent.mobileqq.app.HardCodeUtil;

public class UDConstants
{
  private static SparseArray<String> a;
  
  public static String a(int paramInt)
  {
    a();
    SparseArray localSparseArray = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append("]");
    return (String)localSparseArray.get(paramInt, localStringBuilder.toString());
  }
  
  private static void a()
  {
    if (a != null) {
      return;
    }
    a = new SparseArray();
    a.put(0, "");
    SparseArray localSparseArray = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(String.valueOf(1));
    localStringBuilder.append("]");
    localSparseArray.put(1, localStringBuilder.toString());
    a.put(2, HardCodeUtil.a(2131913968));
    a.put(5, HardCodeUtil.a(2131913965));
    a.put(6, HardCodeUtil.a(2131913959));
    a.put(11, HardCodeUtil.a(2131913957));
    a.put(12, HardCodeUtil.a(2131913960));
    a.put(13, HardCodeUtil.a(2131913961));
    a.put(8, HardCodeUtil.a(2131913962));
    a.put(3, HardCodeUtil.a(2131913964));
    a.put(7, HardCodeUtil.a(2131913963));
    a.put(4, HardCodeUtil.a(2131913967));
    a.put(9, HardCodeUtil.a(2131913966));
    a.put(10, HardCodeUtil.a(2131913958));
    a.put(14, HardCodeUtil.a(2131913956));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UDConstants
 * JD-Core Version:    0.7.0.1
 */