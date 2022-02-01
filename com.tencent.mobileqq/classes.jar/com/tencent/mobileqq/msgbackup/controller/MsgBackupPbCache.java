package com.tencent.mobileqq.msgbackup.controller;

import android.util.SparseArray;
import java.util.ArrayList;

public class MsgBackupPbCache
{
  private static SparseArray<ArrayList<byte[]>> a = new SparseArray(2000);
  private static SparseArray<Integer> b = new SparseArray(2000);
  
  public static void a()
  {
    try
    {
      a.clear();
      b.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    try
    {
      int i = paramArrayOfByte.length;
      if (i > 2000) {
        return;
      }
      ArrayList localArrayList2 = (ArrayList)a.get(i);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList(100);
        b.put(i, Integer.valueOf(0));
      }
      int j = localArrayList1.size();
      if (j >= 100) {
        return;
      }
      localArrayList1.add(paramArrayOfByte);
      a.put(paramArrayOfByte.length, localArrayList1);
      j = ((Integer)b.get(i)).intValue();
      b.put(i, Integer.valueOf(j + 1));
      return;
    }
    finally {}
  }
  
  public static byte[] a(int paramInt)
  {
    try
    {
      Object localObject1 = (ArrayList)a.get(paramInt);
      if (localObject1 == null) {
        return null;
      }
      int i = ((Integer)b.get(paramInt)).intValue();
      int j = ((ArrayList)localObject1).size();
      if (i >= j) {
        return null;
      }
      localObject1 = (byte[])((ArrayList)localObject1).get(i);
      b.put(paramInt, Integer.valueOf(i + 1));
      return localObject1;
    }
    finally {}
  }
  
  public static void b()
  {
    try
    {
      int j = b.size();
      int i = 0;
      while (i < j)
      {
        b.setValueAt(i, Integer.valueOf(0));
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.controller.MsgBackupPbCache
 * JD-Core Version:    0.7.0.1
 */