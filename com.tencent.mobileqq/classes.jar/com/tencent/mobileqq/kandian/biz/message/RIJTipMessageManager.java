package com.tencent.mobileqq.kandian.biz.message;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.push.OnTabRedNumsChangeListenner;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.router.msgbox.api.impl.RIJMsgBoxUtils;
import com.tencent.mobileqq.kandian.repo.push.api.MessageObserver;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.studymode.StudyModeManager;
import mqq.app.AppRuntime;

public class RIJTipMessageManager
{
  private RIJTipMessageManager.Builder jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder;
  private ReadinjoySocialMsgUI jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI;
  private OnTabRedNumsChangeListenner jdField_a_of_type_ComTencentMobileqqKandianBizPushOnTabRedNumsChangeListenner;
  private MessageObserver jdField_a_of_type_ComTencentMobileqqKandianRepoPushApiMessageObserver;
  
  public RIJTipMessageManager(RIJTipMessageManager.Builder paramBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder = paramBuilder;
  }
  
  private void a(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI == null)
    {
      if (RIJMsgBoxUtils.b() == 2) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI = new ReadinjoySocialMsgCard(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder.a());
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI = new ReadinjoySocialMsgTips(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder.a(), LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder.a()).inflate(2131560286, this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder.a(), false));
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI.a(new RIJTipMessageManager.4(this));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder.a().addHeaderView(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI.a());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI.a(paramKandianMsgBoxRedPntInfo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder.a().postInvalidate();
  }
  
  private void l()
  {
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    if ((localKandianMsgBoxRedPntInfo != null) && (localKandianMsgBoxRedPntInfo.mMsgCnt > 0))
    {
      a(localKandianMsgBoxRedPntInfo);
      return;
    }
    c();
  }
  
  public RIJTipMessageManager.Builder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoPushApiMessageObserver = new RIJTipMessageManager.1(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPushOnTabRedNumsChangeListenner = new RIJTipMessageManager.2(this);
  }
  
  public void b()
  {
    if (RIJMsgBoxUtils.b() == 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder.a() != 0) {
      return;
    }
    if (StudyModeManager.a()) {
      return;
    }
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      l();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new RIJTipMessageManager.3(this));
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder.a().removeHeaderView(this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI.a());
        this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder.a().postInvalidate();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d()
  {
    ReadinjoySocialMsgUI localReadinjoySocialMsgUI = this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI;
    if (localReadinjoySocialMsgUI != null)
    {
      localReadinjoySocialMsgUI.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageReadinjoySocialMsgUI = null;
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoPushApiMessageObserver = null;
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizMessageRIJTipMessageManager$Builder.a().d();
    g();
  }
  
  public void f()
  {
    g();
    h();
  }
  
  public void g()
  {
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoPushApiMessageObserver);
  }
  
  public void h()
  {
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPushOnTabRedNumsChangeListenner);
  }
  
  public void i()
  {
    j();
    k();
  }
  
  public void j()
  {
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoPushApiMessageObserver);
  }
  
  public void k()
  {
    ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPushOnTabRedNumsChangeListenner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.message.RIJTipMessageManager
 * JD-Core Version:    0.7.0.1
 */