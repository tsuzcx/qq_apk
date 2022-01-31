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
    int i = localResources.getDimensionPixelSize(2131558648);
    int j = localResources.getDimensionPixelSize(2131558649);
    paramContext.setPadding(i, localResources.getDimensionPixelSize(2131558650), j, localResources.getDimensionPixelSize(2131558651));
    paramContext.setLayoutParams(localLayoutParams);
    return paramContext;
  }
  
  protected int b()
  {
    return 21;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    if (paramBundle.getInt("accostType") == AbsStructMsg.SOURCE_ACCOUNT_TYPE_PA) {}
    Resources localResources = paramContext.getResources();
    int i;
    int k;
    label102:
    Object localObject2;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
      i = paramView.getPaddingTop();
      j = paramView.getPaddingBottom();
      k = localResources.getDimensionPixelSize(2131558648);
      int m = localResources.getDimensionPixelSize(2131558649);
      a(paramView);
      d(paramView);
      paramView.setPadding(k, i, m, j);
      k = AIOUtils.a(7.0F, localResources);
      i = 0;
      if (i >= this.a.size()) {
        return paramView;
      }
      localObject2 = (AbsStructMsgElement)this.a.get(i);
      if (!(localObject2 instanceof StructMsgItemTr)) {
        break label216;
      }
      localObject1 = (StructMsgItemTr)localObject2;
      localObject2 = ((StructMsgItemTr)localObject1).a(paramContext, null, paramBundle);
      if (localObject2 != null)
      {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.topMargin = ((StructMsgItemTr)localObject1).e;
        localLayoutParams.bottomMargin = ((StructMsgItemTr)localObject1).f;
        paramView.addView((View)localObject2, localLayoutParams);
      }
    }
    label216:
    while (!(localObject2 instanceof StructMsgItemHr))
    {
      LinearLayout.LayoutParams localLayoutParams;
      i += 1;
      break label102;
      paramView = a(paramContext);
      break;
    }
    Object localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, null, paramBundle);
    if (((StructMsgItemHr)localObject2).a) {}
    for (int j = 0;; j = AIOUtils.a(2.0F, localResources))
    {
      localObject2 = new LinearLayout.LayoutParams(-1, j);
      ((LinearLayout.LayoutParams)localObject2).topMargin = k;
      ((LinearLayout.LayoutParams)localObject2).bottomMargin = k;
      if (localObject1 == null) {
        break;
      }
      paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      break;
    }
    return paramView;
  }
  
  public String b()
  {
    return "Layout21";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout21
 * JD-Core Version:    0.7.0.1
 */