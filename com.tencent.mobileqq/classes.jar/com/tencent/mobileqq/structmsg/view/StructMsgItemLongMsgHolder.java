package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;

public class StructMsgItemLongMsgHolder
{
  public static View a(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener, Bundle paramBundle)
  {
    paramOnLongClickAndTouchListener = paramContext.getResources();
    int i;
    if (paramBundle.getInt("longMsgHolderType", -1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramView != null) && ((paramView instanceof RelativeLayout))) {
      ((RelativeLayout)paramView).removeAllViews();
    } else {
      paramView = new RelativeLayout(paramContext);
    }
    paramView = (RelativeLayout)paramView;
    paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.b(75.0F, paramOnLongClickAndTouchListener)));
    paramBundle = new RelativeLayout(paramContext);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(13);
    paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(paramContext);
    paramContext = new TextView(paramContext);
    if (i != 0)
    {
      ((ImageView)localObject).setImageResource(2130842663);
      paramContext.setText(paramOnLongClickAndTouchListener.getString(2131894201));
    }
    else
    {
      ((ImageView)localObject).setImageResource(2130842662);
      paramContext.setText(paramOnLongClickAndTouchListener.getString(2131894200));
    }
    ((ImageView)localObject).setId(2131446467);
    ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.b(23.5F, paramOnLongClickAndTouchListener), AIOUtils.b(22.5F, paramOnLongClickAndTouchListener)));
    paramBundle.addView((View)localObject);
    paramContext.setTextSize(2, 14.0F);
    paramContext.setTextColor(Color.parseColor("#777777"));
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131446467);
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(7.5F, paramOnLongClickAndTouchListener);
    paramBundle.addView(paramContext, (ViewGroup.LayoutParams)localObject);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLongMsgHolder
 * JD-Core Version:    0.7.0.1
 */