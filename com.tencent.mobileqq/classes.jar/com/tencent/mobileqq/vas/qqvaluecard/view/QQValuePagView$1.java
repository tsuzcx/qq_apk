package com.tencent.mobileqq.vas.qqvaluecard.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.vas.qqvaluecard.bean.QQValueInfoItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGView;

class QQValuePagView$1
  implements Function1<View, Unit>
{
  QQValuePagView$1(QQValuePagView paramQQValuePagView) {}
  
  private boolean a(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (TextUtils.isEmpty(QQValuePagView.a(this.a))) {
      return false;
    }
    int j;
    label91:
    int i;
    if ((QQValuePagView.a(this.a) != QQValuePagView.a(this.a).a) || (QQValuePagView.a(this.a, QQValuePagView.a(this.a), QQValuePagView.b(this.a)) != 0) || ((QQValuePagView.b(this.a) == "setting") && (QQValuePagView.a(this.a) != QQValuePagView.c(this.a))))
    {
      j = 1;
      i = QQValuePagView.b(this.a, QQValuePagView.a(this.a), QQValuePagView.b(this.a));
      if ((j == 0) || (i == -2) || (QQValuePagView.a(this.a).a == QQValuePagView.b(this.a, QQValuePagView.a(this.a), "setting")) || (QQValuePagView.a(this.a).a == QQValuePagView.b(this.a, QQValuePagView.a(this.a), "card"))) {
        break label503;
      }
      if (QQValuePagView.a(this.a).a != i) {
        break label321;
      }
      i = 0;
    }
    for (;;)
    {
      label198:
      String str1;
      if (i == 1) {
        str1 = "up";
      }
      for (;;)
      {
        String str2 = QQValuePagView.a(this.a).c + str1;
        str1 = str2 + "/qqvalue.pag";
        str2 = str2 + "/number.ttf";
        if ((paramView.getLayoutParams().width > 0) && (j == 0)) {
          break;
        }
        if (((PAGView)paramView).getFile() != null)
        {
          this.a.b();
          return true;
          j = 0;
          break label91;
          label321:
          if (QQValuePagView.a(this.a).a > i)
          {
            i = 1;
            break label198;
          }
          i = -1;
          break label198;
          if (i != -1) {
            break label496;
          }
          str1 = "down";
          continue;
        }
        if (QQValuePagView.a(this.a, (PAGView)paramView, QQValuePagView.a(this.a), str2, str1))
        {
          QQValuePagView.a(this.a, QQValuePagView.a(this.a), QQValuePagView.b(this.a), i);
          QQValuePagView.b(this.a, QQValuePagView.a(this.a), QQValuePagView.b(this.a), QQValuePagView.a(this.a).a);
          QQValuePagView.a(this.a, QQValuePagView.a(this.a));
          QQValuePagView.a(this.a, QQValuePagView.a(this.a).a);
          paramLayoutParams.width = AIOUtils.a(QQValuePagView.a, paramView.getResources());
          paramView.postInvalidate();
          return false;
        }
        paramLayoutParams.width = 0;
        return false;
        label496:
        str1 = "nochange";
      }
      label503:
      i = 0;
    }
  }
  
  public Unit a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = new ViewGroup.LayoutParams(0, 0);
      paramView.setLayoutParams(localLayoutParams1);
    }
    localLayoutParams1.height = AIOUtils.a(QQValuePagView.b, paramView.getResources());
    if ((paramView instanceof PAGView))
    {
      if (a(paramView, localLayoutParams1)) {
        return Unit.INSTANCE;
      }
    }
    else {
      localLayoutParams1.width = 0;
    }
    return Unit.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView.1
 * JD-Core Version:    0.7.0.1
 */