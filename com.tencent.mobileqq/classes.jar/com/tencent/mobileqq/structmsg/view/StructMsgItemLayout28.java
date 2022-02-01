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
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#8C6CF5"));
  static HashMap<Integer, ColorDrawable> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  public int s = -1;
  
  protected int b()
  {
    return 28;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject2 = null;
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramContext).inflate(2131560706, null);
      paramBundle = new StructMsgItemLayout28.ViewHolder(this);
      paramBundle.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localView.findViewById(2131363513));
      paramBundle.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(13.0F);
      paramBundle.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377818));
      paramBundle.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377720));
      paramBundle.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378836));
      paramBundle.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131377719));
      localView.setTag(this.s, paramBundle);
      localView.setOnClickListener(this);
    }
    else
    {
      paramBundle = (StructMsgItemLayout28.ViewHolder)paramView.getTag(this.s);
      localView = paramView;
    }
    Object localObject1 = (ColorDrawable)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.p));
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      paramView = (View)localObject1;
      if (this.p != 0)
      {
        paramView = new ColorDrawable(this.p);
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.p), paramView);
      }
    }
    localObject1 = paramView;
    if (paramView == null) {
      localObject1 = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
    }
    paramBundle.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject1);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    paramView = null;
    localObject1 = localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (AbsStructMsgElement)localIterator.next();
      Object localObject3 = ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangString;
      if ("title".equals(localObject3))
      {
        localObject3 = (StructMsgItemTitle)localObject2;
        paramBundle.jdField_b_of_type_AndroidWidgetTextView.setText(((StructMsgItemTitle)localObject3).ai);
      }
      else
      {
        Object localObject4;
        if ("picture".equals(localObject3))
        {
          localObject3 = ((StructMsgItemCover)localObject2).ac;
          try
          {
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              break label473;
            }
            localObject4 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((int)DisplayUtils.a(paramContext, 62.5F));
            ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = ((int)DisplayUtils.a(paramContext, 115.0F));
            localObject3 = URLDrawable.getDrawable((String)localObject3, (URLDrawable.URLDrawableOptions)localObject4);
            paramBundle.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject3);
            paramBundle.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          }
          catch (Exception localException)
          {
            QLog.e("Q.robot.StructMsg", 1, localException, new Object[0]);
            paramBundle.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
          }
        }
        else if ("voice".equals(localException))
        {
          StructMsgItemVoice localStructMsgItemVoice = (StructMsgItemVoice)localObject2;
          localObject4 = paramBundle.jdField_a_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localStructMsgItemVoice.o);
          localStringBuilder.append("\"");
          ((TextView)localObject4).setText(localStringBuilder.toString());
        }
      }
      label473:
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = (StructMsgForGeneralShare)((AbsStructMsgElement)localObject2).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        localObject1 = ((StructMsgForGeneralShare)localObject2).animResId;
        paramView = ((StructMsgForGeneralShare)localObject2).atMembers;
        paramBundle.c = String.valueOf(((StructMsgForGeneralShare)localObject2).uniseq);
      }
    }
    paramBundle.jdField_a_of_type_JavaLangString = ((String)localObject1);
    paramBundle.jdField_b_of_type_JavaLangString = paramView;
    if (RobotResourcesManager.a().b(paramBundle.c))
    {
      if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)paramContext.getResources().getDrawable(2130844034));
      }
      paramBundle.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
      if (!this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.isRunning())
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
        return localView;
      }
    }
    else
    {
      paramBundle.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844033);
    }
    return localView;
  }
  
  public String b()
  {
    return "layout28";
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag(this.s);
    if ((localObject instanceof StructMsgItemLayout28.ViewHolder))
    {
      localObject = (StructMsgItemLayout28.ViewHolder)localObject;
      if (TextUtils.isEmpty(((StructMsgItemLayout28.ViewHolder)localObject).jdField_a_of_type_JavaLangString))
      {
        QLog.e("Q.robot.StructMsg", 2, "onClick failed , resid empty!");
      }
      else
      {
        String str1 = ((StructMsgItemLayout28.ViewHolder)localObject).jdField_a_of_type_JavaLangString;
        String str2 = ((StructMsgItemLayout28.ViewHolder)localObject).c;
        RobotResourcesManager localRobotResourcesManager = RobotResourcesManager.a();
        if (localRobotResourcesManager.a(((StructMsgItemLayout28.ViewHolder)localObject).jdField_a_of_type_JavaLangString)) {
          RobotResourcesManager.a().a(str2, ((StructMsgItemLayout28.ViewHolder)localObject).jdField_a_of_type_JavaLangString, ((StructMsgItemLayout28.ViewHolder)localObject).jdField_b_of_type_JavaLangString);
        } else {
          localRobotResourcesManager.a(((StructMsgItemLayout28.ViewHolder)localObject).jdField_a_of_type_JavaLangString, new StructMsgItemLayout28.1(this, str2, str1, (StructMsgItemLayout28.ViewHolder)localObject));
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout28
 * JD-Core Version:    0.7.0.1
 */