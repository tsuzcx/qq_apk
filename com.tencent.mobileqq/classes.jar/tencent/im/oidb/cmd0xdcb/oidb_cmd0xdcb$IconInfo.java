package tencent.im.oidb.cmd0xdcb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xdcb$IconInfo
  extends MessageMicro<IconInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField feeds_default_icon_url = PBField.initString("");
  public final PBStringField feeds_msg_icon_url = PBField.initString("");
  public final PBStringField str_jump_schema = PBField.initString("");
  public final PBStringField str_nickname = PBField.initString("");
  public final PBStringField str_op_wording = PBField.initString("");
  public final PBUInt32Field uint32_is_use_gif = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 90, 96, 106, 112, 122 }, new String[] { "feeds_msg_icon_url", "feeds_default_icon_url", "uint32_is_use_gif", "str_jump_schema", "bytes_ext", "uint64_puin", "str_nickname", "uint32_op_type", "str_op_wording" }, new Object[] { "", "", Integer.valueOf(0), "", localByteStringMicro, Long.valueOf(0L), "", Integer.valueOf(0), "" }, IconInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.IconInfo
 * JD-Core Version:    0.7.0.1
 */