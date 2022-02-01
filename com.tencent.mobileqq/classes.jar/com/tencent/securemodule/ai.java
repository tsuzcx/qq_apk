package com.tencent.securemodule;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.securemodule.ui.TransparentActivity;
import com.tencent.securemodule.ui.TransparentActivity.a;

public class ai
  extends Handler
{
  public ai(TransparentActivity paramTransparentActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return;
      } while (TransparentActivity.a(this.a) != null);
      TransparentActivity.a(this.a, new ReportProgressDialog(TransparentActivity.b(this.a)));
      TransparentActivity.a(this.a).setMessage("正在处理...");
      TransparentActivity.a(this.a).setOnCancelListener(new aj(this));
      TransparentActivity.a(this.a).show();
      return;
    case 2: 
      if (TransparentActivity.a(this.a) != null) {
        TransparentActivity.a(this.a).dismiss();
      }
      if (paramMessage.arg1 == 1) {}
      for (paramMessage = "执行成功";; paramMessage = "执行失败")
      {
        Toast.makeText(TransparentActivity.b(this.a), paramMessage, 0).show();
        this.a.finish();
        return;
      }
    case 3: 
      this.a.finish();
      return;
    }
    new TransparentActivity.a(this.a, paramMessage.arg1).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.securemodule.ai
 * JD-Core Version:    0.7.0.1
 */