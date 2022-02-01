package tencent.im.oidb.cmd0xed2;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xed2$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_reqphonetype = PBField.initEnum(1);
  public final PBStringField str_country = PBField.initString("");
  public final PBStringField str_telephone = PBField.initString("");
  public final PBUInt32Field uint32_key_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "str_country", "str_telephone", "uint32_key_type", "bytes_key", "enum_reqphonetype" }, new Object[] { "", "", Integer.valueOf(0), localByteStringMicro, Integer.valueOf(1) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xed2.oidb_0xed2.ReqBody
 * JD-Core Version:    0.7.0.1
 */