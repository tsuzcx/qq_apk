package tencent.im.oidb.cmd0xbe4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbe4$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0xbe4.MsgContent msg_content = new oidb_cmd0xbe4.MsgContent();
  public oidb_cmd0xbe4.MsgFolderInfo msg_folder_info = new oidb_cmd0xbe4.MsgFolderInfo();
  public final PBStringField str_msgid = PBField.initString("");
  public final PBUInt32Field uint32_msg_sub_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82, 88 }, new String[] { "uint64_seq", "uint64_msg_time", "uint32_msg_type", "uint64_from_uin", "bytes_pic_url", "bytes_jump_url", "msg_folder_info", "msg_content", "bytes_ext_data", "str_msgid", "uint32_msg_sub_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null, null, localByteStringMicro3, "", Integer.valueOf(0) }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgBody
 * JD-Core Version:    0.7.0.1
 */