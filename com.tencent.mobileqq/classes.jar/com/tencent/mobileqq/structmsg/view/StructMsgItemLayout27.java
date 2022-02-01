package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.widget.BubbleViewLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class StructMsgItemLayout27
  extends AbsStructMsgItem
{
  private boolean aA = false;
  protected final float az = 10.0F;
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("isSend", true);
    this.aA = paramBundle.getBoolean("pre_dialog", false);
    Resources localResources = paramContext.getResources();
    LinearLayout localLinearLayout;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramView;
      localLinearLayout.removeAllViews();
    }
    else
    {
      localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      localLinearLayout.setOrientation(1);
    }
    localLinearLayout.setId(2131438078);
    BubbleViewLayout localBubbleViewLayout = new BubbleViewLayout(paramContext);
    localBubbleViewLayout.setId(2131438077);
    if (this.aA) {
      localBubbleViewLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    } else {
      localBubbleViewLayout.setLayoutParams(new LinearLayout.LayoutParams(BaseChatItemLayout.e - AIOUtils.b(20.0F, localResources), -2));
    }
    localLinearLayout.setFocusable(false);
    if ((localLinearLayout.getParent() != null) && ((localLinearLayout.getParent() instanceof View))) {
      ((View)localLinearLayout.getParent()).setFocusable(false);
    }
    localLinearLayout.addView(localBubbleViewLayout);
    Object localObject3 = new RelativeLayout(paramContext);
    ((RelativeLayout)localObject3).setId(2131438071);
    paramView = new RelativeLayout.LayoutParams(-1, -2);
    localBubbleViewLayout.addView((View)localObject3, 0);
    if (this.aA)
    {
      if (this.au == 1) {
        ((RelativeLayout)localObject3).setBackgroundResource(2130846172);
      } else {
        ((RelativeLayout)localObject3).setBackgroundResource(2130846173);
      }
      localBubbleViewLayout.a(false);
      localBubbleViewLayout.b(false);
      ((RelativeLayout)localObject3).setLayoutParams(paramView);
    }
    else
    {
      if (bool) {
        paramView.addRule(9);
      } else {
        paramView.addRule(11);
      }
      ((RelativeLayout)localObject3).setLayoutParams(paramView);
      paramView = new ImageView(paramContext);
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      if (!bool)
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(9);
        ((RelativeLayout.LayoutParams)localObject1).addRule(0, 2131438071);
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject1).addRule(11);
        ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131438071);
      }
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      paramView.setId(2131442134);
      if (localBubbleViewLayout.a != bool) {
        localBubbleViewLayout.a = bool;
      }
      if (this.au == 1)
      {
        ((RelativeLayout)localObject3).setBackgroundResource(2130846165);
        paramView.setImageDrawable(localResources.getDrawable(2130846168));
      }
      else
      {
        ((RelativeLayout)localObject3).setBackgroundResource(2130846166);
        paramView.setImageDrawable(localResources.getDrawable(2130846167));
      }
      ((RelativeLayout)localObject3).setFocusable(false);
      ((RelativeLayout)localObject3).setFocusableInTouchMode(false);
      ((RelativeLayout)localObject3).setClickable(false);
      localBubbleViewLayout.setRadius(10.0F);
      localBubbleViewLayout.a(false);
    }
    Iterator localIterator = this.ax.iterator();
    Object localObject2 = null;
    Object localObject1 = null;
    paramView = (View)localObject1;
    while (localIterator.hasNext())
    {
      Object localObject4 = (AbsStructMsgElement)localIterator.next();
      Object localObject5 = ((AbsStructMsgElement)localObject4).b;
      if ("title".equals(localObject5))
      {
        localObject2 = (TextView)((AbsStructMsgElement)localObject4).a(paramContext, (View)localObject2, paramBundle);
        ((TextView)localObject2).setSingleLine();
        localObject4 = new RelativeLayout.LayoutParams(-1, -2);
        int i = localResources.getDimensionPixelSize(2131297273);
        int j = localResources.getDimensionPixelSize(2131296683);
        if (bool) {
          ((RelativeLayout.LayoutParams)localObject4).setMargins(0, 0, 0, 0);
        } else {
          ((RelativeLayout.LayoutParams)localObject4).setMargins(0, 0, 0, 0);
        }
        ((RelativeLayout.LayoutParams)localObject4).addRule(12);
        ((RelativeLayout.LayoutParams)localObject4).addRule(3, 2131438071);
        ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((TextView)localObject2).setPadding(i, j, i, j);
        ((TextView)localObject2).setSingleLine();
        ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
        ((TextView)localObject2).setBackgroundColor(localResources.getColor(2131168464));
        localBubbleViewLayout.addView((View)localObject2);
      }
      else if ("summary".equals(localObject5))
      {
        localObject2 = (StructMsgItemSummary)localObject4;
      }
      try
      {
        long l = Long.parseLong(((StructMsgItemSummary)localObject2).aA);
        localObject2 = Calendar.getInstance();
        ((Calendar)localObject2).setTimeInMillis(l * 1000L);
        localObject4 = new TextView(paramContext);
        ((TextView)localObject4).setId(2131447345);
        localObject5 = new RelativeLayout.LayoutParams(AIOUtils.b(68.0F, localResources), AIOUtils.b(18.0F, localResources));
        ((RelativeLayout.LayoutParams)localObject5).addRule(14);
        if (!this.aA) {
          break label1331;
        }
        f = 51.0F;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          continue;
          float f = 44.0F;
        }
      }
      ((RelativeLayout.LayoutParams)localObject5).topMargin = AIOUtils.b(f, localResources);
      ((TextView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((TextView)localObject4).setText(String.format("%d月%d日", new Object[] { Integer.valueOf(((Calendar)localObject2).get(2) + 1), Integer.valueOf(((Calendar)localObject2).get(5)) }));
      ((RelativeLayout)localObject3).addView((View)localObject4);
      ((TextView)localObject4).setSingleLine();
      try
      {
        ((TextView)localObject4).setIncludeFontPadding(false);
        ((TextView)localObject4).setGravity(17);
        ((TextView)localObject4).setTextSize(14.0F);
        if (this.au == 1)
        {
          ((TextView)localObject4).setTextColor(localResources.getColor(2131165449));
        }
        else
        {
          ((TextView)localObject4).setTextColor(Color.parseColor("#ff455e"));
          ((TextView)localObject4).setAlpha(0.8F);
        }
      }
      catch (Exception localException2)
      {
        label1069:
        break label1069;
      }
      break label1069;
      if (("head".equals(localObject5)) && ((localObject4 instanceof StructMsgItemAvatar)))
      {
        paramBundle.putInt("bundle_args_avatar_width", AIOUtils.b(52.0F, localResources));
        paramBundle.putInt("bundle_args_avatar_height", AIOUtils.b(52.0F, localResources));
        paramBundle.putInt("bundle_args_cover_width", AIOUtils.b(52.0F, localResources));
        paramBundle.putInt("bundle_args_cover_height", AIOUtils.b(52.0F, localResources));
        if (BaseApplicationImpl.sApplication.getRuntime().getAccount().equalsIgnoreCase(((StructMsgItemAvatar)localObject4).av)) {
          localObject1 = (LinearLayout)((AbsStructMsgElement)localObject4).a(paramContext, null, paramBundle);
        } else {
          paramView = (LinearLayout)((AbsStructMsgElement)localObject4).a(paramContext, null, paramBundle);
        }
      }
      localObject2 = null;
    }
    localObject2 = new RelativeLayout(paramContext);
    ((RelativeLayout)localObject2).setId(2131429043);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.addRule(14);
    if (this.aA) {
      paramBundle.topMargin = AIOUtils.b(9.0F, localResources);
    } else {
      paramBundle.topMargin = AIOUtils.b(7.0F, localResources);
    }
    paramBundle.addRule(3, 2131447345);
    ((RelativeLayout)localObject2).setLayoutParams(paramBundle);
    ((RelativeLayout)localObject3).addView((View)localObject2);
    localObject3 = new RelativeLayout.LayoutParams(AIOUtils.b(52.0F, localResources), AIOUtils.b(52.0F, localResources));
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = new LinearLayout(paramContext);
    }
    paramBundle.setId(2131445566);
    paramBundle.setGravity(5);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((RelativeLayout)localObject2).addView(paramBundle);
    localObject1 = new RelativeLayout.LayoutParams(AIOUtils.b(52.0F, localResources), AIOUtils.b(52.0F, localResources));
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131445566);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.b(15.0F, localResources);
    paramBundle = paramView;
    if (paramView == null) {
      paramBundle = new LinearLayout(paramContext);
    }
    paramBundle.setId(2131433779);
    paramBundle.setGravity(3);
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    ((RelativeLayout)localObject2).addView(paramBundle);
    return localLinearLayout;
  }
  
  protected int c()
  {
    return 27;
  }
  
  public String e()
  {
    return "layout27";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout27
 * JD-Core Version:    0.7.0.1
 */