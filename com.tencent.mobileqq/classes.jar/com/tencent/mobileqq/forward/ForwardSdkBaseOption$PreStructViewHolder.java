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
    if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg instanceof StructMsgForAudioShare)) {
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getPreDialogView(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidViewView);
    }
    do
    {
      return this.jdField_a_of_type_AndroidViewView;
      localObject1 = new HeightLimitedLinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((HeightLimitedLinearLayout)localObject1).setOrientation(1);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject2).gravity = 1;
      ((HeightLimitedLinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((HeightLimitedLinearLayout)localObject1).setMaxHeight(this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels >> 1);
      this.jdField_a_of_type_AndroidViewView = ((View)localObject1);
      a();
    } while ((!a(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg)) || (this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.mMsgUrl == null) || ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption instanceof ForwardQZoneRichImageOption)));
    this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.b = 8;
    Object localObject1 = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new View(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidAppActivity);
    ((View)localObject2).setBackgroundResource(2130840284);
    ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, ViewUtils.a(33.0F), 16));
    ((View)localObject2).setOnClickListener(new ForwardSdkBaseOption.PreStructViewHolder.1(this));
    ((View)localObject2).setContentDescription(HardCodeUtil.a(2131704851));
    localObject2 = new FrameLayout.LayoutParams(-1, -2, 16);
    ((FrameLayout.LayoutParams)localObject2).rightMargin = ViewUtils.a(16.0F);
    ((FrameLayout)localObject1).addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_AndroidAppActivity);
    ((ImageView)localObject2).setImageResource(2130840274);
    ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(ViewUtils.a(8.0F), ViewUtils.a(14.0F), 21));
    return localObject1;
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg == null) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    label325:
    label326:
    for (;;)
    {
      return;
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
      Object localObject2 = new ArrayList(1);
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqForwardForwardSdkBaseOption.jdField_a_of_type_ComTencentMobileqqStructmsgAbsShareMsg.getStructMsgItemLists().iterator();
      int i = 0;
      label116:
      if (localIterator.hasNext())
      {
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)localIterator.next();
        View localView1 = (View)this.jdField_a_of_type_JavaUtilHashMap.get(localAbsStructMsgElement);
        View localView2 = localAbsStructMsgElement.a(this.jdField_a_of_type_AndroidContentContext, localView1, (Bundle)localObject1);
        if ((localView2 != null) && ((localAbsStructMsgElement instanceof StructMsgItemLayout2)))
        {
          TextView localTextView = (TextView)localView2.findViewById(2131380651);
          if (localTextView != null)
          {
            localTextView.setGravity(16);
            localTextView.setMaxLines(2);
            localTextView.setTextSize(14.0F);
            localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165676));
          }
        }
        if ((localView2 == null) || (localView2 == localView1)) {
          break label325;
        }
        this.jdField_a_of_type_JavaUtilHashMap.put(localAbsStructMsgElement, localView2);
        ((List)localObject2).add(localView2);
        i = 1;
      }
      for (;;)
      {
        break label116;
        if (i == 0) {
          break label326;
        }
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeAllViewsInLayout();
        localObject1 = ((List)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (View)((Iterator)localObject1).next();
          ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView((View)localObject2);
        }
        break;
      }
    }
  }
  
  boolean a(AbsStructMsg paramAbsStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      bool1 = bool2;
      if (paramAbsStructMsg != null) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramAbsStructMsg.size())
      {
        AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)paramAbsStructMsg.get(i);
        if (!(localAbsStructMsgElement instanceof StructMsgItemLayout2)) {
          break label95;
        }
        paramAbsStructMsg = (StructMsgItemLayout2)localAbsStructMsgElement;
        bool1 = bool2;
        if (paramAbsStructMsg.o != 1)
        {
          bool1 = bool2;
          if (paramAbsStructMsg.o != 3) {
            bool1 = true;
          }
        }
      }
      return bool1;
      label95:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardSdkBaseOption.PreStructViewHolder
 * JD-Core Version:    0.7.0.1
 */