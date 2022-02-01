package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
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

public class StructMsgItemLayout23
  extends AbsStructMsgItem
{
  private LinearLayout a(Context paramContext)
  {
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.gravity = 17;
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject4;
    if ((paramView != null) && ((paramView instanceof LinearLayout)) && ((paramView.getTag() instanceof StructMsgItemLayout23.ViewHolder_23)))
    {
      localObject1 = (StructMsgItemLayout23.ViewHolder_23)paramView.getTag();
      localObject2 = this.ax.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (AbsStructMsgElement)((Iterator)localObject2).next();
        if ("button".equals(((AbsStructMsgElement)localObject4).b))
        {
          localObject3 = (TextView)((AbsStructMsgElement)localObject4).a(paramContext, ((StructMsgItemLayout23.ViewHolder_23)localObject1).a, paramBundle);
          localObject4 = (StructMsgItemButton)localObject4;
          if (TextUtils.isEmpty(((StructMsgItemButton)localObject4).k())) {
            ((TextView)localObject3).setTextSize(16.0F);
          }
          if (TextUtils.isEmpty(((StructMsgItemButton)localObject4).l())) {
            ((TextView)localObject3).setTextColor(Color.parseColor("#12b7f5"));
          }
        }
      }
      return paramView;
    }
    Object localObject1 = a(paramContext);
    Object localObject2 = new StructMsgItemLayout23.ViewHolder_23();
    Object localObject3 = this.ax.iterator();
    paramView = null;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
      if ("button".equals(((AbsStructMsgElement)localObject4).b))
      {
        paramView = (TextView)((AbsStructMsgElement)localObject4).a(paramContext, null, paramBundle);
        localObject4 = (StructMsgItemButton)localObject4;
        if (TextUtils.isEmpty(((StructMsgItemButton)localObject4).k())) {
          paramView.setTextSize(16.0F);
        }
        if (TextUtils.isEmpty(((StructMsgItemButton)localObject4).l())) {
          paramView.setTextColor(Color.parseColor("#12b7f5"));
        }
        localObject4 = new LinearLayout.LayoutParams(-1, AIOUtils.b(41.0F, paramContext.getResources()));
        ((LinearLayout.LayoutParams)localObject4).gravity = 17;
        ((LinearLayout)localObject1).addView(paramView, (ViewGroup.LayoutParams)localObject4);
      }
    }
    if (paramView != null) {
      ((StructMsgItemLayout23.ViewHolder_23)localObject2).a = paramView;
    }
    ((LinearLayout)localObject1).setTag(localObject2);
    return localObject1;
  }
  
  protected int c()
  {
    return 23;
  }
  
  public String e()
  {
    return "layout23";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout23
 * JD-Core Version:    0.7.0.1
 */