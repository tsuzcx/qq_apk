package com.tencent.mobileqq.filemanager.activity.delDownloadFile;

import acql;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.mobileqq.filemanager.util.FileUtil;

public class QfileLocalFileDelPicTabView
  extends QfileLocalFilePicTabView
{
  public QfileLocalFileDelPicTabView(Context paramContext)
  {
    super(paramContext);
  }
  
  public String a(String paramString)
  {
    paramString = FileUtil.a(paramString);
    if ((paramString == null) || (paramString.length() == 0)) {
      return "其他";
    }
    if (".jpg|.bmp|.jpeg|.gif|.png|.ico|".contains(paramString.toLowerCase())) {
      return "图片";
    }
    return "其他";
  }
  
  protected void a()
  {
    setEditbarButton(false, false, false, false, true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFMActivity.a(this);
    this.jdField_a_of_type_JavaLangRunnable = new acql(this);
    ThreadManager.executeOnFileThread(this.jdField_a_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView
 * JD-Core Version:    0.7.0.1
 */