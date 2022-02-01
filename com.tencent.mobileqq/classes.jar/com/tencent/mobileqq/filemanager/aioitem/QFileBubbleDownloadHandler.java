package com.tencent.mobileqq.filemanager.aioitem;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.CircleFileStateView;

public abstract class QFileBubbleDownloadHandler
{
  protected Context a;
  protected View.OnClickListener a;
  protected QQAppInterface a;
  protected QFileBubbleDownloadHandler.OnDownloadIconClickListener a;
  
  public QFileBubbleDownloadHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new QFileBubbleDownloadHandler.1(this);
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
  
  protected abstract CircleFileStateView a(BaseBubbleBuilder.ViewHolder paramViewHolder);
  
  protected void a(View paramView, BaseBubbleBuilder.ViewHolder paramViewHolder, ChatMessage paramChatMessage, int paramInt) {}
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage)
  {
    a(paramViewHolder, false);
    CircleFileStateView localCircleFileStateView;
    int i;
    RelativeLayout.LayoutParams localLayoutParams;
    if (a(paramChatMessage))
    {
      localObject = a(paramViewHolder);
      if (localObject == null)
      {
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
        localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
        localCircleFileStateView.setState(2);
        localCircleFileStateView.setId(2131364638);
        localCircleFileStateView.setProgressRingWidth(0.0F);
        localCircleFileStateView.setCenterBgColor(-1);
        a(paramViewHolder, localCircleFileStateView);
        i = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(i, i);
        localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296402);
        localLayoutParams.addRule(8, 2131364634);
        if (paramChatMessage.isSend())
        {
          localLayoutParams.addRule(0, 2131364634);
          localLayoutParams.addRule(1, 0);
          if ((paramView instanceof ViewGroup)) {
            ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
          }
          a(paramViewHolder, true);
        }
      }
    }
    while (!b(paramChatMessage))
    {
      for (;;)
      {
        return;
        localLayoutParams.addRule(1, 2131364634);
        localLayoutParams.addRule(0, 0);
      }
      ((CircleFileStateView)localObject).setState(2);
      paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
      if (paramView == null)
      {
        i = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        paramView = new RelativeLayout.LayoutParams(i, i);
        if (paramChatMessage.isSend())
        {
          paramView.addRule(0, 2131364634);
          paramView.addRule(1, 0);
        }
        for (;;)
        {
          ((CircleFileStateView)localObject).setLayoutParams(paramView);
          break;
          paramView.addRule(1, 2131364634);
          paramView.addRule(0, 0);
        }
      }
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364634);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364634);
        paramView.addRule(0, 0);
      }
    }
    Object localObject = a(paramViewHolder);
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources();
      localCircleFileStateView = new CircleFileStateView(this.jdField_a_of_type_AndroidContentContext);
      localCircleFileStateView.setState(1);
      localCircleFileStateView.setId(2131364638);
      localCircleFileStateView.setCenterBgColor(-1);
      a(paramViewHolder, localCircleFileStateView);
      localCircleFileStateView.setProgressRingWidth(0.0F);
      i = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      localLayoutParams = new RelativeLayout.LayoutParams(i, i);
      localLayoutParams.bottomMargin = ((Resources)localObject).getDimensionPixelSize(2131296402);
      localLayoutParams.addRule(8, 2131364634);
      if (paramChatMessage.isSend())
      {
        localLayoutParams.addRule(0, 2131364634);
        localLayoutParams.addRule(1, 0);
      }
      for (;;)
      {
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(localCircleFileStateView, localLayoutParams);
        }
        a(paramViewHolder, true);
        return;
        localLayoutParams.addRule(1, 2131364634);
        localLayoutParams.addRule(0, 0);
      }
    }
    ((CircleFileStateView)localObject).setState(1);
    paramView = (RelativeLayout.LayoutParams)((CircleFileStateView)localObject).getLayoutParams();
    if (paramView == null)
    {
      i = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      paramView = new RelativeLayout.LayoutParams(i, i);
      if (paramChatMessage.isSend())
      {
        paramView.addRule(0, 2131364634);
        paramView.addRule(1, 0);
      }
      for (;;)
      {
        ((CircleFileStateView)localObject).setLayoutParams(paramView);
        break;
        paramView.addRule(1, 2131364634);
        paramView.addRule(0, 0);
      }
    }
    if (paramChatMessage.isSend())
    {
      paramView.addRule(0, 2131364634);
      paramView.addRule(1, 0);
    }
    for (;;)
    {
      ((CircleFileStateView)localObject).setLayoutParams(paramView);
      break;
      paramView.addRule(1, 2131364634);
      paramView.addRule(0, 0);
    }
  }
  
  protected abstract void a(BaseBubbleBuilder.ViewHolder paramViewHolder, CircleFileStateView paramCircleFileStateView);
  
  public void a(QFileBubbleDownloadHandler.OnDownloadIconClickListener paramOnDownloadIconClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAioitemQFileBubbleDownloadHandler$OnDownloadIconClickListener = paramOnDownloadIconClickListener;
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
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.QFileBubbleDownloadHandler
 * JD-Core Version:    0.7.0.1
 */