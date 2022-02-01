package com.tencent.mobileqq.troop.navigatebar;

import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.utils.ListUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class TroopAioMsgNavigateBar
  extends BaseAioMsgNavigateBar
{
  TroopAioNavigateBarManager V;
  final String a = "TroopAioMsgNavigateBar";
  
  protected void a()
  {
    super.a();
    this.d = this.D.getConversationFacade().e(this.F.b, this.F.a);
    this.e = this.D.getConversationFacade().a(this.F.b, this.F.a);
    this.V = ((TroopAioNavigateBarManager)this.D.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR));
    if (!((HotChatManager)this.D.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(this.F.b)) {
      this.V.a(this.F.b, this.F.a, 1, this.d, this.d, "", 0, null);
    }
    this.O = new NavigateBarDelegateFactory(this.D, this.E, this, this.F);
  }
  
  protected void b()
  {
    this.V.a(this.F.b, this.F.a, 0);
    super.b();
  }
  
  protected void b(int paramInt)
  {
    if (this.M) {
      this.V.a(this.F.b, this.F.a, this.n);
    }
    super.b(paramInt);
  }
  
  protected void c()
  {
    this.n = this.V.a(this.F.b, this.F.a);
    this.s = this.V.b(this.F.b, this.n);
    if (this.F.a == 1) {
      this.q = this.V.d(this.F.b);
    }
    if (e())
    {
      if (!ListUtils.a(this.s)) {
        this.p = ((Long)this.s.get(this.s.size() - 1)).longValue();
      }
    }
    else {
      this.p = this.V.a(this.F.a, this.F.b);
    }
    this.o = this.V.a(this.F.b, this.p);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initNavigateType, mMulNativigeteSeqList.size = ");
      localStringBuilder.append(this.s.size());
      localStringBuilder.append(", navigateType = ");
      localStringBuilder.append(this.n);
      localStringBuilder.append(", navShMsgSeq = ");
      localStringBuilder.append(this.o);
      localStringBuilder.append(", navigateSeq = ");
      localStringBuilder.append(this.p);
      QLog.d("TroopAioMsgNavigateBar", 2, localStringBuilder.toString());
    }
  }
  
  protected void cA_()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showNavigateBar mFIsShow = ");
      ((StringBuilder)localObject).append(this.Q);
      ((StringBuilder)localObject).append(" navigateType = ");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append("NavConstants.TYPE_TROOP_NOTIFY ");
      ((StringBuilder)localObject).append(102);
      QLog.d("TroopAioMsgNavigateBar", 1, ((StringBuilder)localObject).toString());
    }
    if ((this.n == 102) && (this.Q))
    {
      localObject = this.O.c(102);
      if ((localObject instanceof TroopAioMsgNavigateNotification)) {
        ((TroopAioMsgNavigateNotification)localObject).d();
      }
    }
    else
    {
      g();
    }
  }
  
  protected void d()
  {
    AioAgent.Message localMessage;
    if ((!ListUtils.a(this.s)) && ((this.g.getTag() instanceof AioAgent.Message)))
    {
      this.f.set(true);
      localMessage = (AioAgent.Message)this.g.getTag();
    }
    label379:
    label382:
    for (;;)
    {
      synchronized (this.s)
      {
        long l = ((Long)this.s.remove(0)).longValue();
        AioAgent.Message.a(this.n, l, localMessage);
        int i = this.s.size();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("sizeAfterClick = ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(", mArrowImageRotated = ");
          ((StringBuilder)localObject2).append(this.j);
          ((StringBuilder)localObject2).append(", seq = ");
          ((StringBuilder)localObject2).append(l);
          QLog.d("TroopAioMsgNavigateBar", 2, ((StringBuilder)localObject2).toString());
        }
        l = b;
        if (i <= 0) {
          break label382;
        }
        if (!this.j)
        {
          this.h.startAnimation(this.y);
          this.j = true;
        }
        l = ((Long)this.s.get(0)).longValue();
        Object localObject2 = this.D.getMessageFacade().d(this.F.b, this.F.a, l);
        if ((this.i == null) || (localObject2 == null)) {
          break label379;
        }
        a(((MessageRecord)localObject2).senderuin);
        break label379;
        this.O.a(this.n, localMessage, this.R, i, this.m, this.l, l);
        if ((i > 0) && (!this.D.getMessageFacade().p().f(this.F.b, this.F.a)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopAioMsgNavigateBar", 2, "onClick notify");
          }
          setChanged();
          notifyObservers(localMessage);
          return;
        }
        q();
        return;
      }
      q();
      return;
    }
  }
  
  public boolean e()
  {
    return (TroopAioNavigateUtil.a(this.n)) && (!ListUtils.a(this.s));
  }
  
  protected void g()
  {
    super.g();
    if (this.Q)
    {
      a(this.n, this.R, this.S, this.T);
      p();
      w();
      ReportController.b(null, "dc00898", "", this.F.b, "qq_vip", "0X800A8FB", 0, 1, 0, "", "", "", "");
      return;
    }
    Object localObject = n();
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
    if ((i != 0) && (d(this.n)) && (!this.D.getMessageFacade().p().f(this.F.b, this.F.a)))
    {
      setChanged();
      notifyObservers(AioAgent.Message.a(this.n, this.p, this.e));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("notifyUi==>navigateType = ");
        ((StringBuilder)localObject).append(this.n);
        ((StringBuilder)localObject).append(", navigateSeq = ");
        ((StringBuilder)localObject).append(this.p);
        ((StringBuilder)localObject).append(", navShMsgSeq = ");
        ((StringBuilder)localObject).append(this.o);
        QLog.d("TroopAioMsgNavigateBar.troop.special_msg", 2, ((StringBuilder)localObject).toString());
      }
    }
    q();
  }
  
  protected void h()
  {
    if (this.F == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("click nav bar: navigateType = ");
      localStringBuilder.append(this.n);
      localStringBuilder.append(", navigateSeq = ");
      localStringBuilder.append(this.p);
      QLog.d("TroopAioMsgNavigateBar", 2, localStringBuilder.toString());
    }
    this.z = true;
    ReportController.b(null, "dc00898", "", this.F.b, "qq_vip", "0X800A8FC", 0, 1, 0, "", "", "", "");
    if (this.F.a == 3000) {
      ReportController.b(this.D, "CliOper", "", "", "0X800621C", "0X800621C", 0, 0, "", "", "", "");
    }
    if ((this.r) && (e())) {
      ReportController.b(this.D, "P_CliOper", "Grp_work", "", "use", "Clk_owner", 0, 0, this.F.b, "", "", "");
    }
    if (TroopAioNavigateUtil.a(this.n))
    {
      d();
      return;
    }
    this.O.b(this.n, this.g.getTag(), this.R);
    com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpUtil.b = SystemClock.uptimeMillis();
    q();
  }
  
  public boolean i()
  {
    if ((this.M) && (!this.c) && (this.e > 0))
    {
      int i = this.V.a(this.F.b, this.F.a);
      boolean bool = this.O.a(i, this.e);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isNeedToShowNavigateBar: navigateType:");
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
        QLog.d("TroopAioMsgNavigateBar", 2, localStringBuilder.toString());
      }
      return bool;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isNeedToShowNavigateBar exception: isInitSuccess = ");
    ((StringBuilder)localObject).append(this.M);
    ((StringBuilder)localObject).append(", mHasShowBar = ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", mUnreadCount = ");
    ((StringBuilder)localObject).append(this.e);
    QLog.d("TroopAioMsgNavigateBar", 1, ((StringBuilder)localObject).toString());
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
  
  public void onAnimationRepeat(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.navigatebar.TroopAioMsgNavigateBar
 * JD-Core Version:    0.7.0.1
 */