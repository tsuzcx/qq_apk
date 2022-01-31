package tencent.im.s2c.msgtype0x210.submsgtype0xda;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xda$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ext_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_from_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_group_unionid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_icon_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sub_type = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_version_ctrl = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_vid_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_comment_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66, 74, 80, 90, 98, 106, 114, 122, 130 }, new String[] { "uint32_msg_type", "bytes_msg_info", "bytes_sub_type", "bytes_version_ctrl", "bytes_feed_id", "bytes_union_id", "uint32_comment_id", "bytes_icon_union_id", "bytes_cover_url", "uint32_oper_type", "bytes_group_unionid", "bytes_vid", "bytes_doodle_url", "bytes_from_nick", "bytes_vid_url", "bytes_ext_info" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13 }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xda.SubMsgType0xda.MsgBody
 * JD-Core Version:    0.7.0.1
 */