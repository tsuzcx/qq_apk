package com.tencent.mobileqq.filemanager.settings;

class QQFMSettings$4$1
  implements FMSettingInterface.MoveFileCallback
{
  QQFMSettings$4$1(QQFMSettings.4 param4) {}
  
  public void a()
  {
    synchronized (this.a.this$0)
    {
      QQFMSettings localQQFMSettings = this.a.this$0;
      localQQFMSettings.jdField_a_of_type_Int += 1;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onMovedOver,count[");
      ((StringBuilder)???).append(this.a.this$0.jdField_a_of_type_Int);
      ((StringBuilder)???).append("],total[");
      ((StringBuilder)???).append(this.a.jdField_a_of_type_Int);
      ((StringBuilder)???).append("]");
      QQFMSettings.a(1, ((StringBuilder)???).toString());
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        QQFMSettings.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettingInterface$MoveFileCallback.a();
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a.this$0)
    {
      QQFMSettings localQQFMSettings = this.a.this$0;
      localQQFMSettings.jdField_a_of_type_Int += 1;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onMoveFail,count[");
      ((StringBuilder)???).append(this.a.this$0.jdField_a_of_type_Int);
      ((StringBuilder)???).append("],total[");
      ((StringBuilder)???).append(this.a.jdField_a_of_type_Int);
      ((StringBuilder)???).append("]");
      QQFMSettings.a(1, ((StringBuilder)???).toString());
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        QQFMSettings.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettingInterface$MoveFileCallback.a(16);
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    QQFMSettings localQQFMSettings = this.a.this$0;
    localQQFMSettings.jdField_a_of_type_Long += paramLong1;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettingInterface$MoveFileCallback.a(this.a.this$0.jdField_a_of_type_Long, this.a.this$0.b);
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.4.1
 * JD-Core Version:    0.7.0.1
 */