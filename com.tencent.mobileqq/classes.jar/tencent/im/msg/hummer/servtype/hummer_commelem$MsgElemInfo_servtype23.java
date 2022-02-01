package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype23
  extends MessageMicro<MsgElemInfo_servtype23>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_face_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_others = PBField.initBytes(ByteStringMicro.EMPTY);
  public hummer_commelem.MsgElemInfo_servtype33 msg_yellow_face = new hummer_commelem.MsgElemInfo_servtype33();
  public final PBUInt32Field uint32_face_bubble_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_face_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50 }, new String[] { "uint32_face_type", "uint32_face_bubble_count", "bytes_face_summary", "uint32_flag", "bytes_others", "msg_yellow_face" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, null }, MsgElemInfo_servtype23.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype23
 * JD-Core Version:    0.7.0.1
 */