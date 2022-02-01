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
  Context jdField_a_of_type_AndroidContentContext;
  View jdField_a_of_type_AndroidViewView;
  HashMap<AbsStructMsgElement, View> jdField_a_of_type_JavaUtilHashMap = new HashMap(1);
  
  ForwardSdkBaseOption$PreStructViewHolder(ForwardSdkBaseOption paramForwardSdkBaseOption, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  View a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare)) {
      return this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidContentContext, null);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare))
    {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView);
    }
    else
    {
      Object localObject1 = new HeightLimitedLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((HeightLimitedLinearLayout)localObject1).setOrientation(1);
      Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 1;
      ((HeightLimitedLinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((HeightLimitedLinearLayout)localObject1).setMaxHeight(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels >> 1);
      this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      a();
      if ((a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg)) && (this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl != null))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption;
        if (!(localObject1 instanceof ForwardQZoneRichImageOption))
        {
          ((ForwardSdkBaseOption)localObject1).b = 8;
          localObject1 = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new View(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidAppActivity);
          ((View)localObject2).setBackgroundResource(2130840143);
          ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, ViewUtils.a(33.0F), 16));
          ((View)localObject2).setOnClickListener(new ForwardSdkBaseOption.PreStructViewHolder.1(this));
          ((View)localObject2).setContentDescription(HardCodeUtil.a(2131704927));
          localObject2 = new FrameLayout.LayoutParams(-1, -2, 16);
          ((FrameLayout.LayoutParams)localObject2).rightMargin = ViewUtils.a(16.0F);
          ((FrameLayout)localObject1).addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject2);
          localObject2 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidAppActivity);
          ((ImageView)localObject2).setImageResource(2130840133);
          ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(ViewUtils.a(8.0F), ViewUtils.a(14.0F), 21));
          return localObject1;
        }
      }
    }
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg != null)
    {
      if (this.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForImageShare))
      {
        QLog.w("ForwardOption.ForwardSdkBaseOption", 1, "updateStructView|StructMsgForImageShare not supported！");
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare))
      {
        this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView);
        return;
      }
      Object localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("pre_dialog", true);
      int i = 0;
      Object localObject2 = new ArrayList(1);
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getStructMsgItemLists().iterator();
      while (localIterator.hasNext())
      {
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)localIterator.next();
        View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(localAbsStructMsgElement);
        View localView2 = localAbsStructMsgElement.a(this.jdField_a_of_type_AndroidContentContext, localView1, (Bundle)localObject1);
        if ((localView2 != null) && ((localAbsStructMsgElement instanceof StructMsgItemLayout2)))
        {
          TextView localTextView = (TextView)localView2.findViewById(2131379930);
          if (localTextView != null)
          {
            localTextView.setGravity(16);
            localTextView.setMaxLines(2);
            localTextView.setTextSize(14.0F);
            localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165660));
          }
        }
        if ((localView2 != null) && (localView2 != localView1))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localAbsStructMsgElement, localView2);
          ((List)localObject2).add(localView2);
          i = 1;
        }
      }
      if (i != 0)
      {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeAllViewsInLayout();
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (View)((Iterator)localObject1).next();
          ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView((View)localObject2);
        }
      }
    }
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
            return (paramAbsStructMsg.o != 1) && (paramAbsStructMsg.o != 3);
          }
          i += 1;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.PreStructViewHolder
 * JD-Core Version:    0.7.0.1
 */