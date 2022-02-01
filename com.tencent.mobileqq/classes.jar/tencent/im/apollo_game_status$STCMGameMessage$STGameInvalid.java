package tencent.im;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class apollo_game_status$STCMGameMessage$STGameInvalid
  extends MessageMicro<STGameInvalid>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_game_invlid_info = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_game_invlid_info" }, new Object[] { localByteStringMicro }, STGameInvalid.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.apollo_game_status.STCMGameMessage.STGameInvalid
 * JD-Core Version:    0.7.0.1
 */