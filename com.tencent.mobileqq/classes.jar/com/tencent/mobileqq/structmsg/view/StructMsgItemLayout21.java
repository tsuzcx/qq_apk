package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;

public class StructMsgItemLayout21
  extends AbsStructMsgItem
{
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    paramContext.setOrientation(1);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    int i = localResources.getDimensionPixelSize(2131299802);
    int j = localResources.getDimensionPixelSize(2131299803);
    paramContext.setPadding(i, localResources.getDimensionPixelSize(2131299804), j, localResources.getDimensionPixelSize(2131299801));
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle.getInt("accostType");
    int i = AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA;
    Resources localResources = paramContext.getResources();
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
    }
    else
    {
      paramView = a(paramContext);
    }
    i = paramView.getPaddingTop();
    int j = paramView.getPaddingBottom();
    int k = localResources.getDimensionPixelSize(2131299802);
    int m = localResources.getDimensionPixelSize(2131299803);
    a(paramView);
    d(paramView);
    paramView.setPadding(k, i, m, j);
    k = AIOUtils.b(7.0F, localResources);
    i = 0;
    while (i < this.ax.size())
    {
      Object localObject2 = (AbsStructMsgElement)this.ax.get(i);
      Object localObject1;
      if ((localObject2 instanceof StructMsgItemTr))
      {
        localObject1 = (StructMsgItemTr)localObject2;
        localObject2 = ((StructMsgItemTr)localObject1).a(paramContext, null, paramBundle);
        if (localObject2 != null)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          localLayoutParams.topMargin = ((StructMsgItemTr)localObject1).av;
          localLayoutParams.bottomMargin = ((StructMsgItemTr)localObject1).aw;
          paramView.addView((View)localObject2, localLayoutParams);
        }
      }
      else if ((localObject2 instanceof StructMsgItemHr))
      {
        localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
        if (((StructMsgItemHr)localObject2).au) {
          j = 0;
        } else {
          j = AIOUtils.b(2.0F, localResources);
        }
        localObject2 = new LinearLayout.LayoutParams(-1, j);
        ((LinearLayout.LayoutParams)localObject2).topMargin = k;
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = k;
        if (localObject1 != null) {
          paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
      }
      i += 1;
    }
    return paramView;
  }
  
  protected int c()
  {
    return 21;
  }
  
  public String e()
  {
    return "Layout21";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout21
 * JD-Core Version:    0.7.0.1
 */