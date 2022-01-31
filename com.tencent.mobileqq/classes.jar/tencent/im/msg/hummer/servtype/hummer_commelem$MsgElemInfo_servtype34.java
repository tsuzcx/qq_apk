package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype34
  extends MessageMicro<MsgElemInfo_servtype34>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField from_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  public hummer_commelem.MsgElemInfo_servtype34.GameSession game_session = new hummer_commelem.MsgElemInfo_servtype34.GameSession();
  public final PBUInt32Field push_window_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "from_nickname", "push_window_flag", "game_session", "bytes_ext" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), null, localByteStringMicro2 }, MsgElemInfo_servtype34.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype34
 * JD-Core Version:    0.7.0.1
 */