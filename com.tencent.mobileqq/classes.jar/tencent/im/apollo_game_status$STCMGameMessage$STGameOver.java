package tencent.im;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class apollo_game_status$STCMGameMessage$STGameOver
  extends MessageMicro<STGameOver>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<apollo_game_status.STCMGameMessage.STScoreInfo> rpt_msg_winner_info = PBField.initRepeatMessage(apollo_game_status.STCMGameMessage.STScoreInfo.class);
  public final PBBytesField str_game_over_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_over_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "rpt_msg_winner_info", "uint32_over_type", "str_game_over_info" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro }, STGameOver.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.apollo_game_status.STCMGameMessage.STGameOver
 * JD-Core Version:    0.7.0.1
 */