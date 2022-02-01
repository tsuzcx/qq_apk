package com.tencent.mobileqq.settings.message;

import android.view.View;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QFormSimpleItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Map;

class NewTempMsgSettingFragment$4$1
  implements ActionSheet.OnButtonClickListener
{
  NewTempMsgSettingFragment$4$1(NewTempMsgSettingFragment.4 param4, TempMsgManager paramTempMsgManager, short paramShort, int paramInt, View paramView, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    ReportController.b(this.f.a.a, "dc00898", "", "", this.a.a(paramInt), this.a.a(paramInt), this.a.e(this.b), 0, "", "", "", "");
    int i = this.c;
    if (paramInt != i)
    {
      this.a.a(this.b, paramInt, i, true);
      paramView = this.d;
      if ((paramView instanceof QFormSimpleItem)) {
        ((QFormSimpleItem)paramView).setRightText((CharSequence)NewTempMsgSettingFragment.a(this.f.a).get(Integer.valueOf(paramInt)));
      }
    }
    this.e.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.settings.message.NewTempMsgSettingFragment.4.1
 * JD-Core Version:    0.7.0.1
 */