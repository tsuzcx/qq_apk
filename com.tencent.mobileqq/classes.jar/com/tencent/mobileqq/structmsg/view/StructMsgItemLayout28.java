package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgItemVoice;
import com.tencent.mobileqq.troop.robot.RobotResourcesManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class StructMsgItemLayout28
  extends AbsStructMsgItem
{
  static ColorDrawable aA = new ColorDrawable(Color.parseColor("#8C6CF5"));
  static HashMap<Integer, ColorDrawable> az = new HashMap();
  AnimationDrawable aB;
  public int aC = -1;
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject2 = null;
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramContext).inflate(2131626751, null);
      paramBundle = new StructMsgItemLayout28.ViewHolder(this);
      paramBundle.a = ((BubbleImageView)localView.findViewById(2131429416));
      paramBundle.a.setRadius(13.0F);
      paramBundle.b = ((ImageView)localView.findViewById(2131446287));
      paramBundle.c = ((TextView)localView.findViewById(2131446176));
      paramBundle.e = ((TextView)localView.findViewById(2131447533));
      paramBundle.d = ((ImageView)localView.findViewById(2131446175));
      localView.setTag(this.aC, paramBundle);
      localView.setOnClickListener(this);
    }
    else
    {
      paramBundle = (StructMsgItemLayout28.ViewHolder)paramView.getTag(this.aC);
      localView = paramView;
    }
    Object localObject1 = (ColorDrawable)az.get(Integer.valueOf(this.av));
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      paramView = (View)localObject1;
      if (this.av != 0)
      {
        paramView = new ColorDrawable(this.av);
        az.put(Integer.valueOf(this.av), paramView);
      }
    }
    localObject1 = paramView;
    if (paramView == null) {
      localObject1 = aA;
    }
    paramBundle.a.setImageDrawable((Drawable)localObject1);
    Iterator localIterator = this.ax.iterator();
    paramView = null;
    localObject1 = localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (AbsStructMsgElement)localIterator.next();
      Object localObject3 = ((AbsStructMsgElement)localObject2).b;
      if ("title".equals(localObject3))
      {
        localObject3 = (StructMsgItemTitle)localObject2;
        paramBundle.e.setText(((StructMsgItemTitle)localObject3).aA);
      }
      else
      {
        Object localObject4;
        if ("picture".equals(localObject3))
        {
          localObject3 = ((StructMsgItemCover)localObject2).av;
          try
          {
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label473;
            }
            localObject4 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((int)DisplayUtils.a(paramContext, 62.5F));
            ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((int)DisplayUtils.a(paramContext, 115.0F));
            localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
            paramBundle.b.setImageDrawable((Drawable)localObject3);
            paramBundle.b.setVisibility(0);
          }
          catch (Exception localException)
          {
            QLog.e("Q.robot.StructMsg", 1, localException, new Object[0]);
            paramBundle.b.setVisibility(4);
          }
        }
        else if ("voice".equals(localException))
        {
          StructMsgItemVoice localStructMsgItemVoice = (StructMsgItemVoice)localObject2;
          localObject4 = paramBundle.c;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localStructMsgItemVoice.au);
          localStringBuilder.append("\"");
          ((TextView)localObject4).setText(localStringBuilder.toString());
        }
      }
      label473:
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = (StructMsgForGeneralShare)((AbsStructMsgElement)localObject2).as;
        localObject1 = ((StructMsgForGeneralShare)localObject2).animResId;
        paramView = ((StructMsgForGeneralShare)localObject2).atMembers;
        paramBundle.h = String.valueOf(((StructMsgForGeneralShare)localObject2).uniseq);
      }
    }
    paramBundle.f = ((String)localObject1);
    paramBundle.g = paramView;
    if (RobotResourcesManager.a().c(paramBundle.h))
    {
      if (this.aB == null) {
        this.aB = ((AnimationDrawable)paramContext.getResources().getDrawable(2130844989));
      }
      paramBundle.d.setImageDrawable(this.aB);
      if (!this.aB.isRunning())
      {
        this.aB.start();
        return localView;
      }
    }
    else
    {
      paramBundle.d.setImageResource(2130844988);
    }
    return localView;
  }
  
  protected int c()
  {
    return 28;
  }
  
  public String e()
  {
    return "layout28";
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(this.aC);
    if ((localObject instanceof StructMsgItemLayout28.ViewHolder))
    {
      localObject = (StructMsgItemLayout28.ViewHolder)localObject;
      if (TextUtils.isEmpty(((StructMsgItemLayout28.ViewHolder)localObject).f))
      {
        QLog.e("Q.robot.StructMsg", 2, "onClick failed , resid empty!");
      }
      else
      {
        String str1 = ((StructMsgItemLayout28.ViewHolder)localObject).f;
        String str2 = ((StructMsgItemLayout28.ViewHolder)localObject).h;
        RobotResourcesManager localRobotResourcesManager = RobotResourcesManager.a();
        if (localRobotResourcesManager.b(((StructMsgItemLayout28.ViewHolder)localObject).f)) {
          RobotResourcesManager.a().a(str2, ((StructMsgItemLayout28.ViewHolder)localObject).f, ((StructMsgItemLayout28.ViewHolder)localObject).g);
        } else {
          localRobotResourcesManager.a(((StructMsgItemLayout28.ViewHolder)localObject).f, new StructMsgItemLayout28.1(this, str2, str1, (StructMsgItemLayout28.ViewHolder)localObject));
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout28
 * JD-Core Version:    0.7.0.1
 */