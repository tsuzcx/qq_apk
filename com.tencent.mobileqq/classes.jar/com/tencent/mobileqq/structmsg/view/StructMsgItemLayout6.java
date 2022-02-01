package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement.RichText;
import com.tencent.mobileqq.structmsg.StructMsgGroupElement;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.FixRatioPAHighLightImageView;
import com.tencent.mobileqq.widget.PAImageView;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout6
  extends AbsStructMsgItem
{
  public static int s = 100;
  public static int t = 200;
  public static int u = 300;
  public static int v = 400;
  private boolean a;
  
  public StructMsgItemLayout6()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setPadding(localResources.getDimensionPixelSize(2131299074), 0, localResources.getDimensionPixelSize(2131299075), 0);
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  private void a(Context paramContext, Resources paramResources, LinearLayout paramLinearLayout, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    int i = paramResources.getDimensionPixelSize(2131296441);
    int m = paramResources.getDimensionPixelSize(2131296442);
    Object localObject1 = paramBundle.getString("sType");
    if (localObject1 != null) {
      ((String)localObject1).equals("1");
    }
    Object localObject3;
    Object localObject4;
    int k;
    if (paramLinearLayout.getChildCount() == this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramInt = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
        ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        boolean bool = localObject2 instanceof StructMsgItemTitle;
        if (bool)
        {
          localObject3 = (StructMsgItemTitle)localObject2;
          ((StructMsgItemTitle)localObject3).a(a(), this.p);
          ((StructMsgItemTitle)localObject3).a(false);
          if (TextUtils.isEmpty(((StructMsgItemTitle)localObject3).c())) {
            ((StructMsgItemTitle)localObject3).c(String.valueOf(36));
          }
        }
        else if ((localObject2 instanceof StructMsgItemSummary))
        {
          localObject3 = (StructMsgItemSummary)localObject2;
          ((StructMsgItemSummary)localObject3).a();
          if ((localObject3 != null) && ((((StructMsgItemSummary)localObject3).c() == null) || (((StructMsgItemSummary)localObject3).c().equals("")))) {
            ((StructMsgItemSummary)localObject3).c(String.valueOf(28));
          }
          localObject4 = ((StructMsgItemSummary)localObject3).f();
          if ((localObject4 != null) && (((String)localObject4).equals("1")))
          {
            ((StructMsgItemSummary)localObject3).c(String.valueOf(24));
            if ((paramBoolean) && (TextUtils.isEmpty(((StructMsgItemSummary)localObject3).d()))) {
              ((StructMsgItemSummary)localObject3).b("#8e8e8e");
            }
          }
          else if (paramBoolean)
          {
            if (TextUtils.isEmpty(((StructMsgItemSummary)localObject3).c())) {
              ((StructMsgItemSummary)localObject3).c(String.valueOf(32));
            }
            if (TextUtils.isEmpty(((StructMsgItemSummary)localObject3).d())) {
              ((StructMsgItemSummary)localObject3).b("#000000");
            }
          }
        }
        localObject3 = paramLinearLayout.getChildAt(paramInt);
        ((AbsStructMsgElement)localObject2).a(paramContext, (View)localObject3, paramBundle);
        j = ((View)localObject3).getPaddingTop();
        k = ((View)localObject3).getPaddingBottom();
        if (paramBoolean) {
          if ((!(localObject2 instanceof StructMsgItemCover)) && (!(localObject2 instanceof StructMsgItemHr)))
          {
            if ((localObject2 instanceof StructMsgGroupElement)) {
              ((View)localObject3).setPadding(0, 0, 0, 0);
            } else {
              ((View)localObject3).setPadding(i, j, m, k);
            }
          }
          else {
            ((View)localObject3).setPadding(0, j, 0, k);
          }
        }
        if (bool)
        {
          if ((paramBoolean) && (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).e()))) {
            ((TextView)localObject3).setTypeface(Typeface.DEFAULT, 1);
          }
        }
        else if (((localObject2 instanceof StructMsgItemSummary)) && (paramBoolean)) {
          ((TextView)localObject3).setLineSpacing(AIOUtils.b(2.0F, paramResources), 1.0F);
        }
        paramInt += 1;
      }
    }
    paramLinearLayout.removeAllViews();
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int j = 0;
    for (;;)
    {
      localObject1 = paramContext;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      localObject4 = (AbsStructMsgElement)((Iterator)localObject2).next();
      ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      localObject3 = ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangString;
      if ("title".equals(localObject3))
      {
        if ((localObject4 instanceof StructMsgItemTitle))
        {
          localObject3 = (StructMsgItemTitle)localObject4;
          ((StructMsgItemTitle)localObject3).a(a(), this.p);
          ((StructMsgItemTitle)localObject3).a(false);
          if (TextUtils.isEmpty(((StructMsgItemTitle)localObject3).c())) {
            ((StructMsgItemTitle)localObject3).c(String.valueOf(36));
          }
        }
        localObject1 = ((AbsStructMsgElement)localObject4).a((Context)localObject1, null, paramBundle);
        localObject3 = new LinearLayout.LayoutParams(-2, -2);
        ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(2.5F, paramResources);
        ((LinearLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.b(1.5F, paramResources);
        if ((a(1)) && (j == 0)) {
          ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(20.0F, paramResources);
        }
        if (paramBoolean)
        {
          ((View)localObject1).setPadding(i, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
          if (TextUtils.isEmpty(((StructMsgItemTitle)localObject4).e())) {
            ((TextView)localObject1).setTypeface(Typeface.DEFAULT, 1);
          }
        }
        paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      }
      for (;;)
      {
        break;
        if ("hr".equals(localObject3))
        {
          localObject1 = ((AbsStructMsgElement)localObject4).a((Context)localObject1, null, paramBundle);
          localObject3 = new LinearLayout.LayoutParams(-1, 1);
          if (j > 0) {
            ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(7.5F, paramResources);
          }
          if (paramBoolean)
          {
            ((LinearLayout.LayoutParams)localObject3).leftMargin = i;
            ((LinearLayout.LayoutParams)localObject3).rightMargin = m;
          }
          if (localObject1 != null) {
            paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          }
        }
        else
        {
          Object localObject5;
          if ("summary".equals(localObject3))
          {
            if ((localObject4 instanceof AbsStructMsgTextElement))
            {
              localObject3 = (StructMsgItemSummary)localObject4;
              ((StructMsgItemSummary)localObject3).a();
              if ((localObject3 != null) && ((((StructMsgItemSummary)localObject3).c() == null) || (((StructMsgItemSummary)localObject3).c().equals("")))) {
                ((StructMsgItemSummary)localObject3).c(String.valueOf(28));
              }
              localObject5 = ((StructMsgItemSummary)localObject3).f();
              if ((localObject5 != null) && (((String)localObject5).equals("1")))
              {
                ((StructMsgItemSummary)localObject3).c(String.valueOf(24));
                if ((paramBoolean) && (TextUtils.isEmpty(((StructMsgItemSummary)localObject3).d()))) {
                  ((StructMsgItemSummary)localObject3).b("#8e8e8e");
                }
              }
              else if (paramBoolean)
              {
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject3).c())) {
                  ((StructMsgItemSummary)localObject3).c(String.valueOf(32));
                }
                if (TextUtils.isEmpty(((StructMsgItemSummary)localObject3).d())) {
                  ((StructMsgItemSummary)localObject3).b("#000000");
                }
              }
              else {}
            }
            localObject1 = ((AbsStructMsgElement)localObject4).a((Context)localObject1, null, paramBundle);
            if (paramBoolean) {
              ((TextView)localObject1).setLineSpacing(AIOUtils.b(2.0F, paramResources), 1.0F);
            }
            localObject3 = new LinearLayout.LayoutParams(-2, -2);
            ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(4.5F, paramResources);
            ((LinearLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.b(5.5F, paramResources);
            if ((a(2)) && (j == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
              ((LinearLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.b(13.0F, paramResources);
            }
            if (paramBoolean) {
              ((View)localObject1).setPadding(i, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
            }
            paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          }
          else
          {
            if ("timer".equals(localObject3))
            {
              localObject1 = ((AbsStructMsgElement)localObject4).a((Context)localObject1, null, paramBundle);
              localObject3 = new LinearLayout.LayoutParams(-2, -2);
              if (j > 0) {
                ((LinearLayout.LayoutParams)localObject3).topMargin = paramInt;
              }
              if (paramBoolean) {
                ((View)localObject1).setPadding(i, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
              }
              paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            }
            for (;;)
            {
              break;
              double d;
              if ((!"picture".equals(localObject3)) && (!"video".equals(localObject3)))
              {
                if ("more".equals(localObject3))
                {
                  localObject1 = ((AbsStructMsgElement)localObject4).a((Context)localObject1, null, paramBundle);
                  localObject3 = new LinearLayout.LayoutParams(-1, AIOUtils.b(36.0F, paramResources));
                  if (paramBoolean) {
                    ((View)localObject1).setPadding(i, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                  }
                  paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
                }
                else if ("item".equals(localObject3))
                {
                  localObject1 = ((AbsStructMsgElement)localObject4).a((Context)localObject1, null, paramBundle);
                  if (paramBoolean) {
                    ((View)localObject1).setPadding(i, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                  }
                  paramLinearLayout.addView((View)localObject1);
                }
                else if ("price".equals(localObject3))
                {
                  localObject1 = ((AbsStructMsgElement)localObject4).a((Context)localObject1, null, paramBundle);
                  if (paramBoolean) {
                    ((View)localObject1).setPadding(i, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                  }
                  paramLinearLayout.addView((View)localObject1);
                }
                else if ("pavideo".equals(localObject3))
                {
                  localObject1 = ((AbsStructMsgElement)localObject4).a((Context)localObject1, null, paramBundle);
                  ((AnyScaleTypeImageView)localObject1).setImageResource(2130841754);
                  d = BaseChatItemLayout.b;
                  Double.isNaN(d);
                  localObject3 = new LinearLayout.LayoutParams(-1, (int)(d / 1.8D));
                  if (paramBoolean)
                  {
                    ((View)localObject1).setPadding(i, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                    ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.b(7.5F, paramResources);
                    ((LinearLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.b(7.5F, paramResources);
                  }
                  paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
                }
                else if ("asyncmsg".equals(localObject3))
                {
                  localObject1 = ((AbsStructMsgElement)localObject4).a((Context)localObject1, null, paramBundle);
                  if (paramBoolean) {
                    ((View)localObject1).setPadding(i, ((View)localObject1).getPaddingTop(), m, ((View)localObject1).getPaddingBottom());
                  }
                  paramLinearLayout.addView((View)localObject1);
                }
                else if ("group".equals(localObject3))
                {
                  localObject1 = ((AbsStructMsgElement)localObject4).a((Context)localObject1, null, paramBundle);
                  ((View)localObject1).setPadding(0, 0, 0, 0);
                  localObject3 = new LinearLayout.LayoutParams(-1, -2);
                  ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
                  ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
                  ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
                  paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
                  this.jdField_a_of_type_Boolean = true;
                }
              }
              else
              {
                localObject4 = ((AbsStructMsgElement)localObject4).a((Context)localObject1, null, paramBundle);
                localObject1 = ((View)localObject4).findViewById(2131368633);
                if (("picture".equals(localObject3)) && (paramBoolean) && (a(1)) && (j == 0) && (paramBundle != null)) {
                  paramBundle.putBoolean("pa_should_change", true);
                }
                if ((localObject1 != null) && ((localObject1 instanceof AnyScaleTypeImageView)) && ("picture".equals(localObject3))) {
                  localObject5 = (AnyScaleTypeImageView)localObject1;
                }
                if (paramBoolean)
                {
                  ((View)localObject4).setPadding(0, ((View)localObject4).getPaddingTop(), 0, ((View)localObject4).getPaddingBottom());
                  if ((localObject1 instanceof FixRatioPAHighLightImageView))
                  {
                    ((FixRatioPAHighLightImageView)localObject1).setRatio(1.8F);
                    localObject1 = new LinearLayout.LayoutParams(-1, -2);
                  }
                  else
                  {
                    k = BaseChatItemLayout.A;
                    if (!paramBundle.getBoolean("hasHeadIcon", true)) {
                      k = BaseChatItemLayout.B;
                    }
                    d = k;
                    Double.isNaN(d);
                    localObject1 = new LinearLayout.LayoutParams(-1, (int)(d / 1.8D));
                  }
                }
                else if ((!paramBundle.getBoolean("hasHeadIcon", true)) && (paramBundle.getInt("serviceID", 0) == 21))
                {
                  localObject1 = new LinearLayout.LayoutParams(-1, AIOUtils.b(105.0F, paramResources));
                }
                else
                {
                  localObject1 = new LinearLayout.LayoutParams(-1, AIOUtils.b(175.0F, paramResources));
                }
                if (j > 0) {
                  ((LinearLayout.LayoutParams)localObject1).topMargin = paramInt;
                }
                if (("picture".equals(localObject3)) && (paramBoolean) && (a(1)) && (j == 0))
                {
                  ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
                  if ((localObject4 != null) && ((localObject4 instanceof PAImageView))) {
                    ((PAImageView)localObject4).setUseRadiusRound(true, paramResources.getDimensionPixelSize(2131296443));
                  }
                }
                else
                {
                  ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(7.5F, paramResources);
                }
                ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.b(7.5F, paramResources);
                paramLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject1);
              }
            }
          }
        }
      }
      j += 1;
    }
    if (this.jdField_a_of_type_Boolean) {
      paramLinearLayout.setPadding(0, 0, 0, 0);
    }
  }
  
  private void a(Context paramContext, Resources paramResources, LinearLayout paramLinearLayout, int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject1 = new StringBuffer();
    Object localObject2 = new ArrayList();
    Object localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = -1;
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
      ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      if ((localObject4 instanceof AbsStructMsgTextElement))
      {
        localObject4 = (AbsStructMsgTextElement)localObject4;
        if (paramBoolean) {
          if ((localObject4 instanceof StructMsgItemSummary))
          {
            if (TextUtils.isEmpty(((AbsStructMsgTextElement)localObject4).c())) {
              ((AbsStructMsgTextElement)localObject4).c(String.valueOf(32));
            }
            if (TextUtils.isEmpty(((AbsStructMsgTextElement)localObject4).d())) {
              ((AbsStructMsgTextElement)localObject4).b("#000000");
            }
          }
          else if (((localObject4 instanceof StructMsgItemTitle)) && (TextUtils.isEmpty(((AbsStructMsgTextElement)localObject4).c())))
          {
            ((AbsStructMsgTextElement)localObject4).c(String.valueOf(36));
          }
        }
        localObject4 = ((AbsStructMsgTextElement)localObject4).a(paramResources);
        if (localObject4 != null)
        {
          ((AbsStructMsgTextElement.RichText)localObject4).e = (i + 1);
          ((AbsStructMsgTextElement.RichText)localObject4).f = (((AbsStructMsgTextElement.RichText)localObject4).e + ((AbsStructMsgTextElement.RichText)localObject4).jdField_a_of_type_JavaLangString.length());
          i += ((AbsStructMsgTextElement.RichText)localObject4).jdField_a_of_type_JavaLangString.length();
          ((StringBuffer)localObject1).append(((AbsStructMsgTextElement.RichText)localObject4).jdField_a_of_type_JavaLangString);
          ((ArrayList)localObject2).add(localObject4);
        }
      }
    }
    localObject1 = new SpannableStringBuilder(((StringBuffer)localObject1).toString());
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (AbsStructMsgTextElement.RichText)((Iterator)localObject2).next();
      ((SpannableStringBuilder)localObject1).setSpan(new TextAppearanceSpan(null, ((AbsStructMsgTextElement.RichText)localObject3).b, (int)TypedValue.applyDimension(2, ((AbsStructMsgTextElement.RichText)localObject3).c, paramResources.getDisplayMetrics()), ColorStateList.valueOf(((AbsStructMsgTextElement.RichText)localObject3).jdField_a_of_type_Int), null), ((AbsStructMsgTextElement.RichText)localObject3).e, ((AbsStructMsgTextElement.RichText)localObject3).f, 33);
    }
    if ((paramView != null) && ((paramView instanceof TextView)))
    {
      paramContext = (TextView)paramView;
    }
    else
    {
      paramView = new LinearLayout.LayoutParams(-2, -2);
      paramContext = new TextView(paramContext);
      if (paramBoolean)
      {
        paramContext.setLineSpacing(AIOUtils.b(2.0F, paramResources), 1.0F);
        paramView.topMargin = AIOUtils.b(4.5F, paramResources);
        paramView.bottomMargin = AIOUtils.b(5.5F, paramResources);
      }
      for (;;)
      {
        break;
        paramContext.setLineSpacing(paramInt, 1.0F);
        if (a(2)) {
          paramView.bottomMargin = AIOUtils.b(10.0F, paramResources);
        }
        if (a(1)) {
          paramView.topMargin = AIOUtils.b(10.0F, paramResources);
        }
      }
      paramLinearLayout.addView(paramContext, paramView);
    }
    paramContext.setText((CharSequence)localObject1);
    paramContext.requestLayout();
  }
  
  private void a(LinearLayout paramLinearLayout)
  {
    if (((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).isReportForClick(this.Y)) {
      paramLinearLayout.setOnClickListener(new StructMsgItemLayout6.1(this));
    }
  }
  
  protected int b()
  {
    return 6;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool;
    if (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
      bool = true;
    } else {
      bool = false;
    }
    Resources localResources = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout))) {
      paramView = (LinearLayout)paramView;
    } else {
      paramView = a(paramContext);
    }
    int k = paramView.getPaddingTop();
    int m = paramView.getPaddingBottom();
    int i = localResources.getDimensionPixelSize(2131299074);
    int j = localResources.getDimensionPixelSize(2131299075);
    a(paramView);
    d(paramView);
    if (bool) {
      if (this.o == 1)
      {
        i = localResources.getDimensionPixelSize(2131296441);
        j = i;
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
    paramView.setPadding(i, k, j, m);
    i = AIOUtils.b(8.0F, localResources);
    if (this.o == 1) {
      a(paramContext, localResources, paramView, i, paramView.getChildAt(0), bool);
    } else {
      a(paramContext, localResources, paramView, i, paramBundle, bool);
    }
    a(paramView);
    return paramView;
  }
  
  public String b()
  {
    return "Layout6";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6
 * JD-Core Version:    0.7.0.1
 */