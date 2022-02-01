package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout22
  extends AbsStructMsgItem
{
  private LinearLayout a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i = AIOUtils.b(12.0F, paramContext.getResources());
    localLinearLayout.setPadding(i, i, i, i);
    localLinearLayout.setLayoutParams(localLayoutParams);
    return localLinearLayout;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
    }
    else
    {
      paramView = a(paramContext);
    }
    Iterator localIterator = this.ax.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (AbsStructMsgElement)localIterator.next();
      Object localObject2 = ((AbsStructMsgElement)localObject1).b;
      ((AbsStructMsgElement)localObject1).ar = this.ar;
      if ("title".equals(localObject2))
      {
        localObject2 = (StructMsgItemTitle)localObject1;
        ((StructMsgItemTitle)localObject2).a(d(), this.av);
        localObject1 = (TextView)((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
        ((TextView)localObject1).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject1).setMaxLines(2);
        if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).k())) {
          ((TextView)localObject1).setTextSize(18.0F);
        }
        if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).l())) {
          ((TextView)localObject1).setTextColor(Color.parseColor("#000000"));
        }
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(12.0F, paramContext.getResources());
        paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
      else if ("picture".equals(localObject2))
      {
        localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
        int i = AIOUtils.b(50.0F, paramContext.getResources());
        paramView.addView((View)localObject1, new LinearLayout.LayoutParams(i, i));
      }
    }
    return paramView;
  }
  
  protected int c()
  {
    return 22;
  }
  
  public String e()
  {
    return "layout22";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout22
 * JD-Core Version:    0.7.0.1
 */