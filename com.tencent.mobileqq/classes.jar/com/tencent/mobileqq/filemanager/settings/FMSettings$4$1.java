package com.tencent.mobileqq.filemanager.settings;

class FMSettings$4$1
  implements FMSettingInterface.MoveFileCallback
{
  FMSettings$4$1(FMSettings.4 param4) {}
  
  public void a()
  {
    synchronized (this.a.this$0)
    {
      FMSettings localFMSettings2 = this.a.this$0;
      localFMSettings2.jdField_a_of_type_Int += 1;
      FMSettings.a(1, "onMovedOver,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        FMSettings.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettingInterface$MoveFileCallback.a();
      }
      return;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a.this$0)
    {
      FMSettings localFMSettings2 = this.a.this$0;
      localFMSettings2.jdField_a_of_type_Int += 1;
      FMSettings.a(1, "onMoveFail,count[" + this.a.this$0.jdField_a_of_type_Int + "],total[" + this.a.jdField_a_of_type_Int + "]");
      if (this.a.this$0.jdField_a_of_type_Int == this.a.jdField_a_of_type_Int)
      {
        FMSettings.a(1, "moveFileToDefaultPath,move over!");
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettingInterface$MoveFileCallback.a(16);
      }
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    FMSettings localFMSettings = this.a.this$0;
    localFMSettings.jdField_a_of_type_Long += paramLong1;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettingInterface$MoveFileCallback.a(this.a.this$0.jdField_a_of_type_Long, this.a.this$0.b);
  }
  
  public void a(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.4.1
 * JD-Core Version:    0.7.0.1
 */