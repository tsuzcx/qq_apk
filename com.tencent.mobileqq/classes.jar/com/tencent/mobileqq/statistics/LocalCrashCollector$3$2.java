package com.tencent.mobileqq.statistics;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;

class LocalCrashCollector$3$2
  implements DialogInterface.OnClickListener
{
  LocalCrashCollector$3$2(LocalCrashCollector.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      LocalCrashCollector.a(this.a.this$0).a.setText("");
      LocalCrashCollector.a(this.a.this$0).delete(0, LocalCrashCollector.a(this.a.this$0).length());
      paramDialogInterface.dismiss();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.LocalCrashCollector.3.2
 * JD-Core Version:    0.7.0.1
 */