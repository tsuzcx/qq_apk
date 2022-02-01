package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.SoftReference;

class QQCustomDialogWtihEmoticonInput$9$1
  implements Runnable
{
  QQCustomDialogWtihEmoticonInput$9$1(QQCustomDialogWtihEmoticonInput.9 param9) {}
  
  public void run()
  {
    int k = this.a.this$0.a(this.a.a);
    int m = this.a.this$0.a(this.a.this$0.x);
    int n = this.a.this$0.x.getHeight();
    int i = m + n;
    int j;
    if (k - i > 0)
    {
      i = this.a.a.getHeight() / 2;
    }
    else
    {
      if (this.a.this$0.m)
      {
        j = ImmersiveUtils.getStatusBarHeight(this.a.this$0.getContext());
        j = (k - n - j) / 2 + j;
        if (j < m)
        {
          i = m - j;
          break label162;
        }
        i -= k;
        j = ViewUtils.dip2px(10.0F);
      }
      else
      {
        i -= k;
        j = ViewUtils.dip2px(10.0F);
      }
      i += j;
    }
    label162:
    Object localObject = this.a.this$0.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).y = (-i);
    this.a.this$0.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    if (i > m)
    {
      localObject = this.a.this$0.x.getLayoutParams();
      if (localObject != null)
      {
        ((ViewGroup.LayoutParams)localObject).height = (k - ImmersiveUtils.getStatusBarHeight(this.a.this$0.getContext()) - ViewUtils.dip2px(10.0F));
        this.a.this$0.x.requestLayout();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = (Context)this.a.this$0.k.get();
      j = 0;
      if (localObject != null) {
        j = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
      }
      StringBuilder localStringBuilder = new StringBuilder(128);
      if (localObject == null) {
        localStringBuilder.append("|context is null");
      } else {
        localStringBuilder.append("|context is not null");
      }
      localStringBuilder.append("|screenHeight=");
      localStringBuilder.append(j);
      localStringBuilder.append("|emoSpaceY=");
      localStringBuilder.append(k);
      localStringBuilder.append("|dialogY=");
      localStringBuilder.append(m);
      localStringBuilder.append("|dialogHeight=");
      localStringBuilder.append(n);
      localStringBuilder.append("|moveY=");
      localStringBuilder.append(i);
      QLog.d("QQCustomDialogWtihEmoticonInput.meassure", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.9.1
 * JD-Core Version:    0.7.0.1
 */