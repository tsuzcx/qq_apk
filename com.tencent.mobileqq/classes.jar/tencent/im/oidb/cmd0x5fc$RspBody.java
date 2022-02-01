package tencent.im.oidb;

import appoint.define.appoint_define.AppointID;
import appoint.define.appoint_define.DateEvent;
import appoint.define.appoint_define.FeedEvent;
import appoint.define.appoint_define.NearbyEvent;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x5fc$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 56 }, new String[] { "rpt_msg_event_list", "rpt_act_appoint_ids", "uint64_max_event_id", "str_error_tips", "rpt_msg_nearby_event_list", "rpt_msg_feed_event_list", "uint64_max_fresh_event_id" }, new Object[] { null, null, Long.valueOf(0L), "", null, null, Long.valueOf(0L) }, RspBody.class);
  public final PBRepeatMessageField<appoint_define.AppointID> rpt_act_appoint_ids = PBField.initRepeatMessage(appoint_define.AppointID.class);
  public final PBRepeatMessageField<appoint_define.DateEvent> rpt_msg_event_list = PBField.initRepeatMessage(appoint_define.DateEvent.class);
  public final PBRepeatMessageField<appoint_define.FeedEvent> rpt_msg_feed_event_list = PBField.initRepeatMessage(appoint_define.FeedEvent.class);
  public final PBRepeatMessageField<appoint_define.NearbyEvent> rpt_msg_nearby_event_list = PBField.initRepeatMessage(appoint_define.NearbyEvent.class);
  public final PBStringField str_error_tips = PBField.initString("");
  public final PBUInt64Field uint64_max_event_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_max_fresh_event_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5fc.RspBody
 * JD-Core Version:    0.7.0.1
 */