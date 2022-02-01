package tencent.im;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class apollo_game_status$STCMGameMessage$STGameCancel
  extends MessageMicro<STGameCancel>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_game_cancel_info = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_game_cancel_info" }, new Object[] { localByteStringMicro }, STGameCancel.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.apollo_game_status.STCMGameMessage.STGameCancel
 * JD-Core Version:    0.7.0.1
 */