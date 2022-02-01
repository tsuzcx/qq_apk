package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.SoftReference;

class ForwardNewVersionDialog$8$1
  implements Runnable
{
  ForwardNewVersionDialog$8$1(ForwardNewVersionDialog.8 param8) {}
  
  public void run()
  {
    int k = ForwardNewVersionDialog.a(this.a.this$0, ForwardNewVersionDialog.f(this.a.this$0).getView());
    int m = ForwardNewVersionDialog.a(this.a.this$0, ForwardNewVersionDialog.j(this.a.this$0));
    int n = ForwardNewVersionDialog.j(this.a.this$0).getHeight();
    int i = m + n;
    int i1 = ImmersiveUtils.getStatusBarHeight(this.a.this$0.getContext());
    int j;
    if (k - i > 0)
    {
      i = ForwardNewVersionDialog.f(this.a.this$0).getView().getHeight() / 2;
    }
    else
    {
      j = (k - n - i1) / 2 + i1;
      if (j < m) {
        i = m - j;
      } else {
        i = i - k + ViewUtils.dip2px(10.0F);
      }
    }
    Object localObject = this.a.this$0.getWindow().getAttributes();
    ((WindowManager.LayoutParams)localObject).y = (-i);
    this.a.this$0.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
    if (i > m - i1)
    {
      localObject = ForwardNewVersionDialog.j(this.a.this$0).getLayoutParams();
      if (localObject != null)
      {
        ((ViewGroup.LayoutParams)localObject).height = (k - ImmersiveUtils.getStatusBarHeight(this.a.this$0.getContext()) - ViewUtils.dip2px(10.0F));
        ForwardNewVersionDialog.j(this.a.this$0).requestLayout();
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = (Context)ForwardNewVersionDialog.k(this.a.this$0).get();
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
      localStringBuilder.append("|statusBarHeight=");
      localStringBuilder.append(i1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.8.1
 * JD-Core Version:    0.7.0.1
 */