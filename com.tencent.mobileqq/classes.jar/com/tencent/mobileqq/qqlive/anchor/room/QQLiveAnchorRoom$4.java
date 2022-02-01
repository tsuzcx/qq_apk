package com.tencent.mobileqq.qqlive.anchor.room;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorSSOHelper;
import com.tencent.mobileqq.qqlive.anchor.util.QQLiveAnchorThrowable;
import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataEnter;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataMediaInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataUserInfo;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.EnterReq;
import com.tencent.qqlive.protobuf.iliveRoomPlay.nano.EnterRsp;

class QQLiveAnchorRoom$4
  extends QQLiveBusinessObserver
{
  QQLiveAnchorRoom$4(QQLiveAnchorRoom paramQQLiveAnchorRoom, EnterReq paramEnterReq) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (!QQLiveAnchorRoom.e(this.b))
    {
      if (this.b.e != QQLiveAnchorRoomState.STATE_ENTER_ING) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enter receive, type:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", success:");
        localStringBuilder.append(paramBoolean);
        QLog.d("QQLiveAnchor_BaseRoom", 1, localStringBuilder.toString());
      }
      try
      {
        QQLiveAnchorSSOHelper.a(paramInt, paramBoolean, paramQQLiveRspData);
        paramQQLiveRspData = EnterRsp.a(paramQQLiveRspData.a());
        if (paramQQLiveRspData.a == 0)
        {
          paramQQLiveRspData = QQLiveAnchorSSOHelper.a(paramQQLiveRspData);
          if (TextUtils.isEmpty(this.b.c.roomData.programId)) {
            this.b.c.roomData.programId = this.a.c;
          }
          this.b.c.userDta = new QQLiveAnchorDataUserInfo(paramQQLiveRspData.userInfo);
          this.b.c.mediaData = new QQLiveAnchorDataMediaInfo(paramQQLiveRspData.mediaInfo);
          this.b.c.trtcData = new QQLiveAnchorDataTrtcInfo(paramQQLiveRspData.trtcInfo);
          this.b.a(QQLiveAnchorRoomState.STATE_ENTER_READY);
          this.b.d.a(paramQQLiveRspData);
          this.b.onEnterRoom();
          this.b.o = true;
          return;
        }
        throw new QQLiveAnchorThrowable("enter rsp error", paramQQLiveRspData.a, paramQQLiveRspData.b);
      }
      catch (Throwable paramQQLiveRspData)
      {
        QLog.d("QQLiveAnchor_BaseRoom", 1, "enter failed: ", paramQQLiveRspData);
        this.b.a(QQLiveAnchorRoomState.STATE_ENTER_FAILED);
        paramQQLiveRspData = QQLiveAnchorThrowable.covert(6250, paramQQLiveRspData);
        this.b.d.a(paramQQLiveRspData);
        this.b.d.a(new QQLiveAnchorDataEnter(false, paramQQLiveRspData));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom.4
 * JD-Core Version:    0.7.0.1
 */