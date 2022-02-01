package com.tencent.mobileqq.troop.troop_apps.entry.ui;

import android.view.View;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class BulkSendMessageFragment$6
  implements ActionSheet.OnButtonClickListener
{
  BulkSendMessageFragment$6(BulkSendMessageFragment paramBulkSendMessageFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt < this.b.b.size())
    {
      paramView = (String)this.b.b.get(paramInt);
      this.b.h.setText(paramView);
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment.6
 * JD-Core Version:    0.7.0.1
 */