package com.tencent.mobileqq.guild.navigatebar;

import android.content.Context;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.message.BaseGuildMessageManager;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService;
import com.tencent.mobileqq.guild.message.api.IGuildMsgSeqTimeService.MsgSeqTimeItem;
import com.tencent.mobileqq.guild.message.unread.api.IGuildMsgReadedService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService.UnreadCntInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.navigatebar.AioAgent.Message;
import com.tencent.mobileqq.troop.navigatebar.BaseAioMsgNavigateBar;
import com.tencent.mobileqq.troop.navigatebar.INavigateBar;
import com.tencent.mobileqq.troop.navigatebar.NavigateBarDelegateFactory;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class GuildAioMsgNavigateBar
  extends BaseAioMsgNavigateBar
{
  private final String V = "GuildAioMsgNavigateBar";
  private AIOContext W;
  GuildAioNavigateBarManager a;
  
  public GuildAioMsgNavigateBar(AIOContext paramAIOContext)
  {
    this.W = paramAIOContext;
  }
  
  private HashMap<String, Object> u()
  {
    HashMap localHashMap = new HashMap();
    int j = this.a.a(this.F.b, this.F.a);
    int i = 1;
    if (j != 1) {
      if ((j != 23) && (j != 14)) {
        i = 3;
      } else {
        i = 2;
      }
    }
    localHashMap.put("aio_ear_type", Integer.valueOf(i));
    return localHashMap;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt == 1) {
      return 2131624983;
    }
    return 2131624978;
  }
  
  protected void a()
  {
    super.a();
    this.e = ((int)((IGuildUnreadCntService)this.D.getRuntimeService(IGuildUnreadCntService.class)).getChannelUnreadCnt(this.F.b, 1).a);
    Object localObject = ((IGuildMsgSeqTimeService)this.D.getRuntimeService(IGuildMsgSeqTimeService.class)).getReadedMsgSeq(this.F.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onInit] mUnreadCount");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" mLastReadSeq ");
    localStringBuilder.append(this.d);
    QLog.d("GuildAioMsgNavigateBar", 1, localStringBuilder.toString());
    this.d = ((IGuildMsgSeqTimeService.MsgSeqTimeItem)localObject).a;
    this.a = ((GuildAioNavigateBarManager)this.D.getManager(QQManagerFactory.GUILD_AIO_NAVIGATE_BAR));
    this.O = new NavigateBarDelegateFactory(this.D, this.E, this, this.F);
    int i = ((GuildChatContext)this.W).V();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onInit] channelInfo.getType() ");
    ((StringBuilder)localObject).append(i);
    QLog.d("GuildAioMsgNavigateBar", 1, ((StringBuilder)localObject).toString());
    if (!((GuildChatContext)this.W).W()) {
      this.a.a(this.F.b, this.F.a, 1, this.d, this.d, "", Integer.valueOf(0));
    }
  }
  
  public void a(int paramInt, String paramString1, Object paramObject, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" createNavigateBar navigateType ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" wording = ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" tag = ");
    localStringBuilder.append(paramObject);
    localStringBuilder.append(" senderUin = ");
    localStringBuilder.append(paramString2);
    QLog.d("GuildAioMsgNavigateBar", 1, localStringBuilder.toString());
    if (this.G == null) {
      return;
    }
    if (this.k == null) {
      try
      {
        paramInt = a(paramInt);
        this.k = LayoutInflater.from(this.E).inflate(paramInt, null);
        this.k.setVisibility(8);
      }
      catch (Exception paramString1)
      {
        paramObject = new StringBuilder();
        paramObject.append("mNavitigationBarContainer, inflate error: ");
        paramObject.append(paramString1.getMessage());
        QLog.e("GuildAioMsgNavigateBar", 1, paramObject.toString());
        return;
      }
    }
    if (this.G.indexOfChild(this.k) == -1)
    {
      paramString2 = new RelativeLayout.LayoutParams(-2, -2);
      paramString2.topMargin = DisplayUtil.a(this.E, 18.0F);
      paramString2.addRule(11);
      this.G.addView(this.k, paramString2);
    }
    paramString2 = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
    paramInt = a(new int[] { 2131448070, 2131442214, 2131442350, 2131442345 });
    if (paramInt > 0) {
      paramString2.addRule(3, paramInt);
    }
    if (this.g == null) {
      this.g = this.k.findViewById(2131434528);
    }
    this.g.setTag(paramObject);
    this.l = ((TextView)this.g.findViewById(2131434530));
    this.l.setText(paramString1);
    this.l.setVisibility(0);
    this.g.setOnClickListener(this);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, Observer paramObserver, BaseSessionInfo paramBaseSessionInfo, RelativeLayout paramRelativeLayout, ChatAdapter1 paramChatAdapter1, ChatXListView paramChatXListView, ScrollerRunnable paramScrollerRunnable)
  {
    super.a(paramQQAppInterface, paramContext, paramObserver, paramBaseSessionInfo, paramRelativeLayout, paramChatAdapter1, paramChatXListView, paramScrollerRunnable);
    if (!this.M)
    {
      this.M = true;
      a();
    }
  }
  
  protected void b()
  {
    this.a.a(this.F.b, this.F.a, 0);
    ((IGuildMsgReadedService)this.D.getRuntimeService(IGuildMsgReadedService.class, "")).checkAndcleanMsgAndMsgData(this.F.c);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUninit ");
    localStringBuilder.append(this.a.b.size());
    QLog.d("GuildAioMsgNavigateBar", 1, localStringBuilder.toString());
    super.b();
  }
  
  protected void b(int paramInt)
  {
    if (this.M) {
      this.a.a(this.F.b, this.F.a, this.n);
    }
    super.b(paramInt);
  }
  
  protected void c()
  {
    this.n = this.a.a(this.F.b, this.F.a);
    this.s = this.a.b(this.F.b, this.n);
    if (this.F.a == 10014) {
      this.q = this.a.e(this.F.b);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initNavigateType navigateType 在普通消息下应该为 1");
    localStringBuilder.append(this.F.b);
    localStringBuilder.append("navigateType ");
    localStringBuilder.append(this.n);
    QLog.d("GuildAioMsgNavigateBar", 1, localStringBuilder.toString());
    if (this.a.a(this.F.b) != -1L) {
      Collections.sort(this.s, new GuildAioMsgNavigateBar.GuildSeqComparator());
    }
    if (!ListUtils.a(this.s)) {
      this.p = ((Long)this.s.get(0)).longValue();
    }
    this.o = this.a.a(this.F.b, this.p);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("initNavigateType initNavigateType, mMulNativigateSeqList.size = ");
    localStringBuilder.append(this.s.size());
    localStringBuilder.append(", navigateType = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", navShMsgSeq = ");
    localStringBuilder.append(this.o);
    localStringBuilder.append(", navigateSeq = ");
    localStringBuilder.append(this.p);
    QLog.d("GuildAioMsgNavigateBar", 1, localStringBuilder.toString());
  }
  
  protected void cA_()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showNavigateBar mFIsShow = ");
    localStringBuilder.append(this.Q);
    localStringBuilder.append(" navigateType = ");
    localStringBuilder.append(this.n);
    QLog.d("GuildAioMsgNavigateBar", 1, localStringBuilder.toString());
    g();
  }
  
  protected void d()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onClickMultiNavBar  ");
      ((StringBuilder)localObject1).append(this.n);
      ((StringBuilder)localObject1).append(", navigateSeq = ");
      ((StringBuilder)localObject1).append(this.p);
      QLog.d("GuildAioMsgNavigateBar", 1, ((StringBuilder)localObject1).toString());
    }
    AioAgent.Message localMessage;
    if ((!ListUtils.a(this.s)) && ((this.g.getTag() instanceof AioAgent.Message)))
    {
      this.f.set(true);
      localMessage = (AioAgent.Message)this.g.getTag();
    }
    label443:
    label446:
    for (;;)
    {
      synchronized (this.s)
      {
        long l = ((Long)this.s.remove(0)).longValue();
        AioAgent.Message.a(this.n, l, localMessage);
        int i = this.s.size();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sizeAfterClick = ");
        localStringBuilder.append(i);
        localStringBuilder.append(", seq = ");
        localStringBuilder.append(l);
        localStringBuilder.append(", message = ");
        if (localMessage == null) {
          localObject1 = "null";
        } else {
          localObject1 = localMessage.toString();
        }
        localStringBuilder.append((String)localObject1);
        QLog.d("GuildAioMsgNavigateBar", 1, localStringBuilder.toString());
        l = b;
        if (i <= 0) {
          break label446;
        }
        l = ((Long)this.s.get(0)).longValue();
        localObject1 = this.D.getMessageFacade().d(this.F.b, this.F.a, l);
        if ((this.i == null) || (localObject1 == null)) {
          break label443;
        }
        a(((MessageRecord)localObject1).senderuin);
        break label443;
        this.O.a(this.n, localMessage, this.R, i, this.m, this.l, l);
        if ((i > 0) && (!this.D.getMessageFacade().s().e(this.F.b, this.F.a)))
        {
          QLog.d("GuildAioMsgNavigateBar", 1, "onClick notify");
          setChanged();
          notifyObservers(localMessage);
          return;
        }
        q();
        if (QLog.isColorLevel()) {
          QLog.d("GuildAioMsgNavigateBar", 2, " onClickMultiNavBar hideMsgNavigateBar");
        }
        return;
      }
      q();
      return;
    }
  }
  
  public boolean e()
  {
    return true;
  }
  
  protected void g()
  {
    super.g();
    if (this.Q)
    {
      a(this.n, this.R, this.S, this.T);
      ((IGuildDTReportApi)QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickDynamicParams(this.g, "em_aio_ear", new -..Lambda.GuildAioMsgNavigateBar.ydMyKGtJjVEvChz1HvBMYrx4poI(this));
      p();
      w();
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mFIsShow = ");
    ((StringBuilder)localObject).append(this.Q);
    QLog.d("GuildAioMsgNavigateBar", 1, ((StringBuilder)localObject).toString());
    localObject = n();
    int j = 0;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (this.o > this.d)
      {
        i = j;
        if (this.o >= ((MessageRecord)localObject).shmsgseq) {
          i = 1;
        }
      }
    }
    if ((i != 0) && (d(this.n)))
    {
      setChanged();
      notifyObservers(AioAgent.Message.a(this.n, this.p, this.e));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyUi==>navigateType = ");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append(", navigateSeq = ");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(", navShMsgSeq = ");
      ((StringBuilder)localObject).append(this.o);
      QLog.d("GuildAioMsgNavigateBar.troop.special_msg", 1, ((StringBuilder)localObject).toString());
    }
    q();
  }
  
  protected void h()
  {
    if (this.F == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClickNavBar click nav bar: navigateType = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", navigateSeq = ");
    localStringBuilder.append(this.p);
    QLog.d("GuildAioMsgNavigateBar", 1, localStringBuilder.toString());
    this.z = true;
    if (GuildAioNavigateUtil.a())
    {
      d();
      return;
    }
    this.O.b(this.n, this.g.getTag(), this.R);
    q();
  }
  
  public boolean i()
  {
    if ((this.M) && (!this.c) && (this.e > 0))
    {
      int i = this.a.a(this.F.b, this.F.a);
      boolean bool = this.O.a(i, this.e);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" isNeedToShowNavigateBar: navigateType:");
      localStringBuilder.append(i);
      localStringBuilder.append(", mUnreadCount = ");
      localStringBuilder.append(this.e);
      localStringBuilder.append(", isNeedToShow:");
      localStringBuilder.append(bool);
      if (e())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(", mMulNativigateSeqList size:");
        ((StringBuilder)localObject).append(this.s.size());
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = "";
      }
      localStringBuilder.append((String)localObject);
      QLog.d("GuildAioMsgNavigateBar", 1, localStringBuilder.toString());
      if ((i == 1) && (this.a.b()))
      {
        QLog.d("GuildAioMsgNavigateBar", 1, " isNeedToShowNavigateBar: isHasAt == true");
        return false;
      }
      return bool;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" isNeedToShowNavigateBar exception: isInitSuccess = ");
    ((StringBuilder)localObject).append(this.M);
    ((StringBuilder)localObject).append(", mHasShowBar = ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", mUnreadCount = ");
    ((StringBuilder)localObject).append(this.e);
    QLog.d("GuildAioMsgNavigateBar", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.D != null) && (this.k != null) && (this.F != null) && (this.g != null))
    {
      if (paramAnimation == null) {
        return;
      }
      this.D.getHandler(ChatActivity.class).obtainMessage(68).sendToTarget();
      if (paramAnimation.equals(this.x))
      {
        this.k.setVisibility(8);
        this.g.setVisibility(8);
      }
      this.c = false;
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((this.D != null) && (this.k != null) && (this.F != null) && (this.g != null))
    {
      if (paramAnimation == null) {
        return;
      }
      if ((paramAnimation.equals(this.x)) && (this.z) && (!this.D.getMessageFacade().s().e(this.F.b, this.F.a)))
      {
        setChanged();
        notifyObservers(this.g.getTag());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.navigatebar.GuildAioMsgNavigateBar
 * JD-Core Version:    0.7.0.1
 */