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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          new TransparentActivity.a(this.a, paramMessage.arg1).start();
          return;
        }
      }
      for (;;)
      {
        this.a.finish();
        return;
        if (TransparentActivity.a(this.a) != null) {
          TransparentActivity.a(this.a).dismiss();
        }
        if (paramMessage.arg1 == 1) {
          paramMessage = "执行成功";
        } else {
          paramMessage = "执行失败";
        }
        Toast.makeText(TransparentActivity.b(this.a), paramMessage, 0).show();
      }
    }
    if (TransparentActivity.a(this.a) == null)
    {
      paramMessage = this.a;
      TransparentActivity.a(paramMessage, new ReportProgressDialog(TransparentActivity.b(paramMessage)));
      TransparentActivity.a(this.a).setMessage("正在处理...");
      TransparentActivity.a(this.a).setOnCancelListener(new aj(this));
      TransparentActivity.a(this.a).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.securemodule.ai
 * JD-Core Version:    0.7.0.1
 */