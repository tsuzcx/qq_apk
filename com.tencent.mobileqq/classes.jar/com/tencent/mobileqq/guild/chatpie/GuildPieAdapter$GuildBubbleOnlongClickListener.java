package com.tencent.mobileqq.guild.chatpie;

import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.ChatAdapter1.BubbleOnlongClickListener;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.guild.chatpie.helper.GuildMsgMenuHelper;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.qphone.base.util.QLog;

public class GuildPieAdapter$GuildBubbleOnlongClickListener
  extends ChatAdapter1.BubbleOnlongClickListener
{
  public GuildPieAdapter$GuildBubbleOnlongClickListener(GuildPieAdapter paramGuildPieAdapter)
  {
    super(paramGuildPieAdapter);
  }
  
  private boolean a(View paramView, ChatMessage paramChatMessage)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("chatAdapter onLongClick message msgUid = ");
      localStringBuilder.append(paramChatMessage.msgUid);
      localStringBuilder.append(", time = ");
      localStringBuilder.append(paramChatMessage.time);
      localStringBuilder.append(", msgtype = ");
      localStringBuilder.append(paramChatMessage.msgtype);
      QLog.d("GuildPieAdapter", 2, localStringBuilder.toString());
    }
    paramView = a(paramChatMessage, this.j).a(paramView);
    int i = 0;
    if (paramView != null)
    {
      if (paramView.length == 0) {
        return false;
      }
      int k = paramView.length;
      while (i < k)
      {
        localQQCustomMenu.a(paramView[i]);
        i += 1;
      }
      ((GuildMsgMenuHelper)GuildPieAdapter.b(this.j).bv().a(156)).a(localQQCustomMenu, paramChatMessage);
      com.tencent.mobileqq.utils.BubbleContextMenu.a = true;
      return true;
    }
    return false;
  }
  
  public ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return this.j.r.a(paramChatMessage, this.j);
  }
  
  public boolean onLongClick(View paramView)
  {
    boolean bool2 = ((GuildChatContext)GuildPieAdapter.a(this.j).bv()).Y();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if ((paramView instanceof AnimationTextView)) {
      ((AnimationTextView)paramView).setTag(2131435345, Boolean.valueOf(true));
    }
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onLongClick(paramView);
    }
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if ((localChatMessage instanceof MessageForFile)) {
      return false;
    }
    if (localChatMessage == null) {
      return false;
    }
    if (localChatMessage.isMultiMsg) {
      bool1 = MultiMsgUtil.c(localChatMessage) ^ true;
    }
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildPieAdapter", 2, "onLongClick() called with: return 1");
      }
      return true;
    }
    return a(paramView, localChatMessage);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject = a(AIOUtils.a(paramView), this.j);
    if ((paramView instanceof ArkAppView)) {
      ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
    }
    if ((localObject instanceof BaseGuildMsgViewBuild))
    {
      localObject = ((BaseGuildMsgViewBuild)localObject).c(paramView);
      if (localObject != null) {
        ((BaseBubbleBuilder.TouchDelegate)localObject).a(paramView, paramMotionEvent);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildPieAdapter.GuildBubbleOnlongClickListener
 * JD-Core Version:    0.7.0.1
 */