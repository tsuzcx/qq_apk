package com.tencent.mobileqq.troop.data;

public class MessageInfo
{
  public int a;
  public MessageNavInfo a;
  public String a;
  
  public MessageInfo()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo();
    a();
  }
  
  public MessageInfo(MessageInfo paramMessageInfo)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo();
    if (paramMessageInfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      return;
    }
    a();
  }
  
  public static final boolean a(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 == 11) {
      i = 31;
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 11) {
      paramInt1 = 31;
    }
    if ((i == 2) || (i == 16)) {
      if (i + 1 < paramInt1) {}
    }
    while (i >= paramInt1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return a();
    }
    return b();
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.jdField_a_of_type_Long;
    }
    return -1L;
  }
  
  public MessageInfo a(MessageInfo paramMessageInfo)
  {
    if (paramMessageInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
    }
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a();
  }
  
  public int b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) && (MessageNavInfo.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.jdField_a_of_type_Int))) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public long b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a()) && (MessageNavInfo.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.jdField_a_of_type_Int))) {
      return this.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.jdField_a_of_type_Long;
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.MessageInfo
 * JD-Core Version:    0.7.0.1
 */