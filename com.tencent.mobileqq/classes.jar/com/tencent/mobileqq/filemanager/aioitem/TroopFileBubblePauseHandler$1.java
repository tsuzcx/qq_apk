package com.tencent.mobileqq.filemanager.aioitem;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFileItemOperation;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopFileBubblePauseHandler$1
  implements ActionSheet.OnButtonClickListener
{
  TroopFileBubblePauseHandler$1(TroopFileBubblePauseHandler paramTroopFileBubblePauseHandler, String paramString, TroopFileStatusInfo paramTroopFileStatusInfo) {}
  
  public void onClick(View paramView, int paramInt)
  {
    ReportController.b(this.c.b, "dc00898", "", "", "0X800A7F3", "0X800A7F3", 2, 0, "", "", "", "");
    new TroopFileItemOperation(Long.parseLong(this.a), this.c.b, (Activity)this.c.a).a(this.b.a);
    this.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.TroopFileBubblePauseHandler.1
 * JD-Core Version:    0.7.0.1
 */