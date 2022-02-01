package com.tencent.mobileqq.kandian.biz.xtab.msgboard;

import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4.ReqBody;
import tencent.im.oidb.cmd0xfa4.oidb_cmd0xfa4.ReqMsgBoardInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJXTabMessageBoardModule$requestMessageBoardRedDotInfo$1
  implements Runnable
{
  RIJXTabMessageBoardModule$requestMessageBoardRedDotInfo$1(RIJXTabMessageBoardModule paramRIJXTabMessageBoardModule) {}
  
  public final void run()
  {
    Object localObject1 = new oidb_cmd0xfa4.ReqBody();
    oidb_cmd0xfa4.ReqMsgBoardInfo localReqMsgBoardInfo = new oidb_cmd0xfa4.ReqMsgBoardInfo();
    PBUInt64Field localPBUInt64Field = localReqMsgBoardInfo.lst_time_stamp;
    Object localObject2 = RIJSPUtils.b("rij_message_board_last_update_time_key", Long.valueOf(0L));
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "RIJSPUtils.getReadInJoyS…_LAST_UPDATE_TIME_KEY, 0)");
    localPBUInt64Field.set(((Number)localObject2).longValue());
    ((oidb_cmd0xfa4.ReqBody)localObject1).req_red.set((MessageMicro)localReqMsgBoardInfo);
    localObject1 = ReadInJoyOidbHelper.a("OidbSvc.0xfa4", 4004, 1, ((oidb_cmd0xfa4.ReqBody)localObject1).toByteArray());
    this.this$0.sendPbReq((ToServiceMsg)localObject1);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[requestMessageBoardRedDotInfo] timeStamp = ");
    ((StringBuilder)localObject1).append(localReqMsgBoardInfo.lst_time_stamp.get());
    QLog.i("RIJXTabMessageBoardModule", 1, ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.msgboard.RIJXTabMessageBoardModule.requestMessageBoardRedDotInfo.1
 * JD-Core Version:    0.7.0.1
 */