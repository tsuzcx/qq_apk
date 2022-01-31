package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout4
  extends AbsStructMsgItem
{
  private final int i = 16;
  
  private LinearLayout.LayoutParams a(Resources paramResources, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int j = 50;; j = 58) {
      return new LinearLayout.LayoutParams(AIOUtils.a(j, paramResources), AIOUtils.a(j, paramResources));
    }
  }
  
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    a(paramContext);
    d(paramContext);
    int m = localResources.getDimensionPixelSize(2131558648);
    int n = localResources.getDimensionPixelSize(2131558649);
    int j;
    if (a(1))
    {
      j = AIOUtils.a(15.0F, localResources);
      if (!a(2)) {
        break label121;
      }
    }
    label121:
    for (int k = AIOUtils.a(15.0F, localResources);; k = AIOUtils.a(6.0F, localResources))
    {
      paramContext.setPadding(m, j, n, k);
      paramContext.setLayoutParams(localLayoutParams);
      paramContext.setOrientation(0);
      return paramContext;
      j = AIOUtils.a(6.0F, localResources);
      break;
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 2) {}
    int m;
    int k;
    do
    {
      return;
      m = -1;
      k = -1;
      int j = 0;
      if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        localAbsStructMsgElement = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        int n;
        if ("title".equals(localAbsStructMsgElement.jdField_a_of_type_JavaLangString)) {
          n = j;
        }
        for (;;)
        {
          j += 1;
          k = n;
          break;
          n = k;
          if ("picture".equals(localAbsStructMsgElement.jdField_a_of_type_JavaLangString))
          {
            m = j;
            n = k;
          }
        }
      }
    } while ((k < 0) || (m < 0) || (k >= m));
    AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)this.jdField_a_of_type_JavaUtilArrayList.get(k);
    this.jdField_a_of_type_JavaUtilArrayList.set(k, this.jdField_a_of_type_JavaUtilArrayList.get(m));
    this.jdField_a_of_type_JavaUtilArrayList.set(m, localAbsStructMsgElement);
  }
  
  protected int b()
  {
    return 4;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("NAIOSub", false);
    int k;
    Object localObject2;
    Object localObject3;
    label79:
    Object localObject1;
    Object localObject4;
    if (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA)
    {
      k = 1;
      if ((paramView == null) || (!(paramView instanceof LinearLayout)) || (((LinearLayout)paramView).getChildCount() != this.jdField_a_of_type_JavaUtilArrayList.size())) {
        break label281;
      }
      localObject2 = (LinearLayout)paramView;
      if (k != 0) {
        a();
      }
      localObject3 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      k = 0;
      localObject1 = localObject2;
      if (!((Iterator)localObject3).hasNext()) {
        break label800;
      }
      localObject1 = (AbsStructMsgElement)((Iterator)localObject3).next();
      ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      localObject4 = ((AbsStructMsgElement)localObject1).jdField_a_of_type_JavaLangString;
      if (("title".equals(localObject4)) || ("picture".equals(localObject4)) || ("video".equals(localObject4)))
      {
        ((AbsStructMsgElement)localObject1).a(paramContext, ((LinearLayout)localObject2).getChildAt(k), paramBundle);
        if ((localObject1 instanceof StructMsgItemTitle))
        {
          ((StructMsgItemTitle)localObject1).a(a(), this.f);
          if ((((StructMsgItemTitle)localObject1).c() == null) || (((StructMsgItemTitle)localObject1).c().equals(""))) {
            break label809;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        j = Integer.parseInt(((StructMsgItemTitle)localObject1).c()) / 2;
        localObject1 = (TextView)paramView.findViewById(2131361926);
        if (localObject1 != null) {
          ((TextView)localObject1).setTextSize(2, j);
        }
        k += 1;
        break label79;
        k = 0;
      }
      catch (Exception localException1)
      {
        j = 16;
        continue;
      }
      label281:
      paramView = paramContext.getResources();
      LinearLayout localLinearLayout = a(paramContext);
      if (k != 0)
      {
        j = localLinearLayout.getPaddingTop();
        int m = localLinearLayout.getPaddingBottom();
        localLinearLayout.setPadding(paramView.getDimensionPixelSize(2131558683), j, paramView.getDimensionPixelOffset(2131558684), m);
        a();
      }
      localObject2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject4 = (AbsStructMsgElement)((Iterator)localObject2).next();
        ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangRefWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
        localObject3 = ((AbsStructMsgElement)localObject4).jdField_a_of_type_JavaLangString;
        if ("title".equals(localObject3))
        {
          localObject3 = ((AbsStructMsgElement)localObject4).a(paramContext, null, paramBundle);
          if (((localObject3 instanceof TextView)) && (!TextUtils.isEmpty(((TextView)localObject3).getText()))) {
            localLinearLayout.setContentDescription(((TextView)localObject3).getText());
          }
          if (!(localObject4 instanceof StructMsgItemTitle)) {
            break label803;
          }
          ((StructMsgItemTitle)localObject4).a(a(), this.f);
          if ((((StructMsgItemTitle)localObject4).c() == null) || (((StructMsgItemTitle)localObject4).c().equals(""))) {
            break label803;
          }
        }
      }
      for (;;)
      {
        try
        {
          j = Integer.parseInt(((StructMsgItemTitle)localObject4).c()) / 2;
          localObject4 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject4).gravity = 16;
          ((LinearLayout.LayoutParams)localObject4).weight = 1.0F;
          if (localLinearLayout.getChildCount() == 0)
          {
            ((LinearLayout.LayoutParams)localObject4).leftMargin = 0;
            ((LinearLayout.LayoutParams)localObject4).rightMargin = AIOUtils.a(15.0F, paramView);
            localTextView = (TextView)((View)localObject3).findViewById(2131361926);
            if (localTextView != null)
            {
              localTextView.setEllipsize(TextUtils.TruncateAt.END);
              if (j == 0) {
                continue;
              }
              localTextView.setTextSize(2, j);
            }
            localLinearLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
          }
        }
        catch (Exception localException2)
        {
          TextView localTextView;
          j = 0;
          continue;
          localException2.leftMargin = AIOUtils.a(15.0F, paramView);
          localException2.rightMargin = 0;
          if (k == 0) {
            continue;
          }
          localException2.leftMargin = AIOUtils.a(10.0F, paramView);
          ((TextView)localObject3).setLineSpacing(AIOUtils.a(2.5F, paramView), 1.0F);
          ((TextView)localObject3).setMaxLines(2);
          continue;
          localTextView.setTextSize(2, 16.0F);
          continue;
        }
        if (("picture".equals(localObject3)) || ("video".equals(localObject3)))
        {
          localLinearLayout.addView(localException2.a(paramContext, null, paramBundle), a(paramView, bool));
          break;
        }
        if (!"hr".equals(localObject3)) {
          break;
        }
        localObject3 = localException2.a(paramContext, null, paramBundle);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
        if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1) {
          localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), 0, localLinearLayout.getPaddingRight(), 0);
        }
        localLinearLayout.addView((View)localObject3, localLayoutParams);
        break;
        label800:
        return localLinearLayout;
        label803:
        j = 0;
      }
      label809:
      int j = 16;
    }
  }
  
  public String b()
  {
    return "Layout4";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout4
 * JD-Core Version:    0.7.0.1
 */