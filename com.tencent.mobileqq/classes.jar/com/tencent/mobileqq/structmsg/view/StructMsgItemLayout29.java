package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class StructMsgItemLayout29
  extends AbsStructMsgItem
{
  private void a(Context paramContext, RelativeLayout paramRelativeLayout, Resources paramResources, StructMsgItemLayout29.ViewHolder paramViewHolder)
  {
    paramContext = new ImageView(paramContext);
    paramContext.setImageResource(2130850767);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(10);
    localLayoutParams.addRule(9);
    localLayoutParams.leftMargin = AIOUtils.b(239.0F, paramResources);
    localLayoutParams.topMargin = AIOUtils.b(10.0F, paramResources);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView = paramContext;
    paramContext.setVisibility(4);
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  private void b(Context paramContext, RelativeLayout paramRelativeLayout, Resources paramResources, StructMsgItemLayout29.ViewHolder paramViewHolder)
  {
    paramContext = new TextView(paramContext);
    paramContext.setId(2131376157);
    paramContext.setTextColor(Color.parseColor("#777777"));
    paramContext.setTextSize(1, 14.0F);
    paramContext.setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, AIOUtils.b(25.0F, paramResources));
    localLayoutParams.topMargin = AIOUtils.b(83.0F, paramResources);
    localLayoutParams.leftMargin = AIOUtils.b(30.0F, paramResources);
    paramViewHolder.b = paramContext;
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  private void c(Context paramContext, RelativeLayout paramRelativeLayout, Resources paramResources, StructMsgItemLayout29.ViewHolder paramViewHolder)
  {
    paramContext = new TextView(paramContext);
    paramContext.setId(2131376158);
    paramContext.setText(2131698562);
    paramContext.setTextSize(1, 22.0F);
    paramContext.setTextColor(-1);
    paramContext.setGravity(16);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, AIOUtils.b(75.0F, paramResources));
    localLayoutParams.leftMargin = AIOUtils.b(60.0F, paramResources);
    localLayoutParams.topMargin = AIOUtils.b(8.0F, paramResources);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView = paramContext;
    paramRelativeLayout.addView(paramContext, localLayoutParams);
  }
  
  protected int b()
  {
    return 29;
  }
  
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    ReceiptMsgManager localReceiptMsgManager = ReceiptMsgManager.a();
    Resources localResources = paramContext.getResources();
    int i;
    if (paramView == null)
    {
      paramBundle = new RelativeLayout(paramContext);
      paramView = new StructMsgItemLayout29.ViewHolder(null);
      paramBundle.setTag(-1, paramView);
      paramBundle.setId(2131376156);
      paramView.jdField_a_of_type_AndroidViewView = paramBundle;
      c(paramContext, paramBundle, localResources, paramView);
      b(paramContext, paramBundle, localResources, paramView);
      a(paramContext, paramBundle, localResources, paramView);
      i = 1;
      paramContext = paramBundle;
    }
    else
    {
      paramContext = (RelativeLayout)paramView;
      paramView = (StructMsgItemLayout29.ViewHolder)paramContext.getTag(-1);
      i = 0;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg != null) && (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message != null))
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.isSend();
      paramBundle = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      label145:
      AbsStructMsgElement localAbsStructMsgElement;
      for (int j = 0; paramBundle.hasNext(); j = ((StructMsgItemType)localAbsStructMsgElement).o)
      {
        localAbsStructMsgElement = (AbsStructMsgElement)paramBundle.next();
        if ((!"type".equals(localAbsStructMsgElement.a)) || (!(localAbsStructMsgElement instanceof StructMsgItemType))) {
          break label145;
        }
      }
      if ((bool != paramView.jdField_a_of_type_Boolean) || (j != paramView.jdField_a_of_type_Int) || (i != 0))
      {
        paramContext.setBackgroundDrawable(new BitmapDrawable(localResources, localReceiptMsgManager.a(localResources, bool, j)));
        paramView.jdField_a_of_type_Boolean = bool;
        paramView.jdField_a_of_type_Int = j;
      }
      if (bool)
      {
        paramView.b.setText(2131698561);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      else if ("1".equals(ReceiptMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message)))
      {
        paramView.b.setText(2131698559);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      }
      else
      {
        paramView.b.setText(2131698560);
        paramView.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      if ((!bool) && (BaseApplicationImpl.sProcessId == 1))
      {
        paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        ReceiptMsgManager.a().a(paramView, this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message);
      }
      return paramContext;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructMsgItemLayout29", 2, "getView but parentMsg or message is null");
    }
    if (QLog.isDebugVersion())
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
      if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) {
        paramContext = "-";
      } else {
        paramContext = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
      }
      throw new IllegalStateException(String.format("getView but parentMsg or message is null, %s / %s", new Object[] { paramView, paramContext }));
    }
    return paramContext;
  }
  
  public String b()
  {
    return "layout29";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout29
 * JD-Core Version:    0.7.0.1
 */