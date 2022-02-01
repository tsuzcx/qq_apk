package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$11
  extends Handler
{
  ThemeDIYActivity$11(ThemeDIYActivity paramThemeDIYActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 23: 
    default: 
      QLog.e("ThemeDIYActivity", 1, "Handler = default");
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            ThemeDIYActivity.access$1000(this.this$0, paramMessage);
            return;
            ThemeDIYActivity.access$1100(this.this$0, paramMessage);
            return;
            if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Drawable))) {}
            for (paramMessage = (Drawable)paramMessage.obj;; paramMessage = null)
            {
              this.this$0.mblurbgView.setBackgroundDrawable(paramMessage);
              this.this$0.mPageView.bgDrawable = paramMessage;
              return;
            }
            ThemeDIYActivity.access$1200(this.this$0, paramMessage);
            return;
            ThemeDIYActivity.access$1300(this.this$0);
            return;
            if (paramMessage.obj == null)
            {
              this.this$0.saveOperate(false);
              return;
            }
            this.this$0.saveOperate(true);
            return;
          } while (paramMessage.obj == null);
          this.this$0.setProgressText(paramMessage.obj.toString());
          return;
          this.this$0.setProgessDialog(false, 0);
        } while (paramMessage.obj == null);
        QQToast.a(this.this$0.mContext, paramMessage.obj.toString(), 3600).b(this.this$0.mContext.getResources().getDimensionPixelSize(2131298998));
        return;
      } while (paramMessage.obj == null);
      QQToast.a(this.this$0.mContext, paramMessage.obj.toString(), 3600).b(this.this$0.mContext.getResources().getDimensionPixelSize(2131298998));
      return;
    } while (1 != paramMessage.arg1);
    this.this$0.setProgessDialog(false, 0);
    this.this$0.onUpdate(paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.11
 * JD-Core Version:    0.7.0.1
 */