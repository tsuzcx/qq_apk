package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class HeartbeatReportMgr$1
  implements Runnable
{
  HeartbeatReportMgr$1(HeartbeatReportMgr paramHeartbeatReportMgr) {}
  
  public void run()
  {
    long l = System.currentTimeMillis() - HeartbeatReportMgr.a(this.this$0);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportHeartbeat roomId = ");
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.b(this.this$0).get("roomid"));
    ((StringBuilder)localObject).append(", program_id = ");
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.b(this.this$0).get("program_id"));
    ((StringBuilder)localObject).append(", realTS = ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(", background = ");
    ((StringBuilder)localObject).append(HeartbeatReportMgr.c(this.this$0));
    ((StringBuilder)localObject).append(", play_state = ");
    ((StringBuilder)localObject).append(HeartbeatReportMgr.d(this.this$0).a());
    ((StringBuilder)localObject).append(", state = ");
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.b(this.this$0).get("state"));
    ((StringBuilder)localObject).append(", zt_int4 = ");
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.b(this.this$0).get("zt_int4"));
    ((StringBuilder)localObject).append(", zt_int5 = ");
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.b(this.this$0).get("zt_int5"));
    ((StringBuilder)localObject).append(", anchor = ");
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.b(this.this$0).get("anchor"));
    QLog.i("DataReportMgr", 1, ((StringBuilder)localObject).toString());
    HeartbeatReportMgr.a(this.this$0, System.currentTimeMillis());
    Map localMap = HeartbeatReportMgr.b(this.this$0);
    if (HeartbeatReportMgr.c(this.this$0)) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    localMap.put("zt_int2", localObject);
    HeartbeatReportMgr.b(this.this$0).put("zt_int3", HeartbeatReportMgr.d(this.this$0).a());
    HeartbeatReportMgr.b(this.this$0).put("timelong", String.valueOf(l));
    if ((HeartbeatReportMgr.e(this.this$0) != null) && (HeartbeatReportMgr.e(this.this$0).c() != null))
    {
      HeartbeatReportMgr.b(this.this$0).put("zt_int4", HeartbeatReportMgr.e(this.this$0).c().followStatus);
      HeartbeatReportMgr.b(this.this$0).put("zt_int5", HeartbeatReportMgr.e(this.this$0).c().liveType);
      HeartbeatReportMgr.b(this.this$0).put("state", HeartbeatReportMgr.e(this.this$0).c().state);
      if ("1".equals(HeartbeatReportMgr.e(this.this$0).c().liveType)) {
        HeartbeatReportMgr.b(this.this$0).put("program_id", HeartbeatReportMgr.e(this.this$0).c().programId);
      }
      HeartbeatReportMgr.b(this.this$0).put("anchor", HeartbeatReportMgr.e(this.this$0).c().anchorUid);
    }
    DataReportUtil.b("room_page", "房间", "room", "房间", "heart_beat", "每5s上报一次心跳", HeartbeatReportMgr.b(this.this$0));
    ThreadCenter.postDefaultUITask(this, 5000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.HeartbeatReportMgr.1
 * JD-Core Version:    0.7.0.1
 */