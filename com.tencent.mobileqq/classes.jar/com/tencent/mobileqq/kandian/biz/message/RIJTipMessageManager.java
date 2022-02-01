package com.tencent.mobileqq.kandian.biz.message;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl.Companion;
import com.tencent.mobileqq.kandian.biz.push.OnTabRedNumsChangeListenner;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.studymode.StudyModeManager;
import mqq.app.AppRuntime;

public class RIJTipMessageManager
{
  private MessageObserver a;
  private OnTabRedNumsChangeListenner b;
  private ReadinjoySocialMsgUI c;
  private RIJTipMessageManager.Builder d;
  
  public RIJTipMessageManager(RIJTipMessageManager.Builder paramBuilder)
  {
    this.d = paramBuilder;
  }
  
  private void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if (this.c == null)
    {
      if (RIJMsgBoxUtils.b() == 2)
      {
        this.c = new ReadinjoySocialMsgCard(this.d.b());
      }
      else
      {
        this.c = new ReadinjoySocialMsgTips(this.d.b(), LayoutInflater.from(this.d.b()).inflate(2131626332, this.d.a(), false));
        ((ReadinjoySocialMsgTips)this.c).a(this.d.c());
      }
      this.c.a(new RIJTipMessageManager.4(this));
      this.d.a().addHeaderView(this.c.a());
    }
    this.c.a(paramKandianMsgBoxRedPntInfo);
    this.c.b();
    this.d.a().postInvalidate();
  }
  
  private void m()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).Q();
    if ((localKandianMsgBoxRedPntInfo != null) && (RIJPrivateChatServiceImpl.Companion.a().getTotalRedCount(localKandianMsgBoxRedPntInfo) > 0))
    {
      a(localKandianMsgBoxRedPntInfo);
      return;
    }
    d();
  }
  
  public RIJTipMessageManager.Builder a()
  {
    return this.d;
  }
  
  public void b()
  {
    this.a = new RIJTipMessageManager.1(this);
    this.b = new RIJTipMessageManager.2(this);
  }
  
  public void c()
  {
    if (RIJMsgBoxUtils.b() == 0) {
      return;
    }
    if (this.d.c() != 0) {
      return;
    }
    if (StudyModeManager.h()) {
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      m();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new RIJTipMessageManager.3(this));
  }
  
  public void d()
  {
    try
    {
      if (this.c != null)
      {
        this.d.a().removeHeaderView(this.c.a());
        this.d.a().postInvalidate();
        this.c = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e()
  {
    ReadinjoySocialMsgUI localReadinjoySocialMsgUI = this.c;
    if (localReadinjoySocialMsgUI != null)
    {
      localReadinjoySocialMsgUI.c();
      this.c = null;
    }
    g();
    this.a = null;
  }
  
  public void f()
  {
    this.d.a().e();
    h();
  }
  
  public void g()
  {
    h();
    i();
  }
  
  public void h()
  {
    ((KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(this.a);
  }
  
  public void i()
  {
    ((KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(this.b);
  }
  
  public void j()
  {
    k();
    l();
  }
  
  public void k()
  {
    ((KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.a);
  }
  
  public void l()
  {
    ((KandianMergeManager)ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.RIJTipMessageManager
 * JD-Core Version:    0.7.0.1
 */