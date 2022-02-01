package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopFileModel$10
  implements View.OnClickListener
{
  TroopFileModel$10(TroopFileModel paramTroopFileModel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.b.k != null)
    {
      int i = this.a;
      if (i == 1)
      {
        ReportController.b(null, "dc00898", "", "", "0X800A745", "0X800A745", QFileUtils.c(this.b.z()), 0, "", "", "", "");
        if (this.b.k.j()) {
          this.b.k.d();
        }
      }
      else if (i == 2)
      {
        this.b.k.n();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.10
 * JD-Core Version:    0.7.0.1
 */