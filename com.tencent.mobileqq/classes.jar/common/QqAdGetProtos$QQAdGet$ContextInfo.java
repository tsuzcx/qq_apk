package common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QqAdGetProtos$QQAdGet$ContextInfo
  extends MessageMicro<ContextInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field article_id = PBField.initUInt64(0L);
  public final PBRepeatField<Long> existed_mini_program_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBBytesField page_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field public_id = PBField.initUInt64(0L);
  public final PBUInt32Field source_from = PBField.initUInt32(0);
  public final PBStringField str_source_from = PBField.initString("");
  public final PBUInt32Field tribe_id_tag = PBField.initUInt32(0);
  public final PBUInt32Field tribe_tag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66 }, new String[] { "public_id", "article_id", "tribe_tag", "tribe_id_tag", "source_from", "page_url", "existed_mini_program_ids", "str_source_from" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), "" }, ContextInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGet.ContextInfo
 * JD-Core Version:    0.7.0.1
 */