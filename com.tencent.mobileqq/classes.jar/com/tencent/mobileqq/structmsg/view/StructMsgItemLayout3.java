package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout3
  extends AbsStructMsgItem
{
  @TargetApi(16)
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    Resources localResources = paramContext.getResources();
    Object localObject1 = this.ax.iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext()) {
      if (((AbsStructMsgElement)((Iterator)localObject1).next() instanceof StructMsgItemButton)) {
        i += 1;
      }
    }
    paramBundle.putInt("Layout3ButtonCount", i);
    int m;
    int j;
    int k;
    Object localObject2;
    int n;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localObject1 = (LinearLayout)paramView;
      m = this.ax.size();
      j = 0;
      for (i = 0;; i = k)
      {
        paramView = (View)localObject1;
        k = i;
        if (j >= m) {
          break;
        }
        paramView = (AbsStructMsgElement)this.ax.get(j);
        paramView.ar = this.ar;
        localObject2 = paramView.b;
        if ((!"picture".equals(localObject2)) && (!"video".equals(localObject2)))
        {
          k = i;
          if ("button".equals(localObject2))
          {
            paramBundle.putInt("Layout3ButtonIndex", j);
            paramView.ar = this.ar;
            paramView.a(paramContext, ((LinearLayout)localObject1).getChildAt(j * 2), paramBundle);
            k = i;
            if (i == 0) {
              k = 1;
            }
          }
        }
        else
        {
          paramView.ar = this.ar;
          paramView = paramView.a(paramContext, ((LinearLayout)localObject1).getChildAt(j), paramBundle);
          k = i;
          if ((paramView instanceof PAHighLightImageView))
          {
            paramView = (PAHighLightImageView)paramView;
            k = i;
          }
        }
        j += 1;
      }
      i = 0;
    }
    else
    {
      localObject1 = new LinearLayout(paramContext);
      localObject2 = new ArrayList();
      int i1 = this.ax.size();
      k = 0;
      m = 0;
      for (j = 0; k < i1; j = n)
      {
        paramView = (AbsStructMsgElement)this.ax.get(k);
        paramView.ar = this.ar;
        String str = paramView.b;
        if ((!"picture".equals(str)) && (!"video".equals(str)))
        {
          i = m;
          n = j;
          if ("button".equals(str))
          {
            paramBundle.putInt("Layout3ButtonIndex", k);
            paramView.ar = this.ar;
            paramView = paramView.a(paramContext, null, paramBundle);
            if (k == 0) {
              i = 2131446451;
            } else if (k == 1) {
              i = 2131446452;
            } else if (k == 2) {
              i = 2131446453;
            } else {
              i = 0;
            }
            paramView.setId(i);
            ((ArrayList)localObject2).add(paramView);
            m += 1;
            i = m;
            n = j;
            if (j == 0)
            {
              n = 1;
              i = m;
            }
          }
        }
        else
        {
          if (m >= 3) {
            break;
          }
          paramView.ar = this.ar;
          paramView = paramView.a(paramContext, null, paramBundle);
          if (k == 0) {
            i = 2131446451;
          } else if (k == 1) {
            i = 2131446452;
          } else if (k == 2) {
            i = 2131446453;
          } else {
            i = 0;
          }
          paramView.setId(i);
          ((ArrayList)localObject2).add(paramView);
          i = m + 1;
          n = j;
        }
        k += 1;
        m = i;
      }
      if (((ArrayList)localObject2).size() == 0)
      {
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("generate 3 item failed,item is:");
          paramContext.append(this.ax);
          QLog.e("StructMsg", 2, paramContext.toString());
        }
        return null;
      }
      i = AIOUtils.b(10.0F, localResources);
      n = ((ArrayList)localObject2).size();
      m = (int)((BaseChatItemLayout.f - i - i - 2) / 3.0F);
      i = 0;
      for (;;)
      {
        paramView = (View)localObject1;
        k = j;
        if (i >= n) {
          break;
        }
        paramView = (View)((ArrayList)localObject2).get(i);
        paramBundle = new LinearLayout.LayoutParams(-1, -2);
        paramBundle.weight = 1.0F;
        paramBundle.width = 0;
        paramBundle.height = m;
        if ((paramView instanceof TextView))
        {
          m = AIOUtils.b(45.0F, localResources);
          paramBundle.height = m;
          ((LinearLayout)localObject1).addView(paramView, paramBundle);
          if (i != n - 1)
          {
            paramView = new ImageView(paramContext);
            paramView.setLayoutParams(new ViewGroup.LayoutParams(1, m - 2));
            paramView.setBackgroundColor(-2170912);
            ((LinearLayout)localObject1).addView(paramView);
          }
        }
        else
        {
          if (i > 0) {
            paramBundle.leftMargin = 1;
          }
          ((LinearLayout)localObject1).addView(paramView, paramBundle);
        }
        i += 1;
      }
    }
    a(paramView);
    d(paramView);
    if (k == 0)
    {
      i = AIOUtils.b(10.0F, localResources);
      if (a(1)) {
        j = i;
      } else {
        j = AIOUtils.b(5.0F, localResources);
      }
      if (a(2))
      {
        k = i;
        n = k;
        m = j;
        j = k;
        k = i;
        i = n;
      }
      else
      {
        k = AIOUtils.b(5.0F, localResources);
        n = i;
        m = j;
        j = k;
        k = i;
        i = n;
      }
    }
    else
    {
      m = 0;
      j = 0;
      k = 0;
    }
    paramView.setPadding(k, m, i, j);
    return paramView;
  }
  
  protected int c()
  {
    return 3;
  }
  
  public String e()
  {
    return "Layout3";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout3
 * JD-Core Version:    0.7.0.1
 */