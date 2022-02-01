package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class FileOperaterUtils$13
  implements View.OnClickListener
{
  FileOperaterUtils$13(Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AEE0", "0X800AEE0", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      long l = FileUtil.a(this.jdField_a_of_type_JavaLangString);
      WXShareHelper localWXShareHelper = WXShareHelper.a();
      if (l <= 10485760L)
      {
        int i = FileManagerUtil.b(this.jdField_a_of_type_JavaLangString);
        Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidAppActivity.getResources(), i);
        localWXShareHelper.a(this.jdField_a_of_type_JavaLangString, localBitmap);
        ReportController.b(null, "dc00898", "", "", "0X800AEE1", "0X800AEE1", 0, 0, "", "", "", "");
      }
      else
      {
        ReportController.b(null, "dc00898", "", "", "0X800AEE2", "0X800AEE2", 0, 0, "", "", "", "");
        FMDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, "", 2131698225, new FileOperaterUtils.13.1(this));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.13
 * JD-Core Version:    0.7.0.1
 */