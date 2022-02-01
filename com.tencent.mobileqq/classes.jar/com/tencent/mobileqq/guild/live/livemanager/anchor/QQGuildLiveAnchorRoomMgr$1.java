package com.tencent.mobileqq.guild.live.livemanager.anchor;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.live.livemanager.GuildLiveRoomListenerHandler;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.qphone.base.util.QLog;

class QQGuildLiveAnchorRoomMgr$1
  extends QQLiveAnchorRoomThirdPushBaseCallback
{
  QQGuildLiveAnchorRoomMgr$1(QQGuildLiveAnchorRoomMgr paramQQGuildLiveAnchorRoomMgr) {}
  
  public void a()
  {
    QQGuildLiveAnchorRoomMgr.e(this.a).setValue(Boolean.valueOf(true));
  }
  
  public void a(QQLiveAnchorRoomState paramQQLiveAnchorRoomState1, QQLiveAnchorRoomState paramQQLiveAnchorRoomState2)
  {
    super.a(paramQQLiveAnchorRoomState1, paramQQLiveAnchorRoomState2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStateChange oldState: ");
      localStringBuilder.append(paramQQLiveAnchorRoomState1);
      localStringBuilder.append(" newState: ");
      localStringBuilder.append(paramQQLiveAnchorRoomState2);
      QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
    }
  }
  
  public void a(QQLiveAnchorDataEnter paramQQLiveAnchorDataEnter)
  {
    QQGuildLiveAnchorRoomMgr.a(this.a, paramQQLiveAnchorDataEnter);
  }
  
  public void a(QQLiveAnchorDataFastResume paramQQLiveAnchorDataFastResume)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFastResumeResult result:");
    localStringBuilder.append(paramQQLiveAnchorDataFastResume.isSuccess);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramQQLiveAnchorDataFastResume.errorMsg);
    QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
    QQGuildLiveAnchorRoomMgr.a(this.a, paramQQLiveAnchorDataFastResume.isSuccess);
  }
  
  public void a(QQLiveAnchorDataInit paramQQLiveAnchorDataInit)
  {
    super.a(paramQQLiveAnchorDataInit);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInit suc: ");
    localStringBuilder.append(paramQQLiveAnchorDataInit.isSuccess);
    localStringBuilder.append(" errorMsg:");
    localStringBuilder.append(paramQQLiveAnchorDataInit.errorMsg);
    QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
    QQGuildLiveAnchorRoomMgr.a(this.a).setValue(Boolean.valueOf(paramQQLiveAnchorDataInit.isSuccess));
  }
  
  public void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    super.a(paramQQLiveAnchorDataPrepare);
    this.a.c.setValue(paramQQLiveAnchorDataPrepare);
    if (QQGuildLiveAnchorRoomMgr.b(this.a) != null) {
      QQGuildLiveAnchorRoomMgr.b(this.a).setValue(paramQQLiveAnchorDataPrepare);
    }
    if (paramQQLiveAnchorDataPrepare.isSuccess)
    {
      QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, "onPrepare suc");
      GuildLiveRoomListenerHandler.a(QQGuildLiveAnchorRoomMgr.c(this.a));
      this.a.b(false);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPrepare failed");
    localStringBuilder.append(paramQQLiveAnchorDataPrepare.errorMsg);
    QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
  }
  
  public void a(QQLiveAnchorDataPublishStream paramQQLiveAnchorDataPublishStream)
  {
    this.a.b.setValue(paramQQLiveAnchorDataPublishStream);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPublishStream suc: ");
    localStringBuilder.append(paramQQLiveAnchorDataPublishStream.isSuccess);
    localStringBuilder.append("errMsg: ");
    localStringBuilder.append(paramQQLiveAnchorDataPublishStream.errorMsg);
    QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
  }
  
  public void a(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo)
  {
    super.a(paramQQLiveAnchorDataPullInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetPullInfo: ");
    localStringBuilder.append(paramQQLiveAnchorDataPullInfo.isSuccess);
    localStringBuilder.append(" errorMsg:");
    localStringBuilder.append(paramQQLiveAnchorDataPullInfo.errorMsg);
    QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
  }
  
  public void a(QQLiveAnchorDataPushInfo paramQQLiveAnchorDataPushInfo)
  {
    super.a(paramQQLiveAnchorDataPushInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetPushInfo: ");
    localStringBuilder.append(paramQQLiveAnchorDataPushInfo.isSuccess);
    localStringBuilder.append(" errorMsg:");
    localStringBuilder.append(paramQQLiveAnchorDataPushInfo.errorMsg);
    QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
    QQGuildLiveAnchorRoomMgr.d(this.a).setValue(paramQQLiveAnchorDataPushInfo);
  }
  
  public void a(QQLiveAnchorDataSet paramQQLiveAnchorDataSet)
  {
    super.a(paramQQLiveAnchorDataSet);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSet suc: ");
    localStringBuilder.append(paramQQLiveAnchorDataSet.isSuccess);
    localStringBuilder.append("errMsg: ");
    localStringBuilder.append(paramQQLiveAnchorDataSet.errorMsg);
    QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
    if ((paramQQLiveAnchorDataSet.isSuccess) && (QQGuildLiveAnchorRoomMgr.c(this.a) != null))
    {
      QQGuildLiveAnchorRoomMgr.c(this.a).enterRoom();
      return;
    }
    GuildLiveToast.a(2131890469);
  }
  
  public void a(QQLiveAnchorDataThirdPushCheck paramQQLiveAnchorDataThirdPushCheck)
  {
    super.a(paramQQLiveAnchorDataThirdPushCheck);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onThirdPushChecked isSuccess:");
    localStringBuilder.append(paramQQLiveAnchorDataThirdPushCheck.isSuccess);
    localStringBuilder.append(" errorMsg: ");
    localStringBuilder.append(paramQQLiveAnchorDataThirdPushCheck.errorMsg);
    QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
    this.a.a.setValue(Boolean.valueOf(paramQQLiveAnchorDataThirdPushCheck.isSuccess));
  }
  
  public void a(QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    super.a(paramQQLiveErrorMsg);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError bizErrMsg: ");
    localStringBuilder.append(paramQQLiveErrorMsg.bizErrMsg);
    localStringBuilder.append(" originErrMsg:");
    localStringBuilder.append(paramQQLiveErrorMsg.originErrMsg);
    localStringBuilder.append(" bizErrCode:");
    localStringBuilder.append(paramQQLiveErrorMsg.bizErrCode);
    localStringBuilder.append(" bizModule:");
    localStringBuilder.append(paramQQLiveErrorMsg.bizModule);
    QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
    if (paramQQLiveErrorMsg.bizErrCode == 6270) {
      GuildLiveToast.a(2131890482);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr.1
 * JD-Core Version:    0.7.0.1
 */