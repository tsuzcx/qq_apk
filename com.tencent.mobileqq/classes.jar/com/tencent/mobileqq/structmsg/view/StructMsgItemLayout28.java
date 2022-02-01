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
  
  public int b()
  {
    return 28;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = null;
    View localView;
    StructMsgItemLayout28.ViewHolder localViewHolder;
    label223:
    Object localObject2;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramContext).inflate(2131560833, null);
      localViewHolder = new StructMsgItemLayout28.ViewHolder(this);
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localView.findViewById(2131363590));
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(13.0F);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131378404));
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378312));
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131379486));
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131378311));
      localView.setTag(this.s, localViewHolder);
      localView.setOnClickListener(this);
      paramBundle = (ColorDrawable)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.p));
      paramView = paramBundle;
      if (paramBundle == null)
      {
        paramView = paramBundle;
        if (this.p != 0)
        {
          paramView = new ColorDrawable(this.p);
          jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.p), paramView);
        }
      }
      paramBundle = paramView;
      if (paramView == null) {
        paramBundle = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      }
      localViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramBundle);
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramView = null;
      paramBundle = (Bundle)localObject1;
      if (!localIterator.hasNext()) {
        break label512;
      }
      localObject1 = (AbsStructMsgElement)localIterator.next();
      localObject2 = ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangString;
      if (!"title".equals(localObject2)) {
        break label346;
      }
      localObject2 = (StructMsgItemTitle)localObject1;
      localViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(((StructMsgItemTitle)localObject2).ai);
      label282:
      if (!TextUtils.isEmpty(paramView)) {
        break label608;
      }
      localObject1 = (StructMsgForGeneralShare)((AbsStructMsgElement)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
      paramView = ((StructMsgForGeneralShare)localObject1).animResId;
      paramBundle = ((StructMsgForGeneralShare)localObject1).atMembers;
      localViewHolder.c = String.valueOf(((StructMsgForGeneralShare)localObject1).uniseq);
    }
    label346:
    label608:
    for (;;)
    {
      for (;;)
      {
        break label223;
        localViewHolder = (StructMsgItemLayout28.ViewHolder)paramView.getTag(this.s);
        localView = paramView;
        break;
        if (!"picture".equals(localObject2)) {
          break label460;
        }
        localObject2 = ((StructMsgItemCover)localObject1).ac;
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label282;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)DisplayUtils.a(paramContext, 62.5F));
          localURLDrawableOptions.mRequestHeight = ((int)DisplayUtils.a(paramContext, 115.0F));
          localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        catch (Exception localException)
        {
          QLog.e("Q.robot.StructMsg", 1, localException, new Object[0]);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
      }
      break label282;
      if (!"voice".equals(localException)) {
        break label282;
      }
      StructMsgItemVoice localStructMsgItemVoice = (StructMsgItemVoice)localObject1;
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localStructMsgItemVoice.o + "\"");
      break label282;
      localViewHolder.jdField_a_of_type_JavaLangString = paramView;
      localViewHolder.jdField_b_of_type_JavaLangString = paramBundle;
      if (RobotResourcesManager.a().b(localViewHolder.c))
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)paramContext.getResources().getDrawable(2130844131));
        }
        localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
        if (!this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.isRunning()) {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
        }
        return localView;
      }
      localViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844130);
      return localView;
    }
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
      if (!TextUtils.isEmpty(((StructMsgItemLayout28.ViewHolder)localObject).jdField_a_of_type_JavaLangString)) {
        break label48;
      }
      QLog.e("Q.robot.StructMsg", 2, "onClick failed , resid empty!");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout28
 * JD-Core Version:    0.7.0.1
 */