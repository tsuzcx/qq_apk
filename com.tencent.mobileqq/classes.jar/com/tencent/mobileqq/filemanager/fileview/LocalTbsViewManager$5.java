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
    if (this.a == 5018)
    {
      Display localDisplay = this.b.getWindowManager().getDefaultDisplay();
      int i;
      if (localDisplay.getWidth() > localDisplay.getHeight()) {
        i = 0;
      } else {
        i = 1;
      }
      if (i != 0) {
        this.b.setRequestedOrientation(0);
      } else {
        this.b.setRequestedOrientation(1);
      }
    }
    else
    {
      LocalTbsViewManager.b(this.c).doCommand(Integer.valueOf(this.a), null, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager.5
 * JD-Core Version:    0.7.0.1
 */