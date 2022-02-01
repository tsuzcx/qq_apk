package com.tencent.mobileqq.kandian.biz.ugc;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.kandian.biz.biu.BiuEditText;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.immersive.ImmersiveUtils;

class ReadInJoyBaseDeliverActivity$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadInJoyBaseDeliverActivity$2(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.j.getWindowVisibleDisplayFrame((Rect)localObject);
    int j = this.a.j.getRootView().getHeight();
    int i = j - ((Rect)localObject).height();
    boolean bool;
    if (i > 100) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGlobalLayout screenHeight:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", ExternalPanelheight:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", isShowKeybroad:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ReadInJoyBaseDeliverActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (bool != this.a.F)
    {
      if (i > this.a.D) {
        this.a.D = i;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGlobalLayout mMAXExternalPanelheight:");
        ((StringBuilder)localObject).append(this.a.D);
        QLog.d("ReadInJoyBaseDeliverActivity", 2, ((StringBuilder)localObject).toString());
      }
      i = ViewUtils.dpToPx(this.a.E);
      j = j - ImmersiveUtils.getStatusBarHeight(this.a) - this.a.getTitleBarHeight() - this.a.D;
      int k = j - i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGlobalLayout contentHeight:");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", fixedHeight:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", maxHeight:");
        ((StringBuilder)localObject).append(k);
        QLog.d("ReadInJoyBaseDeliverActivity", 2, ((StringBuilder)localObject).toString());
      }
      this.a.e.setMaxHeight(k);
    }
    this.a.F = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.2
 * JD-Core Version:    0.7.0.1
 */