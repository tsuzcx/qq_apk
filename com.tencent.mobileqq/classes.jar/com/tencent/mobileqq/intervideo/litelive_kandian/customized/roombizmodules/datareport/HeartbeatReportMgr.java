package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class HeartbeatReportMgr
{
  private IPlayerState a;
  private Map<String, String> b;
  private boolean c = false;
  private long d = 0L;
  private OnGetRoomExtInfoListener e;
  private Runnable f = new HeartbeatReportMgr.1(this);
  
  public HeartbeatReportMgr(IPlayerState paramIPlayerState)
  {
    this.a = paramIPlayerState;
  }
  
  public void a()
  {
    QLog.i("DataReportMgr", 1, "stopReportHeartBeat");
    this.e = null;
    ThreadCenter.removeDefaultUITask(this.f);
  }
  
  public void a(OnGetRoomExtInfoListener paramOnGetRoomExtInfoListener)
  {
    this.e = paramOnGetRoomExtInfoListener;
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.d = System.currentTimeMillis();
    this.b = paramMap;
    ThreadCenter.removeDefaultUITask(this.f);
    ThreadCenter.postDefaultUITask(this.f, 5000L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b(Map<String, String> paramMap)
  {
    if (this.d == 0L)
    {
      QLog.i("DataReportMgr", 1, "reportFinalHeartbeat lastHeartbeatTS == 0");
      return;
    }
    this.b = paramMap;
    ThreadCenter.removeDefaultUITask(this.f);
    long l = System.currentTimeMillis() - this.d;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportFinalHeartbeat roomId = ");
    ((StringBuilder)localObject).append((String)paramMap.get("roomid"));
    ((StringBuilder)localObject).append(", program_id = ");
    ((StringBuilder)localObject).append((String)paramMap.get("program_id"));
    ((StringBuilder)localObject).append(", realTS = ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(", background = ");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(", play_state = ");
    ((StringBuilder)localObject).append(this.a.a());
    ((StringBuilder)localObject).append(", state = ");
    ((StringBuilder)localObject).append((String)paramMap.get("state"));
    ((StringBuilder)localObject).append(", zt_int4 = ");
    ((StringBuilder)localObject).append((String)paramMap.get("zt_int4"));
    ((StringBuilder)localObject).append(", zt_int5 = ");
    ((StringBuilder)localObject).append((String)paramMap.get("zt_int5"));
    ((StringBuilder)localObject).append(", anchor = ");
    ((StringBuilder)localObject).append((String)paramMap.get("anchor"));
    QLog.i("DataReportMgr", 1, ((StringBuilder)localObject).toString());
    this.d = System.currentTimeMillis();
    if (this.c) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    paramMap.put("zt_int2", localObject);
    paramMap.put("zt_int3", this.a.a());
    paramMap.put("timelong", String.valueOf(l));
    DataReportUtil.b("room_page", "房间", "room", "房间", "final_heart_beat", "最终心跳（不足5秒时的最后一次心跳）", paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.HeartbeatReportMgr
 * JD-Core Version:    0.7.0.1
 */