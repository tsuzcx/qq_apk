package tencent.im.oidb.cmd0x686;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x686$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 56 }, new String[] { "msg_notify_event", "msg_charm_event", "uint32_config_seq", "msg_rank_config", "uint32_gold_flag", "msg_feed_config", "uint32_config_time" }, new Object[] { null, null, Integer.valueOf(0), null, Integer.valueOf(0), null, Integer.valueOf(0) }, RspBody.class);
  public Oidb_0x686.CharmEvent msg_charm_event = new Oidb_0x686.CharmEvent();
  public Oidb_0x686.NearbyFeedConfig msg_feed_config = new Oidb_0x686.NearbyFeedConfig();
  public Oidb_0x686.NearbyCharmNotify msg_notify_event = new Oidb_0x686.NearbyCharmNotify();
  public Oidb_0x686.NearbyRankConfig msg_rank_config = new Oidb_0x686.NearbyRankConfig();
  public final PBUInt32Field uint32_config_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_config_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gold_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x686.Oidb_0x686.RspBody
 * JD-Core Version:    0.7.0.1
 */