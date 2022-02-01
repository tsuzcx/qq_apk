package com.tencent.mobileqq.filemanager.activity.localfile;

import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import java.util.LinkedHashMap;
import java.util.Map;

class QfileLocalFilePicTabView$1$1
  implements Runnable
{
  QfileLocalFilePicTabView$1$1(QfileLocalFilePicTabView.1 param1, Map paramMap, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView$1.this$0.c.clear();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView$1.this$0.c.putAll(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView$1.this$0.i();
    if ((this.jdField_a_of_type_Int != -1) && (this.b != -1))
    {
      if ((!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView$1.this$0.a.g()) && (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView$1.this$0.a.h()))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView$1.this$0.setSelect(0);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView$1.this$0.setPos(this.jdField_a_of_type_Int, this.b);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalfileQfileLocalFilePicTabView$1.this$0.setSelect(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.1.1
 * JD-Core Version:    0.7.0.1
 */