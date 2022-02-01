package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.api.impl.room.AudienceRoomPlayModule;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPush;
import com.tencent.mobileqq.qqlive.callback.room.audience.AudienceRoomPlayerListener;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.view.TPPlayerVideoView;
import com.tencent.qphone.base.util.QLog;

public class QQLiveAnchorThirdPushChecker
{
  private AudienceRoomPlayModule a;
  private String b;
  private IQQLiveAnchorRoomThirdPush c;
  private QQLiveAnchorAutoCheckPullPlayParams d;
  private AudienceRoomPlayerListener e;
  private boolean f = false;
  
  public QQLiveAnchorThirdPushChecker(String paramString, AudienceRoomPlayModule paramAudienceRoomPlayModule, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPush paramIQQLiveAnchorRoomThirdPush)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create QQLiveAnchorThirdPushChecker, isMute:");
      localStringBuilder.append(paramQQLiveAnchorAutoCheckPullPlayParams.isMute);
      localStringBuilder.append(", playUrl: ");
      localStringBuilder.append(paramString);
      QLog.d("QQLiveAnchor_tpChecker", 1, localStringBuilder.toString());
    }
    this.a = paramAudienceRoomPlayModule;
    if (this.a == null) {
      this.a = new AudienceRoomPlayModule(paramQQLiveAnchorAutoCheckPullPlayParams.isMute);
    }
    if (QLog.isColorLevel())
    {
      paramAudienceRoomPlayModule = new StringBuilder();
      paramAudienceRoomPlayModule.append("playModule, hashCode:");
      paramAudienceRoomPlayModule.append(this.a.hashCode());
      QLog.d("QQLiveAnchor_tpChecker", 1, paramAudienceRoomPlayModule.toString());
    }
    this.b = paramString;
    this.c = paramIQQLiveAnchorRoomThirdPush;
    this.d = paramQQLiveAnchorAutoCheckPullPlayParams;
    this.e = new QQLiveAnchorThirdPushChecker.1(this, paramString, paramIQQLiveAnchorRoomThirdPush);
    this.a.registerRoomPlayerListener(this.e);
    this.a.setRetryParams(paramQQLiveAnchorAutoCheckPullPlayParams.playerRetryInterval, paramQQLiveAnchorAutoCheckPullPlayParams.playerRetryCount);
  }
  
  public TPPlayerVideoView a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDisplayView, isDestroy:");
      ((StringBuilder)localObject).append(this.f);
      QLog.d("QQLiveAnchor_tpChecker", 1, ((StringBuilder)localObject).toString());
    }
    if (this.f) {
      return null;
    }
    Object localObject = this.a;
    if (localObject != null) {
      return ((AudienceRoomPlayModule)localObject).playerView;
    }
    return null;
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startCheck, , isDestroy: ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", hashCode: ");
      localObject = this.a;
      if (localObject == null) {
        localObject = "null";
      } else {
        localObject = Integer.valueOf(localObject.hashCode());
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(", isMute:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", url:");
      localStringBuilder.append(this.b);
      QLog.d("QQLiveAnchor_tpChecker", 1, localStringBuilder.toString());
    }
    if (this.f) {
      return;
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      ((AudienceRoomPlayModule)localObject).startPlay(this.b);
      this.a.setMute(paramBoolean);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("destroy, hashCode:");
      localObject1 = this.a;
      if (localObject1 == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(localObject1.hashCode());
      }
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(", destoryPlayer:");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", url:");
      ((StringBuilder)localObject2).append(this.b);
      QLog.d("QQLiveAnchor_tpChecker", 1, ((StringBuilder)localObject2).toString());
    }
    this.f = true;
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      localObject2 = this.e;
      if (localObject2 != null) {
        ((AudienceRoomPlayModule)localObject1).unRegisterRoomPlayerListener((AudienceRoomPlayerListener)localObject2);
      }
    }
    this.e = null;
    localObject1 = this.a;
    if ((localObject1 != null) && (paramBoolean)) {
      ((AudienceRoomPlayModule)localObject1).destroy();
    }
    this.a = null;
    this.b = null;
    this.d = null;
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorThirdPushChecker
 * JD-Core Version:    0.7.0.1
 */