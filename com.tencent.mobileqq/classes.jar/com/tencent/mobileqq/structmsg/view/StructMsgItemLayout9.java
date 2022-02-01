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
    Resources localResources = paramContext.getResources();
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i;
    if (paramView != null)
    {
      localObject1 = localObject2;
      if ((paramView instanceof RelativeLayout))
      {
        paramView = (RelativeLayout)paramView;
        if (paramView.getChildCount() == j)
        {
          i = 0;
          localObject1 = paramView;
          if (i >= j) {
            break label1053;
          }
          localObject1 = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
          localObject2 = ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangString;
          if ("summary".equals(localObject2))
          {
            localObject1 = (StructMsgItemSummary)localObject1;
            if (paramBoolean)
            {
              ((StructMsgItemSummary)localObject1).b("black");
              label122:
              localObject2 = ((StructMsgItemSummary)localObject1).f();
              if ((localObject2 == null) || (!((String)localObject2).equals("1"))) {
                break label189;
              }
              ((StructMsgItemSummary)localObject1).c("22");
              ((StructMsgItemSummary)localObject1).a(true);
              ((StructMsgItemSummary)localObject1).a(paramContext, paramView.findViewById(2), paramBundle);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            ((StructMsgItemSummary)localObject1).b(null);
            break label122;
            label189:
            if ((localObject2 != null) && (((String)localObject2).equals("2")))
            {
              ((StructMsgItemSummary)localObject1).c("44");
              ((StructMsgItemSummary)localObject1).a(true);
              ((StructMsgItemSummary)localObject1).a(paramContext, paramView.findViewById(3), paramBundle);
            }
            else
            {
              ((StructMsgItemSummary)localObject1).c("30");
              ((StructMsgItemSummary)localObject1).b(20);
              ((StructMsgItemSummary)localObject1).a(paramContext, paramView.findViewById(4), paramBundle);
              continue;
              if ("picture".equals(localObject2))
              {
                localObject1 = (StructMsgItemCover)localObject1;
                if ((((StructMsgItemCover)localObject1).c != null) && (!((StructMsgItemCover)localObject1).c.equals("")))
                {
                  localObject2 = ((StructMsgItemCover)localObject1).a(paramContext, paramView.findViewById(6), true, paramBundle);
                  ((View)localObject2).setClickable(true);
                  ((View)localObject2).setOnClickListener((View.OnClickListener)localObject1);
                }
                else
                {
                  ((StructMsgItemCover)localObject1).a(paramContext, paramView.findViewById(5), true, paramBundle);
                }
              }
            }
          }
        }
        paramView.removeAllViews();
        localObject1 = paramView;
      }
    }
    if (localObject1 == null)
    {
      localObject1 = new RelativeLayout(paramContext);
      ((RelativeLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    }
    for (;;)
    {
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setGravity(3);
      localLinearLayout.setId(1);
      paramView = new RelativeLayout.LayoutParams(-2, -2);
      paramView.addRule(9, -1);
      paramView.rightMargin = AIOUtils.a(20.0F, localResources);
      ((RelativeLayout)localObject1).addView(localLinearLayout, paramView);
      paramView = null;
      i = 0;
      Object localObject3;
      if (i < j)
      {
        localObject2 = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject3 = ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangString;
        if ("summary".equals(localObject3))
        {
          localObject2 = (StructMsgItemSummary)localObject2;
          if (paramBoolean)
          {
            ((StructMsgItemSummary)localObject2).b("black");
            label527:
            localObject3 = ((StructMsgItemSummary)localObject2).f();
            if ((localObject3 == null) || (!((String)localObject3).equals("1"))) {
              break label621;
            }
            ((StructMsgItemSummary)localObject2).c("22");
            ((StructMsgItemSummary)localObject2).a(true);
            localObject2 = ((StructMsgItemSummary)localObject2).a(paramContext, null, paramBundle);
            ((View)localObject2).setId(2);
            ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
            localLinearLayout.addView((View)localObject2, 0);
          }
        }
      }
      label1053:
      label1066:
      for (;;)
      {
        i += 1;
        break;
        ((StructMsgItemSummary)localObject2).b(null);
        break label527;
        label621:
        if ((localObject3 != null) && (((String)localObject3).equals("2")))
        {
          ((StructMsgItemSummary)localObject2).c("44");
          ((StructMsgItemSummary)localObject2).a(true);
          localObject2 = ((StructMsgItemSummary)localObject2).a(paramContext, null, paramBundle);
          ((View)localObject2).setId(3);
          localObject3 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(-3.5F, localResources);
          localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        }
        else
        {
          ((StructMsgItemSummary)localObject2).c("30");
          ((StructMsgItemSummary)localObject2).b(20);
          localObject2 = ((StructMsgItemSummary)localObject2).a(paramContext, null, paramBundle);
          ((View)localObject2).setId(4);
          localObject3 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject3).addRule(1, 1);
          ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
          continue;
          if ("picture".equals(localObject3))
          {
            localObject3 = (StructMsgItemCover)localObject2;
            localObject2 = ((StructMsgItemCover)localObject3).a(paramContext, null, true, paramBundle);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(40.0F, localResources), AIOUtils.a(40.0F, localResources));
            if ((((StructMsgItemCover)localObject3).c != null) && (!((StructMsgItemCover)localObject3).c.equals("")))
            {
              ((View)localObject2).setId(6);
              localLayoutParams.addRule(11, -1);
              ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
              ((View)localObject2).setClickable(true);
              ((View)localObject2).setOnClickListener((View.OnClickListener)localObject3);
            }
            else
            {
              ((View)localObject2).setId(5);
              paramView = (View)localObject2;
              continue;
              if (localLinearLayout.getChildCount() == 0) {
                localLinearLayout.setVisibility(8);
              }
              if (paramView != null)
              {
                paramContext = new RelativeLayout.LayoutParams(AIOUtils.a(40.0F, localResources), AIOUtils.a(40.0F, localResources));
                if (((RelativeLayout)localObject1).findViewById(6) != null)
                {
                  paramContext.addRule(0, 6);
                  paramContext.rightMargin = AIOUtils.a(7.5F, localResources);
                  ((RelativeLayout)localObject1).addView(paramView, paramContext);
                }
              }
              else
              {
                paramContext = ((RelativeLayout)localObject1).findViewById(4);
                if (paramContext != null)
                {
                  paramView = (RelativeLayout.LayoutParams)paramContext.getLayoutParams();
                  if (((RelativeLayout)localObject1).findViewById(5) == null) {
                    break label1066;
                  }
                  paramView.addRule(0, 5);
                }
              }
              for (;;)
              {
                paramContext.setLayoutParams(paramView);
                a((View)localObject1);
                i = AIOUtils.a(22.5F, localResources);
                j = AIOUtils.a(22.5F, localResources);
                ((RelativeLayout)localObject1).setPadding(i, AIOUtils.a(10.75F, localResources), j, AIOUtils.a(11.75F, localResources));
                return localObject1;
                paramContext.addRule(11, -1);
                break;
                if (((RelativeLayout)localObject1).findViewById(6) != null) {
                  paramView.addRule(0, 6);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public int b()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout9
 * JD-Core Version:    0.7.0.1
 */