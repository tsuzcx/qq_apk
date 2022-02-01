package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Collection;

public class StructMsgItemLayout1
  extends AbsStructMsgItem
{
  public StructMsgItemLayout1() {}
  
  public StructMsgItemLayout1(Collection<AbsStructMsgElement> paramCollection)
  {
    super(paramCollection);
  }
  
  protected int a(Resources paramResources, int paramInt, AbsStructMsgElement paramAbsStructMsgElement)
  {
    return AIOUtils.b(5.0F, paramResources);
  }
  
  protected ArrayList<AbsStructMsgElement> a(ArrayList<AbsStructMsgElement> paramArrayList)
  {
    return paramArrayList;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject3 = this;
    Object localObject1 = paramContext;
    Resources localResources = paramContext.getResources();
    int i1 = localResources.getDimensionPixelSize(2131299802);
    int n = localResources.getDimensionPixelSize(2131299803);
    int i = AIOUtils.b(5.0F, localResources);
    if ((((StructMsgItemLayout1)localObject3).as != null) && (((StructMsgItemLayout1)localObject3).as.mMsgServiceID == 35)) {
      k = 6;
    } else {
      k = 10;
    }
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localObject1 = (LinearLayout)paramView;
    }
    else
    {
      paramView = new LinearLayout((Context)localObject1);
      paramView.setOrientation(1);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      if (((StructMsgItemLayout1)localObject3).a(1)) {
        j = ((StructMsgItemLayout1)localObject3).a((Context)localObject1, k) + i;
      } else {
        j = i;
      }
      m = i;
      if (((StructMsgItemLayout1)localObject3).a(2)) {
        m = i + ((StructMsgItemLayout1)localObject3).a((Context)localObject1, k);
      }
      paramView.setPadding(i1, j, n, m);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      i = j;
      localObject1 = paramView;
    }
    if (!TextUtils.isEmpty(((StructMsgItemLayout1)localObject3).e)) {
      ((LinearLayout)localObject1).setBackgroundResource(2130839622);
    }
    ((StructMsgItemLayout1)localObject3).d((View)localObject1);
    paramView = ((StructMsgItemLayout1)localObject3).a(((StructMsgItemLayout1)localObject3).ax);
    int k = ((LinearLayout)localObject1).getChildCount();
    int m = paramView.size();
    Object localObject2 = "image";
    int j = i1;
    Object localObject6;
    Object localObject4;
    Object localObject5;
    if (k == m)
    {
      i1 = paramView.size();
      m = 0;
      k = j;
      j = i;
      i = n;
      while (m < i1)
      {
        localObject6 = (AbsStructMsgElement)paramView.get(m);
        ((AbsStructMsgElement)localObject6).ar = ((StructMsgItemLayout1)localObject3).ar;
        if ((localObject6 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject6).a(d(), ((StructMsgItemLayout1)localObject3).av);
        }
        localObject4 = ((AbsStructMsgElement)localObject6).a(paramContext, ((LinearLayout)localObject1).getChildAt(m), paramBundle);
        if (localObject4 == null) {
          return localObject1;
        }
        n = AIOUtils.b(10.0F, localResources);
        localObject5 = new LinearLayout.LayoutParams(-1, -2);
        if (m > 0) {
          ((LinearLayout.LayoutParams)localObject5).topMargin = ((StructMsgItemLayout1)localObject3).a(localResources, m, (AbsStructMsgElement)localObject6);
        }
        localObject6 = ((AbsStructMsgElement)localObject6).b;
        if ("picture".equals(localObject6))
        {
          ((View)localObject4).setId(-1);
          ((LinearLayout.LayoutParams)localObject5).height = (BaseChatItemLayout.f - n - n);
        }
        for (;;)
        {
          break;
          if ("video".equals(localObject6))
          {
            ((LinearLayout.LayoutParams)localObject5).height = (BaseChatItemLayout.f - n - n);
          }
          else if ("title".equals(localObject6))
          {
            ((View)localObject4).setId(-1);
          }
          else if ("summary".equals(localObject6))
          {
            ((View)localObject4).setId(-1);
          }
          else if ("hr".equals(localObject6))
          {
            ((LinearLayout.LayoutParams)localObject5).height = 1;
            if (i1 == 1) {
              ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
            } else if (m == i1 - 1) {
              ((LinearLayout)localObject1).setPadding(k, j, i, 0);
            }
          }
          else if (((String)localObject2).equals(localObject6))
          {
            ((LinearLayout.LayoutParams)localObject5).gravity = 1;
            ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
          }
        }
        m += 1;
      }
    }
    localObject3 = localObject2;
    ((LinearLayout)localObject1).removeAllViews();
    i1 = paramView.size();
    k = 0;
    localObject2 = paramView;
    m = j;
    paramView = (View)localObject3;
    j = i1;
    for (;;)
    {
      localObject3 = this;
      if (k >= j) {
        break;
      }
      localObject4 = (AbsStructMsgElement)((ArrayList)localObject2).get(k);
      ((AbsStructMsgElement)localObject4).ar = ((StructMsgItemLayout1)localObject3).ar;
      if ((localObject4 instanceof StructMsgItemTitle)) {
        ((StructMsgItemTitle)localObject4).a(d(), ((StructMsgItemLayout1)localObject3).av);
      }
      localObject5 = ((AbsStructMsgElement)localObject4).a(paramContext, null, paramBundle);
      if (localObject5 == null) {
        return localObject1;
      }
      i1 = AIOUtils.b(10.0F, localResources);
      localObject6 = new LinearLayout.LayoutParams(-1, -2);
      if (k > 0) {
        ((LinearLayout.LayoutParams)localObject6).topMargin = ((StructMsgItemLayout1)localObject3).a(localResources, k, (AbsStructMsgElement)localObject4);
      }
      localObject3 = ((AbsStructMsgElement)localObject4).b;
      if ("picture".equals(localObject3))
      {
        ((View)localObject5).setId(-1);
        ((LinearLayout.LayoutParams)localObject6).height = (BaseChatItemLayout.f - i1 - i1);
      }
      for (;;)
      {
        break;
        if ("video".equals(localObject3))
        {
          ((LinearLayout.LayoutParams)localObject6).height = (BaseChatItemLayout.f - i1 - i1);
        }
        else if ("title".equals(localObject3))
        {
          ((View)localObject5).setId(-1);
        }
        else if ("summary".equals(localObject3))
        {
          ((View)localObject5).setId(-1);
        }
        else if ("hr".equals(localObject3))
        {
          ((LinearLayout.LayoutParams)localObject6).height = 1;
          if (j == 1) {
            ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
          } else if (k == j - 1) {
            ((LinearLayout)localObject1).setPadding(m, i, n, 0);
          }
        }
        else if (paramView.equals(localObject3))
        {
          ((LinearLayout.LayoutParams)localObject6).gravity = 1;
          ((LinearLayout)localObject1).setPadding(0, 0, 0, 0);
        }
      }
      ((LinearLayout)localObject1).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      k += 1;
    }
    return localObject1;
  }
  
  protected int c()
  {
    return 1;
  }
  
  public String e()
  {
    return "Layout1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout1
 * JD-Core Version:    0.7.0.1
 */