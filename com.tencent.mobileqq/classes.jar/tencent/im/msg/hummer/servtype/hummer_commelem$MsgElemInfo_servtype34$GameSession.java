package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hummer_commelem$MsgElemInfo_servtype34$GameSession
  extends MessageMicro<GameSession>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField from_open_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField from_role_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field from_tiny_id = PBField.initUInt64(0L);
  public final PBUInt64Field game_appid = PBField.initUInt64(0L);
  public final PBBytesField to_open_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField to_role_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field to_tiny_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56 }, new String[] { "from_role_id", "from_open_id", "to_role_id", "to_open_id", "game_appid", "from_tiny_id", "to_tiny_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localLong, localLong, localLong }, GameSession.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype34.GameSession
 * JD-Core Version:    0.7.0.1
 */