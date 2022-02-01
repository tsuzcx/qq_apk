package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.qwallet.widget.MyLinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

class QQCustomDialogWtihInputAndChoose$6$1
  implements Runnable
{
  QQCustomDialogWtihInputAndChoose$6$1(QQCustomDialogWtihInputAndChoose.6 param6) {}
  
  public void run()
  {
    int k = this.a.this$0.a(this.a.this$0.e);
    int m = this.a.this$0.a(this.a.this$0.j);
    int n = this.a.this$0.j.getHeight();
    Object localObject1 = this.a.this$0.getWindow().getAttributes();
    int i;
    if (k - n > 0) {
      i = this.a.this$0.e.getHeight() / 2;
    } else {
      i = m + n - k;
    }
    ((WindowManager.LayoutParams)localObject1).y = (-i);
    this.a.this$0.getWindow().setAttributes((WindowManager.LayoutParams)localObject1);
    boolean bool = this.a.this$0.n;
    int j = 0;
    Object localObject2;
    if ((bool) && (this.a.this$0.c.getText() != null) && (TextUtils.isEmpty(this.a.this$0.c.getText().toString())))
    {
      localObject1 = (LinearLayout)this.a.this$0.e.findViewById(2131437275);
      if ((localObject1 != null) && (((LinearLayout)localObject1).getChildCount() > 0))
      {
        localObject1 = ((LinearLayout)localObject1).getChildAt(0);
        localObject2 = (TextView)((View)localObject1).findViewById(2131437274);
        if (((TextView)localObject2).getText() != null) {
          this.a.this$0.a(((TextView)localObject2).getText().toString());
        }
        localObject1 = ((View)localObject1).findViewById(2131437273);
        ((View)localObject1).setVisibility(0);
        this.a.this$0.r = ((View)localObject1);
        this.a.this$0.n = false;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = (Context)this.a.this$0.a.get();
      if (localObject1 != null) {
        j = ((Context)localObject1).getResources().getDisplayMetrics().heightPixels;
      }
      localObject2 = new StringBuilder(128);
      if (localObject1 == null) {
        ((StringBuilder)localObject2).append("|context is null");
      } else {
        ((StringBuilder)localObject2).append("|context is not null");
      }
      ((StringBuilder)localObject2).append("|screenHeight=");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append("|emoSpaceY=");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append("|dialogY=");
      ((StringBuilder)localObject2).append(m);
      ((StringBuilder)localObject2).append("|dialogHeight=");
      ((StringBuilder)localObject2).append(n);
      ((StringBuilder)localObject2).append("|moveY=");
      ((StringBuilder)localObject2).append(i);
      QLog.d("QQCustomDialogWtihInputAndChoose.meassure", 2, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihInputAndChoose.6.1
 * JD-Core Version:    0.7.0.1
 */