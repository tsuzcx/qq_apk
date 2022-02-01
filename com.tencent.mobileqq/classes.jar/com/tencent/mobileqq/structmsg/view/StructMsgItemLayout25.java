package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout25
  extends AbsStructMsgItem
{
  private TextView az;
  
  private void a(Context paramContext, Resources paramResources, RelativeLayout paramRelativeLayout, View paramView, LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2)
  {
    float f = paramResources.getDisplayMetrics().density;
    paramRelativeLayout.addView(paramView, new RelativeLayout.LayoutParams(-1, -1));
    paramResources = new FrameLayout(paramContext);
    paramResources.setId(2131446142);
    paramView = new ImageView(paramContext);
    paramView.setImageResource(2130852671);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 80;
    paramResources.addView(paramView, localLayoutParams);
    paramView = new FrameLayout.LayoutParams(-2, -2);
    paramView.gravity = 17;
    paramResources.addView(paramLinearLayout, paramView);
    paramView = new RelativeLayout.LayoutParams(-2, -2);
    paramView.addRule(14);
    paramView.addRule(10);
    paramView.topMargin = ((int)(32.0F * f));
    paramRelativeLayout.addView(paramResources, paramView);
    paramTextView2.setId(2131446143);
    paramTextView2.setIncludeFontPadding(false);
    paramTextView2.setSingleLine(false);
    paramTextView2.setMaxLines(2);
    paramTextView2.setTextSize(1, 40.0F);
    paramTextView2.setTextColor(-1);
    paramTextView2.setGravity(17);
    paramTextView2.getPaint().setFakeBoldText(true);
    this.az = paramTextView2;
    int i = (int)(240.0F * f);
    paramResources = new RelativeLayout.LayoutParams(i, -2);
    paramResources.addRule(14);
    paramResources.addRule(3, 2131446142);
    int j = (int)(5.0F * f);
    paramResources.topMargin = j;
    paramResources.bottomMargin = j;
    paramRelativeLayout.addView(paramTextView2, paramResources);
    paramResources = new ImageView(paramContext);
    paramResources.setId(2131446144);
    paramResources.setImageResource(2130852673);
    paramView = new RelativeLayout.LayoutParams(-2, -2);
    paramView.addRule(14);
    paramView.addRule(3, 2131446143);
    paramRelativeLayout.addView(paramResources, paramView);
    paramResources = new RelativeLayout(paramContext);
    paramView = new ImageView(paramContext);
    paramView.setId(2131446146);
    paramView.setImageResource(2130852674);
    paramLinearLayout = new RelativeLayout.LayoutParams(-2, -2);
    paramLinearLayout.addRule(13);
    paramResources.addView(paramView, paramLinearLayout);
    paramContext = new ImageView(paramContext);
    paramContext.setImageResource(2130852670);
    paramView = new RelativeLayout.LayoutParams(-2, -2);
    paramView.addRule(15);
    paramView.addRule(0, 2131446146);
    j = (int)(6.0F * f);
    paramView.rightMargin = j;
    paramResources.addView(paramContext, paramView);
    paramTextView1.setIncludeFontPadding(false);
    paramTextView1.setTextSize(1, 22.0F);
    paramTextView1.setTextColor(-1);
    paramTextView1.getPaint().setFakeBoldText(true);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(15);
    paramContext.addRule(1, 2131446146);
    paramContext.leftMargin = j;
    paramResources.addView(paramTextView1, paramContext);
    paramContext = new RelativeLayout.LayoutParams(i, -2);
    paramContext.addRule(14);
    paramContext.addRule(3, 2131446144);
    paramContext.topMargin = ((int)(f * 10.0F));
    paramRelativeLayout.addView(paramResources, paramContext);
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
    }
    else
    {
      paramView = new LinearLayout(paramContext);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      paramView.setOrientation(1);
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, AIOUtils.b(290.0F, localResources)));
    paramView.addView(localRelativeLayout);
    Iterator localIterator = this.ax.iterator();
    int i = 0;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject4 = null;
    Object localObject8;
    for (Object localObject1 = null; localIterator.hasNext(); localObject1 = localObject8)
    {
      AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)localIterator.next();
      String str = localAbsStructMsgElement.b;
      Object localObject6;
      Object localObject7;
      if (("type".equals(str)) && ((localAbsStructMsgElement instanceof StructMsgItemType)))
      {
        j = ((StructMsgItemType)localAbsStructMsgElement).au;
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("getView socialType=");
          ((StringBuilder)localObject5).append(j);
          QLog.d("StructMsgItemLayout25", 2, ((StringBuilder)localObject5).toString());
        }
        localObject5 = localObject3;
        localObject6 = localObject2;
        localObject7 = localObject4;
        localObject8 = localObject1;
      }
      else if (("title".equals(str)) && (localObject3 == null))
      {
        if ((localAbsStructMsgElement instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localAbsStructMsgElement).a(d(), this.av);
        }
        localObject5 = (TextView)localAbsStructMsgElement.a(paramContext, null, paramBundle);
        ((TextView)localObject5).setSingleLine();
        ((TextView)localObject5).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject5).getPaint().setFakeBoldText(true);
        j = i;
        localObject6 = localObject2;
        localObject7 = localObject4;
        localObject8 = localObject1;
      }
      else if (("summary".equals(str)) && (localObject2 == null))
      {
        localObject6 = (TextView)localAbsStructMsgElement.a(paramContext, null, paramBundle);
        ((TextView)localObject6).setSingleLine();
        ((TextView)localObject6).setEllipsize(TextUtils.TruncateAt.END);
        j = i;
        localObject5 = localObject3;
        localObject7 = localObject4;
        localObject8 = localObject1;
      }
      else if (("picture".equals(str)) && (localObject4 == null))
      {
        localObject4 = localAbsStructMsgElement.a(paramContext, null, paramBundle);
        j = i;
        localObject5 = localObject3;
        localObject6 = localObject2;
        localObject7 = localObject4;
        localObject8 = localObject1;
        if (localObject4 != null)
        {
          j = i;
          localObject5 = localObject3;
          localObject6 = localObject2;
          localObject7 = localObject4;
          localObject8 = localObject1;
          if ((localObject4 instanceof PAImageView))
          {
            float f = localResources.getDimensionPixelSize(2131296675);
            ((PAImageView)localObject4).setUseRadiusRound(true, f);
            j = i;
            localObject5 = localObject3;
            localObject6 = localObject2;
            localObject7 = localObject4;
            localObject8 = localObject1;
          }
        }
      }
      else
      {
        j = i;
        localObject5 = localObject3;
        localObject6 = localObject2;
        localObject7 = localObject4;
        localObject8 = localObject1;
        if ("head".equals(str))
        {
          j = i;
          localObject5 = localObject3;
          localObject6 = localObject2;
          localObject7 = localObject4;
          localObject8 = localObject1;
          if ((localAbsStructMsgElement instanceof StructMsgItemAvatar))
          {
            j = i;
            localObject5 = localObject3;
            localObject6 = localObject2;
            localObject7 = localObject4;
            localObject8 = localObject1;
            if (localObject1 == null)
            {
              ((StructMsgItemAvatar)localAbsStructMsgElement).au = i;
              localObject8 = (LinearLayout)localAbsStructMsgElement.a(paramContext, null, paramBundle);
              localObject7 = localObject4;
              localObject6 = localObject2;
              localObject5 = localObject3;
              j = i;
            }
          }
        }
      }
      i = j;
      localObject3 = localObject5;
      localObject2 = localObject6;
      localObject4 = localObject7;
    }
    paramBundle = new StructMsgItemMore(paramContext.getString(2131916714)).a(paramContext, null, null);
    Object localObject5 = new LinearLayout.LayoutParams(-1, -2);
    int j = AIOUtils.b(15.0F, localResources);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject5);
    paramBundle.setPadding(j, j, j, j);
    localObject5 = (TextView)paramBundle.findViewById(2131446471);
    ((TextView)localObject5).setSingleLine();
    ((TextView)localObject5).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject5).setTextSize(1, 18.0F);
    paramView.addView(paramBundle);
    if ((localObject3 != null) && (localObject2 != null) && (localObject4 != null))
    {
      if (localObject1 == null) {
        return paramView;
      }
      if (i == 4)
      {
        a(paramContext, localResources, localRelativeLayout, (View)localObject4, localObject1, localObject3, localObject2);
        ((TextView)localObject5).setText(HardCodeUtil.a(2131911924));
        return paramView;
      }
      localRelativeLayout.addView((View)localObject4, new RelativeLayout.LayoutParams(-1, -1));
      paramBundle = new RelativeLayout.LayoutParams(-2, -2);
      paramBundle.addRule(14);
      paramBundle.topMargin = AIOUtils.b(25.0F, localResources);
      localObject3.setLayoutParams(paramBundle);
      localObject3.setId(2131446145);
      localRelativeLayout.addView(localObject3);
      paramBundle = new RelativeLayout(paramContext);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(13);
      localObject2.setLayoutParams((ViewGroup.LayoutParams)localObject4);
      paramBundle.addView(localObject2);
      localObject4 = new ImageView(paramContext);
      ((ImageView)localObject4).setImageResource(2130852664);
      localObject5 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject5).addRule(0, localObject2.getId());
      ((RelativeLayout.LayoutParams)localObject5).addRule(15);
      ((RelativeLayout.LayoutParams)localObject5).rightMargin = AIOUtils.b(7.0F, localResources);
      paramBundle.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      paramContext = new ImageView(paramContext);
      paramContext.setImageResource(2130852665);
      localObject4 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, localObject2.getId());
      ((RelativeLayout.LayoutParams)localObject4).addRule(15);
      ((RelativeLayout.LayoutParams)localObject4).leftMargin = AIOUtils.b(7.0F, localResources);
      paramBundle.addView(paramContext, (ViewGroup.LayoutParams)localObject4);
      paramContext = new RelativeLayout.LayoutParams(-1, -2);
      paramContext.topMargin = AIOUtils.b(5.0F, localResources);
      paramContext.addRule(3, 2131446145);
      paramBundle.setLayoutParams(paramContext);
      paramBundle.setId(2131446143);
      localRelativeLayout.addView(paramBundle);
      paramContext = new RelativeLayout.LayoutParams(-2, -2);
      paramContext.addRule(14);
      paramContext.addRule(3, 2131446143);
      paramContext.topMargin = AIOUtils.b(10.0F, localResources);
      if (localObject1 != null)
      {
        localObject1.setId(2131446142);
        localObject1.setLayoutParams(paramContext);
        localRelativeLayout.addView(localObject1);
      }
      localObject3.setTextSize(2, 14.0F);
      localObject3.setTextColor(-1);
      localObject2.setTextSize(2, 30.0F);
      localObject2.setTextColor(-1);
    }
    return paramView;
  }
  
  protected int c()
  {
    return 25;
  }
  
  public String e()
  {
    return "layout25";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout25
 * JD-Core Version:    0.7.0.1
 */