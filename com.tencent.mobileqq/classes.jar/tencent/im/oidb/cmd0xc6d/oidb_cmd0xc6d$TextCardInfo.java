package tencent.im.oidb.cmd0xc6d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xc6d$TextCardInfo
  extends MessageMicro<TextCardInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_insert_forwards = PBField.initBool(false);
  public final PBBoolField bool_locate_forwards = PBField.initBool(false);
  public final PBBytesField bytes_card_json = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_indexing_type = PBField.initEnum(0);
  public final PBUInt32Field uint32_location = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "enum_indexing_type", "uint32_location", "bool_locate_forwards", "bool_insert_forwards", "bytes_card_json" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false), localByteStringMicro }, TextCardInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xc6d.oidb_cmd0xc6d.TextCardInfo
 * JD-Core Version:    0.7.0.1
 */