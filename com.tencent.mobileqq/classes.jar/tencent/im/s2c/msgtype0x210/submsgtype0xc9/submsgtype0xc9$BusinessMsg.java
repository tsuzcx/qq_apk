package tencent.im.s2c.msgtype0x210.submsgtype0xc9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class submsgtype0xc9$BusinessMsg
  extends MessageMicro<BusinessMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_tab_visible = PBField.initBool(false);
  public final PBBytesField bytes_msg_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField msg_type = PBField.initEnum(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "msg_type", "bytes_msg_data", "bool_tab_visible" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Boolean.valueOf(false) }, BusinessMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc9.submsgtype0xc9.BusinessMsg
 * JD-Core Version:    0.7.0.1
 */