package tencent.im.s2c.msgtype0x210.submsgtype0x135;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ModulePushPb$Content
  extends MessageMicro<Content>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public ModulePushPb.Forward msg_forward = new ModulePushPb.Forward();
  public ModulePushPb.Image msg_image = new ModulePushPb.Image();
  public final PBStringField str_desc = PBField.initString("");
  public final PBStringField str_title = PBField.initString("");
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uint64_from_uin", "str_title", "str_desc", "msg_image", "msg_forward", "bytes_ext_data" }, new Object[] { Long.valueOf(0L), "", "", null, null, localByteStringMicro }, Content.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb.Content
 * JD-Core Version:    0.7.0.1
 */