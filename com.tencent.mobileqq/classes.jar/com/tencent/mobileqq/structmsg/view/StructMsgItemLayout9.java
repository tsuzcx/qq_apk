package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;

public class StructMsgItemLayout9
  extends AbsStructMsgItem
{
  public View a(Context paramContext, View paramView, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject2 = paramContext;
    Resources localResources = paramContext.getResources();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      paramView = (RelativeLayout)paramView;
      if (paramView.getChildCount() == j)
      {
        i = 0;
        while (i < j)
        {
          paramContext = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          paramContext.jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject1 = paramContext.jdField_a_of_type_JavaLangString;
          if ("summary".equals(localObject1))
          {
            paramContext = (StructMsgItemSummary)paramContext;
            if (paramBoolean) {
              paramContext.b("black");
            } else {
              paramContext.b(null);
            }
            localObject1 = paramContext.f();
            if ((localObject1 != null) && (((String)localObject1).equals("1")))
            {
              paramContext.c("22");
              paramContext.a(true);
              paramContext.a((Context)localObject2, paramView.findViewById(2), paramBundle);
            }
            else if ((localObject1 != null) && (((String)localObject1).equals("2")))
            {
              paramContext.c("44");
              paramContext.a(true);
              paramContext.a((Context)localObject2, paramView.findViewById(3), paramBundle);
            }
            else
            {
              paramContext.c("30");
              paramContext.b(20);
              paramContext.a((Context)localObject2, paramView.findViewById(4), paramBundle);
            }
          }
          else if ("picture".equals(localObject1))
          {
            paramContext = (StructMsgItemCover)paramContext;
            if ((paramContext.c != null) && (!paramContext.c.equals("")))
            {
              localObject1 = paramContext.a((Context)localObject2, paramView.findViewById(6), true, paramBundle);
              ((View)localObject1).setClickable(true);
              ((View)localObject1).setOnClickListener(paramContext);
            }
            else
            {
              paramContext.a((Context)localObject2, paramView.findViewById(5), true, paramBundle);
            }
          }
          i += 1;
        }
        return paramView;
      }
      paramView.removeAllViews();
    }
    else
    {
      paramView = null;
    }
    Object localObject1 = paramView;
    if (paramView == null)
    {
      localObject1 = new RelativeLayout((Context)localObject2);
      ((RelativeLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    }
    LinearLayout localLinearLayout = new LinearLayout((Context)localObject2);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(3);
    localLinearLayout.setId(1);
    paramView = new RelativeLayout.LayoutParams(-2, -2);
    paramView.addRule(9, -1);
    paramView.rightMargin = AIOUtils.b(20.0F, localResources);
    ((RelativeLayout)localObject1).addView(localLinearLayout, paramView);
    int i = 0;
    paramView = null;
    for (;;)
    {
      localObject2 = paramContext;
      if (i >= j) {
        break;
      }
      Object localObject3 = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      Object localObject4 = ((AbsStructMsgElement)localObject3).jdField_a_of_type_JavaLangString;
      if ("summary".equals(localObject4))
      {
        localObject3 = (StructMsgItemSummary)localObject3;
        if (paramBoolean) {
          ((StructMsgItemSummary)localObject3).b("black");
        } else {
          ((StructMsgItemSummary)localObject3).b(null);
        }
        localObject4 = ((StructMsgItemSummary)localObject3).f();
        if ((localObject4 != null) && (((String)localObject4).equals("1")))
        {
          ((StructMsgItemSummary)localObject3).c("22");
          ((StructMsgItemSummary)localObject3).a(true);
          localObject2 = ((StructMsgItemSummary)localObject3).a((Context)localObject2, null, paramBundle);
          ((View)localObject2).setId(2);
          ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
          localLinearLayout.addView((View)localObject2, 0);
        }
        for (;;)
        {
          break label870;
          if ((localObject4 == null) || (!((String)localObject4).equals("2"))) {
            break;
          }
          ((StructMsgItemSummary)localObject3).c("44");
          ((StructMsgItemSummary)localObject3).a(true);
          localObject2 = ((StructMsgItemSummary)localObject3).a((Context)localObject2, null, paramBundle);
          ((View)localObject2).setId(3);
          localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(-3.5F, localResources);
          localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
        ((StructMsgItemSummary)localObject3).c("30");
        ((StructMsgItemSummary)localObject3).b(20);
        localObject2 = ((StructMsgItemSummary)localObject3).a((Context)localObject2, null, paramBundle);
        ((View)localObject2).setId(4);
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject3).addRule(1, 1);
        ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      else if ("picture".equals(localObject4))
      {
        localObject3 = (StructMsgItemCover)localObject3;
        localObject2 = ((StructMsgItemCover)localObject3).a((Context)localObject2, null, true, paramBundle);
        localObject4 = new RelativeLayout.LayoutParams(AIOUtils.b(40.0F, localResources), AIOUtils.b(40.0F, localResources));
        if ((((StructMsgItemCover)localObject3).c != null) && (!((StructMsgItemCover)localObject3).c.equals("")))
        {
          ((View)localObject2).setId(6);
          ((RelativeLayout.LayoutParams)localObject4).addRule(11, -1);
          ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
          ((View)localObject2).setClickable(true);
          ((View)localObject2).setOnClickListener((View.OnClickListener)localObject3);
        }
        else
        {
          ((View)localObject2).setId(5);
          paramView = (View)localObject2;
        }
      }
      label870:
      i += 1;
    }
    if (localLinearLayout.getChildCount() == 0) {
      localLinearLayout.setVisibility(8);
    }
    if (paramView != null)
    {
      paramContext = new RelativeLayout.LayoutParams(AIOUtils.b(40.0F, localResources), AIOUtils.b(40.0F, localResources));
      if (((RelativeLayout)localObject1).findViewById(6) != null)
      {
        paramContext.addRule(0, 6);
        paramContext.rightMargin = AIOUtils.b(7.5F, localResources);
      }
      else
      {
        paramContext.addRule(11, -1);
      }
      ((RelativeLayout)localObject1).addView(paramView, paramContext);
    }
    paramContext = ((RelativeLayout)localObject1).findViewById(4);
    if (paramContext != null)
    {
      paramView = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
      if (((RelativeLayout)localObject1).findViewById(5) != null) {
        paramView.addRule(0, 5);
      } else if (((RelativeLayout)localObject1).findViewById(6) != null) {
        paramView.addRule(0, 6);
      }
      paramContext.setLayoutParams(paramView);
    }
    a((View)localObject1);
    i = AIOUtils.b(22.5F, localResources);
    j = AIOUtils.b(22.5F, localResources);
    ((RelativeLayout)localObject1).setPadding(i, AIOUtils.b(10.75F, localResources), j, AIOUtils.b(11.75F, localResources));
    return localObject1;
  }
  
  protected int b()
  {
    return 9;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, false, paramBundle);
  }
  
  public String b()
  {
    return "Layout9";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout9
 * JD-Core Version:    0.7.0.1
 */