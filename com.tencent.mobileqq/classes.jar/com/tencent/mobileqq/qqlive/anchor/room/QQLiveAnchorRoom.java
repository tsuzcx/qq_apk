package com.tencent.mobileqq.qqlive.anchor.room;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.anchor.report.QQLiveAnchorTechReport;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperExit;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperLogin;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperPrepare;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperSet;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.api.impl.room.BaseLiveRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.ExitRoomCallback;
import com.tencent.mobileqq.qqlive.callback.room.audience.RoomInfoListener;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataCheckPermission;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataStreamInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.EnterReq;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public abstract class QQLiveAnchorRoom
  extends BaseLiveRoom
  implements IQQLiveAnchorRoom
{
  protected Context a;
  protected QQLiveAnchorRoomConfig b;
  protected QQLiveAnchorRoomInfo c = new QQLiveAnchorRoomInfo();
  protected final QQLiveAnchorRoomCallback d = new QQLiveAnchorRoomCallback();
  protected QQLiveAnchorRoomState e = QQLiveAnchorRoomState.STATE_NONE;
  protected final RoomInfoService f = new RoomInfoService();
  protected QQLiveAnchorHelperLogin g = new QQLiveAnchorHelperLogin();
  protected QQLiveAnchorHelperPrepare h = new QQLiveAnchorHelperPrepare();
  protected QQLiveAnchorHelperSet i = new QQLiveAnchorHelperSet();
  protected QQLiveAnchorHelperFastResume j = new QQLiveAnchorHelperFastResume();
  protected QQLiveAnchorTechReport k = new QQLiveAnchorTechReport();
  protected int l = 1000;
  protected boolean m = false;
  protected boolean n = false;
  protected boolean o = false;
  protected long p = 0L;
  
  public QQLiveAnchorRoom(Context paramContext, IQQLiveSDK paramIQQLiveSDK, QQLiveAnchorRoomConfig paramQQLiveAnchorRoomConfig, IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback)
  {
    this.a = paramContext.getApplicationContext();
    this.b = paramQQLiveAnchorRoomConfig;
    if (paramIQQLiveAnchorRoomCallback != null) {
      this.d.a(paramIQQLiveAnchorRoomCallback);
    }
    a(QQLiveAnchorRoomState.STATE_CREATE);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    if (!this.isDestroy)
    {
      if (this.isExitRoom) {
        return;
      }
      if (this.heartHandler == null) {
        return;
      }
      this.heartHandler.postDelayed(new QQLiveAnchorRoom.1(this), paramInt);
    }
  }
  
  private void h()
  {
    this.p += 1L;
    if (this.p < 5L) {
      return;
    }
    if (this.d != null)
    {
      QQLiveErrorMsg localQQLiveErrorMsg = new QQLiveErrorMsg();
      localQQLiveErrorMsg.bizModule = 2;
      localQQLiveErrorMsg.bizErrCode = 6105;
      localQQLiveErrorMsg.bizErrMsg = "heart failed";
      this.d.a(localQQLiveErrorMsg);
      QQLiveAnchorTechReport localQQLiveAnchorTechReport = this.k;
      if (localQQLiveAnchorTechReport != null) {
        localQQLiveAnchorTechReport.a(localQQLiveErrorMsg);
      }
    }
    this.p = 0L;
  }
  
  private void i()
  {
    if (this.liveSDK == null) {
      return;
    }
    QQLiveCurRoomInfo localQQLiveCurRoomInfo = new QQLiveCurRoomInfo();
    QQLiveAnchorRoomInfo localQQLiveAnchorRoomInfo = this.c;
    if ((localQQLiveAnchorRoomInfo != null) && (localQQLiveAnchorRoomInfo.roomData != null))
    {
      localQQLiveCurRoomInfo.roomId = localQQLiveAnchorRoomInfo.roomData.id;
      localQQLiveCurRoomInfo.roomType = 1;
      localQQLiveCurRoomInfo.uid = localQQLiveAnchorRoomInfo.uid;
      localQQLiveCurRoomInfo.programId = localQQLiveAnchorRoomInfo.roomData.programId;
      this.liveSDK.recordCurRoomInfo(localQQLiveCurRoomInfo);
      return;
    }
    QLog.e("QQLiveAnchor_BaseRoom", 1, "recordRoomInfo, something null");
  }
  
  private void j()
  {
    if (this.liveSDK == null) {
      return;
    }
    QQLiveAnchorRoomInfo localQQLiveAnchorRoomInfo = this.c;
    if ((localQQLiveAnchorRoomInfo != null) && (localQQLiveAnchorRoomInfo.roomData != null))
    {
      this.liveSDK.removeCurRoomRecord(localQQLiveAnchorRoomInfo.roomData.id);
      return;
    }
    QLog.e("QQLiveAnchor_BaseRoom", 1, "clearRoomInfo, roomData null");
  }
  
  private void k()
  {
    if (this.isDestroy) {
      return;
    }
    this.g.a(this.liveSDK, new QQLiveAnchorRoom.2(this));
  }
  
  protected void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23)
    {
      b();
      return;
    }
    this.d.h();
    String[] arrayOfString = a();
    ArrayList localArrayList = new ArrayList();
    int i2 = arrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = arrayOfString[i1];
      if (paramContext.checkSelfPermission(str) != 0) {
        localArrayList.add(str);
      }
      i1 += 1;
    }
    if (localArrayList.isEmpty())
    {
      b();
      return;
    }
    a(localArrayList);
  }
  
  public void a(QQLiveAnchorRoomState paramQQLiveAnchorRoomState)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeState, old:");
      localStringBuilder.append(this.e.name());
      localStringBuilder.append(", new:");
      localStringBuilder.append(paramQQLiveAnchorRoomState.name());
      QLog.d("QQLiveAnchor_BaseRoom", 1, localStringBuilder.toString());
    }
    if (this.isDestroy) {
      return;
    }
    this.d.a(this.e, paramQQLiveAnchorRoomState);
    this.e = paramQQLiveAnchorRoomState;
  }
  
  public void a(IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback)
  {
    if (this.isDestroy) {
      return;
    }
    if (paramIQQLiveAnchorRoomCallback != null) {
      this.d.a(paramIQQLiveAnchorRoomCallback);
    }
  }
  
  protected void a(QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    if (!this.isDestroy)
    {
      if (this.e != QQLiveAnchorRoomState.STATE_INIT_ING) {
        return;
      }
      a(QQLiveAnchorRoomState.STATE_INIT_FAILED);
      this.isInited = false;
      this.d.a(new QQLiveAnchorDataInit(false, paramQQLiveErrorMsg));
      this.d.a(paramQQLiveErrorMsg);
    }
  }
  
  protected void a(ArrayList<String> paramArrayList)
  {
    this.n = false;
    QQLiveAnchorDataCheckPermission localQQLiveAnchorDataCheckPermission = new QQLiveAnchorDataCheckPermission();
    localQQLiveAnchorDataCheckPermission.isSuccess = false;
    localQQLiveAnchorDataCheckPermission.errorMsg = new QQLiveErrorMsg(2, 6102, "permision error", -1, "");
    localQQLiveAnchorDataCheckPermission.unGrantPermissions = paramArrayList;
    this.d.a(localQQLiveAnchorDataCheckPermission);
  }
  
  protected abstract String[] a();
  
  protected void b()
  {
    this.n = true;
    this.d.a(new QQLiveAnchorDataCheckPermission(true, null));
  }
  
  public void b(IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback)
  {
    if (this.isDestroy) {
      return;
    }
    if (paramIQQLiveAnchorRoomCallback != null) {
      this.d.b(paramIQQLiveAnchorRoomCallback);
    }
  }
  
  public IQQLiveSDK c()
  {
    if (this.isDestroy) {
      return null;
    }
    return this.liveSDK;
  }
  
  public QQLiveAnchorRoomState currentState()
  {
    return this.e;
  }
  
  protected void d()
  {
    if (!this.isDestroy)
    {
      if (this.e != QQLiveAnchorRoomState.STATE_INIT_ING) {
        return;
      }
      if (!this.isInited) {
        try
        {
          if ((!this.isInited) && (this.g.a))
          {
            a(QQLiveAnchorRoomState.STATE_INIT_READY);
            this.isInited = true;
            this.d.a(new QQLiveAnchorDataInit(true, null));
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom destroy");
    }
    if (this.isDestroy) {
      return;
    }
    if (!this.isExitRoom) {
      exitRoom(null);
    }
    a(QQLiveAnchorRoomState.STATE_DESTROY);
    super.destroy();
    e();
    this.k.g();
  }
  
  public void e()
  {
    if (this.isDestroy) {
      return;
    }
    this.d.g();
  }
  
  public void enterRoom()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom enterRoom");
    }
    if (this.isDestroy) {
      return;
    }
    if (this.e == QQLiveAnchorRoomState.STATE_ENTER_ING) {
      return;
    }
    if (this.o)
    {
      a(QQLiveAnchorRoomState.STATE_ENTER_FAILED);
      localObject = new QQLiveErrorMsg();
      ((QQLiveErrorMsg)localObject).bizModule = 2;
      ((QQLiveErrorMsg)localObject).bizErrCode = 6000;
      ((QQLiveErrorMsg)localObject).bizErrMsg = "already enteredRoom";
      this.d.a(new QQLiveAnchorDataEnter(false, (QQLiveErrorMsg)localObject));
      this.d.a((QQLiveErrorMsg)localObject);
      return;
    }
    this.d.d();
    a(QQLiveAnchorRoomState.STATE_ENTER_ING);
    Object localObject = QQLiveAnchorSSOHelper.c(this.c);
    IQQLiveSsoModule localIQQLiveSsoModule = (IQQLiveSsoModule)this.liveSDK.getExtModule("sso_module");
    if (localIQQLiveSsoModule == null)
    {
      QLog.e("QQLiveAnchor_BaseRoom", 4, "enter, get Sso module null");
      return;
    }
    localIQQLiveSsoModule.a("trpc.qlive.ilive_room_play.RoomPlay", "Enter", MessageNano.toByteArray((MessageNano)localObject), new QQLiveAnchorRoom.4(this, (EnterReq)localObject));
    i();
  }
  
  public void exitRoom(ExitRoomCallback paramExitRoomCallback)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("anchorRoom exitRoom: ");
      ((StringBuilder)localObject).append(this.isDestroy);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.isExitRoom);
      QLog.d("QQLiveAnchor_BaseRoom", 1, ((StringBuilder)localObject).toString());
    }
    if (this.isExitRoom) {
      return;
    }
    if (this.isDestroy) {
      return;
    }
    if (this.liveSDK.getAppRuntime() != null) {
      QQLiveAnchorHelperFastResume.a(this.a, this.liveSDK.getAppRuntime().getCurrentUin());
    }
    Object localObject = this.k;
    if (localObject != null) {
      ((QQLiveAnchorTechReport)localObject).f();
    }
    QQLiveAnchorHelperExit.a(this.liveSDK, this.appId, QQLiveAnchorSSOHelper.b(this.c), new QQLiveAnchorRoom.6(this));
    localObject = this.k;
    if (localObject != null) {
      ((QQLiveAnchorTechReport)localObject).e();
    }
    QQLiveAnchorHelperExit.a(this.liveSDK, this.appId, QQLiveAnchorSSOHelper.a(this.c, this.liveSDK.getConfigModule().getConfigData().getLiveClientType()), new QQLiveAnchorRoom.7(this, paramExitRoomCallback));
    a(QQLiveAnchorRoomState.STATE_LIVE_EXIT);
    this.d.a();
    j();
    super.exitRoom(paramExitRoomCallback);
  }
  
  public QQLiveAnchorRoomInfo f()
  {
    if (this.isDestroy) {
      return null;
    }
    return this.c;
  }
  
  public void fastExit(ExitRoomCallback paramExitRoomCallback)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("anchorRoom fastExit: ");
      ((StringBuilder)localObject).append(this.isDestroy);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.isExitRoom);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(this.m);
      QLog.d("QQLiveAnchor_BaseRoom", 1, ((StringBuilder)localObject).toString());
    }
    if (!this.m) {
      return;
    }
    if (!this.isExitRoom)
    {
      if (this.isDestroy) {
        return;
      }
      super.exitRoom(paramExitRoomCallback);
      localObject = this.k;
      if (localObject != null) {
        ((QQLiveAnchorTechReport)localObject).f();
      }
      QQLiveAnchorHelperExit.a(this.liveSDK, this.appId, QQLiveAnchorSSOHelper.b(this.c), new QQLiveAnchorRoom.8(this));
      int i1 = 0;
      try
      {
        int i2 = this.liveSDK.getConfigModule().getConfigData().getLiveClientType();
        i1 = i2;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQLiveAnchor_BaseRoom", 1, localThrowable, new Object[0]);
      }
      QQLiveAnchorTechReport localQQLiveAnchorTechReport = this.k;
      if (localQQLiveAnchorTechReport != null) {
        localQQLiveAnchorTechReport.e();
      }
      QQLiveAnchorHelperExit.a(this.liveSDK, this.appId, QQLiveAnchorSSOHelper.a(this.c, i1), new QQLiveAnchorRoom.9(this, paramExitRoomCallback));
      a(QQLiveAnchorRoomState.STATE_LIVE_EXIT);
    }
  }
  
  public void fastResume()
  {
    this.m = true;
  }
  
  public AppRuntime g()
  {
    if (this.isDestroy) {
      return null;
    }
    return this.liveSDK.getAppRuntime();
  }
  
  public BaseAnchorInfo getAnchorInfo()
  {
    if (this.isDestroy) {
      return null;
    }
    return new QQLiveAnchorDataUserInfo(this.c.userDta);
  }
  
  public QQLiveAnchorRoomInfo getAnchorRoomInfo()
  {
    if (this.isDestroy) {
      return null;
    }
    return new QQLiveAnchorRoomInfo(this.c);
  }
  
  public QQLiveAnchorRoomConfig getRoomConfig()
  {
    if (this.isDestroy) {
      return null;
    }
    return this.b;
  }
  
  public BaseRoomInfo getRoomInfo()
  {
    if (this.isDestroy) {
      return null;
    }
    return new QQLiveAnchorDataRoomInfo(this.c.roomData);
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    if (this.isDestroy) {
      return;
    }
    this.isExitRoom = false;
    this.isInited = false;
    a(QQLiveAnchorRoomState.STATE_INIT_ING);
    this.d.i();
    super.init(paramIQQLiveSDK);
    if (!this.n) {
      a(new QQLiveErrorMsg(2, 6102, "permision error", -1, ""));
    } else {
      k();
    }
    this.k.a(this);
  }
  
  public boolean isAnchorRoom()
  {
    return true;
  }
  
  protected void onEnterRoom()
  {
    if (this.isDestroy) {
      return;
    }
    super.onEnterRoom();
    this.f.a(this.liveSDK);
  }
  
  public void prepare(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom prepare");
    }
    if (this.isDestroy) {
      return;
    }
    QQLiveAnchorRoomInfo localQQLiveAnchorRoomInfo = this.c;
    if ((localQQLiveAnchorRoomInfo != null) && (localQQLiveAnchorRoomInfo.roomData != null) && (!TextUtils.isEmpty(this.c.roomData.programId)))
    {
      this.d.b();
      QLog.e("QQLiveAnchor_BaseRoom", 1, "already prepared");
      paramActivity = new QQLiveAnchorDataPrepare();
      paramActivity.isSuccess = true;
      paramActivity.roomInfo = this.c.roomData;
      paramActivity.roomAttr = this.c.roomAttr;
      this.d.a(paramActivity);
      return;
    }
    this.h.a(paramActivity, this.liveSDK, new QQLiveAnchorRoom.3(this, this.d));
  }
  
  public void registerRoomInfoListener(RoomInfoListener paramRoomInfoListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.f.a(paramRoomInfoListener);
  }
  
  public void reset()
  {
    super.reset();
    this.f.a();
    this.d.g();
  }
  
  public void setAnchorRoomConfig(QQLiveAnchorRoomConfig paramQQLiveAnchorRoomConfig)
  {
    this.b = paramQQLiveAnchorRoomConfig;
  }
  
  public void setAnchorRoomInfo(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo)
  {
    this.c = paramQQLiveAnchorRoomInfo;
  }
  
  public void startHeart()
  {
    if (!this.isDestroy)
    {
      if (this.isExitRoom) {
        return;
      }
      super.startHeart();
    }
  }
  
  public void startPublishStream()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom startPublish");
    }
    if (this.isDestroy) {
      return;
    }
    if (this.e == QQLiveAnchorRoomState.STATE_PUBLISH_ING) {
      return;
    }
    this.d.e();
    if ((this.e != QQLiveAnchorRoomState.STATE_ENTER_READY) && (this.e != QQLiveAnchorRoomState.STATE_PUBLISH_FAILED))
    {
      a(QQLiveAnchorRoomState.STATE_PUBLISH_FAILED);
      localObject1 = new QQLiveErrorMsg();
      ((QQLiveErrorMsg)localObject1).bizModule = 2;
      ((QQLiveErrorMsg)localObject1).bizErrCode = 6000;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("check publish error, curState=");
      ((StringBuilder)localObject2).append(this.e.name());
      ((QQLiveErrorMsg)localObject1).bizErrMsg = ((StringBuilder)localObject2).toString();
      this.d.a(new QQLiveAnchorDataPublishStream(false, (QQLiveErrorMsg)localObject1));
      this.d.a((QQLiveErrorMsg)localObject1);
      return;
    }
    a(QQLiveAnchorRoomState.STATE_PUBLISH_ING);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uid:");
      ((StringBuilder)localObject1).append(this.c.userDta.id);
      ((StringBuilder)localObject1).append(", roomId:");
      ((StringBuilder)localObject1).append(this.c.roomData.id);
      ((StringBuilder)localObject1).append(", streamId:");
      ((StringBuilder)localObject1).append(this.c.trtcData.streamInfo.mainStreamId);
      ((StringBuilder)localObject1).append(", sig:");
      ((StringBuilder)localObject1).append(this.c.trtcData.sig);
      QLog.d("QQLiveAnchor_BaseRoom", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = QQLiveAnchorSSOHelper.b(this.c, this.liveSDK.getConfigModule().getConfigData().getLiveClientType());
    Object localObject2 = (IQQLiveSsoModule)this.liveSDK.getExtModule("sso_module");
    if (localObject2 == null)
    {
      QLog.e("QQLiveAnchor_BaseRoom", 4, "publish, get Sso module null");
      return;
    }
    ((IQQLiveSsoModule)localObject2).a("trpc.qlive.media_logic4opensdk.MediaLogic", "StartNew", MessageNano.toByteArray((MessageNano)localObject1), new QQLiveAnchorRoom.5(this));
  }
  
  public void startSet(QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveAnchor_BaseRoom", 1, "anchorRoom startSet");
    }
    if (this.isDestroy) {
      return;
    }
    this.d.c();
    this.i.a(this.liveSDK, this.c, paramQQLiveAnchorDataRoomAttr, this.d);
  }
  
  public void unRegisterRoomInfoListener(RoomInfoListener paramRoomInfoListener)
  {
    if (this.isDestroy) {
      return;
    }
    this.f.b(paramRoomInfoListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom
 * JD-Core Version:    0.7.0.1
 */