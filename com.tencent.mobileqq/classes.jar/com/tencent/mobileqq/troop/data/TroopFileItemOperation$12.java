package com.tencent.mobileqq.troop.data;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TroopFileItemOperation$12
  implements ActionSheet.OnButtonClickListener
{
  TroopFileItemOperation$12(TroopFileItemOperation paramTroopFileItemOperation, boolean paramBoolean, TroopFileInfo paramTroopFileInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    int i = paramInt;
    if (!this.a) {
      i = paramInt + 1;
    }
    StringBuilder localStringBuilder;
    if (i != 0)
    {
      if ((i == 1) && (TroopFileItemOperation.a(this.d) != 0))
      {
        TroopFileManager.a(this.d.c, this.d.b).b(this.b);
        paramView = this.d.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.d.b);
        localStringBuilder.append("");
        ReportController.b(paramView, "CliOper", "", "", "Grp", "Clk_delete_share", 0, 0, "", localStringBuilder.toString(), "", "");
      }
    }
    else
    {
      TroopFileTransferManager.a(this.d.c, this.d.b).a(this.b.b);
      paramView = this.d.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d.b);
      localStringBuilder.append("");
      ReportController.b(paramView, "CliOper", "", "", "Grp", "Clk_delete_local", 0, 0, "", localStringBuilder.toString(), "", "");
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFileItemOperation.12
 * JD-Core Version:    0.7.0.1
 */