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
  protected final float a;
  private boolean a;
  
  public StructMsgItemLayout27()
  {
    this.jdField_a_of_type_Float = 10.0F;
  }
  
  protected int b()
  {
    return 27;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    boolean bool = paramBundle.getBoolean("isSend", true);
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("pre_dialog", false);
    Resources localResources = paramContext.getResources();
    Object localObject1 = null;
    Object localObject2 = null;
    LinearLayout localLinearLayout;
    BubbleViewLayout localBubbleViewLayout;
    label101:
    Object localObject3;
    label203:
    Object localObject4;
    label233:
    Object localObject5;
    int i;
    int j;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramView;
      localLinearLayout.removeAllViews();
      localLinearLayout.setId(2131362345);
      localBubbleViewLayout = new BubbleViewLayout(paramContext);
      localBubbleViewLayout.setId(2131362346);
      if (!this.jdField_a_of_type_Boolean) {
        break label439;
      }
      localBubbleViewLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      localLinearLayout.setFocusable(false);
      if ((localLinearLayout.getParent() != null) && ((localLinearLayout.getParent() instanceof View))) {
        ((View)localLinearLayout.getParent()).setFocusable(false);
      }
      localLinearLayout.addView(localBubbleViewLayout);
      localObject3 = new RelativeLayout(paramContext);
      ((RelativeLayout)localObject3).setId(2131369425);
      paramView = new RelativeLayout.LayoutParams(-1, -2);
      localBubbleViewLayout.addView((View)localObject3, 0);
      if (!this.jdField_a_of_type_Boolean) {
        break label477;
      }
      if (this.e != 1) {
        break label467;
      }
      ((RelativeLayout)localObject3).setBackgroundResource(2130842196);
      localBubbleViewLayout.a(false);
      localBubbleViewLayout.b(false);
      ((RelativeLayout)localObject3).setLayoutParams(paramView);
      localObject4 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      paramView = (View)localObject2;
      if (!((Iterator)localObject4).hasNext()) {
        break label1066;
      }
      localObject2 = (AbsStructMsgElement)((Iterator)localObject4).next();
      localObject5 = ((AbsStructMsgElement)localObject2).a;
      if (!"title".equals(localObject5)) {
        break label685;
      }
      localObject2 = (TextView)((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
      ((TextView)localObject2).setSingleLine();
      localObject5 = new RelativeLayout.LayoutParams(-1, -2);
      i = localResources.getDimensionPixelSize(2131558514);
      j = localResources.getDimensionPixelSize(2131558606);
      if (!bool) {
        break label673;
      }
      ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, 0, 0);
    }
    for (;;)
    {
      ((RelativeLayout.LayoutParams)localObject5).addRule(12);
      ((RelativeLayout.LayoutParams)localObject5).addRule(3, 2131369425);
      ((TextView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject5);
      ((TextView)localObject2).setPadding(i, j, i, j);
      ((TextView)localObject2).setSingleLine();
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setBackgroundColor(localResources.getColor(2131492969));
      localBubbleViewLayout.addView((View)localObject2);
      break label233;
      localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      localLinearLayout.setOrientation(1);
      break;
      label439:
      localBubbleViewLayout.setLayoutParams(new LinearLayout.LayoutParams(BaseChatItemLayout.d - AIOUtils.a(20.0F, localResources), -2));
      break label101;
      label467:
      ((RelativeLayout)localObject3).setBackgroundResource(2130842197);
      break label203;
      label477:
      if (bool)
      {
        paramView.addRule(9);
        label488:
        ((RelativeLayout)localObject3).setLayoutParams(paramView);
        paramView = new ImageView(paramContext);
        localObject4 = new RelativeLayout.LayoutParams(-2, -2);
        if (bool) {
          break label634;
        }
        ((RelativeLayout.LayoutParams)localObject4).addRule(9);
        ((RelativeLayout.LayoutParams)localObject4).addRule(0, 2131369425);
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject4);
        paramView.setId(2131362371);
        if (localBubbleViewLayout.jdField_a_of_type_Boolean != bool) {
          localBubbleViewLayout.jdField_a_of_type_Boolean = bool;
        }
        if (this.e != 1) {
          break label652;
        }
        ((RelativeLayout)localObject3).setBackgroundResource(2130842189);
        paramView.setImageDrawable(localResources.getDrawable(2130842192));
      }
      for (;;)
      {
        label536:
        ((RelativeLayout)localObject3).setFocusable(false);
        ((RelativeLayout)localObject3).setFocusableInTouchMode(false);
        ((RelativeLayout)localObject3).setClickable(false);
        localBubbleViewLayout.setRadius(10.0F);
        localBubbleViewLayout.a(false);
        break;
        paramView.addRule(11);
        break label488;
        label634:
        ((RelativeLayout.LayoutParams)localObject4).addRule(11);
        ((RelativeLayout.LayoutParams)localObject4).addRule(1, 2131369425);
        break label536;
        label652:
        ((RelativeLayout)localObject3).setBackgroundResource(2130842190);
        paramView.setImageDrawable(localResources.getDrawable(2130842191));
      }
      label673:
      ((RelativeLayout.LayoutParams)localObject5).setMargins(0, 0, 0, 0);
    }
    label685:
    if ("summary".equals(localObject5)) {
      localObject2 = (StructMsgItemSummary)localObject2;
    }
    for (;;)
    {
      try
      {
        long l = Long.parseLong(((StructMsgItemSummary)localObject2).A);
        localObject2 = Calendar.getInstance();
        ((Calendar)localObject2).setTimeInMillis(l * 1000L);
        localObject5 = new TextView(paramContext);
        ((TextView)localObject5).setId(2131366702);
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(68.0F, localResources), AIOUtils.a(18.0F, localResources));
        localLayoutParams.addRule(14);
        if (!this.jdField_a_of_type_Boolean) {
          break label1317;
        }
        f = 51.0F;
        localLayoutParams.topMargin = AIOUtils.a(f, localResources);
        ((TextView)localObject5).setLayoutParams(localLayoutParams);
        ((TextView)localObject5).setText(String.format("%d月%d日", new Object[] { Integer.valueOf(((Calendar)localObject2).get(2) + 1), Integer.valueOf(((Calendar)localObject2).get(5)) }));
        ((RelativeLayout)localObject3).addView((View)localObject5);
        ((TextView)localObject5).setSingleLine();
        ((TextView)localObject5).setIncludeFontPadding(false);
        ((TextView)localObject5).setGravity(17);
        ((TextView)localObject5).setTextSize(14.0F);
        if (this.e == 1)
        {
          ((TextView)localObject5).setTextColor(localResources.getColor(2131493168));
        }
        else
        {
          ((TextView)localObject5).setTextColor(Color.parseColor("#ff455e"));
          ((TextView)localObject5).setAlpha(0.8F);
        }
      }
      catch (Exception localException) {}
      if (("head".equals(localObject5)) && ((localException instanceof StructMsgItemAvatar)))
      {
        paramBundle.putInt("bundle_args_avatar_width", AIOUtils.a(52.0F, localResources));
        paramBundle.putInt("bundle_args_avatar_height", AIOUtils.a(52.0F, localResources));
        paramBundle.putInt("bundle_args_cover_width", AIOUtils.a(52.0F, localResources));
        paramBundle.putInt("bundle_args_cover_height", AIOUtils.a(52.0F, localResources));
        if (BaseApplicationImpl.sApplication.getRuntime().getAccount().equalsIgnoreCase(((StructMsgItemAvatar)localException).u))
        {
          localObject1 = (LinearLayout)localException.a(paramContext, null, paramBundle);
          break;
        }
        paramView = (LinearLayout)localException.a(paramContext, null, paramBundle);
        break;
        label1066:
        RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
        localRelativeLayout.setId(2131369426);
        paramBundle = new RelativeLayout.LayoutParams(-2, -2);
        paramBundle.addRule(14);
        if (this.jdField_a_of_type_Boolean) {}
        for (paramBundle.topMargin = AIOUtils.a(9.0F, localResources);; paramBundle.topMargin = AIOUtils.a(7.0F, localResources))
        {
          paramBundle.addRule(3, 2131366702);
          localRelativeLayout.setLayoutParams(paramBundle);
          ((RelativeLayout)localObject3).addView(localRelativeLayout);
          localObject3 = new RelativeLayout.LayoutParams(AIOUtils.a(52.0F, localResources), AIOUtils.a(52.0F, localResources));
          paramBundle = (Bundle)localObject1;
          if (localObject1 == null) {
            paramBundle = new LinearLayout(paramContext);
          }
          paramBundle.setId(2131369427);
          paramBundle.setGravity(5);
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localRelativeLayout.addView(paramBundle);
          localObject1 = new RelativeLayout.LayoutParams(AIOUtils.a(52.0F, localResources), AIOUtils.a(52.0F, localResources));
          ((RelativeLayout.LayoutParams)localObject1).addRule(1, 2131369427);
          ((RelativeLayout.LayoutParams)localObject1).leftMargin = AIOUtils.a(15.0F, localResources);
          paramBundle = paramView;
          if (paramView == null) {
            paramBundle = new LinearLayout(paramContext);
          }
          paramBundle.setId(2131364630);
          paramBundle.setGravity(3);
          paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          localRelativeLayout.addView(paramBundle);
          return localLinearLayout;
        }
      }
      break;
      break;
      label1317:
      float f = 44.0F;
    }
  }
  
  public String b()
  {
    return "layout27";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout27
 * JD-Core Version:    0.7.0.1
 */