package com.tencent.mobileqq.guild.chatpie;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.BaseQQMessageFacade;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.RefreshMessageContext;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpState;
import com.tencent.mobileqq.activity.aio.oneclickjump.JumpStateMachineController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.ChatXListView.OnLayoutListener;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.BaseGuildMessageManager;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.api.IMessageRecordForGuildWelcome;
import com.tencent.mobileqq.guild.navigatebar.GuildAioTips;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.navigatebar.AioTips;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import mqq.os.MqqHandler;

public class GuildListUI
  extends ListUI
{
  protected boolean a = false;
  ChatXListView.OnLayoutListener k = new GuildListUI.1(this);
  private JumpStateMachineController l;
  private int m = 0;
  
  public GuildListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  private boolean A()
  {
    BaseSessionInfo localBaseSessionInfo = this.b.O();
    boolean bool2 = TextUtils.isEmpty(localBaseSessionInfo.b);
    boolean bool1 = false;
    boolean bool3 = false;
    if (!bool2)
    {
      Object localObject2 = ((IMessageFacadeService)QRoute.api(IMessageFacadeService.class)).getMessageFacade(this.b.a()).a(10014).a(10014);
      Lock localLock = ((BaseMsgProxy)localObject2).a().a(localBaseSessionInfo.b, localBaseSessionInfo.a);
      localLock.lock();
      try
      {
        Object localObject3 = (List)((BaseMsgProxy)localObject2).a().c().get(UinTypeUtil.a(localBaseSessionInfo.b, localBaseSessionInfo.a));
        bool2 = bool1;
        if (localObject3 != null)
        {
          bool2 = bool1;
          if (!((List)localObject3).isEmpty())
          {
            localObject2 = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
            localObject3 = ((List)localObject3).iterator();
            do
            {
              bool1 = bool3;
              if (!((Iterator)localObject3).hasNext()) {
                break;
              }
            } while (((IGuildMessageUtilsApi)localObject2).isLocalOnlyMsg((MessageRecord)((Iterator)localObject3).next()));
            bool1 = true;
            bool2 = bool1;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("hasInvisibleMsgInCache = true, start pulling msg. channelId: ");
              ((StringBuilder)localObject2).append(localBaseSessionInfo.b);
              QLog.i("GuildListUI", 2, ((StringBuilder)localObject2).toString());
              bool2 = bool1;
            }
          }
        }
        return bool2;
      }
      finally
      {
        localLock.unlock();
      }
    }
    return false;
  }
  
  private void B()
  {
    BaseSessionInfo localBaseSessionInfo = this.b.O();
    QQAppInterface localQQAppInterface = this.b.a();
    this.i = SystemClock.uptimeMillis();
    ((ChatContext)this.h.a).a(this.i);
    GuildAioTips localGuildAioTips = (GuildAioTips)this.b.e().d().f();
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (localGuildAioTips != null) {
        bool = localGuildAioTips.g;
      } else {
        bool = false;
      }
      QLog.i("GuildListUI", 2, String.format("onViewCompleteVisableAndReleased mGuildTips=%s valid=%s ", new Object[] { localGuildAioTips, Boolean.valueOf(bool) }));
    }
    if (localGuildAioTips != null)
    {
      if (localGuildAioTips.g)
      {
        this.h.g = true;
        a(localQQAppInterface, localBaseSessionInfo.a).a(localBaseSessionInfo.b, localBaseSessionInfo.a, localGuildAioTips.h, localGuildAioTips.i, localGuildAioTips.j, this.h);
        localGuildAioTips.x();
      }
      else
      {
        this.h.g = false;
        this.h.h = true;
        if (!this.a)
        {
          localQQAppInterface.getMessageFacade().a(localBaseSessionInfo.b, localBaseSessionInfo.a, 30, this.h);
        }
        else
        {
          localQQAppInterface.getMessageFacade().a(localBaseSessionInfo.b, localBaseSessionInfo.a, this.h);
          this.a = false;
        }
      }
    }
    else
    {
      this.h.g = false;
      this.h.h = true;
      if (!this.a)
      {
        localQQAppInterface.getMessageFacade().a(localBaseSessionInfo.b, localBaseSessionInfo.a, 30, this.h);
      }
      else
      {
        localQQAppInterface.getMessageFacade().a(localBaseSessionInfo.b, localBaseSessionInfo.a, this.h);
        this.a = false;
      }
    }
    if ((localBaseSessionInfo.a == 1) && (localQQAppInterface.getTroopMask(localBaseSessionInfo.b) == 3)) {
      ReportController.b(localQQAppInterface, "P_CliOper", "Grp_AIO", "", "AIOchat", "Get_more_history", 0, 0, localBaseSessionInfo.b, "", "", "");
    }
  }
  
  private BaseGuildMessageManager a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return (BaseGuildMessageManager)paramQQAppInterface.getMessageFacade().a(paramInt);
  }
  
  private void a(RefreshMessageContext paramRefreshMessageContext)
  {
    if (paramRefreshMessageContext.g)
    {
      if (paramRefreshMessageContext.i)
      {
        this.b.c(131080);
        return;
      }
      this.b.c(131079);
      return;
    }
    if (paramRefreshMessageContext.k)
    {
      this.b.c(131077);
      paramRefreshMessageContext.k = false;
      return;
    }
    if (((GuildChatContext)this.b).W())
    {
      this.b.c(131077);
      return;
    }
    this.b.c(131076);
  }
  
  private void b(RefreshMessageContext paramRefreshMessageContext)
  {
    if ((this.l.a() == JumpState.JUMP_SUCCESS) && (!paramRefreshMessageContext.g) && (paramRefreshMessageContext.k))
    {
      if (((paramRefreshMessageContext.b == null) || (paramRefreshMessageContext.b.size() == 0)) && (!paramRefreshMessageContext.i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("GuildListUI", 2, "changeStateAfterPullUp, PULL_UP_FAILURE");
        }
        this.l.a(JumpState.PULL_UP_FAILURE);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("GuildListUI", 2, "changeStateAfterPullUp, PULL_UP_SUCCESS");
      }
      this.l.a(JumpState.PULL_UP_SUCCESS);
    }
  }
  
  private boolean b(ChatMessage paramChatMessage)
  {
    return paramChatMessage instanceof IMessageRecordForGuildWelcome;
  }
  
  private void c(RefreshMessageContext paramRefreshMessageContext)
  {
    if ((this.l.a() == JumpState.INACTIVATED) && (paramRefreshMessageContext.g) && (paramRefreshMessageContext.i))
    {
      com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil.c = paramRefreshMessageContext.t;
      if (QLog.isColorLevel()) {
        QLog.d("GuildListUI", 2, "changeStateAfterClickUnreadGuildAIOTip, JUMP_SUCCESS");
      }
      this.l.a(JumpState.JUMP_SUCCESS);
    }
  }
  
  private void d(int paramInt)
  {
    if ((this.g != null) && (this.g.getHeight() != paramInt))
    {
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)this.g.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.g.setLayoutParams(localLayoutParams);
    }
  }
  
  private void y()
  {
    int i = k();
    if (i > 0)
    {
      Object localObject2 = (IGuildMsgSeqTimeService)this.b.a().getRuntimeService(IGuildMsgSeqTimeService.class, "");
      String str = this.b.O().b;
      IGuildMsgSeqTimeService.MsgSeqTimeItem localMsgSeqTimeItem = ((IGuildMsgSeqTimeService)localObject2).getLatestHasSeenMsg(str);
      i -= 1;
      while (i >= 0)
      {
        Object localObject3 = a(i).getTag(2131430591);
        if ((localObject3 instanceof MessageRecord))
        {
          localObject3 = (MessageRecord)localObject3;
          if ((((MessageRecord)localObject3).shmsgseq > 0L) && (!((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).isLocalOnlyMsg((MessageRecord)localObject3)) && ((localMsgSeqTimeItem == null) || (((MessageRecord)localObject3).shmsgseq > localMsgSeqTimeItem.a)))
          {
            localMsgSeqTimeItem = new IGuildMsgSeqTimeService.MsgSeqTimeItem();
            localMsgSeqTimeItem.a = ((MessageRecord)localObject3).shmsgseq;
            localMsgSeqTimeItem.c = ((MessageRecord)localObject3).time;
            localMsgSeqTimeItem.d = ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getMsgMetaFromMr((MessageRecord)localObject3);
            Object localObject1;
            try
            {
              localMsgSeqTimeItem.b = Long.parseLong(((MessageRecord)localObject3).getExtInfoFromExtStr("GUILD_MSG_CNT_NAME"));
            }
            catch (NumberFormatException localNumberFormatException)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("updateLatestVisibleMessage, e = ");
              ((StringBuilder)localObject3).append(localNumberFormatException);
              QLog.d("GuildListUI", 1, ((StringBuilder)localObject3).toString());
              localObject1 = null;
            }
            ((IGuildMsgSeqTimeService)localObject2).setLatestHasSeenMsg(str, (IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("updateLatestVisibleMessage,  lastSeq: ");
            if (localObject1 == null) {
              localObject1 = "null";
            } else {
              localObject1 = ((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject1).toString();
            }
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.d("GuildListUI", 2, ((StringBuilder)localObject2).toString());
            return;
          }
        }
        i -= 1;
      }
    }
  }
  
  private boolean z()
  {
    if (this.f.getCount() > 0)
    {
      AioTips localAioTips = this.b.e().d().f();
      if ((localAioTips != null) && (localAioTips.g) && (this.l.a() == JumpState.INACTIVATED))
      {
        this.i = SystemClock.uptimeMillis();
        ((ChatContext)this.h.a).a(this.i);
        this.h.g = true;
        BaseSessionInfo localBaseSessionInfo = this.b.O();
        this.b.a().getMessageFacade().s().a(localBaseSessionInfo.b, localBaseSessionInfo.a, localAioTips.i, localAioTips.i, localAioTips.j, this.h, 32, true);
        localAioTips.x();
        return true;
      }
    }
    return false;
  }
  
  public JumpStateMachineController a()
  {
    return this.l;
  }
  
  public void a(ChatXListView paramChatXListView, ChatAdapter1 paramChatAdapter1)
  {
    super.a(paramChatXListView, paramChatAdapter1);
    this.l = new JumpStateMachineController(this.b);
    this.l.c();
    this.m = (paramChatXListView.getContext().getResources().getDimensionPixelSize(2131299920) + ImmersiveUtils.getStatusBarHeight(paramChatXListView.getContext()));
    d(this.m);
    paramChatXListView.a(this.k);
  }
  
  public void a(Object paramObject)
  {
    Object localObject = this.b.O();
    paramObject = (RefreshMessageContext)paramObject;
    ChatContext localChatContext = (ChatContext)paramObject.a;
    if (!TextUtils.equals(((BaseSessionInfo)localObject).b, localChatContext.a())) {
      return;
    }
    if ((((BaseSessionInfo)localObject).a == paramObject.q) && (this.i != localChatContext.b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GuildListUI", 2, "refreshMessageContext sync other MiniAIO");
      }
      this.b.c(131073);
      return;
    }
    if ((this.i == localChatContext.b()) && (paramObject.f) && (ConfessMsgUtil.a(paramObject.q, paramObject.w, ((BaseSessionInfo)localObject).a, ((BaseSessionInfo)localObject).v)))
    {
      localObject = paramObject.b;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        this.j += 1;
      }
      long l1 = this.i + 300L - SystemClock.uptimeMillis();
      if (l1 <= 0L) {
        l1 = 0L;
      }
      this.b.g().postDelayed(new GuildListUI.2(this, paramObject), l1);
    }
  }
  
  public void b()
  {
    if (this.c != null)
    {
      this.c.setOverscrollHeader(null);
      this.c.setOverscrollFooter(null);
      this.c.b(this.k);
    }
    super.b();
    this.l = null;
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
  }
  
  public void c()
  {
    super.c();
    this.l.a(this.h);
  }
  
  public void d(boolean paramBoolean)
  {
    BaseSessionInfo localBaseSessionInfo = this.b.O();
    QQAppInterface localQQAppInterface = this.b.a();
    this.h.g = false;
    this.i = SystemClock.uptimeMillis();
    ((ChatContext)this.h.a).a(this.i);
    AioTips localAioTips = this.b.e().d().f();
    if (localAioTips != null)
    {
      long l1 = this.b.e().d().o();
      localQQAppInterface.getMessageFacade().s().a(localBaseSessionInfo.b, localBaseSessionInfo.a, l1 + 1L, localAioTips.i, false, this.h, 50, paramBoolean);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 1)
    {
      if (e())
      {
        if (this.f.getCount() > 0)
        {
          this.h.k = true;
          d(true);
          return true;
        }
        if (A())
        {
          d(true);
          return true;
        }
      }
      else
      {
        this.h.g = false;
      }
      return true;
    }
    if (z()) {
      return true;
    }
    if (this.f.getCount() > 0)
    {
      B();
      return true;
    }
    if (A())
    {
      B();
      return true;
    }
    b(false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildListUI
 * JD-Core Version:    0.7.0.1
 */