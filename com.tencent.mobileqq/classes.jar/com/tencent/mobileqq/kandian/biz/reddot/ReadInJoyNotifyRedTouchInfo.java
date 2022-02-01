package com.tencent.mobileqq.kandian.biz.reddot;

public class ReadInJoyNotifyRedTouchInfo
{
  public static final String a;
  public int a;
  public int b;
  public String b;
  public int c = 0;
  public int d = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = Long.toString(1130L);
  }
  
  public ReadInJoyNotifyRedTouchInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int != 1) {
      return 0;
    }
    return this.jdField_b_of_type_Int;
  }
  
  public int a(ReadInJoyNotifyRedTouchInfo paramReadInJoyNotifyRedTouchInfo)
  {
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo1;
    ReadInJoyNotifyRedTouchInfo localReadInJoyNotifyRedTouchInfo2;
    if (this.jdField_a_of_type_Int > paramReadInJoyNotifyRedTouchInfo.jdField_a_of_type_Int)
    {
      localReadInJoyNotifyRedTouchInfo1 = this;
      localReadInJoyNotifyRedTouchInfo2 = paramReadInJoyNotifyRedTouchInfo;
    }
    else
    {
      localReadInJoyNotifyRedTouchInfo2 = this;
      localReadInJoyNotifyRedTouchInfo1 = paramReadInJoyNotifyRedTouchInfo;
    }
    int i = localReadInJoyNotifyRedTouchInfo2.jdField_a_of_type_Int;
    int m = 0;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2 ? i != 3 ? (i == 4) || ((localReadInJoyNotifyRedTouchInfo1.jdField_a_of_type_Int != 4) && (!localReadInJoyNotifyRedTouchInfo2.jdField_b_of_type_JavaLangString.equals(localReadInJoyNotifyRedTouchInfo1.jdField_b_of_type_JavaLangString))) : (localReadInJoyNotifyRedTouchInfo1.jdField_a_of_type_Int != 3) && (localReadInJoyNotifyRedTouchInfo2.c != localReadInJoyNotifyRedTouchInfo1.c) : (localReadInJoyNotifyRedTouchInfo1.jdField_a_of_type_Int == 2) && (localReadInJoyNotifyRedTouchInfo2.jdField_b_of_type_JavaLangString.equals(localReadInJoyNotifyRedTouchInfo1.jdField_b_of_type_JavaLangString))) {
          break label186;
        }
        i = 1;
        break label188;
      }
      if (localReadInJoyNotifyRedTouchInfo1.jdField_a_of_type_Int == 1) {
        if (localReadInJoyNotifyRedTouchInfo2.jdField_b_of_type_Int == localReadInJoyNotifyRedTouchInfo1.jdField_b_of_type_Int) {
          break label186;
        }
      }
    }
    else
    {
      if (localReadInJoyNotifyRedTouchInfo1.jdField_a_of_type_Int == 0) {
        break label186;
      }
    }
    int k = 1;
    int j = 1;
    break label193;
    label186:
    i = 0;
    label188:
    j = 0;
    k = i;
    label193:
    i = m;
    if (k != 0) {
      i = 1;
    }
    k = i;
    if (j != 0) {
      k = i | 0x2;
    }
    return k;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 0)
    {
      if (i != 1) {}
      while (this.jdField_b_of_type_Int > 0) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyNotifyRedTouchInfo
 * JD-Core Version:    0.7.0.1
 */