package tencent.im.oidb.cmd0x990;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x990$TranslateReq
  extends MessageMicro<TranslateReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_type = PBField.initInt32(0);
  public final PBStringField str_dst_language = PBField.initString("");
  public final PBStringField str_src_language = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "bytes_text", "int32_type", "str_src_language", "str_dst_language" }, new Object[] { localByteStringMicro, Integer.valueOf(0), "", "" }, TranslateReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x990.oidb_0x990.TranslateReq
 * JD-Core Version:    0.7.0.1
 */