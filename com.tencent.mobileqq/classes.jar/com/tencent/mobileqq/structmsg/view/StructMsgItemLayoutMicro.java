package com.tencent.mobileqq.structmsg.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;

public class StructMsgItemLayoutMicro
  extends AbsStructMsgItem
{
  protected boolean a;
  
  protected int b()
  {
    return 2;
  }
  
  @TargetApi(16)
  public View b(Context paramContext, View paramView, Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = paramBundle.getBoolean("pre_dialog", false);
    Resources localResources = paramContext.getResources();
    AbsShareMsg localAbsShareMsg = (AbsShareMsg)this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
    int i = AIOUtils.b(10.0F, localResources);
    Object localObject1;
    if (paramView == null)
    {
      localObject1 = new LinearLayout(paramContext);
      ((LinearLayout)localObject1).setOrientation(1);
      paramBundle = new StructMsgItemLayoutMicro.MiniAppMsgViewHolder(null);
      ((LinearLayout)localObject1).setTag(2131374849, paramBundle);
      paramView = ((LinearLayout)localObject1).getLayoutParams();
      if (paramView == null)
      {
        paramView = new LinearLayout.LayoutParams(-1, -2);
      }
      else
      {
        paramView.width = -1;
        paramView.height = -2;
      }
      ((LinearLayout)localObject1).setLayoutParams(paramView);
      paramView = new TextView(paramContext);
      paramView.setSingleLine(true);
      paramView.setCompoundDrawablePadding(i);
      paramView.setGravity(16);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-16777216);
      paramView.setTextSize(2, 16.0F);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      paramView.setPadding(i, i, i, i);
      ((LinearLayout)localObject1).addView(paramView);
      TextView localTextView = new TextView(paramContext);
      localTextView.setTextColor(-16777216);
      localTextView.setMaxLines(2);
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
      localTextView.setTextSize(2, 12.0F);
      localTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      localTextView.setPadding(i, 0, i, i);
      ((LinearLayout)localObject1).addView(localTextView);
      ImageView localImageView = new ImageView(paramContext);
      int j = BaseChatItemLayout.B;
      double d = BaseChatItemLayout.f;
      Double.isNaN(d);
      Object localObject2 = new LinearLayout.LayoutParams(j, (int)(d * 0.468D));
      ((LinearLayout.LayoutParams)localObject2).gravity = 1;
      localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((LinearLayout)localObject1).addView(localImageView);
      paramContext = new TextView(paramContext);
      paramContext.setTextColor(-7829368);
      paramContext.setTextSize(2, 12.0F);
      paramContext.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      paramContext.setCompoundDrawablePadding(AIOUtils.b(5.0F, localResources));
      localObject2 = localResources.getDrawable(2130847568);
      ((Drawable)localObject2).setBounds(0, 0, AIOUtils.b(18.0F, localResources), AIOUtils.b(10.0F, localResources));
      paramContext.setCompoundDrawables((Drawable)localObject2, null, null, null);
      paramContext.setPadding(i, i, i, i);
      ((LinearLayout)localObject1).addView(paramContext);
      paramBundle.jdField_a_of_type_AndroidWidgetTextView = paramView;
      paramBundle.b = localTextView;
      paramBundle.jdField_a_of_type_AndroidWidgetImageView = localImageView;
      paramBundle.c = paramContext;
      paramBundle.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localObject1);
      paramContext = (Context)localObject1;
      paramView = paramBundle;
    }
    else
    {
      paramContext = (LinearLayout)paramView;
      paramView = (StructMsgItemLayoutMicro.MiniAppMsgViewHolder)paramContext.getTag(2131374849);
    }
    if (this.jdField_a_of_type_Boolean) {
      paramContext.setPadding(i, i, i, i);
    } else {
      paramContext.setPadding(0, 0, 0, 0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructMsgItemLayoutMicro", 2, "getView but parentMsg or message is null");
      }
      return paramContext;
    }
    i = AIOUtils.b(24.0F, localResources);
    try
    {
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mRequestWidth = i;
      paramBundle.mRequestHeight = i;
      paramBundle = URLDrawable.getDrawable(localAbsShareMsg.mContentCover, paramBundle);
      paramBundle.setDecodeHandler(URLDrawableDecodeHandler.a);
      paramBundle.setBounds(0, 0, i, i);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(paramBundle, null, null, null);
    }
    catch (Throwable paramBundle)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getTitleView fail e=");
        ((StringBuilder)localObject1).append(paramBundle.getMessage());
        QLog.d("StructMsgItemLayoutMicro", 2, ((StringBuilder)localObject1).toString());
      }
    }
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(localAbsShareMsg.mContentTitle);
    paramView.b.setText(localAbsShareMsg.mContentSummary);
    paramView.c.setText(HardCodeUtil.a(2131714411));
    if (!TextUtils.isEmpty(localAbsShareMsg.mMsg_I_ActionData)) {}
    try
    {
      paramBundle = URLDrawable.getDrawable(localAbsShareMsg.mMsg_I_ActionData, null);
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      return paramContext;
    }
    catch (IllegalArgumentException paramView)
    {
      label725:
      break label725;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("StructMsgItemLayoutMicro", 2, "getView fail");
      return paramContext;
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    return paramContext;
  }
  
  public String b()
  {
    return "layoutMicro";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutMicro
 * JD-Core Version:    0.7.0.1
 */