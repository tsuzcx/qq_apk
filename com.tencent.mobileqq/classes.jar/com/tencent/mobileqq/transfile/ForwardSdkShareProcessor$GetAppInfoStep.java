package com.tencent.mobileqq.transfile;

import aasr;
import android.text.TextUtils;
import aupn;
import auql;
import auuc;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.observer.BusinessObserver;

class ForwardSdkShareProcessor$GetAppInfoStep
  extends ForwardSdkShareProcessor.ForwardStep
{
  private AtomicBoolean isFinished = new AtomicBoolean(false);
  BusinessObserver mAppInfoObserver = new ForwardSdkShareProcessor.GetAppInfoStep.1(this);
  private int retryCount;
  
  ForwardSdkShareProcessor$GetAppInfoStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    this.stepName = "GetAppInfoStep";
    AtomicBoolean localAtomicBoolean = this.isFinished;
    if (paramForwardSdkShareProcessor.mAppInfo.status == 1) {}
    for (;;)
    {
      localAtomicBoolean.set(bool);
      return;
      bool = false;
    }
  }
  
  protected boolean isFinished()
  {
    return this.isFinished.get();
  }
  
  protected void process()
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetAppInfoStep|process|appId=" + ForwardSdkShareProcessor.access$400(this.this$0) + ",pkgName=" + ForwardSdkShareProcessor.access$500(this.this$0) + ",retry=" + this.retryCount);
    if (this.isCancelled.get())
    {
      doCancel();
      return;
    }
    ForwardSdkShareProcessor.access$602(this.this$0, System.currentTimeMillis());
    switch (this.this$0.mForwardType)
    {
    default: 
      return;
    case 2: 
      aasr.a(this.this$0.app, this.this$0.mAppContext, this.this$0.app.getCurrentAccountUin(), ForwardSdkShareProcessor.access$400(this.this$0), 0L, this.mAppInfoObserver, ForwardSdkShareProcessor.access$500(this.this$0));
      return;
    }
    Object localObject = ((auuc)this.this$0.app.getManager(QQManagerFactory.SDK_SHARE)).a().a(ForwardSdkShareProcessor.access$400(this.this$0));
    if (localObject != null)
    {
      useCachedAppInfo((aupn)localObject);
      return;
    }
    long l = ForwardSdkShareProcessor.access$600(this.this$0) / 1000L;
    localObject = AgentActivity.a(this.this$0.mAppContext, ForwardSdkShareProcessor.access$500(this.this$0), l + "");
    if (QLog.isColorLevel()) {
      QLog.d("Q.share.ForwardSdkShareProcessor", 2, "GetAppInfoStep|process|sign: " + (String)localObject);
    }
    aasr.a(this.this$0.app, this.this$0.mAppContext, this.this$0.app.getCurrentAccountUin(), ForwardSdkShareProcessor.access$400(this.this$0), (String)localObject, l, this.mAppInfoObserver, ForwardSdkShareProcessor.access$500(this.this$0));
  }
  
  void updateMessageRecord()
  {
    Object localObject = this.this$0.app.getMessageFacade().queryMsgItemByUniseq(this.this$0.mUiRequest.mPeerUin, this.this$0.mUiRequest.mUinType, this.this$0.mUiRequest.mUniseq);
    if (((localObject instanceof MessageForStructing)) && ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg)))
    {
      localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
      ((AbsShareMsg)localObject).mSource_A_ActionData = this.this$0.mAppInfo.packName;
      ((AbsShareMsg)localObject).mSourceName = this.this$0.mAppInfo.sourceName;
      ((AbsShareMsg)localObject).mSourceIcon = this.this$0.mAppInfo.sourceIconSmall;
      ((AbsShareMsg)localObject).mSourceUrl = this.this$0.mAppInfo.sourceUrl;
      ((AbsShareMsg)localObject).shareData.appInfoStatus = 1;
      this.this$0.app.getMessageFacade().updateMsgContentByUniseq(this.this$0.mUiRequest.mPeerUin, this.this$0.mUiRequest.mUinType, this.this$0.mUiRequest.mUniseq, ((AbsShareMsg)localObject).getBytes());
      this.this$0.sendMessageToUpdate(1002);
    }
  }
  
  void useCachedAppInfo(aupn paramaupn)
  {
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, "GetAppInfoStep|useCachedAppInfo=,time=" + (System.currentTimeMillis() - ForwardSdkShareProcessor.access$600(this.this$0)));
    this.this$0.mAppInfo.sourceIconSmall = paramaupn.a();
    this.this$0.mAppInfo.sourceIconBig = paramaupn.e();
    if (paramaupn.a())
    {
      if (!TextUtils.isEmpty(paramaupn.d())) {
        this.this$0.mAppInfo.packName = paramaupn.d();
      }
      if (!TextUtils.isEmpty(paramaupn.c())) {
        this.this$0.mAppInfo.sourceName = paramaupn.c();
      }
      if ((!TextUtils.isEmpty(paramaupn.b())) && (ForwardSdkShareProcessor.access$400(this.this$0) != Long.parseLong("1103584836"))) {
        this.this$0.mAppInfo.sourceUrl = paramaupn.b();
      }
    }
    this.this$0.mAppInfo.status = 1;
    updateMessageRecord();
    this.isFinished.set(true);
    doNextStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.GetAppInfoStep
 * JD-Core Version:    0.7.0.1
 */