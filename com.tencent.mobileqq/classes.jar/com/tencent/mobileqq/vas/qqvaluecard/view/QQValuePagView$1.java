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
    boolean bool = QQValuePagView.b(this.a);
    int i = QQValuePagView.a(this.a, 0, bool);
    if (i == 1) {
      str = "up";
    } else if (i == -1) {
      str = "down";
    } else {
      str = "nochange";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(QQValuePagView.c(this.a).h);
    ((StringBuilder)localObject).append(str);
    String str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("/qqvalue.pag");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/number.ttf");
    str = localStringBuilder.toString();
    int j = paramView.getLayoutParams().width;
    return QQValuePagView.a(this.a, paramView, paramLayoutParams, i, bool, (String)localObject, str, j);
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
    localLayoutParams1.height = AIOUtils.b(QQValuePagView.b, paramView.getResources());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qqvaluecard.view.QQValuePagView.1
 * JD-Core Version:    0.7.0.1
 */