package com.tencent.mqp.app.sec;

import com.tencent.mobileqq.app.QQAppInterface;

class ScConfigManager$LoadLocalConfig
  implements Runnable
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public ScConfigManager$LoadLocalConfig(ScConfigManager paramScConfigManager, QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void run()
  {
    ScConfigManager.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mqp.app.sec.ScConfigManager.LoadLocalConfig
 * JD-Core Version:    0.7.0.1
 */