package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout24
  extends AbsStructMsgItem
{
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1;
    Object localObject2;
    int i;
    if ((paramView != null) && ((paramView.getTag() instanceof StructMsgItemLayout24.ViewHolder)))
    {
      localObject1 = (RelativeLayout)paramView;
      ((RelativeLayout)localObject1).removeAllViews();
      localObject2 = (StructMsgItemLayout24.ViewHolder)paramView.getTag();
      ((StructMsgItemLayout24.ViewHolder)localObject2).a();
      paramView = (View)localObject1;
      localObject1 = localObject2;
    }
    else
    {
      paramView = new RelativeLayout(paramContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      i = AIOUtils.b(10.0F, paramContext.getResources());
      int j = AIOUtils.b(13.0F, paramContext.getResources());
      paramView.setPadding(j, i, j, AIOUtils.b(11.0F, paramContext.getResources()));
      localObject1 = new StructMsgItemLayout24.ViewHolder(null);
    }
    try
    {
      localObject2 = this.ax.iterator();
      i = 0;
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (AbsStructMsgElement)((Iterator)localObject2).next();
        if ("picture".equals(((AbsStructMsgElement)localObject3).b))
        {
          localObject3 = ((StructMsgItemCover)localObject3).a(paramContext, ((StructMsgItemLayout24.ViewHolder)localObject1).a, true, paramBundle);
          i = AIOUtils.b(30.0F, paramContext.getResources());
          paramView.addView((View)localObject3, new RelativeLayout.LayoutParams(i, i));
          ((StructMsgItemLayout24.ViewHolder)localObject1).a = ((View)localObject3);
          ((View)localObject3).setVisibility(0);
          i = 1;
        }
        else if ("title".equals(((AbsStructMsgElement)localObject3).b))
        {
          localObject3 = (TextView)((AbsStructMsgElement)localObject3).a(paramContext, ((StructMsgItemLayout24.ViewHolder)localObject1).b, paramBundle);
          ((TextView)localObject3).setGravity(16);
          paramView.addView((View)localObject3, new RelativeLayout.LayoutParams(-2, AIOUtils.b(30.0F, paramContext.getResources())));
          ((StructMsgItemLayout24.ViewHolder)localObject1).b = ((TextView)localObject3);
          ((TextView)localObject3).setVisibility(0);
        }
        else if ("summary".equals(((AbsStructMsgElement)localObject3).b))
        {
          ((StructMsgItemSummary)localObject3).c(2147483647);
          localObject3 = (TextView)((AbsStructMsgElement)localObject3).a(paramContext, ((StructMsgItemLayout24.ViewHolder)localObject1).c, paramBundle);
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
          localLayoutParams.topMargin = AIOUtils.b(34.0F, paramContext.getResources());
          localLayoutParams.bottomMargin = AIOUtils.b(3.0F, paramContext.getResources());
          paramView.addView((View)localObject3, localLayoutParams);
          ((StructMsgItemLayout24.ViewHolder)localObject1).c = ((TextView)localObject3);
          ((TextView)localObject3).setVisibility(0);
        }
      }
      if ((i != 0) && (((StructMsgItemLayout24.ViewHolder)localObject1).b != null)) {
        ((RelativeLayout.LayoutParams)((StructMsgItemLayout24.ViewHolder)localObject1).b.getLayoutParams()).leftMargin = AIOUtils.b(38.0F, paramContext.getResources());
      }
      paramView.setTag(localObject1);
      return paramView;
    }
    catch (Exception paramContext) {}
    return paramView;
  }
  
  protected int c()
  {
    return 24;
  }
  
  public String e()
  {
    return "layout24";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout24
 * JD-Core Version:    0.7.0.1
 */