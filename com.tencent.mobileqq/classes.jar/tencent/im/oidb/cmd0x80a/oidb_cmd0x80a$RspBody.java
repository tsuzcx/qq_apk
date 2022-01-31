package tencent.im.oidb.cmd0x80a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x80a$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 90, 96, 104, 112 }, new String[] { "uint64_uin", "pulseTimerDuration", "leftBtmRedPntPulseMaxCnt", "firstScnRedPntPulseMaxCnt", "AIOPulseMaxCnt", "lastRecvMsgDuration", "lastSendMsgDuration", "leftBtmRedCntMaxForExitAIO", "uint64_main_video_tab_red", "rsp_kd_event_report_resp", "uint64_scroll_interval_time", "uint64_scroll_all_time", "uint64_chat_aio_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
  public final PBUInt64Field AIOPulseMaxCnt = PBField.initUInt64(0L);
  public final PBUInt64Field firstScnRedPntPulseMaxCnt = PBField.initUInt64(0L);
  public final PBUInt64Field lastRecvMsgDuration = PBField.initUInt64(0L);
  public final PBUInt64Field lastSendMsgDuration = PBField.initUInt64(0L);
  public final PBUInt64Field leftBtmRedCntMaxForExitAIO = PBField.initUInt64(0L);
  public final PBUInt64Field leftBtmRedPntPulseMaxCnt = PBField.initUInt64(0L);
  public final PBUInt64Field pulseTimerDuration = PBField.initUInt64(0L);
  public oidb_cmd0x80a.KDEventReportResp rsp_kd_event_report_resp = new oidb_cmd0x80a.KDEventReportResp();
  public final PBUInt64Field uint64_chat_aio_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_main_video_tab_red = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_scroll_all_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_scroll_interval_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.RspBody
 * JD-Core Version:    0.7.0.1
 */