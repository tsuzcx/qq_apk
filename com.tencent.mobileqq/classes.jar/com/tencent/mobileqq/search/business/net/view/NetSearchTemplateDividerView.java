package com.tencent.mobileqq.search.business.net.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.search.base.view.IView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class NetSearchTemplateDividerView
  implements IView
{
  public static final String a = "NetSearchTemplateDividerView";
  public final int b;
  public View c;
  public Context d;
  
  public NetSearchTemplateDividerView(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      int i;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt <= 2) {}
      }
      else
      {
        i = 0;
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("type is illegal, type = ");
        localStringBuilder.append(0);
        QLog.e(str, 1, localStringBuilder.toString());
      }
      this.d = paramContext;
      this.b = i;
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append(a);
    paramContext.append("type is illegal, type = ");
    paramContext.append(paramInt);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public View h()
  {
    Object localObject = this.c;
    if (localObject != null) {
      return localObject;
    }
    boolean bool = ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime());
    localObject = new RelativeLayout(this.d);
    int i = this.b;
    if (i != 1)
    {
      if (i == 2) {
        ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, DisplayUtil.a(this.d, 18.0F)));
      }
    }
    else
    {
      ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, DisplayUtil.a(this.d, 12.0F)));
      View localView = new View(this.d);
      if (bool) {
        localView.setBackgroundColor(this.d.getResources().getColor(2131167919));
      } else {
        localView.setBackgroundColor(this.d.getResources().getColor(2131167918));
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(15);
      localLayoutParams.leftMargin = DisplayUtil.a(this.d, 15.0F);
      localLayoutParams.rightMargin = DisplayUtil.a(this.d, 15.0F);
      ((RelativeLayout)localObject).addView(localView, localLayoutParams);
    }
    if (bool) {
      ((RelativeLayout)localObject).setBackgroundColor(this.d.getResources().getColor(2131167908));
    } else {
      ((RelativeLayout)localObject).setBackgroundColor(this.d.getResources().getColor(2131168464));
    }
    this.c = ((View)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateDividerView
 * JD-Core Version:    0.7.0.1
 */