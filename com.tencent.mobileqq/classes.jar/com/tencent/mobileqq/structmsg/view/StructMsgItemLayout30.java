package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StructMsgItemLayout30
  extends StructMsgItemLayout1
{
  private TextView a(Context paramContext, List<AbsStructMsgElement> paramList)
  {
    paramContext = new TextView(paramContext);
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    if ((paramList != null) && (i > 2))
    {
      paramList = (AbsStructMsgElement)paramList.get(i - 1);
      if ((paramList instanceof AbsStructMsgTextElement))
      {
        paramContext.setText(((AbsStructMsgTextElement)paramList).b());
        paramContext.setGravity(16);
        paramContext.setSingleLine(true);
      }
    }
    return paramContext;
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    if (paramLinearLayout.getWidth() > 0)
    {
      b(paramLinearLayout);
      return;
    }
    paramLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new StructMsgItemLayout30.1(this, paramLinearLayout));
  }
  
  private void b(LinearLayout paramLinearLayout)
  {
    int m = paramLinearLayout.getChildCount();
    int i = 1;
    int k;
    for (int j = 4; i < m; j = k)
    {
      Object localObject = paramLinearLayout.getChildAt(i);
      k = j;
      if ((localObject instanceof TextView))
      {
        localObject = (TextView)localObject;
        Layout localLayout = ((TextView)localObject).getLayout();
        k = j;
        if (localLayout != null)
        {
          k = localLayout.getLineCount();
          if (j > 0)
          {
            ((TextView)localObject).setVisibility(0);
            if (j < k)
            {
              ((TextView)localObject).setMaxLines(j);
              ((TextView)localObject).requestLayout();
            }
          }
          else
          {
            ((TextView)localObject).setVisibility(8);
          }
          k = j - k;
        }
      }
      i += 1;
    }
  }
  
  protected int a(Resources paramResources, int paramInt, AbsStructMsgElement paramAbsStructMsgElement)
  {
    if (paramInt == 1) {
      paramInt = 7;
    } else {
      paramInt = 4;
    }
    return AIOUtils.b(paramInt, paramResources);
  }
  
  protected ArrayList<AbsStructMsgElement> a(ArrayList<AbsStructMsgElement> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new ArrayList();
    int n = paramArrayList.size();
    int k = 0;
    int j;
    Object localObject2;
    for (int i = 0;; i = j)
    {
      j = i;
      if (k >= n) {
        break;
      }
      localObject2 = (AbsStructMsgElement)paramArrayList.get(k);
      j = i;
      if (k == 0)
      {
        j = i;
        if ((localObject2 instanceof StructMsgItemTitle))
        {
          StructMsgItemTitle localStructMsgItemTitle = (StructMsgItemTitle)localObject2;
          int m;
          if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.hasTSum()) && (localStructMsgItemTitle.b().endsWith(HardCodeUtil.a(2131714418)))) {
            m = 1;
          } else {
            m = 0;
          }
          j = i;
          if (m != 0) {
            j = 1;
          }
        }
      }
      if ((localObject2 instanceof StructMsgItemHr)) {
        break;
      }
      if (((localObject2 instanceof StructMsgItemTitle)) || ((localObject2 instanceof StructMsgItemSummary))) {
        ((List)localObject1).add(localObject2);
      }
      k += 1;
    }
    if (j == 0)
    {
      paramArrayList = new StructMsgItemTitle(HardCodeUtil.a(2131714404));
    }
    else
    {
      paramArrayList = (StructMsgItemTitle)((List)localObject1).get(0);
      ((List)localObject1).remove(0);
    }
    paramArrayList.f("34");
    paramArrayList.g("12");
    paramArrayList.h("2");
    paramArrayList.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
    localArrayList.add(paramArrayList);
    paramArrayList = ((List)localObject1).iterator();
    while (paramArrayList.hasNext())
    {
      localObject1 = (AbsStructMsgElement)paramArrayList.next();
      if ((localObject1 instanceof AbsStructMsgTextElement))
      {
        localObject2 = (AbsStructMsgTextElement)localObject1;
        ((AbsStructMsgTextElement)localObject2).f("26");
        ((AbsStructMsgTextElement)localObject2).e("#777777");
        ((AbsStructMsgTextElement)localObject2).g("12");
        ((AbsStructMsgTextElement)localObject2).h("2");
        ((AbsStructMsgElement)localObject1).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
        localArrayList.add(localObject1);
      }
    }
    return localArrayList;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Object localObject2 = paramContext;
    Resources localResources = paramContext.getResources();
    int i = localResources.getDimensionPixelSize(2131299081);
    int j = localResources.getDimensionPixelSize(2131299082);
    int k = localResources.getDimensionPixelSize(2131299080);
    LinearLayout localLinearLayout;
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      localLinearLayout = (LinearLayout)paramView.getChildAt(0);
      localObject1 = (TextView)paramView.getChildAt(1);
    }
    else
    {
      paramView = new LinearLayout((Context)localObject2);
      paramView.setOrientation(1);
      localLinearLayout = new LinearLayout((Context)localObject2);
      localLinearLayout.setOrientation(1);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      localLinearLayout.setPadding(i, j, j, k);
      localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = a((Context)localObject2, this.jdField_a_of_type_JavaUtilArrayList);
      ((TextView)localObject1).setBackgroundResource(2130850842);
      ((TextView)localObject1).setPadding(i, 0, 0, 0);
      ((TextView)localObject1).setTextSize(1, 13.0F);
      ((TextView)localObject1).setGravity(16);
      if (Build.VERSION.SDK_INT > 22) {
        i = localResources.getColor(2131165660, paramContext.getTheme());
      } else {
        i = localResources.getColor(2131165660);
      }
      ((TextView)localObject1).setTextColor(i);
      localObject3 = new LinearLayout.LayoutParams(-1, AIOUtils.b(30.0F, localResources));
      ((LinearLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(2.0F, localResources);
      ((LinearLayout.LayoutParams)localObject3).rightMargin = AIOUtils.b(2.0F, localResources);
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      paramView.addView(localLinearLayout);
      paramView.addView((View)localObject1);
    }
    Object localObject3 = a(this.jdField_a_of_type_JavaUtilArrayList);
    Object localObject4;
    Object localObject5;
    if (localLinearLayout.getChildCount() == ((ArrayList)localObject3).size())
    {
      i = ((ArrayList)localObject3).size();
      j = 0;
      while (j < i)
      {
        localObject4 = (AbsStructMsgElement)((ArrayList)localObject3).get(j);
        ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        if ((localObject4 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject4).a(a(), this.p);
        }
        paramContext = ((AbsStructMsgElement)localObject4).a((Context)localObject2, localLinearLayout.getChildAt(j), paramBundle);
        if (paramContext == null) {
          return localLinearLayout;
        }
        AIOUtils.b(10.0F, localResources);
        localObject5 = new LinearLayout.LayoutParams(-1, -2);
        if (j > 0) {
          ((LinearLayout.LayoutParams)localObject5).topMargin = a(localResources, j, (AbsStructMsgElement)localObject4);
        }
        localObject4 = ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject4)) {
          paramContext.setId(-1);
        } else if ("summary".equals(localObject4)) {
          paramContext.setId(-1);
        }
        j += 1;
      }
    }
    localLinearLayout.removeAllViews();
    j = ((ArrayList)localObject3).size();
    i = 0;
    while (i < j)
    {
      localObject5 = (AbsStructMsgElement)((ArrayList)localObject3).get(i);
      ((AbsStructMsgElement)localObject5).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localObject5 instanceof StructMsgItemTitle)) {
        ((StructMsgItemTitle)localObject5).a(a(), this.p);
      }
      localObject2 = ((AbsStructMsgElement)localObject5).a(paramContext, null, paramBundle);
      if (localObject2 == null) {
        return localLinearLayout;
      }
      AIOUtils.b(10.0F, localResources);
      localObject4 = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        ((LinearLayout.LayoutParams)localObject4).topMargin = a(localResources, i, (AbsStructMsgElement)localObject5);
      }
      localObject5 = ((AbsStructMsgElement)localObject5).jdField_a_of_type_JavaLangString;
      if ("title".equals(localObject5)) {
        ((View)localObject2).setId(-1);
      } else if ("summary".equals(localObject5)) {
        ((View)localObject2).setId(-1);
      }
      localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      i += 1;
    }
    a(localLinearLayout);
    i = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramContext = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(i - 1);
    if ((paramContext instanceof AbsStructMsgTextElement)) {
      ((TextView)localObject1).setText(((AbsStructMsgTextElement)paramContext).ai);
    }
    return paramView;
  }
  
  public String b()
  {
    return "Layout30";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout30
 * JD-Core Version:    0.7.0.1
 */