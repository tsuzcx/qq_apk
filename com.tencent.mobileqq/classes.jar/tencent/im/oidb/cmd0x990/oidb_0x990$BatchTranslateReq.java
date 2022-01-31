package tencent.im.oidb.cmd0x990;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x990$BatchTranslateReq
  extends MessageMicro<BatchTranslateReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> rpt_src_bytes_text_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBStringField str_dst_language = PBField.initString("");
  public final PBStringField str_src_language = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_src_language", "str_dst_language", "rpt_src_bytes_text_list" }, new Object[] { "", "", localByteStringMicro }, BatchTranslateReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x990.oidb_0x990.BatchTranslateReq
 * JD-Core Version:    0.7.0.1
 */