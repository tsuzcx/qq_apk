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
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgTextElement.RichText;
import com.tencent.mobileqq.structmsg.StructMsgGroupElement;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.PAImageView;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout6
  extends AbsStructMsgItem
{
  public static int i = 100;
  public static int j = 200;
  public static int k = 300;
  public static int l = 400;
  
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    paramContext.setPadding(localResources.getDimensionPixelSize(2131558648), 0, localResources.getDimensionPixelSize(2131558649), 0);
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  private void a(Context paramContext, Resources paramResources, LinearLayout paramLinearLayout, int paramInt, Bundle paramBundle, boolean paramBoolean)
  {
    int i1 = paramResources.getDimensionPixelSize(2131558683);
    int i2 = paramResources.getDimensionPixelSize(2131558684);
    Object localObject1 = paramBundle.getString("sType");
    Object localObject2;
    label157:
    Object localObject3;
    int m;
    int n;
    label222:
    Object localObject4;
    if (((localObject1 == null) || (!((String)localObject1).equals("1"))) || (paramLinearLayout.getChildCount() == this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramInt = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AbsStructMsgElement)((Iterator)localObject1).next();
        ((AbsStructMsgElement)localObject2).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        if ((localObject2 instanceof StructMsgItemTitle))
        {
          ((StructMsgItemTitle)localObject2).a(a(), this.f);
          ((StructMsgItemTitle)localObject2).a(false);
          if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).c())) {
            ((StructMsgItemTitle)localObject2).c(String.valueOf(36));
          }
          localObject3 = paramLinearLayout.getChildAt(paramInt);
          ((AbsStructMsgElement)localObject2).a(paramContext, (View)localObject3, paramBundle);
          m = ((View)localObject3).getPaddingTop();
          n = ((View)localObject3).getPaddingBottom();
          if (paramBoolean)
          {
            if ((!(localObject2 instanceof StructMsgItemCover)) && (!(localObject2 instanceof StructMsgItemHr))) {
              break label431;
            }
            ((View)localObject3).setPadding(0, m, 0, n);
          }
          if (!(localObject2 instanceof StructMsgItemTitle)) {
            break label467;
          }
          if ((paramBoolean) && (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).e()))) {
            ((TextView)localObject3).setTypeface(Typeface.DEFAULT, 1);
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          if (!(localObject2 instanceof StructMsgItemSummary)) {
            break label157;
          }
          localObject3 = (StructMsgItemSummary)localObject2;
          ((StructMsgItemSummary)localObject3).a();
          if ((localObject3 != null) && ((((StructMsgItemSummary)localObject3).c() == null) || (((StructMsgItemSummary)localObject3).c().equals("")))) {
            ((StructMsgItemSummary)localObject3).c(String.valueOf(28));
          }
          localObject4 = ((StructMsgItemSummary)localObject3).f();
          if ((localObject4 != null) && (((String)localObject4).equals("1")))
          {
            ((StructMsgItemSummary)localObject3).c(String.valueOf(24));
            if ((!paramBoolean) || (!TextUtils.isEmpty(((StructMsgItemSummary)localObject3).d()))) {
              break label157;
            }
            ((StructMsgItemSummary)localObject3).b("#8e8e8e");
            break label157;
          }
          if (!paramBoolean) {
            break label157;
          }
          if (TextUtils.isEmpty(((StructMsgItemSummary)localObject3).c())) {
            ((StructMsgItemSummary)localObject3).c(String.valueOf(32));
          }
          if (!TextUtils.isEmpty(((StructMsgItemSummary)localObject3).d())) {
            break label157;
          }
          ((StructMsgItemSummary)localObject3).b("#000000");
          break label157;
          label431:
          if ((localObject2 instanceof StructMsgGroupElement))
          {
            ((View)localObject3).setPadding(0, 0, 0, 0);
            break label222;
          }
          ((View)localObject3).setPadding(i1, m, i2, n);
          break label222;
          label467:
          if (((localObject2 instanceof StructMsgItemSummary)) && (paramBoolean)) {
            ((TextView)localObject3).setLineSpacing(AIOUtils.a(2.0F, paramResources), 1.0F);
          }
        }
      }
    }
    else
    {
      paramLinearLayout.removeAllViews();
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      m = 0;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (AbsStructMsgElement)((Iterator)localObject2).next();
        ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject3 = ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject3))
        {
          if ((localObject1 instanceof StructMsgItemTitle))
          {
            ((StructMsgItemTitle)localObject1).a(a(), this.f);
            ((StructMsgItemTitle)localObject1).a(false);
            if (TextUtils.isEmpty(((StructMsgItemTitle)localObject1).c())) {
              ((StructMsgItemTitle)localObject1).c(String.valueOf(36));
            }
          }
          localObject3 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
          localObject4 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject4).topMargin = AIOUtils.a(2.5F, paramResources);
          ((LinearLayout.LayoutParams)localObject4).bottomMargin = AIOUtils.a(1.5F, paramResources);
          if ((a(1)) && (m == 0)) {
            ((LinearLayout.LayoutParams)localObject4).topMargin = AIOUtils.a(20.0F, paramResources);
          }
          if (paramBoolean)
          {
            ((View)localObject3).setPadding(i1, ((View)localObject3).getPaddingTop(), i2, ((View)localObject3).getPaddingBottom());
            if (TextUtils.isEmpty(((StructMsgItemTitle)localObject1).e())) {
              ((TextView)localObject3).setTypeface(Typeface.DEFAULT, 1);
            }
          }
          paramLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
        }
        for (;;)
        {
          m += 1;
          break;
          if ("hr".equals(localObject3))
          {
            localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
            localObject3 = new LinearLayout.LayoutParams(-1, 1);
            if (m > 0) {
              ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(7.5F, paramResources);
            }
            if (paramBoolean)
            {
              ((LinearLayout.LayoutParams)localObject3).leftMargin = i1;
              ((LinearLayout.LayoutParams)localObject3).rightMargin = i2;
            }
            paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
          }
          else
          {
            if ("summary".equals(localObject3))
            {
              if ((localObject1 instanceof AbsStructMsgTextElement))
              {
                localObject3 = (StructMsgItemSummary)localObject1;
                ((StructMsgItemSummary)localObject3).a();
                if ((localObject3 != null) && ((((StructMsgItemSummary)localObject3).c() == null) || (((StructMsgItemSummary)localObject3).c().equals("")))) {
                  ((StructMsgItemSummary)localObject3).c(String.valueOf(28));
                }
                localObject4 = ((StructMsgItemSummary)localObject1).f();
                if ((localObject4 == null) || (!((String)localObject4).equals("1"))) {
                  break label1095;
                }
                ((StructMsgItemSummary)localObject3).c(String.valueOf(24));
                if ((paramBoolean) && (TextUtils.isEmpty(((StructMsgItemSummary)localObject3).d()))) {
                  ((StructMsgItemSummary)localObject3).b("#8e8e8e");
                }
              }
              for (;;)
              {
                localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((TextView)localObject1).setLineSpacing(AIOUtils.a(2.0F, paramResources), 1.0F);
                }
                localObject3 = new LinearLayout.LayoutParams(-2, -2);
                ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(4.5F, paramResources);
                ((LinearLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.a(5.5F, paramResources);
                if ((a(2)) && (m == this.jdField_a_of_type_JavaUtilArrayList.size() - 1)) {
                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.a(13.0F, paramResources);
                }
                if (paramBoolean) {
                  ((View)localObject1).setPadding(i1, ((View)localObject1).getPaddingTop(), i2, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
                break;
                label1095:
                if (paramBoolean)
                {
                  if (TextUtils.isEmpty(((StructMsgItemSummary)localObject3).c())) {
                    ((StructMsgItemSummary)localObject3).c(String.valueOf(32));
                  }
                  if (TextUtils.isEmpty(((StructMsgItemSummary)localObject3).d())) {
                    ((StructMsgItemSummary)localObject3).b("#000000");
                  }
                }
              }
            }
            if ("timer".equals(localObject3))
            {
              localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
              localObject3 = new LinearLayout.LayoutParams(-2, -2);
              if (m > 0) {
                ((LinearLayout.LayoutParams)localObject3).topMargin = paramInt;
              }
              if (paramBoolean) {
                ((View)localObject1).setPadding(i1, ((View)localObject1).getPaddingTop(), i2, ((View)localObject1).getPaddingBottom());
              }
              paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            }
            else
            {
              if (("picture".equals(localObject3)) || ("video".equals(localObject3)))
              {
                localObject4 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
                localObject1 = ((View)localObject4).findViewById(2131361925);
                if (("picture".equals(localObject3)) && (paramBoolean) && (a(1)) && (m == 0) && (paramBundle != null)) {
                  paramBundle.putBoolean("pa_should_change", true);
                }
                if ((localObject1 != null) && ((localObject1 instanceof AnyScaleTypeImageView)) && ("picture".equals(localObject3))) {
                  localObject1 = (AnyScaleTypeImageView)localObject1;
                }
                if (paramBoolean)
                {
                  ((View)localObject4).setPadding(0, ((View)localObject4).getPaddingTop(), 0, ((View)localObject4).getPaddingBottom());
                  n = BaseChatItemLayout.x;
                  if (!paramBundle.getBoolean("hasHeadIcon", true)) {
                    n = BaseChatItemLayout.e;
                  }
                  localObject1 = new LinearLayout.LayoutParams(-1, (int)(n / 1.8D));
                  label1397:
                  if (m > 0) {
                    ((LinearLayout.LayoutParams)localObject1).topMargin = paramInt;
                  }
                  if ((!"picture".equals(localObject3)) || (!paramBoolean) || (!a(1)) || (m != 0)) {
                    break label1561;
                  }
                  ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
                  if ((localObject4 != null) && ((localObject4 instanceof PAImageView))) {
                    ((PAImageView)localObject4).setUseRadiusRound(true, paramResources.getDimensionPixelSize(2131558689));
                  }
                }
                for (;;)
                {
                  ((LinearLayout.LayoutParams)localObject1).bottomMargin = AIOUtils.a(7.5F, paramResources);
                  paramLinearLayout.addView((View)localObject4, (ViewGroup.LayoutParams)localObject1);
                  break;
                  if ((!paramBundle.getBoolean("hasHeadIcon", true)) && (paramBundle.getInt("serviceID", 0) == 21))
                  {
                    localObject1 = new LinearLayout.LayoutParams(-1, AIOUtils.a(105.0F, paramResources));
                    break label1397;
                  }
                  localObject1 = new LinearLayout.LayoutParams(-1, AIOUtils.a(175.0F, paramResources));
                  break label1397;
                  label1561:
                  ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(7.5F, paramResources);
                }
              }
              if ("more".equals(localObject3))
              {
                localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
                localObject3 = new LinearLayout.LayoutParams(-1, AIOUtils.a(36.0F, paramResources));
                if (paramBoolean) {
                  ((View)localObject1).setPadding(i1, ((View)localObject1).getPaddingTop(), i2, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
              }
              else if ("item".equals(localObject3))
              {
                localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((View)localObject1).setPadding(i1, ((View)localObject1).getPaddingTop(), i2, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1);
              }
              else if ("price".equals(localObject3))
              {
                localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((View)localObject1).setPadding(i1, ((View)localObject1).getPaddingTop(), i2, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1);
              }
              else if ("pavideo".equals(localObject3))
              {
                localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
                ((AnyScaleTypeImageView)localObject1).setImageResource(2130839718);
                localObject3 = new LinearLayout.LayoutParams(-1, (int)(BaseChatItemLayout.jdField_a_of_type_Int / 1.8D));
                if (paramBoolean)
                {
                  ((View)localObject1).setPadding(i1, ((View)localObject1).getPaddingTop(), i2, ((View)localObject1).getPaddingBottom());
                  ((LinearLayout.LayoutParams)localObject3).topMargin = AIOUtils.a(7.5F, paramResources);
                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = AIOUtils.a(7.5F, paramResources);
                }
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
              }
              else if ("asyncmsg".equals(localObject3))
              {
                localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
                if (paramBoolean) {
                  ((View)localObject1).setPadding(i1, ((View)localObject1).getPaddingTop(), i2, ((View)localObject1).getPaddingBottom());
                }
                paramLinearLayout.addView((View)localObject1);
              }
              else if ("group".equals(localObject3))
              {
                localObject1 = ((AbsStructMsgElement)localObject1).a(paramContext, null, paramBundle);
                ((View)localObject1).setPadding(0, 0, 0, 0);
                localObject3 = new LinearLayout.LayoutParams(-1, -2);
                ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
                ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
                ((LinearLayout.LayoutParams)localObject3).topMargin = 0;
                ((LinearLayout.LayoutParams)localObject3).bottomMargin = 0;
                paramLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
              }
            }
          }
        }
      }
    }
  }
  
  private void a(Context paramContext, Resources paramResources, LinearLayout paramLinearLayout, int paramInt, View paramView, boolean paramBoolean)
  {
    Object localObject1 = new StringBuffer();
    Object localObject2 = new ArrayList();
    Object localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int m = -1;
    if (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (AbsStructMsgElement)((Iterator)localObject3).next();
      ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      int n = m;
      if ((localObject4 instanceof AbsStructMsgTextElement))
      {
        localObject4 = (AbsStructMsgTextElement)localObject4;
        if (paramBoolean)
        {
          if (!(localObject4 instanceof StructMsgItemSummary)) {
            break label216;
          }
          if (TextUtils.isEmpty(((AbsStructMsgTextElement)localObject4).c())) {
            ((AbsStructMsgTextElement)localObject4).c(String.valueOf(32));
          }
          if (TextUtils.isEmpty(((AbsStructMsgTextElement)localObject4).d())) {
            ((AbsStructMsgTextElement)localObject4).b("#000000");
          }
        }
      }
      for (;;)
      {
        localObject4 = ((AbsStructMsgTextElement)localObject4).a(paramResources);
        n = m;
        if (localObject4 != null)
        {
          ((AbsStructMsgTextElement.RichText)localObject4).e = (m + 1);
          ((AbsStructMsgTextElement.RichText)localObject4).f = (((AbsStructMsgTextElement.RichText)localObject4).e + ((AbsStructMsgTextElement.RichText)localObject4).jdField_a_of_type_JavaLangString.length());
          n = m + ((AbsStructMsgTextElement.RichText)localObject4).jdField_a_of_type_JavaLangString.length();
          ((StringBuffer)localObject1).append(((AbsStructMsgTextElement.RichText)localObject4).jdField_a_of_type_JavaLangString);
          ((ArrayList)localObject2).add(localObject4);
        }
        m = n;
        break;
        label216:
        if (((localObject4 instanceof StructMsgItemTitle)) && (TextUtils.isEmpty(((AbsStructMsgTextElement)localObject4).c()))) {
          ((AbsStructMsgTextElement)localObject4).c(String.valueOf(36));
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
      paramContext.setText((CharSequence)localObject1);
      paramContext.requestLayout();
      return;
    }
    paramView = new LinearLayout.LayoutParams(-2, -2);
    paramContext = new TextView(paramContext);
    if (paramBoolean)
    {
      paramContext.setLineSpacing(AIOUtils.a(2.0F, paramResources), 1.0F);
      paramView.topMargin = AIOUtils.a(4.5F, paramResources);
      paramView.bottomMargin = AIOUtils.a(5.5F, paramResources);
    }
    for (;;)
    {
      paramLinearLayout.addView(paramContext, paramView);
      break;
      paramContext.setLineSpacing(paramInt, 1.0F);
      if (a(2)) {
        paramView.bottomMargin = AIOUtils.a(10.0F, paramResources);
      }
      if (a(1)) {
        paramView.topMargin = AIOUtils.a(10.0F, paramResources);
      }
    }
  }
  
  protected int b()
  {
    return 6;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool;
    Resources localResources;
    label38:
    int i1;
    int i2;
    int m;
    if (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA)
    {
      bool = true;
      localResources = paramContext.getResources();
      if ((paramView == null) || (!(paramView instanceof LinearLayout))) {
        break label159;
      }
      paramView = (LinearLayout)paramView;
      i1 = paramView.getPaddingTop();
      i2 = paramView.getPaddingBottom();
      n = localResources.getDimensionPixelSize(2131558648);
      m = localResources.getDimensionPixelSize(2131558649);
      a(paramView);
      d(paramView);
      if (bool)
      {
        if (this.e != 1) {
          break label168;
        }
        m = localResources.getDimensionPixelSize(2131558683);
      }
    }
    for (int n = m;; n = 0)
    {
      paramView.setPadding(n, i1, m, i2);
      m = AIOUtils.a(8.0F, localResources);
      if (this.e != 1) {
        break label177;
      }
      a(paramContext, localResources, paramView, m, paramView.getChildAt(0), bool);
      return paramView;
      bool = false;
      break;
      label159:
      paramView = a(paramContext);
      break label38;
      label168:
      m = 0;
    }
    label177:
    a(paramContext, localResources, paramView, m, paramBundle, bool);
    return paramView;
  }
  
  public String b()
  {
    return "Layout6";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout6
 * JD-Core Version:    0.7.0.1
 */