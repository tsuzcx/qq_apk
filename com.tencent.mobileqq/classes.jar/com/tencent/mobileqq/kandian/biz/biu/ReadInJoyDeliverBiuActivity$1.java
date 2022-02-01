package com.tencent.mobileqq.kandian.biz.biu;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

class ReadInJoyDeliverBiuActivity$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ReadInJoyDeliverBiuActivity$1(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    ReadInJoyDeliverBiuActivity.a(this.a).getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ReadInJoyDeliverBiuActivity.b(this.a).getRootView().getHeight();
    int j = i - ((Rect)localObject).height();
    boolean bool;
    if (j > 100) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGlobalLayout screenHeight:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", ExternalPanelheight:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", isShowKeybroad:");
      ((StringBuilder)localObject).append(bool);
      QLog.d("ReadInJoyDeliverBiuActivity", 2, ((StringBuilder)localObject).toString());
    }
    i = ReadInJoyDeliverBiuActivity.c(this.a).getHeight();
    if (bool != ReadInJoyDeliverBiuActivity.d(this.a))
    {
      if (j > ReadInJoyDeliverBiuActivity.e(this.a)) {
        ReadInJoyDeliverBiuActivity.a(this.a, j);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGlobalLayout mMAXExternalPanelheight:");
        ((StringBuilder)localObject).append(ReadInJoyDeliverBiuActivity.f(this.a));
        QLog.d("ReadInJoyDeliverBiuActivity", 2, ((StringBuilder)localObject).toString());
      }
      j = i - ReadInJoyDeliverBiuActivity.g(this.a);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGlobalLayout contentHeight:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", fixedHeight:");
        ((StringBuilder)localObject).append(ReadInJoyDeliverBiuActivity.h(this.a));
        ((StringBuilder)localObject).append(", maxHeight:");
        ((StringBuilder)localObject).append(j);
        QLog.d("ReadInJoyDeliverBiuActivity", 2, ((StringBuilder)localObject).toString());
      }
      ReadInJoyDeliverBiuActivity.i(this.a).setMaxHeight(j);
      ReadInJoyDeliverBiuActivity.a(this.a, bool);
      localObject = this.a;
      if (i < ReadInJoyDeliverBiuActivity.j((ReadInJoyDeliverBiuActivity)localObject)) {
        j = i;
      } else {
        j = ReadInJoyDeliverBiuActivity.j(this.a);
      }
      ReadInJoyDeliverBiuActivity.b((ReadInJoyDeliverBiuActivity)localObject, j);
      localObject = this.a;
      if (i <= ReadInJoyDeliverBiuActivity.k((ReadInJoyDeliverBiuActivity)localObject)) {
        i = ReadInJoyDeliverBiuActivity.k(this.a);
      }
      ReadInJoyDeliverBiuActivity.c((ReadInJoyDeliverBiuActivity)localObject, i);
    }
    else if ((ReadInJoyDeliverBiuActivity.l(this.a) != ReadInJoyDeliverBiuActivity.m(this.a)) && (i == ReadInJoyDeliverBiuActivity.k(this.a)))
    {
      i -= ReadInJoyDeliverBiuActivity.m(this.a);
      j = i - ReadInJoyDeliverBiuActivity.n(this.a);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGlobalLayout contentHeight:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", fixedHeight:");
        ((StringBuilder)localObject).append(ReadInJoyDeliverBiuActivity.o(this.a));
        ((StringBuilder)localObject).append(", maxHeight:");
        ((StringBuilder)localObject).append(j);
        QLog.d("ReadInJoyDeliverBiuActivity", 2, ((StringBuilder)localObject).toString());
      }
      ReadInJoyDeliverBiuActivity.p(this.a).setMaxHeight(j);
    }
    localObject = this.a;
    ReadInJoyDeliverBiuActivity.d((ReadInJoyDeliverBiuActivity)localObject, ReadInJoyDeliverBiuActivity.m((ReadInJoyDeliverBiuActivity)localObject));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGlobalLayout mExternalPanelheight:");
      ((StringBuilder)localObject).append(ReadInJoyDeliverBiuActivity.l(this.a));
      QLog.d("ReadInJoyDeliverBiuActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity.1
 * JD-Core Version:    0.7.0.1
 */