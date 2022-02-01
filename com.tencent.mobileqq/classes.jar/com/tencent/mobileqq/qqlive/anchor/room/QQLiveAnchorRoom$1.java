package com.tencent.mobileqq.qqlive.anchor.room;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.protobuf.MediaHeartBeat.nano.SendHeartBeatReq;

class QQLiveAnchorRoom$1
  implements Runnable
{
  QQLiveAnchorRoom$1(QQLiveAnchorRoom paramQQLiveAnchorRoom) {}
  
  public void run()
  {
    Object localObject = this.this$0.getRoomInfo();
    SendHeartBeatReq localSendHeartBeatReq = new SendHeartBeatReq();
    if (localObject != null)
    {
      localSendHeartBeatReq.a = QQLiveAnchorRoom.a(this.this$0).getConfigModule().getConfigData().getLiveClientType();
      localSendHeartBeatReq.d = ((int)((BaseRoomInfo)localObject).getRoomId());
      localSendHeartBeatReq.e = 1;
      localSendHeartBeatReq.b = 4;
    }
    localObject = (IQQLiveSsoModule)QQLiveAnchorRoom.b(this.this$0).getExtModule("sso_module");
    if (localObject != null) {
      ((IQQLiveSsoModule)localObject).a("trpc.qlive.media_hb4opensdk.MediaLogic", "SendHB", MessageNano.toByteArray(localSendHeartBeatReq), new QQLiveAnchorRoom.1.1(this));
    } else {
      QLog.e("QQLiveAnchor_BaseRoom", 4, "heart, get Sso module null");
    }
    if (this.this$0.j != null) {
      this.this$0.j.b(this.this$0.a, this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom.1
 * JD-Core Version:    0.7.0.1
 */