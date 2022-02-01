package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout11
  extends AbsStructMsgItem
{
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = this;
    Resources localResources = paramContext.getResources();
    Object localObject2 = "";
    Object localObject3;
    float f;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof StructMsgItemLayout11.ViewHolder_11)))
    {
      localObject2 = (StructMsgItemLayout11.ViewHolder_11)paramView.getTag();
      localObject3 = ((StructMsgItemLayout11)localObject1).ax.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
        ((AbsStructMsgElement)localObject4).ar = ((StructMsgItemLayout11)localObject1).ar;
        localObject5 = ((AbsStructMsgElement)localObject4).b;
        if ("title".equals(localObject5))
        {
          localObject4 = (StructMsgItemTitle)localObject4;
          ((StructMsgItemTitle)localObject4).c("#ffffff");
          f = FontSettingManager.getFontLevel() / 16.0F;
          if (f > 1.0F)
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("");
            ((StringBuilder)localObject5).append((int)(36 / f));
            ((StructMsgItemTitle)localObject4).d(((StringBuilder)localObject5).toString());
          }
          else
          {
            ((StructMsgItemTitle)localObject4).d(String.valueOf(36));
          }
          ((StructMsgItemTitle)localObject4).a(paramContext, ((StructMsgItemLayout11.ViewHolder_11)localObject2).b, paramBundle);
        }
        else if ("pavideo".equals(localObject5))
        {
          ((AbsStructMsgElement)localObject4).a(paramContext, ((StructMsgItemLayout11.ViewHolder_11)localObject2).a, paramBundle);
        }
      }
      if ((localObject2 != null) && (((StructMsgItemLayout11.ViewHolder_11)localObject2).b != null)) {
        ((TextView)((StructMsgItemLayout11.ViewHolder_11)localObject2).b).setMaxLines(2);
      }
      return paramView;
    }
    Object localObject4 = new RelativeLayout(paramContext);
    double d = BaseChatItemLayout.b - AIOUtils.b(46.0F, localResources);
    Double.isNaN(d);
    int i = (int)(d / 1.8D) + AIOUtils.b(30.0F, localResources);
    ((RelativeLayout)localObject4).setLayoutParams(new RelativeLayout.LayoutParams(-1, i));
    int j = AIOUtils.b(15.0F, localResources);
    ((RelativeLayout)localObject4).setPadding(j, j, j, j);
    Object localObject5 = new StructMsgItemLayout11.ViewHolder_11();
    Iterator localIterator = ((StructMsgItemLayout11)localObject1).ax.iterator();
    paramView = null;
    for (localObject1 = null; localIterator.hasNext(); localObject1 = localObject3)
    {
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)localIterator.next();
      localAbsStructMsgElement.ar = this.ar;
      String str = localAbsStructMsgElement.b;
      if ("title".equals(str))
      {
        localObject1 = (StructMsgItemTitle)localAbsStructMsgElement;
        ((StructMsgItemTitle)localObject1).c("#ffffff");
        f = FontSettingManager.getFontLevel() / 16.0F;
        if (f > 1.0F)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append((int)(36 / f));
          ((StructMsgItemTitle)localObject1).d(((StringBuilder)localObject3).toString());
        }
        else
        {
          ((StructMsgItemTitle)localObject1).d(String.valueOf(36));
        }
        localObject3 = ((StructMsgItemTitle)localObject1).a(paramContext, null, paramBundle);
        ((View)localObject3).setId(1001);
      }
      else
      {
        localObject3 = localObject1;
        if ("pavideo".equals(str))
        {
          paramView = localAbsStructMsgElement.a(paramContext, null, paramBundle);
          paramView.setId(1003);
          localObject3 = localObject1;
        }
      }
    }
    if (paramView != null) {
      ((RelativeLayout)localObject4).addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
    }
    paramBundle = new View(paramContext);
    d = i;
    Double.isNaN(d);
    i = (int)(d * 0.32D);
    paramBundle.setBackgroundResource(2130842753);
    localObject2 = new RelativeLayout.LayoutParams(-1, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((RelativeLayout)localObject4).addView(paramBundle, (ViewGroup.LayoutParams)localObject2);
    if (localObject1 != null)
    {
      paramBundle = new RelativeLayout.LayoutParams(-1, -2);
      paramBundle.addRule(12, -1);
      paramBundle.bottomMargin = AIOUtils.b(11.5F, localResources);
      paramBundle.leftMargin = AIOUtils.b(20.0F, localResources);
      paramBundle.rightMargin = AIOUtils.b(20.0F, localResources);
      ((RelativeLayout)localObject4).addView((View)localObject1, paramBundle);
    }
    paramBundle = new RelativeLayout.LayoutParams(AIOUtils.b(52.5F, localResources), AIOUtils.b(52.5F, localResources));
    paramBundle.addRule(15, -1);
    paramContext = new ImageView(paramContext);
    paramContext.setImageResource(2130842671);
    paramContext.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    paramBundle.addRule(14, -1);
    ((RelativeLayout)localObject4).addView(paramContext, paramBundle);
    if (paramView != null) {
      ((StructMsgItemLayout11.ViewHolder_11)localObject5).a = paramView;
    }
    if (localObject1 != null)
    {
      ((StructMsgItemLayout11.ViewHolder_11)localObject5).b = ((View)localObject1);
      ((TextView)((StructMsgItemLayout11.ViewHolder_11)localObject5).b).setMaxLines(1);
    }
    ((RelativeLayout)localObject4).setTag(localObject5);
    return localObject4;
  }
  
  protected int c()
  {
    return 11;
  }
  
  public String e()
  {
    return "Layout11";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout11
 * JD-Core Version:    0.7.0.1
 */