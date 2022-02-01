package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import atmx;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
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
    int k = atmx.a(this.a.this$0, atmx.a(this.a.this$0));
    int m = atmx.a(this.a.this$0, atmx.a(this.a.this$0));
    int n = atmx.a(this.a.this$0).getHeight();
    int i1 = ImmersiveUtils.getStatusBarHeight(this.a.this$0.getContext());
    int i;
    int j;
    StringBuilder localStringBuilder;
    if (k - (m + n) > 0)
    {
      i = atmx.a(this.a.this$0).getHeight() / 2;
      Object localObject = this.a.this$0.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).y = (-i);
      this.a.this$0.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      if (i > m - i1)
      {
        localObject = atmx.a(this.a.this$0).getLayoutParams();
        if (localObject != null)
        {
          ((ViewGroup.LayoutParams)localObject).height = (k - ImmersiveUtils.getStatusBarHeight(this.a.this$0.getContext()) - ViewUtils.dip2px(10.0F));
          atmx.a(this.a.this$0).requestLayout();
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = (Context)atmx.a(this.a.this$0).get();
        j = 0;
        if (localObject != null) {
          j = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
        }
        localStringBuilder = new StringBuilder(128);
        if (localObject != null) {
          break label388;
        }
        localStringBuilder.append("|context is null");
      }
    }
    for (;;)
    {
      localStringBuilder.append("|screenHeight=").append(j).append("|statusBarHeight=").append(i1).append("|emoSpaceY=").append(k).append("|dialogY=").append(m).append("|dialogHeight=").append(n).append("|moveY=").append(i);
      QLog.d("QQCustomDialogWtihEmoticonInput.meassure", 2, localStringBuilder.toString());
      return;
      i = (k - n - i1) / 2 + i1;
      if (i < m)
      {
        i = m - i;
        break;
      }
      i = m + n - k + ViewUtils.dip2px(10.0F);
      break;
      label388:
      localStringBuilder.append("|context is not null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardNewVersionDialog.8.1
 * JD-Core Version:    0.7.0.1
 */