package com.tencent.mobileqq.filemanager.activity.localfile;

import android.content.SharedPreferences;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import java.util.Map;

class QfileLocalFilePicTabView$1
  implements Runnable
{
  QfileLocalFilePicTabView$1(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void run()
  {
    QfileLocalFilePicTabView.a(this.this$0);
    Map localMap = QfileLocalFilePicTabView.a(this.this$0);
    SharedPreferences localSharedPreferences = this.this$0.a.getSharedPreferences("LAST_CHOOSE_", 0);
    int i = localSharedPreferences.getInt("GROUP", -1);
    int j = localSharedPreferences.getInt("CHILD", -1);
    QfileLocalFilePicTabView.a(this.this$0, new QfileLocalFilePicTabView.1.1(this, localMap, i, j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView.1
 * JD-Core Version:    0.7.0.1
 */