package tencent.im.oidb.cmd0x990;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x990$BatchTranslateRsp
  extends MessageMicro<BatchTranslateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_error_code = PBField.initInt32(0);
  public final PBRepeatField<ByteStringMicro> rpt_dst_bytes_text_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<ByteStringMicro> rpt_src_bytes_text_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBStringField str_dst_language = PBField.initString("");
  public final PBStringField str_src_language = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "int32_error_code", "bytes_error_msg", "str_src_language", "str_dst_language", "rpt_src_bytes_text_list", "rpt_dst_bytes_text_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, "", "", localByteStringMicro2, localByteStringMicro3 }, BatchTranslateRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x990.oidb_0x990.BatchTranslateRsp
 * JD-Core Version:    0.7.0.1
 */