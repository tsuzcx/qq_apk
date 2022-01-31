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
    Object localObject1 = paramBundle.getString("sType");
    int i;
    Resources localResources;
    int k;
    int j;
    int m;
    if (((localObject1 == null) || (!((String)localObject1).equals("1"))) || (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA))
    {
      i = 1;
      localResources = paramContext.getResources();
      k = localResources.getDimensionPixelSize(2131558648);
      j = localResources.getDimensionPixelSize(2131558649);
      m = AIOUtils.a(2.0F, localResources);
      if (i == 0) {
        break label1950;
      }
      k = AIOUtils.a(12.0F, localResources);
      j = k;
    }
    label792:
    label1947:
    label1950:
    for (;;)
    {
      if ((paramView != null) && ((paramView instanceof LinearLayout)))
      {
        localObject1 = (LinearLayout)paramView;
        label105:
        if (!a(1)) {
          break label1947;
        }
        m += a(paramContext);
      }
      for (;;)
      {
        int n;
        if (!TextUtils.isEmpty(this.c))
        {
          ((LinearLayout)localObject1).setBackgroundResource(2130837917);
          n = AIOUtils.a(1.0F, localResources);
          paramView = (LinearLayout.LayoutParams)((LinearLayout)localObject1).getLayoutParams();
          paramView.leftMargin = n;
          paramView.rightMargin = n;
          ((LinearLayout)localObject1).setLayoutParams(paramView);
        }
        ((LinearLayout)localObject1).setPadding(k, 0, j, 0);
        int i1;
        View localView;
        if (((LinearLayout)localObject1).getChildCount() == this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
          n = 0;
          if (n < i1)
          {
            paramView = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(n);
            paramView.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
            if ((paramView instanceof StructMsgItemTitle)) {
              ((StructMsgItemTitle)paramView).a(a(), this.f);
            }
            localView = paramView.a(paramContext, ((LinearLayout)localObject1).getChildAt(n), paramBundle);
            if (localView != null) {
              break label326;
            }
          }
        }
        label326:
        Object localObject2;
        label637:
        do
        {
          return localObject1;
          i = 0;
          break;
          localObject1 = new LinearLayout(paramContext);
          ((LinearLayout)localObject1).setOrientation(1);
          ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
          break label105;
          i2 = AIOUtils.a(10.0F, localResources);
          i3 = AIOUtils.a(5.0F, localResources);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          if (n > 0) {
            ((LinearLayout.LayoutParams)localObject2).topMargin = i3;
          }
          str = paramView.jdField_a_of_type_JavaLangString;
          if ("picture".equals(str))
          {
            localView.setId(-1);
            ((LinearLayout.LayoutParams)localObject2).height = (BaseChatItemLayout.e - i2 - i2);
          }
          for (;;)
          {
            n += 1;
            break;
            if ("video".equals(str))
            {
              ((LinearLayout.LayoutParams)localObject2).height = (BaseChatItemLayout.e - i2 - i2);
            }
            else if ("title".equals(str))
            {
              if (i != 0)
              {
                if (TextUtils.isEmpty(((StructMsgItemTitle)paramView).c())) {
                  ((TextView)localView).setTextSize(18.0F);
                }
                if (TextUtils.isEmpty(((StructMsgItemTitle)paramView).e())) {
                  ((TextView)localView).setTypeface(Typeface.DEFAULT, 1);
                }
              }
              localView.setId(-1);
            }
            else
            {
              if ("summary".equals(str))
              {
                if (this.e == 1)
                {
                  ((TextView)localView).setTextSize(12.0F);
                  ((TextView)localView).setTextColor(-4473925);
                }
                if (i != 0)
                {
                  localObject2 = ((StructMsgItemSummary)paramView).f();
                  if ((localObject2 == null) || (!((String)localObject2).equals("1"))) {
                    break label637;
                  }
                  if (TextUtils.isEmpty(((StructMsgItemSummary)paramView).c())) {
                    ((TextView)localView).setTextSize(12.0F);
                  }
                  if (TextUtils.isEmpty(((StructMsgItemSummary)paramView).d())) {
                    ((TextView)localView).setTextColor(Color.parseColor("#8e8e8e"));
                  }
                }
                for (;;)
                {
                  localView.setId(-1);
                  break;
                  if (TextUtils.isEmpty(((StructMsgItemSummary)paramView).c())) {
                    ((TextView)localView).setTextSize(16.0F);
                  }
                  if (TextUtils.isEmpty(((StructMsgItemSummary)paramView).d())) {
                    ((TextView)localView).setTextColor(-16777216);
                  }
                  ((TextView)localView).setLineSpacing(4.0F, 1.0F);
                }
              }
              if ("hr".equals(str))
              {
                if (((StructMsgItemHr)paramView).a)
                {
                  ((LinearLayout.LayoutParams)localObject2).height = 0;
                  if ((i != 0) && (n != 0)) {
                    ((LinearLayout.LayoutParams)localObject2).topMargin += AIOUtils.a(6.0F, localResources);
                  }
                  localView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
                  if (i == 0) {
                    break label792;
                  }
                  ((LinearLayout)localObject1).setPadding(k, 0, j, 0);
                }
                for (;;)
                {
                  localView.setVisibility(0);
                  break;
                  ((LinearLayout.LayoutParams)localObject2).height = 1;
                  break label723;
                  if (i1 == 1) {
                    ((LinearLayout)localObject1).setPadding(2, 0, 2, 0);
                  } else if (n == i1 - 1) {
                    ((LinearLayout)localObject1).setPadding(k, m, j, 0);
                  }
                }
              }
              if ("image".equals(str))
              {
                ((LinearLayout.LayoutParams)localObject2).gravity = 1;
                ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
              }
              else if ("progress".equals(str))
              {
                ((LinearLayout.LayoutParams)localObject2).height = AIOUtils.a(4.0F, localResources);
                if ((i1 == 1) && (localView.getVisibility() == 8))
                {
                  ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
                  if (a(1)) {
                    ((LinearLayout)localObject1).setPadding(0, a(paramContext), 0, 0);
                  }
                  if (a(2)) {
                    ((LinearLayout)localObject1).setPadding(0, 0, 0, a(paramContext));
                  }
                }
              }
              else if ("more".equals(str))
              {
                localView.setVisibility(0);
              }
            }
          }
          ((LinearLayout)localObject1).removeAllViews();
          i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
          n = 0;
          if (n >= i1) {
            break label1174;
          }
          localObject2 = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(n);
          ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          if ((localObject2 instanceof StructMsgItemTitle)) {
            ((StructMsgItemTitle)localObject2).a(a(), this.f);
          }
          localView = ((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
        } while (localView == null);
        label723:
        label990:
        int i2 = AIOUtils.a(10.0F, localResources);
        int i3 = AIOUtils.a(5.0F, localResources);
        paramView = new LinearLayout.LayoutParams(-1, -2);
        if (n > 0) {
          paramView.topMargin = i3;
        }
        String str = ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangString;
        if ("picture".equals(str))
        {
          localView.setId(-1);
          paramView.height = (BaseChatItemLayout.e - i2 - i2);
          paramView.topMargin = AIOUtils.a(9.5F, localResources);
          paramView.bottomMargin = AIOUtils.a(9.5F, localResources);
        }
        for (;;)
        {
          ((LinearLayout)localObject1).addView(localView, paramView);
          n += 1;
          break label990;
          break;
          if ("video".equals(str))
          {
            paramView.height = (BaseChatItemLayout.e - i2 - i2);
            paramView.topMargin = AIOUtils.a(9.5F, localResources);
            paramView.bottomMargin = AIOUtils.a(9.5F, localResources);
          }
          else if ("title".equals(str))
          {
            if (i != 0)
            {
              if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).c())) {
                ((TextView)localView).setTextSize(18.0F);
              }
              if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).e())) {
                ((TextView)localView).setTypeface(Typeface.DEFAULT, 1);
              }
            }
            paramView.topMargin = AIOUtils.a(3.0F, localResources);
            paramView.bottomMargin = AIOUtils.a(3.0F, localResources);
            if ((a(1)) && (n == 0)) {
              paramView.topMargin += AIOUtils.a(14.0F, localResources);
            }
            localView.setId(-1);
          }
          else
          {
            if ("summary".equals(str))
            {
              if (i != 0)
              {
                str = ((StructMsgItemSummary)localObject2).f();
                if ((str == null) || (!str.equals("1"))) {
                  break label1569;
                }
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject2).c())) {
                  ((TextView)localView).setTextSize(12.0F);
                }
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject2).d())) {
                  ((TextView)localView).setTextColor(Color.parseColor("#8e8e8e"));
                }
              }
              label1445:
              localObject2 = ((StructMsgItemSummary)localObject2).f();
              if ((localObject2 != null) && (((String)localObject2).equals("1")))
              {
                paramView.topMargin = AIOUtils.a(3.0F, localResources);
                paramView.bottomMargin = AIOUtils.a(8.0F, localResources);
                label1494:
                if (this.e == 1)
                {
                  ((TextView)localView).setTextSize(12.0F);
                  ((TextView)localView).setTextColor(-4473925);
                }
                if ((a(2)) && (n == i1 - 1)) {
                  if (i == 0) {
                    break label1656;
                  }
                }
              }
              label1569:
              label1656:
              for (paramView.bottomMargin += AIOUtils.a(12.0F, localResources);; paramView.bottomMargin += AIOUtils.a(16.0F, localResources))
              {
                localView.setId(-1);
                break;
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject2).c())) {
                  ((TextView)localView).setTextSize(16.0F);
                }
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject2).d())) {
                  ((TextView)localView).setTextColor(-16777216);
                }
                ((TextView)localView).setLineSpacing(4.0F, 1.0F);
                break label1445;
                paramView.topMargin = AIOUtils.a(5.0F, localResources);
                paramView.bottomMargin = AIOUtils.a(5.0F, localResources);
                break label1494;
              }
            }
            if ("hr".equals(str))
            {
              if (((StructMsgItemHr)localObject2).a) {}
              for (paramView.height = 0;; paramView.height = 1)
              {
                if ((i != 0) && (n != 0)) {
                  paramView.topMargin += AIOUtils.a(6.0F, localResources);
                }
                if (i == 0) {
                  break label1754;
                }
                ((LinearLayout)localObject1).setPadding(k, 0, j, 0);
                break;
              }
              label1754:
              if (i1 == 1) {
                ((LinearLayout)localObject1).setPadding(2, 0, 2, 0);
              } else if (n == i1 - 1) {
                ((LinearLayout)localObject1).setPadding(k, m, j, 0);
              }
            }
            else if ("image".equals(str))
            {
              paramView.gravity = 1;
              ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
            }
            else if ("progress".equals(str))
            {
              paramView.height = AIOUtils.a(4.0F, localResources);
              if ((i1 == 1) && (localView.getVisibility() == 8))
              {
                ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
                if (a(1)) {
                  ((LinearLayout)localObject1).setPadding(0, a(paramContext), 0, 0);
                }
                if (a(2)) {
                  ((LinearLayout)localObject1).setPadding(0, 0, 0, a(paramContext));
                }
              }
            }
            else if ("more".equals(str))
            {
              paramView = new LinearLayout.LayoutParams(-1, AIOUtils.a(36.0F, localResources));
            }
          }
        }
      }
    }
  }
  
  public String b()
  {
    return "Layout0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault
 * JD-Core Version:    0.7.0.1
 */