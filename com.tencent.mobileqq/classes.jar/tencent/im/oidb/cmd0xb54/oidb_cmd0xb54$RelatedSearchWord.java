package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb54$RelatedSearchWord
  extends MessageMicro<RelatedSearchWord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFloatField float_score = PBField.initFloat(0.0F);
  public final PBStringField str_jmp_url = PBField.initString("");
  public final PBStringField str_modle_name = PBField.initString("");
  public final PBUInt32Field uint32_modle_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 29, 34, 40 }, new String[] { "bytes_word", "str_jmp_url", "float_score", "str_modle_name", "uint32_modle_id" }, new Object[] { localByteStringMicro, "", Float.valueOf(0.0F), "", Integer.valueOf(0) }, RelatedSearchWord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RelatedSearchWord
 * JD-Core Version:    0.7.0.1
 */