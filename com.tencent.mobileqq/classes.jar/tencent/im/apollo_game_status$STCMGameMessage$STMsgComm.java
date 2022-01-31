package tencent.im;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class apollo_game_status$STCMGameMessage$STMsgComm
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField rpt_uint32_session_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField rpt_uint32_uin_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBBytesField str_game_comm_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_room_id = PBField.initString("");
  public final PBUInt32Field uint32_game_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_play_model = PBField.initUInt32(0);
  public final PBUInt32Field uint32_room_vol = PBField.initUInt32(0);
  public final PBUInt32Field uint32_session_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_time_stamp = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 64, 72 }, new String[] { "uint32_game_id", "str_room_id", "uint64_time_stamp", "uint32_session_id", "rpt_uint32_session_list", "uint32_play_model", "str_game_comm_info", "rpt_uint32_uin_list", "uint32_room_vol" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, STMsgComm.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.apollo_game_status.STCMGameMessage.STMsgComm
 * JD-Core Version:    0.7.0.1
 */