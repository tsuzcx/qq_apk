package tencent.im.oidb.cmd0x80a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTRule;

public final class oidb_cmd0x80a$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 90, 96, 104, 112, 120, 128, 138, 144, 154, 162 }, new String[] { "uint64_uin", "pulseTimerDuration", "leftBtmRedPntPulseMaxCnt", "firstScnRedPntPulseMaxCnt", "AIOPulseMaxCnt", "lastRecvMsgDuration", "lastSendMsgDuration", "leftBtmRedCntMaxForExitAIO", "uint64_main_video_tab_red", "rsp_kd_event_report_resp", "uint64_scroll_interval_time", "uint64_scroll_all_time", "uint64_chat_aio_time", "report_critical_event", "critical_event_debounce_interval", "critical_event_configuration", "force_top_daily_red_day_offset", "idle_push_wake_param", "msg_srt_rule_list" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), null, Long.valueOf(0L), null, null }, RspBody.class);
  public final PBUInt64Field AIOPulseMaxCnt = PBField.initUInt64(0L);
  public oidb_cmd0x80a.CriticalEventConfiguration critical_event_configuration = new oidb_cmd0x80a.CriticalEventConfiguration();
  public final PBUInt64Field critical_event_debounce_interval = PBField.initUInt64(0L);
  public final PBUInt64Field firstScnRedPntPulseMaxCnt = PBField.initUInt64(0L);
  public final PBInt64Field force_top_daily_red_day_offset = PBField.initInt64(0L);
  public final PBRepeatMessageField<oidb_cmd0x80a.IdlePushWakeParam> idle_push_wake_param = PBField.initRepeatMessage(oidb_cmd0x80a.IdlePushWakeParam.class);
  public final PBUInt64Field lastRecvMsgDuration = PBField.initUInt64(0L);
  public final PBUInt64Field lastSendMsgDuration = PBField.initUInt64(0L);
  public final PBUInt64Field leftBtmRedCntMaxForExitAIO = PBField.initUInt64(0L);
  public final PBUInt64Field leftBtmRedPntPulseMaxCnt = PBField.initUInt64(0L);
  public final PBRepeatMessageField<oidb_cmd0x64e.SRTRule> msg_srt_rule_list = PBField.initRepeatMessage(oidb_cmd0x64e.SRTRule.class);
  public final PBUInt64Field pulseTimerDuration = PBField.initUInt64(0L);
  public final PBBoolField report_critical_event = PBField.initBool(false);
  public oidb_cmd0x80a.KDEventReportResp rsp_kd_event_report_resp = new oidb_cmd0x80a.KDEventReportResp();
  public final PBUInt64Field uint64_chat_aio_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_main_video_tab_red = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_scroll_all_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_scroll_interval_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.RspBody
 * JD-Core Version:    0.7.0.1
 */