package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import bhpy;
import bhtq;
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
    int m = this.a.this$0.a(this.a.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout);
    int n = this.a.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
    int i;
    int j;
    StringBuilder localStringBuilder;
    if (k - (m + n) > 0)
    {
      i = this.a.a.getHeight() / 2;
      Object localObject = this.a.this$0.getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject).y = (-i);
      this.a.this$0.getWindow().setAttributes((WindowManager.LayoutParams)localObject);
      if (i > m)
      {
        localObject = this.a.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        if (localObject != null)
        {
          ((ViewGroup.LayoutParams)localObject).height = (k - ImmersiveUtils.getStatusBarHeight(this.a.this$0.getContext()) - bhtq.a(10.0F));
          this.a.this$0.jdField_a_of_type_AndroidWidgetRelativeLayout.requestLayout();
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = (Context)this.a.this$0.jdField_a_of_type_JavaLangRefSoftReference.get();
        j = 0;
        if (localObject != null) {
          j = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
        }
        localStringBuilder = new StringBuilder(128);
        if (localObject != null) {
          break label396;
        }
        localStringBuilder.append("|context is null");
      }
    }
    for (;;)
    {
      localStringBuilder.append("|screenHeight=").append(j).append("|emoSpaceY=").append(k).append("|dialogY=").append(m).append("|dialogHeight=").append(n).append("|moveY=").append(i);
      QLog.d("QQCustomDialogWtihEmoticonInput.meassure", 2, localStringBuilder.toString());
      return;
      if (this.a.this$0.jdField_a_of_type_Boolean)
      {
        i = ImmersiveUtils.getStatusBarHeight(this.a.this$0.getContext());
        i += (k - n - i) / 2;
        if (i < m) {}
        for (i = m - i;; i = m + n - k + bhtq.a(10.0F)) {
          break;
        }
      }
      i = m + n - k + bhtq.a(10.0F);
      break;
      label396:
      localStringBuilder.append("|context is not null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput.9.1
 * JD-Core Version:    0.7.0.1
 */