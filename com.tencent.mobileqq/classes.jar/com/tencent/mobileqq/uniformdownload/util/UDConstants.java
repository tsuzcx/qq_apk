package com.tencent.mobileqq.uniformdownload.util;

import android.util.SparseArray;
import com.tencent.mobileqq.app.HardCodeUtil;

public class UDConstants
{
  private static SparseArray<String> a;
  
  public static String a(int paramInt)
  {
    a();
    return (String)a.get(paramInt, "[" + String.valueOf(paramInt) + "]");
  }
  
  private static void a()
  {
    if (a != null) {
      return;
    }
    a = new SparseArray();
    a.put(0, "");
    a.put(1, "[" + String.valueOf(1) + "]");
    a.put(2, HardCodeUtil.a(2131716883));
    a.put(5, HardCodeUtil.a(2131716880));
    a.put(6, HardCodeUtil.a(2131716874));
    a.put(11, HardCodeUtil.a(2131716872));
    a.put(12, HardCodeUtil.a(2131716875));
    a.put(13, HardCodeUtil.a(2131716876));
    a.put(8, HardCodeUtil.a(2131716877));
    a.put(3, HardCodeUtil.a(2131716879));
    a.put(7, HardCodeUtil.a(2131716878));
    a.put(4, HardCodeUtil.a(2131716882));
    a.put(9, HardCodeUtil.a(2131716881));
    a.put(10, HardCodeUtil.a(2131716873));
    a.put(14, HardCodeUtil.a(2131716871));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.uniformdownload.util.UDConstants
 * JD-Core Version:    0.7.0.1
 */