package com.tencent.mobileqq.guild.live.livemanager.anchor;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.live.livemanager.GuildLiveRoomListenerHandler;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveEventHelper;
import com.tencent.mobileqq.guild.live.livemanager.QQGuildLiveRoomCommMgr;
import com.tencent.mobileqq.guild.live.livemanager.repo.QQGuildLiveRoomUiData;
import com.tencent.mobileqq.guild.util.GuildAVPriorityManager;
import com.tencent.mobileqq.guild.util.GuildLiveToast;
import com.tencent.mobileqq.guild.util.livedata.BetterLiveData;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QQGuildLiveAnchorRoomMgr
  implements IQQGuildLiveAnchorRoomMgr
{
  private static final QQGuildLiveAnchorRoomMgr d = new QQGuildLiveAnchorRoomMgr();
  public MutableLiveData<Boolean> a;
  public MutableLiveData<QQLiveAnchorDataPublishStream> b;
  public MutableLiveData<QQLiveAnchorDataPrepare> c;
  private final String e = "QGL.QQGuildLiveAnchorRoomMgr";
  private MutableLiveData<QQLiveAnchorDataPrepare> f;
  private IQQLiveAnchorRoom g;
  private MutableLiveData<Boolean> h;
  private MutableLiveData<Boolean> i;
  private MutableLiveData<QQLiveAnchorDataPushInfo> j;
  private MutableLiveData<Boolean> k;
  private IQQLiveAnchorRoomCallback l;
  
  private QQGuildLiveAnchorRoomMgr()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    this.a = new MutableLiveData(localBoolean);
    this.b = new MutableLiveData(null);
    this.c = new MutableLiveData(null);
    this.h = new MutableLiveData(localBoolean);
    this.i = new MutableLiveData(localBoolean);
    this.j = new MutableLiveData(null);
    this.l = new QQGuildLiveAnchorRoomMgr.1(this);
  }
  
  public static QQGuildLiveAnchorRoomMgr a()
  {
    return d;
  }
  
  private void a(IQQLiveSDK paramIQQLiveSDK, QQLiveAnchorRecord paramQQLiveAnchorRecord)
  {
    if (!GuildAVPriorityManager.a(f(), "频道直播", QQGuildLiveEventHelper.a()))
    {
      QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "resumeRoomIfCan requestAVFocus failure.");
      paramIQQLiveSDK = this.k;
      if (paramIQQLiveSDK != null) {
        paramIQQLiveSDK.setValue(Boolean.valueOf(false));
      }
      return;
    }
    this.g = paramIQQLiveSDK.getAnchorModule().createFastResumeRoom(paramQQLiveAnchorRecord, this.l);
    this.g.a(this.l);
    GuildLiveRoomListenerHandler.a(this.g);
    b(true);
    QQGuildLiveRoomUiData.a().a(d());
    this.g.init(paramIQQLiveSDK);
    this.g.fastResume();
    QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "fastResume end.");
  }
  
  private void a(QQLiveAnchorDataEnter paramQQLiveAnchorDataEnter)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleOnEnterResult, enterResult.isSuccess = ");
    ((StringBuilder)localObject).append(paramQQLiveAnchorDataEnter.isSuccess);
    ((StringBuilder)localObject).append("errorMsg = ");
    ((StringBuilder)localObject).append(paramQQLiveAnchorDataEnter.errorMsg);
    QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, ((StringBuilder)localObject).toString());
    if (paramQQLiveAnchorDataEnter.isSuccess)
    {
      localObject = this.g;
      if (localObject != null) {
        ((IQQLiveAnchorRoom)localObject).startPublishStream();
      }
      QQGuildLiveRoomUiData.a().b(Boolean.valueOf(true));
      if (paramQQLiveAnchorDataEnter.roomInfo != null) {
        QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "update roomInfo.");
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject;
    if (this.g != null) {
      if (paramBoolean)
      {
        localObject = QQGuildLiveRoomUiData.a();
        ((QQGuildLiveRoomUiData)localObject).c(Boolean.valueOf(true));
        ((QQGuildLiveRoomUiData)localObject).b(Boolean.valueOf(true));
      }
      else
      {
        GuildLiveToast.a(2131890450);
        e();
        GuildAVPriorityManager.a("频道直播");
      }
    }
    if (this.g != null)
    {
      localObject = this.k;
      if (localObject != null) {
        ((MutableLiveData)localObject).setValue(Boolean.valueOf(paramBoolean));
      }
    }
  }
  
  private void e()
  {
    boolean bool = QQGuildLiveRoomCommMgr.a().b();
    IQQLiveSDK localIQQLiveSDK = QQGuildLiveRoomCommMgr.a().c();
    if ((bool) && (localIQQLiveSDK != null)) {
      localIQQLiveSDK.getAnchorModule().removeAnchorRecord(localIQQLiveSDK.getAppRuntime().getCurrentUin());
    }
  }
  
  private AppRuntime f()
  {
    return MobileQQ.sMobileQQ.peekAppRuntime();
  }
  
  public LiveData<Boolean> a(long paramLong, String paramString)
  {
    this.k = new BetterLiveData();
    boolean bool = QQGuildLiveRoomCommMgr.a().b();
    Boolean localBoolean = Boolean.valueOf(false);
    if (!bool)
    {
      QLog.e("QGL.QQGuildLiveAnchorRoomMgr", 1, "resumeRoomIfCan, sdk not init suc.");
      this.k.setValue(localBoolean);
      return this.k;
    }
    IQQLiveSDK localIQQLiveSDK = QQGuildLiveRoomCommMgr.a().c();
    QQLiveAnchorRecord localQQLiveAnchorRecord = localIQQLiveSDK.getAnchorModule().getValidAnchorRecord(localIQQLiveSDK.getAppRuntime().getCurrentUin());
    if (localQQLiveAnchorRecord == null)
    {
      QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "not anchor record.");
      b(paramLong, paramString);
      this.k.setValue(localBoolean);
      return this.k;
    }
    paramString = new StringBuilder();
    paramString.append("record roomId:");
    paramString.append(localQQLiveAnchorRecord.roomId);
    paramString.append(" uid:");
    paramString.append(localQQLiveAnchorRecord.uid);
    QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, paramString.toString());
    if (localQQLiveAnchorRecord.roomId == paramLong)
    {
      a(localIQQLiveSDK, localQQLiveAnchorRecord);
    }
    else
    {
      QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "record.roomId != resumeRoomId， don't resume.");
      b(localQQLiveAnchorRecord.roomId, localQQLiveAnchorRecord.programId);
      this.k.setValue(localBoolean);
    }
    return this.k;
  }
  
  public LiveData<QQLiveAnchorDataPrepare> a(Activity paramActivity)
  {
    this.f = new MutableLiveData();
    this.g.prepare(paramActivity);
    return this.f;
  }
  
  public LiveData<Boolean> a(boolean paramBoolean)
  {
    QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "anchorExitRoom.");
    if (this.g != null)
    {
      QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "anchorExitRoom start.");
      GuildLiveRoomListenerHandler.a();
      IQQLiveAnchorRoom localIQQLiveAnchorRoom = this.g;
      localIQQLiveAnchorRoom.exitRoom(new QQGuildLiveAnchorRoomMgr.2(this, paramBoolean, localIQQLiveAnchorRoom));
      this.h.setValue(Boolean.valueOf(false));
      this.c.setValue(null);
      this.j.setValue(null);
      this.a.setValue(Boolean.valueOf(false));
      this.b.setValue(null);
      this.g = null;
      this.k = null;
      QQGuildLiveRoomUiData.a().o();
    }
    GuildAVPriorityManager.a("频道直播");
    return this.i;
  }
  
  public void a(QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr)
  {
    IQQLiveAnchorRoom localIQQLiveAnchorRoom = this.g;
    if (localIQQLiveAnchorRoom != null) {
      localIQQLiveAnchorRoom.startSet(paramQQLiveAnchorDataRoomAttr);
    }
  }
  
  public LiveData<Boolean> b()
  {
    IQQLiveSDK localIQQLiveSDK = QQGuildLiveRoomCommMgr.a().c();
    if ((localIQQLiveSDK != null) && (QQGuildLiveRoomCommMgr.a().b()))
    {
      if (this.g != null) {
        QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, "mAnchorRoom has been create");
      }
      QQLiveAnchorRoomConfig localQQLiveAnchorRoomConfig = new QQLiveAnchorRoomConfig();
      localQQLiveAnchorRoomConfig.streamRecordType = QQLiveAnchorStreamRecordType.THIRD_PUSH;
      this.g = localIQQLiveSDK.getAnchorModule().createRoom(BaseApplication.getContext(), localQQLiveAnchorRoomConfig, this.l);
      this.g.init(localIQQLiveSDK);
      return this.h;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QGL.QQGuildLiveAnchorRoomMgr", 1, "audienceEnterRoom, live sdk not init suc.");
    }
    return this.h;
  }
  
  public void b(long paramLong, String paramString)
  {
    QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, "forceExitLiveRoom.");
    IQQLiveSDK localIQQLiveSDK = QQGuildLiveRoomCommMgr.a().c();
    if (localIQQLiveSDK != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("forceExitLiveRoom. roomId=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" pro:");
      localStringBuilder.append(paramString);
      QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, localStringBuilder.toString());
      int m = localIQQLiveSDK.getAnchorModule().tryCloseIsolatedRoom(paramLong, paramString);
      paramString = new StringBuilder();
      paramString.append("forceExitLiveRoom. resultCode=");
      paramString.append(m);
      QLog.i("QGL.QQGuildLiveAnchorRoomMgr", 1, paramString.toString());
      if (m == 0) {
        GuildLiveToast.a(2131890439);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    IQQLiveAnchorRoom localIQQLiveAnchorRoom = this.g;
    if ((localIQQLiveAnchorRoom != null) && ((localIQQLiveAnchorRoom instanceof IQQLiveAnchorThirdPushRoom))) {
      ((ITPPlayerVideoView)((IQQLiveAnchorThirdPushRoom)localIQQLiveAnchorRoom).getDisplayView()).setXYAxis(0);
    }
  }
  
  public LiveData<QQLiveAnchorDataPushInfo> c()
  {
    if (this.g != null)
    {
      QQLiveAnchorAutoCheckPullPlayParams localQQLiveAnchorAutoCheckPullPlayParams = new QQLiveAnchorAutoCheckPullPlayParams();
      localQQLiveAnchorAutoCheckPullPlayParams.autoCheckPullPlay = true;
      localQQLiveAnchorAutoCheckPullPlayParams.playerRetryCount = 500;
      localQQLiveAnchorAutoCheckPullPlayParams.playerRetryInterval = 500L;
      IQQLiveAnchorRoom localIQQLiveAnchorRoom = this.g;
      if ((localIQQLiveAnchorRoom instanceof IQQLiveAnchorThirdPushRoom)) {
        ((IQQLiveAnchorThirdPushRoom)localIQQLiveAnchorRoom).getRtmpPushUrl(localQQLiveAnchorAutoCheckPullPlayParams);
      }
    }
    return this.j;
  }
  
  public View d()
  {
    IQQLiveAnchorRoom localIQQLiveAnchorRoom = this.g;
    if (localIQQLiveAnchorRoom != null)
    {
      if ((localIQQLiveAnchorRoom instanceof IQQLiveAnchorThirdPushRoom)) {
        return ((ITPPlayerVideoView)((IQQLiveAnchorThirdPushRoom)localIQQLiveAnchorRoom).getDisplayView()).getCurrentDisplayView();
      }
      if ((localIQQLiveAnchorRoom instanceof IQQLiveAnchorTRTCRoom)) {
        return (View)((IQQLiveAnchorTRTCRoom)localIQQLiveAnchorRoom).getDisplayView();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.livemanager.anchor.QQGuildLiveAnchorRoomMgr
 * JD-Core Version:    0.7.0.1
 */