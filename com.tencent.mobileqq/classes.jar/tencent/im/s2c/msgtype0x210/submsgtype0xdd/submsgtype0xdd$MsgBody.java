package tencent.im.s2c.msgtype0x210.submsgtype0xdd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0xdd$MsgBody
  extends MessageMicro<MsgBody>
{
  public static final int MSG_TYPE_ENTER_ROOM = 2;
  public static final int MSG_TYPE_FRESH = 1;
  public static final int MSG_TYPE_KICK = 3;
  public static final int MSG_TYPE_UNREADY = 4;
  public static final int STATE_READY = 1;
  public static final int STATE_UNREADY = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint32_msg_type", "rpt_uint64_invite_uin", "uint64_invite_leader", "msg_poi_info", "rpt_msg_player_state" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, null }, MsgBody.class);
  public submsgtype0xdd.MsgBody.WifiPOIInfo msg_poi_info = new submsgtype0xdd.MsgBody.WifiPOIInfo();
  public final PBRepeatMessageField<submsgtype0xdd.MsgBody.PlayerState> rpt_msg_player_state = PBField.initRepeatMessage(submsgtype0xdd.MsgBody.PlayerState.class);
  public final PBRepeatField<Long> rpt_uint64_invite_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_invite_leader = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody
 * JD-Core Version:    0.7.0.1
 */