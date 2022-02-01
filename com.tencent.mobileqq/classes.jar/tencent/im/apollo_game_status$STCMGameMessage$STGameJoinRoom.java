package tencent.im;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class apollo_game_status$STCMGameMessage$STGameJoinRoom
  extends MessageMicro<STGameJoinRoom>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Integer> rpt_uint32_uin_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBBytesField str_game_join_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_room_vol = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_room_vol", "rpt_uint32_uin_list", "str_game_join_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, STGameJoinRoom.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.apollo_game_status.STCMGameMessage.STGameJoinRoom
 * JD-Core Version:    0.7.0.1
 */