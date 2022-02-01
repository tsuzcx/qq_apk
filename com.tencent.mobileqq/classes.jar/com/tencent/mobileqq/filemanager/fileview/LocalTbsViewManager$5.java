package com.tencent.mobileqq.filemanager.fileview;

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
    if (this.jdField_a_of_type_Int == 5018)
    {
      Display localDisplay = this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay();
      int i;
      if (localDisplay.getWidth() > localDisplay.getHeight()) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(0);
      } else {
        this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
      }
    }
    else
    {
      LocalTbsViewManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewLocalTbsViewManager).doCommand(Integer.valueOf(this.jdField_a_of_type_Int), null, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.5
 * JD-Core Version:    0.7.0.1
 */