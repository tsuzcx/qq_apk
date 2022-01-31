package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout2
  extends AbsStructMsgItem
{
  protected boolean a;
  protected boolean b;
  
  private TextViewWrapLayout a(Context paramContext)
  {
    paramContext = new TextViewWrapLayout(paramContext);
    paramContext.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (!TextUtils.isEmpty(this.c)) {
      paramContext.setBackgroundResource(2130838623);
    }
    d(paramContext);
    return paramContext;
  }
  
  private void a(Context paramContext, ViewGroup paramViewGroup)
  {
    Resources localResources = paramContext.getResources();
    int m = localResources.getDimensionPixelSize(2131558648);
    int n = localResources.getDimensionPixelSize(2131558649);
    int k = AIOUtils.a(5.0F, localResources);
    if (a(1)) {}
    for (int j = a(paramContext) + k;; j = k)
    {
      int i = k;
      if (a(2)) {
        i = k + a(paramContext);
      }
      if (this.jdField_a_of_type_Boolean) {
        i = AIOUtils.a(2.0F, localResources);
      }
      paramViewGroup.setPadding(m, j, n, i);
      return;
    }
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
    if ((paramViewGroup == null) || (paramView == null) || (paramLayoutParams == null)) {
      return;
    }
    paramViewGroup.addView(paramView, paramLayoutParams);
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    if (paramTextView == null) {}
    while (paramInt <= 0) {
      return;
    }
    paramTextView.setMaxLines(paramInt);
  }
  
  private void b(Context paramContext, ViewGroup paramViewGroup)
  {
    int j;
    int k;
    if (!this.b)
    {
      paramContext = paramContext.getResources();
      j = AIOUtils.a(11.0F, paramContext);
      k = AIOUtils.a(14.0F, paramContext);
      if (!this.jdField_a_of_type_Boolean) {
        break label53;
      }
    }
    label53:
    for (int i = AIOUtils.a(2.0F, paramContext);; i = AIOUtils.a(12.0F, paramContext))
    {
      paramViewGroup.setPadding(k, j, k, i);
      return;
    }
  }
  
  protected int b()
  {
    return 2;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject6 = paramContext.getResources();
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("isShowCommentLayout", false);
    this.b = paramBundle.getBoolean("pre_dialog", false);
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject4 = null;
    Object localObject5;
    Object localObject7;
    Object localObject8;
    if ((paramView != null) && ((paramView instanceof TextViewWrapLayout)))
    {
      localObject6 = (TextViewWrapLayout)paramView;
      localObject5 = (RelativeLayout)paramView.findViewById(2131368330);
      localObject7 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramView = (View)localObject4;
      if (((Iterator)localObject7).hasNext())
      {
        localObject4 = (AbsStructMsgElement)((Iterator)localObject7).next();
        ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject8 = ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangString;
        if ((("picture".equals(localObject8)) || ("vote".equals(localObject8)) || ("video".equals(localObject8))) && (localObject3 == null)) {
          localObject3 = ((AbsStructMsgElement)localObject4).a(paramContext, ((TextViewWrapLayout)localObject6).findViewById(2131361925), paramBundle);
        }
      }
    }
    for (;;)
    {
      break;
      if (("title".equals(localObject8)) && (localObject2 == null))
      {
        if ((localObject4 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject4).a(a(), this.f);
        }
        localObject2 = (TextView)((AbsStructMsgElement)localObject4).a(paramContext, ((TextViewWrapLayout)localObject6).findViewById(2131361926), paramBundle);
      }
      else if (localObject1 == null)
      {
        if (("summary".equals(localObject8)) || ("timer".equals(localObject8)))
        {
          localObject1 = (TextView)((AbsStructMsgElement)localObject4).a(paramContext, ((TextViewWrapLayout)localObject6).findViewById(2131361927), paramBundle);
        }
        else if ("checklist".equals(localObject8))
        {
          paramView = (LinearLayout)((AbsStructMsgElement)localObject4).a(paramContext, ((TextViewWrapLayout)localObject6).findViewById(2131361935), paramBundle);
          continue;
          localObject4 = paramView;
          paramView = (View)localObject2;
          localObject3 = localObject1;
          localObject1 = localObject6;
          localObject2 = localObject5;
          label352:
          label370:
          int i;
          if ((this.e == 1) || (this.e == 3))
          {
            a(paramContext, (ViewGroup)localObject1);
            if (localObject2 != null)
            {
              if (!this.jdField_a_of_type_Boolean) {
                break label1779;
              }
              ((RelativeLayout)localObject2).setVisibility(0);
            }
            i = 0;
            int k = 0;
            int j = i;
            if (paramView != null)
            {
              paramContext = paramView.getTag();
              j = i;
              if ((paramContext instanceof StructMsgItemTitle))
              {
                paramContext = (StructMsgItemTitle)paramContext;
                j = i;
                if (paramContext != null)
                {
                  if (TextUtils.isEmpty(paramContext.b())) {
                    break label1789;
                  }
                  i = 1;
                  label426:
                  j = i;
                }
              }
            }
            i = k;
            if (localObject3 != null)
            {
              paramContext = ((TextView)localObject3).getTag();
              i = k;
              if ((paramContext instanceof StructMsgItemSummary))
              {
                paramContext = (StructMsgItemSummary)paramContext;
                i = k;
                if (paramContext != null)
                {
                  if (TextUtils.isEmpty(paramContext.b())) {
                    break label1795;
                  }
                  i = 1;
                }
              }
            }
            label482:
            k = i;
            if (localObject4 != null)
            {
              paramContext = ((LinearLayout)localObject4).getTag();
              k = i;
              if ((paramContext instanceof StructMsgItemVote))
              {
                paramContext = ((StructMsgItemVote)paramContext).jdField_a_of_type_JavaUtilArrayList;
                if ((paramContext == null) || (paramContext.isEmpty())) {
                  break label1801;
                }
                i = 1;
                label530:
                k = i;
              }
            }
            if (j == 0) {
              break label1835;
            }
            a(paramView, 2);
            a(paramView, 0);
            a((TextView)localObject3, 2);
            if ((this.e != 1) && (this.e != 3)) {
              break label1807;
            }
            paramView.setTextSize(16.0F);
            label580:
            if (k == 0) {
              break label1852;
            }
            a((View)localObject3, 0);
            label592:
            if ((this.e != 1) && (this.e != 3)) {
              break label1863;
            }
            if (localObject3 != null) {
              ((TextView)localObject3).setSingleLine(true);
            }
            if (paramView != null) {
              paramView.setSingleLine(true);
            }
            label628:
            if (AppSetting.b)
            {
              paramContext = new StringBuilder();
              if (paramView != null) {
                paramContext.append(paramView.getText());
              }
              i = paramBundle.getInt("serviceID", 0);
              if ((localObject3 != null) && ((i == 32) || (i == 14) || (i == 15) || (i == 109) || (i == 16) || (i == 17))) {
                paramContext.append(",").append(((TextView)localObject3).getText());
              }
              ((TextViewWrapLayout)localObject1).setContentDescription(paramContext.toString());
            }
            return localObject1;
            localObject5 = a(paramContext);
            localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
            paramView = null;
            localObject2 = null;
            localObject1 = null;
            localObject3 = null;
            label765:
            if (((Iterator)localObject4).hasNext())
            {
              localObject7 = (AbsStructMsgElement)((Iterator)localObject4).next();
              ((AbsStructMsgElement)localObject7).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
              localObject8 = ((AbsStructMsgElement)localObject7).jdField_a_of_type_JavaLangString;
              if ((("picture".equals(localObject8)) || ("vote".equals(localObject8)) || ("video".equals(localObject8))) && (localObject3 == null)) {
                localObject3 = ((AbsStructMsgElement)localObject7).a(paramContext, null, paramBundle);
              }
            }
          }
          for (;;)
          {
            break label765;
            if (("title".equals(localObject8)) && (localObject2 == null))
            {
              if ((localObject7 instanceof StructMsgItemTitle)) {
                ((StructMsgItemTitle)localObject7).a(a(), this.f);
              }
              localObject2 = (TextView)((AbsStructMsgElement)localObject7).a(paramContext, null, paramBundle);
            }
            else if (localObject1 == null)
            {
              if (("summary".equals(localObject8)) || ("timer".equals(localObject8)))
              {
                localObject1 = (TextView)((AbsStructMsgElement)localObject7).a(paramContext, null, paramBundle);
              }
              else if ("checklist".equals(localObject8))
              {
                paramView = (LinearLayout)((AbsStructMsgElement)localObject7).a(paramContext, null, paramBundle);
                continue;
                if (localObject3 == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 2 item failure.");
                  }
                  return null;
                }
                localObject4 = localObject2;
                if (localObject2 == null)
                {
                  localObject4 = localObject2;
                  if (localObject1 != null) {
                    localObject4 = (TextView)new StructMsgItemTitle(((TextView)localObject1).getText().toString()).a(paramContext, null, paramBundle);
                  }
                }
                if (localObject4 == null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("StructMsg", 2, "generate 2 item titleview failure.");
                  }
                  return null;
                }
                localObject7 = new RelativeLayout.LayoutParams(-1, -2);
                ((RelativeLayout.LayoutParams)localObject7).topMargin = 0;
                ((RelativeLayout.LayoutParams)localObject7).addRule(10);
                localObject8 = new RelativeLayout.LayoutParams(-1, -2);
                ((RelativeLayout.LayoutParams)localObject8).addRule(3, ((TextView)localObject4).getId());
                if ((this.e == 1) || (this.e == 3))
                {
                  label1174:
                  RelativeLayout localRelativeLayout;
                  RelativeLayout.LayoutParams localLayoutParams;
                  if (this.e == 1)
                  {
                    localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, (Resources)localObject6), AIOUtils.a(50.0F, (Resources)localObject6));
                    ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(3.0F, (Resources)localObject6);
                    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
                    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
                    localRelativeLayout = new RelativeLayout(paramContext);
                    localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    if (this.e != 3) {
                      break label1380;
                    }
                    localLayoutParams.topMargin = AIOUtils.a(12.0F, (Resources)localObject6);
                  }
                  for (((RelativeLayout.LayoutParams)localObject8).topMargin = 5;; ((RelativeLayout.LayoutParams)localObject8).topMargin = 0)
                  {
                    localLayoutParams.addRule(10);
                    localLayoutParams.addRule(1, ((View)localObject3).getId());
                    localLayoutParams.leftMargin = AIOUtils.a(10.0F, (Resources)localObject6);
                    a((ViewGroup)localObject5, (View)localObject3, (RelativeLayout.LayoutParams)localObject2);
                    a(localRelativeLayout, (View)localObject4, (RelativeLayout.LayoutParams)localObject7);
                    a(localRelativeLayout, (View)localObject1, (RelativeLayout.LayoutParams)localObject8);
                    a(localRelativeLayout, paramView, (RelativeLayout.LayoutParams)localObject8);
                    ((TextViewWrapLayout)localObject5).addView(localRelativeLayout, localLayoutParams);
                    localObject6 = localObject4;
                    localObject2 = null;
                    localObject4 = paramView;
                    localObject3 = localObject1;
                    paramView = (View)localObject6;
                    localObject1 = localObject5;
                    break;
                    localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(115.0F, (Resources)localObject6), AIOUtils.a(70.0F, (Resources)localObject6));
                    ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(3.0F, (Resources)localObject6);
                    break label1174;
                    label1380:
                    localLayoutParams.topMargin = AIOUtils.a(7.0F, (Resources)localObject6);
                  }
                }
                if (!this.b)
                {
                  if (localObject1 != null) {
                    ((TextView)localObject1).setLineSpacing(AIOUtils.a(1.0F, (Resources)localObject6), 1.0F);
                  }
                  localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(50.0F, (Resources)localObject6), AIOUtils.a(50.0F, (Resources)localObject6));
                  ((RelativeLayout.LayoutParams)localObject2).topMargin = AIOUtils.a(7.0F, (Resources)localObject6);
                  ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(10.0F, (Resources)localObject6);
                  ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((TextView)localObject4).getId());
                  ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                  ((RelativeLayout.LayoutParams)localObject8).topMargin = AIOUtils.a(5.0F, (Resources)localObject6);
                  ((RelativeLayout.LayoutParams)localObject8).addRule(0, ((View)localObject3).getId());
                  a((ViewGroup)localObject5, (View)localObject4, (RelativeLayout.LayoutParams)localObject7);
                  a((ViewGroup)localObject5, (View)localObject3, (RelativeLayout.LayoutParams)localObject2);
                  a((ViewGroup)localObject5, (View)localObject1, (RelativeLayout.LayoutParams)localObject8);
                  a((ViewGroup)localObject5, paramView, (RelativeLayout.LayoutParams)localObject8);
                  localObject2 = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2130969959, null);
                  localObject6 = new RelativeLayout.LayoutParams(-1, -2);
                  ((RelativeLayout.LayoutParams)localObject6).topMargin = 0;
                  ((RelativeLayout.LayoutParams)localObject6).addRule(3, ((View)localObject3).getId());
                  a((ViewGroup)localObject5, (View)localObject2, (RelativeLayout.LayoutParams)localObject6);
                  localObject6 = localObject4;
                  localObject4 = paramView;
                  localObject3 = localObject1;
                  paramView = (View)localObject6;
                  localObject1 = localObject5;
                  break;
                }
                ((TextView)localObject4).setLineSpacing(AIOUtils.a(4.0F, (Resources)localObject6), 1.0F);
                localObject2 = new RelativeLayout.LayoutParams(AIOUtils.a(40.0F, (Resources)localObject6), AIOUtils.a(40.0F, (Resources)localObject6));
                ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(12.0F, (Resources)localObject6);
                ((RelativeLayout.LayoutParams)localObject2).addRule(11);
                ((RelativeLayout.LayoutParams)localObject2).addRule(15);
                ((RelativeLayout.LayoutParams)localObject7).addRule(0, ((View)localObject3).getId());
                ((RelativeLayout.LayoutParams)localObject7).addRule(9);
                ((RelativeLayout.LayoutParams)localObject7).addRule(15);
                a((ViewGroup)localObject5, (View)localObject3, (RelativeLayout.LayoutParams)localObject2);
                a((ViewGroup)localObject5, (View)localObject4, (RelativeLayout.LayoutParams)localObject7);
                localObject6 = localObject4;
                localObject2 = null;
                localObject4 = paramView;
                localObject3 = localObject1;
                paramView = (View)localObject6;
                localObject1 = localObject5;
                break;
                b(paramContext, (ViewGroup)localObject1);
                break label352;
                label1779:
                ((RelativeLayout)localObject2).setVisibility(8);
                break label370;
                label1789:
                i = 0;
                break label426;
                label1795:
                i = 0;
                break label482;
                label1801:
                i = 0;
                break label530;
                label1807:
                if (!this.b) {}
                for (float f = 17.0F;; f = 14.0F)
                {
                  paramView.setTextSize(f);
                  break;
                }
                label1835:
                a(paramView, 8);
                a((TextView)localObject3, 4);
                break label580;
                label1852:
                a((View)localObject3, 8);
                break label592;
                label1863:
                a((TextView)localObject3, 3);
                break label628;
              }
            }
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2
 * JD-Core Version:    0.7.0.1
 */