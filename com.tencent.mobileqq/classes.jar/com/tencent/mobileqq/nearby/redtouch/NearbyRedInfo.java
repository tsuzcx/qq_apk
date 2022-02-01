package com.tencent.mobileqq.nearby.redtouch;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NearbyRedInfo
{
  public static HashMap<Integer, Integer> a;
  public int a;
  public long a;
  public String a;
  public List<String> a;
  public int b;
  public String b;
  public int c;
  public String c = "";
  public int d;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), Integer.valueOf(20));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), Integer.valueOf(40));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(5), Integer.valueOf(60));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(0), Integer.valueOf(80));
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(-1), Integer.valueOf(100));
  }
  
  public NearbyRedInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public void a(int paramInt)
  {
    Integer localInteger1 = (Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    Integer localInteger2 = (Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if ((localInteger1 != null) && (localInteger2 != null) && (localInteger1.compareTo(localInteger2) < 0)) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public void a(String paramString)
  {
    int i = 0;
    try
    {
      int j = Integer.valueOf(paramString).intValue();
      i = j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("NearbyRedInfo", 1, localNumberFormatException, new Object[0]);
        this.jdField_a_of_type_JavaLangString = paramString;
      }
    }
    this.jdField_b_of_type_Int = (i + this.jdField_b_of_type_Int);
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int += paramInt;
  }
  
  public String toString()
  {
    return "[redType=" + this.jdField_a_of_type_Int + ", redNum=" + this.jdField_b_of_type_Int + ", redTxt=" + this.jdField_a_of_type_JavaLangString + ", redAppIdType=" + this.d + ", url=" + this.jdField_a_of_type_JavaUtilList + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.redtouch.NearbyRedInfo
 * JD-Core Version:    0.7.0.1
 */