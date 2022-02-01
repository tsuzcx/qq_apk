package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.SharedPreferences;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import java.util.ArrayList;
import java.util.Map;

class QfileLocalFilePicTabView$1
  implements Runnable
{
  QfileLocalFilePicTabView$1(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void run()
  {
    Object localObject = QfileLocalFilePicTabView.a(this.this$0);
    Map localMap = QfileLocalFilePicTabView.a(this.this$0, (ArrayList)localObject);
    QfileLocalFilePicTabView localQfileLocalFilePicTabView = this.this$0;
    localQfileLocalFilePicTabView.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject);
    localObject = localQfileLocalFilePicTabView.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getSharedPreferences("LAST_CHOOSE_", 0);
    int i = ((SharedPreferences)localObject).getInt("GROUP", -1);
    int j = ((SharedPreferences)localObject).getInt("CHILD", -1);
    QfileLocalFilePicTabView.a(this.this$0, new QfileLocalFilePicTabView.1.1(this, localMap, i, j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.1
 * JD-Core Version:    0.7.0.1
 */