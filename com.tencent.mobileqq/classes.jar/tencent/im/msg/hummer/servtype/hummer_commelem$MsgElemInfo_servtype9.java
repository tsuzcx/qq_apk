package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class hummer_commelem$MsgElemInfo_servtype9
  extends MessageMicro<MsgElemInfo_servtype9>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_anchor_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_schema = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_anchor_nickname = PBField.initString("");
  public final PBStringField str_live_title = PBField.initString("");
  public final PBUInt32Field uint32_anchor_status = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_anchor_status", "bytes_jump_schema", "str_anchor_nickname", "bytes_anchor_head_url", "str_live_title" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, "", localByteStringMicro2, "" }, MsgElemInfo_servtype9.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype9
 * JD-Core Version:    0.7.0.1
 */