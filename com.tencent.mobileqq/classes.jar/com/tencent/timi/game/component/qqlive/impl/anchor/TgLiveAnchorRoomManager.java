package com.tencent.timi.game.component.qqlive.impl.anchor;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom;
import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataBase;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.realtime.LiveRealTimeInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.component.qqlive.api.SimpleTgLiveAnchorStartListener;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorStartListener;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomCommonManager;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomListenerHandler;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomUIData;
import com.tencent.timi.game.component.qqlive.impl.util.TgLiveUtils;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.livedata.BetterLiveData;
import mqq.app.AppRuntime;

public class TgLiveAnchorRoomManager
  implements ITgLiveAnchorRoomManager
{
  private static volatile TgLiveAnchorRoomManager c;
  public MutableLiveData<Boolean> a;
  public MutableLiveData<QQLiveAnchorDataPublishStream> b;
  private IQQLiveAnchorRoom d;
  private MutableLiveData<Boolean> e;
  private MutableLiveData<QQLiveAnchorDataPrepare> f;
  private MutableLiveData<Boolean> g;
  private MutableLiveData<QQLiveAnchorDataPushInfo> h;
  private MutableLiveData<Boolean> i;
  private TgLiveAnchorStartListener j;
  private boolean k;
  private boolean l;
  private IQQLiveAnchorRoomCallback m;
  
  private TgLiveAnchorRoomManager()
  {
    Boolean localBoolean = Boolean.valueOf(false);
    this.a = new MutableLiveData(localBoolean);
    this.b = new MutableLiveData(null);
    this.e = new MutableLiveData(localBoolean);
    this.f = new MutableLiveData(null);
    this.g = new MutableLiveData(localBoolean);
    this.h = new MutableLiveData(null);
    this.k = false;
    this.l = false;
    this.m = new TgLiveAnchorRoomManager.1(this);
  }
  
  public static TgLiveAnchorRoomManager a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new TgLiveAnchorRoomManager();
        }
      }
      finally {}
    }
    return c;
  }
  
  private void a(QQLiveAnchorRecord paramQQLiveAnchorRecord)
  {
    Object localObject = TgLiveRoomCommonManager.a().c();
    this.d = ((IQQLiveSDK)localObject).getAnchorModule().createFastResumeRoom(paramQQLiveAnchorRecord, this.m);
    this.d.a(this.m);
    TgLiveRoomListenerHandler.a(this.d);
    a(true);
    TgLiveRoomUIData.a().a(c());
    this.d.init((IQQLiveSDK)localObject);
    this.d.fastResume();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("finallyResumeLiveRoom END - ");
    ((StringBuilder)localObject).append(paramQQLiveAnchorRecord.roomId);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramQQLiveAnchorRecord.streamType);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", ((StringBuilder)localObject).toString());
  }
  
  private void a(QQLiveAnchorDataBase paramQQLiveAnchorDataBase, View paramView)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("callFinalLiveStreamResultSuccess - ");
    ((StringBuilder)localObject).append(this.j);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", ((StringBuilder)localObject).toString());
    localObject = this.j;
    if (localObject != null)
    {
      ((TgLiveAnchorStartListener)localObject).a(paramQQLiveAnchorDataBase.isSuccess, paramQQLiveAnchorDataBase, paramView);
      this.j = null;
    }
  }
  
  private void a(QQLiveAnchorDataEnter paramQQLiveAnchorDataEnter)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleOnEnterResult, enterResult.isSuccess = ");
    localStringBuilder.append(paramQQLiveAnchorDataEnter.isSuccess);
    localStringBuilder.append(", anchorRoomId = ");
    Object localObject2 = paramQQLiveAnchorDataEnter.roomInfo;
    Object localObject1 = Integer.valueOf(0);
    if (localObject2 != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramQQLiveAnchorDataEnter.roomInfo.getRoomId());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramQQLiveAnchorDataEnter.roomInfo.name);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = localObject1;
    }
    localStringBuilder.append(localObject2);
    localStringBuilder.append(", anchorUid = ");
    long l1;
    if (paramQQLiveAnchorDataEnter.userInfo != null) {
      l1 = paramQQLiveAnchorDataEnter.userInfo.id;
    } else {
      l1 = 0L;
    }
    localStringBuilder.append(l1);
    localStringBuilder.append(", bizId = ");
    if (paramQQLiveAnchorDataEnter.userInfo != null) {
      localObject1 = paramQQLiveAnchorDataEnter.userInfo.businessUid;
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(", errorMsg = ");
    localStringBuilder.append(paramQQLiveAnchorDataEnter.errorMsg);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", localStringBuilder.toString());
    localObject1 = this.j;
    if (localObject1 != null)
    {
      ((TgLiveAnchorStartListener)localObject1).a(paramQQLiveAnchorDataEnter.isSuccess, paramQQLiveAnchorDataEnter);
      if (!paramQQLiveAnchorDataEnter.isSuccess) {
        this.j.a(5, paramQQLiveAnchorDataEnter.errorMsg.bizErrCode, paramQQLiveAnchorDataEnter.errorMsg.bizErrMsg);
      }
    }
    if (paramQQLiveAnchorDataEnter.isSuccess)
    {
      localObject1 = TgLiveRoomUIData.a();
      ((TgLiveRoomUIData)localObject1).b(Boolean.valueOf(true));
      if ((paramQQLiveAnchorDataEnter.roomInfo != null) && (TextUtils.isEmpty(paramQQLiveAnchorDataEnter.roomInfo.coverUrl16v9)))
      {
        QLog.i("TgLiveTag_TgLiveAnchorRoomManager", 1, "update roomInfo.");
        ((TgLiveRoomUIData)localObject1).a(paramQQLiveAnchorDataEnter.roomInfo.coverUrl16v9);
      }
      if (this.d != null)
      {
        paramQQLiveAnchorDataEnter = this.j;
        if (paramQQLiveAnchorDataEnter != null) {
          paramQQLiveAnchorDataEnter.d();
        }
        this.d.startPublishStream();
      }
    }
  }
  
  private void a(QQLiveAnchorDataFastResume paramQQLiveAnchorDataFastResume)
  {
    Object localObject;
    if (this.d != null) {
      if (paramQQLiveAnchorDataFastResume.isSuccess)
      {
        localObject = TgLiveRoomUIData.a();
        ((TgLiveRoomUIData)localObject).b(Boolean.valueOf(true));
        ((TgLiveRoomUIData)localObject).c(Boolean.valueOf(true));
      }
      else
      {
        CustomToastView.a("恢复直播失败");
        d();
        TgLiveUtils.b(true);
      }
    }
    if (this.d != null)
    {
      localObject = this.i;
      if (localObject != null) {
        ((MutableLiveData)localObject).setValue(Boolean.valueOf(paramQQLiveAnchorDataFastResume.isSuccess));
      }
    }
    if (this.j != null)
    {
      if (!paramQQLiveAnchorDataFastResume.isSuccess)
      {
        this.j.a(11, paramQQLiveAnchorDataFastResume.errorMsg.bizErrCode, paramQQLiveAnchorDataFastResume.errorMsg.bizErrMsg);
        return;
      }
      a(paramQQLiveAnchorDataFastResume, c());
    }
  }
  
  private void d()
  {
    boolean bool = TgLiveRoomCommonManager.a().b();
    IQQLiveSDK localIQQLiveSDK = TgLiveRoomCommonManager.a().c();
    if ((bool) && (localIQQLiveSDK != null)) {
      localIQQLiveSDK.getAnchorModule().removeAnchorRecord(localIQQLiveSDK.getAppRuntime().getCurrentUin());
    }
  }
  
  public LiveData<Boolean> a(long paramLong, String paramString, SimpleTgLiveAnchorStartListener paramSimpleTgLiveAnchorStartListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resumeRoomIfCan resumeRoomId = ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(", programId = ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", ((StringBuilder)localObject).toString());
    if (paramSimpleTgLiveAnchorStartListener != null)
    {
      if (this.j != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("resumeRoomIfCan but already has mAnchorStartListener!! old = ");
        ((StringBuilder)localObject).append(this.j);
        ((StringBuilder)localObject).append(", new = ");
        ((StringBuilder)localObject).append(paramSimpleTgLiveAnchorStartListener);
        Logger.c("TgLiveTag_TgLiveAnchorRoomManager", ((StringBuilder)localObject).toString());
      }
      this.j = paramSimpleTgLiveAnchorStartListener;
    }
    if (this.d != null)
    {
      paramSimpleTgLiveAnchorStartListener = new StringBuilder();
      paramSimpleTgLiveAnchorStartListener.append("resumeRoomIfCan but mAnchorRoom has been create --- ");
      paramSimpleTgLiveAnchorStartListener.append(this.d);
      Logger.c("TgLiveTag_TgLiveAnchorRoomManager", paramSimpleTgLiveAnchorStartListener.toString());
    }
    this.i = new BetterLiveData();
    if (!TgLiveRoomCommonManager.a().b())
    {
      QLog.e("TgLiveTag_TgLiveAnchorRoomManager", 1, "resumeRoomIfCan, sdk not init suc.");
      this.i.setValue(Boolean.valueOf(false));
      paramString = this.j;
      if (paramString != null) {
        paramString.a(11, -1, "SDK尚未初始化");
      }
      return this.i;
    }
    paramSimpleTgLiveAnchorStartListener = TgLiveRoomCommonManager.a().c();
    localObject = paramSimpleTgLiveAnchorStartListener.getAppRuntime().getCurrentUin();
    paramSimpleTgLiveAnchorStartListener = paramSimpleTgLiveAnchorStartListener.getAnchorModule().getValidAnchorRecord((String)localObject);
    if (paramSimpleTgLiveAnchorStartListener == null)
    {
      Logger.c("TgLiveTag_TgLiveAnchorRoomManager", "resumeRoomIfCan no anchor record");
      a(paramLong, paramString);
      this.i.setValue(Boolean.valueOf(false));
      paramString = this.j;
      if (paramString != null) {
        paramString.a(11, -2, "没有可复播的房间");
      }
    }
    else
    {
      paramString = new StringBuilder();
      paramString.append("record roomId:");
      paramString.append(paramSimpleTgLiveAnchorStartListener.roomId);
      paramString.append(" uid:");
      paramString.append(paramSimpleTgLiveAnchorStartListener.uid);
      Logger.a("TgLiveTag_TgLiveAnchorRoomManager", paramString.toString());
      if ((paramLong > 0L) && (paramLong != paramSimpleTgLiveAnchorStartListener.roomId))
      {
        Logger.c("TgLiveTag_TgLiveAnchorRoomManager", "record.roomId != resumeRoomId， don't resume.");
        a(paramSimpleTgLiveAnchorStartListener.roomId, paramSimpleTgLiveAnchorStartListener.programId);
        this.i.setValue(Boolean.valueOf(false));
        paramString = this.j;
        if (paramString != null) {
          paramString.a(11, -3, "复播失败, 房间信息不一致");
        }
      }
      else if (!TgLiveUtils.a(true))
      {
        Logger.c("TgLiveTag_TgLiveAnchorRoomManager", "resumeRoomIfCan requestAVFocus failure.");
        this.i.setValue(Boolean.valueOf(false));
        paramString = this.j;
        if (paramString != null) {
          paramString.a(1, -4, "当前音视频被占用");
        }
      }
      else
      {
        TgLiveUtils.a(paramSimpleTgLiveAnchorStartListener.streamType, new TgLiveAnchorRoomManager.3(this, paramSimpleTgLiveAnchorStartListener));
      }
    }
    return this.i;
  }
  
  public LiveData<QQLiveAnchorDataPrepare> a(Activity paramActivity)
  {
    TgLiveAnchorStartListener localTgLiveAnchorStartListener = this.j;
    if (localTgLiveAnchorStartListener != null) {
      localTgLiveAnchorStartListener.b();
    }
    this.d.prepare(paramActivity);
    TgLiveRoomListenerHandler.a(this.d);
    a(false);
    return this.f;
  }
  
  public LiveData<Boolean> a(QQLiveAnchorStreamRecordType paramQQLiveAnchorStreamRecordType, boolean paramBoolean, TgLiveAnchorStartListener paramTgLiveAnchorStartListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("anchorCreateRoom - ");
    ((StringBuilder)localObject).append(paramQQLiveAnchorStreamRecordType);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", ((StringBuilder)localObject).toString());
    if (paramTgLiveAnchorStartListener != null)
    {
      if (this.j != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("anchorCreateRoom but already has mAnchorStartListener!! old = ");
        ((StringBuilder)localObject).append(this.j);
        ((StringBuilder)localObject).append(", new = ");
        ((StringBuilder)localObject).append(paramTgLiveAnchorStartListener);
        Logger.c("TgLiveTag_TgLiveAnchorRoomManager", ((StringBuilder)localObject).toString());
      }
      this.j = paramTgLiveAnchorStartListener;
      this.j.a();
    }
    if (this.d != null)
    {
      paramTgLiveAnchorStartListener = new StringBuilder();
      paramTgLiveAnchorStartListener.append("anchorCreateRoom but mAnchorRoom has been create --- ");
      paramTgLiveAnchorStartListener.append(this.d);
      Logger.c("TgLiveTag_TgLiveAnchorRoomManager", paramTgLiveAnchorStartListener.toString());
    }
    paramTgLiveAnchorStartListener = TgLiveRoomCommonManager.a().c();
    if ((paramTgLiveAnchorStartListener != null) && (TgLiveRoomCommonManager.a().b()))
    {
      localObject = paramTgLiveAnchorStartListener.getAnchorModule().getCurRoom();
      if ((localObject != null) && (this.d == null))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("anchorCreateRoom  but already has sdk cache --- ");
        localStringBuilder.append(localObject);
        localStringBuilder.append(", state = ");
        localStringBuilder.append(((IQQLiveAnchorRoom)localObject).currentState());
        Logger.c("TgLiveTag_TgLiveAnchorRoomManager", localStringBuilder.toString());
      }
      this.k = paramBoolean;
      if ((paramBoolean) && (localObject != null) && (((IQQLiveAnchorRoom)localObject).currentState() == QQLiveAnchorRoomState.STATE_CREATE))
      {
        QLog.e("TgLiveTag_TgLiveAnchorRoomManager", 1, "use prepared room");
        this.d = ((IQQLiveAnchorRoom)localObject);
        this.d.a(this.m);
      }
      else
      {
        QLog.e("TgLiveTag_TgLiveAnchorRoomManager", 1, "create new room");
        localObject = new QQLiveAnchorRoomConfig();
        ((QQLiveAnchorRoomConfig)localObject).streamRecordType = paramQQLiveAnchorStreamRecordType;
        this.d = paramTgLiveAnchorStartListener.getAnchorModule().createRoom(TimiGameActivityManager.a(), (QQLiveAnchorRoomConfig)localObject, this.m);
      }
      this.d.init(paramTgLiveAnchorStartListener);
      return this.e;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TgLiveTag_TgLiveAnchorRoomManager", 1, "anchorCreateRoom, live sdk not init suc.");
    }
    paramQQLiveAnchorStreamRecordType = this.j;
    if (paramQQLiveAnchorStreamRecordType != null)
    {
      paramQQLiveAnchorStreamRecordType.a(false, null);
      this.j.a(3, -1, "SDK尚未初始化");
    }
    return this.e;
  }
  
  public LiveData<Boolean> a(IResultListener<LiveRealTimeInfo> paramIResultListener)
  {
    QLog.i("TgLiveTag_TgLiveAnchorRoomManager", 1, "anchorExitRoom.");
    Boolean localBoolean = Boolean.valueOf(false);
    this.k = false;
    this.l = false;
    this.j = null;
    if (this.d != null)
    {
      TgLiveRoomListenerHandler.a();
      long l1 = this.d.getRoomInfo().getRoomId();
      IQQLiveAnchorRoom localIQQLiveAnchorRoom = this.d;
      localIQQLiveAnchorRoom.exitRoom(new TgLiveAnchorRoomManager.2(this, l1, paramIResultListener, localIQQLiveAnchorRoom));
      this.e.setValue(localBoolean);
      this.f.setValue(null);
      this.h.setValue(null);
      this.a.setValue(localBoolean);
      this.b.setValue(null);
      this.d = null;
      this.i = null;
      TgLiveRoomUIData.a().d();
    }
    else if (paramIResultListener != null)
    {
      paramIResultListener.a(-1000, "数据异常");
    }
    TgLiveUtils.b(true);
    return this.g;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyOnVideoSizeChanged width_");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" height_");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(", mHasThirdPushChecked = ");
    ((StringBuilder)localObject).append(this.l);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", ((StringBuilder)localObject).toString());
    if ((!this.l) && ((paramInt1 > 0) || (paramInt2 > 0)))
    {
      localObject = this.d;
      if ((localObject != null) && (((IQQLiveAnchorRoom)localObject).getRoomConfig().streamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH))
      {
        this.l = true;
        Logger.c("TgLiveTag_TgLiveAnchorRoomManager", "notifyOnVideoSizeChanged tmp code");
        localObject = this.j;
        if (localObject != null) {
          ((TgLiveAnchorStartListener)localObject).c();
        }
        this.d.enterRoom();
      }
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("forceExitLiveRoom - ");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(" - ");
    ((StringBuilder)localObject).append(paramString);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", ((StringBuilder)localObject).toString());
    if (paramLong <= 0L) {
      return;
    }
    localObject = TgLiveRoomCommonManager.a().c();
    if (localObject != null)
    {
      int n = ((IQQLiveSDK)localObject).getAnchorModule().tryCloseIsolatedRoom(paramLong, paramString);
      paramString = new StringBuilder();
      paramString.append("forceExitLiveRoom. resultCode=");
      paramString.append(n);
      QLog.i("TgLiveTag_TgLiveAnchorRoomManager", 1, paramString.toString());
      if (n == 0) {
        CustomToastView.a("强退房间成功");
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setVideoScaleFullScreen ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.d);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", ((StringBuilder)localObject).toString());
    localObject = this.d;
    if (localObject != null)
    {
      if ((localObject instanceof IQQLiveAnchorTRTCRoom))
      {
        localObject = (FrameLayout)((IQQLiveAnchorTRTCRoom)localObject).getDisplayView();
        return;
      }
      if ((localObject instanceof IQQLiveAnchorThirdPushRoom)) {
        ((ITPPlayerVideoView)((IQQLiveAnchorThirdPushRoom)localObject).getDisplayView()).setXYAxis(0);
      }
    }
  }
  
  public IQQLiveAnchorRoom b()
  {
    return this.d;
  }
  
  public View c()
  {
    Object localObject3 = this.d;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      if ((localObject3 instanceof IQQLiveAnchorTRTCRoom)) {
        return (View)((IQQLiveAnchorTRTCRoom)localObject3).getDisplayView();
      }
      localObject1 = localObject2;
      if ((localObject3 instanceof ILiveTPPlayerRoom))
      {
        localObject3 = (ITPPlayerVideoView)((ILiveTPPlayerRoom)localObject3).getDisplayView();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((ITPPlayerVideoView)localObject3).getCurrentDisplayView();
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager
 * JD-Core Version:    0.7.0.1
 */