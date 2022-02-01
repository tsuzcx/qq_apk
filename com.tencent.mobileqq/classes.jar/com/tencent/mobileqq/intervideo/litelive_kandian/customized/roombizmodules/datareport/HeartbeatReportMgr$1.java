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
    QLog.i("DataReportMgr", 1, "reportHeartbeat roomId = " + (String)HeartbeatReportMgr.a(this.this$0).get("roomid") + ", program_id = " + (String)HeartbeatReportMgr.a(this.this$0).get("program_id") + ", realTS = " + l + ", background = " + HeartbeatReportMgr.a(this.this$0) + ", play_state = " + HeartbeatReportMgr.a(this.this$0).a() + ", state = " + (String)HeartbeatReportMgr.a(this.this$0).get("state") + ", zt_int4 = " + (String)HeartbeatReportMgr.a(this.this$0).get("zt_int4") + ", zt_int5 = " + (String)HeartbeatReportMgr.a(this.this$0).get("zt_int5") + ", anchor = " + (String)HeartbeatReportMgr.a(this.this$0).get("anchor"));
    HeartbeatReportMgr.a(this.this$0, System.currentTimeMillis());
    Map localMap = HeartbeatReportMgr.a(this.this$0);
    if (HeartbeatReportMgr.a(this.this$0)) {}
    for (String str = "2";; str = "1")
    {
      localMap.put("zt_int2", str);
      HeartbeatReportMgr.a(this.this$0).put("zt_int3", HeartbeatReportMgr.a(this.this$0).a());
      HeartbeatReportMgr.a(this.this$0).put("timelong", String.valueOf(l));
      if ((HeartbeatReportMgr.a(this.this$0) != null) && (HeartbeatReportMgr.a(this.this$0).a() != null))
      {
        HeartbeatReportMgr.a(this.this$0).put("zt_int4", HeartbeatReportMgr.a(this.this$0).a().followStatus);
        HeartbeatReportMgr.a(this.this$0).put("zt_int5", HeartbeatReportMgr.a(this.this$0).a().liveType);
        HeartbeatReportMgr.a(this.this$0).put("state", HeartbeatReportMgr.a(this.this$0).a().state);
        if ("1".equals(HeartbeatReportMgr.a(this.this$0).a().liveType)) {
          HeartbeatReportMgr.a(this.this$0).put("program_id", HeartbeatReportMgr.a(this.this$0).a().programId);
        }
        HeartbeatReportMgr.a(this.this$0).put("anchor", HeartbeatReportMgr.a(this.this$0).a().anchorUid);
      }
      DataReportUtil.b("room_page", "房间", "room", "房间", "heart_beat", "每5s上报一次心跳", HeartbeatReportMgr.a(this.this$0));
      ThreadCenter.postDefaultUITask(this, 5000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.HeartbeatReportMgr.1
 * JD-Core Version:    0.7.0.1
 */