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

final class FileOperaterUtils$14
  implements View.OnClickListener
{
  FileOperaterUtils$14(Activity paramActivity, String paramString) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "dc00898", "", "", "0X800AEE0", "0X800AEE0", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_AndroidAppActivity == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
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
        FMDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, "", 2131698169, new FileOperaterUtils.14.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileOperaterUtils.14
 * JD-Core Version:    0.7.0.1
 */