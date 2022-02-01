package com.tencent.mobileqq.kandian.biz.ugc;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
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
    this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowVisibleDisplayFrame((Rect)localObject);
    int j = this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer.getRootView().getHeight();
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
    if (bool != this.a.k)
    {
      if (i > this.a.e) {
        this.a.e = i;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGlobalLayout mMAXExternalPanelheight:");
        ((StringBuilder)localObject).append(this.a.e);
        QLog.d("ReadInJoyBaseDeliverActivity", 2, ((StringBuilder)localObject).toString());
      }
      i = ViewUtils.b(this.a.f);
      j = j - ImmersiveUtils.getStatusBarHeight(this.a) - this.a.getTitleBarHeight() - this.a.e;
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
      this.a.jdField_a_of_type_AndroidWidgetEditText.setMaxHeight(k);
    }
    this.a.k = bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.2
 * JD-Core Version:    0.7.0.1
 */