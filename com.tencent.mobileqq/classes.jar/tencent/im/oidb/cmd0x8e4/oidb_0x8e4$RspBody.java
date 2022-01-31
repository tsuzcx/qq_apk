package tencent.im.oidb.cmd0x8e4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public final class oidb_0x8e4$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public Common.WifiPOIInfo poi_info = new Common.WifiPOIInfo();
  public final PBRepeatMessageField<oidb_0x8e4.PlayerState> rpt_msg_player_state = PBField.initRepeatMessage(oidb_0x8e4.PlayerState.class);
  public final PBRepeatField<Long> rpt_uint64_invite_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_kick_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBBytesField string_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_err_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_invite_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_max_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_refresh_interval = PBField.initUInt32(0);
  public final PBUInt32Field uint32_zone_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_leader_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66, 74, 82, 88 }, new String[] { "uint64_leader_uin", "rpt_uint64_invite_uin", "poi_info", "uint32_refresh_interval", "string_invite_id", "rpt_uint64_kick_uin", "uint32_max_member_num", "rpt_msg_player_state", "string_err_title", "string_err_msg", "uint32_zone_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody
 * JD-Core Version:    0.7.0.1
 */