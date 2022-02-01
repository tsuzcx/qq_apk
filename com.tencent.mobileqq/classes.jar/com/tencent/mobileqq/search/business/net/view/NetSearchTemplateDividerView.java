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
  public final int a;
  public Context a;
  public View a;
  
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
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("type is illegal, type = ");
        localStringBuilder.append(0);
        QLog.e(str, 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_Int = i;
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append(jdField_a_of_type_JavaLangString);
    paramContext.append("type is illegal, type = ");
    paramContext.append(paramInt);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public View a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      return localObject;
    }
    boolean bool = ThemeUtil.isInNightMode(MobileQQ.sMobileQQ.peekAppRuntime());
    localObject = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i == 2) {
        ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 18.0F)));
      }
    }
    else
    {
      ((RelativeLayout)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 12.0F)));
      View localView = new View(this.jdField_a_of_type_AndroidContentContext);
      if (bool) {
        localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166985));
      } else {
        localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166984));
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, 1);
      localLayoutParams.addRule(15);
      localLayoutParams.leftMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
      localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
      ((RelativeLayout)localObject).addView(localView, localLayoutParams);
    }
    if (bool) {
      ((RelativeLayout)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166974));
    } else {
      ((RelativeLayout)localObject).setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
    }
    this.jdField_a_of_type_AndroidViewView = ((View)localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.business.net.view.NetSearchTemplateDividerView
 * JD-Core Version:    0.7.0.1
 */