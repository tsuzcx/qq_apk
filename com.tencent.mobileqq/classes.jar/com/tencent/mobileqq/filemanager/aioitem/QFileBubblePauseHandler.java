package com.tencent.mobileqq.filemanager.aioitem;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;

public abstract class QFileBubblePauseHandler
{
  protected Context a;
  protected View.OnClickListener a;
  protected QQAppInterface a;
  protected ActionSheet a;
  
  public QFileBubblePauseHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QFileBubblePauseHandler.1(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(BaseBubbleBuilder.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    paramViewHolder = a(paramViewHolder);
    if (paramBoolean) {
      if (paramViewHolder != null)
      {
        paramViewHolder.setVisibility(0);
        paramViewHolder.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      }
    }
    while (paramViewHolder == null) {
      return;
    }
    paramViewHolder.setVisibility(8);
    paramViewHolder.setOnClickListener(null);
  }
  
  protected abstract ImageView a(BaseBubbleBuilder.ViewHolder paramViewHolder);
  
  protected void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      ActionSheetHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetActionSheet);
    }
  }
  
  protected void a(View paramView, BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage, int paramInt) {}
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      paramChatMessage = a(paramViewHolder);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838392);
        paramChatMessage.setId(2131364653);
        a(paramViewHolder, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364634);
        localLayoutParams.addRule(0, 2131364634);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramViewHolder, true);
        return;
        paramChatMessage.setImageResource(2130838392);
      }
    }
    if (b(paramChatMessage))
    {
      paramChatMessage = a(paramViewHolder);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        paramChatMessage.setImageResource(2130838387);
        paramChatMessage.setId(2131364653);
        a(paramViewHolder, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams.addRule(8, 2131364634);
        localLayoutParams.addRule(0, 2131364634);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      for (;;)
      {
        a(paramViewHolder, true);
        return;
        paramChatMessage.setImageResource(2130838387);
      }
    }
    a(paramViewHolder, false);
  }
  
  protected abstract void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ImageView paramImageView);
  
  protected void a(ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ActionMenuItem(0, ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, 2131718558), 0, 0, 2));
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, localArrayList, paramOnButtonClickListener);
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet != null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690800);
      ActionSheetHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetActionSheet);
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    return false;
  }
  
  protected boolean b(ChatMessage paramChatMessage)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.QFileBubblePauseHandler
 * JD-Core Version:    0.7.0.1
 */