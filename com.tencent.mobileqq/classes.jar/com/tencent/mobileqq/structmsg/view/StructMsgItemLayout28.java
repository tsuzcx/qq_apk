package com.tencent.mobileqq.structmsg.view;

import aije;
import aijf;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class StructMsgItemLayout28
  extends AbsStructMsgItem
{
  static ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(Color.parseColor("#8C6CF5"));
  static HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  AnimationDrawable jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable;
  public int i = -1;
  
  protected int b()
  {
    return 28;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = null;
    View localView;
    aijf localaijf;
    label223:
    Object localObject2;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramContext).inflate(2130969962, null);
      localaijf = new aijf(this);
      localaijf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView = ((BubbleImageView)localView.findViewById(2131368595));
      localaijf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setRadius(13.0F);
      localaijf.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368599));
      localaijf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368598));
      localaijf.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131368596));
      localaijf.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368597));
      localView.setTag(this.i, localaijf);
      localView.setOnClickListener(this);
      paramBundle = (ColorDrawable)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.f));
      paramView = paramBundle;
      if (paramBundle == null)
      {
        paramView = paramBundle;
        if (this.f != 0)
        {
          paramView = new ColorDrawable(this.f);
          jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(this.f), paramView);
        }
      }
      paramBundle = paramView;
      if (paramView == null) {
        paramBundle = jdField_a_of_type_AndroidGraphicsDrawableColorDrawable;
      }
      localaijf.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramBundle);
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
      localaijf.jdField_b_of_type_AndroidWidgetTextView.setText(((StructMsgItemTitle)localObject2).A);
      label282:
      if (!TextUtils.isEmpty(paramView)) {
        break label608;
      }
      localObject1 = (StructMsgForGeneralShare)((AbsStructMsgElement)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
      paramView = ((StructMsgForGeneralShare)localObject1).animResId;
      paramBundle = ((StructMsgForGeneralShare)localObject1).atMembers;
      localaijf.c = String.valueOf(((StructMsgForGeneralShare)localObject1).uniseq);
    }
    label346:
    label608:
    for (;;)
    {
      for (;;)
      {
        break label223;
        localaijf = (aijf)paramView.getTag(this.i);
        localView = paramView;
        break;
        if (!"picture".equals(localObject2)) {
          break label460;
        }
        localObject2 = ((StructMsgItemCover)localObject1).u;
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label282;
          }
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = ((int)DisplayUtils.a(paramContext, 62.5F));
          localURLDrawableOptions.mRequestHeight = ((int)DisplayUtils.a(paramContext, 115.0F));
          localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
          localaijf.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
          localaijf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        catch (Exception localException)
        {
          QLog.e("Q.robot.StructMsg", 1, localException, new Object[0]);
          localaijf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        }
      }
      break label282;
      if (!"voice".equals(localException)) {
        break label282;
      }
      StructMsgItemVoice localStructMsgItemVoice = (StructMsgItemVoice)localObject1;
      localaijf.jdField_a_of_type_AndroidWidgetTextView.setText(localStructMsgItemVoice.e + "\"");
      break label282;
      localaijf.jdField_a_of_type_JavaLangString = paramView;
      localaijf.jdField_b_of_type_JavaLangString = paramBundle;
      if (RobotResourcesManager.a().c(localaijf.c))
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable = ((AnimationDrawable)paramContext.getResources().getDrawable(2130841481));
        }
        localaijf.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable);
        if (!this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.isRunning()) {
          this.jdField_a_of_type_AndroidGraphicsDrawableAnimationDrawable.start();
        }
        return localView;
      }
      localaijf.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130841480);
      return localView;
    }
  }
  
  public String b()
  {
    return "layout28";
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag(this.i);
    if ((paramView instanceof aijf))
    {
      paramView = (aijf)paramView;
      if (TextUtils.isEmpty(paramView.jdField_a_of_type_JavaLangString)) {
        QLog.e("Q.robot.StructMsg", 2, "onClick failed , resid empty!");
      }
    }
    else
    {
      return;
    }
    String str1 = paramView.jdField_a_of_type_JavaLangString;
    String str2 = paramView.c;
    RobotResourcesManager localRobotResourcesManager = RobotResourcesManager.a();
    if (localRobotResourcesManager.b(paramView.jdField_a_of_type_JavaLangString))
    {
      RobotResourcesManager.a().a(str2, paramView.jdField_a_of_type_JavaLangString, paramView.jdField_b_of_type_JavaLangString);
      return;
    }
    localRobotResourcesManager.a(paramView.jdField_a_of_type_JavaLangString, new aije(this, str2, str1, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout28
 * JD-Core Version:    0.7.0.1
 */