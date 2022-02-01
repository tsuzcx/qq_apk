package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class apollo_game_status$STCMGameMessage$STScoreInfo
  extends MessageMicro<STScoreInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_winner", "str_wording" }, new Object[] { Integer.valueOf(0), "" }, STScoreInfo.class);
  public final PBStringField str_wording = PBField.initString("");
  public final PBUInt32Field uint32_winner = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.apollo_game_status.STCMGameMessage.STScoreInfo
 * JD-Core Version:    0.7.0.1
 */