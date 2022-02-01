package com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport;

import com.tencent.falco.utils.ThreadCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class HeartbeatReportMgr
{
  private long jdField_a_of_type_Long = 0L;
  private IPlayerState jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportIPlayerState;
  private OnGetRoomExtInfoListener jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener;
  private Runnable jdField_a_of_type_JavaLangRunnable = new HeartbeatReportMgr.1(this);
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean = false;
  
  public HeartbeatReportMgr(IPlayerState paramIPlayerState)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportIPlayerState = paramIPlayerState;
  }
  
  public void a()
  {
    QLog.i("DataReportMgr", 1, "stopReportHeartBeat");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener = null;
    ThreadCenter.removeDefaultUITask(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(OnGetRoomExtInfoListener paramOnGetRoomExtInfoListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportOnGetRoomExtInfoListener = paramOnGetRoomExtInfoListener;
  }
  
  public void a(Map<String, String> paramMap)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    ThreadCenter.removeDefaultUITask(this.jdField_a_of_type_JavaLangRunnable);
    ThreadCenter.postDefaultUITask(this.jdField_a_of_type_JavaLangRunnable, 5000L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(Map<String, String> paramMap)
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      QLog.i("DataReportMgr", 1, "reportFinalHeartbeat lastHeartbeatTS == 0");
      return;
    }
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    ThreadCenter.removeDefaultUITask(this.jdField_a_of_type_JavaLangRunnable);
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportFinalHeartbeat roomId = ");
    ((StringBuilder)localObject).append((String)paramMap.get("roomid"));
    ((StringBuilder)localObject).append(", program_id = ");
    ((StringBuilder)localObject).append((String)paramMap.get("program_id"));
    ((StringBuilder)localObject).append(", realTS = ");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(", background = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject).append(", play_state = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportIPlayerState.a());
    ((StringBuilder)localObject).append(", state = ");
    ((StringBuilder)localObject).append((String)paramMap.get("state"));
    ((StringBuilder)localObject).append(", zt_int4 = ");
    ((StringBuilder)localObject).append((String)paramMap.get("zt_int4"));
    ((StringBuilder)localObject).append(", zt_int5 = ");
    ((StringBuilder)localObject).append((String)paramMap.get("zt_int5"));
    ((StringBuilder)localObject).append(", anchor = ");
    ((StringBuilder)localObject).append((String)paramMap.get("anchor"));
    QLog.i("DataReportMgr", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Boolean) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    paramMap.put("zt_int2", localObject);
    paramMap.put("zt_int3", this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedRoombizmodulesDatareportIPlayerState.a());
    paramMap.put("timelong", String.valueOf(l));
    DataReportUtil.b("room_page", "房间", "room", "房间", "final_heart_beat", "最终心跳（不足5秒时的最后一次心跳）", paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.roombizmodules.datareport.HeartbeatReportMgr
 * JD-Core Version:    0.7.0.1
 */