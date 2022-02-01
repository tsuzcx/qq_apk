package com.tencent.mobileqq.forward;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout2;
import com.tencent.mobileqq.structmsg.widget.HeightLimitedLinearLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class ForwardSdkBaseOption$PreStructViewHolder
{
  Context a;
  View b;
  HashMap<AbsStructMsgElement, View> c = new HashMap(1);
  
  ForwardSdkBaseOption$PreStructViewHolder(ForwardSdkBaseOption paramForwardSdkBaseOption, Context paramContext)
  {
    this.a = paramContext;
  }
  
  View a()
  {
    if ((this.d.am instanceof StructMsgForImageShare)) {
      return this.d.am.getPreDialogView(this.a, null);
    }
    if ((this.d.am instanceof StructMsgForAudioShare))
    {
      this.b = this.d.am.getPreDialogView(this.a, this.b);
    }
    else
    {
      Object localObject1 = new HeightLimitedLinearLayout(this.a);
      ((HeightLimitedLinearLayout)localObject1).setOrientation(1);
      Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 1;
      ((HeightLimitedLinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((HeightLimitedLinearLayout)localObject1).setMaxHeight(this.a.getResources().getDisplayMetrics().heightPixels >> 1);
      this.b = ((View)localObject1);
      b();
      if ((a(this.d.am)) && (this.d.am.mMsgUrl != null))
      {
        localObject1 = this.d;
        if (!(localObject1 instanceof ForwardQZoneRichImageOption))
        {
          ((ForwardSdkBaseOption)localObject1).L = 8;
          localObject1 = new FrameLayout(this.a);
          localObject2 = new View(this.d.s);
          ((View)localObject2).setBackgroundResource(2130840448);
          ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, ViewUtils.dip2px(33.0F), 16));
          ((View)localObject2).setOnClickListener(new ForwardSdkBaseOption.PreStructViewHolder.1(this));
          ((View)localObject2).setContentDescription(HardCodeUtil.a(2131902819));
          localObject2 = new FrameLayout.LayoutParams(-1, -2, 16);
          ((FrameLayout.LayoutParams)localObject2).rightMargin = ViewUtils.dip2px(16.0F);
          ((FrameLayout)localObject1).addView(this.b, (ViewGroup.LayoutParams)localObject2);
          localObject2 = new ImageView(this.d.s);
          ((ImageView)localObject2).setImageResource(2130840437);
          ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(ViewUtils.dip2px(8.0F), ViewUtils.dip2px(14.0F), 21));
          return localObject1;
        }
      }
    }
    return this.b;
  }
  
  boolean a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      if (paramAbsStructMsg != null)
      {
        int i = 0;
        while (i < paramAbsStructMsg.size())
        {
          AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)paramAbsStructMsg.get(i);
          if ((localAbsStructMsgElement instanceof StructMsgItemLayout2))
          {
            paramAbsStructMsg = (StructMsgItemLayout2)localAbsStructMsgElement;
            return (paramAbsStructMsg.au != 1) && (paramAbsStructMsg.au != 3);
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  void b()
  {
    if (this.d.am != null)
    {
      if (this.b == null) {
        return;
      }
      if ((this.d.am instanceof StructMsgForImageShare))
      {
        QLog.w("ForwardOption.ForwardSdkBaseOption", 1, "updateStructView|StructMsgForImageShare not supported！");
        return;
      }
      if ((this.d.am instanceof StructMsgForAudioShare))
      {
        this.d.am.getPreDialogView(this.a, this.b);
        return;
      }
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("pre_dialog", true);
      int i = 0;
      Object localObject2 = new ArrayList(1);
      Iterator localIterator = this.d.am.getStructMsgItemLists().iterator();
      while (localIterator.hasNext())
      {
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)localIterator.next();
        View localView1 = (View)this.c.get(localAbsStructMsgElement);
        View localView2 = localAbsStructMsgElement.a(this.a, localView1, (Bundle)localObject1);
        if ((localView2 != null) && ((localAbsStructMsgElement instanceof StructMsgItemLayout2)))
        {
          TextView localTextView = (TextView)localView2.findViewById(2131448814);
          if (localTextView != null)
          {
            localTextView.setGravity(16);
            localTextView.setMaxLines(2);
            localTextView.setTextSize(14.0F);
            localTextView.setTextColor(this.a.getResources().getColor(2131166120));
          }
        }
        if ((localView2 != null) && (localView2 != localView1))
        {
          this.c.put(localAbsStructMsgElement, localView2);
          ((List)localObject2).add(localView2);
          i = 1;
        }
      }
      if (i != 0)
      {
        ((ViewGroup)this.b).removeAllViewsInLayout();
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (View)((Iterator)localObject1).next();
          ((ViewGroup)this.b).addView((View)localObject2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.PreStructViewHolder
 * JD-Core Version:    0.7.0.1
 */