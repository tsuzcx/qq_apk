package com.tencent.mobileqq.qqlive.api.impl.anchor;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.anchor.prepare.QQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorTRTCRoom;
import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorThirdPushRoom;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperExit;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.IQQLiveModuleAnchor;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRecord;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class QQLiveModuleAnchorImpl
  implements IQQLiveModuleAnchor
{
  private static final String TAG = "QQLiveSDK_anchor";
  private IQQLiveAnchorRoom curRoom = null;
  private IQQLiveSDK sdkImpl;
  
  public IQQLiveAnchorRoom createFastResumeRoom(QQLiveAnchorRecord paramQQLiveAnchorRecord, IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback)
  {
    this.curRoom = QQLiveAnchorHelperFastResume.a(this.sdkImpl, paramQQLiveAnchorRecord, paramIQQLiveAnchorRoomCallback);
    return this.curRoom;
  }
  
  public IQQLiveAnchorPrepareWrapper createPrepareWrapper()
  {
    return new QQLiveAnchorPrepareWrapper();
  }
  
  public IQQLiveAnchorRoom createRoom(Context paramContext, QQLiveAnchorRoomConfig paramQQLiveAnchorRoomConfig, IQQLiveAnchorRoomCallback paramIQQLiveAnchorRoomCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("anchor module create room: ");
      Object localObject;
      if (paramQQLiveAnchorRoomConfig == null) {
        localObject = "null";
      } else {
        localObject = paramQQLiveAnchorRoomConfig.streamRecordType;
      }
      localStringBuilder.append(localObject);
      QLog.d("QQLiveSDK_anchor", 1, localStringBuilder.toString());
    }
    if (paramQQLiveAnchorRoomConfig.streamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH) {
      this.curRoom = new QQLiveAnchorThirdPushRoom(paramContext, this.sdkImpl, paramQQLiveAnchorRoomConfig, paramIQQLiveAnchorRoomCallback);
    } else {
      this.curRoom = new QQLiveAnchorTRTCRoom(paramContext, this.sdkImpl, paramQQLiveAnchorRoomConfig, paramIQQLiveAnchorRoomCallback);
    }
    return this.curRoom;
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveSDK_anchor", 1, "anchor module destroy");
    }
    this.sdkImpl = null;
  }
  
  public void destroyRoom()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveSDK_anchor", 1, "anchor module, destroy room");
    }
    IQQLiveAnchorRoom localIQQLiveAnchorRoom = this.curRoom;
    if (localIQQLiveAnchorRoom != null) {
      localIQQLiveAnchorRoom.destroy();
    }
    this.curRoom = null;
  }
  
  public IQQLiveAnchorRoom getCurRoom()
  {
    return this.curRoom;
  }
  
  public QQLiveAnchorRecord getValidAnchorRecord(String paramString)
  {
    return QQLiveAnchorHelperFastResume.a(this.sdkImpl.getAppRuntime().getApplicationContext(), paramString, this.sdkImpl);
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveSDK_anchor", 1, "anchor module init");
    }
    this.sdkImpl = paramIQQLiveSDK;
  }
  
  public void removeAnchorRecord(String paramString)
  {
    QQLiveAnchorHelperFastResume.a(this.sdkImpl.getAppRuntime().getApplicationContext(), paramString);
  }
  
  public void reset() {}
  
  public int tryCloseIsolatedRoom(long paramLong, String paramString)
  {
    IQQLiveSDK localIQQLiveSDK = this.sdkImpl;
    if ((localIQQLiveSDK != null) && (localIQQLiveSDK.isInited()) && (this.sdkImpl.getLoginModule() != null) && (this.sdkImpl.getLoginModule().isLogined()))
    {
      if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString)))
      {
        localIQQLiveSDK = this.sdkImpl;
        QQLiveAnchorHelperExit.a(localIQQLiveSDK, localIQQLiveSDK.getAppId(), QQLiveAnchorSSOHelper.a(paramLong, paramString), new QQLiveModuleAnchorImpl.1(this));
        return 0;
      }
      return 6401;
    }
    return 6400;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveModuleAnchorImpl
 * JD-Core Version:    0.7.0.1
 */