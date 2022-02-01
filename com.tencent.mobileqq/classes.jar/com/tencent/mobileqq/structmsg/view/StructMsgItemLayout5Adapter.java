package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout5Adapter
{
  private AbsStructMsgItem a;
  private Context b;
  private int c = -1;
  private TextView d;
  private View e;
  private int f;
  
  public StructMsgItemLayout5Adapter(AbsStructMsgItem paramAbsStructMsgItem, Context paramContext, int paramInt)
  {
    this.a = paramAbsStructMsgItem;
    this.b = paramContext;
    this.c = paramInt;
    this.f = this.b.getResources().getDimensionPixelSize(2131296676);
  }
  
  private TextView a(String paramString, View paramView, boolean paramBoolean)
  {
    Resources localResources = this.b.getResources();
    TextView localTextView;
    if (paramView == null)
    {
      localTextView = new TextView(this.b);
      localTextView.setMaxLines(2);
      localTextView.setTextColor(-1);
      localTextView.setTextSize(2, 19.0F);
      localTextView.setMaxLines(2);
      localTextView.setLineSpacing(AIOUtils.b(2.5F, localResources), 1.0F);
      localTextView.setGravity(80);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      if (paramBoolean) {
        localTextView.setBackgroundResource(2130842619);
      }
      int i = AIOUtils.b(12.5F, localResources);
      int j = AIOUtils.b(12.0F, localResources);
      localTextView.setPadding(j, 0, j, i);
      localTextView.setId(2131446593);
      paramView = localTextView;
      if (!TextUtils.isEmpty(paramString))
      {
        localTextView.setText(paramString);
        return localTextView;
      }
    }
    else
    {
      localTextView = (TextView)paramView;
      if (!TextUtils.isEmpty(paramString)) {
        localTextView.setText(paramString);
      }
      paramView = localTextView;
      if (paramBoolean)
      {
        paramView = localTextView;
        if (localTextView.getBackground() == null)
        {
          localTextView.setBackgroundResource(2130842619);
          paramView = localTextView;
        }
      }
    }
    return paramView;
  }
  
  public static boolean a(AbsStructMsgItem paramAbsStructMsgItem, int paramInt)
  {
    if (paramInt != 0) {
      return false;
    }
    paramAbsStructMsgItem = paramAbsStructMsgItem.ax.iterator();
    String str;
    do
    {
      if (!paramAbsStructMsgItem.hasNext()) {
        break;
      }
      str = ((AbsStructMsgElement)paramAbsStructMsgItem.next()).b;
      if ("picture".equals(str)) {
        return true;
      }
    } while ("title".equals(str));
    return false;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (!a(this.a, this.c)) {
      return this.a.a(paramContext, paramView, paramBundle);
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout5Adapter", 2, "layout5 use new style");
    }
    Object localObject1;
    Object localObject3;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localObject1 = (LinearLayout)paramView;
      localObject2 = (FrameLayout)((LinearLayout)localObject1).findViewById(2131446569);
      if (localObject2 != null)
      {
        localObject3 = this.a.ax.iterator();
        paramView = null;
        while (((Iterator)localObject3).hasNext())
        {
          AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject3).next();
          String str = localAbsStructMsgElement.b;
          if ("title".equals(str)) {
            paramView = ((StructMsgItemTitle)localAbsStructMsgElement).e();
          } else if ("picture".equals(str)) {
            this.e = a(localAbsStructMsgElement, (View)localObject2, paramBundle);
          }
        }
        localObject2 = this.e;
        if (localObject2 != null)
        {
          paramContext = (TextView)((View)localObject2).findViewById(2131446590);
          if (!TextUtils.isEmpty(paramView))
          {
            if (paramContext != null)
            {
              a(paramView, paramContext, true);
              return localObject1;
            }
            paramContext = a(paramView, null, true);
            paramView = new ViewGroup.LayoutParams(-1, this.f);
            paramContext.setId(2131446590);
            ((ViewGroup)this.e).addView(paramContext, paramView);
            return localObject1;
          }
          if (paramContext != null) {
            ((ViewGroup)this.e).removeView(paramContext);
          }
          return localObject1;
        }
        ((LinearLayout)localObject1).removeAllViews();
      }
      else
      {
        ((LinearLayout)localObject1).removeAllViews();
        paramView = null;
      }
    }
    else
    {
      localObject1 = null;
      paramView = (View)localObject1;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new LinearLayout(paramContext);
      ((LinearLayout)localObject2).setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setId(2131446591);
    }
    paramContext = this.a.ax.iterator();
    while (paramContext.hasNext())
    {
      localObject1 = (AbsStructMsgElement)paramContext.next();
      localObject3 = ((AbsStructMsgElement)localObject1).b;
      if ("title".equals(localObject3)) {
        paramView = ((StructMsgItemTitle)localObject1).e();
      } else if ("picture".equals(localObject3)) {
        this.e = a((AbsStructMsgElement)localObject1, null, paramBundle);
      }
    }
    if (this.e != null)
    {
      if (!TextUtils.isEmpty(paramView))
      {
        paramContext = new ViewGroup.LayoutParams(-1, this.f);
        paramView = a(paramView.trim(), null, true);
        paramView.setId(2131446590);
        ((ViewGroup)this.e).addView(paramView, paramContext);
      }
      ((LinearLayout)localObject2).addView(this.e);
      return localObject2;
    }
    if ((!TextUtils.isEmpty(paramView)) && (paramView.trim().length() > 0))
    {
      this.d = a(paramView.trim(), null, false);
      paramContext = new ViewGroup.LayoutParams(-2, -2);
      this.d.setLayoutParams(paramContext);
      int i = AIOUtils.b(12.0F, this.b.getResources());
      this.d.setPadding(i, i, i, i);
      this.d.setId(2131446593);
      this.d.setGravity(16);
      ((LinearLayout)localObject2).addView(this.d);
    }
    return localObject2;
  }
  
  public View a(AbsStructMsgElement paramAbsStructMsgElement, View paramView, Bundle paramBundle)
  {
    Resources localResources = this.b.getResources();
    if ((paramView != null) && ((paramView instanceof FrameLayout)))
    {
      paramView = (FrameLayout)paramView;
      paramAbsStructMsgElement.a(this.b, paramView.findViewById(2131435545), paramBundle);
      return paramView;
    }
    paramView = new FrameLayout(this.b);
    paramView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    paramView.setId(2131446569);
    if (paramBundle != null) {
      paramBundle.putBoolean("pa_should_change", true);
    }
    paramAbsStructMsgElement = (ImageView)paramAbsStructMsgElement.a(this.b, null, paramBundle).findViewById(2131435545);
    paramBundle = new FrameLayout.LayoutParams(-1, this.f);
    if ((paramAbsStructMsgElement != null) && ((paramAbsStructMsgElement instanceof PAImageView)))
    {
      PAImageView localPAImageView = (PAImageView)paramAbsStructMsgElement;
      localPAImageView.setUseRadiusRound(true, localResources.getDimensionPixelSize(2131296675));
      localPAImageView.setTag(2131440836, Integer.valueOf(1));
    }
    paramView.addView(paramAbsStructMsgElement, paramBundle);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5Adapter
 * JD-Core Version:    0.7.0.1
 */