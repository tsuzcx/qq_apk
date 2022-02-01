package com.tencent.timi.game.component.qqlive.impl.anchor;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomThirdPushBaseCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataFastResume;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataInit;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPublishStream;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPushInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataSet;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorStartListener;
import com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomUIData;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;

class TgLiveAnchorRoomManager$1
  extends QQLiveAnchorRoomThirdPushBaseCallback
{
  TgLiveAnchorRoomManager$1(TgLiveAnchorRoomManager paramTgLiveAnchorRoomManager) {}
  
  public void a()
  {
    TgLiveAnchorRoomManager.g(this.a).setValue(Boolean.valueOf(true));
  }
  
  public void a(QQLiveAnchorDataEnter paramQQLiveAnchorDataEnter)
  {
    TgLiveAnchorRoomManager.a(this.a, paramQQLiveAnchorDataEnter);
  }
  
  public void a(QQLiveAnchorDataFastResume paramQQLiveAnchorDataFastResume)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFastResumeResult result:");
    localStringBuilder.append(paramQQLiveAnchorDataFastResume.isSuccess);
    localStringBuilder.append(" msg:");
    localStringBuilder.append(paramQQLiveAnchorDataFastResume.errorMsg);
    QLog.i("TgLiveTag_TgLiveAnchorRoomManager", 1, localStringBuilder.toString());
    TgLiveAnchorRoomManager.a(this.a, paramQQLiveAnchorDataFastResume);
  }
  
  public void a(QQLiveAnchorDataInit paramQQLiveAnchorDataInit)
  {
    super.a(paramQQLiveAnchorDataInit);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onInit suc: ");
    localStringBuilder.append(paramQQLiveAnchorDataInit.isSuccess);
    localStringBuilder.append(" errorMsg:");
    localStringBuilder.append(paramQQLiveAnchorDataInit.errorMsg);
    QLog.d("TgLiveTag_TgLiveAnchorRoomManager", 2, localStringBuilder.toString());
    TgLiveAnchorRoomManager.a(this.a).setValue(Boolean.valueOf(paramQQLiveAnchorDataInit.isSuccess));
    if (TgLiveAnchorRoomManager.b(this.a) != null)
    {
      TgLiveAnchorRoomManager.b(this.a).a(paramQQLiveAnchorDataInit.isSuccess, paramQQLiveAnchorDataInit);
      if (!paramQQLiveAnchorDataInit.isSuccess) {
        TgLiveAnchorRoomManager.b(this.a).a(3, paramQQLiveAnchorDataInit.errorMsg.bizErrCode, paramQQLiveAnchorDataInit.errorMsg.bizErrMsg);
      }
    }
  }
  
  public void a(QQLiveAnchorDataPrepare paramQQLiveAnchorDataPrepare)
  {
    super.a(paramQQLiveAnchorDataPrepare);
    TgLiveAnchorRoomManager.c(this.a).setValue(paramQQLiveAnchorDataPrepare);
    if (TgLiveAnchorRoomManager.b(this.a) != null)
    {
      TgLiveAnchorRoomManager.b(this.a).a(paramQQLiveAnchorDataPrepare.isSuccess, paramQQLiveAnchorDataPrepare);
      if (!paramQQLiveAnchorDataPrepare.isSuccess) {
        TgLiveAnchorRoomManager.b(this.a).a(4, paramQQLiveAnchorDataPrepare.errorMsg.bizErrCode, paramQQLiveAnchorDataPrepare.errorMsg.bizErrMsg);
      }
    }
    StringBuilder localStringBuilder;
    if (paramQQLiveAnchorDataPrepare.isSuccess)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPrepare success, roomId = ");
      localStringBuilder.append(paramQQLiveAnchorDataPrepare.roomAttr.roomId);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramQQLiveAnchorDataPrepare.roomAttr.roomName);
      Logger.a("TgLiveTag_TgLiveAnchorRoomManager", localStringBuilder.toString());
      if (TgLiveAnchorRoomManager.d(this.a) != null)
      {
        TgLiveRoomUIData.a().a(paramQQLiveAnchorDataPrepare.roomAttr.poster16v9);
        paramQQLiveAnchorDataPrepare = TgLiveAnchorRoomManager.d(this.a).getRoomConfig().streamRecordType;
        if ((paramQQLiveAnchorDataPrepare != QQLiveAnchorStreamRecordType.SCREEN) && ((!TgLiveAnchorRoomManager.e(this.a)) || (paramQQLiveAnchorDataPrepare != QQLiveAnchorStreamRecordType.THIRD_PUSH)))
        {
          if (paramQQLiveAnchorDataPrepare == QQLiveAnchorStreamRecordType.THIRD_PUSH)
          {
            paramQQLiveAnchorDataPrepare = new QQLiveAnchorAutoCheckPullPlayParams();
            paramQQLiveAnchorDataPrepare.autoCheckPullPlay = true;
            ((IQQLiveAnchorThirdPushRoom)TgLiveAnchorRoomManager.d(this.a)).getRtmpPushUrl(paramQQLiveAnchorDataPrepare);
          }
        }
        else
        {
          Logger.a("TgLiveTag_TgLiveAnchorRoomManager", "onPrepare success, onEnterRoomStart");
          if (TgLiveAnchorRoomManager.b(this.a) != null) {
            TgLiveAnchorRoomManager.b(this.a).c();
          }
          TgLiveAnchorRoomManager.d(this.a).enterRoom();
        }
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPrepare failed - ");
      localStringBuilder.append(paramQQLiveAnchorDataPrepare.errorMsg);
      Logger.c("TgLiveTag_TgLiveAnchorRoomManager", localStringBuilder.toString());
      CustomToastView.a(paramQQLiveAnchorDataPrepare.errorMsg.bizErrMsg);
    }
  }
  
  public void a(QQLiveAnchorDataPublishStream paramQQLiveAnchorDataPublishStream)
  {
    this.a.b.setValue(paramQQLiveAnchorDataPublishStream);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPublishStream suc: ");
    ((StringBuilder)localObject).append(paramQQLiveAnchorDataPublishStream.isSuccess);
    ((StringBuilder)localObject).append("errMsg: ");
    ((StringBuilder)localObject).append(paramQQLiveAnchorDataPublishStream.errorMsg);
    QLog.d("TgLiveTag_TgLiveAnchorRoomManager", 2, ((StringBuilder)localObject).toString());
    TgLiveRoomUIData.a().c(Boolean.valueOf(true));
    localObject = this.a.c();
    TgLiveRoomUIData.a().a((View)localObject);
    if (TgLiveAnchorRoomManager.b(this.a) != null)
    {
      if (!paramQQLiveAnchorDataPublishStream.isSuccess)
      {
        TgLiveAnchorRoomManager.b(this.a).a(8, paramQQLiveAnchorDataPublishStream.errorMsg.bizErrCode, paramQQLiveAnchorDataPublishStream.errorMsg.bizErrMsg);
        return;
      }
      TgLiveAnchorRoomManager.a(this.a, paramQQLiveAnchorDataPublishStream, (View)localObject);
    }
  }
  
  public void a(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo)
  {
    super.a(paramQQLiveAnchorDataPullInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetPullInfo: ");
    localStringBuilder.append(paramQQLiveAnchorDataPullInfo.isSuccess);
    localStringBuilder.append(" errorMsg:");
    localStringBuilder.append(paramQQLiveAnchorDataPullInfo.errorMsg);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramQQLiveAnchorDataPullInfo.defaultPlayUrl);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", localStringBuilder.toString());
    if (TgLiveAnchorRoomManager.b(this.a) != null) {
      TgLiveAnchorRoomManager.b(this.a).a(paramQQLiveAnchorDataPullInfo);
    }
    if (paramQQLiveAnchorDataPullInfo.isSuccess) {
      TextUtils.isEmpty(paramQQLiveAnchorDataPullInfo.defaultPlayUrl);
    }
  }
  
  public void a(QQLiveAnchorDataPushInfo paramQQLiveAnchorDataPushInfo)
  {
    super.a(paramQQLiveAnchorDataPushInfo);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onGetPushInfo: ");
    ((StringBuilder)localObject).append(paramQQLiveAnchorDataPushInfo.isSuccess);
    ((StringBuilder)localObject).append(" errorMsg:");
    ((StringBuilder)localObject).append(paramQQLiveAnchorDataPushInfo.errorMsg);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", ((StringBuilder)localObject).toString());
    TgLiveAnchorRoomManager.f(this.a).setValue(paramQQLiveAnchorDataPushInfo);
    if (TgLiveAnchorRoomManager.b(this.a) != null)
    {
      TgLiveAnchorStartListener localTgLiveAnchorStartListener = TgLiveAnchorRoomManager.b(this.a);
      boolean bool = paramQQLiveAnchorDataPushInfo.isSuccess;
      String str = "";
      if (paramQQLiveAnchorDataPushInfo != null) {
        localObject = paramQQLiveAnchorDataPushInfo.serverPart;
      } else {
        localObject = "";
      }
      if (paramQQLiveAnchorDataPushInfo != null) {
        str = paramQQLiveAnchorDataPushInfo.streamParam;
      }
      localTgLiveAnchorStartListener.a(bool, paramQQLiveAnchorDataPushInfo, (String)localObject, str);
      if (!paramQQLiveAnchorDataPushInfo.isSuccess) {
        TgLiveAnchorRoomManager.b(this.a).a(6, paramQQLiveAnchorDataPushInfo.errorMsg.bizErrCode, paramQQLiveAnchorDataPushInfo.errorMsg.bizErrMsg);
      }
    }
    if (paramQQLiveAnchorDataPushInfo.isSuccess)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetPushInfo: rtmpUrl= ");
      ((StringBuilder)localObject).append(paramQQLiveAnchorDataPushInfo.serverPart);
      ((StringBuilder)localObject).append(", rtmpKey = ");
      ((StringBuilder)localObject).append(paramQQLiveAnchorDataPushInfo.streamParam);
      ((StringBuilder)localObject).append(", expireTs = ");
      ((StringBuilder)localObject).append(paramQQLiveAnchorDataPushInfo.expireTs);
      Logger.a("TgLiveTag_TgLiveAnchorRoomManager", ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(QQLiveAnchorDataSet paramQQLiveAnchorDataSet)
  {
    super.a(paramQQLiveAnchorDataSet);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSetRoomInfo suc: ");
    localStringBuilder.append(paramQQLiveAnchorDataSet.isSuccess);
    localStringBuilder.append("errMsg: ");
    localStringBuilder.append(paramQQLiveAnchorDataSet.errorMsg);
    Logger.a("TgLiveTag_TgLiveAnchorRoomManager", localStringBuilder.toString());
  }
  
  public void a(QQLiveAnchorDataThirdPushCheck paramQQLiveAnchorDataThirdPushCheck)
  {
    super.a(paramQQLiveAnchorDataThirdPushCheck);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onThirdPushChecked isSuccess:");
    localStringBuilder.append(paramQQLiveAnchorDataThirdPushCheck.isSuccess);
    localStringBuilder.append(" errorMsg: ");
    localStringBuilder.append(paramQQLiveAnchorDataThirdPushCheck.errorMsg);
    QLog.d("TgLiveTag_TgLiveAnchorRoomManager", 2, localStringBuilder.toString());
    this.a.a.setValue(Boolean.valueOf(paramQQLiveAnchorDataThirdPushCheck.isSuccess));
    TgLiveAnchorRoomManager.a(this.a, true);
    if (TgLiveAnchorRoomManager.b(this.a) != null)
    {
      TgLiveAnchorRoomManager.b(this.a).a(paramQQLiveAnchorDataThirdPushCheck);
      if (!paramQQLiveAnchorDataThirdPushCheck.isSuccess) {
        TgLiveAnchorRoomManager.b(this.a).a(7, paramQQLiveAnchorDataThirdPushCheck.errorMsg.bizErrCode, paramQQLiveAnchorDataThirdPushCheck.errorMsg.bizErrMsg);
      }
    }
    if ((paramQQLiveAnchorDataThirdPushCheck.isSuccess) && (TgLiveAnchorRoomManager.d(this.a) != null) && (TgLiveAnchorRoomManager.d(this.a).getRoomConfig().streamRecordType == QQLiveAnchorStreamRecordType.THIRD_PUSH))
    {
      if (TgLiveAnchorRoomManager.b(this.a) != null) {
        TgLiveAnchorRoomManager.b(this.a).c();
      }
      TgLiveAnchorRoomManager.d(this.a).enterRoom();
    }
  }
  
  public void a(QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    super.a(paramQQLiveErrorMsg);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError bizErrMsg: ");
    localStringBuilder.append(paramQQLiveErrorMsg.bizErrMsg);
    localStringBuilder.append(" originErrMsg:");
    localStringBuilder.append(paramQQLiveErrorMsg.bizErrMsg);
    localStringBuilder.append(" bizErrCode:");
    localStringBuilder.append(paramQQLiveErrorMsg.bizErrCode);
    localStringBuilder.append(" bizModule:");
    localStringBuilder.append(paramQQLiveErrorMsg.bizModule);
    QLog.e("TgLiveTag_TgLiveAnchorRoomManager", 2, localStringBuilder.toString());
    if (paramQQLiveErrorMsg.bizErrCode == 6270) {
      CustomToastView.a("第三方推流失败");
    }
    if (TgLiveAnchorRoomManager.b(this.a) != null) {
      TgLiveAnchorRoomManager.b(this.a).a(9, paramQQLiveErrorMsg.bizErrCode, paramQQLiveErrorMsg.bizErrMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager.1
 * JD-Core Version:    0.7.0.1
 */