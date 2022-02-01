package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.forward.AppInfo;
import com.tencent.mobileqq.forward.ForwardD55Manager;
import com.tencent.mobileqq.forward.ForwardSdkStatusManager;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ForwardSdkShareProcessor$GetAppInfoStep
  extends ForwardSdkShareProcessor.ForwardStep
{
  private AtomicBoolean isFinished;
  OpensdkBusinessObserver mAppInfoObserver;
  private int retryCount;
  
  ForwardSdkShareProcessor$GetAppInfoStep(ForwardSdkShareProcessor paramForwardSdkShareProcessor)
  {
    super(paramForwardSdkShareProcessor);
    boolean bool = false;
    this.isFinished = new AtomicBoolean(false);
    this.mAppInfoObserver = new ForwardSdkShareProcessor.GetAppInfoStep.1(this);
    this.stepName = "GetAppInfoStep";
    AtomicBoolean localAtomicBoolean = this.isFinished;
    if (paramForwardSdkShareProcessor.mAppInfo.status == 1) {
      bool = true;
    }
    localAtomicBoolean.set(bool);
  }
  
  protected boolean isFinished()
  {
    return this.isFinished.get();
  }
  
  protected void process()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("GetAppInfoStep|process|appId=");
    ((StringBuilder)localObject1).append(ForwardSdkShareProcessor.access$400(this.this$0));
    ((StringBuilder)localObject1).append(",pkgName=");
    ((StringBuilder)localObject1).append(ForwardSdkShareProcessor.access$500(this.this$0));
    ((StringBuilder)localObject1).append(",retry=");
    ((StringBuilder)localObject1).append(this.retryCount);
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, ((StringBuilder)localObject1).toString());
    if (this.isCancelled.get())
    {
      doCancel();
      return;
    }
    ForwardSdkShareProcessor.access$602(this.this$0, System.currentTimeMillis());
    int i = this.this$0.mForwardType;
    if (i != 2)
    {
      if (i != 11) {
        return;
      }
      localObject1 = ((ForwardSdkStatusManager)this.this$0.app.getManager(QQManagerFactory.SDK_SHARE)).a().a(ForwardSdkShareProcessor.access$400(this.this$0));
      if (localObject1 != null)
      {
        useCachedAppInfo((AppInfo)localObject1);
        return;
      }
      long l = ForwardSdkShareProcessor.access$600(this.this$0) / 1000L;
      localObject1 = this.this$0.mAppContext;
      Object localObject2 = ForwardSdkShareProcessor.access$500(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(l);
      localStringBuilder.append("");
      localObject1 = AuthorityUtil.a((Context)localObject1, (String)localObject2, localStringBuilder.toString());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("GetAppInfoStep|process|sign: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("Q.share.ForwardSdkShareProcessor", 2, ((StringBuilder)localObject2).toString());
      }
      Share.a(this.this$0.app, this.this$0.mAppContext, this.this$0.app.getCurrentAccountUin(), ForwardSdkShareProcessor.access$400(this.this$0), (String)localObject1, l, this.mAppInfoObserver, ForwardSdkShareProcessor.access$500(this.this$0));
      return;
    }
    Share.a(this.this$0.app, this.this$0.mAppContext, this.this$0.app.getCurrentAccountUin(), ForwardSdkShareProcessor.access$400(this.this$0), 0L, this.mAppInfoObserver, ForwardSdkShareProcessor.access$500(this.this$0));
  }
  
  void updateMessageRecord()
  {
    Object localObject = this.this$0.app.getMessageFacade().b(this.this$0.mUiRequest.mPeerUin, this.this$0.mUiRequest.mUinType, this.this$0.mUiRequest.mUniseq);
    if ((localObject instanceof MessageForStructing))
    {
      localObject = (MessageForStructing)localObject;
      if ((((MessageForStructing)localObject).structingMsg instanceof AbsShareMsg))
      {
        localObject = (AbsShareMsg)((MessageForStructing)localObject).structingMsg;
        ((AbsShareMsg)localObject).mSource_A_ActionData = this.this$0.mAppInfo.packName;
        ((AbsShareMsg)localObject).mSourceName = this.this$0.mAppInfo.sourceName;
        ((AbsShareMsg)localObject).mSourceIcon = this.this$0.mAppInfo.sourceIconSmall;
        ((AbsShareMsg)localObject).mSourceUrl = this.this$0.mAppInfo.sourceUrl;
        ((AbsShareMsg)localObject).shareData.appInfoStatus = 1;
        this.this$0.app.getMessageFacade().a(this.this$0.mUiRequest.mPeerUin, this.this$0.mUiRequest.mUinType, this.this$0.mUiRequest.mUniseq, ((AbsShareMsg)localObject).getBytes());
        this.this$0.sendMessageToUpdate(1002);
      }
    }
  }
  
  void useCachedAppInfo(AppInfo paramAppInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetAppInfoStep|useCachedAppInfo=,time=");
    localStringBuilder.append(System.currentTimeMillis() - ForwardSdkShareProcessor.access$600(this.this$0));
    QLog.d("Q.share.ForwardSdkShareProcessor", 1, localStringBuilder.toString());
    this.this$0.mAppInfo.sourceIconSmall = paramAppInfo.a();
    this.this$0.mAppInfo.sourceIconBig = paramAppInfo.e();
    if (paramAppInfo.a())
    {
      if (!TextUtils.isEmpty(paramAppInfo.d())) {
        this.this$0.mAppInfo.packName = paramAppInfo.d();
      }
      if (!TextUtils.isEmpty(paramAppInfo.c())) {
        this.this$0.mAppInfo.sourceName = paramAppInfo.c();
      }
      if ((!TextUtils.isEmpty(paramAppInfo.b())) && (ForwardSdkShareProcessor.access$400(this.this$0) != Long.parseLong("1103584836"))) {
        this.this$0.mAppInfo.sourceUrl = paramAppInfo.b();
      }
    }
    this.this$0.mAppInfo.status = 1;
    updateMessageRecord();
    this.isFinished.set(true);
    doNextStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ForwardSdkShareProcessor.GetAppInfoStep
 * JD-Core Version:    0.7.0.1
 */