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
    a.put(2, HardCodeUtil.a(2131716536));
    a.put(5, HardCodeUtil.a(2131716533));
    a.put(6, HardCodeUtil.a(2131716527));
    a.put(11, HardCodeUtil.a(2131716525));
    a.put(12, HardCodeUtil.a(2131716528));
    a.put(13, HardCodeUtil.a(2131716529));
    a.put(8, HardCodeUtil.a(2131716530));
    a.put(3, HardCodeUtil.a(2131716532));
    a.put(7, HardCodeUtil.a(2131716531));
    a.put(4, HardCodeUtil.a(2131716535));
    a.put(9, HardCodeUtil.a(2131716534));
    a.put(10, HardCodeUtil.a(2131716526));
    a.put(14, HardCodeUtil.a(2131716524));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UDConstants
 * JD-Core Version:    0.7.0.1
 */