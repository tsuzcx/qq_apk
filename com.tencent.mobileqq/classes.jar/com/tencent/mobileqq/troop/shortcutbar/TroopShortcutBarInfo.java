package com.tencent.mobileqq.troop.shortcutbar;

import java.util.ArrayList;
import java.util.Iterator;

public class TroopShortcutBarInfo
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private ArrayList<TroopShortcutBarApp> jdField_a_of_type_JavaUtilArrayList;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private long d = 0L;
  
  public TroopShortcutBarInfo()
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = null;
  }
  
  public TroopShortcutBarInfo(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2, ArrayList<TroopShortcutBarApp> paramArrayList)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = (System.currentTimeMillis() + paramInt1 * 1000);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_c_of_type_Int = (paramInt4 * 1000);
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.d = paramLong2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public TroopShortcutBarApp a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TroopShortcutBarApp localTroopShortcutBarApp = (TroopShortcutBarApp)localIterator.next();
      if (localTroopShortcutBarApp.b() == paramLong) {
        return localTroopShortcutBarApp;
      }
    }
    return null;
  }
  
  public ArrayList<TroopShortcutBarApp> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long c()
  {
    return this.d;
  }
  
  public void c(int paramInt)
  {
    this.jdField_b_of_type_Long = paramInt;
  }
  
  public void d(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarInfo
 * JD-Core Version:    0.7.0.1
 */