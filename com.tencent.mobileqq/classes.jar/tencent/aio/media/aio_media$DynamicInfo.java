package tencent.aio.media;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media$DynamicInfo
  extends MessageMicro<DynamicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_media_type = PBField.initInt32(0);
  public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_user_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 32 }, new String[] { "uint32_user_num", "rpt_uint64_uins", "int32_media_type" }, new Object[] { localInteger, Long.valueOf(0L), localInteger }, DynamicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.aio.media.aio_media.DynamicInfo
 * JD-Core Version:    0.7.0.1
 */