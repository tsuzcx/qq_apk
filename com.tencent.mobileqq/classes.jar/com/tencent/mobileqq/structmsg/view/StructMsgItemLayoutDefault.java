package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;

public class StructMsgItemLayoutDefault
  extends AbsStructMsgItem
{
  protected int b()
  {
    return 0;
  }
  
  @TargetApi(16)
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject1 = paramContext;
    Object localObject2 = paramBundle;
    Object localObject3 = ((Bundle)localObject2).getString("sType");
    if (localObject3 != null) {
      ((String)localObject3).equals("1");
    }
    int j;
    if (((Bundle)localObject2).getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
      j = 1;
    } else {
      j = 0;
    }
    localObject3 = paramContext.getResources();
    int k = ((Resources)localObject3).getDimensionPixelSize(2131299074);
    int m = ((Resources)localObject3).getDimensionPixelSize(2131299075);
    int n = AIOUtils.b(2.0F, (Resources)localObject3);
    if (j != 0)
    {
      k = AIOUtils.b(12.0F, (Resources)localObject3);
      m = k;
    }
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
    }
    else
    {
      paramView = new LinearLayout((Context)localObject1);
      paramView.setOrientation(1);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
    }
    int i = n;
    if (a(1)) {
      i = n + a((Context)localObject1, 10);
    }
    if (!TextUtils.isEmpty(this.c))
    {
      paramView.setBackgroundResource(2130838254);
      n = AIOUtils.b(1.0F, (Resources)localObject3);
      localObject2 = (LinearLayout.LayoutParams)paramView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject2).leftMargin = n;
      ((LinearLayout.LayoutParams)localObject2).rightMargin = n;
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    }
    paramView.setPadding(k, 0, m, 0);
    int i2;
    int i3;
    Object localObject4;
    Object localObject5;
    if (paramView.getChildCount() == this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
      n = 0;
      for (;;)
      {
        localObject2 = paramView;
        if (n >= i1) {
          break;
        }
        localObject2 = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(n);
        ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        if ((localObject2 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject2).a(a(), this.p);
        }
        localObject1 = ((AbsStructMsgElement)localObject2).a((Context)localObject1, paramView.getChildAt(n), paramBundle);
        if (localObject1 == null) {
          return paramView;
        }
        i2 = AIOUtils.b(10.0F, (Resources)localObject3);
        i3 = AIOUtils.b(5.0F, (Resources)localObject3);
        localObject4 = new LinearLayout.LayoutParams(-1, -2);
        if (n > 0) {
          ((LinearLayout.LayoutParams)localObject4).topMargin = i3;
        }
        localObject5 = ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangString;
        if ("picture".equals(localObject5))
        {
          ((View)localObject1).setId(-1);
          ((LinearLayout.LayoutParams)localObject4).height = (BaseChatItemLayout.f - i2 - i2);
        }
        for (;;)
        {
          break;
          if ("video".equals(localObject5))
          {
            ((LinearLayout.LayoutParams)localObject4).height = (BaseChatItemLayout.f - i2 - i2);
          }
          else if ("title".equals(localObject5))
          {
            if (j != 0)
            {
              localObject2 = (StructMsgItemTitle)localObject2;
              if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).c())) {
                ((TextView)localObject1).setTextSize(18.0F);
              }
              if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).e())) {
                ((TextView)localObject1).setTypeface(Typeface.DEFAULT, 1);
              }
            }
            ((View)localObject1).setId(-1);
          }
          else if ("summary".equals(localObject5))
          {
            if (this.o == 1)
            {
              localObject4 = (TextView)localObject1;
              ((TextView)localObject4).setTextSize(12.0F);
              ((TextView)localObject4).setTextColor(-4473925);
            }
            if (j != 0)
            {
              localObject2 = (StructMsgItemSummary)localObject2;
              localObject4 = ((StructMsgItemSummary)localObject2).f();
              if ((localObject4 != null) && (((String)localObject4).equals("1")))
              {
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject2).c())) {
                  ((TextView)localObject1).setTextSize(12.0F);
                }
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject2).d())) {
                  ((TextView)localObject1).setTextColor(Color.parseColor("#8e8e8e"));
                }
              }
              else
              {
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject2).c())) {
                  ((TextView)localObject1).setTextSize(16.0F);
                }
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject2).d())) {
                  ((TextView)localObject1).setTextColor(-16777216);
                }
                ((TextView)localObject1).setLineSpacing(4.0F, 1.0F);
              }
            }
            ((View)localObject1).setId(-1);
          }
          else
          {
            if ("hr".equals(localObject5))
            {
              if (((StructMsgItemHr)localObject2).a) {
                ((LinearLayout.LayoutParams)localObject4).height = 0;
              } else {
                ((LinearLayout.LayoutParams)localObject4).height = 1;
              }
              if ((j != 0) && (n != 0)) {
                ((LinearLayout.LayoutParams)localObject4).topMargin += AIOUtils.b(6.0F, (Resources)localObject3);
              }
              ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
              if (j != 0) {
                paramView.setPadding(k, 0, m, 0);
              }
              for (;;)
              {
                break;
                if (i1 == 1) {
                  paramView.setPadding(2, 0, 2, 0);
                } else if (n == i1 - 1) {
                  paramView.setPadding(k, i, m, 0);
                }
              }
              ((View)localObject1).setVisibility(0);
            }
            else
            {
              if (!"image".equals(localObject5)) {
                break label874;
              }
              ((LinearLayout.LayoutParams)localObject4).gravity = 1;
              paramView.setPadding(0, 0, 0, 0);
            }
            for (;;)
            {
              break;
              label874:
              if ("progress".equals(localObject5))
              {
                ((LinearLayout.LayoutParams)localObject4).height = AIOUtils.b(4.0F, (Resources)localObject3);
                if ((i1 == 1) && (((View)localObject1).getVisibility() == 8))
                {
                  paramView.setPadding(0, 0, 0, 0);
                  if (a(1)) {
                    paramView.setPadding(0, a(paramContext, 10), 0, 0);
                  }
                  if (a(2)) {
                    paramView.setPadding(0, 0, 0, a(paramContext, 10));
                  }
                }
              }
              else if ("more".equals(localObject5))
              {
                ((View)localObject1).setVisibility(0);
              }
            }
          }
        }
        n += 1;
        localObject1 = paramContext;
      }
    }
    paramView.removeAllViews();
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    n = 0;
    for (;;)
    {
      localObject2 = paramView;
      if (n >= i1) {
        break;
      }
      localObject2 = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(n);
      ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localObject2 instanceof StructMsgItemTitle)) {
        ((StructMsgItemTitle)localObject2).a(a(), this.p);
      }
      localObject4 = ((AbsStructMsgElement)localObject2).a((Context)localObject1, null, paramBundle);
      if (localObject4 == null) {
        return paramView;
      }
      i2 = AIOUtils.b(10.0F, (Resources)localObject3);
      i3 = AIOUtils.b(5.0F, (Resources)localObject3);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      if (n > 0) {
        ((LinearLayout.LayoutParams)localObject1).topMargin = i3;
      }
      localObject5 = ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangString;
      if ("picture".equals(localObject5))
      {
        ((View)localObject4).setId(-1);
        ((LinearLayout.LayoutParams)localObject1).height = (BaseChatItemLayout.f - i2 - i2);
        ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(9.5F, (Resources)localObject3);
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.b(9.5F, (Resources)localObject3);
      }
      for (;;)
      {
        break;
        if ("video".equals(localObject5))
        {
          ((LinearLayout.LayoutParams)localObject1).height = (BaseChatItemLayout.f - i2 - i2);
          ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(9.5F, (Resources)localObject3);
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.b(9.5F, (Resources)localObject3);
        }
        else if ("title".equals(localObject5))
        {
          if (j != 0)
          {
            localObject2 = (StructMsgItemTitle)localObject2;
            if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).c())) {
              ((TextView)localObject4).setTextSize(18.0F);
            }
            if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).e())) {
              ((TextView)localObject4).setTypeface(Typeface.DEFAULT, 1);
            }
          }
          ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(3.0F, (Resources)localObject3);
          ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.b(3.0F, (Resources)localObject3);
          if ((a(1)) && (n == 0)) {
            ((LinearLayout.LayoutParams)localObject1).topMargin += AIOUtils.b(14.0F, (Resources)localObject3);
          }
          ((View)localObject4).setId(-1);
        }
        else
        {
          if ("summary".equals(localObject5))
          {
            if (j != 0)
            {
              localObject5 = (StructMsgItemSummary)localObject2;
              String str = ((StructMsgItemSummary)localObject5).f();
              if ((str != null) && (str.equals("1")))
              {
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject5).c())) {
                  ((TextView)localObject4).setTextSize(12.0F);
                }
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject5).d())) {
                  ((TextView)localObject4).setTextColor(Color.parseColor("#8e8e8e"));
                }
              }
              else
              {
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject5).c())) {
                  ((TextView)localObject4).setTextSize(16.0F);
                }
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject5).d())) {
                  ((TextView)localObject4).setTextColor(-16777216);
                }
                ((TextView)localObject4).setLineSpacing(4.0F, 1.0F);
              }
            }
            localObject2 = ((StructMsgItemSummary)localObject2).f();
            if ((localObject2 != null) && (((String)localObject2).equals("1")))
            {
              ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(3.0F, (Resources)localObject3);
              ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.b(8.0F, (Resources)localObject3);
            }
            else
            {
              ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(5.0F, (Resources)localObject3);
              ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.b(5.0F, (Resources)localObject3);
            }
            if (this.o == 1)
            {
              localObject2 = (TextView)localObject4;
              ((TextView)localObject2).setTextSize(12.0F);
              ((TextView)localObject2).setTextColor(-4473925);
            }
            if ((a(2)) && (n == i1 - 1)) {
              if (j != 0) {
                ((LinearLayout.LayoutParams)localObject1).bottomMargin += AIOUtils.b(12.0F, (Resources)localObject3);
              } else {
                ((LinearLayout.LayoutParams)localObject1).bottomMargin += AIOUtils.b(16.0F, (Resources)localObject3);
              }
            }
            ((View)localObject4).setId(-1);
          }
          else if ("hr".equals(localObject5))
          {
            if (((StructMsgItemHr)localObject2).a) {
              ((LinearLayout.LayoutParams)localObject1).height = 0;
            } else {
              ((LinearLayout.LayoutParams)localObject1).height = 1;
            }
            if ((j != 0) && (n != 0)) {
              ((LinearLayout.LayoutParams)localObject1).topMargin += AIOUtils.b(6.0F, (Resources)localObject3);
            }
            if (j != 0) {
              paramView.setPadding(k, 0, m, 0);
            }
            do
            {
              for (;;)
              {
                break label1870;
                localObject2 = paramView;
                if (i1 != 1) {
                  break;
                }
                ((LinearLayout)localObject2).setPadding(2, 0, 2, 0);
              }
            } while (n != i1 - 1);
            ((LinearLayout)localObject2).setPadding(k, i, m, 0);
          }
          else
          {
            localObject2 = paramView;
            if (!"image".equals(localObject5)) {
              break label1873;
            }
            ((LinearLayout.LayoutParams)localObject1).gravity = 1;
            ((LinearLayout)localObject2).setPadding(0, 0, 0, 0);
          }
          label1870:
          continue;
          label1873:
          if ("progress".equals(localObject5))
          {
            ((LinearLayout.LayoutParams)localObject1).height = AIOUtils.b(4.0F, (Resources)localObject3);
            if ((i1 == 1) && (((View)localObject4).getVisibility() == 8))
            {
              ((LinearLayout)localObject2).setPadding(0, 0, 0, 0);
              if (a(1)) {
                ((LinearLayout)localObject2).setPadding(0, a(paramContext, 10), 0, 0);
              }
              if (a(2)) {
                ((LinearLayout)localObject2).setPadding(0, 0, 0, a(paramContext, 10));
              }
            }
          }
          else if ("more".equals(localObject5))
          {
            localObject1 = new LinearLayout.LayoutParams(-1, AIOUtils.b(36.0F, (Resources)localObject3));
          }
        }
      }
      paramView.addView((View)localObject4, (ViewGroup.LayoutParams)localObject1);
      n += 1;
      localObject1 = paramContext;
    }
    return localObject2;
  }
  
  public String b()
  {
    return "Layout0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault
 * JD-Core Version:    0.7.0.1
 */