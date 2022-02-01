package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$7
  implements View.OnClickListener
{
  FileOperaterUtils$7(Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BasePluginActivity)) {
      FileManagerUtil.a(((BasePluginActivity)this.jdField_a_of_type_AndroidAppActivity).getOutActivity(), this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      FileManagerUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.7
 * JD-Core Version:    0.7.0.1
 */