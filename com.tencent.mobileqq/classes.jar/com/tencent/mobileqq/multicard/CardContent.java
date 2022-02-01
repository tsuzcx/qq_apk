package com.tencent.mobileqq.multicard;

import com.tencent.mobileqq.activity.aio.intimate.IntimateUtil;
import com.tencent.mobileqq.data.IntimateInfo;

public class CardContent
{
  public int a;
  private long a;
  public IntimateInfo a;
  public String a;
  
  public CardContent(IntimateInfo paramIntimateInfo)
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    paramIntimateInfo = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
    if (paramIntimateInfo != null) {
      if (!paramIntimateInfo.isFriend) {
        this.jdField_a_of_type_Int = 1;
      } else {
        this.jdField_a_of_type_Int = 0;
      }
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    IntimateInfo localIntimateInfo = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
    if (localIntimateInfo == null) {
      return null;
    }
    return localIntimateInfo.friendUin;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    IntimateInfo localIntimateInfo = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
    if (localIntimateInfo == null) {
      return false;
    }
    return IntimateUtil.a(localIntimateInfo.maskType);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.CardContent
 * JD-Core Version:    0.7.0.1
 */