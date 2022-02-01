package com.tencent.mobileqq.guild.chatpie;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.guild.chatpie.helper.AIOGuildDTReportHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildAIOMultiActionHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildAIOUnreadHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildAppAuthorHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildAtHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildChatPieFoldStatusListenerHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildDraftHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildDrawerFrameHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildEventFlowHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildFocusChannelHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildGestureListenerHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildGuestHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildInputBarHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildMsgMenuHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildOneClickJumpHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildRedPointHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildReplyHelper;
import com.tencent.mobileqq.guild.chatpie.helper.GuildTitleBarHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuildHelperProvider
  extends HelperProvider
{
  private final String a = "GuildHelperProvider";
  private final List<GuildChatPieFoldStatusListener> b = new ArrayList();
  
  public GuildHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a(101, new AIOGuildDTReportHelper(paramBaseChatPie));
    a(147, new GuildAIOMultiActionHelper(paramBaseChatPie));
    a(111, new GuildDraftHelper(paramBaseChatPie));
    a(148, new GuildGestureListenerHelper(paramBaseChatPie));
    a(152, new GuildChatPieFoldStatusListenerHelper(paramBaseChatPie));
    a(155, new GuildDrawerFrameHelper(paramBaseChatPie));
    a(157, new GuildAIOUnreadHelper(paramBaseChatPie));
    a((GuildChatContext)paramBaseChatPie.bv());
  }
  
  protected void a(GuildChatContext paramGuildChatContext)
  {
    a(119, new GuildReplyHelper(paramGuildChatContext));
    a(142, new GuildRedPointHelper(paramGuildChatContext));
    a(143, new GuildTitleBarHelper(paramGuildChatContext));
    a(144, new GuildAtHelper(paramGuildChatContext));
    a(145, new GuildInputBarHelper(paramGuildChatContext));
    a(154, new GuildAppAuthorHelper(paramGuildChatContext));
    a(149, new GuildFocusChannelHelper(paramGuildChatContext));
    a(150, new GuildOneClickJumpHelper(paramGuildChatContext));
    a(151, new GuildEventFlowHelper(paramGuildChatContext));
    a(153, new GuildGuestHelper(paramGuildChatContext));
    a(156, new GuildMsgMenuHelper(paramGuildChatContext));
  }
  
  public void a(GuildChatPieFoldStatusListener paramGuildChatPieFoldStatusListener)
  {
    if (!this.b.contains(paramGuildChatPieFoldStatusListener)) {
      this.b.add(paramGuildChatPieFoldStatusListener);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFoldStatus isOpen:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" fromToEndDirType:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" sourceType:");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.i("GuildHelperProvider", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((GuildChatPieFoldStatusListener)((Iterator)localObject).next()).a(paramBoolean, paramInt1, paramInt2);
    }
  }
  
  public void b(GuildChatPieFoldStatusListener paramGuildChatPieFoldStatusListener)
  {
    this.b.remove(paramGuildChatPieFoldStatusListener);
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInterceptFoldGesture isOpen:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("GuildHelperProvider", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((GuildChatPieFoldStatusListener)((Iterator)localObject).next()).a(paramBoolean)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean f(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onInterceptFoldEvent type:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("GuildHelperProvider", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((GuildChatPieFoldStatusListener)((Iterator)localObject).next()).a(paramInt)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildHelperProvider
 * JD-Core Version:    0.7.0.1
 */