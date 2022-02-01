package com.tencent.mobileqq.uftransfer.task.utils;

import android.util.SparseIntArray;

public class UFTTaskUtils
{
  private static final SparseIntArray a = new SparseIntArray();
  private static final SparseIntArray b;
  private static final SparseIntArray c;
  private static final SparseIntArray d;
  private static final SparseIntArray e;
  private static final SparseIntArray f;
  
  static
  {
    a.put(0, 0);
    a.put(1, 9004);
    a.put(2, 9004);
    a.put(3, 9045);
    a.put(4, 9052);
    a.put(5, 9032);
    a.put(6, 9052);
    a.put(7, 9005);
    a.put(8, 9003);
    a.put(9, 4606);
    a.put(10, 4606);
    a.put(11, 9001);
    a.put(12, 9052);
    a.put(13, 9009);
    a.put(16, 9009);
    a.put(14, 9032);
    a.put(15, 9032);
    a.put(17, 9001);
    a.put(18, 9052);
    a.put(19, 9001);
    a.put(20, 9001);
    a.put(30, 9043);
    a.put(31, 9006);
    a.put(32, 9042);
    a.put(33, 9037);
    b = new SparseIntArray();
    b.put(0, 0);
    b.put(1, 3);
    b.put(2, 9);
    b.put(3, 3);
    b.put(4, 3);
    b.put(5, 3);
    b.put(6, 3);
    b.put(10, 3);
    b.put(12, 3);
    b.put(13, 3);
    b.put(14, 3);
    b.put(15, 3);
    b.put(16, 3);
    b.put(18, 3);
    b.put(9, 4);
    b.put(19, 4);
    b.put(20, 4);
    b.put(17, 9);
    b.put(11, 9);
    b.put(7, 10);
    b.put(8, 7);
    b.put(30, 2);
    b.put(31, 1);
    b.put(32, 5);
    b.put(33, 8);
    c = new SparseIntArray();
    c.put(0, 0);
    c.put(1, 307);
    c.put(2, 901);
    c.put(3, 300);
    c.put(4, 307);
    c.put(5, 309);
    c.put(6, 308);
    c.put(7, 10);
    c.put(8, 707);
    c.put(9, 4);
    c.put(10, 4);
    c.put(11, 9);
    c.put(12, 309);
    c.put(13, 312);
    c.put(14, 309);
    c.put(15, 309);
    c.put(16, 300);
    c.put(17, 905);
    c.put(18, 307);
    c.put(19, 4);
    c.put(20, 4);
    c.put(30, 2);
    c.put(31, 103);
    c.put(32, 503);
    c.put(33, 8);
    d = new SparseIntArray();
    d.put(0, 0);
    d.put(1, 106);
    d.put(2, 106);
    d.put(3, 1);
    d.put(4, 1);
    d.put(5, 1);
    d.put(6, 1);
    d.put(7, 102);
    d.put(8, 203);
    d.put(9, 1);
    d.put(10, 1);
    d.put(11, 102);
    d.put(12, 1);
    d.put(13, 1);
    d.put(14, 1);
    d.put(15, 1);
    d.put(16, 1);
    d.put(17, 1);
    d.put(18, 1);
    d.put(19, 1);
    d.put(20, 1);
    d.put(30, 103);
    d.put(31, 103);
    d.put(32, 102);
    d.put(33, 1);
    e = new SparseIntArray();
    e.put(0, 0);
    e.put(1, 100);
    e.put(2, 7);
    e.put(3, -97);
    e.put(4, 101);
    e.put(5, 101);
    e.put(6, 101);
    e.put(7, 112);
    e.put(8, 6);
    e.put(9, 104);
    e.put(10, 104);
    e.put(11, 112);
    e.put(12, 101);
    e.put(13, 111);
    e.put(14, 101);
    e.put(15, 101);
    e.put(16, 101);
    e.put(17, 112);
    e.put(18, 101);
    e.put(19, 101);
    e.put(20, 101);
    e.put(30, 101);
    e.put(31, 101);
    e.put(32, 6);
    e.put(33, 112);
    f = new SparseIntArray();
    f.put(0, 0);
    f.put(1, 31);
    f.put(100, 31);
    f.put(101, 31);
    f.put(102, 31);
    f.put(2, 30);
    f.put(3, 5);
    f.put(300, 5);
    f.put(301, 5);
    f.put(302, 5);
    f.put(303, 5);
    f.put(304, 5);
    f.put(305, 5);
    f.put(313, 5);
    f.put(309, 5);
    f.put(306, 2);
    f.put(901, 2);
    f.put(4, 1);
    f.put(307, 1);
    f.put(308, 1);
    f.put(312, 13);
    f.put(5, 32);
    f.put(501, 32);
    f.put(502, 32);
    f.put(503, 32);
    f.put(504, 32);
    f.put(701, 32);
    f.put(702, 32);
    f.put(7, 11);
    f.put(700, 11);
    f.put(703, 11);
    f.put(704, 11);
    f.put(707, 8);
    f.put(708, 8);
    f.put(709, 8);
    f.put(710, 8);
    f.put(8, 33);
    f.put(9, 17);
    f.put(902, 17);
    f.put(904, 17);
    f.put(10, 7);
    f.put(11, 11);
    f.put(12, 11);
  }
  
  public static int a(int paramInt)
  {
    return a.get(paramInt, paramInt);
  }
  
  public static int b(int paramInt)
  {
    return b.get(paramInt, paramInt);
  }
  
  public static int c(int paramInt)
  {
    return c.get(paramInt, paramInt);
  }
  
  public static int d(int paramInt)
  {
    return d.get(paramInt, paramInt);
  }
  
  public static int e(int paramInt)
  {
    return e.get(paramInt, paramInt);
  }
  
  public static int f(int paramInt)
  {
    return f.get(paramInt, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.utils.UFTTaskUtils
 * JD-Core Version:    0.7.0.1
 */