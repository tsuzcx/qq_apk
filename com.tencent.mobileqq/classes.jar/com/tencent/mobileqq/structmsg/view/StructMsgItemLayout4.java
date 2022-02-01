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
  private final int az = 16;
  
  private LinearLayout.LayoutParams a(Resources paramResources, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 50;
    } else {
      i = 58;
    }
    float f = i;
    return new LinearLayout.LayoutParams(AIOUtils.b(f, paramResources), AIOUtils.b(f, paramResources));
  }
  
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    a(paramContext);
    d(paramContext);
    int k = localResources.getDimensionPixelSize(2131299802);
    int m = localResources.getDimensionPixelSize(2131299803);
    int i;
    if (a(1)) {
      i = AIOUtils.b(15.0F, localResources);
    } else {
      i = AIOUtils.b(6.0F, localResources);
    }
    int j;
    if (a(2)) {
      j = AIOUtils.b(15.0F, localResources);
    } else {
      j = AIOUtils.b(6.0F, localResources);
    }
    paramContext.setPadding(k, i, m, j);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setOrientation(0);
    return paramContext;
  }
  
  private void f()
  {
    if (this.ax.size() > 2) {
      return;
    }
    int i = 0;
    int j = -1;
    int k = -1;
    AbsStructMsgElement localAbsStructMsgElement;
    while (i < this.ax.size())
    {
      localAbsStructMsgElement = (AbsStructMsgElement)this.ax.get(i);
      int m;
      if ("title".equals(localAbsStructMsgElement.b))
      {
        m = i;
      }
      else
      {
        m = j;
        if ("picture".equals(localAbsStructMsgElement.b))
        {
          k = i;
          m = j;
        }
      }
      i += 1;
      j = m;
    }
    if ((j >= 0) && (k >= 0) && (j < k))
    {
      localAbsStructMsgElement = (AbsStructMsgElement)this.ax.get(j);
      this.ax.set(j, this.ax.get(k));
      this.ax.set(k, localAbsStructMsgElement);
    }
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("NAIOSub", false);
    int i;
    if (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject1;
    Object localObject3;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramView;
      if (localLinearLayout.getChildCount() == this.ax.size())
      {
        if (i != 0) {
          f();
        }
        localObject2 = this.ax.iterator();
        i = 0;
        for (;;)
        {
          localObject1 = localLinearLayout;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (AbsStructMsgElement)((Iterator)localObject2).next();
          ((AbsStructMsgElement)localObject1).ar = this.ar;
          localObject3 = ((AbsStructMsgElement)localObject1).b;
          if (("title".equals(localObject3)) || ("picture".equals(localObject3)) || ("video".equals(localObject3)))
          {
            ((AbsStructMsgElement)localObject1).a(paramContext, localLinearLayout.getChildAt(i), paramBundle);
            if ((localObject1 instanceof StructMsgItemTitle))
            {
              localObject3 = (StructMsgItemTitle)localObject1;
              ((StructMsgItemTitle)localObject3).a(d(), this.av);
              if ((((StructMsgItemTitle)localObject3).k() == null) || (((StructMsgItemTitle)localObject3).k().equals(""))) {}
            }
          }
          try
          {
            j = Integer.parseInt(((StructMsgItemTitle)localObject1).k()) / 2;
          }
          catch (Exception localException1)
          {
            int j;
            label237:
            int k;
            break label237;
          }
          j = 16;
          localObject1 = (TextView)paramView.findViewById(2131448814);
          if (localObject1 != null) {
            ((TextView)localObject1).setTextSize(2, j);
          }
          i += 1;
        }
      }
    }
    Object localObject2 = paramContext.getResources();
    LinearLayout localLinearLayout = a(paramContext);
    if (i != 0)
    {
      j = localLinearLayout.getPaddingTop();
      k = localLinearLayout.getPaddingBottom();
      localLinearLayout.setPadding(((Resources)localObject2).getDimensionPixelSize(2131296673), j, ((Resources)localObject2).getDimensionPixelOffset(2131296674), k);
      f();
    }
    paramView = this.ax.iterator();
    for (;;)
    {
      localObject1 = localLinearLayout;
      if (!paramView.hasNext()) {
        break;
      }
      localObject3 = (AbsStructMsgElement)paramView.next();
      ((AbsStructMsgElement)localObject3).ar = this.ar;
      localObject1 = ((AbsStructMsgElement)localObject3).b;
      if ("title".equals(localObject1))
      {
        localObject1 = ((AbsStructMsgElement)localObject3).a(paramContext, null, paramBundle);
        if ((localObject1 instanceof TextView))
        {
          localObject4 = (TextView)localObject1;
          if (!TextUtils.isEmpty(((TextView)localObject4).getText())) {
            localLinearLayout.setContentDescription(((TextView)localObject4).getText());
          }
        }
        if ((localObject3 instanceof StructMsgItemTitle))
        {
          localObject4 = (StructMsgItemTitle)localObject3;
          ((StructMsgItemTitle)localObject4).a(d(), this.av);
          if ((((StructMsgItemTitle)localObject4).k() == null) || (((StructMsgItemTitle)localObject4).k().equals(""))) {}
        }
      }
      try
      {
        j = Integer.parseInt(((StructMsgItemTitle)localObject3).k()) / 2;
      }
      catch (Exception localException2)
      {
        label505:
        break label505;
      }
      j = 0;
      localObject3 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject3).gravity = 16;
      ((LinearLayout.LayoutParams)localObject3).weight = 1.0F;
      if (localLinearLayout.getChildCount() == 0)
      {
        ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
        ((LinearLayout.LayoutParams)localObject3).rightMargin = AIOUtils.b(15.0F, (Resources)localObject2);
      }
      else
      {
        ((LinearLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(15.0F, (Resources)localObject2);
        ((LinearLayout.LayoutParams)localObject3).rightMargin = 0;
        if (i != 0)
        {
          ((LinearLayout.LayoutParams)localObject3).leftMargin = AIOUtils.b(10.0F, (Resources)localObject2);
          localObject4 = (TextView)localObject1;
          ((TextView)localObject4).setLineSpacing(AIOUtils.b(2.5F, (Resources)localObject2), 1.0F);
          ((TextView)localObject4).setMaxLines(2);
        }
      }
      Object localObject4 = (TextView)((View)localObject1).findViewById(2131448814);
      if (localObject4 != null)
      {
        ((TextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
        if (j != 0) {
          ((TextView)localObject4).setTextSize(2, j);
        } else {
          ((TextView)localObject4).setTextSize(2, 16.0F);
        }
      }
      localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
      if ((!"picture".equals(localObject1)) && (!"video".equals(localObject1)))
      {
        if ("hr".equals(localObject1))
        {
          localObject1 = ((AbsStructMsgElement)localObject3).a(paramContext, null, paramBundle);
          localObject3 = new LinearLayout.LayoutParams(-1, 1);
          if (this.ax.size() == 1) {
            localLinearLayout.setPadding(localLinearLayout.getPaddingLeft(), 0, localLinearLayout.getPaddingRight(), 0);
          }
          localLinearLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
        }
      }
      else {
        localLinearLayout.addView(((AbsStructMsgElement)localObject3).a(paramContext, null, paramBundle), a((Resources)localObject2, bool));
      }
    }
    return localObject1;
  }
  
  protected int c()
  {
    return 4;
  }
  
  public String e()
  {
    return "Layout4";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout4
 * JD-Core Version:    0.7.0.1
 */