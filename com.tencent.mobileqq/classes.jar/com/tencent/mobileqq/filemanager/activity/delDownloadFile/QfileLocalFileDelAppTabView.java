package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import acgk;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileAppTabView;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class QfileLocalFileDelAppTabView
  extends QfileLocalFileAppTabView
{
  public QfileLocalFileDelAppTabView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void a()
  {
    this.b.clear();
    this.b.put("未安装", new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this);
    this.jdField_a_of_type_JavaLangRunnable = new acgk(this);
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelAppTabView
 * JD-Core Version:    0.7.0.1
 */