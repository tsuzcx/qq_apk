package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild.ViewHolder;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;

public abstract class GuildFileBaseBubblePauseHandler
{
  protected Context a;
  protected QQAppInterface b;
  protected ActionSheet c;
  protected View.OnClickListener d = new GuildFileBaseBubblePauseHandler.1(this);
  
  public GuildFileBaseBubblePauseHandler(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.b = paramQQAppInterface;
    this.a = paramContext;
  }
  
  private void a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView)
  {
    ImageView localImageView = a(paramViewHolder);
    if (localImageView == null)
    {
      localImageView = new ImageView(this.a);
      localImageView.setImageResource(2130838287);
      localImageView.setId(2131430598);
      a(paramViewHolder, localImageView);
      int i = AIOUtils.b(16.0F, paramView.getResources());
      paramViewHolder = new RelativeLayout.LayoutParams(i, i);
      paramViewHolder.addRule(5, 2131430578);
      paramViewHolder.addRule(3, 2131430578);
      paramViewHolder.bottomMargin = AIOUtils.b(8.666666F, paramView.getResources());
      if ((paramView instanceof ViewGroup)) {
        ((ViewGroup)paramView).addView(localImageView, paramViewHolder);
      }
    }
    else
    {
      localImageView.setImageResource(2130838287);
    }
  }
  
  private void a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder, boolean paramBoolean)
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
  
  private void b(BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView)
  {
    ImageView localImageView = a(paramViewHolder);
    if (localImageView == null)
    {
      localImageView = new ImageView(this.a);
      localImageView.setImageResource(2130838271);
      localImageView.setId(2131430598);
      a(paramViewHolder, localImageView);
      int i = AIOUtils.b(16.0F, paramView.getResources());
      paramViewHolder = new RelativeLayout.LayoutParams(i, i);
      paramViewHolder.addRule(5, 2131430578);
      paramViewHolder.addRule(3, 2131430578);
      paramViewHolder.bottomMargin = AIOUtils.b(8.666666F, paramView.getResources());
      if ((paramView instanceof ViewGroup)) {
        ((ViewGroup)paramView).addView(localImageView, paramViewHolder);
      }
    }
    else
    {
      localImageView.setImageResource(2130838271);
    }
  }
  
  protected abstract ImageView a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder);
  
  protected void a()
  {
    ActionSheet localActionSheet = this.c;
    if ((localActionSheet != null) && (localActionSheet.isShowing())) {
      ActionSheetHelper.b((Activity)this.a, this.c);
    }
  }
  
  protected void a(View paramView, ChatItemBuilder.BaseHolder paramBaseHolder, ChatMessage paramChatMessage, int paramInt) {}
  
  public void a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage)
  {
    if (a(paramChatMessage))
    {
      a(paramViewHolder, paramView);
      a(paramViewHolder, true);
      return;
    }
    if (b(paramChatMessage))
    {
      b(paramViewHolder, paramView);
      a(paramViewHolder, true);
      return;
    }
    a(paramViewHolder, false);
  }
  
  protected abstract void a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder, ImageView paramImageView);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildFileBaseBubblePauseHandler
 * JD-Core Version:    0.7.0.1
 */