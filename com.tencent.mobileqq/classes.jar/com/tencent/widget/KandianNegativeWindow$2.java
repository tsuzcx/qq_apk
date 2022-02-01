package com.tencent.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class KandianNegativeWindow$2
  implements View.OnClickListener
{
  KandianNegativeWindow$2(KandianNegativeWindow paramKandianNegativeWindow) {}
  
  public void onClick(View paramView)
  {
    KandianNegativeWindow localKandianNegativeWindow;
    switch (paramView.getId())
    {
    default: 
      this.a.dismiss();
      break;
    case 2131439189: 
      this.a.c(paramView);
      this.a.e();
      localKandianNegativeWindow = this.a;
      localKandianNegativeWindow.M = 3;
      localKandianNegativeWindow.N = HardCodeUtil.a(2131903881);
      KandianNegativeWindow.a(this.a, paramView.getTag(), true);
      break;
    case 2131439187: 
      this.a.c.setData(this.a.i, HardCodeUtil.a(2131903877), this.a.R);
      this.a.a(true);
      localKandianNegativeWindow = this.a;
      localKandianNegativeWindow.M = 1;
      localKandianNegativeWindow.N = HardCodeUtil.a(2131903882);
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      break;
    case 2131439186: 
      this.a.c(paramView);
      this.a.e();
      localKandianNegativeWindow = this.a;
      localKandianNegativeWindow.M = 4;
      localKandianNegativeWindow.N = localKandianNegativeWindow.L;
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      break;
    case 2131439185: 
      this.a.c(paramView);
      this.a.e();
      localKandianNegativeWindow = this.a;
      localKandianNegativeWindow.M = 5;
      localKandianNegativeWindow.N = BaseApplicationImpl.getContext().getString(2131915414);
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      break;
    case 2131439182: 
      this.a.d.getLayoutParams();
      this.a.d.getParent();
      this.a.c.setData(this.a.j, HardCodeUtil.a(2131903876), this.a.R);
      this.a.a(true);
      localKandianNegativeWindow = this.a;
      localKandianNegativeWindow.M = 2;
      localKandianNegativeWindow.N = HardCodeUtil.a(2131903885);
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      break;
    case 2131437082: 
      this.a.a(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.KandianNegativeWindow.2
 * JD-Core Version:    0.7.0.1
 */