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
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.a(this.this$0).get("roomid"));
    ((StringBuilder)localObject).append(", program_id = ");
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.a(this.this$0).get("program_id"));
    ((StringBuilder)localObject).append(", realTS = ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(", background = ");
    ((StringBuilder)localObject).append(HeartbeatReportMgr.a(this.this$0));
    ((StringBuilder)localObject).append(", play_state = ");
    ((StringBuilder)localObject).append(HeartbeatReportMgr.a(this.this$0).a());
    ((StringBuilder)localObject).append(", state = ");
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.a(this.this$0).get("state"));
    ((StringBuilder)localObject).append(", zt_int4 = ");
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.a(this.this$0).get("zt_int4"));
    ((StringBuilder)localObject).append(", zt_int5 = ");
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.a(this.this$0).get("zt_int5"));
    ((StringBuilder)localObject).append(", anchor = ");
    ((StringBuilder)localObject).append((String)HeartbeatReportMgr.a(this.this$0).get("anchor"));
    QLog.i("DataReportMgr", 1, ((StringBuilder)localObject).toString());
    HeartbeatReportMgr.a(this.this$0, System.currentTimeMillis());
    Map localMap = HeartbeatReportMgr.a(this.this$0);
    if (HeartbeatReportMgr.a(this.this$0)) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    localMap.put("zt_int2", localObject);
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.HeartbeatReportMgr.1
 * JD-Core Version:    0.7.0.1
 */