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
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.isFriend) {
        break label49;
      }
    }
    label49:
    for (this.jdField_a_of_type_Int = 1;; this.jdField_a_of_type_Int = 0)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return;
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.friendUin;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) {
      return false;
    }
    return IntimateUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.maskType);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.CardContent
 * JD-Core Version:    0.7.0.1
 */