package com.tencent.mobileqq.filemanager.fileviewer.FileView;

import android.app.Activity;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tbs.reader.TbsReaderView;

class LocalTbsViewManager$5
  implements View.OnClickListener
{
  LocalTbsViewManager$5(LocalTbsViewManager paramLocalTbsViewManager, int paramInt, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    int i;
    if (this.jdField_a_of_type_Int == 5018)
    {
      Display localDisplay = this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay();
      if (localDisplay.getWidth() > localDisplay.getHeight())
      {
        i = 0;
        if (i == 0) {
          break label61;
        }
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 1;
      break;
      label61:
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      continue;
      LocalTbsViewManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerFileViewLocalTbsViewManager).doCommand(Integer.valueOf(this.jdField_a_of_type_Int), null, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager.5
 * JD-Core Version:    0.7.0.1
 */