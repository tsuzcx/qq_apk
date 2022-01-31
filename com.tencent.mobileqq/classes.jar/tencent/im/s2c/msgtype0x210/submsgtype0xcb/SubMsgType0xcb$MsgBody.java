package tencent.im.s2c.msgtype0x210.submsgtype0xcb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xcb$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_anchor_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_anchor_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_c2c_msg_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_schema = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_live_end_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_live_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_anchor_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_wording_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_live_wording_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 72 }, new String[] { "uint32_anchor_status", "bytes_jump_schema", "bytes_anchor_nickname", "bytes_anchor_head_url", "bytes_live_wording", "bytes_live_end_wording", "bytes_c2c_msg_wording", "uint32_live_wording_type", "uint32_end_wording_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0) }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody
 * JD-Core Version:    0.7.0.1
 */