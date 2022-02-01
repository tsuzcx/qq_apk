package com.tencent.mobileqq.troop.activity.editservice;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EditTroopNameService$2
  implements View.OnClickListener
{
  EditTroopNameService$2(EditTroopNameService paramEditTroopNameService) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131366086) && (!EditTroopNameService.a(this.a)) && (!TextUtils.isEmpty(EditTroopNameService.a(this.a))))
    {
      if ((TextUtils.isEmpty(EditTroopNameService.b(this.a)) ^ true)) {}
      String str2;
      try
      {
        str1 = String.format(EditTroopNameService.a(this.a).getString(2131720026), new Object[] { EditTroopNameService.a(this.a), EditTroopNameService.b(this.a) });
      }
      catch (Exception localException)
      {
        String str1;
        localException.printStackTrace();
        str2 = "";
      }
      str1 = String.format(EditTroopNameService.a(this.a).getString(2131720027), new Object[] { EditTroopNameService.a(this.a) });
      if (!TextUtils.isEmpty(str2))
      {
        if (Build.VERSION.SDK_INT < 11)
        {
          ((android.text.ClipboardManager)EditTroopNameService.a(this.a).getSystemService("clipboard")).setText(str2);
        }
        else
        {
          android.content.ClipboardManager localClipboardManager = (android.content.ClipboardManager)EditTroopNameService.a(this.a).getSystemService("clipboard");
          ClipboardMonitor.setText(localClipboardManager, str2);
          localClipboardManager.setText(str2);
        }
        QQToast.a(EditTroopNameService.a(this.a), 2131699465, 1).a();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editservice.EditTroopNameService.2
 * JD-Core Version:    0.7.0.1
 */