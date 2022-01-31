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
    label37:
    Object localObject;
    if (paramBundle.getInt("longMsgHolderType", -1) == 1)
    {
      i = 1;
      if ((paramView == null) || (!(paramView instanceof RelativeLayout))) {
        break label237;
      }
      ((RelativeLayout)paramView).removeAllViews();
      paramView = (RelativeLayout)paramView;
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, AIOUtils.a(75.0F, paramOnLongClickAndTouchListener)));
      paramBundle = new RelativeLayout(paramContext);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramView.addView(paramBundle, (ViewGroup.LayoutParams)localObject);
      localObject = new ImageView(paramContext);
      paramContext = new TextView(paramContext);
      if (i == 0) {
        break label249;
      }
      ((ImageView)localObject).setImageResource(2130839711);
      paramContext.setText(paramOnLongClickAndTouchListener.getString(2131430105));
    }
    for (;;)
    {
      ((ImageView)localObject).setId(2131362098);
      ((ImageView)localObject).setLayoutParams(new RelativeLayout.LayoutParams(AIOUtils.a(23.5F, paramOnLongClickAndTouchListener), AIOUtils.a(22.5F, paramOnLongClickAndTouchListener)));
      paramBundle.addView((View)localObject);
      paramContext.setTextSize(2, 14.0F);
      paramContext.setTextColor(Color.parseColor("#777777"));
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(1, 2131362098);
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.a(7.5F, paramOnLongClickAndTouchListener);
      paramBundle.addView(paramContext, (ViewGroup.LayoutParams)localObject);
      return paramView;
      i = 0;
      break;
      label237:
      paramView = new RelativeLayout(paramContext);
      break label37;
      label249:
      ((ImageView)localObject).setImageResource(2130839710);
      paramContext.setText(paramOnLongClickAndTouchListener.getString(2131430106));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLongMsgHolder
 * JD-Core Version:    0.7.0.1
 */