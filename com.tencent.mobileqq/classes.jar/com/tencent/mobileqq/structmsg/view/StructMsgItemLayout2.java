package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout2
  extends AbsStructMsgItem
{
  protected boolean a;
  
  private TextViewWrapLayout a(Context paramContext)
  {
    paramContext = new TextViewWrapLayout(paramContext);
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (!TextUtils.isEmpty(this.c)) {
      paramContext.setBackgroundResource(2130839433);
    }
    d(paramContext);
    return paramContext;
  }
  
  private void a(Context paramContext, ViewGroup paramViewGroup)
  {
    Resources localResources = paramContext.getResources();
    int m = localResources.getDimensionPixelSize(2131299074);
    int n = localResources.getDimensionPixelSize(2131299075);
    int i = AIOUtils.b(5.0F, localResources);
    int j;
    if (a(1)) {
      j = a(paramContext, 10) + i;
    } else {
      j = i;
    }
    int k = i;
    if (a(2)) {
      k = i + a(paramContext, 10);
    }
    paramViewGroup.setPadding(m, j, n, k);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    paramView.setVisibility(paramInt);
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    if ((paramViewGroup != null) && (paramView != null))
    {
      if (paramLayoutParams == null) {
        return;
      }
      paramViewGroup.addView(paramView, paramLayoutParams);
    }
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramInt > 0) {
      paramTextView.setMaxLines(paramInt);
    }
  }
  
  private void b(Context paramContext, ViewGroup paramViewGroup)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      paramContext = paramContext.getResources();
      int i = AIOUtils.b(11.0F, paramContext);
      int j = AIOUtils.b(14.0F, paramContext);
      paramViewGroup.setPadding(j, i, j, AIOUtils.b(12.0F, paramContext));
    }
  }
  
  protected int b()
  {
    return 2;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("pre_dialog", false);
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
      if ((localObject2 instanceof StructMsgItemCover))
      {
        localObject2 = (StructMsgItemCover)localObject2;
        if (((StructMsgItemCover)localObject2).t == StructMsgItemCover.s) {
          ((StructMsgItemCover)localObject2).t = StructMsgItemCover.q;
        }
      }
    }
    localObject1 = null;
    Object localObject5;
    Object localObject4;
    Object localObject3;
    Object localObject6;
    Object localObject7;
    if ((paramView != null) && ((paramView instanceof TextViewWrapLayout)))
    {
      localObject5 = (TextViewWrapLayout)paramView;
      localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      localObject3 = null;
      localObject2 = localObject3;
      paramView = (View)localObject2;
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (AbsStructMsgElement)((Iterator)localObject4).next();
        ((AbsStructMsgElement)localObject6).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject7 = ((AbsStructMsgElement)localObject6).jdField_a_of_type_JavaLangString;
        if ((("picture".equals(localObject7)) || ("vote".equals(localObject7)) || ("video".equals(localObject7))) && (localObject3 == null))
        {
          localObject3 = ((AbsStructMsgElement)localObject6).a(paramContext, ((TextViewWrapLayout)localObject5).findViewById(2131368633), paramBundle);
        }
        else if (("title".equals(localObject7)) && (localObject1 == null))
        {
          if ((localObject6 instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localObject6).a(a(), this.p);
          }
          localObject1 = (TextView)((AbsStructMsgElement)localObject6).a(paramContext, ((TextViewWrapLayout)localObject5).findViewById(2131379930), paramBundle);
        }
        else if (localObject2 == null)
        {
          if ((!"summary".equals(localObject7)) && (!"timer".equals(localObject7)))
          {
            if ("checklist".equals(localObject7)) {
              paramView = (LinearLayout)((AbsStructMsgElement)localObject6).a(paramContext, ((TextViewWrapLayout)localObject5).findViewById(2131379570), paramBundle);
            }
          }
          else {
            localObject2 = (TextView)((AbsStructMsgElement)localObject6).a(paramContext, ((TextViewWrapLayout)localObject5).findViewById(2131379906), paramBundle);
          }
        }
      }
      localObject4 = localObject2;
      localObject3 = localObject5;
      localObject2 = localObject1;
      localObject1 = localObject4;
    }
    else
    {
      TextViewWrapLayout localTextViewWrapLayout = a(paramContext);
      Object localObject8 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      localObject3 = null;
      localObject2 = localObject3;
      localObject1 = localObject2;
      for (paramView = (View)localObject1; ((Iterator)localObject8).hasNext(); paramView = (View)localObject7)
      {
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject8).next();
        localAbsStructMsgElement.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        String str = localAbsStructMsgElement.jdField_a_of_type_JavaLangString;
        if ((("picture".equals(str)) || ("vote".equals(str)) || ("video".equals(str))) && (localObject3 == null))
        {
          localObject4 = localAbsStructMsgElement.a(paramContext, null, paramBundle);
          localObject5 = localObject2;
          localObject6 = localObject1;
          localObject7 = paramView;
        }
        else if (("title".equals(str)) && (localObject2 == null))
        {
          if ((localAbsStructMsgElement instanceof StructMsgItemTitle))
          {
            ((StructMsgItemTitle)localAbsStructMsgElement).a(a(), this.p);
            localObject2 = null;
          }
          else
          {
            localObject2 = null;
          }
          localObject5 = (TextView)localAbsStructMsgElement.a(paramContext, (View)localObject2, paramBundle);
          localObject4 = localObject3;
          localObject6 = localObject1;
          localObject7 = paramView;
        }
        else
        {
          localObject4 = localObject3;
          localObject5 = localObject2;
          localObject6 = localObject1;
          localObject7 = paramView;
          if (localObject1 == null) {
            if ((!"summary".equals(str)) && (!"timer".equals(str)))
            {
              localObject4 = localObject3;
              localObject5 = localObject2;
              localObject6 = localObject1;
              localObject7 = paramView;
              if ("checklist".equals(str))
              {
                localObject7 = (LinearLayout)localAbsStructMsgElement.a(paramContext, null, paramBundle);
                localObject4 = localObject3;
                localObject5 = localObject2;
                localObject6 = localObject1;
              }
            }
            else
            {
              localObject6 = (TextView)localAbsStructMsgElement.a(paramContext, null, paramBundle);
              localObject7 = paramView;
              localObject5 = localObject2;
              localObject4 = localObject3;
            }
          }
        }
        localObject3 = localObject4;
        localObject2 = localObject5;
        localObject1 = localObject6;
      }
      if (localObject3 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StructMsg", 2, "generate 2 item failure.");
        }
        return null;
      }
      if ((localObject2 == null) && (localObject1 != null)) {
        localObject2 = (TextView)new StructMsgItemTitle(((TextView)localObject1).getText().toString()).a(paramContext, null, paramBundle);
      }
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StructMsg", 2, "generate 2 item titleview failure.");
        }
        return null;
      }
      localObject5 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject5).topMargin = 0;
      ((RelativeLayout.LayoutParams)localObject5).addRule(10);
      localObject6 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject6).addRule(3, ((TextView)localObject2).getId());
      if ((this.o != 1) && (this.o != 3))
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          if (localObject1 != null) {
            ((TextView)localObject1).setLineSpacing(AIOUtils.b(1.0F, localResources), 1.0F);
          }
          localObject4 = new RelativeLayout.LayoutParams(AIOUtils.b(50.0F, localResources), AIOUtils.b(50.0F, localResources));
          ((RelativeLayout.LayoutParams)localObject4).topMargin = AIOUtils.b(7.0F, localResources);
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.b(10.0F, localResources);
          ((RelativeLayout.LayoutParams)localObject4).addRule(3, ((TextView)localObject2).getId());
          ((RelativeLayout.LayoutParams)localObject4).addRule(11);
          ((RelativeLayout.LayoutParams)localObject6).topMargin = AIOUtils.b(5.0F, localResources);
          ((RelativeLayout.LayoutParams)localObject6).addRule(0, ((View)localObject3).getId());
          a(localTextViewWrapLayout, (View)localObject2, (RelativeLayout.LayoutParams)localObject5);
          a(localTextViewWrapLayout, (View)localObject3, (RelativeLayout.LayoutParams)localObject4);
          a(localTextViewWrapLayout, (View)localObject1, (RelativeLayout.LayoutParams)localObject6);
          a(localTextViewWrapLayout, paramView, (RelativeLayout.LayoutParams)localObject6);
          localObject3 = localTextViewWrapLayout;
        }
        else
        {
          localObject4 = new RelativeLayout.LayoutParams(AIOUtils.b(32.0F, localResources), AIOUtils.b(32.0F, localResources));
          ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.b(6.0F, localResources);
          ((RelativeLayout.LayoutParams)localObject4).addRule(11);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15);
          int i = ViewUtils.a(20.0F);
          ((RelativeLayout.LayoutParams)localObject5).topMargin = i;
          ((RelativeLayout.LayoutParams)localObject5).bottomMargin = i;
          ((RelativeLayout.LayoutParams)localObject5).addRule(0, ((View)localObject3).getId());
          ((RelativeLayout.LayoutParams)localObject5).addRule(9);
          ((RelativeLayout.LayoutParams)localObject5).addRule(15);
          a(localTextViewWrapLayout, (View)localObject3, (RelativeLayout.LayoutParams)localObject4);
          a(localTextViewWrapLayout, (View)localObject2, (RelativeLayout.LayoutParams)localObject5);
          localObject3 = localTextViewWrapLayout;
        }
      }
      else
      {
        if (this.o == 1)
        {
          localObject4 = new RelativeLayout.LayoutParams(AIOUtils.b(50.0F, localResources), AIOUtils.b(50.0F, localResources));
          ((RelativeLayout.LayoutParams)localObject4).topMargin = AIOUtils.b(3.0F, localResources);
        }
        else
        {
          localObject4 = new RelativeLayout.LayoutParams(AIOUtils.b(115.0F, localResources), AIOUtils.b(70.0F, localResources));
          ((RelativeLayout.LayoutParams)localObject4).topMargin = AIOUtils.b(3.0F, localResources);
        }
        ((RelativeLayout.LayoutParams)localObject4).addRule(9);
        ((RelativeLayout.LayoutParams)localObject4).addRule(10);
        localObject7 = new RelativeLayout(paramContext);
        localObject8 = new RelativeLayout.LayoutParams(-1, -2);
        if (this.o == 3)
        {
          ((RelativeLayout.LayoutParams)localObject8).topMargin = AIOUtils.b(12.0F, localResources);
          ((RelativeLayout.LayoutParams)localObject6).topMargin = 5;
        }
        else
        {
          ((RelativeLayout.LayoutParams)localObject8).topMargin = AIOUtils.b(7.0F, localResources);
          ((RelativeLayout.LayoutParams)localObject6).topMargin = 0;
        }
        ((RelativeLayout.LayoutParams)localObject8).addRule(10);
        ((RelativeLayout.LayoutParams)localObject8).addRule(1, ((View)localObject3).getId());
        ((RelativeLayout.LayoutParams)localObject8).leftMargin = AIOUtils.b(10.0F, localResources);
        a(localTextViewWrapLayout, (View)localObject3, (RelativeLayout.LayoutParams)localObject4);
        a((ViewGroup)localObject7, (View)localObject2, (RelativeLayout.LayoutParams)localObject5);
        a((ViewGroup)localObject7, (View)localObject1, (RelativeLayout.LayoutParams)localObject6);
        a((ViewGroup)localObject7, paramView, (RelativeLayout.LayoutParams)localObject6);
        localTextViewWrapLayout.addView((View)localObject7, (ViewGroup.LayoutParams)localObject8);
        localObject3 = localTextViewWrapLayout;
      }
    }
    if ((this.o != 1) && (this.o != 3)) {
      b(paramContext, (ViewGroup)localObject3);
    } else {
      a(paramContext, (ViewGroup)localObject3);
    }
    if (localObject2 != null)
    {
      paramContext = ((TextView)localObject2).getTag();
      if ((paramContext instanceof StructMsgItemTitle))
      {
        paramContext = (StructMsgItemTitle)paramContext;
        if (paramContext != null)
        {
          bool3 = TextUtils.isEmpty(paramContext.b()) ^ true;
          break label1479;
        }
      }
    }
    boolean bool3 = false;
    label1479:
    if (localObject1 != null)
    {
      paramContext = ((TextView)localObject1).getTag();
      if ((paramContext instanceof StructMsgItemSummary))
      {
        paramContext = (StructMsgItemSummary)paramContext;
        if (paramContext != null)
        {
          bool1 = TextUtils.isEmpty(paramContext.b()) ^ true;
          break label1523;
        }
      }
    }
    boolean bool1 = false;
    label1523:
    boolean bool2 = bool1;
    if (paramView != null)
    {
      paramContext = paramView.getTag();
      bool2 = bool1;
      if ((paramContext instanceof StructMsgItemVote))
      {
        paramContext = ((StructMsgItemVote)paramContext).jdField_a_of_type_JavaUtilArrayList;
        if ((paramContext != null) && (!paramContext.isEmpty())) {
          bool2 = true;
        } else {
          bool2 = false;
        }
      }
    }
    if (bool3)
    {
      a((TextView)localObject2, 2);
      a((View)localObject2, 0);
      a((TextView)localObject1, 2);
      if ((this.o != 1) && (this.o != 3))
      {
        float f;
        if (!this.jdField_a_of_type_Boolean) {
          f = 17.0F;
        } else {
          f = 14.0F;
        }
        ((TextView)localObject2).setTextSize(f);
      }
      else
      {
        ((TextView)localObject2).setTextSize(16.0F);
      }
    }
    else
    {
      a((View)localObject2, 8);
      a((TextView)localObject1, 4);
    }
    if (bool2) {
      a((View)localObject1, 0);
    } else {
      a((View)localObject1, 8);
    }
    if ((this.o != 1) && (this.o != 3))
    {
      a((TextView)localObject1, 3);
    }
    else
    {
      if (localObject1 != null) {
        ((TextView)localObject1).setSingleLine(true);
      }
      if (localObject2 != null)
      {
        ((TextView)localObject2).setSingleLine(true);
        ((TextView)localObject2).setMaxLines(1);
      }
    }
    if (AppSetting.d)
    {
      paramContext = new StringBuilder();
      if (localObject2 != null) {
        paramContext.append(((TextView)localObject2).getText());
      }
      int j = paramBundle.getInt("serviceID", 0);
      if ((localObject1 != null) && ((j == 32) || (j == 14) || (j == 15) || (j == 16) || (j == 17)))
      {
        paramContext.append(",");
        paramContext.append(((TextView)localObject1).getText());
      }
      ((TextViewWrapLayout)localObject3).setContentDescription(paramContext.toString());
    }
    return localObject3;
  }
  
  public String b()
  {
    return "Layout2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2
 * JD-Core Version:    0.7.0.1
 */