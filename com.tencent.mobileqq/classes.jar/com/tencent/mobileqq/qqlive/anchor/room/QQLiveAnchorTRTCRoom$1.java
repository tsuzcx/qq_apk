package com.tencent.mobileqq.qqlive.anchor.room;

import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperTRTC;
import com.tencent.mobileqq.qqlive.callback.anchor.QQLiveAnchorRoomBaseCallback;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataStreamInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams.Builder;

class QQLiveAnchorTRTCRoom$1
  extends QQLiveAnchorRoomBaseCallback
{
  QQLiveAnchorTRTCRoom$1(QQLiveAnchorTRTCRoom paramQQLiveAnchorTRTCRoom) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QQLiveAnchorTRTCRoom.a(this.a))
    {
      this.a.r = false;
      QQLiveErrorMsg localQQLiveErrorMsg = new QQLiveErrorMsg();
      localQQLiveErrorMsg.bizModule = 2;
      localQQLiveErrorMsg.bizErrCode = 6103;
      localQQLiveErrorMsg.bizErrMsg = "screenCaptureError";
      localQQLiveErrorMsg.originErrCode = paramInt;
      localQQLiveErrorMsg.originErrMsg = paramString;
      this.a.a(localQQLiveErrorMsg);
    }
  }
  
  public void e()
  {
    if (this.a.b.streamRecordType != QQLiveAnchorStreamRecordType.THIRD_PUSH)
    {
      QQLiveRoomParams localQQLiveRoomParams = new QQLiveRoomParams.Builder().setUserId(String.valueOf(this.a.c.userDta.id)).setRoomId(this.a.c.roomData.id).setRoleType(0).setScene(1).setUserSig(this.a.c.trtcData.sig).setStreamId(this.a.c.trtcData.streamInfo.mainStreamId).build();
      this.a.q.a(localQQLiveRoomParams);
    }
  }
  
  public void m()
  {
    if (QQLiveAnchorTRTCRoom.a(this.a))
    {
      QQLiveAnchorTRTCRoom localQQLiveAnchorTRTCRoom = this.a;
      localQQLiveAnchorTRTCRoom.r = false;
      QQLiveAnchorTRTCRoom.b(localQQLiveAnchorTRTCRoom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorTRTCRoom.1
 * JD-Core Version:    0.7.0.1
 */