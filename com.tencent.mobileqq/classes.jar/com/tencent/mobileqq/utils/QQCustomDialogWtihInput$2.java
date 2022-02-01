package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.SoftReference;

class QQCustomDialogWtihInput$2
  implements View.OnClickListener
{
  QQCustomDialogWtihInput$2(QQCustomDialogWtihInput paramQQCustomDialogWtihInput, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick timeGap:" + (System.currentTimeMillis() - QQCustomDialogWtihInput.access$000(this.this$0)) + " MANUFACTURER:" + Build.MANUFACTURER + " MODEL:" + Build.MODEL);
    }
    if ((System.currentTimeMillis() - QQCustomDialogWtihInput.access$000(this.this$0) < 800L) && (QQCustomDialogWtihInput.access$100(this.this$0))) {
      if (QLog.isColorLevel()) {
        QLog.d("QQCustomDialogWtihInput", 2, "setPositiveButton onClick skip");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      Object localObject = QQCustomDialogWtihInput.access$200(this.this$0).getText().toString();
      if (localObject != null) {
        if ((QQText.containsEmoji((String)localObject)) || (QQText.containsExpression((String)localObject)))
        {
          localObject = (Context)QQCustomDialogWtihInput.access$300(this.this$0).get();
          if (localObject != null)
          {
            localObject = new QQToast((Context)localObject);
            ((QQToast)localObject).d(2000);
            ((QQToast)localObject).c(2131719009);
            ((QQToast)localObject).a();
          }
        }
        else if ((QQCustomDialogWtihInput.access$400(this.this$0) == null) && (24 < ((String)localObject).getBytes().length))
        {
          localObject = (Context)QQCustomDialogWtihInput.access$300(this.this$0).get();
          if (localObject != null)
          {
            localObject = new QQToast((Context)localObject);
            ((QQToast)localObject).d(2000);
            ((QQToast)localObject).c(2131719010);
            ((QQToast)localObject).a();
          }
        }
        else
        {
          if (this.val$nl != null) {
            this.val$nl.onClick(this.this$0, 1);
          }
          this.this$0.dismiss();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInput.2
 * JD-Core Version:    0.7.0.1
 */