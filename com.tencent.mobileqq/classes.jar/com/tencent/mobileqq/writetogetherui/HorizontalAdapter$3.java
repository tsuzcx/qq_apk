package com.tencent.mobileqq.writetogetherui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.writetogetherconfig.WriteTogetherTemplateConfBean.Template;

class HorizontalAdapter$3
  implements DialogInterface.OnClickListener
{
  HorizontalAdapter$3(HorizontalAdapter paramHorizontalAdapter, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ReportController.b(null, "dc00898", "", "", "0X800B359", "0X800B359", 1, 0, "", "", "", "");
    HorizontalAdapter.c(this.b).a(HorizontalAdapter.b(this.b)[this.a].c);
    HorizontalAdapter.a(this.b, this.a);
    this.b.a(false);
    this.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogetherui.HorizontalAdapter.3
 * JD-Core Version:    0.7.0.1
 */