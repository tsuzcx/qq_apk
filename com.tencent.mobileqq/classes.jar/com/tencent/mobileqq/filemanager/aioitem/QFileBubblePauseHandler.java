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
  protected QQAppInterface b;
  protected ActionSheet c;
  protected View.OnClickListener d = new QFileBubblePauseHandler.1(this);
  
  public QFileBubblePauseHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.a = paramContext;
    this.b = paramQQAppInterface;
  }
  
  private void a(BaseBubbleBuilder.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    paramViewHolder = a(paramViewHolder);
    if (paramBoolean)
    {
      if (paramViewHolder != null)
      {
        paramViewHolder.setVisibility(0);
        paramViewHolder.setOnClickListener(this.d);
      }
    }
    else if (paramViewHolder != null)
    {
      paramViewHolder.setVisibility(8);
      paramViewHolder.setOnClickListener(null);
    }
  }
  
  protected abstract ImageView a(BaseBubbleBuilder.ViewHolder paramViewHolder);
  
  protected void a()
  {
    ActionSheet localActionSheet = this.c;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      ActionSheetHelper.b((Activity)this.a, this.c);
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
        paramChatMessage = new ImageView(this.a);
        paramChatMessage.setImageResource(2130838287);
        paramChatMessage.setId(2131430598);
        a(paramViewHolder, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.b(16.0F, this.a.getResources());
        localLayoutParams.addRule(8, 2131430578);
        localLayoutParams.addRule(0, 2131430578);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      else
      {
        paramChatMessage.setImageResource(2130838287);
      }
      a(paramViewHolder, true);
      return;
    }
    if (b(paramChatMessage))
    {
      paramChatMessage = a(paramViewHolder);
      if (paramChatMessage == null)
      {
        paramChatMessage = new ImageView(this.a);
        paramChatMessage.setImageResource(2130838271);
        paramChatMessage.setId(2131430598);
        a(paramViewHolder, paramChatMessage);
        localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        localLayoutParams.bottomMargin = AIOUtils.b(16.0F, this.a.getResources());
        localLayoutParams.addRule(8, 2131430578);
        localLayoutParams.addRule(0, 2131430578);
        localLayoutParams.addRule(1, 0);
        if ((paramView instanceof ViewGroup)) {
          ((ViewGroup)paramView).addView(paramChatMessage, localLayoutParams);
        }
      }
      else
      {
        paramChatMessage.setImageResource(2130838271);
      }
      a(paramViewHolder, true);
      return;
    }
    a(paramViewHolder, false);
  }
  
  protected abstract void a(BaseBubbleBuilder.ViewHolder paramViewHolder, ImageView paramImageView);
  
  protected void a(ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ActionMenuItem(0, ActionSheetHelper.a(this.a, 2131915708), 0, 0, 2));
    this.c = ActionSheetHelper.b(this.a, localArrayList, paramOnButtonClickListener);
    paramOnButtonClickListener = this.c;
    if (paramOnButtonClickListener != null)
    {
      paramOnButtonClickListener.addCancelButton(2131887648);
      ActionSheetHelper.a((Activity)this.a, this.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.aioitem.QFileBubblePauseHandler
 * JD-Core Version:    0.7.0.1
 */